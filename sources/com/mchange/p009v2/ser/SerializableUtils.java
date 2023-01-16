package com.mchange.p009v2.ser;

import com.mchange.p006v1.p008io.InputStreamUtils;
import com.mchange.p006v1.p008io.OutputStreamUtils;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* renamed from: com.mchange.v2.ser.SerializableUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/ser/SerializableUtils.class */
public final class SerializableUtils {
    static final MLogger logger = MLog.getLogger(SerializableUtils.class);

    private SerializableUtils() {
    }

    public static byte[] toByteArray(Object obj) throws NotSerializableException {
        return serializeToByteArray(obj);
    }

    public static byte[] toByteArray(Object obj, Indirector indirector, IndirectPolicy indirectPolicy) throws NotSerializableException {
        try {
            if (indirectPolicy == IndirectPolicy.DEFINITELY_INDIRECT) {
                if (indirector != null) {
                    return toByteArray(indirector.indirectForm(obj));
                }
                throw new IllegalArgumentException("null indirector is not consistent with " + indirectPolicy);
            } else if (indirectPolicy == IndirectPolicy.INDIRECT_ON_EXCEPTION) {
                if (indirector == null) {
                    throw new IllegalArgumentException("null indirector is not consistent with " + indirectPolicy);
                }
                try {
                    return toByteArray(obj);
                } catch (NotSerializableException e) {
                    return toByteArray(obj, indirector, IndirectPolicy.DEFINITELY_INDIRECT);
                }
            } else if (indirectPolicy == IndirectPolicy.DEFINITELY_DIRECT) {
                return toByteArray(obj);
            } else {
                throw new InternalError("unknown indirecting policy: " + indirectPolicy);
            }
        } catch (NotSerializableException e2) {
            throw e2;
        } catch (Exception e3) {
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "An Exception occurred while serializing an Object to a byte[] with an Indirector.", (Throwable) e3);
            }
            throw new NotSerializableException(e3.toString());
        }
    }

    public static byte[] serializeToByteArray(Object obj) throws NotSerializableException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
            return byteArrayOutputStream.toByteArray();
        } catch (NotSerializableException e) {
            e.fillInStackTrace();
            throw e;
        } catch (IOException e2) {
            if (logger.isLoggable(MLevel.SEVERE)) {
                logger.log(MLevel.SEVERE, "An IOException occurred while writing into a ByteArrayOutputStream?!?", (Throwable) e2);
            }
            throw new Error("IOException writing to a byte array!");
        }
    }

    public static Object fromByteArray(byte[] bArr) throws IOException, ClassNotFoundException {
        Object deserializeFromByteArray = deserializeFromByteArray(bArr);
        if (deserializeFromByteArray instanceof IndirectlySerialized) {
            return ((IndirectlySerialized) deserializeFromByteArray).getObject();
        }
        return deserializeFromByteArray;
    }

    public static Object fromByteArray(byte[] bArr, boolean z) throws IOException, ClassNotFoundException {
        if (z) {
            return deserializeFromByteArray(bArr);
        }
        return fromByteArray(bArr);
    }

    public static Object deserializeFromByteArray(byte[] bArr) throws IOException, ClassNotFoundException {
        return new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
    }

    public static Object testSerializeDeserialize(Object obj) throws IOException, ClassNotFoundException {
        return deepCopy(obj);
    }

    public static Object deepCopy(Object obj) throws IOException, ClassNotFoundException {
        return deserializeFromByteArray(serializeToByteArray(obj));
    }

    public static final Object unmarshallObjectFromFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            return objectInputStream.readObject();
        } finally {
            InputStreamUtils.attemptClose(objectInputStream);
        }
    }

    public static final void marshallObjectToFile(Object obj, File file) throws IOException {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            objectOutputStream.writeObject(obj);
        } finally {
            OutputStreamUtils.attemptClose(objectOutputStream);
        }
    }
}
