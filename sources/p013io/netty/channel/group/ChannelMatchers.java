package p013io.netty.channel.group;

import p013io.netty.channel.Channel;
import p013io.netty.channel.ServerChannel;

/* renamed from: io.netty.channel.group.ChannelMatchers */
/* loaded from: grasscutter.jar:io/netty/channel/group/ChannelMatchers.class */
public final class ChannelMatchers {
    private static final ChannelMatcher ALL_MATCHER = new ChannelMatcher() { // from class: io.netty.channel.group.ChannelMatchers.1
        @Override // p013io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel channel) {
            return true;
        }
    };
    private static final ChannelMatcher SERVER_CHANNEL_MATCHER = isInstanceOf(ServerChannel.class);
    private static final ChannelMatcher NON_SERVER_CHANNEL_MATCHER = isNotInstanceOf(ServerChannel.class);

    private ChannelMatchers() {
    }

    public static ChannelMatcher all() {
        return ALL_MATCHER;
    }

    public static ChannelMatcher isNot(Channel channel) {
        return invert(m1181is(channel));
    }

    /* renamed from: is */
    public static ChannelMatcher m1181is(Channel channel) {
        return new InstanceMatcher(channel);
    }

    public static ChannelMatcher isInstanceOf(Class<? extends Channel> clazz) {
        return new ClassMatcher(clazz);
    }

    public static ChannelMatcher isNotInstanceOf(Class<? extends Channel> clazz) {
        return invert(isInstanceOf(clazz));
    }

    public static ChannelMatcher isServerChannel() {
        return SERVER_CHANNEL_MATCHER;
    }

    public static ChannelMatcher isNonServerChannel() {
        return NON_SERVER_CHANNEL_MATCHER;
    }

    public static ChannelMatcher invert(ChannelMatcher matcher) {
        return new InvertMatcher(matcher);
    }

    public static ChannelMatcher compose(ChannelMatcher... matchers) {
        if (matchers.length < 1) {
            throw new IllegalArgumentException("matchers must at least contain one element");
        } else if (matchers.length == 1) {
            return matchers[0];
        } else {
            return new CompositeMatcher(matchers);
        }
    }

    /* renamed from: io.netty.channel.group.ChannelMatchers$CompositeMatcher */
    /* loaded from: grasscutter.jar:io/netty/channel/group/ChannelMatchers$CompositeMatcher.class */
    private static final class CompositeMatcher implements ChannelMatcher {
        private final ChannelMatcher[] matchers;

        CompositeMatcher(ChannelMatcher... matchers) {
            this.matchers = matchers;
        }

        @Override // p013io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel channel) {
            for (ChannelMatcher m : this.matchers) {
                if (!m.matches(channel)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.group.ChannelMatchers$InvertMatcher */
    /* loaded from: grasscutter.jar:io/netty/channel/group/ChannelMatchers$InvertMatcher.class */
    public static final class InvertMatcher implements ChannelMatcher {
        private final ChannelMatcher matcher;

        InvertMatcher(ChannelMatcher matcher) {
            this.matcher = matcher;
        }

        @Override // p013io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel channel) {
            return !this.matcher.matches(channel);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.group.ChannelMatchers$InstanceMatcher */
    /* loaded from: grasscutter.jar:io/netty/channel/group/ChannelMatchers$InstanceMatcher.class */
    public static final class InstanceMatcher implements ChannelMatcher {
        private final Channel channel;

        InstanceMatcher(Channel channel) {
            this.channel = channel;
        }

        @Override // p013io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel ch) {
            return this.channel == ch;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.group.ChannelMatchers$ClassMatcher */
    /* loaded from: grasscutter.jar:io/netty/channel/group/ChannelMatchers$ClassMatcher.class */
    public static final class ClassMatcher implements ChannelMatcher {
        private final Class<? extends Channel> clazz;

        ClassMatcher(Class<? extends Channel> clazz) {
            this.clazz = clazz;
        }

        @Override // p013io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel ch) {
            return this.clazz.isInstance(ch);
        }
    }
}
