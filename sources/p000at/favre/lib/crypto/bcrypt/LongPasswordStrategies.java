package p000at.favre.lib.crypto.bcrypt;

import p000at.favre.lib.crypto.bcrypt.LongPasswordStrategy;

/* renamed from: at.favre.lib.crypto.bcrypt.LongPasswordStrategies */
/* loaded from: grasscutter.jar:at/favre/lib/crypto/bcrypt/LongPasswordStrategies.class */
public final class LongPasswordStrategies {
    private LongPasswordStrategies() {
    }

    public static LongPasswordStrategy truncate() {
        return new LongPasswordStrategy.TruncateStrategy(71);
    }

    public static LongPasswordStrategy hashSha512() {
        return new LongPasswordStrategy.Sha512DerivationStrategy(71);
    }

    public static LongPasswordStrategy strict() {
        return new LongPasswordStrategy.StrictMaxPasswordLengthStrategy(71);
    }
}
