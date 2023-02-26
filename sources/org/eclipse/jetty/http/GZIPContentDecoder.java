package org.eclipse.jetty.http;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.component.Destroyable;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/GZIPContentDecoder.class */
public class GZIPContentDecoder implements Destroyable {
    private static final long UINT_MAX = 4294967295L;
    private final List<ByteBuffer> _inflateds;
    private final Inflater _inflater;
    private final ByteBufferPool _pool;
    private final int _bufferSize;
    private State _state;
    private int _size;
    private long _value;
    private byte _flags;
    private ByteBuffer _inflated;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/GZIPContentDecoder$State.class */
    public enum State {
        INITIAL,
        ID,
        CM,
        FLG,
        MTIME,
        XFL,
        OS,
        FLAGS,
        EXTRA_LENGTH,
        EXTRA,
        NAME,
        COMMENT,
        HCRC,
        DATA,
        CRC,
        ISIZE
    }

    public GZIPContentDecoder() {
        this(null, 2048);
    }

    public GZIPContentDecoder(int bufferSize) {
        this(null, bufferSize);
    }

    public GZIPContentDecoder(ByteBufferPool pool, int bufferSize) {
        this._inflateds = new ArrayList();
        this._inflater = new Inflater(true);
        this._bufferSize = bufferSize;
        this._pool = pool;
        reset();
    }

    public ByteBuffer decode(ByteBuffer compressed) {
        decodeChunks(compressed);
        if (!this._inflateds.isEmpty()) {
            this._inflateds.add(this._inflated);
            this._inflated = null;
            ByteBuffer result = acquire(this._inflateds.stream().mapToInt((v0) -> {
                return v0.remaining();
            }).sum());
            for (ByteBuffer buffer : this._inflateds) {
                BufferUtil.append(result, buffer);
                release(buffer);
            }
            this._inflateds.clear();
            return result;
        } else if (BufferUtil.isEmpty(this._inflated) || this._state == State.CRC || this._state == State.ISIZE) {
            return BufferUtil.EMPTY_BUFFER;
        } else {
            ByteBuffer result2 = this._inflated;
            this._inflated = null;
            return result2;
        }
    }

    /* access modifiers changed from: protected */
    public boolean decodedChunk(ByteBuffer chunk) {
        if (this._inflated == null) {
            this._inflated = chunk;
            return false;
        } else if (BufferUtil.space(this._inflated) >= chunk.remaining()) {
            BufferUtil.append(this._inflated, chunk);
            release(chunk);
            return false;
        } else {
            this._inflateds.add(this._inflated);
            this._inflated = chunk;
            return false;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:23:0x00ce
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    protected void decodeChunks(java.nio.ByteBuffer r9) {
        /*
        // Method dump skipped, instructions count: 1040
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.http.GZIPContentDecoder.decodeChunks(java.nio.ByteBuffer):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: org.eclipse.jetty.http.GZIPContentDecoder$1 */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/GZIPContentDecoder$1.class */
    public static /* synthetic */ class C56131 {
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$jetty$http$GZIPContentDecoder$State = new int[State.values().length];

        static {
            try {
                $SwitchMap$org$eclipse$jetty$http$GZIPContentDecoder$State[State.INITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$org$eclipse$jetty$http$GZIPContentDecoder$State[State.FLAGS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$org$eclipse$jetty$http$GZIPContentDecoder$State[State.DATA.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$org$eclipse$jetty$http$GZIPContentDecoder$State[State.ID.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$org$eclipse$jetty$http$GZIPContentDecoder$State[State.CM.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$org$eclipse$jetty$http$GZIPContentDecoder$State[State.FLG.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$org$eclipse$jetty$http$GZIPContentDecoder$State[State.MTIME.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$org$eclipse$jetty$http$GZIPContentDecoder$State[State.XFL.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$org$eclipse$jetty$http$GZIPContentDecoder$State[State.OS.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$org$eclipse$jetty$http$GZIPContentDecoder$State[State.EXTRA_LENGTH.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$org$eclipse$jetty$http$GZIPContentDecoder$State[State.EXTRA.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$org$eclipse$jetty$http$GZIPContentDecoder$State[State.NAME.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$org$eclipse$jetty$http$GZIPContentDecoder$State[State.COMMENT.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$org$eclipse$jetty$http$GZIPContentDecoder$State[State.HCRC.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$org$eclipse$jetty$http$GZIPContentDecoder$State[State.CRC.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$org$eclipse$jetty$http$GZIPContentDecoder$State[State.ISIZE.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
        }
    }

    private void reset() {
        this._inflater.reset();
        this._state = State.INITIAL;
        this._size = 0;
        this._value = 0;
        this._flags = 0;
    }

    @Override // org.eclipse.jetty.util.component.Destroyable
    public void destroy() {
        this._inflater.end();
    }

    public boolean isFinished() {
        return this._state == State.INITIAL;
    }

    public ByteBuffer acquire(int capacity) {
        return this._pool == null ? BufferUtil.allocate(capacity) : this._pool.acquire(capacity, false);
    }

    public void release(ByteBuffer buffer) {
        if (this._pool != null && !BufferUtil.isTheEmptyBuffer(buffer)) {
            this._pool.release(buffer);
        }
    }
}
