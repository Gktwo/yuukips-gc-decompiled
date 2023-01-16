package emu.grasscutter.server.http.log;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: grasscutter.jar:emu/grasscutter/server/http/log/LogWeb.class */
public class LogWeb implements Serializable {
    @SerializedName("applicationId")
    private Integer applicationId;
    @SerializedName("applicationName")
    private String applicationName;
    @SerializedName("msgId")
    private String msgId;
    @SerializedName("eventTime")
    private String eventTime;
    @SerializedName("eventId")
    private Integer eventId;
    @SerializedName("eventName")
    private String eventName;
    @SerializedName("uploadContent")
    private UploadContent uploadContent;

    public Integer getApplicationId() {
        return this.applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationName() {
        return this.applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getEventTime() {
        return this.eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public Integer getEventId() {
        return this.eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return this.eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public UploadContent getUploadContent() {
        return this.uploadContent;
    }

    public void setUploadContent(UploadContent uploadContent) {
        this.uploadContent = uploadContent;
    }
}
