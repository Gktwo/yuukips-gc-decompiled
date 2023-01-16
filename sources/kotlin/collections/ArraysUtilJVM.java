package kotlin.collections;

import java.util.Arrays;
import java.util.List;

/* loaded from: grasscutter.jar:kotlin/collections/ArraysUtilJVM.class */
class ArraysUtilJVM {
    ArraysUtilJVM() {
    }

    /* access modifiers changed from: package-private */
    public static <T> List<T> asList(T[] array) {
        return Arrays.asList(array);
    }
}
