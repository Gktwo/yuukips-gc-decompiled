package javax.servlet;

/* loaded from: grasscutter.jar:javax/servlet/SessionCookieConfig.class */
public interface SessionCookieConfig {
    void setName(String str);

    String getName();

    void setDomain(String str);

    String getDomain();

    void setPath(String str);

    String getPath();

    void setComment(String str);

    String getComment();

    void setHttpOnly(boolean z);

    boolean isHttpOnly();

    void setSecure(boolean z);

    boolean isSecure();

    void setMaxAge(int i);

    int getMaxAge();
}
