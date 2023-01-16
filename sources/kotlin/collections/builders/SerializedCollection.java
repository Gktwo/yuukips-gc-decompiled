package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ListBuilder.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��6\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n��\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b��\u0018�� \u00112\u00020\u0001:\u0001\u0011B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0019\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��¨\u0006\u0012"}, m373d2 = {"Lkotlin/collections/builders/SerializedCollection;", "Ljava/io/Externalizable;", "()V", "collection", "", "tag", "", "(Ljava/util/Collection;I)V", "readExternal", "", "input", "Ljava/io/ObjectInput;", "readResolve", "", "writeExternal", "output", "Ljava/io/ObjectOutput;", "Companion", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/collections/builders/SerializedCollection.class */
public final class SerializedCollection implements Externalizable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private Collection<?> collection;
    private final int tag;
    private static final long serialVersionUID = 0;
    public static final int tagList = 0;
    public static final int tagSet = 1;

    public SerializedCollection(@NotNull Collection<?> collection, int tag) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        this.collection = collection;
        this.tag = tag;
    }

    public SerializedCollection() {
        this(CollectionsKt.emptyList(), 0);
    }

    @Override // java.io.Externalizable
    public void writeExternal(@NotNull ObjectOutput output) {
        Intrinsics.checkNotNullParameter(output, "output");
        output.writeByte(this.tag);
        output.writeInt(this.collection.size());
        Iterator<?> it = this.collection.iterator();
        while (it.hasNext()) {
            output.writeObject(it.next());
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(@NotNull ObjectInput input) {
        Set set;
        SerializedCollection serializedCollection;
        Intrinsics.checkNotNullParameter(input, "input");
        int flags = input.readByte();
        int tag = flags & 1;
        if ((flags & -2) != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + flags + '.');
        }
        int size = input.readInt();
        if (size < 0) {
            throw new InvalidObjectException("Illegal size value: " + size + '.');
        }
        switch (tag) {
            case 0:
                List $this$readExternal_u24lambda_u2d1 = CollectionsKt.createListBuilder(size);
                for (int i = 0; i < size; i++) {
                    $this$readExternal_u24lambda_u2d1.add(input.readObject());
                }
                serializedCollection = this;
                set = CollectionsKt.build($this$readExternal_u24lambda_u2d1);
                break;
            case 1:
                Set $this$readExternal_u24lambda_u2d3 = SetsKt.createSetBuilder(size);
                for (int i2 = 0; i2 < size; i2++) {
                    $this$readExternal_u24lambda_u2d3.add(input.readObject());
                }
                serializedCollection = this;
                set = SetsKt.build($this$readExternal_u24lambda_u2d3);
                break;
            default:
                throw new InvalidObjectException("Unsupported collection type tag: " + tag + '.');
        }
        serializedCollection.collection = set;
    }

    private final Object readResolve() {
        return this.collection;
    }

    /* compiled from: ListBuilder.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001a\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\t\n��\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n��¨\u0006\b"}, m373d2 = {"Lkotlin/collections/builders/SerializedCollection$Companion;", "", "()V", "serialVersionUID", "", "tagList", "", "tagSet", "kotlin-stdlib"})
    /* loaded from: grasscutter.jar:kotlin/collections/builders/SerializedCollection$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }
    }
}
