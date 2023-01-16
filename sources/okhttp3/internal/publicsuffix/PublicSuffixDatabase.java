package okhttp3.internal.publicsuffix;

import dev.morphia.mapping.Mapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p016io.Closeable;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: PublicSuffixDatabase.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��4\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018�� \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\u0006X.¢\u0006\u0002\n��R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n��¨\u0006\u0016"}, m373d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "()V", "listRead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "publicSuffixExceptionListBytes", "", "publicSuffixListBytes", "readCompleteLatch", "Ljava/util/concurrent/CountDownLatch;", "findMatchingRule", "", "", "domainLabels", "getEffectiveTldPlusOne", "domain", "readTheList", "", "readTheListUninterruptibly", "setListBytes", "splitDomain", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/publicsuffix/PublicSuffixDatabase.class */
public final class PublicSuffixDatabase {
    @NotNull
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    @NotNull
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);
    private byte[] publicSuffixListBytes;
    private byte[] publicSuffixExceptionListBytes;
    @NotNull
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private static final char EXCEPTION_MARKER = '!';
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final byte[] WILDCARD_LABEL = {42};
    @NotNull
    private static final List<String> PREVAILING_RULE = CollectionsKt.listOf("*");
    @NotNull
    private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();

    @Nullable
    public final String getEffectiveTldPlusOne(@NotNull String domain) {
        int firstLabelOffset;
        Intrinsics.checkNotNullParameter(domain, "domain");
        String unicodeDomain = IDN.toUnicode(domain);
        Intrinsics.checkNotNullExpressionValue(unicodeDomain, "unicodeDomain");
        List domainLabels = splitDomain(unicodeDomain);
        List rule = findMatchingRule(domainLabels);
        if (domainLabels.size() == rule.size() && rule.get(0).charAt(0) != '!') {
            return null;
        }
        if (rule.get(0).charAt(0) == '!') {
            firstLabelOffset = domainLabels.size() - rule.size();
        } else {
            firstLabelOffset = domainLabels.size() - (rule.size() + 1);
        }
        return SequencesKt.joinToString$default(SequencesKt.drop(CollectionsKt.asSequence(splitDomain(domain)), firstLabelOffset), Mapper.IGNORED_FIELDNAME, null, null, 0, null, null, 62, null);
    }

    private final List<String> splitDomain(String domain) {
        List domainLabels = StringsKt.split$default((CharSequence) domain, new char[]{'.'}, false, 0, 6, (Object) null);
        if (Intrinsics.areEqual(CollectionsKt.last((List<? extends Object>) domainLabels), "")) {
            return CollectionsKt.dropLast(domainLabels, 1);
        }
        return domainLabels;
    }

    private final List<String> findMatchingRule(List<String> list) {
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } else {
            readTheListUninterruptibly();
        }
        if (!(this.publicSuffixListBytes != null)) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
        }
        int size = list.size();
        byte[][] domainLabelsUtf8Bytes = new byte[size];
        for (int i = 0; i < size; i++) {
            Charset charset = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(charset, "UTF_8");
            byte[] bytes = list.get(i).getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            domainLabelsUtf8Bytes[i] = bytes;
        }
        String exactMatch = null;
        int i2 = 0;
        int length = domainLabelsUtf8Bytes.length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            i2++;
            Companion companion = Companion;
            byte[] bArr = this.publicSuffixListBytes;
            if (bArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                bArr = null;
            }
            String rule = companion.binarySearch(bArr, domainLabelsUtf8Bytes, i2);
            if (rule != null) {
                exactMatch = rule;
                break;
            }
        }
        String wildcardMatch = null;
        if (domainLabelsUtf8Bytes.length > 1) {
            byte[][] labelsWithWildcard = (byte[][]) domainLabelsUtf8Bytes.clone();
            int labelIndex = 0;
            int length2 = labelsWithWildcard.length - 1;
            while (true) {
                if (labelIndex >= length2) {
                    break;
                }
                labelIndex++;
                labelsWithWildcard[labelIndex] = WILDCARD_LABEL;
                Companion companion2 = Companion;
                byte[] bArr2 = this.publicSuffixListBytes;
                if (bArr2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                    bArr2 = null;
                }
                String rule2 = companion2.binarySearch(bArr2, labelsWithWildcard, labelIndex);
                if (rule2 != null) {
                    wildcardMatch = rule2;
                    break;
                }
            }
        }
        String exception = null;
        if (wildcardMatch != null) {
            int labelIndex2 = 0;
            int length3 = domainLabelsUtf8Bytes.length - 1;
            while (true) {
                if (labelIndex2 >= length3) {
                    break;
                }
                labelIndex2++;
                Companion companion3 = Companion;
                byte[] bArr3 = this.publicSuffixExceptionListBytes;
                if (bArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
                    bArr3 = null;
                }
                String rule3 = companion3.binarySearch(bArr3, domainLabelsUtf8Bytes, labelIndex2);
                if (rule3 != null) {
                    exception = rule3;
                    break;
                }
            }
        }
        if (exception != null) {
            return StringsKt.split$default((CharSequence) Intrinsics.stringPlus("!", exception), new char[]{'.'}, false, 0, 6, (Object) null);
        }
        if (exactMatch == null && wildcardMatch == null) {
            return PREVAILING_RULE;
        }
        List split$default = exactMatch == null ? null : StringsKt.split$default((CharSequence) exactMatch, new char[]{'.'}, false, 0, 6, (Object) null);
        List exactRuleLabels = split$default == null ? CollectionsKt.emptyList() : split$default;
        List split$default2 = wildcardMatch == null ? null : StringsKt.split$default((CharSequence) wildcardMatch, new char[]{'.'}, false, 0, 6, (Object) null);
        List wildcardRuleLabels = split$default2 == null ? CollectionsKt.emptyList() : split$default2;
        if (exactRuleLabels.size() > wildcardRuleLabels.size()) {
            return exactRuleLabels;
        }
        return wildcardRuleLabels;
    }

    private final void readTheListUninterruptibly() {
        boolean interrupted = false;
        while (true) {
            try {
                readTheList();
                break;
            } catch (InterruptedIOException e) {
                try {
                    Thread.interrupted();
                    interrupted = true;
                } catch (Throwable th) {
                    if (interrupted) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (IOException e2) {
                Platform.Companion.get().log("Failed to read public suffix list", 5, e2);
                if (interrupted) {
                    Thread.currentThread().interrupt();
                    return;
                }
                return;
            }
        }
        if (interrupted) {
            Thread.currentThread().interrupt();
        }
    }

    private final void readTheList() throws IOException {
        InputStream resource = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (resource != null) {
            BufferedSource buffer = Okio.buffer(new GzipSource(Okio.source(resource)));
            try {
                BufferedSource bufferedSource = buffer;
                byte[] readByteArray = bufferedSource.readByteArray((long) bufferedSource.readInt());
                byte[] readByteArray2 = bufferedSource.readByteArray((long) bufferedSource.readInt());
                Unit unit = Unit.INSTANCE;
                Closeable.closeFinally(buffer, null);
                synchronized (this) {
                    Intrinsics.checkNotNull(readByteArray);
                    this.publicSuffixListBytes = readByteArray;
                    Intrinsics.checkNotNull(readByteArray2);
                    this.publicSuffixExceptionListBytes = readByteArray2;
                    Unit unit2 = Unit.INSTANCE;
                }
                this.readCompleteLatch.countDown();
            } catch (Throwable th) {
                Closeable.closeFinally(buffer, null);
                throw th;
            }
        }
    }

    public final void setListBytes(@NotNull byte[] publicSuffixListBytes, @NotNull byte[] publicSuffixExceptionListBytes) {
        Intrinsics.checkNotNullParameter(publicSuffixListBytes, "publicSuffixListBytes");
        Intrinsics.checkNotNullParameter(publicSuffixExceptionListBytes, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = publicSuffixListBytes;
        this.publicSuffixExceptionListBytes = publicSuffixExceptionListBytes;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }

    /* compiled from: PublicSuffixDatabase.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��:\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\f\n��\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n��\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\fJ)\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n��R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n��R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n��¨\u0006\u0014"}, m373d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$Companion;", "", "()V", "EXCEPTION_MARKER", "", "PREVAILING_RULE", "", "", "PUBLIC_SUFFIX_RESOURCE", "WILDCARD_LABEL", "", "instance", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", BeanUtil.PREFIX_GETTER_GET, "binarySearch", "labels", "", "labelIndex", "", "([B[[BI)Ljava/lang/String;", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/publicsuffix/PublicSuffixDatabase$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }

        /* access modifiers changed from: private */
        public final String binarySearch(byte[] $this$binarySearch, byte[][] labels, int labelIndex) {
            int byte0;
            int compareResult;
            int low = 0;
            int high = $this$binarySearch.length;
            String match = null;
            while (true) {
                if (low >= high) {
                    break;
                }
                int mid = (low + high) / 2;
                while (mid > -1 && $this$binarySearch[mid] != 10) {
                    mid--;
                }
                int mid2 = mid + 1;
                int end = 1;
                while ($this$binarySearch[mid2 + end] != 10) {
                    end++;
                }
                int publicSuffixLength = (mid2 + end) - mid2;
                int currentLabelIndex = labelIndex;
                int currentLabelByteIndex = 0;
                int publicSuffixByteIndex = 0;
                boolean expectDot = false;
                while (true) {
                    if (expectDot) {
                        byte0 = 46;
                        expectDot = false;
                    } else {
                        byte0 = Util.and(labels[currentLabelIndex][currentLabelByteIndex], 255);
                    }
                    compareResult = byte0 - Util.and($this$binarySearch[mid2 + publicSuffixByteIndex], 255);
                    if (compareResult == 0) {
                        publicSuffixByteIndex++;
                        currentLabelByteIndex++;
                        if (publicSuffixByteIndex == publicSuffixLength) {
                            break;
                        } else if (labels[currentLabelIndex].length == currentLabelByteIndex) {
                            if (currentLabelIndex == labels.length - 1) {
                                break;
                            }
                            currentLabelIndex++;
                            currentLabelByteIndex = -1;
                            expectDot = true;
                        }
                    } else {
                        break;
                    }
                }
                if (compareResult >= 0) {
                    if (compareResult <= 0) {
                        int publicSuffixBytesLeft = publicSuffixLength - publicSuffixByteIndex;
                        int labelBytesLeft = labels[currentLabelIndex].length - currentLabelByteIndex;
                        int i = currentLabelIndex + 1;
                        int length = labels.length;
                        while (i < length) {
                            i++;
                            labelBytesLeft += labels[i].length;
                        }
                        if (labelBytesLeft >= publicSuffixBytesLeft) {
                            if (labelBytesLeft <= publicSuffixBytesLeft) {
                                Charset charset = StandardCharsets.UTF_8;
                                Intrinsics.checkNotNullExpressionValue(charset, "UTF_8");
                                match = new String($this$binarySearch, mid2, publicSuffixLength, charset);
                                break;
                            }
                            low = mid2 + end + 1;
                        } else {
                            high = mid2 - 1;
                        }
                    } else {
                        low = mid2 + end + 1;
                    }
                } else {
                    high = mid2 - 1;
                }
            }
            return match;
        }
    }
}
