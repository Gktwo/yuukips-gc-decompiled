package org.quartz.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.RMISecurityManager;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.listeners.SchedulerListenerSupport;

/* loaded from: grasscutter.jar:org/quartz/impl/QuartzServer.class */
public class QuartzServer extends SchedulerListenerSupport {
    private Scheduler sched = null;

    QuartzServer() {
    }

    public void serve(SchedulerFactory schedFact, boolean console) throws Exception {
        this.sched = schedFact.getScheduler();
        this.sched.start();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        System.out.println("\n*** The scheduler successfully started.");
        if (console) {
            System.out.println("\n");
            System.out.println("The scheduler will now run until you type \"exit\"");
            System.out.println("   If it was configured to export itself via RMI,");
            System.out.println("   then other process may now use it.");
            BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
            do {
                System.out.print("Type 'exit' to shutdown the server: ");
            } while (!"exit".equals(rdr.readLine()));
            System.out.println("\n...Shutting down server...");
            this.sched.shutdown(true);
        }
    }

    @Override // org.quartz.listeners.SchedulerListenerSupport, org.quartz.SchedulerListener
    public void schedulerError(String msg, SchedulerException cause) {
        System.err.println("*** " + msg);
        cause.printStackTrace();
    }

    @Override // org.quartz.listeners.SchedulerListenerSupport, org.quartz.SchedulerListener
    public void schedulerShutdown() {
        System.out.println("\n*** The scheduler is now shutdown.");
        this.sched = null;
    }

    public static void main(String[] args) throws Exception {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            QuartzServer server = new QuartzServer();
            if (args.length == 0) {
                server.serve(new StdSchedulerFactory(), false);
            } else if (args.length != 1 || !args[0].equalsIgnoreCase("console")) {
                System.err.println("\nUsage: QuartzServer [console]");
            } else {
                server.serve(new StdSchedulerFactory(), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
