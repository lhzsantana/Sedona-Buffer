import com.google.gson.Gson;
import leaf.Authentication;
import leaf.Operation;
import leaf.Operations;
import leaf.Token;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Leaf {
    String username = "";
    String password = "";

    public Leaf(String username, String password){
        this.username=username;
        this.password=password;
    }

    HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    String api = "https://api.withleaf.io";

    public List<Operation> getStandardGeoJSON(String token) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder(URI.create(api+"/services/operations/api/files?page=0&size=3&status=processed"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer "+token)
                .GET().build();

        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

        return (new Gson()).fromJson(response.body(), Operations.class).getOperations();
    }

    public String authenticate() throws IOException, InterruptedException {

        Authentication authentication = new Authentication();
        authentication.setUsername(username);
        authentication.setPassword(password);

        HttpRequest request = HttpRequest.newBuilder(URI.create(api+"/api/authenticate"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString((new Gson()).toJson(authentication))).build();

        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

        return (new Gson()).fromJson(response.body(), Token.class).getId_token();
    }
}
