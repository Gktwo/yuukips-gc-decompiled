package com.mchange.p009v2.codegen.bean;

import java.io.IOException;
import java.io.Writer;

/* renamed from: com.mchange.v2.codegen.bean.PropertyBeanGenerator */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/PropertyBeanGenerator.class */
public interface PropertyBeanGenerator {
    void generate(ClassInfo classInfo, Property[] propertyArr, Writer writer) throws IOException;
}
