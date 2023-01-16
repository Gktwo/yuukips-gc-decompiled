package p013io.javalin.http;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.servlet.http.HttpServletResponseWrapper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p016io.Closeable;
import kotlin.p016io.IOStreams;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p013io.javalin.core.JavalinConfig;
import p013io.javalin.core.util.Util;

/* compiled from: JavalinResponseWrapper.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018��2\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\u0010\u0010\u001f\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010 \u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n��R#\u0010\u0015\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0016\u0010\r¨\u0006!"}, m373d2 = {"Lio/javalin/http/JavalinResponseWrapper;", "Ljavax/servlet/http/HttpServletResponseWrapper;", "ctx", "Lio/javalin/http/Context;", "config", "Lio/javalin/core/JavalinConfig;", "requestType", "Lio/javalin/http/HandlerType;", "(Lio/javalin/http/Context;Lio/javalin/core/JavalinConfig;Lio/javalin/http/HandlerType;)V", "clientEtag", "", "kotlin.jvm.PlatformType", "getClientEtag", "()Ljava/lang/String;", "clientEtag$delegate", "Lkotlin/Lazy;", "outputStreamWrapper", "Lio/javalin/http/OutputStreamWrapper;", "getOutputStreamWrapper", "()Lio/javalin/http/OutputStreamWrapper;", "outputStreamWrapper$delegate", "serverEtag", "getServerEtag", "serverEtag$delegate", "closeWith304", "", "inputStream", "Ljava/io/InputStream;", "generateEtagWriteAndClose", "resultStream", "getOutputStream", "write", "writeToWrapperAndClose", "javalin"})
/* renamed from: io.javalin.http.JavalinResponseWrapper */
/* loaded from: grasscutter.jar:io/javalin/http/JavalinResponseWrapper.class */
public final class JavalinResponseWrapper extends HttpServletResponseWrapper {
    @NotNull
    private final Context ctx;
    @NotNull
    private final JavalinConfig config;
    @NotNull
    private final HandlerType requestType;
    @NotNull
    private final Lazy outputStreamWrapper$delegate = LazyKt.lazy(new Function0<OutputStreamWrapper>(this) { // from class: io.javalin.http.JavalinResponseWrapper$outputStreamWrapper$2
        final /* synthetic */ JavalinResponseWrapper this$0;

        /* access modifiers changed from: package-private */
        {
            this.this$0 = $receiver;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final OutputStreamWrapper invoke() {
            return new OutputStreamWrapper(this.this$0.config, this.this$0.ctx, null, 4, null);
        }
    });
    @NotNull
    private final Lazy serverEtag$delegate = LazyKt.lazy(new Function0<String>(this) { // from class: io.javalin.http.JavalinResponseWrapper$serverEtag$2
        final /* synthetic */ JavalinResponseWrapper this$0;

        /* access modifiers changed from: package-private */
        {
            this.this$0 = $receiver;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return this.this$0.getHeader("ETag");
        }
    });
    @NotNull
    private final Lazy clientEtag$delegate = LazyKt.lazy(new Function0<String>(this) { // from class: io.javalin.http.JavalinResponseWrapper$clientEtag$2
        final /* synthetic */ JavalinResponseWrapper this$0;

        /* access modifiers changed from: package-private */
        {
            this.this$0 = $receiver;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return this.this$0.ctx.req.getHeader("If-None-Match");
        }
    });

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public JavalinResponseWrapper(@NotNull Context ctx, @NotNull JavalinConfig config, @NotNull HandlerType requestType) {
        super(ctx.res);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(requestType, "requestType");
        this.ctx = ctx;
        this.config = config;
        this.requestType = requestType;
    }

    private final OutputStreamWrapper getOutputStreamWrapper() {
        return (OutputStreamWrapper) this.outputStreamWrapper$delegate.getValue();
    }

    @Override // javax.servlet.ServletResponseWrapper, javax.servlet.ServletResponse
    @NotNull
    public OutputStreamWrapper getOutputStream() {
        return getOutputStreamWrapper();
    }

    private final String getServerEtag() {
        return (String) this.serverEtag$delegate.getValue();
    }

    private final String getClientEtag() {
        return (String) this.clientEtag$delegate.getValue();
    }

    public final void write(@Nullable InputStream resultStream) {
        if (resultStream != null) {
            if (getServerEtag() != null && Intrinsics.areEqual(getServerEtag(), getClientEtag())) {
                closeWith304(resultStream);
            } else if (getServerEtag() == null && this.requestType == HandlerType.GET && this.config.autogenerateEtags) {
                generateEtagWriteAndClose(resultStream);
            } else {
                writeToWrapperAndClose(resultStream);
            }
        }
    }

    private final void generateEtagWriteAndClose(InputStream resultStream) {
        InputStream it = resultStream;
        Throwable th = null;
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(IOStreams.readBytes(it));
            Closeable.closeFinally(it, th);
            String generatedEtag = Util.INSTANCE.getChecksumAndReset(inputStream);
            setHeader("ETag", generatedEtag);
            if (Intrinsics.areEqual(generatedEtag, getClientEtag())) {
                closeWith304(inputStream);
            } else {
                writeToWrapperAndClose(inputStream);
            }
        } catch (Throwable th2) {
            Closeable.closeFinally(it, th);
            throw th2;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x0055
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private final void writeToWrapperAndClose(java.io.InputStream r7) {
        /*
            r6 = this;
            r0 = r7
            java.io.Closeable r0 = (java.io.Closeable) r0
            r8 = r0
            r0 = 0
            r9 = r0
            r0 = 0
            r10 = r0
            r0 = 0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r10 = r0
            r0 = r8
            java.io.InputStream r0 = (java.io.InputStream) r0     // Catch: Throwable -> 0x0078, all -> 0x0081
            r11 = r0
            r0 = 0
            r13 = r0
            r0 = r6
            io.javalin.http.OutputStreamWrapper r0 = r0.getOutputStreamWrapper()     // Catch: Throwable -> 0x0078, all -> 0x0081
            java.io.Closeable r0 = (java.io.Closeable) r0     // Catch: Throwable -> 0x0078, all -> 0x0081
            r14 = r0
            r0 = 0
            r15 = r0
            r0 = 0
            r16 = r0
            r0 = 0
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch: Throwable -> 0x0078, all -> 0x0081
            r16 = r0
            r0 = r14
            io.javalin.http.OutputStreamWrapper r0 = (p013io.javalin.http.OutputStreamWrapper) r0     // Catch: Throwable -> 0x0078, all -> 0x0081, Throwable -> 0x0055, all -> 0x005e
            r17 = r0
            r0 = 0
            r19 = r0
            r0 = r11
            r1 = r17
            java.io.OutputStream r1 = (java.io.OutputStream) r1     // Catch: Throwable -> 0x0078, all -> 0x0081, Throwable -> 0x0055, all -> 0x005e
            r2 = 0
            r3 = 2
            r4 = 0
            long r0 = kotlin.p016io.IOStreams.copyTo$default(r0, r1, r2, r3, r4)     // Catch: Throwable -> 0x0078, all -> 0x0081, Throwable -> 0x0055, all -> 0x005e
            r17 = r0
            r0 = r14
            r1 = r16
            kotlin.p016io.Closeable.closeFinally(r0, r1)     // Catch: Throwable -> 0x0078, all -> 0x0081
            r0 = r17
            goto L_0x006a
        L_0x0055:
            r17 = move-exception
            r1 = r17
            r16 = r1
            r1 = r17
            throw r1     // Catch: Throwable -> 0x0078, all -> 0x0081, all -> 0x005e
        L_0x005e:
            r17 = move-exception
            r0 = r14
            r1 = r16
            kotlin.p016io.Closeable.closeFinally(r0, r1)     // Catch: Throwable -> 0x0078, all -> 0x0081
            r0 = r17
            throw r0     // Catch: Throwable -> 0x0078, all -> 0x0081
        L_0x006a:
            r11 = r0
            r0 = r8
            r1 = r10
            kotlin.p016io.Closeable.closeFinally(r0, r1)
            r0 = r11
            goto L_0x008c
        L_0x0078:
            r11 = move-exception
            r1 = r11
            r10 = r1
            r1 = r11
            throw r1     // Catch: all -> 0x0081
        L_0x0081:
            r11 = move-exception
            r0 = r8
            r1 = r10
            kotlin.p016io.Closeable.closeFinally(r0, r1)
            r0 = r11
            throw r0
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.javalin.http.JavalinResponseWrapper.writeToWrapperAndClose(java.io.InputStream):void");
    }

    private final void closeWith304(InputStream inputStream) {
        InputStream inputStream2 = inputStream;
        Throwable th = null;
        try {
            InputStream inputStream3 = inputStream2;
            this.ctx.status(HttpCode.NOT_MODIFIED);
            Closeable.closeFinally(inputStream2, th);
        } catch (Throwable th2) {
            Closeable.closeFinally(inputStream2, th);
            throw th2;
        }
    }
}
