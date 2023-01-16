package p001ch.qos.logback.classic.spi;

import java.io.Serializable;
import java.util.Map;
import p001ch.qos.logback.classic.LoggerContext;

/* renamed from: ch.qos.logback.classic.spi.LoggerContextVO */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/spi/LoggerContextVO.class */
public class LoggerContextVO implements Serializable {
    private static final long serialVersionUID = 5488023392483144387L;
    final String name;
    final Map<String, String> propertyMap;
    final long birthTime;

    public LoggerContextVO(LoggerContext lc) {
        this.name = lc.getName();
        this.propertyMap = lc.getCopyOfPropertyMap();
        this.birthTime = lc.getBirthTime();
    }

    public LoggerContextVO(String name, Map<String, String> propertyMap, long birthTime) {
        this.name = name;
        this.propertyMap = propertyMap;
        this.birthTime = birthTime;
    }

    public String getName() {
        return this.name;
    }

    public Map<String, String> getPropertyMap() {
        return this.propertyMap;
    }

    public long getBirthTime() {
        return this.birthTime;
    }

    @Override // java.lang.Object
    public String toString() {
        return "LoggerContextVO{name='" + this.name + "', propertyMap=" + this.propertyMap + ", birthTime=" + this.birthTime + '}';
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LoggerContextVO)) {
            return false;
        }
        LoggerContextVO that = (LoggerContextVO) o;
        if (this.birthTime != that.birthTime) {
            return false;
        }
        if (this.name != null) {
            if (!this.name.equals(that.name)) {
                return false;
            }
        } else if (that.name != null) {
            return false;
        }
        if (this.propertyMap != null) {
            if (!this.propertyMap.equals(that.propertyMap)) {
                return false;
            }
            return true;
        } else if (that.propertyMap != null) {
            return false;
        } else {
            return true;
        }
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (31 * ((31 * (this.name != null ? this.name.hashCode() : 0)) + (this.propertyMap != null ? this.propertyMap.hashCode() : 0))) + ((int) (this.birthTime ^ (this.birthTime >>> 32)));
    }
}
