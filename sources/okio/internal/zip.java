package okio.internal;

import java.io.IOException;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import okhttp3.internal.p021ws.WebSocketProtocol;
import okio.BufferedSource;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import okio.ZipFileSystem;
import org.jetbrains.annotations.NotNull;

@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��j\n��\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017H\u0002\u001a\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u001b\u001a.\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#0\"H��\u001a\f\u0010$\u001a\u00020\u0015*\u00020%H��\u001a\f\u0010&\u001a\u00020'*\u00020%H\u0002\u001a.\u0010(\u001a\u00020)*\u00020%2\u0006\u0010*\u001a\u00020\u00012\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020)0,H\u0002\u001a\u0014\u0010-\u001a\u00020.*\u00020%2\u0006\u0010/\u001a\u00020.H��\u001a\u0018\u00100\u001a\u0004\u0018\u00010.*\u00020%2\b\u0010/\u001a\u0004\u0018\u00010.H\u0002\u001a\u0014\u00101\u001a\u00020'*\u00020%2\u0006\u00102\u001a\u00020'H\u0002\u001a\f\u00103\u001a\u00020)*\u00020%H��\"\u000e\u0010��\u001a\u00020\u0001XT¢\u0006\u0002\n��\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n��\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n��\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n��\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n��\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n��\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n��\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n��\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n��\"\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n��\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n��\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n��\"\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u00064"}, m373d2 = {"BIT_FLAG_ENCRYPTED", "", "BIT_FLAG_UNSUPPORTED_MASK", "CENTRAL_FILE_HEADER_SIGNATURE", "COMPRESSION_METHOD_DEFLATED", "COMPRESSION_METHOD_STORED", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "HEADER_ID_EXTENDED_TIMESTAMP", "HEADER_ID_ZIP64_EXTENDED_INFO", "LOCAL_FILE_HEADER_SIGNATURE", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", "", "ZIP64_EOCD_RECORD_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "hex", "", "getHex", "(I)Ljava/lang/String;", "buildIndex", "", "Lokio/Path;", "Lokio/internal/ZipEntry;", "entries", "", "dosDateTimeToEpochMillis", "date", "time", "(II)Ljava/lang/Long;", "openZip", "Lokio/ZipFileSystem;", "zipPath", "fileSystem", "Lokio/FileSystem;", "predicate", "Lkotlin/Function1;", "", "readEntry", "Lokio/BufferedSource;", "readEocdRecord", "Lokio/internal/EocdRecord;", "readExtra", "", "extraSize", "block", "Lkotlin/Function2;", "readLocalHeader", "Lokio/FileMetadata;", "basicMetadata", "readOrSkipLocalHeader", "readZip64EocdRecord", "regularRecord", "skipLocalHeader", "okio"})
/* renamed from: okio.internal.ZipKt */
/* loaded from: grasscutter.jar:okio/internal/ZipKt.class */
public final class zip {
    private static final int LOCAL_FILE_HEADER_SIGNATURE;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE;
    private static final int ZIP64_LOCATOR_SIGNATURE;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE;
    public static final int COMPRESSION_METHOD_DEFLATED;
    public static final int COMPRESSION_METHOD_STORED;
    private static final int BIT_FLAG_ENCRYPTED;
    private static final int BIT_FLAG_UNSUPPORTED_MASK;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP;

    public static /* synthetic */ ZipFileSystem openZip$default(Path path, FileSystem fileSystem, Function1 function1, int i, Object obj) throws IOException {
        if ((i & 4) != 0) {
            function1 = ZipKt$openZip$1.INSTANCE;
        }
        return openZip(path, fileSystem, function1);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
        jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 15, insn: 0x00c0: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r15 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:18:0x00c0
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVarsInBlock(SSATransform.java:171)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:143)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:60)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    @org.jetbrains.annotations.NotNull
    public static final okio.ZipFileSystem openZip(
/*
[932] Method generation error in method: okio.internal.ZipKt.openZip(okio.Path, okio.FileSystem, kotlin.jvm.functions.Function1<? super okio.internal.ZipEntry, java.lang.Boolean>):okio.ZipFileSystem, file: grasscutter.jar:okio/internal/ZipKt.class
    jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r7v0 ??
    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:228)
    	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:195)
    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:151)
    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:344)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
    
*/

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> $this$sortedBy$iv) {
        Map result = new LinkedHashMap();
        for (ZipEntry entry : CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: okio.internal.ZipKt$buildIndex$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((ZipEntry) t).getCanonicalPath(), ((ZipEntry) t2).getCanonicalPath());
            }
        })) {
            if (((ZipEntry) result.put(entry.getCanonicalPath(), entry)) == null) {
                ZipEntry child = entry;
                while (true) {
                    Path parentPath = child.getCanonicalPath().parent();
                    if (parentPath != null) {
                        ZipEntry parentEntry = (ZipEntry) result.get(parentPath);
                        if (parentEntry != null) {
                            parentEntry.getChildren().add(child.getCanonicalPath());
                            break;
                        }
                        ZipEntry parentEntry2 = new ZipEntry(parentPath, true, null, 0, 0, 0, 0, null, 0, 508, null);
                        result.put(parentPath, parentEntry2);
                        parentEntry2.getChildren().add(child.getCanonicalPath());
                        child = parentEntry2;
                    }
                }
            }
        }
        return result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r39v0 */
    /* JADX WARN: Type inference failed for: r39v1, types: [long] */
    /* JADX WARN: Type inference failed for: r39v8 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final okio.internal.ZipEntry readEntry(@org.jetbrains.annotations.NotNull okio.BufferedSource r16) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 546
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.zip.readEntry(okio.BufferedSource):okio.internal.ZipEntry");
    }

    private static final EocdRecord readEocdRecord(BufferedSource $this$readEocdRecord) throws IOException {
        int diskNumber = $this$readEocdRecord.readShortLe() & 65535;
        int diskWithCentralDir = $this$readEocdRecord.readShortLe() & 65535;
        long entryCount = (long) ($this$readEocdRecord.readShortLe() & 65535);
        if (entryCount == ((long) ($this$readEocdRecord.readShortLe() & 65535)) && diskNumber == 0 && diskWithCentralDir == 0) {
            $this$readEocdRecord.skip(4);
            return new EocdRecord(entryCount, ((long) $this$readEocdRecord.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE, $this$readEocdRecord.readShortLe() & 65535);
        }
        throw new IOException("unsupported zip: spanned");
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource $this$readZip64EocdRecord, EocdRecord regularRecord) throws IOException {
        $this$readZip64EocdRecord.skip(12);
        int diskNumber = $this$readZip64EocdRecord.readIntLe();
        int diskWithCentralDirStart = $this$readZip64EocdRecord.readIntLe();
        long entryCount = $this$readZip64EocdRecord.readLongLe();
        if (entryCount == $this$readZip64EocdRecord.readLongLe() && diskNumber == 0 && diskWithCentralDirStart == 0) {
            $this$readZip64EocdRecord.skip(8);
            return new EocdRecord(entryCount, $this$readZip64EocdRecord.readLongLe(), regularRecord.getCommentByteCount());
        }
        throw new IOException("unsupported zip: spanned");
    }

    private static final void readExtra(BufferedSource $this$readExtra, int extraSize, Function2<? super Integer, ? super Long, Unit> function2) {
        long remaining = (long) extraSize;
        while (remaining != 0) {
            if (remaining < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int headerId = $this$readExtra.readShortLe() & 65535;
            long dataSize = ((long) $this$readExtra.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
            long remaining2 = remaining - ((long) 4);
            if (remaining2 < dataSize) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            $this$readExtra.require(dataSize);
            long sizeBefore = $this$readExtra.getBuffer().size();
            function2.invoke(Integer.valueOf(headerId), Long.valueOf(dataSize));
            long fieldRemaining = (dataSize + $this$readExtra.getBuffer().size()) - sizeBefore;
            if (fieldRemaining < 0) {
                throw new IOException(Intrinsics.stringPlus("unsupported zip: too many bytes processed for ", Integer.valueOf(headerId)));
            }
            if (fieldRemaining > 0) {
                $this$readExtra.getBuffer().skip(fieldRemaining);
            }
            remaining = remaining2 - dataSize;
        }
    }

    public static final void skipLocalHeader(@NotNull BufferedSource $this$skipLocalHeader) {
        Intrinsics.checkNotNullParameter($this$skipLocalHeader, "<this>");
        readOrSkipLocalHeader($this$skipLocalHeader, null);
    }

    @NotNull
    public static final FileMetadata readLocalHeader(@NotNull BufferedSource $this$readLocalHeader, @NotNull FileMetadata basicMetadata) {
        Intrinsics.checkNotNullParameter($this$readLocalHeader, "<this>");
        Intrinsics.checkNotNullParameter(basicMetadata, "basicMetadata");
        FileMetadata readOrSkipLocalHeader = readOrSkipLocalHeader($this$readLocalHeader, basicMetadata);
        Intrinsics.checkNotNull(readOrSkipLocalHeader);
        return readOrSkipLocalHeader;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r1v22, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private static final FileMetadata readOrSkipLocalHeader(BufferedSource $this$readOrSkipLocalHeader, FileMetadata basicMetadata) {
        Ref.ObjectRef lastModifiedAtMillis = new Ref.ObjectRef();
        lastModifiedAtMillis.element = basicMetadata == null ? 0 : basicMetadata.getLastModifiedAtMillis();
        Ref.ObjectRef lastAccessedAtMillis = new Ref.ObjectRef();
        Ref.ObjectRef createdAtMillis = new Ref.ObjectRef();
        int signature = $this$readOrSkipLocalHeader.readIntLe();
        if (signature != LOCAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(signature));
        }
        $this$readOrSkipLocalHeader.skip(2);
        int bitFlag = $this$readOrSkipLocalHeader.readShortLe() & 65535;
        if ((bitFlag & 1) != 0) {
            throw new IOException(Intrinsics.stringPlus("unsupported zip: general purpose bit flag=", getHex(bitFlag)));
        }
        $this$readOrSkipLocalHeader.skip(18);
        long fileNameLength = ((long) $this$readOrSkipLocalHeader.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        int extraSize = $this$readOrSkipLocalHeader.readShortLe() & 65535;
        $this$readOrSkipLocalHeader.skip(fileNameLength);
        if (basicMetadata == null) {
            $this$readOrSkipLocalHeader.skip((long) extraSize);
            return null;
        }
        readExtra($this$readOrSkipLocalHeader, extraSize, new Function2<Integer, Long, Unit>($this$readOrSkipLocalHeader, lastModifiedAtMillis, lastAccessedAtMillis, createdAtMillis) { // from class: okio.internal.ZipKt$readOrSkipLocalHeader$1
            final /* synthetic */ BufferedSource $this_readOrSkipLocalHeader;
            final /* synthetic */ Ref.ObjectRef<Long> $lastModifiedAtMillis;
            final /* synthetic */ Ref.ObjectRef<Long> $lastAccessedAtMillis;
            final /* synthetic */ Ref.ObjectRef<Long> $createdAtMillis;

            /* access modifiers changed from: package-private */
            {
                this.$this_readOrSkipLocalHeader = $receiver;
                this.$lastModifiedAtMillis = r5;
                this.$lastAccessedAtMillis = r6;
                this.$createdAtMillis = r7;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Long l) {
                invoke(num.intValue(), l.longValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r22v0 */
            /* JADX WARN: Type inference failed for: r22v1, types: [long] */
            /* JADX WARN: Type inference failed for: r1v15, types: [T, java.lang.Long] */
            /* JADX WARN: Type inference failed for: r1v21, types: [T, java.lang.Long] */
            /* JADX WARN: Type inference failed for: r1v27, types: [T, java.lang.Long] */
            /* JADX WARN: Type inference failed for: r22v8 */
            /* JADX WARNING: Unknown variable types count: 1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void invoke(int r7, long r8) {
                /*
                // Method dump skipped, instructions count: 258
                */
                throw new UnsupportedOperationException("Method not decompiled: okio.internal.ZipKt$readOrSkipLocalHeader$1.invoke(int, long):void");
            }
        });
        return new FileMetadata(basicMetadata.isRegularFile(), basicMetadata.isDirectory(), null, basicMetadata.getSize(), (Long) createdAtMillis.element, (Long) lastModifiedAtMillis.element, (Long) lastAccessedAtMillis.element, null, 128, null);
    }

    private static final Long dosDateTimeToEpochMillis(int date, int time) {
        if (time == -1) {
            return null;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(14, 0);
        cal.set(1980 + ((date >> 9) & 127), ((date >> 5) & 15) - 1, date & 31, (time >> 11) & 31, (time >> 5) & 63, (time & 31) << 1);
        return Long.valueOf(cal.getTime().getTime());
    }

    private static final String getHex(int $this$hex) {
        String num = Integer.toString($this$hex, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return Intrinsics.stringPlus("0x", num);
    }
}
