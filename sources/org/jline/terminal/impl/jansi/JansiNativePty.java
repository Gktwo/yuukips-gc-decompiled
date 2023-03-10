package org.jline.terminal.impl.jansi;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import org.fusesource.jansi.internal.CLibrary;
import org.jline.terminal.Attributes;
import org.jline.terminal.Size;
import org.jline.terminal.impl.AbstractPty;
import org.jline.terminal.spi.Pty;
import org.jline.utils.ExecHelper;
import org.jline.utils.OSUtils;

/* loaded from: grasscutter.jar:org/jline/terminal/impl/jansi/JansiNativePty.class */
public abstract class JansiNativePty extends AbstractPty implements Pty {
    private final int master;
    private final int slave;
    private final int slaveOut;
    private final String name;
    private final FileDescriptor masterFD;
    private final FileDescriptor slaveFD;
    private final FileDescriptor slaveOutFD;

    protected abstract CLibrary.Termios toTermios(Attributes attributes);

    protected abstract Attributes toAttributes(CLibrary.Termios termios);

    public JansiNativePty(int master, FileDescriptor masterFD, int slave, FileDescriptor slaveFD, String name) {
        this(master, masterFD, slave, slaveFD, slave, slaveFD, name);
    }

    public JansiNativePty(int master, FileDescriptor masterFD, int slave, FileDescriptor slaveFD, int slaveOut, FileDescriptor slaveOutFD, String name) {
        this.master = master;
        this.slave = slave;
        this.slaveOut = slaveOut;
        this.name = name;
        this.masterFD = masterFD;
        this.slaveFD = slaveFD;
        this.slaveOutFD = slaveOutFD;
    }

    protected static String ttyname() throws IOException {
        String name;
        if (JansiSupportImpl.JANSI_MAJOR_VERSION > 1 || (JansiSupportImpl.JANSI_MAJOR_VERSION == 1 && JansiSupportImpl.JANSI_MINOR_VERSION >= 16)) {
            name = CLibrary.ttyname(0);
        } else {
            try {
                name = ExecHelper.exec(true, OSUtils.TTY_COMMAND);
            } catch (IOException e) {
                throw new IOException("Not a tty", e);
            }
        }
        if (name != null) {
            name = name.trim();
        }
        if (name != null && !name.isEmpty()) {
            return name;
        }
        throw new IOException("Not a tty");
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

    @Override // org.jline.terminal.spi.Pty
    public Attributes getAttr() throws IOException {
        CLibrary.Termios tios = new CLibrary.Termios();
        CLibrary.tcgetattr(this.slave, tios);
        return toAttributes(tios);
    }

    @Override // org.jline.terminal.impl.AbstractPty
    protected void doSetAttr(Attributes attr) throws IOException {
        CLibrary.tcsetattr(this.slave, CLibrary.TCSANOW, toTermios(attr));
    }

    @Override // org.jline.terminal.spi.Pty
    public Size getSize() throws IOException {
        CLibrary.WinSize sz = new CLibrary.WinSize();
        CLibrary.ioctl(this.slave, CLibrary.TIOCGWINSZ, sz);
        return new Size(sz.ws_col, sz.ws_row);
    }

    @Override // org.jline.terminal.spi.Pty
    public void setSize(Size size) throws IOException {
        CLibrary.ioctl(this.slave, CLibrary.TIOCSWINSZ, new CLibrary.WinSize((short) size.getRows(), (short) size.getColumns()));
    }

    @Override // java.lang.Object
    public String toString() {
        return "JansiNativePty[" + getName() + "]";
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

    public static boolean isConsoleOutput() {
        return CLibrary.isatty(1) == 1;
    }

    public static boolean isConsoleInput() {
        return CLibrary.isatty(0) == 1;
    }
}
