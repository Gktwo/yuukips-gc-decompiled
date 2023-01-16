package p013io.netty.handler.timeout;

import org.jline.builtins.TTop;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.StringUtil;

/* renamed from: io.netty.handler.timeout.IdleStateEvent */
/* loaded from: grasscutter.jar:io/netty/handler/timeout/IdleStateEvent.class */
public class IdleStateEvent {
    public static final IdleStateEvent FIRST_READER_IDLE_STATE_EVENT = new DefaultIdleStateEvent(IdleState.READER_IDLE, true);
    public static final IdleStateEvent READER_IDLE_STATE_EVENT = new DefaultIdleStateEvent(IdleState.READER_IDLE, false);
    public static final IdleStateEvent FIRST_WRITER_IDLE_STATE_EVENT = new DefaultIdleStateEvent(IdleState.WRITER_IDLE, true);
    public static final IdleStateEvent WRITER_IDLE_STATE_EVENT = new DefaultIdleStateEvent(IdleState.WRITER_IDLE, false);
    public static final IdleStateEvent FIRST_ALL_IDLE_STATE_EVENT = new DefaultIdleStateEvent(IdleState.ALL_IDLE, true);
    public static final IdleStateEvent ALL_IDLE_STATE_EVENT = new DefaultIdleStateEvent(IdleState.ALL_IDLE, false);
    private final IdleState state;
    private final boolean first;

    protected IdleStateEvent(IdleState state, boolean first) {
        this.state = (IdleState) ObjectUtil.checkNotNull(state, TTop.STAT_STATE);
        this.first = first;
    }

    public IdleState state() {
        return this.state;
    }

    public boolean isFirst() {
        return this.first;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + '(' + this.state + (this.first ? ", first" : "") + ')';
    }

    /* renamed from: io.netty.handler.timeout.IdleStateEvent$DefaultIdleStateEvent */
    /* loaded from: grasscutter.jar:io/netty/handler/timeout/IdleStateEvent$DefaultIdleStateEvent.class */
    private static final class DefaultIdleStateEvent extends IdleStateEvent {
        private final String representation;

        DefaultIdleStateEvent(IdleState state, boolean first) {
            super(state, first);
            this.representation = "IdleStateEvent(" + state + (first ? ", first" : "") + ')';
        }

        @Override // p013io.netty.handler.timeout.IdleStateEvent
        public String toString() {
            return this.representation;
        }
    }
}
