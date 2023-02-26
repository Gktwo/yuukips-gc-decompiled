package com.mongodb;

import java.util.List;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/DBObjectFactory.class */
public interface DBObjectFactory {
    DBObject getInstance();

    DBObject getInstance(List<String> list);
}
