package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/ser/std/InetSocketAddressSerializer.class */
public class InetSocketAddressSerializer extends StdScalarSerializer<InetSocketAddress> {
    public InetSocketAddressSerializer() {
        super(InetSocketAddress.class);
    }

    public void serialize(InetSocketAddress value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        InetAddress addr = value.getAddress();
        String str = addr == null ? value.getHostName() : addr.toString().trim();
        int ix = str.indexOf(47);
        if (ix >= 0) {
            if (ix != 0) {
                str = str.substring(0, ix);
            } else if (addr instanceof Inet6Address) {
                str = "[" + str.substring(1) + "]";
            } else {
                str = str.substring(1);
            }
        }
        jgen.writeString(str + EmitterKt.COMMENT_PREFIX + value.getPort());
    }

    public void serializeWithType(InetSocketAddress value, JsonGenerator g, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
        WritableTypeId typeIdDef = typeSer.writeTypePrefix(g, typeSer.typeId(value, InetSocketAddress.class, JsonToken.VALUE_STRING));
        serialize(value, g, provider);
        typeSer.writeTypeSuffix(g, typeIdDef);
    }
}
