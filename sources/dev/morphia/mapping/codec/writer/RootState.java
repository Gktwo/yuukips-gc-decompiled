package dev.morphia.mapping.codec.writer;

import org.bson.Document;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/writer/RootState.class */
public class RootState extends WriteState {
    private Document seed;
    private DocumentState documentState;

    /* access modifiers changed from: package-private */
    public RootState(DocumentWriter writer) {
        super(writer, null);
    }

    /* access modifiers changed from: package-private */
    public RootState(DocumentWriter writer, Document seed) {
        super(writer, null);
        this.seed = seed;
    }

    public Document getDocument() {
        Document document = new Document();
        if (this.seed != null) {
            document.putAll(this.seed);
        }
        document.putAll(this.documentState.value());
        return document;
    }

    public String toString() {
        if (this.documentState == null) {
            return "<<undefined>>";
        }
        return this.documentState.toString();
    }

    @Override // dev.morphia.mapping.codec.writer.WriteState
    protected String state() {
        return "root";
    }

    @Override // dev.morphia.mapping.codec.writer.WriteState
    WriteState document() {
        this.documentState = new DocumentState(getWriter(), this);
        return this.documentState;
    }

    @Override // dev.morphia.mapping.codec.writer.WriteState
    void done() {
    }
}
