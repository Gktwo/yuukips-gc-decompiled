package com.mongodb.event;

import java.util.EventListener;

/* loaded from: grasscutter.jar:com/mongodb/event/ClusterListener.class */
public interface ClusterListener extends EventListener {
    default void clusterOpening(ClusterOpeningEvent event) {
    }

    default void clusterClosed(ClusterClosedEvent event) {
    }

    default void clusterDescriptionChanged(ClusterDescriptionChangedEvent event) {
    }
}
