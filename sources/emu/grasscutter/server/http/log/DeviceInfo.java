package emu.grasscutter.server.http.log;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: grasscutter.jar:emu/grasscutter/server/http/log/DeviceInfo.class */
public class DeviceInfo implements Serializable {
    @SerializedName(value = "ip", alternate = {"Ip"})

    /* renamed from: ip */
    private String f960ip;
    @SerializedName(value = "plat", alternate = {"Plat"})
    private Integer plat;
    @SerializedName(value = "device_id", alternate = {"deviceId"})
    private String deviceId;
    @SerializedName(value = "device_name", alternate = {"deviceName"})
    private String deviceName;
    @SerializedName(value = "device_model", alternate = {"deviceModel"})
    private String deviceModel;
    @SerializedName(value = "register_cps", alternate = {"registerCps"})
    private String registerCps;
    @SerializedName(value = "current_cps", alternate = {"currentCps"})
    private String currentCps;
    @SerializedName(value = "bundle_id", alternate = {"bundleId"})
    private String bundleId;
    @SerializedName(value = "os", alternate = {"Os"})

    /* renamed from: os */
    private String f961os;
    @SerializedName(value = "channel_id", alternate = {"channelId"})
    private String channelId;
    @SerializedName(value = "channel_subid", alternate = {"channelSubid"})
    private String channelSubid;

    public String getIp() {
        return this.f960ip;
    }

    public void setIp(String ip) {
        this.f960ip = ip;
    }

    public Integer getPlat() {
        return this.plat;
    }

    public void setPlat(Integer plat) {
        this.plat = plat;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getRegisterCps() {
        return this.registerCps;
    }

    public void setRegisterCps(String registerCps) {
        this.registerCps = registerCps;
    }

    public String getCurrentCps() {
        return this.currentCps;
    }

    public void setCurrentCps(String currentCps) {
        this.currentCps = currentCps;
    }

    public String getBundleId() {
        return this.bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public String getOs() {
        return this.f961os;
    }

    public void setOs(String os) {
        this.f961os = os;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelSubid() {
        return this.channelSubid;
    }

    public void setChannelSubid(String channelSubid) {
        this.channelSubid = channelSubid;
    }
}
