package org.eclipse.jetty.webapp;

import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/DiscoveredAnnotation.class */
public abstract class DiscoveredAnnotation {
    private static final Logger LOG = Log.getLogger(DiscoveredAnnotation.class);
    protected WebAppContext _context;
    protected String _className;
    protected Class<?> _clazz;
    protected Resource _resource;

    public abstract void apply();

    public DiscoveredAnnotation(WebAppContext context, String className) {
        this(context, className, null);
    }

    public DiscoveredAnnotation(WebAppContext context, String className, Resource resource) {
        this._context = context;
        this._className = className;
        this._resource = resource;
    }

    public Resource getResource() {
        return this._resource;
    }

    public Class<?> getTargetClass() {
        if (this._clazz != null) {
            return this._clazz;
        }
        loadClass();
        return this._clazz;
    }

    private void loadClass() {
        if (this._clazz == null && this._className != null) {
            try {
                this._clazz = Loader.loadClass(this._className);
            } catch (Exception e) {
                LOG.warn(e);
            }
        }
    }
}
