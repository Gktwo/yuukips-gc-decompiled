package com.mchange.p009v2.codegen.bean;

/* renamed from: com.mchange.v2.codegen.bean.ClassInfo */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/ClassInfo.class */
public interface ClassInfo {
    String getPackageName();

    int getModifiers();

    String getClassName();

    String getSuperclassName();

    String[] getInterfaceNames();

    String[] getGeneralImports();

    String[] getSpecificImports();
}
