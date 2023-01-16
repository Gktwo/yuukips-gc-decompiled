package p013io.netty.channel.kqueue;

import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.kqueue.AcceptFilter */
/* loaded from: grasscutter.jar:io/netty/channel/kqueue/AcceptFilter.class */
public final class AcceptFilter {
    static final AcceptFilter PLATFORM_UNSUPPORTED = new AcceptFilter("", "");
    private final String filterName;
    private final String filterArgs;

    public AcceptFilter(String filterName, String filterArgs) {
        this.filterName = (String) ObjectUtil.checkNotNull(filterName, "filterName");
        this.filterArgs = (String) ObjectUtil.checkNotNull(filterArgs, "filterArgs");
    }

    public String filterName() {
        return this.filterName;
    }

    public String filterArgs() {
        return this.filterArgs;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AcceptFilter)) {
            return false;
        }
        AcceptFilter rhs = (AcceptFilter) o;
        return this.filterName.equals(rhs.filterName) && this.filterArgs.equals(rhs.filterArgs);
    }

    public int hashCode() {
        return (31 * (31 + this.filterName.hashCode())) + this.filterArgs.hashCode();
    }

    public String toString() {
        return this.filterName + ", " + this.filterArgs;
    }
}
