package com.mchange.p006v1.p007db.sql.schemarep;

import com.mchange.p006v1.identicator.Identicator;
import java.util.Arrays;

/* renamed from: com.mchange.v1.db.sql.schemarep.TypeRepIdenticator */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/schemarep/TypeRepIdenticator.class */
public class TypeRepIdenticator implements Identicator {
    private static final TypeRepIdenticator INSTANCE = new TypeRepIdenticator();

    public static TypeRepIdenticator getInstance() {
        return INSTANCE;
    }

    private TypeRepIdenticator() {
    }

    @Override // com.mchange.p006v1.identicator.Identicator
    public boolean identical(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        TypeRep typeRep = (TypeRep) obj;
        TypeRep typeRep2 = (TypeRep) obj2;
        return typeRep.getTypeCode() == typeRep2.getTypeCode() && Arrays.equals(typeRep.getTypeSize(), typeRep2.getTypeSize());
    }

    @Override // com.mchange.p006v1.identicator.Identicator
    public int hash(Object obj) {
        TypeRep typeRep = (TypeRep) obj;
        int typeCode = typeRep.getTypeCode();
        int[] typeSize = typeRep.getTypeSize();
        if (typeSize != null) {
            int length = typeSize.length;
            for (int i : typeSize) {
                typeCode ^= i;
            }
            typeCode ^= length;
        }
        return typeCode;
    }
}
