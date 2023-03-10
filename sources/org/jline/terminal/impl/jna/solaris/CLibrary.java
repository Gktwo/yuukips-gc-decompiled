package org.jline.terminal.impl.jna.solaris;

import com.sun.jna.LastErrorException;
import com.sun.jna.Library;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import org.jline.terminal.Attributes;
import org.jline.terminal.Size;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/solaris/CLibrary.class */
public interface CLibrary extends Library {
    public static final int _TIOC = 21504;
    public static final int TIOCGWINSZ = 21608;
    public static final int TIOCSWINSZ = 21607;
    public static final int VINTR = 0;
    public static final int VQUIT = 1;
    public static final int VERASE = 2;
    public static final int VKILL = 3;
    public static final int VEOF = 4;
    public static final int VTIME = 5;
    public static final int VMIN = 6;
    public static final int VSWTC = 7;
    public static final int VSTART = 8;
    public static final int VSTOP = 9;
    public static final int VSUSP = 10;
    public static final int VEOL = 11;
    public static final int VREPRINT = 12;
    public static final int VDISCARD = 13;
    public static final int VWERASE = 14;
    public static final int VLNEXT = 15;
    public static final int VEOL2 = 16;
    public static final int IGNBRK = 1;
    public static final int BRKINT = 2;
    public static final int IGNPAR = 4;
    public static final int PARMRK = 16;
    public static final int INPCK = 32;
    public static final int ISTRIP = 64;
    public static final int INLCR = 256;
    public static final int IGNCR = 512;
    public static final int ICRNL = 1024;
    public static final int IUCLC = 4096;
    public static final int IXON = 8192;
    public static final int IXANY = 16384;
    public static final int IXOFF = 65536;
    public static final int IMAXBEL = 131072;
    public static final int IUTF8 = 262144;
    public static final int OPOST = 1;
    public static final int OLCUC = 2;
    public static final int ONLCR = 4;
    public static final int OCRNL = 16;
    public static final int ONOCR = 32;
    public static final int ONLRET = 64;
    public static final int OFILL = 256;
    public static final int OFDEL = 512;
    public static final int NLDLY = 1024;
    public static final int NL0 = 0;
    public static final int NL1 = 1024;
    public static final int CRDLY = 12288;
    public static final int CR0 = 0;
    public static final int CR1 = 4096;
    public static final int CR2 = 8192;
    public static final int CR3 = 12288;
    public static final int TABDLY = 81920;
    public static final int TAB0 = 0;
    public static final int TAB1 = 16384;
    public static final int TAB2 = 65536;
    public static final int TAB3 = 81920;
    public static final int XTABS = 81920;
    public static final int BSDLY = 131072;
    public static final int BS0 = 0;
    public static final int BS1 = 131072;
    public static final int VTDLY = 262144;
    public static final int VT0 = 0;
    public static final int VT1 = 262144;
    public static final int FFDLY = 1048576;
    public static final int FF0 = 0;
    public static final int FF1 = 1048576;
    public static final int CBAUD = 65559;

    /* renamed from: B0 */
    public static final int f3210B0 = 0;
    public static final int B50 = 1;
    public static final int B75 = 2;
    public static final int B110 = 3;
    public static final int B134 = 4;
    public static final int B150 = 5;
    public static final int B200 = 6;
    public static final int B300 = 7;
    public static final int B600 = 16;
    public static final int B1200 = 17;
    public static final int B1800 = 18;
    public static final int B2400 = 19;
    public static final int B4800 = 20;
    public static final int B9600 = 21;
    public static final int B19200 = 22;
    public static final int B38400 = 23;
    public static final int EXTA = 11637248;
    public static final int EXTB = 11764736;
    public static final int CSIZE = 96;
    public static final int CS5 = 0;
    public static final int CS6 = 32;
    public static final int CS7 = 64;
    public static final int CS8 = 96;
    public static final int CSTOPB = 256;
    public static final int CREAD = 512;
    public static final int PARENB = 1024;
    public static final int PARODD = 4096;
    public static final int HUPCL = 8192;
    public static final int CLOCAL = 16384;
    public static final int ISIG = 1;
    public static final int ICANON = 2;
    public static final int XCASE = 4;
    public static final int ECHO = 16;
    public static final int ECHOE = 32;
    public static final int ECHOK = 64;
    public static final int ECHONL = 256;
    public static final int NOFLSH = 512;
    public static final int TOSTOP = 1024;
    public static final int ECHOCTL = 4096;
    public static final int ECHOPRT = 8192;
    public static final int ECHOKE = 16384;
    public static final int FLUSHO = 65536;
    public static final int PENDIN = 262144;
    public static final int IEXTEN = 1048576;
    public static final int EXTPROC = 2097152;
    public static final int TCSANOW = 0;
    public static final int TCSADRAIN = 1;
    public static final int TCSAFLUSH = 2;

    void tcgetattr(int i, termios termios2) throws LastErrorException;

    void tcsetattr(int i, int i2, termios termios2) throws LastErrorException;

    void ioctl(int i, long j, winsize winsize2) throws LastErrorException;

    int isatty(int i);

    void ttyname_r(int i, byte[] bArr, int i2) throws LastErrorException;

    void openpty(int[] iArr, int[] iArr2, byte[] bArr, termios termios2, winsize winsize2) throws LastErrorException;

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/solaris/CLibrary$winsize.class */
    public static class winsize extends Structure {
        public short ws_row;
        public short ws_col;
        public short ws_xpixel;
        public short ws_ypixel;

        public winsize() {
        }

        public winsize(Size ws) {
            this.ws_row = (short) ws.getRows();
            this.ws_col = (short) ws.getColumns();
        }

        public Size toSize() {
            return new Size(this.ws_col, this.ws_row);
        }

        @Override // com.sun.jna.Structure
        protected List<String> getFieldOrder() {
            return Arrays.asList("ws_row", "ws_col", "ws_xpixel", "ws_ypixel");
        }
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/solaris/CLibrary$termios.class */
    public static class termios extends Structure {
        public int c_iflag;
        public int c_oflag;
        public int c_cflag;
        public int c_lflag;
        public byte[] c_cc;

        @Override // com.sun.jna.Structure
        protected List<String> getFieldOrder() {
            return Arrays.asList("c_iflag", "c_oflag", "c_cflag", "c_lflag", "c_cc");
        }

        public termios() {
            this.c_cc = new byte[32];
        }

        public termios(Attributes t) {
            this.c_cc = new byte[32];
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.IGNBRK), 1, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.BRKINT), 2, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.IGNPAR), 4, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.PARMRK), 16, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.INPCK), 32, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.ISTRIP), 64, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.INLCR), 256, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.IGNCR), 512, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.ICRNL), 1024, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.IXON), 8192, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.IXOFF), 65536, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.IXANY), 16384, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.IMAXBEL), 131072, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.IUTF8), 262144, this.c_iflag);
            this.c_oflag = setFlag(t.getOutputFlag(Attributes.OutputFlag.OPOST), 1, this.c_oflag);
            this.c_oflag = setFlag(t.getOutputFlag(Attributes.OutputFlag.ONLCR), 4, this.c_oflag);
            this.c_oflag = setFlag(t.getOutputFlag(Attributes.OutputFlag.OCRNL), 16, this.c_oflag);
            this.c_oflag = setFlag(t.getOutputFlag(Attributes.OutputFlag.ONOCR), 32, this.c_oflag);
            this.c_oflag = setFlag(t.getOutputFlag(Attributes.OutputFlag.ONLRET), 64, this.c_oflag);
            this.c_oflag = setFlag(t.getOutputFlag(Attributes.OutputFlag.OFILL), 256, this.c_oflag);
            this.c_oflag = setFlag(t.getOutputFlag(Attributes.OutputFlag.NLDLY), 1024, this.c_oflag);
            this.c_oflag = setFlag(t.getOutputFlag(Attributes.OutputFlag.TABDLY), 81920, this.c_oflag);
            this.c_oflag = setFlag(t.getOutputFlag(Attributes.OutputFlag.CRDLY), 12288, this.c_oflag);
            this.c_oflag = setFlag(t.getOutputFlag(Attributes.OutputFlag.FFDLY), 1048576, this.c_oflag);
            this.c_oflag = setFlag(t.getOutputFlag(Attributes.OutputFlag.BSDLY), 131072, this.c_oflag);
            this.c_oflag = setFlag(t.getOutputFlag(Attributes.OutputFlag.VTDLY), 262144, this.c_oflag);
            this.c_oflag = setFlag(t.getOutputFlag(Attributes.OutputFlag.OFDEL), 512, this.c_oflag);
            this.c_cflag = setFlag(t.getControlFlag(Attributes.ControlFlag.CS5), 0, this.c_cflag);
            this.c_cflag = setFlag(t.getControlFlag(Attributes.ControlFlag.CS6), 32, this.c_cflag);
            this.c_cflag = setFlag(t.getControlFlag(Attributes.ControlFlag.CS7), 64, this.c_cflag);
            this.c_cflag = setFlag(t.getControlFlag(Attributes.ControlFlag.CS8), 96, this.c_cflag);
            this.c_cflag = setFlag(t.getControlFlag(Attributes.ControlFlag.CSTOPB), 256, this.c_cflag);
            this.c_cflag = setFlag(t.getControlFlag(Attributes.ControlFlag.CREAD), 512, this.c_cflag);
            this.c_cflag = setFlag(t.getControlFlag(Attributes.ControlFlag.PARENB), 1024, this.c_cflag);
            this.c_cflag = setFlag(t.getControlFlag(Attributes.ControlFlag.PARODD), 4096, this.c_cflag);
            this.c_cflag = setFlag(t.getControlFlag(Attributes.ControlFlag.HUPCL), 8192, this.c_cflag);
            this.c_cflag = setFlag(t.getControlFlag(Attributes.ControlFlag.CLOCAL), 16384, this.c_cflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.ECHOKE), 16384, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.ECHOE), 32, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.ECHOK), 64, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.ECHO), 16, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.ECHONL), 256, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.ECHOPRT), 8192, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.ECHOCTL), 4096, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.ISIG), 1, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.ICANON), 2, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.IEXTEN), 1048576, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.EXTPROC), 2097152, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.TOSTOP), 1024, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.FLUSHO), 65536, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.PENDIN), 262144, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.NOFLSH), 512, this.c_lflag);
            this.c_cc[4] = (byte) t.getControlChar(Attributes.ControlChar.VEOF);
            this.c_cc[11] = (byte) t.getControlChar(Attributes.ControlChar.VEOL);
            this.c_cc[16] = (byte) t.getControlChar(Attributes.ControlChar.VEOL2);
            this.c_cc[2] = (byte) t.getControlChar(Attributes.ControlChar.VERASE);
            this.c_cc[14] = (byte) t.getControlChar(Attributes.ControlChar.VWERASE);
            this.c_cc[3] = (byte) t.getControlChar(Attributes.ControlChar.VKILL);
            this.c_cc[12] = (byte) t.getControlChar(Attributes.ControlChar.VREPRINT);
            this.c_cc[0] = (byte) t.getControlChar(Attributes.ControlChar.VINTR);
            this.c_cc[1] = (byte) t.getControlChar(Attributes.ControlChar.VQUIT);
            this.c_cc[10] = (byte) t.getControlChar(Attributes.ControlChar.VSUSP);
            this.c_cc[8] = (byte) t.getControlChar(Attributes.ControlChar.VSTART);
            this.c_cc[9] = (byte) t.getControlChar(Attributes.ControlChar.VSTOP);
            this.c_cc[15] = (byte) t.getControlChar(Attributes.ControlChar.VLNEXT);
            this.c_cc[13] = (byte) t.getControlChar(Attributes.ControlChar.VDISCARD);
            this.c_cc[6] = (byte) t.getControlChar(Attributes.ControlChar.VMIN);
            this.c_cc[5] = (byte) t.getControlChar(Attributes.ControlChar.VTIME);
        }

        private int setFlag(boolean flag, int value, int org2) {
            return flag ? org2 | value : org2;
        }

        public Attributes toAttributes() {
            Attributes attr = new Attributes();
            EnumSet<Attributes.InputFlag> iflag = attr.getInputFlags();
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.IGNBRK, 1);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.IGNBRK, 1);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.BRKINT, 2);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.IGNPAR, 4);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.PARMRK, 16);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.INPCK, 32);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.ISTRIP, 64);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.INLCR, 256);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.IGNCR, 512);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.ICRNL, 1024);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.IXON, 8192);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.IXOFF, 65536);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.IXANY, 16384);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.IMAXBEL, 131072);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.IUTF8, 262144);
            EnumSet<Attributes.OutputFlag> oflag = attr.getOutputFlags();
            addFlag(this.c_oflag, oflag, Attributes.OutputFlag.OPOST, 1);
            addFlag(this.c_oflag, oflag, Attributes.OutputFlag.ONLCR, 4);
            addFlag(this.c_oflag, oflag, Attributes.OutputFlag.OCRNL, 16);
            addFlag(this.c_oflag, oflag, Attributes.OutputFlag.ONOCR, 32);
            addFlag(this.c_oflag, oflag, Attributes.OutputFlag.ONLRET, 64);
            addFlag(this.c_oflag, oflag, Attributes.OutputFlag.OFILL, 256);
            addFlag(this.c_oflag, oflag, Attributes.OutputFlag.NLDLY, 1024);
            addFlag(this.c_oflag, oflag, Attributes.OutputFlag.TABDLY, 81920);
            addFlag(this.c_oflag, oflag, Attributes.OutputFlag.CRDLY, 12288);
            addFlag(this.c_oflag, oflag, Attributes.OutputFlag.FFDLY, 1048576);
            addFlag(this.c_oflag, oflag, Attributes.OutputFlag.BSDLY, 131072);
            addFlag(this.c_oflag, oflag, Attributes.OutputFlag.VTDLY, 262144);
            addFlag(this.c_oflag, oflag, Attributes.OutputFlag.OFDEL, 512);
            EnumSet<Attributes.ControlFlag> cflag = attr.getControlFlags();
            addFlag(this.c_cflag, cflag, Attributes.ControlFlag.CS5, 0);
            addFlag(this.c_cflag, cflag, Attributes.ControlFlag.CS6, 32);
            addFlag(this.c_cflag, cflag, Attributes.ControlFlag.CS7, 64);
            addFlag(this.c_cflag, cflag, Attributes.ControlFlag.CS8, 96);
            addFlag(this.c_cflag, cflag, Attributes.ControlFlag.CSTOPB, 256);
            addFlag(this.c_cflag, cflag, Attributes.ControlFlag.CREAD, 512);
            addFlag(this.c_cflag, cflag, Attributes.ControlFlag.PARENB, 1024);
            addFlag(this.c_cflag, cflag, Attributes.ControlFlag.PARODD, 4096);
            addFlag(this.c_cflag, cflag, Attributes.ControlFlag.HUPCL, 8192);
            addFlag(this.c_cflag, cflag, Attributes.ControlFlag.CLOCAL, 16384);
            EnumSet<Attributes.LocalFlag> lflag = attr.getLocalFlags();
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.ECHOKE, 16384);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.ECHOE, 32);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.ECHOK, 64);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.ECHO, 16);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.ECHONL, 256);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.ECHOPRT, 8192);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.ECHOCTL, 4096);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.ISIG, 1);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.ICANON, 2);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.IEXTEN, 1048576);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.EXTPROC, 2097152);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.TOSTOP, 1024);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.FLUSHO, 65536);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.PENDIN, 262144);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.NOFLSH, 512);
            EnumMap<Attributes.ControlChar, Integer> cc = attr.getControlChars();
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VEOF, (Attributes.ControlChar) Integer.valueOf(this.c_cc[4]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VEOL, (Attributes.ControlChar) Integer.valueOf(this.c_cc[11]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VEOL2, (Attributes.ControlChar) Integer.valueOf(this.c_cc[16]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VERASE, (Attributes.ControlChar) Integer.valueOf(this.c_cc[2]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VWERASE, (Attributes.ControlChar) Integer.valueOf(this.c_cc[14]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VKILL, (Attributes.ControlChar) Integer.valueOf(this.c_cc[3]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VREPRINT, (Attributes.ControlChar) Integer.valueOf(this.c_cc[12]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VINTR, (Attributes.ControlChar) Integer.valueOf(this.c_cc[0]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VQUIT, (Attributes.ControlChar) Integer.valueOf(this.c_cc[1]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VSUSP, (Attributes.ControlChar) Integer.valueOf(this.c_cc[10]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VSTART, (Attributes.ControlChar) Integer.valueOf(this.c_cc[8]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VSTOP, (Attributes.ControlChar) Integer.valueOf(this.c_cc[9]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VLNEXT, (Attributes.ControlChar) Integer.valueOf(this.c_cc[15]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VDISCARD, (Attributes.ControlChar) Integer.valueOf(this.c_cc[13]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VMIN, (Attributes.ControlChar) Integer.valueOf(this.c_cc[6]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VTIME, (Attributes.ControlChar) Integer.valueOf(this.c_cc[5]));
            return attr;
        }

        private <T extends Enum<T>> void addFlag(int value, EnumSet<T> flags, T flag, int v) {
            if ((value & v) != 0) {
                flags.add(flag);
            }
        }
    }
}
