package p000at.favre.lib.bytes;

import java.util.Arrays;
import java.util.Collections;
import p000at.favre.lib.bytes.BytesValidator;

/* renamed from: at.favre.lib.bytes.BytesValidators */
/* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesValidators.class */
public final class BytesValidators {
    private BytesValidators() {
    }

    public static BytesValidator atLeast(int byteLength) {
        return new BytesValidator.Length(byteLength, BytesValidator.Length.Mode.GREATER_OR_EQ_THAN);
    }

    public static BytesValidator atMost(int byteLength) {
        return new BytesValidator.Length(byteLength, BytesValidator.Length.Mode.SMALLER_OR_EQ_THAN);
    }

    public static BytesValidator exactLength(int byteLength) {
        return new BytesValidator.Length(byteLength, BytesValidator.Length.Mode.EXACT);
    }

    public static BytesValidator onlyOf(byte refByte) {
        return new BytesValidator.IdenticalContent(refByte, BytesValidator.IdenticalContent.Mode.ONLY_OF);
    }

    public static BytesValidator notOnlyOf(byte refByte) {
        return new BytesValidator.IdenticalContent(refByte, BytesValidator.IdenticalContent.Mode.NOT_ONLY_OF);
    }

    public static BytesValidator startsWith(byte... startsWithBytes) {
        return new BytesValidator.PrePostFix(true, startsWithBytes);
    }

    public static BytesValidator endsWith(byte... endsWithBytes) {
        return new BytesValidator.PrePostFix(false, endsWithBytes);
    }

    public static BytesValidator noneOf(byte refByte) {
        return new BytesValidator.IdenticalContent(refByte, BytesValidator.IdenticalContent.Mode.NONE_OF);
    }

    /* renamed from: or */
    public static BytesValidator m1593or(BytesValidator... validators) {
        return new BytesValidator.Logical(Arrays.asList(validators), BytesValidator.Logical.Operator.OR);
    }

    public static BytesValidator and(BytesValidator... validators) {
        return new BytesValidator.Logical(Arrays.asList(validators), BytesValidator.Logical.Operator.AND);
    }

    public static BytesValidator not(BytesValidator validator) {
        return new BytesValidator.Logical(Collections.singletonList(validator), BytesValidator.Logical.Operator.NOT);
    }
}
