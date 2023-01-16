package org.eclipse.jetty.webapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.xml.XmlParser;
import org.jline.reader.impl.LineReaderImpl;

/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/FragmentDescriptor.class */
public class FragmentDescriptor extends WebDescriptor {
    public static final String NAMELESS = "@@-NAMELESS-@@";
    protected static int _counter = 0;
    protected OtherType _otherType = OtherType.None;
    protected List<String> _befores = new ArrayList();
    protected List<String> _afters = new ArrayList();
    protected String _name;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/FragmentDescriptor$OtherType.class */
    public enum OtherType {
        None,
        Before,
        After
    }

    public FragmentDescriptor(Resource xml) throws Exception {
        super(xml);
    }

    public String getName() {
        return this._name;
    }

    @Override // org.eclipse.jetty.webapp.WebDescriptor, org.eclipse.jetty.webapp.Descriptor
    public void parse() throws Exception {
        parse();
        processName();
    }

    public void processName() {
        String tmp;
        XmlParser.Node nameNode = getRoot().get("name");
        StringBuilder append = new StringBuilder().append(NAMELESS);
        int i = _counter;
        _counter = i + 1;
        this._name = append.append(i).toString();
        if (nameNode != null && (tmp = nameNode.toString(false, true)) != null && tmp.length() > 0) {
            this._name = tmp;
        }
    }

    @Override // org.eclipse.jetty.webapp.WebDescriptor
    public void processOrdering() {
        XmlParser.Node ordering = getRoot().get("ordering");
        if (ordering != null) {
            this._isOrdered = true;
            processBefores(ordering);
            processAfters(ordering);
        }
    }

    public void processBefores(XmlParser.Node ordering) {
        XmlParser.Node before = ordering.get("before");
        if (before != null) {
            Iterator<?> iter = before.iterator();
            while (iter.hasNext()) {
                Object o = iter.next();
                if (o instanceof XmlParser.Node) {
                    XmlParser.Node node = (XmlParser.Node) o;
                    if (node.getTag().equalsIgnoreCase(LineReaderImpl.DEFAULT_OTHERS_GROUP_NAME)) {
                        if (this._otherType != OtherType.None) {
                            throw new IllegalStateException("Duplicate <other> clause detected in " + this._xml.getURI());
                        }
                        this._otherType = OtherType.Before;
                    } else if (node.getTag().equalsIgnoreCase("name")) {
                        this._befores.add(node.toString(false, true));
                    }
                }
            }
        }
    }

    public void processAfters(XmlParser.Node ordering) {
        XmlParser.Node after = ordering.get("after");
        if (after != null) {
            Iterator<?> iter = after.iterator();
            while (iter.hasNext()) {
                Object o = iter.next();
                if (o instanceof XmlParser.Node) {
                    XmlParser.Node node = (XmlParser.Node) o;
                    if (node.getTag().equalsIgnoreCase(LineReaderImpl.DEFAULT_OTHERS_GROUP_NAME)) {
                        if (this._otherType != OtherType.None) {
                            throw new IllegalStateException("Duplicate <other> clause detected in " + this._xml.getURI());
                        }
                        this._otherType = OtherType.After;
                    } else if (node.getTag().equalsIgnoreCase("name")) {
                        this._afters.add(node.toString(false, true));
                    }
                }
            }
        }
    }

    public List<String> getBefores() {
        return Collections.unmodifiableList(this._befores);
    }

    public List<String> getAfters() {
        return Collections.unmodifiableList(this._afters);
    }

    public OtherType getOtherType() {
        return this._otherType;
    }

    @Override // org.eclipse.jetty.webapp.WebDescriptor
    public List<String> getOrdering() {
        return null;
    }
}
