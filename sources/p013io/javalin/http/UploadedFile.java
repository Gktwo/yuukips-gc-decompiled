package p013io.javalin.http;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;

/* compiled from: UploadedFile.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��0\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018��2\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J=\u0010\u0018\u001a\u00020��2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n��\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n��\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n��\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n��\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, m373d2 = {"Lio/javalin/http/UploadedFile;", "", "content", "Ljava/io/InputStream;", "contentType", "", "filename", "extension", "size", "", "(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getContent", "()Ljava/io/InputStream;", "getContentType", "()Ljava/lang/String;", "getExtension", "getFilename", "getSize", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", Printer.TO_STRING, "javalin"})
/* renamed from: io.javalin.http.UploadedFile */
/* loaded from: grasscutter.jar:io/javalin/http/UploadedFile.class */
public final class UploadedFile {
    @NotNull
    private final InputStream content;
    @Nullable
    private final String contentType;
    @NotNull
    private final String filename;
    @NotNull
    private final String extension;
    private final long size;

    @NotNull
    public final InputStream component1() {
        return this.content;
    }

    @Nullable
    public final String component2() {
        return this.contentType;
    }

    @NotNull
    public final String component3() {
        return this.filename;
    }

    @NotNull
    public final String component4() {
        return this.extension;
    }

    public final long component5() {
        return this.size;
    }

    @NotNull
    public final UploadedFile copy(@NotNull InputStream content, @Nullable String contentType, @NotNull String filename, @NotNull String extension, long size) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(extension, "extension");
        return new UploadedFile(content, contentType, filename, extension, size);
    }

    public static /* synthetic */ UploadedFile copy$default(UploadedFile uploadedFile, InputStream inputStream, String str, String str2, String str3, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            inputStream = uploadedFile.content;
        }
        if ((i & 2) != 0) {
            str = uploadedFile.contentType;
        }
        if ((i & 4) != 0) {
            str2 = uploadedFile.filename;
        }
        if ((i & 8) != 0) {
            str3 = uploadedFile.extension;
        }
        if ((i & 16) != 0) {
            j = uploadedFile.size;
        }
        return uploadedFile.copy(inputStream, str, str2, str3, j);
    }

    @NotNull
    public String toString() {
        return "UploadedFile(content=" + this.content + ", contentType=" + ((Object) this.contentType) + ", filename=" + this.filename + ", extension=" + this.extension + ", size=" + this.size + ')';
    }

    public int hashCode() {
        return (((((((this.content.hashCode() * 31) + (this.contentType == null ? 0 : this.contentType.hashCode())) * 31) + this.filename.hashCode()) * 31) + this.extension.hashCode()) * 31) + Long.hashCode(this.size);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadedFile)) {
            return false;
        }
        UploadedFile uploadedFile = (UploadedFile) other;
        return Intrinsics.areEqual(this.content, uploadedFile.content) && Intrinsics.areEqual(this.contentType, uploadedFile.contentType) && Intrinsics.areEqual(this.filename, uploadedFile.filename) && Intrinsics.areEqual(this.extension, uploadedFile.extension) && this.size == uploadedFile.size;
    }

    public UploadedFile(@NotNull InputStream content, @Nullable String contentType, @NotNull String filename, @NotNull String extension, long size) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(extension, "extension");
        this.content = content;
        this.contentType = contentType;
        this.filename = filename;
        this.extension = extension;
        this.size = size;
    }

    @NotNull
    public final InputStream getContent() {
        return this.content;
    }

    @Nullable
    public final String getContentType() {
        return this.contentType;
    }

    @NotNull
    public final String getFilename() {
        return this.filename;
    }

    @NotNull
    public final String getExtension() {
        return this.extension;
    }

    public final long getSize() {
        return this.size;
    }
}
