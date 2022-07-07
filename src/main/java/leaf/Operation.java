package leaf;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "fileName",
    "provider",
    "organizationId",
    "fileType",
    "fileFormat",
    "sizeInBytes",
    "originalFile",
    "rawGeojson",
    "standardGeojson",
    "zippedPNGs",
    "leafUserId",
    "apiOwnerUsername",
    "summary",
    "sourceFiles",
    "status",
    "origin",
    "createdTime",
    "operationStartTime",
    "operationEndTime"
})
public class Operation {

    @JsonProperty("id")
    private String id;
    @JsonProperty("fileName")
    private String fileName;
    @JsonProperty("provider")
    private String provider;
    @JsonProperty("organizationId")
    private String organizationId;
    @JsonProperty("fileType")
    private String fileType;
    @JsonProperty("fileFormat")
    private String fileFormat;
    @JsonProperty("sizeInBytes")
    private Integer sizeInBytes;
    @JsonProperty("originalFile")
    private String originalFile;
    @JsonProperty("rawGeojson")
    private String rawGeojson;
    @JsonProperty("standardGeojson")
    private String standardGeojson;
    @JsonProperty("zippedPNGs")
    private String zippedPNGs;
    @JsonProperty("leafUserId")
    private String leafUserId;
    @JsonProperty("apiOwnerUsername")
    private String apiOwnerUsername;
    @JsonProperty("summary")
    private Summary summary;
    @JsonProperty("sourceFiles")
    private List<Object> sourceFiles = null;
    @JsonProperty("status")
    private String status;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("createdTime")
    private String createdTime;
    @JsonProperty("operationStartTime")
    private String operationStartTime;
    @JsonProperty("operationEndTime")
    private String operationEndTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("fileName")
    public String getFileName() {
        return fileName;
    }

    @JsonProperty("fileName")
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @JsonProperty("provider")
    public String getProvider() {
        return provider;
    }

    @JsonProperty("provider")
    public void setProvider(String provider) {
        this.provider = provider;
    }

    @JsonProperty("organizationId")
    public String getOrganizationId() {
        return organizationId;
    }

    @JsonProperty("organizationId")
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    @JsonProperty("fileType")
    public String getFileType() {
        return fileType;
    }

    @JsonProperty("fileType")
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @JsonProperty("fileFormat")
    public String getFileFormat() {
        return fileFormat;
    }

    @JsonProperty("fileFormat")
    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    @JsonProperty("sizeInBytes")
    public Integer getSizeInBytes() {
        return sizeInBytes;
    }

    @JsonProperty("sizeInBytes")
    public void setSizeInBytes(Integer sizeInBytes) {
        this.sizeInBytes = sizeInBytes;
    }

    @JsonProperty("originalFile")
    public String getOriginalFile() {
        return originalFile;
    }

    @JsonProperty("originalFile")
    public void setOriginalFile(String originalFile) {
        this.originalFile = originalFile;
    }

    @JsonProperty("rawGeojson")
    public String getRawGeojson() {
        return rawGeojson;
    }

    @JsonProperty("rawGeojson")
    public void setRawGeojson(String rawGeojson) {
        this.rawGeojson = rawGeojson;
    }

    @JsonProperty("standardGeojson")
    public String getStandardGeojson() {
        return standardGeojson;
    }

    @JsonProperty("standardGeojson")
    public void setStandardGeojson(String standardGeojson) {
        this.standardGeojson = standardGeojson;
    }

    @JsonProperty("zippedPNGs")
    public String getZippedPNGs() {
        return zippedPNGs;
    }

    @JsonProperty("zippedPNGs")
    public void setZippedPNGs(String zippedPNGs) {
        this.zippedPNGs = zippedPNGs;
    }

    @JsonProperty("leafUserId")
    public String getLeafUserId() {
        return leafUserId;
    }

    @JsonProperty("leafUserId")
    public void setLeafUserId(String leafUserId) {
        this.leafUserId = leafUserId;
    }

    @JsonProperty("apiOwnerUsername")
    public String getApiOwnerUsername() {
        return apiOwnerUsername;
    }

    @JsonProperty("apiOwnerUsername")
    public void setApiOwnerUsername(String apiOwnerUsername) {
        this.apiOwnerUsername = apiOwnerUsername;
    }

    @JsonProperty("summary")
    public Summary getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    @JsonProperty("sourceFiles")
    public List<Object> getSourceFiles() {
        return sourceFiles;
    }

    @JsonProperty("sourceFiles")
    public void setSourceFiles(List<Object> sourceFiles) {
        this.sourceFiles = sourceFiles;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("origin")
    public String getOrigin() {
        return origin;
    }

    @JsonProperty("origin")
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @JsonProperty("createdTime")
    public String getCreatedTime() {
        return createdTime;
    }

    @JsonProperty("createdTime")
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    @JsonProperty("operationStartTime")
    public String getOperationStartTime() {
        return operationStartTime;
    }

    @JsonProperty("operationStartTime")
    public void setOperationStartTime(String operationStartTime) {
        this.operationStartTime = operationStartTime;
    }

    @JsonProperty("operationEndTime")
    public String getOperationEndTime() {
        return operationEndTime;
    }

    @JsonProperty("operationEndTime")
    public void setOperationEndTime(String operationEndTime) {
        this.operationEndTime = operationEndTime;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}