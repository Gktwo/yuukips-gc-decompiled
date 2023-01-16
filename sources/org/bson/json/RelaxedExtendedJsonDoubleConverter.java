package org.bson.json;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/RelaxedExtendedJsonDoubleConverter.class */
public class RelaxedExtendedJsonDoubleConverter implements Converter<Double> {
    private static final Converter<Double> FALLBACK_CONVERTER = new ExtendedJsonDoubleConverter();

    public void convert(Double value, StrictJsonWriter writer) {
        if (value.isNaN() || value.isInfinite()) {
            FALLBACK_CONVERTER.convert(value, writer);
        } else {
            writer.writeNumber(Double.toString(value.doubleValue()));
        }
    }
}
