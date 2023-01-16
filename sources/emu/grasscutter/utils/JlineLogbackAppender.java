package emu.grasscutter.utils;

import emu.grasscutter.Grasscutter;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;
import org.jline.reader.LineReader;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.ConsoleAppender;

/* loaded from: grasscutter.jar:emu/grasscutter/utils/JlineLogbackAppender.class */
public class JlineLogbackAppender extends ConsoleAppender<ILoggingEvent> {
    /* access modifiers changed from: protected */
    public void append(ILoggingEvent eventObject) {
        if (this.started) {
            Stream stream = Arrays.stream(new String(this.encoder.encode(eventObject)).split("\n\r"));
            LineReader console = Grasscutter.getConsole();
            Objects.requireNonNull(console);
            stream.forEach(this::printAbove);
        }
    }
}
