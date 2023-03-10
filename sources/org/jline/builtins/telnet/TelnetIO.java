package org.jline.builtins.telnet;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jline.builtins.telnet.ConnectionEvent;

/* loaded from: grasscutter.jar:org/jline/builtins/telnet/TelnetIO.class */
public class TelnetIO {
    protected static final int IAC = 255;

    /* renamed from: GA */
    protected static final int f3179GA = 249;
    protected static final int WILL = 251;
    protected static final int WONT = 252;

    /* renamed from: DO */
    protected static final int f3180DO = 253;
    protected static final int DONT = 254;

    /* renamed from: SB */
    protected static final int f3181SB = 250;

    /* renamed from: SE */
    protected static final int f3182SE = 240;
    protected static final int NOP = 241;

    /* renamed from: DM */
    protected static final int f3183DM = 242;
    protected static final int BRK = 243;

    /* renamed from: IP */
    protected static final int f3184IP = 244;

    /* renamed from: AO */
    protected static final int f3185AO = 245;
    protected static final int AYT = 246;

    /* renamed from: EC */
    protected static final int f3186EC = 247;

    /* renamed from: EL */
    protected static final int f3187EL = 248;
    protected static final int ECHO = 1;
    protected static final int SUPGA = 3;
    protected static final int NAWS = 31;
    protected static final int TTYPE = 24;

    /* renamed from: IS */
    protected static final int f3188IS = 0;
    protected static final int SEND = 1;
    protected static final int LOGOUT = 18;
    protected static final int LINEMODE = 34;
    protected static final int LM_MODE = 1;
    protected static final int LM_EDIT = 1;
    protected static final int LM_TRAPSIG = 2;
    protected static final int LM_MODEACK = 4;
    protected static final int LM_FORWARDMASK = 2;
    protected static final int LM_SLC = 3;
    protected static final int LM_SLC_NOSUPPORT = 0;
    protected static final int LM_SLC_DEFAULT = 3;
    protected static final int LM_SLC_VALUE = 2;
    protected static final int LM_SLC_CANTCHANGE = 1;
    protected static final int LM_SLC_LEVELBITS = 3;
    protected static final int LM_SLC_ACK = 128;
    protected static final int LM_SLC_FLUSHIN = 64;
    protected static final int LM_SLC_FLUSHOUT = 32;
    protected static final int LM_SLC_SYNCH = 1;
    protected static final int LM_SLC_BRK = 2;
    protected static final int LM_SLC_IP = 3;
    protected static final int LM_SLC_AO = 4;
    protected static final int LM_SLC_AYT = 5;
    protected static final int LM_SLC_EOR = 6;
    protected static final int LM_SLC_ABORT = 7;
    protected static final int LM_SLC_EOF = 8;
    protected static final int LM_SLC_SUSP = 9;
    protected static final int NEWENV = 39;
    protected static final int NE_INFO = 2;
    protected static final int NE_VAR = 0;
    protected static final int NE_VALUE = 1;
    protected static final int NE_ESC = 2;
    protected static final int NE_USERVAR = 3;
    protected static final int NE_VAR_OK = 2;
    protected static final int NE_VAR_DEFINED = 1;
    protected static final int NE_VAR_DEFINED_EMPTY = 0;
    protected static final int NE_VAR_UNDEFINED = -1;
    protected static final int NE_IN_ERROR = -2;
    protected static final int NE_IN_END = -3;
    protected static final int NE_VAR_NAME_MAXLENGTH = 50;
    protected static final int NE_VAR_VALUE_MAXLENGTH = 1000;
    protected static final int EXT_ASCII = 17;
    protected static final int SEND_LOC = 23;
    protected static final int AUTHENTICATION = 37;
    protected static final int ENCRYPT = 38;
    private static final Logger LOG = Logger.getLogger(TelnetIO.class.getName());
    private static final int SMALLEST_BELIEVABLE_WIDTH = 20;
    private static final int SMALLEST_BELIEVABLE_HEIGHT = 6;
    private static final int DEFAULT_WIDTH = 80;
    private static final int DEFAULT_HEIGHT = 25;
    private Connection connection;
    private ConnectionData connectionData;
    private DataOutputStream out;

    /* renamed from: in */
    private DataInputStream f3189in;
    private IACHandler iacHandler;
    private InetAddress localAddress;
    private boolean noIac = false;
    private boolean initializing;
    private boolean crFlag;

    public void initIO() throws IOException {
        this.iacHandler = new IACHandler();
        this.f3189in = new DataInputStream(this.connectionData.getSocket().getInputStream());
        this.out = new DataOutputStream(new BufferedOutputStream(this.connectionData.getSocket().getOutputStream()));
        this.localAddress = this.connectionData.getSocket().getLocalAddress();
        this.crFlag = false;
        initTelnetCommunication();
    }

    public void setConnection(Connection con) {
        this.connection = con;
        this.connectionData = this.connection.getConnectionData();
    }

    public void write(byte b) throws IOException {
        if (!this.crFlag && b == 10) {
            this.out.write(13);
        }
        this.out.write(b);
        if (b == 13) {
            this.crFlag = true;
        } else {
            this.crFlag = false;
        }
    }

    public void write(int i) throws IOException {
        write((byte) i);
    }

    public void write(byte[] sequence) throws IOException {
        for (byte b : sequence) {
            write(b);
        }
    }

    public void write(int[] sequence) throws IOException {
        for (int i : sequence) {
            write((byte) i);
        }
    }

    public void write(char ch) throws IOException {
        write((byte) ch);
    }

    public void write(String str) throws IOException {
        write(str.getBytes());
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void closeOutput() {
        try {
            write(255);
            write(253);
            write(18);
            this.out.close();
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "closeOutput()", (Throwable) ex);
        }
    }

    /* access modifiers changed from: private */
    public void rawWrite(int i) throws IOException {
        this.out.write(i);
    }

    public int read() throws IOException {
        int c = rawread();
        this.noIac = false;
        while (c == 255 && !this.noIac) {
            c = rawread();
            if (c != 255) {
                this.iacHandler.handleC(c);
                c = rawread();
            } else {
                this.noIac = true;
            }
        }
        return stripCRSeq(c);
    }

    public void closeInput() {
        try {
            this.f3189in.close();
        } catch (IOException e) {
        }
    }

    /* access modifiers changed from: private */
    public int read16int() throws IOException {
        return this.f3189in.readUnsignedShort();
    }

    /* access modifiers changed from: private */
    public int rawread() throws IOException {
        int b = this.f3189in.readUnsignedByte();
        this.connectionData.activity();
        return b;
    }

    private int stripCRSeq(int input) throws IOException {
        if (input != 13) {
            return input;
        }
        rawread();
        return 10;
    }

    private void initTelnetCommunication() {
        this.initializing = true;
        try {
            if (this.connectionData.isLineMode()) {
                this.iacHandler.doLineModeInit();
                LOG.log(Level.FINE, "Line mode initialized.");
            } else {
                this.iacHandler.doCharacterModeInit();
                LOG.log(Level.FINE, "Character mode initialized.");
            }
            this.connectionData.getSocket().setSoTimeout(1000);
            read();
            try {
                this.connectionData.getSocket().setSoTimeout(0);
            } catch (Exception ex) {
                LOG.log(Level.SEVERE, "initTelnetCommunication()", (Throwable) ex);
            }
        } catch (Exception e) {
            try {
                this.connectionData.getSocket().setSoTimeout(0);
            } catch (Exception ex2) {
                LOG.log(Level.SEVERE, "initTelnetCommunication()", (Throwable) ex2);
            }
        } catch (Throwable th) {
            try {
                this.connectionData.getSocket().setSoTimeout(0);
            } catch (Exception ex3) {
                LOG.log(Level.SEVERE, "initTelnetCommunication()", (Throwable) ex3);
            }
            throw th;
        }
        this.initializing = false;
    }

    /* access modifiers changed from: private */
    public void IamHere() {
        try {
            write("[" + this.localAddress.toString() + ":Yes]");
            flush();
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "IamHere()", (Throwable) ex);
        }
    }

    /* access modifiers changed from: private */
    public void nvtBreak() {
        this.connection.processConnectionEvent(new ConnectionEvent(this.connection, ConnectionEvent.Type.CONNECTION_BREAK));
    }

    /* access modifiers changed from: private */
    public void setTerminalGeometry(int width, int height) {
        if (width < 20) {
            width = 80;
        }
        if (height < 6) {
            height = 25;
        }
        this.connectionData.setTerminalGeometry(width, height);
        this.connection.processConnectionEvent(new ConnectionEvent(this.connection, ConnectionEvent.Type.CONNECTION_TERMINAL_GEOMETRY_CHANGED));
    }

    public void setEcho(boolean b) {
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/jline/builtins/telnet/TelnetIO$IACHandler.class */
    public class IACHandler {
        private int[] buffer = new int[2];
        private boolean DO_ECHO = false;
        private boolean DO_SUPGA = false;
        private boolean DO_NAWS = false;
        private boolean DO_TTYPE = false;
        private boolean DO_LINEMODE = false;
        private boolean DO_NEWENV = false;
        private boolean WAIT_DO_REPLY_SUPGA = false;
        private boolean WAIT_DO_REPLY_ECHO = false;
        private boolean WAIT_DO_REPLY_NAWS = false;
        private boolean WAIT_DO_REPLY_TTYPE = false;
        private boolean WAIT_DO_REPLY_LINEMODE = false;
        private boolean WAIT_LM_MODE_ACK = false;
        private boolean WAIT_LM_DO_REPLY_FORWARDMASK = false;
        private boolean WAIT_DO_REPLY_NEWENV = false;
        private boolean WAIT_NE_SEND_REPLY = false;
        private boolean WAIT_WILL_REPLY_SUPGA = false;
        private boolean WAIT_WILL_REPLY_ECHO = false;
        private boolean WAIT_WILL_REPLY_NAWS = false;
        private boolean WAIT_WILL_REPLY_TTYPE = false;

        IACHandler() {
        }

        public void doCharacterModeInit() throws IOException {
            sendCommand(251, 1, true);
            sendCommand(254, 1, true);
            sendCommand(253, 31, true);
            sendCommand(251, 3, true);
            sendCommand(253, 3, true);
            sendCommand(253, 24, true);
            sendCommand(253, 39, true);
        }

        public void doLineModeInit() throws IOException {
            sendCommand(253, 31, true);
            sendCommand(251, 3, true);
            sendCommand(253, 3, true);
            sendCommand(253, 24, true);
            sendCommand(253, 34, true);
            sendCommand(253, 39, true);
        }

        public void handleC(int i) throws IOException {
            this.buffer[0] = i;
            if (!parseTWO(this.buffer)) {
                this.buffer[1] = TelnetIO.this.rawread();
                parse(this.buffer);
            }
            this.buffer[0] = 0;
            this.buffer[1] = 0;
        }

        private boolean parseTWO(int[] buf) {
            switch (buf[0]) {
                case 241:
                case 244:
                case 245:
                case 247:
                case 248:
                case 255:
                    return true;
                case 242:
                case 249:
                case 250:
                case 251:
                case 252:
                case 253:
                case 254:
                default:
                    return false;
                case 243:
                    TelnetIO.this.nvtBreak();
                    return true;
                case 246:
                    TelnetIO.this.IamHere();
                    return true;
            }
        }

        private void parse(int[] buf) throws IOException {
            switch (buf[0]) {
                case 242:
                case 243:
                case 244:
                case 245:
                case 246:
                case 247:
                case 248:
                case 249:
                default:
                    return;
                case 250:
                    if (supported(buf[1]) && isEnabled(buf[1])) {
                        switch (buf[1]) {
                            case 24:
                                handleTTYPE();
                                return;
                            case 31:
                                handleNAWS();
                                return;
                            case 34:
                                handleLINEMODE();
                                return;
                            case 39:
                                handleNEWENV();
                                return;
                            default:
                                return;
                        }
                    } else {
                        return;
                    }
                case 251:
                    if (supported(buf[1]) && isEnabled(buf[1])) {
                        return;
                    }
                    if (waitDOreply(buf[1]) && supported(buf[1])) {
                        enable(buf[1]);
                        setWait(253, buf[1], false);
                        return;
                    } else if (supported(buf[1])) {
                        sendCommand(253, buf[1], false);
                        enable(buf[1]);
                        return;
                    } else {
                        sendCommand(254, buf[1], false);
                        return;
                    }
                case 252:
                    if (waitDOreply(buf[1]) && supported(buf[1])) {
                        setWait(253, buf[1], false);
                        return;
                    } else if (supported(buf[1]) && isEnabled(buf[1])) {
                        enable(buf[1]);
                        return;
                    } else {
                        return;
                    }
                case 253:
                    if (supported(buf[1]) && isEnabled(buf[1])) {
                        return;
                    }
                    if (waitWILLreply(buf[1]) && supported(buf[1])) {
                        enable(buf[1]);
                        setWait(251, buf[1], false);
                        return;
                    } else if (supported(buf[1])) {
                        sendCommand(251, buf[1], false);
                        enable(buf[1]);
                        return;
                    } else {
                        sendCommand(252, buf[1], false);
                        return;
                    }
                case 254:
                    if (waitWILLreply(buf[1]) && supported(buf[1])) {
                        setWait(251, buf[1], false);
                        return;
                    } else if (supported(buf[1]) && isEnabled(buf[1])) {
                        enable(buf[1]);
                        return;
                    } else {
                        return;
                    }
            }
        }

        private void handleNAWS() throws IOException {
            int width = TelnetIO.this.read16int();
            if (width == 255) {
                width = TelnetIO.this.read16int();
            }
            int height = TelnetIO.this.read16int();
            if (height == 255) {
                height = TelnetIO.this.read16int();
            }
            skipToSE();
            TelnetIO.this.setTerminalGeometry(width, height);
        }

        private void handleTTYPE() throws IOException {
            TelnetIO.this.rawread();
            String tmpstr = readIACSETerminatedString(40);
            TelnetIO.LOG.log(Level.FINE, "Reported terminal name " + tmpstr);
            TelnetIO.this.connectionData.setNegotiatedTerminalType(tmpstr);
        }

        public void handleLINEMODE() throws IOException {
            int c = TelnetIO.this.rawread();
            switch (c) {
                case 1:
                    handleLMMode();
                    return;
                case 3:
                    handleLMSLC();
                    return;
                case 251:
                case 252:
                    handleLMForwardMask(c);
                    return;
                default:
                    skipToSE();
                    return;
            }
        }

        public void handleLMMode() throws IOException {
            if (this.WAIT_LM_MODE_ACK) {
                int mask = TelnetIO.this.rawread();
                if (mask != 7) {
                    TelnetIO.LOG.log(Level.FINE, "Client violates linemodeack sent: " + mask);
                }
                this.WAIT_LM_MODE_ACK = false;
            }
            skipToSE();
        }

        public void handleLMSLC() throws IOException {
            int[] triple = new int[3];
            if (readTriple(triple)) {
                if (triple[0] == 0 && triple[1] == 3 && triple[2] == 0) {
                    skipToSE();
                    TelnetIO.this.rawWrite(255);
                    TelnetIO.this.rawWrite(250);
                    TelnetIO.this.rawWrite(34);
                    TelnetIO.this.rawWrite(3);
                    for (int i = 1; i < 12; i++) {
                        TelnetIO.this.rawWrite(i);
                        TelnetIO.this.rawWrite(3);
                        TelnetIO.this.rawWrite(0);
                    }
                    TelnetIO.this.rawWrite(255);
                    TelnetIO.this.rawWrite(240);
                    TelnetIO.this.flush();
                    return;
                }
                TelnetIO.this.rawWrite(255);
                TelnetIO.this.rawWrite(250);
                TelnetIO.this.rawWrite(34);
                TelnetIO.this.rawWrite(3);
                TelnetIO.this.rawWrite(triple[0]);
                TelnetIO.this.rawWrite(triple[1] | 128);
                TelnetIO.this.rawWrite(triple[2]);
                while (readTriple(triple)) {
                    TelnetIO.this.rawWrite(triple[0]);
                    TelnetIO.this.rawWrite(triple[1] | 128);
                    TelnetIO.this.rawWrite(triple[2]);
                }
                TelnetIO.this.rawWrite(255);
                TelnetIO.this.rawWrite(240);
                TelnetIO.this.flush();
            }
        }

        public void handleLMForwardMask(int WHAT) throws IOException {
            switch (WHAT) {
                case 252:
                    if (this.WAIT_LM_DO_REPLY_FORWARDMASK) {
                        this.WAIT_LM_DO_REPLY_FORWARDMASK = false;
                        break;
                    }
                    break;
            }
            skipToSE();
        }

        public void handleNEWENV() throws IOException {
            TelnetIO.LOG.log(Level.FINE, "handleNEWENV()");
            switch (TelnetIO.this.rawread()) {
                case 0:
                    handleNEIs();
                    return;
                case 2:
                    handleNEInfo();
                    return;
                default:
                    skipToSE();
                    return;
            }
        }

        private int readNEVariableName(StringBuffer sbuf) throws IOException {
            TelnetIO.LOG.log(Level.FINE, "readNEVariableName()");
            while (true) {
                int i = TelnetIO.this.rawread();
                if (i == -1) {
                    return -2;
                }
                if (i == 255) {
                    int i2 = TelnetIO.this.rawread();
                    if (i2 == 255) {
                        sbuf.append((char) i2);
                    } else if (i2 == 240) {
                        return -3;
                    } else {
                        return -2;
                    }
                } else if (i == 2) {
                    int i3 = TelnetIO.this.rawread();
                    if (i3 != 2 && i3 != 0 && i3 != 3 && i3 != 1) {
                        return -2;
                    }
                    sbuf.append((char) i3);
                } else if (i == 0 || i == 3) {
                    return -1;
                } else {
                    if (i == 1) {
                        return 1;
                    }
                    if (sbuf.length() >= 50) {
                        return -2;
                    }
                    sbuf.append((char) i);
                }
            }
        }

        private int readNEVariableValue(StringBuffer sbuf) throws IOException {
            TelnetIO.LOG.log(Level.FINE, "readNEVariableValue()");
            int i = TelnetIO.this.rawread();
            if (i == -1) {
                return -2;
            }
            if (i == 255) {
                int i2 = TelnetIO.this.rawread();
                if (i2 == 255) {
                    return 0;
                }
                if (i2 == 240) {
                    return -3;
                }
                return -2;
            } else if (i == 0 || i == 3) {
                return 0;
            } else {
                if (i == 2) {
                    int i3 = TelnetIO.this.rawread();
                    if (i3 != 2 && i3 != 0 && i3 != 3 && i3 != 1) {
                        return -2;
                    }
                    sbuf.append((char) i3);
                } else {
                    sbuf.append((char) i);
                }
                while (true) {
                    int i4 = TelnetIO.this.rawread();
                    if (i4 == -1) {
                        return -2;
                    }
                    if (i4 == 255) {
                        int i5 = TelnetIO.this.rawread();
                        if (i5 == 255) {
                            sbuf.append((char) i5);
                        } else if (i5 == 240) {
                            return -3;
                        } else {
                            return -2;
                        }
                    } else if (i4 == 2) {
                        int i6 = TelnetIO.this.rawread();
                        if (i6 != 2 && i6 != 0 && i6 != 3 && i6 != 1) {
                            return -2;
                        }
                        sbuf.append((char) i6);
                    } else if (i4 == 0 || i4 == 3) {
                        return 2;
                    } else {
                        if (sbuf.length() > 1000) {
                            return -2;
                        }
                        sbuf.append((char) i4);
                    }
                }
            }
        }

        public void readNEVariables() throws IOException {
            TelnetIO.LOG.log(Level.FINE, "readNEVariables()");
            StringBuffer sbuf = new StringBuffer(50);
            int i = TelnetIO.this.rawread();
            if (i == 255) {
                skipToSE();
                TelnetIO.LOG.log(Level.FINE, "readNEVariables()::INVALID VARIABLE");
            } else if (i == 0 || i == 3) {
                do {
                    switch (readNEVariableName(sbuf)) {
                        case -3:
                            TelnetIO.LOG.log(Level.FINE, "readNEVariables()::NE_IN_END");
                            return;
                        case -2:
                            TelnetIO.LOG.log(Level.FINE, "readNEVariables()::NE_IN_ERROR");
                            return;
                        case -1:
                            TelnetIO.LOG.log(Level.FINE, "readNEVariables()::NE_VAR_UNDEFINED");
                            break;
                        case 1:
                            TelnetIO.LOG.log(Level.FINE, "readNEVariables()::NE_VAR_DEFINED");
                            String str = sbuf.toString();
                            sbuf.delete(0, sbuf.length());
                            switch (readNEVariableValue(sbuf)) {
                                case -3:
                                    TelnetIO.LOG.log(Level.FINE, "readNEVariables()::NE_IN_END");
                                    return;
                                case -2:
                                    TelnetIO.LOG.log(Level.FINE, "readNEVariables()::NE_IN_ERROR");
                                    return;
                                case 0:
                                    TelnetIO.LOG.log(Level.FINE, "readNEVariables()::NE_VAR_DEFINED_EMPTY");
                                    break;
                                case 2:
                                    TelnetIO.LOG.log(Level.FINE, "readNEVariables()::NE_VAR_OK:VAR=" + str + " VAL=" + sbuf.toString());
                                    TelnetIO.this.connectionData.getEnvironment().put(str, sbuf.toString());
                                    sbuf.delete(0, sbuf.length());
                                    break;
                            }
                    }
                } while (1 != 0);
            }
        }

        public void handleNEIs() throws IOException {
            TelnetIO.LOG.log(Level.FINE, "handleNEIs()");
            if (isEnabled(39)) {
                readNEVariables();
            }
        }

        public void handleNEInfo() throws IOException {
            TelnetIO.LOG.log(Level.FINE, "handleNEInfo()");
            if (isEnabled(39)) {
                readNEVariables();
            }
        }

        public void getTTYPE() throws IOException {
            if (isEnabled(24)) {
                TelnetIO.this.rawWrite(255);
                TelnetIO.this.rawWrite(250);
                TelnetIO.this.rawWrite(24);
                TelnetIO.this.rawWrite(1);
                TelnetIO.this.rawWrite(255);
                TelnetIO.this.rawWrite(240);
                TelnetIO.this.flush();
            }
        }

        public void negotiateLineMode() throws IOException {
            if (isEnabled(34)) {
                TelnetIO.this.rawWrite(255);
                TelnetIO.this.rawWrite(250);
                TelnetIO.this.rawWrite(34);
                TelnetIO.this.rawWrite(1);
                TelnetIO.this.rawWrite(3);
                TelnetIO.this.rawWrite(255);
                TelnetIO.this.rawWrite(240);
                this.WAIT_LM_MODE_ACK = true;
                TelnetIO.this.rawWrite(255);
                TelnetIO.this.rawWrite(250);
                TelnetIO.this.rawWrite(34);
                TelnetIO.this.rawWrite(254);
                TelnetIO.this.rawWrite(2);
                TelnetIO.this.rawWrite(255);
                TelnetIO.this.rawWrite(240);
                this.WAIT_LM_DO_REPLY_FORWARDMASK = true;
                TelnetIO.this.flush();
            }
        }

        private void negotiateEnvironment() throws IOException {
            if (isEnabled(39)) {
                TelnetIO.this.rawWrite(255);
                TelnetIO.this.rawWrite(250);
                TelnetIO.this.rawWrite(39);
                TelnetIO.this.rawWrite(1);
                TelnetIO.this.rawWrite(0);
                TelnetIO.this.rawWrite(3);
                TelnetIO.this.rawWrite(255);
                TelnetIO.this.rawWrite(240);
                this.WAIT_NE_SEND_REPLY = true;
                TelnetIO.this.flush();
            }
        }

        private void skipToSE() throws IOException {
            do {
            } while (TelnetIO.this.rawread() != 240);
        }

        private boolean readTriple(int[] triple) throws IOException {
            triple[0] = TelnetIO.this.rawread();
            triple[1] = TelnetIO.this.rawread();
            if (triple[0] == 255 && triple[1] == 240) {
                return false;
            }
            triple[2] = TelnetIO.this.rawread();
            return true;
        }

        private String readIACSETerminatedString(int maxlength) throws IOException {
            int where = 0;
            char[] cbuf = new char[maxlength];
            boolean cont = true;
            do {
                int i = TelnetIO.this.rawread();
                switch (i) {
                    case -1:
                        return new String("default");
                    case 255:
                        i = TelnetIO.this.rawread();
                        if (i == 240) {
                            cont = false;
                            break;
                        }
                        break;
                }
                if (cont) {
                    char b = (char) i;
                    if (b == '\n' || b == '\r' || where == maxlength) {
                        cont = false;
                    } else {
                        where++;
                        cbuf[where] = b;
                    }
                }
            } while (cont);
            return new String(cbuf, 0, where);
        }

        private boolean supported(int i) {
            switch (i) {
                case 1:
                case 3:
                case 24:
                case 31:
                case 39:
                    return true;
                case 34:
                    return TelnetIO.this.connectionData.isLineMode();
                default:
                    return false;
            }
        }

        private void sendCommand(int i, int j, boolean westarted) throws IOException {
            TelnetIO.this.rawWrite(255);
            TelnetIO.this.rawWrite(i);
            TelnetIO.this.rawWrite(j);
            if (i == 253 && westarted) {
                setWait(253, j, true);
            }
            if (i == 251 && westarted) {
                setWait(251, j, true);
            }
            TelnetIO.this.flush();
        }

        private void enable(int i) throws IOException {
            switch (i) {
                case 1:
                    if (this.DO_ECHO) {
                        this.DO_ECHO = false;
                        return;
                    } else {
                        this.DO_ECHO = true;
                        return;
                    }
                case 3:
                    if (this.DO_SUPGA) {
                        this.DO_SUPGA = false;
                        return;
                    } else {
                        this.DO_SUPGA = true;
                        return;
                    }
                case 24:
                    if (this.DO_TTYPE) {
                        this.DO_TTYPE = false;
                        return;
                    }
                    this.DO_TTYPE = true;
                    getTTYPE();
                    return;
                case 31:
                    if (this.DO_NAWS) {
                        this.DO_NAWS = false;
                        return;
                    } else {
                        this.DO_NAWS = true;
                        return;
                    }
                case 34:
                    if (this.DO_LINEMODE) {
                        this.DO_LINEMODE = false;
                        TelnetIO.this.connectionData.setLineMode(false);
                        return;
                    }
                    this.DO_LINEMODE = true;
                    negotiateLineMode();
                    return;
                case 39:
                    if (this.DO_NEWENV) {
                        this.DO_NEWENV = false;
                        return;
                    }
                    this.DO_NEWENV = true;
                    negotiateEnvironment();
                    return;
                default:
                    return;
            }
        }

        private boolean isEnabled(int i) {
            switch (i) {
                case 1:
                    return this.DO_ECHO;
                case 3:
                    return this.DO_SUPGA;
                case 24:
                    return this.DO_TTYPE;
                case 31:
                    return this.DO_NAWS;
                case 34:
                    return this.DO_LINEMODE;
                case 39:
                    return this.DO_NEWENV;
                default:
                    return false;
            }
        }

        private boolean waitWILLreply(int i) {
            switch (i) {
                case 1:
                    return this.WAIT_WILL_REPLY_ECHO;
                case 3:
                    return this.WAIT_WILL_REPLY_SUPGA;
                case 24:
                    return this.WAIT_WILL_REPLY_TTYPE;
                case 31:
                    return this.WAIT_WILL_REPLY_NAWS;
                default:
                    return false;
            }
        }

        private boolean waitDOreply(int i) {
            switch (i) {
                case 1:
                    return this.WAIT_DO_REPLY_ECHO;
                case 3:
                    return this.WAIT_DO_REPLY_SUPGA;
                case 24:
                    return this.WAIT_DO_REPLY_TTYPE;
                case 31:
                    return this.WAIT_DO_REPLY_NAWS;
                case 34:
                    return this.WAIT_DO_REPLY_LINEMODE;
                case 39:
                    return this.WAIT_DO_REPLY_NEWENV;
                default:
                    return false;
            }
        }

        private void setWait(int WHAT, int OPTION, boolean WAIT) {
            switch (WHAT) {
                case 251:
                    switch (OPTION) {
                        case 1:
                            this.WAIT_WILL_REPLY_ECHO = WAIT;
                            return;
                        case 3:
                            this.WAIT_WILL_REPLY_SUPGA = WAIT;
                            return;
                        case 24:
                            this.WAIT_WILL_REPLY_TTYPE = WAIT;
                            return;
                        case 31:
                            this.WAIT_WILL_REPLY_NAWS = WAIT;
                            return;
                        default:
                            return;
                    }
                case 253:
                    switch (OPTION) {
                        case 1:
                            this.WAIT_DO_REPLY_ECHO = WAIT;
                            return;
                        case 3:
                            this.WAIT_DO_REPLY_SUPGA = WAIT;
                            return;
                        case 24:
                            this.WAIT_DO_REPLY_TTYPE = WAIT;
                            return;
                        case 31:
                            this.WAIT_DO_REPLY_NAWS = WAIT;
                            return;
                        case 34:
                            this.WAIT_DO_REPLY_LINEMODE = WAIT;
                            return;
                        case 39:
                            this.WAIT_DO_REPLY_NEWENV = WAIT;
                            return;
                        default:
                            return;
                    }
                default:
                    return;
            }
        }
    }
}
