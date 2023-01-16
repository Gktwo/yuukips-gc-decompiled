package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.introspect.Annotated;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/introspect/AnnotatedAndMetadata.class */
public class AnnotatedAndMetadata<A extends Annotated, M> {
    public final A annotated;
    public final M metadata;

    public AnnotatedAndMetadata(A ann, M md) {
        this.annotated = ann;
        this.metadata = md;
    }

    /* renamed from: of */
    public static <A extends Annotated, M> AnnotatedAndMetadata<A, M> m1473of(A ann, M md) {
        return new AnnotatedAndMetadata<>(ann, md);
    }
}
