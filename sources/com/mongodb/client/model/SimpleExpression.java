package com.mongodb.client.model;

import org.bson.BsonDocument;
import org.bson.BsonDocumentWriter;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/model/SimpleExpression.class */
class SimpleExpression<TExpression> implements Bson {
    private final String name;
    private final TExpression expression;

    /* access modifiers changed from: package-private */
    public SimpleExpression(String name, TExpression expression) {
        this.name = name;
        this.expression = expression;
    }

    @Override // org.bson.conversions.Bson
    public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
        BsonDocumentWriter writer = new BsonDocumentWriter(new BsonDocument());
        writer.writeStartDocument();
        writer.writeName(this.name);
        BuildersHelper.encodeValue(writer, this.expression, codecRegistry);
        writer.writeEndDocument();
        return writer.getDocument();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleExpression<?> that = (SimpleExpression) o;
        if (this.name != null) {
            if (!this.name.equals(that.name)) {
                return false;
            }
        } else if (that.name != null) {
            return false;
        }
        return this.expression != null ? this.expression.equals(that.expression) : that.expression == null;
    }

    public int hashCode() {
        return (31 * (this.name != null ? this.name.hashCode() : 0)) + (this.expression != null ? this.expression.hashCode() : 0);
    }

    public String toString() {
        return "Expression{name='" + this.name + "', expression=" + this.expression + '}';
    }
}
