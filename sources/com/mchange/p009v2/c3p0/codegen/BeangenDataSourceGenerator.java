package com.mchange.p009v2.c3p0.codegen;

import com.mchange.p006v1.xml.DomParseUtils;
import com.mchange.p009v2.codegen.IndentedWriter;
import com.mchange.p009v2.codegen.bean.BeanExtractingGeneratorExtension;
import com.mchange.p009v2.codegen.bean.BeangenUtils;
import com.mchange.p009v2.codegen.bean.ClassInfo;
import com.mchange.p009v2.codegen.bean.CompleteConstructorGeneratorExtension;
import com.mchange.p009v2.codegen.bean.GeneratorExtension;
import com.mchange.p009v2.codegen.bean.IndirectingSerializableExtension;
import com.mchange.p009v2.codegen.bean.ParsedPropertyBeanDocument;
import com.mchange.p009v2.codegen.bean.Property;
import com.mchange.p009v2.codegen.bean.PropertyReferenceableExtension;
import com.mchange.p009v2.codegen.bean.PropsToStringGeneratorExtension;
import com.mchange.p009v2.codegen.bean.SimpleClassInfo;
import com.mchange.p009v2.codegen.bean.SimplePropertyBeanGenerator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/* renamed from: com.mchange.v2.c3p0.codegen.BeangenDataSourceGenerator */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/codegen/BeangenDataSourceGenerator.class */
public class BeangenDataSourceGenerator {
    public static void main(String[] argv) {
        try {
            if (argv.length != 2) {
                System.err.println("java " + BeangenDataSourceGenerator.class.getName() + " <infile.xml> <OutputFile.java>");
                return;
            }
            File outFile = new File(argv[1]);
            File parentDir = outFile.getParentFile();
            if (!parentDir.exists()) {
                System.err.println("Warning: making parent directory: " + parentDir);
                parentDir.mkdirs();
            }
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(argv[0]));
            ParsedPropertyBeanDocument parsed = new ParsedPropertyBeanDocument(doc);
            Writer w = new BufferedWriter(new FileWriter(outFile));
            SimplePropertyBeanGenerator gen = new SimplePropertyBeanGenerator();
            gen.setGeneratorName(BeangenDataSourceGenerator.class.getName());
            gen.addExtension(new IndirectingSerializableExtension("com.mchange.v2.naming.ReferenceIndirector") { // from class: com.mchange.v2.c3p0.codegen.BeangenDataSourceGenerator.1
                @Override // com.mchange.p009v2.codegen.bean.SerializableExtension
                protected void generateExtraSerInitializers(ClassInfo info, Class superclassType, Property[] props, Class[] propTypes, IndentedWriter iw) throws IOException {
                    if (BeangenUtils.hasBoundProperties(props)) {
                        iw.println("this.pcs = new PropertyChangeSupport( this );");
                    }
                    if (BeangenUtils.hasConstrainedProperties(props)) {
                        iw.println("this.vcs = new VetoableChangeSupport( this );");
                    }
                }

                /* access modifiers changed from: protected */
                @Override // com.mchange.p009v2.codegen.bean.IndirectingSerializableExtension
                public void writeIndirectStoreObject(Property prop, Class propType, IndentedWriter iw) throws IOException {
                    iw.println("com.mchange.v2.log.MLog.getLogger( this.getClass() ).log(com.mchange.v2.log.MLevel.FINE, \"Direct serialization provoked a NotSerializableException! Trying indirect.\", nse);");
                    writeIndirectStoreObject(prop, propType, iw);
                }
            });
            gen.addExtension(new C3P0ImplUtilsParentLoggerGeneratorExtension());
            PropsToStringGeneratorExtension tsge = new PropsToStringGeneratorExtension();
            tsge.setExcludePropertyNames(Arrays.asList("userOverridesAsString", "overrideDefaultUser", "overrideDefaultPassword"));
            gen.addExtension(tsge);
            PropertyReferenceableExtension prex = new PropertyReferenceableExtension();
            prex.setUseExplicitReferenceProperties(true);
            prex.setFactoryClassName("com.mchange.v2.c3p0.impl.C3P0JavaBeanObjectFactory");
            gen.addExtension(prex);
            gen.addExtension(new BooleanInitIdentityTokenConstructortorGeneratorExtension());
            if (parsed.getClassInfo().getClassName().equals("WrapperConnectionPoolDataSourceBase")) {
                gen.addExtension(new WcpdsExtrasGeneratorExtension());
            }
            if (unmodifiableShadow(doc)) {
                gen.addExtension(new UnmodifiableShadowGeneratorExtension());
            }
            gen.generate(parsed.getClassInfo(), parsed.getProperties(), w);
            w.flush();
            w.close();
            System.err.println("Processed: " + argv[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean unmodifiableShadow(Document doc) {
        return DomParseUtils.uniqueChild(doc.getDocumentElement(), "unmodifiable-shadow") != null;
    }

    /* renamed from: com.mchange.v2.c3p0.codegen.BeangenDataSourceGenerator$BooleanInitIdentityTokenConstructortorGeneratorExtension */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/codegen/BeangenDataSourceGenerator$BooleanInitIdentityTokenConstructortorGeneratorExtension.class */
    static class BooleanInitIdentityTokenConstructortorGeneratorExtension implements GeneratorExtension {
        BooleanInitIdentityTokenConstructortorGeneratorExtension() {
        }

        @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
        public Collection extraGeneralImports() {
            return Collections.EMPTY_SET;
        }

        @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
        public Collection extraSpecificImports() {
            Set out = new HashSet();
            out.add("com.mchange.v2.c3p0.C3P0Registry");
            return out;
        }

        @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
        public Collection extraInterfaceNames() {
            return Collections.EMPTY_SET;
        }

        @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
        public void generate(ClassInfo info, Class superclassType, Property[] props, Class[] propTypes, IndentedWriter iw) throws IOException {
            BeangenUtils.writeExplicitDefaultConstructor(2, info, iw);
            iw.println();
            iw.println("public " + info.getClassName() + "( boolean autoregister )");
            iw.println("{");
            iw.upIndent();
            iw.println("if (autoregister)");
            iw.println("{");
            iw.upIndent();
            iw.println("this.identityToken = C3P0ImplUtils.allocateIdentityToken( this );");
            iw.println("C3P0Registry.reregister( this );");
            iw.downIndent();
            iw.println("}");
            iw.downIndent();
            iw.println("}");
        }
    }

    /* renamed from: com.mchange.v2.c3p0.codegen.BeangenDataSourceGenerator$WcpdsExtrasGeneratorExtension */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/codegen/BeangenDataSourceGenerator$WcpdsExtrasGeneratorExtension.class */
    static class WcpdsExtrasGeneratorExtension implements GeneratorExtension {
        WcpdsExtrasGeneratorExtension() {
        }

        @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
        public Collection extraGeneralImports() {
            return Collections.EMPTY_SET;
        }

        @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
        public Collection extraSpecificImports() {
            Set out = new HashSet();
            out.add("com.mchange.v2.c3p0.ConnectionCustomizer");
            out.add("javax.sql.PooledConnection");
            out.add("java.sql.SQLException");
            return out;
        }

        @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
        public Collection extraInterfaceNames() {
            return Collections.EMPTY_SET;
        }

        @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
        public void generate(ClassInfo info, Class superclassType, Property[] props, Class[] propTypes, IndentedWriter iw) throws IOException {
            iw.println("protected abstract PooledConnection getPooledConnection( ConnectionCustomizer cc, String idt) throws SQLException;");
            iw.println("protected abstract PooledConnection getPooledConnection(String user, String password, ConnectionCustomizer cc, String idt) throws SQLException;");
        }
    }

    /* renamed from: com.mchange.v2.c3p0.codegen.BeangenDataSourceGenerator$UnmodifiableShadowGeneratorExtension */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/codegen/BeangenDataSourceGenerator$UnmodifiableShadowGeneratorExtension.class */
    static class UnmodifiableShadowGeneratorExtension implements GeneratorExtension {
        BeanExtractingGeneratorExtension bege = new BeanExtractingGeneratorExtension();
        CompleteConstructorGeneratorExtension ccge = new CompleteConstructorGeneratorExtension();

        UnmodifiableShadowGeneratorExtension() {
            this.bege.setExtractMethodModifiers(2);
            this.bege.setConstructorModifiers(1);
        }

        @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
        public Collection extraGeneralImports() {
            Set out = new HashSet();
            out.addAll(this.bege.extraGeneralImports());
            out.addAll(this.ccge.extraGeneralImports());
            return out;
        }

        @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
        public Collection extraSpecificImports() {
            Set out = new HashSet();
            out.addAll(this.bege.extraSpecificImports());
            out.addAll(this.ccge.extraSpecificImports());
            return out;
        }

        @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
        public Collection extraInterfaceNames() {
            return Collections.EMPTY_SET;
        }

        @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
        public void generate(ClassInfo info, Class superclassType, Property[] props, Class[] propTypes, IndentedWriter iw) throws IOException {
            ClassInfo innerInfo = new SimpleClassInfo(info.getPackageName(), 9, "UnmodifiableShadow", info.getSuperclassName(), info.getInterfaceNames(), info.getGeneralImports(), info.getSpecificImports());
            SimplePropertyBeanGenerator innerGen = new SimplePropertyBeanGenerator();
            innerGen.setInner(true);
            innerGen.setForceUnmodifiable(true);
            innerGen.addExtension(this.bege);
            innerGen.addExtension(this.ccge);
            innerGen.generate(innerInfo, props, iw);
        }
    }
}
