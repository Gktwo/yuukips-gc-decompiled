package com.mchange.p009v2.codegen.bean;

import com.mchange.p006v1.lang.ClassUtils;
import com.mchange.p009v2.codegen.CodegenUtils;
import com.mchange.p009v2.codegen.IndentedWriter;
import java.io.IOException;
import java.util.Comparator;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* renamed from: com.mchange.v2.codegen.bean.BeangenUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/BeangenUtils.class */
public final class BeangenUtils {
    public static final Comparator PROPERTY_COMPARATOR = new Comparator() { // from class: com.mchange.v2.codegen.bean.BeangenUtils.1
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return String.CASE_INSENSITIVE_ORDER.compare(((Property) obj).getName(), ((Property) obj2).getName());
        }
    };

    public static String capitalize(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public static void writeExplicitDefaultConstructor(int i, ClassInfo classInfo, IndentedWriter indentedWriter) throws IOException {
        indentedWriter.print(CodegenUtils.getModifierString(i));
        indentedWriter.println(' ' + classInfo.getClassName() + "()");
        indentedWriter.println("{}");
    }

    public static void writeArgList(Property[] propertyArr, boolean z, IndentedWriter indentedWriter) throws IOException {
        int length = propertyArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                indentedWriter.print(", ");
            }
            if (z) {
                indentedWriter.print(propertyArr[i].getSimpleTypeName() + ' ');
            }
            indentedWriter.print(propertyArr[i].getName());
        }
    }

    public static void writePropertyMember(Property property, IndentedWriter indentedWriter) throws IOException {
        writePropertyVariable(property, indentedWriter);
    }

    public static void writePropertyVariable(Property property, IndentedWriter indentedWriter) throws IOException {
        writePropertyVariable(property, property.getDefaultValueExpression(), indentedWriter);
    }

    public static void writePropertyMember(Property property, String str, IndentedWriter indentedWriter) throws IOException {
        writePropertyVariable(property, str, indentedWriter);
    }

    public static void writePropertyVariable(Property property, String str, IndentedWriter indentedWriter) throws IOException {
        indentedWriter.print(CodegenUtils.getModifierString(property.getVariableModifiers()));
        indentedWriter.print(' ' + property.getSimpleTypeName() + ' ' + property.getName());
        if (str != null) {
            indentedWriter.print(" = " + str);
        }
        indentedWriter.println(';');
    }

    public static void writePropertyGetter(Property property, IndentedWriter indentedWriter) throws IOException {
        writePropertyGetter(property, property.getDefensiveCopyExpression(), indentedWriter);
    }

    public static void writePropertyGetter(Property property, String str, IndentedWriter indentedWriter) throws IOException {
        String str2 = "boolean".equals(property.getSimpleTypeName()) ? BeanUtil.PREFIX_GETTER_IS : BeanUtil.PREFIX_GETTER_GET;
        indentedWriter.print(CodegenUtils.getModifierString(property.getGetterModifiers()));
        indentedWriter.println(' ' + property.getSimpleTypeName() + ' ' + str2 + capitalize(property.getName()) + "()");
        String str3 = str;
        if (str3 == null) {
            str3 = property.getName();
        }
        indentedWriter.println("{ return " + str3 + "; }");
    }

    public static void writePropertySetter(Property property, IndentedWriter indentedWriter) throws IOException {
        writePropertySetter(property, property.getDefensiveCopyExpression(), indentedWriter);
    }

    public static void writePropertySetter(Property property, String str, IndentedWriter indentedWriter) throws IOException {
        String str2 = str;
        if (str2 == null) {
            str2 = property.getName();
        }
        writePropertySetterWithGetExpressionSetStatement(property, "this." + property.getName(), "this." + property.getName() + " = " + str2 + ';', indentedWriter);
    }

    public static void writePropertySetterWithGetExpressionSetStatement(Property property, String str, String str2, IndentedWriter indentedWriter) throws IOException {
        String str3;
        indentedWriter.print(CodegenUtils.getModifierString(property.getSetterModifiers()));
        indentedWriter.print(" void set" + capitalize(property.getName()) + "( " + property.getSimpleTypeName() + ' ' + property.getName() + " )");
        if (property.isConstrained()) {
            indentedWriter.println(" throws PropertyVetoException");
        } else {
            indentedWriter.println();
        }
        indentedWriter.println('{');
        indentedWriter.upIndent();
        if (changeMarked(property)) {
            indentedWriter.println(property.getSimpleTypeName() + " oldVal = " + str + ';');
            String str4 = "oldVal";
            String name = property.getName();
            String simpleTypeName = property.getSimpleTypeName();
            if (ClassUtils.isPrimitive(simpleTypeName)) {
                Class classForPrimitive = ClassUtils.classForPrimitive(simpleTypeName);
                if (classForPrimitive == Byte.TYPE) {
                    str4 = "new Byte( " + str4 + " )";
                    name = "new Byte( " + name + " )";
                } else if (classForPrimitive == Character.TYPE) {
                    str4 = "new Character( " + str4 + " )";
                    name = "new Character( " + name + " )";
                } else if (classForPrimitive == Short.TYPE) {
                    str4 = "new Short( " + str4 + " )";
                    name = "new Short( " + name + " )";
                } else if (classForPrimitive == Float.TYPE) {
                    str4 = "new Float( " + str4 + " )";
                    name = "new Float( " + name + " )";
                } else if (classForPrimitive == Double.TYPE) {
                    str4 = "new Double( " + str4 + " )";
                    name = "new Double( " + name + " )";
                }
                str3 = "oldVal != " + property.getName();
            } else {
                str3 = "! eqOrBothNull( oldVal, " + property.getName() + " )";
            }
            if (property.isConstrained()) {
                indentedWriter.println("if ( " + str3 + " )");
                indentedWriter.upIndent();
                indentedWriter.println("vcs.fireVetoableChange( \"" + property.getName() + "\", " + str4 + ", " + name + " );");
                indentedWriter.downIndent();
            }
            indentedWriter.println(str2);
            if (property.isBound()) {
                indentedWriter.println("if ( " + str3 + " )");
                indentedWriter.upIndent();
                indentedWriter.println("pcs.firePropertyChange( \"" + property.getName() + "\", " + str4 + ", " + name + " );");
                indentedWriter.downIndent();
            }
        } else {
            indentedWriter.println(str2);
        }
        indentedWriter.downIndent();
        indentedWriter.println('}');
    }

    public static boolean hasBoundProperties(Property[] propertyArr) {
        for (Property property : propertyArr) {
            if (property.isBound()) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasConstrainedProperties(Property[] propertyArr) {
        for (Property property : propertyArr) {
            if (property.isConstrained()) {
                return true;
            }
        }
        return false;
    }

    private static boolean changeMarked(Property property) {
        return property.isBound() || property.isConstrained();
    }

    private BeangenUtils() {
    }
}
