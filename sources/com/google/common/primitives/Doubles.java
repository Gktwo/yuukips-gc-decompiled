package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.regex.Pattern;
import org.jline.reader.impl.LineReaderImpl;
import org.slf4j.Marker;

@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/primitives/Doubles.class */
public final class Doubles {
    public static final int BYTES = 8;
    @GwtIncompatible
    static final Pattern FLOATING_POINT_PATTERN = fpPattern();

    private Doubles() {
    }

    public static int hashCode(double value) {
        return Double.valueOf(value).hashCode();
    }

    public static int compare(double a, double b) {
        return Double.compare(a, b);
    }

    public static boolean isFinite(double value) {
        return Double.NEGATIVE_INFINITY < value && value < Double.POSITIVE_INFINITY;
    }

    public static boolean contains(double[] array, double target) {
        for (double value : array) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }

    public static int indexOf(double[] array, double target) {
        return indexOf(array, target, 0, array.length);
    }

    /* access modifiers changed from: private */
    public static int indexOf(double[] array, double target, int start, int end) {
        for (int i = start; i < end; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        r7 = r7 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int indexOf(double[] r5, double[] r6) {
        /*
            r0 = r5
            java.lang.String r1 = "array"
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0, r1)
            r0 = r6
            java.lang.String r1 = "target"
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0, r1)
            r0 = r6
            int r0 = r0.length
            if (r0 != 0) goto L_0x0015
            r0 = 0
            return r0
        L_0x0015:
            r0 = 0
            r7 = r0
        L_0x0017:
            r0 = r7
            r1 = r5
            int r1 = r1.length
            r2 = r6
            int r2 = r2.length
            int r1 = r1 - r2
            r2 = 1
            int r1 = r1 + r2
            if (r0 >= r1) goto L_0x0047
            r0 = 0
            r8 = r0
        L_0x0024:
            r0 = r8
            r1 = r6
            int r1 = r1.length
            if (r0 >= r1) goto L_0x003f
            r0 = r5
            r1 = r7
            r2 = r8
            int r1 = r1 + r2
            r0 = r0[r1]
            r1 = r6
            r2 = r8
            r1 = r1[r2]
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0039
            goto L_0x0041
        L_0x0039:
            int r8 = r8 + 1
            goto L_0x0024
        L_0x003f:
            r0 = r7
            return r0
        L_0x0041:
            int r7 = r7 + 1
            goto L_0x0017
        L_0x0047:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Doubles.indexOf(double[], double[]):int");
    }

    public static int lastIndexOf(double[] array, double target) {
        return lastIndexOf(array, target, 0, array.length);
    }

    /* access modifiers changed from: private */
    public static int lastIndexOf(double[] array, double target, int start, int end) {
        for (int i = end - 1; i >= start; i--) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: double[] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v9, types: [double] */
    public static double min(double... array) {
        Preconditions.checkArgument(array.length > 0);
        char c = array[0];
        for (int i = 1; i < array.length; i++) {
            c = Math.min((double) c, (double) array[i]);
        }
        return c;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: double[] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v9, types: [double] */
    public static double max(double... array) {
        Preconditions.checkArgument(array.length > 0);
        char c = array[0];
        for (int i = 1; i < array.length; i++) {
            c = Math.max((double) c, (double) array[i]);
        }
        return c;
    }

    @Beta
    public static double constrainToRange(double value, double min, double max) {
        Preconditions.checkArgument(min <= max, "min (%s) must be less than or equal to max (%s)", Double.valueOf(min), Double.valueOf(max));
        return Math.min(Math.max(value, min), max);
    }

    public static double[] concat(double[]... arrays) {
        int length = 0;
        for (double[] array : arrays) {
            length += array.length;
        }
        double[] result = new double[length];
        int pos = 0;
        for (double[] array2 : arrays) {
            System.arraycopy(array2, 0, result, pos, array2.length);
            pos += array2.length;
        }
        return result;
    }

    /* loaded from: grasscutter.jar:com/google/common/primitives/Doubles$DoubleConverter.class */
    private static final class DoubleConverter extends Converter<String, Double> implements Serializable {
        static final DoubleConverter INSTANCE = new DoubleConverter();
        private static final long serialVersionUID = 1;

        private DoubleConverter() {
        }

        /* access modifiers changed from: protected */
        public Double doForward(String value) {
            return Double.valueOf(value);
        }

        /* access modifiers changed from: protected */
        public String doBackward(Double value) {
            return value.toString();
        }

        @Override // java.lang.Object
        public String toString() {
            return "Doubles.stringConverter()";
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    @Beta
    public static Converter<String, Double> stringConverter() {
        return DoubleConverter.INSTANCE;
    }

    public static double[] ensureCapacity(double[] array, int minLength, int padding) {
        Preconditions.checkArgument(minLength >= 0, "Invalid minLength: %s", minLength);
        Preconditions.checkArgument(padding >= 0, "Invalid padding: %s", padding);
        return array.length < minLength ? Arrays.copyOf(array, minLength + padding) : array;
    }

    public static String join(String separator, double... array) {
        Preconditions.checkNotNull(separator);
        if (array.length == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder(array.length * 12);
        builder.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            builder.append(separator).append(array[i]);
        }
        return builder.toString();
    }

    public static Comparator<double[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    /* loaded from: grasscutter.jar:com/google/common/primitives/Doubles$LexicographicalComparator.class */
    private enum LexicographicalComparator implements Comparator<double[]> {
        INSTANCE;

        public int compare(double[] left, double[] right) {
            int minLength = Math.min(left.length, right.length);
            for (int i = 0; i < minLength; i++) {
                int result = Double.compare(left[i], right[i]);
                if (result != 0) {
                    return result;
                }
            }
            return left.length - right.length;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return "Doubles.lexicographicalComparator()";
        }
    }

    public static void sortDescending(double[] array) {
        Preconditions.checkNotNull(array);
        sortDescending(array, 0, array.length);
    }

    public static void sortDescending(double[] array, int fromIndex, int toIndex) {
        Preconditions.checkNotNull(array);
        Preconditions.checkPositionIndexes(fromIndex, toIndex, array.length);
        Arrays.sort(array, fromIndex, toIndex);
        reverse(array, fromIndex, toIndex);
    }

    public static void reverse(double[] array) {
        Preconditions.checkNotNull(array);
        reverse(array, 0, array.length);
    }

    public static void reverse(double[] array, int fromIndex, int toIndex) {
        Preconditions.checkNotNull(array);
        Preconditions.checkPositionIndexes(fromIndex, toIndex, array.length);
        int i = fromIndex;
        for (int j = toIndex - 1; i < j; j--) {
            double tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
        }
    }

    public static double[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof DoubleArrayAsList) {
            return ((DoubleArrayAsList) collection).toDoubleArray();
        }
        Object[] boxedArray = collection.toArray();
        int len = boxedArray.length;
        double[] array = new double[len];
        for (int i = 0; i < len; i++) {
            array[i] = ((Number) Preconditions.checkNotNull(boxedArray[i])).doubleValue();
        }
        return array;
    }

    public static List<Double> asList(double... backingArray) {
        if (backingArray.length == 0) {
            return Collections.emptyList();
        }
        return new DoubleArrayAsList(backingArray);
    }

    @GwtCompatible
    /* loaded from: grasscutter.jar:com/google/common/primitives/Doubles$DoubleArrayAsList.class */
    private static class DoubleArrayAsList extends AbstractList<Double> implements RandomAccess, Serializable {
        final double[] array;
        final int start;
        final int end;
        private static final long serialVersionUID = 0;

        DoubleArrayAsList(double[] array) {
            this(array, 0, array.length);
        }

        DoubleArrayAsList(double[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public Double get(int index) {
            Preconditions.checkElementIndex(index, size());
            return Double.valueOf(this.array[this.start + index]);
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Spliterator.OfDouble spliterator() {
            return Spliterators.spliterator(this.array, this.start, this.end, 0);
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public boolean contains(Object target) {
            return (target instanceof Double) && Doubles.indexOf(this.array, ((Double) target).doubleValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object target) {
            int i;
            if (!(target instanceof Double) || (i = Doubles.indexOf(this.array, ((Double) target).doubleValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return i - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object target) {
            int i;
            if (!(target instanceof Double) || (i = Doubles.lastIndexOf(this.array, ((Double) target).doubleValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return i - this.start;
        }

        public Double set(int index, Double element) {
            Preconditions.checkElementIndex(index, size());
            double oldValue = this.array[this.start + index];
            this.array[this.start + index] = ((Double) Preconditions.checkNotNull(element)).doubleValue();
            return Double.valueOf(oldValue);
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int fromIndex, int toIndex) {
            Preconditions.checkPositionIndexes(fromIndex, toIndex, size());
            if (fromIndex == toIndex) {
                return Collections.emptyList();
            }
            return new DoubleArrayAsList(this.array, this.start + fromIndex, this.start + toIndex);
        }

        @Override // java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof DoubleArrayAsList)) {
                return equals(object);
            }
            DoubleArrayAsList that = (DoubleArrayAsList) object;
            int size = size();
            if (that.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.array[this.start + i] != that.array[that.start + i]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
        public int hashCode() {
            int result = 1;
            for (int i = this.start; i < this.end; i++) {
                result = (31 * result) + Doubles.hashCode(this.array[i]);
            }
            return result;
        }

        @Override // java.util.AbstractCollection, java.lang.Object
        public String toString() {
            StringBuilder builder = new StringBuilder(size() * 12);
            builder.append('[').append(this.array[this.start]);
            for (int i = this.start + 1; i < this.end; i++) {
                builder.append(", ").append(this.array[i]);
            }
            return builder.append(']').toString();
        }

        double[] toDoubleArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }
    }

    @GwtIncompatible
    private static Pattern fpPattern() {
        return Pattern.compile(("[+-]?(?:NaN|Infinity|" + ("(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)(?:[eE][+-]?\\d+#)?[fFdD]?") + "|" + ("0[xX](?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)[pP][+-]?\\d+#[fFdD]?") + ")").replace(LineReaderImpl.DEFAULT_COMMENT_BEGIN, Marker.ANY_NON_NULL_MARKER));
    }

    @Beta
    @GwtIncompatible
    public static Double tryParse(String string) {
        if (!FLOATING_POINT_PATTERN.matcher(string).matches()) {
            return null;
        }
        try {
            return Double.valueOf(Double.parseDouble(string));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
