package com.mchange.p005io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* renamed from: com.mchange.io.SerializableUtils */
/* loaded from: grasscutter.jar:com/mchange/io/SerializableUtils.class */
public final class SerializableUtils {
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

    private SerializableUtils() {
    }
}
