package com.mchange.p009v2.codegen.bean;

/* renamed from: com.mchange.v2.codegen.bean.SimpleClassInfo */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/SimpleClassInfo.class */
public class SimpleClassInfo implements ClassInfo {
    String packageName;
    int modifiers;
    String className;
    String superclassName;
    String[] interfaceNames;
    String[] generalImports;
    String[] specificImports;

    @Override // com.mchange.p009v2.codegen.bean.ClassInfo
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.mchange.p009v2.codegen.bean.ClassInfo
    public int getModifiers() {
        return this.modifiers;
    }

    @Override // com.mchange.p009v2.codegen.bean.ClassInfo
    public String getClassName() {
        return this.className;
    }

    @Override // com.mchange.p009v2.codegen.bean.ClassInfo
    public String getSuperclassName() {
        return this.superclassName;
    }

    @Override // com.mchange.p009v2.codegen.bean.ClassInfo
    public String[] getInterfaceNames() {
        return this.interfaceNames;
    }

    @Override // com.mchange.p009v2.codegen.bean.ClassInfo
    public String[] getGeneralImports() {
        return this.generalImports;
    }

    @Override // com.mchange.p009v2.codegen.bean.ClassInfo
    public String[] getSpecificImports() {
        return this.specificImports;
    }

    public SimpleClassInfo(String str, int i, String str2, String str3, String[] strArr, String[] strArr2, String[] strArr3) {
        this.packageName = str;
        this.modifiers = i;
        this.className = str2;
        this.superclassName = str3;
        this.interfaceNames = strArr;
        this.generalImports = strArr2;
        this.specificImports = strArr3;
    }
}
