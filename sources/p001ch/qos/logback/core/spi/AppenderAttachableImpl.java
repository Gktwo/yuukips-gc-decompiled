package p001ch.qos.logback.core.spi;

import java.util.Iterator;
import p001ch.qos.logback.core.Appender;
import p001ch.qos.logback.core.util.COWArrayList;

/* renamed from: ch.qos.logback.core.spi.AppenderAttachableImpl */
/* loaded from: grasscutter.jar:ch/qos/logback/core/spi/AppenderAttachableImpl.class */
public class AppenderAttachableImpl<E> implements AppenderAttachable<E> {
    private final COWArrayList<Appender<E>> appenderList = new COWArrayList<>(new Appender[0]);
    static final long START = System.currentTimeMillis();

    @Override // p001ch.qos.logback.core.spi.AppenderAttachable
    public void addAppender(Appender<E> newAppender) {
        if (newAppender == null) {
            throw new IllegalArgumentException("Null argument disallowed");
        }
        this.appenderList.addIfAbsent(newAppender);
    }

    public int appendLoopOnAppenders(E e) {
        int size = 0;
        for (Appender<E> appender : this.appenderList.asTypedArray()) {
            appender.doAppend(e);
            size++;
        }
        return size;
    }

    @Override // p001ch.qos.logback.core.spi.AppenderAttachable
    public Iterator<Appender<E>> iteratorForAppenders() {
        return this.appenderList.iterator();
    }

    @Override // p001ch.qos.logback.core.spi.AppenderAttachable
    public Appender<E> getAppender(String name) {
        if (name == null) {
            return null;
        }
        Iterator<Appender<E>> it = this.appenderList.iterator();
        while (it.hasNext()) {
            Appender<E> appender = it.next();
            if (name.equals(appender.getName())) {
                return appender;
            }
        }
        return null;
    }

    @Override // p001ch.qos.logback.core.spi.AppenderAttachable
    public boolean isAttached(Appender<E> appender) {
        if (appender == null) {
            return false;
        }
        Iterator<Appender<E>> it = this.appenderList.iterator();
        while (it.hasNext()) {
            if (it.next() == appender) {
                return true;
            }
        }
        return false;
    }

    @Override // p001ch.qos.logback.core.spi.AppenderAttachable
    public void detachAndStopAllAppenders() {
        Iterator<Appender<E>> it = this.appenderList.iterator();
        while (it.hasNext()) {
            it.next().stop();
        }
        this.appenderList.clear();
    }

    @Override // p001ch.qos.logback.core.spi.AppenderAttachable
    public boolean detachAppender(Appender<E> appender) {
        if (appender == null) {
            return false;
        }
        return this.appenderList.remove(appender);
    }

    @Override // p001ch.qos.logback.core.spi.AppenderAttachable
    public boolean detachAppender(String name) {
        if (name == null) {
            return false;
        }
        boolean removed = false;
        Iterator<Appender<E>> it = this.appenderList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Appender<E> a = it.next();
            if (name.equals(a.getName())) {
                removed = this.appenderList.remove(a);
                break;
            }
        }
        return removed;
    }
}
