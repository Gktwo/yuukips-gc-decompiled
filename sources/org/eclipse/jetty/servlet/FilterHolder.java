package org.eclipse.jetty.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.servlet.BaseHolder;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.component.DumpableCollection;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/FilterHolder.class */
public class FilterHolder extends Holder<Filter> {
    private static final Logger LOG = Log.getLogger(FilterHolder.class);
    private transient Filter _filter;
    private transient Config _config;
    private transient FilterRegistration.Dynamic _registration;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/FilterHolder$WrapFunction.class */
    public interface WrapFunction {
        Filter wrapFilter(Filter filter);
    }

    public FilterHolder() {
        this(Source.EMBEDDED);
    }

    public FilterHolder(Source source) {
        super(source);
    }

    public FilterHolder(Class<? extends Filter> filter) {
        this(Source.EMBEDDED);
        setHeldClass(filter);
    }

    public FilterHolder(Filter filter) {
        this(Source.EMBEDDED);
        setFilter(filter);
    }

    @Override // org.eclipse.jetty.servlet.BaseHolder, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        doStart();
        if (!Filter.class.isAssignableFrom(getHeldClass())) {
            String msg = getHeldClass() + " is not a javax.servlet.Filter";
            doStop();
            throw new IllegalStateException(msg);
        }
    }

    @Override // org.eclipse.jetty.servlet.BaseHolder
    public void initialize() throws Exception {
        Filter filter;
        synchronized (this) {
            if (this._filter == null) {
                initialize();
                this._filter = getInstance();
                if (this._filter == null) {
                    ServletContext context = getServletHandler().getServletContext();
                    if (context != null) {
                        filter = context.createFilter(getHeldClass());
                    } else {
                        filter = (Filter) getHeldClass().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    }
                    try {
                        this._filter = filter;
                    } catch (ServletException ex) {
                        Throwable cause = ex.getRootCause();
                        if (cause instanceof InstantiationException) {
                            throw ((InstantiationException) cause);
                        } else if (cause instanceof IllegalAccessException) {
                            throw ((IllegalAccessException) cause);
                        } else {
                            throw ex;
                        }
                    }
                }
                this._filter = wrap(this._filter, WrapFunction.class, (v0, v1) -> {
                    return v0.wrapFilter(v1);
                });
                this._config = new Config();
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Filter.init {}", this._filter);
                }
                this._filter.init(this._config);
            }
        }
    }

    @Override // org.eclipse.jetty.servlet.BaseHolder, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        doStop();
        this._config = null;
        if (this._filter != null) {
            try {
                destroyInstance(this._filter);
            } finally {
                this._filter = null;
            }
        }
    }

    @Override // org.eclipse.jetty.servlet.Holder
    public void destroyInstance(Object o) {
        if (o != null) {
            Filter filter = (Filter) o;
            getServletHandler().destroyFilter(unwrap(filter));
            filter.destroy();
        }
    }

    public synchronized void setFilter(Filter filter) {
        setInstance(filter);
    }

    public Filter getFilter() {
        return this._filter;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (isAsyncSupported() || !request.isAsyncSupported()) {
            getFilter().doFilter(request, response, chain);
            return;
        }
        Request baseRequest = Request.getBaseRequest(request);
        Objects.requireNonNull(baseRequest);
        try {
            baseRequest.setAsyncSupported(false, this);
            getFilter().doFilter(request, response, chain);
            baseRequest.setAsyncSupported(true, null);
        } catch (Throwable th) {
            baseRequest.setAsyncSupported(true, null);
            throw th;
        }
    }

    @Override // org.eclipse.jetty.servlet.BaseHolder, org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        if (getInitParameters().isEmpty()) {
            Object[] objArr = new Object[1];
            objArr[0] = this._filter == null ? getHeldClass() : this._filter;
            Dumpable.dumpObjects(out, indent, this, objArr);
            return;
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = this._filter == null ? getHeldClass() : this._filter;
        objArr2[1] = new DumpableCollection("initParams", getInitParameters().entrySet());
        Dumpable.dumpObjects(out, indent, this, objArr2);
    }

    @Override // org.eclipse.jetty.servlet.Holder, org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        Object[] objArr = new Object[6];
        objArr[0] = getName();
        objArr[1] = getClassName();
        objArr[2] = Integer.valueOf(hashCode());
        objArr[3] = Boolean.valueOf(this._filter != null);
        objArr[4] = Boolean.valueOf(isAsyncSupported());
        objArr[5] = getSource();
        return String.format("%s==%s@%x{inst=%b,async=%b,src=%s}", objArr);
    }

    public FilterRegistration.Dynamic getRegistration() {
        if (this._registration == null) {
            this._registration = new Registration();
        }
        return this._registration;
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/FilterHolder$Registration.class */
    public class Registration extends Holder<Filter>.HolderRegistration implements FilterRegistration.Dynamic {
        protected Registration() {
            super();
        }

        @Override // javax.servlet.FilterRegistration
        public void addMappingForServletNames(EnumSet<DispatcherType> dispatcherTypes, boolean isMatchAfter, String... servletNames) {
            FilterHolder.this.illegalStateIfContextStarted();
            FilterMapping mapping = new FilterMapping();
            mapping.setFilterHolder(FilterHolder.this);
            mapping.setServletNames(servletNames);
            mapping.setDispatcherTypes(dispatcherTypes);
            if (isMatchAfter) {
                FilterHolder.this.getServletHandler().addFilterMapping(mapping);
            } else {
                FilterHolder.this.getServletHandler().prependFilterMapping(mapping);
            }
        }

        @Override // javax.servlet.FilterRegistration
        public void addMappingForUrlPatterns(EnumSet<DispatcherType> dispatcherTypes, boolean isMatchAfter, String... urlPatterns) {
            FilterHolder.this.illegalStateIfContextStarted();
            FilterMapping mapping = new FilterMapping();
            mapping.setFilterHolder(FilterHolder.this);
            mapping.setPathSpecs(urlPatterns);
            mapping.setDispatcherTypes(dispatcherTypes);
            if (isMatchAfter) {
                FilterHolder.this.getServletHandler().addFilterMapping(mapping);
            } else {
                FilterHolder.this.getServletHandler().prependFilterMapping(mapping);
            }
        }

        @Override // javax.servlet.FilterRegistration
        public Collection<String> getServletNameMappings() {
            String[] servlets;
            FilterMapping[] mappings = FilterHolder.this.getServletHandler().getFilterMappings();
            List<String> names = new ArrayList<>();
            for (FilterMapping mapping : mappings) {
                if (mapping.getFilterHolder() == FilterHolder.this && (servlets = mapping.getServletNames()) != null && servlets.length > 0) {
                    names.addAll(Arrays.asList(servlets));
                }
            }
            return names;
        }

        @Override // javax.servlet.FilterRegistration
        public Collection<String> getUrlPatternMappings() {
            FilterMapping[] mappings = FilterHolder.this.getServletHandler().getFilterMappings();
            List<String> patterns = new ArrayList<>();
            for (FilterMapping mapping : mappings) {
                if (mapping.getFilterHolder() == FilterHolder.this) {
                    patterns.addAll(TypeUtil.asList(mapping.getPathSpecs()));
                }
            }
            return patterns;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/FilterHolder$Config.class */
    public class Config extends Holder<Filter>.HolderConfig implements FilterConfig {
        Config() {
            super();
        }

        @Override // javax.servlet.FilterConfig
        public String getFilterName() {
            return FilterHolder.this.getName();
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/FilterHolder$Wrapper.class */
    public static class Wrapper implements Filter, BaseHolder.Wrapped<Filter> {
        private final Filter _filter;

        public Wrapper(Filter filter) {
            this._filter = (Filter) Objects.requireNonNull(filter, "Filter cannot be null");
        }

        @Override // org.eclipse.jetty.servlet.BaseHolder.Wrapped
        public Filter getWrapped() {
            return this._filter;
        }

        @Override // javax.servlet.Filter
        public void init(FilterConfig filterConfig) throws ServletException {
            this._filter.init(filterConfig);
        }

        @Override // javax.servlet.Filter
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            this._filter.doFilter(request, response, chain);
        }

        @Override // javax.servlet.Filter
        public void destroy() {
            this._filter.destroy();
        }

        public String toString() {
            return String.format("%s:%s", getClass().getSimpleName(), this._filter.toString());
        }
    }
}
