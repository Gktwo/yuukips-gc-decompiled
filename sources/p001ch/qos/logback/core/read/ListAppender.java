package p001ch.qos.logback.core.read;

import java.util.ArrayList;
import java.util.List;
import p001ch.qos.logback.core.AppenderBase;

/* renamed from: ch.qos.logback.core.read.ListAppender */
/* loaded from: grasscutter.jar:ch/qos/logback/core/read/ListAppender.class */
public class ListAppender<E> extends AppenderBase<E> {
    public List<E> list = new ArrayList();

    @Override // p001ch.qos.logback.core.AppenderBase
    protected void append(E e) {
        this.list.add(e);
    }
}
