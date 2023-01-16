package com.zaxxer.hikari.util;

import java.sql.Connection;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.bytebuddy.ClassFileVersion;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/util/UtilityElf.class */
public final class UtilityElf {
    public static String getNullIfEmpty(String text) {
        if (text != null && !text.trim().isEmpty()) {
            return text.trim();
        }
        return null;
    }

    public static void quietlySleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }

    public static <T> T createInstance(String className, Class<T> clazz, Object... args) {
        if (className == null) {
            return null;
        }
        try {
            Class<?> loaded = UtilityElf.class.getClassLoader().loadClass(className);
            if (args.length == 0) {
                return clazz.cast(loaded.newInstance());
            }
            Class<?>[] argClasses = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                argClasses[i] = args[i].getClass();
            }
            return clazz.cast(loaded.getConstructor(argClasses).newInstance(args));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ThreadPoolExecutor createThreadPoolExecutor(int queueSize, String threadName, ThreadFactory threadFactory, RejectedExecutionHandler policy) {
        if (threadFactory == null) {
            threadFactory = new DefaultThreadFactory(threadName, true);
        }
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(queueSize), threadFactory, policy);
        executor.allowCoreThreadTimeOut(true);
        return executor;
    }

    public static ThreadPoolExecutor createThreadPoolExecutor(BlockingQueue<Runnable> queue, String threadName, ThreadFactory threadFactory, RejectedExecutionHandler policy) {
        if (threadFactory == null) {
            threadFactory = new DefaultThreadFactory(threadName, true);
        }
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, queue, threadFactory, policy);
        executor.allowCoreThreadTimeOut(true);
        return executor;
    }

    public static int getTransactionIsolation(String transactionIsolationName) {
        if (transactionIsolationName == null) {
            return -1;
        }
        try {
            String upperName = transactionIsolationName.toUpperCase(Locale.ENGLISH);
            if (upperName.startsWith("TRANSACTION_")) {
                return Connection.class.getField(upperName).getInt(null);
            }
            int level = Integer.parseInt(transactionIsolationName);
            switch (level) {
                case 0:
                case 1:
                case 2:
                case 4:
                case 8:
                    return level;
                case 3:
                case 5:
                case 6:
                case 7:
                default:
                    throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid transaction isolation value: " + transactionIsolationName);
        }
    }

    public static boolean isJdk8Plus() {
        Matcher matcher = Pattern.compile("(?:(\\d+(?:\\.?\\d*)))").matcher(System.getProperty(ClassFileVersion.VersionLocator.JAVA_VERSION));
        return matcher.find() && Float.parseFloat(matcher.group(1)) > 1.7f;
    }

    /* loaded from: grasscutter.jar:com/zaxxer/hikari/util/UtilityElf$DefaultThreadFactory.class */
    public static final class DefaultThreadFactory implements ThreadFactory {
        private final String threadName;
        private final boolean daemon;

        public DefaultThreadFactory(String threadName, boolean daemon) {
            this.threadName = threadName;
            this.daemon = daemon;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r, this.threadName);
            thread.setDaemon(this.daemon);
            return thread;
        }
    }
}
