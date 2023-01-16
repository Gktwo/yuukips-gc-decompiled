package org.eclipse.jetty.websocket.common.events.annotated;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/events/annotated/EventMethods.class */
public class EventMethods {
    private Class<?> pojoClass;
    public EventMethod onConnect = null;
    public EventMethod onClose = null;
    public EventMethod onBinary = null;
    public EventMethod onText = null;
    public EventMethod onError = null;
    public EventMethod onFrame = null;

    public EventMethods(Class<?> pojoClass) {
        this.pojoClass = pojoClass;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EventMethods other = (EventMethods) obj;
        if (this.pojoClass == null) {
            return other.pojoClass == null;
        }
        return this.pojoClass.getName().equals(other.pojoClass.getName());
    }

    public Class<?> getPojoClass() {
        return this.pojoClass;
    }

    public int hashCode() {
        return (31 * 1) + (this.pojoClass == null ? 0 : this.pojoClass.getName().hashCode());
    }

    public String toString() {
        return "EventMethods [pojoClass=" + this.pojoClass + ", onConnect=" + this.onConnect + ", onClose=" + this.onClose + ", onBinary=" + this.onBinary + ", onText=" + this.onText + ", onException=" + this.onError + ", onFrame=" + this.onFrame + "]";
    }
}
