package emu.grasscutter.server.http.log;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: grasscutter.jar:emu/grasscutter/server/http/log/LogInfo.class */
public class LogInfo implements Serializable {
    @SerializedName(value = "log_time", alternate = {"logTime"})
    private String logTime;
    @SerializedName(value = "region", alternate = {"Region"})
    private String region;
    @SerializedName(value = "action_id", alternate = {"actionId"})
    private Integer actionId;
    @SerializedName(value = "action_name", alternate = {"actionName"})
    private String actionName;
    @SerializedName(value = "c_body", alternate = {"cBody"})
    private String cBody;

    public String getLogTime() {
        return this.logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getActionId() {
        return this.actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public String getActionName() {
        return this.actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getCBody() {
        return this.cBody;
    }

    public void setCBody(String cBody) {
        this.cBody = cBody;
    }
}
