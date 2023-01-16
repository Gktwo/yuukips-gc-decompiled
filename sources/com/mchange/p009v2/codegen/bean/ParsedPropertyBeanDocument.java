package com.mchange.p009v2.codegen.bean;

import com.mchange.p006v1.xml.DomParseUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* renamed from: com.mchange.v2.codegen.bean.ParsedPropertyBeanDocument */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/ParsedPropertyBeanDocument.class */
public class ParsedPropertyBeanDocument {
    static final String[] EMPTY_SA = new String[0];
    String packageName;
    int class_modifiers;
    String className;
    String superclassName;
    String[] interfaceNames;
    String[] generalImports;
    String[] specificImports;
    Property[] properties;

    public ParsedPropertyBeanDocument(Document document) {
        this.interfaceNames = EMPTY_SA;
        this.generalImports = EMPTY_SA;
        this.specificImports = EMPTY_SA;
        Element documentElement = document.getDocumentElement();
        this.packageName = DomParseUtils.allTextFromUniqueChild(documentElement, "package");
        Element uniqueImmediateChild = DomParseUtils.uniqueImmediateChild(documentElement, "modifiers");
        if (uniqueImmediateChild != null) {
            this.class_modifiers = parseModifiers(uniqueImmediateChild);
        } else {
            this.class_modifiers = 1;
        }
        Element uniqueChild = DomParseUtils.uniqueChild(documentElement, "imports");
        if (uniqueChild != null) {
            this.generalImports = DomParseUtils.allTextFromImmediateChildElements(uniqueChild, "general");
            this.specificImports = DomParseUtils.allTextFromImmediateChildElements(uniqueChild, "specific");
        }
        this.className = DomParseUtils.allTextFromUniqueChild(documentElement, "output-class");
        this.superclassName = DomParseUtils.allTextFromUniqueChild(documentElement, "extends");
        Element uniqueChild2 = DomParseUtils.uniqueChild(documentElement, "implements");
        if (uniqueChild2 != null) {
            this.interfaceNames = DomParseUtils.allTextFromImmediateChildElements(uniqueChild2, "interface");
        }
        this.properties = findProperties(DomParseUtils.uniqueChild(documentElement, "properties"));
    }

    public ClassInfo getClassInfo() {
        return new ClassInfo() { // from class: com.mchange.v2.codegen.bean.ParsedPropertyBeanDocument.1
            @Override // com.mchange.p009v2.codegen.bean.ClassInfo
            public String getPackageName() {
                return ParsedPropertyBeanDocument.this.packageName;
            }

            @Override // com.mchange.p009v2.codegen.bean.ClassInfo
            public int getModifiers() {
                return ParsedPropertyBeanDocument.this.class_modifiers;
            }

            @Override // com.mchange.p009v2.codegen.bean.ClassInfo
            public String getClassName() {
                return ParsedPropertyBeanDocument.this.className;
            }

            @Override // com.mchange.p009v2.codegen.bean.ClassInfo
            public String getSuperclassName() {
                return ParsedPropertyBeanDocument.this.superclassName;
            }

            @Override // com.mchange.p009v2.codegen.bean.ClassInfo
            public String[] getInterfaceNames() {
                return ParsedPropertyBeanDocument.this.interfaceNames;
            }

            @Override // com.mchange.p009v2.codegen.bean.ClassInfo
            public String[] getGeneralImports() {
                return ParsedPropertyBeanDocument.this.generalImports;
            }

            @Override // com.mchange.p009v2.codegen.bean.ClassInfo
            public String[] getSpecificImports() {
                return ParsedPropertyBeanDocument.this.specificImports;
            }
        };
    }

    public Property[] getProperties() {
        return (Property[]) this.properties.clone();
    }

    private Property[] findProperties(Element element) {
        NodeList immediateChildElementsByTagName = DomParseUtils.immediateChildElementsByTagName(element, "property");
        int length = immediateChildElementsByTagName.getLength();
        Property[] propertyArr = new Property[length];
        for (int i = 0; i < length; i++) {
            Element element2 = (Element) immediateChildElementsByTagName.item(i);
            propertyArr[i] = new SimpleProperty(modifiersThroughParentElem(element2, "variable", 2), DomParseUtils.allTextFromUniqueChild(element2, "name", true), DomParseUtils.allTextFromUniqueChild(element2, "type", true), DomParseUtils.allTextFromUniqueChild(element2, "defensive-copy", true), DomParseUtils.allTextFromUniqueChild(element2, "default-value", true), modifiersThroughParentElem(element2, "getter", 1), modifiersThroughParentElem(element2, "setter", 1), DomParseUtils.uniqueChild(element2, "read-only") != null, DomParseUtils.uniqueChild(element2, "bound") != null, DomParseUtils.uniqueChild(element2, "constrained") != null);
        }
        return propertyArr;
    }

    private static int modifiersThroughParentElem(Element element, String str, int i) {
        Element uniqueChild = DomParseUtils.uniqueChild(element, str);
        if (uniqueChild == null) {
            return i;
        }
        Element uniqueChild2 = DomParseUtils.uniqueChild(uniqueChild, "modifiers");
        if (uniqueChild2 != null) {
            return parseModifiers(uniqueChild2);
        }
        return i;
    }

    private static int parseModifiers(Element element) {
        int i;
        int i2;
        int i3 = 0;
        String[] allTextFromImmediateChildElements = DomParseUtils.allTextFromImmediateChildElements(element, "modifier", true);
        for (String str : allTextFromImmediateChildElements) {
            if ("public".equals(str)) {
                i2 = i3;
                i = 1;
            } else if ("protected".equals(str)) {
                i2 = i3;
                i = 4;
            } else if ("private".equals(str)) {
                i2 = i3;
                i = 2;
            } else if ("final".equals(str)) {
                i2 = i3;
                i = 16;
            } else if ("abstract".equals(str)) {
                i2 = i3;
                i = 1024;
            } else if ("static".equals(str)) {
                i2 = i3;
                i = 8;
            } else if ("synchronized".equals(str)) {
                i2 = i3;
                i = 32;
            } else if ("volatile".equals(str)) {
                i2 = i3;
                i = 64;
            } else if ("transient".equals(str)) {
                i2 = i3;
                i = 128;
            } else if ("strictfp".equals(str)) {
                i2 = i3;
                i = 2048;
            } else if ("native".equals(str)) {
                i2 = i3;
                i = 256;
            } else if ("interface".equals(str)) {
                i2 = i3;
                i = 512;
            } else {
                throw new IllegalArgumentException("Bad modifier: " + str);
            }
            i3 = i2 | i;
        }
        return i3;
    }
}
