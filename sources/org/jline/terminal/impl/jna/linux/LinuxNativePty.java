package org.jline.terminal.impl.jna.linux;

import com.sun.jna.LastErrorException;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import java.io.FileDescriptor;
import java.io.IOException;
import org.jline.terminal.Attributes;
import org.jline.terminal.Size;
import org.jline.terminal.impl.jna.JnaNativePty;
import org.jline.terminal.impl.jna.linux.CLibrary;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/linux/LinuxNativePty.class */
public class LinuxNativePty extends JnaNativePty {
    private static final CLibrary C_LIBRARY = (CLibrary) Native.load(Platform.C_LIBRARY_NAME, CLibrary.class);

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/linux/LinuxNativePty$UtilLibrary.class */
    public interface UtilLibrary extends Library {
        public static final UtilLibrary INSTANCE = (UtilLibrary) Native.load("util", UtilLibrary.class);

        void openpty(int[] iArr, int[] iArr2, byte[] bArr, CLibrary.termios termios, CLibrary.winsize winsize) throws LastErrorException;
    }

    public static LinuxNativePty current() throws IOException {
        byte[] buf = new byte[64];
        C_LIBRARY.ttyname_r(0, buf, buf.length);
        int len = 0;
        while (buf[len] != 0) {
            len++;
        }
        return new LinuxNativePty(-1, null, 0, FileDescriptor.in, 1, FileDescriptor.out, new String(buf, 0, len));
    }

    public static LinuxNativePty open(Attributes attr, Size size) throws IOException {
        int[] master = new int[1];
        int[] slave = new int[1];
        byte[] buf = new byte[64];
        UtilLibrary.INSTANCE.openpty(master, slave, buf, attr != null ? new CLibrary.termios(attr) : null, size != null ? new CLibrary.winsize(size) : null);
        int len = 0;
        while (buf[len] != 0) {
            len++;
        }
        return new LinuxNativePty(master[0], newDescriptor(master[0]), slave[0], newDescriptor(slave[0]), new String(buf, 0, len));
    }

    public LinuxNativePty(int master, FileDescriptor masterFD, int slave, FileDescriptor slaveFD, String name) {
        super(master, masterFD, slave, slaveFD, name);
    }

    public LinuxNativePty(int master, FileDescriptor masterFD, int slave, FileDescriptor slaveFD, int slaveOut, FileDescriptor slaveOutFD, String name) {
        super(master, masterFD, slave, slaveFD, slaveOut, slaveOutFD, name);
    }

    @Override // org.jline.terminal.spi.Pty
    public Attributes getAttr() throws IOException {
        CLibrary.termios termios = new CLibrary.termios();
        C_LIBRARY.tcgetattr(getSlave(), termios);
        return termios.toAttributes();
    }

    @Override // org.jline.terminal.impl.AbstractPty
    protected void doSetAttr(Attributes attr) throws IOException {
        CLibrary.termios termios = new CLibrary.termios(attr);
        CLibrary.termios org2 = new CLibrary.termios();
        C_LIBRARY.tcgetattr(getSlave(), org2);
        org2.c_iflag = termios.c_iflag;
        org2.c_oflag = termios.c_oflag;
        org2.c_lflag = termios.c_lflag;
        System.arraycopy(termios.c_cc, 0, org2.c_cc, 0, termios.c_cc.length);
        C_LIBRARY.tcsetattr(getSlave(), 1, org2);
    }

    @Override // org.jline.terminal.spi.Pty
    public Size getSize() throws IOException {
        CLibrary.winsize sz = new CLibrary.winsize();
        C_LIBRARY.ioctl(getSlave(), CLibrary.TIOCGWINSZ, sz);
        return sz.toSize();
    }

    @Override // org.jline.terminal.spi.Pty
    public void setSize(Size size) throws IOException {
        C_LIBRARY.ioctl(getSlave(), CLibrary.TIOCSWINSZ, new CLibrary.winsize(size));
    }

    public static int isatty(int fd) {
        return C_LIBRARY.isatty(fd);
    }
}
