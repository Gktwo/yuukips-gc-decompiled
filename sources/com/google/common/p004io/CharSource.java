package com.google.common.p004io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Streams;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.MustBeClosed;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;
import kotlin.jvm.internal.LongCompanionObject;

@GwtIncompatible
/* renamed from: com.google.common.io.CharSource */
/* loaded from: grasscutter.jar:com/google/common/io/CharSource.class */
public abstract class CharSource {
    public abstract Reader openStream() throws IOException;

    @Beta
    public ByteSource asByteSource(Charset charset) {
        return new AsByteSource(charset);
    }

    public BufferedReader openBufferedStream() throws IOException {
        Reader reader = openStream();
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
    }

    @Beta
    @MustBeClosed
    public Stream<String> lines() throws IOException {
        BufferedReader reader = openBufferedStream();
        return (Stream) reader.lines().onClose(() -> {
            try {
                reader.close();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        });
    }

    @Beta
    public Optional<Long> lengthIfKnown() {
        return Optional.absent();
    }

    @Beta
    public long length() throws IOException {
        Optional<Long> lengthIfKnown = lengthIfKnown();
        if (lengthIfKnown.isPresent()) {
            return lengthIfKnown.get().longValue();
        }
        Closer closer = Closer.create();
        try {
            long countBySkipping = countBySkipping((Reader) closer.register(openStream()));
            closer.close();
            return countBySkipping;
        } catch (Throwable th) {
            closer.close();
            throw th;
        }
    }

    private long countBySkipping(Reader reader) throws IOException {
        long count = 0;
        while (true) {
            long read = reader.skip(LongCompanionObject.MAX_VALUE);
            if (read == 0) {
                return count;
            }
            count += read;
        }
    }

    @CanIgnoreReturnValue
    public long copyTo(Appendable appendable) throws IOException {
        Preconditions.checkNotNull(appendable);
        Closer closer = Closer.create();
        try {
            long copy = CharStreams.copy((Reader) closer.register(openStream()), appendable);
            closer.close();
            return copy;
        } catch (Throwable th) {
            closer.close();
            throw th;
        }
    }

    @CanIgnoreReturnValue
    public long copyTo(CharSink sink) throws IOException {
        Preconditions.checkNotNull(sink);
        Closer closer = Closer.create();
        try {
            long copy = CharStreams.copy((Reader) closer.register(openStream()), (Writer) closer.register(sink.openStream()));
            closer.close();
            return copy;
        } catch (Throwable th) {
            closer.close();
            throw th;
        }
    }

    public String read() throws IOException {
        Closer closer = Closer.create();
        try {
            String charStreams = CharStreams.toString((Reader) closer.register(openStream()));
            closer.close();
            return charStreams;
        } catch (Throwable th) {
            closer.close();
            throw th;
        }
    }

    public String readFirstLine() throws IOException {
        Closer closer = Closer.create();
        try {
            String readLine = ((BufferedReader) closer.register(openBufferedStream())).readLine();
            closer.close();
            return readLine;
        } catch (Throwable th) {
            closer.close();
            throw th;
        }
    }

    public ImmutableList<String> readLines() throws IOException {
        Closer closer = Closer.create();
        try {
            BufferedReader reader = (BufferedReader) closer.register(openBufferedStream());
            List<String> result = Lists.newArrayList();
            while (true) {
                String line = reader.readLine();
                if (line != null) {
                    result.add(line);
                } else {
                    ImmutableList<String> copyOf = ImmutableList.copyOf((Collection) result);
                    closer.close();
                    return copyOf;
                }
            }
        } catch (Throwable th) {
            closer.close();
            throw th;
        }
    }

    @CanIgnoreReturnValue
    @Beta
    public <T> T readLines(LineProcessor<T> processor) throws IOException {
        Preconditions.checkNotNull(processor);
        Closer closer = Closer.create();
        try {
            T t = (T) CharStreams.readLines((Reader) closer.register(openStream()), processor);
            closer.close();
            return t;
        } catch (Throwable th) {
            closer.close();
            throw th;
        }
    }

    @Beta
    public void forEachLine(Consumer<? super String> action) throws IOException {
        try {
            Stream<String> lines = lines();
            lines.forEachOrdered(action);
            if (lines != null) {
                if (0 != 0) {
                    lines.close();
                } else {
                    lines.close();
                }
            }
        } catch (UncheckedIOException e) {
            throw e.getCause();
        }
    }

    public boolean isEmpty() throws IOException {
        Optional<Long> lengthIfKnown = lengthIfKnown();
        if (lengthIfKnown.isPresent()) {
            return lengthIfKnown.get().longValue() == 0;
        }
        Closer closer = Closer.create();
        try {
            return ((Reader) closer.register(openStream())).read() == -1;
        } finally {
            closer.close();
        }
    }

    public static CharSource concat(Iterable<? extends CharSource> sources) {
        return new ConcatenatedCharSource(sources);
    }

    public static CharSource concat(Iterator<? extends CharSource> sources) {
        return concat(ImmutableList.copyOf(sources));
    }

    public static CharSource concat(CharSource... sources) {
        return concat(ImmutableList.copyOf(sources));
    }

    public static CharSource wrap(CharSequence charSequence) {
        return charSequence instanceof String ? new StringCharSource((String) charSequence) : new CharSequenceCharSource(charSequence);
    }

    public static CharSource empty() {
        return EmptyCharSource.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: com.google.common.io.CharSource$AsByteSource */
    /* loaded from: grasscutter.jar:com/google/common/io/CharSource$AsByteSource.class */
    public final class AsByteSource extends ByteSource {
        final Charset charset;

        AsByteSource(Charset charset) {
            this.charset = (Charset) Preconditions.checkNotNull(charset);
        }

        @Override // com.google.common.p004io.ByteSource
        public CharSource asCharSource(Charset charset) {
            if (charset.equals(this.charset)) {
                return CharSource.this;
            }
            return asCharSource(charset);
        }

        @Override // com.google.common.p004io.ByteSource
        public InputStream openStream() throws IOException {
            return new ReaderInputStream(CharSource.this.openStream(), this.charset, 8192);
        }

        public String toString() {
            return CharSource.this.toString() + ".asByteSource(" + this.charset + ")";
        }
    }

    /* renamed from: com.google.common.io.CharSource$CharSequenceCharSource */
    /* loaded from: grasscutter.jar:com/google/common/io/CharSource$CharSequenceCharSource.class */
    private static class CharSequenceCharSource extends CharSource {
        private static final Splitter LINE_SPLITTER = Splitter.onPattern("\r\n|\n|\r");
        protected final CharSequence seq;

        protected CharSequenceCharSource(CharSequence seq) {
            this.seq = (CharSequence) Preconditions.checkNotNull(seq);
        }

        @Override // com.google.common.p004io.CharSource
        public Reader openStream() {
            return new CharSequenceReader(this.seq);
        }

        @Override // com.google.common.p004io.CharSource
        public String read() {
            return this.seq.toString();
        }

        @Override // com.google.common.p004io.CharSource
        public boolean isEmpty() {
            return this.seq.length() == 0;
        }

        @Override // com.google.common.p004io.CharSource
        public long length() {
            return (long) this.seq.length();
        }

        @Override // com.google.common.p004io.CharSource
        public Optional<Long> lengthIfKnown() {
            return Optional.m1463of(Long.valueOf((long) this.seq.length()));
        }

        private Iterator<String> linesIterator() {
            return new AbstractIterator<String>() { // from class: com.google.common.io.CharSource.CharSequenceCharSource.1
                Iterator<String> lines;

                {
                    this.lines = CharSequenceCharSource.LINE_SPLITTER.split(CharSequenceCharSource.this.seq).iterator();
                }

                /* access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                public String computeNext() {
                    if (this.lines.hasNext()) {
                        String next = this.lines.next();
                        if (this.lines.hasNext() || !next.isEmpty()) {
                            return next;
                        }
                    }
                    return endOfData();
                }
            };
        }

        @Override // com.google.common.p004io.CharSource
        public Stream<String> lines() {
            return Streams.stream(linesIterator());
        }

        @Override // com.google.common.p004io.CharSource
        public String readFirstLine() {
            Iterator<String> lines = linesIterator();
            if (lines.hasNext()) {
                return lines.next();
            }
            return null;
        }

        @Override // com.google.common.p004io.CharSource
        public ImmutableList<String> readLines() {
            return ImmutableList.copyOf(linesIterator());
        }

        @Override // com.google.common.p004io.CharSource
        public <T> T readLines(LineProcessor<T> processor) throws IOException {
            Iterator<String> lines = linesIterator();
            while (lines.hasNext() && processor.processLine(lines.next())) {
            }
            return processor.getResult();
        }

        public String toString() {
            return "CharSource.wrap(" + Ascii.truncate(this.seq, 30, "...") + ")";
        }
    }

    /* renamed from: com.google.common.io.CharSource$StringCharSource */
    /* loaded from: grasscutter.jar:com/google/common/io/CharSource$StringCharSource.class */
    private static class StringCharSource extends CharSequenceCharSource {
        protected StringCharSource(String seq) {
            super(seq);
        }

        @Override // com.google.common.p004io.CharSource.CharSequenceCharSource, com.google.common.p004io.CharSource
        public Reader openStream() {
            return new StringReader((String) this.seq);
        }

        @Override // com.google.common.p004io.CharSource
        public long copyTo(Appendable appendable) throws IOException {
            appendable.append(this.seq);
            return (long) this.seq.length();
        }

        @Override // com.google.common.p004io.CharSource
        public long copyTo(CharSink sink) throws IOException {
            Preconditions.checkNotNull(sink);
            Closer closer = Closer.create();
            try {
                ((Writer) closer.register(sink.openStream())).write((String) this.seq);
                long length = (long) this.seq.length();
                closer.close();
                return length;
            } catch (Throwable th) {
                closer.close();
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.google.common.io.CharSource$EmptyCharSource */
    /* loaded from: grasscutter.jar:com/google/common/io/CharSource$EmptyCharSource.class */
    public static final class EmptyCharSource extends StringCharSource {
        private static final EmptyCharSource INSTANCE = new EmptyCharSource();

        private EmptyCharSource() {
            super("");
        }

        @Override // com.google.common.p004io.CharSource.CharSequenceCharSource
        public String toString() {
            return "CharSource.empty()";
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.google.common.io.CharSource$ConcatenatedCharSource */
    /* loaded from: grasscutter.jar:com/google/common/io/CharSource$ConcatenatedCharSource.class */
    public static final class ConcatenatedCharSource extends CharSource {
        private final Iterable<? extends CharSource> sources;

        ConcatenatedCharSource(Iterable<? extends CharSource> sources) {
            this.sources = (Iterable) Preconditions.checkNotNull(sources);
        }

        @Override // com.google.common.p004io.CharSource
        public Reader openStream() throws IOException {
            return new MultiReader(this.sources.iterator());
        }

        @Override // com.google.common.p004io.CharSource
        public boolean isEmpty() throws IOException {
            for (CharSource source : this.sources) {
                if (!source.isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARN: Type inference failed for: r0v18, types: [long] */
        @Override // com.google.common.p004io.CharSource
        public Optional<Long> lengthIfKnown() {
            char c = 0;
            for (CharSource source : this.sources) {
                Optional<Long> lengthIfKnown = source.lengthIfKnown();
                if (!lengthIfKnown.isPresent()) {
                    return Optional.absent();
                }
                c += lengthIfKnown.get().longValue();
            }
            return Optional.m1463of(Long.valueOf(c));
        }

        /* JADX WARN: Type inference failed for: r0v11, types: [long] */
        @Override // com.google.common.p004io.CharSource
        public long length() throws IOException {
            char c = 0;
            for (CharSource source : this.sources) {
                c += source.length();
            }
            return c;
        }

        public String toString() {
            return "CharSource.concat(" + this.sources + ")";
        }
    }
}
