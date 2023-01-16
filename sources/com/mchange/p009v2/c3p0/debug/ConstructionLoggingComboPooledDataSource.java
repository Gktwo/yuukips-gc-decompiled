package com.mchange.p009v2.c3p0.debug;

import com.mchange.p009v2.c3p0.AbstractComboPooledDataSource;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.naming.Referenceable;

/* renamed from: com.mchange.v2.c3p0.debug.ConstructionLoggingComboPooledDataSource */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/debug/ConstructionLoggingComboPooledDataSource.class */
public final class ConstructionLoggingComboPooledDataSource extends AbstractComboPooledDataSource implements Serializable, Referenceable {
    static final MLogger logger = MLog.getLogger(ConstructionLoggingComboPooledDataSource.class);
    private static final long serialVersionUID = 1;
    private static final short VERSION = 1;

    public ConstructionLoggingComboPooledDataSource() {
        if (logger.isLoggable(MLevel.FINE)) {
            logger.log(MLevel.FINE, "Creation of ConstructionLoggingComboPooledDataSource.", (Throwable) new Exception("DEBUG STACK TRACE -- CREATION OF ConstructionLoggingComboPooledDataSource"));
        }
    }

    public ConstructionLoggingComboPooledDataSource(boolean autoregister) {
        super(autoregister);
        if (logger.isLoggable(MLevel.FINE)) {
            logger.log(MLevel.FINE, "Creation of ConstructionLoggingComboPooledDataSource.", (Throwable) new Exception("DEBUG STACK TRACE -- CREATION OF ConstructionLoggingComboPooledDataSource"));
        }
    }

    public ConstructionLoggingComboPooledDataSource(String configName) {
        super(configName);
        if (logger.isLoggable(MLevel.FINE)) {
            logger.log(MLevel.FINE, "Creation of ConstructionLoggingComboPooledDataSource.", (Throwable) new Exception("DEBUG STACK TRACE -- CREATION OF ConstructionLoggingComboPooledDataSource"));
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeShort(1);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        short version = ois.readShort();
        switch (version) {
            case 1:
                return;
            default:
                throw new IOException("Unsupported Serialized Version: " + ((int) version));
        }
    }
}
