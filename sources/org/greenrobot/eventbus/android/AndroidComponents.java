package org.greenrobot.eventbus.android;

import org.greenrobot.eventbus.Logger;
import org.greenrobot.eventbus.MainThreadSupport;

/* loaded from: grasscutter.jar:org/greenrobot/eventbus/android/AndroidComponents.class */
public abstract class AndroidComponents {
    private static final AndroidComponents implementation;
    public final Logger logger;
    public final MainThreadSupport defaultMainThreadSupport;

    static {
        AndroidComponents androidComponents;
        if (AndroidDependenciesDetector.isAndroidSDKAvailable()) {
            androidComponents = AndroidDependenciesDetector.instantiateAndroidComponents();
        } else {
            androidComponents = null;
        }
        implementation = androidComponents;
    }

    public static boolean areAvailable() {
        return implementation != null;
    }

    public static AndroidComponents get() {
        return implementation;
    }

    public AndroidComponents(Logger logger, MainThreadSupport defaultMainThreadSupport) {
        this.logger = logger;
        this.defaultMainThreadSupport = defaultMainThreadSupport;
    }
}
