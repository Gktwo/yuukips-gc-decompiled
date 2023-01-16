package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;

@Beta
/* loaded from: grasscutter.jar:com/google/common/hash/Funnels.class */
public final class Funnels {
    private Funnels() {
    }

    public static Funnel<byte[]> byteArrayFunnel() {
        return ByteArrayFunnel.INSTANCE;
    }

    /* loaded from: grasscutter.jar:com/google/common/hash/Funnels$ByteArrayFunnel.class */
    private enum ByteArrayFunnel implements Funnel<byte[]> {
        INSTANCE;

        public void funnel(byte[] from, PrimitiveSink into) {
            into.putBytes(from);
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return "Funnels.byteArrayFunnel()";
        }
    }

    public static Funnel<CharSequence> unencodedCharsFunnel() {
        return UnencodedCharsFunnel.INSTANCE;
    }

    /* loaded from: grasscutter.jar:com/google/common/hash/Funnels$UnencodedCharsFunnel.class */
    private enum UnencodedCharsFunnel implements Funnel<CharSequence> {
        INSTANCE;

        public void funnel(CharSequence from, PrimitiveSink into) {
            into.putUnencodedChars(from);
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return "Funnels.unencodedCharsFunnel()";
        }
    }

    public static Funnel<CharSequence> stringFunnel(Charset charset) {
        return new StringCharsetFunnel(charset);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/hash/Funnels$StringCharsetFunnel.class */
    public static class StringCharsetFunnel implements Funnel<CharSequence>, Serializable {
        private final Charset charset;

        StringCharsetFunnel(Charset charset) {
            this.charset = (Charset) Preconditions.checkNotNull(charset);
        }

        public void funnel(CharSequence from, PrimitiveSink into) {
            into.putString(from, this.charset);
        }

        @Override // java.lang.Object
        public String toString() {
            return "Funnels.stringFunnel(" + this.charset.name() + ")";
        }

        @Override // java.lang.Object
        public boolean equals(Object o) {
            if (o instanceof StringCharsetFunnel) {
                return this.charset.equals(((StringCharsetFunnel) o).charset);
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return StringCharsetFunnel.class.hashCode() ^ this.charset.hashCode();
        }

        Object writeReplace() {
            return new SerializedForm(this.charset);
        }

        /* loaded from: grasscutter.jar:com/google/common/hash/Funnels$StringCharsetFunnel$SerializedForm.class */
        private static class SerializedForm implements Serializable {
            private final String charsetCanonicalName;
            private static final long serialVersionUID = 0;

            SerializedForm(Charset charset) {
                this.charsetCanonicalName = charset.name();
            }

            private Object readResolve() {
                return Funnels.stringFunnel(Charset.forName(this.charsetCanonicalName));
            }
        }
    }

    public static Funnel<Integer> integerFunnel() {
        return IntegerFunnel.INSTANCE;
    }

    /* loaded from: grasscutter.jar:com/google/common/hash/Funnels$IntegerFunnel.class */
    private enum IntegerFunnel implements Funnel<Integer> {
        INSTANCE;

        public void funnel(Integer from, PrimitiveSink into) {
            into.putInt(from.intValue());
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return "Funnels.integerFunnel()";
        }
    }

    public static <E> Funnel<Iterable<? extends E>> sequentialFunnel(Funnel<E> elementFunnel) {
        return new SequentialFunnel(elementFunnel);
    }

    /* loaded from: grasscutter.jar:com/google/common/hash/Funnels$SequentialFunnel.class */
    private static class SequentialFunnel<E> implements Funnel<Iterable<? extends E>>, Serializable {
        private final Funnel<E> elementFunnel;

        @Override // com.google.common.hash.Funnel
        public /* bridge */ /* synthetic */ void funnel(Object obj, PrimitiveSink primitiveSink) {
            funnel((Iterable) ((Iterable) obj), primitiveSink);
        }

        SequentialFunnel(Funnel<E> elementFunnel) {
            this.elementFunnel = (Funnel) Preconditions.checkNotNull(elementFunnel);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: com.google.common.hash.Funnel<E> */
        /* JADX WARN: Multi-variable type inference failed */
        public void funnel(Iterable<? extends E> from, PrimitiveSink into) {
            Iterator<? extends E> it = from.iterator();
            while (it.hasNext()) {
                this.elementFunnel.funnel(it.next(), into);
            }
        }

        @Override // java.lang.Object
        public String toString() {
            return "Funnels.sequentialFunnel(" + this.elementFunnel + ")";
        }

        @Override // java.lang.Object
        public boolean equals(Object o) {
            if (o instanceof SequentialFunnel) {
                return this.elementFunnel.equals(((SequentialFunnel) o).elementFunnel);
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return SequentialFunnel.class.hashCode() ^ this.elementFunnel.hashCode();
        }
    }

    public static Funnel<Long> longFunnel() {
        return LongFunnel.INSTANCE;
    }

    /* loaded from: grasscutter.jar:com/google/common/hash/Funnels$LongFunnel.class */
    private enum LongFunnel implements Funnel<Long> {
        INSTANCE;

        public void funnel(Long from, PrimitiveSink into) {
            into.putLong(from.longValue());
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return "Funnels.longFunnel()";
        }
    }

    public static OutputStream asOutputStream(PrimitiveSink sink) {
        return new SinkAsStream(sink);
    }

    /* loaded from: grasscutter.jar:com/google/common/hash/Funnels$SinkAsStream.class */
    private static class SinkAsStream extends OutputStream {
        final PrimitiveSink sink;

        SinkAsStream(PrimitiveSink sink) {
            this.sink = (PrimitiveSink) Preconditions.checkNotNull(sink);
        }

        @Override // java.io.OutputStream
        public void write(int b) {
            this.sink.putByte((byte) b);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bytes) {
            this.sink.putBytes(bytes);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bytes, int off, int len) {
            this.sink.putBytes(bytes, off, len);
        }

        @Override // java.lang.Object
        public String toString() {
            return "Funnels.asOutputStream(" + this.sink + ")";
        }
    }
}
