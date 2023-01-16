package net.bytebuddy.utility.privilege;

import java.lang.reflect.AccessibleObject;
import java.security.PrivilegedAction;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/utility/privilege/SetAccessibleAction.class */
public class SetAccessibleAction<T extends AccessibleObject> implements PrivilegedAction<T> {
    private final T accessibleObject;

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.accessibleObject.equals(((SetAccessibleAction) obj).accessibleObject);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (getClass().hashCode() * 31) + this.accessibleObject.hashCode();
    }

    public SetAccessibleAction(T accessibleObject) {
        this.accessibleObject = accessibleObject;
    }

    @Override // java.security.PrivilegedAction
    public T run() {
        this.accessibleObject.setAccessible(true);
        return this.accessibleObject;
    }
}
