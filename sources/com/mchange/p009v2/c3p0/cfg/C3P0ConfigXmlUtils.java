package com.mchange.p009v2.c3p0.cfg;

import com.mchange.p006v1.xml.DomParseUtils;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import dev.morphia.mapping.Mapper;
import java.io.InputStream;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* renamed from: com.mchange.v2.c3p0.cfg.C3P0ConfigXmlUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/cfg/C3P0ConfigXmlUtils.class */
public final class C3P0ConfigXmlUtils {
    public static final String XML_CONFIG_RSRC_PATH = "/c3p0-config.xml";
    public static final String LINESEP;
    static final MLogger logger = MLog.getLogger(C3P0ConfigXmlUtils.class);
    private static final String[] MISSPELL_PFXS = {"/c3p0", "/c3pO", "/c3po", "/C3P0", "/C3PO"};
    private static final char[] MISSPELL_LINES = {'-', '_'};
    private static final String[] MISSPELL_CONFIG = {"config", "CONFIG"};
    private static final String[] MISSPELL_XML = {"xml", "XML"};

    static {
        String ls;
        try {
            ls = System.getProperty("line.separator", "\r\n");
        } catch (Exception e) {
            ls = "\r\n";
        }
        LINESEP = ls;
    }

    private static final void warnCommonXmlConfigResourceMisspellings() {
        if (logger.isLoggable(MLevel.WARNING)) {
            int lena = MISSPELL_PFXS.length;
            for (int a = 0; a < lena; a++) {
                StringBuffer sb = new StringBuffer(16);
                sb.append(MISSPELL_PFXS[a]);
                int lenb = MISSPELL_LINES.length;
                for (int b = 0; b < lenb; b++) {
                    sb.append(MISSPELL_LINES[b]);
                    int lenc = MISSPELL_CONFIG.length;
                    for (int c = 0; c < lenc; c++) {
                        sb.append(MISSPELL_CONFIG[c]);
                        sb.append('.');
                        int lend = MISSPELL_XML.length;
                        for (int d = 0; d < lend; d++) {
                            sb.append(MISSPELL_XML[d]);
                            String test = sb.toString();
                            if (!test.equals(XML_CONFIG_RSRC_PATH) && C3P0ConfigXmlUtils.class.getResource(test) != null) {
                                logger.warning("POSSIBLY MISSPELLED c3p0-conf.xml RESOURCE FOUND. Please ensure the file name is c3p0-config.xml, all lower case, with the digit 0 (NOT the letter O) in c3p0. It should be placed  in the top level of c3p0's effective classpath.");
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public static C3P0Config extractXmlConfigFromDefaultResource(boolean usePermissiveParser) throws Exception {
        InputStream is = null;
        try {
            is = C3P0ConfigUtils.class.getResourceAsStream(XML_CONFIG_RSRC_PATH);
            if (is == null) {
                warnCommonXmlConfigResourceMisspellings();
                return null;
            }
            C3P0Config extractXmlConfigFromInputStream = extractXmlConfigFromInputStream(is, usePermissiveParser);
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {
                    if (logger.isLoggable(MLevel.FINE)) {
                        logger.log(MLevel.FINE, "Exception on resource InputStream close.", (Throwable) e);
                    }
                }
            }
            return extractXmlConfigFromInputStream;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e2) {
                    if (logger.isLoggable(MLevel.FINE)) {
                        logger.log(MLevel.FINE, "Exception on resource InputStream close.", (Throwable) e2);
                    }
                }
            }
        }
    }

    private static void attemptSetFeature(DocumentBuilderFactory dbf, String featureUri, boolean setting) {
        try {
            dbf.setFeature(featureUri, setting);
        } catch (ParserConfigurationException e) {
            if (logger.isLoggable(MLevel.FINE)) {
                logger.log(MLevel.FINE, "Attempted but failed to set presumably unsupported feature '" + featureUri + "' to " + setting + Mapper.IGNORED_FIELDNAME);
            }
        }
    }

    private static void cautionDocumentBuilderFactory(DocumentBuilderFactory dbf) {
        attemptSetFeature(dbf, "http://apache.org/xml/features/disallow-doctype-decl", true);
        attemptSetFeature(dbf, "http://xerces.apache.org/xerces-j/features.html#external-general-entities", false);
        attemptSetFeature(dbf, "http://xerces.apache.org/xerces2-j/features.html#external-general-entities", false);
        attemptSetFeature(dbf, "http://xml.org/sax/features/external-general-entities", false);
        attemptSetFeature(dbf, "http://xerces.apache.org/xerces-j/features.html#external-parameter-entities", false);
        attemptSetFeature(dbf, "http://xerces.apache.org/xerces2-j/features.html#external-parameter-entities", false);
        attemptSetFeature(dbf, "http://xml.org/sax/features/external-parameter-entities", false);
        attemptSetFeature(dbf, "http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        dbf.setXIncludeAware(false);
        dbf.setExpandEntityReferences(false);
    }

    public static C3P0Config extractXmlConfigFromInputStream(InputStream is, boolean usePermissiveParser) throws Exception {
        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
        if (!usePermissiveParser) {
            cautionDocumentBuilderFactory(fact);
        }
        return extractConfigFromXmlDoc(fact.newDocumentBuilder().parse(is));
    }

    public static C3P0Config extractConfigFromXmlDoc(Document doc) throws Exception {
        NamedScope defaults;
        Element docElem = doc.getDocumentElement();
        if (docElem.getTagName().equals("c3p0-config")) {
            HashMap configNamesToNamedScopes = new HashMap();
            Element defaultConfigElem = DomParseUtils.uniqueChild(docElem, "default-config");
            if (defaultConfigElem != null) {
                defaults = extractNamedScopeFromLevel(defaultConfigElem);
            } else {
                defaults = new NamedScope();
            }
            NodeList nl = DomParseUtils.immediateChildElementsByTagName(docElem, "named-config");
            int len = nl.getLength();
            for (int i = 0; i < len; i++) {
                Element namedConfigElem = (Element) nl.item(i);
                String configName = namedConfigElem.getAttribute("name");
                if (configName == null || configName.length() <= 0) {
                    logger.warning("Configuration XML contained named-config element without name attribute: " + namedConfigElem);
                } else {
                    configNamesToNamedScopes.put(configName, extractNamedScopeFromLevel(namedConfigElem));
                }
            }
            return new C3P0Config(defaults, configNamesToNamedScopes);
        }
        throw new Exception("Root element of c3p0 config xml should be 'c3p0-config', not '" + docElem.getTagName() + "'.");
    }

    private static NamedScope extractNamedScopeFromLevel(Element elem) {
        HashMap props = extractPropertiesFromLevel(elem);
        HashMap userNamesToOverrides = new HashMap();
        NodeList nl = DomParseUtils.immediateChildElementsByTagName(elem, "user-overrides");
        int len = nl.getLength();
        for (int i = 0; i < len; i++) {
            Element perUserConfigElem = (Element) nl.item(i);
            String userName = perUserConfigElem.getAttribute("user");
            if (userName == null || userName.length() <= 0) {
                logger.warning("Configuration XML contained user-overrides element without user attribute: " + LINESEP + perUserConfigElem);
            } else {
                userNamesToOverrides.put(userName, extractPropertiesFromLevel(perUserConfigElem));
            }
        }
        return new NamedScope(props, userNamesToOverrides, extractExtensionsFromLevel(elem));
    }

    private static HashMap extractExtensionsFromLevel(Element elem) {
        HashMap out = new HashMap();
        NodeList nl = DomParseUtils.immediateChildElementsByTagName(elem, "extensions");
        int len = nl.getLength();
        for (int i = 0; i < len; i++) {
            out.putAll(extractPropertiesFromLevel((Element) nl.item(i)));
        }
        return out;
    }

    private static HashMap extractPropertiesFromLevel(Element elem) {
        HashMap out = new HashMap();
        try {
            NodeList nl = DomParseUtils.immediateChildElementsByTagName(elem, "property");
            int len = nl.getLength();
            for (int i = 0; i < len; i++) {
                Element propertyElem = (Element) nl.item(i);
                String propName = propertyElem.getAttribute("name");
                if (propName == null || propName.length() <= 0) {
                    logger.warning("Configuration XML contained property element without name attribute: " + LINESEP + propertyElem);
                } else {
                    out.put(propName, DomParseUtils.allTextFromElement(propertyElem, true));
                }
            }
        } catch (Exception e) {
            logger.log(MLevel.WARNING, "An exception occurred while reading config XML. Some configuration information has probably been ignored.", (Throwable) e);
        }
        return out;
    }

    private C3P0ConfigXmlUtils() {
    }
}
