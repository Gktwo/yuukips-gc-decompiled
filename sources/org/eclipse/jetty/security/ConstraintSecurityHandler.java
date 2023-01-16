package org.eclipse.jetty.security;

import dev.morphia.mapping.Mapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.servlet.HttpConstraintElement;
import javax.servlet.HttpMethodConstraintElement;
import javax.servlet.ServletSecurityElement;
import javax.servlet.annotation.ServletSecurity;
import org.eclipse.jetty.http.PathMap;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.component.DumpableCollection;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.security.Constraint;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/ConstraintSecurityHandler.class */
public class ConstraintSecurityHandler extends SecurityHandler implements ConstraintAware {
    private static final Logger LOG = Log.getLogger(SecurityHandler.class);
    private static final String OMISSION_SUFFIX = ".omission";
    private static final String ALL_METHODS = "*";
    private final List<ConstraintMapping> _constraintMappings = new CopyOnWriteArrayList();
    private final List<ConstraintMapping> _durableConstraintMappings = new CopyOnWriteArrayList();
    private final Set<String> _roles = new CopyOnWriteArraySet();
    private final PathMap<Map<String, RoleInfo>> _constraintMap = new PathMap<>();
    private boolean _denyUncoveredMethods = false;

    public static Constraint createConstraint() {
        return new Constraint();
    }

    public static Constraint createConstraint(Constraint constraint) {
        try {
            return (Constraint) constraint.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
    }

    public static Constraint createConstraint(String name, boolean authenticate, String[] roles, int dataConstraint) {
        Constraint constraint = createConstraint();
        if (name != null) {
            constraint.setName(name);
        }
        constraint.setAuthenticate(authenticate);
        constraint.setRoles(roles);
        constraint.setDataConstraint(dataConstraint);
        return constraint;
    }

    public static Constraint createConstraint(String name, HttpConstraintElement element) {
        return createConstraint(name, element.getRolesAllowed(), element.getEmptyRoleSemantic(), element.getTransportGuarantee());
    }

    public static Constraint createConstraint(String name, String[] rolesAllowed, ServletSecurity.EmptyRoleSemantic permitOrDeny, ServletSecurity.TransportGuarantee transport) {
        Constraint constraint = createConstraint();
        if (rolesAllowed != null && rolesAllowed.length != 0) {
            constraint.setAuthenticate(true);
            constraint.setRoles(rolesAllowed);
            constraint.setName(name + "-RolesAllowed");
        } else if (permitOrDeny.equals(ServletSecurity.EmptyRoleSemantic.DENY)) {
            constraint.setName(name + "-Deny");
            constraint.setAuthenticate(true);
        } else {
            constraint.setName(name + "-Permit");
            constraint.setAuthenticate(false);
        }
        constraint.setDataConstraint(transport.equals(ServletSecurity.TransportGuarantee.CONFIDENTIAL) ? 2 : 0);
        return constraint;
    }

    public static List<ConstraintMapping> getConstraintMappingsForPath(String pathSpec, List<ConstraintMapping> constraintMappings) {
        if (pathSpec == null || "".equals(pathSpec.trim()) || constraintMappings == null || constraintMappings.size() == 0) {
            return Collections.emptyList();
        }
        List<ConstraintMapping> mappings = new ArrayList<>();
        for (ConstraintMapping mapping : constraintMappings) {
            if (pathSpec.equals(mapping.getPathSpec())) {
                mappings.add(mapping);
            }
        }
        return mappings;
    }

    public static List<ConstraintMapping> removeConstraintMappingsForPath(String pathSpec, List<ConstraintMapping> constraintMappings) {
        if (pathSpec == null || "".equals(pathSpec.trim()) || constraintMappings == null || constraintMappings.size() == 0) {
            return Collections.emptyList();
        }
        List<ConstraintMapping> mappings = new ArrayList<>();
        for (ConstraintMapping mapping : constraintMappings) {
            if (!pathSpec.equals(mapping.getPathSpec())) {
                mappings.add(mapping);
            }
        }
        return mappings;
    }

    public static List<ConstraintMapping> createConstraintsWithMappingsForPath(String name, String pathSpec, ServletSecurityElement securityElement) {
        List<ConstraintMapping> mappings = new ArrayList<>();
        ConstraintMapping httpConstraintMapping = null;
        if (!(securityElement.getEmptyRoleSemantic() == ServletSecurity.EmptyRoleSemantic.PERMIT && securityElement.getRolesAllowed().length == 0 && securityElement.getTransportGuarantee() == ServletSecurity.TransportGuarantee.NONE)) {
            Constraint httpConstraint = createConstraint(name, securityElement);
            httpConstraintMapping = new ConstraintMapping();
            httpConstraintMapping.setPathSpec(pathSpec);
            httpConstraintMapping.setConstraint(httpConstraint);
            mappings.add(httpConstraintMapping);
        }
        List<String> methodOmissions = new ArrayList<>();
        Collection<HttpMethodConstraintElement> methodConstraintElements = securityElement.getHttpMethodConstraints();
        if (methodConstraintElements != null) {
            for (HttpMethodConstraintElement methodConstraintElement : methodConstraintElements) {
                Constraint methodConstraint = createConstraint(name, methodConstraintElement);
                ConstraintMapping mapping = new ConstraintMapping();
                mapping.setConstraint(methodConstraint);
                mapping.setPathSpec(pathSpec);
                if (methodConstraintElement.getMethodName() != null) {
                    mapping.setMethod(methodConstraintElement.getMethodName());
                    methodOmissions.add(methodConstraintElement.getMethodName());
                }
                mappings.add(mapping);
            }
        }
        if (methodOmissions.size() > 0 && httpConstraintMapping != null) {
            httpConstraintMapping.setMethodOmissions((String[]) methodOmissions.toArray(new String[0]));
        }
        return mappings;
    }

    @Override // org.eclipse.jetty.security.ConstraintAware
    public List<ConstraintMapping> getConstraintMappings() {
        return this._constraintMappings;
    }

    @Override // org.eclipse.jetty.security.ConstraintAware
    public Set<String> getRoles() {
        return this._roles;
    }

    public void setConstraintMappings(List<ConstraintMapping> constraintMappings) {
        setConstraintMappings(constraintMappings, null);
    }

    public void setConstraintMappings(ConstraintMapping[] constraintMappings) {
        setConstraintMappings(Arrays.asList(constraintMappings), null);
    }

    @Override // org.eclipse.jetty.security.ConstraintAware
    public void setConstraintMappings(List<ConstraintMapping> constraintMappings, Set<String> roles) {
        this._constraintMappings.clear();
        this._constraintMappings.addAll(constraintMappings);
        this._durableConstraintMappings.clear();
        if (isInDurableState()) {
            this._durableConstraintMappings.addAll(constraintMappings);
        }
        if (roles == null) {
            roles = new HashSet();
            for (ConstraintMapping cm : constraintMappings) {
                String[] cmr = cm.getConstraint().getRoles();
                if (cmr != null) {
                    for (String r : cmr) {
                        if (!"*".equals(r)) {
                            roles.add(r);
                        }
                    }
                }
            }
        }
        setRoles(roles);
        if (isStarted()) {
            this._constraintMappings.stream().forEach(m -> {
                processConstraintMapping(m);
            });
        }
    }

    public void setRoles(Set<String> roles) {
        this._roles.clear();
        this._roles.addAll(roles);
    }

    @Override // org.eclipse.jetty.security.ConstraintAware
    public void addConstraintMapping(ConstraintMapping mapping) {
        this._constraintMappings.add(mapping);
        if (isInDurableState()) {
            this._durableConstraintMappings.add(mapping);
        }
        if (!(mapping.getConstraint() == null || mapping.getConstraint().getRoles() == null)) {
            String[] roles = mapping.getConstraint().getRoles();
            for (String role : roles) {
                if (!"*".equals(role) && !Constraint.ANY_AUTH.equals(role)) {
                    addRole(role);
                }
            }
        }
        if (isStarted()) {
            processConstraintMapping(mapping);
        }
    }

    @Override // org.eclipse.jetty.security.ConstraintAware
    public void addRole(String role) {
        boolean modified = this._roles.add(role);
        if (isStarted() && modified) {
            for (Map<String, RoleInfo> map : this._constraintMap.values()) {
                for (RoleInfo info : map.values()) {
                    if (info.isAnyRole()) {
                        info.addRole(role);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.security.SecurityHandler, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        this._constraintMappings.stream().forEach(m -> {
            processConstraintMapping(m);
        });
        checkPathsWithUncoveredHttpMethods();
        doStart();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.security.SecurityHandler, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        doStop();
        this._constraintMap.clear();
        this._constraintMappings.clear();
        this._constraintMappings.addAll(this._durableConstraintMappings);
    }

    protected void processConstraintMapping(ConstraintMapping mapping) {
        Map<String, RoleInfo> mappings = this._constraintMap.get(mapping.getPathSpec());
        if (mappings == null) {
            mappings = new HashMap();
            this._constraintMap.put(mapping.getPathSpec(), (String) mappings);
        }
        RoleInfo allMethodsRoleInfo = mappings.get("*");
        if (allMethodsRoleInfo != null && allMethodsRoleInfo.isForbidden()) {
            return;
        }
        if (mapping.getMethodOmissions() == null || mapping.getMethodOmissions().length <= 0) {
            String httpMethod = mapping.getMethod();
            if (httpMethod == null) {
                httpMethod = "*";
            }
            RoleInfo roleInfo = mappings.get(httpMethod);
            if (roleInfo == null) {
                roleInfo = new RoleInfo();
                mappings.put(httpMethod, roleInfo);
                if (allMethodsRoleInfo != null) {
                    roleInfo.combine(allMethodsRoleInfo);
                }
            }
            if (!roleInfo.isForbidden()) {
                configureRoleInfo(roleInfo, mapping);
                if (roleInfo.isForbidden() && httpMethod.equals("*")) {
                    mappings.clear();
                    mappings.put("*", roleInfo);
                    return;
                }
                return;
            }
            return;
        }
        processConstraintMappingWithMethodOmissions(mapping, mappings);
    }

    protected void processConstraintMappingWithMethodOmissions(ConstraintMapping mapping, Map<String, RoleInfo> mappings) {
        String[] omissions = mapping.getMethodOmissions();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < omissions.length; i++) {
            if (i > 0) {
                sb.append(Mapper.IGNORED_FIELDNAME);
            }
            sb.append(omissions[i]);
        }
        sb.append(OMISSION_SUFFIX);
        RoleInfo ri = new RoleInfo();
        mappings.put(sb.toString(), ri);
        configureRoleInfo(ri, mapping);
    }

    protected void configureRoleInfo(RoleInfo ri, ConstraintMapping mapping) {
        ri.setForbidden(mapping.getConstraint().isForbidden());
        ri.setUserDataConstraint(UserDataConstraint.get(mapping.getConstraint().getDataConstraint()));
        if (!ri.isForbidden()) {
            ri.setChecked(mapping.getConstraint().getAuthenticate());
            if (!ri.isChecked()) {
                return;
            }
            if (mapping.getConstraint().isAnyRole()) {
                for (String role : this._roles) {
                    ri.addRole(role);
                }
                ri.setAnyRole(true);
            } else if (mapping.getConstraint().isAnyAuth()) {
                ri.setAnyAuth(true);
            } else {
                String[] newRoles = mapping.getConstraint().getRoles();
                for (String role2 : newRoles) {
                    if (!this._roles.contains(role2)) {
                        throw new IllegalArgumentException("Attempt to use undeclared role: " + role2 + ", known roles: " + this._roles);
                    }
                    ri.addRole(role2);
                }
            }
        }
    }

    @Override // org.eclipse.jetty.security.SecurityHandler
    protected RoleInfo prepareConstraintInfo(String pathInContext, Request request) {
        Map<String, RoleInfo> mappings = this._constraintMap.match(pathInContext);
        if (mappings == null) {
            return null;
        }
        String httpMethod = request.getMethod();
        RoleInfo roleInfo = mappings.get(httpMethod);
        if (roleInfo == null) {
            List<RoleInfo> applicableConstraints = new ArrayList<>();
            RoleInfo all = mappings.get("*");
            if (all != null) {
                applicableConstraints.add(all);
            }
            for (Map.Entry<String, RoleInfo> entry : mappings.entrySet()) {
                if (entry.getKey() != null && entry.getKey().endsWith(OMISSION_SUFFIX) && !entry.getKey().contains(httpMethod)) {
                    applicableConstraints.add(entry.getValue());
                }
            }
            if (applicableConstraints.size() == 0 && isDenyUncoveredHttpMethods()) {
                roleInfo = new RoleInfo();
                roleInfo.setForbidden(true);
            } else if (applicableConstraints.size() == 1) {
                roleInfo = applicableConstraints.get(0);
            } else {
                roleInfo = new RoleInfo();
                roleInfo.setUserDataConstraint(UserDataConstraint.None);
                for (RoleInfo r : applicableConstraints) {
                    roleInfo.combine(r);
                }
            }
        }
        return roleInfo;
    }

    @Override // org.eclipse.jetty.security.SecurityHandler
    protected boolean checkUserDataPermissions(String pathInContext, Request request, Response response, RoleInfo roleInfo) throws IOException {
        if (roleInfo == null) {
            return true;
        }
        if (roleInfo.isForbidden()) {
            return false;
        }
        UserDataConstraint dataConstraint = roleInfo.getUserDataConstraint();
        if (dataConstraint == null || dataConstraint == UserDataConstraint.None) {
            return true;
        }
        HttpConfiguration httpConfig = Request.getBaseRequest(request).getHttpChannel().getHttpConfiguration();
        if (dataConstraint != UserDataConstraint.Confidential && dataConstraint != UserDataConstraint.Integral) {
            throw new IllegalArgumentException("Invalid dataConstraint value: " + dataConstraint);
        } else if (request.isSecure()) {
            return true;
        } else {
            if (httpConfig.getSecurePort() > 0) {
                String url = URIUtil.newURI(httpConfig.getSecureScheme(), request.getServerName(), httpConfig.getSecurePort(), request.getRequestURI(), request.getQueryString());
                response.setContentLength(0);
                response.sendRedirect(url, true);
            } else {
                response.sendError(403, "!Secure");
            }
            request.setHandled(true);
            return false;
        }
    }

    @Override // org.eclipse.jetty.security.SecurityHandler
    protected boolean isAuthMandatory(Request baseRequest, Response baseResponse, Object constraintInfo) {
        return constraintInfo != null && ((RoleInfo) constraintInfo).isChecked();
    }

    @Override // org.eclipse.jetty.security.SecurityHandler
    protected boolean checkWebResourcePermissions(String pathInContext, Request request, Response response, Object constraintInfo, UserIdentity userIdentity) throws IOException {
        if (constraintInfo == null) {
            return true;
        }
        RoleInfo roleInfo = (RoleInfo) constraintInfo;
        if (!roleInfo.isChecked()) {
            return true;
        }
        if (roleInfo.isAnyAuth() && request.getUserPrincipal() != null) {
            return true;
        }
        boolean isUserInRole = false;
        Iterator<String> it = roleInfo.getRoles().iterator();
        while (true) {
            if (it.hasNext()) {
                if (userIdentity.isUserInRole(it.next(), null)) {
                    isUserInRole = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!roleInfo.isAnyRole() || request.getUserPrincipal() == null || !isUserInRole) {
            return isUserInRole;
        }
        return true;
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        dumpObjects(out, indent, DumpableCollection.from("roles", this._roles), DumpableCollection.from("constraints", this._constraintMap.entrySet()));
    }

    @Override // org.eclipse.jetty.security.ConstraintAware
    public void setDenyUncoveredHttpMethods(boolean deny) {
        this._denyUncoveredMethods = deny;
    }

    @Override // org.eclipse.jetty.security.ConstraintAware
    public boolean isDenyUncoveredHttpMethods() {
        return this._denyUncoveredMethods;
    }

    @Override // org.eclipse.jetty.security.ConstraintAware
    public boolean checkPathsWithUncoveredHttpMethods() {
        Set<String> paths = getPathsWithUncoveredHttpMethods();
        if (paths == null || paths.isEmpty()) {
            return false;
        }
        for (String p : paths) {
            LOG.warn("{} has uncovered http methods for path: {}", ContextHandler.getCurrentContext(), p);
        }
        if (!LOG.isDebugEnabled()) {
            return true;
        }
        LOG.debug(new Throwable());
        return true;
    }

    public Set<String> getPathsWithUncoveredHttpMethods() {
        if (this._denyUncoveredMethods) {
            return Collections.emptySet();
        }
        Set<String> uncoveredPaths = new HashSet<>();
        for (Map.Entry<String, Map<String, RoleInfo>> entry : this._constraintMap.entrySet()) {
            Map<String, RoleInfo> methodMappings = entry.getValue();
            if (methodMappings.get("*") == null) {
                boolean hasOmissions = omissionsExist(entry.getKey(), methodMappings);
                for (String method : methodMappings.keySet()) {
                    if (method.endsWith(OMISSION_SUFFIX)) {
                        for (String m : getOmittedMethods(method)) {
                            if (!methodMappings.containsKey(m)) {
                                uncoveredPaths.add(entry.getKey());
                            }
                        }
                    } else if (!hasOmissions) {
                        uncoveredPaths.add(entry.getKey());
                    }
                }
            }
        }
        return uncoveredPaths;
    }

    protected boolean omissionsExist(String path, Map<String, RoleInfo> methodMappings) {
        if (methodMappings == null) {
            return false;
        }
        boolean hasOmissions = false;
        for (String m : methodMappings.keySet()) {
            if (m.endsWith(OMISSION_SUFFIX)) {
                hasOmissions = true;
            }
        }
        return hasOmissions;
    }

    protected Set<String> getOmittedMethods(String omission) {
        if (omission == null || !omission.endsWith(OMISSION_SUFFIX)) {
            return Collections.emptySet();
        }
        String[] strings = omission.split("\\.");
        Set<String> methods = new HashSet<>();
        for (int i = 0; i < strings.length - 1; i++) {
            methods.add(strings[i]);
        }
        return methods;
    }

    private boolean isInDurableState() {
        ContextHandler context = ContextHandler.getContextHandler(null);
        Server server = getServer();
        return (context == null && server == null) || (context != null && !context.isRunning()) || (context == null && server != null && !server.isRunning());
    }
}
