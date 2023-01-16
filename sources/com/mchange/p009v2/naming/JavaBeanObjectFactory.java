package com.mchange.p009v2.naming;

import com.mchange.p009v2.beans.BeansUtils;
import com.mchange.p009v2.lang.Coerce;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.ser.SerializableUtils;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import javax.naming.BinaryRefAddr;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.StringRefAddr;
import javax.naming.spi.ObjectFactory;

/* renamed from: com.mchange.v2.naming.JavaBeanObjectFactory */
/* loaded from: grasscutter.jar:com/mchange/v2/naming/JavaBeanObjectFactory.class */
public class JavaBeanObjectFactory implements ObjectFactory {
    private static final MLogger logger = MLog.getLogger(JavaBeanObjectFactory.class);
    static final Object NULL_TOKEN = new Object();

    public Object getObjectInstance(Object obj, Name name, Context context, Hashtable hashtable) throws Exception {
        if (!(obj instanceof Reference)) {
            return null;
        }
        Reference reference = (Reference) obj;
        HashMap hashMap = new HashMap();
        Enumeration all = reference.getAll();
        while (all.hasMoreElements()) {
            RefAddr refAddr = (RefAddr) all.nextElement();
            hashMap.put(refAddr.getType(), refAddr);
        }
        Class<?> cls = Class.forName(reference.getClassName());
        Set set = null;
        BinaryRefAddr binaryRefAddr = (BinaryRefAddr) hashMap.remove("com.mchange.v2.naming.JavaBeanReferenceMaker.REF_PROPS_KEY");
        if (binaryRefAddr != null) {
            set = (Set) SerializableUtils.fromByteArray((byte[]) binaryRefAddr.getContent());
        }
        return findBean(cls, createPropertyMap(cls, hashMap), set);
    }

    private Map createPropertyMap(Class cls, Map map) throws Exception {
        PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(cls).getPropertyDescriptors();
        HashMap hashMap = new HashMap();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String name = propertyDescriptor.getName();
            Class propertyType = propertyDescriptor.getPropertyType();
            Object remove = map.remove(name);
            if (remove != null) {
                if (remove instanceof StringRefAddr) {
                    String str = (String) ((StringRefAddr) remove).getContent();
                    if (Coerce.canCoerce(propertyType)) {
                        hashMap.put(name, Coerce.toObject(str, propertyType));
                    } else {
                        PropertyEditor findPropertyEditor = BeansUtils.findPropertyEditor(propertyDescriptor);
                        findPropertyEditor.setAsText(str);
                        hashMap.put(name, findPropertyEditor.getValue());
                    }
                } else if (remove instanceof BinaryRefAddr) {
                    byte[] bArr = (byte[]) ((BinaryRefAddr) remove).getContent();
                    if (bArr.length == 0) {
                        hashMap.put(name, NULL_TOKEN);
                    } else {
                        hashMap.put(name, SerializableUtils.fromByteArray(bArr));
                    }
                } else if (logger.isLoggable(MLevel.WARNING)) {
                    logger.warning(getClass().getName() + " -- unknown RefAddr subclass: " + remove.getClass().getName());
                }
            }
        }
        for (String str2 : map.keySet()) {
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.warning(getClass().getName() + " -- RefAddr for unknown property: " + str2);
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public Object createBlankInstance(Class cls) throws Exception {
        return cls.newInstance();
    }

    /* access modifiers changed from: protected */
    public Object findBean(Class cls, Map map, Set set) throws Exception {
        Object createBlankInstance = createBlankInstance(cls);
        PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(createBlankInstance.getClass()).getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String name = propertyDescriptor.getName();
            Object obj = map.get(name);
            Method writeMethod = propertyDescriptor.getWriteMethod();
            if (obj != null) {
                if (writeMethod != null) {
                    Object[] objArr = new Object[1];
                    objArr[0] = obj == NULL_TOKEN ? null : obj;
                    writeMethod.invoke(createBlankInstance, objArr);
                } else if (logger.isLoggable(MLevel.WARNING)) {
                    logger.warning(getClass().getName() + ": Could not restore read-only property '" + name + "'.");
                }
            } else if (writeMethod != null && ((set == null || set.contains(name)) && logger.isLoggable(MLevel.WARNING))) {
                logger.warning(getClass().getName() + " -- Expected writable property ''" + name + "'' left at default value");
            }
        }
        return createBlankInstance;
    }
}
