package org.reflections.scanners;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javassist.bytecode.ClassFile;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import org.reflections.util.JavassistHelper;

/* loaded from: grasscutter.jar:org/reflections/scanners/MethodParameterNamesScanner.class */
public class MethodParameterNamesScanner implements Scanner {
    @Override // org.reflections.scanners.Scanner
    public List<Map.Entry<String, String>> scan(ClassFile classFile) {
        List<Map.Entry<String, String>> entries = new ArrayList<>();
        for (MethodInfo method : classFile.getMethods()) {
            String key = JavassistHelper.methodName(classFile, method);
            String value = getString(method);
            if (!value.isEmpty()) {
                entries.add(entry(key, value));
            }
        }
        return entries;
    }

    private String getString(MethodInfo method) {
        CodeAttribute codeAttribute = method.getCodeAttribute();
        LocalVariableAttribute table = codeAttribute != null ? (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag) : null;
        int length = JavassistHelper.getParameters(method).size();
        if (length <= 0) {
            return "";
        }
        int shift = Modifier.isStatic(method.getAccessFlags()) ? 0 : 1;
        return (String) IntStream.range(shift, length + shift).mapToObj(i -> {
            return method.getConstPool().getUtf8Info(table.nameIndex(i));
        }).filter(name -> {
            return !name.startsWith("this$");
        }).collect(Collectors.joining(", "));
    }
}
