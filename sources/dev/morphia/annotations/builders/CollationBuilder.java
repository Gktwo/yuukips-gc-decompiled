package dev.morphia.annotations.builders;

import com.mongodb.client.model.CollationAlternate;
import com.mongodb.client.model.CollationCaseFirst;
import com.mongodb.client.model.CollationMaxVariable;
import com.mongodb.client.model.CollationStrength;
import dev.morphia.annotations.Collation;

/* loaded from: grasscutter.jar:dev/morphia/annotations/builders/CollationBuilder.class */
public class CollationBuilder extends AnnotationBuilder<Collation> implements Collation {
    @Override // dev.morphia.annotations.builders.AnnotationBuilder, java.lang.annotation.Annotation
    public Class<Collation> annotationType() {
        return Collation.class;
    }

    @Override // dev.morphia.annotations.Collation
    public boolean backwards() {
        return ((Boolean) get("backwards")).booleanValue();
    }

    @Override // dev.morphia.annotations.Collation
    public boolean caseLevel() {
        return ((Boolean) get("caseLevel")).booleanValue();
    }

    @Override // dev.morphia.annotations.Collation
    public String locale() {
        return (String) get("locale");
    }

    @Override // dev.morphia.annotations.Collation
    public boolean normalization() {
        return ((Boolean) get("normalization")).booleanValue();
    }

    @Override // dev.morphia.annotations.Collation
    public boolean numericOrdering() {
        return ((Boolean) get("numericOrdering")).booleanValue();
    }

    @Override // dev.morphia.annotations.Collation
    public CollationAlternate alternate() {
        return (CollationAlternate) get("alternate");
    }

    @Override // dev.morphia.annotations.Collation
    public CollationCaseFirst caseFirst() {
        return (CollationCaseFirst) get("caseFirst");
    }

    @Override // dev.morphia.annotations.Collation
    public CollationMaxVariable maxVariable() {
        return (CollationMaxVariable) get("maxVariable");
    }

    @Override // dev.morphia.annotations.Collation
    public CollationStrength strength() {
        return (CollationStrength) get("strength");
    }

    public CollationBuilder alternate(CollationAlternate alternate) {
        put("alternate", alternate);
        return this;
    }

    public CollationBuilder backwards(boolean backwards) {
        put("backwards", Boolean.valueOf(backwards));
        return this;
    }

    public CollationBuilder caseFirst(CollationCaseFirst caseFirst) {
        put("caseFirst", caseFirst);
        return this;
    }

    public CollationBuilder caseLevel(boolean caseLevel) {
        put("caseLevel", Boolean.valueOf(caseLevel));
        return this;
    }

    public CollationBuilder locale(String locale) {
        put("locale", locale);
        return this;
    }

    public CollationBuilder maxVariable(CollationMaxVariable maxVariable) {
        put("maxVariable", maxVariable);
        return this;
    }

    public CollationBuilder normalization(boolean normalization) {
        put("normalization", Boolean.valueOf(normalization));
        return this;
    }

    public CollationBuilder numericOrdering(boolean numericOrdering) {
        put("numericOrdering", Boolean.valueOf(numericOrdering));
        return this;
    }

    public CollationBuilder strength(CollationStrength strength) {
        put("strength", strength);
        return this;
    }
}
