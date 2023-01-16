package p001ch.qos.logback.core.spi;

import java.util.ArrayList;
import java.util.List;
import p001ch.qos.logback.core.filter.Filter;
import p001ch.qos.logback.core.util.COWArrayList;

/* renamed from: ch.qos.logback.core.spi.FilterAttachableImpl */
/* loaded from: grasscutter.jar:ch/qos/logback/core/spi/FilterAttachableImpl.class */
public final class FilterAttachableImpl<E> implements FilterAttachable<E> {
    COWArrayList<Filter<E>> filterList = new COWArrayList<>(new Filter[0]);

    @Override // p001ch.qos.logback.core.spi.FilterAttachable
    public void addFilter(Filter<E> newFilter) {
        this.filterList.add(newFilter);
    }

    @Override // p001ch.qos.logback.core.spi.FilterAttachable
    public void clearAllFilters() {
        this.filterList.clear();
    }

    @Override // p001ch.qos.logback.core.spi.FilterAttachable
    public FilterReply getFilterChainDecision(E event) {
        for (Filter<E> filter : this.filterList.asTypedArray()) {
            FilterReply r = filter.decide(event);
            if (r == FilterReply.DENY || r == FilterReply.ACCEPT) {
                return r;
            }
        }
        return FilterReply.NEUTRAL;
    }

    @Override // p001ch.qos.logback.core.spi.FilterAttachable
    public List<Filter<E>> getCopyOfAttachedFiltersList() {
        return new ArrayList(this.filterList);
    }
}
