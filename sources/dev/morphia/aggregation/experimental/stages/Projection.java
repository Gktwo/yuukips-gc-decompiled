package dev.morphia.aggregation.experimental.stages;

import com.mongodb.DBCollection;
import dev.morphia.aggregation.experimental.expressions.Expressions;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import dev.morphia.aggregation.experimental.expressions.impls.Fields;
import dev.morphia.aggregation.experimental.expressions.impls.PipelineField;
import dev.morphia.query.ValidationException;
import dev.morphia.sofia.Sofia;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/Projection.class */
public class Projection extends Stage {
    private Fields<Projection> includes;
    private Fields<Projection> excludes;
    private boolean suppressId;

    protected Projection() {
        super("$project");
    }

    @Deprecated(forRemoval = true)
    /* renamed from: of */
    public static Projection m1233of() {
        return new Projection();
    }

    public static Projection project() {
        return new Projection();
    }

    public Projection exclude(String name) {
        return exclude(name, Expressions.value(false));
    }

    public List<PipelineField> getFields() {
        List<PipelineField> fields = new ArrayList<>();
        if (this.includes != null) {
            fields.addAll(this.includes.getFields());
        }
        if (this.excludes != null) {
            fields.addAll(this.excludes.getFields());
        }
        if (this.suppressId) {
            fields.add(new PipelineField(DBCollection.ID_FIELD_NAME, Expressions.value(false)));
        }
        return fields;
    }

    public Projection include(String name, Expression value) {
        if (this.includes == null) {
            this.includes = Fields.m1256on(this);
        }
        this.includes.add(name, value);
        validateProjections();
        return this;
    }

    public Projection include(String name) {
        return include(name, Expressions.value(true));
    }

    public Projection suppressId() {
        this.suppressId = true;
        return this;
    }

    private Projection exclude(String name, Expression value) {
        if (this.excludes == null) {
            this.excludes = Fields.m1256on(this);
        }
        this.excludes.add(name, value);
        validateProjections();
        return this;
    }

    private void validateProjections() {
        if (this.includes != null && this.excludes != null) {
            if (this.excludes.size() > 1 || !DBCollection.ID_FIELD_NAME.equals(this.excludes.getFields().get(0).getName())) {
                throw new ValidationException(Sofia.mixedProjections(new Locale[0]));
            }
        }
    }
}
