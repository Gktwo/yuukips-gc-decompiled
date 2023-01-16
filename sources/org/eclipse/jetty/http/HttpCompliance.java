package org.eclipse.jetty.http;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.jetty.http.HttpURI;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpCompliance.class */
public enum HttpCompliance {
    LEGACY(sectionsBySpec("0,METHOD_CASE_SENSITIVE")),
    RFC2616_LEGACY(sectionsBySpec("RFC2616,-FIELD_COLON,-METHOD_CASE_SENSITIVE,-TRANSFER_ENCODING_WITH_CONTENT_LENGTH,-MULTIPLE_CONTENT_LENGTHS")),
    RFC2616(sectionsBySpec("RFC2616")),
    RFC7230_LEGACY(sectionsBySpec("RFC7230,-METHOD_CASE_SENSITIVE")),
    RFC7230(sectionsBySpec("RFC7230")),
    RFC7230_NO_AMBIGUOUS_URIS(sectionsBySpec("RFC7230,NO_AMBIGUOUS_PATH_SEGMENTS,NO_AMBIGUOUS_PATH_SEPARATORS")),
    CUSTOM0(sectionsByProperty("CUSTOM0")),
    CUSTOM1(sectionsByProperty("CUSTOM1")),
    CUSTOM2(sectionsByProperty("CUSTOM2")),
    CUSTOM3(sectionsByProperty("CUSTOM3"));
    
    public static final String VIOLATIONS_ATTR = "org.eclipse.jetty.http.compliance.violations";
    private static final Map<HttpComplianceSection, HttpCompliance> __required = new HashMap();
    private final EnumSet<HttpComplianceSection> _sections;
    private static final EnumMap<HttpURI.Violation, HttpComplianceSection> __uriViolations;

    static {
        HttpComplianceSection[] values = HttpComplianceSection.values();
        for (HttpComplianceSection section : values) {
            HttpCompliance[] values2 = values();
            int length = values2.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    HttpCompliance compliance = values2[i];
                    if (compliance.sections().contains(section)) {
                        __required.put(section, compliance);
                        break;
                    }
                    i++;
                }
            }
        }
        __uriViolations = new EnumMap<>(HttpURI.Violation.class);
        HttpURI.Violation[] values3 = HttpURI.Violation.values();
        for (HttpURI.Violation violation : values3) {
            switch (violation) {
                case SEPARATOR:
                    __uriViolations.put((EnumMap<HttpURI.Violation, HttpComplianceSection>) violation, (HttpURI.Violation) HttpComplianceSection.NO_AMBIGUOUS_PATH_SEPARATORS);
                    break;
                case SEGMENT:
                    __uriViolations.put((EnumMap<HttpURI.Violation, HttpComplianceSection>) violation, (HttpURI.Violation) HttpComplianceSection.NO_AMBIGUOUS_PATH_SEGMENTS);
                    break;
                case PARAM:
                    __uriViolations.put((EnumMap<HttpURI.Violation, HttpComplianceSection>) violation, (HttpURI.Violation) HttpComplianceSection.NO_AMBIGUOUS_PATH_PARAMETERS);
                    break;
                case ENCODING:
                    __uriViolations.put((EnumMap<HttpURI.Violation, HttpComplianceSection>) violation, (HttpURI.Violation) HttpComplianceSection.NO_AMBIGUOUS_PATH_ENCODING);
                    break;
                case EMPTY:
                    __uriViolations.put((EnumMap<HttpURI.Violation, HttpComplianceSection>) violation, (HttpURI.Violation) HttpComplianceSection.NO_AMBIGUOUS_EMPTY_SEGMENT);
                    break;
                case UTF16:
                    __uriViolations.put((EnumMap<HttpURI.Violation, HttpComplianceSection>) violation, (HttpURI.Violation) HttpComplianceSection.NO_UTF16_ENCODINGS);
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    private static EnumSet<HttpComplianceSection> sectionsByProperty(String property) {
        String s = System.getProperty(HttpCompliance.class.getName() + property);
        return sectionsBySpec(s == null ? "*" : s);
    }

    static EnumSet<HttpComplianceSection> sectionsBySpec(String spec) {
        EnumSet<HttpComplianceSection> sections;
        String[] elements = spec.split("\\s*,\\s*");
        int i = 0;
        String str = elements[0];
        char c = 65535;
        switch (str.hashCode()) {
            case 42:
                if (str.equals("*")) {
                    c = 2;
                    break;
                }
                break;
            case 48:
                if (str.equals("0")) {
                    c = 0;
                    break;
                }
                break;
            case 1828317304:
                if (str.equals("RFC2616")) {
                    c = 1;
                    break;
                }
                break;
            case 1828462471:
                if (str.equals("RFC7230")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                sections = EnumSet.noneOf(HttpComplianceSection.class);
                i = 0 + 1;
                break;
            case 1:
                i = 0 + 1;
                sections = EnumSet.complementOf(EnumSet.of(HttpComplianceSection.NO_FIELD_FOLDING, HttpComplianceSection.NO_HTTP_0_9, HttpComplianceSection.NO_AMBIGUOUS_PATH_SEGMENTS, HttpComplianceSection.NO_AMBIGUOUS_PATH_SEPARATORS, HttpComplianceSection.NO_UTF16_ENCODINGS, HttpComplianceSection.NO_AMBIGUOUS_EMPTY_SEGMENT, HttpComplianceSection.NO_AMBIGUOUS_PATH_ENCODING));
                break;
            case 2:
            case 3:
                i = 0 + 1;
                sections = EnumSet.complementOf(EnumSet.of(HttpComplianceSection.NO_AMBIGUOUS_PATH_SEGMENTS, HttpComplianceSection.NO_AMBIGUOUS_PATH_SEPARATORS, HttpComplianceSection.NO_UTF16_ENCODINGS, HttpComplianceSection.NO_AMBIGUOUS_EMPTY_SEGMENT, HttpComplianceSection.NO_AMBIGUOUS_PATH_ENCODING));
                break;
            default:
                sections = EnumSet.noneOf(HttpComplianceSection.class);
                break;
        }
        while (i < elements.length) {
            i++;
            String element = elements[i];
            boolean exclude = element.startsWith("-");
            if (exclude) {
                element = element.substring(1);
            }
            HttpComplianceSection section = HttpComplianceSection.valueOf(element);
            if (exclude) {
                sections.remove(section);
            } else {
                sections.add(section);
            }
        }
        return sections;
    }

    public static HttpCompliance requiredCompliance(HttpComplianceSection section) {
        return __required.get(section);
    }

    HttpCompliance(EnumSet enumSet) {
        this._sections = enumSet;
    }

    public EnumSet<HttpComplianceSection> sections() {
        return this._sections;
    }

    public static String checkUriCompliance(HttpCompliance compliance, HttpURI uri) {
        HttpURI.Violation[] values = HttpURI.Violation.values();
        for (HttpURI.Violation violation : values) {
            if (uri.hasViolation(violation) && (compliance == null || compliance.sections().contains(__uriViolations.get(violation)))) {
                return violation.getMessage();
            }
        }
        return null;
    }
}
