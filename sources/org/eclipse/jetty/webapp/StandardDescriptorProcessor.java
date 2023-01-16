package org.eclipse.jetty.webapp;

import dev.morphia.mapping.Mapper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.servlet.DispatcherType;
import javax.servlet.MultipartConfigElement;
import javax.servlet.SessionTrackingMode;
import org.eclipse.jetty.http.pathmap.ServletPathSpec;
import org.eclipse.jetty.security.ConstraintAware;
import org.eclipse.jetty.security.ConstraintMapping;
import org.eclipse.jetty.security.authentication.FormAuthenticator;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ErrorPageErrorHandler;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.FilterMapping;
import org.eclipse.jetty.servlet.ListenerHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlet.ServletMapping;
import org.eclipse.jetty.servlet.Source;
import org.eclipse.jetty.util.ArrayUtil;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.security.Constraint;
import org.eclipse.jetty.xml.XmlParser;

/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/StandardDescriptorProcessor.class */
public class StandardDescriptorProcessor extends IterativeDescriptorProcessor {
    private static final Logger LOG = Log.getLogger(StandardDescriptorProcessor.class);
    public static final String STANDARD_PROCESSOR = "org.eclipse.jetty.standardDescriptorProcessor";
    final Map<String, FilterHolder> _filterHolderMap = new HashMap();
    final List<FilterHolder> _filterHolders = new ArrayList();
    final List<FilterMapping> _filterMappings = new ArrayList();
    final Map<String, ServletHolder> _servletHolderMap = new HashMap();
    final List<ServletHolder> _servletHolders = new ArrayList();
    final List<ServletMapping> _servletMappings = new ArrayList();

    public StandardDescriptorProcessor() {
        try {
            registerVisitor("context-param", getClass().getMethod("visitContextParam", __signature));
            registerVisitor("display-name", getClass().getMethod("visitDisplayName", __signature));
            registerVisitor("servlet", getClass().getMethod("visitServlet", __signature));
            registerVisitor("servlet-mapping", getClass().getMethod("visitServletMapping", __signature));
            registerVisitor("session-config", getClass().getMethod("visitSessionConfig", __signature));
            registerVisitor("mime-mapping", getClass().getMethod("visitMimeMapping", __signature));
            registerVisitor("welcome-file-list", getClass().getMethod("visitWelcomeFileList", __signature));
            registerVisitor("locale-encoding-mapping-list", getClass().getMethod("visitLocaleEncodingList", __signature));
            registerVisitor("error-page", getClass().getMethod("visitErrorPage", __signature));
            registerVisitor("taglib", getClass().getMethod("visitTagLib", __signature));
            registerVisitor("jsp-config", getClass().getMethod("visitJspConfig", __signature));
            registerVisitor("security-constraint", getClass().getMethod("visitSecurityConstraint", __signature));
            registerVisitor("login-config", getClass().getMethod("visitLoginConfig", __signature));
            registerVisitor("security-role", getClass().getMethod("visitSecurityRole", __signature));
            registerVisitor("filter", getClass().getMethod("visitFilter", __signature));
            registerVisitor("filter-mapping", getClass().getMethod("visitFilterMapping", __signature));
            registerVisitor("listener", getClass().getMethod("visitListener", __signature));
            registerVisitor("distributable", getClass().getMethod("visitDistributable", __signature));
            registerVisitor("deny-uncovered-http-methods", getClass().getMethod("visitDenyUncoveredHttpMethods", __signature));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // org.eclipse.jetty.webapp.IterativeDescriptorProcessor
    public void start(WebAppContext context, Descriptor descriptor) {
        FilterHolder[] filters = context.getServletHandler().getFilters();
        for (FilterHolder h : filters) {
            this._filterHolderMap.put(h.getName(), h);
            this._filterHolders.add(h);
        }
        if (context.getServletHandler().getFilterMappings() != null) {
            this._filterMappings.addAll(Arrays.asList(context.getServletHandler().getFilterMappings()));
        }
        ServletHolder[] servlets = context.getServletHandler().getServlets();
        for (ServletHolder h2 : servlets) {
            this._servletHolderMap.put(h2.getName(), h2);
            this._servletHolders.add(h2);
        }
        if (context.getServletHandler().getServletMappings() != null) {
            this._servletMappings.addAll(Arrays.asList(context.getServletHandler().getServletMappings()));
        }
    }

    @Override // org.eclipse.jetty.webapp.IterativeDescriptorProcessor
    public void end(WebAppContext context, Descriptor descriptor) {
        context.getServletHandler().setFilters((FilterHolder[]) this._filterHolders.toArray(new FilterHolder[this._filterHolderMap.size()]));
        context.getServletHandler().setServlets((ServletHolder[]) this._servletHolders.toArray(new ServletHolder[this._servletHolderMap.size()]));
        context.getServletHandler().setFilterMappings((FilterMapping[]) this._filterMappings.toArray(new FilterMapping[this._filterMappings.size()]));
        context.getServletHandler().setServletMappings((ServletMapping[]) this._servletMappings.toArray(new ServletMapping[this._servletMappings.size()]));
        this._filterHolderMap.clear();
        this._filterHolders.clear();
        this._filterMappings.clear();
        this._servletHolderMap.clear();
        this._servletHolders.clear();
        this._servletMappings.clear();
    }

    public void visitContextParam(WebAppContext context, Descriptor descriptor, XmlParser.Node node) {
        String name = node.getString("param-name", false, true);
        String value = node.getString("param-value", false, true);
        switch (context.getMetaData().getOrigin(new StringBuilder().append("context-param.").append(name).toString())) {
            case NotSet:
                context.getInitParams().put(name, value);
                context.getMetaData().setOrigin("context-param." + name, descriptor);
                break;
            case WebXml:
            case WebDefaults:
            case WebOverride:
                if (!(descriptor instanceof FragmentDescriptor)) {
                    context.getInitParams().put(name, value);
                    context.getMetaData().setOrigin("context-param." + name, descriptor);
                    break;
                }
                break;
            case WebFragment:
                if ((descriptor instanceof FragmentDescriptor) && !context.getInitParams().get(name).equals(value)) {
                    throw new IllegalStateException("Conflicting context-param " + name + "=" + value + " in " + descriptor.getResource());
                }
                break;
            default:
                LOG.warn(new Throwable());
                break;
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("ContextParam: " + name + "=" + value, new Object[0]);
        }
    }

    public void visitDisplayName(WebAppContext context, Descriptor descriptor, XmlParser.Node node) {
        if (!(descriptor instanceof FragmentDescriptor)) {
            context.setDisplayName(node.toString(false, true));
            context.getMetaData().setOrigin("display-name", descriptor);
        }
    }

    public void visitServlet(WebAppContext context, Descriptor descriptor, XmlParser.Node node) {
        String roleName;
        String id = node.getAttribute("id");
        String name = node.getString("servlet-name", false, true);
        ServletHolder holder = this._servletHolderMap.get(name);
        if (holder == null) {
            holder = context.getServletHandler().newServletHolder(new Source(Source.Origin.DESCRIPTOR, descriptor.getResource().toString()));
            holder.setName(name);
            this._servletHolderMap.put(name, holder);
            this._servletHolders.add(holder);
        }
        Iterator<?> iParamsIter = node.iterator("init-param");
        while (iParamsIter.hasNext()) {
            XmlParser.Node paramNode = iParamsIter.next();
            String pname = paramNode.getString("param-name", false, true);
            String pvalue = paramNode.getString("param-value", false, true);
            String originName = name + ".servlet.init-param." + pname;
            Descriptor originDescriptor = context.getMetaData().getOriginDescriptor(originName);
            switch (context.getMetaData().getOrigin(originName)) {
                case NotSet:
                    holder.setInitParameter(pname, pvalue);
                    context.getMetaData().setOrigin(originName, descriptor);
                    break;
                case WebXml:
                case WebDefaults:
                case WebOverride:
                    if (!(descriptor instanceof FragmentDescriptor) && descriptor != originDescriptor) {
                        holder.setInitParameter(pname, pvalue);
                        context.getMetaData().setOrigin(originName, descriptor);
                        break;
                    }
                    break;
                case WebFragment:
                    if (descriptor != originDescriptor && !holder.getInitParameter(pname).equals(pvalue)) {
                        throw new IllegalStateException("Mismatching init-param " + pname + "=" + pvalue + " in " + descriptor.getResource());
                    }
                    break;
                default:
                    LOG.warn(new Throwable());
                    break;
            }
        }
        String servletClass = node.getString("servlet-class", false, true);
        if ("".equals(servletClass)) {
            servletClass = null;
        }
        if (!(id == null || !id.equals("jsp") || servletClass == null)) {
            try {
                Loader.loadClass(servletClass);
            } catch (ClassNotFoundException e) {
                LOG.info("NO JSP Support for {}, did not find {}", context.getContextPath(), servletClass);
                servletClass = "org.eclipse.jetty.servlet.NoJspServlet";
            }
        }
        if (servletClass != null) {
            ((WebDescriptor) descriptor).addClassName(servletClass);
            switch (context.getMetaData().getOrigin(new StringBuilder().append(name).append(".servlet.servlet-class").toString())) {
                case NotSet:
                    holder.setClassName(servletClass);
                    context.getMetaData().setOrigin(name + ".servlet.servlet-class", descriptor);
                    break;
                case WebXml:
                case WebDefaults:
                case WebOverride:
                    if (!(descriptor instanceof FragmentDescriptor)) {
                        holder.setClassName(servletClass);
                        context.getMetaData().setOrigin(name + ".servlet.servlet-class", descriptor);
                        break;
                    }
                    break;
                case WebFragment:
                    if (!servletClass.equals(holder.getClassName())) {
                        throw new IllegalStateException("Conflicting servlet-class " + servletClass + " in " + descriptor.getResource());
                    }
                    break;
                default:
                    LOG.warn(new Throwable());
                    break;
            }
        }
        String jspFile = node.getString("jsp-file", false, true);
        if (jspFile != null) {
            holder.setForcedPath(jspFile);
        }
        XmlParser.Node startup = node.get("load-on-startup");
        if (startup != null) {
            String s = startup.toString(false, true).toLowerCase(Locale.ENGLISH);
            int order = 0;
            if (s.startsWith("t")) {
                LOG.warn("Deprecated boolean load-on-startup.  Please use integer", new Object[0]);
                order = 1;
            } else if (s != null) {
                try {
                    if (s.trim().length() > 0) {
                        order = Integer.parseInt(s);
                    }
                } catch (Exception e2) {
                    LOG.warn("Cannot parse load-on-startup " + s + ". Please use integer", new Object[0]);
                    LOG.ignore(e2);
                }
            }
            switch (context.getMetaData().getOrigin(new StringBuilder().append(name).append(".servlet.load-on-startup").toString())) {
                case NotSet:
                    holder.setInitOrder(order);
                    context.getMetaData().setOrigin(name + ".servlet.load-on-startup", descriptor);
                    break;
                case WebXml:
                case WebDefaults:
                case WebOverride:
                    if (!(descriptor instanceof FragmentDescriptor)) {
                        holder.setInitOrder(order);
                        context.getMetaData().setOrigin(name + ".servlet.load-on-startup", descriptor);
                        break;
                    }
                    break;
                case WebFragment:
                    if (order != holder.getInitOrder()) {
                        throw new IllegalStateException("Conflicting load-on-startup value in " + descriptor.getResource());
                    }
                    break;
                default:
                    LOG.warn(new Throwable());
                    break;
            }
        }
        Iterator<XmlParser.Node> sRefsIter = node.iterator("security-role-ref");
        while (sRefsIter.hasNext()) {
            XmlParser.Node securityRef = sRefsIter.next();
            String roleName2 = securityRef.getString("role-name", false, true);
            String roleLink = securityRef.getString("role-link", false, true);
            if (roleName2 == null || roleName2.length() <= 0 || roleLink == null || roleLink.length() <= 0) {
                LOG.warn("Ignored invalid security-role-ref element: servlet-name=" + holder.getName() + ", " + securityRef, new Object[0]);
            } else {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("link role " + roleName2 + " to " + roleLink + " for " + this, new Object[0]);
                }
                switch (context.getMetaData().getOrigin(new StringBuilder().append(name).append(".servlet.role-name.").append(roleName2).toString())) {
                    case NotSet:
                        holder.setUserRoleLink(roleName2, roleLink);
                        context.getMetaData().setOrigin(name + ".servlet.role-name." + roleName2, descriptor);
                        continue;
                    case WebXml:
                    case WebDefaults:
                    case WebOverride:
                        if (!(descriptor instanceof FragmentDescriptor)) {
                            holder.setUserRoleLink(roleName2, roleLink);
                            context.getMetaData().setOrigin(name + ".servlet.role-name." + roleName2, descriptor);
                            break;
                        } else {
                            continue;
                        }
                    case WebFragment:
                        if (!holder.getUserRoleLink(roleName2).equals(roleLink)) {
                            throw new IllegalStateException("Conflicting role-link for role-name " + roleName2 + " for servlet " + name + " in " + descriptor.getResource());
                        }
                        continue;
                    default:
                        LOG.warn(new Throwable());
                        continue;
                }
            }
        }
        XmlParser.Node runAs = node.get("run-as");
        if (!(runAs == null || (roleName = runAs.getString("role-name", false, true)) == null)) {
            switch (context.getMetaData().getOrigin(new StringBuilder().append(name).append(".servlet.run-as").toString())) {
                case NotSet:
                    holder.setRunAsRole(roleName);
                    context.getMetaData().setOrigin(name + ".servlet.run-as", descriptor);
                    break;
                case WebXml:
                case WebDefaults:
                case WebOverride:
                    if (!(descriptor instanceof FragmentDescriptor)) {
                        holder.setRunAsRole(roleName);
                        context.getMetaData().setOrigin(name + ".servlet.run-as", descriptor);
                        break;
                    }
                    break;
                case WebFragment:
                    if (!holder.getRunAsRole().equals(roleName)) {
                        throw new IllegalStateException("Conflicting run-as role " + roleName + " for servlet " + name + " in " + descriptor.getResource());
                    }
                    break;
                default:
                    LOG.warn(new Throwable());
                    break;
            }
        }
        String async = node.getString("async-supported", false, true);
        if (async != null) {
            boolean val = async.length() == 0 || Boolean.parseBoolean(async);
            switch (context.getMetaData().getOrigin(new StringBuilder().append(name).append(".servlet.async-supported").toString())) {
                case NotSet:
                    holder.setAsyncSupported(val);
                    context.getMetaData().setOrigin(name + ".servlet.async-supported", descriptor);
                    break;
                case WebXml:
                case WebDefaults:
                case WebOverride:
                    if (!(descriptor instanceof FragmentDescriptor)) {
                        holder.setAsyncSupported(val);
                        context.getMetaData().setOrigin(name + ".servlet.async-supported", descriptor);
                        break;
                    }
                    break;
                case WebFragment:
                    if (holder.isAsyncSupported() != val) {
                        throw new IllegalStateException("Conflicting async-supported=" + async + " for servlet " + name + " in " + descriptor.getResource());
                    }
                    break;
                default:
                    LOG.warn(new Throwable());
                    break;
            }
        }
        String enabled = node.getString("enabled", false, true);
        if (enabled != null) {
            boolean isEnabled = enabled.length() == 0 || Boolean.parseBoolean(enabled);
            switch (context.getMetaData().getOrigin(new StringBuilder().append(name).append(".servlet.enabled").toString())) {
                case NotSet:
                    holder.setEnabled(isEnabled);
                    context.getMetaData().setOrigin(name + ".servlet.enabled", descriptor);
                    break;
                case WebXml:
                case WebDefaults:
                case WebOverride:
                    if (!(descriptor instanceof FragmentDescriptor)) {
                        holder.setEnabled(isEnabled);
                        context.getMetaData().setOrigin(name + ".servlet.enabled", descriptor);
                        break;
                    }
                    break;
                case WebFragment:
                    if (holder.isEnabled() != isEnabled) {
                        throw new IllegalStateException("Conflicting value of servlet enabled for servlet " + name + " in " + descriptor.getResource());
                    }
                    break;
                default:
                    LOG.warn(new Throwable());
                    break;
            }
        }
        XmlParser.Node multipart = node.get("multipart-config");
        if (multipart != null) {
            String location = multipart.getString("location", false, true);
            String maxFile = multipart.getString("max-file-size", false, true);
            String maxRequest = multipart.getString("max-request-size", false, true);
            String threshold = multipart.getString("file-size-threshold", false, true);
            MultipartConfigElement element = new MultipartConfigElement(location, (maxFile == null || "".equals(maxFile)) ? -1 : Long.parseLong(maxFile), (maxRequest == null || "".equals(maxRequest)) ? -1 : Long.parseLong(maxRequest), (threshold == null || "".equals(threshold)) ? 0 : Integer.parseInt(threshold));
            switch (context.getMetaData().getOrigin(new StringBuilder().append(name).append(".servlet.multipart-config").toString())) {
                case NotSet:
                    holder.getRegistration().setMultipartConfig(element);
                    context.getMetaData().setOrigin(name + ".servlet.multipart-config", descriptor);
                    return;
                case WebXml:
                case WebDefaults:
                case WebOverride:
                    if (!(descriptor instanceof FragmentDescriptor)) {
                        holder.getRegistration().setMultipartConfig(element);
                        context.getMetaData().setOrigin(name + ".servlet.multipart-config", descriptor);
                        return;
                    }
                    return;
                case WebFragment:
                    MultipartConfigElement cfg = ((ServletHolder.Registration) holder.getRegistration()).getMultipartConfig();
                    if (cfg.getMaxFileSize() != element.getMaxFileSize()) {
                        throw new IllegalStateException("Conflicting multipart-config max-file-size for servlet " + name + " in " + descriptor.getResource());
                    } else if (cfg.getMaxRequestSize() != element.getMaxRequestSize()) {
                        throw new IllegalStateException("Conflicting multipart-config max-request-size for servlet " + name + " in " + descriptor.getResource());
                    } else if (cfg.getFileSizeThreshold() != element.getFileSizeThreshold()) {
                        throw new IllegalStateException("Conflicting multipart-config file-size-threshold for servlet " + name + " in " + descriptor.getResource());
                    } else {
                        if (cfg.getLocation() == null || !(element.getLocation() == null || element.getLocation().length() == 0)) {
                            if (cfg.getLocation() != null) {
                                return;
                            }
                            if (element.getLocation() == null && element.getLocation().length() <= 0) {
                                return;
                            }
                        }
                        throw new IllegalStateException("Conflicting multipart-config location for servlet " + name + " in " + descriptor.getResource());
                    }
                default:
                    LOG.warn(new Throwable());
                    return;
            }
        }
    }

    public void visitServletMapping(WebAppContext context, Descriptor descriptor, XmlParser.Node node) {
        String servletName = node.getString("servlet-name", false, true);
        switch (context.getMetaData().getOrigin(new StringBuilder().append(servletName).append(".servlet.mappings").toString())) {
            case NotSet:
                context.getMetaData().setOrigin(servletName + ".servlet.mappings", descriptor);
                addServletMapping(servletName, node, context, descriptor);
                return;
            case WebXml:
            case WebDefaults:
            case WebOverride:
                if (!(descriptor instanceof FragmentDescriptor)) {
                    addServletMapping(servletName, node, context, descriptor);
                    return;
                }
                return;
            case WebFragment:
                addServletMapping(servletName, node, context, descriptor);
                return;
            default:
                LOG.warn(new Throwable());
                return;
        }
    }

    public void visitSessionConfig(WebAppContext context, Descriptor descriptor, XmlParser.Node node) {
        if (context.getSessionHandler() != null) {
            XmlParser.Node tNode = node.get("session-timeout");
            if (tNode != null) {
                BigDecimal asDecimal = new BigDecimal(tNode.toString(false, true));
                if (asDecimal.compareTo(SessionHandler.MAX_INACTIVE_MINUTES) > 0) {
                    throw new IllegalStateException("Max session-timeout in minutes is " + SessionHandler.MAX_INACTIVE_MINUTES);
                }
                context.getSessionHandler().setMaxInactiveInterval(asDecimal.intValueExact() * 60);
            }
            Iterator<XmlParser.Node> iter = node.iterator("tracking-mode");
            if (iter.hasNext()) {
                Set<SessionTrackingMode> modes = null;
                switch (context.getMetaData().getOrigin("session.tracking-mode")) {
                    case NotSet:
                    case WebDefaults:
                        modes = new HashSet<>();
                        context.getMetaData().setOrigin("session.tracking-mode", descriptor);
                        break;
                    case WebXml:
                    case WebOverride:
                    case WebFragment:
                        if (descriptor instanceof OverrideDescriptor) {
                            modes = new HashSet<>();
                        } else {
                            modes = new HashSet<>(context.getSessionHandler().getEffectiveSessionTrackingModes());
                        }
                        context.getMetaData().setOrigin("session.tracking-mode", descriptor);
                        break;
                    default:
                        LOG.warn(new Throwable());
                        break;
                }
                while (iter.hasNext()) {
                    modes.add(SessionTrackingMode.valueOf(iter.next().toString(false, true)));
                }
                context.getSessionHandler().setSessionTrackingModes(modes);
            }
            XmlParser.Node cookieConfig = node.get("cookie-config");
            if (cookieConfig != null) {
                String name = cookieConfig.getString("name", false, true);
                if (name != null) {
                    switch (context.getMetaData().getOrigin("cookie-config.name")) {
                        case NotSet:
                            context.getSessionHandler().getSessionCookieConfig().setName(name);
                            context.getMetaData().setOrigin("cookie-config.name", descriptor);
                            break;
                        case WebXml:
                        case WebDefaults:
                        case WebOverride:
                            if (!(descriptor instanceof FragmentDescriptor)) {
                                context.getSessionHandler().getSessionCookieConfig().setName(name);
                                context.getMetaData().setOrigin("cookie-config.name", descriptor);
                                break;
                            }
                            break;
                        case WebFragment:
                            if (!name.equals(SessionHandler.getSessionCookieName(context.getSessionHandler().getSessionCookieConfig()))) {
                                throw new IllegalStateException("Conflicting cookie-config name " + name + " in " + descriptor.getResource());
                            }
                            break;
                        default:
                            LOG.warn(new Throwable());
                            break;
                    }
                }
                String domain = cookieConfig.getString("domain", false, true);
                if (domain != null) {
                    switch (context.getMetaData().getOrigin("cookie-config.domain")) {
                        case NotSet:
                            context.getSessionHandler().getSessionCookieConfig().setDomain(domain);
                            context.getMetaData().setOrigin("cookie-config.domain", descriptor);
                            break;
                        case WebXml:
                        case WebDefaults:
                        case WebOverride:
                            if (!(descriptor instanceof FragmentDescriptor)) {
                                context.getSessionHandler().getSessionCookieConfig().setDomain(domain);
                                context.getMetaData().setOrigin("cookie-config.domain", descriptor);
                                break;
                            }
                            break;
                        case WebFragment:
                            if (!context.getSessionHandler().getSessionCookieConfig().getDomain().equals(domain)) {
                                throw new IllegalStateException("Conflicting cookie-config domain " + domain + " in " + descriptor.getResource());
                            }
                            break;
                        default:
                            LOG.warn(new Throwable());
                            break;
                    }
                }
                String path = cookieConfig.getString("path", false, true);
                if (path != null) {
                    switch (context.getMetaData().getOrigin("cookie-config.path")) {
                        case NotSet:
                            context.getSessionHandler().getSessionCookieConfig().setPath(path);
                            context.getMetaData().setOrigin("cookie-config.path", descriptor);
                            break;
                        case WebXml:
                        case WebDefaults:
                        case WebOverride:
                            if (!(descriptor instanceof FragmentDescriptor)) {
                                context.getSessionHandler().getSessionCookieConfig().setPath(path);
                                context.getMetaData().setOrigin("cookie-config.path", descriptor);
                                break;
                            }
                            break;
                        case WebFragment:
                            if (!path.equals(context.getSessionHandler().getSessionCookieConfig().getPath())) {
                                throw new IllegalStateException("Conflicting cookie-config path " + path + " in " + descriptor.getResource());
                            }
                            break;
                        default:
                            LOG.warn(new Throwable());
                            break;
                    }
                }
                String comment = cookieConfig.getString("comment", false, true);
                if (comment != null) {
                    switch (context.getMetaData().getOrigin("cookie-config.comment")) {
                        case NotSet:
                            context.getSessionHandler().getSessionCookieConfig().setComment(comment);
                            context.getMetaData().setOrigin("cookie-config.comment", descriptor);
                            break;
                        case WebXml:
                        case WebDefaults:
                        case WebOverride:
                            if (!(descriptor instanceof FragmentDescriptor)) {
                                context.getSessionHandler().getSessionCookieConfig().setComment(comment);
                                context.getMetaData().setOrigin("cookie-config.comment", descriptor);
                                break;
                            }
                            break;
                        case WebFragment:
                            if (!context.getSessionHandler().getSessionCookieConfig().getComment().equals(comment)) {
                                throw new IllegalStateException("Conflicting cookie-config comment " + comment + " in " + descriptor.getResource());
                            }
                            break;
                        default:
                            LOG.warn(new Throwable());
                            break;
                    }
                }
                XmlParser.Node tNode2 = cookieConfig.get("http-only");
                if (tNode2 != null) {
                    boolean httpOnly = Boolean.parseBoolean(tNode2.toString(false, true));
                    switch (context.getMetaData().getOrigin("cookie-config.http-only")) {
                        case NotSet:
                            context.getSessionHandler().getSessionCookieConfig().setHttpOnly(httpOnly);
                            context.getMetaData().setOrigin("cookie-config.http-only", descriptor);
                            break;
                        case WebXml:
                        case WebDefaults:
                        case WebOverride:
                            if (!(descriptor instanceof FragmentDescriptor)) {
                                context.getSessionHandler().getSessionCookieConfig().setHttpOnly(httpOnly);
                                context.getMetaData().setOrigin("cookie-config.http-only", descriptor);
                                break;
                            }
                            break;
                        case WebFragment:
                            if (context.getSessionHandler().getSessionCookieConfig().isHttpOnly() != httpOnly) {
                                throw new IllegalStateException("Conflicting cookie-config http-only " + httpOnly + " in " + descriptor.getResource());
                            }
                            break;
                        default:
                            LOG.warn(new Throwable());
                            break;
                    }
                }
                XmlParser.Node tNode3 = cookieConfig.get("secure");
                if (tNode3 != null) {
                    boolean secure = Boolean.parseBoolean(tNode3.toString(false, true));
                    switch (context.getMetaData().getOrigin("cookie-config.secure")) {
                        case NotSet:
                            context.getSessionHandler().getSessionCookieConfig().setSecure(secure);
                            context.getMetaData().setOrigin("cookie-config.secure", descriptor);
                            break;
                        case WebXml:
                        case WebDefaults:
                        case WebOverride:
                            if (!(descriptor instanceof FragmentDescriptor)) {
                                context.getSessionHandler().getSessionCookieConfig().setSecure(secure);
                                context.getMetaData().setOrigin("cookie-config.secure", descriptor);
                                break;
                            }
                            break;
                        case WebFragment:
                            if (context.getSessionHandler().getSessionCookieConfig().isSecure() != secure) {
                                throw new IllegalStateException("Conflicting cookie-config secure " + secure + " in " + descriptor.getResource());
                            }
                            break;
                        default:
                            LOG.warn(new Throwable());
                            break;
                    }
                }
                XmlParser.Node tNode4 = cookieConfig.get("max-age");
                if (tNode4 != null) {
                    int maxAge = Integer.parseInt(tNode4.toString(false, true));
                    switch (context.getMetaData().getOrigin("cookie-config.max-age")) {
                        case NotSet:
                            context.getSessionHandler().getSessionCookieConfig().setMaxAge(maxAge);
                            context.getMetaData().setOrigin("cookie-config.max-age", descriptor);
                            return;
                        case WebXml:
                        case WebDefaults:
                        case WebOverride:
                            if (!(descriptor instanceof FragmentDescriptor)) {
                                context.getSessionHandler().getSessionCookieConfig().setMaxAge(maxAge);
                                context.getMetaData().setOrigin("cookie-config.max-age", descriptor);
                                return;
                            }
                            return;
                        case WebFragment:
                            if (context.getSessionHandler().getSessionCookieConfig().getMaxAge() != maxAge) {
                                throw new IllegalStateException("Conflicting cookie-config max-age " + maxAge + " in " + descriptor.getResource());
                            }
                            return;
                        default:
                            LOG.warn(new Throwable());
                            return;
                    }
                }
            }
        }
    }

    public void visitMimeMapping(WebAppContext context, Descriptor descriptor, XmlParser.Node node) {
        String extension = node.getString("extension", false, true);
        if (extension != null && extension.startsWith(Mapper.IGNORED_FIELDNAME)) {
            extension = extension.substring(1);
        }
        String mimeType = node.getString("mime-type", false, true);
        if (extension != null) {
            switch (context.getMetaData().getOrigin(new StringBuilder().append("extension.").append(extension).toString())) {
                case NotSet:
                    context.getMimeTypes().addMimeMapping(extension, mimeType);
                    context.getMetaData().setOrigin("extension." + extension, descriptor);
                    return;
                case WebXml:
                case WebDefaults:
                case WebOverride:
                    if (!(descriptor instanceof FragmentDescriptor)) {
                        context.getMimeTypes().addMimeMapping(extension, mimeType);
                        context.getMetaData().setOrigin("extension." + extension, descriptor);
                        return;
                    }
                    return;
                case WebFragment:
                    if (!context.getMimeTypes().getMimeByExtension(Mapper.IGNORED_FIELDNAME + extension).equals(mimeType)) {
                        throw new IllegalStateException("Conflicting mime-type " + mimeType + " for extension " + extension + " in " + descriptor.getResource());
                    }
                    return;
                default:
                    LOG.warn(new Throwable());
                    return;
            }
        }
    }

    public void visitWelcomeFileList(WebAppContext context, Descriptor descriptor, XmlParser.Node node) {
        switch (context.getMetaData().getOrigin("welcome-file-list")) {
            case NotSet:
                context.getMetaData().setOrigin("welcome-file-list", descriptor);
                addWelcomeFiles(context, node);
                return;
            case WebXml:
                addWelcomeFiles(context, node);
                return;
            case WebDefaults:
                if (!(descriptor instanceof DefaultsDescriptor) && !(descriptor instanceof OverrideDescriptor) && !(descriptor instanceof FragmentDescriptor)) {
                    context.setWelcomeFiles(new String[0]);
                }
                addWelcomeFiles(context, node);
                return;
            case WebOverride:
                addWelcomeFiles(context, node);
                return;
            case WebFragment:
                addWelcomeFiles(context, node);
                return;
            default:
                LOG.warn(new Throwable());
                return;
        }
    }

    public void visitLocaleEncodingList(WebAppContext context, Descriptor descriptor, XmlParser.Node node) {
        Iterator<XmlParser.Node> iter = node.iterator("locale-encoding-mapping");
        while (iter.hasNext()) {
            XmlParser.Node mapping = iter.next();
            String locale = mapping.getString("locale", false, true);
            String encoding = mapping.getString("encoding", false, true);
            if (encoding != null) {
                switch (context.getMetaData().getOrigin(new StringBuilder().append("locale-encoding.").append(locale).toString())) {
                    case NotSet:
                        context.addLocaleEncoding(locale, encoding);
                        context.getMetaData().setOrigin("locale-encoding." + locale, descriptor);
                        continue;
                    case WebXml:
                    case WebDefaults:
                    case WebOverride:
                        if (!(descriptor instanceof FragmentDescriptor)) {
                            context.addLocaleEncoding(locale, encoding);
                            context.getMetaData().setOrigin("locale-encoding." + locale, descriptor);
                            break;
                        } else {
                            continue;
                        }
                    case WebFragment:
                        if (!encoding.equals(context.getLocaleEncoding(locale))) {
                            throw new IllegalStateException("Conflicting loacle-encoding mapping for locale " + locale + " in " + descriptor.getResource());
                        }
                        continue;
                    default:
                        LOG.warn(new Throwable());
                        continue;
                }
            }
        }
    }

    public void visitErrorPage(WebAppContext context, Descriptor descriptor, XmlParser.Node node) {
        String originName;
        String error = node.getString("error-code", false, true);
        int code = 0;
        if (error == null || error.length() == 0) {
            error = node.getString("exception-type", false, true);
            if (error == null || error.length() == 0) {
                error = ErrorPageErrorHandler.GLOBAL_ERROR_PAGE;
            }
        } else {
            code = Integer.parseInt(error);
        }
        String location = node.getString("location", false, true);
        if (!location.startsWith("/")) {
            throw new IllegalStateException("Missing leading '/' for location: " + location);
        }
        ErrorPageErrorHandler handler = (ErrorPageErrorHandler) context.getErrorHandler();
        switch (context.getMetaData().getOrigin(new StringBuilder().append("error.").append(error).toString())) {
            case NotSet:
                if (code > 0) {
                    handler.addErrorPage(code, location);
                } else {
                    handler.addErrorPage(error, location);
                }
                context.getMetaData().setOrigin("error." + error, descriptor);
                return;
            case WebXml:
            case WebDefaults:
            case WebOverride:
                if (descriptor instanceof FragmentDescriptor) {
                    return;
                }
                if (descriptor == context.getMetaData().getOriginDescriptor(originName)) {
                    throw new IllegalStateException("Duplicate error-page " + error + " at " + location);
                }
                if (code > 0) {
                    handler.addErrorPage(code, location);
                } else {
                    handler.addErrorPage(error, location);
                }
                context.getMetaData().setOrigin("error." + error, descriptor);
                return;
            case WebFragment:
                if (!handler.getErrorPages().get(error).equals(location)) {
                    throw new IllegalStateException("Conflicting error-code or exception-type " + error + " in " + descriptor.getResource());
                }
                return;
            default:
                LOG.warn(new Throwable());
                return;
        }
    }

    public void addWelcomeFiles(WebAppContext context, XmlParser.Node node) {
        Iterator<XmlParser.Node> iter = node.iterator("welcome-file");
        while (iter.hasNext()) {
            String welcome = iter.next().toString(false, true);
            if (welcome != null && welcome.trim().length() > 0) {
                context.setWelcomeFiles((String[]) ArrayUtil.addToArray(context.getWelcomeFiles(), welcome, String.class));
            }
        }
    }

    public ServletMapping addServletMapping(String servletName, XmlParser.Node node, WebAppContext context, Descriptor descriptor) {
        ServletMapping mapping = new ServletMapping(new Source(Source.Origin.DESCRIPTOR, descriptor.getResource().toString()));
        mapping.setServletName(servletName);
        mapping.setDefault(descriptor instanceof DefaultsDescriptor);
        List<String> paths = new ArrayList<>();
        Iterator<XmlParser.Node> iter = node.iterator("url-pattern");
        while (iter.hasNext()) {
            String p = ServletPathSpec.normalize(iter.next().toString(false, true));
            ListIterator<ServletMapping> listItor = this._servletMappings.listIterator();
            boolean found = false;
            while (listItor.hasNext() && !found) {
                ServletMapping sm = listItor.next();
                if (sm.getPathSpecs() != null) {
                    String[] pathSpecs = sm.getPathSpecs();
                    for (String ps : pathSpecs) {
                        if (p.equals(ps) && (sm.isDefault() || servletName.equals(sm.getServletName()))) {
                            if (!sm.isDefault()) {
                                LOG.warn("Duplicate mapping from {} to {}", p, servletName);
                            } else if (LOG.isDebugEnabled()) {
                                LOG.debug("{} in mapping {} from defaults descriptor is overridden by ", ps, sm, servletName);
                            }
                            String[] updatedPaths = (String[]) ArrayUtil.removeFromArray(sm.getPathSpecs(), ps);
                            if (updatedPaths == null || updatedPaths.length == 0) {
                                if (LOG.isDebugEnabled()) {
                                    LOG.debug("Removed empty mapping {}", sm);
                                }
                                listItor.remove();
                            } else {
                                sm.setPathSpecs(updatedPaths);
                                if (LOG.isDebugEnabled()) {
                                    LOG.debug("Removed path {} from mapping {}", p, sm);
                                }
                            }
                            found = true;
                        }
                    }
                }
            }
            paths.add(p);
            context.getMetaData().setOrigin(servletName + ".servlet.mapping." + p, descriptor);
        }
        mapping.setPathSpecs((String[]) paths.toArray(new String[paths.size()]));
        if (LOG.isDebugEnabled()) {
            LOG.debug("Added mapping {} ", mapping);
        }
        this._servletMappings.add(mapping);
        return mapping;
    }

    public void addFilterMapping(String filterName, XmlParser.Node node, WebAppContext context, Descriptor descriptor) {
        FilterMapping mapping = new FilterMapping();
        mapping.setFilterName(filterName);
        List<String> paths = new ArrayList<>();
        Iterator<XmlParser.Node> iter = node.iterator("url-pattern");
        while (iter.hasNext()) {
            String p = ServletPathSpec.normalize(iter.next().toString(false, true));
            paths.add(p);
            context.getMetaData().setOrigin(filterName + ".filter.mapping." + p, descriptor);
        }
        mapping.setPathSpecs((String[]) paths.toArray(new String[paths.size()]));
        List<String> names = new ArrayList<>();
        Iterator<XmlParser.Node> iter2 = node.iterator("servlet-name");
        while (iter2.hasNext()) {
            names.add(iter2.next().toString(false, true));
        }
        mapping.setServletNames((String[]) names.toArray(new String[names.size()]));
        List<DispatcherType> dispatches = new ArrayList<>();
        Iterator<XmlParser.Node> iter3 = node.iterator("dispatcher");
        while (iter3.hasNext()) {
            dispatches.add(FilterMapping.dispatch(iter3.next().toString(false, true)));
        }
        if (dispatches.size() > 0) {
            mapping.setDispatcherTypes(EnumSet.copyOf(dispatches));
        }
        this._filterMappings.add(mapping);
    }

    public void visitTagLib(WebAppContext context, Descriptor descriptor, XmlParser.Node node) {
        String uri = node.getString("taglib-uri", false, true);
        String location = node.getString("taglib-location", false, true);
        context.setResourceAlias(uri, location);
        ServletContextHandler.JspConfig config = (ServletContextHandler.JspConfig) context.getServletContext().getJspConfigDescriptor();
        if (config == null) {
            config = new ServletContextHandler.JspConfig();
            context.getServletContext().setJspConfigDescriptor(config);
        }
        ServletContextHandler.TagLib tl = new ServletContextHandler.TagLib();
        tl.setTaglibLocation(location);
        tl.setTaglibURI(uri);
        config.addTaglibDescriptor(tl);
    }

    public void visitJspConfig(WebAppContext context, Descriptor descriptor, XmlParser.Node node) {
        ServletContextHandler.JspConfig config = (ServletContextHandler.JspConfig) context.getServletContext().getJspConfigDescriptor();
        if (config == null) {
            config = new ServletContextHandler.JspConfig();
            context.getServletContext().setJspConfigDescriptor(config);
        }
        for (int i = 0; i < node.size(); i++) {
            Object o = node.get(i);
            if ((o instanceof XmlParser.Node) && "taglib".equals(((XmlParser.Node) o).getTag())) {
                visitTagLib(context, descriptor, (XmlParser.Node) o);
            }
        }
        Iterator<XmlParser.Node> iter = node.iterator("jsp-property-group");
        List<String> paths = new ArrayList<>();
        while (iter.hasNext()) {
            ServletContextHandler.JspPropertyGroup jpg = new ServletContextHandler.JspPropertyGroup();
            config.addJspPropertyGroup(jpg);
            XmlParser.Node group = iter.next();
            Iterator<XmlParser.Node> iter2 = group.iterator("url-pattern");
            while (iter2.hasNext()) {
                String url = ServletPathSpec.normalize(iter2.next().toString(false, true));
                paths.add(url);
                jpg.addUrlPattern(url);
            }
            jpg.setElIgnored(group.getString("el-ignored", false, true));
            jpg.setPageEncoding(group.getString("page-encoding", false, true));
            jpg.setScriptingInvalid(group.getString("scripting-invalid", false, true));
            jpg.setIsXml(group.getString("is-xml", false, true));
            jpg.setDeferredSyntaxAllowedAsLiteral(group.getString("deferred-syntax-allowed-as-literal", false, true));
            jpg.setTrimDirectiveWhitespaces(group.getString("trim-directive-whitespaces", false, true));
            jpg.setDefaultContentType(group.getString("default-content-type", false, true));
            jpg.setBuffer(group.getString("buffer", false, true));
            jpg.setErrorOnUndeclaredNamespace(group.getString("error-on-undeclared-namespace", false, true));
            Iterator<XmlParser.Node> preludes = group.iterator("include-prelude");
            while (preludes.hasNext()) {
                jpg.addIncludePrelude(preludes.next().toString(false, true));
            }
            Iterator<XmlParser.Node> codas = group.iterator("include-coda");
            while (codas.hasNext()) {
                jpg.addIncludeCoda(codas.next().toString(false, true));
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug(config.toString(), new Object[0]);
            }
        }
        if (paths.size() > 0) {
            ServletMapping jspMapping = null;
            Iterator<ServletMapping> it = this._servletMappings.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ServletMapping m = it.next();
                if (m.getServletName().equals("jsp")) {
                    jspMapping = m;
                    break;
                }
            }
            if (jspMapping == null) {
                ServletMapping mapping = new ServletMapping(new Source(Source.Origin.DESCRIPTOR, descriptor.getResource().toString()));
                mapping.setServletName("jsp");
                mapping.setPathSpecs((String[]) paths.toArray(new String[paths.size()]));
                this._servletMappings.add(mapping);
            } else if (jspMapping.getPathSpecs() == null) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Adding all paths from jsp-config to jsp servlet mapping", new Object[0]);
                }
                jspMapping.setPathSpecs((String[]) paths.toArray(new String[paths.size()]));
            } else {
                ListIterator<String> piterator = paths.listIterator();
                while (piterator.hasNext()) {
                    if (jspMapping.containsPathSpec(piterator.next())) {
                        piterator.remove();
                    }
                }
                if (paths.size() > 0) {
                    for (String p : jspMapping.getPathSpecs()) {
                        paths.add(p);
                    }
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Adding extra paths from jsp-config to jsp servlet mapping", new Object[0]);
                    }
                    jspMapping.setPathSpecs((String[]) paths.toArray(new String[paths.size()]));
                }
            }
        }
    }

    public void visitSecurityConstraint(WebAppContext context, Descriptor descriptor, XmlParser.Node node) {
        if (context.getSecurityHandler() == null) {
            LOG.warn("security-constraint declared but SecurityHandler==null", new Object[0]);
            return;
        }
        Constraint scBase = new Constraint();
        try {
            XmlParser.Node auths = node.get("auth-constraint");
            if (auths != null) {
                scBase.setAuthenticate(true);
                Iterator<XmlParser.Node> iter = auths.iterator("role-name");
                List<String> roles = new ArrayList<>();
                while (iter.hasNext()) {
                    roles.add(iter.next().toString(false, true));
                }
                scBase.setRoles((String[]) roles.toArray(new String[roles.size()]));
            }
            XmlParser.Node data = node.get("user-data-constraint");
            if (data != null) {
                String guarantee = data.get("transport-guarantee").toString(false, true).toUpperCase(Locale.ENGLISH);
                if (guarantee == null || guarantee.length() == 0 || Constraint.NONE.equals(guarantee)) {
                    scBase.setDataConstraint(0);
                } else if ("INTEGRAL".equals(guarantee)) {
                    scBase.setDataConstraint(1);
                } else if ("CONFIDENTIAL".equals(guarantee)) {
                    scBase.setDataConstraint(2);
                } else {
                    LOG.warn("Unknown user-data-constraint:" + guarantee, new Object[0]);
                    scBase.setDataConstraint(2);
                }
            }
            Iterator<XmlParser.Node> iter2 = node.iterator("web-resource-collection");
            while (iter2.hasNext()) {
                XmlParser.Node collection = iter2.next();
                String name = collection.getString("web-resource-name", false, true);
                Constraint sc = (Constraint) scBase.clone();
                sc.setName(name);
                Iterator<XmlParser.Node> iter22 = collection.iterator("url-pattern");
                while (iter22.hasNext()) {
                    String url = ServletPathSpec.normalize(iter22.next().toString(false, true));
                    context.getMetaData().setOrigin("constraint.url." + url, descriptor);
                    Iterator<XmlParser.Node> methods = collection.iterator("http-method");
                    Iterator<XmlParser.Node> ommissions = collection.iterator("http-method-omission");
                    if (methods.hasNext()) {
                        if (ommissions.hasNext()) {
                            throw new IllegalStateException("web-resource-collection cannot contain both http-method and http-method-omission");
                        }
                        while (methods.hasNext()) {
                            String method = methods.next().toString(false, true);
                            ConstraintMapping mapping = new ConstraintMapping();
                            mapping.setMethod(method);
                            mapping.setPathSpec(url);
                            mapping.setConstraint(sc);
                            ((ConstraintAware) context.getSecurityHandler()).addConstraintMapping(mapping);
                        }
                    } else if (ommissions.hasNext()) {
                        while (ommissions.hasNext()) {
                            String method2 = ommissions.next().toString(false, true);
                            ConstraintMapping mapping2 = new ConstraintMapping();
                            mapping2.setMethodOmissions(new String[]{method2});
                            mapping2.setPathSpec(url);
                            mapping2.setConstraint(sc);
                            ((ConstraintAware) context.getSecurityHandler()).addConstraintMapping(mapping2);
                        }
                    } else {
                        ConstraintMapping mapping3 = new ConstraintMapping();
                        mapping3.setPathSpec(url);
                        mapping3.setConstraint(sc);
                        ((ConstraintAware) context.getSecurityHandler()).addConstraintMapping(mapping3);
                    }
                }
            }
        } catch (CloneNotSupportedException e) {
            LOG.warn(e);
        }
    }

    public void visitLoginConfig(WebAppContext context, Descriptor descriptor, XmlParser.Node node) throws Exception {
        XmlParser.Node method = node.get("auth-method");
        if (method != null) {
            switch (context.getMetaData().getOrigin("auth-method")) {
                case NotSet:
                    context.getSecurityHandler().setAuthMethod(method.toString(false, true));
                    context.getMetaData().setOrigin("auth-method", descriptor);
                    break;
                case WebXml:
                case WebDefaults:
                case WebOverride:
                    if (!(descriptor instanceof FragmentDescriptor)) {
                        context.getSecurityHandler().setAuthMethod(method.toString(false, true));
                        context.getMetaData().setOrigin("auth-method", descriptor);
                        break;
                    }
                    break;
                case WebFragment:
                    if (!context.getSecurityHandler().getAuthMethod().equals(method.toString(false, true))) {
                        throw new IllegalStateException("Conflicting auth-method value in " + descriptor.getResource());
                    }
                    break;
                default:
                    LOG.warn(new Throwable());
                    break;
            }
            XmlParser.Node name = node.get("realm-name");
            String nameStr = name == null ? "default" : name.toString(false, true);
            switch (context.getMetaData().getOrigin("realm-name")) {
                case NotSet:
                    context.getSecurityHandler().setRealmName(nameStr);
                    context.getMetaData().setOrigin("realm-name", descriptor);
                    break;
                case WebXml:
                case WebDefaults:
                case WebOverride:
                    if (!(descriptor instanceof FragmentDescriptor)) {
                        context.getSecurityHandler().setRealmName(nameStr);
                        context.getMetaData().setOrigin("realm-name", descriptor);
                        break;
                    }
                    break;
                case WebFragment:
                    if (!context.getSecurityHandler().getRealmName().equals(nameStr)) {
                        throw new IllegalStateException("Conflicting realm-name value in " + descriptor.getResource());
                    }
                    break;
                default:
                    LOG.warn(new Throwable());
                    break;
            }
            if ("FORM".equalsIgnoreCase(context.getSecurityHandler().getAuthMethod())) {
                XmlParser.Node formConfig = node.get("form-login-config");
                if (formConfig != null) {
                    String loginPageName = null;
                    XmlParser.Node loginPage = formConfig.get("form-login-page");
                    if (loginPage != null) {
                        loginPageName = loginPage.toString(false, true);
                    }
                    String errorPageName = null;
                    XmlParser.Node errorPage = formConfig.get("form-error-page");
                    if (errorPage != null) {
                        errorPageName = errorPage.toString(false, true);
                    }
                    switch (context.getMetaData().getOrigin("form-login-page")) {
                        case NotSet:
                            context.getSecurityHandler().setInitParameter(FormAuthenticator.__FORM_LOGIN_PAGE, loginPageName);
                            context.getMetaData().setOrigin("form-login-page", descriptor);
                            break;
                        case WebXml:
                        case WebDefaults:
                        case WebOverride:
                            if (!(descriptor instanceof FragmentDescriptor)) {
                                context.getSecurityHandler().setInitParameter(FormAuthenticator.__FORM_LOGIN_PAGE, loginPageName);
                                context.getMetaData().setOrigin("form-login-page", descriptor);
                                break;
                            }
                            break;
                        case WebFragment:
                            if (!context.getSecurityHandler().getInitParameter(FormAuthenticator.__FORM_LOGIN_PAGE).equals(loginPageName)) {
                                throw new IllegalStateException("Conflicting form-login-page value in " + descriptor.getResource());
                            }
                            break;
                        default:
                            LOG.warn(new Throwable());
                            break;
                    }
                    switch (context.getMetaData().getOrigin("form-error-page")) {
                        case NotSet:
                            context.getSecurityHandler().setInitParameter(FormAuthenticator.__FORM_ERROR_PAGE, errorPageName);
                            context.getMetaData().setOrigin("form-error-page", descriptor);
                            return;
                        case WebXml:
                        case WebDefaults:
                        case WebOverride:
                            if (!(descriptor instanceof FragmentDescriptor)) {
                                context.getSecurityHandler().setInitParameter(FormAuthenticator.__FORM_ERROR_PAGE, errorPageName);
                                context.getMetaData().setOrigin("form-error-page", descriptor);
                                return;
                            }
                            return;
                        case WebFragment:
                            if (!context.getSecurityHandler().getInitParameter(FormAuthenticator.__FORM_ERROR_PAGE).equals(errorPageName)) {
                                throw new IllegalStateException("Conflicting form-error-page value in " + descriptor.getResource());
                            }
                            return;
                        default:
                            LOG.warn(new Throwable());
                            return;
                    }
                } else {
                    throw new IllegalStateException("!form-login-config");
                }
            }
        }
    }

    public void visitSecurityRole(WebAppContext context, Descriptor descriptor, XmlParser.Node node) {
        if (context.getSecurityHandler() == null) {
            LOG.warn("security-role declared but SecurityHandler==null", new Object[0]);
            return;
        }
        ((ConstraintAware) context.getSecurityHandler()).addRole(node.get("role-name").toString(false, true));
    }

    public void visitFilter(WebAppContext context, Descriptor descriptor, XmlParser.Node node) {
        String name = node.getString("filter-name", false, true);
        FilterHolder holder = this._filterHolderMap.get(name);
        if (holder == null) {
            holder = context.getServletHandler().newFilterHolder(new Source(Source.Origin.DESCRIPTOR, descriptor.getResource().toString()));
            holder.setName(name);
            this._filterHolderMap.put(name, holder);
            this._filterHolders.add(holder);
        }
        String filterClass = node.getString("filter-class", false, true);
        if (filterClass != null) {
            ((WebDescriptor) descriptor).addClassName(filterClass);
            switch (context.getMetaData().getOrigin(new StringBuilder().append(name).append(".filter.filter-class").toString())) {
                case NotSet:
                    holder.setClassName(filterClass);
                    context.getMetaData().setOrigin(name + ".filter.filter-class", descriptor);
                    break;
                case WebXml:
                case WebDefaults:
                case WebOverride:
                    if (!(descriptor instanceof FragmentDescriptor)) {
                        holder.setClassName(filterClass);
                        context.getMetaData().setOrigin(name + ".filter.filter-class", descriptor);
                        break;
                    }
                    break;
                case WebFragment:
                    if (!holder.getClassName().equals(filterClass)) {
                        throw new IllegalStateException("Conflicting filter-class for filter " + name + " in " + descriptor.getResource());
                    }
                    break;
                default:
                    LOG.warn(new Throwable());
                    break;
            }
        }
        Iterator<XmlParser.Node> iter = node.iterator("init-param");
        while (iter.hasNext()) {
            XmlParser.Node paramNode = iter.next();
            String pname = paramNode.getString("param-name", false, true);
            String pvalue = paramNode.getString("param-value", false, true);
            switch (context.getMetaData().getOrigin(new StringBuilder().append(name).append(".filter.init-param.").append(pname).toString())) {
                case NotSet:
                    holder.setInitParameter(pname, pvalue);
                    context.getMetaData().setOrigin(name + ".filter.init-param." + pname, descriptor);
                    break;
                case WebXml:
                case WebDefaults:
                case WebOverride:
                    if (descriptor instanceof FragmentDescriptor) {
                        break;
                    } else {
                        holder.setInitParameter(pname, pvalue);
                        context.getMetaData().setOrigin(name + ".filter.init-param." + pname, descriptor);
                        break;
                    }
                case WebFragment:
                    if (holder.getInitParameter(pname).equals(pvalue)) {
                        break;
                    } else {
                        throw new IllegalStateException("Mismatching init-param " + pname + "=" + pvalue + " in " + descriptor.getResource());
                    }
                default:
                    LOG.warn(new Throwable());
                    break;
            }
        }
        String async = node.getString("async-supported", false, true);
        if (async != null) {
            holder.setAsyncSupported(async.length() == 0 || Boolean.parseBoolean(async));
        }
        if (async != null) {
            boolean val = async.length() == 0 || Boolean.parseBoolean(async);
            switch (context.getMetaData().getOrigin(new StringBuilder().append(name).append(".filter.async-supported").toString())) {
                case NotSet:
                    holder.setAsyncSupported(val);
                    context.getMetaData().setOrigin(name + ".filter.async-supported", descriptor);
                    return;
                case WebXml:
                case WebDefaults:
                case WebOverride:
                    if (!(descriptor instanceof FragmentDescriptor)) {
                        holder.setAsyncSupported(val);
                        context.getMetaData().setOrigin(name + ".filter.async-supported", descriptor);
                        return;
                    }
                    return;
                case WebFragment:
                    if (holder.isAsyncSupported() != val) {
                        throw new IllegalStateException("Conflicting async-supported=" + async + " for filter " + name + " in " + descriptor.getResource());
                    }
                    return;
                default:
                    LOG.warn(new Throwable());
                    return;
            }
        }
    }

    public void visitFilterMapping(WebAppContext context, Descriptor descriptor, XmlParser.Node node) {
        String filterName = node.getString("filter-name", false, true);
        switch (context.getMetaData().getOrigin(new StringBuilder().append(filterName).append(".filter.mappings").toString())) {
            case NotSet:
                context.getMetaData().setOrigin(filterName + ".filter.mappings", descriptor);
                addFilterMapping(filterName, node, context, descriptor);
                return;
            case WebXml:
            case WebDefaults:
            case WebOverride:
                if (!(descriptor instanceof FragmentDescriptor)) {
                    addFilterMapping(filterName, node, context, descriptor);
                    return;
                }
                return;
            case WebFragment:
                addFilterMapping(filterName, node, context, descriptor);
                return;
            default:
                LOG.warn(new Throwable());
                return;
        }
    }

    public void visitListener(WebAppContext context, Descriptor descriptor, XmlParser.Node node) {
        String className = node.getString("listener-class", false, true);
        if (className != null) {
            try {
                if (className.length() > 0) {
                    for (ListenerHolder holder : context.getServletHandler().getListeners()) {
                        if (holder.getClassName().equals(className)) {
                            return;
                        }
                    }
                    ((WebDescriptor) descriptor).addClassName(className);
                    ListenerHolder h = context.getServletHandler().newListenerHolder(new Source(Source.Origin.DESCRIPTOR, descriptor.getResource().toString()));
                    h.setClassName(className);
                    context.getServletHandler().addListener(h);
                    context.getMetaData().setOrigin(className + ".listener", descriptor);
                }
            } catch (Exception e) {
                LOG.warn("Could not instantiate listener " + className, e);
            }
        }
    }

    public void visitDistributable(WebAppContext context, Descriptor descriptor, XmlParser.Node node) {
        ((WebDescriptor) descriptor).setDistributable(true);
    }

    public void visitDenyUncoveredHttpMethods(WebAppContext context, Descriptor descriptor, XmlParser.Node node) {
        if (context.getSecurityHandler() == null) {
            LOG.warn("deny-uncovered-http-methods declared but SecurityHandler==null", new Object[0]);
        } else {
            ((ConstraintAware) context.getSecurityHandler()).setDenyUncoveredHttpMethods(true);
        }
    }
}
