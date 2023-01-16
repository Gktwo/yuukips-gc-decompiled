package net.bytebuddy.dynamic;

import net.bytebuddy.description.method.MethodDescription;

/* loaded from: grasscutter.jar:net/bytebuddy/dynamic/VisibilityBridgeStrategy.class */
public interface VisibilityBridgeStrategy {

    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/VisibilityBridgeStrategy$Default.class */
    public enum Default implements VisibilityBridgeStrategy {
        ALWAYS {
            @Override // net.bytebuddy.dynamic.VisibilityBridgeStrategy
            public boolean generateVisibilityBridge(MethodDescription methodDescription) {
                return true;
            }
        },
        ON_NON_GENERIC_METHOD {
            @Override // net.bytebuddy.dynamic.VisibilityBridgeStrategy
            public boolean generateVisibilityBridge(MethodDescription methodDescription) {
                return !methodDescription.isGenerified();
            }
        },
        NEVER {
            @Override // net.bytebuddy.dynamic.VisibilityBridgeStrategy
            public boolean generateVisibilityBridge(MethodDescription methodDescription) {
                return false;
            }
        }
    }

    boolean generateVisibilityBridge(MethodDescription methodDescription);
}
