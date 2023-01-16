package p000at.favre.lib.bytes;

import java.util.List;

/* renamed from: at.favre.lib.bytes.BytesValidator */
/* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesValidator.class */
public interface BytesValidator {
    boolean validate(byte[] bArr);

    /* renamed from: at.favre.lib.bytes.BytesValidator$Length */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesValidator$Length.class */
    public static final class Length implements BytesValidator {
        private final int refLength;
        private final Mode mode;

        /* renamed from: at.favre.lib.bytes.BytesValidator$Length$Mode */
        /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesValidator$Length$Mode.class */
        enum Mode {
            SMALLER_OR_EQ_THAN,
            GREATER_OR_EQ_THAN,
            EXACT
        }

        public Length(int refLength, Mode mode) {
            this.refLength = refLength;
            this.mode = mode;
        }

        @Override // p000at.favre.lib.bytes.BytesValidator
        public boolean validate(byte[] byteArrayToValidate) {
            switch (this.mode) {
                case GREATER_OR_EQ_THAN:
                    return byteArrayToValidate.length >= this.refLength;
                case SMALLER_OR_EQ_THAN:
                    return byteArrayToValidate.length <= this.refLength;
                case EXACT:
                default:
                    return byteArrayToValidate.length == this.refLength;
            }
        }
    }

    /* renamed from: at.favre.lib.bytes.BytesValidator$IdenticalContent */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesValidator$IdenticalContent.class */
    public static final class IdenticalContent implements BytesValidator {
        private final byte refByte;
        private final Mode mode;

        /* access modifiers changed from: package-private */
        /* renamed from: at.favre.lib.bytes.BytesValidator$IdenticalContent$Mode */
        /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesValidator$IdenticalContent$Mode.class */
        public enum Mode {
            ONLY_OF,
            NONE_OF,
            NOT_ONLY_OF
        }

        /* access modifiers changed from: package-private */
        public IdenticalContent(byte refByte, Mode mode) {
            this.refByte = refByte;
            this.mode = mode;
        }

        @Override // p000at.favre.lib.bytes.BytesValidator
        public boolean validate(byte[] byteArrayToValidate) {
            for (byte b : byteArrayToValidate) {
                if (this.mode == Mode.NONE_OF && b == this.refByte) {
                    return false;
                }
                if (this.mode == Mode.ONLY_OF && b != this.refByte) {
                    return false;
                }
                if (this.mode == Mode.NOT_ONLY_OF && b != this.refByte) {
                    return true;
                }
            }
            return this.mode == Mode.NONE_OF || this.mode == Mode.ONLY_OF;
        }
    }

    /* renamed from: at.favre.lib.bytes.BytesValidator$PrePostFix */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesValidator$PrePostFix.class */
    public static final class PrePostFix implements BytesValidator {
        private final byte[] pfix;
        private final boolean startsWith;

        public PrePostFix(boolean startsWith, byte... pfix) {
            this.pfix = pfix;
            this.startsWith = startsWith;
        }

        @Override // p000at.favre.lib.bytes.BytesValidator
        public boolean validate(byte[] byteArrayToValidate) {
            if (this.pfix.length > byteArrayToValidate.length) {
                return false;
            }
            for (int i = 0; i < this.pfix.length; i++) {
                if (this.startsWith && this.pfix[i] != byteArrayToValidate[i]) {
                    return false;
                }
                if (!(this.startsWith || this.pfix[i] == byteArrayToValidate[(byteArrayToValidate.length - this.pfix.length) + i])) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: at.favre.lib.bytes.BytesValidator$Logical */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesValidator$Logical.class */
    public static final class Logical implements BytesValidator {
        private final List<BytesValidator> validatorList;
        private final Operator operator;

        /* access modifiers changed from: package-private */
        /* renamed from: at.favre.lib.bytes.BytesValidator$Logical$Operator */
        /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesValidator$Logical$Operator.class */
        public enum Operator {
            OR,
            AND,
            NOT
        }

        public Logical(List<BytesValidator> validatorList, Operator operator) {
            if (validatorList.isEmpty()) {
                throw new IllegalArgumentException("must contain at least 1 element");
            } else if (operator != Operator.NOT || validatorList.size() == 1) {
                this.validatorList = validatorList;
                this.operator = operator;
            } else {
                throw new IllegalArgumentException("not operator can only be applied to single element");
            }
        }

        @Override // p000at.favre.lib.bytes.BytesValidator
        public boolean validate(byte[] byteArrayToValidate) {
            if (this.operator == Operator.NOT) {
                return !this.validatorList.get(0).validate(byteArrayToValidate);
            }
            boolean bool = this.operator != Operator.OR;
            for (BytesValidator bytesValidator : this.validatorList) {
                switch (this.operator) {
                    case AND:
                        bool &= bytesValidator.validate(byteArrayToValidate);
                        break;
                    case OR:
                    default:
                        bool |= bytesValidator.validate(byteArrayToValidate);
                        break;
                }
            }
            return bool;
        }
    }
}
