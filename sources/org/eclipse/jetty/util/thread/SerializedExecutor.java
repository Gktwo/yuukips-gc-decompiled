package org.eclipse.jetty.util.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import org.eclipse.jetty.util.log.Log;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/SerializedExecutor.class */
public class SerializedExecutor implements Executor {
    private final AtomicReference<Link> _tail = new AtomicReference<>();

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/SerializedExecutor$ErrorHandlingTask.class */
    public interface ErrorHandlingTask extends Runnable, Consumer<Throwable> {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable task) {
        Link link = new Link(task);
        Link lastButOne = this._tail.getAndSet(link);
        if (lastButOne == null) {
            run(link);
        } else {
            lastButOne._next.lazySet(link);
        }
    }

    protected void onError(Runnable task, Throwable t) {
        if (task instanceof ErrorHandlingTask) {
            ((ErrorHandlingTask) task).accept(t);
        }
        Log.getLogger(task.getClass()).warn(t);
    }

    private void run(Link link) {
        Link next;
        while (link != null) {
            try {
                link._task.run();
                if (this._tail.compareAndSet(link, null)) {
                    link = null;
                } else {
                    Object obj = link._next.get();
                    while (true) {
                        next = (Link) obj;
                        if (next != null) {
                            break;
                        }
                        Thread.yield();
                        obj = link._next.get();
                    }
                    link = next;
                }
            } catch (Throwable th) {
                if (!this._tail.compareAndSet(link, null)) {
                    for (Object obj2 = link._next.get(); ((Link) obj2) == null; obj2 = link._next.get()) {
                        Thread.yield();
                    }
                }
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/SerializedExecutor$Link.class */
    public class Link {
        private final Runnable _task;
        private final AtomicReference<Link> _next = new AtomicReference<>();

        public Link(Runnable task) {
            this._task = task;
        }
    }
}
