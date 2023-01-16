package com.mchange.p009v2.management;

import java.util.Comparator;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;

/* renamed from: com.mchange.v2.management.ManagementUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/management/ManagementUtils.class */
public class ManagementUtils {
    public static final Comparator PARAM_INFO_COMPARATOR = new Comparator() { // from class: com.mchange.v2.management.ManagementUtils.1
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            MBeanParameterInfo mBeanParameterInfo = (MBeanParameterInfo) obj;
            MBeanParameterInfo mBeanParameterInfo2 = (MBeanParameterInfo) obj2;
            int compareTo = mBeanParameterInfo.getType().compareTo(mBeanParameterInfo2.getType());
            if (compareTo == 0) {
                compareTo = mBeanParameterInfo.getName().compareTo(mBeanParameterInfo2.getName());
                if (compareTo == 0) {
                    String description = mBeanParameterInfo.getDescription();
                    String description2 = mBeanParameterInfo2.getDescription();
                    if (description == null && description2 == null) {
                        compareTo = 0;
                    } else if (description == null) {
                        compareTo = -1;
                    } else if (description2 == null) {
                        compareTo = 1;
                    } else {
                        compareTo = description.compareTo(description2);
                    }
                }
            }
            return compareTo;
        }
    };
    public static final Comparator OP_INFO_COMPARATOR = new Comparator() { // from class: com.mchange.v2.management.ManagementUtils.2
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            MBeanOperationInfo mBeanOperationInfo = (MBeanOperationInfo) obj;
            MBeanOperationInfo mBeanOperationInfo2 = (MBeanOperationInfo) obj2;
            String name = mBeanOperationInfo.getName();
            String name2 = mBeanOperationInfo2.getName();
            int compare = String.CASE_INSENSITIVE_ORDER.compare(name, name2);
            if (compare == 0) {
                if (name.equals(name2)) {
                    MBeanParameterInfo[] signature = mBeanOperationInfo.getSignature();
                    MBeanParameterInfo[] signature2 = mBeanOperationInfo2.getSignature();
                    if (signature.length < signature2.length) {
                        compare = -1;
                    } else if (signature.length > signature2.length) {
                        compare = 1;
                    } else {
                        int length = signature.length;
                        for (int i = 0; i < length; i++) {
                            compare = ManagementUtils.PARAM_INFO_COMPARATOR.compare(signature[i], signature2[i]);
                            if (compare != 0) {
                                break;
                            }
                        }
                    }
                } else {
                    compare = name.compareTo(name2);
                }
            }
            return compare;
        }
    };
}
