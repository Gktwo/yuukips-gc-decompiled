package org.jline.terminal.impl.jna.osx;

import com.sun.jna.LastErrorException;
import com.sun.jna.Library;
import com.sun.jna.NativeLong;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import okhttp3.internal.http2.Http2Stream;
import org.jline.terminal.Attributes;
import org.jline.terminal.Size;
import p001ch.qos.logback.core.FileAppender;
import p001ch.qos.logback.core.util.FileSize;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/osx/CLibrary.class */
public interface CLibrary extends Library {
    public static final long TIOCGWINSZ = 1074295912;
    public static final long TIOCSWINSZ = 2148037735L;
    public static final int TCSANOW = 0;
    public static final int VEOF = 0;
    public static final int VEOL = 1;
    public static final int VEOL2 = 2;
    public static final int VERASE = 3;
    public static final int VWERASE = 4;
    public static final int VKILL = 5;
    public static final int VREPRINT = 6;
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
    public static final int IUTF8 = 16384;
    public static final int OPOST = 1;
    public static final int ONLCR = 2;
    public static final int OXTABS = 4;
    public static final int ONOEOT = 8;
    public static final int OCRNL = 16;
    public static final int ONOCR = 32;
    public static final int ONLRET = 64;
    public static final int OFILL = 128;
    public static final int NLDLY = 768;
    public static final int TABDLY = 3076;
    public static final int CRDLY = 12288;
    public static final int FFDLY = 16384;
    public static final int BSDLY = 32768;
    public static final int VTDLY = 65536;
    public static final int OFDEL = 131072;
    public static final int CIGNORE = 1;
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
    public static final int CCTS_OFLOW = 65536;
    public static final int CRTS_IFLOW = 131072;
    public static final int CDTR_IFLOW = 262144;
    public static final int CDSR_OFLOW = 524288;
    public static final int CCAR_OFLOW = 1048576;
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
    public static final int NOKERNINFO = 33554432;
    public static final int PENDIN = 536870912;
    public static final int NOFLSH = Integer.MIN_VALUE;

    void tcgetattr(int i, termios termios2) throws LastErrorException;

    void tcsetattr(int i, int i2, termios termios2) throws LastErrorException;

    void ioctl(int i, NativeLong nativeLong, winsize winsize2) throws LastErrorException;

    int isatty(int i);

    void ttyname_r(int i, byte[] bArr, int i2) throws LastErrorException;

    void openpty(int[] iArr, int[] iArr2, byte[] bArr, termios termios2, winsize winsize2) throws LastErrorException;

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/osx/CLibrary$winsize.class */
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
    /* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/osx/CLibrary$termios.class */
    public static class termios extends Structure {
        public NativeLong c_iflag;
        public NativeLong c_oflag;
        public NativeLong c_cflag;
        public NativeLong c_lflag;
        public byte[] c_cc;
        public NativeLong c_ispeed;
        public NativeLong c_ospeed;

        @Override // com.sun.jna.Structure
        protected List<String> getFieldOrder() {
            return Arrays.asList("c_iflag", "c_oflag", "c_cflag", "c_lflag", "c_cc", "c_ispeed", "c_ospeed");
        }

        public termios() {
            this.c_cc = new byte[20];
        }

        public termios(Attributes t) {
            this.c_cc = new byte[20];
            setFlag(t.getInputFlag(Attributes.InputFlag.IGNBRK), 1, this.c_iflag);
            setFlag(t.getInputFlag(Attributes.InputFlag.BRKINT), 2, this.c_iflag);
            setFlag(t.getInputFlag(Attributes.InputFlag.IGNPAR), 4, this.c_iflag);
            setFlag(t.getInputFlag(Attributes.InputFlag.PARMRK), 8, this.c_iflag);
            setFlag(t.getInputFlag(Attributes.InputFlag.INPCK), 16, this.c_iflag);
            setFlag(t.getInputFlag(Attributes.InputFlag.ISTRIP), 32, this.c_iflag);
            setFlag(t.getInputFlag(Attributes.InputFlag.INLCR), 64, this.c_iflag);
            setFlag(t.getInputFlag(Attributes.InputFlag.IGNCR), 128, this.c_iflag);
            setFlag(t.getInputFlag(Attributes.InputFlag.ICRNL), 256, this.c_iflag);
            setFlag(t.getInputFlag(Attributes.InputFlag.IXON), 512, this.c_iflag);
            setFlag(t.getInputFlag(Attributes.InputFlag.IXOFF), 1024, this.c_iflag);
            setFlag(t.getInputFlag(Attributes.InputFlag.IXANY), 2048, this.c_iflag);
            setFlag(t.getInputFlag(Attributes.InputFlag.IMAXBEL), FileAppender.DEFAULT_BUFFER_SIZE, this.c_iflag);
            setFlag(t.getInputFlag(Attributes.InputFlag.IUTF8), Http2Stream.EMIT_BUFFER_SIZE, this.c_iflag);
            setFlag(t.getOutputFlag(Attributes.OutputFlag.OPOST), 1, this.c_oflag);
            setFlag(t.getOutputFlag(Attributes.OutputFlag.ONLCR), 2, this.c_oflag);
            setFlag(t.getOutputFlag(Attributes.OutputFlag.OXTABS), 4, this.c_oflag);
            setFlag(t.getOutputFlag(Attributes.OutputFlag.ONOEOT), 8, this.c_oflag);
            setFlag(t.getOutputFlag(Attributes.OutputFlag.OCRNL), 16, this.c_oflag);
            setFlag(t.getOutputFlag(Attributes.OutputFlag.ONOCR), 32, this.c_oflag);
            setFlag(t.getOutputFlag(Attributes.OutputFlag.ONLRET), 64, this.c_oflag);
            setFlag(t.getOutputFlag(Attributes.OutputFlag.OFILL), 128, this.c_oflag);
            setFlag(t.getOutputFlag(Attributes.OutputFlag.NLDLY), 768, this.c_oflag);
            setFlag(t.getOutputFlag(Attributes.OutputFlag.TABDLY), 3076, this.c_oflag);
            setFlag(t.getOutputFlag(Attributes.OutputFlag.CRDLY), 12288, this.c_oflag);
            setFlag(t.getOutputFlag(Attributes.OutputFlag.FFDLY), Http2Stream.EMIT_BUFFER_SIZE, this.c_oflag);
            setFlag(t.getOutputFlag(Attributes.OutputFlag.BSDLY), 32768, this.c_oflag);
            setFlag(t.getOutputFlag(Attributes.OutputFlag.VTDLY), 65536, this.c_oflag);
            setFlag(t.getOutputFlag(Attributes.OutputFlag.OFDEL), 131072, this.c_oflag);
            setFlag(t.getControlFlag(Attributes.ControlFlag.CIGNORE), 1, this.c_cflag);
            setFlag(t.getControlFlag(Attributes.ControlFlag.CS5), 0, this.c_cflag);
            setFlag(t.getControlFlag(Attributes.ControlFlag.CS6), 256, this.c_cflag);
            setFlag(t.getControlFlag(Attributes.ControlFlag.CS7), 512, this.c_cflag);
            setFlag(t.getControlFlag(Attributes.ControlFlag.CS8), 768, this.c_cflag);
            setFlag(t.getControlFlag(Attributes.ControlFlag.CSTOPB), 1024, this.c_cflag);
            setFlag(t.getControlFlag(Attributes.ControlFlag.CREAD), 2048, this.c_cflag);
            setFlag(t.getControlFlag(Attributes.ControlFlag.PARENB), 4096, this.c_cflag);
            setFlag(t.getControlFlag(Attributes.ControlFlag.PARODD), FileAppender.DEFAULT_BUFFER_SIZE, this.c_cflag);
            setFlag(t.getControlFlag(Attributes.ControlFlag.HUPCL), Http2Stream.EMIT_BUFFER_SIZE, this.c_cflag);
            setFlag(t.getControlFlag(Attributes.ControlFlag.CLOCAL), 32768, this.c_cflag);
            setFlag(t.getControlFlag(Attributes.ControlFlag.CCTS_OFLOW), 65536, this.c_cflag);
            setFlag(t.getControlFlag(Attributes.ControlFlag.CRTS_IFLOW), 131072, this.c_cflag);
            setFlag(t.getControlFlag(Attributes.ControlFlag.CDTR_IFLOW), 262144, this.c_cflag);
            setFlag(t.getControlFlag(Attributes.ControlFlag.CDSR_OFLOW), 524288, this.c_cflag);
            setFlag(t.getControlFlag(Attributes.ControlFlag.CCAR_OFLOW), FileSize.MB_COEFFICIENT, this.c_cflag);
            setFlag(t.getLocalFlag(Attributes.LocalFlag.ECHOKE), 1, this.c_lflag);
            setFlag(t.getLocalFlag(Attributes.LocalFlag.ECHOE), 2, this.c_lflag);
            setFlag(t.getLocalFlag(Attributes.LocalFlag.ECHOK), 4, this.c_lflag);
            setFlag(t.getLocalFlag(Attributes.LocalFlag.ECHO), 8, this.c_lflag);
            setFlag(t.getLocalFlag(Attributes.LocalFlag.ECHONL), 16, this.c_lflag);
            setFlag(t.getLocalFlag(Attributes.LocalFlag.ECHOPRT), 32, this.c_lflag);
            setFlag(t.getLocalFlag(Attributes.LocalFlag.ECHOCTL), 64, this.c_lflag);
            setFlag(t.getLocalFlag(Attributes.LocalFlag.ISIG), 128, this.c_lflag);
            setFlag(t.getLocalFlag(Attributes.LocalFlag.ICANON), 256, this.c_lflag);
            setFlag(t.getLocalFlag(Attributes.LocalFlag.ALTWERASE), 512, this.c_lflag);
            setFlag(t.getLocalFlag(Attributes.LocalFlag.IEXTEN), 1024, this.c_lflag);
            setFlag(t.getLocalFlag(Attributes.LocalFlag.EXTPROC), 2048, this.c_lflag);
            setFlag(t.getLocalFlag(Attributes.LocalFlag.TOSTOP), 4194304, this.c_lflag);
            setFlag(t.getLocalFlag(Attributes.LocalFlag.FLUSHO), 8388608, this.c_lflag);
            setFlag(t.getLocalFlag(Attributes.LocalFlag.NOKERNINFO), 33554432, this.c_lflag);
            setFlag(t.getLocalFlag(Attributes.LocalFlag.PENDIN), 536870912, this.c_lflag);
            setFlag(t.getLocalFlag(Attributes.LocalFlag.NOFLSH), -2147483648L, this.c_lflag);
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
            this.c_cc[11] = (byte) t.getControlChar(Attributes.ControlChar.VDSUSP);
            this.c_cc[12] = (byte) t.getControlChar(Attributes.ControlChar.VSTART);
            this.c_cc[13] = (byte) t.getControlChar(Attributes.ControlChar.VSTOP);
            this.c_cc[14] = (byte) t.getControlChar(Attributes.ControlChar.VLNEXT);
            this.c_cc[15] = (byte) t.getControlChar(Attributes.ControlChar.VDISCARD);
            this.c_cc[16] = (byte) t.getControlChar(Attributes.ControlChar.VMIN);
            this.c_cc[17] = (byte) t.getControlChar(Attributes.ControlChar.VTIME);
            this.c_cc[18] = (byte) t.getControlChar(Attributes.ControlChar.VSTATUS);
        }

        private void setFlag(boolean flag, long value, NativeLong org2) {
            org2.setValue(flag ? org2.longValue() | value : org2.longValue());
        }

        public Attributes toAttributes() {
            Attributes attr = new Attributes();
            EnumSet<Attributes.InputFlag> iflag = attr.getInputFlags();
            addFlag(this.c_iflag.longValue(), iflag, Attributes.InputFlag.IGNBRK, 1);
            addFlag(this.c_iflag.longValue(), iflag, Attributes.InputFlag.IGNBRK, 1);
            addFlag(this.c_iflag.longValue(), iflag, Attributes.InputFlag.BRKINT, 2);
            addFlag(this.c_iflag.longValue(), iflag, Attributes.InputFlag.IGNPAR, 4);
            addFlag(this.c_iflag.longValue(), iflag, Attributes.InputFlag.PARMRK, 8);
            addFlag(this.c_iflag.longValue(), iflag, Attributes.InputFlag.INPCK, 16);
            addFlag(this.c_iflag.longValue(), iflag, Attributes.InputFlag.ISTRIP, 32);
            addFlag(this.c_iflag.longValue(), iflag, Attributes.InputFlag.INLCR, 64);
            addFlag(this.c_iflag.longValue(), iflag, Attributes.InputFlag.IGNCR, 128);
            addFlag(this.c_iflag.longValue(), iflag, Attributes.InputFlag.ICRNL, 256);
            addFlag(this.c_iflag.longValue(), iflag, Attributes.InputFlag.IXON, 512);
            addFlag(this.c_iflag.longValue(), iflag, Attributes.InputFlag.IXOFF, 1024);
            addFlag(this.c_iflag.longValue(), iflag, Attributes.InputFlag.IXANY, 2048);
            addFlag(this.c_iflag.longValue(), iflag, Attributes.InputFlag.IMAXBEL, 8192);
            addFlag(this.c_iflag.longValue(), iflag, Attributes.InputFlag.IUTF8, 16384);
            EnumSet<Attributes.OutputFlag> oflag = attr.getOutputFlags();
            addFlag(this.c_oflag.longValue(), oflag, Attributes.OutputFlag.OPOST, 1);
            addFlag(this.c_oflag.longValue(), oflag, Attributes.OutputFlag.ONLCR, 2);
            addFlag(this.c_oflag.longValue(), oflag, Attributes.OutputFlag.OXTABS, 4);
            addFlag(this.c_oflag.longValue(), oflag, Attributes.OutputFlag.ONOEOT, 8);
            addFlag(this.c_oflag.longValue(), oflag, Attributes.OutputFlag.OCRNL, 16);
            addFlag(this.c_oflag.longValue(), oflag, Attributes.OutputFlag.ONOCR, 32);
            addFlag(this.c_oflag.longValue(), oflag, Attributes.OutputFlag.ONLRET, 64);
            addFlag(this.c_oflag.longValue(), oflag, Attributes.OutputFlag.OFILL, 128);
            addFlag(this.c_oflag.longValue(), oflag, Attributes.OutputFlag.NLDLY, 768);
            addFlag(this.c_oflag.longValue(), oflag, Attributes.OutputFlag.TABDLY, 3076);
            addFlag(this.c_oflag.longValue(), oflag, Attributes.OutputFlag.CRDLY, 12288);
            addFlag(this.c_oflag.longValue(), oflag, Attributes.OutputFlag.FFDLY, 16384);
            addFlag(this.c_oflag.longValue(), oflag, Attributes.OutputFlag.BSDLY, 32768);
            addFlag(this.c_oflag.longValue(), oflag, Attributes.OutputFlag.VTDLY, 65536);
            addFlag(this.c_oflag.longValue(), oflag, Attributes.OutputFlag.OFDEL, 131072);
            EnumSet<Attributes.ControlFlag> cflag = attr.getControlFlags();
            addFlag(this.c_cflag.longValue(), cflag, Attributes.ControlFlag.CIGNORE, 1);
            addFlag(this.c_cflag.longValue(), cflag, Attributes.ControlFlag.CS5, 0);
            addFlag(this.c_cflag.longValue(), cflag, Attributes.ControlFlag.CS6, 256);
            addFlag(this.c_cflag.longValue(), cflag, Attributes.ControlFlag.CS7, 512);
            addFlag(this.c_cflag.longValue(), cflag, Attributes.ControlFlag.CS8, 768);
            addFlag(this.c_cflag.longValue(), cflag, Attributes.ControlFlag.CSTOPB, 1024);
            addFlag(this.c_cflag.longValue(), cflag, Attributes.ControlFlag.CREAD, 2048);
            addFlag(this.c_cflag.longValue(), cflag, Attributes.ControlFlag.PARENB, 4096);
            addFlag(this.c_cflag.longValue(), cflag, Attributes.ControlFlag.PARODD, 8192);
            addFlag(this.c_cflag.longValue(), cflag, Attributes.ControlFlag.HUPCL, 16384);
            addFlag(this.c_cflag.longValue(), cflag, Attributes.ControlFlag.CLOCAL, 32768);
            addFlag(this.c_cflag.longValue(), cflag, Attributes.ControlFlag.CCTS_OFLOW, 65536);
            addFlag(this.c_cflag.longValue(), cflag, Attributes.ControlFlag.CRTS_IFLOW, 131072);
            addFlag(this.c_cflag.longValue(), cflag, Attributes.ControlFlag.CDSR_OFLOW, 524288);
            addFlag(this.c_cflag.longValue(), cflag, Attributes.ControlFlag.CCAR_OFLOW, 1048576);
            EnumSet<Attributes.LocalFlag> lflag = attr.getLocalFlags();
            addFlag(this.c_lflag.longValue(), lflag, Attributes.LocalFlag.ECHOKE, 1);
            addFlag(this.c_lflag.longValue(), lflag, Attributes.LocalFlag.ECHOE, 2);
            addFlag(this.c_lflag.longValue(), lflag, Attributes.LocalFlag.ECHOK, 4);
            addFlag(this.c_lflag.longValue(), lflag, Attributes.LocalFlag.ECHO, 8);
            addFlag(this.c_lflag.longValue(), lflag, Attributes.LocalFlag.ECHONL, 16);
            addFlag(this.c_lflag.longValue(), lflag, Attributes.LocalFlag.ECHOPRT, 32);
            addFlag(this.c_lflag.longValue(), lflag, Attributes.LocalFlag.ECHOCTL, 64);
            addFlag(this.c_lflag.longValue(), lflag, Attributes.LocalFlag.ISIG, 128);
            addFlag(this.c_lflag.longValue(), lflag, Attributes.LocalFlag.ICANON, 256);
            addFlag(this.c_lflag.longValue(), lflag, Attributes.LocalFlag.ALTWERASE, 512);
            addFlag(this.c_lflag.longValue(), lflag, Attributes.LocalFlag.IEXTEN, 1024);
            addFlag(this.c_lflag.longValue(), lflag, Attributes.LocalFlag.EXTPROC, 2048);
            addFlag(this.c_lflag.longValue(), lflag, Attributes.LocalFlag.TOSTOP, 4194304);
            addFlag(this.c_lflag.longValue(), lflag, Attributes.LocalFlag.FLUSHO, 8388608);
            addFlag(this.c_lflag.longValue(), lflag, Attributes.LocalFlag.NOKERNINFO, 33554432);
            addFlag(this.c_lflag.longValue(), lflag, Attributes.LocalFlag.PENDIN, 536870912);
            addFlag(this.c_lflag.longValue(), lflag, Attributes.LocalFlag.NOFLSH, Integer.MIN_VALUE);
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
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VDSUSP, (Attributes.ControlChar) Integer.valueOf(this.c_cc[11]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VSTART, (Attributes.ControlChar) Integer.valueOf(this.c_cc[12]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VSTOP, (Attributes.ControlChar) Integer.valueOf(this.c_cc[13]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VLNEXT, (Attributes.ControlChar) Integer.valueOf(this.c_cc[14]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VDISCARD, (Attributes.ControlChar) Integer.valueOf(this.c_cc[15]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VMIN, (Attributes.ControlChar) Integer.valueOf(this.c_cc[16]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VTIME, (Attributes.ControlChar) Integer.valueOf(this.c_cc[17]));
            cc.put((EnumMap<Attributes.ControlChar, Integer>) Attributes.ControlChar.VSTATUS, (Attributes.ControlChar) Integer.valueOf(this.c_cc[18]));
            return attr;
        }

        private <T extends Enum<T>> void addFlag(long value, EnumSet<T> flags, T flag, int v) {
            if ((value & ((long) v)) != 0) {
                flags.add(flag);
            }
        }
    }
}
