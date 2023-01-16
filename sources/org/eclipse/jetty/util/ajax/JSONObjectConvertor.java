package org.eclipse.jetty.util.ajax;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.eclipse.jetty.util.ajax.JSON;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/ajax/JSONObjectConvertor.class */
public class JSONObjectConvertor implements JSON.Convertor {
    private boolean _fromJSON;
    private Set _excluded;

    public JSONObjectConvertor() {
        this._excluded = null;
        this._fromJSON = false;
    }

    public JSONObjectConvertor(boolean fromJSON) {
        this._excluded = null;
        this._fromJSON = fromJSON;
    }

    public JSONObjectConvertor(boolean fromJSON, String[] excluded) {
        this._excluded = null;
        this._fromJSON = fromJSON;
        if (excluded != null) {
            this._excluded = new HashSet(Arrays.asList(excluded));
        }
    }

    @Override // org.eclipse.jetty.util.ajax.JSON.Convertor
    public Object fromJSON(Map map) {
        if (!this._fromJSON) {
            return map;
        }
        throw new UnsupportedOperationException();
    }

    @Override // org.eclipse.jetty.util.ajax.JSON.Convertor
    public void toJSON(Object obj, JSON.Output out) {
        String name;
        try {
            obj.getClass();
            if (this._fromJSON) {
                out.addClass(obj.getClass());
            }
            Method[] methods = obj.getClass().getMethods();
            for (Method m : methods) {
                if (!Modifier.isStatic(m.getModifiers()) && m.getParameterCount() == 0 && m.getReturnType() != null && m.getDeclaringClass() != Object.class) {
                    String name2 = m.getName();
                    if (name2.startsWith(BeanUtil.PREFIX_GETTER_IS)) {
                        name = name2.substring(2, 3).toLowerCase(Locale.ENGLISH) + name2.substring(3);
                    } else if (name2.startsWith(BeanUtil.PREFIX_GETTER_GET)) {
                        name = name2.substring(3, 4).toLowerCase(Locale.ENGLISH) + name2.substring(4);
                    }
                    if (includeField(name, obj, m)) {
                        out.add(name, m.invoke(obj, null));
                    }
                }
            }
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    protected boolean includeField(String name, Object o, Method m) {
        return this._excluded == null || !this._excluded.contains(name);
    }
}
