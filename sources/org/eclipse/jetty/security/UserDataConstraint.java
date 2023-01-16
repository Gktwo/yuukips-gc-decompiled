package org.eclipse.jetty.security;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/UserDataConstraint.class */
public enum UserDataConstraint {
    None,
    Integral,
    Confidential;

    public static UserDataConstraint get(int dataConstraint) {
        if (dataConstraint < -1 || dataConstraint > 2) {
            throw new IllegalArgumentException("Expected -1, 0, 1, or 2, not: " + dataConstraint);
        } else if (dataConstraint == -1) {
            return None;
        } else {
            return values()[dataConstraint];
        }
    }

    public UserDataConstraint combine(UserDataConstraint other) {
        if (compareTo(other) < 0) {
            return this;
        }
        return other;
    }
}
