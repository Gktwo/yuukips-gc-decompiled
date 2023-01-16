package com.mchange.net;

/* loaded from: grasscutter.jar:com/mchange/net/SmtpException.class */
public class SmtpException extends ProtocolException {
    int resp_num;

    public SmtpException() {
    }

    public SmtpException(String str) {
        super(str);
    }

    public SmtpException(int i, String str) {
        this(str);
        this.resp_num = i;
    }

    public int getSmtpResponseNumber() {
        return this.resp_num;
    }
}
