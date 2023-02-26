package org.jline.terminal.impl.jansi;

import java.io.IOException;
import java.nio.charset.Charset;
import org.jline.terminal.Attributes;
import org.jline.terminal.Size;
import org.jline.terminal.Terminal;
import org.jline.terminal.impl.jansi.freebsd.FreeBsdNativePty;
import org.jline.terminal.impl.jansi.linux.LinuxNativePty;
import org.jline.terminal.impl.jansi.osx.OsXNativePty;
import org.jline.terminal.impl.jansi.win.JansiWinSysTerminal;
import org.jline.terminal.spi.JansiSupport;
import org.jline.terminal.spi.Pty;
import org.jline.utils.OSUtils;

/* loaded from: grasscutter.jar:org/jline/terminal/impl/jansi/JansiSupportImpl.class */
public class JansiSupportImpl implements JansiSupport {
    static final int JANSI_MAJOR_VERSION;
    static final int JANSI_MINOR_VERSION;

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:11:0x0034
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    static {
        /*
            r0 = 0
            r3 = r0
            r0 = 0
            r4 = r0
            r0 = 0
            r5 = r0
            java.lang.Class<org.fusesource.jansi.AnsiConsole> r0 = org.fusesource.jansi.AnsiConsole.class
            java.lang.String r1 = "jansi.properties"
            java.io.InputStream r0 = r0.getResourceAsStream(r1)     // Catch: IOException -> 0x0050, Throwable -> 0x0088
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L_0x0029
            java.util.Properties r0 = new java.util.Properties     // Catch: IOException -> 0x0050, Throwable -> 0x0034, Throwable -> 0x0088
            r1 = r0
            r1.<init>()     // Catch: IOException -> 0x0050, Throwable -> 0x0034, Throwable -> 0x0088
            r7 = r0
            r0 = r7
            r1 = r6
            r0.load(r1)     // Catch: IOException -> 0x0050, Throwable -> 0x0034, Throwable -> 0x0088
            r0 = r7
            java.lang.String r1 = "version"
            java.lang.String r0 = r0.getProperty(r1)     // Catch: IOException -> 0x0050, Throwable -> 0x0034, Throwable -> 0x0088
            r5 = r0
        L_0x0029:
            r0 = r6
            if (r0 == 0) goto L_0x004d
            r0 = r6
            r0.close()     // Catch: IOException -> 0x0050, Throwable -> 0x0088
            goto L_0x004d
        L_0x0034:
            r7 = move-exception
            r0 = r6
            if (r0 == 0) goto L_0x004a
            r0 = r6
            r0.close()     // Catch: Throwable -> 0x0041, IOException -> 0x0050, Throwable -> 0x0088
            goto L_0x004a
        L_0x0041:
            r8 = move-exception
            r0 = r7
            r1 = r8
            r0.addSuppressed(r1)     // Catch: IOException -> 0x0050, Throwable -> 0x0088
        L_0x004a:
            r0 = r7
            throw r0     // Catch: IOException -> 0x0050, Throwable -> 0x0088
        L_0x004d:
            goto L_0x0051
        L_0x0050:
            r6 = move-exception
        L_0x0051:
            r0 = r5
            if (r0 != 0) goto L_0x005e
            java.lang.Class<org.fusesource.jansi.AnsiConsole> r0 = org.fusesource.jansi.AnsiConsole.class
            java.lang.Package r0 = r0.getPackage()     // Catch: Throwable -> 0x0088
            java.lang.String r0 = r0.getImplementationVersion()     // Catch: Throwable -> 0x0088
            r5 = r0
        L_0x005e:
            r0 = r5
            if (r0 == 0) goto L_0x0085
            java.lang.String r0 = "([0-9]+)\\.([0-9]+)([\\.-]\\S+)?"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch: Throwable -> 0x0088
            r1 = r5
            java.util.regex.Matcher r0 = r0.matcher(r1)     // Catch: Throwable -> 0x0088
            r6 = r0
            r0 = r6
            boolean r0 = r0.matches()     // Catch: Throwable -> 0x0088
            if (r0 == 0) goto L_0x0085
            r0 = r6
            r1 = 1
            java.lang.String r0 = r0.group(r1)     // Catch: Throwable -> 0x0088
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: Throwable -> 0x0088
            r3 = r0
            r0 = r6
            r1 = 2
            java.lang.String r0 = r0.group(r1)     // Catch: Throwable -> 0x0088
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: Throwable -> 0x0088
            r4 = r0
        L_0x0085:
            goto L_0x0089
        L_0x0088:
            r5 = move-exception
        L_0x0089:
            r0 = r3
            org.jline.terminal.impl.jansi.JansiSupportImpl.JANSI_MAJOR_VERSION = r0
            r0 = r4
            org.jline.terminal.impl.jansi.JansiSupportImpl.JANSI_MINOR_VERSION = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.terminal.impl.jansi.JansiSupportImpl.m10122clinit():void");
    }

    public static int getJansiMajorVersion() {
        return JANSI_MAJOR_VERSION;
    }

    public static int getJansiMinorVersion() {
        return JANSI_MINOR_VERSION;
    }

    public static boolean isAtLeast(int major, int minor) {
        return JANSI_MAJOR_VERSION > major || (JANSI_MAJOR_VERSION == major && JANSI_MINOR_VERSION >= minor);
    }

    @Override // org.jline.terminal.spi.JansiSupport
    public Pty current() throws IOException {
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Linux")) {
            return LinuxNativePty.current();
        }
        if (osName.startsWith("Mac") || osName.startsWith("Darwin")) {
            return OsXNativePty.current();
        }
        if (!osName.startsWith("Solaris") && !osName.startsWith("SunOS") && osName.startsWith("FreeBSD") && isAtLeast(1, 16)) {
            return FreeBsdNativePty.current();
        }
        throw new UnsupportedOperationException();
    }

    @Override // org.jline.terminal.spi.JansiSupport
    public Pty open(Attributes attributes, Size size) throws IOException {
        if (isAtLeast(1, 16)) {
            String osName = System.getProperty("os.name");
            if (osName.startsWith("Linux")) {
                return LinuxNativePty.open(attributes, size);
            }
            if (osName.startsWith("Mac") || osName.startsWith("Darwin")) {
                return OsXNativePty.open(attributes, size);
            }
            if (!osName.startsWith("Solaris") && !osName.startsWith("SunOS") && osName.startsWith("FreeBSD")) {
                return FreeBsdNativePty.open(attributes, size);
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override // org.jline.terminal.spi.JansiSupport
    public Terminal winSysTerminal(String name, String type, boolean ansiPassThrough, Charset encoding, int codepage, boolean nativeSignals, Terminal.SignalHandler signalHandler) throws IOException {
        return winSysTerminal(name, type, ansiPassThrough, encoding, codepage, nativeSignals, signalHandler, false);
    }

    @Override // org.jline.terminal.spi.JansiSupport
    public Terminal winSysTerminal(String name, String type, boolean ansiPassThrough, Charset encoding, int codepage, boolean nativeSignals, Terminal.SignalHandler signalHandler, boolean paused) throws IOException {
        if (isAtLeast(1, 12)) {
            JansiWinSysTerminal terminal = JansiWinSysTerminal.createTerminal(name, type, ansiPassThrough, encoding, codepage, nativeSignals, signalHandler, paused);
            if (!isAtLeast(1, 16)) {
                terminal.disableScrolling();
            }
            return terminal;
        }
        throw new UnsupportedOperationException();
    }

    @Override // org.jline.terminal.spi.JansiSupport
    public boolean isWindowsConsole() {
        return JansiWinSysTerminal.isWindowsConsole();
    }

    @Override // org.jline.terminal.spi.JansiSupport
    public boolean isConsoleOutput() {
        if (OSUtils.IS_CYGWIN || OSUtils.IS_MSYSTEM) {
            if (isAtLeast(2, 1)) {
                return JansiNativePty.isConsoleOutput();
            }
            throw new UnsupportedOperationException();
        } else if (OSUtils.IS_WINDOWS) {
            return JansiWinSysTerminal.isConsoleOutput();
        } else {
            return JansiNativePty.isConsoleOutput();
        }
    }

    @Override // org.jline.terminal.spi.JansiSupport
    public boolean isConsoleInput() {
        if (OSUtils.IS_CYGWIN || OSUtils.IS_MSYSTEM) {
            if (isAtLeast(2, 1)) {
                return JansiNativePty.isConsoleInput();
            }
            throw new UnsupportedOperationException();
        } else if (OSUtils.IS_WINDOWS) {
            return JansiWinSysTerminal.isConsoleInput();
        } else {
            return JansiNativePty.isConsoleInput();
        }
    }
}
