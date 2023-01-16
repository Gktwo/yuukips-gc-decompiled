package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import p001ch.qos.logback.core.joran.action.Action;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: AbstractMap.kt */
@SinceKotlin(version = "1.1")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\"\n��\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n��\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010��\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b'\u0018�� )*\u0004\b��\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001)B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0013\u001a\u00020\u00142\u0010\u0010\u0015\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0016H��¢\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00028��H\u0016¢\u0006\u0002\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0018\u0010 \u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028��H\u0002¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\rH\u0016J#\u0010#\u001a\u0010\u0012\u0004\u0012\u00028��\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00028��H\u0002¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0014H\u0016J\b\u0010&\u001a\u00020'H\u0016J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u001fH\u0002J\u001c\u0010&\u001a\u00020'2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028��\u0012\u0004\u0012\u00028\u00010\u0016H\bR\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028��\u0018\u00010\u0006X\u000e¢\u0006\u0002\n��R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\bX\u000e¢\u0006\u0002\n��R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028��0\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006*"}, m373d2 = {"Lkotlin/collections/AbstractMap;", "K", "V", "", "()V", "_keys", "", "_values", "", "keys", "getKeys", "()Ljava/util/Set;", "size", "", "getSize", "()I", "values", "getValues", "()Ljava/util/Collection;", "containsEntry", "", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", Action.KEY_ATTRIBUTE, "(Ljava/lang/Object;)Z", "containsValue", "value", "equals", "other", "", BeanUtil.PREFIX_GETTER_GET, "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "implFindEntry", "(Ljava/lang/Object;)Ljava/util/Map$Entry;", "isEmpty", Printer.TO_STRING, "", "o", "Companion", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/collections/AbstractMap.class */
public abstract class AbstractMap<K, V> implements Map<K, V>, KMappedMarker {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private volatile Set<? extends K> _keys;
    @Nullable
    private volatile Collection<? extends V> _values;

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object key) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract Set getEntries();

    protected AbstractMap() {
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return implFindEntry(key) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        Iterable<Map.Entry> $this$any$iv = entrySet();
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Map.Entry it : $this$any$iv) {
            if (Intrinsics.areEqual(it.getValue(), value)) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsEntry$kotlin_stdlib(@Nullable Map.Entry<?, ?> entry) {
        if (entry == null) {
            return false;
        }
        Object key = entry.getKey();
        Object value = entry.getValue();
        Object ourValue = get(key);
        if (!Intrinsics.areEqual(value, ourValue)) {
            return false;
        }
        if (ourValue != null || containsKey(key)) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map, java.lang.Object
    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!((other instanceof Map) && size() == ((Map) other).size())) {
            return false;
        }
        Iterable<Map.Entry> $this$all$iv = ((Map) other).entrySet();
        if (($this$all$iv instanceof Collection) && ((Collection) $this$all$iv).isEmpty()) {
            return true;
        }
        for (Map.Entry it : $this$all$iv) {
            if (!containsEntry$kotlin_stdlib(it)) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V get(Object key) {
        Map.Entry<K, V> implFindEntry = implFindEntry(key);
        if (implFindEntry != null) {
            return implFindEntry.getValue();
        }
        return null;
    }

    @Override // java.util.Map, java.lang.Object
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public int getSize() {
        return entrySet().size();
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: java.util.Set<? extends K>, java.util.Set<K>, java.lang.Object */
    @NotNull
    public Set<K> getKeys() {
        if (this._keys == null) {
            this._keys = new AbstractSet<K>(this) { // from class: kotlin.collections.AbstractMap$keys$1
                final /* synthetic */ AbstractMap<K, V> this$0;

                /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.collections.AbstractMap<K, ? extends V> */
                /* JADX WARN: Multi-variable type inference failed */
                /* access modifiers changed from: package-private */
                {
                    this.this$0 = r4;
                }

                @Override // kotlin.collections.AbstractCollection, java.util.Collection
                public boolean contains(Object element) {
                    return this.this$0.containsKey(element);
                }

                @Override // kotlin.collections.AbstractSet, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
                @NotNull
                public Iterator<K> iterator() {
                    return 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0018: RETURN  
                          (wrap: kotlin.collections.AbstractMap$keys$1$iterator$1 : 0x0015: CONSTRUCTOR  (r0v5 kotlin.collections.AbstractMap$keys$1$iterator$1 A[REMOVE]) = 
                          (wrap: java.util.Iterator : 0x0007: INVOKE  (r0v3 'entryIterator' java.util.Iterator A[REMOVE]) = 
                          (wrap: java.util.Set : 0x0004: INVOKE  (r0v2 java.util.Set A[REMOVE]) = 
                          (wrap: kotlin.collections.AbstractMap<K, V> : 0x0001: IGET  (r0v1 kotlin.collections.AbstractMap<K, V> A[REMOVE]) = 
                          (r4v0 'this' kotlin.collections.AbstractMap$keys$1 A[D('this' kotlin.collections.AbstractMap$keys$1), IMMUTABLE_TYPE, THIS])
                         kotlin.collections.AbstractMap$keys$1.this$0 kotlin.collections.AbstractMap)
                         type: VIRTUAL call: kotlin.collections.AbstractMap.entrySet():java.util.Set)
                         type: INTERFACE call: java.util.Set.iterator():java.util.Iterator)
                         call: kotlin.collections.AbstractMap$keys$1$iterator$1.<init>(java.util.Iterator):void type: CONSTRUCTOR)
                         in method: kotlin.collections.AbstractMap$keys$1.iterator():java.util.Iterator<K>, file: grasscutter.jar:kotlin/collections/AbstractMap$keys$1.class
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: kotlin.collections.AbstractMap$keys$1$iterator$1, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:259)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:675)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:393)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:343)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                        	... 15 more
                        */
                    /*
                        this = this;
                        r0 = r4
                        kotlin.collections.AbstractMap<K, V> r0 = r0.this$0
                        java.util.Set r0 = r0.entrySet()
                        java.util.Iterator r0 = r0.iterator()
                        r5 = r0
                        kotlin.collections.AbstractMap$keys$1$iterator$1 r0 = new kotlin.collections.AbstractMap$keys$1$iterator$1
                        r1 = r0
                        r2 = r5
                        r1.<init>(r2)
                        java.util.Iterator r0 = (java.util.Iterator) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.AbstractMap$keys$1.iterator():java.util.Iterator");
                }

                @Override // kotlin.collections.AbstractCollection
                public int getSize() {
                    return this.this$0.size();
                }
            };
        }
        Set set = (Set<? extends K>) this._keys;
        Intrinsics.checkNotNull(set);
        return set;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return CollectionsKt.joinToString$default(entrySet(), ", ", "{", "}", 0, null, new Function1<Map.Entry<? extends K, ? extends V>, CharSequence>(this) { // from class: kotlin.collections.AbstractMap$toString$1
            final /* synthetic */ AbstractMap<K, V> this$0;

            /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.collections.AbstractMap<K, ? extends V> */
            /* JADX WARN: Multi-variable type inference failed */
            /* access modifiers changed from: package-private */
            {
                this.this$0 = r4;
            }

            @NotNull
            public final CharSequence invoke(@NotNull Map.Entry<? extends K, ? extends V> entry) {
                Intrinsics.checkNotNullParameter(entry, "it");
                return AbstractMap.access$toString(this.this$0, entry);
            }
        }, 24, null);
    }

    /* access modifiers changed from: private */
    public final String toString(Map.Entry<? extends K, ? extends V> entry) {
        return toString(entry.getKey()) + '=' + toString(entry.getValue());
    }

    private final String toString(Object o) {
        return o == this ? "(this Map)" : String.valueOf(o);
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: java.util.Collection<? extends V>, java.util.Collection<V>, java.lang.Object */
    @NotNull
    public Collection<V> getValues() {
        if (this._values == null) {
            this._values = new AbstractCollection<V>(this) { // from class: kotlin.collections.AbstractMap$values$1
                final /* synthetic */ AbstractMap<K, V> this$0;

                /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.collections.AbstractMap<K, ? extends V> */
                /* JADX WARN: Multi-variable type inference failed */
                /* access modifiers changed from: package-private */
                {
                    this.this$0 = r4;
                }

                @Override // kotlin.collections.AbstractCollection, java.util.Collection
                public boolean contains(Object element) {
                    return this.this$0.containsValue(element);
                }

                @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
                @NotNull
                public Iterator<V> iterator() {
                    return 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0018: RETURN  
                          (wrap: kotlin.collections.AbstractMap$values$1$iterator$1 : 0x0015: CONSTRUCTOR  (r0v5 kotlin.collections.AbstractMap$values$1$iterator$1 A[REMOVE]) = 
                          (wrap: java.util.Iterator : 0x0007: INVOKE  (r0v3 'entryIterator' java.util.Iterator A[REMOVE]) = 
                          (wrap: java.util.Set : 0x0004: INVOKE  (r0v2 java.util.Set A[REMOVE]) = 
                          (wrap: kotlin.collections.AbstractMap<K, V> : 0x0001: IGET  (r0v1 kotlin.collections.AbstractMap<K, V> A[REMOVE]) = 
                          (r4v0 'this' kotlin.collections.AbstractMap$values$1 A[D('this' kotlin.collections.AbstractMap$values$1), IMMUTABLE_TYPE, THIS])
                         kotlin.collections.AbstractMap$values$1.this$0 kotlin.collections.AbstractMap)
                         type: VIRTUAL call: kotlin.collections.AbstractMap.entrySet():java.util.Set)
                         type: INTERFACE call: java.util.Set.iterator():java.util.Iterator)
                         call: kotlin.collections.AbstractMap$values$1$iterator$1.<init>(java.util.Iterator):void type: CONSTRUCTOR)
                         in method: kotlin.collections.AbstractMap$values$1.iterator():java.util.Iterator<V>, file: grasscutter.jar:kotlin/collections/AbstractMap$values$1.class
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: kotlin.collections.AbstractMap$values$1$iterator$1, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:259)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:675)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:393)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:343)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                        	... 15 more
                        */
                    /*
                        this = this;
                        r0 = r4
                        kotlin.collections.AbstractMap<K, V> r0 = r0.this$0
                        java.util.Set r0 = r0.entrySet()
                        java.util.Iterator r0 = r0.iterator()
                        r5 = r0
                        kotlin.collections.AbstractMap$values$1$iterator$1 r0 = new kotlin.collections.AbstractMap$values$1$iterator$1
                        r1 = r0
                        r2 = r5
                        r1.<init>(r2)
                        java.util.Iterator r0 = (java.util.Iterator) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.AbstractMap$values$1.iterator():java.util.Iterator");
                }

                @Override // kotlin.collections.AbstractCollection
                public int getSize() {
                    return this.this$0.size();
                }
            };
        }
        Collection collection = (Collection<? extends V>) this._values;
        Intrinsics.checkNotNull(collection);
        return collection;
    }

    private final Map.Entry<K, V> implFindEntry(K k) {
        Object obj;
        Iterator<T> it = entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            Object element$iv = it.next();
            if (Intrinsics.areEqual(((Map.Entry) element$iv).getKey(), k)) {
                obj = element$iv;
                break;
            }
        }
        return (Map.Entry) obj;
    }

    /* compiled from: AbstractMap.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��*\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000b\n��\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H��¢\u0006\u0002\b\bJ\u001d\u0010\t\u001a\u00020\n2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H��¢\u0006\u0002\b\u000bJ\u001d\u0010\f\u001a\u00020\r2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H��¢\u0006\u0002\b\u000e¨\u0006\u000f"}, m373d2 = {"Lkotlin/collections/AbstractMap$Companion;", "", "()V", "entryEquals", "", "e", "", "other", "entryEquals$kotlin_stdlib", "entryHashCode", "", "entryHashCode$kotlin_stdlib", "entryToString", "", "entryToString$kotlin_stdlib", "kotlin-stdlib"})
    /* loaded from: grasscutter.jar:kotlin/collections/AbstractMap$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        public final int entryHashCode$kotlin_stdlib(@NotNull Map.Entry<?, ?> entry) {
            Intrinsics.checkNotNullParameter(entry, "e");
            Object key = entry.getKey();
            int hashCode = key != null ? key.hashCode() : 0;
            Object value = entry.getValue();
            return hashCode ^ (value != null ? value.hashCode() : 0);
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : 0x0012: INVOKE  (r1v3 java.lang.Object A[REMOVE]) = (r4v0 java.util.Map$Entry<?, ?> A[D('e' java.util.Map$Entry)]) type: INTERFACE call: java.util.Map.Entry.getKey():java.lang.Object), ('=' char), (wrap: java.lang.Object : 0x0020: INVOKE  (r1v6 java.lang.Object A[REMOVE]) = (r4v0 java.util.Map$Entry<?, ?> A[D('e' java.util.Map$Entry)]) type: INTERFACE call: java.util.Map.Entry.getValue():java.lang.Object)] */
        @NotNull
        public final String entryToString$kotlin_stdlib(@NotNull Map.Entry<?, ?> entry) {
            Intrinsics.checkNotNullParameter(entry, "e");
            return new StringBuilder().append(entry.getKey()).append('=').append(entry.getValue()).toString();
        }

        public final boolean entryEquals$kotlin_stdlib(@NotNull Map.Entry<?, ?> entry, @Nullable Object other) {
            Intrinsics.checkNotNullParameter(entry, "e");
            return (other instanceof Map.Entry) && Intrinsics.areEqual(entry.getKey(), ((Map.Entry) other).getKey()) && Intrinsics.areEqual(entry.getValue(), ((Map.Entry) other).getValue());
        }
    }
}
