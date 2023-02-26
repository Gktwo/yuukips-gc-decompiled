package com.mongodb.internal.connection.tlschannel.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/util/DirectBufferDeallocator.class */
public class DirectBufferDeallocator {
    private static Logger logger = LoggerFactory.getLogger(DirectBufferDeallocator.class);
    private final Deallocator deallocator;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/util/DirectBufferDeallocator$Deallocator.class */
    public interface Deallocator {
        void free(ByteBuffer byteBuffer);
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/util/DirectBufferDeallocator$Java8Deallocator.class */
    private static class Java8Deallocator implements Deallocator {
        final Method cleanerAccessor;
        final Method clean;

        Java8Deallocator() {
            try {
                this.cleanerAccessor = Class.forName("sun.nio.ch.DirectBuffer").getMethod("cleaner", null);
                this.clean = Class.forName("sun.misc.Cleaner").getMethod("clean", new Class[0]);
            } catch (ClassNotFoundException | NoSuchMethodException t) {
                throw new RuntimeException(t);
            }
        }

        @Override // com.mongodb.internal.connection.tlschannel.util.DirectBufferDeallocator.Deallocator
        public void free(ByteBuffer bb) {
            try {
                this.clean.invoke(this.cleanerAccessor.invoke(bb, new Object[0]), new Object[0]);
            } catch (IllegalAccessException | InvocationTargetException t) {
                throw new RuntimeException(t);
            }
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/util/DirectBufferDeallocator$Java9Deallocator.class */
    private static class Java9Deallocator implements Deallocator {
        final Object unsafe;
        final Method invokeCleaner;

        Java9Deallocator() {
            try {
                Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
                Field theUnsafe = unsafeClass.getDeclaredField("theUnsafe");
                theUnsafe.setAccessible(true);
                this.unsafe = theUnsafe.get(null);
                this.invokeCleaner = unsafeClass.getMethod("invokeCleaner", ByteBuffer.class);
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException t) {
                throw new RuntimeException(t);
            }
        }

        @Override // com.mongodb.internal.connection.tlschannel.util.DirectBufferDeallocator.Deallocator
        public void free(ByteBuffer bb) {
            try {
                this.invokeCleaner.invoke(this.unsafe, bb);
            } catch (IllegalAccessException | InvocationTargetException t) {
                throw new RuntimeException(t);
            }
        }
    }

    public DirectBufferDeallocator() {
        if (Util.getJavaMajorVersion() >= 9) {
            this.deallocator = new Java9Deallocator();
            logger.debug("initialized direct buffer deallocator for java >= 9");
            return;
        }
        this.deallocator = new Java8Deallocator();
        logger.debug("initialized direct buffer deallocator for java < 9");
    }

    public void deallocate(ByteBuffer buffer) {
        this.deallocator.free(buffer);
    }
}
