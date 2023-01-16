package okio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;

/* compiled from: FileMetadata.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��2\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n��\u0018��2\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\u0010\u000fJu\u0010\u001b\u001a\u00020��2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\u0010\u001cJ'\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\b\b��\u0010\u001e*\u00020\u00012\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u001e0\u000e¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\"H\u0016R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R!\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\b\n��\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u0004\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u0002\u0010\u0015R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n��\u001a\u0004\b\u0019\u0010\u001a¨\u0006#"}, m373d2 = {"Lokio/FileMetadata;", "", "isRegularFile", "", "isDirectory", "symlinkTarget", "Lokio/Path;", "size", "", "createdAtMillis", "lastModifiedAtMillis", "lastAccessedAtMillis", "extras", "", "Lkotlin/reflect/KClass;", "(ZZLokio/Path;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)V", "getCreatedAtMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExtras", "()Ljava/util/Map;", "()Z", "getLastAccessedAtMillis", "getLastModifiedAtMillis", "getSize", "getSymlinkTarget", "()Lokio/Path;", "copy", "(ZZLokio/Path;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)Lokio/FileMetadata;", "extra", "T", "type", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", Printer.TO_STRING, "", "okio"})
/* loaded from: grasscutter.jar:okio/FileMetadata.class */
public final class FileMetadata {
    private final boolean isRegularFile;
    private final boolean isDirectory;
    @Nullable
    private final Path symlinkTarget;
    @Nullable
    private final Long size;
    @Nullable
    private final Long createdAtMillis;
    @Nullable
    private final Long lastModifiedAtMillis;
    @Nullable
    private final Long lastAccessedAtMillis;
    @NotNull
    private final Map<KClass<?>, Object> extras;

    public FileMetadata() {
        this(false, false, null, null, null, null, null, null, 255, null);
    }

    public FileMetadata(boolean isRegularFile, boolean isDirectory, @Nullable Path symlinkTarget, @Nullable Long size, @Nullable Long createdAtMillis, @Nullable Long lastModifiedAtMillis, @Nullable Long lastAccessedAtMillis, @NotNull Map<KClass<?>, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "extras");
        this.isRegularFile = isRegularFile;
        this.isDirectory = isDirectory;
        this.symlinkTarget = symlinkTarget;
        this.size = size;
        this.createdAtMillis = createdAtMillis;
        this.lastModifiedAtMillis = lastModifiedAtMillis;
        this.lastAccessedAtMillis = lastAccessedAtMillis;
        this.extras = MapsKt.toMap(map);
    }

    public /* synthetic */ FileMetadata(boolean z, boolean z2, Path path, Long l, Long l2, Long l3, Long l4, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? null : path, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2, (i & 32) != 0 ? null : l3, (i & 64) != 0 ? null : l4, (i & 128) != 0 ? MapsKt.emptyMap() : map);
    }

    public final boolean isRegularFile() {
        return this.isRegularFile;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    @Nullable
    public final Path getSymlinkTarget() {
        return this.symlinkTarget;
    }

    @Nullable
    public final Long getSize() {
        return this.size;
    }

    @Nullable
    public final Long getCreatedAtMillis() {
        return this.createdAtMillis;
    }

    @Nullable
    public final Long getLastModifiedAtMillis() {
        return this.lastModifiedAtMillis;
    }

    @Nullable
    public final Long getLastAccessedAtMillis() {
        return this.lastAccessedAtMillis;
    }

    @NotNull
    public final Map<KClass<?>, Object> getExtras() {
        return this.extras;
    }

    @Nullable
    public final <T> T extra(@NotNull KClass<? extends T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        Object value = this.extras.get(kClass);
        if (value == null) {
            return null;
        }
        return (T) KClasses.cast(kClass, value);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: okio.FileMetadata */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FileMetadata copy$default(FileMetadata fileMetadata, boolean z, boolean z2, Path path, Long l, Long l2, Long l3, Long l4, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            z = fileMetadata.isRegularFile;
        }
        if ((i & 2) != 0) {
            z2 = fileMetadata.isDirectory;
        }
        if ((i & 4) != 0) {
            path = fileMetadata.symlinkTarget;
        }
        if ((i & 8) != 0) {
            l = fileMetadata.size;
        }
        if ((i & 16) != 0) {
            l2 = fileMetadata.createdAtMillis;
        }
        if ((i & 32) != 0) {
            l3 = fileMetadata.lastModifiedAtMillis;
        }
        if ((i & 64) != 0) {
            l4 = fileMetadata.lastAccessedAtMillis;
        }
        Map<KClass<?>, Object> map2 = map;
        if ((i & 128) != 0) {
            map2 = fileMetadata.extras;
        }
        return fileMetadata.copy(z, z2, path, l, l2, l3, l4, map2);
    }

    @NotNull
    public final FileMetadata copy(boolean isRegularFile, boolean isDirectory, @Nullable Path symlinkTarget, @Nullable Long size, @Nullable Long createdAtMillis, @Nullable Long lastModifiedAtMillis, @Nullable Long lastAccessedAtMillis, @NotNull Map<KClass<?>, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "extras");
        return new FileMetadata(isRegularFile, isDirectory, symlinkTarget, size, createdAtMillis, lastModifiedAtMillis, lastAccessedAtMillis, map);
    }

    @NotNull
    public String toString() {
        List fields = new ArrayList();
        if (this.isRegularFile) {
            fields.add("isRegularFile");
        }
        if (this.isDirectory) {
            fields.add("isDirectory");
        }
        if (this.size != null) {
            fields.add(Intrinsics.stringPlus("byteCount=", this.size));
        }
        if (this.createdAtMillis != null) {
            fields.add(Intrinsics.stringPlus("createdAt=", this.createdAtMillis));
        }
        if (this.lastModifiedAtMillis != null) {
            fields.add(Intrinsics.stringPlus("lastModifiedAt=", this.lastModifiedAtMillis));
        }
        if (this.lastAccessedAtMillis != null) {
            fields.add(Intrinsics.stringPlus("lastAccessedAt=", this.lastAccessedAtMillis));
        }
        if (!this.extras.isEmpty()) {
            fields.add(Intrinsics.stringPlus("extras=", this.extras));
        }
        return CollectionsKt.joinToString$default(fields, ", ", "FileMetadata(", ")", 0, null, null, 56, null);
    }
}
