package org.eclipse.jetty.websocket.common.extensions.compress;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/extensions/compress/XWebkitDeflateFrameExtension.class */
public class XWebkitDeflateFrameExtension extends DeflateFrameExtension {
    @Override // org.eclipse.jetty.websocket.common.extensions.compress.DeflateFrameExtension, org.eclipse.jetty.websocket.common.extensions.AbstractExtension, org.eclipse.jetty.websocket.api.extensions.Extension
    public String getName() {
        return "x-webkit-deflate-frame";
    }
}
