package com.mchange.p009v2.cfg;

import com.mchange.p009v2.cfg.DelayedLogItem;
import com.mchange.p009v2.cfg.PropertiesConfigSource;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Properties;

/* renamed from: com.mchange.v2.cfg.BasicPropertiesConfigSource */
/* loaded from: grasscutter.jar:com/mchange/v2/cfg/BasicPropertiesConfigSource.class */
public final class BasicPropertiesConfigSource implements PropertiesConfigSource {
    @Override // com.mchange.p009v2.cfg.PropertiesConfigSource
    public PropertiesConfigSource.Parse propertiesFromSource(String str) throws FileNotFoundException, Exception {
        InputStream resourceAsStream = MultiPropertiesConfig.class.getResourceAsStream(str);
        if (resourceAsStream != null) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(resourceAsStream);
            Properties properties = new Properties();
            LinkedList linkedList = new LinkedList();
            try {
                properties.load(bufferedInputStream);
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e) {
                        linkedList.add(new DelayedLogItem(DelayedLogItem.Level.WARNING, "An IOException occurred while closing InputStream from resource path '" + str + "'.", e));
                    }
                }
                return new PropertiesConfigSource.Parse(properties, linkedList);
            } catch (Throwable th) {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                        linkedList.add(new DelayedLogItem(DelayedLogItem.Level.WARNING, "An IOException occurred while closing InputStream from resource path '" + str + "'.", e2));
                        throw th;
                    }
                }
                throw th;
            }
        } else {
            throw new FileNotFoundException(String.format("Resource not found at path '%s'.", str));
        }
    }
}
