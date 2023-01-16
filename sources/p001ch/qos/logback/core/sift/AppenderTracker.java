package p001ch.qos.logback.core.sift;

import p001ch.qos.logback.core.Appender;
import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.helpers.NOPAppender;
import p001ch.qos.logback.core.joran.spi.JoranException;
import p001ch.qos.logback.core.spi.AbstractComponentTracker;
import p001ch.qos.logback.core.spi.ContextAwareImpl;

/* renamed from: ch.qos.logback.core.sift.AppenderTracker */
/* loaded from: grasscutter.jar:ch/qos/logback/core/sift/AppenderTracker.class */
public class AppenderTracker<E> extends AbstractComponentTracker<Appender<E>> {
    int nopaWarningCount = 0;
    final Context context;
    final AppenderFactory<E> appenderFactory;
    final ContextAwareImpl contextAware;

    @Override // p001ch.qos.logback.core.spi.AbstractComponentTracker
    protected /* bridge */ /* synthetic */ boolean isComponentStale(Object obj) {
        return isComponentStale((Appender) ((Appender) obj));
    }

    @Override // p001ch.qos.logback.core.spi.AbstractComponentTracker
    protected /* bridge */ /* synthetic */ void processPriorToRemoval(Object obj) {
        processPriorToRemoval((Appender) ((Appender) obj));
    }

    public AppenderTracker(Context context, AppenderFactory<E> appenderFactory) {
        this.context = context;
        this.appenderFactory = appenderFactory;
        this.contextAware = new ContextAwareImpl(context, this);
    }

    protected void processPriorToRemoval(Appender<E> component) {
        component.stop();
    }

    /* access modifiers changed from: protected */
    @Override // p001ch.qos.logback.core.spi.AbstractComponentTracker
    public Appender<E> buildComponent(String key) {
        Appender<E> appender = null;
        try {
            appender = this.appenderFactory.buildAppender(this.context, key);
        } catch (JoranException e) {
            this.contextAware.addError("Error while building appender with discriminating value [" + key + "]");
        }
        Appender<E> appender2 = appender;
        if (appender == null) {
            appender2 = buildNOPAppender(key);
        }
        return appender2;
    }

    private NOPAppender<E> buildNOPAppender(String key) {
        if (this.nopaWarningCount < 4) {
            this.nopaWarningCount++;
            this.contextAware.addError("Building NOPAppender for discriminating value [" + key + "]");
        }
        NOPAppender<E> nopa = new NOPAppender<>();
        nopa.setContext(this.context);
        nopa.start();
        return nopa;
    }

    protected boolean isComponentStale(Appender<E> appender) {
        return !appender.isStarted();
    }
}
