package p001ch.qos.logback.core.property;

import java.io.File;
import p001ch.qos.logback.core.PropertyDefinerBase;
import p001ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.core.property.FileExistsPropertyDefiner */
/* loaded from: grasscutter.jar:ch/qos/logback/core/property/FileExistsPropertyDefiner.class */
public class FileExistsPropertyDefiner extends PropertyDefinerBase {
    String path;

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override // p001ch.qos.logback.core.spi.PropertyDefiner
    public String getPropertyValue() {
        if (!OptionHelper.isEmpty(this.path)) {
            return booleanAsStr(new File(this.path).exists());
        }
        addError("The \"path\" property must be set.");
        return null;
    }
}
