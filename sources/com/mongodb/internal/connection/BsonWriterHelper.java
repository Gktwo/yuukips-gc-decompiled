package com.mongodb.internal.connection;

import com.mongodb.internal.connection.MessageSettings;
import com.mongodb.internal.connection.SplittablePayload;
import java.util.List;
import org.bson.BsonDocument;
import org.bson.BsonElement;
import org.bson.BsonMaximumSizeExceededException;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.codecs.BsonValueCodecProvider;
import org.bson.codecs.Codec;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.p022io.BsonOutput;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/BsonWriterHelper.class */
final class BsonWriterHelper {
    private static final int DOCUMENT_HEADROOM = 16384;
    private static final CodecRegistry REGISTRY = CodecRegistries.fromProviders(new BsonValueCodecProvider());
    private static final EncoderContext ENCODER_CONTEXT = EncoderContext.builder().build();

    /* access modifiers changed from: package-private */
    public static void writeElements(BsonWriter writer, List<BsonElement> bsonElements) {
        for (BsonElement bsonElement : bsonElements) {
            writer.writeName(bsonElement.getName());
            getCodec(bsonElement.getValue()).encode(writer, bsonElement.getValue(), ENCODER_CONTEXT);
        }
    }

    /* access modifiers changed from: package-private */
    public static void writePayloadArray(BsonWriter writer, BsonOutput bsonOutput, MessageSettings settings, int messageStartPosition, SplittablePayload payload, int maxSplittableDocumentSize) {
        writer.writeStartArray(payload.getPayloadName());
        writePayload(writer, bsonOutput, getDocumentMessageSettings(settings), messageStartPosition, payload, maxSplittableDocumentSize);
        writer.writeEndArray();
    }

    /* access modifiers changed from: package-private */
    public static void writePayload(BsonWriter writer, BsonOutput bsonOutput, MessageSettings settings, int messageStartPosition, SplittablePayload payload, int maxSplittableDocumentSize) {
        MessageSettings payloadSettings = getPayloadMessageSettings(payload.getPayloadType(), settings);
        List<BsonDocument> payloadDocuments = payload.getPayload();
        int i = 0;
        while (i < payloadDocuments.size() && writeDocument(writer, bsonOutput, payloadSettings, payloadDocuments.get(i), messageStartPosition, i + 1, maxSplittableDocumentSize)) {
            payload.setPosition(i + 1);
            i++;
        }
        if (payload.getPosition() == 0) {
            throw new BsonMaximumSizeExceededException(String.format("Payload document size is larger than maximum of %d.", Integer.valueOf(payloadSettings.getMaxDocumentSize())));
        }
    }

    private static boolean writeDocument(BsonWriter writer, BsonOutput bsonOutput, MessageSettings settings, BsonDocument document, int messageStartPosition, int batchItemCount, int maxSplittableDocumentSize) {
        int currentPosition = bsonOutput.getPosition();
        getCodec(document).encode(writer, document, ENCODER_CONTEXT);
        if (!exceedsLimits(settings, bsonOutput.getPosition() - messageStartPosition, bsonOutput.getPosition() - currentPosition, batchItemCount) && (batchItemCount <= 1 || bsonOutput.getPosition() - messageStartPosition <= maxSplittableDocumentSize)) {
            return true;
        }
        bsonOutput.truncateToPosition(currentPosition);
        return false;
    }

    private static Codec<BsonValue> getCodec(BsonValue bsonValue) {
        return REGISTRY.get(bsonValue.getClass());
    }

    private static MessageSettings getPayloadMessageSettings(SplittablePayload.Type type, MessageSettings settings) {
        MessageSettings payloadMessageSettings = settings;
        if (type != SplittablePayload.Type.INSERT) {
            payloadMessageSettings = createMessageSettingsBuilder(settings).maxDocumentSize(settings.getMaxDocumentSize() + 16384).build();
        }
        return payloadMessageSettings;
    }

    private static MessageSettings getDocumentMessageSettings(MessageSettings settings) {
        return createMessageSettingsBuilder(settings).maxMessageSize(settings.getMaxDocumentSize() + 16384).build();
    }

    private static MessageSettings.Builder createMessageSettingsBuilder(MessageSettings settings) {
        return MessageSettings.builder().maxBatchCount(settings.getMaxBatchCount()).maxMessageSize(settings.getMaxMessageSize()).maxDocumentSize(settings.getMaxDocumentSize()).maxWireVersion(settings.getMaxWireVersion());
    }

    private static boolean exceedsLimits(MessageSettings settings, int messageSize, int documentSize, int batchItemCount) {
        if (batchItemCount <= settings.getMaxBatchCount() && messageSize <= settings.getMaxMessageSize() && documentSize <= settings.getMaxDocumentSize()) {
            return false;
        }
        return true;
    }

    private BsonWriterHelper() {
    }
}
