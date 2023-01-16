package org.eclipse.jetty.util.ajax;

import java.util.Map;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.ajax.JSON;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/ajax/JSONPojoConvertorFactory.class */
public class JSONPojoConvertorFactory implements JSON.Convertor {
    private final JSON _json;
    private final boolean _fromJson;

    public JSONPojoConvertorFactory(JSON json) {
        if (json == null) {
            throw new IllegalArgumentException();
        }
        this._json = json;
        this._fromJson = true;
    }

    public JSONPojoConvertorFactory(JSON json, boolean fromJSON) {
        if (json == null) {
            throw new IllegalArgumentException();
        }
        this._json = json;
        this._fromJson = fromJSON;
    }

    @Override // org.eclipse.jetty.util.ajax.JSON.Convertor
    public void toJSON(Object obj, JSON.Output out) {
        String clsName = obj.getClass().getName();
        JSON.Convertor convertor = this._json.getConvertorFor(clsName);
        if (convertor == null) {
            try {
                convertor = new JSONPojoConvertor(Loader.loadClass(clsName), this._fromJson);
                this._json.addConvertorFor(clsName, convertor);
            } catch (ClassNotFoundException e) {
                JSON.LOG.warn(e);
            }
        }
        if (convertor != null) {
            convertor.toJSON(obj, out);
        }
    }

    @Override // org.eclipse.jetty.util.ajax.JSON.Convertor
    public Object fromJSON(Map object) {
        String clsName = (String) object.get("class");
        if (clsName != null) {
            JSON.Convertor convertor = this._json.getConvertorFor(clsName);
            if (convertor == null) {
                try {
                    convertor = new JSONPojoConvertor(Loader.loadClass(clsName), this._fromJson);
                    this._json.addConvertorFor(clsName, convertor);
                } catch (ClassNotFoundException e) {
                    JSON.LOG.warn(e);
                }
            }
            if (convertor != null) {
                return convertor.fromJSON(object);
            }
        }
        return object;
    }
}
