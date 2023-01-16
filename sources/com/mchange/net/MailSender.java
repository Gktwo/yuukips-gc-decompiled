package com.mchange.net;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* loaded from: grasscutter.jar:com/mchange/net/MailSender.class */
public interface MailSender {
    void sendMail(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4) throws IOException, ProtocolException, UnsupportedEncodingException;

    void sendMail(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3) throws IOException, ProtocolException;
}
