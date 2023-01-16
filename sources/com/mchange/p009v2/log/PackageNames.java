package com.mchange.p009v2.log;

/* renamed from: com.mchange.v2.log.PackageNames */
/* loaded from: grasscutter.jar:com/mchange/v2/log/PackageNames.class */
public class PackageNames implements NameTransformer {
    @Override // com.mchange.p009v2.log.NameTransformer
    public String transformName(String str) {
        return null;
    }

    @Override // com.mchange.p009v2.log.NameTransformer
    public String transformName(Class cls) {
        String name = cls.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf <= 0) {
            return "";
        }
        return name.substring(0, lastIndexOf);
    }

    @Override // com.mchange.p009v2.log.NameTransformer
    public String transformName() {
        return null;
    }
}
