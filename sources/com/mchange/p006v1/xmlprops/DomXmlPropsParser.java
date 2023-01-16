package com.mchange.p006v1.xmlprops;

import com.mchange.p006v1.xml.ResourceEntityResolver;
import com.mchange.p006v1.xml.StdErrErrorHandler;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;

/* renamed from: com.mchange.v1.xmlprops.DomXmlPropsParser */
/* loaded from: grasscutter.jar:com/mchange/v1/xmlprops/DomXmlPropsParser.class */
public class DomXmlPropsParser {
    static final String XMLPROPS_NAMESPACE_URI = "http://www.mchange.com/namespaces/xmlprops";
    static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    static {
        factory.setNamespaceAware(true);
        factory.setValidating(true);
    }

    public Properties parseXmlProps(InputStream inputStream) throws XmlPropsException {
        return parseXmlProps(new InputSource(inputStream), new ResourceEntityResolver(getClass()), new StdErrErrorHandler());
    }

    private Properties parseXmlProps(InputSource inputSource, EntityResolver entityResolver, ErrorHandler errorHandler) throws XmlPropsException {
        try {
            Properties properties = new Properties();
            DocumentBuilder newDocumentBuilder = factory.newDocumentBuilder();
            newDocumentBuilder.setEntityResolver(entityResolver);
            newDocumentBuilder.setErrorHandler(errorHandler);
            NodeList elementsByTagName = newDocumentBuilder.parse(inputSource).getDocumentElement().getElementsByTagName("property");
            int length = elementsByTagName.getLength();
            for (int i = 0; i < length; i++) {
                Element element = (Element) elementsByTagName.item(i);
                String attribute = element.getAttribute("name");
                StringBuffer stringBuffer = new StringBuffer();
                NodeList childNodes = element.getChildNodes();
                int length2 = childNodes.getLength();
                for (int i2 = 0; i2 < length2; i2++) {
                    Node item = childNodes.item(i2);
                    if (item.getNodeType() == 3) {
                        stringBuffer.append(item.getNodeValue());
                    }
                }
                properties.put(attribute, stringBuffer.toString());
            }
            return properties;
        } catch (Exception e) {
            e.printStackTrace();
            throw new XmlPropsException(e);
        }
    }

    public static void main(String[] strArr) {
        try {
            Properties parseXmlProps = new DomXmlPropsParser().parseXmlProps(new BufferedInputStream(new FileInputStream(strArr[0])));
            for (String str : parseXmlProps.keySet()) {
                System.err.println(str + '=' + parseXmlProps.getProperty(str));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
