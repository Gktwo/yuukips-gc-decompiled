package org.eclipse.jetty.client.api;

import java.net.URI;
import java.util.Map;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.util.Attributes;
import org.eclipse.jetty.util.StringUtil;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Authentication.class */
public interface Authentication {
    public static final String ANY_REALM = "<<ANY_REALM>>";

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Authentication$Result.class */
    public interface Result {
        URI getURI();

        void apply(Request request);
    }

    boolean matches(String str, URI uri, String str2);

    Result authenticate(Request request, ContentResponse contentResponse, HeaderInfo headerInfo, Attributes attributes);

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Authentication$HeaderInfo.class */
    public static class HeaderInfo {
        private final HttpHeader header;
        private final String type;
        private final Map<String, String> params;

        public HeaderInfo(HttpHeader header, String type, Map<String, String> params) throws IllegalArgumentException {
            this.header = header;
            this.type = type;
            this.params = params;
        }

        public String getType() {
            return this.type;
        }

        public String getRealm() {
            return this.params.get("realm");
        }

        public String getBase64() {
            return this.params.get("base64");
        }

        public Map<String, String> getParameters() {
            return this.params;
        }

        public String getParameter(String paramName) {
            return this.params.get(StringUtil.asciiToLowerCase(paramName));
        }

        public HttpHeader getHeader() {
            return this.header;
        }
    }
}
