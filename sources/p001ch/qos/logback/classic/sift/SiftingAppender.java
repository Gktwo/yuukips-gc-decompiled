package p001ch.qos.logback.classic.sift;

import org.slf4j.Marker;
import p001ch.qos.logback.classic.ClassicConstants;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.joran.spi.DefaultClass;
import p001ch.qos.logback.core.sift.Discriminator;
import p001ch.qos.logback.core.sift.SiftingAppenderBase;

/* renamed from: ch.qos.logback.classic.sift.SiftingAppender */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/sift/SiftingAppender.class */
public class SiftingAppender extends SiftingAppenderBase<ILoggingEvent> {
    /* access modifiers changed from: protected */
    public long getTimestamp(ILoggingEvent event) {
        return event.getTimeStamp();
    }

    @Override // p001ch.qos.logback.core.sift.SiftingAppenderBase
    @DefaultClass(MDCBasedDiscriminator.class)
    public void setDiscriminator(Discriminator<ILoggingEvent> discriminator) {
        setDiscriminator(discriminator);
    }

    /* access modifiers changed from: protected */
    public boolean eventMarksEndOfLife(ILoggingEvent event) {
        Marker marker = event.getMarker();
        if (marker == null) {
            return false;
        }
        return marker.contains(ClassicConstants.FINALIZE_SESSION_MARKER);
    }
}
