package org.jline.terminal.impl.jna.freebsd;

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
/* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/freebsd/CLibrary.class */
public interface CLibrary extends Library {
    public static final int TIOCGWINSZ = 1074295912;
    public static final int TIOCSWINSZ = -2146929561;
    public static final int VEOF = 0;
    public static final int VEOL = 1;
    public static final int VEOL2 = 2;
    public static final int VERASE = 3;
    public static final int VWERASE = 4;
    public static final int VKILL = 5;
    public static final int VREPRINT = 6;
    public static final int VERASE2 = 7;
    public static final int VINTR = 8;
    public static final int VQUIT = 9;
    public static final int VSUSP = 10;
    public static final int VDSUSP = 11;
    public static final int VSTART = 12;
    public static final int VSTOP = 13;
    public static final int VLNEXT = 14;
    public static final int VDISCARD = 15;
    public static final int VMIN = 16;
    public static final int VTIME = 17;
    public static final int VSTATUS = 18;
    public static final int IGNBRK = 1;
    public static final int BRKINT = 2;
    public static final int IGNPAR = 4;
    public static final int PARMRK = 8;
    public static final int INPCK = 16;
    public static final int ISTRIP = 32;
    public static final int INLCR = 64;
    public static final int IGNCR = 128;
    public static final int ICRNL = 256;
    public static final int IXON = 512;
    public static final int IXOFF = 1024;
    public static final int IXANY = 2048;
    public static final int IMAXBEL = 8192;
    public static final int OPOST = 1;
    public static final int ONLCR = 2;
    public static final int TABDLY = 4;
    public static final int TAB0 = 0;
    public static final int TAB3 = 4;
    public static final int ONOEOT = 8;
    public static final int OCRNL = 16;
    public static final int ONLRET = 64;
    public static final int CIGNORE = 1;
    public static final int CSIZE = 768;
    public static final int CS5 = 0;
    public static final int CS6 = 256;
    public static final int CS7 = 512;
    public static final int CS8 = 768;
    public static final int CSTOPB = 1024;
    public static final int CREAD = 2048;
    public static final int PARENB = 4096;
    public static final int PARODD = 8192;
    public static final int HUPCL = 16384;
    public static final int CLOCAL = 32768;
    public static final int ECHOKE = 1;
    public static final int ECHOE = 2;
    public static final int ECHOK = 4;
    public static final int ECHO = 8;
    public static final int ECHONL = 16;
    public static final int ECHOPRT = 32;
    public static final int ECHOCTL = 64;
    public static final int ISIG = 128;
    public static final int ICANON = 256;
    public static final int ALTWERASE = 512;
    public static final int IEXTEN = 1024;
    public static final int EXTPROC = 2048;
    public static final int TOSTOP = 4194304;
    public static final int FLUSHO = 8388608;
    public static final int PENDIN = 33554432;
    public static final int NOFLSH = 134217728;
    public static final int TCSANOW = 0;
    public static final int TCSADRAIN = 1;
    public static final int TCSAFLUSH = 2;

    void tcgetattr(int i, termios termios2) throws LastErrorException;

    void tcsetattr(int i, int i2, termios termios2) throws LastErrorException;

    void ioctl(int i, long j, winsize winsize2) throws LastErrorException;

    int isatty(int i);

    void ttyname_r(int i, byte[] bArr, int i2) throws LastErrorException;

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/freebsd/CLibrary$winsize.class */
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
    /* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/freebsd/CLibrary$termios.class */
    public static class termios extends Structure {
        public int c_iflag;
        public int c_oflag;
        public int c_cflag;
        public int c_lflag;
        public byte[] c_cc;
        public int c_ispeed;
        public int c_ospeed;

        @Override // com.sun.jna.Structure
        protected List<String> getFieldOrder() {
            return Arrays.asList("c_iflag", "c_oflag", "c_cflag", "c_lflag", "c_cc", "c_ispeed", "c_ospeed");
        }

        public termios() {
            this.c_cc = new byte[20];
        }

        public termios(Attributes t) {
            this.c_cc = new byte[20];
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.IGNBRK), 1, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.BRKINT), 2, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.IGNPAR), 4, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.PARMRK), 8, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.INPCK), 16, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.ISTRIP), 32, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.INLCR), 64, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.IGNCR), 128, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.ICRNL), 256, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.IXON), 512, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.IXOFF), 1024, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.IXANY), 2048, this.c_iflag);
            this.c_iflag = setFlag(t.getInputFlag(Attributes.InputFlag.IMAXBEL), 8192, this.c_iflag);
            this.c_oflag = setFlag(t.getOutputFlag(Attributes.OutputFlag.OPOST), 1, this.c_oflag);
            this.c_oflag = setFlag(t.getOutputFlag(Attributes.OutputFlag.ONLCR), 2, this.c_oflag);
            this.c_oflag = setFlag(t.getOutputFlag(Attributes.OutputFlag.OCRNL), 16, this.c_oflag);
            this.c_oflag = setFlag(t.getOutputFlag(Attributes.OutputFlag.ONLRET), 64, this.c_oflag);
            this.c_oflag = setFlag(t.getOutputFlag(Attributes.OutputFlag.TABDLY), 4, this.c_oflag);
            this.c_cflag = setFlag(t.getControlFlag(Attributes.ControlFlag.CS5), 0, this.c_cflag);
            this.c_cflag = setFlag(t.getControlFlag(Attributes.ControlFlag.CS6), 256, this.c_cflag);
            this.c_cflag = setFlag(t.getControlFlag(Attributes.ControlFlag.CS7), 512, this.c_cflag);
            this.c_cflag = setFlag(t.getControlFlag(Attributes.ControlFlag.CS8), 768, this.c_cflag);
            this.c_cflag = setFlag(t.getControlFlag(Attributes.ControlFlag.CSTOPB), 1024, this.c_cflag);
            this.c_cflag = setFlag(t.getControlFlag(Attributes.ControlFlag.CREAD), 2048, this.c_cflag);
            this.c_cflag = setFlag(t.getControlFlag(Attributes.ControlFlag.PARENB), 4096, this.c_cflag);
            this.c_cflag = setFlag(t.getControlFlag(Attributes.ControlFlag.PARODD), 8192, this.c_cflag);
            this.c_cflag = setFlag(t.getControlFlag(Attributes.ControlFlag.HUPCL), 16384, this.c_cflag);
            this.c_cflag = setFlag(t.getControlFlag(Attributes.ControlFlag.CLOCAL), 32768, this.c_cflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.ECHOKE), 1, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.ECHOE), 2, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.ECHOK), 4, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.ECHO), 8, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.ECHONL), 16, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.ECHOPRT), 32, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.ECHOCTL), 64, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.ISIG), 128, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.ICANON), 256, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.IEXTEN), 1024, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.EXTPROC), 2048, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.TOSTOP), 4194304, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.FLUSHO), 8388608, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.PENDIN), 33554432, this.c_lflag);
            this.c_lflag = setFlag(t.getLocalFlag(Attributes.LocalFlag.NOFLSH), 134217728, this.c_lflag);
            this.c_cc[0] = (byte) t.getControlChar(Attributes.ControlChar.VEOF);
            this.c_cc[1] = (byte) t.getControlChar(Attributes.ControlChar.VEOL);
            this.c_cc[2] = (byte) t.getControlChar(Attributes.ControlChar.VEOL2);
            this.c_cc[3] = (byte) t.getControlChar(Attributes.ControlChar.VERASE);
            this.c_cc[4] = (byte) t.getControlChar(Attributes.ControlChar.VWERASE);
            this.c_cc[5] = (byte) t.getControlChar(Attributes.ControlChar.VKILL);
            this.c_cc[6] = (byte) t.getControlChar(Attributes.ControlChar.VREPRINT);
            this.c_cc[8] = (byte) t.getControlChar(Attributes.ControlChar.VINTR);
            this.c_cc[9] = (byte) t.getControlChar(Attributes.ControlChar.VQUIT);
            this.c_cc[10] = (byte) t.getControlChar(Attributes.ControlChar.VSUSP);
            this.c_cc[12] = (byte) t.getControlChar(Attributes.ControlChar.VSTART);
            this.c_cc[13] = (byte) t.getControlChar(Attributes.ControlChar.VSTOP);
            this.c_cc[14] = (byte) t.getControlChar(Attributes.ControlChar.VLNEXT);
            this.c_cc[15] = (byte) t.getControlChar(Attributes.ControlChar.VDISCARD);
            this.c_cc[16] = (byte) t.getControlChar(Attributes.ControlChar.VMIN);
            this.c_cc[17] = (byte) t.getControlChar(Attributes.ControlChar.VTIME);
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
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.PARMRK, 8);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.INPCK, 16);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.ISTRIP, 32);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.INLCR, 64);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.IGNCR, 128);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.ICRNL, 256);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.IXON, 512);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.IXOFF, 1024);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.IXANY, 2048);
            addFlag(this.c_iflag, iflag, Attributes.InputFlag.IMAXBEL, 8192);
            EnumSet<Attributes.OutputFlag> oflag = attr.getOutputFlags();
            addFlag(this.c_oflag, oflag, Attributes.OutputFlag.OPOST, 1);
            addFlag(this.c_oflag, oflag, Attributes.OutputFlag.ONLCR, 2);
            addFlag(this.c_oflag, oflag, Attributes.OutputFlag.OCRNL, 16);
            addFlag(this.c_oflag, oflag, Attributes.OutputFlag.ONLRET, 64);
            addFlag(this.c_oflag, oflag, Attributes.OutputFlag.TABDLY, 4);
            EnumSet<Attributes.ControlFlag> cflag = attr.getControlFlags();
            addFlag(this.c_cflag, cflag, Attributes.ControlFlag.CS5, 0);
            addFlag(this.c_cflag, cflag, Attributes.ControlFlag.CS6, 256);
            addFlag(this.c_cflag, cflag, Attributes.ControlFlag.CS7, 512);
            addFlag(this.c_cflag, cflag, Attributes.ControlFlag.CS8, 768);
            addFlag(this.c_cflag, cflag, Attributes.ControlFlag.CSTOPB, 1024);
            addFlag(this.c_cflag, cflag, Attributes.ControlFlag.CREAD, 2048);
            addFlag(this.c_cflag, cflag, Attributes.ControlFlag.PARENB, 4096);
            addFlag(this.c_cflag, cflag, Attributes.ControlFlag.PARODD, 8192);
            addFlag(this.c_cflag, cflag, Attributes.ControlFlag.HUPCL, 16384);
            addFlag(this.c_cflag, cflag, Attributes.ControlFlag.CLOCAL, 32768);
            EnumSet<Attributes.LocalFlag> lflag = attr.getLocalFlags();
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.ECHOKE, 1);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.ECHOE, 2);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.ECHOK, 4);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.ECHO, 8);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.ECHONL, 16);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.ECHOPRT, 32);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.ECHOCTL, 64);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.ISIG, 128);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.ICANON, 256);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.IEXTEN, 1024);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.EXTPROC, 2048);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.TOSTOP, 4194304);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.FLUSHO, 8388608);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.PENDIN, 33554432);
            addFlag(this.c_lflag, lflag, Attributes.LocalFlag.NOFLSH, 134217728);
            EnumMap<Attributes.ControlChar, Integer> cc = attr.getControlChars();
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VEOF, (Attributes.ControlChar) Integer.valueOf(this.c_cc[0]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VEOL, (Attributes.ControlChar) Integer.valueOf(this.c_cc[1]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VEOL2, (Attributes.ControlChar) Integer.valueOf(this.c_cc[2]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VERASE, (Attributes.ControlChar) Integer.valueOf(this.c_cc[3]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VWERASE, (Attributes.ControlChar) Integer.valueOf(this.c_cc[4]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VKILL, (Attributes.ControlChar) Integer.valueOf(this.c_cc[5]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VREPRINT, (Attributes.ControlChar) Integer.valueOf(this.c_cc[6]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VINTR, (Attributes.ControlChar) Integer.valueOf(this.c_cc[8]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VQUIT, (Attributes.ControlChar) Integer.valueOf(this.c_cc[9]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VSUSP, (Attributes.ControlChar) Integer.valueOf(this.c_cc[10]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VSTART, (Attributes.ControlChar) Integer.valueOf(this.c_cc[12]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VSTOP, (Attributes.ControlChar) Integer.valueOf(this.c_cc[13]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VLNEXT, (Attributes.ControlChar) Integer.valueOf(this.c_cc[14]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VDISCARD, (Attributes.ControlChar) Integer.valueOf(this.c_cc[15]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VMIN, (Attributes.ControlChar) Integer.valueOf(this.c_cc[16]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VTIME, (Attributes.ControlChar) Integer.valueOf(this.c_cc[17]));
            return attr;
        }

        private <T extends Enum<T>> void addFlag(int value, EnumSet<T> flags, T flag, int v) {
            if ((value & v) != 0) {
                flags.add(flag);
            }
        }
    }
}
