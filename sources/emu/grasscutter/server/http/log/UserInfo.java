package emu.grasscutter.server.http.log;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: grasscutter.jar:emu/grasscutter/server/http/log/UserInfo.class */
public class UserInfo implements Serializable {
    @SerializedName(value = "uid", alternate = {"Uid"})
    private String uid;
    @SerializedName(value = "level", alternate = {"Level"})
    private String level;
    @SerializedName(value = "account_type", alternate = {"accountType"})
    private String accountType;
    @SerializedName(value = "open_id", alternate = {"openId"})
    private String openId;
    @SerializedName(value = "tag", alternate = {"Tag"})
    private String tag;

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getOpenId() {
        return this.openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
