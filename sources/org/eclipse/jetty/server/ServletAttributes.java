package org.eclipse.jetty.server;

import java.util.Set;
import org.eclipse.jetty.util.Attributes;
import org.eclipse.jetty.util.AttributesMap;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/ServletAttributes.class */
public class ServletAttributes implements Attributes {
    private final Attributes _attributes = new AttributesMap();
    private AsyncAttributes _asyncAttributes;

    public void setAsyncAttributes(String requestURI, String contextPath, String servletPath, String pathInfo, String queryString) {
        this._asyncAttributes = new AsyncAttributes(this._attributes, requestURI, contextPath, servletPath, pathInfo, queryString);
    }

    private Attributes getAttributes() {
        return this._asyncAttributes == null ? this._attributes : this._asyncAttributes;
    }

    @Override // org.eclipse.jetty.util.Attributes
    public void removeAttribute(String name) {
        getAttributes().removeAttribute(name);
    }

    @Override // org.eclipse.jetty.util.Attributes
    public void setAttribute(String name, Object attribute) {
        getAttributes().setAttribute(name, attribute);
    }

    @Override // org.eclipse.jetty.util.Attributes
    public Object getAttribute(String name) {
        return getAttributes().getAttribute(name);
    }

    @Override // org.eclipse.jetty.util.Attributes
    public Set<String> getAttributeNameSet() {
        return getAttributes().getAttributeNameSet();
    }

    @Override // org.eclipse.jetty.util.Attributes
    public void clearAttributes() {
        getAttributes().clearAttributes();
        this._asyncAttributes = null;
    }
}
