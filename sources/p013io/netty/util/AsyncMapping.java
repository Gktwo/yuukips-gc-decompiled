package p013io.netty.util;

import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.Promise;

/* renamed from: io.netty.util.AsyncMapping */
/* loaded from: grasscutter.jar:io/netty/util/AsyncMapping.class */
public interface AsyncMapping<IN, OUT> {
    Future<OUT> map(IN in, Promise<OUT> promise);
}
