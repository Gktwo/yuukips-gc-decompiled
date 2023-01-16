package com.mchange.p009v2.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/* renamed from: com.mchange.v2.util.PropertiesUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/util/PropertiesUtils.class */
public final class PropertiesUtils {
    public static int getIntProperty(Properties properties, String str, int i) throws NumberFormatException {
        String property = properties.getProperty(str);
        return property != null ? Integer.parseInt(property) : i;
    }

    public static Properties fromString(String str, String str2) throws UnsupportedEncodingException {
        try {
            Properties properties = new Properties();
            if (str != null) {
                properties.load(new ByteArrayInputStream(str.getBytes(str2)));
            }
            return properties;
        } catch (UnsupportedEncodingException e) {
            throw e;
        } catch (IOException e2) {
            throw new Error("Huh? An IOException while working with byte array streams?!", e2);
        }
    }

    public static Properties fromString(String str) {
        try {
            return fromString(str, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new Error("Huh? An ISO-8859-1 is an unsupported encoding?!", e);
        }
    }

    public static String toString(Properties properties, String str, String str2) throws UnsupportedEncodingException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            properties.store(byteArrayOutputStream, str);
            byteArrayOutputStream.flush();
            return new String(byteArrayOutputStream.toByteArray(), str2);
        } catch (UnsupportedEncodingException e) {
            throw e;
        } catch (IOException e2) {
            throw new Error("Huh? An IOException while working with byte array streams?!", e2);
        }
    }

    public static String toString(Properties properties, String str) {
        try {
            return toString(properties, str, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new Error("Huh? An ISO-8859-1 is an unsupported encoding?!", e);
        }
    }

    private PropertiesUtils() {
    }
}
