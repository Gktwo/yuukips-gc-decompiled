package org.quartz.simpl;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Map;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.TriggerFiredBundle;

/* loaded from: grasscutter.jar:org/quartz/simpl/PropertySettingJobFactory.class */
public class PropertySettingJobFactory extends SimpleJobFactory {
    private boolean warnIfNotFound = false;
    private boolean throwIfNotFound = false;

    @Override // org.quartz.simpl.SimpleJobFactory, org.quartz.spi.JobFactory
    public Job newJob(TriggerFiredBundle bundle, Scheduler scheduler) throws SchedulerException {
        Job job = newJob(bundle, scheduler);
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.putAll(scheduler.getContext());
        jobDataMap.putAll(bundle.getJobDetail().getJobDataMap());
        jobDataMap.putAll(bundle.getTrigger().getJobDataMap());
        setBeanProps(job, jobDataMap);
        return job;
    }

    protected void setBeanProps(Object obj, JobDataMap data) throws SchedulerException {
        BeanInfo bi = null;
        try {
            bi = Introspector.getBeanInfo(obj.getClass());
        } catch (IntrospectionException e) {
            handleError("Unable to introspect Job class.", e);
        }
        PropertyDescriptor[] propDescs = bi.getPropertyDescriptors();
        for (Map.Entry<String, Object> entry : data.getWrappedMap().entrySet()) {
            String name = entry.getKey();
            Method setMeth = getSetMethod("set" + name.substring(0, 1).toUpperCase(Locale.US) + name.substring(1), propDescs);
            Object o = null;
            if (setMeth == null) {
                try {
                    handleError("No setter on Job class " + obj.getClass().getName() + " for property '" + name + "'");
                } catch (IllegalAccessException e2) {
                    handleError("The setter on Job class " + obj.getClass().getName() + " for property '" + name + "' could not be accessed.", e2);
                } catch (NumberFormatException nfe) {
                    handleError("The setter on Job class " + obj.getClass().getName() + " for property '" + name + "' expects a " + ((Object) null) + " but was given " + o.getClass().getName(), nfe);
                } catch (IllegalArgumentException e3) {
                    handleError("The setter on Job class " + obj.getClass().getName() + " for property '" + name + "' expects a " + ((Object) null) + " but was given " + o.getClass().getName(), e3);
                } catch (InvocationTargetException e4) {
                    handleError("The setter on Job class " + obj.getClass().getName() + " for property '" + name + "' could not be invoked.", e4);
                }
            } else {
                Class<?> paramType = setMeth.getParameterTypes()[0];
                Object o2 = entry.getValue();
                Object parm = null;
                if (paramType.isPrimitive()) {
                    if (o2 == null) {
                        handleError("Cannot set primitive property '" + name + "' on Job class " + obj.getClass().getName() + " to null.");
                    } else if (paramType.equals(Integer.TYPE)) {
                        if (o2 instanceof String) {
                            parm = Integer.valueOf((String) o2);
                        } else if (o2 instanceof Integer) {
                            parm = o2;
                        }
                    } else if (paramType.equals(Long.TYPE)) {
                        if (o2 instanceof String) {
                            parm = Long.valueOf((String) o2);
                        } else if (o2 instanceof Long) {
                            parm = o2;
                        }
                    } else if (paramType.equals(Float.TYPE)) {
                        if (o2 instanceof String) {
                            parm = Float.valueOf((String) o2);
                        } else if (o2 instanceof Float) {
                            parm = o2;
                        }
                    } else if (paramType.equals(Double.TYPE)) {
                        if (o2 instanceof String) {
                            parm = Double.valueOf((String) o2);
                        } else if (o2 instanceof Double) {
                            parm = o2;
                        }
                    } else if (paramType.equals(Boolean.TYPE)) {
                        if (o2 instanceof String) {
                            parm = Boolean.valueOf((String) o2);
                        } else if (o2 instanceof Boolean) {
                            parm = o2;
                        }
                    } else if (paramType.equals(Byte.TYPE)) {
                        if (o2 instanceof String) {
                            parm = Byte.valueOf((String) o2);
                        } else if (o2 instanceof Byte) {
                            parm = o2;
                        }
                    } else if (paramType.equals(Short.TYPE)) {
                        if (o2 instanceof String) {
                            parm = Short.valueOf((String) o2);
                        } else if (o2 instanceof Short) {
                            parm = o2;
                        }
                    } else if (paramType.equals(Character.TYPE)) {
                        if (o2 instanceof String) {
                            String str = (String) o2;
                            if (str.length() == 1) {
                                parm = Character.valueOf(str.charAt(0));
                            }
                        } else if (o2 instanceof Character) {
                            parm = o2;
                        }
                    }
                } else if (o2 != null && paramType.isAssignableFrom(o2.getClass())) {
                    parm = o2;
                }
                if (o2 == null || parm != null) {
                    setMeth.invoke(obj, parm);
                } else {
                    handleError("The setter on Job class " + obj.getClass().getName() + " for property '" + name + "' expects a " + paramType + " but was given " + o2.getClass().getName());
                }
            }
        }
    }

    private void handleError(String message) throws SchedulerException {
        handleError(message, null);
    }

    private void handleError(String message, Exception e) throws SchedulerException {
        if (isThrowIfPropertyNotFound()) {
            throw new SchedulerException(message, e);
        } else if (!isWarnIfPropertyNotFound()) {
        } else {
            if (e == null) {
                getLog().warn(message);
            } else {
                getLog().warn(message, (Throwable) e);
            }
        }
    }

    private Method getSetMethod(String name, PropertyDescriptor[] props) {
        for (PropertyDescriptor propertyDescriptor : props) {
            Method wMeth = propertyDescriptor.getWriteMethod();
            if (wMeth != null && wMeth.getParameterTypes().length == 1 && wMeth.getName().equals(name)) {
                return wMeth;
            }
        }
        return null;
    }

    public boolean isThrowIfPropertyNotFound() {
        return this.throwIfNotFound;
    }

    public void setThrowIfPropertyNotFound(boolean throwIfNotFound) {
        this.throwIfNotFound = throwIfNotFound;
    }

    public boolean isWarnIfPropertyNotFound() {
        return this.warnIfNotFound;
    }

    public void setWarnIfPropertyNotFound(boolean warnIfNotFound) {
        this.warnIfNotFound = warnIfNotFound;
    }
}
