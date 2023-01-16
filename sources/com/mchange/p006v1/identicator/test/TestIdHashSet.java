package com.mchange.p006v1.identicator.test;

import com.mchange.p006v1.identicator.IdHashSet;
import com.mchange.p006v1.identicator.Identicator;

/* renamed from: com.mchange.v1.identicator.test.TestIdHashSet */
/* loaded from: grasscutter.jar:com/mchange/v1/identicator/test/TestIdHashSet.class */
public class TestIdHashSet {
    public static void main(String[] strArr) {
        IdHashSet idHashSet = new IdHashSet(new Identicator() { // from class: com.mchange.v1.identicator.test.TestIdHashSet.1
            @Override // com.mchange.p006v1.identicator.Identicator
            public boolean identical(Object obj, Object obj2) {
                return ((String) obj).charAt(0) == ((String) obj2).charAt(0);
            }

            @Override // com.mchange.p006v1.identicator.Identicator
            public int hash(Object obj) {
                return ((String) obj).charAt(0);
            }
        });
        System.out.println(idHashSet.add("hello"));
        System.out.println(idHashSet.add("world"));
        System.out.println(idHashSet.add("hi"));
        System.out.println(idHashSet.size());
        for (Object obj : idHashSet.toArray()) {
            System.out.println(obj);
        }
    }
}
