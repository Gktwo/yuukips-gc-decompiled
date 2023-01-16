package org.eclipse.jetty.util.ajax;

import java.lang.reflect.Method;
import java.util.Map;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.ajax.JSON;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import p001ch.qos.logback.core.CoreConstants;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/ajax/JSONEnumConvertor.class */
public class JSONEnumConvertor implements JSON.Convertor {
    private static final Logger LOG = Log.getLogger(JSONEnumConvertor.class);
    private boolean _fromJSON;
    private Method _valueOf;

    public JSONEnumConvertor() {
        this(false);
    }

    public JSONEnumConvertor(boolean fromJSON) {
        try {
            this._valueOf = Loader.loadClass("java.lang.Enum").getMethod(CoreConstants.VALUE_OF, Class.class, String.class);
            this._fromJSON = fromJSON;
        } catch (Exception e) {
            throw new RuntimeException("!Enums", e);
        }
    }

    @Override // org.eclipse.jetty.util.ajax.JSON.Convertor
    public Object fromJSON(Map map) {
        if (!this._fromJSON) {
            throw new UnsupportedOperationException();
        }
        try {
            return this._valueOf.invoke(null, Loader.loadClass((String) map.get("class")), map.get("value"));
        } catch (Exception e) {
            LOG.warn(e);
            return null;
        }
    }

    @Override // org.eclipse.jetty.util.ajax.JSON.Convertor
    public void toJSON(Object obj, JSON.Output out) {
        if (this._fromJSON) {
            out.addClass(obj.getClass());
            out.add("value", ((Enum) obj).name());
            return;
        }
        out.add(((Enum) obj).name());
    }
}
