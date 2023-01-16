package p013io.netty.buffer;

import p013io.netty.util.ByteProcessor;

@Deprecated
/* renamed from: io.netty.buffer.ByteBufProcessor */
/* loaded from: grasscutter.jar:io/netty/buffer/ByteBufProcessor.class */
public interface ByteBufProcessor extends ByteProcessor {
    @Deprecated
    public static final ByteBufProcessor FIND_NUL = new ByteBufProcessor() { // from class: io.netty.buffer.ByteBufProcessor.1
        @Override // p013io.netty.util.ByteProcessor
        public boolean process(byte value) throws Exception {
            return value != 0;
        }
    };
    @Deprecated
    public static final ByteBufProcessor FIND_NON_NUL = new ByteBufProcessor() { // from class: io.netty.buffer.ByteBufProcessor.2
        @Override // p013io.netty.util.ByteProcessor
        public boolean process(byte value) throws Exception {
            return value == 0;
        }
    };
    @Deprecated
    public static final ByteBufProcessor FIND_CR = new ByteBufProcessor() { // from class: io.netty.buffer.ByteBufProcessor.3
        @Override // p013io.netty.util.ByteProcessor
        public boolean process(byte value) throws Exception {
            return value != 13;
        }
    };
    @Deprecated
    public static final ByteBufProcessor FIND_NON_CR = new ByteBufProcessor() { // from class: io.netty.buffer.ByteBufProcessor.4
        @Override // p013io.netty.util.ByteProcessor
        public boolean process(byte value) throws Exception {
            return value == 13;
        }
    };
    @Deprecated
    public static final ByteBufProcessor FIND_LF = new ByteBufProcessor() { // from class: io.netty.buffer.ByteBufProcessor.5
        @Override // p013io.netty.util.ByteProcessor
        public boolean process(byte value) throws Exception {
            return value != 10;
        }
    };
    @Deprecated
    public static final ByteBufProcessor FIND_NON_LF = new ByteBufProcessor() { // from class: io.netty.buffer.ByteBufProcessor.6
        @Override // p013io.netty.util.ByteProcessor
        public boolean process(byte value) throws Exception {
            return value == 10;
        }
    };
    @Deprecated
    public static final ByteBufProcessor FIND_CRLF = new ByteBufProcessor() { // from class: io.netty.buffer.ByteBufProcessor.7
        @Override // p013io.netty.util.ByteProcessor
        public boolean process(byte value) throws Exception {
            return (value == 13 || value == 10) ? false : true;
        }
    };
    @Deprecated
    public static final ByteBufProcessor FIND_NON_CRLF = new ByteBufProcessor() { // from class: io.netty.buffer.ByteBufProcessor.8
        @Override // p013io.netty.util.ByteProcessor
        public boolean process(byte value) throws Exception {
            return value == 13 || value == 10;
        }
    };
    @Deprecated
    public static final ByteBufProcessor FIND_LINEAR_WHITESPACE = new ByteBufProcessor() { // from class: io.netty.buffer.ByteBufProcessor.9
        @Override // p013io.netty.util.ByteProcessor
        public boolean process(byte value) throws Exception {
            return (value == 32 || value == 9) ? false : true;
        }
    };
    @Deprecated
    public static final ByteBufProcessor FIND_NON_LINEAR_WHITESPACE = new ByteBufProcessor() { // from class: io.netty.buffer.ByteBufProcessor.10
        @Override // p013io.netty.util.ByteProcessor
        public boolean process(byte value) throws Exception {
            return value == 32 || value == 9;
        }
    };
}
