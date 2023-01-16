package org.eclipse.jetty.webapp;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.eclipse.jetty.xml.XmlParser;

/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/IterativeDescriptorProcessor.class */
public abstract class IterativeDescriptorProcessor implements DescriptorProcessor {
    public static final Class<?>[] __signature = {WebAppContext.class, Descriptor.class, XmlParser.Node.class};
    protected Map<String, Method> _visitors = new HashMap();

    public abstract void start(WebAppContext webAppContext, Descriptor descriptor);

    public abstract void end(WebAppContext webAppContext, Descriptor descriptor);

    public void registerVisitor(String nodeName, Method m) {
        this._visitors.put(nodeName, m);
    }

    @Override // org.eclipse.jetty.webapp.DescriptorProcessor
    public void process(WebAppContext context, Descriptor descriptor) throws Exception {
        if (descriptor != null) {
            start(context, descriptor);
            Iterator<?> iter = descriptor.getRoot().iterator();
            while (iter.hasNext()) {
                Object o = iter.next();
                if (o instanceof XmlParser.Node) {
                    visit(context, descriptor, (XmlParser.Node) o);
                }
            }
            end(context, descriptor);
        }
    }

    protected void visit(WebAppContext context, Descriptor descriptor, XmlParser.Node node) throws Exception {
        Method m = this._visitors.get(node.getTag());
        if (m != null) {
            m.invoke(this, context, descriptor, node);
        }
    }
}
