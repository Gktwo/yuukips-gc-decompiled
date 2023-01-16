package p013io.javalin.http.sse;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.AsyncContext;
import javax.servlet.ServletOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p016io.IOStreams;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Emitter.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��4\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u0012\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n��¨\u0006\u0013"}, m373d2 = {"Lio/javalin/http/sse/Emitter;", "", "asyncContext", "Ljavax/servlet/AsyncContext;", "(Ljavax/servlet/AsyncContext;)V", "closed", "", "newline", "", "output", "Ljavax/servlet/ServletOutputStream;", "emit", "", "comment", "event", "data", "Ljava/io/InputStream;", "id", "isClosed", "javalin"})
/* renamed from: io.javalin.http.sse.Emitter */
/* loaded from: grasscutter.jar:io/javalin/http/sse/Emitter.class */
public final class Emitter {
    @NotNull
    private AsyncContext asyncContext;
    private ServletOutputStream output;
    private boolean closed;
    @NotNull
    private final String newline = "\n";

    public Emitter(@NotNull AsyncContext asyncContext) {
        Intrinsics.checkNotNullParameter(asyncContext, "asyncContext");
        this.asyncContext = asyncContext;
        try {
            ServletOutputStream outputStream = this.asyncContext.getResponse().getOutputStream();
            Intrinsics.checkNotNullExpressionValue(outputStream, "asyncContext.response.outputStream");
            this.output = outputStream;
        } catch (IOException e) {
            this.closed = true;
        }
    }

    public final void emit(@NotNull String event, @NotNull InputStream data, @Nullable String id) {
        ServletOutputStream servletOutputStream;
        ServletOutputStream servletOutputStream2;
        ServletOutputStream servletOutputStream3;
        ServletOutputStream servletOutputStream4;
        ServletOutputStream servletOutputStream5;
        ServletOutputStream servletOutputStream6;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(data, "data");
        synchronized (this) {
            if (id != null) {
                try {
                    ServletOutputStream servletOutputStream7 = this.output;
                    if (servletOutputStream7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("output");
                        servletOutputStream = null;
                    } else {
                        servletOutputStream = servletOutputStream7;
                    }
                    servletOutputStream.print("id: " + ((Object) id) + this.newline);
                } catch (IOException e) {
                    this.closed = true;
                }
            }
            ServletOutputStream servletOutputStream8 = this.output;
            if (servletOutputStream8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("output");
                servletOutputStream2 = null;
            } else {
                servletOutputStream2 = servletOutputStream8;
            }
            servletOutputStream2.print("event: " + event + this.newline);
            ServletOutputStream servletOutputStream9 = this.output;
            if (servletOutputStream9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("output");
                servletOutputStream3 = null;
            } else {
                servletOutputStream3 = servletOutputStream9;
            }
            servletOutputStream3.print("data: ");
            ServletOutputStream servletOutputStream10 = this.output;
            if (servletOutputStream10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("output");
                servletOutputStream4 = null;
            } else {
                servletOutputStream4 = servletOutputStream10;
            }
            IOStreams.copyTo$default(data, servletOutputStream4, 0, 2, null);
            ServletOutputStream servletOutputStream11 = this.output;
            if (servletOutputStream11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("output");
                servletOutputStream5 = null;
            } else {
                servletOutputStream5 = servletOutputStream11;
            }
            servletOutputStream5.print(this.newline);
            ServletOutputStream servletOutputStream12 = this.output;
            if (servletOutputStream12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("output");
                servletOutputStream6 = null;
            } else {
                servletOutputStream6 = servletOutputStream12;
            }
            servletOutputStream6.print(this.newline);
            this.asyncContext.getResponse().flushBuffer();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void emit(@NotNull String comment) {
        ServletOutputStream servletOutputStream;
        Intrinsics.checkNotNullParameter(comment, "comment");
        try {
            for (String it : StringsKt.split$default((CharSequence) comment, new String[]{this.newline}, false, 0, 6, (Object) null)) {
                ServletOutputStream servletOutputStream2 = this.output;
                if (servletOutputStream2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("output");
                    servletOutputStream = null;
                } else {
                    servletOutputStream = servletOutputStream2;
                }
                servletOutputStream.print(": " + it + this.newline);
            }
            this.asyncContext.getResponse().flushBuffer();
        } catch (IOException e) {
            this.closed = true;
        }
    }

    public final boolean isClosed() {
        return this.closed;
    }
}
