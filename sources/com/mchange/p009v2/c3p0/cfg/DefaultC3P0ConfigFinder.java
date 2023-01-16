package com.mchange.p009v2.c3p0.cfg;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import p001ch.qos.logback.core.joran.action.Action;

/* renamed from: com.mchange.v2.c3p0.cfg.DefaultC3P0ConfigFinder */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/cfg/DefaultC3P0ConfigFinder.class */
public class DefaultC3P0ConfigFinder implements C3P0ConfigFinder {
    static final String XML_CFG_FILE_KEY = "com.mchange.v2.c3p0.cfg.xml";
    static final String XML_CFG_EXPAND_ENTITY_REFS_KEY = "com.mchange.v2.c3p0.cfg.xml.expandEntityReferences";
    static final String XML_CFG_USE_PERMISSIVE_PARSER_KEY = "com.mchange.v2.c3p0.cfg.xml.usePermissiveParser";
    static final String CLASSLOADER_RESOURCE_PREFIX = "classloader:";
    static final MLogger logger = MLog.getLogger(DefaultC3P0ConfigFinder.class);
    final boolean warn_of_xml_overrides;

    public DefaultC3P0ConfigFinder(boolean warn_of_xml_overrides) {
        this.warn_of_xml_overrides = warn_of_xml_overrides;
    }

    public DefaultC3P0ConfigFinder() {
        this(false);
    }

    @Override // com.mchange.p009v2.c3p0.cfg.C3P0ConfigFinder
    public C3P0Config findConfig() throws Exception {
        C3P0Config out;
        InputStream is;
        HashMap flatDefaults = C3P0ConfigUtils.extractHardcodedC3P0Defaults();
        flatDefaults.putAll(C3P0ConfigUtils.extractC3P0PropertiesResources());
        String cfgFile = C3P0Config.getPropsFileConfigProperty(XML_CFG_FILE_KEY);
        boolean usePermissiveParser = findUsePermissiveParser();
        if (cfgFile == null) {
            C3P0Config xmlConfig = C3P0ConfigXmlUtils.extractXmlConfigFromDefaultResource(usePermissiveParser);
            if (xmlConfig != null) {
                insertDefaultsUnderNascentConfig(flatDefaults, xmlConfig);
                out = xmlConfig;
                mbOverrideWarning("resource", C3P0ConfigXmlUtils.XML_CONFIG_RSRC_PATH);
            } else {
                out = C3P0ConfigUtils.configFromFlatDefaults(flatDefaults);
            }
        } else {
            String cfgFile2 = cfgFile.trim();
            InputStream is2 = null;
            try {
                if (cfgFile2.startsWith(CLASSLOADER_RESOURCE_PREFIX)) {
                    ClassLoader cl = getClass().getClassLoader();
                    String rsrcPath = cfgFile2.substring(CLASSLOADER_RESOURCE_PREFIX.length());
                    if (rsrcPath.startsWith("/")) {
                        rsrcPath = rsrcPath.substring(1);
                    }
                    is = cl.getResourceAsStream(rsrcPath);
                    if (is == null) {
                        throw new FileNotFoundException("Specified ClassLoader resource '" + rsrcPath + "' could not be found. [ Found in configuration: " + XML_CFG_FILE_KEY + '=' + cfgFile2 + " ]");
                    }
                    mbOverrideWarning("resource", rsrcPath);
                } else {
                    is = new BufferedInputStream(new FileInputStream(cfgFile2));
                    mbOverrideWarning(Action.FILE_ATTRIBUTE, cfgFile2);
                }
                C3P0Config xmlConfig2 = C3P0ConfigXmlUtils.extractXmlConfigFromInputStream(is, usePermissiveParser);
                insertDefaultsUnderNascentConfig(flatDefaults, xmlConfig2);
                out = xmlConfig2;
                if (is != null) {
                    try {
                        is.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        is2.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
        }
        out.defaultConfig.props.putAll(C3P0ConfigUtils.findAllC3P0SystemProperties());
        return out;
    }

    private void insertDefaultsUnderNascentConfig(HashMap flatDefaults, C3P0Config config) {
        flatDefaults.putAll(config.defaultConfig.props);
        config.defaultConfig.props = flatDefaults;
    }

    private void mbOverrideWarning(String srcType, String srcName) {
        if (this.warn_of_xml_overrides && logger.isLoggable(MLevel.WARNING)) {
            logger.log(MLevel.WARNING, "Configuation defined in " + srcType + "'" + srcName + "' overrides all other c3p0 config.");
        }
    }

    private static boolean affirmativelyTrue(String propStr) {
        return propStr != null && propStr.trim().equalsIgnoreCase(C3P0Substitutions.DEBUG);
    }

    private boolean findUsePermissiveParser() {
        String warningKey;
        boolean deprecatedExpandEntityRefs = affirmativelyTrue(C3P0Config.getPropsFileConfigProperty(XML_CFG_EXPAND_ENTITY_REFS_KEY));
        boolean usePermissiveParser = affirmativelyTrue(C3P0Config.getPropsFileConfigProperty(XML_CFG_USE_PERMISSIVE_PARSER_KEY));
        boolean out = usePermissiveParser || deprecatedExpandEntityRefs;
        if (out && logger.isLoggable(MLevel.WARNING)) {
            if (deprecatedExpandEntityRefs) {
                logger.log(MLevel.WARNING, "You have set the configuration property 'com.mchange.v2.c3p0.cfg.xml.expandEntityReferences', which has been deprecated, to true. Please use 'com.mchange.v2.c3p0.cfg.xml.usePermissiveParser' instead. Please be aware that permissive parsing enables inline document type definitions, XML inclusions, and other fetures!");
                if (usePermissiveParser) {
                    warningKey = "Configuration property 'com.mchange.v2.c3p0.cfg.xml.usePermissiveParser'";
                } else {
                    warningKey = "Configuration property 'com.mchange.v2.c3p0.cfg.xml.expandEntityReferences' (deprecated)";
                }
            } else {
                warningKey = "Configuration property 'com.mchange.v2.c3p0.cfg.xml.usePermissiveParser'";
            }
            logger.log(MLevel.WARNING, warningKey + " is set to 'true'. Entity references will be resolved in XML c3p0 configuration files, doctypes and xml includes will be permitted, the file will in general be parsed very permissively. This may be a security hazard. Be sure you understand your XML config files, including the full transitive closure of entity references and incusions. See CVE-2018-20433, https://nvd.nist.gov/vuln/detail/CVE-2018-20433 / See also https://github.com/OWASP/CheatSheetSeries/blob/31c94f233c40af4237432008106f42a9c4bff05e/cheatsheets/XML_External_Entity_Prevention_Cheat_Sheet.md / See also https://vsecurity.com//download/papers/XMLDTDEntityAttacks.pdf");
        }
        return out;
    }
}
