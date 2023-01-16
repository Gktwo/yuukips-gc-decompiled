package p013io.javalin.websocket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Tuples;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: WsPathMatcher.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��4\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n��\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0004¢\u0006\u0002\n��¨\u0006\u0013"}, m373d2 = {"Lio/javalin/websocket/WsPathMatcher;", "", "()V", "wsHandlerEntries", "Ljava/util/EnumMap;", "Lio/javalin/websocket/WsHandlerType;", "", "Lio/javalin/websocket/WsEntry;", BeanUtil.PREFIX_ADDER, "", "entry", "findAfterHandlerEntries", "", "path", "", "findBeforeHandlerEntries", "findEndpointHandlerEntry", "findEntries", "handlerType", "javalin"})
/* renamed from: io.javalin.websocket.WsPathMatcher */
/* loaded from: grasscutter.jar:io/javalin/websocket/WsPathMatcher.class */
public final class WsPathMatcher {
    @NotNull
    private final EnumMap<WsHandlerType, List<WsEntry>> wsHandlerEntries;

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    public WsPathMatcher() {
        Object[] $this$associateTo$iv = WsHandlerType.values();
        Map destination$iv = new EnumMap(WsHandlerType.class);
        for (Object element$iv : $this$associateTo$iv) {
            Pair pair = Tuples.m366to(element$iv, new ArrayList());
            destination$iv.put(pair.getFirst(), pair.getSecond());
        }
        this.wsHandlerEntries = (EnumMap) destination$iv;
    }

    public final void add(@NotNull WsEntry entry) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(entry, "entry");
        List<WsEntry> list = this.wsHandlerEntries.get(entry.getType());
        Intrinsics.checkNotNull(list);
        Intrinsics.checkNotNullExpressionValue(list, "wsHandlerEntries[entry.type]!!");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            Object next = it.next();
            WsEntry it2 = (WsEntry) next;
            if (it2.getType() != entry.getType() || !Intrinsics.areEqual(it2.getPath(), entry.getPath())) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                obj = next;
                break;
            }
        }
        if (obj != null) {
            throw new IllegalArgumentException("Handler with type='" + entry.getType() + "' and path='" + entry.getPath() + "' already exists.");
        }
        List<WsEntry> list2 = this.wsHandlerEntries.get(entry.getType());
        Intrinsics.checkNotNull(list2);
        list2.add(entry);
    }

    @NotNull
    public final List<WsEntry> findBeforeHandlerEntries(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return findEntries(WsHandlerType.WS_BEFORE, path);
    }

    @Nullable
    public final WsEntry findEndpointHandlerEntry(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return (WsEntry) CollectionsKt.firstOrNull((List<? extends Object>) findEntries(WsHandlerType.WEBSOCKET, path));
    }

    @NotNull
    public final List<WsEntry> findAfterHandlerEntries(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return findEntries(WsHandlerType.WS_AFTER, path);
    }

    private final List<WsEntry> findEntries(WsHandlerType handlerType, String path) {
        Iterable iterable = this.wsHandlerEntries.get(handlerType);
        Intrinsics.checkNotNull(iterable);
        Intrinsics.checkNotNullExpressionValue(iterable, "wsHandlerEntries[handlerType]!!");
        Iterable $this$filter$iv = iterable;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            WsEntry entry = (WsEntry) element$iv$iv;
            if (Intrinsics.areEqual(entry.getPath(), "*") || entry.matches(path)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }
}
