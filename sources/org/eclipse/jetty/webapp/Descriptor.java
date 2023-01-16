package org.eclipse.jetty.webapp;

import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.xml.XmlParser;

/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/Descriptor.class */
public abstract class Descriptor {
    protected Resource _xml;
    protected XmlParser.Node _root;
    protected String _dtd;
    protected boolean _validating;

    public abstract XmlParser ensureParser() throws ClassNotFoundException;

    public Descriptor(Resource xml) {
        this._xml = xml;
    }

    public void setValidating(boolean validating) {
        this._validating = validating;
    }

    public void parse() throws Exception {
        if (this._root == null) {
            try {
                XmlParser parser = ensureParser();
                this._root = parser.parse(this._xml.getInputStream());
                this._dtd = parser.getDTD();
            } finally {
                this._xml.close();
            }
        }
    }

    public Resource getResource() {
        return this._xml;
    }

    public XmlParser.Node getRoot() {
        return this._root;
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this._xml + ")";
    }
}
