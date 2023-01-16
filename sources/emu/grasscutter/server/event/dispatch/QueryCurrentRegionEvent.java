package emu.grasscutter.server.event.dispatch;

import emu.grasscutter.server.event.types.ServerEvent;

/* loaded from: grasscutter.jar:emu/grasscutter/server/event/dispatch/QueryCurrentRegionEvent.class */
public final class QueryCurrentRegionEvent extends ServerEvent {
    private String regionInfo;

    public QueryCurrentRegionEvent(String regionInfo) {
        super(ServerEvent.Type.DISPATCH);
        this.regionInfo = regionInfo;
    }

    public void setRegionInfo(String regionInfo) {
        this.regionInfo = regionInfo;
    }

    public String getRegionInfo() {
        return this.regionInfo;
    }
}
