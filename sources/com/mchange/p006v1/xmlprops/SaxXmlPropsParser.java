package com.mchange.p006v1.xmlprops;

import com.mchange.p006v1.xml.StdErrErrorHandler;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* renamed from: com.mchange.v1.xmlprops.SaxXmlPropsParser */
/* loaded from: grasscutter.jar:com/mchange/v1/xmlprops/SaxXmlPropsParser.class */
public class SaxXmlPropsParser {
    static final String DEFAULT_XML_READER = "org.apache.xerces.parsers.SAXParser";
    static final String XMLPROPS_NAMESPACE_URI = "http://www.mchange.com/namespaces/xmlprops";

    public static Properties parseXmlProps(InputStream inputStream) throws XmlPropsException {
        try {
            return parseXmlProps(new InputSource(inputStream), (XMLReader) Class.forName(DEFAULT_XML_READER).newInstance(), null, null);
        } catch (XmlPropsException e) {
            throw e;
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new XmlPropsException("Exception while instantiating XMLReader.", e2);
        }
    }

    private static Properties parseXmlProps(InputSource inputSource, XMLReader xMLReader, EntityResolver entityResolver, ErrorHandler errorHandler) throws XmlPropsException {
        if (entityResolver != null) {
            try {
                xMLReader.setEntityResolver(entityResolver);
            } catch (Exception e) {
                if (e instanceof SAXException) {
                    ((SAXException) e).getException().printStackTrace();
                }
                e.printStackTrace();
                throw new XmlPropsException(e);
            }
        }
        if (errorHandler == null) {
            errorHandler = new StdErrErrorHandler();
        }
        xMLReader.setErrorHandler(errorHandler);
        XmlPropsContentHandler xmlPropsContentHandler = new XmlPropsContentHandler();
        xMLReader.setContentHandler(xmlPropsContentHandler);
        xMLReader.parse(inputSource);
        return xmlPropsContentHandler.getLastProperties();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v1.xmlprops.SaxXmlPropsParser$XmlPropsContentHandler */
    /* loaded from: grasscutter.jar:com/mchange/v1/xmlprops/SaxXmlPropsParser$XmlPropsContentHandler.class */
    public static class XmlPropsContentHandler implements ContentHandler {
        Locator locator;
        Properties props;
        String name;
        StringBuffer valueBuf;

        XmlPropsContentHandler() {
        }

        @Override // org.xml.sax.ContentHandler
        public void setDocumentLocator(Locator locator) {
            this.locator = locator;
        }

        @Override // org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
            this.props = new Properties();
        }

        @Override // org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            System.err.println("--> startElement( " + str + ", " + str2 + ", " + attributes + ")");
            if ((str.equals("") || str.equals(SaxXmlPropsParser.XMLPROPS_NAMESPACE_URI)) && str2.equals("property")) {
                this.name = attributes.getValue(str, "name");
                this.valueBuf = new StringBuffer();
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) throws SAXException {
            if (this.valueBuf != null) {
                this.valueBuf.append(cArr, i, i2);
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
            if (this.valueBuf != null) {
                this.valueBuf.append(cArr, i, i2);
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            if ((str.equals("") || str.equals(SaxXmlPropsParser.XMLPROPS_NAMESPACE_URI)) && str2.equals("property")) {
                System.err.println("NAME: " + this.name);
                this.props.put(this.name, this.valueBuf.toString());
                this.valueBuf = null;
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void endDocument() throws SAXException {
        }

        @Override // org.xml.sax.ContentHandler
        public void startPrefixMapping(String str, String str2) throws SAXException {
        }

        @Override // org.xml.sax.ContentHandler
        public void endPrefixMapping(String str) throws SAXException {
        }

        @Override // org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) throws SAXException {
        }

        @Override // org.xml.sax.ContentHandler
        public void skippedEntity(String str) throws SAXException {
        }

        public Properties getLastProperties() {
            return this.props;
        }
    }

    public static void main(String[] strArr) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(strArr[0]));
            new SaxXmlPropsParser();
            Properties parseXmlProps = parseXmlProps(bufferedInputStream);
            for (String str : parseXmlProps.keySet()) {
                System.err.println(str + '=' + parseXmlProps.getProperty(str));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
