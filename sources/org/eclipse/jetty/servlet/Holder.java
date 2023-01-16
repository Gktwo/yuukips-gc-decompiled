package org.eclipse.jetty.servlet;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.servlet.Registration;
import javax.servlet.ServletContext;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@ManagedObject("Holder - a container for servlets and the like")
/* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/Holder.class */
public abstract class Holder<T> extends BaseHolder<T> {
    private static final Logger LOG = Log.getLogger(Holder.class);
    private final Map<String, String> _initParams = new HashMap(3);
    private String _displayName;
    private boolean _asyncSupported;
    private String _name;

    /* access modifiers changed from: protected */
    public Holder(Source source) {
        super(source);
        switch (getSource().getOrigin()) {
            case JAVAX_API:
            case DESCRIPTOR:
            case ANNOTATION:
                this._asyncSupported = false;
                return;
            default:
                this._asyncSupported = true;
                return;
        }
    }

    @ManagedAttribute(value = "Display Name", readonly = true)
    public String getDisplayName() {
        return this._displayName;
    }

    public String getInitParameter(String param) {
        if (this._initParams == null) {
            return null;
        }
        return this._initParams.get(param);
    }

    public Enumeration<String> getInitParameterNames() {
        if (this._initParams == null) {
            return Collections.enumeration(Collections.EMPTY_LIST);
        }
        return Collections.enumeration(this._initParams.keySet());
    }

    @ManagedAttribute(value = "Initial Parameters", readonly = true)
    public Map<String, String> getInitParameters() {
        return this._initParams;
    }

    @ManagedAttribute(value = "Name", readonly = true)
    public String getName() {
        return this._name;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.servlet.BaseHolder
    public synchronized void setInstance(T instance) {
        setInstance(instance);
        if (getName() == null) {
            setName(String.format("%s@%x", instance.getClass().getName(), Integer.valueOf(instance.hashCode())));
        }
    }

    public void destroyInstance(Object instance) throws Exception {
    }

    @Override // org.eclipse.jetty.servlet.BaseHolder
    public void setClassName(String className) {
        setClassName(className);
        if (this._name == null) {
            this._name = className + "-" + Integer.toHexString(hashCode());
        }
    }

    @Override // org.eclipse.jetty.servlet.BaseHolder
    public void setHeldClass(Class<? extends T> held) {
        setHeldClass(held);
        if (held != null && this._name == null) {
            this._name = held.getName() + "-" + Integer.toHexString(hashCode());
        }
    }

    public void setDisplayName(String name) {
        this._displayName = name;
    }

    public void setInitParameter(String param, String value) {
        this._initParams.put(param, value);
    }

    public void setInitParameters(Map<String, String> map) {
        this._initParams.clear();
        this._initParams.putAll(map);
    }

    public void setName(String name) {
        this._name = name;
    }

    public void setAsyncSupported(boolean suspendable) {
        this._asyncSupported = suspendable;
    }

    public boolean isAsyncSupported() {
        return this._asyncSupported;
    }

    @Override // org.eclipse.jetty.servlet.BaseHolder, org.eclipse.jetty.util.component.Dumpable
    public String dump() {
        return dump();
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s@%x==%s", this._name, Integer.valueOf(hashCode()), getClassName());
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/Holder$HolderConfig.class */
    public class HolderConfig {
        /* access modifiers changed from: protected */
        public HolderConfig() {
        }

        public ServletContext getServletContext() {
            return Holder.this.getServletHandler().getServletContext();
        }

        public String getInitParameter(String param) {
            return Holder.this.getInitParameter(param);
        }

        public Enumeration<String> getInitParameterNames() {
            return Holder.this.getInitParameterNames();
        }
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/Holder$HolderRegistration.class */
    public class HolderRegistration implements Registration.Dynamic {
        /* access modifiers changed from: protected */
        public HolderRegistration() {
        }

        @Override // javax.servlet.Registration.Dynamic
        public void setAsyncSupported(boolean isAsyncSupported) {
            Holder.this.illegalStateIfContextStarted();
            Holder.this.setAsyncSupported(isAsyncSupported);
        }

        public void setDescription(String description) {
            if (Holder.LOG.isDebugEnabled()) {
                Holder.LOG.debug(this + " is " + description, new Object[0]);
            }
        }

        @Override // javax.servlet.Registration
        public String getClassName() {
            return Holder.this.getClassName();
        }

        @Override // javax.servlet.Registration
        public String getInitParameter(String name) {
            return Holder.this.getInitParameter(name);
        }

        @Override // javax.servlet.Registration
        public Map<String, String> getInitParameters() {
            return Holder.this.getInitParameters();
        }

        @Override // javax.servlet.Registration
        public String getName() {
            return Holder.this.getName();
        }

        @Override // javax.servlet.Registration
        public boolean setInitParameter(String name, String value) {
            Holder.this.illegalStateIfContextStarted();
            if (name == null) {
                throw new IllegalArgumentException("init parameter name required");
            } else if (value == null) {
                throw new IllegalArgumentException("non-null value required for init parameter " + name);
            } else if (Holder.this.getInitParameter(name) != null) {
                return false;
            } else {
                Holder.this.setInitParameter(name, value);
                return true;
            }
        }

        @Override // javax.servlet.Registration
        public Set<String> setInitParameters(Map<String, String> initParameters) {
            Holder.this.illegalStateIfContextStarted();
            Set<String> clash = null;
            for (Map.Entry<String, String> entry : initParameters.entrySet()) {
                if (entry.getKey() == null) {
                    throw new IllegalArgumentException("init parameter name required");
                } else if (entry.getValue() == null) {
                    throw new IllegalArgumentException("non-null value required for init parameter " + entry.getKey());
                } else if (Holder.this.getInitParameter(entry.getKey()) != null) {
                    if (clash == null) {
                        clash = new HashSet<>();
                    }
                    clash.add(entry.getKey());
                }
            }
            if (clash != null) {
                return clash;
            }
            Holder.this.getInitParameters().putAll(initParameters);
            return Collections.emptySet();
        }
    }
}
