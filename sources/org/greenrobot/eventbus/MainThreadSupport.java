package org.greenrobot.eventbus;

/* loaded from: grasscutter.jar:org/greenrobot/eventbus/MainThreadSupport.class */
public interface MainThreadSupport {
    boolean isMainThread();

    Poster createPoster(EventBus eventBus);
}
