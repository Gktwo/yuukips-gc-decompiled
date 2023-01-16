package org.bson;

import java.math.BigDecimal;
import org.bson.types.Decimal128;

/* loaded from: grasscutter.jar:org/bson/BsonDouble.class */
public class BsonDouble extends BsonNumber implements Comparable<BsonDouble> {
    private final double value;

    public BsonDouble(double value) {
        this.value = value;
    }

    public int compareTo(BsonDouble o) {
        return Double.compare(this.value, o.value);
    }

    @Override // org.bson.BsonValue
    public BsonType getBsonType() {
        return BsonType.DOUBLE;
    }

    public double getValue() {
        return this.value;
    }

    @Override // org.bson.BsonNumber
    public int intValue() {
        return (int) this.value;
    }

    @Override // org.bson.BsonNumber
    public long longValue() {
        return (long) this.value;
    }

    @Override // org.bson.BsonNumber
    public Decimal128 decimal128Value() {
        if (Double.isNaN(this.value)) {
            return Decimal128.NaN;
        }
        if (Double.isInfinite(this.value)) {
            return this.value > 0.0d ? Decimal128.POSITIVE_INFINITY : Decimal128.NEGATIVE_INFINITY;
        }
        return new Decimal128(new BigDecimal(this.value));
    }

    @Override // org.bson.BsonNumber
    public double doubleValue() {
        return this.value;
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && getClass() == o.getClass() && Double.compare(((BsonDouble) o).value, this.value) == 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        long temp = Double.doubleToLongBits(this.value);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override // java.lang.Object
    public String toString() {
        return "BsonDouble{value=" + this.value + '}';
    }
}
