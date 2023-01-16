package dev.morphia.aggregation.experimental.stages;

import com.mongodb.DBCollection;
import com.mongodb.lang.Nullable;
import dev.morphia.aggregation.experimental.AggregationException;
import dev.morphia.aggregation.experimental.expressions.Expressions;
import dev.morphia.aggregation.experimental.expressions.impls.DocumentExpression;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import dev.morphia.aggregation.experimental.expressions.impls.Fields;
import dev.morphia.sofia.Sofia;
import java.util.Locale;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/Group.class */
public class Group extends Stage {

    /* renamed from: id */
    private GroupId f470id;
    private Fields<Group> fields;

    protected Group() {
        super("$group");
    }

    protected Group(GroupId id) {
        super("$group");
        this.f470id = id;
    }

    public static Group group(GroupId id) {
        return new Group(id);
    }

    public static Group group() {
        return new Group();
    }

    /* renamed from: id */
    public static GroupId m1246id() {
        return new GroupId();
    }

    /* renamed from: id */
    public static GroupId m1244id(String name) {
        return new GroupId(Expressions.field(name));
    }

    /* renamed from: id */
    public static GroupId m1245id(Expression name) {
        return new GroupId(name);
    }

    @Deprecated(forRemoval = true)
    /* renamed from: of */
    public static Group m1242of(GroupId id) {
        return new Group(id);
    }

    @Deprecated(forRemoval = true)
    /* renamed from: of */
    public static Group m1243of() {
        return new Group();
    }

    public Group field(String name) {
        return field(name, Expressions.field(name));
    }

    public Group field(String name, Expression expression) {
        if (!name.equals(DBCollection.ID_FIELD_NAME)) {
            if (this.fields == null) {
                this.fields = Fields.m1256on(this);
            }
            this.fields.add(name, expression);
        } else if (this.f470id != null) {
            throw new AggregationException(Sofia.groupIdAlreadyDefined(new Locale[0]));
        } else {
            this.f470id = m1245id(expression);
        }
        return this;
    }

    public Fields<Group> getFields() {
        return this.fields;
    }

    @Nullable
    public GroupId getId() {
        return this.f470id;
    }

    /* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/Group$GroupId.class */
    public static class GroupId {
        private Expression field;
        private DocumentExpression document;

        protected GroupId() {
            this.document = Expressions.m1259of();
        }

        protected GroupId(Expression value) {
            if (value instanceof DocumentExpression) {
                this.document = (DocumentExpression) value;
            } else {
                this.field = value;
            }
        }

        public GroupId field(String name) {
            return field(name, Expressions.field(name));
        }

        public GroupId field(String name, Expression expression) {
            if (this.field != null) {
                throw new AggregationException(Sofia.mixedModesNotAllowed(DBCollection.ID_FIELD_NAME, new Locale[0]));
            }
            this.document.field(name, expression);
            return this;
        }

        @Nullable
        public DocumentExpression getDocument() {
            return this.document;
        }

        @Nullable
        public Expression getField() {
            return this.field;
        }
    }
}
