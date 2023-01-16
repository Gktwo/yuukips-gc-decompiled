package com.mchange.net;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

/* loaded from: grasscutter.jar:com/mchange/net/SmtpMailSender.class */
public class SmtpMailSender implements MailSender {
    InetAddress hostAddr;
    int port;

    public SmtpMailSender(InetAddress inetAddress, int i) {
        this.hostAddr = inetAddress;
        this.port = i;
    }

    public SmtpMailSender(InetAddress inetAddress) {
        this(inetAddress, 25);
    }

    public SmtpMailSender(String str, int i) throws UnknownHostException {
        this(InetAddress.getByName(str), i);
    }

    public SmtpMailSender(String str) throws UnknownHostException {
        this(str, 25);
    }

    @Override // com.mchange.net.MailSender
    public void sendMail(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4) throws IOException, ProtocolException, UnsupportedEncodingException {
        String[] strArr4;
        if (strArr == null || strArr.length < 1) {
            throw new SmtpException("You must specify at least one recipient in the \"to\" field.");
        }
        Properties properties = new Properties();
        properties.put("From", str);
        properties.put("To", makeRecipientString(strArr));
        properties.put("Subject", str2);
        properties.put("MIME-Version", "1.0");
        properties.put("Content-Type", "text/plain; charset=" + MimeUtils.normalEncoding(str4));
        properties.put("X-Generator", getClass().getName());
        if (strArr2 == null && strArr3 == null) {
            strArr4 = strArr;
        } else {
            strArr4 = new String[strArr.length + (strArr2 != null ? strArr2.length : 0) + (strArr3 != null ? strArr3.length : 0)];
            System.arraycopy(strArr, 0, strArr4, 0, strArr.length);
            int length = 0 + strArr.length;
            if (strArr2 != null) {
                System.arraycopy(strArr2, 0, strArr4, length, strArr2.length);
                length += strArr2.length;
                properties.put("CC", makeRecipientString(strArr2));
            }
            if (strArr3 != null) {
                System.arraycopy(strArr3, 0, strArr4, length, strArr3.length);
            }
        }
        SmtpUtils.sendMail(this.hostAddr, this.port, str, strArr4, properties, str3.getBytes(str4));
    }

    @Override // com.mchange.net.MailSender
    public void sendMail(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3) throws IOException, ProtocolException {
        try {
            sendMail(str, strArr, strArr2, strArr3, str2, str3, System.getProperty("file.encoding"));
        } catch (UnsupportedEncodingException e) {
            throw new InternalError("Default encoding [" + System.getProperty("file.encoding") + "] not supported???");
        }
    }

    private static String makeRecipientString(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer(256);
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(strArr[i]);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] strArr) {
        try {
            new SmtpMailSender("localhost").sendMail("swaldman@mchange.com", new String[]{"stevewaldman@uky.edu"}, new String[0], new String[]{"stevewaldman@mac.com"}, "Test SmtpMailSender Again", "Wheeeee!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
