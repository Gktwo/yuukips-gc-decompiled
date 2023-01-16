package javax.servlet.http;

import java.util.Enumeration;

/* loaded from: grasscutter.jar:javax/servlet/http/HttpSessionContext.class */
public interface HttpSessionContext {
    HttpSession getSession(String str);

    Enumeration<String> getIds();
}
