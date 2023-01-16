package javax.servlet.http;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/* loaded from: grasscutter.jar:javax/servlet/http/Cookie.class */
public class Cookie implements Cloneable, Serializable {
    private static final long serialVersionUID = -6454587001725327448L;
    private static final String TSPECIALS;
    private static final String LSTRING_FILE = "javax.servlet.http.LocalStrings";
    private static ResourceBundle lStrings = ResourceBundle.getBundle(LSTRING_FILE);
    private String name;
    private String value;
    private String comment;
    private String domain;
    private String path;
    private boolean secure;
    private int maxAge = -1;
    private int version = 0;
    private boolean isHttpOnly = false;

    static {
        if (Boolean.valueOf(System.getProperty("org.glassfish.web.rfc2109_cookie_names_enforced", C3P0Substitutions.DEBUG)).booleanValue()) {
            TSPECIALS = "/()<>@,;:\\\"[]?={} \t";
        } else {
            TSPECIALS = ",; ";
        }
    }

    public Cookie(String name, String value) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException(lStrings.getString("err.cookie_name_blank"));
        } else if (!isToken(name) || name.equalsIgnoreCase("Comment") || name.equalsIgnoreCase("Discard") || name.equalsIgnoreCase("Domain") || name.equalsIgnoreCase("Expires") || name.equalsIgnoreCase("Max-Age") || name.equalsIgnoreCase("Path") || name.equalsIgnoreCase("Secure") || name.equalsIgnoreCase("Version") || name.startsWith("$")) {
            throw new IllegalArgumentException(MessageFormat.format(lStrings.getString("err.cookie_name_is_token"), name));
        } else {
            this.name = name;
            this.value = value;
        }
    }

    public void setComment(String purpose) {
        this.comment = purpose;
    }

    public String getComment() {
        return this.comment;
    }

    public void setDomain(String domain) {
        this.domain = domain.toLowerCase(Locale.ENGLISH);
    }

    public String getDomain() {
        return this.domain;
    }

    public void setMaxAge(int expiry) {
        this.maxAge = expiry;
    }

    public int getMaxAge() {
        return this.maxAge;
    }

    public void setPath(String uri) {
        this.path = uri;
    }

    public String getPath() {
        return this.path;
    }

    public void setSecure(boolean flag) {
        this.secure = flag;
    }

    public boolean getSecure() {
        return this.secure;
    }

    public String getName() {
        return this.name;
    }

    public void setValue(String newValue) {
        this.value = newValue;
    }

    public String getValue() {
        return this.value;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int v) {
        this.version = v;
    }

    private boolean isToken(String value) {
        int len = value.length();
        for (int i = 0; i < len; i++) {
            char c = value.charAt(i);
            if (c < ' ' || c >= 127 || TSPECIALS.indexOf(c) != -1) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Object
    public Object clone() {
        try {
            return clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void setHttpOnly(boolean isHttpOnly) {
        this.isHttpOnly = isHttpOnly;
    }

    public boolean isHttpOnly() {
        return this.isHttpOnly;
    }
}
