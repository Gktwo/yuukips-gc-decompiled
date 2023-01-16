package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/greenrobot/eventbus/PendingPost.class */
public final class PendingPost {
    private static final List<PendingPost> pendingPostPool = new ArrayList();
    Object event;
    Subscription subscription;
    PendingPost next;

    private PendingPost(Object event, Subscription subscription) {
        this.event = event;
        this.subscription = subscription;
    }

    /* access modifiers changed from: package-private */
    public static PendingPost obtainPendingPost(Subscription subscription, Object event) {
        synchronized (pendingPostPool) {
            int size = pendingPostPool.size();
            if (size <= 0) {
                return new PendingPost(event, subscription);
            }
            PendingPost pendingPost = pendingPostPool.remove(size - 1);
            pendingPost.event = event;
            pendingPost.subscription = subscription;
            pendingPost.next = null;
            return pendingPost;
        }
    }

    /* access modifiers changed from: package-private */
    public static void releasePendingPost(PendingPost pendingPost) {
        pendingPost.event = null;
        pendingPost.subscription = null;
        pendingPost.next = null;
        synchronized (pendingPostPool) {
            if (pendingPostPool.size() < 10000) {
                pendingPostPool.add(pendingPost);
            }
        }
    }
}
