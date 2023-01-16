package org.eclipse.jetty.security;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/RoleRunAsToken.class */
public class RoleRunAsToken implements RunAsToken {
    private final String _runAsRole;

    public RoleRunAsToken(String runAsRole) {
        this._runAsRole = runAsRole;
    }

    public String getRunAsRole() {
        return this._runAsRole;
    }

    public String toString() {
        return "RoleRunAsToken(" + this._runAsRole + ")";
    }
}
