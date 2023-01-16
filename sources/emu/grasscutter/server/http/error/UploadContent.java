package emu.grasscutter.server.http.error;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.quartz.jobs.p027ee.mail.SendMailJob;

/* loaded from: grasscutter.jar:emu/grasscutter/server/http/error/UploadContent.class */
public class UploadContent implements Serializable {
    @SerializedName("error_code")
    private Integer error_Code;
    @SerializedName("errorCode")
    private String errorCode;
    @SerializedName(SendMailJob.PROP_MESSAGE)
    private String message;
    @SerializedName("user_id")
    private Integer userId;
    @SerializedName("auid")
    private String auid;
    @SerializedName("time")
    private Integer time;
    @SerializedName("stackTrace")
    private String stackTrace;
    @SerializedName("exceptionSerialNum")
    private Integer exceptionSerialNum;
    @SerializedName("frame")
    private String frame;
    @SerializedName("deviceModel")
    private String deviceModel;
    @SerializedName("deviceName")
    private String deviceName;
    @SerializedName("operatingSystem")
    private String operatingSystem;
    @SerializedName("userName")
    private String userName;
    @SerializedName("version")
    private String version;
    @SerializedName("guid")
    private String guid;
    @SerializedName("isRelease")
    private Boolean isRelease;
    @SerializedName("serverName")
    private String serverName;
    @SerializedName("projectNick")
    private String projectNick;
    @SerializedName("userNick")
    private String userNick;
    @SerializedName("logType")
    private String logType;
    @SerializedName("subErrorCode")
    private String subErrorCode;
    @SerializedName("cpuInfo")
    private String cpuInfo;
    @SerializedName("gpuInfo")
    private String gpuInfo;
    @SerializedName("memoryInfo")
    private String memoryInfo;
    @SerializedName("clientIp")
    private String clientIp;
    @SerializedName("errorLevel")
    private String errorLevel;
    @SerializedName("errorCategory")
    private String errorCategory;
    @SerializedName("notifyUser")
    private String notifyUser;

    public Integer getError_Code() {
        return this.error_Code;
    }

    public void setError_Code(Integer error_Code) {
        this.error_Code = error_Code;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAuid() {
        return this.auid;
    }

    public void setAuid(String auid) {
        this.auid = auid;
    }

    public Integer getTime() {
        return this.time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getStackTrace() {
        return this.stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public Integer getExceptionSerialNum() {
        return this.exceptionSerialNum;
    }

    public void setExceptionSerialNum(Integer exceptionSerialNum) {
        this.exceptionSerialNum = exceptionSerialNum;
    }

    public String getFrame() {
        return this.frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getOperatingSystem() {
        return this.operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGuid() {
        return this.guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Boolean getIsRelease() {
        return this.isRelease;
    }

    public void setIsRelease(Boolean isRelease) {
        this.isRelease = isRelease;
    }

    public String getServerName() {
        return this.serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getProjectNick() {
        return this.projectNick;
    }

    public void setProjectNick(String projectNick) {
        this.projectNick = projectNick;
    }

    public String getUserNick() {
        return this.userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getLogType() {
        return this.logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getSubErrorCode() {
        return this.subErrorCode;
    }

    public void setSubErrorCode(String subErrorCode) {
        this.subErrorCode = subErrorCode;
    }

    public String getCpuInfo() {
        return this.cpuInfo;
    }

    public void setCpuInfo(String cpuInfo) {
        this.cpuInfo = cpuInfo;
    }

    public String getGpuInfo() {
        return this.gpuInfo;
    }

    public void setGpuInfo(String gpuInfo) {
        this.gpuInfo = gpuInfo;
    }

    public String getMemoryInfo() {
        return this.memoryInfo;
    }

    public void setMemoryInfo(String memoryInfo) {
        this.memoryInfo = memoryInfo;
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getErrorLevel() {
        return this.errorLevel;
    }

    public void setErrorLevel(String errorLevel) {
        this.errorLevel = errorLevel;
    }

    public String getErrorCategory() {
        return this.errorCategory;
    }

    public void setErrorCategory(String errorCategory) {
        this.errorCategory = errorCategory;
    }

    public String getNotifyUser() {
        return this.notifyUser;
    }

    public void setNotifyUser(String notifyUser) {
        this.notifyUser = notifyUser;
    }
}
