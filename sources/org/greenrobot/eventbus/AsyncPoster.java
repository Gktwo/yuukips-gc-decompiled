package org.greenrobot.eventbus;

/* loaded from: grasscutter.jar:org/greenrobot/eventbus/AsyncPoster.class */
class AsyncPoster implements Runnable, Poster {
    private final PendingPostQueue queue = new PendingPostQueue();
    private final EventBus eventBus;

    /* access modifiers changed from: package-private */
    public AsyncPoster(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override // org.greenrobot.eventbus.Poster
    public void enqueue(Subscription subscription, Object event) {
        this.queue.enqueue(PendingPost.obtainPendingPost(subscription, event));
        this.eventBus.getExecutorService().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        PendingPost pendingPost = this.queue.poll();
        if (pendingPost == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.eventBus.invokeSubscriber(pendingPost);
    }
}
