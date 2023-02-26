package com.mchange.p009v2.c3p0.test;

import com.mchange.p009v2.c3p0.ComboPooledDataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.sql.DataSource;

/* renamed from: com.mchange.v2.c3p0.test.ConnectionDispersionTest */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/ConnectionDispersionTest.class */
public final class ConnectionDispersionTest {
    private static final int DELAY_TIME = 120000;
    private static final int NUM_THREADS = 600;
    private static DataSource cpds;
    private static final Integer ZERO = new Integer(0);
    private static boolean should_go = false;
    private static int ready_count = 0;

    private static synchronized void setDataSource(DataSource ds) {
        cpds = ds;
    }

    /* access modifiers changed from: private */
    public static synchronized DataSource getDataSource() {
        return cpds;
    }

    /* access modifiers changed from: private */
    public static synchronized int ready() {
        int i = ready_count + 1;
        ready_count = i;
        return i;
    }

    private static synchronized boolean isReady() {
        return ready_count == NUM_THREADS;
    }

    private static synchronized void start() {
        should_go = true;
        ConnectionDispersionTest.class.notifyAll();
    }

    private static synchronized void stop() {
        should_go = false;
        ConnectionDispersionTest.class.notifyAll();
    }

    /* access modifiers changed from: private */
    public static synchronized boolean shouldGo() {
        return should_go;
    }

    public static void main(String[] argv) {
        String jdbc_url = null;
        String username = null;
        String password = null;
        if (argv.length == 3) {
            jdbc_url = argv[0];
            username = argv[1];
            password = argv[2];
        } else if (argv.length == 1) {
            jdbc_url = argv[0];
            username = null;
            password = null;
        } else {
            usage();
        }
        if (!jdbc_url.startsWith("jdbc:")) {
            usage();
        }
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setJdbcUrl(jdbc_url);
            ds.setUser(username);
            ds.setPassword(password);
            setDataSource(ds);
            ds.getConnection().close();
            System.err.println("Generating thread list...");
            List threads = new ArrayList((int) NUM_THREADS);
            for (int i = 0; i < NUM_THREADS; i++) {
                CompeteThread competeThread = new CompeteThread();
                competeThread.start();
                threads.add(competeThread);
                Thread.currentThread();
                Thread.yield();
            }
            System.err.println("Thread list generated.");
            synchronized (ConnectionDispersionTest.class) {
                while (!isReady()) {
                    ConnectionDispersionTest.class.wait();
                }
            }
            System.err.println("Starting the race.");
            start();
            System.err.println("Sleeping 120.0 seconds to let the race run");
            Thread.sleep(120000);
            System.err.println("Stopping the race.");
            stop();
            System.err.println("Waiting for Threads to complete.");
            for (int i2 = 0; i2 < NUM_THREADS; i2++) {
                ((Thread) threads.get(i2)).join();
            }
            Map outcomeMap = new TreeMap();
            for (int i3 = 0; i3 < NUM_THREADS; i3++) {
                Integer outcome = new Integer(((CompeteThread) threads.get(i3)).getCount());
                Integer old = (Integer) outcomeMap.get(outcome);
                if (old == null) {
                    old = ZERO;
                }
                outcomeMap.put(outcome, new Integer(old.intValue() + 1));
            }
            int last = 0;
            for (Integer outcome2 : outcomeMap.keySet()) {
                Integer count = (Integer) outcomeMap.get(outcome2);
                int oc = outcome2.intValue();
                int c = count.intValue();
                while (last < oc) {
                    System.out.println(String.valueOf(10000 + last).substring(1) + ": ");
                    last++;
                }
                last++;
                System.out.print(String.valueOf(10000 + oc).substring(1) + ": ");
                for (int i4 = 0; i4 < c; i4++) {
                    System.out.print('*');
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: com.mchange.v2.c3p0.test.ConnectionDispersionTest$CompeteThread */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/ConnectionDispersionTest$CompeteThread.class */
    static class CompeteThread extends Thread {

        /* renamed from: ds */
        DataSource f402ds;
        int count;

        CompeteThread() {
        }

        synchronized void increment() {
            this.count++;
        }

        synchronized int getCount() {
            return this.count;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:28:0x0077
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            /*
            // Method dump skipped, instructions count: 220
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.test.ConnectionDispersionTest.CompeteThread.run():void");
        }
    }

    private static void usage() {
        System.err.println("java -Djdbc.drivers=<comma_sep_list_of_drivers> " + ConnectionDispersionTest.class.getName() + " <jdbc_url> [<username> <password>]");
        System.exit(-1);
    }
}
