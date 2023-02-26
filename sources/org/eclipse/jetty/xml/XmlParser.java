package org.eclipse.jetty.xml;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.StringTokenizer;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.eclipse.jetty.util.LazyList;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: grasscutter.jar:org/eclipse/jetty/xml/XmlParser.class */
public class XmlParser {
    private static final Logger LOG = Log.getLogger(XmlParser.class);
    private SAXParser _parser;
    private Map<String, ContentHandler> _observerMap;
    private String _xpath;
    private Object _xpaths;
    private String _dtd;
    private Map<String, URL> _redirectMap = new HashMap();
    private Stack<ContentHandler> _observers = new Stack<>();

    public XmlParser() {
        setValidating(Boolean.valueOf(System.getProperty("org.eclipse.jetty.xml.XmlParser.Validating", SAXParserFactory.newInstance().getClass().toString().startsWith("org.apache.xerces.") ? C3P0Substitutions.DEBUG : "false")).booleanValue());
    }

    public XmlParser(boolean validating) {
        setValidating(validating);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:7:0x0027
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public void setValidating(boolean r5) {
        /*
            r4 = this;
            javax.xml.parsers.SAXParserFactory r0 = javax.xml.parsers.SAXParserFactory.newInstance()     // Catch: Exception -> 0x009a
            r6 = r0
            r0 = r6
            r1 = r5
            r0.setValidating(r1)     // Catch: Exception -> 0x009a
            r0 = r4
            r1 = r6
            javax.xml.parsers.SAXParser r1 = r1.newSAXParser()     // Catch: Exception -> 0x009a
            r0._parser = r1     // Catch: Exception -> 0x009a
            r0 = r5
            if (r0 == 0) goto L_0x0024
            r0 = r4
            javax.xml.parsers.SAXParser r0 = r0._parser     // Catch: Exception -> 0x009a, Exception -> 0x0027
            org.xml.sax.XMLReader r0 = r0.getXMLReader()     // Catch: Exception -> 0x009a, Exception -> 0x0027
            java.lang.String r1 = "http://apache.org/xml/features/validation/schema"
            r2 = r5
            r0.setFeature(r1, r2)     // Catch: Exception -> 0x009a, Exception -> 0x0027
        L_0x0024:
            goto L_0x0043
        L_0x0027:
            r7 = move-exception
            r0 = r5
            if (r0 == 0) goto L_0x003a
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.xml.XmlParser.LOG     // Catch: Exception -> 0x009a
            java.lang.String r1 = "Schema validation may not be supported: "
            r2 = r7
            r0.warn(r1, r2)     // Catch: Exception -> 0x009a
            goto L_0x0043
        L_0x003a:
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.xml.XmlParser.LOG     // Catch: Exception -> 0x009a
            r1 = r7
            r0.ignore(r1)     // Catch: Exception -> 0x009a
        L_0x0043:
            r0 = r4
            javax.xml.parsers.SAXParser r0 = r0._parser     // Catch: Exception -> 0x009a
            org.xml.sax.XMLReader r0 = r0.getXMLReader()     // Catch: Exception -> 0x009a
            java.lang.String r1 = "http://xml.org/sax/features/validation"
            r2 = r5
            r0.setFeature(r1, r2)     // Catch: Exception -> 0x009a
            r0 = r4
            javax.xml.parsers.SAXParser r0 = r0._parser     // Catch: Exception -> 0x009a
            org.xml.sax.XMLReader r0 = r0.getXMLReader()     // Catch: Exception -> 0x009a
            java.lang.String r1 = "http://xml.org/sax/features/namespaces"
            r2 = 1
            r0.setFeature(r1, r2)     // Catch: Exception -> 0x009a
            r0 = r4
            javax.xml.parsers.SAXParser r0 = r0._parser     // Catch: Exception -> 0x009a
            org.xml.sax.XMLReader r0 = r0.getXMLReader()     // Catch: Exception -> 0x009a
            java.lang.String r1 = "http://xml.org/sax/features/namespace-prefixes"
            r2 = 0
            r0.setFeature(r1, r2)     // Catch: Exception -> 0x009a
            r0 = r5
            if (r0 == 0) goto L_0x0083
            r0 = r4
            javax.xml.parsers.SAXParser r0 = r0._parser     // Catch: Exception -> 0x009a, Exception -> 0x0086
            org.xml.sax.XMLReader r0 = r0.getXMLReader()     // Catch: Exception -> 0x009a, Exception -> 0x0086
            java.lang.String r1 = "http://apache.org/xml/features/nonvalidating/load-external-dtd"
            r2 = r5
            r0.setFeature(r1, r2)     // Catch: Exception -> 0x009a, Exception -> 0x0086
        L_0x0083:
            goto L_0x0097
        L_0x0086:
            r7 = move-exception
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.xml.XmlParser.LOG     // Catch: Exception -> 0x009a
            r1 = r7
            java.lang.String r1 = r1.getMessage()     // Catch: Exception -> 0x009a
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: Exception -> 0x009a
            r0.warn(r1, r2)     // Catch: Exception -> 0x009a
        L_0x0097:
            goto L_0x00b2
        L_0x009a:
            r6 = move-exception
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.xml.XmlParser.LOG
            java.lang.String r1 = "EXCEPTION "
            r2 = r6
            r0.warn(r1, r2)
            java.lang.Error r0 = new java.lang.Error
            r1 = r0
            r2 = r6
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x00b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.xml.XmlParser.setValidating(boolean):void");
    }

    public boolean isValidating() {
        return this._parser.isValidating();
    }

    public synchronized void redirectEntity(String name, URL entity) {
        if (entity != null) {
            this._redirectMap.put(name, entity);
        }
    }

    public String getXpath() {
        return this._xpath;
    }

    public void setXpath(String xpath) {
        this._xpath = xpath;
        StringTokenizer tok = new StringTokenizer(xpath, "| ");
        while (tok.hasMoreTokens()) {
            this._xpaths = LazyList.add(this._xpaths, tok.nextToken());
        }
    }

    public String getDTD() {
        return this._dtd;
    }

    public synchronized void addContentHandler(String trigger, ContentHandler observer) {
        if (this._observerMap == null) {
            this._observerMap = new HashMap();
        }
        this._observerMap.put(trigger, observer);
    }

    public synchronized Node parse(InputSource source) throws IOException, SAXException {
        this._dtd = null;
        Handler handler = new Handler();
        XMLReader reader = this._parser.getXMLReader();
        reader.setContentHandler(handler);
        reader.setErrorHandler(handler);
        reader.setEntityResolver(handler);
        if (LOG.isDebugEnabled()) {
            LOG.debug("parsing: sid=" + source.getSystemId() + ",pid=" + source.getPublicId(), new Object[0]);
        }
        this._parser.parse(source, handler);
        if (handler._error != null) {
            throw handler._error;
        }
        Node doc = (Node) handler._top.get(0);
        handler.clear();
        return doc;
    }

    public synchronized Node parse(String url) throws IOException, SAXException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("parse: " + url, new Object[0]);
        }
        return parse(new InputSource(url));
    }

    public synchronized Node parse(File file) throws IOException, SAXException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("parse: " + file, new Object[0]);
        }
        return parse(new InputSource(Resource.toURL(file).toString()));
    }

    public synchronized Node parse(InputStream in) throws IOException, SAXException {
        this._dtd = null;
        Handler handler = new Handler();
        XMLReader reader = this._parser.getXMLReader();
        reader.setContentHandler(handler);
        reader.setErrorHandler(handler);
        reader.setEntityResolver(handler);
        this._parser.parse(new InputSource(in), handler);
        if (handler._error != null) {
            throw handler._error;
        }
        Node doc = (Node) handler._top.get(0);
        handler.clear();
        return doc;
    }

    /* access modifiers changed from: protected */
    public InputSource resolveEntity(String pid, String sid) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("resolveEntity(" + pid + ", " + sid + ")", new Object[0]);
        }
        if (sid != null && sid.endsWith(".dtd")) {
            this._dtd = sid;
        }
        URL entity = null;
        if (pid != null) {
            entity = this._redirectMap.get(pid);
        }
        if (entity == null) {
            entity = this._redirectMap.get(sid);
        }
        if (entity == null) {
            String dtd = sid;
            if (dtd.lastIndexOf(47) >= 0) {
                dtd = dtd.substring(dtd.lastIndexOf(47) + 1);
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("Can't exact match entity in redirect map, trying " + dtd, new Object[0]);
            }
            entity = this._redirectMap.get(dtd);
        }
        if (entity == null) {
            return null;
        }
        try {
            InputStream in = entity.openStream();
            if (LOG.isDebugEnabled()) {
                LOG.debug("Redirected entity " + sid + " --> " + entity, new Object[0]);
            }
            InputSource is = new InputSource(in);
            is.setSystemId(sid);
            return is;
        } catch (IOException e) {
            LOG.ignore(e);
            return null;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/xml/XmlParser$NoopHandler.class */
    private class NoopHandler extends DefaultHandler {
        Handler _next;
        int _depth;

        NoopHandler(Handler next) {
            this._next = next;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
            this._depth++;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (this._depth == 0) {
                XmlParser.this._parser.getXMLReader().setContentHandler(this._next);
            } else {
                this._depth--;
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/xml/XmlParser$Handler.class */
    public class Handler extends DefaultHandler {
        SAXParseException _error;
        private NoopHandler _noop;
        Node _top = new Node(null, null, null);
        private Node _context = this._top;

        Handler() {
            this._noop = new NoopHandler(this);
        }

        void clear() {
            this._top = null;
            this._error = null;
            this._context = null;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
            String name = null;
            if (XmlParser.this._parser.isNamespaceAware()) {
                name = localName;
            }
            if (name == null || "".equals(name)) {
                name = qName;
            }
            Node node = new Node(this._context, name, attrs);
            if (XmlParser.this._xpaths != null) {
                String path = node.getPath();
                boolean match = false;
                int i = LazyList.size(XmlParser.this._xpaths);
                while (!match) {
                    i--;
                    if (i <= 0) {
                        break;
                    }
                    String xpath = (String) LazyList.get(XmlParser.this._xpaths, i);
                    match = path.equals(xpath) || (xpath.startsWith(path) && xpath.length() > path.length() && xpath.charAt(path.length()) == '/');
                }
                if (match) {
                    this._context.add(node);
                    this._context = node;
                } else {
                    XmlParser.this._parser.getXMLReader().setContentHandler(this._noop);
                }
            } else {
                this._context.add(node);
                this._context = node;
            }
            ContentHandler observer = null;
            if (XmlParser.this._observerMap != null) {
                observer = (ContentHandler) XmlParser.this._observerMap.get(name);
            }
            XmlParser.this._observers.push(observer);
            for (int i2 = 0; i2 < XmlParser.this._observers.size(); i2++) {
                if (XmlParser.this._observers.get(i2) != null) {
                    ((ContentHandler) XmlParser.this._observers.get(i2)).startElement(uri, localName, qName, attrs);
                }
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String uri, String localName, String qName) throws SAXException {
            this._context = this._context._parent;
            for (int i = 0; i < XmlParser.this._observers.size(); i++) {
                if (XmlParser.this._observers.get(i) != null) {
                    ((ContentHandler) XmlParser.this._observers.get(i)).endElement(uri, localName, qName);
                }
            }
            XmlParser.this._observers.pop();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void ignorableWhitespace(char[] buf, int offset, int len) throws SAXException {
            for (int i = 0; i < XmlParser.this._observers.size(); i++) {
                if (XmlParser.this._observers.get(i) != null) {
                    ((ContentHandler) XmlParser.this._observers.get(i)).ignorableWhitespace(buf, offset, len);
                }
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] buf, int offset, int len) throws SAXException {
            this._context.add(new String(buf, offset, len));
            for (int i = 0; i < XmlParser.this._observers.size(); i++) {
                if (XmlParser.this._observers.get(i) != null) {
                    ((ContentHandler) XmlParser.this._observers.get(i)).characters(buf, offset, len);
                }
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
        public void warning(SAXParseException ex) {
            XmlParser.LOG.debug(Log.EXCEPTION, ex);
            XmlParser.LOG.warn("WARNING@" + getLocationString(ex) + " : " + ex.toString(), new Object[0]);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
        public void error(SAXParseException ex) throws SAXException {
            if (this._error == null) {
                this._error = ex;
            }
            XmlParser.LOG.debug(Log.EXCEPTION, ex);
            XmlParser.LOG.warn("ERROR@" + getLocationString(ex) + " : " + ex.toString(), new Object[0]);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
        public void fatalError(SAXParseException ex) throws SAXException {
            this._error = ex;
            XmlParser.LOG.debug(Log.EXCEPTION, ex);
            XmlParser.LOG.warn("FATAL@" + getLocationString(ex) + " : " + ex.toString(), new Object[0]);
            throw ex;
        }

        private String getLocationString(SAXParseException ex) {
            return ex.getSystemId() + " line:" + ex.getLineNumber() + " col:" + ex.getColumnNumber();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.EntityResolver
        public InputSource resolveEntity(String pid, String sid) {
            return XmlParser.this.resolveEntity(pid, sid);
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/xml/XmlParser$Attribute.class */
    public static class Attribute {
        private String _name;
        private String _value;

        Attribute(String n, String v) {
            this._name = n;
            this._value = v;
        }

        public String getName() {
            return this._name;
        }

        public String getValue() {
            return this._value;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/xml/XmlParser$Node.class */
    public static class Node extends AbstractList<Object> {
        Node _parent;
        private ArrayList<Object> _list;
        private String _tag;
        private Attribute[] _attrs;
        private boolean _lastString = false;
        private String _path;

        /* access modifiers changed from: package-private */
        public Node(Node parent, String tag, Attributes attrs) {
            this._parent = parent;
            this._tag = tag;
            if (attrs != null) {
                this._attrs = new Attribute[attrs.getLength()];
                for (int i = 0; i < attrs.getLength(); i++) {
                    String name = attrs.getLocalName(i);
                    if (name == null || name.equals("")) {
                        name = attrs.getQName(i);
                    }
                    this._attrs[i] = new Attribute(name, attrs.getValue(i));
                }
            }
        }

        public Node getParent() {
            return this._parent;
        }

        public String getTag() {
            return this._tag;
        }

        public String getPath() {
            if (this._path == null) {
                if (getParent() == null || getParent().getTag() == null) {
                    this._path = "/" + this._tag;
                } else {
                    this._path = getParent().getPath() + "/" + this._tag;
                }
            }
            return this._path;
        }

        public Attribute[] getAttributes() {
            return this._attrs;
        }

        public String getAttribute(String name) {
            return getAttribute(name, null);
        }

        public String getAttribute(String name, String dft) {
            if (this._attrs == null || name == null) {
                return dft;
            }
            for (int i = 0; i < this._attrs.length; i++) {
                if (name.equals(this._attrs[i].getName())) {
                    return this._attrs[i].getValue();
                }
            }
            return dft;
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            if (this._list != null) {
                return this._list.size();
            }
            return 0;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            if (this._list != null) {
                return this._list.get(i);
            }
            return null;
        }

        public Node get(String tag) {
            if (this._list == null) {
                return null;
            }
            for (int i = 0; i < this._list.size(); i++) {
                Object o = this._list.get(i);
                if (o instanceof Node) {
                    Node n = (Node) o;
                    if (tag.equals(n._tag)) {
                        return n;
                    }
                }
            }
            return null;
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, Object o) {
            if (this._list == null) {
                this._list = new ArrayList<>();
            }
            if (o instanceof String) {
                if (this._lastString) {
                    int last = this._list.size() - 1;
                    this._list.set(last, ((String) this._list.get(last)) + o);
                } else {
                    this._list.add(i, o);
                }
                this._lastString = true;
                return;
            }
            this._lastString = false;
            this._list.add(i, o);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
        public void clear() {
            if (this._list != null) {
                this._list.clear();
            }
            this._list = null;
        }

        public String getString(String tag, boolean tags, boolean trim) {
            Node node = get(tag);
            if (node == null) {
                return null;
            }
            String s = node.toString(tags);
            if (s != null && trim) {
                s = s.trim();
            }
            return s;
        }

        @Override // java.util.AbstractCollection, java.lang.Object
        public synchronized String toString() {
            return toString(true);
        }

        public synchronized String toString(boolean tag) {
            StringBuilder buf = new StringBuilder();
            toString(buf, tag);
            return buf.toString();
        }

        public synchronized String toString(boolean tag, boolean trim) {
            String s = toString(tag);
            if (s != null && trim) {
                s = s.trim();
            }
            return s;
        }

        private synchronized void toString(StringBuilder buf, boolean tag) {
            if (tag) {
                buf.append("<");
                buf.append(this._tag);
                if (this._attrs != null) {
                    for (int i = 0; i < this._attrs.length; i++) {
                        buf.append(' ');
                        buf.append(this._attrs[i].getName());
                        buf.append("=\"");
                        buf.append(this._attrs[i].getValue());
                        buf.append("\"");
                    }
                }
            }
            if (this._list != null) {
                if (tag) {
                    buf.append(">");
                }
                for (int i2 = 0; i2 < this._list.size(); i2++) {
                    Object o = this._list.get(i2);
                    if (o != null) {
                        if (o instanceof Node) {
                            ((Node) o).toString(buf, tag);
                        } else {
                            buf.append(o.toString());
                        }
                    }
                }
                if (tag) {
                    buf.append("</");
                    buf.append(this._tag);
                    buf.append(">");
                }
            } else if (tag) {
                buf.append("/>");
            }
        }

        public Iterator<Node> iterator(final String tag) {
            return new Iterator<Node>() { // from class: org.eclipse.jetty.xml.XmlParser.Node.1

                /* renamed from: c */
                int f3151c = 0;
                Node _node;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    if (this._node != null) {
                        return true;
                    }
                    while (Node.this._list != null && this.f3151c < Node.this._list.size()) {
                        Object o = Node.this._list.get(this.f3151c);
                        if (o instanceof Node) {
                            Node n = (Node) o;
                            if (tag.equals(n._tag)) {
                                this._node = n;
                                return true;
                            }
                        }
                        this.f3151c++;
                    }
                    return false;
                }

                @Override // java.util.Iterator
                public Node next() {
                    try {
                        if (hasNext()) {
                            Node node = this._node;
                            this._node = null;
                            this.f3151c++;
                            return node;
                        }
                        throw new NoSuchElementException();
                    } catch (Throwable th) {
                        this._node = null;
                        this.f3151c++;
                        throw th;
                    }
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException("Not supported");
                }
            };
        }
    }
}
