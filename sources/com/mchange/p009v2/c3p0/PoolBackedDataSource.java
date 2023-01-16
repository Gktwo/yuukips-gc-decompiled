package com.mchange.p009v2.c3p0;

import com.mchange.p009v2.c3p0.impl.AbstractPoolBackedDataSource;

/* renamed from: com.mchange.v2.c3p0.PoolBackedDataSource */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/PoolBackedDataSource.class */
public final class PoolBackedDataSource extends AbstractPoolBackedDataSource implements PooledDataSource {
    public PoolBackedDataSource(boolean autoregister) {
        super(autoregister);
    }

    public PoolBackedDataSource() {
        this(true);
    }

    public PoolBackedDataSource(String configName) {
        this();
        initializeNamedConfig(configName, false);
    }

    @Override // com.mchange.p009v2.c3p0.impl.AbstractPoolBackedDataSource
    public String toString(boolean show_config) {
        return toString();
    }
}
