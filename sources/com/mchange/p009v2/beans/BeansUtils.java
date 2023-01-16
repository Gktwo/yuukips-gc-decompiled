package com.mchange.p009v2.beans;

import com.mchange.p009v2.lang.Coerce;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.beans.IndexedPropertyDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* renamed from: com.mchange.v2.beans.BeansUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/beans/BeansUtils.class */
public final class BeansUtils {
    static final MLogger logger = MLog.getLogger(BeansUtils.class);
    static final Object[] EMPTY_ARGS = new Object[0];

    public static PropertyEditor findPropertyEditor(PropertyDescriptor propertyDescriptor) {
        PropertyEditor propertyEditor = null;
        Class cls = null;
        try {
            cls = propertyDescriptor.getPropertyEditorClass();
            if (cls != null) {
                propertyEditor = (PropertyEditor) cls.newInstance();
            }
        } catch (Exception e) {
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "Bad property editor class " + cls.getName() + " registered for property " + propertyDescriptor.getName(), (Throwable) e);
            }
        }
        if (propertyEditor == null) {
            propertyEditor = PropertyEditorManager.findEditor(propertyDescriptor.getPropertyType());
        }
        return propertyEditor;
    }

    public static boolean equalsByAccessibleProperties(Object obj, Object obj2) throws IntrospectionException {
        return equalsByAccessibleProperties(obj, obj2, Collections.EMPTY_SET);
    }

    public static boolean equalsByAccessibleProperties(Object obj, Object obj2, Collection collection) throws IntrospectionException {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        extractAccessiblePropertiesToMap(hashMap, obj, collection);
        extractAccessiblePropertiesToMap(hashMap2, obj2, collection);
        return hashMap.equals(hashMap2);
    }

    public static boolean equalsByAccessiblePropertiesVerbose(Object obj, Object obj2, Collection collection) throws IntrospectionException {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        extractAccessiblePropertiesToMap(hashMap, obj, collection);
        extractAccessiblePropertiesToMap(hashMap2, obj2, collection);
        boolean z = true;
        if (hashMap.size() != hashMap2.size()) {
            System.err.println("Unequal sizes --> Map0: " + hashMap.size() + "; m1: " + hashMap2.size());
            Set keySet = hashMap.keySet();
            keySet.removeAll(hashMap2.keySet());
            Set keySet2 = hashMap2.keySet();
            keySet2.removeAll(hashMap.keySet());
            if (keySet.size() > 0) {
                System.err.println("Map0 extras:");
                Iterator it = keySet.iterator();
                while (it.hasNext()) {
                    System.err.println('\t' + it.next().toString());
                }
            }
            if (keySet2.size() > 0) {
                System.err.println("Map1 extras:");
                Iterator it2 = keySet2.iterator();
                while (it2.hasNext()) {
                    System.err.println('\t' + it2.next().toString());
                }
            }
            z = false;
        }
        for (String str : hashMap.keySet()) {
            Object obj3 = hashMap.get(str);
            Object obj4 = hashMap2.get(str);
            if ((obj3 == null && obj4 != null) || (obj3 != null && !obj3.equals(obj4))) {
                System.err.println('\t' + str + ": " + obj3 + " != " + obj4);
                z = false;
            }
        }
        return z;
    }

    public static void overwriteAccessibleProperties(Object obj, Object obj2) throws IntrospectionException {
        overwriteAccessibleProperties(obj, obj2, Collections.EMPTY_SET);
    }

    public static void overwriteAccessibleProperties(Object obj, Object obj2, Collection collection) throws IntrospectionException {
        try {
            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(obj.getClass(), Object.class).getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                if (!collection.contains(propertyDescriptor.getName())) {
                    Method readMethod = propertyDescriptor.getReadMethod();
                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    if (readMethod == null || writeMethod == null) {
                        if ((propertyDescriptor instanceof IndexedPropertyDescriptor) && logger.isLoggable(MLevel.WARNING)) {
                            logger.warning("BeansUtils.overwriteAccessibleProperties() does not support indexed properties that do not provide single-valued array getters and setters! [The indexed methods provide no means of modifying the size of the array in the destination bean if it does not match the source.]");
                        }
                        if (logger.isLoggable(MLevel.INFO)) {
                            logger.info("Property inaccessible for overwriting: " + propertyDescriptor.getName());
                        }
                    } else {
                        writeMethod.invoke(obj2, readMethod.invoke(obj, EMPTY_ARGS));
                    }
                }
            }
        } catch (IntrospectionException e) {
            throw e;
        } catch (Exception e2) {
            if (logger.isLoggable(MLevel.FINE)) {
                logger.log(MLevel.FINE, "Converting exception to throwable IntrospectionException");
            }
            throw new IntrospectionException(e2.getMessage());
        }
    }

    public static void overwriteAccessiblePropertiesFromMap(Map map, Object obj, boolean z) throws IntrospectionException {
        overwriteAccessiblePropertiesFromMap(map, obj, z, Collections.EMPTY_SET);
    }

    public static void overwriteAccessiblePropertiesFromMap(Map map, Object obj, boolean z, Collection collection) throws IntrospectionException {
        overwriteAccessiblePropertiesFromMap(map, obj, z, collection, false, MLevel.WARNING, MLevel.WARNING, true);
    }

    public static void overwriteAccessiblePropertiesFromMap(Map map, Object obj, boolean z, Collection collection, boolean z2, MLevel mLevel, MLevel mLevel2, boolean z3) throws IntrospectionException {
        Object obj2;
        if (mLevel == null) {
            mLevel = MLevel.WARNING;
        }
        if (mLevel2 == null) {
            mLevel2 = MLevel.WARNING;
        }
        Set keySet = map.keySet();
        PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(obj.getClass(), Object.class).getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String name = propertyDescriptor.getName();
            if (keySet.contains(name) && ((collection == null || !collection.contains(name)) && ((obj2 = map.get(name)) != null || !z))) {
                Method writeMethod = propertyDescriptor.getWriteMethod();
                Class propertyType = propertyDescriptor.getPropertyType();
                if (writeMethod == null) {
                    if ((propertyDescriptor instanceof IndexedPropertyDescriptor) && logger.isLoggable(MLevel.FINER)) {
                        logger.finer("BeansUtils.overwriteAccessiblePropertiesFromMap() does not support indexed properties that do not provide single-valued array getters and setters! [The indexed methods provide no means of modifying the size of the array in the destination bean if it does not match the source.]");
                    }
                    if (logger.isLoggable(mLevel)) {
                        String str = "Property inaccessible for overwriting: " + name;
                        logger.log(mLevel, str);
                        if (z3) {
                            throw new IntrospectionException(str);
                        }
                    } else {
                        continue;
                    }
                } else {
                    if (z2 && obj2 != null && obj2.getClass() == String.class) {
                        Class propertyType2 = propertyDescriptor.getPropertyType();
                        propertyType = propertyType2;
                        if (propertyType2 != String.class && Coerce.canCoerce(propertyType)) {
                            try {
                                writeMethod.invoke(obj, Coerce.toObject((String) obj2, propertyType));
                            } catch (IllegalArgumentException e) {
                                String str2 = "Failed to coerce property: " + name + " [propVal: " + obj2 + "; propType: " + propertyType + "]";
                                if (logger.isLoggable(mLevel2)) {
                                    logger.log(mLevel2, str2, (Throwable) e);
                                }
                                if (z3) {
                                    throw new IntrospectionException(str2);
                                }
                            } catch (Exception e2) {
                                String str3 = "Failed to set property: " + name + " [propVal: " + obj2 + "; propType: " + propertyType + "]";
                                if (logger.isLoggable(mLevel)) {
                                    logger.log(mLevel, str3, (Throwable) e2);
                                }
                                if (z3) {
                                    throw new IntrospectionException(str3);
                                }
                            }
                        }
                    }
                    try {
                        writeMethod.invoke(obj, obj2);
                    } catch (Exception e3) {
                        String str4 = "Failed to set property: " + name + " [propVal: " + obj2 + "; propType: " + propertyType + "]";
                        if (logger.isLoggable(mLevel)) {
                            logger.log(mLevel, str4, (Throwable) e3);
                        }
                        if (z3) {
                            throw new IntrospectionException(str4);
                        }
                    }
                }
            }
        }
    }

    public static void appendPropNamesAndValues(StringBuffer stringBuffer, Object obj, Collection collection) throws IntrospectionException {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        extractAccessiblePropertiesToMap(treeMap, obj, collection);
        boolean z = true;
        for (String str : treeMap.keySet()) {
            Object obj2 = treeMap.get(str);
            if (z) {
                z = false;
            } else {
                stringBuffer.append(", ");
            }
            stringBuffer.append(str);
            stringBuffer.append(" -> ");
            stringBuffer.append(obj2);
        }
    }

    public static void extractAccessiblePropertiesToMap(Map map, Object obj) throws IntrospectionException {
        extractAccessiblePropertiesToMap(map, obj, Collections.EMPTY_SET);
    }

    public static void extractAccessiblePropertiesToMap(Map map, Object obj, Collection collection) throws IntrospectionException {
        String str = null;
        try {
            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(obj.getClass(), Object.class).getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                str = propertyDescriptor.getName();
                if (!collection.contains(str)) {
                    map.put(str, propertyDescriptor.getReadMethod().invoke(obj, EMPTY_ARGS));
                }
            }
        } catch (IntrospectionException e) {
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.warning("Problem occurred while overwriting property: " + str);
            }
            if (logger.isLoggable(MLevel.FINE)) {
                logger.logp(MLevel.FINE, BeansUtils.class.getName(), "extractAccessiblePropertiesToMap( Map fillMe, Object bean, Collection ignoreProps )", (str != null ? "Problem occurred while overwriting property: " + str : "") + " throwing...", e);
            }
            throw e;
        } catch (Exception e2) {
            if (logger.isLoggable(MLevel.FINE)) {
                logger.logp(MLevel.FINE, BeansUtils.class.getName(), "extractAccessiblePropertiesToMap( Map fillMe, Object bean, Collection ignoreProps )", "Caught unexpected Exception; Converting to IntrospectionException.", (Throwable) e2);
            }
            throw new IntrospectionException(e2.toString() + (str == null ? "" : " [" + str + ']'));
        }
    }

    private static void overwriteProperty(String str, Object obj, Method method, Object obj2) throws Exception {
        if (method.getDeclaringClass().isAssignableFrom(obj2.getClass())) {
            method.invoke(obj2, obj);
            return;
        }
        PropertyDescriptor propertyDescriptor = null;
        PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(obj2.getClass(), Object.class).getPropertyDescriptors();
        int i = 0;
        int length = propertyDescriptors.length;
        while (true) {
            if (i >= length) {
                break;
            } else if (str.equals(propertyDescriptors[i].getName())) {
                propertyDescriptor = propertyDescriptors[i];
                break;
            } else {
                i++;
            }
        }
        propertyDescriptor.getWriteMethod().invoke(obj2, obj);
    }

    public static void overwriteSpecificAccessibleProperties(Object obj, Object obj2, Collection collection) throws IntrospectionException {
        try {
            HashSet hashSet = new HashSet(collection);
            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(obj.getClass(), Object.class).getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String name = propertyDescriptor.getName();
                if (hashSet.remove(name)) {
                    Method readMethod = propertyDescriptor.getReadMethod();
                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    if (readMethod == null || writeMethod == null) {
                        if ((propertyDescriptor instanceof IndexedPropertyDescriptor) && logger.isLoggable(MLevel.WARNING)) {
                            logger.warning("BeansUtils.overwriteAccessibleProperties() does not support indexed properties that do not provide single-valued array getters and setters! [The indexed methods provide no means of modifying the size of the array in the destination bean if it does not match the source.]");
                        }
                        if (logger.isLoggable(MLevel.INFO)) {
                            logger.info("Property inaccessible for overwriting: " + propertyDescriptor.getName());
                        }
                    } else {
                        overwriteProperty(name, readMethod.invoke(obj, EMPTY_ARGS), writeMethod, obj2);
                    }
                }
            }
            if (logger.isLoggable(MLevel.WARNING)) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    logger.warning("failed to find expected property: " + it.next());
                }
            }
        } catch (IntrospectionException e) {
            throw e;
        } catch (Exception e2) {
            if (logger.isLoggable(MLevel.FINE)) {
                logger.logp(MLevel.FINE, BeansUtils.class.getName(), "overwriteSpecificAccessibleProperties( Object sourceBean, Object destBean, Collection props )", "Caught unexpected Exception; Converting to IntrospectionException.", (Throwable) e2);
            }
            throw new IntrospectionException(e2.getMessage());
        }
    }

    public static void debugShowPropertyChange(PropertyChangeEvent propertyChangeEvent) {
        System.err.println("PropertyChangeEvent: [ propertyName -> " + propertyChangeEvent.getPropertyName() + ", oldValue -> " + propertyChangeEvent.getOldValue() + ", newValue -> " + propertyChangeEvent.getNewValue() + " ]");
    }

    private BeansUtils() {
    }
}
