package com.mchange.p009v2.beans.swing;

import com.mchange.p009v2.beans.BeansUtils;
import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.PropertyVetoException;
import java.lang.reflect.Method;
import javax.swing.SwingUtilities;

/* access modifiers changed from: package-private */
/* renamed from: com.mchange.v2.beans.swing.PropertyComponentBindingUtility */
/* loaded from: grasscutter.jar:com/mchange/v2/beans/swing/PropertyComponentBindingUtility.class */
public class PropertyComponentBindingUtility {
    static final Object[] EMPTY_ARGS = new Object[0];
    HostBindingInterface hbi;
    Object bean;

    /* renamed from: pd */
    PropertyDescriptor f393pd;
    EventSetDescriptor propChangeEsd;
    Method addMethod;
    Method removeMethod;
    Method propGetter;
    Method propSetter;
    PropertyEditor propEditor;
    Object nullReplacement;

    /* access modifiers changed from: package-private */
    public PropertyComponentBindingUtility(final HostBindingInterface hostBindingInterface, Object obj, final String str, boolean z) throws IntrospectionException {
        this.f393pd = null;
        this.propChangeEsd = null;
        this.addMethod = null;
        this.removeMethod = null;
        this.propGetter = null;
        this.propSetter = null;
        this.propEditor = null;
        this.nullReplacement = null;
        this.hbi = hostBindingInterface;
        this.bean = obj;
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        int i = 0;
        int length = propertyDescriptors.length;
        while (true) {
            if (i >= length) {
                break;
            }
            PropertyDescriptor propertyDescriptor = propertyDescriptors[i];
            if (str.equals(propertyDescriptor.getName())) {
                this.f393pd = propertyDescriptor;
                break;
            }
            i++;
        }
        if (this.f393pd == null) {
            throw new IntrospectionException("Cannot find property on bean Object with name '" + str + "'.");
        }
        EventSetDescriptor[] eventSetDescriptors = beanInfo.getEventSetDescriptors();
        int i2 = 0;
        int length2 = eventSetDescriptors.length;
        while (true) {
            if (i2 >= length2) {
                break;
            }
            EventSetDescriptor eventSetDescriptor = eventSetDescriptors[i2];
            if ("propertyChange".equals(eventSetDescriptor.getName())) {
                this.propChangeEsd = eventSetDescriptor;
                break;
            }
            i2++;
        }
        if (this.propChangeEsd == null) {
            throw new IntrospectionException("Cannot find PropertyChangeEvent on bean Object with name '" + str + "'.");
        }
        this.propEditor = BeansUtils.findPropertyEditor(this.f393pd);
        if (!z || this.propEditor != null) {
            this.propGetter = this.f393pd.getReadMethod();
            this.propSetter = this.f393pd.getWriteMethod();
            if (this.propGetter == null || this.propSetter == null) {
                throw new IntrospectionException("The specified property '" + str + "' must be both readdable and writable, but it is not!");
            }
            Class propertyType = this.f393pd.getPropertyType();
            if (propertyType.isPrimitive()) {
                if (propertyType == Boolean.TYPE) {
                    this.nullReplacement = Boolean.FALSE;
                }
                if (propertyType == Byte.TYPE) {
                    this.nullReplacement = new Byte((byte) 0);
                } else if (propertyType == Character.TYPE) {
                    this.nullReplacement = new Character(0);
                } else if (propertyType == Short.TYPE) {
                    this.nullReplacement = new Short((short) 0);
                } else if (propertyType == Integer.TYPE) {
                    this.nullReplacement = new Integer(0);
                } else if (propertyType == Long.TYPE) {
                    this.nullReplacement = new Long(0);
                } else if (propertyType == Float.TYPE) {
                    this.nullReplacement = new Float(0.0f);
                } else if (propertyType == Double.TYPE) {
                    this.nullReplacement = new Double(0.0d);
                } else {
                    throw new InternalError("What kind of primitive is " + propertyType.getName() + "???");
                }
            }
            this.addMethod = this.propChangeEsd.getAddListenerMethod();
            this.removeMethod = this.propChangeEsd.getAddListenerMethod();
            try {
                this.addMethod.invoke(obj, new PropertyChangeListener() { // from class: com.mchange.v2.beans.swing.PropertyComponentBindingUtility.1
                    @Override // java.beans.PropertyChangeListener
                    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                        if (propertyChangeEvent.getPropertyName().equals(str)) {
                            hostBindingInterface.syncToValue(PropertyComponentBindingUtility.this.propEditor, propertyChangeEvent.getNewValue());
                        }
                    }
                });
                hostBindingInterface.addUserModificationListeners();
            } catch (Exception e) {
                e.printStackTrace();
                throw new IntrospectionException("The introspected PropertyChangeEvent adding method failed with an Exception.");
            }
        } else {
            throw new IntrospectionException("Could not find an appropriate PropertyEditor for property: " + str);
        }
    }

    public void userModification() {
        Object obj = null;
        try {
            obj = this.propGetter.invoke(this.bean, EMPTY_ARGS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Object fetchUserModification = this.hbi.fetchUserModification(this.propEditor, obj);
            if (fetchUserModification == null) {
                fetchUserModification = this.nullReplacement;
            }
            this.propSetter.invoke(this.bean, fetchUserModification);
        } catch (Exception e2) {
            if (!(e2 instanceof PropertyVetoException)) {
                e2.printStackTrace();
            }
            syncComponentToValue(true);
        }
    }

    public void resync() {
        syncComponentToValue(false);
    }

    private void syncComponentToValue(final boolean z) {
        try {
            final Object invoke = this.propGetter.invoke(this.bean, EMPTY_ARGS);
            SwingUtilities.invokeLater(new Runnable() { // from class: com.mchange.v2.beans.swing.PropertyComponentBindingUtility.2
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        PropertyComponentBindingUtility.this.hbi.alertErroneousInput();
                    }
                    PropertyComponentBindingUtility.this.hbi.syncToValue(PropertyComponentBindingUtility.this.propEditor, invoke);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
