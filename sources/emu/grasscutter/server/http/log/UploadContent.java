package emu.grasscutter.server.http.log;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: grasscutter.jar:emu/grasscutter/server/http/log/UploadContent.class */
public class UploadContent implements Serializable {
    @SerializedName(value = "device_info", alternate = {"deviceInfo", "deviceinfo"})
    private DeviceInfo deviceInfo;
    @SerializedName(value = "user_info", alternate = {"userInfo", "userinfo"})
    private UserInfo userInfo;
    @SerializedName(value = "version_info", alternate = {"versionInfo", "versioninfo"})
    private VersionInfo versionInfo;
    @SerializedName(value = "log_info", alternate = {"logInfo", "loginfo"})
    private LogInfo logInfo;

    public DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public VersionInfo getVersionInfo() {
        return this.versionInfo;
    }

    public void setVersionInfo(VersionInfo versionInfo) {
        this.versionInfo = versionInfo;
    }

    public LogInfo getLogInfo() {
        return this.logInfo;
    }

    public void setLogInfo(LogInfo logInfo) {
        this.logInfo = logInfo;
    }
}
