package emu.grasscutter.server.http.error;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: grasscutter.jar:emu/grasscutter/server/http/error/LogError.class */
public class LogError implements Serializable {
    @SerializedName(value = "applicationId", alternate = {"application_id"})
    private Integer applicationId;
    @SerializedName(value = "applicationName", alternate = {"application_name"})
    private String applicationName;
    @SerializedName(value = "msgID", alternate = {"msg_id"})
    private String msgID;
    @SerializedName(value = "eventTime", alternate = {"event_time"})
    private String eventTime;
    @SerializedName(value = "eventId", alternate = {"event_id"})
    private Integer eventId;
    @SerializedName(value = "eventName", alternate = {"event_name"})
    private String eventName;
    @SerializedName(value = "uploadContent", alternate = {"upload_content"})
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

    public String getMsgID() {
        return this.msgID;
    }

    public void setMsgID(String msgID) {
        this.msgID = msgID;
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
