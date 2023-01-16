package dev.morphia.query;

import dev.morphia.query.Updates;
import java.util.List;

/* loaded from: grasscutter.jar:dev/morphia/query/Updates.class */
public interface Updates<Updater extends Updates> {
    Updater addToSet(String str, Object obj);

    Updater addToSet(String str, List<?> list);

    Updater addToSet(String str, Iterable<?> iterable);

    Updater dec(String str);

    Updater dec(String str, Number number);

    Updater disableValidation();

    Updater enableValidation();

    Updater inc(String str);

    Updater inc(String str, Number number);

    Updater max(String str, Number number);

    Updater min(String str, Number number);

    Updater push(String str, Object obj);

    Updater push(String str, Object obj, PushOptions pushOptions);

    Updater push(String str, List<?> list);

    Updater push(String str, List<?> list, PushOptions pushOptions);

    Updater pull(String str, Object obj);

    Updater pullAll(String str, List<?> list);

    Updater removeFirst(String str);

    Updater removeLast(String str);

    Updater set(String str, Object obj);

    Updater set(Object obj);

    Updater setOnInsert(String str, Object obj);

    Updater unset(String str);

    @Deprecated(since = "2.0", forRemoval = true)
    default Updater removeAll(String field, Object value) {
        return pull(field, value);
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default Updater removeAll(String field, List<?> values) {
        return pullAll(field, values);
    }
}
