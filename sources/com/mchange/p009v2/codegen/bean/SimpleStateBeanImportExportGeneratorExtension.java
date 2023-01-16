package com.mchange.p009v2.codegen.bean;

import com.mchange.p009v2.codegen.IndentedWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.mchange.v2.codegen.bean.SimpleStateBeanImportExportGeneratorExtension */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/SimpleStateBeanImportExportGeneratorExtension.class */
public class SimpleStateBeanImportExportGeneratorExtension implements GeneratorExtension {
    int ctor_modifiers = 1;

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraGeneralImports() {
        return Collections.EMPTY_SET;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraSpecificImports() {
        return Collections.EMPTY_SET;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraInterfaceNames() {
        return Collections.EMPTY_SET;
    }

    /* renamed from: com.mchange.v2.codegen.bean.SimpleStateBeanImportExportGeneratorExtension$SimplePropertyMask */
    /* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/SimpleStateBeanImportExportGeneratorExtension$SimplePropertyMask.class */
    static class SimplePropertyMask implements Property {

        /* renamed from: p */
        Property f416p;

        SimplePropertyMask(Property property) {
            this.f416p = property;
        }

        @Override // com.mchange.p009v2.codegen.bean.Property
        public int getVariableModifiers() {
            return 2;
        }

        @Override // com.mchange.p009v2.codegen.bean.Property
        public String getName() {
            return this.f416p.getName();
        }

        @Override // com.mchange.p009v2.codegen.bean.Property
        public String getSimpleTypeName() {
            return this.f416p.getSimpleTypeName();
        }

        @Override // com.mchange.p009v2.codegen.bean.Property
        public String getDefensiveCopyExpression() {
            return null;
        }

        @Override // com.mchange.p009v2.codegen.bean.Property
        public String getDefaultValueExpression() {
            return null;
        }

        @Override // com.mchange.p009v2.codegen.bean.Property
        public int getGetterModifiers() {
            return 1;
        }

        @Override // com.mchange.p009v2.codegen.bean.Property
        public int getSetterModifiers() {
            return 1;
        }

        @Override // com.mchange.p009v2.codegen.bean.Property
        public boolean isReadOnly() {
            return false;
        }

        @Override // com.mchange.p009v2.codegen.bean.Property
        public boolean isBound() {
            return false;
        }

        @Override // com.mchange.p009v2.codegen.bean.Property
        public boolean isConstrained() {
            return false;
        }
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public void generate(ClassInfo classInfo, Class cls, Property[] propertyArr, Class[] clsArr, IndentedWriter indentedWriter) throws IOException {
        int length = propertyArr.length;
        Property[] propertyArr2 = new Property[length];
        for (int i = 0; i < length; i++) {
            propertyArr2[i] = new SimplePropertyMask(propertyArr[i]);
        }
        indentedWriter.println("protected static class SimpleStateBean implements ExportedState");
        indentedWriter.println("{");
        indentedWriter.upIndent();
        for (int i2 = 0; i2 < length; i2++) {
            propertyArr2[i2] = new SimplePropertyMask(propertyArr[i2]);
            BeangenUtils.writePropertyMember(propertyArr2[i2], indentedWriter);
            indentedWriter.println();
            BeangenUtils.writePropertyGetter(propertyArr2[i2], indentedWriter);
            indentedWriter.println();
            BeangenUtils.writePropertySetter(propertyArr2[i2], indentedWriter);
        }
        indentedWriter.downIndent();
        indentedWriter.println("}");
    }
}
