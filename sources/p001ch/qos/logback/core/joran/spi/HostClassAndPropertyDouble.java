package p001ch.qos.logback.core.joran.spi;

/* renamed from: ch.qos.logback.core.joran.spi.HostClassAndPropertyDouble */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/spi/HostClassAndPropertyDouble.class */
public class HostClassAndPropertyDouble {
    final Class<?> hostClass;
    final String propertyName;

    public HostClassAndPropertyDouble(Class<?> hostClass, String propertyName) {
        this.hostClass = hostClass;
        this.propertyName = propertyName;
    }

    public Class<?> getHostClass() {
        return this.hostClass;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public int hashCode() {
        return (31 * ((31 * 1) + (this.hostClass == null ? 0 : this.hostClass.hashCode()))) + (this.propertyName == null ? 0 : this.propertyName.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HostClassAndPropertyDouble other = (HostClassAndPropertyDouble) obj;
        if (this.hostClass == null) {
            if (other.hostClass != null) {
                return false;
            }
        } else if (!this.hostClass.equals(other.hostClass)) {
            return false;
        }
        if (this.propertyName == null) {
            if (other.propertyName != null) {
                return false;
            }
            return true;
        } else if (!this.propertyName.equals(other.propertyName)) {
            return false;
        } else {
            return true;
        }
    }
}
