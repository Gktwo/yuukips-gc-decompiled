package com.mchange.p009v2.c3p0.management;

import com.mchange.p006v1.lang.ClassUtils;
import com.mchange.p009v2.c3p0.AbstractComboPooledDataSource;
import com.mchange.p009v2.c3p0.DriverManagerDataSource;
import com.mchange.p009v2.c3p0.PooledDataSource;
import com.mchange.p009v2.c3p0.WrapperConnectionPoolDataSource;
import com.mchange.p009v2.c3p0.impl.AbstractPoolBackedDataSource;
import com.mchange.p009v2.lang.ObjectUtils;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.management.ManagementUtils;
import dev.morphia.mapping.Mapper;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.DynamicMBean;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.MBeanServer;
import javax.management.ReflectionException;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* renamed from: com.mchange.v2.c3p0.management.DynamicPooledDataSourceManagerMBean */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/management/DynamicPooledDataSourceManagerMBean.class */
public class DynamicPooledDataSourceManagerMBean implements DynamicMBean {
    static final MLogger logger;
    static final Set HIDE_PROPS;
    static final Set HIDE_OPS;
    static final Set FORCE_OPS;
    static final Set FORCE_READ_ONLY_PROPS;
    static final MBeanOperationInfo[] OP_INFS;
    PooledDataSource pds;
    String mbeanName;
    MBeanServer mbs;
    ConnectionPoolDataSource cpds;
    DataSource unpooledDataSource;
    Map pdsAttrInfos;
    Map cpdsAttrInfos;
    Map unpooledDataSourceAttrInfos;
    static final /* synthetic */ boolean $assertionsDisabled;
    MBeanInfo info = null;
    PropertyChangeListener pcl = new PropertyChangeListener() { // from class: com.mchange.v2.c3p0.management.DynamicPooledDataSourceManagerMBean.1
        @Override // java.beans.PropertyChangeListener
        public void propertyChange(PropertyChangeEvent evt) {
            String propName = evt.getPropertyName();
            evt.getNewValue();
            if ("nestedDataSource".equals(propName) || "connectionPoolDataSource".equals(propName) || "dataSourceName".equals(propName)) {
                DynamicPooledDataSourceManagerMBean.this.reinitialize();
            }
        }
    };

    static {
        $assertionsDisabled = !DynamicPooledDataSourceManagerMBean.class.desiredAssertionStatus();
        logger = MLog.getLogger(DynamicPooledDataSourceManagerMBean.class);
        Set hpTmp = new HashSet();
        hpTmp.add("connectionPoolDataSource");
        hpTmp.add("nestedDataSource");
        hpTmp.add("reference");
        hpTmp.add("connection");
        hpTmp.add("password");
        hpTmp.add("pooledConnection");
        hpTmp.add("properties");
        hpTmp.add("logWriter");
        hpTmp.add("lastAcquisitionFailureDefaultUser");
        hpTmp.add("lastCheckoutFailureDefaultUser");
        hpTmp.add("lastCheckinFailureDefaultUser");
        hpTmp.add("lastIdleTestFailureDefaultUser");
        hpTmp.add("lastConnectionTestFailureDefaultUser");
        HIDE_PROPS = Collections.unmodifiableSet(hpTmp);
        Class[] userPassArgs = {String.class, String.class};
        Set hoTmp = new HashSet();
        try {
            hoTmp.add(PooledDataSource.class.getMethod("close", Boolean.TYPE));
            hoTmp.add(PooledDataSource.class.getMethod("getConnection", userPassArgs));
            hoTmp.add(PooledDataSource.class.getMethod("getLastAcquisitionFailure", userPassArgs));
            hoTmp.add(PooledDataSource.class.getMethod("getLastCheckinFailure", userPassArgs));
            hoTmp.add(PooledDataSource.class.getMethod("getLastCheckoutFailure", userPassArgs));
            hoTmp.add(PooledDataSource.class.getMethod("getLastIdleTestFailure", userPassArgs));
            hoTmp.add(PooledDataSource.class.getMethod("getLastConnectionTestFailure", userPassArgs));
        } catch (Exception e) {
            logger.log(MLevel.WARNING, "Tried to hide an operation from being exposed by mbean, but failed to find the operation!", (Throwable) e);
        }
        HIDE_OPS = Collections.unmodifiableSet(hoTmp);
        Set fropTmp = new HashSet();
        fropTmp.add("identityToken");
        FORCE_READ_ONLY_PROPS = Collections.unmodifiableSet(fropTmp);
        FORCE_OPS = Collections.unmodifiableSet(new HashSet());
        OP_INFS = extractOpInfs();
    }

    public DynamicPooledDataSourceManagerMBean(PooledDataSource pds, String mbeanName, MBeanServer mbs) throws Exception {
        this.pds = pds;
        this.mbeanName = mbeanName;
        this.mbs = mbs;
        if (pds instanceof AbstractComboPooledDataSource) {
            ((AbstractComboPooledDataSource) pds).addPropertyChangeListener(this.pcl);
        } else if (pds instanceof AbstractPoolBackedDataSource) {
            ((AbstractPoolBackedDataSource) pds).addPropertyChangeListener(this.pcl);
        } else {
            logger.warning(this + "managing an unexpected PooledDataSource. Only top-level attributes will be available. PooledDataSource: " + pds);
        }
        Exception e = reinitialize();
        if (e != null) {
            throw e;
        }
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:33:0x023d
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public synchronized java.lang.Exception reinitialize() {
        /*
        // Method dump skipped, instructions count: 663
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.management.DynamicPooledDataSourceManagerMBean.reinitialize():java.lang.Exception");
    }

    private static MBeanOperationInfo[] extractOpInfs() {
        MBeanParameterInfo[] pi;
        MBeanOperationInfo opi;
        MBeanParameterInfo[] userPass = {new MBeanParameterInfo("user", "java.lang.String", "The database username of a pool-owner."), new MBeanParameterInfo("password", "java.lang.String", "The database password of a pool-owner.")};
        MBeanParameterInfo[] empty = new MBeanParameterInfo[0];
        Method[] meths = PooledDataSource.class.getMethods();
        Set attrInfos = new TreeSet(ManagementUtils.OP_INFO_COMPARATOR);
        for (Method meth : meths) {
            if (!HIDE_OPS.contains(meth)) {
                String mname = meth.getName();
                Class[] params = meth.getParameterTypes();
                if (FORCE_OPS.contains(mname) || ((!mname.startsWith("set") || params.length != 1) && ((!mname.startsWith(BeanUtil.PREFIX_GETTER_GET) && !mname.startsWith(BeanUtil.PREFIX_GETTER_IS)) || params.length != 0))) {
                    Class retType = meth.getReturnType();
                    int impact = retType == Void.TYPE ? 1 : 0;
                    if (params.length == 2 && params[0] == String.class && params[1] == String.class) {
                        pi = userPass;
                    } else if (params.length == 0) {
                        pi = empty;
                    } else {
                        pi = null;
                    }
                    if (pi != null) {
                        opi = new MBeanOperationInfo(mname, (String) null, pi, retType.getName(), impact);
                    } else {
                        opi = new MBeanOperationInfo(meth.toString(), meth);
                    }
                    attrInfos.add(opi);
                }
            }
        }
        return (MBeanOperationInfo[]) attrInfos.toArray(new MBeanOperationInfo[attrInfos.size()]);
    }

    public synchronized Object getAttribute(String attr) throws AttributeNotFoundException, MBeanException, ReflectionException {
        try {
            AttrRec rec = attrRecForAttribute(attr);
            if (rec == null) {
                throw new AttributeNotFoundException(attr);
            }
            MBeanAttributeInfo ai = rec.attrInfo;
            if (!ai.isReadable()) {
                throw new IllegalArgumentException(attr + " not readable.");
            }
            String name = ai.getName();
            String mname = (ai.isIs() ? BeanUtil.PREFIX_GETTER_IS : BeanUtil.PREFIX_GETTER_GET) + Character.toUpperCase(name.charAt(0)) + name.substring(1);
            Object target = rec.target;
            return target.getClass().getMethod(mname, null).invoke(target, null);
        } catch (Exception e) {
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "Failed to get requested attribute: " + attr, (Throwable) e);
            }
            throw new MBeanException(e);
        }
    }

    public synchronized AttributeList getAttributes(String[] attrs) {
        AttributeList al = new AttributeList();
        for (String attr : attrs) {
            try {
                al.add(new Attribute(attr, getAttribute(attr)));
            } catch (Exception e) {
                if (logger.isLoggable(MLevel.WARNING)) {
                    logger.log(MLevel.WARNING, "Failed to get requested attribute (for list): " + attr, (Throwable) e);
                }
            }
        }
        return al;
    }

    private AttrRec attrRecForAttribute(String attr) {
        if (!$assertionsDisabled && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (this.pdsAttrInfos.containsKey(attr)) {
            return new AttrRec(this.pds, (MBeanAttributeInfo) this.pdsAttrInfos.get(attr));
        } else {
            if (this.cpdsAttrInfos.containsKey(attr)) {
                return new AttrRec(this.cpds, (MBeanAttributeInfo) this.cpdsAttrInfos.get(attr));
            }
            if (this.unpooledDataSourceAttrInfos.containsKey(attr)) {
                return new AttrRec(this.unpooledDataSource, (MBeanAttributeInfo) this.unpooledDataSourceAttrInfos.get(attr));
            }
            return null;
        }
    }

    public synchronized MBeanInfo getMBeanInfo() {
        if (this.info == null) {
            reinitialize();
        }
        return this.info;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005d, code lost:
        if (r0 != false) goto L_0x0060;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Object invoke(java.lang.String r8, java.lang.Object[] r9, java.lang.String[] r10) throws javax.management.MBeanException, javax.management.ReflectionException {
        /*
        // Method dump skipped, instructions count: 244
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.management.DynamicPooledDataSourceManagerMBean.invoke(java.lang.String, java.lang.Object[], java.lang.String[]):java.lang.Object");
    }

    public synchronized void setAttribute(Attribute attrObj) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
        try {
            String attr = attrObj.getName();
            Object curVal = getAttribute(attr);
            Object newVal = attrObj.getValue();
            if (!ObjectUtils.eqOrBothNull(curVal, newVal)) {
                if (attr == "factoryClassLocation") {
                    if (this.pds instanceof AbstractComboPooledDataSource) {
                        ((AbstractComboPooledDataSource) this.pds).setFactoryClassLocation((String) newVal);
                        return;
                    } else if (this.pds instanceof AbstractPoolBackedDataSource) {
                        String strval = (String) newVal;
                        AbstractPoolBackedDataSource apbds = (AbstractPoolBackedDataSource) this.pds;
                        apbds.setFactoryClassLocation(strval);
                        ConnectionPoolDataSource checkDs1 = apbds.getConnectionPoolDataSource();
                        if (checkDs1 instanceof WrapperConnectionPoolDataSource) {
                            WrapperConnectionPoolDataSource wcheckDs1 = (WrapperConnectionPoolDataSource) checkDs1;
                            wcheckDs1.setFactoryClassLocation(strval);
                            DataSource checkDs2 = wcheckDs1.getNestedDataSource();
                            if (checkDs2 instanceof DriverManagerDataSource) {
                                ((DriverManagerDataSource) checkDs2).setFactoryClassLocation(strval);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                AttrRec rec = attrRecForAttribute(attr);
                if (rec == null) {
                    throw new AttributeNotFoundException(attr);
                }
                MBeanAttributeInfo ai = rec.attrInfo;
                if (!ai.isWritable()) {
                    throw new IllegalArgumentException(attr + " not writable.");
                }
                Class attrType = ClassUtils.forName(rec.attrInfo.getType());
                String name = ai.getName();
                String mname = "set" + Character.toUpperCase(name.charAt(0)) + name.substring(1);
                Object target = rec.target;
                target.getClass().getMethod(mname, attrType).invoke(target, newVal);
                if (target != this.pds) {
                    if (this.pds instanceof AbstractPoolBackedDataSource) {
                        ((AbstractPoolBackedDataSource) this.pds).resetPoolManager(false);
                    } else if (logger.isLoggable(MLevel.WARNING)) {
                        logger.warning("MBean set a nested ConnectionPoolDataSource or DataSource parameter on an unknown PooledDataSource type. Could not reset the pool manager, so the changes may not take effect. c3p0 may need to be updated for PooledDataSource type " + this.pds.getClass() + Mapper.IGNORED_FIELDNAME);
                    }
                }
            }
        } catch (Exception e) {
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "Failed to set requested attribute: " + attrObj, (Throwable) e);
            }
            throw new MBeanException(e);
        }
    }

    public synchronized AttributeList setAttributes(AttributeList al) {
        AttributeList out = new AttributeList();
        int len = al.size();
        for (int i = 0; i < len; i++) {
            Attribute attrObj = (Attribute) al.get(i);
            try {
                setAttribute(attrObj);
                out.add(attrObj);
            } catch (Exception e) {
                if (logger.isLoggable(MLevel.WARNING)) {
                    logger.log(MLevel.WARNING, "Failed to set requested attribute (from list): " + attrObj, (Throwable) e);
                }
            }
        }
        return out;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:14:0x0088
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private static java.util.Map extractAttributeInfos(java.lang.Object r9) {
        /*
        // Method dump skipped, instructions count: 255
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.management.DynamicPooledDataSourceManagerMBean.extractAttributeInfos(java.lang.Object):java.util.Map");
    }

    private static String getDescription(String attrName) {
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: com.mchange.v2.c3p0.management.DynamicPooledDataSourceManagerMBean$AttrRec */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/management/DynamicPooledDataSourceManagerMBean$AttrRec.class */
    public static class AttrRec {
        Object target;
        MBeanAttributeInfo attrInfo;

        AttrRec(Object target, MBeanAttributeInfo attrInfo) {
            this.target = target;
            this.attrInfo = attrInfo;
        }
    }
}
