package p001ch.qos.logback.core.joran.conditional;

import p001ch.qos.logback.core.spi.PropertyContainer;
import p001ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.core.joran.conditional.PropertyWrapperForScripts */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/conditional/PropertyWrapperForScripts.class */
public class PropertyWrapperForScripts {
    PropertyContainer local;
    PropertyContainer context;

    public void setPropertyContainers(PropertyContainer local, PropertyContainer context) {
        this.local = local;
        this.context = context;
    }

    public boolean isNull(String k) {
        return OptionHelper.propertyLookup(k, this.local, this.context) == null;
    }

    public boolean isDefined(String k) {
        return OptionHelper.propertyLookup(k, this.local, this.context) != null;
    }

    /* renamed from: p */
    public String m1592p(String k) {
        return property(k);
    }

    public String property(String k) {
        String val = OptionHelper.propertyLookup(k, this.local, this.context);
        if (val != null) {
            return val;
        }
        return "";
    }
}
