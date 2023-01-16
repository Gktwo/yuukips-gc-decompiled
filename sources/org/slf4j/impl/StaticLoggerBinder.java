package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.classic.util.ContextSelectorStaticBinder;

/* loaded from: grasscutter.jar:org/slf4j/impl/StaticLoggerBinder.class */
public class StaticLoggerBinder implements LoggerFactoryBinder {
    static final String NULL_CS_URL = "http://logback.qos.ch/codes.html#null_CS";
    private boolean initialized = false;
    private LoggerContext defaultLoggerContext = new LoggerContext();
    private final ContextSelectorStaticBinder contextSelectorBinder = ContextSelectorStaticBinder.getSingleton();
    public static String REQUESTED_API_VERSION = "1.7.16";
    private static StaticLoggerBinder SINGLETON = new StaticLoggerBinder();
    private static Object KEY = new Object();

    static {
        SINGLETON.init();
    }

    private StaticLoggerBinder() {
        this.defaultLoggerContext.setName("default");
    }

    public static StaticLoggerBinder getSingleton() {
        return SINGLETON;
    }

    static void reset() {
        SINGLETON = new StaticLoggerBinder();
        SINGLETON.init();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:3:0x0011
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    void init() {
        /*
            r4 = this;
            ch.qos.logback.classic.util.ContextInitializer r0 = new ch.qos.logback.classic.util.ContextInitializer     // Catch: Exception -> 0x003f, JoranException -> 0x0011
            r1 = r0
            r2 = r4
            ch.qos.logback.classic.LoggerContext r2 = r2.defaultLoggerContext     // Catch: Exception -> 0x003f, JoranException -> 0x0011
            r1.<init>(r2)     // Catch: Exception -> 0x003f, JoranException -> 0x0011
            r0.autoConfig()     // Catch: Exception -> 0x003f, JoranException -> 0x0011
            goto L_0x0018
        L_0x0011:
            r5 = move-exception
            java.lang.String r0 = "Failed to auto configure default logger context"
            r1 = r5
            org.slf4j.helpers.Util.report(r0, r1)     // Catch: Exception -> 0x003f
        L_0x0018:
            r0 = r4
            ch.qos.logback.classic.LoggerContext r0 = r0.defaultLoggerContext     // Catch: Exception -> 0x003f
            boolean r0 = p001ch.qos.logback.core.status.StatusUtil.contextHasStatusListener(r0)     // Catch: Exception -> 0x003f
            if (r0 != 0) goto L_0x0029
            r0 = r4
            ch.qos.logback.classic.LoggerContext r0 = r0.defaultLoggerContext     // Catch: Exception -> 0x003f
            p001ch.qos.logback.core.util.StatusPrinter.printInCaseOfErrorsOrWarnings(r0)     // Catch: Exception -> 0x003f
        L_0x0029:
            r0 = r4
            ch.qos.logback.classic.util.ContextSelectorStaticBinder r0 = r0.contextSelectorBinder     // Catch: Exception -> 0x003f
            r1 = r4
            ch.qos.logback.classic.LoggerContext r1 = r1.defaultLoggerContext     // Catch: Exception -> 0x003f
            java.lang.Object r2 = org.slf4j.impl.StaticLoggerBinder.KEY     // Catch: Exception -> 0x003f
            r0.init(r1, r2)     // Catch: Exception -> 0x003f
            r0 = r4
            r1 = 1
            r0.initialized = r1     // Catch: Exception -> 0x003f
            goto L_0x0060
        L_0x003f:
            r5 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            java.lang.String r1 = "Failed to instantiate ["
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.Class<ch.qos.logback.classic.LoggerContext> r1 = p001ch.qos.logback.classic.LoggerContext.class
            java.lang.String r1 = r1.getName()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = "]"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = r5
            org.slf4j.helpers.Util.report(r0, r1)
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.slf4j.impl.StaticLoggerBinder.init():void");
    }

    @Override // org.slf4j.spi.LoggerFactoryBinder
    public ILoggerFactory getLoggerFactory() {
        if (!this.initialized) {
            return this.defaultLoggerContext;
        }
        if (this.contextSelectorBinder.getContextSelector() != null) {
            return this.contextSelectorBinder.getContextSelector().getLoggerContext();
        }
        throw new IllegalStateException("contextSelector cannot be null. See also http://logback.qos.ch/codes.html#null_CS");
    }

    @Override // org.slf4j.spi.LoggerFactoryBinder
    public String getLoggerFactoryClassStr() {
        return this.contextSelectorBinder.getClass().getName();
    }
}
