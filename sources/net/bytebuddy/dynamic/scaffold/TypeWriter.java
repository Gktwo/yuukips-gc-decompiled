package net.bytebuddy.dynamic.scaffold;

import dev.morphia.mapping.Mapper;
import edu.umd.p012cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.RecordComponentList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.TypeResolutionStrategy;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import net.bytebuddy.dynamic.scaffold.TypeInitializer;
import net.bytebuddy.dynamic.scaffold.inline.MethodRebaseResolver;
import net.bytebuddy.dynamic.scaffold.inline.RebaseImplementationTarget;
import net.bytebuddy.dynamic.scaffold.subclass.SubclassImplementationTarget;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.attribute.AnnotationAppender;
import net.bytebuddy.implementation.attribute.AnnotationRetention;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.attribute.FieldAttributeAppender;
import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
import net.bytebuddy.implementation.attribute.RecordComponentAttributeAppender;
import net.bytebuddy.implementation.attribute.TypeAttributeAppender;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.ClassReader;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.ClassWriter;
import net.bytebuddy.jar.asm.ConstantDynamic;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.TypePath;
import net.bytebuddy.jar.asm.commons.ClassRemapper;
import net.bytebuddy.jar.asm.commons.Remapper;
import net.bytebuddy.jar.asm.commons.SimpleRemapper;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;
import net.bytebuddy.utility.visitor.FramePaddingMethodVisitor;
import net.bytebuddy.utility.visitor.MetadataAwareClassVisitor;

/* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter.class */
public interface TypeWriter<T> {
    public static final String DUMP_PROPERTY = "net.bytebuddy.dump";

    DynamicType.Unloaded<T> make(TypeResolutionStrategy.Resolved resolved);

    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$FieldPool.class */
    public interface FieldPool {
        Record target(FieldDescription fieldDescription);

        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$FieldPool$Record.class */
        public interface Record {
            boolean isImplicit();

            FieldDescription getField();

            FieldAttributeAppender getFieldAppender();

            Object resolveDefault(Object obj);

            void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory factory);

            void apply(FieldVisitor fieldVisitor, AnnotationValueFilter.Factory factory);

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$FieldPool$Record$ForImplicitField.class */
            public static class ForImplicitField implements Record {
                private final FieldDescription fieldDescription;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((ForImplicitField) obj).fieldDescription);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.fieldDescription.hashCode();
                }

                public ForImplicitField(FieldDescription fieldDescription) {
                    this.fieldDescription = fieldDescription;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public boolean isImplicit() {
                    return true;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public FieldDescription getField() {
                    return this.fieldDescription;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public FieldAttributeAppender getFieldAppender() {
                    throw new IllegalStateException("An implicit field record does not expose a field appender: " + this);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public Object resolveDefault(Object defaultValue) {
                    throw new IllegalStateException("An implicit field record does not expose a default value: " + this);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                    FieldVisitor fieldVisitor = classVisitor.visitField(this.fieldDescription.getActualModifiers(), this.fieldDescription.getInternalName(), this.fieldDescription.getDescriptor(), this.fieldDescription.getGenericSignature(), FieldDescription.NO_DEFAULT_VALUE);
                    if (fieldVisitor != null) {
                        FieldAttributeAppender.ForInstrumentedField.INSTANCE.apply(fieldVisitor, this.fieldDescription, annotationValueFilterFactory.mo138on(this.fieldDescription));
                        fieldVisitor.visitEnd();
                    }
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public void apply(FieldVisitor fieldVisitor, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                    throw new IllegalStateException("An implicit field record is not intended for partial application: " + this);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$FieldPool$Record$ForExplicitField.class */
            public static class ForExplicitField implements Record {
                private final FieldAttributeAppender attributeAppender;
                private final Object defaultValue;
                private final FieldDescription fieldDescription;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.attributeAppender.equals(((ForExplicitField) obj).attributeAppender) && this.defaultValue.equals(((ForExplicitField) obj).defaultValue) && this.fieldDescription.equals(((ForExplicitField) obj).fieldDescription);
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.attributeAppender.hashCode()) * 31) + this.defaultValue.hashCode()) * 31) + this.fieldDescription.hashCode();
                }

                public ForExplicitField(FieldAttributeAppender attributeAppender, Object defaultValue, FieldDescription fieldDescription) {
                    this.attributeAppender = attributeAppender;
                    this.defaultValue = defaultValue;
                    this.fieldDescription = fieldDescription;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public boolean isImplicit() {
                    return false;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public FieldDescription getField() {
                    return this.fieldDescription;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public FieldAttributeAppender getFieldAppender() {
                    return this.attributeAppender;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public Object resolveDefault(Object defaultValue) {
                    return this.defaultValue == null ? defaultValue : this.defaultValue;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                    FieldVisitor fieldVisitor = classVisitor.visitField(this.fieldDescription.getActualModifiers(), this.fieldDescription.getInternalName(), this.fieldDescription.getDescriptor(), this.fieldDescription.getGenericSignature(), resolveDefault(FieldDescription.NO_DEFAULT_VALUE));
                    if (fieldVisitor != null) {
                        this.attributeAppender.apply(fieldVisitor, this.fieldDescription, annotationValueFilterFactory.mo138on(this.fieldDescription));
                        fieldVisitor.visitEnd();
                    }
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public void apply(FieldVisitor fieldVisitor, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                    this.attributeAppender.apply(fieldVisitor, this.fieldDescription, annotationValueFilterFactory.mo138on(this.fieldDescription));
                }
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$FieldPool$Disabled.class */
        public enum Disabled implements FieldPool {
            INSTANCE;

            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool
            public Record target(FieldDescription fieldDescription) {
                throw new IllegalStateException("Cannot look up field from disabled pool");
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$MethodPool.class */
    public interface MethodPool {
        Record target(MethodDescription methodDescription);

        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$MethodPool$Record.class */
        public interface Record {
            Sort getSort();

            MethodDescription getMethod();

            Visibility getVisibility();

            Record prepend(ByteCodeAppender byteCodeAppender);

            void apply(ClassVisitor classVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory);

            void applyHead(MethodVisitor methodVisitor);

            void applyBody(MethodVisitor methodVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory);

            void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory);

            ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context context);

            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$MethodPool$Record$Sort.class */
            public enum Sort {
                SKIPPED(false, false),
                DEFINED(true, false),
                IMPLEMENTED(true, true);
                
                private final boolean define;
                private final boolean implement;

                Sort(boolean define, boolean implement) {
                    this.define = define;
                    this.implement = implement;
                }

                public boolean isDefined() {
                    return this.define;
                }

                public boolean isImplemented() {
                    return this.implement;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$MethodPool$Record$ForNonImplementedMethod.class */
            public static class ForNonImplementedMethod implements Record {
                private final MethodDescription methodDescription;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.methodDescription.equals(((ForNonImplementedMethod) obj).methodDescription);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.methodDescription.hashCode();
                }

                public ForNonImplementedMethod(MethodDescription methodDescription) {
                    this.methodDescription = methodDescription;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public void apply(ClassVisitor classVisitor, Implementation.Context implementationContext, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public void applyBody(MethodVisitor methodVisitor, Implementation.Context implementationContext, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                    throw new IllegalStateException("Cannot apply body for non-implemented method on " + this.methodDescription);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                    throw new IllegalStateException("Cannot apply code for non-implemented method on " + this.methodDescription);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public void applyHead(MethodVisitor methodVisitor) {
                    throw new IllegalStateException("Cannot apply head for non-implemented method on " + this.methodDescription);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public MethodDescription getMethod() {
                    return this.methodDescription;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public Visibility getVisibility() {
                    return this.methodDescription.getVisibility();
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public Sort getSort() {
                    return Sort.SKIPPED;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public Record prepend(ByteCodeAppender byteCodeAppender) {
                    return new ForDefinedMethod.WithBody(this.methodDescription, new ByteCodeAppender.Compound(byteCodeAppender, new ByteCodeAppender.Simple(DefaultValue.m113of(this.methodDescription.getReturnType()), MethodReturn.m108of(this.methodDescription.getReturnType()))));
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$MethodPool$Record$ForDefinedMethod.class */
            public static abstract class ForDefinedMethod implements Record {
                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public void apply(ClassVisitor classVisitor, Implementation.Context implementationContext, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                    MethodVisitor methodVisitor = classVisitor.visitMethod(getMethod().getActualModifiers(getSort().isImplemented(), getVisibility()), getMethod().getInternalName(), getMethod().getDescriptor(), getMethod().getGenericSignature(), getMethod().getExceptionTypes().asErasures().toInternalNames());
                    if (methodVisitor != null) {
                        ParameterList<?> parameterList = getMethod().getParameters();
                        if (parameterList.hasExplicitMetaData()) {
                            Iterator it = parameterList.iterator();
                            while (it.hasNext()) {
                                ParameterDescription parameterDescription = (ParameterDescription) it.next();
                                methodVisitor.visitParameter(parameterDescription.getName(), parameterDescription.getModifiers());
                            }
                        }
                        applyHead(methodVisitor);
                        applyBody(methodVisitor, implementationContext, annotationValueFilterFactory);
                        methodVisitor.visitEnd();
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$MethodPool$Record$ForDefinedMethod$WithBody.class */
                public static class WithBody extends ForDefinedMethod {
                    private final MethodDescription methodDescription;
                    private final ByteCodeAppender byteCodeAppender;
                    private final MethodAttributeAppender methodAttributeAppender;
                    private final Visibility visibility;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.visibility.equals(((WithBody) obj).visibility) && this.methodDescription.equals(((WithBody) obj).methodDescription) && this.byteCodeAppender.equals(((WithBody) obj).byteCodeAppender) && this.methodAttributeAppender.equals(((WithBody) obj).methodAttributeAppender);
                    }

                    public int hashCode() {
                        return (((((((getClass().hashCode() * 31) + this.methodDescription.hashCode()) * 31) + this.byteCodeAppender.hashCode()) * 31) + this.methodAttributeAppender.hashCode()) * 31) + this.visibility.hashCode();
                    }

                    public WithBody(MethodDescription methodDescription, ByteCodeAppender byteCodeAppender) {
                        this(methodDescription, byteCodeAppender, MethodAttributeAppender.NoOp.INSTANCE, methodDescription.getVisibility());
                    }

                    public WithBody(MethodDescription methodDescription, ByteCodeAppender byteCodeAppender, MethodAttributeAppender methodAttributeAppender, Visibility visibility) {
                        this.methodDescription = methodDescription;
                        this.byteCodeAppender = byteCodeAppender;
                        this.methodAttributeAppender = methodAttributeAppender;
                        this.visibility = visibility;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public MethodDescription getMethod() {
                        return this.methodDescription;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Sort getSort() {
                        return Sort.IMPLEMENTED;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Visibility getVisibility() {
                        return this.visibility;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyHead(MethodVisitor methodVisitor) {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyBody(MethodVisitor methodVisitor, Implementation.Context implementationContext, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                        applyAttributes(methodVisitor, annotationValueFilterFactory);
                        methodVisitor.visitCode();
                        ByteCodeAppender.Size size = applyCode(methodVisitor, implementationContext);
                        methodVisitor.visitMaxs(size.getOperandStackSize(), size.getLocalVariableSize());
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                        this.methodAttributeAppender.apply(methodVisitor, this.methodDescription, annotationValueFilterFactory.mo137on(this.methodDescription));
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                        return this.byteCodeAppender.apply(methodVisitor, implementationContext, this.methodDescription);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Record prepend(ByteCodeAppender byteCodeAppender) {
                        return new WithBody(this.methodDescription, new ByteCodeAppender.Compound(byteCodeAppender, this.byteCodeAppender), this.methodAttributeAppender, this.visibility);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$MethodPool$Record$ForDefinedMethod$WithoutBody.class */
                public static class WithoutBody extends ForDefinedMethod {
                    private final MethodDescription methodDescription;
                    private final MethodAttributeAppender methodAttributeAppender;
                    private final Visibility visibility;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.visibility.equals(((WithoutBody) obj).visibility) && this.methodDescription.equals(((WithoutBody) obj).methodDescription) && this.methodAttributeAppender.equals(((WithoutBody) obj).methodAttributeAppender);
                    }

                    public int hashCode() {
                        return (((((getClass().hashCode() * 31) + this.methodDescription.hashCode()) * 31) + this.methodAttributeAppender.hashCode()) * 31) + this.visibility.hashCode();
                    }

                    public WithoutBody(MethodDescription methodDescription, MethodAttributeAppender methodAttributeAppender, Visibility visibility) {
                        this.methodDescription = methodDescription;
                        this.methodAttributeAppender = methodAttributeAppender;
                        this.visibility = visibility;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public MethodDescription getMethod() {
                        return this.methodDescription;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Sort getSort() {
                        return Sort.DEFINED;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Visibility getVisibility() {
                        return this.visibility;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyHead(MethodVisitor methodVisitor) {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyBody(MethodVisitor methodVisitor, Implementation.Context implementationContext, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                        applyAttributes(methodVisitor, annotationValueFilterFactory);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                        this.methodAttributeAppender.apply(methodVisitor, this.methodDescription, annotationValueFilterFactory.mo137on(this.methodDescription));
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                        throw new IllegalStateException("Cannot apply code for abstract method on " + this.methodDescription);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Record prepend(ByteCodeAppender byteCodeAppender) {
                        throw new IllegalStateException("Cannot prepend code for abstract method on " + this.methodDescription);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$MethodPool$Record$ForDefinedMethod$WithAnnotationDefaultValue.class */
                public static class WithAnnotationDefaultValue extends ForDefinedMethod {
                    private final MethodDescription methodDescription;
                    private final AnnotationValue<?, ?> annotationValue;
                    private final MethodAttributeAppender methodAttributeAppender;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.methodDescription.equals(((WithAnnotationDefaultValue) obj).methodDescription) && this.annotationValue.equals(((WithAnnotationDefaultValue) obj).annotationValue) && this.methodAttributeAppender.equals(((WithAnnotationDefaultValue) obj).methodAttributeAppender);
                    }

                    public int hashCode() {
                        return (((((getClass().hashCode() * 31) + this.methodDescription.hashCode()) * 31) + this.annotationValue.hashCode()) * 31) + this.methodAttributeAppender.hashCode();
                    }

                    public WithAnnotationDefaultValue(MethodDescription methodDescription, AnnotationValue<?, ?> annotationValue, MethodAttributeAppender methodAttributeAppender) {
                        this.methodDescription = methodDescription;
                        this.annotationValue = annotationValue;
                        this.methodAttributeAppender = methodAttributeAppender;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public MethodDescription getMethod() {
                        return this.methodDescription;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Sort getSort() {
                        return Sort.DEFINED;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Visibility getVisibility() {
                        return this.methodDescription.getVisibility();
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyHead(MethodVisitor methodVisitor) {
                        if (!this.methodDescription.isDefaultValue(this.annotationValue)) {
                            throw new IllegalStateException("Cannot set " + this.annotationValue + " as default for " + this.methodDescription);
                        }
                        AnnotationVisitor annotationVisitor = methodVisitor.visitAnnotationDefault();
                        AnnotationAppender.Default.apply(annotationVisitor, this.methodDescription.getReturnType().asErasure(), AnnotationAppender.NO_NAME, this.annotationValue.resolve());
                        annotationVisitor.visitEnd();
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyBody(MethodVisitor methodVisitor, Implementation.Context implementationContext, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                        this.methodAttributeAppender.apply(methodVisitor, this.methodDescription, annotationValueFilterFactory.mo137on(this.methodDescription));
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                        throw new IllegalStateException("Cannot apply attributes for default value on " + this.methodDescription);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                        throw new IllegalStateException("Cannot apply code for default value on " + this.methodDescription);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Record prepend(ByteCodeAppender byteCodeAppender) {
                        throw new IllegalStateException("Cannot prepend code for default value on " + this.methodDescription);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$MethodPool$Record$ForDefinedMethod$OfVisibilityBridge.class */
                public static class OfVisibilityBridge extends ForDefinedMethod implements ByteCodeAppender {
                    private final MethodDescription visibilityBridge;
                    private final MethodDescription bridgeTarget;
                    private final TypeDescription bridgeType;
                    private final MethodAttributeAppender attributeAppender;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.visibilityBridge.equals(((OfVisibilityBridge) obj).visibilityBridge) && this.bridgeTarget.equals(((OfVisibilityBridge) obj).bridgeTarget) && this.bridgeType.equals(((OfVisibilityBridge) obj).bridgeType) && this.attributeAppender.equals(((OfVisibilityBridge) obj).attributeAppender);
                    }

                    public int hashCode() {
                        return (((((((getClass().hashCode() * 31) + this.visibilityBridge.hashCode()) * 31) + this.bridgeTarget.hashCode()) * 31) + this.bridgeType.hashCode()) * 31) + this.attributeAppender.hashCode();
                    }

                    protected OfVisibilityBridge(MethodDescription visibilityBridge, MethodDescription bridgeTarget, TypeDescription bridgeType, MethodAttributeAppender attributeAppender) {
                        this.visibilityBridge = visibilityBridge;
                        this.bridgeTarget = bridgeTarget;
                        this.bridgeType = bridgeType;
                        this.attributeAppender = attributeAppender;
                    }

                    /* renamed from: of */
                    public static Record m202of(TypeDescription instrumentedType, MethodDescription bridgeTarget, MethodAttributeAppender attributeAppender) {
                        TypeDefinition bridgeType = null;
                        if (bridgeTarget.isDefaultMethod()) {
                            TypeDescription declaringType = bridgeTarget.getDeclaringType().asErasure();
                            for (TypeDefinition interfaceType : instrumentedType.getInterfaces().asErasures().filter(ElementMatchers.isSubTypeOf(declaringType))) {
                                if (bridgeType == null || declaringType.isAssignableTo(bridgeType.asErasure())) {
                                    bridgeType = interfaceType;
                                }
                            }
                        }
                        if (bridgeType == null) {
                            bridgeType = instrumentedType.getSuperClass();
                        }
                        return new OfVisibilityBridge(new VisibilityBridge(instrumentedType, bridgeTarget), bridgeTarget, bridgeType.asErasure(), attributeAppender);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public MethodDescription getMethod() {
                        return this.visibilityBridge;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Sort getSort() {
                        return Sort.IMPLEMENTED;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Visibility getVisibility() {
                        return this.bridgeTarget.getVisibility();
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Record prepend(ByteCodeAppender byteCodeAppender) {
                        return new WithBody(this.visibilityBridge, new ByteCodeAppender.Compound(this, byteCodeAppender), this.attributeAppender, this.bridgeTarget.getVisibility());
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyHead(MethodVisitor methodVisitor) {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyBody(MethodVisitor methodVisitor, Implementation.Context implementationContext, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                        applyAttributes(methodVisitor, annotationValueFilterFactory);
                        methodVisitor.visitCode();
                        ByteCodeAppender.Size size = applyCode(methodVisitor, implementationContext);
                        methodVisitor.visitMaxs(size.getOperandStackSize(), size.getLocalVariableSize());
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                        this.attributeAppender.apply(methodVisitor, this.visibilityBridge, annotationValueFilterFactory.mo137on(this.visibilityBridge));
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                        return apply(methodVisitor, implementationContext, this.visibilityBridge);
                    }

                    @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
                    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext, MethodDescription instrumentedMethod) {
                        return new ByteCodeAppender.Simple(MethodVariableAccess.allArgumentsOf(instrumentedMethod).prependThisReference(), MethodInvocation.invoke(this.bridgeTarget).special(this.bridgeType), MethodReturn.m108of(instrumentedMethod.getReturnType())).apply(methodVisitor, implementationContext, instrumentedMethod);
                    }

                    /* access modifiers changed from: protected */
                    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$MethodPool$Record$ForDefinedMethod$OfVisibilityBridge$VisibilityBridge.class */
                    public static class VisibilityBridge extends MethodDescription.InDefinedShape.AbstractBase {
                        private final TypeDescription instrumentedType;
                        private final MethodDescription bridgeTarget;

                        protected VisibilityBridge(TypeDescription instrumentedType, MethodDescription bridgeTarget) {
                            this.instrumentedType = instrumentedType;
                            this.bridgeTarget = bridgeTarget;
                        }

                        @Override // net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
                        public TypeDescription getDeclaringType() {
                            return this.instrumentedType;
                        }

                        @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
                        public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                            return new ParameterList.Explicit.ForTypes(this, this.bridgeTarget.getParameters().asTypeList().asRawTypes());
                        }

                        @Override // net.bytebuddy.description.method.MethodDescription
                        public TypeDescription.Generic getReturnType() {
                            return this.bridgeTarget.getReturnType().asRawType();
                        }

                        @Override // net.bytebuddy.description.method.MethodDescription
                        public TypeList.Generic getExceptionTypes() {
                            return this.bridgeTarget.getExceptionTypes().asRawTypes();
                        }

                        @Override // net.bytebuddy.description.method.MethodDescription
                        public AnnotationValue<?, ?> getDefaultValue() {
                            return AnnotationValue.UNDEFINED;
                        }

                        @Override // net.bytebuddy.description.TypeVariableSource
                        public TypeList.Generic getTypeVariables() {
                            return new TypeList.Generic.Empty();
                        }

                        @Override // net.bytebuddy.description.annotation.AnnotationSource
                        public AnnotationList getDeclaredAnnotations() {
                            return this.bridgeTarget.getDeclaredAnnotations();
                        }

                        @Override // net.bytebuddy.description.ModifierReviewable
                        public int getModifiers() {
                            return (this.bridgeTarget.getModifiers() | 4096 | 64) & -257;
                        }

                        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
                        public String getInternalName() {
                            return this.bridgeTarget.getName();
                        }
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$MethodPool$Record$AccessBridgeWrapper.class */
            public static class AccessBridgeWrapper implements Record {
                private final Record delegate;
                private final TypeDescription instrumentedType;
                private final MethodDescription bridgeTarget;
                private final Set<MethodDescription.TypeToken> bridgeTypes;
                private final MethodAttributeAppender attributeAppender;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.delegate.equals(((AccessBridgeWrapper) obj).delegate) && this.instrumentedType.equals(((AccessBridgeWrapper) obj).instrumentedType) && this.bridgeTarget.equals(((AccessBridgeWrapper) obj).bridgeTarget) && this.bridgeTypes.equals(((AccessBridgeWrapper) obj).bridgeTypes) && this.attributeAppender.equals(((AccessBridgeWrapper) obj).attributeAppender);
                }

                public int hashCode() {
                    return (((((((((getClass().hashCode() * 31) + this.delegate.hashCode()) * 31) + this.instrumentedType.hashCode()) * 31) + this.bridgeTarget.hashCode()) * 31) + this.bridgeTypes.hashCode()) * 31) + this.attributeAppender.hashCode();
                }

                protected AccessBridgeWrapper(Record delegate, TypeDescription instrumentedType, MethodDescription bridgeTarget, Set<MethodDescription.TypeToken> bridgeTypes, MethodAttributeAppender attributeAppender) {
                    this.delegate = delegate;
                    this.instrumentedType = instrumentedType;
                    this.bridgeTarget = bridgeTarget;
                    this.bridgeTypes = bridgeTypes;
                    this.attributeAppender = attributeAppender;
                }

                /* renamed from: of */
                public static Record m203of(Record delegate, TypeDescription instrumentedType, MethodDescription bridgeTarget, Set<MethodDescription.TypeToken> bridgeTypes, MethodAttributeAppender attributeAppender) {
                    Set<MethodDescription.TypeToken> compatibleBridgeTypes = new HashSet<>();
                    for (MethodDescription.TypeToken bridgeType : bridgeTypes) {
                        if (bridgeTarget.isBridgeCompatible(bridgeType)) {
                            compatibleBridgeTypes.add(bridgeType);
                        }
                    }
                    return (compatibleBridgeTypes.isEmpty() || (instrumentedType.isInterface() && !delegate.getSort().isImplemented())) ? delegate : new AccessBridgeWrapper(delegate, instrumentedType, bridgeTarget, compatibleBridgeTypes, attributeAppender);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public Sort getSort() {
                    return this.delegate.getSort();
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public MethodDescription getMethod() {
                    return this.bridgeTarget;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public Visibility getVisibility() {
                    return this.delegate.getVisibility();
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public Record prepend(ByteCodeAppender byteCodeAppender) {
                    return new AccessBridgeWrapper(this.delegate.prepend(byteCodeAppender), this.instrumentedType, this.bridgeTarget, this.bridgeTypes, this.attributeAppender);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public void apply(ClassVisitor classVisitor, Implementation.Context implementationContext, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                    this.delegate.apply(classVisitor, implementationContext, annotationValueFilterFactory);
                    for (MethodDescription.TypeToken bridgeType : this.bridgeTypes) {
                        MethodDescription.InDefinedShape bridgeMethod = new AccessorBridge(this.bridgeTarget, bridgeType, this.instrumentedType);
                        MethodDescription.InDefinedShape bridgeTarget = new BridgeTarget(this.bridgeTarget, this.instrumentedType);
                        MethodVisitor methodVisitor = classVisitor.visitMethod(bridgeMethod.getActualModifiers(true, getVisibility()), bridgeMethod.getInternalName(), bridgeMethod.getDescriptor(), MethodDescription.NON_GENERIC_SIGNATURE, bridgeMethod.getExceptionTypes().asErasures().toInternalNames());
                        if (methodVisitor != null) {
                            this.attributeAppender.apply(methodVisitor, bridgeMethod, annotationValueFilterFactory.mo135on(this.instrumentedType));
                            methodVisitor.visitCode();
                            StackManipulation[] stackManipulationArr = new StackManipulation[4];
                            stackManipulationArr[0] = MethodVariableAccess.allArgumentsOf(bridgeMethod).asBridgeOf(bridgeTarget).prependThisReference();
                            stackManipulationArr[1] = MethodInvocation.invoke(bridgeTarget).virtual(this.instrumentedType);
                            stackManipulationArr[2] = bridgeTarget.getReturnType().asErasure().isAssignableTo(bridgeMethod.getReturnType().asErasure()) ? StackManipulation.Trivial.INSTANCE : TypeCasting.m116to(bridgeMethod.getReturnType().asErasure());
                            stackManipulationArr[3] = MethodReturn.m108of(bridgeMethod.getReturnType());
                            ByteCodeAppender.Size size = new ByteCodeAppender.Simple(stackManipulationArr).apply(methodVisitor, implementationContext, bridgeMethod);
                            methodVisitor.visitMaxs(size.getOperandStackSize(), size.getLocalVariableSize());
                            methodVisitor.visitEnd();
                        }
                    }
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public void applyHead(MethodVisitor methodVisitor) {
                    this.delegate.applyHead(methodVisitor);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public void applyBody(MethodVisitor methodVisitor, Implementation.Context implementationContext, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                    this.delegate.applyBody(methodVisitor, implementationContext, annotationValueFilterFactory);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                    this.delegate.applyAttributes(methodVisitor, annotationValueFilterFactory);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                    return this.delegate.applyCode(methodVisitor, implementationContext);
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$MethodPool$Record$AccessBridgeWrapper$AccessorBridge.class */
                protected static class AccessorBridge extends MethodDescription.InDefinedShape.AbstractBase {
                    private final MethodDescription bridgeTarget;
                    private final MethodDescription.TypeToken bridgeType;
                    private final TypeDescription instrumentedType;

                    protected AccessorBridge(MethodDescription bridgeTarget, MethodDescription.TypeToken bridgeType, TypeDescription instrumentedType) {
                        this.bridgeTarget = bridgeTarget;
                        this.bridgeType = bridgeType;
                        this.instrumentedType = instrumentedType;
                    }

                    @Override // net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
                    public TypeDescription getDeclaringType() {
                        return this.instrumentedType;
                    }

                    @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
                    public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                        return new ParameterList.Explicit.ForTypes(this, this.bridgeType.getParameterTypes());
                    }

                    @Override // net.bytebuddy.description.method.MethodDescription
                    public TypeDescription.Generic getReturnType() {
                        return this.bridgeType.getReturnType().asGenericType();
                    }

                    @Override // net.bytebuddy.description.method.MethodDescription
                    public TypeList.Generic getExceptionTypes() {
                        return this.bridgeTarget.getExceptionTypes().accept(TypeDescription.Generic.Visitor.TypeErasing.INSTANCE);
                    }

                    @Override // net.bytebuddy.description.method.MethodDescription
                    public AnnotationValue<?, ?> getDefaultValue() {
                        return AnnotationValue.UNDEFINED;
                    }

                    @Override // net.bytebuddy.description.TypeVariableSource
                    public TypeList.Generic getTypeVariables() {
                        return new TypeList.Generic.Empty();
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationSource
                    public AnnotationList getDeclaredAnnotations() {
                        return new AnnotationList.Empty();
                    }

                    @Override // net.bytebuddy.description.ModifierReviewable
                    public int getModifiers() {
                        return (this.bridgeTarget.getModifiers() | 64 | 4096) & -1281;
                    }

                    @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
                    public String getInternalName() {
                        return this.bridgeTarget.getInternalName();
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$MethodPool$Record$AccessBridgeWrapper$BridgeTarget.class */
                protected static class BridgeTarget extends MethodDescription.InDefinedShape.AbstractBase {
                    private final MethodDescription bridgeTarget;
                    private final TypeDescription instrumentedType;

                    protected BridgeTarget(MethodDescription bridgeTarget, TypeDescription instrumentedType) {
                        this.bridgeTarget = bridgeTarget;
                        this.instrumentedType = instrumentedType;
                    }

                    @Override // net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
                    public TypeDescription getDeclaringType() {
                        return this.instrumentedType;
                    }

                    @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
                    public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                        return new ParameterList.ForTokens(this, this.bridgeTarget.getParameters().asTokenList(ElementMatchers.m104is(this.instrumentedType)));
                    }

                    @Override // net.bytebuddy.description.method.MethodDescription
                    public TypeDescription.Generic getReturnType() {
                        return this.bridgeTarget.getReturnType();
                    }

                    @Override // net.bytebuddy.description.method.MethodDescription
                    public TypeList.Generic getExceptionTypes() {
                        return this.bridgeTarget.getExceptionTypes();
                    }

                    @Override // net.bytebuddy.description.method.MethodDescription
                    public AnnotationValue<?, ?> getDefaultValue() {
                        return this.bridgeTarget.getDefaultValue();
                    }

                    @Override // net.bytebuddy.description.TypeVariableSource
                    public TypeList.Generic getTypeVariables() {
                        return this.bridgeTarget.getTypeVariables();
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationSource
                    public AnnotationList getDeclaredAnnotations() {
                        return this.bridgeTarget.getDeclaredAnnotations();
                    }

                    @Override // net.bytebuddy.description.ModifierReviewable
                    public int getModifiers() {
                        return this.bridgeTarget.getModifiers();
                    }

                    @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
                    public String getInternalName() {
                        return this.bridgeTarget.getInternalName();
                    }
                }
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$RecordComponentPool.class */
    public interface RecordComponentPool {
        Record target(RecordComponentDescription recordComponentDescription);

        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$RecordComponentPool$Record.class */
        public interface Record {
            boolean isImplicit();

            RecordComponentDescription getRecordComponent();

            RecordComponentAttributeAppender getRecordComponentAppender();

            void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory factory);

            void apply(RecordComponentVisitor recordComponentVisitor, AnnotationValueFilter.Factory factory);

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$RecordComponentPool$Record$ForImplicitRecordComponent.class */
            public static class ForImplicitRecordComponent implements Record {
                private final RecordComponentDescription recordComponentDescription;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.recordComponentDescription.equals(((ForImplicitRecordComponent) obj).recordComponentDescription);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.recordComponentDescription.hashCode();
                }

                public ForImplicitRecordComponent(RecordComponentDescription recordComponentDescription) {
                    this.recordComponentDescription = recordComponentDescription;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool.Record
                public boolean isImplicit() {
                    return true;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool.Record
                public RecordComponentDescription getRecordComponent() {
                    return this.recordComponentDescription;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool.Record
                public RecordComponentAttributeAppender getRecordComponentAppender() {
                    throw new IllegalStateException("An implicit field record does not expose a field appender: " + this);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool.Record
                public void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                    RecordComponentVisitor recordComponentVisitor = classVisitor.visitRecordComponent(this.recordComponentDescription.getActualName(), this.recordComponentDescription.getDescriptor(), this.recordComponentDescription.getGenericSignature());
                    if (recordComponentVisitor != null) {
                        RecordComponentAttributeAppender.ForInstrumentedRecordComponent.INSTANCE.apply(recordComponentVisitor, this.recordComponentDescription, annotationValueFilterFactory.mo136on(this.recordComponentDescription));
                        recordComponentVisitor.visitEnd();
                    }
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool.Record
                public void apply(RecordComponentVisitor recordComponentVisitor, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                    throw new IllegalStateException("An implicit field record is not intended for partial application: " + this);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$RecordComponentPool$Record$ForExplicitRecordComponent.class */
            public static class ForExplicitRecordComponent implements Record {
                private final RecordComponentAttributeAppender attributeAppender;
                private final RecordComponentDescription recordComponentDescription;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.attributeAppender.equals(((ForExplicitRecordComponent) obj).attributeAppender) && this.recordComponentDescription.equals(((ForExplicitRecordComponent) obj).recordComponentDescription);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.attributeAppender.hashCode()) * 31) + this.recordComponentDescription.hashCode();
                }

                public ForExplicitRecordComponent(RecordComponentAttributeAppender attributeAppender, RecordComponentDescription recordComponentDescription) {
                    this.attributeAppender = attributeAppender;
                    this.recordComponentDescription = recordComponentDescription;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool.Record
                public boolean isImplicit() {
                    return false;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool.Record
                public RecordComponentDescription getRecordComponent() {
                    return this.recordComponentDescription;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool.Record
                public RecordComponentAttributeAppender getRecordComponentAppender() {
                    return this.attributeAppender;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool.Record
                public void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                    RecordComponentVisitor recordComponentVisitor = classVisitor.visitRecordComponent(this.recordComponentDescription.getActualName(), this.recordComponentDescription.getDescriptor(), this.recordComponentDescription.getGenericSignature());
                    if (recordComponentVisitor != null) {
                        this.attributeAppender.apply(recordComponentVisitor, this.recordComponentDescription, annotationValueFilterFactory.mo136on(this.recordComponentDescription));
                        recordComponentVisitor.visitEnd();
                    }
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool.Record
                public void apply(RecordComponentVisitor recordComponentVisitor, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                    this.attributeAppender.apply(recordComponentVisitor, this.recordComponentDescription, annotationValueFilterFactory.mo136on(this.recordComponentDescription));
                }
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$RecordComponentPool$Disabled.class */
        public enum Disabled implements RecordComponentPool {
            INSTANCE;

            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool
            public Record target(RecordComponentDescription recordComponentDescription) {
                throw new IllegalStateException("Cannot look up record component from disabled pool");
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default.class */
    public static abstract class Default<S> implements TypeWriter<S> {
        private static final String NO_REFERENCE = null;
        protected static final String DUMP_FOLDER;
        protected final TypeDescription instrumentedType;
        protected final ClassFileVersion classFileVersion;
        protected final FieldPool fieldPool;
        protected final RecordComponentPool recordComponentPool;
        protected final List<? extends DynamicType> auxiliaryTypes;
        protected final FieldList<FieldDescription.InDefinedShape> fields;
        protected final MethodList<?> methods;
        protected final MethodList<?> instrumentedMethods;
        protected final RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponents;
        protected final LoadedTypeInitializer loadedTypeInitializer;
        protected final TypeInitializer typeInitializer;
        protected final TypeAttributeAppender typeAttributeAppender;
        protected final AsmVisitorWrapper asmVisitorWrapper;
        protected final AnnotationValueFilter.Factory annotationValueFilterFactory;
        protected final AnnotationRetention annotationRetention;
        protected final AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy;
        protected final Implementation.Context.Factory implementationContextFactory;
        protected final TypeValidation typeValidation;
        protected final ClassWriterStrategy classWriterStrategy;
        protected final TypePool typePool;

        protected abstract Default<S>.UnresolvedType create(TypeInitializer typeInitializer, ClassDumpAction.Dispatcher dispatcher);

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.annotationRetention.equals(((Default) obj).annotationRetention) && this.typeValidation.equals(((Default) obj).typeValidation) && this.instrumentedType.equals(((Default) obj).instrumentedType) && this.classFileVersion.equals(((Default) obj).classFileVersion) && this.fieldPool.equals(((Default) obj).fieldPool) && this.recordComponentPool.equals(((Default) obj).recordComponentPool) && this.auxiliaryTypes.equals(((Default) obj).auxiliaryTypes) && this.fields.equals(((Default) obj).fields) && this.methods.equals(((Default) obj).methods) && this.instrumentedMethods.equals(((Default) obj).instrumentedMethods) && this.recordComponents.equals(((Default) obj).recordComponents) && this.loadedTypeInitializer.equals(((Default) obj).loadedTypeInitializer) && this.typeInitializer.equals(((Default) obj).typeInitializer) && this.typeAttributeAppender.equals(((Default) obj).typeAttributeAppender) && this.asmVisitorWrapper.equals(((Default) obj).asmVisitorWrapper) && this.annotationValueFilterFactory.equals(((Default) obj).annotationValueFilterFactory) && this.auxiliaryTypeNamingStrategy.equals(((Default) obj).auxiliaryTypeNamingStrategy) && this.implementationContextFactory.equals(((Default) obj).implementationContextFactory) && this.classWriterStrategy.equals(((Default) obj).classWriterStrategy) && this.typePool.equals(((Default) obj).typePool);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.classFileVersion.hashCode()) * 31) + this.fieldPool.hashCode()) * 31) + this.recordComponentPool.hashCode()) * 31) + this.auxiliaryTypes.hashCode()) * 31) + this.fields.hashCode()) * 31) + this.methods.hashCode()) * 31) + this.instrumentedMethods.hashCode()) * 31) + this.recordComponents.hashCode()) * 31) + this.loadedTypeInitializer.hashCode()) * 31) + this.typeInitializer.hashCode()) * 31) + this.typeAttributeAppender.hashCode()) * 31) + this.asmVisitorWrapper.hashCode()) * 31) + this.annotationValueFilterFactory.hashCode()) * 31) + this.annotationRetention.hashCode()) * 31) + this.auxiliaryTypeNamingStrategy.hashCode()) * 31) + this.implementationContextFactory.hashCode()) * 31) + this.typeValidation.hashCode()) * 31) + this.classWriterStrategy.hashCode()) * 31) + this.typePool.hashCode();
        }

        static {
            String dumpFolder;
            try {
                dumpFolder = (String) AccessController.doPrivileged(new GetSystemPropertyAction(TypeWriter.DUMP_PROPERTY));
            } catch (RuntimeException e) {
                dumpFolder = null;
            }
            DUMP_FOLDER = dumpFolder;
        }

        protected Default(TypeDescription instrumentedType, ClassFileVersion classFileVersion, FieldPool fieldPool, RecordComponentPool recordComponentPool, List<? extends DynamicType> auxiliaryTypes, FieldList<FieldDescription.InDefinedShape> fields, MethodList<?> methods, MethodList<?> instrumentedMethods, RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponents, LoadedTypeInitializer loadedTypeInitializer, TypeInitializer typeInitializer, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, AnnotationValueFilter.Factory annotationValueFilterFactory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy, Implementation.Context.Factory implementationContextFactory, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool) {
            this.instrumentedType = instrumentedType;
            this.classFileVersion = classFileVersion;
            this.fieldPool = fieldPool;
            this.recordComponentPool = recordComponentPool;
            this.auxiliaryTypes = auxiliaryTypes;
            this.fields = fields;
            this.methods = methods;
            this.instrumentedMethods = instrumentedMethods;
            this.recordComponents = recordComponents;
            this.loadedTypeInitializer = loadedTypeInitializer;
            this.typeInitializer = typeInitializer;
            this.typeAttributeAppender = typeAttributeAppender;
            this.asmVisitorWrapper = asmVisitorWrapper;
            this.auxiliaryTypeNamingStrategy = auxiliaryTypeNamingStrategy;
            this.annotationValueFilterFactory = annotationValueFilterFactory;
            this.annotationRetention = annotationRetention;
            this.implementationContextFactory = implementationContextFactory;
            this.typeValidation = typeValidation;
            this.classWriterStrategy = classWriterStrategy;
            this.typePool = typePool;
        }

        public static <U> TypeWriter<U> forCreation(MethodRegistry.Compiled methodRegistry, List<? extends DynamicType> auxiliaryTypes, FieldPool fieldPool, RecordComponentPool recordComponentPool, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, ClassFileVersion classFileVersion, AnnotationValueFilter.Factory annotationValueFilterFactory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy, Implementation.Context.Factory implementationContextFactory, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool) {
            return new ForCreation(methodRegistry.getInstrumentedType(), classFileVersion, fieldPool, methodRegistry, recordComponentPool, auxiliaryTypes, methodRegistry.getInstrumentedType().getDeclaredFields(), methodRegistry.getMethods(), methodRegistry.getInstrumentedMethods(), methodRegistry.getInstrumentedType().getRecordComponents(), methodRegistry.getLoadedTypeInitializer(), methodRegistry.getTypeInitializer(), typeAttributeAppender, asmVisitorWrapper, annotationValueFilterFactory, annotationRetention, auxiliaryTypeNamingStrategy, implementationContextFactory, typeValidation, classWriterStrategy, typePool);
        }

        public static <U> TypeWriter<U> forRedefinition(MethodRegistry.Prepared methodRegistry, List<? extends DynamicType> auxiliaryTypes, FieldPool fieldPool, RecordComponentPool recordComponentPool, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, ClassFileVersion classFileVersion, AnnotationValueFilter.Factory annotationValueFilterFactory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy, Implementation.Context.Factory implementationContextFactory, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool, TypeDescription originalType, ClassFileLocator classFileLocator) {
            return new ForInlining.WithFullProcessing(methodRegistry.getInstrumentedType(), classFileVersion, fieldPool, recordComponentPool, auxiliaryTypes, methodRegistry.getInstrumentedType().getDeclaredFields(), methodRegistry.getMethods(), methodRegistry.getInstrumentedMethods(), methodRegistry.getInstrumentedType().getRecordComponents(), methodRegistry.getLoadedTypeInitializer(), methodRegistry.getTypeInitializer(), typeAttributeAppender, asmVisitorWrapper, annotationValueFilterFactory, annotationRetention, auxiliaryTypeNamingStrategy, implementationContextFactory, typeValidation, classWriterStrategy, typePool, originalType, classFileLocator, methodRegistry, SubclassImplementationTarget.Factory.LEVEL_TYPE, MethodRebaseResolver.Disabled.INSTANCE);
        }

        public static <U> TypeWriter<U> forRebasing(MethodRegistry.Prepared methodRegistry, List<? extends DynamicType> auxiliaryTypes, FieldPool fieldPool, RecordComponentPool recordComponentPool, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, ClassFileVersion classFileVersion, AnnotationValueFilter.Factory annotationValueFilterFactory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy, Implementation.Context.Factory implementationContextFactory, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool, TypeDescription originalType, ClassFileLocator classFileLocator, MethodRebaseResolver methodRebaseResolver) {
            return new ForInlining.WithFullProcessing(methodRegistry.getInstrumentedType(), classFileVersion, fieldPool, recordComponentPool, CompoundList.m80of((List) auxiliaryTypes, (List) methodRebaseResolver.getAuxiliaryTypes()), methodRegistry.getInstrumentedType().getDeclaredFields(), methodRegistry.getMethods(), methodRegistry.getInstrumentedMethods(), methodRegistry.getInstrumentedType().getRecordComponents(), methodRegistry.getLoadedTypeInitializer(), methodRegistry.getTypeInitializer(), typeAttributeAppender, asmVisitorWrapper, annotationValueFilterFactory, annotationRetention, auxiliaryTypeNamingStrategy, implementationContextFactory, typeValidation, classWriterStrategy, typePool, originalType, classFileLocator, methodRegistry, new RebaseImplementationTarget.Factory(methodRebaseResolver), methodRebaseResolver);
        }

        public static <U> TypeWriter<U> forDecoration(TypeDescription instrumentedType, ClassFileVersion classFileVersion, List<? extends DynamicType> auxiliaryTypes, List<? extends MethodDescription> methods, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, AnnotationValueFilter.Factory annotationValueFilterFactory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy, Implementation.Context.Factory implementationContextFactory, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool, ClassFileLocator classFileLocator) {
            return new ForInlining.WithDecorationOnly(instrumentedType, classFileVersion, auxiliaryTypes, new MethodList.Explicit(methods), typeAttributeAppender, asmVisitorWrapper, annotationValueFilterFactory, annotationRetention, auxiliaryTypeNamingStrategy, implementationContextFactory, typeValidation, classWriterStrategy, typePool, classFileLocator);
        }

        @Override // net.bytebuddy.dynamic.scaffold.TypeWriter
        @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Setting a debugging property should never change the program outcome")
        public DynamicType.Unloaded<S> make(TypeResolutionStrategy.Resolved typeResolutionStrategy) {
            ClassDumpAction.Dispatcher dispatcher = DUMP_FOLDER == null ? ClassDumpAction.Dispatcher.Disabled.INSTANCE : new ClassDumpAction.Dispatcher.Enabled(DUMP_FOLDER, System.currentTimeMillis());
            Default<S>.UnresolvedType unresolvedType = create(typeResolutionStrategy.injectedInto(this.typeInitializer), dispatcher);
            dispatcher.dump(this.instrumentedType, false, unresolvedType.getBinaryRepresentation());
            return unresolvedType.toDynamicType(typeResolutionStrategy);
        }

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$UnresolvedType.class */
        protected class UnresolvedType {
            private final byte[] binaryRepresentation;
            private final List<? extends DynamicType> auxiliaryTypes;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && Arrays.equals(this.binaryRepresentation, ((UnresolvedType) obj).binaryRepresentation) && this.auxiliaryTypes.equals(((UnresolvedType) obj).auxiliaryTypes) && Default.this.equals(Default.this);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + Arrays.hashCode(this.binaryRepresentation)) * 31) + this.auxiliaryTypes.hashCode()) * 31) + Default.this.hashCode();
            }

            protected UnresolvedType(byte[] binaryRepresentation, List<? extends DynamicType> auxiliaryTypes) {
                this.binaryRepresentation = binaryRepresentation;
                this.auxiliaryTypes = auxiliaryTypes;
            }

            protected DynamicType.Unloaded<S> toDynamicType(TypeResolutionStrategy.Resolved typeResolutionStrategy) {
                return new DynamicType.Default.Unloaded(Default.this.instrumentedType, this.binaryRepresentation, Default.this.loadedTypeInitializer, CompoundList.m80of((List) Default.this.auxiliaryTypes, (List) this.auxiliaryTypes), typeResolutionStrategy);
            }

            protected byte[] getBinaryRepresentation() {
                return this.binaryRepresentation;
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ValidatingClassVisitor.class */
        protected static class ValidatingClassVisitor extends ClassVisitor {
            private static final String NO_PARAMETERS = "()";
            private static final String RETURNS_VOID = "V";
            private static final String STRING_DESCRIPTOR = "Ljava/lang/String;";
            private static final FieldVisitor IGNORE_FIELD = null;
            private static final MethodVisitor IGNORE_METHOD = null;
            private Constraint constraint;

            protected ValidatingClassVisitor(ClassVisitor classVisitor) {
                super(OpenedClassReader.ASM_API, classVisitor);
            }

            /* renamed from: of */
            protected static ClassVisitor m204of(ClassVisitor classVisitor, TypeValidation typeValidation) {
                return typeValidation.isEnabled() ? new ValidatingClassVisitor(classVisitor) : classVisitor;
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public void visit(int version, int modifiers, String name, String signature, String superName, String[] interfaces) {
                boolean record;
                ClassFileVersion classFileVersion = ClassFileVersion.ofMinorMajor(version);
                List<Constraint> constraints = new ArrayList<>();
                constraints.add(new Constraint.ForClassFileVersion(classFileVersion));
                if (name.endsWith("/package-info")) {
                    constraints.add(Constraint.ForPackageType.INSTANCE);
                } else if ((modifiers & 8192) != 0) {
                    if (!classFileVersion.isAtLeast(ClassFileVersion.JAVA_V5)) {
                        throw new IllegalStateException("Cannot define an annotation type for class file version " + classFileVersion);
                    }
                    constraints.add(classFileVersion.isAtLeast(ClassFileVersion.JAVA_V8) ? Constraint.ForAnnotation.JAVA_8 : Constraint.ForAnnotation.CLASSIC);
                } else if ((modifiers & 512) != 0) {
                    constraints.add(classFileVersion.isAtLeast(ClassFileVersion.JAVA_V8) ? Constraint.ForInterface.JAVA_8 : Constraint.ForInterface.CLASSIC);
                } else if ((modifiers & 1024) != 0) {
                    constraints.add(Constraint.ForClass.ABSTRACT);
                } else {
                    constraints.add(Constraint.ForClass.MANIFEST);
                }
                if ((modifiers & 65536) != 0) {
                    constraints.add(Constraint.ForRecord.INSTANCE);
                    record = true;
                } else {
                    record = false;
                }
                this.constraint = new Constraint.Compound(constraints);
                this.constraint.assertType(modifiers, interfaces != null, signature != null);
                if (record) {
                    this.constraint.assertRecord();
                }
                visit(version, modifiers, name, signature, superName, interfaces);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public void visitPermittedSubclass(String permittedSubclass) {
                this.constraint.assertPermittedSubclass();
                visitPermittedSubclass(permittedSubclass);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
                this.constraint.assertAnnotation();
                return visitAnnotation(descriptor, visible);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public AnnotationVisitor visitTypeAnnotation(int typeReference, TypePath typePath, String descriptor, boolean visible) {
                this.constraint.assertTypeAnnotation();
                return visitTypeAnnotation(typeReference, typePath, descriptor, visible);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public void visitNestHost(String nestHost) {
                this.constraint.assertNestMate();
                visitNestHost(nestHost);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public void visitNestMember(String nestMember) {
                this.constraint.assertNestMate();
                visitNestMember(nestMember);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public FieldVisitor visitField(int modifiers, String name, String descriptor, String signature, Object defaultValue) {
                Class<?> type;
                int maximum;
                int minimum;
                if (defaultValue != null) {
                    switch (descriptor.charAt(0)) {
                        case 'B':
                        case 'C':
                        case 'I':
                        case 'S':
                        case 'Z':
                            type = Integer.class;
                            break;
                        case 'D':
                            type = Double.class;
                            break;
                        case 'E':
                        case 'G':
                        case 'H':
                        case 'K':
                        case 'L':
                        case 'M':
                        case 'N':
                        case 'O':
                        case 'P':
                        case 'Q':
                        case 'R':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'W':
                        case 'X':
                        case 'Y':
                        default:
                            if (descriptor.equals(STRING_DESCRIPTOR)) {
                                type = String.class;
                                break;
                            } else {
                                throw new IllegalStateException("Cannot define a default value for type of field " + name);
                            }
                        case 'F':
                            type = Float.class;
                            break;
                        case 'J':
                            type = Long.class;
                            break;
                    }
                    if (!type.isInstance(defaultValue)) {
                        throw new IllegalStateException("Field " + name + " defines an incompatible default value " + defaultValue);
                    } else if (type == Integer.class) {
                        switch (descriptor.charAt(0)) {
                            case 'B':
                                minimum = -128;
                                maximum = 127;
                                break;
                            case 'C':
                                minimum = 0;
                                maximum = 65535;
                                break;
                            case 'S':
                                minimum = -32768;
                                maximum = 32767;
                                break;
                            case 'Z':
                                minimum = 0;
                                maximum = 1;
                                break;
                            default:
                                minimum = Integer.MIN_VALUE;
                                maximum = Integer.MAX_VALUE;
                                break;
                        }
                        int value = ((Integer) defaultValue).intValue();
                        if (value < minimum || value > maximum) {
                            throw new IllegalStateException("Field " + name + " defines an incompatible default value " + defaultValue);
                        }
                    }
                }
                this.constraint.assertField(name, (modifiers & 1) != 0, (modifiers & 8) != 0, (modifiers & 16) != 0, signature != null);
                FieldVisitor fieldVisitor = visitField(modifiers, name, descriptor, signature, defaultValue);
                return fieldVisitor == null ? IGNORE_FIELD : new ValidatingFieldVisitor(fieldVisitor);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public MethodVisitor visitMethod(int modifiers, String name, String descriptor, String signature, String[] exceptions) {
                this.constraint.assertMethod(name, (modifiers & 1024) != 0, (modifiers & 1) != 0, (modifiers & 2) != 0, (modifiers & 8) != 0, !name.equals("<init>") && !name.equals("<clinit>") && (modifiers & 10) == 0, name.equals("<init>"), !descriptor.startsWith(NO_PARAMETERS) || descriptor.endsWith(RETURNS_VOID), signature != null);
                MethodVisitor methodVisitor = visitMethod(modifiers, name, descriptor, signature, exceptions);
                return methodVisitor == null ? IGNORE_METHOD : new ValidatingMethodVisitor(methodVisitor, name);
            }

            /* access modifiers changed from: protected */
            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ValidatingClassVisitor$Constraint.class */
            public interface Constraint {
                void assertType(int i, boolean z, boolean z2);

                void assertField(String str, boolean z, boolean z2, boolean z3, boolean z4);

                void assertMethod(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8);

                void assertAnnotation();

                void assertTypeAnnotation();

                void assertDefaultValue(String str);

                void assertDefaultMethodCall();

                void assertTypeInConstantPool();

                void assertMethodTypeInConstantPool();

                void assertHandleInConstantPool();

                void assertInvokeDynamic();

                void assertSubRoutine();

                void assertDynamicValueInConstantPool();

                void assertNestMate();

                void assertRecord();

                void assertPermittedSubclass();

                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ValidatingClassVisitor$Constraint$ForClass.class */
                public enum ForClass implements Constraint {
                    MANIFEST(true),
                    ABSTRACT(false);
                    
                    private final boolean manifestType;

                    ForClass(boolean manifestType) {
                        this.manifestType = manifestType;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertType(int modifier, boolean definesInterfaces, boolean isGeneric) {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertField(String name, boolean isPublic, boolean isStatic, boolean isFinal, boolean isGeneric) {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethod(String name, boolean isAbstract, boolean isPublic, boolean isPrivate, boolean isStatic, boolean isVirtual, boolean isConstructor, boolean isDefaultValueIncompatible, boolean isGeneric) {
                        if (isAbstract && this.manifestType) {
                            throw new IllegalStateException("Cannot define abstract method '" + name + "' for non-abstract class");
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertAnnotation() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeAnnotation() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultValue(String name) {
                        throw new IllegalStateException("Cannot define default value for '" + name + "' for non-annotation type");
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultMethodCall() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethodTypeInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertHandleInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertInvokeDynamic() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertSubRoutine() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDynamicValueInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertNestMate() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertRecord() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertPermittedSubclass() {
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ValidatingClassVisitor$Constraint$ForPackageType.class */
                public enum ForPackageType implements Constraint {
                    INSTANCE;

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertField(String name, boolean isPublic, boolean isStatic, boolean isFinal, boolean isGeneric) {
                        throw new IllegalStateException("Cannot define a field for a package description type");
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethod(String name, boolean isAbstract, boolean isPublic, boolean isPrivate, boolean isStatic, boolean isVirtual, boolean isConstructor, boolean isNoDefaultValue, boolean isGeneric) {
                        throw new IllegalStateException("Cannot define a method for a package description type");
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertAnnotation() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeAnnotation() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultValue(String name) {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultMethodCall() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethodTypeInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertHandleInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertInvokeDynamic() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertSubRoutine() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertType(int modifier, boolean definesInterfaces, boolean isGeneric) {
                        if (modifier != 5632) {
                            throw new IllegalStateException("A package description type must define 5632 as modifier");
                        } else if (definesInterfaces) {
                            throw new IllegalStateException("Cannot implement interface for package type");
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDynamicValueInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertNestMate() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertRecord() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertPermittedSubclass() {
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ValidatingClassVisitor$Constraint$ForInterface.class */
                public enum ForInterface implements Constraint {
                    CLASSIC(true),
                    JAVA_8(false);
                    
                    private final boolean classic;

                    ForInterface(boolean classic) {
                        this.classic = classic;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertField(String name, boolean isPublic, boolean isStatic, boolean isFinal, boolean isGeneric) {
                        if (!isStatic || !isPublic || !isFinal) {
                            throw new IllegalStateException("Cannot only define public, static, final field '" + name + "' for interface type");
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethod(String name, boolean isAbstract, boolean isPublic, boolean isPrivate, boolean isStatic, boolean isVirtual, boolean isConstructor, boolean isDefaultValueIncompatible, boolean isGeneric) {
                        if (name.equals("<clinit>")) {
                            return;
                        }
                        if (isConstructor) {
                            throw new IllegalStateException("Cannot define constructor for interface type");
                        } else if (this.classic && !isPublic) {
                            throw new IllegalStateException("Cannot define non-public method '" + name + "' for interface type");
                        } else if (this.classic && !isVirtual) {
                            throw new IllegalStateException("Cannot define non-virtual method '" + name + "' for a pre-Java 8 interface type");
                        } else if (this.classic && !isAbstract) {
                            throw new IllegalStateException("Cannot define default method '" + name + "' for pre-Java 8 interface type");
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertAnnotation() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeAnnotation() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultValue(String name) {
                        throw new IllegalStateException("Cannot define default value for '" + name + "' for non-annotation type");
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultMethodCall() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertType(int modifier, boolean definesInterfaces, boolean isGeneric) {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethodTypeInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertHandleInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertInvokeDynamic() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertSubRoutine() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDynamicValueInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertNestMate() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertRecord() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertPermittedSubclass() {
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ValidatingClassVisitor$Constraint$ForRecord.class */
                public enum ForRecord implements Constraint {
                    INSTANCE;

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertField(String name, boolean isPublic, boolean isStatic, boolean isFinal, boolean isGeneric) {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethod(String name, boolean isAbstract, boolean isPublic, boolean isPrivate, boolean isStatic, boolean isVirtual, boolean isConstructor, boolean isDefaultValueIncompatible, boolean isGeneric) {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertAnnotation() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeAnnotation() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultValue(String name) {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultMethodCall() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertType(int modifier, boolean definesInterfaces, boolean isGeneric) {
                        if ((modifier & 1024) != 0) {
                            throw new IllegalStateException("Cannot define a record class as abstract");
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethodTypeInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertHandleInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertInvokeDynamic() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertSubRoutine() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDynamicValueInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertNestMate() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertRecord() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertPermittedSubclass() {
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ValidatingClassVisitor$Constraint$ForAnnotation.class */
                public enum ForAnnotation implements Constraint {
                    CLASSIC(true),
                    JAVA_8(false);
                    
                    private final boolean classic;

                    ForAnnotation(boolean classic) {
                        this.classic = classic;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertField(String name, boolean isPublic, boolean isStatic, boolean isFinal, boolean isGeneric) {
                        if (!isStatic || !isPublic || !isFinal) {
                            throw new IllegalStateException("Cannot only define public, static, final field '" + name + "' for interface type");
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethod(String name, boolean isAbstract, boolean isPublic, boolean isPrivate, boolean isStatic, boolean isVirtual, boolean isConstructor, boolean isDefaultValueIncompatible, boolean isGeneric) {
                        if (name.equals("<clinit>")) {
                            return;
                        }
                        if (isConstructor) {
                            throw new IllegalStateException("Cannot define constructor for interface type");
                        } else if (this.classic && !isVirtual) {
                            throw new IllegalStateException("Cannot define non-virtual method '" + name + "' for a pre-Java 8 annotation type");
                        } else if (!isStatic && isDefaultValueIncompatible) {
                            throw new IllegalStateException("Cannot define method '" + name + "' with the given signature as an annotation type method");
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertAnnotation() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeAnnotation() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultValue(String name) {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultMethodCall() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertType(int modifier, boolean definesInterfaces, boolean isGeneric) {
                        if ((modifier & 512) == 0) {
                            throw new IllegalStateException("Cannot define annotation type without interface modifier");
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethodTypeInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertHandleInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertInvokeDynamic() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertSubRoutine() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDynamicValueInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertNestMate() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertRecord() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertPermittedSubclass() {
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ValidatingClassVisitor$Constraint$ForClassFileVersion.class */
                public static class ForClassFileVersion implements Constraint {
                    private final ClassFileVersion classFileVersion;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.classFileVersion.equals(((ForClassFileVersion) obj).classFileVersion);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.classFileVersion.hashCode();
                    }

                    protected ForClassFileVersion(ClassFileVersion classFileVersion) {
                        this.classFileVersion = classFileVersion;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertType(int modifiers, boolean definesInterfaces, boolean isGeneric) {
                        if ((modifiers & 8192) != 0 && !this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V5)) {
                            throw new IllegalStateException("Cannot define annotation type for class file version " + this.classFileVersion);
                        } else if (isGeneric && !this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V4)) {
                            throw new IllegalStateException("Cannot define a generic type for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertField(String name, boolean isPublic, boolean isStatic, boolean isFinal, boolean isGeneric) {
                        if (isGeneric && !this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V4)) {
                            throw new IllegalStateException("Cannot define generic field '" + name + "' for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethod(String name, boolean isAbstract, boolean isPublic, boolean isPrivate, boolean isStatic, boolean isVirtual, boolean isConstructor, boolean isDefaultValueIncompatible, boolean isGeneric) {
                        if (isGeneric && !this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V4)) {
                            throw new IllegalStateException("Cannot define generic method '" + name + "' for class file version " + this.classFileVersion);
                        } else if (!isVirtual && isAbstract) {
                            throw new IllegalStateException("Cannot define static or non-virtual method '" + name + "' to be abstract");
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertAnnotation() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V5)) {
                            throw new IllegalStateException("Cannot write annotations for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeAnnotation() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V5)) {
                            throw new IllegalStateException("Cannot write type annotations for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultValue(String name) {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultMethodCall() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V8)) {
                            throw new IllegalStateException("Cannot invoke default method for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeInConstantPool() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V5)) {
                            throw new IllegalStateException("Cannot write type to constant pool for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethodTypeInConstantPool() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V7)) {
                            throw new IllegalStateException("Cannot write method type to constant pool for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertHandleInConstantPool() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V7)) {
                            throw new IllegalStateException("Cannot write method handle to constant pool for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertInvokeDynamic() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V7)) {
                            throw new IllegalStateException("Cannot write invoke dynamic instruction for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertSubRoutine() {
                        if (this.classFileVersion.isGreaterThan(ClassFileVersion.JAVA_V5)) {
                            throw new IllegalStateException("Cannot write subroutine for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDynamicValueInConstantPool() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V11)) {
                            throw new IllegalStateException("Cannot write dynamic constant for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertNestMate() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V11)) {
                            throw new IllegalStateException("Cannot define nest mate for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertRecord() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V14)) {
                            throw new IllegalStateException("Cannot define record for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertPermittedSubclass() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V17)) {
                            throw new IllegalStateException("Cannot define permitted subclasses for class file version " + this.classFileVersion);
                        }
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ValidatingClassVisitor$Constraint$Compound.class */
                public static class Compound implements Constraint {
                    private final List<Constraint> constraints = new ArrayList();

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.constraints.equals(((Compound) obj).constraints);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.constraints.hashCode();
                    }

                    public Compound(List<? extends Constraint> constraints) {
                        for (Constraint constraint : constraints) {
                            if (constraint instanceof Compound) {
                                this.constraints.addAll(((Compound) constraint).constraints);
                            } else {
                                this.constraints.add(constraint);
                            }
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertType(int modifier, boolean definesInterfaces, boolean isGeneric) {
                        for (Constraint constraint : this.constraints) {
                            constraint.assertType(modifier, definesInterfaces, isGeneric);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertField(String name, boolean isPublic, boolean isStatic, boolean isFinal, boolean isGeneric) {
                        for (Constraint constraint : this.constraints) {
                            constraint.assertField(name, isPublic, isStatic, isFinal, isGeneric);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethod(String name, boolean isAbstract, boolean isPublic, boolean isPrivate, boolean isStatic, boolean isVirtual, boolean isConstructor, boolean isDefaultValueIncompatible, boolean isGeneric) {
                        for (Constraint constraint : this.constraints) {
                            constraint.assertMethod(name, isAbstract, isPublic, isPrivate, isStatic, isVirtual, isConstructor, isDefaultValueIncompatible, isGeneric);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultValue(String name) {
                        for (Constraint constraint : this.constraints) {
                            constraint.assertDefaultValue(name);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultMethodCall() {
                        for (Constraint constraint : this.constraints) {
                            constraint.assertDefaultMethodCall();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertAnnotation() {
                        for (Constraint constraint : this.constraints) {
                            constraint.assertAnnotation();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeAnnotation() {
                        for (Constraint constraint : this.constraints) {
                            constraint.assertTypeAnnotation();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeInConstantPool() {
                        for (Constraint constraint : this.constraints) {
                            constraint.assertTypeInConstantPool();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethodTypeInConstantPool() {
                        for (Constraint constraint : this.constraints) {
                            constraint.assertMethodTypeInConstantPool();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertHandleInConstantPool() {
                        for (Constraint constraint : this.constraints) {
                            constraint.assertHandleInConstantPool();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertInvokeDynamic() {
                        for (Constraint constraint : this.constraints) {
                            constraint.assertInvokeDynamic();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertSubRoutine() {
                        for (Constraint constraint : this.constraints) {
                            constraint.assertSubRoutine();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDynamicValueInConstantPool() {
                        for (Constraint constraint : this.constraints) {
                            constraint.assertDynamicValueInConstantPool();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertNestMate() {
                        for (Constraint constraint : this.constraints) {
                            constraint.assertNestMate();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertRecord() {
                        for (Constraint constraint : this.constraints) {
                            constraint.assertRecord();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertPermittedSubclass() {
                        for (Constraint constraint : this.constraints) {
                            constraint.assertPermittedSubclass();
                        }
                    }
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ValidatingClassVisitor$ValidatingFieldVisitor.class */
            protected class ValidatingFieldVisitor extends FieldVisitor {
                protected ValidatingFieldVisitor(FieldVisitor fieldVisitor) {
                    super(OpenedClassReader.ASM_API, fieldVisitor);
                }

                @Override // net.bytebuddy.jar.asm.FieldVisitor
                public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
                    ValidatingClassVisitor.this.constraint.assertAnnotation();
                    return visitAnnotation(desc, visible);
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ValidatingClassVisitor$ValidatingMethodVisitor.class */
            protected class ValidatingMethodVisitor extends MethodVisitor {
                private final String name;

                protected ValidatingMethodVisitor(MethodVisitor methodVisitor, String name) {
                    super(OpenedClassReader.ASM_API, methodVisitor);
                    this.name = name;
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
                    ValidatingClassVisitor.this.constraint.assertAnnotation();
                    return visitAnnotation(desc, visible);
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public AnnotationVisitor visitAnnotationDefault() {
                    ValidatingClassVisitor.this.constraint.assertDefaultValue(this.name);
                    return visitAnnotationDefault();
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                @SuppressFBWarnings(value = {"SF_SWITCH_NO_DEFAULT"}, justification = "Fall through to default case is intentional")
                public void visitLdcInsn(Object value) {
                    if (value instanceof Type) {
                        switch (((Type) value).getSort()) {
                            case 9:
                            case 10:
                                ValidatingClassVisitor.this.constraint.assertTypeInConstantPool();
                                break;
                            case 11:
                                ValidatingClassVisitor.this.constraint.assertMethodTypeInConstantPool();
                                break;
                        }
                    } else if (value instanceof Handle) {
                        ValidatingClassVisitor.this.constraint.assertHandleInConstantPool();
                    } else if (value instanceof ConstantDynamic) {
                        ValidatingClassVisitor.this.constraint.assertDynamicValueInConstantPool();
                    }
                    visitLdcInsn(value);
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
                    if (isInterface && opcode == 183) {
                        ValidatingClassVisitor.this.constraint.assertDefaultMethodCall();
                    }
                    visitMethodInsn(opcode, owner, name, descriptor, isInterface);
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitInvokeDynamicInsn(String name, String descriptor, Handle bootstrapMethod, Object[] bootstrapArgument) {
                    ValidatingClassVisitor.this.constraint.assertInvokeDynamic();
                    for (Object constant : bootstrapArgument) {
                        if (constant instanceof ConstantDynamic) {
                            ValidatingClassVisitor.this.constraint.assertDynamicValueInConstantPool();
                        }
                    }
                    visitInvokeDynamicInsn(name, descriptor, bootstrapMethod, bootstrapArgument);
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitJumpInsn(int opcode, Label label) {
                    if (opcode == 168) {
                        ValidatingClassVisitor.this.constraint.assertSubRoutine();
                    }
                    visitJumpInsn(opcode, label);
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining.class */
        public static abstract class ForInlining<U> extends Default<U> {
            private static final FieldVisitor IGNORE_FIELD = null;
            private static final MethodVisitor IGNORE_METHOD = null;
            private static final RecordComponentVisitor IGNORE_RECORD_COMPONENT = null;
            private static final AnnotationVisitor IGNORE_ANNOTATION = null;
            protected final TypeDescription originalType;
            protected final ClassFileLocator classFileLocator;

            protected abstract ClassVisitor writeTo(ClassVisitor classVisitor, TypeInitializer typeInitializer, ContextRegistry contextRegistry, int i, int i2);

            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default
            public boolean equals(Object obj) {
                if (!equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.originalType.equals(((ForInlining) obj).originalType) && this.classFileLocator.equals(((ForInlining) obj).classFileLocator);
            }

            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default
            public int hashCode() {
                return (((hashCode() * 31) + this.originalType.hashCode()) * 31) + this.classFileLocator.hashCode();
            }

            protected ForInlining(TypeDescription instrumentedType, ClassFileVersion classFileVersion, FieldPool fieldPool, RecordComponentPool recordComponentPool, List<? extends DynamicType> auxiliaryTypes, FieldList<FieldDescription.InDefinedShape> fields, MethodList<?> methods, MethodList<?> instrumentedMethods, RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponents, LoadedTypeInitializer loadedTypeInitializer, TypeInitializer typeInitializer, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, AnnotationValueFilter.Factory annotationValueFilterFactory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy, Implementation.Context.Factory implementationContextFactory, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool, TypeDescription originalType, ClassFileLocator classFileLocator) {
                super(instrumentedType, classFileVersion, fieldPool, recordComponentPool, auxiliaryTypes, fields, methods, instrumentedMethods, recordComponents, loadedTypeInitializer, typeInitializer, typeAttributeAppender, asmVisitorWrapper, annotationValueFilterFactory, annotationRetention, auxiliaryTypeNamingStrategy, implementationContextFactory, typeValidation, classWriterStrategy, typePool);
                this.originalType = originalType;
                this.classFileLocator = classFileLocator;
            }

            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default
            protected Default<U>.UnresolvedType create(TypeInitializer typeInitializer, ClassDumpAction.Dispatcher dispatcher) {
                try {
                    int writerFlags = this.asmVisitorWrapper.mergeWriter(0);
                    int readerFlags = this.asmVisitorWrapper.mergeReader(0);
                    byte[] binaryRepresentation = this.classFileLocator.locate(this.originalType.getName()).resolve();
                    dispatcher.dump(this.instrumentedType, true, binaryRepresentation);
                    ClassReader classReader = OpenedClassReader.m63of(binaryRepresentation);
                    ClassWriter classWriter = this.classWriterStrategy.resolve(writerFlags, this.typePool, classReader);
                    ContextRegistry contextRegistry = new ContextRegistry();
                    classReader.accept(writeTo(ValidatingClassVisitor.m204of(classWriter, this.typeValidation), typeInitializer, contextRegistry, writerFlags, readerFlags), readerFlags);
                    return new UnresolvedType(classWriter.toByteArray(), contextRegistry.getAuxiliaryTypes());
                } catch (IOException exception) {
                    throw new RuntimeException("The class file could not be written", exception);
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$ContextRegistry.class */
            protected static class ContextRegistry {
                private Implementation.Context.ExtractableView implementationContext;

                protected ContextRegistry() {
                }

                public void setImplementationContext(Implementation.Context.ExtractableView implementationContext) {
                    this.implementationContext = implementationContext;
                }

                @SuppressFBWarnings(value = {"UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR"}, justification = "Lazy value definition is intended")
                public List<DynamicType> getAuxiliaryTypes() {
                    return this.implementationContext.getAuxiliaryTypes();
                }
            }

            /* access modifiers changed from: protected */
            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithFullProcessing.class */
            public static class WithFullProcessing<V> extends ForInlining<V> {
                private final MethodRegistry.Prepared methodRegistry;
                private final Implementation.Target.Factory implementationTargetFactory;
                private final MethodRebaseResolver methodRebaseResolver;

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining, net.bytebuddy.dynamic.scaffold.TypeWriter.Default
                public boolean equals(Object obj) {
                    if (!equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.methodRegistry.equals(((WithFullProcessing) obj).methodRegistry) && this.implementationTargetFactory.equals(((WithFullProcessing) obj).implementationTargetFactory) && this.methodRebaseResolver.equals(((WithFullProcessing) obj).methodRebaseResolver);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining, net.bytebuddy.dynamic.scaffold.TypeWriter.Default
                public int hashCode() {
                    return (((((hashCode() * 31) + this.methodRegistry.hashCode()) * 31) + this.implementationTargetFactory.hashCode()) * 31) + this.methodRebaseResolver.hashCode();
                }

                protected WithFullProcessing(TypeDescription instrumentedType, ClassFileVersion classFileVersion, FieldPool fieldPool, RecordComponentPool recordComponentPool, List<? extends DynamicType> auxiliaryTypes, FieldList<FieldDescription.InDefinedShape> fields, MethodList<?> methods, MethodList<?> instrumentedMethods, RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponents, LoadedTypeInitializer loadedTypeInitializer, TypeInitializer typeInitializer, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, AnnotationValueFilter.Factory annotationValueFilterFactory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy, Implementation.Context.Factory implementationContextFactory, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool, TypeDescription originalType, ClassFileLocator classFileLocator, MethodRegistry.Prepared methodRegistry, Implementation.Target.Factory implementationTargetFactory, MethodRebaseResolver methodRebaseResolver) {
                    super(instrumentedType, classFileVersion, fieldPool, recordComponentPool, auxiliaryTypes, fields, methods, instrumentedMethods, recordComponents, loadedTypeInitializer, typeInitializer, typeAttributeAppender, asmVisitorWrapper, annotationValueFilterFactory, annotationRetention, auxiliaryTypeNamingStrategy, implementationContextFactory, typeValidation, classWriterStrategy, typePool, originalType, classFileLocator);
                    this.methodRegistry = methodRegistry;
                    this.implementationTargetFactory = implementationTargetFactory;
                    this.methodRebaseResolver = methodRebaseResolver;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining
                protected ClassVisitor writeTo(ClassVisitor classVisitor, TypeInitializer typeInitializer, ContextRegistry contextRegistry, int writerFlags, int readerFlags) {
                    ClassVisitor classVisitor2 = new RedefinitionClassVisitor(classVisitor, typeInitializer, contextRegistry, writerFlags, readerFlags);
                    return this.originalType.getName().equals(this.instrumentedType.getName()) ? classVisitor2 : new OpenedClassRemapper(classVisitor2, new SimpleRemapper(this.originalType.getInternalName(), this.instrumentedType.getInternalName()));
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithFullProcessing$OpenedClassRemapper.class */
                protected static class OpenedClassRemapper extends ClassRemapper {
                    protected OpenedClassRemapper(ClassVisitor classVisitor, Remapper remapper) {
                        super(OpenedClassReader.ASM_API, classVisitor, remapper);
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithFullProcessing$InitializationHandler.class */
                protected interface InitializationHandler {
                    void complete(ClassVisitor classVisitor, Implementation.Context.ExtractableView extractableView);

                    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithFullProcessing$InitializationHandler$Creating.class */
                    public static class Creating extends TypeInitializer.Drain.Default implements InitializationHandler {
                        protected Creating(TypeDescription instrumentedType, MethodPool methodPool, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                            super(instrumentedType, methodPool, annotationValueFilterFactory);
                        }

                        @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler
                        public void complete(ClassVisitor classVisitor, Implementation.Context.ExtractableView implementationContext) {
                            implementationContext.drain(this, classVisitor, this.annotationValueFilterFactory);
                        }
                    }

                    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithFullProcessing$InitializationHandler$Appending.class */
                    public static abstract class Appending extends MethodVisitor implements InitializationHandler, TypeInitializer.Drain {
                        protected final TypeDescription instrumentedType;
                        protected final MethodPool.Record record;
                        protected final AnnotationValueFilter.Factory annotationValueFilterFactory;
                        protected final FrameWriter frameWriter;
                        protected int stackSize;
                        protected int localVariableLength;

                        protected abstract void onStart();

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public abstract void visitEnd();

                        protected abstract void onComplete(Implementation.Context context);

                        protected Appending(MethodVisitor methodVisitor, TypeDescription instrumentedType, MethodPool.Record record, AnnotationValueFilter.Factory annotationValueFilterFactory, boolean requireFrames, boolean expandFrames) {
                            super(OpenedClassReader.ASM_API, methodVisitor);
                            this.instrumentedType = instrumentedType;
                            this.record = record;
                            this.annotationValueFilterFactory = annotationValueFilterFactory;
                            if (!requireFrames) {
                                this.frameWriter = FrameWriter.NoOp.INSTANCE;
                            } else if (expandFrames) {
                                this.frameWriter = FrameWriter.Expanding.INSTANCE;
                            } else {
                                this.frameWriter = new FrameWriter.Active();
                            }
                        }

                        /* renamed from: of */
                        protected static InitializationHandler m205of(boolean enabled, MethodVisitor methodVisitor, TypeDescription instrumentedType, MethodPool methodPool, AnnotationValueFilter.Factory annotationValueFilterFactory, boolean requireFrames, boolean expandFrames) {
                            if (enabled) {
                                return withDrain(methodVisitor, instrumentedType, methodPool, annotationValueFilterFactory, requireFrames, expandFrames);
                            }
                            return withoutDrain(methodVisitor, instrumentedType, methodPool, annotationValueFilterFactory, requireFrames, expandFrames);
                        }

                        private static WithDrain withDrain(MethodVisitor methodVisitor, TypeDescription instrumentedType, MethodPool methodPool, AnnotationValueFilter.Factory annotationValueFilterFactory, boolean requireFrames, boolean expandFrames) {
                            MethodPool.Record record = methodPool.target(new MethodDescription.Latent.TypeInitializer(instrumentedType));
                            return record.getSort().isImplemented() ? new WithDrain.WithActiveRecord(methodVisitor, instrumentedType, record, annotationValueFilterFactory, requireFrames, expandFrames) : new WithDrain.WithoutActiveRecord(methodVisitor, instrumentedType, record, annotationValueFilterFactory, requireFrames, expandFrames);
                        }

                        private static WithoutDrain withoutDrain(MethodVisitor methodVisitor, TypeDescription instrumentedType, MethodPool methodPool, AnnotationValueFilter.Factory annotationValueFilterFactory, boolean requireFrames, boolean expandFrames) {
                            MethodPool.Record record = methodPool.target(new MethodDescription.Latent.TypeInitializer(instrumentedType));
                            return record.getSort().isImplemented() ? new WithoutDrain.WithActiveRecord(methodVisitor, instrumentedType, record, annotationValueFilterFactory, requireFrames, expandFrames) : new WithoutDrain.WithoutActiveRecord(methodVisitor, instrumentedType, record, annotationValueFilterFactory);
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitCode() {
                            this.record.applyAttributes(this.f3068mv, this.annotationValueFilterFactory);
                            visitCode();
                            onStart();
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitFrame(int type, int localVariableLength, Object[] localVariable, int stackSize, Object[] stack) {
                            visitFrame(type, localVariableLength, localVariable, stackSize, stack);
                            this.frameWriter.onFrame(type, localVariableLength);
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitMaxs(int stackSize, int localVariableLength) {
                            this.stackSize = stackSize;
                            this.localVariableLength = localVariableLength;
                        }

                        @Override // net.bytebuddy.dynamic.scaffold.TypeInitializer.Drain
                        public void apply(ClassVisitor classVisitor, TypeInitializer typeInitializer, Implementation.Context implementationContext) {
                            ByteCodeAppender.Size size = typeInitializer.apply(this.f3068mv, implementationContext, new MethodDescription.Latent.TypeInitializer(this.instrumentedType));
                            this.stackSize = Math.max(this.stackSize, size.getOperandStackSize());
                            this.localVariableLength = Math.max(this.localVariableLength, size.getLocalVariableSize());
                            onComplete(implementationContext);
                        }

                        @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler
                        public void complete(ClassVisitor classVisitor, Implementation.Context.ExtractableView implementationContext) {
                            implementationContext.drain(this, classVisitor, this.annotationValueFilterFactory);
                            this.f3068mv.visitMaxs(this.stackSize, this.localVariableLength);
                            this.f3068mv.visitEnd();
                        }

                        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithFullProcessing$InitializationHandler$Appending$FrameWriter.class */
                        protected interface FrameWriter {
                            public static final Object[] EMPTY = new Object[0];

                            void onFrame(int i, int i2);

                            void emitFrame(MethodVisitor methodVisitor);

                            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithFullProcessing$InitializationHandler$Appending$FrameWriter$NoOp.class */
                            public enum NoOp implements FrameWriter {
                                INSTANCE;

                                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending.FrameWriter
                                public void onFrame(int type, int localVariableLength) {
                                }

                                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending.FrameWriter
                                public void emitFrame(MethodVisitor methodVisitor) {
                                }
                            }

                            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithFullProcessing$InitializationHandler$Appending$FrameWriter$Expanding.class */
                            public enum Expanding implements FrameWriter {
                                INSTANCE;

                                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending.FrameWriter
                                public void onFrame(int type, int localVariableLength) {
                                }

                                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending.FrameWriter
                                public void emitFrame(MethodVisitor methodVisitor) {
                                    methodVisitor.visitFrame(-1, EMPTY.length, EMPTY, EMPTY.length, EMPTY);
                                }
                            }

                            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithFullProcessing$InitializationHandler$Appending$FrameWriter$Active.class */
                            public static class Active implements FrameWriter {
                                private int currentLocalVariableLength;

                                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending.FrameWriter
                                public void onFrame(int type, int localVariableLength) {
                                    switch (type) {
                                        case -1:
                                        case 0:
                                            this.currentLocalVariableLength = localVariableLength;
                                            return;
                                        case 1:
                                            this.currentLocalVariableLength += localVariableLength;
                                            return;
                                        case 2:
                                            this.currentLocalVariableLength -= localVariableLength;
                                            return;
                                        case 3:
                                        case 4:
                                            return;
                                        default:
                                            throw new IllegalStateException("Unexpected frame type: " + type);
                                    }
                                }

                                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending.FrameWriter
                                public void emitFrame(MethodVisitor methodVisitor) {
                                    if (this.currentLocalVariableLength == 0) {
                                        methodVisitor.visitFrame(3, EMPTY.length, EMPTY, EMPTY.length, EMPTY);
                                    } else if (this.currentLocalVariableLength > 3) {
                                        methodVisitor.visitFrame(0, EMPTY.length, EMPTY, EMPTY.length, EMPTY);
                                    } else {
                                        methodVisitor.visitFrame(2, this.currentLocalVariableLength, EMPTY, EMPTY.length, EMPTY);
                                    }
                                    this.currentLocalVariableLength = 0;
                                }
                            }
                        }

                        /* access modifiers changed from: protected */
                        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithFullProcessing$InitializationHandler$Appending$WithoutDrain.class */
                        public static abstract class WithoutDrain extends Appending {
                            protected WithoutDrain(MethodVisitor methodVisitor, TypeDescription instrumentedType, MethodPool.Record record, AnnotationValueFilter.Factory annotationValueFilterFactory, boolean requireFrames, boolean expandFrames) {
                                super(methodVisitor, instrumentedType, record, annotationValueFilterFactory, requireFrames, expandFrames);
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending
                            protected void onStart() {
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending, net.bytebuddy.jar.asm.MethodVisitor
                            public void visitEnd() {
                            }

                            /* access modifiers changed from: protected */
                            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithFullProcessing$InitializationHandler$Appending$WithoutDrain$WithoutActiveRecord.class */
                            public static class WithoutActiveRecord extends WithoutDrain {
                                protected WithoutActiveRecord(MethodVisitor methodVisitor, TypeDescription instrumentedType, MethodPool.Record record, AnnotationValueFilter.Factory annotationValueFilterFactory) {
                                    super(methodVisitor, instrumentedType, record, annotationValueFilterFactory, false, false);
                                }

                                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending
                                protected void onComplete(Implementation.Context implementationContext) {
                                }
                            }

                            /* access modifiers changed from: protected */
                            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithFullProcessing$InitializationHandler$Appending$WithoutDrain$WithActiveRecord.class */
                            public static class WithActiveRecord extends WithoutDrain {
                                private final Label label = new Label();

                                protected WithActiveRecord(MethodVisitor methodVisitor, TypeDescription instrumentedType, MethodPool.Record record, AnnotationValueFilter.Factory annotationValueFilterFactory, boolean requireFrames, boolean expandFrames) {
                                    super(methodVisitor, instrumentedType, record, annotationValueFilterFactory, requireFrames, expandFrames);
                                }

                                @Override // net.bytebuddy.jar.asm.MethodVisitor
                                public void visitInsn(int opcode) {
                                    if (opcode == 177) {
                                        this.f3068mv.visitJumpInsn(167, this.label);
                                    } else {
                                        visitInsn(opcode);
                                    }
                                }

                                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending
                                protected void onComplete(Implementation.Context implementationContext) {
                                    this.f3068mv.visitLabel(this.label);
                                    this.frameWriter.emitFrame(this.f3068mv);
                                    ByteCodeAppender.Size size = this.record.applyCode(this.f3068mv, implementationContext);
                                    this.stackSize = Math.max(this.stackSize, size.getOperandStackSize());
                                    this.localVariableLength = Math.max(this.localVariableLength, size.getLocalVariableSize());
                                }
                            }
                        }

                        /* access modifiers changed from: protected */
                        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithFullProcessing$InitializationHandler$Appending$WithDrain.class */
                        public static abstract class WithDrain extends Appending {
                            protected final Label appended = new Label();
                            protected final Label original = new Label();

                            protected abstract void onAfterComplete(Implementation.Context context);

                            protected WithDrain(MethodVisitor methodVisitor, TypeDescription instrumentedType, MethodPool.Record record, AnnotationValueFilter.Factory annotationValueFilterFactory, boolean requireFrames, boolean expandFrames) {
                                super(new FramePaddingMethodVisitor(methodVisitor), instrumentedType, record, annotationValueFilterFactory, requireFrames, expandFrames);
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending
                            protected void onStart() {
                                this.f3068mv.visitJumpInsn(167, this.appended);
                                this.f3068mv.visitLabel(this.original);
                                this.frameWriter.emitFrame(this.f3068mv);
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending, net.bytebuddy.jar.asm.MethodVisitor
                            public void visitEnd() {
                                this.f3068mv.visitLabel(this.appended);
                                this.frameWriter.emitFrame(this.f3068mv);
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending
                            protected void onComplete(Implementation.Context implementationContext) {
                                this.f3068mv.visitJumpInsn(167, this.original);
                                onAfterComplete(implementationContext);
                            }

                            /* access modifiers changed from: protected */
                            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithFullProcessing$InitializationHandler$Appending$WithDrain$WithoutActiveRecord.class */
                            public static class WithoutActiveRecord extends WithDrain {
                                protected WithoutActiveRecord(MethodVisitor methodVisitor, TypeDescription instrumentedType, MethodPool.Record record, AnnotationValueFilter.Factory annotationValueFilterFactory, boolean requireFrames, boolean expandFrames) {
                                    super(methodVisitor, instrumentedType, record, annotationValueFilterFactory, requireFrames, expandFrames);
                                }

                                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending.WithDrain
                                protected void onAfterComplete(Implementation.Context implementationContext) {
                                }
                            }

                            /* access modifiers changed from: protected */
                            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithFullProcessing$InitializationHandler$Appending$WithDrain$WithActiveRecord.class */
                            public static class WithActiveRecord extends WithDrain {
                                private final Label label = new Label();

                                protected WithActiveRecord(MethodVisitor methodVisitor, TypeDescription instrumentedType, MethodPool.Record record, AnnotationValueFilter.Factory annotationValueFilterFactory, boolean requireFrames, boolean expandFrames) {
                                    super(methodVisitor, instrumentedType, record, annotationValueFilterFactory, requireFrames, expandFrames);
                                }

                                @Override // net.bytebuddy.jar.asm.MethodVisitor
                                public void visitInsn(int opcode) {
                                    if (opcode == 177) {
                                        this.f3068mv.visitJumpInsn(167, this.label);
                                    } else {
                                        visitInsn(opcode);
                                    }
                                }

                                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending.WithDrain
                                protected void onAfterComplete(Implementation.Context implementationContext) {
                                    this.f3068mv.visitLabel(this.label);
                                    this.frameWriter.emitFrame(this.f3068mv);
                                    ByteCodeAppender.Size size = this.record.applyCode(this.f3068mv, implementationContext);
                                    this.stackSize = Math.max(this.stackSize, size.getOperandStackSize());
                                    this.localVariableLength = Math.max(this.localVariableLength, size.getLocalVariableSize());
                                }
                            }
                        }
                    }
                }

                @SuppressFBWarnings(value = {"UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR"}, justification = "Field access order is implied by ASM")
                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithFullProcessing$RedefinitionClassVisitor.class */
                protected class RedefinitionClassVisitor extends MetadataAwareClassVisitor {
                    private final TypeInitializer typeInitializer;
                    private final ContextRegistry contextRegistry;
                    private final int writerFlags;
                    private final int readerFlags;
                    private final LinkedHashMap<String, FieldDescription> declarableFields = new LinkedHashMap<>();
                    private final LinkedHashMap<String, MethodDescription> declarableMethods;
                    private final LinkedHashMap<String, RecordComponentDescription> declarableRecordComponents;
                    private final Set<String> nestMembers;
                    private final LinkedHashMap<String, TypeDescription> declaredTypes;
                    private final Set<String> permittedSubclasses;
                    private MethodPool methodPool;
                    private InitializationHandler initializationHandler;
                    private Implementation.Context.ExtractableView implementationContext;
                    private boolean retainDeprecationModifiers;

                    protected RedefinitionClassVisitor(ClassVisitor classVisitor, TypeInitializer typeInitializer, ContextRegistry contextRegistry, int writerFlags, int readerFlags) {
                        super(OpenedClassReader.ASM_API, classVisitor);
                        this.typeInitializer = typeInitializer;
                        this.contextRegistry = contextRegistry;
                        this.writerFlags = writerFlags;
                        this.readerFlags = readerFlags;
                        for (FieldDescription fieldDescription : WithFullProcessing.this.fields) {
                            this.declarableFields.put(fieldDescription.getInternalName() + fieldDescription.getDescriptor(), fieldDescription);
                        }
                        this.declarableMethods = new LinkedHashMap<>();
                        for (MethodDescription methodDescription : WithFullProcessing.this.instrumentedMethods) {
                            this.declarableMethods.put(methodDescription.getInternalName() + methodDescription.getDescriptor(), methodDescription);
                        }
                        this.declarableRecordComponents = new LinkedHashMap<>();
                        for (RecordComponentDescription recordComponentDescription : WithFullProcessing.this.recordComponents) {
                            this.declarableRecordComponents.put(recordComponentDescription.getActualName(), recordComponentDescription);
                        }
                        if (WithFullProcessing.this.instrumentedType.isNestHost()) {
                            this.nestMembers = new LinkedHashSet();
                            for (TypeDescription typeDescription : WithFullProcessing.this.instrumentedType.getNestMembers().filter(ElementMatchers.not(ElementMatchers.m104is(WithFullProcessing.this.instrumentedType)))) {
                                this.nestMembers.add(typeDescription.getInternalName());
                            }
                        } else {
                            this.nestMembers = Collections.emptySet();
                        }
                        this.declaredTypes = new LinkedHashMap<>();
                        for (TypeDescription typeDescription2 : WithFullProcessing.this.instrumentedType.getDeclaredTypes()) {
                            this.declaredTypes.put(typeDescription2.getInternalName(), typeDescription2);
                        }
                        if (WithFullProcessing.this.instrumentedType.isSealed()) {
                            this.permittedSubclasses = new LinkedHashSet();
                            for (TypeDescription typeDescription3 : WithFullProcessing.this.instrumentedType.getPermittedSubtypes()) {
                                this.permittedSubclasses.add(typeDescription3.getInternalName());
                            }
                            return;
                        }
                        this.permittedSubclasses = null;
                    }

                    @Override // net.bytebuddy.jar.asm.ClassVisitor
                    public void visit(int classFileVersionNumber, int modifiers, String internalName, String genericSignature, String superClassInternalName, String[] interfaceTypeInternalName) {
                        String str;
                        ClassFileVersion classFileVersion = ClassFileVersion.ofMinorMajor(classFileVersionNumber);
                        this.methodPool = WithFullProcessing.this.methodRegistry.compile(WithFullProcessing.this.implementationTargetFactory, classFileVersion);
                        this.initializationHandler = new InitializationHandler.Creating(WithFullProcessing.this.instrumentedType, this.methodPool, WithFullProcessing.this.annotationValueFilterFactory);
                        this.implementationContext = WithFullProcessing.this.implementationContextFactory.make(WithFullProcessing.this.instrumentedType, WithFullProcessing.this.auxiliaryTypeNamingStrategy, this.typeInitializer, classFileVersion, WithFullProcessing.this.classFileVersion);
                        this.retainDeprecationModifiers = classFileVersion.isLessThan(ClassFileVersion.JAVA_V5);
                        this.contextRegistry.setImplementationContext(this.implementationContext);
                        this.f3066cv = WithFullProcessing.this.asmVisitorWrapper.wrap(WithFullProcessing.this.instrumentedType, this.f3066cv, this.implementationContext, WithFullProcessing.this.typePool, WithFullProcessing.this.fields, WithFullProcessing.this.methods, this.writerFlags, this.readerFlags);
                        ClassVisitor classVisitor = this.f3066cv;
                        int actualModifiers = WithFullProcessing.this.instrumentedType.getActualModifiers((modifiers & 32) != 0 && !WithFullProcessing.this.instrumentedType.isInterface()) | resolveDeprecationModifiers(modifiers) | (((modifiers & 16) == 0 || !WithFullProcessing.this.instrumentedType.isAnonymousType()) ? 0 : 16);
                        String internalName2 = WithFullProcessing.this.instrumentedType.getInternalName();
                        String genericSignature2 = TypeDescription.AbstractBase.RAW_TYPES ? genericSignature : WithFullProcessing.this.instrumentedType.getGenericSignature();
                        if (WithFullProcessing.this.instrumentedType.getSuperClass() == null) {
                            str = WithFullProcessing.this.instrumentedType.isInterface() ? TypeDescription.OBJECT.getInternalName() : Default.NO_REFERENCE;
                        } else {
                            str = WithFullProcessing.this.instrumentedType.getSuperClass().asErasure().getInternalName();
                        }
                        classVisitor.visit(classFileVersionNumber, actualModifiers, internalName2, genericSignature2, str, WithFullProcessing.this.instrumentedType.getInterfaces().asErasures().toInternalNames());
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    protected void onVisitNestHost(String nestHost) {
                        onNestHost();
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    protected void onNestHost() {
                        if (!WithFullProcessing.this.instrumentedType.isNestHost()) {
                            this.f3066cv.visitNestHost(WithFullProcessing.this.instrumentedType.getNestHost().getInternalName());
                        }
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    protected void onVisitPermittedSubclass(String permittedSubclass) {
                        if (this.permittedSubclasses != null && this.permittedSubclasses.remove(permittedSubclass)) {
                            this.f3066cv.visitPermittedSubclass(permittedSubclass);
                        }
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    protected void onVisitOuterClass(String owner, String name, String descriptor) {
                        try {
                            onOuterType();
                        } catch (Throwable th) {
                            this.f3066cv.visitOuterClass(owner, name, descriptor);
                        }
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    protected void onOuterType() {
                        MethodDescription.InDefinedShape enclosingMethod = WithFullProcessing.this.instrumentedType.getEnclosingMethod();
                        if (enclosingMethod != null) {
                            this.f3066cv.visitOuterClass(enclosingMethod.getDeclaringType().getInternalName(), enclosingMethod.getInternalName(), enclosingMethod.getDescriptor());
                        } else if (WithFullProcessing.this.instrumentedType.isLocalType() || WithFullProcessing.this.instrumentedType.isAnonymousType()) {
                            this.f3066cv.visitOuterClass(WithFullProcessing.this.instrumentedType.getEnclosingType().getInternalName(), Default.NO_REFERENCE, Default.NO_REFERENCE);
                        }
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    protected void onAfterAttributes() {
                        WithFullProcessing.this.typeAttributeAppender.apply(this.f3066cv, WithFullProcessing.this.instrumentedType, WithFullProcessing.this.annotationValueFilterFactory.mo135on(WithFullProcessing.this.instrumentedType));
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    protected AnnotationVisitor onVisitTypeAnnotation(int typeReference, TypePath typePath, String descriptor, boolean visible) {
                        if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                            return this.f3066cv.visitTypeAnnotation(typeReference, typePath, descriptor, visible);
                        }
                        return ForInlining.IGNORE_ANNOTATION;
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    protected AnnotationVisitor onVisitAnnotation(String descriptor, boolean visible) {
                        if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                            return this.f3066cv.visitAnnotation(descriptor, visible);
                        }
                        return ForInlining.IGNORE_ANNOTATION;
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    protected RecordComponentVisitor onVisitRecordComponent(String name, String descriptor, String genericSignature) {
                        RecordComponentDescription recordComponentDescription = this.declarableRecordComponents.remove(name);
                        if (recordComponentDescription != null) {
                            RecordComponentPool.Record record = WithFullProcessing.this.recordComponentPool.target(recordComponentDescription);
                            if (!record.isImplicit()) {
                                return redefine(record, genericSignature);
                            }
                        }
                        return this.f3066cv.visitRecordComponent(name, descriptor, genericSignature);
                    }

                    protected RecordComponentVisitor redefine(RecordComponentPool.Record record, String genericSignature) {
                        RecordComponentDescription recordComponentDescription = record.getRecordComponent();
                        RecordComponentVisitor recordComponentVisitor = this.f3066cv.visitRecordComponent(recordComponentDescription.getActualName(), recordComponentDescription.getDescriptor(), TypeDescription.AbstractBase.RAW_TYPES ? genericSignature : recordComponentDescription.getGenericSignature());
                        return recordComponentVisitor == null ? ForInlining.IGNORE_RECORD_COMPONENT : new AttributeObtainingRecordComponentVisitor(recordComponentVisitor, record);
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    protected FieldVisitor onVisitField(int modifiers, String internalName, String descriptor, String genericSignature, Object defaultValue) {
                        FieldDescription fieldDescription = this.declarableFields.remove(internalName + descriptor);
                        if (fieldDescription != null) {
                            FieldPool.Record record = WithFullProcessing.this.fieldPool.target(fieldDescription);
                            if (!record.isImplicit()) {
                                return redefine(record, defaultValue, modifiers, genericSignature);
                            }
                        }
                        return this.f3066cv.visitField(modifiers, internalName, descriptor, genericSignature, defaultValue);
                    }

                    protected FieldVisitor redefine(FieldPool.Record record, Object defaultValue, int modifiers, String genericSignature) {
                        FieldDescription instrumentedField = record.getField();
                        FieldVisitor fieldVisitor = this.f3066cv.visitField(instrumentedField.getActualModifiers() | resolveDeprecationModifiers(modifiers), instrumentedField.getInternalName(), instrumentedField.getDescriptor(), TypeDescription.AbstractBase.RAW_TYPES ? genericSignature : instrumentedField.getGenericSignature(), record.resolveDefault(defaultValue));
                        return fieldVisitor == null ? ForInlining.IGNORE_FIELD : new AttributeObtainingFieldVisitor(fieldVisitor, record);
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    protected MethodVisitor onVisitMethod(int modifiers, String internalName, String descriptor, String genericSignature, String[] exceptionName) {
                        if (internalName.equals("<clinit>")) {
                            MethodVisitor methodVisitor = this.f3066cv.visitMethod(modifiers, internalName, descriptor, genericSignature, exceptionName);
                            if (methodVisitor == null) {
                                return ForInlining.IGNORE_METHOD;
                            }
                            InitializationHandler of = InitializationHandler.Appending.m205of(this.implementationContext.isEnabled(), methodVisitor, WithFullProcessing.this.instrumentedType, this.methodPool, WithFullProcessing.this.annotationValueFilterFactory, (this.writerFlags & 2) == 0 && this.implementationContext.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V6), (this.readerFlags & 8) != 0);
                            this.initializationHandler = of;
                            return (MethodVisitor) of;
                        }
                        MethodDescription methodDescription = this.declarableMethods.remove(internalName + descriptor);
                        if (methodDescription == null) {
                            return this.f3066cv.visitMethod(modifiers, internalName, descriptor, genericSignature, exceptionName);
                        }
                        return redefine(methodDescription, (modifiers & 1024) != 0, modifiers, genericSignature);
                    }

                    protected MethodVisitor redefine(MethodDescription methodDescription, boolean abstractOrigin, int modifiers, String genericSignature) {
                        MethodPool.Record record = this.methodPool.target(methodDescription);
                        if (!record.getSort().isDefined()) {
                            return this.f3066cv.visitMethod(methodDescription.getActualModifiers() | resolveDeprecationModifiers(modifiers), methodDescription.getInternalName(), methodDescription.getDescriptor(), TypeDescription.AbstractBase.RAW_TYPES ? genericSignature : methodDescription.getGenericSignature(), methodDescription.getExceptionTypes().asErasures().toInternalNames());
                        }
                        MethodDescription implementedMethod = record.getMethod();
                        MethodVisitor methodVisitor = this.f3066cv.visitMethod(ModifierContributor.Resolver.m255of(Collections.singleton(record.getVisibility())).resolve(implementedMethod.getActualModifiers(record.getSort().isImplemented())) | resolveDeprecationModifiers(modifiers), implementedMethod.getInternalName(), implementedMethod.getDescriptor(), TypeDescription.AbstractBase.RAW_TYPES ? genericSignature : implementedMethod.getGenericSignature(), implementedMethod.getExceptionTypes().asErasures().toInternalNames());
                        if (methodVisitor == null) {
                            return ForInlining.IGNORE_METHOD;
                        }
                        if (abstractOrigin) {
                            return new AttributeObtainingMethodVisitor(methodVisitor, record);
                        }
                        if (!methodDescription.isNative()) {
                            return new CodePreservingMethodVisitor(methodVisitor, record, WithFullProcessing.this.methodRebaseResolver.resolve(implementedMethod.asDefined()));
                        }
                        MethodRebaseResolver.Resolution resolution = WithFullProcessing.this.methodRebaseResolver.resolve(implementedMethod.asDefined());
                        if (resolution.isRebased()) {
                            MethodVisitor rebasedMethodVisitor = visitMethod(resolution.getResolvedMethod().getActualModifiers() | resolveDeprecationModifiers(modifiers), resolution.getResolvedMethod().getInternalName(), resolution.getResolvedMethod().getDescriptor(), TypeDescription.AbstractBase.RAW_TYPES ? genericSignature : implementedMethod.getGenericSignature(), resolution.getResolvedMethod().getExceptionTypes().asErasures().toInternalNames());
                            if (rebasedMethodVisitor != null) {
                                rebasedMethodVisitor.visitEnd();
                            }
                        }
                        return new AttributeObtainingMethodVisitor(methodVisitor, record);
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    protected void onVisitInnerClass(String internalName, String outerName, String innerName, int modifiers) {
                        String str;
                        String str2;
                        if (!internalName.equals(WithFullProcessing.this.instrumentedType.getInternalName())) {
                            TypeDescription declaredType = this.declaredTypes.remove(internalName);
                            if (declaredType == null) {
                                this.f3066cv.visitInnerClass(internalName, outerName, innerName, modifiers);
                                return;
                            }
                            ClassVisitor classVisitor = this.f3066cv;
                            if (declaredType.isMemberType() || (outerName != null && innerName == null && declaredType.isAnonymousType())) {
                                str = WithFullProcessing.this.instrumentedType.getInternalName();
                            } else {
                                str = Default.NO_REFERENCE;
                            }
                            if (declaredType.isAnonymousType()) {
                                str2 = Default.NO_REFERENCE;
                            } else {
                                str2 = declaredType.getSimpleName();
                            }
                            classVisitor.visitInnerClass(internalName, str, str2, declaredType.getModifiers());
                        }
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    protected void onVisitNestMember(String nestMember) {
                        if (WithFullProcessing.this.instrumentedType.isNestHost() && this.nestMembers.remove(nestMember)) {
                            this.f3066cv.visitNestMember(nestMember);
                        }
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    protected void onVisitEnd() {
                        String str;
                        String str2;
                        for (String nestMember : this.nestMembers) {
                            this.f3066cv.visitNestMember(nestMember);
                        }
                        if (this.permittedSubclasses != null) {
                            for (String permittedSubclass : this.permittedSubclasses) {
                                this.f3066cv.visitPermittedSubclass(permittedSubclass);
                            }
                        }
                        TypeDescription declaringType = WithFullProcessing.this.instrumentedType.getDeclaringType();
                        if (declaringType != null) {
                            this.f3066cv.visitInnerClass(WithFullProcessing.this.instrumentedType.getInternalName(), declaringType.getInternalName(), WithFullProcessing.this.instrumentedType.getSimpleName(), WithFullProcessing.this.instrumentedType.getModifiers());
                        } else if (WithFullProcessing.this.instrumentedType.isLocalType()) {
                            this.f3066cv.visitInnerClass(WithFullProcessing.this.instrumentedType.getInternalName(), Default.NO_REFERENCE, WithFullProcessing.this.instrumentedType.getSimpleName(), WithFullProcessing.this.instrumentedType.getModifiers());
                        } else if (WithFullProcessing.this.instrumentedType.isAnonymousType()) {
                            this.f3066cv.visitInnerClass(WithFullProcessing.this.instrumentedType.getInternalName(), Default.NO_REFERENCE, Default.NO_REFERENCE, WithFullProcessing.this.instrumentedType.getModifiers());
                        }
                        for (TypeDescription typeDescription : this.declaredTypes.values()) {
                            ClassVisitor classVisitor = this.f3066cv;
                            String internalName = typeDescription.getInternalName();
                            if (typeDescription.isMemberType()) {
                                str = WithFullProcessing.this.instrumentedType.getInternalName();
                            } else {
                                str = Default.NO_REFERENCE;
                            }
                            if (typeDescription.isAnonymousType()) {
                                str2 = Default.NO_REFERENCE;
                            } else {
                                str2 = typeDescription.getSimpleName();
                            }
                            classVisitor.visitInnerClass(internalName, str, str2, typeDescription.getModifiers());
                        }
                        for (RecordComponentDescription recordComponent : this.declarableRecordComponents.values()) {
                            WithFullProcessing.this.recordComponentPool.target(recordComponent).apply(this.f3066cv, WithFullProcessing.this.annotationValueFilterFactory);
                        }
                        for (FieldDescription fieldDescription : this.declarableFields.values()) {
                            WithFullProcessing.this.fieldPool.target(fieldDescription).apply(this.f3066cv, WithFullProcessing.this.annotationValueFilterFactory);
                        }
                        for (MethodDescription methodDescription : this.declarableMethods.values()) {
                            this.methodPool.target(methodDescription).apply(this.f3066cv, this.implementationContext, WithFullProcessing.this.annotationValueFilterFactory);
                        }
                        this.initializationHandler.complete(this.f3066cv, this.implementationContext);
                        this.f3066cv.visitEnd();
                    }

                    private int resolveDeprecationModifiers(int modifiers) {
                        return (!this.retainDeprecationModifiers || (modifiers & 131072) == 0) ? 0 : 131072;
                    }

                    /* access modifiers changed from: protected */
                    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithFullProcessing$RedefinitionClassVisitor$AttributeObtainingFieldVisitor.class */
                    public class AttributeObtainingFieldVisitor extends FieldVisitor {
                        private final FieldPool.Record record;

                        protected AttributeObtainingFieldVisitor(FieldVisitor fieldVisitor, FieldPool.Record record) {
                            super(OpenedClassReader.ASM_API, fieldVisitor);
                            this.record = record;
                        }

                        @Override // net.bytebuddy.jar.asm.FieldVisitor
                        public AnnotationVisitor visitTypeAnnotation(int typeReference, TypePath typePath, String descriptor, boolean visible) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                return visitTypeAnnotation(typeReference, typePath, descriptor, visible);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        @Override // net.bytebuddy.jar.asm.FieldVisitor
                        public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                return visitAnnotation(descriptor, visible);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        @Override // net.bytebuddy.jar.asm.FieldVisitor
                        public void visitEnd() {
                            this.record.apply(this.f3067fv, WithFullProcessing.this.annotationValueFilterFactory);
                            visitEnd();
                        }
                    }

                    /* access modifiers changed from: protected */
                    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithFullProcessing$RedefinitionClassVisitor$AttributeObtainingRecordComponentVisitor.class */
                    public class AttributeObtainingRecordComponentVisitor extends RecordComponentVisitor {
                        private final RecordComponentPool.Record record;

                        protected AttributeObtainingRecordComponentVisitor(RecordComponentVisitor recordComponentVisitor, RecordComponentPool.Record record) {
                            super(OpenedClassReader.ASM_API, recordComponentVisitor);
                            this.record = record;
                        }

                        @Override // net.bytebuddy.jar.asm.RecordComponentVisitor
                        public AnnotationVisitor visitTypeAnnotation(int typeReference, TypePath typePath, String descriptor, boolean visible) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                return visitTypeAnnotation(typeReference, typePath, descriptor, visible);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        @Override // net.bytebuddy.jar.asm.RecordComponentVisitor
                        public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                return visitAnnotation(descriptor, visible);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        @Override // net.bytebuddy.jar.asm.RecordComponentVisitor
                        public void visitEnd() {
                            this.record.apply(getDelegate(), WithFullProcessing.this.annotationValueFilterFactory);
                            visitEnd();
                        }
                    }

                    /* access modifiers changed from: protected */
                    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithFullProcessing$RedefinitionClassVisitor$CodePreservingMethodVisitor.class */
                    public class CodePreservingMethodVisitor extends MethodVisitor {
                        private final MethodVisitor actualMethodVisitor;
                        private final MethodPool.Record record;
                        private final MethodRebaseResolver.Resolution resolution;

                        protected CodePreservingMethodVisitor(MethodVisitor actualMethodVisitor, MethodPool.Record record, MethodRebaseResolver.Resolution resolution) {
                            super(OpenedClassReader.ASM_API, actualMethodVisitor);
                            this.actualMethodVisitor = actualMethodVisitor;
                            this.record = record;
                            this.resolution = resolution;
                            record.applyHead(actualMethodVisitor);
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public AnnotationVisitor visitAnnotationDefault() {
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public AnnotationVisitor visitTypeAnnotation(int typeReference, TypePath typePath, String descriptor, boolean visible) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                return visitTypeAnnotation(typeReference, typePath, descriptor, visible);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                return visitAnnotation(descriptor, visible);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitAnnotableParameterCount(int count, boolean visible) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                visitAnnotableParameterCount(count, visible);
                            }
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public AnnotationVisitor visitParameterAnnotation(int index, String descriptor, boolean visible) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                return visitParameterAnnotation(index, descriptor, visible);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitCode() {
                            MethodVisitor methodVisitor;
                            this.record.applyBody(this.actualMethodVisitor, RedefinitionClassVisitor.this.implementationContext, WithFullProcessing.this.annotationValueFilterFactory);
                            this.actualMethodVisitor.visitEnd();
                            if (this.resolution.isRebased()) {
                                methodVisitor = RedefinitionClassVisitor.this.f3066cv.visitMethod(this.resolution.getResolvedMethod().getActualModifiers(), this.resolution.getResolvedMethod().getInternalName(), this.resolution.getResolvedMethod().getDescriptor(), this.resolution.getResolvedMethod().getGenericSignature(), this.resolution.getResolvedMethod().getExceptionTypes().asErasures().toInternalNames());
                            } else {
                                methodVisitor = ForInlining.IGNORE_METHOD;
                            }
                            this.f3068mv = methodVisitor;
                            visitCode();
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitMaxs(int stackSize, int localVariableLength) {
                            visitMaxs(stackSize, Math.max(localVariableLength, this.resolution.getResolvedMethod().getStackSize()));
                        }
                    }

                    /* access modifiers changed from: protected */
                    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithFullProcessing$RedefinitionClassVisitor$AttributeObtainingMethodVisitor.class */
                    public class AttributeObtainingMethodVisitor extends MethodVisitor {
                        private final MethodVisitor actualMethodVisitor;
                        private final MethodPool.Record record;

                        protected AttributeObtainingMethodVisitor(MethodVisitor actualMethodVisitor, MethodPool.Record record) {
                            super(OpenedClassReader.ASM_API, actualMethodVisitor);
                            this.actualMethodVisitor = actualMethodVisitor;
                            this.record = record;
                            record.applyHead(actualMethodVisitor);
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public AnnotationVisitor visitAnnotationDefault() {
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public AnnotationVisitor visitTypeAnnotation(int typeReference, TypePath typePath, String descriptor, boolean visible) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                return visitTypeAnnotation(typeReference, typePath, descriptor, visible);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                return visitAnnotation(descriptor, visible);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitAnnotableParameterCount(int count, boolean visible) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                visitAnnotableParameterCount(count, visible);
                            }
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public AnnotationVisitor visitParameterAnnotation(int index, String descriptor, boolean visible) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                return visitParameterAnnotation(index, descriptor, visible);
                            }
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitCode() {
                            this.f3068mv = ForInlining.IGNORE_METHOD;
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitEnd() {
                            this.record.applyBody(this.actualMethodVisitor, RedefinitionClassVisitor.this.implementationContext, WithFullProcessing.this.annotationValueFilterFactory);
                            this.actualMethodVisitor.visitEnd();
                        }
                    }
                }
            }

            /* access modifiers changed from: protected */
            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithDecorationOnly.class */
            public static class WithDecorationOnly<V> extends ForInlining<V> {
                protected WithDecorationOnly(TypeDescription instrumentedType, ClassFileVersion classFileVersion, List<? extends DynamicType> auxiliaryTypes, MethodList<?> methods, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, AnnotationValueFilter.Factory annotationValueFilterFactory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy, Implementation.Context.Factory implementationContextFactory, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool, ClassFileLocator classFileLocator) {
                    super(instrumentedType, classFileVersion, FieldPool.Disabled.INSTANCE, RecordComponentPool.Disabled.INSTANCE, auxiliaryTypes, new LazyFieldList(instrumentedType), methods, new MethodList.Empty(), new RecordComponentList.Empty(), LoadedTypeInitializer.NoOp.INSTANCE, TypeInitializer.None.INSTANCE, typeAttributeAppender, asmVisitorWrapper, annotationValueFilterFactory, annotationRetention, auxiliaryTypeNamingStrategy, implementationContextFactory, typeValidation, classWriterStrategy, typePool, instrumentedType, classFileLocator);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining
                protected ClassVisitor writeTo(ClassVisitor classVisitor, TypeInitializer typeInitializer, ContextRegistry contextRegistry, int writerFlags, int readerFlags) {
                    if (!typeInitializer.isDefined()) {
                        return new DecorationClassVisitor(classVisitor, contextRegistry, writerFlags, readerFlags);
                    }
                    throw new UnsupportedOperationException("Cannot apply a type initializer for a decoration");
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithDecorationOnly$LazyFieldList.class */
                protected static class LazyFieldList extends FieldList.AbstractBase<FieldDescription.InDefinedShape> {
                    private final TypeDescription instrumentedType;

                    protected LazyFieldList(TypeDescription instrumentedType) {
                        this.instrumentedType = instrumentedType;
                    }

                    @Override // java.util.AbstractList, java.util.List
                    public FieldDescription.InDefinedShape get(int index) {
                        return (FieldDescription.InDefinedShape) this.instrumentedType.getDeclaredFields().get(index);
                    }

                    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
                    public int size() {
                        return this.instrumentedType.getDeclaredFields().size();
                    }
                }

                @SuppressFBWarnings(value = {"UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR"}, justification = "Field access order is implied by ASM")
                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForInlining$WithDecorationOnly$DecorationClassVisitor.class */
                protected class DecorationClassVisitor extends MetadataAwareClassVisitor implements TypeInitializer.Drain {
                    private final ContextRegistry contextRegistry;
                    private final int writerFlags;
                    private final int readerFlags;
                    private Implementation.Context.ExtractableView implementationContext;

                    protected DecorationClassVisitor(ClassVisitor classVisitor, ContextRegistry contextRegistry, int writerFlags, int readerFlags) {
                        super(OpenedClassReader.ASM_API, classVisitor);
                        this.contextRegistry = contextRegistry;
                        this.writerFlags = writerFlags;
                        this.readerFlags = readerFlags;
                    }

                    @Override // net.bytebuddy.jar.asm.ClassVisitor
                    public void visit(int classFileVersionNumber, int modifiers, String internalName, String genericSignature, String superClassInternalName, String[] interfaceTypeInternalName) {
                        this.implementationContext = WithDecorationOnly.this.implementationContextFactory.make(WithDecorationOnly.this.instrumentedType, WithDecorationOnly.this.auxiliaryTypeNamingStrategy, WithDecorationOnly.this.typeInitializer, ClassFileVersion.ofMinorMajor(classFileVersionNumber), WithDecorationOnly.this.classFileVersion);
                        this.contextRegistry.setImplementationContext(this.implementationContext);
                        this.f3066cv = WithDecorationOnly.this.asmVisitorWrapper.wrap(WithDecorationOnly.this.instrumentedType, this.f3066cv, this.implementationContext, WithDecorationOnly.this.typePool, WithDecorationOnly.this.fields, WithDecorationOnly.this.methods, this.writerFlags, this.readerFlags);
                        this.f3066cv.visit(classFileVersionNumber, modifiers, internalName, genericSignature, superClassInternalName, interfaceTypeInternalName);
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    protected AnnotationVisitor onVisitTypeAnnotation(int typeReference, TypePath typePath, String descriptor, boolean visible) {
                        if (WithDecorationOnly.this.annotationRetention.isEnabled()) {
                            return this.f3066cv.visitTypeAnnotation(typeReference, typePath, descriptor, visible);
                        }
                        return ForInlining.IGNORE_ANNOTATION;
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    protected AnnotationVisitor onVisitAnnotation(String descriptor, boolean visible) {
                        if (WithDecorationOnly.this.annotationRetention.isEnabled()) {
                            return this.f3066cv.visitAnnotation(descriptor, visible);
                        }
                        return ForInlining.IGNORE_ANNOTATION;
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    protected void onAfterAttributes() {
                        WithDecorationOnly.this.typeAttributeAppender.apply(this.f3066cv, WithDecorationOnly.this.instrumentedType, WithDecorationOnly.this.annotationValueFilterFactory.mo135on(WithDecorationOnly.this.instrumentedType));
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    protected void onVisitEnd() {
                        this.implementationContext.drain(this, this.f3066cv, WithDecorationOnly.this.annotationValueFilterFactory);
                        this.f3066cv.visitEnd();
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeInitializer.Drain
                    public void apply(ClassVisitor classVisitor, TypeInitializer typeInitializer, Implementation.Context implementationContext) {
                    }
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ForCreation.class */
        public static class ForCreation<U> extends Default<U> {
            private final MethodPool methodPool;

            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default
            public boolean equals(Object obj) {
                if (!equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.methodPool.equals(((ForCreation) obj).methodPool);
            }

            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default
            public int hashCode() {
                return (hashCode() * 31) + this.methodPool.hashCode();
            }

            protected ForCreation(TypeDescription instrumentedType, ClassFileVersion classFileVersion, FieldPool fieldPool, MethodPool methodPool, RecordComponentPool recordComponentPool, List<? extends DynamicType> auxiliaryTypes, FieldList<FieldDescription.InDefinedShape> fields, MethodList<?> methods, MethodList<?> instrumentedMethods, RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponents, LoadedTypeInitializer loadedTypeInitializer, TypeInitializer typeInitializer, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, AnnotationValueFilter.Factory annotationValueFilterFactory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy, Implementation.Context.Factory implementationContextFactory, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool) {
                super(instrumentedType, classFileVersion, fieldPool, recordComponentPool, auxiliaryTypes, fields, methods, instrumentedMethods, recordComponents, loadedTypeInitializer, typeInitializer, typeAttributeAppender, asmVisitorWrapper, annotationValueFilterFactory, annotationRetention, auxiliaryTypeNamingStrategy, implementationContextFactory, typeValidation, classWriterStrategy, typePool);
                this.methodPool = methodPool;
            }

            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default
            protected Default<U>.UnresolvedType create(TypeInitializer typeInitializer, ClassDumpAction.Dispatcher dispatcher) {
                String str;
                String str2;
                int writerFlags = this.asmVisitorWrapper.mergeWriter(0);
                ClassWriter classWriter = this.classWriterStrategy.resolve(writerFlags, this.typePool);
                Implementation.Context.ExtractableView implementationContext = this.implementationContextFactory.make(this.instrumentedType, this.auxiliaryTypeNamingStrategy, typeInitializer, this.classFileVersion, this.classFileVersion);
                ClassVisitor classVisitor = this.asmVisitorWrapper.wrap(this.instrumentedType, ValidatingClassVisitor.m204of(classWriter, this.typeValidation), implementationContext, this.typePool, this.fields, this.methods, writerFlags, this.asmVisitorWrapper.mergeReader(0));
                classVisitor.visit(this.classFileVersion.getMinorMajorVersion(), this.instrumentedType.getActualModifiers(!this.instrumentedType.isInterface()), this.instrumentedType.getInternalName(), this.instrumentedType.getGenericSignature(), (this.instrumentedType.getSuperClass() == null ? TypeDescription.OBJECT : this.instrumentedType.getSuperClass().asErasure()).getInternalName(), this.instrumentedType.getInterfaces().asErasures().toInternalNames());
                if (!this.instrumentedType.isNestHost()) {
                    classVisitor.visitNestHost(this.instrumentedType.getNestHost().getInternalName());
                }
                MethodDescription.InDefinedShape enclosingMethod = this.instrumentedType.getEnclosingMethod();
                if (enclosingMethod != null) {
                    classVisitor.visitOuterClass(enclosingMethod.getDeclaringType().getInternalName(), enclosingMethod.getInternalName(), enclosingMethod.getDescriptor());
                } else if (this.instrumentedType.isLocalType() || this.instrumentedType.isAnonymousType()) {
                    classVisitor.visitOuterClass(this.instrumentedType.getEnclosingType().getInternalName(), Default.NO_REFERENCE, Default.NO_REFERENCE);
                }
                this.typeAttributeAppender.apply(classVisitor, this.instrumentedType, this.annotationValueFilterFactory.mo135on(this.instrumentedType));
                if (this.instrumentedType.isNestHost()) {
                    for (TypeDescription typeDescription : this.instrumentedType.getNestMembers().filter(ElementMatchers.not(ElementMatchers.m104is(this.instrumentedType)))) {
                        classVisitor.visitNestMember(typeDescription.getInternalName());
                    }
                }
                for (TypeDescription typeDescription2 : this.instrumentedType.getPermittedSubtypes()) {
                    classVisitor.visitPermittedSubclass(typeDescription2.getInternalName());
                }
                TypeDescription declaringType = this.instrumentedType.getDeclaringType();
                if (declaringType != null) {
                    classVisitor.visitInnerClass(this.instrumentedType.getInternalName(), declaringType.getInternalName(), this.instrumentedType.getSimpleName(), this.instrumentedType.getModifiers());
                } else if (this.instrumentedType.isLocalType()) {
                    classVisitor.visitInnerClass(this.instrumentedType.getInternalName(), Default.NO_REFERENCE, this.instrumentedType.getSimpleName(), this.instrumentedType.getModifiers());
                } else if (this.instrumentedType.isAnonymousType()) {
                    classVisitor.visitInnerClass(this.instrumentedType.getInternalName(), Default.NO_REFERENCE, Default.NO_REFERENCE, this.instrumentedType.getModifiers());
                }
                for (TypeDescription typeDescription3 : this.instrumentedType.getDeclaredTypes()) {
                    String internalName = typeDescription3.getInternalName();
                    if (typeDescription3.isMemberType()) {
                        str = this.instrumentedType.getInternalName();
                    } else {
                        str = Default.NO_REFERENCE;
                    }
                    if (typeDescription3.isAnonymousType()) {
                        str2 = Default.NO_REFERENCE;
                    } else {
                        str2 = typeDescription3.getSimpleName();
                    }
                    classVisitor.visitInnerClass(internalName, str, str2, typeDescription3.getModifiers());
                }
                for (RecordComponentDescription recordComponentDescription : this.recordComponents) {
                    this.recordComponentPool.target(recordComponentDescription).apply(classVisitor, this.annotationValueFilterFactory);
                }
                for (FieldDescription fieldDescription : this.fields) {
                    this.fieldPool.target(fieldDescription).apply(classVisitor, this.annotationValueFilterFactory);
                }
                for (MethodDescription methodDescription : this.instrumentedMethods) {
                    this.methodPool.target(methodDescription).apply(classVisitor, implementationContext, this.annotationValueFilterFactory);
                }
                implementationContext.drain(new TypeInitializer.Drain.Default(this.instrumentedType, this.methodPool, this.annotationValueFilterFactory), classVisitor, this.annotationValueFilterFactory);
                classVisitor.visitEnd();
                return new UnresolvedType(classWriter.toByteArray(), implementationContext.getAuxiliaryTypes());
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ClassDumpAction.class */
        protected static class ClassDumpAction implements PrivilegedExceptionAction<Void> {
            private static final Void NOTHING = null;
            private final String target;
            private final TypeDescription instrumentedType;
            private final boolean original;
            private final long suffix;
            private final byte[] binaryRepresentation;

            @Override // java.lang.Object
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.original == ((ClassDumpAction) obj).original && this.suffix == ((ClassDumpAction) obj).suffix && this.target.equals(((ClassDumpAction) obj).target) && this.instrumentedType.equals(((ClassDumpAction) obj).instrumentedType) && Arrays.equals(this.binaryRepresentation, ((ClassDumpAction) obj).binaryRepresentation);
            }

            @Override // java.lang.Object
            public int hashCode() {
                int hashCode = ((((((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + this.instrumentedType.hashCode()) * 31) + (this.original ? 1 : 0)) * 31;
                return ((hashCode + ((int) (hashCode ^ (this.suffix >>> 32)))) * 31) + Arrays.hashCode(this.binaryRepresentation);
            }

            protected ClassDumpAction(String target, TypeDescription instrumentedType, boolean original, long suffix, byte[] binaryRepresentation) {
                this.target = target;
                this.instrumentedType = instrumentedType;
                this.original = original;
                this.suffix = suffix;
                this.binaryRepresentation = binaryRepresentation;
            }

            @Override // java.security.PrivilegedExceptionAction
            public Void run() throws Exception {
                OutputStream outputStream = new FileOutputStream(new File(this.target, this.instrumentedType.getName() + (this.original ? "-original." : Mapper.IGNORED_FIELDNAME) + this.suffix + ".class"));
                try {
                    outputStream.write(this.binaryRepresentation);
                    return NOTHING;
                } finally {
                    outputStream.close();
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ClassDumpAction$Dispatcher.class */
            protected interface Dispatcher {
                void dump(TypeDescription typeDescription, boolean z, byte[] bArr);

                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ClassDumpAction$Dispatcher$Disabled.class */
                public enum Disabled implements Dispatcher {
                    INSTANCE;

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ClassDumpAction.Dispatcher
                    public void dump(TypeDescription instrumentedType, boolean original, byte[] binaryRepresentation) {
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeWriter$Default$ClassDumpAction$Dispatcher$Enabled.class */
                public static class Enabled implements Dispatcher {
                    private final String folder;
                    private final long timestamp;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.timestamp == ((Enabled) obj).timestamp && this.folder.equals(((Enabled) obj).folder);
                    }

                    public int hashCode() {
                        int hashCode = ((getClass().hashCode() * 31) + this.folder.hashCode()) * 31;
                        return hashCode + ((int) (hashCode ^ (this.timestamp >>> 32)));
                    }

                    protected Enabled(String folder, long timestamp) {
                        this.folder = folder;
                        this.timestamp = timestamp;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ClassDumpAction.Dispatcher
                    public void dump(TypeDescription instrumentedType, boolean original, byte[] binaryRepresentation) {
                        try {
                            AccessController.doPrivileged(new ClassDumpAction(this.folder, instrumentedType, original, this.timestamp, binaryRepresentation));
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
