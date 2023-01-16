package dev.morphia.aggregation.experimental.stages;

import dev.morphia.aggregation.experimental.expressions.Expressions;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import dev.morphia.sofia.Sofia;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/Unset.class */
public class Unset extends Stage {
    private final List<Expression> fields = new ArrayList();

    protected Unset() {
        super("$unset");
    }

    @Deprecated(forRemoval = true)
    public static Unset fields(String name, String... names) {
        Unset unset = new Unset().add(name);
        for (String additional : names) {
            unset.add(additional);
        }
        return unset;
    }

    public static Unset unset(String name, String... names) {
        Unset unset = new Unset().add(name);
        for (String additional : names) {
            unset.add(additional);
        }
        return unset;
    }

    public List<Expression> getFields() {
        return this.fields;
    }

    private Unset add(String name) {
        String fieldName = name;
        if (fieldName.startsWith("$")) {
            fieldName = fieldName.substring(1);
            Sofia.logUnsetNamesDollarSign(new Locale[0]);
        }
        this.fields.add(Expressions.value(fieldName));
        return this;
    }
}
