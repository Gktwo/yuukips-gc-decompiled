package com.mongodb.management;

/* loaded from: grasscutter.jar:com/mongodb/management/ConnectionPoolStatisticsMBean.class */
public interface ConnectionPoolStatisticsMBean {
    String getHost();

    int getPort();

    int getMinSize();

    int getMaxSize();

    int getSize();

    int getCheckedOutCount();
}
