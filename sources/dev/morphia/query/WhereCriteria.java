package dev.morphia.query;

import org.bson.Document;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/query/WhereCriteria.class */
public class WhereCriteria extends AbstractCriteria {

    /* renamed from: js */
    private final Object f487js;

    public WhereCriteria(String js) {
        this.f487js = js;
    }

    @Override // dev.morphia.query.Criteria
    public Document toDocument() {
        return new Document(FilterOperator.WHERE.val(), this.f487js);
    }

    @Override // dev.morphia.query.Criteria
    public String getFieldName() {
        return FilterOperator.WHERE.val();
    }
}
