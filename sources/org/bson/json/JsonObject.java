package org.bson.json;

import org.bson.BsonDocument;
import org.bson.BsonDocumentWrapper;
import org.bson.assertions.Assertions;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:org/bson/json/JsonObject.class */
public class JsonObject implements Bson {
    private final String json;

    public JsonObject(String json) {
        Assertions.notNull("Json", json);
        boolean foundBrace = false;
        int i = 0;
        while (true) {
            if (i >= json.length()) {
                break;
            }
            char c = json.charAt(i);
            if (c == '{') {
                foundBrace = true;
                break;
            } else {
                Assertions.isTrueArgument("json is a valid JSON object", Character.isWhitespace(c));
                i++;
            }
        }
        Assertions.isTrueArgument("json is a valid JSON object", foundBrace);
        this.json = json;
    }

    public String getJson() {
        return this.json;
    }

    @Override // org.bson.conversions.Bson
    public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry registry) {
        return new BsonDocumentWrapper(this, registry.get(JsonObject.class));
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass() || !this.json.equals(((JsonObject) o).getJson())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.json.hashCode();
    }

    public String toString() {
        return this.json;
    }
}
