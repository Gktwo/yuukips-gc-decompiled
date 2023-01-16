package com.mchange.p006v1.xml;

import java.io.IOException;
import java.io.InputStream;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* renamed from: com.mchange.v1.xml.ResourceEntityResolver */
/* loaded from: grasscutter.jar:com/mchange/v1/xml/ResourceEntityResolver.class */
public class ResourceEntityResolver implements EntityResolver {

    /* renamed from: cl */
    ClassLoader f388cl;
    String prefix;

    public ResourceEntityResolver(ClassLoader classLoader, String str) {
        this.f388cl = classLoader;
        this.prefix = str;
    }

    public ResourceEntityResolver(Class cls) {
        this(cls.getClassLoader(), classToPrefix(cls));
    }

    @Override // org.xml.sax.EntityResolver
    public InputSource resolveEntity(String str, String str2) throws SAXException, IOException {
        if (str2 == null) {
            return null;
        }
        int lastIndexOf = str2.lastIndexOf(47);
        InputStream resourceAsStream = this.f388cl.getResourceAsStream(this.prefix + (lastIndexOf >= 0 ? str2.substring(lastIndexOf + 1) : str2));
        if (resourceAsStream == null) {
            return null;
        }
        return new InputSource(resourceAsStream);
    }

    private static String classToPrefix(Class cls) {
        String name = cls.getName();
        int lastIndexOf = name.lastIndexOf(46);
        String substring = lastIndexOf > 0 ? name.substring(0, lastIndexOf) : null;
        StringBuffer stringBuffer = new StringBuffer(256);
        if (substring != null) {
            stringBuffer.append(substring);
            int length = stringBuffer.length();
            for (int i = 0; i < length; i++) {
                if (stringBuffer.charAt(i) == '.') {
                    stringBuffer.setCharAt(i, '/');
                }
            }
            stringBuffer.append('/');
        }
        return stringBuffer.toString();
    }
}
