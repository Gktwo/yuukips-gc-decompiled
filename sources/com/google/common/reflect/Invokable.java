package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

@Beta
/* loaded from: grasscutter.jar:com/google/common/reflect/Invokable.class */
public abstract class Invokable<T, R> extends Element implements GenericDeclaration {
    public abstract boolean isOverridable();

    public abstract boolean isVarArgs();

    abstract Object invokeInternal(Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException;

    abstract Type[] getGenericParameterTypes();

    abstract AnnotatedType[] getAnnotatedParameterTypes();

    abstract Type[] getGenericExceptionTypes();

    abstract Annotation[][] getParameterAnnotations();

    abstract Type getGenericReturnType();

    public abstract AnnotatedType getAnnotatedReturnType();

    @Override // com.google.common.reflect.Element, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return toString();
    }

    @Override // com.google.common.reflect.Element, java.lang.Object
    public /* bridge */ /* synthetic */ int hashCode() {
        return hashCode();
    }

    @Override // com.google.common.reflect.Element, java.lang.Object
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return equals(obj);
    }

    <M extends AccessibleObject & Member> Invokable(M member) {
        super(member);
    }

    public static Invokable<?, Object> from(Method method) {
        return new MethodInvokable(method);
    }

    public static <T> Invokable<T, T> from(Constructor<T> constructor) {
        return new ConstructorInvokable(constructor);
    }

    @CanIgnoreReturnValue
    public final R invoke(T receiver, Object... args) throws InvocationTargetException, IllegalAccessException {
        return (R) invokeInternal(receiver, (Object[]) Preconditions.checkNotNull(args));
    }

    public final TypeToken<? extends R> getReturnType() {
        return (TypeToken<? extends R>) TypeToken.m1298of(getGenericReturnType());
    }

    public final ImmutableList<Parameter> getParameters() {
        Type[] parameterTypes = getGenericParameterTypes();
        Annotation[][] annotations = getParameterAnnotations();
        AnnotatedType[] annotatedTypes = getAnnotatedParameterTypes();
        ImmutableList.Builder<Parameter> builder = ImmutableList.builder();
        for (int i = 0; i < parameterTypes.length; i++) {
            builder.add((ImmutableList.Builder<Parameter>) new Parameter(this, i, TypeToken.m1298of(parameterTypes[i]), annotations[i], annotatedTypes[i]));
        }
        return builder.build();
    }

    public final ImmutableList<TypeToken<? extends Throwable>> getExceptionTypes() {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type type : getGenericExceptionTypes()) {
            builder.add((ImmutableList.Builder) TypeToken.m1298of(type));
        }
        return builder.build();
    }

    public final <R1 extends R> Invokable<T, R1> returning(Class<R1> returnType) {
        return returning(TypeToken.m1299of((Class) returnType));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.common.reflect.Invokable<T, R> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R1 extends R> Invokable<T, R1> returning(TypeToken<R1> returnType) {
        if (returnType.isSupertypeOf(getReturnType())) {
            return this;
        }
        throw new IllegalArgumentException("Invokable is known to return " + getReturnType() + ", not " + returnType);
    }

    @Override // com.google.common.reflect.Element, java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) getDeclaringClass();
    }

    @Override // com.google.common.reflect.Element
    public TypeToken<T> getOwnerType() {
        return TypeToken.m1299of((Class) getDeclaringClass());
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/reflect/Invokable$MethodInvokable.class */
    public static class MethodInvokable<T> extends Invokable<T, Object> {
        final Method method;

        /* access modifiers changed from: package-private */
        public MethodInvokable(Method method) {
            super(method);
            this.method = method;
        }

        @Override // com.google.common.reflect.Invokable
        final Object invokeInternal(Object receiver, Object[] args) throws InvocationTargetException, IllegalAccessException {
            return this.method.invoke(receiver, args);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.Invokable
        public Type getGenericReturnType() {
            return this.method.getGenericReturnType();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.Invokable
        public Type[] getGenericParameterTypes() {
            return this.method.getGenericParameterTypes();
        }

        @Override // com.google.common.reflect.Invokable
        AnnotatedType[] getAnnotatedParameterTypes() {
            return this.method.getAnnotatedParameterTypes();
        }

        @Override // com.google.common.reflect.Invokable
        public AnnotatedType getAnnotatedReturnType() {
            return this.method.getAnnotatedReturnType();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.Invokable
        public Type[] getGenericExceptionTypes() {
            return this.method.getGenericExceptionTypes();
        }

        @Override // com.google.common.reflect.Invokable
        final Annotation[][] getParameterAnnotations() {
            return this.method.getParameterAnnotations();
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            return this.method.getTypeParameters();
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isOverridable() {
            return !isFinal() && !isPrivate() && !isStatic() && !Modifier.isFinal(getDeclaringClass().getModifiers());
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isVarArgs() {
            return this.method.isVarArgs();
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/reflect/Invokable$ConstructorInvokable.class */
    public static class ConstructorInvokable<T> extends Invokable<T, T> {
        final Constructor<?> constructor;

        /* access modifiers changed from: package-private */
        public ConstructorInvokable(Constructor<?> constructor) {
            super(constructor);
            this.constructor = constructor;
        }

        @Override // com.google.common.reflect.Invokable
        final Object invokeInternal(Object receiver, Object[] args) throws InvocationTargetException, IllegalAccessException {
            try {
                return this.constructor.newInstance(args);
            } catch (InstantiationException e) {
                throw new RuntimeException(this.constructor + " failed.", e);
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.Invokable
        public Type getGenericReturnType() {
            Class<?> declaringClass = getDeclaringClass();
            TypeVariable<?>[] typeParams = declaringClass.getTypeParameters();
            if (typeParams.length > 0) {
                return Types.newParameterizedType(declaringClass, typeParams);
            }
            return declaringClass;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.Invokable
        public Type[] getGenericParameterTypes() {
            Type[] types = this.constructor.getGenericParameterTypes();
            if (types.length > 0 && mayNeedHiddenThis()) {
                Class<?>[] rawParamTypes = this.constructor.getParameterTypes();
                if (types.length == rawParamTypes.length && rawParamTypes[0] == getDeclaringClass().getEnclosingClass()) {
                    return (Type[]) Arrays.copyOfRange(types, 1, types.length);
                }
            }
            return types;
        }

        @Override // com.google.common.reflect.Invokable
        AnnotatedType[] getAnnotatedParameterTypes() {
            return this.constructor.getAnnotatedParameterTypes();
        }

        @Override // com.google.common.reflect.Invokable
        public AnnotatedType getAnnotatedReturnType() {
            return this.constructor.getAnnotatedReturnType();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.reflect.Invokable
        public Type[] getGenericExceptionTypes() {
            return this.constructor.getGenericExceptionTypes();
        }

        @Override // com.google.common.reflect.Invokable
        final Annotation[][] getParameterAnnotations() {
            return this.constructor.getParameterAnnotations();
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            TypeVariable<?>[] declaredByClass = getDeclaringClass().getTypeParameters();
            TypeVariable<?>[] declaredByConstructor = this.constructor.getTypeParameters();
            TypeVariable<?>[] result = new TypeVariable[declaredByClass.length + declaredByConstructor.length];
            System.arraycopy(declaredByClass, 0, result, 0, declaredByClass.length);
            System.arraycopy(declaredByConstructor, 0, result, declaredByClass.length, declaredByConstructor.length);
            return result;
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isOverridable() {
            return false;
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isVarArgs() {
            return this.constructor.isVarArgs();
        }

        private boolean mayNeedHiddenThis() {
            Class<?> declaringClass = this.constructor.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            Method enclosingMethod = declaringClass.getEnclosingMethod();
            return enclosingMethod != null ? !Modifier.isStatic(enclosingMethod.getModifiers()) : declaringClass.getEnclosingClass() != null && !Modifier.isStatic(declaringClass.getModifiers());
        }
    }
}
