package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/* access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/util/concurrent/AggregateFuture.class */
public abstract class AggregateFuture<InputT, OutputT> extends AbstractFuture.TrustedFuture<OutputT> {
    private static final Logger logger = Logger.getLogger(AggregateFuture.class.getName());
    private AggregateFuture<InputT, OutputT>.RunningState runningState;

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected final void afterDone() {
        afterDone();
        AggregateFuture<InputT, OutputT>.RunningState localRunningState = this.runningState;
        if (localRunningState != null) {
            this.runningState = null;
            ImmutableCollection<? extends ListenableFuture<? extends InputT>> futures = ((RunningState) localRunningState).futures;
            boolean wasInterrupted = wasInterrupted();
            if (wasInterrupted) {
                localRunningState.interruptTask();
            }
            if (isCancelled() && (futures != null)) {
                UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = futures.iterator();
                while (it.hasNext()) {
                    ((ListenableFuture) it.next()).cancel(wasInterrupted);
                }
            }
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected String pendingToString() {
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> localFutures;
        AggregateFuture<InputT, OutputT>.RunningState localRunningState = this.runningState;
        if (localRunningState == null || (localFutures = ((RunningState) localRunningState).futures) == null) {
            return null;
        }
        return "futures=[" + localFutures + "]";
    }

    final void init(AggregateFuture<InputT, OutputT>.RunningState runningState) {
        this.runningState = runningState;
        runningState.init();
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/AggregateFuture$RunningState.class */
    public abstract class RunningState extends AggregateFutureState implements Runnable {
        private ImmutableCollection<? extends ListenableFuture<? extends InputT>> futures;
        private final boolean allMustSucceed;
        private final boolean collectsValues;

        abstract void collectOneValue(boolean z, int i, InputT inputt);

        abstract void handleAllCompleted();

        /* access modifiers changed from: package-private */
        public RunningState(ImmutableCollection<? extends ListenableFuture<? extends InputT>> futures, boolean allMustSucceed, boolean collectsValues) {
            super(futures.size());
            this.futures = (ImmutableCollection) Preconditions.checkNotNull(futures);
            this.allMustSucceed = allMustSucceed;
            this.collectsValues = collectsValues;
        }

        @Override // java.lang.Runnable
        public final void run() {
            decrementCountAndMaybeComplete();
        }

        /* access modifiers changed from: private */
        public void init() {
            if (this.futures.isEmpty()) {
                handleAllCompleted();
            } else if (this.allMustSucceed) {
                final int i = 0;
                UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = this.futures.iterator();
                while (it.hasNext()) {
                    final ListenableFuture<? extends InputT> listenable = (ListenableFuture) it.next();
                    i++;
                    listenable.addListener(new Runnable() { // from class: com.google.common.util.concurrent.AggregateFuture.RunningState.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                RunningState.this.handleOneInputDone(i, listenable);
                            } finally {
                                RunningState.this.decrementCountAndMaybeComplete();
                            }
                        }
                    }, MoreExecutors.directExecutor());
                }
            } else {
                UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it2 = this.futures.iterator();
                while (it2.hasNext()) {
                    ((ListenableFuture) it2.next()).addListener(this, MoreExecutors.directExecutor());
                }
            }
        }

        private void handleException(Throwable throwable) {
            Preconditions.checkNotNull(throwable);
            boolean completedWithFailure = false;
            boolean firstTimeSeeingThisException = true;
            if (this.allMustSucceed) {
                completedWithFailure = AggregateFuture.this.setException(throwable);
                if (completedWithFailure) {
                    releaseResourcesAfterFailure();
                } else {
                    firstTimeSeeingThisException = AggregateFuture.addCausalChain(getOrInitSeenExceptions(), throwable);
                }
            }
            if ((throwable instanceof Error) || (this.allMustSucceed & (!completedWithFailure) & firstTimeSeeingThisException)) {
                AggregateFuture.logger.log(Level.SEVERE, throwable instanceof Error ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", throwable);
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState
        final void addInitialException(Set<Throwable> seen) {
            if (!AggregateFuture.this.isCancelled()) {
                AggregateFuture.addCausalChain(seen, AggregateFuture.this.tryInternalFastPathGetFailure());
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.common.util.concurrent.AggregateFuture$RunningState */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: private */
        public void handleOneInputDone(int index, Future<? extends InputT> future) {
            Preconditions.checkState(this.allMustSucceed || !AggregateFuture.this.isDone() || AggregateFuture.this.isCancelled(), "Future was done before all dependencies completed");
            try {
                Preconditions.checkState(future.isDone(), "Tried to set value from future which is not done");
                if (this.allMustSucceed) {
                    if (future.isCancelled()) {
                        AggregateFuture.this.runningState = null;
                        AggregateFuture.this.cancel(false);
                    } else {
                        Object done = Futures.getDone(future);
                        if (this.collectsValues) {
                            collectOneValue(this.allMustSucceed, index, done);
                        }
                    }
                } else if (this.collectsValues && !future.isCancelled()) {
                    collectOneValue(this.allMustSucceed, index, Futures.getDone(future));
                }
            } catch (ExecutionException e) {
                handleException(e.getCause());
            } catch (Throwable t) {
                handleException(t);
            }
        }

        /* access modifiers changed from: private */
        public void decrementCountAndMaybeComplete() {
            int newRemaining = decrementRemainingAndGet();
            Preconditions.checkState(newRemaining >= 0, "Less than 0 remaining futures");
            if (newRemaining == 0) {
                processCompleted();
            }
        }

        private void processCompleted() {
            if (this.collectsValues && (!this.allMustSucceed)) {
                int i = 0;
                UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = this.futures.iterator();
                while (it.hasNext()) {
                    i++;
                    handleOneInputDone(i, (ListenableFuture) it.next());
                }
            }
            handleAllCompleted();
        }

        /* access modifiers changed from: package-private */
        @ForOverride
        @OverridingMethodsMustInvokeSuper
        public void releaseResourcesAfterFailure() {
            this.futures = null;
        }

        void interruptTask() {
        }
    }

    /* access modifiers changed from: private */
    public static boolean addCausalChain(Set<Throwable> seen, Throwable t) {
        while (t != null) {
            if (!seen.add(t)) {
                return false;
            }
            t = t.getCause();
        }
        return true;
    }
}
