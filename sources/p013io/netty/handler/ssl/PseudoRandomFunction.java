package p013io.netty.handler.ssl;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import p013io.netty.util.internal.EmptyArrays;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.ssl.PseudoRandomFunction */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/PseudoRandomFunction.class */
final class PseudoRandomFunction {
    private PseudoRandomFunction() {
    }

    static byte[] hash(byte[] secret, byte[] label, byte[] seed, int length, String algo) {
        ObjectUtil.checkPositiveOrZero(length, "length");
        try {
            Mac hmac = Mac.getInstance(algo);
            hmac.init(new SecretKeySpec(secret, algo));
            int iterations = (int) Math.ceil(((double) length) / ((double) hmac.getMacLength()));
            byte[] expansion = EmptyArrays.EMPTY_BYTES;
            byte[] data = concat(label, seed);
            byte[] A = data;
            for (int i = 0; i < iterations; i++) {
                A = hmac.doFinal(A);
                expansion = concat(expansion, hmac.doFinal(concat(A, data)));
            }
            return Arrays.copyOf(expansion, length);
        } catch (GeneralSecurityException e) {
            throw new IllegalArgumentException("Could not find algo: " + algo, e);
        }
    }

    private static byte[] concat(byte[] first, byte[] second) {
        byte[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
}
