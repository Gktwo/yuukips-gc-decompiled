package org.eclipse.jetty.security;

import java.util.List;
import java.util.Set;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/ConstraintAware.class */
public interface ConstraintAware {
    List<ConstraintMapping> getConstraintMappings();

    Set<String> getRoles();

    void setConstraintMappings(List<ConstraintMapping> list, Set<String> set);

    void addConstraintMapping(ConstraintMapping constraintMapping);

    void addRole(String str);

    void setDenyUncoveredHttpMethods(boolean z);

    boolean isDenyUncoveredHttpMethods();

    boolean checkPathsWithUncoveredHttpMethods();
}
