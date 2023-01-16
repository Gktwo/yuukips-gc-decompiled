package emu.grasscutter.server.event.dispatch;

import emu.grasscutter.server.event.types.ServerEvent;

/* loaded from: grasscutter.jar:emu/grasscutter/server/event/dispatch/QueryAllRegionsEvent.class */
public final class QueryAllRegionsEvent extends ServerEvent {
    private String regionList;

    public QueryAllRegionsEvent(String regionList) {
        super(ServerEvent.Type.DISPATCH);
        this.regionList = regionList;
    }

    public void setRegionList(String regionList) {
        this.regionList = regionList;
    }

    public String getRegionList() {
        return this.regionList;
    }
}
