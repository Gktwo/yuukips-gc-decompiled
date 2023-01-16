package org.quartz.impl.jdbcjobstore;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/TablePrefixAware.class */
public interface TablePrefixAware {
    void setTablePrefix(String str);

    void setSchedName(String str);
}
