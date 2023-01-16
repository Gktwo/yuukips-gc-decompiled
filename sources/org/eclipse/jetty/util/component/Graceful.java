package org.eclipse.jetty.util.component;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jetty.util.FutureCallback;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/component/Graceful.class */
public interface Graceful {
    Future<Void> shutdown();

    boolean isShutdown();

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/component/Graceful$Shutdown.class */
    public static class Shutdown implements Graceful {
        private final AtomicReference<FutureCallback> _shutdown = new AtomicReference<>();

        protected FutureCallback newShutdownCallback() {
            return FutureCallback.SUCCEEDED;
        }

        @Override // org.eclipse.jetty.util.component.Graceful
        public Future<Void> shutdown() {
            return this._shutdown.updateAndGet(fcb -> {
                return fcb == null ? newShutdownCallback() : fcb;
            });
        }

        @Override // org.eclipse.jetty.util.component.Graceful
        public boolean isShutdown() {
            return this._shutdown.get() != null;
        }

        public void cancel() {
            FutureCallback shutdown = this._shutdown.getAndSet(null);
            if (shutdown != null && !shutdown.isDone()) {
                shutdown.cancel(true);
            }
        }

        public FutureCallback get() {
            return this._shutdown.get();
        }
    }
}
