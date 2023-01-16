package kotlin.p016io;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReadWrite.kt */
/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n��\b\u0002\u0018��2\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n��¨\u0006\b"}, m373d2 = {"Lkotlin/io/LinesSequence;", "Lkotlin/sequences/Sequence;", "", "reader", "Ljava/io/BufferedReader;", "(Ljava/io/BufferedReader;)V", "iterator", "", "kotlin-stdlib"})
/* renamed from: kotlin.io.LinesSequence */
/* loaded from: grasscutter.jar:kotlin/io/LinesSequence.class */
public final class LinesSequence implements Sequence<String> {
    @NotNull
    private final BufferedReader reader;

    public LinesSequence(@NotNull BufferedReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        this.reader = reader;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<String> iterator() {
        return new Object(this) { // from class: kotlin.io.LinesSequence$iterator$1
            @Nullable
            private String nextValue;
            private boolean done;
            final /* synthetic */ LinesSequence this$0;

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.nextValue == null && !this.done) {
                    this.nextValue = LinesSequence.access$getReader$p(this.this$0).readLine();
                    if (this.nextValue == null) {
                        this.done = true;
                    }
                }
                return this.nextValue != null;
            }

            @Override // java.util.Iterator
            @NotNull
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                String answer = this.nextValue;
                this.nextValue = null;
                Intrinsics.checkNotNull(answer);
                return answer;
            }
        };
    }
}
