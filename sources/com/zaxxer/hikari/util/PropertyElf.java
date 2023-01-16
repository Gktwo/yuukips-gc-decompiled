package com.zaxxer.hikari.util;

import com.zaxxer.hikari.HikariConfig;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/util/PropertyElf.class */
public final class PropertyElf {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyElf.class);
    private static final Pattern GETTER_PATTERN = Pattern.compile("(get|is)[A-Z].+");

    public static void setTargetFromProperties(Object target, Properties properties) {
        if (target != null && properties != null) {
            List<Method> methods = Arrays.asList(target.getClass().getMethods());
            Enumeration<?> propertyNames = properties.propertyNames();
            while (propertyNames.hasMoreElements()) {
                Object key = propertyNames.nextElement();
                String propName = key.toString();
                Object propValue = properties.getProperty(propName);
                if (propValue == null) {
                    propValue = properties.get(key);
                }
                if (!(target instanceof HikariConfig) || !propName.startsWith("dataSource.")) {
                    setProperty(target, propName, propValue, methods);
                } else {
                    ((HikariConfig) target).addDataSourceProperty(propName.substring("dataSource.".length()), propValue);
                }
            }
        }
    }

    public static Set<String> getPropertyNames(Class<?> targetClass) {
        HashSet<String> set = new HashSet<>();
        Matcher matcher = GETTER_PATTERN.matcher("");
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            String name = method.getName();
            if (method.getParameterTypes().length == 0 && matcher.reset(name).matches()) {
                String name2 = name.replaceFirst("(get|is)", "");
                try {
                    if (targetClass.getMethod("set" + name2, method.getReturnType()) != null) {
                        set.add(Character.toLowerCase(name2.charAt(0)) + name2.substring(1));
                    }
                } catch (Exception e) {
                }
            }
        }
        return set;
    }

    public static Object getProperty(String propName, Object target) {
        try {
            return target.getClass().getMethod(BeanUtil.PREFIX_GETTER_GET + propName.substring(0, 1).toUpperCase(Locale.ENGLISH) + propName.substring(1), new Class[0]).invoke(target, new Object[0]);
        } catch (Exception e) {
            try {
                return target.getClass().getMethod(BeanUtil.PREFIX_GETTER_IS + propName.substring(0, 1).toUpperCase(Locale.ENGLISH) + propName.substring(1), new Class[0]).invoke(target, new Object[0]);
            } catch (Exception e2) {
                return null;
            }
        }
    }

    public static Properties copyProperties(Properties props) {
        Properties copy = new Properties();
        for (Map.Entry<Object, Object> entry : props.entrySet()) {
            copy.setProperty(entry.getKey().toString(), entry.getValue().toString());
        }
        return copy;
    }

    private static void setProperty(Object target, String propName, Object propValue, List<Method> methods) {
        Method writeMethod = null;
        String methodName = "set" + propName.substring(0, 1).toUpperCase(Locale.ENGLISH) + propName.substring(1);
        Iterator<Method> it = methods.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Method method = it.next();
            if (method.getName().equals(methodName) && method.getParameterTypes().length == 1) {
                writeMethod = method;
                break;
            }
        }
        if (writeMethod == null) {
            String methodName2 = "set" + propName.toUpperCase(Locale.ENGLISH);
            Iterator<Method> it2 = methods.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Method method2 = it2.next();
                if (method2.getName().equals(methodName2) && method2.getParameterTypes().length == 1) {
                    writeMethod = method2;
                    break;
                }
            }
        }
        if (writeMethod == null) {
            LOGGER.error("Property {} does not exist on target {}", propName, target.getClass());
            throw new RuntimeException(String.format("Property %s does not exist on target %s", propName, target.getClass()));
        }
        try {
            Class<?> paramClass = writeMethod.getParameterTypes()[0];
            if (paramClass == Integer.TYPE) {
                writeMethod.invoke(target, Integer.valueOf(Integer.parseInt(propValue.toString())));
            } else if (paramClass == Long.TYPE) {
                writeMethod.invoke(target, Long.valueOf(Long.parseLong(propValue.toString())));
            } else if (paramClass == Boolean.TYPE || paramClass == Boolean.class) {
                writeMethod.invoke(target, Boolean.valueOf(Boolean.parseBoolean(propValue.toString())));
            } else if (paramClass == String.class) {
                writeMethod.invoke(target, propValue.toString());
            } else {
                writeMethod.invoke(target, propValue);
            }
        } catch (Exception e) {
            LOGGER.error("Failed to set property {} on target {}", propName, target.getClass(), e);
            throw new RuntimeException(e);
        }
    }
}
