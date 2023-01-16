package p013io.javalin.core.event;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: EventManager.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��D\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\r¢\u0006\u0002\u0010\u0019J\u001a\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u001b\u001a\u00020\u0006J\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00050\u00042\u0006\u0010\u001b\u001a\u00020\u0014R&\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR-\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00100\f¢\u0006\b\n��\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00050\u0004¢\u0006\b\n��\u001a\u0004\b\u0015\u0010\b¨\u0006\u001d"}, m373d2 = {"Lio/javalin/core/event/EventManager;", "", "()V", "handlerAddedHandlers", "", "Ljava/util/function/Consumer;", "Lio/javalin/core/event/HandlerMetaInfo;", "getHandlerAddedHandlers", "()Ljava/util/Set;", "setHandlerAddedHandlers", "(Ljava/util/Set;)V", "lifecycleHandlers", "", "Lio/javalin/core/event/JavalinEvent;", "Ljava/util/HashSet;", "Lio/javalin/core/event/EventHandler;", "Lkotlin/collections/HashSet;", "getLifecycleHandlers", "()Ljava/util/Map;", "wsHandlerAddedHandlers", "Lio/javalin/core/event/WsHandlerMetaInfo;", "getWsHandlerAddedHandlers", "fireEvent", "", "javalinEvent", "(Lio/javalin/core/event/JavalinEvent;)Lkotlin/Unit;", "fireHandlerAddedEvent", "metaInfo", "fireWsHandlerAddedEvent", "javalin"})
/* renamed from: io.javalin.core.event.EventManager */
/* loaded from: grasscutter.jar:io/javalin/core/event/EventManager.class */
public final class EventManager {
    @NotNull
    private final Map<JavalinEvent, HashSet<EventHandler>> lifecycleHandlers;
    @NotNull
    private Set<Consumer<HandlerMetaInfo>> handlerAddedHandlers;
    @NotNull
    private final Set<Consumer<WsHandlerMetaInfo>> wsHandlerAddedHandlers;

    public EventManager() {
        Object[] $this$associate$iv = JavalinEvent.values();
        Map destination$iv$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity($this$associate$iv.length), 16));
        for (Object element$iv$iv : $this$associate$iv) {
            Pair pair = Tuples.m366to(element$iv$iv, new HashSet());
            destination$iv$iv.put(pair.getFirst(), pair.getSecond());
        }
        this.lifecycleHandlers = destination$iv$iv;
        this.handlerAddedHandlers = new LinkedHashSet();
        this.wsHandlerAddedHandlers = new LinkedHashSet();
    }

    @NotNull
    public final Map<JavalinEvent, HashSet<EventHandler>> getLifecycleHandlers() {
        return this.lifecycleHandlers;
    }

    @NotNull
    public final Set<Consumer<HandlerMetaInfo>> getHandlerAddedHandlers() {
        return this.handlerAddedHandlers;
    }

    public final void setHandlerAddedHandlers(@NotNull Set<Consumer<HandlerMetaInfo>> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.handlerAddedHandlers = set;
    }

    @NotNull
    public final Set<Consumer<WsHandlerMetaInfo>> getWsHandlerAddedHandlers() {
        return this.wsHandlerAddedHandlers;
    }

    @Nullable
    public final Unit fireEvent(@NotNull JavalinEvent javalinEvent) {
        Intrinsics.checkNotNullParameter(javalinEvent, "javalinEvent");
        Iterable<EventHandler> $this$forEach$iv = (HashSet) this.lifecycleHandlers.get(javalinEvent);
        if ($this$forEach$iv == null) {
            return null;
        }
        for (EventHandler eventHandler : $this$forEach$iv) {
            eventHandler.handleEvent();
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public final Set<Consumer<HandlerMetaInfo>> fireHandlerAddedEvent(@NotNull HandlerMetaInfo metaInfo) {
        Intrinsics.checkNotNullParameter(metaInfo, "metaInfo");
        Set<Consumer> $this$fireHandlerAddedEvent_u24lambda_u2d3 = this.handlerAddedHandlers;
        for (Consumer it : $this$fireHandlerAddedEvent_u24lambda_u2d3) {
            it.accept(metaInfo);
        }
        return $this$fireHandlerAddedEvent_u24lambda_u2d3;
    }

    @NotNull
    public final Set<Consumer<WsHandlerMetaInfo>> fireWsHandlerAddedEvent(@NotNull WsHandlerMetaInfo metaInfo) {
        Intrinsics.checkNotNullParameter(metaInfo, "metaInfo");
        Set<Consumer> $this$fireWsHandlerAddedEvent_u24lambda_u2d5 = this.wsHandlerAddedHandlers;
        for (Consumer it : $this$fireWsHandlerAddedEvent_u24lambda_u2d5) {
            it.accept(metaInfo);
        }
        return $this$fireWsHandlerAddedEvent_u24lambda_u2d5;
    }
}
