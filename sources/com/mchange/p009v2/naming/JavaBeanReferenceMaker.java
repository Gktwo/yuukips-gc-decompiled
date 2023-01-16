package com.mchange.p009v2.naming;

import com.mchange.p009v2.beans.BeansUtils;
import com.mchange.p009v2.lang.Coerce;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.ser.IndirectPolicy;
import com.mchange.p009v2.ser.SerializableUtils;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import javax.naming.BinaryRefAddr;
import javax.naming.NamingException;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.StringRefAddr;

/* renamed from: com.mchange.v2.naming.JavaBeanReferenceMaker */
/* loaded from: grasscutter.jar:com/mchange/v2/naming/JavaBeanReferenceMaker.class */
public class JavaBeanReferenceMaker implements ReferenceMaker {
    static final String REF_PROPS_KEY = "com.mchange.v2.naming.JavaBeanReferenceMaker.REF_PROPS_KEY";
    String factoryClassName = "com.mchange.v2.naming.JavaBeanObjectFactory";
    String defaultFactoryClassLocation = null;
    Set referenceProperties = new HashSet();
    ReferenceIndirector indirector = new ReferenceIndirector();
    private static final MLogger logger = MLog.getLogger(JavaBeanReferenceMaker.class);
    static final Object[] EMPTY_ARGS = new Object[0];
    static final byte[] NULL_TOKEN_BYTES = new byte[0];

    public Hashtable getEnvironmentProperties() {
        return this.indirector.getEnvironmentProperties();
    }

    public void setEnvironmentProperties(Hashtable hashtable) {
        this.indirector.setEnvironmentProperties(hashtable);
    }

    public void setFactoryClassName(String str) {
        this.factoryClassName = str;
    }

    public String getFactoryClassName() {
        return this.factoryClassName;
    }

    public String getDefaultFactoryClassLocation() {
        return this.defaultFactoryClassLocation;
    }

    public void setDefaultFactoryClassLocation(String str) {
        this.defaultFactoryClassLocation = str;
    }

    public void addReferenceProperty(String str) {
        this.referenceProperties.add(str);
    }

    public void removeReferenceProperty(String str) {
        this.referenceProperties.remove(str);
    }

    @Override // com.mchange.p009v2.naming.ReferenceMaker
    public Reference createReference(Object obj) throws NamingException {
        try {
            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(obj.getClass()).getPropertyDescriptors();
            ArrayList<RefAddr> arrayList = new ArrayList();
            String str = this.defaultFactoryClassLocation;
            boolean z = this.referenceProperties.size() > 0;
            if (z) {
                arrayList.add(new BinaryRefAddr(REF_PROPS_KEY, SerializableUtils.toByteArray(this.referenceProperties)));
            }
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String name = propertyDescriptor.getName();
                if (!z || this.referenceProperties.contains(name)) {
                    Class propertyType = propertyDescriptor.getPropertyType();
                    Method readMethod = propertyDescriptor.getReadMethod();
                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    if (readMethod != null && writeMethod != null) {
                        Object invoke = readMethod.invoke(obj, EMPTY_ARGS);
                        if (name.equals("factoryClassLocation")) {
                            if (String.class != propertyType) {
                                throw new NamingException(getClass().getName() + " requires a factoryClassLocation property to be a string, " + propertyType.getName() + " is not valid.");
                            }
                            str = (String) invoke;
                        }
                        if (invoke == null) {
                            arrayList.add(new BinaryRefAddr(name, NULL_TOKEN_BYTES));
                        } else if (Coerce.canCoerce(propertyType)) {
                            arrayList.add(new StringRefAddr(name, String.valueOf(invoke)));
                        } else {
                            BinaryRefAddr binaryRefAddr = null;
                            PropertyEditor findPropertyEditor = BeansUtils.findPropertyEditor(propertyDescriptor);
                            if (findPropertyEditor != null) {
                                findPropertyEditor.setValue(invoke);
                                String asText = findPropertyEditor.getAsText();
                                if (asText != null) {
                                    binaryRefAddr = new StringRefAddr(name, asText);
                                }
                            }
                            if (binaryRefAddr == null) {
                                binaryRefAddr = new BinaryRefAddr(name, SerializableUtils.toByteArray(invoke, this.indirector, IndirectPolicy.INDIRECT_ON_EXCEPTION));
                            }
                            arrayList.add(binaryRefAddr);
                        }
                    } else if (logger.isLoggable(MLevel.WARNING)) {
                        logger.warning(getClass().getName() + ": Skipping " + name + " because it is " + (writeMethod == null ? "read-only." : "write-only."));
                    }
                }
            }
            Reference reference = new Reference(obj.getClass().getName(), this.factoryClassName, str);
            for (RefAddr refAddr : arrayList) {
                reference.add(refAddr);
            }
            return reference;
        } catch (Exception e) {
            if (logger.isLoggable(MLevel.FINE)) {
                logger.log(MLevel.FINE, "Exception trying to create Reference.", (Throwable) e);
            }
            throw new NamingException("Could not create reference from bean: " + e.toString());
        }
    }
}
