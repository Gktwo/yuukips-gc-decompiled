package javax.servlet.http;

/* loaded from: grasscutter.jar:javax/servlet/http/HttpUpgradeHandler.class */
public interface HttpUpgradeHandler {
    void init(WebConnection webConnection);

    void destroy();
}
