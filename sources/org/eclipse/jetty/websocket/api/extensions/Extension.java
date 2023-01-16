package org.eclipse.jetty.websocket.api.extensions;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/extensions/Extension.class */
public interface Extension extends IncomingFrames, OutgoingFrames {
    ExtensionConfig getConfig();

    String getName();

    boolean isRsv1User();

    boolean isRsv2User();

    boolean isRsv3User();

    void setNextIncomingFrames(IncomingFrames incomingFrames);

    void setNextOutgoingFrames(OutgoingFrames outgoingFrames);
}
