package p001ch.qos.logback.core.spi;

import java.util.List;
import p001ch.qos.logback.core.filter.Filter;

/* renamed from: ch.qos.logback.core.spi.FilterAttachable */
/* loaded from: grasscutter.jar:ch/qos/logback/core/spi/FilterAttachable.class */
public interface FilterAttachable<E> {
    void addFilter(Filter<E> filter);

    void clearAllFilters();

    List<Filter<E>> getCopyOfAttachedFiltersList();

    FilterReply getFilterChainDecision(E e);
}
