package dev.morphia;

import com.mongodb.client.model.ReturnDocument;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/FindAndModifyOptions.class */
public final class FindAndModifyOptions extends ModifyOptions {
    @Deprecated(since = "2.0", forRemoval = true)
    public FindAndModifyOptions returnNew(boolean returnNew) {
        returnDocument(returnNew ? ReturnDocument.AFTER : ReturnDocument.BEFORE);
        return this;
    }
}
