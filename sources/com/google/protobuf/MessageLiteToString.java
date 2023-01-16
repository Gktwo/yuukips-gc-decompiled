package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import net.bytebuddy.utility.JavaConstant;
import p001ch.qos.logback.core.joran.action.Action;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/protobuf/MessageLiteToString.class */
public final class MessageLiteToString {
    private static final String LIST_SUFFIX = "List";
    private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
    private static final String MAP_SUFFIX = "Map";
    private static final String BYTES_SUFFIX = "Bytes";

    MessageLiteToString() {
    }

    /* access modifiers changed from: package-private */
    public static String toString(MessageLite messageLite, String commentString) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("# ").append(commentString);
        reflectivePrintWithIndent(messageLite, buffer, 0);
        return buffer.toString();
    }

    private static void reflectivePrintWithIndent(MessageLite messageLite, StringBuilder buffer, int indent) {
        boolean hasValue;
        Map<String, Method> nameToNoArgMethod = new HashMap<>();
        Map<String, Method> nameToMethod = new HashMap<>();
        Set<String> getters = new TreeSet<>();
        Method[] declaredMethods = messageLite.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            nameToMethod.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                nameToNoArgMethod.put(method.getName(), method);
                if (method.getName().startsWith(BeanUtil.PREFIX_GETTER_GET)) {
                    getters.add(method.getName());
                }
            }
        }
        for (String getter : getters) {
            String suffix = getter.startsWith(BeanUtil.PREFIX_GETTER_GET) ? getter.substring(3) : getter;
            if (suffix.endsWith(LIST_SUFFIX) && !suffix.endsWith(BUILDER_LIST_SUFFIX) && !suffix.equals(LIST_SUFFIX)) {
                String camelCase = suffix.substring(0, 1).toLowerCase() + suffix.substring(1, suffix.length() - LIST_SUFFIX.length());
                Method listMethod = nameToNoArgMethod.get(getter);
                if (listMethod != null && listMethod.getReturnType().equals(List.class)) {
                    printField(buffer, indent, camelCaseToSnakeCase(camelCase), GeneratedMessageLite.invokeOrDie(listMethod, messageLite, new Object[0]));
                }
            }
            if (suffix.endsWith(MAP_SUFFIX) && !suffix.equals(MAP_SUFFIX)) {
                String camelCase2 = suffix.substring(0, 1).toLowerCase() + suffix.substring(1, suffix.length() - MAP_SUFFIX.length());
                Method mapMethod = nameToNoArgMethod.get(getter);
                if (mapMethod != null && mapMethod.getReturnType().equals(Map.class) && !mapMethod.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(mapMethod.getModifiers())) {
                    printField(buffer, indent, camelCaseToSnakeCase(camelCase2), GeneratedMessageLite.invokeOrDie(mapMethod, messageLite, new Object[0]));
                }
            }
            if (nameToMethod.get("set" + suffix) != null && (!suffix.endsWith(BYTES_SUFFIX) || !nameToNoArgMethod.containsKey(BeanUtil.PREFIX_GETTER_GET + suffix.substring(0, suffix.length() - BYTES_SUFFIX.length())))) {
                String camelCase3 = suffix.substring(0, 1).toLowerCase() + suffix.substring(1);
                Method getMethod = nameToNoArgMethod.get(BeanUtil.PREFIX_GETTER_GET + suffix);
                Method hasMethod = nameToNoArgMethod.get("has" + suffix);
                if (getMethod != null) {
                    Object value = GeneratedMessageLite.invokeOrDie(getMethod, messageLite, new Object[0]);
                    if (hasMethod == null) {
                        hasValue = !isDefaultValue(value);
                    } else {
                        hasValue = ((Boolean) GeneratedMessageLite.invokeOrDie(hasMethod, messageLite, new Object[0])).booleanValue();
                    }
                    if (hasValue) {
                        printField(buffer, indent, camelCaseToSnakeCase(camelCase3), value);
                    }
                }
            }
        }
        if (messageLite instanceof GeneratedMessageLite.ExtendableMessage) {
            Iterator<Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object>> iter = ((GeneratedMessageLite.ExtendableMessage) messageLite).extensions.iterator();
            while (iter.hasNext()) {
                Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object> entry = iter.next();
                printField(buffer, indent, "[" + entry.getKey().getNumber() + "]", entry.getValue());
            }
        }
        if (((GeneratedMessageLite) messageLite).unknownFields != null) {
            ((GeneratedMessageLite) messageLite).unknownFields.printWithIndent(buffer, indent);
        }
    }

    private static boolean isDefaultValue(Object o) {
        if (o instanceof Boolean) {
            return !((Boolean) o).booleanValue();
        }
        if (o instanceof Integer) {
            return ((Integer) o).intValue() == 0;
        }
        if (o instanceof Float) {
            return ((Float) o).floatValue() == 0.0f;
        }
        if (o instanceof Double) {
            return ((Double) o).doubleValue() == 0.0d;
        }
        if (o instanceof String) {
            return o.equals("");
        }
        if (o instanceof ByteString) {
            return o.equals(ByteString.EMPTY);
        }
        return o instanceof MessageLite ? o == ((MessageLite) o).getDefaultInstanceForType() : (o instanceof Enum) && ((Enum) o).ordinal() == 0;
    }

    /* access modifiers changed from: package-private */
    public static final void printField(StringBuilder buffer, int indent, String name, Object object) {
        if (object instanceof List) {
            Iterator<?> it = ((List) object).iterator();
            while (it.hasNext()) {
                printField(buffer, indent, name, it.next());
            }
        } else if (object instanceof Map) {
            for (Map.Entry<?, ?> entry : ((Map) object).entrySet()) {
                printField(buffer, indent, name, entry);
            }
        } else {
            buffer.append('\n');
            for (int i = 0; i < indent; i++) {
                buffer.append(' ');
            }
            buffer.append(name);
            if (object instanceof String) {
                buffer.append(": \"").append(TextFormatEscaper.escapeText((String) object)).append('\"');
            } else if (object instanceof ByteString) {
                buffer.append(": \"").append(TextFormatEscaper.escapeBytes((ByteString) object)).append('\"');
            } else if (object instanceof GeneratedMessageLite) {
                buffer.append(" {");
                reflectivePrintWithIndent((GeneratedMessageLite) object, buffer, indent + 2);
                buffer.append("\n");
                for (int i2 = 0; i2 < indent; i2++) {
                    buffer.append(' ');
                }
                buffer.append("}");
            } else if (object instanceof Map.Entry) {
                buffer.append(" {");
                Map.Entry<?, ?> entry2 = (Map.Entry) object;
                printField(buffer, indent + 2, Action.KEY_ATTRIBUTE, entry2.getKey());
                printField(buffer, indent + 2, "value", entry2.getValue());
                buffer.append("\n");
                for (int i3 = 0; i3 < indent; i3++) {
                    buffer.append(' ');
                }
                buffer.append("}");
            } else {
                buffer.append(": ").append(object.toString());
            }
        }
    }

    private static final String camelCaseToSnakeCase(String camelCase) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < camelCase.length(); i++) {
            char ch = camelCase.charAt(i);
            if (Character.isUpperCase(ch)) {
                builder.append(JavaConstant.Dynamic.DEFAULT_NAME);
            }
            builder.append(Character.toLowerCase(ch));
        }
        return builder.toString();
    }
}
