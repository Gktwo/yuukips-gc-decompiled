package p001ch.qos.logback.core.joran.util;

import dev.morphia.mapping.Mapper;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import p001ch.qos.logback.core.joran.spi.DefaultClass;
import p001ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
import p001ch.qos.logback.core.joran.util.beans.BeanDescription;
import p001ch.qos.logback.core.joran.util.beans.BeanDescriptionCache;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;
import p001ch.qos.logback.core.spi.ContextAwareBase;
import p001ch.qos.logback.core.util.AggregationType;
import p001ch.qos.logback.core.util.PropertySetterException;

/* renamed from: ch.qos.logback.core.joran.util.PropertySetter */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/util/PropertySetter.class */
public class PropertySetter extends ContextAwareBase {
    protected final Object obj;
    protected final Class<?> objClass;
    protected final BeanDescription beanDescription;

    public PropertySetter(BeanDescriptionCache beanDescriptionCache, Object obj) {
        this.obj = obj;
        this.objClass = obj.getClass();
        this.beanDescription = beanDescriptionCache.getBeanDescription(this.objClass);
    }

    public void setProperty(String name, String value) {
        if (value != null) {
            Method setter = findSetterMethod(name);
            if (setter == null) {
                addWarn("No setter for property [" + name + "] in " + this.objClass.getName() + Mapper.IGNORED_FIELDNAME);
                return;
            }
            try {
                setProperty(setter, name, value);
            } catch (PropertySetterException ex) {
                addWarn("Failed to set property [" + name + "] to value \"" + value + "\". ", ex);
            }
        }
    }

    private void setProperty(Method setter, String name, String value) throws PropertySetterException {
        Class<?>[] paramTypes = setter.getParameterTypes();
        try {
            Object arg = StringToObjectConverter.convertArg(this, value, paramTypes[0]);
            if (arg == null) {
                throw new PropertySetterException("Conversion to type [" + paramTypes[0] + "] failed.");
            }
            try {
                setter.invoke(this.obj, arg);
            } catch (Exception ex) {
                throw new PropertySetterException(ex);
            }
        } catch (Throwable t) {
            throw new PropertySetterException("Conversion to type [" + paramTypes[0] + "] failed. ", t);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public AggregationType computeAggregationType(String name) {
        Method addMethod = findAdderMethod(capitalizeFirstLetter(name));
        if (addMethod != null) {
            AggregationType type = computeRawAggregationType(addMethod);
            switch (type) {
                case NOT_FOUND:
                    return AggregationType.NOT_FOUND;
                case AS_BASIC_PROPERTY:
                    return AggregationType.AS_BASIC_PROPERTY_COLLECTION;
                case AS_COMPLEX_PROPERTY:
                    return AggregationType.AS_COMPLEX_PROPERTY_COLLECTION;
                case AS_BASIC_PROPERTY_COLLECTION:
                case AS_COMPLEX_PROPERTY_COLLECTION:
                    addError("Unexpected AggregationType " + type);
                    break;
            }
        }
        Method setter = findSetterMethod(name);
        if (setter != null) {
            return computeRawAggregationType(setter);
        }
        return AggregationType.NOT_FOUND;
    }

    private Method findAdderMethod(String name) {
        return this.beanDescription.getAdder(BeanUtil.toLowerCamelCase(name));
    }

    private Method findSetterMethod(String name) {
        return this.beanDescription.getSetter(BeanUtil.toLowerCamelCase(name));
    }

    private Class<?> getParameterClassForMethod(Method method) {
        if (method == null) {
            return null;
        }
        Class<?>[] classArray = method.getParameterTypes();
        if (classArray.length != 1) {
            return null;
        }
        return classArray[0];
    }

    private AggregationType computeRawAggregationType(Method method) {
        Class<?> parameterClass = getParameterClassForMethod(method);
        if (parameterClass == null) {
            return AggregationType.NOT_FOUND;
        }
        if (StringToObjectConverter.canBeBuiltFromSimpleString(parameterClass)) {
            return AggregationType.AS_BASIC_PROPERTY;
        }
        return AggregationType.AS_COMPLEX_PROPERTY;
    }

    private boolean isUnequivocallyInstantiable(Class<?> clazz) {
        if (clazz.isInterface()) {
            return false;
        }
        try {
            if (clazz.newInstance() != null) {
                return true;
            }
            return false;
        } catch (IllegalAccessException e) {
            return false;
        } catch (InstantiationException e2) {
            return false;
        }
    }

    public Class<?> getObjClass() {
        return this.objClass;
    }

    public void addComplexProperty(String name, Object complexProperty) {
        Method adderMethod = findAdderMethod(name);
        if (adderMethod == null) {
            addError("Could not find method [add" + name + "] in class [" + this.objClass.getName() + "].");
        } else if (isSanityCheckSuccessful(name, adderMethod, adderMethod.getParameterTypes(), complexProperty)) {
            invokeMethodWithSingleParameterOnThisObject(adderMethod, complexProperty);
        }
    }

    void invokeMethodWithSingleParameterOnThisObject(Method method, Object parameter) {
        Class<?> ccc = parameter.getClass();
        try {
            method.invoke(this.obj, parameter);
        } catch (Exception e) {
            addError("Could not invoke method " + method.getName() + " in class " + this.obj.getClass().getName() + " with parameter of type " + ccc.getName(), e);
        }
    }

    public void addBasicProperty(String name, String strValue) {
        if (strValue != null) {
            String name2 = capitalizeFirstLetter(name);
            Method adderMethod = findAdderMethod(name2);
            if (adderMethod == null) {
                addError("No adder for property [" + name2 + "].");
                return;
            }
            Class<?>[] paramTypes = adderMethod.getParameterTypes();
            isSanityCheckSuccessful(name2, adderMethod, paramTypes, strValue);
            try {
                if (StringToObjectConverter.convertArg(this, strValue, paramTypes[0]) != null) {
                    invokeMethodWithSingleParameterOnThisObject(adderMethod, strValue);
                }
            } catch (Throwable t) {
                addError("Conversion to type [" + paramTypes[0] + "] failed. ", t);
            }
        }
    }

    public void setComplexProperty(String name, Object complexProperty) {
        Method setter = findSetterMethod(name);
        if (setter == null) {
            addWarn("Not setter method for property [" + name + "] in " + this.obj.getClass().getName());
        } else if (isSanityCheckSuccessful(name, setter, setter.getParameterTypes(), complexProperty)) {
            try {
                invokeMethodWithSingleParameterOnThisObject(setter, complexProperty);
            } catch (Exception e) {
                addError("Could not set component " + this.obj + " for parent component " + this.obj, e);
            }
        }
    }

    private boolean isSanityCheckSuccessful(String name, Method method, Class<?>[] params, Object complexProperty) {
        Class<?> ccc = complexProperty.getClass();
        if (params.length != 1) {
            addError("Wrong number of parameters in setter method for property [" + name + "] in " + this.obj.getClass().getName());
            return false;
        } else if (params[0].isAssignableFrom(complexProperty.getClass())) {
            return true;
        } else {
            addError("A \"" + ccc.getName() + "\" object is not assignable to a \"" + params[0].getName() + "\" variable.");
            addError("The class \"" + params[0].getName() + "\" was loaded by ");
            addError("[" + params[0].getClassLoader() + "] whereas object of type ");
            addError("\"" + ccc.getName() + "\" was loaded by [" + ccc.getClassLoader() + "].");
            return false;
        }
    }

    private String capitalizeFirstLetter(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public Object getObj() {
        return this.obj;
    }

    Method getRelevantMethod(String name, AggregationType aggregationType) {
        Method relevantMethod;
        if (aggregationType == AggregationType.AS_COMPLEX_PROPERTY_COLLECTION) {
            relevantMethod = findAdderMethod(name);
        } else if (aggregationType == AggregationType.AS_COMPLEX_PROPERTY) {
            relevantMethod = findSetterMethod(name);
        } else {
            throw new IllegalStateException(aggregationType + " not allowed here");
        }
        return relevantMethod;
    }

    <T extends Annotation> T getAnnotation(String name, Class<T> annonationClass, Method relevantMethod) {
        if (relevantMethod != null) {
            return (T) relevantMethod.getAnnotation(annonationClass);
        }
        return null;
    }

    Class<?> getDefaultClassNameByAnnonation(String name, Method relevantMethod) {
        DefaultClass defaultClassAnnon = (DefaultClass) getAnnotation(name, DefaultClass.class, relevantMethod);
        if (defaultClassAnnon != null) {
            return defaultClassAnnon.value();
        }
        return null;
    }

    Class<?> getByConcreteType(String name, Method relevantMethod) {
        Class<?> paramType = getParameterClassForMethod(relevantMethod);
        if (paramType != null && isUnequivocallyInstantiable(paramType)) {
            return paramType;
        }
        return null;
    }

    public Class<?> getClassNameViaImplicitRules(String name, AggregationType aggregationType, DefaultNestedComponentRegistry registry) {
        Class<?> registryResult = registry.findDefaultComponentType(this.obj.getClass(), name);
        if (registryResult != null) {
            return registryResult;
        }
        Method relevantMethod = getRelevantMethod(name, aggregationType);
        if (relevantMethod == null) {
            return null;
        }
        Class<?> byAnnotation = getDefaultClassNameByAnnonation(name, relevantMethod);
        if (byAnnotation != null) {
            return byAnnotation;
        }
        return getByConcreteType(name, relevantMethod);
    }
}
