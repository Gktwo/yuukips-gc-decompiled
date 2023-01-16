package net.bytebuddy.implementation.attribute;

import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.TypeDescription;

/* loaded from: grasscutter.jar:net/bytebuddy/implementation/attribute/AnnotationValueFilter.class */
public interface AnnotationValueFilter {

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/attribute/AnnotationValueFilter$Factory.class */
    public interface Factory {
        /* renamed from: on */
        AnnotationValueFilter mo135on(TypeDescription typeDescription);

        /* renamed from: on */
        AnnotationValueFilter mo138on(FieldDescription fieldDescription);

        /* renamed from: on */
        AnnotationValueFilter mo137on(MethodDescription methodDescription);

        /* renamed from: on */
        AnnotationValueFilter mo136on(RecordComponentDescription recordComponentDescription);
    }

    boolean isRelevant(AnnotationDescription annotationDescription, MethodDescription.InDefinedShape inDefinedShape);

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/attribute/AnnotationValueFilter$Default.class */
    public enum Default implements AnnotationValueFilter, Factory {
        SKIP_DEFAULTS {
            @Override // net.bytebuddy.implementation.attribute.AnnotationValueFilter
            public boolean isRelevant(AnnotationDescription annotationDescription, MethodDescription.InDefinedShape methodDescription) {
                Object defaultValue = methodDescription.getDefaultValue();
                return defaultValue == null || !defaultValue.equals(annotationDescription.getValue(methodDescription));
            }
        },
        APPEND_DEFAULTS {
            @Override // net.bytebuddy.implementation.attribute.AnnotationValueFilter
            public boolean isRelevant(AnnotationDescription annotationDescription, MethodDescription.InDefinedShape methodDescription) {
                return true;
            }
        };

        @Override // net.bytebuddy.implementation.attribute.AnnotationValueFilter.Factory
        /* renamed from: on */
        public AnnotationValueFilter mo135on(TypeDescription instrumentedType) {
            return this;
        }

        @Override // net.bytebuddy.implementation.attribute.AnnotationValueFilter.Factory
        /* renamed from: on */
        public AnnotationValueFilter mo138on(FieldDescription fieldDescription) {
            return this;
        }

        @Override // net.bytebuddy.implementation.attribute.AnnotationValueFilter.Factory
        /* renamed from: on */
        public AnnotationValueFilter mo137on(MethodDescription methodDescription) {
            return this;
        }

        @Override // net.bytebuddy.implementation.attribute.AnnotationValueFilter.Factory
        /* renamed from: on */
        public AnnotationValueFilter mo136on(RecordComponentDescription recordComponentDescription) {
            return this;
        }
    }
}
