package emu.grasscutter.server.http.log;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: grasscutter.jar:emu/grasscutter/server/http/log/VersionInfo.class */
public class VersionInfo implements Serializable {
    @SerializedName(value = "client_version", alternate = {"clientVersion"})
    private String clientVersion;
    @SerializedName(value = "sdk_env", alternate = {"sdkEnv"})
    private Integer sdkEnv;
    @SerializedName(value = "sdk_version", alternate = {"sdkVersion"})
    private String sdkVersion;
    @SerializedName(value = "log_version", alternate = {"logVersion"})
    private String logVersion;

    public String getClientVersion() {
        return this.clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public Integer getSdkEnv() {
        return this.sdkEnv;
    }

    public void setSdkEnv(Integer sdkEnv) {
        this.sdkEnv = sdkEnv;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public String getLogVersion() {
        return this.logVersion;
    }

    public void setLogVersion(String logVersion) {
        this.logVersion = logVersion;
    }
}
