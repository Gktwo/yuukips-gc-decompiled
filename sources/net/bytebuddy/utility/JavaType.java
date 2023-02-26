package net.bytebuddy.utility;

import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;

/* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaType.class */
public enum JavaType {
    CONSTABLE("java.lang.constant.Constable", 1537, TypeDescription.UNDEFINED, new TypeDefinition[0]),
    TYPE_DESCRIPTOR("java.lang.invoke.TypeDescriptor", 1537, TypeDescription.UNDEFINED, new TypeDefinition[0]),
    TYPE_DESCRIPTOR_OF_FIELD("java.lang.invoke.TypeDescriptor$OfField", 1537, TypeDescription.UNDEFINED, TYPE_DESCRIPTOR.getTypeStub()),
    TYPE_DESCRIPTOR_OF_METHOD("java.lang.invoke.TypeDescriptor$OfMethod", 1537, TypeDescription.UNDEFINED, TYPE_DESCRIPTOR.getTypeStub()),
    CONSTANT_DESCRIPTION("java.lang.constant.ConstantDesc", 1537, TypeDescription.UNDEFINED, new TypeDefinition[0]),
    DYNAMIC_CONSTANT_DESCRIPTION("java.lang.constant.DynamicConstantDesc", 1025, TypeDescription.OBJECT, CONSTANT_DESCRIPTION.getTypeStub()),
    CLASS_DESCRIPTION("java.lang.constant.ClassDesc", 1537, TypeDescription.UNDEFINED, CONSTANT_DESCRIPTION.getTypeStub(), TYPE_DESCRIPTOR_OF_FIELD.getTypeStub()),
    METHOD_TYPE_DESCRIPTION("java.lang.constant.MethodTypeDesc", 1537, TypeDescription.UNDEFINED, CONSTANT_DESCRIPTION.getTypeStub(), TYPE_DESCRIPTOR_OF_METHOD.getTypeStub()),
    METHOD_HANDLE_DESCRIPTION("java.lang.constant.MethodHandleDesc", 1537, TypeDescription.UNDEFINED, CONSTANT_DESCRIPTION.getTypeStub()),
    DIRECT_METHOD_HANDLE_DESCRIPTION("java.lang.constant.DirectMethodHandleDesc", 1537, TypeDescription.UNDEFINED, METHOD_HANDLE_DESCRIPTION.getTypeStub()),
    METHOD_HANDLE("java.lang.invoke.MethodHandle", 1025, TypeDescription.OBJECT, CONSTABLE.getTypeStub()),
    METHOD_HANDLES("java.lang.invoke.MethodHandles", 1, Object.class, new Type[0]),
    METHOD_TYPE("java.lang.invoke.MethodType", 17, TypeDescription.OBJECT, CONSTABLE.getTypeStub(), TYPE_DESCRIPTOR_OF_METHOD.getTypeStub(), TypeDescription.ForLoadedType.m247of(Serializable.class)),
    METHOD_HANDLES_LOOKUP("java.lang.invoke.MethodHandles$Lookup", 25, Object.class, new Type[0]),
    CALL_SITE("java.lang.invoke.CallSite", 1025, Object.class, new Type[0]),
    VAR_HANDLE("java.lang.invoke.VarHandle", 1025, TypeDescription.Generic.OBJECT, CONSTABLE.getTypeStub()),
    PARAMETER("java.lang.reflect.Parameter", 17, Object.class, AnnotatedElement.class),
    EXECUTABLE("java.lang.reflect.Executable", 1025, AccessibleObject.class, Member.class, GenericDeclaration.class),
    MODULE("java.lang.Module", 17, Object.class, AnnotatedElement.class),
    CONSTANT_BOOTSTRAPS("java.lang.invoke.ConstantBootstraps", 17, Object.class, new Type[0]),
    RECORD("java.lang.Record", 1025, Object.class, new Type[0]),
    OBJECT_METHODS("java.lang.runtime.ObjectMethods", 1, Object.class, new Type[0]),
    ACCESS_CONTROL_CONTEXT("java.security.AccessControlContext", 17, TypeDescription.UNDEFINED, new TypeDefinition[0]);
    
    private final TypeDescription typeDescription;
    private transient /* synthetic */ Class loaded;
    private transient /* synthetic */ boolean available;

    JavaType(String typeName, int modifiers, Type superClass, Type... anInterface) {
        this(typeName, modifiers, superClass == null ? TypeDescription.Generic.UNDEFINED : TypeDefinition.Sort.describe(superClass), new TypeList.Generic.ForLoadedTypes(anInterface));
    }

    JavaType(String typeName, int modifiers, TypeDefinition superClass, TypeDefinition... anInterface) {
        this(typeName, modifiers, superClass == null ? TypeDescription.Generic.UNDEFINED : superClass.asGenericType(), new TypeList.Generic.Explicit(anInterface));
    }

    JavaType(String typeName, int modifiers, TypeDescription.Generic superClass, TypeList.Generic interfaces) {
        this.typeDescription = new LatentTypeWithSimpleName(typeName, modifiers, superClass, interfaces);
    }

    public TypeDescription getTypeStub() {
        return this.typeDescription;
    }

    @CachedReturnPlugin.Enhance("loaded")
    public Class<?> load() throws ClassNotFoundException {
        Class<?> cls = this.loaded != null ? null : Class.forName(this.typeDescription.getName(), false, ClassLoadingStrategy.BOOTSTRAP_LOADER);
        if (cls == null) {
            cls = this.loaded;
        } else {
            this.loaded = cls;
        }
        return cls;
    }

    public TypeDescription loadAsDescription() throws ClassNotFoundException {
        return TypeDescription.ForLoadedType.m247of(load());
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0012 */
    /* JADX WARN: Type inference failed for: r0v9, types: [net.bytebuddy.utility.JavaType] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @net.bytebuddy.build.CachedReturnPlugin.Enhance("available")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isAvailable() {
        /*
            r4 = this;
            r0 = r4
            boolean r0 = r0.available
            goto L_0x0007
        L_0x0007:
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L_0x0010
            r0 = 0
            goto L_0x0020
        L_0x0010:
            r0 = r4
            r6 = r0
            r0 = r6
            java.lang.Class r0 = r0.load()     // Catch: ClassNotFoundException -> 0x001b
            r0 = 1
            goto L_0x0020
        L_0x001b:
            r7 = move-exception
            r1 = 0
            goto L_0x0020
        L_0x0020:
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L_0x002f
            r0 = 1
            r1 = r4
            r2 = r1; r1 = r0; r0 = r2; 
            r0.available = r1
            goto L_0x0031
        L_0x002f:
            r0 = 1
            r6 = r0
        L_0x0031:
            goto L_0x0034
        L_0x0034:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.utility.JavaType.isAvailable():boolean");
    }

    public boolean isInstance(Object instance) {
        if (!isAvailable()) {
            return false;
        }
        try {
            return load().isInstance(instance);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaType$LatentTypeWithSimpleName.class */
    protected static class LatentTypeWithSimpleName extends TypeDescription.Latent {
        protected LatentTypeWithSimpleName(String name, int modifiers, TypeDescription.Generic superClass, List<? extends TypeDescription.Generic> interfaces) {
            super(name, modifiers, superClass, interfaces);
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase.OfSimpleType, net.bytebuddy.description.type.TypeDescription
        public String getSimpleName() {
            String name = getName();
            int index = Math.max(name.lastIndexOf(36), name.lastIndexOf(46));
            return index == -1 ? name : name.substring(index + 1);
        }
    }
}
