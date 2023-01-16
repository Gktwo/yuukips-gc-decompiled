package org.eclipse.jetty.client.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Iterator;
import org.eclipse.jetty.util.Fields;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/FormContentProvider.class */
public class FormContentProvider extends StringContentProvider {
    public FormContentProvider(Fields fields) {
        this(fields, StandardCharsets.UTF_8);
    }

    public FormContentProvider(Fields fields, Charset charset) {
        super("application/x-www-form-urlencoded", convert(fields, charset), charset);
    }

    public static String convert(Fields fields) {
        return convert(fields, StandardCharsets.UTF_8);
    }

    public static String convert(Fields fields, Charset charset) {
        StringBuilder builder = new StringBuilder(fields.getSize() * 32);
        Iterator<Fields.Field> it = fields.iterator();
        while (it.hasNext()) {
            Fields.Field field = it.next();
            for (String value : field.getValues()) {
                if (builder.length() > 0) {
                    builder.append("&");
                }
                builder.append(encode(field.getName(), charset)).append("=").append(encode(value, charset));
            }
        }
        return builder.toString();
    }

    private static String encode(String value, Charset charset) {
        try {
            return URLEncoder.encode(value, charset.name());
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedCharsetException(charset.name());
        }
    }
}
