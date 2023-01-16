package dev.morphia.query;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/query/AbstractCriteria.class */
public abstract class AbstractCriteria implements Criteria {
    private CriteriaContainer attachedTo;

    @Override // dev.morphia.query.Criteria
    public void attach(CriteriaContainer container) {
        if (this.attachedTo != null) {
            this.attachedTo.remove(this);
        }
        this.attachedTo = container;
    }
}
