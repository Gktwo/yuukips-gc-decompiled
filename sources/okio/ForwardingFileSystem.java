package okio;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import p001ch.qos.logback.core.joran.action.Action;

/* compiled from: ForwardingFileSystem.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00172\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0010\u001a\u00020\bH\u0016J \u0010\u001e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010%\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020'2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010(\u001a\u00020 H\u0016R\u0013\u0010\u0002\u001a\u00020\u00018\u0007¢\u0006\b\n��\u001a\u0004\b\u0002\u0010\u0004¨\u0006)"}, m373d2 = {"Lokio/ForwardingFileSystem;", "Lokio/FileSystem;", MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX, "(Lokio/FileSystem;)V", "()Lokio/FileSystem;", "appendingSink", "Lokio/Sink;", Action.FILE_ATTRIBUTE, "Lokio/Path;", "mustExist", "", "atomicMove", "", "source", TypeProxy.INSTANCE_FIELD, "canonicalize", "path", "createDirectory", "dir", "mustCreate", "createSymlink", "delete", "list", "", "listOrNull", "listRecursively", "Lkotlin/sequences/Sequence;", "followSymlinks", "metadataOrNull", "Lokio/FileMetadata;", "onPathParameter", "functionName", "", "parameterName", "onPathResult", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", Printer.TO_STRING, "okio"})
/* loaded from: grasscutter.jar:okio/ForwardingFileSystem.class */
public abstract class ForwardingFileSystem extends FileSystem {
    @NotNull
    private final FileSystem delegate;

    @JvmName(name = MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX)
    @NotNull
    public final FileSystem delegate() {
        return this.delegate;
    }

    public ForwardingFileSystem(@NotNull FileSystem delegate) {
        Intrinsics.checkNotNullParameter(delegate, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.delegate = delegate;
    }

    @NotNull
    public Path onPathParameter(@NotNull Path path, @NotNull String functionName, @NotNull String parameterName) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        Intrinsics.checkNotNullParameter(parameterName, "parameterName");
        return path;
    }

    @NotNull
    public Path onPathResult(@NotNull Path path, @NotNull String functionName) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        return path;
    }

    @Override // okio.FileSystem
    @NotNull
    public Path canonicalize(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        return onPathResult(this.delegate.canonicalize(onPathParameter(path, "canonicalize", "path")), "canonicalize");
    }

    @Override // okio.FileSystem
    @Nullable
    public FileMetadata metadataOrNull(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata metadataOrNull = this.delegate.metadataOrNull(onPathParameter(path, "metadataOrNull", "path"));
        if (metadataOrNull == null) {
            return null;
        }
        return metadataOrNull.getSymlinkTarget() == null ? metadataOrNull : FileMetadata.copy$default(metadataOrNull, false, false, onPathResult(metadataOrNull.getSymlinkTarget(), "metadataOrNull"), null, null, null, null, null, PacketOpcodes.SceneForceLockNotify, null);
    }

    @Override // okio.FileSystem
    @NotNull
    public List<Path> list(@NotNull Path dir) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Iterable<Path> $this$mapTo$iv = this.delegate.list(onPathParameter(dir, "list", "dir"));
        Collection destination$iv = (List) new ArrayList();
        for (Path it : $this$mapTo$iv) {
            destination$iv.add(onPathResult(it, "list"));
        }
        List paths = (List) destination$iv;
        CollectionsKt.sort(paths);
        return paths;
    }

    @Override // okio.FileSystem
    @Nullable
    public List<Path> listOrNull(@NotNull Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Iterable result = this.delegate.listOrNull(onPathParameter(dir, "listOrNull", "dir"));
        if (result == null) {
            return null;
        }
        Iterable<Path> $this$mapTo$iv = result;
        Collection destination$iv = (List) new ArrayList();
        for (Path it : $this$mapTo$iv) {
            destination$iv.add(onPathResult(it, "listOrNull"));
        }
        List paths = (List) destination$iv;
        CollectionsKt.sort(paths);
        return paths;
    }

    @Override // okio.FileSystem
    @NotNull
    public Sequence<Path> listRecursively(@NotNull Path dir, boolean followSymlinks) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        return SequencesKt.map(this.delegate.listRecursively(onPathParameter(dir, "listRecursively", "dir"), followSymlinks), new Function1<Path, Path>(this) { // from class: okio.ForwardingFileSystem$listRecursively$1
            final /* synthetic */ ForwardingFileSystem this$0;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
            }

            @NotNull
            public final Path invoke(@NotNull Path it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return this.this$0.onPathResult(it, "listRecursively");
            }
        });
    }

    @Override // okio.FileSystem
    @NotNull
    public FileHandle openReadOnly(@NotNull Path file) throws IOException {
        Intrinsics.checkNotNullParameter(file, Action.FILE_ATTRIBUTE);
        return this.delegate.openReadOnly(onPathParameter(file, "openReadOnly", Action.FILE_ATTRIBUTE));
    }

    @Override // okio.FileSystem
    @NotNull
    public FileHandle openReadWrite(@NotNull Path file, boolean mustCreate, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(file, Action.FILE_ATTRIBUTE);
        return this.delegate.openReadWrite(onPathParameter(file, "openReadWrite", Action.FILE_ATTRIBUTE), mustCreate, mustExist);
    }

    @Override // okio.FileSystem
    @NotNull
    public Source source(@NotNull Path file) throws IOException {
        Intrinsics.checkNotNullParameter(file, Action.FILE_ATTRIBUTE);
        return this.delegate.source(onPathParameter(file, "source", Action.FILE_ATTRIBUTE));
    }

    @Override // okio.FileSystem
    @NotNull
    public Sink sink(@NotNull Path file, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter(file, Action.FILE_ATTRIBUTE);
        return this.delegate.sink(onPathParameter(file, "sink", Action.FILE_ATTRIBUTE), mustCreate);
    }

    @Override // okio.FileSystem
    @NotNull
    public Sink appendingSink(@NotNull Path file, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(file, Action.FILE_ATTRIBUTE);
        return this.delegate.appendingSink(onPathParameter(file, "appendingSink", Action.FILE_ATTRIBUTE), mustExist);
    }

    @Override // okio.FileSystem
    public void createDirectory(@NotNull Path dir, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        this.delegate.createDirectory(onPathParameter(dir, "createDirectory", "dir"), mustCreate);
    }

    @Override // okio.FileSystem
    public void atomicMove(@NotNull Path source, @NotNull Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, TypeProxy.INSTANCE_FIELD);
        this.delegate.atomicMove(onPathParameter(source, "atomicMove", "source"), onPathParameter(target, "atomicMove", TypeProxy.INSTANCE_FIELD));
    }

    @Override // okio.FileSystem
    public void delete(@NotNull Path path, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        this.delegate.delete(onPathParameter(path, "delete", "path"), mustExist);
    }

    @Override // okio.FileSystem
    public void createSymlink(@NotNull Path source, @NotNull Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, TypeProxy.INSTANCE_FIELD);
        this.delegate.createSymlink(onPathParameter(source, "createSymlink", "source"), onPathParameter(target, "createSymlink", TypeProxy.INSTANCE_FIELD));
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.String : 0x000e: INVOKE  (r1v4 java.lang.String A[REMOVE]) = 
      (wrap: kotlin.reflect.KClass : 0x000b: INVOKE  (r1v3 kotlin.reflect.KClass A[REMOVE]) = 
      (wrap: java.lang.Class<?> : 0x0008: INVOKE  (r1v2 java.lang.Class<?> A[REMOVE]) = (r3v0 'this' okio.ForwardingFileSystem A[D('this' okio.ForwardingFileSystem), IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: java.lang.Object.getClass():java.lang.Class)
     type: STATIC call: kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(java.lang.Class):kotlin.reflect.KClass)
     type: INTERFACE call: kotlin.reflect.KClass.getSimpleName():java.lang.String)), ('(' char), (wrap: okio.FileSystem : 0x001c: IGET  (r1v7 okio.FileSystem A[REMOVE]) = (r3v0 'this' okio.ForwardingFileSystem A[D('this' okio.ForwardingFileSystem), IMMUTABLE_TYPE, THIS]) okio.ForwardingFileSystem.delegate okio.FileSystem), (')' char)] */
    @NotNull
    public String toString() {
        return new StringBuilder().append((Object) Reflection.getOrCreateKotlinClass(getClass()).getSimpleName()).append('(').append(this.delegate).append(')').toString();
    }
}
