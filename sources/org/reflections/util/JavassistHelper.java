package org.reflections.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javassist.bytecode.AccessFlag;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.AttributeInfo;
import javassist.bytecode.ClassFile;
import javassist.bytecode.Descriptor;
import javassist.bytecode.FieldInfo;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.ParameterAnnotationsAttribute;
import javassist.bytecode.annotation.Annotation;

/* loaded from: grasscutter.jar:org/reflections/util/JavassistHelper.class */
public class JavassistHelper {
    public static boolean includeInvisibleTag = true;

    public static String fieldName(ClassFile classFile, FieldInfo object) {
        return String.format("%s.%s", classFile.getName(), object.getName());
    }

    public static String methodName(ClassFile classFile, MethodInfo object) {
        return String.format("%s.%s(%s)", classFile.getName(), object.getName(), String.join(", ", getParameters(object)));
    }

    public static boolean isPublic(Object object) {
        if (object instanceof ClassFile) {
            return AccessFlag.isPublic(((ClassFile) object).getAccessFlags());
        }
        if (object instanceof FieldInfo) {
            return AccessFlag.isPublic(((FieldInfo) object).getAccessFlags());
        }
        if (object instanceof MethodInfo) {
            return AccessFlag.isPublic(((MethodInfo) object).getAccessFlags());
        }
        return false;
    }

    public static Stream<MethodInfo> getMethods(ClassFile classFile) {
        return classFile.getMethods().stream().filter((v0) -> {
            return v0.isMethod();
        });
    }

    public static Stream<MethodInfo> getConstructors(ClassFile classFile) {
        return classFile.getMethods().stream().filter(methodInfo -> {
            return !methodInfo.isMethod();
        });
    }

    public static List<String> getParameters(MethodInfo method) {
        List<String> result = new ArrayList<>();
        String descriptor = method.getDescriptor().substring(1);
        Descriptor.Iterator iterator = new Descriptor.Iterator(descriptor);
        Integer prev = null;
        while (iterator.hasNext()) {
            int cur = iterator.next();
            if (prev != null) {
                result.add(Descriptor.toString(descriptor.substring(prev.intValue(), cur)));
            }
            prev = Integer.valueOf(cur);
        }
        return result;
    }

    public static String getReturnType(MethodInfo method) {
        String descriptor = method.getDescriptor();
        return Descriptor.toString(descriptor.substring(descriptor.lastIndexOf(")") + 1));
    }

    public static List<String> getAnnotations(Function<String, AttributeInfo> function) {
        Function andThen = function.andThen(attribute -> {
            if (attribute != null) {
                return ((AnnotationsAttribute) attribute).getAnnotations();
            }
            return null;
        }).andThen(JavassistHelper::annotationNames);
        List<String> result = new ArrayList<>((Collection) andThen.apply(AnnotationsAttribute.visibleTag));
        if (includeInvisibleTag) {
            result.addAll((Collection) andThen.apply(AnnotationsAttribute.invisibleTag));
        }
        return result;
    }

    public static List<List<String>> getParametersAnnotations(MethodInfo method) {
        method.getClass();
        Function<String, List<List<String>>> names = this::getAttribute.andThen(attribute -> {
            if (attribute != null) {
                return ((ParameterAnnotationsAttribute) attribute).getAnnotations();
            }
            return null;
        }).andThen(aa -> {
            return aa != null ? (List) Stream.of((Object[]) aa).map(JavassistHelper::annotationNames).collect(Collectors.toList()) : Collections.emptyList();
        });
        List<List<String>> visibleAnnotations = names.apply(ParameterAnnotationsAttribute.visibleTag);
        if (!includeInvisibleTag) {
            return new ArrayList(visibleAnnotations);
        }
        List<List<String>> invisibleAnnotations = names.apply(ParameterAnnotationsAttribute.invisibleTag);
        if (invisibleAnnotations.isEmpty()) {
            return new ArrayList(visibleAnnotations);
        }
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < Math.max(visibleAnnotations.size(), invisibleAnnotations.size()); i++) {
            List<String> concat = new ArrayList<>();
            if (i < visibleAnnotations.size()) {
                concat.addAll(visibleAnnotations.get(i));
            }
            if (i < invisibleAnnotations.size()) {
                concat.addAll(invisibleAnnotations.get(i));
            }
            result.add(concat);
        }
        return result;
    }

    private static List<String> annotationNames(Annotation[] annotations) {
        return annotations != null ? (List) Stream.of((Object[]) annotations).map((v0) -> {
            return v0.getTypeName();
        }).collect(Collectors.toList()) : Collections.emptyList();
    }
}
