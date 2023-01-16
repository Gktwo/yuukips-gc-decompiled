package dev.morphia.query;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/query/CriteriaContainer.class */
public interface CriteriaContainer extends Criteria {
    default void add(Criteria... criteria) {
        MorphiaQuery.legacyOperation();
    }

    default CriteriaContainer and(Criteria... criteria) {
        return (CriteriaContainer) MorphiaQuery.legacyOperation();
    }

    default FieldEnd<? extends CriteriaContainer> criteria(String field) {
        return (FieldEnd) MorphiaQuery.legacyOperation();
    }

    /* renamed from: or */
    default CriteriaContainer mo1224or(Criteria... criteria) {
        return (CriteriaContainer) MorphiaQuery.legacyOperation();
    }

    default void remove(Criteria criteria) {
        MorphiaQuery.legacyOperation();
    }
}
