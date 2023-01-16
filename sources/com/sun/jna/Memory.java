package com.sun.jna;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: grasscutter.jar:com/sun/jna/Memory.class */
public class Memory extends Pointer {
    private static LinkedReference HEAD;
    private final LinkedReference reference;
    protected long size;
    private static ReferenceQueue<Memory> QUEUE = new ReferenceQueue<>();
    private static final WeakMemoryHolder buffers = new WeakMemoryHolder();

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/sun/jna/Memory$LinkedReference.class */
    public static class LinkedReference extends WeakReference<Memory> {
        private LinkedReference next;
        private LinkedReference prev;

        private LinkedReference(Memory referent) {
            super(referent, Memory.QUEUE);
        }

        static LinkedReference track(Memory instance) {
            synchronized (Memory.QUEUE) {
                while (true) {
                    LinkedReference stale = (LinkedReference) Memory.QUEUE.poll();
                    if (stale == null) {
                        break;
                    }
                    stale.unlink();
                }
            }
            LinkedReference entry = new LinkedReference(instance);
            synchronized (LinkedReference.class) {
                if (Memory.HEAD != null) {
                    entry.next = Memory.HEAD;
                    Memory.HEAD.prev = entry;
                    LinkedReference unused = Memory.HEAD = entry;
                } else {
                    LinkedReference unused2 = Memory.HEAD = entry;
                }
            }
            return entry;
        }

        /* access modifiers changed from: private */
        public void unlink() {
            LinkedReference next;
            synchronized (LinkedReference.class) {
                if (Memory.HEAD == this) {
                    next = Memory.HEAD = Memory.HEAD.next;
                } else if (this.prev != null) {
                    LinkedReference linkedReference = this.prev;
                    LinkedReference linkedReference2 = this.next;
                    linkedReference.next = linkedReference2;
                    next = linkedReference2;
                } else {
                    return;
                }
                if (next != null) {
                    next.prev = this.prev;
                }
                this.prev = null;
            }
        }
    }

    public static void purge() {
        buffers.clean();
    }

    public static void disposeAll() {
        synchronized (LinkedReference.class) {
            while (true) {
                LinkedReference entry = HEAD;
                if (entry != null) {
                    Memory memory = (Memory) HEAD.get();
                    if (memory != null) {
                        memory.dispose();
                    } else {
                        HEAD.unlink();
                    }
                    if (HEAD == entry) {
                        throw new IllegalStateException("the HEAD did not change");
                    }
                }
            }
        }
        synchronized (QUEUE) {
            while (true) {
                LinkedReference stale = (LinkedReference) QUEUE.poll();
                if (stale != null) {
                    stale.unlink();
                }
            }
        }
    }

    static int integrityCheck() {
        synchronized (LinkedReference.class) {
            if (HEAD == null) {
                return 0;
            }
            ArrayList<LinkedReference> entries = new ArrayList<>();
            for (LinkedReference entry = HEAD; entry != null; entry = entry.next) {
                entries.add(entry);
            }
            int index = entries.size() - 1;
            LinkedReference entry2 = entries.get(index);
            while (entry2 != null) {
                if (entries.get(index) != entry2) {
                    throw new IllegalStateException(entries.get(index) + " vs. " + entry2 + " at index " + index);
                }
                entry2 = entry2.prev;
                index--;
            }
            return entries.size();
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/sun/jna/Memory$SharedMemory.class */
    public class SharedMemory extends Memory {
        public SharedMemory(long offset, long size) {
            this.size = size;
            this.peer = Memory.this.peer + offset;
        }

        @Override // com.sun.jna.Memory
        protected synchronized void dispose() {
            this.peer = 0;
        }

        @Override // com.sun.jna.Memory
        protected void boundsCheck(long off, long sz) {
            Memory.this.boundsCheck((this.peer - Memory.this.peer) + off, sz);
        }

        @Override // com.sun.jna.Memory, com.sun.jna.Pointer
        public String toString() {
            return toString() + " (shared from " + Memory.this.toString() + ")";
        }
    }

    public Memory(long size) {
        this.size = size;
        if (size <= 0) {
            throw new IllegalArgumentException("Allocation size must be greater than zero");
        }
        this.peer = malloc(size);
        if (this.peer == 0) {
            throw new OutOfMemoryError("Cannot allocate " + size + " bytes");
        }
        this.reference = LinkedReference.track(this);
    }

    protected Memory() {
        this.reference = null;
    }

    @Override // com.sun.jna.Pointer
    public Pointer share(long offset) {
        return share(offset, size() - offset);
    }

    @Override // com.sun.jna.Pointer
    public Pointer share(long offset, long sz) {
        boundsCheck(offset, sz);
        return new SharedMemory(offset, sz);
    }

    public Memory align(int byteBoundary) {
        if (byteBoundary <= 0) {
            throw new IllegalArgumentException("Byte boundary must be positive: " + byteBoundary);
        }
        for (int i = 0; i < 32; i++) {
            if (byteBoundary == (1 << i)) {
                long mask = (((long) byteBoundary) - 1) ^ -1;
                if ((this.peer & mask) == this.peer) {
                    return this;
                }
                long newPeer = ((this.peer + ((long) byteBoundary)) - 1) & mask;
                long newSize = (this.peer + this.size) - newPeer;
                if (newSize > 0) {
                    return (Memory) share(newPeer - this.peer, newSize);
                }
                throw new IllegalArgumentException("Insufficient memory to align to the requested boundary");
            }
        }
        throw new IllegalArgumentException("Byte boundary must be a power of two");
    }

    protected void finalize() {
        dispose();
    }

    protected synchronized void dispose() {
        if (this.peer != 0) {
            try {
                free(this.peer);
            } finally {
                this.peer = 0;
                this.reference.unlink();
            }
        }
    }

    public void clear() {
        clear(this.size);
    }

    public boolean valid() {
        return this.peer != 0;
    }

    public long size() {
        return this.size;
    }

    protected void boundsCheck(long off, long sz) {
        if (off < 0) {
            throw new IndexOutOfBoundsException("Invalid offset: " + off);
        } else if (off + sz > this.size) {
            throw new IndexOutOfBoundsException("Bounds exceeds available space : size=" + this.size + ", offset=" + (off + sz));
        }
    }

    @Override // com.sun.jna.Pointer
    public void read(long bOff, byte[] buf, int index, int length) {
        boundsCheck(bOff, ((long) length) * 1);
        read(bOff, buf, index, length);
    }

    @Override // com.sun.jna.Pointer
    public void read(long bOff, short[] buf, int index, int length) {
        boundsCheck(bOff, ((long) length) * 2);
        read(bOff, buf, index, length);
    }

    @Override // com.sun.jna.Pointer
    public void read(long bOff, char[] buf, int index, int length) {
        boundsCheck(bOff, (long) (length * Native.WCHAR_SIZE));
        read(bOff, buf, index, length);
    }

    @Override // com.sun.jna.Pointer
    public void read(long bOff, int[] buf, int index, int length) {
        boundsCheck(bOff, ((long) length) * 4);
        read(bOff, buf, index, length);
    }

    @Override // com.sun.jna.Pointer
    public void read(long bOff, long[] buf, int index, int length) {
        boundsCheck(bOff, ((long) length) * 8);
        read(bOff, buf, index, length);
    }

    @Override // com.sun.jna.Pointer
    public void read(long bOff, float[] buf, int index, int length) {
        boundsCheck(bOff, ((long) length) * 4);
        read(bOff, buf, index, length);
    }

    @Override // com.sun.jna.Pointer
    public void read(long bOff, double[] buf, int index, int length) {
        boundsCheck(bOff, ((long) length) * 8);
        read(bOff, buf, index, length);
    }

    @Override // com.sun.jna.Pointer
    public void read(long bOff, Pointer[] buf, int index, int length) {
        boundsCheck(bOff, (long) (length * Native.POINTER_SIZE));
        read(bOff, buf, index, length);
    }

    @Override // com.sun.jna.Pointer
    public void write(long bOff, byte[] buf, int index, int length) {
        boundsCheck(bOff, ((long) length) * 1);
        write(bOff, buf, index, length);
    }

    @Override // com.sun.jna.Pointer
    public void write(long bOff, short[] buf, int index, int length) {
        boundsCheck(bOff, ((long) length) * 2);
        write(bOff, buf, index, length);
    }

    @Override // com.sun.jna.Pointer
    public void write(long bOff, char[] buf, int index, int length) {
        boundsCheck(bOff, (long) (length * Native.WCHAR_SIZE));
        write(bOff, buf, index, length);
    }

    @Override // com.sun.jna.Pointer
    public void write(long bOff, int[] buf, int index, int length) {
        boundsCheck(bOff, ((long) length) * 4);
        write(bOff, buf, index, length);
    }

    @Override // com.sun.jna.Pointer
    public void write(long bOff, long[] buf, int index, int length) {
        boundsCheck(bOff, ((long) length) * 8);
        write(bOff, buf, index, length);
    }

    @Override // com.sun.jna.Pointer
    public void write(long bOff, float[] buf, int index, int length) {
        boundsCheck(bOff, ((long) length) * 4);
        write(bOff, buf, index, length);
    }

    @Override // com.sun.jna.Pointer
    public void write(long bOff, double[] buf, int index, int length) {
        boundsCheck(bOff, ((long) length) * 8);
        write(bOff, buf, index, length);
    }

    @Override // com.sun.jna.Pointer
    public void write(long bOff, Pointer[] buf, int index, int length) {
        boundsCheck(bOff, (long) (length * Native.POINTER_SIZE));
        write(bOff, buf, index, length);
    }

    @Override // com.sun.jna.Pointer
    public byte getByte(long offset) {
        boundsCheck(offset, 1);
        return getByte(offset);
    }

    @Override // com.sun.jna.Pointer
    public char getChar(long offset) {
        boundsCheck(offset, (long) Native.WCHAR_SIZE);
        return getChar(offset);
    }

    @Override // com.sun.jna.Pointer
    public short getShort(long offset) {
        boundsCheck(offset, 2);
        return getShort(offset);
    }

    @Override // com.sun.jna.Pointer
    public int getInt(long offset) {
        boundsCheck(offset, 4);
        return getInt(offset);
    }

    @Override // com.sun.jna.Pointer
    public long getLong(long offset) {
        boundsCheck(offset, 8);
        return getLong(offset);
    }

    @Override // com.sun.jna.Pointer
    public float getFloat(long offset) {
        boundsCheck(offset, 4);
        return getFloat(offset);
    }

    @Override // com.sun.jna.Pointer
    public double getDouble(long offset) {
        boundsCheck(offset, 8);
        return getDouble(offset);
    }

    @Override // com.sun.jna.Pointer
    public Pointer getPointer(long offset) {
        boundsCheck(offset, (long) Native.POINTER_SIZE);
        return shareReferenceIfInBounds(getPointer(offset));
    }

    @Override // com.sun.jna.Pointer
    public ByteBuffer getByteBuffer(long offset, long length) {
        boundsCheck(offset, length);
        ByteBuffer b = getByteBuffer(offset, length);
        buffers.put(b, this);
        return b;
    }

    @Override // com.sun.jna.Pointer
    public String getString(long offset, String encoding) {
        boundsCheck(offset, 0);
        return getString(offset, encoding);
    }

    @Override // com.sun.jna.Pointer
    public String getWideString(long offset) {
        boundsCheck(offset, 0);
        return getWideString(offset);
    }

    @Override // com.sun.jna.Pointer
    public void setByte(long offset, byte value) {
        boundsCheck(offset, 1);
        setByte(offset, value);
    }

    @Override // com.sun.jna.Pointer
    public void setChar(long offset, char value) {
        boundsCheck(offset, (long) Native.WCHAR_SIZE);
        setChar(offset, value);
    }

    @Override // com.sun.jna.Pointer
    public void setShort(long offset, short value) {
        boundsCheck(offset, 2);
        setShort(offset, value);
    }

    @Override // com.sun.jna.Pointer
    public void setInt(long offset, int value) {
        boundsCheck(offset, 4);
        setInt(offset, value);
    }

    @Override // com.sun.jna.Pointer
    public void setLong(long offset, long value) {
        boundsCheck(offset, 8);
        setLong(offset, value);
    }

    @Override // com.sun.jna.Pointer
    public void setFloat(long offset, float value) {
        boundsCheck(offset, 4);
        setFloat(offset, value);
    }

    @Override // com.sun.jna.Pointer
    public void setDouble(long offset, double value) {
        boundsCheck(offset, 8);
        setDouble(offset, value);
    }

    @Override // com.sun.jna.Pointer
    public void setPointer(long offset, Pointer value) {
        boundsCheck(offset, (long) Native.POINTER_SIZE);
        setPointer(offset, value);
    }

    @Override // com.sun.jna.Pointer
    public void setString(long offset, String value, String encoding) {
        boundsCheck(offset, ((long) Native.getBytes(value, encoding).length) + 1);
        setString(offset, value, encoding);
    }

    @Override // com.sun.jna.Pointer
    public void setWideString(long offset, String value) {
        boundsCheck(offset, (((long) value.length()) + 1) * ((long) Native.WCHAR_SIZE));
        setWideString(offset, value);
    }

    @Override // com.sun.jna.Pointer
    public String toString() {
        return "allocated@0x" + Long.toHexString(this.peer) + " (" + this.size + " bytes)";
    }

    protected static void free(long p) {
        if (p != 0) {
            Native.free(p);
        }
    }

    protected static long malloc(long size) {
        return Native.malloc(size);
    }

    public String dump() {
        return dump(0, (int) size());
    }

    private Pointer shareReferenceIfInBounds(Pointer target) {
        if (target == null) {
            return null;
        }
        long offset = target.peer - this.peer;
        if (offset < 0 || offset >= this.size) {
            return target;
        }
        return share(offset);
    }
}
