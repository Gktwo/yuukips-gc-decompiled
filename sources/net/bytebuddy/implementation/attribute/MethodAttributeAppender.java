package net.bytebuddy.implementation.attribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.attribute.AnnotationAppender;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;

/* loaded from: grasscutter.jar:net/bytebuddy/implementation/attribute/MethodAttributeAppender.class */
public interface MethodAttributeAppender {
    void apply(MethodVisitor methodVisitor, MethodDescription methodDescription, AnnotationValueFilter annotationValueFilter);

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/attribute/MethodAttributeAppender$NoOp.class */
    public enum NoOp implements MethodAttributeAppender, Factory {
        INSTANCE;

        @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender.Factory
        public MethodAttributeAppender make(TypeDescription typeDescription) {
            return this;
        }

        @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender
        public void apply(MethodVisitor methodVisitor, MethodDescription methodDescription, AnnotationValueFilter annotationValueFilter) {
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/attribute/MethodAttributeAppender$Factory.class */
    public interface Factory {
        MethodAttributeAppender make(TypeDescription typeDescription);

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/attribute/MethodAttributeAppender$Factory$Compound.class */
        public static class Compound implements Factory {
            private final List<Factory> factories;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.factories.equals(((Compound) obj).factories);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.factories.hashCode();
            }

            public Compound(Factory... factory) {
                this(Arrays.asList(factory));
            }

            public Compound(List<? extends Factory> factories) {
                this.factories = new ArrayList();
                for (Factory factory : factories) {
                    if (factory instanceof Compound) {
                        this.factories.addAll(((Compound) factory).factories);
                    } else if (!(factory instanceof NoOp)) {
                        this.factories.add(factory);
                    }
                }
            }

            @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender.Factory
            public MethodAttributeAppender make(TypeDescription typeDescription) {
                List<MethodAttributeAppender> methodAttributeAppenders = new ArrayList<>(this.factories.size());
                for (Factory factory : this.factories) {
                    methodAttributeAppenders.add(factory.make(typeDescription));
                }
                return new Compound(methodAttributeAppenders);
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/attribute/MethodAttributeAppender$ForInstrumentedMethod.class */
    public enum ForInstrumentedMethod implements MethodAttributeAppender, Factory {
        EXCLUDING_RECEIVER {
            @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender.ForInstrumentedMethod
            protected AnnotationAppender appendReceiver(AnnotationAppender annotationAppender, AnnotationValueFilter annotationValueFilter, MethodDescription methodDescription) {
                return annotationAppender;
            }
        },
        INCLUDING_RECEIVER {
            @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender.ForInstrumentedMethod
            protected AnnotationAppender appendReceiver(AnnotationAppender annotationAppender, AnnotationValueFilter annotationValueFilter, MethodDescription methodDescription) {
                TypeDescription.Generic receiverType = methodDescription.getReceiverType();
                return receiverType == null ? annotationAppender : (AnnotationAppender) receiverType.accept(AnnotationAppender.ForTypeAnnotations.ofReceiverType(annotationAppender, annotationValueFilter));
            }
        };

        protected abstract AnnotationAppender appendReceiver(AnnotationAppender annotationAppender, AnnotationValueFilter annotationValueFilter, MethodDescription methodDescription);

        @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender.Factory
        public MethodAttributeAppender make(TypeDescription typeDescription) {
            return this;
        }

        @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender
        public void apply(MethodVisitor methodVisitor, MethodDescription methodDescription, AnnotationValueFilter annotationValueFilter) {
            AnnotationAppender annotationAppender = AnnotationAppender.ForTypeAnnotations.ofTypeVariable((AnnotationAppender) methodDescription.getReturnType().accept(AnnotationAppender.ForTypeAnnotations.ofMethodReturnType(new AnnotationAppender.Default(new AnnotationAppender.Target.OnMethod(methodVisitor)), annotationValueFilter)), annotationValueFilter, false, methodDescription.getTypeVariables());
            for (AnnotationDescription annotation : methodDescription.getDeclaredAnnotations().filter(ElementMatchers.not(ElementMatchers.annotationType(ElementMatchers.nameStartsWith("jdk.internal."))))) {
                annotationAppender = annotationAppender.append(annotation, annotationValueFilter);
            }
            Iterator it = methodDescription.getParameters().iterator();
            while (it.hasNext()) {
                ParameterDescription parameterDescription = (ParameterDescription) it.next();
                AnnotationAppender parameterAppender = (AnnotationAppender) parameterDescription.getType().accept(AnnotationAppender.ForTypeAnnotations.ofMethodParameterType(new AnnotationAppender.Default(new AnnotationAppender.Target.OnMethodParameter(methodVisitor, parameterDescription.getIndex())), annotationValueFilter, parameterDescription.getIndex()));
                for (AnnotationDescription annotation2 : parameterDescription.getDeclaredAnnotations()) {
                    parameterAppender = parameterAppender.append(annotation2, annotationValueFilter);
                }
            }
            AnnotationAppender annotationAppender2 = appendReceiver(annotationAppender, annotationValueFilter, methodDescription);
            int exceptionTypeIndex = 0;
            for (TypeDescription.Generic exceptionType : methodDescription.getExceptionTypes()) {
                exceptionTypeIndex++;
                annotationAppender2 = (AnnotationAppender) exceptionType.accept(AnnotationAppender.ForTypeAnnotations.ofExceptionType(annotationAppender2, annotationValueFilter, exceptionTypeIndex));
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/attribute/MethodAttributeAppender$Explicit.class */
    public static class Explicit implements MethodAttributeAppender, Factory {
        private final Target target;
        private final List<? extends AnnotationDescription> annotations;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.target.equals(((Explicit) obj).target) && this.annotations.equals(((Explicit) obj).annotations);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.target.hashCode()) * 31) + this.annotations.hashCode();
        }

        public Explicit(int parameterIndex, List<? extends AnnotationDescription> annotations) {
            this(new Target.OnMethodParameter(parameterIndex), annotations);
        }

        public Explicit(List<? extends AnnotationDescription> annotations) {
            this(Target.OnMethod.INSTANCE, annotations);
        }

        protected Explicit(Target target, List<? extends AnnotationDescription> annotations) {
            this.target = target;
            this.annotations = annotations;
        }

        /* renamed from: of */
        public static Factory m134of(MethodDescription methodDescription) {
            return new Factory.Compound(ofMethodAnnotations(methodDescription), ofParameterAnnotations(methodDescription));
        }

        public static Factory ofMethodAnnotations(MethodDescription methodDescription) {
            return new Explicit(methodDescription.getDeclaredAnnotations());
        }

        public static Factory ofParameterAnnotations(MethodDescription methodDescription) {
            ParameterList<?> parameters = methodDescription.getParameters();
            List<Factory> factories = new ArrayList<>(parameters.size());
            Iterator it = parameters.iterator();
            while (it.hasNext()) {
                ParameterDescription parameter = (ParameterDescription) it.next();
                factories.add(new Explicit(parameter.getIndex(), parameter.getDeclaredAnnotations()));
            }
            return new Factory.Compound(factories);
        }

        @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender.Factory
        public MethodAttributeAppender make(TypeDescription typeDescription) {
            return this;
        }

        @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender
        public void apply(MethodVisitor methodVisitor, MethodDescription methodDescription, AnnotationValueFilter annotationValueFilter) {
            AnnotationAppender appender = new AnnotationAppender.Default(this.target.make(methodVisitor, methodDescription));
            for (AnnotationDescription annotation : this.annotations) {
                appender = appender.append(annotation, annotationValueFilter);
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/attribute/MethodAttributeAppender$Explicit$Target.class */
        protected interface Target {
            AnnotationAppender.Target make(MethodVisitor methodVisitor, MethodDescription methodDescription);

            /* loaded from: grasscutter.jar:net/bytebuddy/implementation/attribute/MethodAttributeAppender$Explicit$Target$OnMethod.class */
            public enum OnMethod implements Target {
                INSTANCE;

                @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender.Explicit.Target
                public AnnotationAppender.Target make(MethodVisitor methodVisitor, MethodDescription methodDescription) {
                    return new AnnotationAppender.Target.OnMethod(methodVisitor);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/implementation/attribute/MethodAttributeAppender$Explicit$Target$OnMethodParameter.class */
            public static class OnMethodParameter implements Target {
                private final int parameterIndex;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.parameterIndex == ((OnMethodParameter) obj).parameterIndex;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.parameterIndex;
                }

                protected OnMethodParameter(int parameterIndex) {
                    this.parameterIndex = parameterIndex;
                }

                @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender.Explicit.Target
                public AnnotationAppender.Target make(MethodVisitor methodVisitor, MethodDescription methodDescription) {
                    if (this.parameterIndex < methodDescription.getParameters().size()) {
                        return new AnnotationAppender.Target.OnMethodParameter(methodVisitor, this.parameterIndex);
                    }
                    throw new IllegalArgumentException("Method " + methodDescription + " has less then " + this.parameterIndex + " parameters");
                }
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/attribute/MethodAttributeAppender$ForReceiverType.class */
    public static class ForReceiverType implements MethodAttributeAppender, Factory {
        private final TypeDescription.Generic receiverType;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.receiverType.equals(((ForReceiverType) obj).receiverType);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.receiverType.hashCode();
        }

        public ForReceiverType(TypeDescription.Generic receiverType) {
            this.receiverType = receiverType;
        }

        @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender.Factory
        public MethodAttributeAppender make(TypeDescription typeDescription) {
            return this;
        }

        @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender
        public void apply(MethodVisitor methodVisitor, MethodDescription methodDescription, AnnotationValueFilter annotationValueFilter) {
            this.receiverType.accept(AnnotationAppender.ForTypeAnnotations.ofReceiverType(new AnnotationAppender.Default(new AnnotationAppender.Target.OnMethod(methodVisitor)), annotationValueFilter));
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/attribute/MethodAttributeAppender$Compound.class */
    public static class Compound implements MethodAttributeAppender {
        private final List<MethodAttributeAppender> methodAttributeAppenders;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.methodAttributeAppenders.equals(((Compound) obj).methodAttributeAppenders);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.methodAttributeAppenders.hashCode();
        }

        public Compound(MethodAttributeAppender... methodAttributeAppender) {
            this(Arrays.asList(methodAttributeAppender));
        }

        public Compound(List<? extends MethodAttributeAppender> methodAttributeAppenders) {
            this.methodAttributeAppenders = new ArrayList();
            for (MethodAttributeAppender methodAttributeAppender : methodAttributeAppenders) {
                if (methodAttributeAppender instanceof Compound) {
                    this.methodAttributeAppenders.addAll(((Compound) methodAttributeAppender).methodAttributeAppenders);
                } else if (!(methodAttributeAppender instanceof NoOp)) {
                    this.methodAttributeAppenders.add(methodAttributeAppender);
                }
            }
        }

        @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender
        public void apply(MethodVisitor methodVisitor, MethodDescription methodDescription, AnnotationValueFilter annotationValueFilter) {
            for (MethodAttributeAppender methodAttributeAppender : this.methodAttributeAppenders) {
                methodAttributeAppender.apply(methodVisitor, methodDescription, annotationValueFilter);
            }
        }
    }
}
