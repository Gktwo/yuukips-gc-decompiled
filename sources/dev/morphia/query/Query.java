package dev.morphia.query;

import com.mongodb.ExplainVerbosity;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.lang.Nullable;
import dev.morphia.DeleteOptions;
import dev.morphia.query.experimental.filters.Filter;
import dev.morphia.query.experimental.updates.UpdateOperator;
import dev.morphia.query.internal.MorphiaCursor;
import dev.morphia.query.internal.MorphiaKeyCursor;
import dev.morphia.sofia.Sofia;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/query/Query.class */
public interface Query<T> extends CriteriaContainer, Iterable<T> {
    long count();

    long count(CountOptions countOptions);

    DeleteResult delete(DeleteOptions deleteOptions);

    Query<T> disableValidation();

    Query<T> enableValidation();

    Map<String, Object> explain(FindOptions findOptions, @Nullable ExplainVerbosity explainVerbosity);

    @Nullable
    T findAndDelete(FindAndDeleteOptions findAndDeleteOptions);

    @Nullable
    T first();

    @Nullable
    T first(FindOptions findOptions);

    Class<T> getEntityClass();

    Modify<T> modify(UpdateOperator updateOperator, UpdateOperator... updateOperatorArr);

    MorphiaCursor<T> iterator(FindOptions findOptions);

    @Deprecated(since = "2.0", forRemoval = true)
    MorphiaKeyCursor<T> keys();

    @Deprecated(since = "2.0", forRemoval = true)
    MorphiaKeyCursor<T> keys(FindOptions findOptions);

    @Deprecated(since = "2.0", forRemoval = true)
    Query<T> search(String str);

    @Deprecated(since = "2.0", forRemoval = true)
    Query<T> search(String str, String str2);

    @Override // dev.morphia.query.Criteria
    Document toDocument();

    Update<T> update(UpdateOperator updateOperator, UpdateOperator... updateOperatorArr);

    @Override // dev.morphia.query.CriteriaContainer
    @Deprecated(since = "2.0", forRemoval = true)
    default CriteriaContainer and(Criteria... criteria) {
        return (CriteriaContainer) MorphiaQuery.legacyOperation();
    }

    @Override // dev.morphia.query.CriteriaContainer
    @Deprecated(since = "2.0", forRemoval = true)
    default FieldEnd<? extends CriteriaContainer> criteria(String field) {
        return (FieldEnd) MorphiaQuery.legacyOperation();
    }

    default DeleteResult delete() {
        return delete(new DeleteOptions());
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default MorphiaCursor<T> execute() {
        return (MorphiaCursor) MorphiaQuery.legacyOperation();
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default MorphiaCursor<T> execute(FindOptions options) {
        return (MorphiaCursor) MorphiaQuery.legacyOperation();
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default MorphiaCursor<T> find() {
        return iterator();
    }

    default Map<String, Object> explain() {
        return explain(new FindOptions());
    }

    default Map<String, Object> explain(FindOptions options) {
        return explain(options, null);
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default FieldEnd<? extends Query<T>> field(String name) {
        return (FieldEnd) MorphiaQuery.legacyOperation();
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default Query<T> filter(String condition, Object value) {
        return (Query) MorphiaQuery.legacyOperation();
    }

    default Query<T> filter(Filter... filters) {
        throw new UnsupportedOperationException(Sofia.notAvailableInLegacy(new Locale[0]));
    }

    @Nullable
    default T findAndDelete() {
        return findAndDelete(new FindAndDeleteOptions());
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default MorphiaCursor<T> find(FindOptions options) {
        return iterator(options);
    }

    @Override // java.lang.Iterable
    default MorphiaCursor<T> iterator() {
        return iterator(new FindOptions());
    }

    @Override // dev.morphia.query.CriteriaContainer
    @Deprecated(since = "2.0", forRemoval = true)
    /* renamed from: or */
    default CriteriaContainer mo1224or(Criteria... criteria) {
        return (CriteriaContainer) MorphiaQuery.legacyOperation();
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default Modify<T> modify(UpdateOperations<T> operations) {
        return (Modify) MorphiaQuery.legacyOperation();
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default Query<T> retrieveKnownFields() {
        return (Query) MorphiaQuery.legacyOperation();
    }

    default Stream<T> stream() {
        return stream(new FindOptions());
    }

    default Stream<T> stream(FindOptions options) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator(options), 0), false);
    }

    default Update<T> update(List<UpdateOperator> updates) {
        if (!updates.isEmpty()) {
            return update(updates.get(0), (UpdateOperator[]) updates.subList(1, updates.size()).toArray(new UpdateOperator[0]));
        }
        throw new IllegalArgumentException(Sofia.atLeastOneUpdateRequired(new Locale[0]));
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default Update<T> update(UpdateOperations<T> operations) {
        return (Update) MorphiaQuery.legacyOperation();
    }
}
