package com.mchange.p009v2.codegen.bean;

import com.mchange.p006v1.lang.ClassUtils;
import com.mchange.p009v2.codegen.CodegenUtils;
import com.mchange.p009v2.codegen.IndentedWriter;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import dev.morphia.mapping.Mapper;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* renamed from: com.mchange.v2.codegen.bean.SimplePropertyBeanGenerator */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/SimplePropertyBeanGenerator.class */
public class SimplePropertyBeanGenerator implements PropertyBeanGenerator {
    private static final MLogger logger = MLog.getLogger(SimplePropertyBeanGenerator.class);
    protected ClassInfo info;
    protected Property[] props;

    /* renamed from: iw */
    protected IndentedWriter f414iw;
    protected Set generalImports;
    protected Set specificImports;
    protected Set interfaceNames;
    protected Class superclassType;
    protected List interfaceTypes;
    protected Class[] propertyTypes;
    private boolean inner = false;
    private int java_version = 140;
    private boolean force_unmodifiable = false;
    private String generatorName = getClass().getName();
    protected List generatorExtensions = new ArrayList();

    public synchronized void setInner(boolean z) {
        this.inner = z;
    }

    public synchronized boolean isInner() {
        return this.inner;
    }

    public synchronized void setJavaVersion(int i) {
        this.java_version = i;
    }

    public synchronized int getJavaVersion() {
        return this.java_version;
    }

    public synchronized void setGeneratorName(String str) {
        this.generatorName = str;
    }

    public synchronized String getGeneratorName() {
        return this.generatorName;
    }

    public synchronized void setForceUnmodifiable(boolean z) {
        this.force_unmodifiable = z;
    }

    public synchronized boolean isForceUnmodifiable() {
        return this.force_unmodifiable;
    }

    public synchronized void addExtension(GeneratorExtension generatorExtension) {
        this.generatorExtensions.add(generatorExtension);
    }

    public synchronized void removeExtension(GeneratorExtension generatorExtension) {
        this.generatorExtensions.remove(generatorExtension);
    }

    @Override // com.mchange.p009v2.codegen.bean.PropertyBeanGenerator
    public synchronized void generate(ClassInfo classInfo, Property[] propertyArr, Writer writer) throws IOException {
        this.info = classInfo;
        this.props = propertyArr;
        Arrays.sort(propertyArr, BeangenUtils.PROPERTY_COMPARATOR);
        this.f414iw = writer instanceof IndentedWriter ? (IndentedWriter) writer : new IndentedWriter(writer);
        this.generalImports = new TreeSet();
        if (classInfo.getGeneralImports() != null) {
            this.generalImports.addAll(Arrays.asList(classInfo.getGeneralImports()));
        }
        this.specificImports = new TreeSet();
        if (classInfo.getSpecificImports() != null) {
            this.specificImports.addAll(Arrays.asList(classInfo.getSpecificImports()));
        }
        this.interfaceNames = new TreeSet();
        if (classInfo.getInterfaceNames() != null) {
            this.interfaceNames.addAll(Arrays.asList(classInfo.getInterfaceNames()));
        }
        addInternalImports();
        addInternalInterfaces();
        resolveTypes();
        if (!this.inner) {
            writeHeader();
            this.f414iw.println();
        }
        generateClassJavaDocComment();
        writeClassDeclaration();
        this.f414iw.println('{');
        this.f414iw.upIndent();
        writeCoreBody();
        this.f414iw.downIndent();
        this.f414iw.println('}');
    }

    protected void resolveTypes() {
        String[] strArr = (String[]) this.generalImports.toArray(new String[this.generalImports.size()]);
        String[] strArr2 = (String[]) this.specificImports.toArray(new String[this.specificImports.size()]);
        if (this.info.getSuperclassName() != null) {
            try {
                this.superclassType = ClassUtils.forName(this.info.getSuperclassName(), strArr, strArr2);
            } catch (Exception e) {
                if (logger.isLoggable(MLevel.WARNING)) {
                    logger.warning(getClass().getName() + " could not resolve superclass '" + this.info.getSuperclassName() + "'.");
                }
                this.superclassType = null;
            }
        }
        this.interfaceTypes = new ArrayList(this.interfaceNames.size());
        for (String str : this.interfaceNames) {
            try {
                this.interfaceTypes.add(ClassUtils.forName(str, strArr, strArr2));
            } catch (Exception e2) {
                if (logger.isLoggable(MLevel.WARNING)) {
                    logger.warning(getClass().getName() + " could not resolve interface '" + str + "'.");
                }
                this.interfaceTypes.add(null);
            }
        }
        this.propertyTypes = new Class[this.props.length];
        int length = this.props.length;
        for (int i = 0; i < length; i++) {
            String simpleTypeName = this.props[i].getSimpleTypeName();
            try {
                this.propertyTypes[i] = ClassUtils.forName(simpleTypeName, strArr, strArr2);
            } catch (Exception e3) {
                if (logger.isLoggable(MLevel.WARNING)) {
                    logger.log(MLevel.WARNING, getClass().getName() + " could not resolve property type '" + simpleTypeName + "'.", (Throwable) e3);
                }
                this.propertyTypes[i] = null;
            }
        }
    }

    protected void addInternalImports() {
        if (boundProperties()) {
            this.specificImports.add("java.beans.PropertyChangeEvent");
            this.specificImports.add("java.beans.PropertyChangeSupport");
            this.specificImports.add("java.beans.PropertyChangeListener");
        }
        if (constrainedProperties()) {
            this.specificImports.add("java.beans.PropertyChangeEvent");
            this.specificImports.add("java.beans.PropertyVetoException");
            this.specificImports.add("java.beans.VetoableChangeSupport");
            this.specificImports.add("java.beans.VetoableChangeListener");
        }
        for (GeneratorExtension generatorExtension : this.generatorExtensions) {
            this.specificImports.addAll(generatorExtension.extraSpecificImports());
            this.generalImports.addAll(generatorExtension.extraGeneralImports());
        }
    }

    protected void addInternalInterfaces() {
        for (GeneratorExtension generatorExtension : this.generatorExtensions) {
            this.interfaceNames.addAll(generatorExtension.extraInterfaceNames());
        }
    }

    protected void writeCoreBody() throws IOException {
        writeJavaBeansChangeSupport();
        writePropertyVariables();
        writeOtherVariables();
        this.f414iw.println();
        writeGetterSetterPairs();
        if (boundProperties()) {
            this.f414iw.println();
            writeBoundPropertyEventSourceMethods();
        }
        if (constrainedProperties()) {
            this.f414iw.println();
            writeConstrainedPropertyEventSourceMethods();
        }
        writeInternalUtilityFunctions();
        writeOtherFunctions();
        writeOtherClasses();
        SimpleClassInfo simpleClassInfo = new SimpleClassInfo(this.info.getPackageName(), this.info.getModifiers(), this.info.getClassName(), this.info.getSuperclassName(), (String[]) this.interfaceNames.toArray(new String[this.interfaceNames.size()]), (String[]) this.generalImports.toArray(new String[this.generalImports.size()]), (String[]) this.specificImports.toArray(new String[this.specificImports.size()]));
        for (GeneratorExtension generatorExtension : this.generatorExtensions) {
            this.f414iw.println();
            generatorExtension.generate(simpleClassInfo, this.superclassType, this.props, this.propertyTypes, this.f414iw);
        }
    }

    protected void writeInternalUtilityFunctions() throws IOException {
        this.f414iw.println("private boolean eqOrBothNull( Object a, Object b )");
        this.f414iw.println("{");
        this.f414iw.upIndent();
        this.f414iw.println("return");
        this.f414iw.upIndent();
        this.f414iw.println("a == b ||");
        this.f414iw.println("(a != null && a.equals(b));");
        this.f414iw.downIndent();
        this.f414iw.downIndent();
        this.f414iw.println("}");
    }

    protected void writeConstrainedPropertyEventSourceMethods() throws IOException {
        this.f414iw.println("public void addVetoableChangeListener( VetoableChangeListener vcl )");
        this.f414iw.println("{ vcs.addVetoableChangeListener( vcl ); }");
        this.f414iw.println();
        this.f414iw.println("public void removeVetoableChangeListener( VetoableChangeListener vcl )");
        this.f414iw.println("{ vcs.removeVetoableChangeListener( vcl ); }");
        this.f414iw.println();
        if (this.java_version >= 140) {
            this.f414iw.println("public VetoableChangeListener[] getVetoableChangeListeners()");
            this.f414iw.println("{ return vcs.getVetoableChangeListeners(); }");
        }
    }

    protected void writeBoundPropertyEventSourceMethods() throws IOException {
        this.f414iw.println("public void addPropertyChangeListener( PropertyChangeListener pcl )");
        this.f414iw.println("{ pcs.addPropertyChangeListener( pcl ); }");
        this.f414iw.println();
        this.f414iw.println("public void addPropertyChangeListener( String propName, PropertyChangeListener pcl )");
        this.f414iw.println("{ pcs.addPropertyChangeListener( propName, pcl ); }");
        this.f414iw.println();
        this.f414iw.println("public void removePropertyChangeListener( PropertyChangeListener pcl )");
        this.f414iw.println("{ pcs.removePropertyChangeListener( pcl ); }");
        this.f414iw.println();
        this.f414iw.println("public void removePropertyChangeListener( String propName, PropertyChangeListener pcl )");
        this.f414iw.println("{ pcs.removePropertyChangeListener( propName, pcl ); }");
        this.f414iw.println();
        if (this.java_version >= 140) {
            this.f414iw.println("public PropertyChangeListener[] getPropertyChangeListeners()");
            this.f414iw.println("{ return pcs.getPropertyChangeListeners(); }");
        }
    }

    protected void writeJavaBeansChangeSupport() throws IOException {
        if (boundProperties()) {
            this.f414iw.println("protected PropertyChangeSupport pcs = new PropertyChangeSupport( this );");
            this.f414iw.println();
            this.f414iw.println("protected PropertyChangeSupport getPropertyChangeSupport()");
            this.f414iw.println("{ return pcs; }");
        }
        if (constrainedProperties()) {
            this.f414iw.println("protected VetoableChangeSupport vcs = new VetoableChangeSupport( this );");
            this.f414iw.println();
            this.f414iw.println("protected VetoableChangeSupport getVetoableChangeSupport()");
            this.f414iw.println("{ return vcs; }");
        }
    }

    protected void writeOtherVariables() throws IOException {
    }

    protected void writeOtherFunctions() throws IOException {
    }

    protected void writeOtherClasses() throws IOException {
    }

    protected void writePropertyVariables() throws IOException {
        int length = this.props.length;
        for (int i = 0; i < length; i++) {
            writePropertyVariable(this.props[i]);
        }
    }

    protected void writePropertyVariable(Property property) throws IOException {
        BeangenUtils.writePropertyVariable(property, this.f414iw);
    }

    protected void writePropertyMembers() throws IOException {
        throw new InternalError("writePropertyMembers() deprecated and removed. please us writePropertyVariables().");
    }

    protected void writePropertyMember(Property property) throws IOException {
        throw new InternalError("writePropertyMember() deprecated and removed. please us writePropertyVariable().");
    }

    protected void writeGetterSetterPairs() throws IOException {
        int length = this.props.length;
        for (int i = 0; i < length; i++) {
            writeGetterSetterPair(this.props[i], this.propertyTypes[i]);
            if (i != length - 1) {
                this.f414iw.println();
            }
        }
    }

    protected void writeGetterSetterPair(Property property, Class cls) throws IOException {
        writePropertyGetter(property, cls);
        if (!property.isReadOnly() && !this.force_unmodifiable) {
            this.f414iw.println();
            writePropertySetter(property, cls);
        }
    }

    protected void writePropertyGetter(Property property, Class cls) throws IOException {
        BeangenUtils.writePropertyGetter(property, getGetterDefensiveCopyExpression(property, cls), this.f414iw);
    }

    protected void writePropertySetter(Property property, Class cls) throws IOException {
        BeangenUtils.writePropertySetter(property, getSetterDefensiveCopyExpression(property, cls), this.f414iw);
    }

    protected String getGetterDefensiveCopyExpression(Property property, Class cls) {
        return property.getDefensiveCopyExpression();
    }

    protected String getSetterDefensiveCopyExpression(Property property, Class cls) {
        return property.getDefensiveCopyExpression();
    }

    protected String getConstructorDefensiveCopyExpression(Property property, Class cls) {
        return property.getDefensiveCopyExpression();
    }

    protected void writeHeader() throws IOException {
        writeBannerComments();
        this.f414iw.println();
        this.f414iw.println("package " + this.info.getPackageName() + ';');
        this.f414iw.println();
        writeImports();
    }

    protected void writeBannerComments() throws IOException {
        this.f414iw.println("/*");
        this.f414iw.println(" * This class autogenerated by " + this.generatorName + '.');
        this.f414iw.println(" * " + new Date());
        this.f414iw.println(" * DO NOT HAND EDIT!");
        this.f414iw.println(" */");
    }

    protected void generateClassJavaDocComment() throws IOException {
        this.f414iw.println("/**");
        this.f414iw.println(" * This class was generated by " + this.generatorName + Mapper.IGNORED_FIELDNAME);
        this.f414iw.println(" */");
    }

    protected void writeImports() throws IOException {
        Iterator it = this.generalImports.iterator();
        while (it.hasNext()) {
            this.f414iw.println("import " + it.next() + ".*;");
        }
        Iterator it2 = this.specificImports.iterator();
        while (it2.hasNext()) {
            this.f414iw.println("import " + it2.next() + ";");
        }
    }

    protected void writeClassDeclaration() throws IOException {
        this.f414iw.print(CodegenUtils.getModifierString(this.info.getModifiers()) + " class " + this.info.getClassName());
        String superclassName = this.info.getSuperclassName();
        if (superclassName != null) {
            this.f414iw.print(" extends " + superclassName);
        }
        if (this.interfaceNames.size() > 0) {
            this.f414iw.print(" implements ");
            boolean z = true;
            for (String str : this.interfaceNames) {
                if (z) {
                    z = false;
                } else {
                    this.f414iw.print(", ");
                }
                this.f414iw.print(str);
            }
        }
        this.f414iw.println();
    }

    boolean boundProperties() {
        return BeangenUtils.hasBoundProperties(this.props);
    }

    boolean constrainedProperties() {
        return BeangenUtils.hasConstrainedProperties(this.props);
    }

    public static void main(String[] strArr) {
        try {
            SimpleClassInfo simpleClassInfo = new SimpleClassInfo("test", 1, strArr[0], null, null, new String[]{"java.awt"}, null);
            Property[] propertyArr = {new SimpleProperty("number", "int", null, "7", false, true, false), new SimpleProperty("fpNumber", "float", null, null, true, true, false), new SimpleProperty("location", "Point", "new Point( location.x, location.y )", "new Point( 0, 0 )", false, true, true)};
            FileWriter fileWriter = new FileWriter(strArr[0] + ".java");
            SimplePropertyBeanGenerator simplePropertyBeanGenerator = new SimplePropertyBeanGenerator();
            simplePropertyBeanGenerator.addExtension(new SerializableExtension());
            simplePropertyBeanGenerator.generate(simpleClassInfo, propertyArr, fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
