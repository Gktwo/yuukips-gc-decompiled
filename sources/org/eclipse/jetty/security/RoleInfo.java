package org.eclipse.jetty.security;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/RoleInfo.class */
public class RoleInfo {
    private boolean _isAnyAuth;
    private boolean _isAnyRole;
    private boolean _checked;
    private boolean _forbidden;
    private UserDataConstraint _userDataConstraint;
    private final Set<String> _roles = new CopyOnWriteArraySet();

    public boolean isChecked() {
        return this._checked;
    }

    public void setChecked(boolean checked) {
        this._checked = checked;
        if (!checked) {
            this._forbidden = false;
            this._roles.clear();
            this._isAnyRole = false;
            this._isAnyAuth = false;
        }
    }

    public boolean isForbidden() {
        return this._forbidden;
    }

    public void setForbidden(boolean forbidden) {
        this._forbidden = forbidden;
        if (forbidden) {
            this._checked = true;
            this._userDataConstraint = null;
            this._isAnyRole = false;
            this._isAnyAuth = false;
            this._roles.clear();
        }
    }

    public boolean isAnyRole() {
        return this._isAnyRole;
    }

    public void setAnyRole(boolean anyRole) {
        this._isAnyRole = anyRole;
        if (anyRole) {
            this._checked = true;
        }
    }

    public boolean isAnyAuth() {
        return this._isAnyAuth;
    }

    public void setAnyAuth(boolean anyAuth) {
        this._isAnyAuth = anyAuth;
        if (anyAuth) {
            this._checked = true;
        }
    }

    public UserDataConstraint getUserDataConstraint() {
        return this._userDataConstraint;
    }

    public void setUserDataConstraint(UserDataConstraint userDataConstraint) {
        if (userDataConstraint == null) {
            throw new NullPointerException("Null UserDataConstraint");
        } else if (this._userDataConstraint == null) {
            this._userDataConstraint = userDataConstraint;
        } else {
            this._userDataConstraint = this._userDataConstraint.combine(userDataConstraint);
        }
    }

    public Set<String> getRoles() {
        return this._roles;
    }

    public void addRole(String role) {
        this._roles.add(role);
    }

    public void combine(RoleInfo other) {
        if (other._forbidden) {
            setForbidden(true);
        } else if (other._checked) {
            setChecked(true);
            if (other._isAnyAuth) {
                setAnyAuth(true);
            }
            if (other._isAnyRole) {
                setAnyRole(true);
            }
            this._roles.addAll(other._roles);
        }
        setUserDataConstraint(other._userDataConstraint);
    }

    public String toString() {
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = this._forbidden ? "Forbidden," : "";
        objArr[2] = this._checked ? "Checked," : "";
        objArr[3] = this._isAnyAuth ? "AnyAuth," : "";
        objArr[4] = this._isAnyRole ? "*" : this._roles;
        objArr[5] = this._userDataConstraint;
        return String.format("RoleInfo@%x{%s%s%s%s,%s}", objArr);
    }
}
