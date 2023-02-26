package p013io.github.classgraph;

import dev.morphia.mapping.Mapper;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.text.Typography;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.CollectionUtils;
import org.jline.console.Printer;

/* access modifiers changed from: package-private */
/* renamed from: io.github.classgraph.GraphvizDotfileGenerator */
/* loaded from: grasscutter.jar:io/github/classgraph/GraphvizDotfileGenerator.class */
public final class GraphvizDotfileGenerator {
    private static final String STANDARD_CLASS_COLOR = "fff2b6";
    private static final String INTERFACE_COLOR = "b6e7ff";
    private static final String ANNOTATION_COLOR = "f3c9ff";
    private static final int PARAM_WRAP_WIDTH = 40;
    private static final BitSet IS_UNICODE_WHITESPACE = new BitSet(65536);

    static {
        for (int i = 0; i < " \t\n\u000b\f\r  ᠎               　".length(); i++) {
            IS_UNICODE_WHITESPACE.set(" \t\n\u000b\f\r  ᠎               　".charAt(i));
        }
    }

    private GraphvizDotfileGenerator() {
    }

    private static boolean isUnicodeWhitespace(char c) {
        return IS_UNICODE_WHITESPACE.get(c);
    }

    private static void htmlEncode(CharSequence unsafeStr, boolean turnNewlineIntoBreak, StringBuilder buf) {
        int n = unsafeStr.length();
        for (int i = 0; i < n; i++) {
            char c = unsafeStr.charAt(i);
            switch (c) {
                case '\n':
                    if (turnNewlineIntoBreak) {
                        buf.append("<br>");
                        break;
                    } else {
                        buf.append(' ');
                        break;
                    }
                case '\"':
                    buf.append("&quot;");
                    break;
                case '&':
                    buf.append("&amp;");
                    break;
                case '\'':
                    buf.append("&#x27;");
                    break;
                case '/':
                    buf.append("&#x2F;");
                    break;
                case '<':
                    buf.append("&lt;");
                    break;
                case '>':
                    buf.append("&gt;");
                    break;
                case '\\':
                    buf.append("&lsol;");
                    break;
                case 160:
                    buf.append("&nbsp;");
                    break;
                case 163:
                    buf.append("&pound;");
                    break;
                case 169:
                    buf.append("&copy;");
                    break;
                case 171:
                    buf.append("&laquo;");
                    break;
                case 174:
                    buf.append("&reg;");
                    break;
                case 187:
                    buf.append("&raquo;");
                    break;
                case 8211:
                    buf.append("&ndash;");
                    break;
                case Typography.mdash /* 8212 */:
                    buf.append("&mdash;");
                    break;
                case Typography.leftSingleQuote /* 8216 */:
                    buf.append("&lsquo;");
                    break;
                case Typography.rightSingleQuote /* 8217 */:
                    buf.append("&rsquo;");
                    break;
                case 8220:
                    buf.append("&ldquo;");
                    break;
                case Typography.rightDoubleQuote /* 8221 */:
                    buf.append("&rdquo;");
                    break;
                default:
                    if (c <= ' ' || isUnicodeWhitespace(c)) {
                        buf.append(' ');
                        break;
                    } else {
                        buf.append(c);
                        break;
                    }
            }
        }
    }

    private static void htmlEncode(CharSequence unsafeStr, StringBuilder buf) {
        htmlEncode(unsafeStr, false, buf);
    }

    private static void labelClassNodeHTML(ClassInfo ci, String shape, String boxBgColor, boolean showFields, boolean showMethods, boolean useSimpleNames, ScanSpec scanSpec, StringBuilder buf) {
        String str;
        buf.append("[shape=").append(shape).append(",style=filled,fillcolor=\"#").append(boxBgColor).append("\",label=");
        buf.append('<');
        buf.append("<table border='0' cellborder='0' cellspacing='1'>");
        StringBuilder append = buf.append("<tr><td><font point-size='12'>").append(ci.getModifiersStr()).append(' ');
        if (ci.isEnum()) {
            str = "enum";
        } else {
            str = ci.isAnnotation() ? "@interface" : ci.isInterface() ? "interface" : "class";
        }
        append.append(str).append("</font></td></tr>");
        if (ci.getName().contains(Mapper.IGNORED_FIELDNAME)) {
            buf.append("<tr><td><font point-size='14'><b>");
            htmlEncode(ci.getPackageName() + Mapper.IGNORED_FIELDNAME, buf);
            buf.append("</b></font></td></tr>");
        }
        buf.append("<tr><td><font point-size='20'><b>");
        htmlEncode(ci.getSimpleName(), buf);
        buf.append("</b></font></td></tr>");
        int r = (int) (((float) Integer.parseInt(boxBgColor.substring(0, 2), 16)) * 0.8f);
        int g = (int) (((float) Integer.parseInt(boxBgColor.substring(2, 4), 16)) * 0.8f);
        int b = (int) (((float) Integer.parseInt(boxBgColor.substring(4, 6), 16)) * 0.8f);
        String darkerColor = String.format("#%s%s%s%s%s%s", Integer.toString(r >> 4, 16), Integer.toString(r & 15, 16), Integer.toString(g >> 4, 16), Integer.toString(g & 15, 16), Integer.toString(b >> 4, 16), Integer.toString(b & 15, 16));
        AnnotationInfoList annotationInfo = ci.annotationInfo;
        if (annotationInfo != null && !annotationInfo.isEmpty()) {
            buf.append("<tr><td colspan='3' bgcolor='").append(darkerColor).append("'><font point-size='12'><b>ANNOTATIONS</b></font></td></tr>");
            AnnotationInfoList annotationInfoSorted = new AnnotationInfoList(annotationInfo);
            CollectionUtils.sortIfNotEmpty(annotationInfoSorted);
            Iterator it = annotationInfoSorted.iterator();
            while (it.hasNext()) {
                AnnotationInfo ai = (AnnotationInfo) it.next();
                if (!ai.getName().startsWith("java.lang.annotation.")) {
                    buf.append("<tr>");
                    buf.append("<td align='center' valign='top'>");
                    htmlEncode(ai.toString(), buf);
                    buf.append("</td></tr>");
                }
            }
        }
        FieldInfoList fieldInfo = ci.fieldInfo;
        if (showFields && fieldInfo != null && !fieldInfo.isEmpty()) {
            FieldInfoList fieldInfoSorted = new FieldInfoList(fieldInfo);
            CollectionUtils.sortIfNotEmpty(fieldInfoSorted);
            for (int i = fieldInfoSorted.size() - 1; i >= 0; i--) {
                if (((FieldInfo) fieldInfoSorted.get(i)).getName().equals("serialVersionUID")) {
                    fieldInfoSorted.remove(i);
                }
            }
            if (!fieldInfoSorted.isEmpty()) {
                buf.append("<tr><td colspan='3' bgcolor='").append(darkerColor).append("'><font point-size='12'><b>").append(scanSpec.ignoreFieldVisibility ? "" : "PUBLIC ").append("FIELDS</b></font></td></tr>");
                buf.append("<tr><td cellpadding='0'>");
                buf.append("<table border='0' cellborder='0'>");
                Iterator it2 = fieldInfoSorted.iterator();
                while (it2.hasNext()) {
                    FieldInfo fi = (FieldInfo) it2.next();
                    buf.append("<tr>");
                    buf.append("<td align='right' valign='top'>");
                    AnnotationInfoList fieldAnnotationInfo = fi.annotationInfo;
                    if (fieldAnnotationInfo != null) {
                        Iterator it3 = fieldAnnotationInfo.iterator();
                        while (it3.hasNext()) {
                            AnnotationInfo ai2 = (AnnotationInfo) it3.next();
                            if (buf.charAt(buf.length() - 1) != ' ') {
                                buf.append(' ');
                            }
                            htmlEncode(ai2.toString(), buf);
                        }
                    }
                    if (scanSpec.ignoreFieldVisibility) {
                        if (buf.charAt(buf.length() - 1) != ' ') {
                            buf.append(' ');
                        }
                        buf.append(fi.getModifierStr());
                    }
                    if (buf.charAt(buf.length() - 1) != ' ') {
                        buf.append(' ');
                    }
                    TypeSignature typeSig = fi.getTypeSignatureOrTypeDescriptor();
                    htmlEncode(useSimpleNames ? typeSig.toStringWithSimpleNames() : typeSig.toString(), buf);
                    buf.append("</td>");
                    buf.append("<td align='left' valign='top'><b>");
                    htmlEncode(fi.getName(), buf);
                    buf.append("</b></td></tr>");
                }
                buf.append("</table>");
                buf.append("</td></tr>");
            }
        }
        MethodInfoList methodInfo = ci.methodInfo;
        if (showMethods && methodInfo != null) {
            MethodInfoList methodInfoSorted = new MethodInfoList(methodInfo);
            CollectionUtils.sortIfNotEmpty(methodInfoSorted);
            for (int i2 = methodInfoSorted.size() - 1; i2 >= 0; i2--) {
                MethodInfo mi = (MethodInfo) methodInfoSorted.get(i2);
                String name = mi.getName();
                int numParam = mi.getParameterInfo().length;
                if (name.equals("<clinit>") || ((name.equals("hashCode") && numParam == 0) || ((name.equals(Printer.TO_STRING) && numParam == 0) || (name.equals("equals") && numParam == 1 && mi.getTypeDescriptor().toString().equals("boolean (java.lang.Object)"))))) {
                    methodInfoSorted.remove(i2);
                }
            }
            if (!methodInfoSorted.isEmpty()) {
                buf.append("<tr><td cellpadding='0'>");
                buf.append("<table border='0' cellborder='0'>");
                buf.append("<tr><td colspan='3' bgcolor='").append(darkerColor).append("'><font point-size='12'><b>").append(scanSpec.ignoreMethodVisibility ? "" : "PUBLIC ").append("METHODS</b></font></td></tr>");
                Iterator it4 = methodInfoSorted.iterator();
                while (it4.hasNext()) {
                    MethodInfo mi2 = (MethodInfo) it4.next();
                    buf.append("<tr>");
                    buf.append("<td align='right' valign='top'>");
                    AnnotationInfoList methodAnnotationInfo = mi2.annotationInfo;
                    if (methodAnnotationInfo != null) {
                        Iterator it5 = methodAnnotationInfo.iterator();
                        while (it5.hasNext()) {
                            AnnotationInfo ai3 = (AnnotationInfo) it5.next();
                            if (buf.charAt(buf.length() - 1) != ' ') {
                                buf.append(' ');
                            }
                            htmlEncode(ai3.toString(), buf);
                        }
                    }
                    if (scanSpec.ignoreMethodVisibility) {
                        if (buf.charAt(buf.length() - 1) != ' ') {
                            buf.append(' ');
                        }
                        buf.append(mi2.getModifiersStr());
                    }
                    if (buf.charAt(buf.length() - 1) != ' ') {
                        buf.append(' ');
                    }
                    if (!mi2.getName().equals("<init>")) {
                        TypeSignature resultTypeSig = mi2.getTypeSignatureOrTypeDescriptor().getResultType();
                        htmlEncode(useSimpleNames ? resultTypeSig.toStringWithSimpleNames() : resultTypeSig.toString(), buf);
                    } else {
                        buf.append("<b>&lt;constructor&gt;</b>");
                    }
                    buf.append("</td>");
                    buf.append("<td align='left' valign='top'>");
                    buf.append("<b>");
                    if (mi2.getName().equals("<init>")) {
                        htmlEncode(ci.getSimpleName(), buf);
                    } else {
                        htmlEncode(mi2.getName(), buf);
                    }
                    buf.append("</b>&nbsp;");
                    buf.append("</td>");
                    buf.append("<td align='left' valign='top'>");
                    buf.append('(');
                    MethodParameterInfo[] paramInfo = mi2.getParameterInfo();
                    if (paramInfo.length != 0) {
                        int wrapPos = 0;
                        for (int i3 = 0; i3 < paramInfo.length; i3++) {
                            if (i3 > 0) {
                                buf.append(", ");
                                wrapPos += 2;
                            }
                            if (wrapPos > 40) {
                                buf.append("</td></tr><tr><td></td><td></td><td align='left' valign='top'>");
                                wrapPos = 0;
                            }
                            AnnotationInfo[] paramAnnotationInfo = paramInfo[i3].annotationInfo;
                            if (paramAnnotationInfo != null) {
                                for (AnnotationInfo ai4 : paramAnnotationInfo) {
                                    String ais = ai4.toString();
                                    if (!ais.isEmpty()) {
                                        if (buf.charAt(buf.length() - 1) != ' ') {
                                            buf.append(' ');
                                        }
                                        htmlEncode(ais, buf);
                                        wrapPos += 1 + ais.length();
                                        if (wrapPos > 40) {
                                            buf.append("</td></tr><tr><td></td><td></td><td align='left' valign='top'>");
                                            wrapPos = 0;
                                        }
                                    }
                                }
                            }
                            TypeSignature paramTypeSig = paramInfo[i3].getTypeSignatureOrTypeDescriptor();
                            String paramTypeStr = useSimpleNames ? paramTypeSig.toStringWithSimpleNames() : paramTypeSig.toString();
                            htmlEncode(paramTypeStr, buf);
                            wrapPos += paramTypeStr.length();
                            String paramName = paramInfo[i3].getName();
                            if (paramName != null) {
                                buf.append(" <B>");
                                htmlEncode(paramName, buf);
                                wrapPos += 1 + paramName.length();
                                buf.append("</B>");
                            }
                        }
                    }
                    buf.append(')');
                    buf.append("</td></tr>");
                }
                buf.append("</table>");
                buf.append("</td></tr>");
            }
        }
        buf.append("</table>");
        buf.append(">]");
    }

    /* access modifiers changed from: package-private */
    public static String generateGraphVizDotFile(ClassInfoList classInfoList, float sizeX, float sizeY, boolean showFields, boolean showFieldTypeDependencyEdges, boolean showMethods, boolean showMethodTypeDependencyEdges, boolean showAnnotations, boolean useSimpleNames, ScanSpec scanSpec) {
        StringBuilder buf = new StringBuilder(1048576);
        buf.append("digraph {\n");
        buf.append("size=\"").append(sizeX).append(',').append(sizeY).append("\";\n");
        buf.append("layout=dot;\n");
        buf.append("rankdir=\"BT\";\n");
        buf.append("overlap=false;\n");
        buf.append("splines=true;\n");
        buf.append("pack=true;\n");
        buf.append("graph [fontname = \"Courier, Regular\"]\n");
        buf.append("node [fontname = \"Courier, Regular\"]\n");
        buf.append("edge [fontname = \"Courier, Regular\"]\n");
        ClassInfoList standardClassNodes = classInfoList.getStandardClasses();
        ClassInfoList interfaceNodes = classInfoList.getInterfaces();
        ClassInfoList annotationNodes = classInfoList.getAnnotations();
        Iterator it = standardClassNodes.iterator();
        while (it.hasNext()) {
            ClassInfo node = (ClassInfo) it.next();
            buf.append('\"').append(node.getName()).append('\"');
            labelClassNodeHTML(node, "box", STANDARD_CLASS_COLOR, showFields, showMethods, useSimpleNames, scanSpec, buf);
            buf.append(";\n");
        }
        Iterator it2 = interfaceNodes.iterator();
        while (it2.hasNext()) {
            ClassInfo node2 = (ClassInfo) it2.next();
            buf.append('\"').append(node2.getName()).append('\"');
            labelClassNodeHTML(node2, "diamond", INTERFACE_COLOR, showFields, showMethods, useSimpleNames, scanSpec, buf);
            buf.append(";\n");
        }
        Iterator it3 = annotationNodes.iterator();
        while (it3.hasNext()) {
            ClassInfo node3 = (ClassInfo) it3.next();
            buf.append('\"').append(node3.getName()).append('\"');
            labelClassNodeHTML(node3, "oval", ANNOTATION_COLOR, showFields, showMethods, useSimpleNames, scanSpec, buf);
            buf.append(";\n");
        }
        Set<String> allVisibleNodes = new HashSet<>();
        allVisibleNodes.addAll(standardClassNodes.getNames());
        allVisibleNodes.addAll(interfaceNodes.getNames());
        allVisibleNodes.addAll(annotationNodes.getNames());
        buf.append('\n');
        Iterator it4 = standardClassNodes.iterator();
        while (it4.hasNext()) {
            ClassInfo classNode = (ClassInfo) it4.next();
            Iterator it5 = classNode.getSuperclasses().directOnly().iterator();
            while (it5.hasNext()) {
                ClassInfo directSuperclassNode = (ClassInfo) it5.next();
                if (directSuperclassNode != null && allVisibleNodes.contains(directSuperclassNode.getName()) && !directSuperclassNode.getName().equals("java.lang.Object")) {
                    buf.append("  \"").append(classNode.getName()).append("\" -> \"").append(directSuperclassNode.getName()).append("\" [arrowsize=2.5]\n");
                }
            }
            Iterator it6 = classNode.getInterfaces().directOnly().iterator();
            while (it6.hasNext()) {
                ClassInfo implementedInterfaceNode = (ClassInfo) it6.next();
                if (allVisibleNodes.contains(implementedInterfaceNode.getName())) {
                    buf.append("  \"").append(classNode.getName()).append("\" -> \"").append(implementedInterfaceNode.getName()).append("\" [arrowhead=diamond, arrowsize=2.5]\n");
                }
            }
            if (showFieldTypeDependencyEdges && classNode.fieldInfo != null) {
                Iterator it7 = classNode.fieldInfo.iterator();
                while (it7.hasNext()) {
                    for (ClassInfo referencedFieldType : ((FieldInfo) it7.next()).findReferencedClassInfo()) {
                        if (allVisibleNodes.contains(referencedFieldType.getName())) {
                            buf.append("  \"").append(referencedFieldType.getName()).append("\" -> \"").append(classNode.getName()).append("\" [arrowtail=obox, arrowsize=2.5, dir=back]\n");
                        }
                    }
                }
            }
            if (showMethodTypeDependencyEdges && classNode.methodInfo != null) {
                Iterator it8 = classNode.methodInfo.iterator();
                while (it8.hasNext()) {
                    for (ClassInfo referencedMethodType : ((MethodInfo) it8.next()).findReferencedClassInfo()) {
                        if (allVisibleNodes.contains(referencedMethodType.getName())) {
                            buf.append("  \"").append(referencedMethodType.getName()).append("\" -> \"").append(classNode.getName()).append("\" [arrowtail=box, arrowsize=2.5, dir=back]\n");
                        }
                    }
                }
            }
        }
        Iterator it9 = interfaceNodes.iterator();
        while (it9.hasNext()) {
            ClassInfo interfaceNode = (ClassInfo) it9.next();
            Iterator it10 = interfaceNode.getInterfaces().directOnly().iterator();
            while (it10.hasNext()) {
                ClassInfo superinterfaceNode = (ClassInfo) it10.next();
                if (allVisibleNodes.contains(superinterfaceNode.getName())) {
                    buf.append("  \"").append(interfaceNode.getName()).append("\" -> \"").append(superinterfaceNode.getName()).append("\" [arrowhead=diamond, arrowsize=2.5]\n");
                }
            }
        }
        if (showAnnotations) {
            Iterator it11 = annotationNodes.iterator();
            while (it11.hasNext()) {
                ClassInfo annotationNode = (ClassInfo) it11.next();
                Iterator it12 = annotationNode.getClassesWithAnnotationDirectOnly().iterator();
                while (it12.hasNext()) {
                    ClassInfo annotatedClassNode = (ClassInfo) it12.next();
                    if (allVisibleNodes.contains(annotatedClassNode.getName())) {
                        buf.append("  \"").append(annotatedClassNode.getName()).append("\" -> \"").append(annotationNode.getName()).append("\" [arrowhead=dot, arrowsize=2.5]\n");
                    }
                }
                Iterator it13 = annotationNode.getClassesWithMethodAnnotationDirectOnly().iterator();
                while (it13.hasNext()) {
                    ClassInfo classWithMethodAnnotationNode = (ClassInfo) it13.next();
                    if (allVisibleNodes.contains(classWithMethodAnnotationNode.getName())) {
                        buf.append("  \"").append(classWithMethodAnnotationNode.getName()).append("\" -> \"").append(annotationNode.getName()).append("\" [arrowhead=odot, arrowsize=2.5]\n");
                    }
                }
                Iterator it14 = annotationNode.getClassesWithFieldAnnotationDirectOnly().iterator();
                while (it14.hasNext()) {
                    ClassInfo classWithMethodAnnotationNode2 = (ClassInfo) it14.next();
                    if (allVisibleNodes.contains(classWithMethodAnnotationNode2.getName())) {
                        buf.append("  \"").append(classWithMethodAnnotationNode2.getName()).append("\" -> \"").append(annotationNode.getName()).append("\" [arrowhead=odot, arrowsize=2.5]\n");
                    }
                }
            }
        }
        buf.append('}');
        return buf.toString();
    }

    /* access modifiers changed from: package-private */
    public static String generateGraphVizDotFileFromInterClassDependencies(ClassInfoList classInfoList, float sizeX, float sizeY, boolean includeExternalClasses) {
        String str;
        String str2;
        StringBuilder buf = new StringBuilder(1048576);
        buf.append("digraph {\n");
        buf.append("size=\"").append(sizeX).append(',').append(sizeY).append("\";\n");
        buf.append("layout=dot;\n");
        buf.append("rankdir=\"BT\";\n");
        buf.append("overlap=false;\n");
        buf.append("splines=true;\n");
        buf.append("pack=true;\n");
        buf.append("graph [fontname = \"Courier, Regular\"]\n");
        buf.append("node [fontname = \"Courier, Regular\"]\n");
        buf.append("edge [fontname = \"Courier, Regular\"]\n");
        Set<ClassInfo> allVisibleNodes = new HashSet<>(classInfoList);
        if (includeExternalClasses) {
            Iterator it = classInfoList.iterator();
            while (it.hasNext()) {
                allVisibleNodes.addAll(((ClassInfo) it.next()).getClassDependencies());
            }
        }
        for (ClassInfo ci : allVisibleNodes) {
            buf.append('\"').append(ci.getName()).append('\"');
            StringBuilder append = buf.append("[shape=").append(ci.isAnnotation() ? "oval" : ci.isInterface() ? "diamond" : "box").append(",style=filled,fillcolor=\"#");
            if (ci.isAnnotation()) {
                str = ANNOTATION_COLOR;
            } else {
                str = ci.isInterface() ? INTERFACE_COLOR : STANDARD_CLASS_COLOR;
            }
            append.append(str).append("\",label=");
            buf.append('<');
            buf.append("<table border='0' cellborder='0' cellspacing='1'>");
            StringBuilder append2 = buf.append("<tr><td><font point-size='12'>").append(ci.getModifiersStr()).append(' ');
            if (ci.isEnum()) {
                str2 = "enum";
            } else {
                str2 = ci.isAnnotation() ? "@interface" : ci.isInterface() ? "interface" : "class";
            }
            append2.append(str2).append("</font></td></tr>");
            if (ci.getName().contains(Mapper.IGNORED_FIELDNAME)) {
                buf.append("<tr><td><font point-size='14'><b>");
                htmlEncode(ci.getPackageName(), buf);
                buf.append("</b></font></td></tr>");
            }
            buf.append("<tr><td><font point-size='20'><b>");
            htmlEncode(ci.getSimpleName(), buf);
            buf.append("</b></font></td></tr>");
            buf.append("</table>");
            buf.append(">];\n");
        }
        buf.append('\n');
        Iterator it2 = classInfoList.iterator();
        while (it2.hasNext()) {
            ClassInfo ci2 = (ClassInfo) it2.next();
            Iterator it3 = ci2.getClassDependencies().iterator();
            while (it3.hasNext()) {
                ClassInfo dep = (ClassInfo) it3.next();
                if (includeExternalClasses || allVisibleNodes.contains(dep)) {
                    buf.append("  \"").append(ci2.getName()).append("\" -> \"").append(dep.getName()).append("\" [arrowsize=2.5]\n");
                }
            }
        }
        buf.append('}');
        return buf.toString();
    }
}
