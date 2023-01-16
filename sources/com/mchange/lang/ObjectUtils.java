package com.mchange.lang;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* loaded from: grasscutter.jar:com/mchange/lang/ObjectUtils.class */
public final class ObjectUtils {
    public static final Object DUMMY_OBJECT = new Object();

    private ObjectUtils() {
    }

    public static byte[] objectToByteArray(Object obj) throws NotSerializableException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
            return byteArrayOutputStream.toByteArray();
        } catch (NotSerializableException e) {
            e.fillInStackTrace();
            throw e;
        } catch (IOException e2) {
            e2.printStackTrace();
            throw new Error("IOException writing to a byte array!");
        }
    }

    public static Object objectFromByteArray(byte[] bArr) throws IOException, ClassNotFoundException {
        return new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
    }
}
