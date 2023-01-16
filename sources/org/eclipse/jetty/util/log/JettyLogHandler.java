package org.eclipse.jetty.util.log;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.regex.Pattern;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/log/JettyLogHandler.class */
public class JettyLogHandler extends Handler {
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:9:0x003a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static void config() {
        /*
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.ClassLoader r0 = r0.getContextClassLoader()
            r7 = r0
            r0 = r7
            java.lang.String r1 = "logging.properties"
            java.net.URL r0 = r0.getResource(r1)
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L_0x005e
            java.io.PrintStream r0 = java.lang.System.err
            java.lang.String r1 = "Initializing java.util.logging from %s%n"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r8
            r3[r4] = r5
            java.io.PrintStream r0 = r0.printf(r1, r2)
            r0 = r8
            java.io.InputStream r0 = r0.openStream()     // Catch: IOException -> 0x0053
            r9 = r0
            java.util.logging.LogManager r0 = java.util.logging.LogManager.getLogManager()     // Catch: Throwable -> 0x003a, IOException -> 0x0053
            r1 = r9
            r0.readConfiguration(r1)     // Catch: Throwable -> 0x003a, IOException -> 0x0053
            r0 = r9
            if (r0 == 0) goto L_0x0050
            r0 = r9
            r0.close()     // Catch: IOException -> 0x0053
            goto L_0x0050
        L_0x003a:
            r10 = move-exception
            r0 = r9
            if (r0 == 0) goto L_0x004e
            r0 = r9
            r0.close()     // Catch: Throwable -> 0x0046, IOException -> 0x0053
            goto L_0x004e
        L_0x0046:
            r11 = move-exception
            r0 = r10
            r1 = r11
            r0.addSuppressed(r1)     // Catch: IOException -> 0x0053
        L_0x004e:
            r0 = r10
            throw r0     // Catch: IOException -> 0x0053
        L_0x0050:
            goto L_0x006b
        L_0x0053:
            r9 = move-exception
            r0 = r9
            java.io.PrintStream r1 = java.lang.System.err
            r0.printStackTrace(r1)
            goto L_0x006b
        L_0x005e:
            java.io.PrintStream r0 = java.lang.System.err
            java.lang.String r1 = "WARNING: java.util.logging failed to initialize: logging.properties not found%n"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.io.PrintStream r0 = r0.printf(r1, r2)
        L_0x006b:
            java.lang.String r0 = "org.apache.commons.logging.Log"
            java.lang.String r1 = "org.apache.commons.logging.impl.Jdk14Logger"
            java.lang.String r0 = java.lang.System.setProperty(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.log.JettyLogHandler.config():void");
    }

    public JettyLogHandler() {
        if (Boolean.parseBoolean(Log.__props.getProperty("org.eclipse.jetty.util.log.DEBUG", "false"))) {
            setLevel(Level.FINEST);
        }
        if (Boolean.parseBoolean(Log.__props.getProperty("org.eclipse.jetty.util.log.IGNORED", "false"))) {
            setLevel(Level.ALL);
        }
        System.err.printf("%s Initialized at level [%s]%n", getClass().getName(), getLevel().getName());
    }

    private synchronized String formatMessage(LogRecord record) {
        String msg = getMessage(record);
        try {
            Object[] params = record.getParameters();
            if (params == null || params.length == 0) {
                return msg;
            }
            if (Pattern.compile("\\{\\d+\\}").matcher(msg).find()) {
                return MessageFormat.format(msg, params);
            }
            return msg;
        } catch (Exception e) {
            return msg;
        }
    }

    private String getMessage(LogRecord record) {
        ResourceBundle bundle = record.getResourceBundle();
        if (bundle != null) {
            try {
                return bundle.getString(record.getMessage());
            } catch (MissingResourceException e) {
            }
        }
        return record.getMessage();
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord record) {
        Logger jettyLogger = getJettyLogger(record.getLoggerName());
        int level = record.getLevel().intValue();
        if (level < Level.OFF.intValue()) {
            Throwable cause = record.getThrown();
            String msg = formatMessage(record);
            if (level >= Level.WARNING.intValue()) {
                if (cause != null) {
                    jettyLogger.warn(msg, cause);
                } else {
                    jettyLogger.warn(msg, new Object[0]);
                }
            } else if (level >= Level.INFO.intValue()) {
                if (cause != null) {
                    jettyLogger.info(msg, cause);
                } else {
                    jettyLogger.info(msg, new Object[0]);
                }
            } else if (level >= Level.FINEST.intValue()) {
                if (cause != null) {
                    jettyLogger.debug(msg, cause);
                } else {
                    jettyLogger.debug(msg, new Object[0]);
                }
            } else if (level >= Level.ALL.intValue()) {
                jettyLogger.ignore(cause);
            }
        }
    }

    private Logger getJettyLogger(String loggerName) {
        return Log.getLogger(loggerName);
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    @Override // java.util.logging.Handler
    public void close() throws SecurityException {
    }
}
