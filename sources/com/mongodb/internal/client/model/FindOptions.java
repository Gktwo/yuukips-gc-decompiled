package com.mongodb.internal.client.model;

import com.mongodb.CursorType;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.model.Collation;
import com.mongodb.lang.Nullable;
import java.util.concurrent.TimeUnit;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/internal/client/model/FindOptions.class */
public final class FindOptions {
    private int batchSize;
    private int limit;
    private Bson projection;
    private long maxTimeMS;
    private long maxAwaitTimeMS;
    private int skip;
    private Bson sort;
    private CursorType cursorType;
    private boolean noCursorTimeout;
    private boolean oplogReplay;
    private boolean partial;
    private Collation collation;
    private String comment;
    private Bson hint;
    private String hintString;
    private Bson max;
    private Bson min;
    private boolean returnKey;
    private boolean showRecordId;
    private Boolean allowDiskUse;

    public FindOptions() {
        this.cursorType = CursorType.NonTailable;
    }

    FindOptions(int batchSize, int limit, Bson projection, long maxTimeMS, long maxAwaitTimeMS, int skip, Bson sort, CursorType cursorType, boolean noCursorTimeout, boolean oplogReplay, boolean partial, Collation collation, String comment, Bson hint, String hintString, Bson max, Bson min, boolean returnKey, boolean showRecordId, Boolean allowDiskUse) {
        this.cursorType = CursorType.NonTailable;
        this.batchSize = batchSize;
        this.limit = limit;
        this.projection = projection;
        this.maxTimeMS = maxTimeMS;
        this.maxAwaitTimeMS = maxAwaitTimeMS;
        this.skip = skip;
        this.sort = sort;
        this.cursorType = cursorType;
        this.noCursorTimeout = noCursorTimeout;
        this.oplogReplay = oplogReplay;
        this.partial = partial;
        this.collation = collation;
        this.comment = comment;
        this.hint = hint;
        this.hintString = hintString;
        this.max = max;
        this.min = min;
        this.returnKey = returnKey;
        this.showRecordId = showRecordId;
        this.allowDiskUse = allowDiskUse;
    }

    public FindOptions withBatchSize(int batchSize) {
        return new FindOptions(batchSize, this.limit, this.projection, this.maxTimeMS, this.maxAwaitTimeMS, this.skip, this.sort, this.cursorType, this.noCursorTimeout, this.oplogReplay, this.partial, this.collation, this.comment, this.hint, this.hintString, this.max, this.min, this.returnKey, this.showRecordId, this.allowDiskUse);
    }

    public int getLimit() {
        return this.limit;
    }

    public FindOptions limit(int limit) {
        this.limit = limit;
        return this;
    }

    public int getSkip() {
        return this.skip;
    }

    public FindOptions skip(int skip) {
        this.skip = skip;
        return this;
    }

    public long getMaxTime(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        return timeUnit.convert(this.maxTimeMS, TimeUnit.MILLISECONDS);
    }

    public FindOptions maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        Assertions.isTrueArgument("maxTime > = 0", maxTime >= 0);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    public long getMaxAwaitTime(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        return timeUnit.convert(this.maxAwaitTimeMS, TimeUnit.MILLISECONDS);
    }

    public FindOptions maxAwaitTime(long maxAwaitTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        Assertions.isTrueArgument("maxAwaitTime > = 0", maxAwaitTime >= 0);
        this.maxAwaitTimeMS = TimeUnit.MILLISECONDS.convert(maxAwaitTime, timeUnit);
        return this;
    }

    public int getBatchSize() {
        return this.batchSize;
    }

    public FindOptions batchSize(int batchSize) {
        this.batchSize = batchSize;
        return this;
    }

    @Nullable
    public Bson getProjection() {
        return this.projection;
    }

    public FindOptions projection(@Nullable Bson projection) {
        this.projection = projection;
        return this;
    }

    @Nullable
    public Bson getSort() {
        return this.sort;
    }

    public FindOptions sort(@Nullable Bson sort) {
        this.sort = sort;
        return this;
    }

    public boolean isNoCursorTimeout() {
        return this.noCursorTimeout;
    }

    public FindOptions noCursorTimeout(boolean noCursorTimeout) {
        this.noCursorTimeout = noCursorTimeout;
        return this;
    }

    public boolean isOplogReplay() {
        return this.oplogReplay;
    }

    public FindOptions oplogReplay(boolean oplogReplay) {
        this.oplogReplay = oplogReplay;
        return this;
    }

    public boolean isPartial() {
        return this.partial;
    }

    public FindOptions partial(boolean partial) {
        this.partial = partial;
        return this;
    }

    public CursorType getCursorType() {
        return this.cursorType;
    }

    public FindOptions cursorType(CursorType cursorType) {
        this.cursorType = (CursorType) Assertions.notNull("cursorType", cursorType);
        return this;
    }

    @Nullable
    public Collation getCollation() {
        return this.collation;
    }

    public FindOptions collation(@Nullable Collation collation) {
        this.collation = collation;
        return this;
    }

    @Nullable
    public String getComment() {
        return this.comment;
    }

    public FindOptions comment(@Nullable String comment) {
        this.comment = comment;
        return this;
    }

    @Nullable
    public Bson getHint() {
        return this.hint;
    }

    public FindOptions hint(@Nullable Bson hint) {
        this.hint = hint;
        return this;
    }

    @Nullable
    public String getHintString() {
        return this.hintString;
    }

    public FindOptions hintString(@Nullable String hint) {
        this.hintString = hint;
        return this;
    }

    @Nullable
    public Bson getMax() {
        return this.max;
    }

    public FindOptions max(@Nullable Bson max) {
        this.max = max;
        return this;
    }

    @Nullable
    public Bson getMin() {
        return this.min;
    }

    public FindOptions min(@Nullable Bson min) {
        this.min = min;
        return this;
    }

    public boolean isReturnKey() {
        return this.returnKey;
    }

    public FindOptions returnKey(boolean returnKey) {
        this.returnKey = returnKey;
        return this;
    }

    public boolean isShowRecordId() {
        return this.showRecordId;
    }

    public FindOptions showRecordId(boolean showRecordId) {
        this.showRecordId = showRecordId;
        return this;
    }

    public Boolean isAllowDiskUse() {
        return this.allowDiskUse;
    }

    public FindOptions allowDiskUse(@Nullable Boolean allowDiskUse) {
        this.allowDiskUse = allowDiskUse;
        return this;
    }

    public String toString() {
        return "FindOptions{batchSize=" + this.batchSize + ", limit=" + this.limit + ", projection=" + this.projection + ", maxTimeMS=" + this.maxTimeMS + ", maxAwaitTimeMS=" + this.maxAwaitTimeMS + ", skip=" + this.skip + ", sort=" + this.sort + ", cursorType=" + this.cursorType + ", noCursorTimeout=" + this.noCursorTimeout + ", oplogReplay=" + this.oplogReplay + ", partial=" + this.partial + ", collation=" + this.collation + ", comment='" + this.comment + "', hint=" + this.hint + ", max=" + this.max + ", min=" + this.min + ", returnKey=" + this.returnKey + ", showRecordId=" + this.showRecordId + ", allowDiskUse=" + this.allowDiskUse + "}";
    }
}
