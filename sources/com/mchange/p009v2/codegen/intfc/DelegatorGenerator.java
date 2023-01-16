package com.mchange.p009v2.codegen.intfc;

import com.mchange.p006v1.lang.ClassUtils;
import com.mchange.p009v2.codegen.CodegenUtils;
import com.mchange.p009v2.codegen.IndentedWriter;
import dev.morphia.mapping.Mapper;
import emu.grasscutter.net.packet.PacketOpcodes;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/* renamed from: com.mchange.v2.codegen.intfc.DelegatorGenerator */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/intfc/DelegatorGenerator.class */
public class DelegatorGenerator {
    int class_modifiers = PacketOpcodes.ProudSkillExtraLevelNotify;
    int method_modifiers = 1;
    int wrapping_ctor_modifiers = 1;
    int default_ctor_modifiers = 1;
    boolean wrapping_constructor = true;
    boolean default_constructor = true;
    boolean inner_getter = true;
    boolean inner_setter = true;
    Class superclass = null;
    Class[] extraInterfaces = null;
    Method[] reflectiveDelegateMethods = null;
    ReflectiveDelegationPolicy reflectiveDelegationPolicy = ReflectiveDelegationPolicy.USE_MAIN_DELEGATE_INTERFACE;
    static final Comparator classComp = new Comparator() { // from class: com.mchange.v2.codegen.intfc.DelegatorGenerator.1
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Class) obj).getName().compareTo(((Class) obj2).getName());
        }
    };

    public void setGenerateInnerSetter(boolean z) {
        this.inner_setter = z;
    }

    public boolean isGenerateInnerSetter() {
        return this.inner_setter;
    }

    public void setGenerateInnerGetter(boolean z) {
        this.inner_getter = z;
    }

    public boolean isGenerateInnerGetter() {
        return this.inner_getter;
    }

    public void setGenerateNoArgConstructor(boolean z) {
        this.default_constructor = z;
    }

    public boolean isGenerateNoArgConstructor() {
        return this.default_constructor;
    }

    public void setGenerateWrappingConstructor(boolean z) {
        this.wrapping_constructor = z;
    }

    public boolean isGenerateWrappingConstructor() {
        return this.wrapping_constructor;
    }

    public void setWrappingConstructorModifiers(int i) {
        this.wrapping_ctor_modifiers = i;
    }

    public int getWrappingConstructorModifiers() {
        return this.wrapping_ctor_modifiers;
    }

    public void setNoArgConstructorModifiers(int i) {
        this.default_ctor_modifiers = i;
    }

    public int getNoArgConstructorModifiers() {
        return this.default_ctor_modifiers;
    }

    public void setMethodModifiers(int i) {
        this.method_modifiers = i;
    }

    public int getMethodModifiers() {
        return this.method_modifiers;
    }

    public void setClassModifiers(int i) {
        this.class_modifiers = i;
    }

    public int getClassModifiers() {
        return this.class_modifiers;
    }

    public void setSuperclass(Class cls) {
        this.superclass = cls;
    }

    public Class getSuperclass() {
        return this.superclass;
    }

    public void setExtraInterfaces(Class[] clsArr) {
        this.extraInterfaces = clsArr;
    }

    public Class[] getExtraInterfaces() {
        return this.extraInterfaces;
    }

    public Method[] getReflectiveDelegateMethods() {
        return this.reflectiveDelegateMethods;
    }

    public void setReflectiveDelegateMethods(Method[] methodArr) {
        this.reflectiveDelegateMethods = methodArr;
    }

    public ReflectiveDelegationPolicy getReflectiveDelegationPolicy() {
        return this.reflectiveDelegationPolicy;
    }

    public void setReflectiveDelegationPolicy(ReflectiveDelegationPolicy reflectiveDelegationPolicy) {
        this.reflectiveDelegationPolicy = reflectiveDelegationPolicy;
    }

    public void writeDelegator(Class cls, String str, Writer writer) throws IOException {
        String str2;
        IndentedWriter indentedWriter = CodegenUtils.toIndentedWriter(writer);
        String substring = str.substring(0, str.lastIndexOf(46));
        String fqcnLastElement = CodegenUtils.fqcnLastElement(str);
        String simpleClassName = this.superclass != null ? ClassUtils.simpleClassName(this.superclass) : null;
        String simpleClassName2 = ClassUtils.simpleClassName(cls);
        String[] strArr = null;
        if (this.extraInterfaces != null) {
            strArr = new String[this.extraInterfaces.length];
            int length = this.extraInterfaces.length;
            for (int i = 0; i < length; i++) {
                strArr[i] = ClassUtils.simpleClassName(this.extraInterfaces[i]);
            }
        }
        TreeSet treeSet = new TreeSet(classComp);
        Method[] methods = cls.getMethods();
        if (!CodegenUtils.inSamePackage(cls.getName(), str)) {
            treeSet.add(cls);
        }
        if (this.superclass != null && !CodegenUtils.inSamePackage(this.superclass.getName(), str)) {
            treeSet.add(this.superclass);
        }
        if (this.extraInterfaces != null) {
            int length2 = this.extraInterfaces.length;
            for (int i2 = 0; i2 < length2; i2++) {
                Class cls2 = this.extraInterfaces[i2];
                if (!CodegenUtils.inSamePackage(cls2.getName(), str)) {
                    treeSet.add(cls2);
                }
            }
        }
        ensureImports(str, treeSet, methods);
        if (this.reflectiveDelegateMethods != null) {
            ensureImports(str, treeSet, this.reflectiveDelegateMethods);
        }
        if (this.reflectiveDelegationPolicy.delegateClass != null && !CodegenUtils.inSamePackage(this.reflectiveDelegationPolicy.delegateClass.getName(), str)) {
            treeSet.add(this.reflectiveDelegationPolicy.delegateClass);
        }
        generateBannerComment(indentedWriter);
        indentedWriter.println("package " + substring + ';');
        indentedWriter.println();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            indentedWriter.println("import " + ((Class) it.next()).getName() + ';');
        }
        generateExtraImports(indentedWriter);
        indentedWriter.println();
        generateClassJavaDocComment(indentedWriter);
        indentedWriter.print(CodegenUtils.getModifierString(this.class_modifiers) + " class " + fqcnLastElement);
        if (this.superclass != null) {
            indentedWriter.print(" extends " + simpleClassName);
        }
        indentedWriter.print(" implements " + simpleClassName2);
        if (strArr != null) {
            int length3 = strArr.length;
            for (int i3 = 0; i3 < length3; i3++) {
                indentedWriter.print(", " + strArr[i3]);
            }
        }
        indentedWriter.println();
        indentedWriter.println("{");
        indentedWriter.upIndent();
        indentedWriter.println("protected " + simpleClassName2 + " inner;");
        indentedWriter.println();
        if (this.reflectiveDelegateMethods != null) {
            indentedWriter.println("protected Class __delegateClass = null;");
        }
        indentedWriter.println();
        indentedWriter.println("private void __setInner( " + simpleClassName2 + " inner )");
        indentedWriter.println("{");
        indentedWriter.upIndent();
        indentedWriter.println("this.inner = inner;");
        if (this.reflectiveDelegateMethods != null) {
            if (this.reflectiveDelegationPolicy == ReflectiveDelegationPolicy.USE_MAIN_DELEGATE_INTERFACE) {
                str2 = simpleClassName2 + ".class";
            } else if (this.reflectiveDelegationPolicy == ReflectiveDelegationPolicy.USE_RUNTIME_CLASS) {
                str2 = "inner.getClass()";
            } else {
                str2 = ClassUtils.simpleClassName(this.reflectiveDelegationPolicy.delegateClass) + ".class";
            }
            indentedWriter.println("this.__delegateClass = inner == null ? null : " + str2 + ";");
        }
        indentedWriter.downIndent();
        indentedWriter.println("}");
        indentedWriter.println();
        if (this.wrapping_constructor) {
            indentedWriter.println(CodegenUtils.getModifierString(this.wrapping_ctor_modifiers) + ' ' + fqcnLastElement + '(' + simpleClassName2 + " inner)");
            indentedWriter.println("{ __setInner( inner ); }");
        }
        if (this.default_constructor) {
            indentedWriter.println();
            indentedWriter.println(CodegenUtils.getModifierString(this.default_ctor_modifiers) + ' ' + fqcnLastElement + "()");
            indentedWriter.println("{}");
        }
        if (this.inner_setter) {
            indentedWriter.println();
            indentedWriter.println(CodegenUtils.getModifierString(this.method_modifiers) + " void setInner( " + simpleClassName2 + " inner )");
            indentedWriter.println("{ __setInner( inner ); }");
        }
        if (this.inner_getter) {
            indentedWriter.println();
            indentedWriter.println(CodegenUtils.getModifierString(this.method_modifiers) + ' ' + simpleClassName2 + " getInner()");
            indentedWriter.println("{ return inner; }");
        }
        indentedWriter.println();
        int length4 = methods.length;
        for (int i4 = 0; i4 < length4; i4++) {
            Method method = methods[i4];
            if (i4 != 0) {
                indentedWriter.println();
            }
            indentedWriter.println(CodegenUtils.methodSignature(this.method_modifiers, method, null));
            indentedWriter.println("{");
            indentedWriter.upIndent();
            generatePreDelegateCode(cls, str, method, indentedWriter);
            generateDelegateCode(cls, str, method, indentedWriter);
            generatePostDelegateCode(cls, str, method, indentedWriter);
            indentedWriter.downIndent();
            indentedWriter.println("}");
        }
        if (this.reflectiveDelegateMethods != null) {
            indentedWriter.println("// Methods not in core interface to be delegated via reflection");
            int length5 = this.reflectiveDelegateMethods.length;
            for (int i5 = 0; i5 < length5; i5++) {
                Method method2 = this.reflectiveDelegateMethods[i5];
                if (i5 != 0) {
                    indentedWriter.println();
                }
                indentedWriter.println(CodegenUtils.methodSignature(this.method_modifiers, method2, null));
                indentedWriter.println("{");
                indentedWriter.upIndent();
                generatePreDelegateCode(cls, str, method2, indentedWriter);
                generateReflectiveDelegateCode(cls, str, method2, indentedWriter);
                generatePostDelegateCode(cls, str, method2, indentedWriter);
                indentedWriter.downIndent();
                indentedWriter.println("}");
            }
        }
        indentedWriter.println();
        generateExtraDeclarations(cls, str, indentedWriter);
        indentedWriter.downIndent();
        indentedWriter.println("}");
    }

    private void ensureImports(String str, Set set, Method[] methodArr) {
        int length = methodArr.length;
        for (int i = 0; i < length; i++) {
            Class<?>[] parameterTypes = methodArr[i].getParameterTypes();
            int length2 = parameterTypes.length;
            for (int i2 = 0; i2 < length2; i2++) {
                if (!CodegenUtils.inSamePackage(parameterTypes[i2].getName(), str)) {
                    set.add(CodegenUtils.unarrayClass(parameterTypes[i2]));
                }
            }
            Class<?>[] exceptionTypes = methodArr[i].getExceptionTypes();
            int length3 = exceptionTypes.length;
            for (int i3 = 0; i3 < length3; i3++) {
                if (!CodegenUtils.inSamePackage(exceptionTypes[i3].getName(), str)) {
                    set.add(CodegenUtils.unarrayClass(exceptionTypes[i3]));
                }
            }
            if (!CodegenUtils.inSamePackage(methodArr[i].getReturnType().getName(), str)) {
                set.add(CodegenUtils.unarrayClass(methodArr[i].getReturnType()));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void generateDelegateCode(Class cls, String str, Method method, IndentedWriter indentedWriter) throws IOException {
        indentedWriter.println((method.getReturnType() == Void.TYPE ? "" : "return ") + "inner." + CodegenUtils.methodCall(method) + ";");
    }

    protected void generateReflectiveDelegateCode(Class cls, String str, Method method, IndentedWriter indentedWriter) throws IOException {
        Class<?> returnType = method.getReturnType();
        String reflectiveMethodParameterTypeArray = CodegenUtils.reflectiveMethodParameterTypeArray(method);
        String reflectiveMethodObjectArray = CodegenUtils.reflectiveMethodObjectArray(method);
        Class<?>[] exceptionTypes = method.getExceptionTypes();
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(exceptionTypes));
        indentedWriter.println("try");
        indentedWriter.println("{");
        indentedWriter.upIndent();
        indentedWriter.println("Method m = __delegateClass.getMethod(\"" + method.getName() + "\", " + reflectiveMethodParameterTypeArray + ");");
        indentedWriter.println((returnType == Void.TYPE ? "" : "return (" + ClassUtils.simpleClassName(returnType) + ") ") + "m.invoke( inner, " + reflectiveMethodObjectArray + " );");
        indentedWriter.downIndent();
        indentedWriter.println("}");
        if (!hashSet.contains(IllegalAccessException.class)) {
            indentedWriter.println("catch (IllegalAccessException iae)");
            indentedWriter.println("{");
            indentedWriter.upIndent();
            indentedWriter.println("throw new RuntimeException(\"A reflectively delegated method '" + method.getName() + "' cannot access the object to which the call is delegated\", iae);");
            indentedWriter.downIndent();
            indentedWriter.println("}");
        }
        indentedWriter.println("catch (InvocationTargetException ite)");
        indentedWriter.println("{");
        indentedWriter.upIndent();
        indentedWriter.println("Throwable cause = ite.getCause();");
        indentedWriter.println("if (cause instanceof RuntimeException) throw (RuntimeException) cause;");
        indentedWriter.println("if (cause instanceof Error) throw (Error) cause;");
        int length = exceptionTypes.length;
        if (length > 0) {
            for (Class<?> cls2 : exceptionTypes) {
                String simpleClassName = ClassUtils.simpleClassName(cls2);
                indentedWriter.println("if (cause instanceof " + simpleClassName + ") throw (" + simpleClassName + ") cause;");
            }
        }
        indentedWriter.println("throw new RuntimeException(\"Target of reflectively delegated method '" + method.getName() + "' threw an Exception.\", cause);");
        indentedWriter.downIndent();
        indentedWriter.println("}");
    }

    protected void generateBannerComment(IndentedWriter indentedWriter) throws IOException {
        indentedWriter.println("/*");
        indentedWriter.println(" * This class generated by " + getClass().getName());
        indentedWriter.println(" * " + new Date());
        indentedWriter.println(" * DO NOT HAND EDIT!!!!");
        indentedWriter.println(" */");
    }

    protected void generateClassJavaDocComment(IndentedWriter indentedWriter) throws IOException {
        indentedWriter.println("/**");
        indentedWriter.println(" * This class was generated by " + getClass().getName() + Mapper.IGNORED_FIELDNAME);
        indentedWriter.println(" */");
    }

    protected void generateExtraImports(IndentedWriter indentedWriter) throws IOException {
    }

    protected void generatePreDelegateCode(Class cls, String str, Method method, IndentedWriter indentedWriter) throws IOException {
    }

    protected void generatePostDelegateCode(Class cls, String str, Method method, IndentedWriter indentedWriter) throws IOException {
    }

    protected void generateExtraDeclarations(Class cls, String str, IndentedWriter indentedWriter) throws IOException {
    }
}
