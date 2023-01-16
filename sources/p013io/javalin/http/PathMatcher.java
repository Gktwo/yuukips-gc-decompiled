package p013io.javalin.http;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Tuples;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: PathMatcher.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��<\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n��\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\u001d\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH��¢\u0006\u0002\b\u0012J\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u000fH\u0002R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0004¢\u0006\u0002\n��¨\u0006\u0015"}, m373d2 = {"Lio/javalin/http/PathMatcher;", "", "()V", "handlerEntries", "Ljava/util/EnumMap;", "Lio/javalin/http/HandlerType;", "Ljava/util/ArrayList;", "Lio/javalin/http/HandlerEntry;", BeanUtil.PREFIX_ADDER, "", "entry", "findEntries", "", "handlerType", "requestUri", "", "hasEntries", "", "hasEntries$javalin", "match", "requestPath", "javalin"})
/* renamed from: io.javalin.http.PathMatcher */
/* loaded from: grasscutter.jar:io/javalin/http/PathMatcher.class */
public final class PathMatcher {
    @NotNull
    private final EnumMap<HandlerType, ArrayList<HandlerEntry>> handlerEntries;

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    public PathMatcher() {
        Object[] $this$associateTo$iv = HandlerType.values();
        Map destination$iv = new EnumMap(HandlerType.class);
        for (Object element$iv : $this$associateTo$iv) {
            Pair pair = Tuples.m366to(element$iv, new ArrayList());
            destination$iv.put(pair.getFirst(), pair.getSecond());
        }
        this.handlerEntries = (EnumMap) destination$iv;
    }

    public final void add(@NotNull HandlerEntry entry) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(entry, "entry");
        if (entry.getType().isHttpMethod()) {
            ArrayList<HandlerEntry> arrayList = this.handlerEntries.get(entry.getType());
            Intrinsics.checkNotNull(arrayList);
            Intrinsics.checkNotNullExpressionValue(arrayList, "handlerEntries[entry.type]!!");
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                Object next = it.next();
                HandlerEntry it2 = (HandlerEntry) next;
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
        }
        ArrayList<HandlerEntry> arrayList2 = this.handlerEntries.get(entry.getType());
        Intrinsics.checkNotNull(arrayList2);
        arrayList2.add(entry);
    }

    @NotNull
    public final List<HandlerEntry> findEntries(@NotNull HandlerType handlerType, @NotNull String requestUri) {
        Intrinsics.checkNotNullParameter(handlerType, "handlerType");
        Intrinsics.checkNotNullParameter(requestUri, "requestUri");
        Iterable iterable = this.handlerEntries.get(handlerType);
        Intrinsics.checkNotNull(iterable);
        Intrinsics.checkNotNullExpressionValue(iterable, "handlerEntries[handlerType]!!");
        Iterable $this$filter$iv = iterable;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (match((HandlerEntry) element$iv$iv, requestUri)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public final boolean hasEntries$javalin(@NotNull HandlerType handlerType, @NotNull String requestUri) {
        Intrinsics.checkNotNullParameter(handlerType, "handlerType");
        Intrinsics.checkNotNullParameter(requestUri, "requestUri");
        Iterable iterable = this.handlerEntries.get(handlerType);
        Intrinsics.checkNotNull(iterable);
        Intrinsics.checkNotNullExpressionValue(iterable, "handlerEntries[handlerType]!!");
        Iterable<HandlerEntry> $this$any$iv = iterable;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (HandlerEntry entry : $this$any$iv) {
            if (match(entry, requestUri)) {
                return true;
            }
        }
        return false;
    }

    private final boolean match(HandlerEntry entry, String requestPath) {
        if (!Intrinsics.areEqual(entry.getPath(), "*") && !Intrinsics.areEqual(entry.getPath(), requestPath)) {
            return entry.matches(requestPath);
        }
        return true;
    }
}
