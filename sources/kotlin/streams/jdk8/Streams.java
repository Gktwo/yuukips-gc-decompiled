package kotlin.streams.jdk8;

import java.util.Iterator;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(m371mv = {1, 5, 1}, m372k = 2, m374d1 = {"��.\n��\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n��\u001a\u0012\u0010��\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u001a\u0012\u0010��\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005H\u0007\u001a\u0012\u0010��\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007\u001a\u001e\u0010��\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b��\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\tH\u0007\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\t\"\u0004\b��\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u0001H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f*\u00020\u0003H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f*\u00020\u0005H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f*\u00020\u0007H\u0007\u001a\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f\"\u0004\b��\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\tH\u0007¨\u0006\r"}, m373d2 = {"asSequence", "Lkotlin/sequences/Sequence;", "", "Ljava/util/stream/DoubleStream;", "", "Ljava/util/stream/IntStream;", "", "Ljava/util/stream/LongStream;", "T", "Ljava/util/stream/Stream;", "asStream", "toList", "", "kotlin-stdlib-jdk8"}, m370pn = "kotlin.streams")
@JvmName(name = "StreamsKt")
/* renamed from: kotlin.streams.jdk8.StreamsKt */
/* loaded from: grasscutter.jar:kotlin/streams/jdk8/StreamsKt.class */
public final class Streams {
    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> Sequence<T> asSequence(@NotNull Stream<T> stream) {
        Intrinsics.checkNotNullParameter(stream, "$this$asSequence");
        return new Sequence<T>(stream) { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$1
            final /* synthetic */ Stream $this_asSequence$inlined;

            {
                this.$this_asSequence$inlined = r4;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<T> iterator() {
                Iterator<T> it = this.$this_asSequence$inlined.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator()");
                return it;
            }
        };
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final Sequence<Integer> asSequence(@NotNull IntStream $this$asSequence) {
        Intrinsics.checkNotNullParameter($this$asSequence, "$this$asSequence");
        return new Sequence<Integer>($this$asSequence) { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$2
            final /* synthetic */ IntStream $this_asSequence$inlined;

            {
                this.$this_asSequence$inlined = r4;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Integer> iterator() {
                PrimitiveIterator.OfInt it = this.$this_asSequence$inlined.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator()");
                return it;
            }
        };
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final Sequence<Long> asSequence(@NotNull LongStream $this$asSequence) {
        Intrinsics.checkNotNullParameter($this$asSequence, "$this$asSequence");
        return new Sequence<Long>($this$asSequence) { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$3
            final /* synthetic */ LongStream $this_asSequence$inlined;

            {
                this.$this_asSequence$inlined = r4;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Long> iterator() {
                PrimitiveIterator.OfLong it = this.$this_asSequence$inlined.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator()");
                return it;
            }
        };
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final Sequence<Double> asSequence(@NotNull DoubleStream $this$asSequence) {
        Intrinsics.checkNotNullParameter($this$asSequence, "$this$asSequence");
        return new Sequence<Double>($this$asSequence) { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$4
            final /* synthetic */ DoubleStream $this_asSequence$inlined;

            {
                this.$this_asSequence$inlined = r4;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Double> iterator() {
                PrimitiveIterator.OfDouble it = this.$this_asSequence$inlined.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator()");
                return it;
            }
        };
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> Stream<T> asStream(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$asStream");
        Stream<T> stream = StreamSupport.stream(new Supplier(sequence) { // from class: kotlin.streams.jdk8.StreamsKt$asStream$1
            final /* synthetic */ Sequence $this_asStream;

            /* access modifiers changed from: package-private */
            {
                this.$this_asStream = r4;
            }

            @Override // java.util.function.Supplier
            public final Spliterator<T> get() {
                return Spliterators.spliteratorUnknownSize(this.$this_asStream.iterator(), 16);
            }
        }, 16, false);
        Intrinsics.checkNotNullExpressionValue(stream, "StreamSupport.stream({ S…literator.ORDERED, false)");
        return stream;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> List<T> toList(@NotNull Stream<T> stream) {
        Intrinsics.checkNotNullParameter(stream, "$this$toList");
        Object collect = stream.collect(Collectors.toList());
        Intrinsics.checkNotNullExpressionValue(collect, "collect(Collectors.toList<T>())");
        return (List) collect;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final List<Integer> toList(@NotNull IntStream $this$toList) {
        Intrinsics.checkNotNullParameter($this$toList, "$this$toList");
        int[] array = $this$toList.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "toArray()");
        return ArraysKt.asList(array);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final List<Long> toList(@NotNull LongStream $this$toList) {
        Intrinsics.checkNotNullParameter($this$toList, "$this$toList");
        long[] array = $this$toList.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "toArray()");
        return ArraysKt.asList(array);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final List<Double> toList(@NotNull DoubleStream $this$toList) {
        Intrinsics.checkNotNullParameter($this$toList, "$this$toList");
        double[] array = $this$toList.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "toArray()");
        return ArraysKt.asList(array);
    }
}
