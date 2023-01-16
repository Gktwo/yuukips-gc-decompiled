package com.mchange.p006v1.xml;

import com.mchange.p006v1.util.DebugUtils;
import java.util.ArrayList;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/* renamed from: com.mchange.v1.xml.DomParseUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/xml/DomParseUtils.class */
public final class DomParseUtils {
    static final boolean DEBUG = true;

    public static String allTextFromUniqueChild(Element element, String str) throws DOMException {
        return allTextFromUniqueChild(element, str, false);
    }

    public static String allTextFromUniqueChild(Element element, String str, boolean z) throws DOMException {
        Element uniqueChildByTagName = uniqueChildByTagName(element, str);
        if (uniqueChildByTagName == null) {
            return null;
        }
        return allTextFromElement(uniqueChildByTagName, z);
    }

    public static Element uniqueChild(Element element, String str) throws DOMException {
        return uniqueChildByTagName(element, str);
    }

    public static Element uniqueChildByTagName(Element element, String str) throws DOMException {
        NodeList elementsByTagName = element.getElementsByTagName(str);
        int length = elementsByTagName.getLength();
        DebugUtils.myAssert(length <= 1, "There is more than one (" + length + ") child with tag name: " + str + "!!!");
        if (length == 1) {
            return (Element) elementsByTagName.item(0);
        }
        return null;
    }

    public static String allText(Element element) throws DOMException {
        return allTextFromElement(element);
    }

    public static String allText(Element element, boolean z) throws DOMException {
        return allTextFromElement(element, z);
    }

    public static String allTextFromElement(Element element) throws DOMException {
        return allTextFromElement(element, false);
    }

    public static String allTextFromElement(Element element, boolean z) throws DOMException {
        StringBuffer stringBuffer = new StringBuffer();
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            Node item = childNodes.item(i);
            if (item instanceof Text) {
                stringBuffer.append(item.getNodeValue());
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        return z ? stringBuffer2.trim() : stringBuffer2;
    }

    public static String[] allTextFromImmediateChildElements(Element element, String str) throws DOMException {
        return allTextFromImmediateChildElements(element, str, false);
    }

    public static String[] allTextFromImmediateChildElements(Element element, String str, boolean z) throws DOMException {
        NodeList immediateChildElementsByTagName = immediateChildElementsByTagName(element, str);
        int length = immediateChildElementsByTagName.getLength();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = allText((Element) immediateChildElementsByTagName.item(i), z);
        }
        return strArr;
    }

    public static NodeList immediateChildElementsByTagName(Element element, String str) throws DOMException {
        return getImmediateChildElementsByTagName(element, str);
    }

    public static NodeList getImmediateChildElementsByTagName(Element element, String str) throws DOMException {
        final ArrayList arrayList = new ArrayList();
        for (Node firstChild = element.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if ((firstChild instanceof Element) && ((Element) firstChild).getTagName().equals(str)) {
                arrayList.add(firstChild);
            }
        }
        return new NodeList() { // from class: com.mchange.v1.xml.DomParseUtils.1
            @Override // org.w3c.dom.NodeList
            public int getLength() {
                return arrayList.size();
            }

            @Override // org.w3c.dom.NodeList
            public Node item(int i) {
                return (Node) arrayList.get(i);
            }
        };
    }

    public static String allTextFromUniqueImmediateChild(Element element, String str) throws DOMException {
        Element uniqueImmediateChildByTagName = uniqueImmediateChildByTagName(element, str);
        if (uniqueImmediateChildByTagName == null) {
            return null;
        }
        return allTextFromElement(uniqueImmediateChildByTagName);
    }

    public static Element uniqueImmediateChild(Element element, String str) throws DOMException {
        return uniqueImmediateChildByTagName(element, str);
    }

    public static Element uniqueImmediateChildByTagName(Element element, String str) throws DOMException {
        NodeList immediateChildElementsByTagName = getImmediateChildElementsByTagName(element, str);
        int length = immediateChildElementsByTagName.getLength();
        DebugUtils.myAssert(length <= 1, "There is more than one (" + length + ") child with tag name: " + str + "!!!");
        if (length == 1) {
            return (Element) immediateChildElementsByTagName.item(0);
        }
        return null;
    }

    public static String attrValFromElement(Element element, String str) throws DOMException {
        Attr attributeNode = element.getAttributeNode(str);
        if (attributeNode == null) {
            return null;
        }
        return attributeNode.getValue();
    }

    private DomParseUtils() {
    }
}
