package emu.grasscutter.utils;

import emu.grasscutter.server.event.internal.ServerLogEvent;
import java.nio.charset.StandardCharsets;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.AppenderBase;
import p001ch.qos.logback.core.encoder.Encoder;

/* loaded from: grasscutter.jar:emu/grasscutter/utils/ServerLogEventAppender.class */
public class ServerLogEventAppender<E> extends AppenderBase<E> {
    protected Encoder<E> encoder;

    @Override // p001ch.qos.logback.core.AppenderBase
    protected void append(E event) {
        new ServerLogEvent((ILoggingEvent) event, new String(this.encoder.encode(event), StandardCharsets.UTF_8)).call();
    }

    public Encoder<E> getEncoder() {
        return this.encoder;
    }

    public void setEncoder(Encoder<E> encoder) {
        this.encoder = encoder;
    }
}
