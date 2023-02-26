package org.eclipse.jetty.util.security;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.security.Credential;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/security/Password.class */
public class Password extends Credential {
    private static final Logger LOG = Log.getLogger(Password.class);
    private static final long serialVersionUID = 5062906681431569445L;
    public static final String __OBFUSCATE = "OBF:";
    private String _pw;

    public Password(String password) {
        this._pw = password;
        while (this._pw != null && this._pw.startsWith(__OBFUSCATE)) {
            this._pw = deobfuscate(this._pw);
        }
    }

    @Override // java.lang.Object
    public String toString() {
        return this._pw;
    }

    public String toStarString() {
        return "*****************************************************".substring(0, this._pw.length());
    }

    @Override // org.eclipse.jetty.util.security.Credential
    public boolean check(Object credentials) {
        if (this == credentials) {
            return true;
        }
        if (credentials instanceof Password) {
            return credentials.equals(this._pw);
        }
        if (credentials instanceof String) {
            return stringEquals(this._pw, (String) credentials);
        }
        if (credentials instanceof char[]) {
            return stringEquals(this._pw, new String((char[]) credentials));
        }
        if (credentials instanceof Credential) {
            return ((Credential) credentials).check(this._pw);
        }
        return false;
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (null == o) {
            return false;
        }
        if (o instanceof Password) {
            return stringEquals(this._pw, ((Password) o)._pw);
        }
        if (o instanceof String) {
            return stringEquals(this._pw, (String) o);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return null == this._pw ? hashCode() : this._pw.hashCode();
    }

    public static String obfuscate(String s) {
        StringBuilder buf = new StringBuilder();
        byte[] b = s.getBytes(StandardCharsets.UTF_8);
        buf.append(__OBFUSCATE);
        for (int i = 0; i < b.length; i++) {
            byte b1 = b[i];
            byte b2 = b[b.length - (i + 1)];
            if (b1 < 0 || b2 < 0) {
                String x = Integer.toString(((255 & b1) * 256) + (255 & b2), 36).toLowerCase(Locale.ENGLISH);
                buf.append((CharSequence) "U0000", 0, 5 - x.length());
                buf.append(x);
            } else {
                int i0 = ((Byte.MAX_VALUE + b1 + b2) * 256) + ((Byte.MAX_VALUE + b1) - b2);
                String x2 = Integer.toString(i0, 36).toLowerCase(Locale.ENGLISH);
                Integer.parseInt(x2, 36);
                byte b3 = (byte) ((((i0 / 256) + (i0 % 256)) - PacketOpcodes.ExecuteGroupTriggerRsp) / 2);
                buf.append((CharSequence) "000", 0, 4 - x2.length());
                buf.append(x2);
            }
        }
        return buf.toString();
    }

    public static String deobfuscate(String s) {
        if (s.startsWith(__OBFUSCATE)) {
            s = s.substring(4);
        }
        byte[] b = new byte[s.length() / 2];
        int l = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'U') {
                i++;
                l++;
                b[l] = (byte) (Integer.parseInt(s.substring(i, i + 4), 36) >> 8);
            } else {
                int i0 = Integer.parseInt(s.substring(i, i + 4), 36);
                l++;
                b[l] = (byte) ((((i0 / 256) + (i0 % 256)) - PacketOpcodes.ExecuteGroupTriggerRsp) / 2);
            }
            i += 4;
        }
        return new String(b, 0, l, StandardCharsets.UTF_8);
    }

    public static Password getPassword(String realm, String dft, String promptDft) {
        String passwd = System.getProperty(realm, dft);
        if (passwd == null || passwd.length() == 0) {
            try {
                System.out.print(realm + ((promptDft == null || promptDft.length() <= 0) ? "" : " [dft]") + " : ");
                System.out.flush();
                byte[] buf = new byte[512];
                int len = System.in.read(buf);
                if (len > 0) {
                    passwd = new String(buf, 0, len).trim();
                }
            } catch (IOException e) {
                LOG.warn(Log.EXCEPTION, e);
            }
            if (passwd == null || passwd.length() == 0) {
                passwd = promptDft;
            }
        }
        return new Password(passwd);
    }

    public static void main(String[] arg) {
        if (!(arg.length == 1 || arg.length == 2)) {
            System.err.println("Usage - java " + Password.class.getName() + " [<user>] <password>");
            System.err.println("If the password is ?, the user will be prompted for the password");
            System.exit(1);
        }
        String p = arg[arg.length == 1 ? (char) 0 : 1];
        Password pw = new Password(p);
        System.err.println(pw.toString());
        System.err.println(obfuscate(pw.toString()));
        System.err.println(Credential.MD5.digest(p));
        if (arg.length == 2) {
            System.err.println(Credential.Crypt.crypt(arg[0], pw.toString()));
        }
    }
}
