package kotlin.collections;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p001ch.qos.logback.core.joran.action.Action;

/* compiled from: Grouping.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 5, m369xi = 49, m374d1 = {"��@\n��\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0001\u0010��\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b��\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052b\u0010\u0006\u001a^\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u0002H\u00030\u0007H\bø\u0001��\u001a·\u0001\u0010\u000f\u001a\u0002H\u0010\"\u0004\b��\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b��\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u00102b\u0010\u0006\u001a^\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u0002H\u00030\u0007H\bø\u0001��¢\u0006\u0002\u0010\u0013\u001aI\u0010\u0014\u001a\u0002H\u0010\"\u0004\b��\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0016\b\u0002\u0010\u0010*\u0010\u0012\u0006\b��\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00150\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u0010H\u0007¢\u0006\u0002\u0010\u0016\u001a¿\u0001\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b��\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u000526\u0010\u0018\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u00192K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u001aH\bø\u0001��\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b��\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u001b\u001a\u0002H\u000326\u0010\u0006\u001a2\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u0019H\bø\u0001��¢\u0006\u0002\u0010\u001c\u001aØ\u0001\u0010\u001d\u001a\u0002H\u0010\"\u0004\b��\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b��\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u001026\u0010\u0018\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u00192K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u001aH\bø\u0001��¢\u0006\u0002\u0010\u001e\u001a\u0001\u0010\u001d\u001a\u0002H\u0010\"\u0004\b��\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b��\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u00102\u0006\u0010\u001b\u001a\u0002H\u000326\u0010\u0006\u001a2\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u0019H\bø\u0001��¢\u0006\u0002\u0010\u001f\u001a\u0001\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0\u0001\"\u0004\b��\u0010!\"\b\b\u0001\u0010\u0004*\u0002H!\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H!¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H!0\u001aH\bø\u0001��\u001a¤\u0001\u0010\"\u001a\u0002H\u0010\"\u0004\b��\u0010!\"\b\b\u0001\u0010\u0004*\u0002H!\"\u0004\b\u0002\u0010\u0002\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b��\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u00102K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H!¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H!0\u001aH\bø\u0001��¢\u0006\u0002\u0010#\u0002\u0007\n\u0005\b20\u0001¨\u0006$"}, m373d2 = {"aggregate", "", "K", "R", "T", "Lkotlin/collections/Grouping;", "operation", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", Action.KEY_ATTRIBUTE, "accumulator", "element", "", "first", "aggregateTo", "M", "", "destination", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function4;)Ljava/util/Map;", "eachCountTo", "", "(Lkotlin/collections/Grouping;Ljava/util/Map;)Ljava/util/Map;", "fold", "initialValueSelector", "Lkotlin/Function2;", "Lkotlin/Function3;", "initialValue", "(Lkotlin/collections/Grouping;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "foldTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "(Lkotlin/collections/Grouping;Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "reduce", "S", "reduceTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "kotlin-stdlib"}, m368xs = "kotlin/collections/GroupingKt")
/* loaded from: grasscutter.jar:kotlin/collections/GroupingKt__GroupingKt.class */
class GroupingKt__GroupingKt extends GroupingJVM {
    /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: ? super K */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, K, R> java.util.Map<K, R> aggregate(@org.jetbrains.annotations.NotNull kotlin.collections.Grouping<T, ? extends K> r9, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function4<? super K, ? super R, ? super T, ? super java.lang.Boolean, ? extends R> r10) {
        /*
            r0 = r9
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r10
            java.lang.String r1 = "operation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = 0
            r11 = r0
            r0 = r9
            r12 = r0
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r1 = r0
            r1.<init>()
            java.util.Map r0 = (java.util.Map) r0
            r13 = r0
            r0 = 0
            r14 = r0
            r0 = r12
            java.util.Iterator r0 = r0.sourceIterator()
            r15 = r0
        L_0x0028:
            r0 = r15
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0082
            r0 = r15
            java.lang.Object r0 = r0.next()
            r16 = r0
            r0 = r12
            r1 = r16
            java.lang.Object r0 = r0.keyOf(r1)
            r17 = r0
            r0 = r13
            r1 = r17
            java.lang.Object r0 = r0.get(r1)
            r18 = r0
            r0 = r13
            r1 = r17
            r2 = r10
            r3 = r17
            r4 = r18
            r5 = r16
            r6 = r18
            if (r6 != 0) goto L_0x0070
            r6 = r13
            r7 = r17
            boolean r6 = r6.containsKey(r7)
            if (r6 != 0) goto L_0x0070
            r6 = 1
            goto L_0x0071
        L_0x0070:
            r6 = 0
        L_0x0071:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            java.lang.Object r2 = r2.invoke(r3, r4, r5, r6)
            java.lang.Object r0 = r0.put(r1, r2)
            goto L_0x0028
        L_0x0082:
            r0 = r13
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.GroupingKt__GroupingKt.aggregate(kotlin.collections.Grouping, kotlin.jvm.functions.Function4):java.util.Map");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: ? super K */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, K, R, M extends java.util.Map<? super K, R>> M aggregateTo(@org.jetbrains.annotations.NotNull kotlin.collections.Grouping<T, ? extends K> r9, @org.jetbrains.annotations.NotNull M r10, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function4<? super K, ? super R, ? super T, ? super java.lang.Boolean, ? extends R> r11) {
        /*
            r0 = r9
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r10
            java.lang.String r1 = "destination"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r11
            java.lang.String r1 = "operation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = 0
            r12 = r0
            r0 = r9
            java.util.Iterator r0 = r0.sourceIterator()
            r13 = r0
        L_0x001c:
            r0 = r13
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0073
            r0 = r13
            java.lang.Object r0 = r0.next()
            r14 = r0
            r0 = r9
            r1 = r14
            java.lang.Object r0 = r0.keyOf(r1)
            r15 = r0
            r0 = r10
            r1 = r15
            java.lang.Object r0 = r0.get(r1)
            r16 = r0
            r0 = r10
            r1 = r15
            r2 = r11
            r3 = r15
            r4 = r16
            r5 = r14
            r6 = r16
            if (r6 != 0) goto L_0x0061
            r6 = r10
            r7 = r15
            boolean r6 = r6.containsKey(r7)
            if (r6 != 0) goto L_0x0061
            r6 = 1
            goto L_0x0062
        L_0x0061:
            r6 = 0
        L_0x0062:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            java.lang.Object r2 = r2.invoke(r3, r4, r5, r6)
            java.lang.Object r0 = r0.put(r1, r2)
            goto L_0x001c
        L_0x0073:
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.GroupingKt__GroupingKt.aggregateTo(kotlin.collections.Grouping, java.util.Map, kotlin.jvm.functions.Function4):java.util.Map");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v18, resolved type: ? super K */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, K, R> java.util.Map<K, R> fold(@org.jetbrains.annotations.NotNull kotlin.collections.Grouping<T, ? extends K> r8, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super K, ? super T, ? extends R> r9, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super K, ? super R, ? super T, ? extends R> r10) {
        /*
            r0 = r8
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r9
            java.lang.String r1 = "initialValueSelector"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r10
            java.lang.String r1 = "operation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = 0
            r11 = r0
            r0 = r8
            r12 = r0
            r0 = 0
            r13 = r0
            r0 = r12
            r14 = r0
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r1 = r0
            r1.<init>()
            java.util.Map r0 = (java.util.Map) r0
            r15 = r0
            r0 = 0
            r16 = r0
            r0 = r14
            java.util.Iterator r0 = r0.sourceIterator()
            r17 = r0
        L_0x0037:
            r0 = r17
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00be
            r0 = r17
            java.lang.Object r0 = r0.next()
            r18 = r0
            r0 = r14
            r1 = r18
            java.lang.Object r0 = r0.keyOf(r1)
            r19 = r0
            r0 = r15
            r1 = r19
            java.lang.Object r0 = r0.get(r1)
            r20 = r0
            r0 = r15
            r1 = r19
            r2 = r19
            r3 = r20
            r4 = r18
            r5 = r20
            if (r5 != 0) goto L_0x007f
            r5 = r15
            r6 = r19
            boolean r5 = r5.containsKey(r6)
            if (r5 != 0) goto L_0x007f
            r5 = 1
            goto L_0x0080
        L_0x007f:
            r5 = 0
        L_0x0080:
            r21 = r5
            r22 = r4
            r23 = r3
            r24 = r2
            r27 = r1
            r26 = r0
            r0 = 0
            r25 = r0
            r0 = r10
            r1 = r24
            r2 = r21
            if (r2 == 0) goto L_0x00a4
            r2 = r9
            r3 = r24
            r4 = r22
            java.lang.Object r2 = r2.invoke(r3, r4)
            goto L_0x00a6
        L_0x00a4:
            r2 = r23
        L_0x00a6:
            r3 = r22
            java.lang.Object r0 = r0.invoke(r1, r2, r3)
            r28 = r0
            r0 = r26
            r1 = r27
            r2 = r28
            java.lang.Object r0 = r0.put(r1, r2)
            goto L_0x0037
        L_0x00be:
            r0 = r15
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.GroupingKt__GroupingKt.fold(kotlin.collections.Grouping, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3):java.util.Map");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: ? super K */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, K, R, M extends java.util.Map<? super K, R>> M foldTo(@org.jetbrains.annotations.NotNull kotlin.collections.Grouping<T, ? extends K> r8, @org.jetbrains.annotations.NotNull M r9, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super K, ? super T, ? extends R> r10, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super K, ? super R, ? super T, ? extends R> r11) {
        /*
            r0 = r8
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r9
            java.lang.String r1 = "destination"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r10
            java.lang.String r1 = "initialValueSelector"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r11
            java.lang.String r1 = "operation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = 0
            r12 = r0
            r0 = r8
            r13 = r0
            r0 = 0
            r14 = r0
            r0 = r13
            java.util.Iterator r0 = r0.sourceIterator()
            r15 = r0
        L_0x002a:
            r0 = r15
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00ae
            r0 = r15
            java.lang.Object r0 = r0.next()
            r16 = r0
            r0 = r13
            r1 = r16
            java.lang.Object r0 = r0.keyOf(r1)
            r17 = r0
            r0 = r9
            r1 = r17
            java.lang.Object r0 = r0.get(r1)
            r18 = r0
            r0 = r9
            r1 = r17
            r2 = r17
            r3 = r18
            r4 = r16
            r5 = r18
            if (r5 != 0) goto L_0x006f
            r5 = r9
            r6 = r17
            boolean r5 = r5.containsKey(r6)
            if (r5 != 0) goto L_0x006f
            r5 = 1
            goto L_0x0070
        L_0x006f:
            r5 = 0
        L_0x0070:
            r19 = r5
            r20 = r4
            r21 = r3
            r22 = r2
            r25 = r1
            r24 = r0
            r0 = 0
            r23 = r0
            r0 = r11
            r1 = r22
            r2 = r19
            if (r2 == 0) goto L_0x0094
            r2 = r10
            r3 = r22
            r4 = r20
            java.lang.Object r2 = r2.invoke(r3, r4)
            goto L_0x0096
        L_0x0094:
            r2 = r21
        L_0x0096:
            r3 = r20
            java.lang.Object r0 = r0.invoke(r1, r2, r3)
            r26 = r0
            r0 = r24
            r1 = r25
            r2 = r26
            java.lang.Object r0 = r0.put(r1, r2)
            goto L_0x002a
        L_0x00ae:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.GroupingKt__GroupingKt.foldTo(kotlin.collections.Grouping, java.util.Map, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3):java.util.Map");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, K, R> java.util.Map<K, R> fold(@org.jetbrains.annotations.NotNull kotlin.collections.Grouping<T, ? extends K> r7, R r8, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super T, ? extends R> r9) {
        /*
            r0 = r7
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r9
            java.lang.String r1 = "operation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = 0
            r10 = r0
            r0 = r7
            r11 = r0
            r0 = 0
            r12 = r0
            r0 = r11
            r13 = r0
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r1 = r0
            r1.<init>()
            java.util.Map r0 = (java.util.Map) r0
            r14 = r0
            r0 = 0
            r15 = r0
            r0 = r13
            java.util.Iterator r0 = r0.sourceIterator()
            r16 = r0
        L_0x0031:
            r0 = r16
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00a9
            r0 = r16
            java.lang.Object r0 = r0.next()
            r17 = r0
            r0 = r13
            r1 = r17
            java.lang.Object r0 = r0.keyOf(r1)
            r18 = r0
            r0 = r14
            r1 = r18
            java.lang.Object r0 = r0.get(r1)
            r19 = r0
            r0 = r14
            r1 = r18
            r2 = r19
            r3 = r17
            r4 = r19
            if (r4 != 0) goto L_0x0077
            r4 = r14
            r5 = r18
            boolean r4 = r4.containsKey(r5)
            if (r4 != 0) goto L_0x0077
            r4 = 1
            goto L_0x0078
        L_0x0077:
            r4 = 0
        L_0x0078:
            r20 = r4
            r21 = r3
            r22 = r2
            r25 = r1
            r24 = r0
            r0 = 0
            r23 = r0
            r0 = r9
            r1 = r20
            if (r1 == 0) goto L_0x008f
            r1 = r8
            goto L_0x0091
        L_0x008f:
            r1 = r22
        L_0x0091:
            r2 = r21
            java.lang.Object r0 = r0.invoke(r1, r2)
            r26 = r0
            r0 = r24
            r1 = r25
            r2 = r26
            java.lang.Object r0 = r0.put(r1, r2)
            goto L_0x0031
        L_0x00a9:
            r0 = r14
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.GroupingKt__GroupingKt.fold(kotlin.collections.Grouping, java.lang.Object, kotlin.jvm.functions.Function2):java.util.Map");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: M extends java.util.Map<? super K, R> */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R, M extends Map<? super K, R>> M foldTo(@NotNull Grouping<T, ? extends K> grouping, @NotNull M m, R r, @NotNull Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(grouping, "<this>");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function2, "operation");
        Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            T next = sourceIterator.next();
            Object key$iv = grouping.keyOf(next);
            Object accumulator$iv = m.get(key$iv);
            m.put(key$iv, function2.invoke(accumulator$iv == null && !m.containsKey(key$iv) ? r : accumulator$iv, next));
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v17, resolved type: ? super K */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S, T extends S, K> java.util.Map<K, S> reduce(@org.jetbrains.annotations.NotNull kotlin.collections.Grouping<T, ? extends K> r8, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super K, ? super S, ? super T, ? extends S> r9) {
        /*
            r0 = r8
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r9
            java.lang.String r1 = "operation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = 0
            r10 = r0
            r0 = r8
            r11 = r0
            r0 = 0
            r12 = r0
            r0 = r11
            r13 = r0
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r1 = r0
            r1.<init>()
            java.util.Map r0 = (java.util.Map) r0
            r14 = r0
            r0 = 0
            r15 = r0
            r0 = r13
            java.util.Iterator r0 = r0.sourceIterator()
            r16 = r0
        L_0x002f:
            r0 = r16
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00ae
            r0 = r16
            java.lang.Object r0 = r0.next()
            r17 = r0
            r0 = r13
            r1 = r17
            java.lang.Object r0 = r0.keyOf(r1)
            r18 = r0
            r0 = r14
            r1 = r18
            java.lang.Object r0 = r0.get(r1)
            r19 = r0
            r0 = r14
            r1 = r18
            r2 = r18
            r3 = r19
            r4 = r17
            r5 = r19
            if (r5 != 0) goto L_0x0077
            r5 = r14
            r6 = r18
            boolean r5 = r5.containsKey(r6)
            if (r5 != 0) goto L_0x0077
            r5 = 1
            goto L_0x0078
        L_0x0077:
            r5 = 0
        L_0x0078:
            r20 = r5
            r21 = r4
            r22 = r3
            r23 = r2
            r26 = r1
            r25 = r0
            r0 = 0
            r24 = r0
            r0 = r20
            if (r0 == 0) goto L_0x0091
            r0 = r21
            goto L_0x009d
        L_0x0091:
            r0 = r9
            r1 = r23
            r2 = r22
            r3 = r21
            java.lang.Object r0 = r0.invoke(r1, r2, r3)
        L_0x009d:
            r27 = r0
            r0 = r25
            r1 = r26
            r2 = r27
            java.lang.Object r0 = r0.put(r1, r2)
            goto L_0x002f
        L_0x00ae:
            r0 = r14
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.GroupingKt__GroupingKt.reduce(kotlin.collections.Grouping, kotlin.jvm.functions.Function3):java.util.Map");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: ? super K */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S, T extends S, K, M extends java.util.Map<? super K, S>> M reduceTo(@org.jetbrains.annotations.NotNull kotlin.collections.Grouping<T, ? extends K> r8, @org.jetbrains.annotations.NotNull M r9, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super K, ? super S, ? super T, ? extends S> r10) {
        /*
            r0 = r8
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r9
            java.lang.String r1 = "destination"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r10
            java.lang.String r1 = "operation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = 0
            r11 = r0
            r0 = r8
            r12 = r0
            r0 = 0
            r13 = r0
            r0 = r12
            java.util.Iterator r0 = r0.sourceIterator()
            r14 = r0
        L_0x0023:
            r0 = r14
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x009f
            r0 = r14
            java.lang.Object r0 = r0.next()
            r15 = r0
            r0 = r12
            r1 = r15
            java.lang.Object r0 = r0.keyOf(r1)
            r16 = r0
            r0 = r9
            r1 = r16
            java.lang.Object r0 = r0.get(r1)
            r17 = r0
            r0 = r9
            r1 = r16
            r2 = r16
            r3 = r17
            r4 = r15
            r5 = r17
            if (r5 != 0) goto L_0x0068
            r5 = r9
            r6 = r16
            boolean r5 = r5.containsKey(r6)
            if (r5 != 0) goto L_0x0068
            r5 = 1
            goto L_0x0069
        L_0x0068:
            r5 = 0
        L_0x0069:
            r18 = r5
            r19 = r4
            r20 = r3
            r21 = r2
            r24 = r1
            r23 = r0
            r0 = 0
            r22 = r0
            r0 = r18
            if (r0 == 0) goto L_0x0082
            r0 = r19
            goto L_0x008e
        L_0x0082:
            r0 = r10
            r1 = r21
            r2 = r20
            r3 = r19
            java.lang.Object r0 = r0.invoke(r1, r2, r3)
        L_0x008e:
            r25 = r0
            r0 = r23
            r1 = r24
            r2 = r25
            java.lang.Object r0 = r0.put(r1, r2)
            goto L_0x0023
        L_0x009f:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.GroupingKt__GroupingKt.reduceTo(kotlin.collections.Grouping, java.util.Map, kotlin.jvm.functions.Function3):java.util.Map");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: M extends java.util.Map<? super K, java.lang.Integer> */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, M extends Map<? super K, Integer>> M eachCountTo(@NotNull Grouping<T, ? extends K> grouping, @NotNull M m) {
        Intrinsics.checkNotNullParameter(grouping, "<this>");
        Intrinsics.checkNotNullParameter(m, "destination");
        Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            Object key$iv$iv = grouping.keyOf(sourceIterator.next());
            Object accumulator$iv$iv = m.get(key$iv$iv);
            m.put(key$iv$iv, Integer.valueOf(((Number) (accumulator$iv$iv == null && !m.containsKey(key$iv$iv) ? 0 : accumulator$iv$iv)).intValue() + 1));
        }
        return m;
    }
}
