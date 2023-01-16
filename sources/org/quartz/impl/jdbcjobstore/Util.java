package org.quartz.impl.jdbcjobstore;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Locale;
import org.quartz.JobPersistenceException;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/Util.class */
public final class Util {
    private Util() {
    }

    public static String rtp(String query, String tablePrefix, String schedNameLiteral) {
        return MessageFormat.format(query, tablePrefix, schedNameLiteral);
    }

    static String getJobNameKey(String jobName, String groupName) {
        return (groupName + "_$x$x$_" + jobName).intern();
    }

    static String getTriggerNameKey(String triggerName, String groupName) {
        return (groupName + "_$x$x$_" + triggerName).intern();
    }

    public static void closeResultSet(ResultSet rs) {
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }
    }

    public static void closeStatement(Statement statement) {
        if (null != statement) {
            try {
                statement.close();
            } catch (SQLException e) {
            }
        }
    }

    public static void setBeanProps(Object obj, String[] propNames, Object[] propValues) throws JobPersistenceException {
        if (propNames != null && propNames.length != 0) {
            if (propNames.length != propValues.length) {
                throw new IllegalArgumentException("propNames[].lenght != propValues[].length");
            }
            try {
                PropertyDescriptor[] propDescs = Introspector.getBeanInfo(obj.getClass()).getPropertyDescriptors();
                for (int i = 0; i < propNames.length; i++) {
                    String name = propNames[i];
                    Method setMeth = getSetMethod("set" + name.substring(0, 1).toUpperCase(Locale.US) + name.substring(1), propDescs);
                    if (setMeth == null) {
                        throw new NoSuchMethodException("No setter for property '" + name + "'");
                    } else if (setMeth.getParameterTypes().length != 1) {
                        throw new NoSuchMethodException("No 1-argument setter for property '" + name + "'");
                    } else {
                        setMeth.invoke(obj, propValues[i]);
                    }
                }
            } catch (Exception e) {
                throw new JobPersistenceException("Unable to set property named: " + ((String) null) + " of object of type: " + obj.getClass().getCanonicalName(), e);
            }
        }
    }

    private static Method getSetMethod(String name, PropertyDescriptor[] props) {
        for (PropertyDescriptor propertyDescriptor : props) {
            Method wMeth = propertyDescriptor.getWriteMethod();
            if (wMeth != null && wMeth.getName().equals(name)) {
                return wMeth;
            }
        }
        return null;
    }
}
