package p013io.netty.handler.codec.string;

import p013io.netty.buffer.ByteBufUtil;
import p013io.netty.util.CharsetUtil;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.StringUtil;

/* renamed from: io.netty.handler.codec.string.LineSeparator */
/* loaded from: grasscutter.jar:io/netty/handler/codec/string/LineSeparator.class */
public final class LineSeparator {
    public static final LineSeparator DEFAULT = new LineSeparator(StringUtil.NEWLINE);
    public static final LineSeparator UNIX = new LineSeparator("\n");
    public static final LineSeparator WINDOWS = new LineSeparator("\r\n");
    private final String value;

    public LineSeparator(String lineSeparator) {
        this.value = (String) ObjectUtil.checkNotNull(lineSeparator, "lineSeparator");
    }

    public String value() {
        return this.value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LineSeparator)) {
            return false;
        }
        LineSeparator that = (LineSeparator) o;
        return this.value != null ? this.value.equals(that.value) : that.value == null;
    }

    public int hashCode() {
        if (this.value != null) {
            return this.value.hashCode();
        }
        return 0;
    }

    public String toString() {
        return ByteBufUtil.hexDump(this.value.getBytes(CharsetUtil.UTF_8));
    }
}
