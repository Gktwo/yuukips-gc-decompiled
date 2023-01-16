package p000at.favre.lib.crypto.bcrypt;

/* renamed from: at.favre.lib.crypto.bcrypt.IllegalBCryptFormatException */
/* loaded from: grasscutter.jar:at/favre/lib/crypto/bcrypt/IllegalBCryptFormatException.class */
public class IllegalBCryptFormatException extends Exception {
    public IllegalBCryptFormatException(String s) {
        super(s);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return getMessage() + " - example of expected hash format: '$2a$06$If6bvum7DFjUnE9p2uDeDu0YHzrHM6tf.iqN8.yx.jNN1ILEf7h0i' which includes 16 bytes salt and 23 bytes hash value encoded in a base64 flavor";
    }
}
