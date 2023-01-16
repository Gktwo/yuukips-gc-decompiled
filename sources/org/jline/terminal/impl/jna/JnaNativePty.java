package org.jline.terminal.impl.jna;

import com.sun.jna.Platform;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import org.jline.terminal.Attributes;
import org.jline.terminal.Size;
import org.jline.terminal.impl.AbstractPty;
import org.jline.terminal.impl.jna.freebsd.FreeBsdNativePty;
import org.jline.terminal.impl.jna.linux.LinuxNativePty;
import org.jline.terminal.impl.jna.osx.OsXNativePty;
import org.jline.terminal.impl.jna.solaris.SolarisNativePty;
import org.jline.terminal.spi.Pty;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/JnaNativePty.class */
public abstract class JnaNativePty extends AbstractPty implements Pty {
    private final int master;
    private final int slave;
    private final int slaveOut;
    private final String name;
    private final FileDescriptor masterFD;
    private final FileDescriptor slaveFD;
    private final FileDescriptor slaveOutFD;

    public static JnaNativePty current() throws IOException {
        if (Platform.isMac()) {
            if (!Platform.is64Bit() || !Platform.isARM()) {
                return OsXNativePty.current();
            }
            throw new UnsupportedOperationException();
        } else if (Platform.isLinux()) {
            return LinuxNativePty.current();
        } else {
            if (Platform.isSolaris()) {
                return SolarisNativePty.current();
            }
            if (Platform.isFreeBSD()) {
                return FreeBsdNativePty.current();
            }
            throw new UnsupportedOperationException();
        }
    }

    public static JnaNativePty open(Attributes attr, Size size) throws IOException {
        if (Platform.isMac()) {
            return OsXNativePty.open(attr, size);
        }
        if (Platform.isLinux()) {
            return LinuxNativePty.open(attr, size);
        }
        if (Platform.isSolaris()) {
            return SolarisNativePty.open(attr, size);
        }
        if (Platform.isFreeBSD()) {
            return FreeBsdNativePty.open(attr, size);
        }
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    public JnaNativePty(int master, FileDescriptor masterFD, int slave, FileDescriptor slaveFD, String name) {
        this(master, masterFD, slave, slaveFD, slave, slaveFD, name);
    }

    /* access modifiers changed from: protected */
    public JnaNativePty(int master, FileDescriptor masterFD, int slave, FileDescriptor slaveFD, int slaveOut, FileDescriptor slaveOutFD, String name) {
        this.master = master;
        this.slave = slave;
        this.slaveOut = slaveOut;
        this.name = name;
        this.masterFD = masterFD;
        this.slaveFD = slaveFD;
        this.slaveOutFD = slaveOutFD;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.master > 0) {
            getMasterInput().close();
        }
        if (this.slave > 0) {
            getSlaveInput().close();
        }
    }

    public int getMaster() {
        return this.master;
    }

    public int getSlave() {
        return this.slave;
    }

    public int getSlaveOut() {
        return this.slaveOut;
    }

    public String getName() {
        return this.name;
    }

    public FileDescriptor getMasterFD() {
        return this.masterFD;
    }

    public FileDescriptor getSlaveFD() {
        return this.slaveFD;
    }

    public FileDescriptor getSlaveOutFD() {
        return this.slaveOutFD;
    }

    @Override // org.jline.terminal.spi.Pty
    public InputStream getMasterInput() {
        return new FileInputStream(getMasterFD());
    }

    @Override // org.jline.terminal.spi.Pty
    public OutputStream getMasterOutput() {
        return new FileOutputStream(getMasterFD());
    }

    @Override // org.jline.terminal.impl.AbstractPty
    protected InputStream doGetSlaveInput() {
        return new FileInputStream(getSlaveFD());
    }

    @Override // org.jline.terminal.spi.Pty
    public OutputStream getSlaveOutput() {
        return new FileOutputStream(getSlaveOutFD());
    }

    protected static FileDescriptor newDescriptor(int fd) {
        try {
            Constructor<FileDescriptor> cns = FileDescriptor.class.getDeclaredConstructor(Integer.TYPE);
            cns.setAccessible(true);
            return cns.newInstance(Integer.valueOf(fd));
        } catch (Throwable e) {
            throw new RuntimeException("Unable to create FileDescriptor", e);
        }
    }

    @Override // java.lang.Object
    public String toString() {
        return "JnaNativePty[" + getName() + "]";
    }

    public static boolean isConsoleOutput() {
        return isatty(1);
    }

    public static boolean isConsoleInput() {
        return isatty(0);
    }

    private static boolean isatty(int fd) {
        return Platform.isMac() ? OsXNativePty.isatty(fd) == 1 : Platform.isLinux() ? LinuxNativePty.isatty(fd) == 1 : Platform.isSolaris() ? SolarisNativePty.isatty(fd) == 1 : Platform.isFreeBSD() && FreeBsdNativePty.isatty(fd) == 1;
    }
}
