package com.mchange.p009v2.codegen.bean;

import com.mchange.p009v2.codegen.IndentedWriter;
import com.mchange.p009v2.ser.IndirectPolicy;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;

/* renamed from: com.mchange.v2.codegen.bean.IndirectingSerializableExtension */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/IndirectingSerializableExtension.class */
public class IndirectingSerializableExtension extends SerializableExtension {
    protected String findIndirectorExpr;
    protected String indirectorClassName;

    public IndirectingSerializableExtension(String str) {
        this.indirectorClassName = str;
        this.findIndirectorExpr = "new " + str + "()";
    }

    protected IndirectingSerializableExtension() {
    }

    @Override // com.mchange.p009v2.codegen.bean.SerializableExtension, com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraSpecificImports() {
        Collection extraSpecificImports = extraSpecificImports();
        extraSpecificImports.add(this.indirectorClassName);
        extraSpecificImports.add("com.mchange.v2.ser.IndirectlySerialized");
        extraSpecificImports.add("com.mchange.v2.ser.Indirector");
        extraSpecificImports.add("com.mchange.v2.ser.SerializableUtils");
        extraSpecificImports.add("java.io.NotSerializableException");
        return extraSpecificImports;
    }

    protected IndirectPolicy indirectingPolicy(Property property, Class cls) {
        if (Serializable.class.isAssignableFrom(cls)) {
            return IndirectPolicy.DEFINITELY_DIRECT;
        }
        return IndirectPolicy.INDIRECT_ON_EXCEPTION;
    }

    protected void writeInitializeIndirector(Property property, Class cls, IndentedWriter indentedWriter) throws IOException {
    }

    protected void writeExtraDeclarations(ClassInfo classInfo, Class cls, Property[] propertyArr, Class[] clsArr, IndentedWriter indentedWriter) throws IOException {
    }

    @Override // com.mchange.p009v2.codegen.bean.SerializableExtension, com.mchange.p009v2.codegen.bean.GeneratorExtension
    public void generate(ClassInfo classInfo, Class cls, Property[] propertyArr, Class[] clsArr, IndentedWriter indentedWriter) throws IOException {
        generate(classInfo, cls, propertyArr, clsArr, indentedWriter);
        writeExtraDeclarations(classInfo, cls, propertyArr, clsArr, indentedWriter);
    }

    @Override // com.mchange.p009v2.codegen.bean.SerializableExtension
    protected void writeStoreObject(Property property, Class cls, IndentedWriter indentedWriter) throws IOException {
        IndirectPolicy indirectingPolicy = indirectingPolicy(property, cls);
        if (indirectingPolicy == IndirectPolicy.DEFINITELY_INDIRECT) {
            writeIndirectStoreObject(property, cls, indentedWriter);
        } else if (indirectingPolicy == IndirectPolicy.INDIRECT_ON_EXCEPTION) {
            indentedWriter.println("try");
            indentedWriter.println("{");
            indentedWriter.upIndent();
            indentedWriter.println("//test serialize");
            indentedWriter.println("SerializableUtils.toByteArray(" + property.getName() + ");");
            writeStoreObject(property, cls, indentedWriter);
            indentedWriter.downIndent();
            indentedWriter.println("}");
            indentedWriter.println("catch (NotSerializableException nse)");
            indentedWriter.println("{");
            indentedWriter.upIndent();
            writeIndirectStoreObject(property, cls, indentedWriter);
            indentedWriter.downIndent();
            indentedWriter.println("}");
        } else if (indirectingPolicy == IndirectPolicy.DEFINITELY_DIRECT) {
            writeStoreObject(property, cls, indentedWriter);
        } else {
            throw new InternalError("indirectingPolicy() overridden to return unknown policy: " + indirectingPolicy);
        }
    }

    /* access modifiers changed from: protected */
    public void writeIndirectStoreObject(Property property, Class cls, IndentedWriter indentedWriter) throws IOException {
        indentedWriter.println("try");
        indentedWriter.println("{");
        indentedWriter.upIndent();
        indentedWriter.println("Indirector indirector = " + this.findIndirectorExpr + ';');
        writeInitializeIndirector(property, cls, indentedWriter);
        indentedWriter.println("oos.writeObject( indirector.indirectForm( " + property.getName() + " ) );");
        indentedWriter.downIndent();
        indentedWriter.println("}");
        indentedWriter.println("catch (IOException indirectionIOException)");
        indentedWriter.println("{ throw indirectionIOException; }");
        indentedWriter.println("catch (Exception indirectionOtherException)");
        indentedWriter.println("{ throw new IOException(\"Problem indirectly serializing " + property.getName() + ": \" + indirectionOtherException.toString() ); }");
    }

    @Override // com.mchange.p009v2.codegen.bean.SerializableExtension
    protected void writeUnstoreObject(Property property, Class cls, IndentedWriter indentedWriter) throws IOException {
        IndirectPolicy indirectingPolicy = indirectingPolicy(property, cls);
        if (indirectingPolicy == IndirectPolicy.DEFINITELY_INDIRECT || indirectingPolicy == IndirectPolicy.INDIRECT_ON_EXCEPTION) {
            indentedWriter.println("// we create an artificial scope so that we can use the name o for all indirectly serialized objects.");
            indentedWriter.println("{");
            indentedWriter.upIndent();
            indentedWriter.println("Object o = ois.readObject();");
            indentedWriter.println("if (o instanceof IndirectlySerialized) o = ((IndirectlySerialized) o).getObject();");
            indentedWriter.println("this." + property.getName() + " = (" + property.getSimpleTypeName() + ") o;");
            indentedWriter.downIndent();
            indentedWriter.println("}");
        } else if (indirectingPolicy == IndirectPolicy.DEFINITELY_DIRECT) {
            writeUnstoreObject(property, cls, indentedWriter);
        } else {
            throw new InternalError("indirectingPolicy() overridden to return unknown policy: " + indirectingPolicy);
        }
    }
}
