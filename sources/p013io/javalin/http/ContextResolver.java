package p013io.javalin.http;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: ContextResolver.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��.\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002RD\u0010\u0003\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u001e\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u000e¢\u0006\u0002\n��R \u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\r0\f8\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u001e\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u001e\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u001e\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u000e¢\u0006\u0002\n��¨\u0006\u0012"}, m373d2 = {"Lio/javalin/http/ContextResolver;", "", "()V", "defaultFutureCallback", "Lkotlin/Function2;", "Lio/javalin/http/Context;", "Lkotlin/ParameterName;", "name", "ctx", "result", "", "fullUrl", "Lkotlin/Function1;", "", "host", "ip", "scheme", "url", "javalin"})
/* renamed from: io.javalin.http.ContextResolver */
/* loaded from: grasscutter.jar:io/javalin/http/ContextResolver.class */
public final class ContextResolver {
    @JvmField
    @NotNull

    /* renamed from: ip */
    public Function1<? super Context, String> f938ip = ContextResolver$ip$1.INSTANCE;
    @JvmField
    @NotNull
    public Function1<? super Context, String> host = ContextResolver$host$1.INSTANCE;
    @JvmField
    @NotNull
    public Function1<? super Context, String> scheme = ContextResolver$scheme$1.INSTANCE;
    @JvmField
    @NotNull
    public Function1<? super Context, String> url = ContextResolver$url$1.INSTANCE;
    @JvmField
    @NotNull
    public Function1<? super Context, String> fullUrl = ContextResolver$fullUrl$1.INSTANCE;
    @JvmField
    @NotNull
    public Function2<? super Context, Object, Unit> defaultFutureCallback = ContextResolver$defaultFutureCallback$1.INSTANCE;
}
