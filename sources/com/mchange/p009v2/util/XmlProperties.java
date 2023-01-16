package com.mchange.p009v2.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/* renamed from: com.mchange.v2.util.XmlProperties */
/* loaded from: grasscutter.jar:com/mchange/v2/util/XmlProperties.class */
public class XmlProperties extends Properties {
    static final String DTD_SYSTEM_ID = "http://www.mchange.com/dtd/xml-properties.dtd";
    static final String DTD_RSRC_PATH = "dtd/xml-properties.dtd";
    DocumentBuilder docBuilder;
    Transformer identityTransformer = TransformerFactory.newInstance().newTransformer();
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !XmlProperties.class.desiredAssertionStatus();
    }

    public XmlProperties() throws ParserConfigurationException, TransformerConfigurationException {
        C09441 r0 = new EntityResolver() { // from class: com.mchange.v2.util.XmlProperties.1
            @Override // org.xml.sax.EntityResolver
            public InputSource resolveEntity(String str, String str2) {
                if (XmlProperties.DTD_SYSTEM_ID.equals(str2)) {
                    return new InputSource(XmlProperties.class.getResourceAsStream(XmlProperties.DTD_RSRC_PATH));
                }
                return null;
            }
        };
        C09452 r02 = new ErrorHandler() { // from class: com.mchange.v2.util.XmlProperties.2
            @Override // org.xml.sax.ErrorHandler
            public void warning(SAXParseException sAXParseException) throws SAXException {
                System.err.println("[Warning] " + sAXParseException.toString());
            }

            @Override // org.xml.sax.ErrorHandler
            public void error(SAXParseException sAXParseException) throws SAXException {
                System.err.println("[Error] " + sAXParseException.toString());
            }

            @Override // org.xml.sax.ErrorHandler
            public void fatalError(SAXParseException sAXParseException) throws SAXException {
                System.err.println("[Fatal Error] " + sAXParseException.toString());
            }
        };
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setValidating(true);
        newInstance.setCoalescing(true);
        newInstance.setIgnoringComments(true);
        this.docBuilder = newInstance.newDocumentBuilder();
        this.docBuilder.setEntityResolver(r0);
        this.docBuilder.setErrorHandler(r02);
        this.identityTransformer.setOutputProperty("indent", "yes");
        this.identityTransformer.setOutputProperty("doctype-system", DTD_SYSTEM_ID);
    }

    public synchronized void loadXml(InputStream inputStream) throws IOException, SAXException {
        NodeList elementsByTagName = this.docBuilder.parse(inputStream).getElementsByTagName("property");
        int length = elementsByTagName.getLength();
        for (int i = 0; i < length; i++) {
            extractProperty(elementsByTagName.item(i));
        }
    }

    private void extractProperty(Node node) {
        Element element = (Element) node;
        Object attribute = element.getAttribute("name");
        boolean booleanValue = Boolean.valueOf(element.getAttribute("trim")).booleanValue();
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        if ($assertionsDisabled || (length >= 0 && length <= 1)) {
            String nodeValue = length == 0 ? "" : ((Text) childNodes.item(0)).getNodeValue();
            if (booleanValue) {
                nodeValue = nodeValue.trim();
            }
            put(attribute, nodeValue);
            return;
        }
        throw new AssertionError("Bad number of children of property element: " + length);
    }

    public synchronized void saveXml(OutputStream outputStream) throws IOException, TransformerException {
        storeXml(outputStream, null);
    }

    public synchronized void storeXml(OutputStream outputStream, String str) throws IOException, TransformerException {
        Document newDocument = this.docBuilder.newDocument();
        if (str != null) {
            newDocument.appendChild(newDocument.createComment(str));
        }
        Element createElement = newDocument.createElement("xml-properties");
        for (String str2 : keySet()) {
            Element createElement2 = newDocument.createElement("property");
            createElement2.setAttribute("name", str2);
            createElement2.appendChild(newDocument.createTextNode((String) get(str2)));
            createElement.appendChild(createElement2);
        }
        newDocument.appendChild(createElement);
        this.identityTransformer.transform(new DOMSource(newDocument), new StreamResult(outputStream));
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r7) {
        /*
            r0 = 0
            r8 = r0
            r0 = 0
            r9 = r0
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch: Exception -> 0x006a, all -> 0x0092
            r1 = r0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: Exception -> 0x006a, all -> 0x0092
            r3 = r2
            r4 = r7
            r5 = 0
            r4 = r4[r5]     // Catch: Exception -> 0x006a, all -> 0x0092
            r3.<init>(r4)     // Catch: Exception -> 0x006a, all -> 0x0092
            r1.<init>(r2)     // Catch: Exception -> 0x006a, all -> 0x0092
            r8 = r0
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch: Exception -> 0x006a, all -> 0x0092
            r1 = r0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: Exception -> 0x006a, all -> 0x0092
            r3 = r2
            r4 = r7
            r5 = 1
            r4 = r4[r5]     // Catch: Exception -> 0x006a, all -> 0x0092
            r3.<init>(r4)     // Catch: Exception -> 0x006a, all -> 0x0092
            r1.<init>(r2)     // Catch: Exception -> 0x006a, all -> 0x0092
            r9 = r0
            com.mchange.v2.util.XmlProperties r0 = new com.mchange.v2.util.XmlProperties     // Catch: Exception -> 0x006a, all -> 0x0092
            r1 = r0
            r1.<init>()     // Catch: Exception -> 0x006a, all -> 0x0092
            r10 = r0
            r0 = r10
            r1 = r8
            r0.loadXml(r1)     // Catch: Exception -> 0x006a, all -> 0x0092
            r0 = r10
            java.io.PrintStream r1 = java.lang.System.out     // Catch: Exception -> 0x006a, all -> 0x0092
            r0.list(r1)     // Catch: Exception -> 0x006a, all -> 0x0092
            r0 = r10
            r1 = r9
            java.lang.String r2 = "This is the resaved test document."
            r0.storeXml(r1, r2)     // Catch: Exception -> 0x006a, all -> 0x0092
            r0 = r9
            r0.flush()     // Catch: Exception -> 0x006a, all -> 0x0092
            r0 = r8
            if (r0 == 0) goto L_0x004f
            r0 = r8
            r0.close()     // Catch: Exception -> 0x0052
        L_0x004f:
            goto L_0x0057
        L_0x0052:
            r10 = move-exception
            r0 = r10
            r0.printStackTrace()
        L_0x0057:
            r0 = r9
            if (r0 == 0) goto L_0x005f
            r0 = r9
            r0.close()     // Catch: Exception -> 0x0062
        L_0x005f:
            goto L_0x00bb
        L_0x0062:
            r10 = move-exception
            r0 = r10
            r0.printStackTrace()
            goto L_0x00bb
        L_0x006a:
            r10 = move-exception
            r0 = r10
            r0.printStackTrace()     // Catch: all -> 0x0092
            r0 = r8
            if (r0 == 0) goto L_0x0077
            r0 = r8
            r0.close()     // Catch: Exception -> 0x007a
        L_0x0077:
            goto L_0x007f
        L_0x007a:
            r10 = move-exception
            r0 = r10
            r0.printStackTrace()
        L_0x007f:
            r0 = r9
            if (r0 == 0) goto L_0x0087
            r0 = r9
            r0.close()     // Catch: Exception -> 0x008a
        L_0x0087:
            goto L_0x00bb
        L_0x008a:
            r10 = move-exception
            r0 = r10
            r0.printStackTrace()
            goto L_0x00bb
        L_0x0092:
            r11 = move-exception
            r0 = r8
            if (r0 == 0) goto L_0x009c
            r0 = r8
            r0.close()     // Catch: Exception -> 0x009f
        L_0x009c:
            goto L_0x00a6
        L_0x009f:
            r12 = move-exception
            r0 = r12
            r0.printStackTrace()
        L_0x00a6:
            r0 = r9
            if (r0 == 0) goto L_0x00ae
            r0 = r9
            r0.close()     // Catch: Exception -> 0x00b1
        L_0x00ae:
            goto L_0x00b8
        L_0x00b1:
            r12 = move-exception
            r0 = r12
            r0.printStackTrace()
        L_0x00b8:
            r0 = r11
            throw r0
        L_0x00bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.util.XmlProperties.main(java.lang.String[]):void");
    }
}
