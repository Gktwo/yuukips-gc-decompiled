package com.mchange.net;

import com.mchange.p005io.OutputStreamUtils;
import com.mchange.p005io.ReaderUtils;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Properties;

/* loaded from: grasscutter.jar:com/mchange/net/SmtpUtils.class */
public final class SmtpUtils {
    private static final String ENC = "8859_1";
    private static final String CRLF = "\r\n";
    private static final String CHARSET = "charset";
    private static final int CHARSET_LEN = CHARSET.length();
    public static final int DEFAULT_SMTP_PORT = 25;

    public static void sendMail(InetAddress inetAddress, int i, String str, String[] strArr, Properties properties, byte[] bArr) throws IOException, SmtpException {
        BufferedReader bufferedReader;
        DataOutputStream dataOutputStream;
        Socket socket;
        try {
            socket = null;
            dataOutputStream = null;
            bufferedReader = null;
            try {
                socket = new Socket(inetAddress, i);
                dataOutputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), ENC));
                ensureResponse(bufferedReader, 200, 300);
                dataOutputStream.writeBytes("HELO " + socket.getLocalAddress().getHostName() + "\r\n");
                dataOutputStream.flush();
                ensureResponse(bufferedReader, 200, 300);
                dataOutputStream.writeBytes("MAIL FROM: " + str + "\r\n");
                dataOutputStream.flush();
                ensureResponse(bufferedReader, 200, 300);
                int length = strArr.length;
                while (true) {
                    length--;
                    if (length < 0) {
                        break;
                    }
                    dataOutputStream.writeBytes("RCPT TO: " + strArr[length] + "\r\n");
                    dataOutputStream.flush();
                    ensureResponse(bufferedReader, 200, 300);
                }
                dataOutputStream.writeBytes("DATA\r\n");
                dataOutputStream.flush();
                ensureResponse(bufferedReader, 300, 400);
                Enumeration keys = properties.keys();
                while (keys.hasMoreElements()) {
                    String str2 = (String) keys.nextElement();
                    dataOutputStream.writeBytes(str2 + ": " + properties.getProperty(str2) + "\r\n");
                }
                dataOutputStream.writeBytes("\r\n");
                dataOutputStream.write(bArr);
                dataOutputStream.writeBytes("\r\n.\r\n");
                dataOutputStream.flush();
                ensureResponse(bufferedReader, 200, 300);
                dataOutputStream.writeBytes("QUIT\r\n");
                dataOutputStream.flush();
                OutputStreamUtils.attemptClose(dataOutputStream);
                ReaderUtils.attemptClose(bufferedReader);
                SocketUtils.attemptClose(socket);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                throw new InternalError("8859_1 not supported???");
            }
        } catch (Throwable th) {
            OutputStreamUtils.attemptClose(dataOutputStream);
            ReaderUtils.attemptClose(bufferedReader);
            SocketUtils.attemptClose(socket);
            throw th;
        }
    }

    private static String encodingFromContentType(String str) {
        int indexOf = str.indexOf(CHARSET);
        if (indexOf < 0) {
            return null;
        }
        String trim = str.substring(indexOf + CHARSET_LEN).trim();
        if (trim.charAt(0) != '=') {
            return encodingFromContentType(trim);
        }
        String trim2 = trim.substring(1).trim();
        int indexOf2 = trim2.indexOf(59);
        if (indexOf2 >= 0) {
            trim2 = trim2.substring(0, indexOf2);
        }
        return trim2;
    }

    private static byte[] bytesFromBodyString(String str, String str2) throws UnsupportedEncodingException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(byteArrayOutputStream, str2));
        printWriter.print(str);
        printWriter.flush();
        return byteArrayOutputStream.toByteArray();
    }

    private static void ensureResponse(BufferedReader bufferedReader, int i, int i2) throws IOException, SmtpException {
        String readLine = bufferedReader.readLine();
        try {
            int parseInt = Integer.parseInt(readLine.substring(0, 3));
            while (readLine.charAt(3) == '-') {
                readLine = bufferedReader.readLine();
            }
            if (parseInt < i || parseInt >= i2) {
                throw new SmtpException(parseInt, readLine);
            }
        } catch (NumberFormatException e) {
            throw new SmtpException("Bad SMTP response while mailing document!");
        }
    }

    public static void main(String[] strArr) {
        try {
            Properties properties = new Properties();
            properties.put("From", "goolash@mchange.com");
            properties.put("To", "garbage@mchange.com");
            properties.put("Subject", "Test test test AGAIN...");
            sendMail(InetAddress.getByName("mailhub.mchange.com"), 25, "octavia@mchange.com", new String[]{"swaldman@mchange.com", "sw-lists@mchange.com"}, properties, "This is a test AGAIN! Imagine that!".getBytes(ENC));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private SmtpUtils() {
    }
}
