package com.mchange.p009v2.codegen.bean;

import com.mchange.p009v2.codegen.IndentedWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.mchange.v2.codegen.bean.SerializableExtension */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/SerializableExtension.class */
public class SerializableExtension implements GeneratorExtension {
    Set transientProperties;
    Map transientPropertyInitializers;

    public SerializableExtension(Set set, Map map) {
        this.transientProperties = set;
        this.transientPropertyInitializers = map;
    }

    public SerializableExtension() {
        this(Collections.EMPTY_SET, null);
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraGeneralImports() {
        return Collections.EMPTY_SET;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraSpecificImports() {
        HashSet hashSet = new HashSet();
        hashSet.add("java.io.IOException");
        hashSet.add("java.io.Serializable");
        hashSet.add("java.io.ObjectOutputStream");
        hashSet.add("java.io.ObjectInputStream");
        return hashSet;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraInterfaceNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("Serializable");
        return hashSet;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public void generate(ClassInfo classInfo, Class cls, Property[] propertyArr, Class[] clsArr, IndentedWriter indentedWriter) throws IOException {
        indentedWriter.println("private static final long serialVersionUID = 1;");
        indentedWriter.println("private static final short VERSION = 0x0001;");
        indentedWriter.println();
        indentedWriter.println("private void writeObject( ObjectOutputStream oos ) throws IOException");
        indentedWriter.println("{");
        indentedWriter.upIndent();
        indentedWriter.println("oos.writeShort( VERSION );");
        int length = propertyArr.length;
        for (int i = 0; i < length; i++) {
            Property property = propertyArr[i];
            if (!this.transientProperties.contains(property.getName())) {
                Class cls2 = clsArr[i];
                if (cls2 == null || !cls2.isPrimitive()) {
                    writeStoreObject(property, cls2, indentedWriter);
                } else if (cls2 == Byte.TYPE) {
                    indentedWriter.println("oos.writeByte(" + property.getName() + ");");
                } else if (cls2 == Character.TYPE) {
                    indentedWriter.println("oos.writeChar(" + property.getName() + ");");
                } else if (cls2 == Short.TYPE) {
                    indentedWriter.println("oos.writeShort(" + property.getName() + ");");
                } else if (cls2 == Integer.TYPE) {
                    indentedWriter.println("oos.writeInt(" + property.getName() + ");");
                } else if (cls2 == Boolean.TYPE) {
                    indentedWriter.println("oos.writeBoolean(" + property.getName() + ");");
                } else if (cls2 == Long.TYPE) {
                    indentedWriter.println("oos.writeLong(" + property.getName() + ");");
                } else if (cls2 == Float.TYPE) {
                    indentedWriter.println("oos.writeFloat(" + property.getName() + ");");
                } else if (cls2 == Double.TYPE) {
                    indentedWriter.println("oos.writeDouble(" + property.getName() + ");");
                }
            }
        }
        generateExtraSerWriteStatements(classInfo, cls, propertyArr, clsArr, indentedWriter);
        indentedWriter.downIndent();
        indentedWriter.println("}");
        indentedWriter.println();
        indentedWriter.println("private void readObject( ObjectInputStream ois ) throws IOException, ClassNotFoundException");
        indentedWriter.println("{");
        indentedWriter.upIndent();
        indentedWriter.println("short version = ois.readShort();");
        indentedWriter.println("switch (version)");
        indentedWriter.println("{");
        indentedWriter.upIndent();
        indentedWriter.println("case VERSION:");
        indentedWriter.upIndent();
        int length2 = propertyArr.length;
        for (int i2 = 0; i2 < length2; i2++) {
            Property property2 = propertyArr[i2];
            if (!this.transientProperties.contains(property2.getName())) {
                Class cls3 = clsArr[i2];
                if (cls3 == null || !cls3.isPrimitive()) {
                    writeUnstoreObject(property2, cls3, indentedWriter);
                } else if (cls3 == Byte.TYPE) {
                    indentedWriter.println("this." + property2.getName() + " = ois.readByte();");
                } else if (cls3 == Character.TYPE) {
                    indentedWriter.println("this." + property2.getName() + " = ois.readChar();");
                } else if (cls3 == Short.TYPE) {
                    indentedWriter.println("this." + property2.getName() + " = ois.readShort();");
                } else if (cls3 == Integer.TYPE) {
                    indentedWriter.println("this." + property2.getName() + " = ois.readInt();");
                } else if (cls3 == Boolean.TYPE) {
                    indentedWriter.println("this." + property2.getName() + " = ois.readBoolean();");
                } else if (cls3 == Long.TYPE) {
                    indentedWriter.println("this." + property2.getName() + " = ois.readLong();");
                } else if (cls3 == Float.TYPE) {
                    indentedWriter.println("this." + property2.getName() + " = ois.readFloat();");
                } else if (cls3 == Double.TYPE) {
                    indentedWriter.println("this." + property2.getName() + " = ois.readDouble();");
                }
            } else {
                String str = (String) this.transientPropertyInitializers.get(property2.getName());
                if (str != null) {
                    indentedWriter.println("this." + property2.getName() + " = " + str + ';');
                }
            }
        }
        generateExtraSerInitializers(classInfo, cls, propertyArr, clsArr, indentedWriter);
        indentedWriter.println("break;");
        indentedWriter.downIndent();
        indentedWriter.println("default:");
        indentedWriter.upIndent();
        indentedWriter.println("throw new IOException(\"Unsupported Serialized Version: \" + version);");
        indentedWriter.downIndent();
        indentedWriter.downIndent();
        indentedWriter.println("}");
        indentedWriter.downIndent();
        indentedWriter.println("}");
    }

    /* access modifiers changed from: protected */
    public void writeStoreObject(Property property, Class cls, IndentedWriter indentedWriter) throws IOException {
        indentedWriter.println("oos.writeObject( " + property.getName() + " );");
    }

    /* access modifiers changed from: protected */
    public void writeUnstoreObject(Property property, Class cls, IndentedWriter indentedWriter) throws IOException {
        indentedWriter.println("this." + property.getName() + " = (" + property.getSimpleTypeName() + ") ois.readObject();");
    }

    protected void generateExtraSerWriteStatements(ClassInfo classInfo, Class cls, Property[] propertyArr, Class[] clsArr, IndentedWriter indentedWriter) throws IOException {
    }

    protected void generateExtraSerInitializers(ClassInfo classInfo, Class cls, Property[] propertyArr, Class[] clsArr, IndentedWriter indentedWriter) throws IOException {
    }
}
