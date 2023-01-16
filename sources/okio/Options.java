package okio;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: Options.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0011\n��\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018�� \u00152\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0015B\u001f\b\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000eH\u0002R\u001e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n��\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, m373d2 = {"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "byteStrings", "", "trie", "", "([Lokio/ByteString;[I)V", "getByteStrings$okio", "()[Lokio/ByteString;", "[Lokio/ByteString;", "size", "", "getSize", "()I", "getTrie$okio", "()[I", BeanUtil.PREFIX_GETTER_GET, "index", "Companion", "okio"})
/* loaded from: grasscutter.jar:okio/Options.class */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ByteString[] byteStrings;
    @NotNull
    private final int[] trie;

    @JvmStatic
    @NotNull
    /* renamed from: of */
    public static final Options m47of(@NotNull ByteString... byteStrings) {
        return Companion.m46of(byteStrings);
    }

    public /* synthetic */ Options(ByteString[] byteStrings, int[] trie, DefaultConstructorMarker $constructor_marker) {
        this(byteStrings, trie);
    }

    public /* bridge */ boolean contains(ByteString element) {
        return contains((Options) element);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object element) {
        if (!(element instanceof ByteString)) {
            return false;
        }
        return contains((ByteString) element);
    }

    public /* bridge */ int indexOf(ByteString element) {
        return indexOf((Options) element);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object element) {
        if (!(element instanceof ByteString)) {
            return -1;
        }
        return indexOf((ByteString) element);
    }

    public /* bridge */ int lastIndexOf(ByteString element) {
        return lastIndexOf((Options) element);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object element) {
        if (!(element instanceof ByteString)) {
            return -1;
        }
        return lastIndexOf((ByteString) element);
    }

    @NotNull
    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    @NotNull
    public final int[] getTrie$okio() {
        return this.trie;
    }

    private Options(ByteString[] byteStrings, int[] trie) {
        this.byteStrings = byteStrings;
        this.trie = trie;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.byteStrings.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    @NotNull
    public ByteString get(int index) {
        return this.byteStrings[index];
    }

    /* compiled from: Options.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��>\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n��\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002J!\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0016\"\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0017R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, m373d2 = {"Lokio/Options$Companion;", "", "()V", "intCount", "", "Lokio/Buffer;", "getIntCount", "(Lokio/Buffer;)J", "buildTrieRecursive", "", "nodeOffset", "node", "byteStringOffset", "", "byteStrings", "", "Lokio/ByteString;", "fromIndex", "toIndex", "indexes", "of", "Lokio/Options;", "", "([Lokio/ByteString;)Lokio/Options;", "okio"})
    /* loaded from: grasscutter.jar:okio/Options$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0220, code lost:
            continue;
         */
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        /* renamed from: of */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okio.Options m46of(@org.jetbrains.annotations.NotNull okio.ByteString... r13) {
            /*
            // Method dump skipped, instructions count: 660
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.Options.Companion.m46of(okio.ByteString[]):okio.Options");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v1 */
        /* JADX WARN: Type inference failed for: r11v2 */
        /* JADX WARN: Type inference failed for: r11v4 */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static /* synthetic */ void buildTrieRecursive$default(okio.Options.Companion r10, long r11, okio.Buffer r13, int r14, java.util.List r15, int r16, int r17, java.util.List r18, int r19, java.lang.Object r20) {
            /*
                r0 = r19
                r1 = 1
                r0 = r0 & r1
                if (r0 == 0) goto L_0x0009
                r0 = 0
                r11 = r0
            L_0x0009:
                r0 = r19
                r1 = 4
                r0 = r0 & r1
                if (r0 == 0) goto L_0x0013
                r0 = 0
                r14 = r0
            L_0x0013:
                r0 = r19
                r1 = 16
                r0 = r0 & r1
                if (r0 == 0) goto L_0x001e
                r0 = 0
                r16 = r0
            L_0x001e:
                r0 = r19
                r1 = 32
                r0 = r0 & r1
                if (r0 == 0) goto L_0x002f
                r0 = r15
                int r0 = r0.size()
                r17 = r0
            L_0x002f:
                r0 = r10
                r1 = r11
                r2 = r13
                r3 = r14
                r4 = r15
                r5 = r16
                r6 = r17
                r7 = r18
                r0.buildTrieRecursive(r1, r2, r3, r4, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.Options.Companion.buildTrieRecursive$default(okio.Options$Companion, long, okio.Buffer, int, java.util.List, int, int, java.util.List, int, java.lang.Object):void");
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x00c1  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00fb  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0175 A[LOOP:2: B:36:0x0175->B:42:0x01c8, LOOP_START, PHI: r26 
          PHI: (r26v9 'i' int) = (r26v7 'i' int), (r26v10 'i' int) binds: [B:35:0x0172, B:42:0x01c8] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x01cb  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x01df  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x029d  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x0359  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x03b6  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void buildTrieRecursive(long r11, okio.Buffer r13, int r14, java.util.List<? extends okio.ByteString> r15, int r16, int r17, java.util.List<java.lang.Integer> r18) {
            /*
            // Method dump skipped, instructions count: 1008
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.Options.Companion.buildTrieRecursive(long, okio.Buffer, int, java.util.List, int, int, java.util.List):void");
        }

        private final long getIntCount(Buffer $this$intCount) {
            return $this$intCount.size() / ((long) 4);
        }
    }
}
