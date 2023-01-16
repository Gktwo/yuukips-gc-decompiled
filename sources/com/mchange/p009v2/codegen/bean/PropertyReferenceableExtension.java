package com.mchange.p009v2.codegen.bean;

import com.mchange.p009v2.codegen.IndentedWriter;
import com.mchange.p009v2.naming.JavaBeanObjectFactory;
import com.mchange.p009v2.naming.JavaBeanReferenceMaker;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

/* renamed from: com.mchange.v2.codegen.bean.PropertyReferenceableExtension */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/PropertyReferenceableExtension.class */
public class PropertyReferenceableExtension implements GeneratorExtension {
    boolean explicit_reference_properties = false;
    String factoryClassName = JavaBeanObjectFactory.class.getName();
    String javaBeanReferenceMakerClassName = JavaBeanReferenceMaker.class.getName();

    public void setUseExplicitReferenceProperties(boolean z) {
        this.explicit_reference_properties = z;
    }

    public boolean getUseExplicitReferenceProperties() {
        return this.explicit_reference_properties;
    }

    public void setFactoryClassName(String str) {
        this.factoryClassName = str;
    }

    public String getFactoryClassName() {
        return this.factoryClassName;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraGeneralImports() {
        return new HashSet();
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraSpecificImports() {
        HashSet hashSet = new HashSet();
        hashSet.add("javax.naming.Reference");
        hashSet.add("javax.naming.Referenceable");
        hashSet.add("javax.naming.NamingException");
        hashSet.add("com.mchange.v2.naming.JavaBeanObjectFactory");
        hashSet.add("com.mchange.v2.naming.JavaBeanReferenceMaker");
        hashSet.add("com.mchange.v2.naming.ReferenceMaker");
        return hashSet;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraInterfaceNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("Referenceable");
        return hashSet;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public void generate(ClassInfo classInfo, Class cls, Property[] propertyArr, Class[] clsArr, IndentedWriter indentedWriter) throws IOException {
        indentedWriter.println("final static JavaBeanReferenceMaker referenceMaker = new " + this.javaBeanReferenceMakerClassName + "();");
        indentedWriter.println();
        indentedWriter.println("static");
        indentedWriter.println("{");
        indentedWriter.upIndent();
        indentedWriter.println("referenceMaker.setFactoryClassName( \"" + this.factoryClassName + "\" );");
        if (this.explicit_reference_properties) {
            int length = propertyArr.length;
            for (int i = 0; i < length; i++) {
                indentedWriter.println("referenceMaker.addReferenceProperty(\"" + propertyArr[i].getName() + "\");");
            }
        }
        indentedWriter.downIndent();
        indentedWriter.println("}");
        indentedWriter.println();
        indentedWriter.println("public Reference getReference() throws NamingException");
        indentedWriter.println("{");
        indentedWriter.upIndent();
        indentedWriter.println("return referenceMaker.createReference( this );");
        indentedWriter.downIndent();
        indentedWriter.println("}");
    }
}
