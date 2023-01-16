package com.mchange.p009v2.codegen.bean;

import com.mchange.p009v2.codegen.CodegenUtils;
import java.io.IOException;
import java.lang.reflect.Modifier;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* renamed from: com.mchange.v2.codegen.bean.InnerBeanPropertyBeanGenerator */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/InnerBeanPropertyBeanGenerator.class */
public class InnerBeanPropertyBeanGenerator extends SimplePropertyBeanGenerator {
    String innerBeanClassName;
    int inner_bean_member_modifiers = 4;
    int inner_bean_accessor_modifiers = 4;
    int inner_bean_replacer_modifiers = 4;
    String innerBeanInitializationExpression = null;

    public void setInnerBeanClassName(String str) {
        this.innerBeanClassName = str;
    }

    public String getInnerBeanClassName() {
        return this.innerBeanClassName;
    }

    private String defaultInnerBeanInitializationExpression() {
        return "new " + this.innerBeanClassName + "()";
    }

    private String findInnerBeanClassName() {
        return this.innerBeanClassName == null ? "InnerBean" : this.innerBeanClassName;
    }

    private String findInnerBeanInitializationExpression() {
        return this.innerBeanInitializationExpression == null ? defaultInnerBeanInitializationExpression() : this.innerBeanInitializationExpression;
    }

    /* access modifiers changed from: private */
    public int findInnerClassModifiers() {
        int i = 8;
        if (Modifier.isPublic(this.inner_bean_accessor_modifiers) || Modifier.isPublic(this.inner_bean_replacer_modifiers)) {
            i = 8 | 1;
        } else if (Modifier.isProtected(this.inner_bean_accessor_modifiers) || Modifier.isProtected(this.inner_bean_replacer_modifiers)) {
            i = 8 | 4;
        } else if (Modifier.isPrivate(this.inner_bean_accessor_modifiers) && Modifier.isPrivate(this.inner_bean_replacer_modifiers)) {
            i = 8 | 2;
        }
        return i;
    }

    private void writeSyntheticInnerBeanClass() throws IOException {
        int length = this.props.length;
        Property[] propertyArr = new Property[length];
        for (int i = 0; i < length; i++) {
            propertyArr[i] = new SimplePropertyMask(this.props[i]) { // from class: com.mchange.v2.codegen.bean.InnerBeanPropertyBeanGenerator.1
                @Override // com.mchange.p009v2.codegen.bean.SimplePropertyMask, com.mchange.p009v2.codegen.bean.Property
                public int getVariableModifiers() {
                    return 130;
                }
            };
        }
        createInnerGenerator().generate(new WrapperClassInfo(this.info) { // from class: com.mchange.v2.codegen.bean.InnerBeanPropertyBeanGenerator.2
            @Override // com.mchange.p009v2.codegen.bean.WrapperClassInfo, com.mchange.p009v2.codegen.bean.ClassInfo
            public String getClassName() {
                return "InnerBean";
            }

            @Override // com.mchange.p009v2.codegen.bean.WrapperClassInfo, com.mchange.p009v2.codegen.bean.ClassInfo
            public int getModifiers() {
                return InnerBeanPropertyBeanGenerator.this.findInnerClassModifiers();
            }
        }, propertyArr, this.f414iw);
    }

    protected PropertyBeanGenerator createInnerGenerator() {
        SimplePropertyBeanGenerator simplePropertyBeanGenerator = new SimplePropertyBeanGenerator();
        simplePropertyBeanGenerator.setInner(true);
        simplePropertyBeanGenerator.addExtension(new SerializableExtension());
        CloneableExtension cloneableExtension = new CloneableExtension();
        cloneableExtension.setExceptionSwallowing(true);
        simplePropertyBeanGenerator.addExtension(cloneableExtension);
        return simplePropertyBeanGenerator;
    }

    @Override // com.mchange.p009v2.codegen.bean.SimplePropertyBeanGenerator
    protected void writeOtherVariables() throws IOException {
        this.f414iw.println(CodegenUtils.getModifierString(this.inner_bean_member_modifiers) + ' ' + findInnerBeanClassName() + " innerBean = " + findInnerBeanInitializationExpression() + ';');
        this.f414iw.println();
        this.f414iw.println(CodegenUtils.getModifierString(this.inner_bean_accessor_modifiers) + ' ' + findInnerBeanClassName() + " accessInnerBean()");
        this.f414iw.println("{ return innerBean; }");
    }

    @Override // com.mchange.p009v2.codegen.bean.SimplePropertyBeanGenerator
    protected void writeOtherFunctions() throws IOException {
        this.f414iw.print(CodegenUtils.getModifierString(this.inner_bean_replacer_modifiers) + ' ' + findInnerBeanClassName() + " replaceInnerBean( " + findInnerBeanClassName() + " innerBean )");
        if (constrainedProperties()) {
            this.f414iw.println(" throws PropertyVetoException");
        } else {
            this.f414iw.println();
        }
        this.f414iw.println("{");
        this.f414iw.upIndent();
        this.f414iw.println("beforeReplaceInnerBean();");
        this.f414iw.println("this.innerBean = innerBean;");
        this.f414iw.println("afterReplaceInnerBean();");
        this.f414iw.downIndent();
        this.f414iw.println("}");
        this.f414iw.println();
        boolean isAbstract = Modifier.isAbstract(this.info.getModifiers());
        this.f414iw.print("protected ");
        if (isAbstract) {
            this.f414iw.print("abstract ");
        }
        this.f414iw.print("void beforeReplaceInnerBean()");
        if (constrainedProperties()) {
            this.f414iw.print(" throws PropertyVetoException");
        }
        if (isAbstract) {
            this.f414iw.println(';');
        } else {
            this.f414iw.println(" {} //hook method for subclasses");
        }
        this.f414iw.println();
        this.f414iw.print("protected ");
        if (isAbstract) {
            this.f414iw.print("abstract ");
        }
        this.f414iw.print("void afterReplaceInnerBean()");
        if (isAbstract) {
            this.f414iw.println(';');
        } else {
            this.f414iw.println(" {} //hook method for subclasses");
        }
        this.f414iw.println();
        BeangenUtils.writeExplicitDefaultConstructor(1, this.info, this.f414iw);
        this.f414iw.println();
        this.f414iw.println("public " + this.info.getClassName() + "(" + findInnerBeanClassName() + " innerBean)");
        this.f414iw.println("{ this.innerBean = innerBean; }");
    }

    @Override // com.mchange.p009v2.codegen.bean.SimplePropertyBeanGenerator
    protected void writeOtherClasses() throws IOException {
        if (this.innerBeanClassName == null) {
            writeSyntheticInnerBeanClass();
        }
    }

    @Override // com.mchange.p009v2.codegen.bean.SimplePropertyBeanGenerator
    protected void writePropertyVariable(Property property) throws IOException {
    }

    @Override // com.mchange.p009v2.codegen.bean.SimplePropertyBeanGenerator
    protected void writePropertyGetter(Property property, Class cls) throws IOException {
        String simpleTypeName = property.getSimpleTypeName();
        String str = ("boolean".equals(simpleTypeName) ? BeanUtil.PREFIX_GETTER_IS : BeanUtil.PREFIX_GETTER_GET) + BeangenUtils.capitalize(property.getName());
        this.f414iw.print(CodegenUtils.getModifierString(property.getGetterModifiers()));
        this.f414iw.println(' ' + property.getSimpleTypeName() + ' ' + str + "()");
        this.f414iw.println('{');
        this.f414iw.upIndent();
        this.f414iw.println(simpleTypeName + ' ' + property.getName() + " = innerBean." + str + "();");
        String getterDefensiveCopyExpression = getGetterDefensiveCopyExpression(property, cls);
        if (getterDefensiveCopyExpression == null) {
            getterDefensiveCopyExpression = property.getName();
        }
        this.f414iw.println("return " + getterDefensiveCopyExpression + ';');
        this.f414iw.downIndent();
        this.f414iw.println('}');
    }

    @Override // com.mchange.p009v2.codegen.bean.SimplePropertyBeanGenerator
    protected void writePropertySetter(Property property, Class cls) throws IOException {
        String str = "boolean".equals(property.getSimpleTypeName()) ? BeanUtil.PREFIX_GETTER_IS : BeanUtil.PREFIX_GETTER_GET;
        String setterDefensiveCopyExpression = getSetterDefensiveCopyExpression(property, cls);
        if (setterDefensiveCopyExpression == null) {
            setterDefensiveCopyExpression = property.getName();
        }
        BeangenUtils.writePropertySetterWithGetExpressionSetStatement(property, "innerBean." + str + BeangenUtils.capitalize(property.getName()) + "()", "innerBean.set" + BeangenUtils.capitalize(property.getName()) + "( " + setterDefensiveCopyExpression + " );", this.f414iw);
    }
}
