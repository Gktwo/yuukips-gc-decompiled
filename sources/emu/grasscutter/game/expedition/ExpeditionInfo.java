package emu.grasscutter.game.expedition;

import dev.morphia.annotations.Entity;
import emu.grasscutter.net.proto.AvatarExpeditionInfoOuterClass;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/game/expedition/ExpeditionInfo.class */
public class ExpeditionInfo {
    private int state;
    private int expId;
    private int hourTime;
    private int startTime;

    public void setState(int state) {
        this.state = state;
    }

    public void setExpId(int expId) {
        this.expId = expId;
    }

    public void setHourTime(int hourTime) {
        this.hourTime = hourTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getState() {
        return this.state;
    }

    public int getExpId() {
        return this.expId;
    }

    public int getHourTime() {
        return this.hourTime;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo toProto() {
        return AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo.newBuilder().setStateValue(getState()).setExpId(getExpId()).setHourTime(getHourTime()).setStartTime(getStartTime()).build();
    }
}
