package com.mongodb.internal.client.model;

import com.mongodb.client.model.CountOptions;
import com.mongodb.client.model.EstimatedDocumentCountOptions;
import java.util.concurrent.TimeUnit;

/* loaded from: grasscutter.jar:com/mongodb/internal/client/model/CountOptionsHelper.class */
public final class CountOptionsHelper {
    public static CountOptions fromEstimatedDocumentCountOptions(EstimatedDocumentCountOptions options) {
        return new CountOptions().maxTime(options.getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS);
    }

    private CountOptionsHelper() {
    }
}
