package org.eclipse.jetty.websocket.common.events;

import java.util.ArrayList;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/events/ParamList.class */
public class ParamList extends ArrayList<Class<?>[]> {
    public void addParams(Class<?>... paramTypes) {
        add(paramTypes);
    }
}
