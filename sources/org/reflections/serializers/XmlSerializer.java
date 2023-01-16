package org.reflections.serializers;

import java.io.InputStream;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.reflections.Reflections;
import org.reflections.ReflectionsException;
import org.reflections.Store;
import p001ch.qos.logback.core.joran.action.Action;

/* loaded from: grasscutter.jar:org/reflections/serializers/XmlSerializer.class */
public class XmlSerializer implements Serializer {
    @Override // org.reflections.serializers.Serializer
    public Reflections read(InputStream inputStream) {
        try {
            return new Reflections(new Store((Map) new SAXReader().read(inputStream).getRootElement().elements().stream().collect(Collectors.toMap((v0) -> {
                return v0.getName();
            }, index -> {
                return (Map) index.elements().stream().collect(Collectors.toMap(entry -> {
                    return entry.element(Action.KEY_ATTRIBUTE).getText();
                }, entry -> {
                    return (Set) entry.element("values").elements().stream().map((v0) -> {
                        return v0.getText();
                    }).collect(Collectors.toSet());
                }));
            }))));
        } catch (Exception e) {
            throw new ReflectionsException("could not read.", e);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:12:0x004f
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // org.reflections.serializers.Serializer
    public java.io.File save(org.reflections.Reflections r6, java.lang.String r7) {
        /*
            r5 = this;
            r0 = r7
            java.io.File r0 = org.reflections.serializers.Serializer.prepareFile(r0)
            r8 = r0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: Exception -> 0x0083
            r1 = r0
            r2 = r8
            r1.<init>(r2)     // Catch: Exception -> 0x0083
            r9 = r0
            r0 = 0
            r10 = r0
            org.dom4j.io.XMLWriter r0 = new org.dom4j.io.XMLWriter     // Catch: Throwable -> 0x004f, all -> 0x0058, Exception -> 0x0083
            r1 = r0
            r2 = r9
            org.dom4j.io.OutputFormat r3 = org.dom4j.io.OutputFormat.createPrettyPrint()     // Catch: Throwable -> 0x004f, all -> 0x0058, Exception -> 0x0083
            r1.<init>(r2, r3)     // Catch: Throwable -> 0x004f, all -> 0x0058, Exception -> 0x0083
            r1 = r5
            r2 = r6
            org.reflections.Store r2 = r2.getStore()     // Catch: Throwable -> 0x004f, all -> 0x0058, Exception -> 0x0083
            org.dom4j.Document r1 = r1.createDocument(r2)     // Catch: Throwable -> 0x004f, all -> 0x0058, Exception -> 0x0083
            r0.write(r1)     // Catch: Throwable -> 0x004f, all -> 0x0058, Exception -> 0x0083
            r0 = r9
            if (r0 == 0) goto L_0x0080
            r0 = r10
            if (r0 == 0) goto L_0x0047
            r0 = r9
            r0.close()     // Catch: Throwable -> 0x003b, Exception -> 0x0083
            goto L_0x0080
        L_0x003b:
            r11 = move-exception
            r0 = r10
            r1 = r11
            r0.addSuppressed(r1)     // Catch: Exception -> 0x0083
            goto L_0x0080
        L_0x0047:
            r0 = r9
            r0.close()     // Catch: Exception -> 0x0083
            goto L_0x0080
        L_0x004f:
            r11 = move-exception
            r0 = r11
            r10 = r0
            r0 = r11
            throw r0     // Catch: Exception -> 0x0083, all -> 0x0058
        L_0x0058:
            r12 = move-exception
            r0 = r9
            if (r0 == 0) goto L_0x007d
            r0 = r10
            if (r0 == 0) goto L_0x0078
            r0 = r9
            r0.close()     // Catch: Throwable -> 0x006c, Exception -> 0x0083
            goto L_0x007d
        L_0x006c:
            r13 = move-exception
            r0 = r10
            r1 = r13
            r0.addSuppressed(r1)     // Catch: Exception -> 0x0083
            goto L_0x007d
        L_0x0078:
            r0 = r9
            r0.close()     // Catch: Exception -> 0x0083
        L_0x007d:
            r0 = r12
            throw r0     // Catch: Exception -> 0x0083
        L_0x0080:
            goto L_0x00a2
        L_0x0083:
            r9 = move-exception
            org.reflections.ReflectionsException r0 = new org.reflections.ReflectionsException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "could not save to file "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r7
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r3 = r9
            r1.<init>(r2, r3)
            throw r0
        L_0x00a2:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.reflections.serializers.XmlSerializer.save(org.reflections.Reflections, java.lang.String):java.io.File");
    }

    private Document createDocument(Store store) {
        Document document = DocumentFactory.getInstance().createDocument();
        Element root = document.addElement("Reflections");
        store.forEach(index, map -> {
            Element indexElement = root.addElement(index);
            map.forEach(key, values -> {
                Element entryElement = indexElement.addElement("entry");
                entryElement.addElement(Action.KEY_ATTRIBUTE).setText(key);
                Element valuesElement = entryElement.addElement("values");
                values.forEach(value -> {
                    valuesElement.addElement("value").setText(value);
                });
            });
        });
        return document;
    }
}
