package org.eclipse.jetty.util;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Set;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/Attributes.class */
public interface Attributes {
    void removeAttribute(String str);

    void setAttribute(String str, Object obj);

    Object getAttribute(String str);

    Set<String> getAttributeNameSet();

    void clearAttributes();

    default Enumeration<String> getAttributeNames() {
        return Collections.enumeration(getAttributeNameSet());
    }

    static Attributes unwrap(Attributes attributes) {
        while (attributes instanceof Wrapper) {
            attributes = ((Wrapper) attributes).getAttributes();
        }
        return attributes;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Attributes$Wrapper.class */
    public static abstract class Wrapper implements Attributes {
        protected final Attributes _attributes;

        public Wrapper(Attributes attributes) {
            this._attributes = attributes;
        }

        public Attributes getAttributes() {
            return this._attributes;
        }

        @Override // org.eclipse.jetty.util.Attributes
        public void removeAttribute(String name) {
            this._attributes.removeAttribute(name);
        }

        @Override // org.eclipse.jetty.util.Attributes
        public void setAttribute(String name, Object attribute) {
            this._attributes.setAttribute(name, attribute);
        }

        @Override // org.eclipse.jetty.util.Attributes
        public Object getAttribute(String name) {
            return this._attributes.getAttribute(name);
        }

        @Override // org.eclipse.jetty.util.Attributes
        public Set<String> getAttributeNameSet() {
            return this._attributes.getAttributeNameSet();
        }

        @Override // org.eclipse.jetty.util.Attributes
        public void clearAttributes() {
            this._attributes.clearAttributes();
        }
    }
}
