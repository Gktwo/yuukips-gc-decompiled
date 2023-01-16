package com.mchange.p006v1.p007db.sql.schemarep;

/* renamed from: com.mchange.v1.db.sql.schemarep.TypeRepImpl */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/schemarep/TypeRepImpl.class */
public final class TypeRepImpl implements TypeRep {
    int type_code;
    int[] typeSize;

    public TypeRepImpl(int i, int[] iArr) {
        this.type_code = i;
        this.typeSize = iArr;
    }

    @Override // com.mchange.p006v1.p007db.sql.schemarep.TypeRep
    public int getTypeCode() {
        return this.type_code;
    }

    @Override // com.mchange.p006v1.p007db.sql.schemarep.TypeRep
    public int[] getTypeSize() {
        return this.typeSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TypeRep) {
            return TypeRepIdenticator.getInstance().identical(this, obj);
        }
        return false;
    }

    public int hashCode() {
        return TypeRepIdenticator.getInstance().hash(this);
    }
}
