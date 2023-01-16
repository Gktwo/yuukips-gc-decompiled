package p001ch.qos.logback.core.property;

import p001ch.qos.logback.core.PropertyDefinerBase;
import p001ch.qos.logback.core.util.Loader;
import p001ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.core.property.ResourceExistsPropertyDefiner */
/* loaded from: grasscutter.jar:ch/qos/logback/core/property/ResourceExistsPropertyDefiner.class */
public class ResourceExistsPropertyDefiner extends PropertyDefinerBase {
    String resourceStr;

    public String getResource() {
        return this.resourceStr;
    }

    public void setResource(String resource) {
        this.resourceStr = resource;
    }

    @Override // p001ch.qos.logback.core.spi.PropertyDefiner
    public String getPropertyValue() {
        if (OptionHelper.isEmpty(this.resourceStr)) {
            addError("The \"resource\" property must be set.");
            return null;
        }
        return booleanAsStr(Loader.getResourceBySelfClassLoader(this.resourceStr) != null);
    }
}
