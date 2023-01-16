package com.mongodb;

import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/DBObjectFactory.class */
interface DBObjectFactory {
    DBObject getInstance();

    DBObject getInstance(List<String> list);
}
