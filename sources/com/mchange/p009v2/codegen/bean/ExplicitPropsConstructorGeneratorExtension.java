package com.mchange.p009v2.codegen.bean;

import com.mchange.p009v2.codegen.CodegenUtils;
import com.mchange.p009v2.codegen.IndentedWriter;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.mchange.v2.codegen.bean.ExplicitPropsConstructorGeneratorExtension */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/ExplicitPropsConstructorGeneratorExtension.class */
public class ExplicitPropsConstructorGeneratorExtension implements GeneratorExtension {
    static final MLogger logger = MLog.getLogger(ExplicitPropsConstructorGeneratorExtension.class);
    String[] propNames;
    boolean skips_silently = false;
    int ctor_modifiers = 1;

    public ExplicitPropsConstructorGeneratorExtension() {
    }

    public ExplicitPropsConstructorGeneratorExtension(String[] strArr) {
        this.propNames = strArr;
    }

    public String[] getPropNames() {
        return (String[]) this.propNames.clone();
    }

    public void setPropNames(String[] strArr) {
        this.propNames = (String[]) strArr.clone();
    }

    public boolean isSkipsSilently() {
        return this.skips_silently;
    }

    public void setsSkipsSilently(boolean z) {
        this.skips_silently = z;
    }

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

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public void generate(ClassInfo classInfo, Class cls, Property[] propertyArr, Class[] clsArr, IndentedWriter indentedWriter) throws IOException {
        HashMap hashMap = new HashMap();
        int length = propertyArr.length;
        for (int i = 0; i < length; i++) {
            hashMap.put(propertyArr[i].getName(), propertyArr[i]);
        }
        ArrayList arrayList = new ArrayList(this.propNames.length);
        int length2 = this.propNames.length;
        for (int i2 = 0; i2 < length2; i2++) {
            Property property = (Property) hashMap.get(this.propNames[i2]);
            if (property == null) {
                logger.warning("Could not include property '" + this.propNames[i2] + "' in explicit-props-constructor generated for bean class '" + classInfo.getClassName() + "' because the property is not defined for the bean. Skipping.");
            } else {
                arrayList.add(property);
            }
        }
        if (arrayList.size() > 0) {
            Property[] propertyArr2 = (Property[]) arrayList.toArray(new Property[arrayList.size()]);
            indentedWriter.print(CodegenUtils.getModifierString(this.ctor_modifiers));
            indentedWriter.print(classInfo.getClassName() + "( ");
            BeangenUtils.writeArgList(propertyArr2, true, indentedWriter);
            indentedWriter.println(" )");
            indentedWriter.println("{");
            indentedWriter.upIndent();
            int length3 = propertyArr2.length;
            for (int i3 = 0; i3 < length3; i3++) {
                indentedWriter.print("this." + propertyArr2[i3].getName() + " = ");
                String defensiveCopyExpression = propertyArr2[i3].getDefensiveCopyExpression();
                if (defensiveCopyExpression == null) {
                    defensiveCopyExpression = propertyArr2[i3].getName();
                }
                indentedWriter.println(defensiveCopyExpression + ';');
            }
            indentedWriter.downIndent();
            indentedWriter.println("}");
        }
    }
}
