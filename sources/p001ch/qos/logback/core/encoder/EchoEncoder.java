package p001ch.qos.logback.core.encoder;

import p001ch.qos.logback.core.CoreConstants;

/* renamed from: ch.qos.logback.core.encoder.EchoEncoder */
/* loaded from: grasscutter.jar:ch/qos/logback/core/encoder/EchoEncoder.class */
public class EchoEncoder<E> extends EncoderBase<E> {
    String fileHeader;
    String fileFooter;

    @Override // p001ch.qos.logback.core.encoder.Encoder
    public byte[] encode(E event) {
        return (event + CoreConstants.LINE_SEPARATOR).getBytes();
    }

    @Override // p001ch.qos.logback.core.encoder.Encoder
    public byte[] footerBytes() {
        if (this.fileFooter == null) {
            return null;
        }
        return this.fileFooter.getBytes();
    }

    @Override // p001ch.qos.logback.core.encoder.Encoder
    public byte[] headerBytes() {
        if (this.fileHeader == null) {
            return null;
        }
        return this.fileHeader.getBytes();
    }
}
