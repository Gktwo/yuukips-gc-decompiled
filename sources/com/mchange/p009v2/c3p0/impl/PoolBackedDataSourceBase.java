package com.mchange.p009v2.c3p0.impl;

import com.mchange.p009v2.c3p0.C3P0Registry;
import com.mchange.p009v2.c3p0.cfg.C3P0Config;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.naming.JavaBeanReferenceMaker;
import com.mchange.p009v2.naming.ReferenceIndirector;
import com.mchange.p009v2.ser.IndirectlySerialized;
import com.mchange.p009v2.ser.SerializableUtils;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.sql.ConnectionPoolDataSource;

/* renamed from: com.mchange.v2.c3p0.impl.PoolBackedDataSourceBase */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/PoolBackedDataSourceBase.class */
public class PoolBackedDataSourceBase extends IdentityTokenResolvable implements Referenceable, Serializable {
    private ConnectionPoolDataSource connectionPoolDataSource;
    private volatile String identityToken;
    private static final long serialVersionUID = 1;
    private static final short VERSION = 1;
    static final JavaBeanReferenceMaker referenceMaker = new JavaBeanReferenceMaker();
    protected PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    protected VetoableChangeSupport vcs = new VetoableChangeSupport(this);
    private String dataSourceName = C3P0Config.initializeStringPropertyVar("dataSourceName", C3P0Defaults.dataSourceName());
    private Map extensions = C3P0Config.initializeExtensions();
    private String factoryClassLocation = C3P0Config.initializeStringPropertyVar("factoryClassLocation", C3P0Defaults.factoryClassLocation());
    private int numHelperThreads = C3P0Config.initializeIntPropertyVar("numHelperThreads", C3P0Defaults.numHelperThreads());

    protected PropertyChangeSupport getPropertyChangeSupport() {
        return this.pcs;
    }

    protected VetoableChangeSupport getVetoableChangeSupport() {
        return this.vcs;
    }

    public synchronized ConnectionPoolDataSource getConnectionPoolDataSource() {
        return this.connectionPoolDataSource;
    }

    public synchronized void setConnectionPoolDataSource(ConnectionPoolDataSource connectionPoolDataSource) throws PropertyVetoException {
        ConnectionPoolDataSource oldVal = this.connectionPoolDataSource;
        if (!eqOrBothNull(oldVal, connectionPoolDataSource)) {
            this.vcs.fireVetoableChange("connectionPoolDataSource", oldVal, connectionPoolDataSource);
        }
        this.connectionPoolDataSource = connectionPoolDataSource;
        if (!eqOrBothNull(oldVal, connectionPoolDataSource)) {
            this.pcs.firePropertyChange("connectionPoolDataSource", oldVal, connectionPoolDataSource);
        }
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public synchronized String getDataSourceName() {
        return this.dataSourceName;
    }

    public synchronized void setDataSourceName(String dataSourceName) {
        String oldVal = this.dataSourceName;
        this.dataSourceName = dataSourceName;
        if (!eqOrBothNull(oldVal, dataSourceName)) {
            this.pcs.firePropertyChange("dataSourceName", oldVal, dataSourceName);
        }
    }

    public synchronized Map getExtensions() {
        return Collections.unmodifiableMap(this.extensions);
    }

    public synchronized void setExtensions(Map extensions) {
        this.extensions = Collections.unmodifiableMap(extensions);
    }

    public synchronized String getFactoryClassLocation() {
        return this.factoryClassLocation;
    }

    public synchronized void setFactoryClassLocation(String factoryClassLocation) {
        this.factoryClassLocation = factoryClassLocation;
    }

    @Override // com.mchange.p009v2.c3p0.impl.IdentityTokenized
    public String getIdentityToken() {
        return this.identityToken;
    }

    @Override // com.mchange.p009v2.c3p0.impl.IdentityTokenized
    public void setIdentityToken(String identityToken) {
        String oldVal = this.identityToken;
        this.identityToken = identityToken;
        if (!eqOrBothNull(oldVal, identityToken)) {
            this.pcs.firePropertyChange("identityToken", oldVal, identityToken);
        }
    }

    public synchronized int getNumHelperThreads() {
        return this.numHelperThreads;
    }

    public synchronized void setNumHelperThreads(int numHelperThreads) {
        int oldVal = this.numHelperThreads;
        this.numHelperThreads = numHelperThreads;
        if (oldVal != numHelperThreads) {
            this.pcs.firePropertyChange("numHelperThreads", oldVal, numHelperThreads);
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        this.pcs.addPropertyChangeListener(pcl);
    }

    public void addPropertyChangeListener(String propName, PropertyChangeListener pcl) {
        this.pcs.addPropertyChangeListener(propName, pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        this.pcs.removePropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(String propName, PropertyChangeListener pcl) {
        this.pcs.removePropertyChangeListener(propName, pcl);
    }

    public PropertyChangeListener[] getPropertyChangeListeners() {
        return this.pcs.getPropertyChangeListeners();
    }

    public void addVetoableChangeListener(VetoableChangeListener vcl) {
        this.vcs.addVetoableChangeListener(vcl);
    }

    public void removeVetoableChangeListener(VetoableChangeListener vcl) {
        this.vcs.removeVetoableChangeListener(vcl);
    }

    public VetoableChangeListener[] getVetoableChangeListeners() {
        return this.vcs.getVetoableChangeListeners();
    }

    private boolean eqOrBothNull(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeShort(1);
        try {
            SerializableUtils.toByteArray(this.connectionPoolDataSource);
            oos.writeObject(this.connectionPoolDataSource);
        } catch (NotSerializableException nse) {
            MLog.getLogger(getClass()).log(MLevel.FINE, "Direct serialization provoked a NotSerializableException! Trying indirect.", (Throwable) nse);
            try {
                oos.writeObject(new ReferenceIndirector().indirectForm(this.connectionPoolDataSource));
            } catch (IOException indirectionIOException) {
                throw indirectionIOException;
            } catch (Exception indirectionOtherException) {
                throw new IOException("Problem indirectly serializing connectionPoolDataSource: " + indirectionOtherException.toString());
            }
        }
        oos.writeObject(this.dataSourceName);
        try {
            SerializableUtils.toByteArray(this.extensions);
            oos.writeObject(this.extensions);
        } catch (NotSerializableException nse2) {
            MLog.getLogger(getClass()).log(MLevel.FINE, "Direct serialization provoked a NotSerializableException! Trying indirect.", (Throwable) nse2);
            try {
                oos.writeObject(new ReferenceIndirector().indirectForm(this.extensions));
            } catch (IOException indirectionIOException2) {
                throw indirectionIOException2;
            } catch (Exception indirectionOtherException2) {
                throw new IOException("Problem indirectly serializing extensions: " + indirectionOtherException2.toString());
            }
        }
        oos.writeObject(this.factoryClassLocation);
        oos.writeObject(this.identityToken);
        oos.writeInt(this.numHelperThreads);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        short version = ois.readShort();
        switch (version) {
            case 1:
                Object o = ois.readObject();
                if (o instanceof IndirectlySerialized) {
                    o = ((IndirectlySerialized) o).getObject();
                }
                this.connectionPoolDataSource = (ConnectionPoolDataSource) o;
                this.dataSourceName = (String) ois.readObject();
                Object o2 = ois.readObject();
                if (o2 instanceof IndirectlySerialized) {
                    o2 = ((IndirectlySerialized) o2).getObject();
                }
                this.extensions = (Map) o2;
                this.factoryClassLocation = (String) ois.readObject();
                this.identityToken = (String) ois.readObject();
                this.numHelperThreads = ois.readInt();
                this.pcs = new PropertyChangeSupport(this);
                this.vcs = new VetoableChangeSupport(this);
                return;
            default:
                throw new IOException("Unsupported Serialized Version: " + ((int) version));
        }
    }

    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return C3P0ImplUtils.PARENT_LOGGER;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(toString());
        sb.append(" [ ");
        sb.append("connectionPoolDataSource -> " + this.connectionPoolDataSource);
        sb.append(", ");
        sb.append("dataSourceName -> " + this.dataSourceName);
        sb.append(", ");
        sb.append("extensions -> " + this.extensions);
        sb.append(", ");
        sb.append("factoryClassLocation -> " + this.factoryClassLocation);
        sb.append(", ");
        sb.append("identityToken -> " + this.identityToken);
        sb.append(", ");
        sb.append("numHelperThreads -> " + this.numHelperThreads);
        String extraToStringInfo = extraToStringInfo();
        if (extraToStringInfo != null) {
            sb.append(extraToStringInfo);
        }
        sb.append(" ]");
        return sb.toString();
    }

    protected String extraToStringInfo() {
        return null;
    }

    static {
        referenceMaker.setFactoryClassName("com.mchange.v2.c3p0.impl.C3P0JavaBeanObjectFactory");
        referenceMaker.addReferenceProperty("connectionPoolDataSource");
        referenceMaker.addReferenceProperty("dataSourceName");
        referenceMaker.addReferenceProperty("extensions");
        referenceMaker.addReferenceProperty("factoryClassLocation");
        referenceMaker.addReferenceProperty("identityToken");
        referenceMaker.addReferenceProperty("numHelperThreads");
    }

    public Reference getReference() throws NamingException {
        return referenceMaker.createReference(this);
    }

    private PoolBackedDataSourceBase() {
    }

    public PoolBackedDataSourceBase(boolean autoregister) {
        if (autoregister) {
            this.identityToken = C3P0ImplUtils.allocateIdentityToken(this);
            C3P0Registry.reregister(this);
        }
    }
}
