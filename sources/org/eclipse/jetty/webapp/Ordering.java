package org.eclipse.jetty.webapp;

import java.util.List;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/Ordering.class */
public interface Ordering {
    List<Resource> order(List<Resource> list);
}
