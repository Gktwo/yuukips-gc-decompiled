package net.bytebuddy.utility.privilege;

import java.security.PrivilegedAction;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/utility/privilege/GetSystemPropertyAction.class */
public class GetSystemPropertyAction implements PrivilegedAction<String> {
    private final String key;

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.key.equals(((GetSystemPropertyAction) obj).key);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (getClass().hashCode() * 31) + this.key.hashCode();
    }

    public GetSystemPropertyAction(String key) {
        this.key = key;
    }

    @Override // java.security.PrivilegedAction
    public String run() {
        return System.getProperty(this.key);
    }
}
