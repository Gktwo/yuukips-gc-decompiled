package okhttp3.internal.http2;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Huffman.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��F\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u0015\n��\n\u0002\u0010\u0012\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n��\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018��2\u00020\u0001:\u0001\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n��¨\u0006\u001b"}, m373d2 = {"Lokhttp3/internal/http2/Huffman;", "", "()V", "CODES", "", "CODE_BIT_COUNTS", "", "root", "Lokhttp3/internal/http2/Huffman$Node;", "addCode", "", "symbol", "", "code", "codeBitCount", "decode", "source", "Lokio/BufferedSource;", "byteCount", "", "sink", "Lokio/BufferedSink;", "encode", "Lokio/ByteString;", "encodedLength", "bytes", "Node", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/http2/Huffman.class */
public final class Huffman {
    @NotNull
    public static final Huffman INSTANCE = new Huffman();
    @NotNull
    private static final int[] CODES = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, PacketOpcodes.SetPlayerHeadImageReq, 8185, 21, PacketOpcodes.ScenePlayerLocationNotify, PacketOpcodes.BlessingGiveFriendPicRsp, 1018, PacketOpcodes.AvatarSkillDepotChangeNotify, PacketOpcodes.BeginCameraSceneLookNotify, PacketOpcodes.GetActivityInfoRsp, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, PacketOpcodes.EnterSceneReadyRsp, 32764, 32, PacketOpcodes.GetFriendShowAvatarInfoRsp, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, PacketOpcodes.PersonalSceneJumpReq, 115, PacketOpcodes.ScenePlayerInfoNotify, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, PacketOpcodes.SalesmanTakeSpecialRewardRsp, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
    @NotNull
    private static final byte[] CODE_BIT_COUNTS = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};
    @NotNull
    private static final Node root = new Node();

    private Huffman() {
    }

    static {
        int i = 0;
        int length = CODE_BIT_COUNTS.length;
        while (i < length) {
            i++;
            INSTANCE.addCode(i, CODES[i], CODE_BIT_COUNTS[i]);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x001a */
    /* JADX DEBUG: Multi-variable search result rejected for r9v1, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v4, types: [long] */
    public final void encode(@NotNull ByteString source, @NotNull BufferedSink sink) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long accumulator = 0;
        int accumulatorBitCount = 0;
        int i = 0;
        int size = source.size();
        while (i < size) {
            i++;
            int symbol = Util.and(source.getByte(i), 255);
            int code = CODES[symbol];
            byte b = CODE_BIT_COUNTS[symbol];
            accumulator = ((accumulator == true ? 1 : 0) << b) | ((long) code);
            accumulatorBitCount += b;
            while (accumulatorBitCount >= 8) {
                accumulatorBitCount -= 8;
                sink.writeByte((int) (accumulator >> accumulatorBitCount));
            }
        }
        if (accumulatorBitCount > 0) {
            sink.writeByte((int) ((accumulator << (8 - accumulatorBitCount)) | (255 >>> accumulatorBitCount)));
        }
    }

    /* JADX WARN: Type inference failed for: r0v15, types: [long] */
    public final int encodedLength(@NotNull ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        char c = 0;
        int i = 0;
        int size = bytes.size();
        while (i < size) {
            i++;
            c += (long) CODE_BIT_COUNTS[Util.and(bytes.getByte(i), 255)];
        }
        return (int) ((c + ((long) 7)) >> 3);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x001b */
    /* JADX DEBUG: Multi-variable search result rejected for r13v1, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v3, types: [long] */
    public final void decode(@NotNull BufferedSource source, long byteCount, @NotNull BufferedSink sink) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        Node node = root;
        int accumulator = 0;
        int accumulatorBitCount = 0;
        long j = 0;
        while ((j == true ? 1 : 0) < byteCount) {
            j++;
            accumulator = (accumulator << 8) | Util.and(source.readByte(), 255);
            accumulatorBitCount += 8;
            while (accumulatorBitCount >= 8) {
                Node[] children = node.getChildren();
                Intrinsics.checkNotNull(children);
                Node node2 = children[(accumulator >>> (accumulatorBitCount - 8)) & 255];
                Intrinsics.checkNotNull(node2);
                node = node2;
                if (node.getChildren() == null) {
                    sink.writeByte(node.getSymbol());
                    accumulatorBitCount -= node.getTerminalBitCount();
                    node = root;
                } else {
                    accumulatorBitCount -= 8;
                }
            }
        }
        while (accumulatorBitCount > 0) {
            Node[] children2 = node.getChildren();
            Intrinsics.checkNotNull(children2);
            Node node3 = children2[(accumulator << (8 - accumulatorBitCount)) & 255];
            Intrinsics.checkNotNull(node3);
            if (node3.getChildren() == null && node3.getTerminalBitCount() <= accumulatorBitCount) {
                sink.writeByte(node3.getSymbol());
                accumulatorBitCount -= node3.getTerminalBitCount();
                node = root;
            } else {
                return;
            }
        }
    }

    private final void addCode(int symbol, int code, int codeBitCount) {
        Node terminal = new Node(symbol, codeBitCount);
        int accumulatorBitCount = codeBitCount;
        Node node = root;
        while (accumulatorBitCount > 8) {
            accumulatorBitCount -= 8;
            int childIndex = (code >>> accumulatorBitCount) & 255;
            Node[] children = node.getChildren();
            Intrinsics.checkNotNull(children);
            Node child = children[childIndex];
            if (child == null) {
                child = new Node();
                children[childIndex] = child;
            }
            node = child;
        }
        int shift = 8 - accumulatorBitCount;
        int start = (code << shift) & 255;
        int end = 1 << shift;
        Node[] children2 = node.getChildren();
        Intrinsics.checkNotNull(children2);
        ArraysKt.fill(children2, terminal, start, start + end);
    }

    /* compiled from: Huffman.kt */
    /* access modifiers changed from: private */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001c\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\b\u0002\u0018��2\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u001d\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010��\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n��\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n��\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, m373d2 = {"Lokhttp3/internal/http2/Huffman$Node;", "", "()V", "symbol", "", "bits", "(II)V", "children", "", "getChildren", "()[Lokhttp3/internal/http2/Huffman$Node;", "[Lokhttp3/internal/http2/Huffman$Node;", "getSymbol", "()I", "terminalBitCount", "getTerminalBitCount", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/http2/Huffman$Node.class */
    public static final class Node {
        @Nullable
        private final Node[] children;
        private final int symbol;
        private final int terminalBitCount;

        @Nullable
        public final Node[] getChildren() {
            return this.children;
        }

        public final int getSymbol() {
            return this.symbol;
        }

        public final int getTerminalBitCount() {
            return this.terminalBitCount;
        }

        public Node() {
            this.children = new Node[256];
            this.symbol = 0;
            this.terminalBitCount = 0;
        }

        public Node(int symbol, int bits) {
            this.children = null;
            this.symbol = symbol;
            int b = bits & 7;
            this.terminalBitCount = b == 0 ? 8 : b;
        }
    }
}
