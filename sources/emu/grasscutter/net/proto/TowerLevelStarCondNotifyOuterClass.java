package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.TowerLevelStarCondDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerLevelStarCondNotifyOuterClass.class */
public final class TowerLevelStarCondNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eTowerLevelStarCondNotify.proto\u001a\u001cTowerLevelStarCondData.proto\"n\n\u0018TowerLevelStarCondNotify\u0012\u000f\n\u0007floorId\u0018\r \u0001(\r\u0012\u0012\n\nlevelIndex\u0018\u0004 \u0001(\r\u0012-\n\fcondDataList\u0018\u000f \u0003(\u000b2\u0017.TowerLevelStarCondDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{TowerLevelStarCondDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TowerLevelStarCondNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TowerLevelStarCondNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TowerLevelStarCondNotify_descriptor, new String[]{"FloorId", "LevelIndex", "CondDataList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerLevelStarCondNotifyOuterClass$TowerLevelStarCondNotifyOrBuilder.class */
    public interface TowerLevelStarCondNotifyOrBuilder extends MessageOrBuilder {
        int getFloorId();

        int getLevelIndex();

        List<TowerLevelStarCondDataOuterClass.TowerLevelStarCondData> getCondDataListList();

        TowerLevelStarCondDataOuterClass.TowerLevelStarCondData getCondDataList(int i);

        int getCondDataListCount();

        List<? extends TowerLevelStarCondDataOuterClass.TowerLevelStarCondDataOrBuilder> getCondDataListOrBuilderList();

        TowerLevelStarCondDataOuterClass.TowerLevelStarCondDataOrBuilder getCondDataListOrBuilder(int i);
    }

    private TowerLevelStarCondNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerLevelStarCondNotifyOuterClass$TowerLevelStarCondNotify.class */
    public static final class TowerLevelStarCondNotify extends GeneratedMessageV3 implements TowerLevelStarCondNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FLOORID_FIELD_NUMBER = 13;
        private int floorId_;
        public static final int LEVELINDEX_FIELD_NUMBER = 4;
        private int levelIndex_;
        public static final int CONDDATALIST_FIELD_NUMBER = 15;
        private List<TowerLevelStarCondDataOuterClass.TowerLevelStarCondData> condDataList_;
        private byte memoizedIsInitialized;
        private static final TowerLevelStarCondNotify DEFAULT_INSTANCE = new TowerLevelStarCondNotify();
        private static final Parser<TowerLevelStarCondNotify> PARSER = new AbstractParser<TowerLevelStarCondNotify>() { // from class: emu.grasscutter.net.proto.TowerLevelStarCondNotifyOuterClass.TowerLevelStarCondNotify.1
            @Override // com.google.protobuf.Parser
            public TowerLevelStarCondNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TowerLevelStarCondNotify(input, extensionRegistry);
            }
        };

        private TowerLevelStarCondNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TowerLevelStarCondNotify() {
            this.memoizedIsInitialized = -1;
            this.condDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TowerLevelStarCondNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TowerLevelStarCondNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_;
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                mutable_bitField0_ = 0;
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 32:
                                this.levelIndex_ = input.readUInt32();
                                break;
                            case 104:
                                this.floorId_ = input.readUInt32();
                                break;
                            case 122:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.condDataList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.condDataList_.add((TowerLevelStarCondDataOuterClass.TowerLevelStarCondData) input.readMessage(TowerLevelStarCondDataOuterClass.TowerLevelStarCondData.parser(), extensionRegistry));
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.condDataList_ = Collections.unmodifiableList(this.condDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TowerLevelStarCondNotifyOuterClass.internal_static_TowerLevelStarCondNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TowerLevelStarCondNotifyOuterClass.internal_static_TowerLevelStarCondNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(TowerLevelStarCondNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TowerLevelStarCondNotifyOuterClass.TowerLevelStarCondNotifyOrBuilder
        public int getFloorId() {
            return this.floorId_;
        }

        @Override // emu.grasscutter.net.proto.TowerLevelStarCondNotifyOuterClass.TowerLevelStarCondNotifyOrBuilder
        public int getLevelIndex() {
            return this.levelIndex_;
        }

        @Override // emu.grasscutter.net.proto.TowerLevelStarCondNotifyOuterClass.TowerLevelStarCondNotifyOrBuilder
        public List<TowerLevelStarCondDataOuterClass.TowerLevelStarCondData> getCondDataListList() {
            return this.condDataList_;
        }

        @Override // emu.grasscutter.net.proto.TowerLevelStarCondNotifyOuterClass.TowerLevelStarCondNotifyOrBuilder
        public List<? extends TowerLevelStarCondDataOuterClass.TowerLevelStarCondDataOrBuilder> getCondDataListOrBuilderList() {
            return this.condDataList_;
        }

        @Override // emu.grasscutter.net.proto.TowerLevelStarCondNotifyOuterClass.TowerLevelStarCondNotifyOrBuilder
        public int getCondDataListCount() {
            return this.condDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.TowerLevelStarCondNotifyOuterClass.TowerLevelStarCondNotifyOrBuilder
        public TowerLevelStarCondDataOuterClass.TowerLevelStarCondData getCondDataList(int index) {
            return this.condDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TowerLevelStarCondNotifyOuterClass.TowerLevelStarCondNotifyOrBuilder
        public TowerLevelStarCondDataOuterClass.TowerLevelStarCondDataOrBuilder getCondDataListOrBuilder(int index) {
            return this.condDataList_.get(index);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.levelIndex_ != 0) {
                output.writeUInt32(4, this.levelIndex_);
            }
            if (this.floorId_ != 0) {
                output.writeUInt32(13, this.floorId_);
            }
            for (int i = 0; i < this.condDataList_.size(); i++) {
                output.writeMessage(15, this.condDataList_.get(i));
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.levelIndex_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.levelIndex_);
            }
            if (this.floorId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.floorId_);
            }
            for (int i = 0; i < this.condDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(15, this.condDataList_.get(i));
            }
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TowerLevelStarCondNotify)) {
                return equals(obj);
            }
            TowerLevelStarCondNotify other = (TowerLevelStarCondNotify) obj;
            return getFloorId() == other.getFloorId() && getLevelIndex() == other.getLevelIndex() && getCondDataListList().equals(other.getCondDataListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + getFloorId())) + 4)) + getLevelIndex();
            if (getCondDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getCondDataListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TowerLevelStarCondNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerLevelStarCondNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerLevelStarCondNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerLevelStarCondNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerLevelStarCondNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerLevelStarCondNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerLevelStarCondNotify parseFrom(InputStream input) throws IOException {
            return (TowerLevelStarCondNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerLevelStarCondNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerLevelStarCondNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerLevelStarCondNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (TowerLevelStarCondNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TowerLevelStarCondNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerLevelStarCondNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerLevelStarCondNotify parseFrom(CodedInputStream input) throws IOException {
            return (TowerLevelStarCondNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerLevelStarCondNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerLevelStarCondNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TowerLevelStarCondNotify prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
            return new Builder(parent);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerLevelStarCondNotifyOuterClass$TowerLevelStarCondNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TowerLevelStarCondNotifyOrBuilder {
            private int bitField0_;
            private int floorId_;
            private int levelIndex_;
            private List<TowerLevelStarCondDataOuterClass.TowerLevelStarCondData> condDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<TowerLevelStarCondDataOuterClass.TowerLevelStarCondData, TowerLevelStarCondDataOuterClass.TowerLevelStarCondData.Builder, TowerLevelStarCondDataOuterClass.TowerLevelStarCondDataOrBuilder> condDataListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TowerLevelStarCondNotifyOuterClass.internal_static_TowerLevelStarCondNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TowerLevelStarCondNotifyOuterClass.internal_static_TowerLevelStarCondNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(TowerLevelStarCondNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TowerLevelStarCondNotify.alwaysUseFieldBuilders) {
                    getCondDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.floorId_ = 0;
                this.levelIndex_ = 0;
                if (this.condDataListBuilder_ == null) {
                    this.condDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.condDataListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TowerLevelStarCondNotifyOuterClass.internal_static_TowerLevelStarCondNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TowerLevelStarCondNotify getDefaultInstanceForType() {
                return TowerLevelStarCondNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerLevelStarCondNotify build() {
                TowerLevelStarCondNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerLevelStarCondNotify buildPartial() {
                TowerLevelStarCondNotify result = new TowerLevelStarCondNotify(this);
                int i = this.bitField0_;
                result.floorId_ = this.floorId_;
                result.levelIndex_ = this.levelIndex_;
                if (this.condDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.condDataList_ = Collections.unmodifiableList(this.condDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.condDataList_ = this.condDataList_;
                } else {
                    result.condDataList_ = this.condDataListBuilder_.build();
                }
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, java.lang.Object, com.google.protobuf.Message.Builder
            public Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor field, Object value) {
                return setField(field, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor field) {
                return clearField(field);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneof) {
                return clearOneof(oneof);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
                return setRepeatedField(field, index, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
                return addRepeatedField(field, value);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof TowerLevelStarCondNotify) {
                    return mergeFrom((TowerLevelStarCondNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TowerLevelStarCondNotify other) {
                if (other == TowerLevelStarCondNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getFloorId() != 0) {
                    setFloorId(other.getFloorId());
                }
                if (other.getLevelIndex() != 0) {
                    setLevelIndex(other.getLevelIndex());
                }
                if (this.condDataListBuilder_ == null) {
                    if (!other.condDataList_.isEmpty()) {
                        if (this.condDataList_.isEmpty()) {
                            this.condDataList_ = other.condDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureCondDataListIsMutable();
                            this.condDataList_.addAll(other.condDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.condDataList_.isEmpty()) {
                    if (this.condDataListBuilder_.isEmpty()) {
                        this.condDataListBuilder_.dispose();
                        this.condDataListBuilder_ = null;
                        this.condDataList_ = other.condDataList_;
                        this.bitField0_ &= -2;
                        this.condDataListBuilder_ = TowerLevelStarCondNotify.alwaysUseFieldBuilders ? getCondDataListFieldBuilder() : null;
                    } else {
                        this.condDataListBuilder_.addAllMessages(other.condDataList_);
                    }
                }
                mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TowerLevelStarCondNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = TowerLevelStarCondNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TowerLevelStarCondNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TowerLevelStarCondNotifyOuterClass.TowerLevelStarCondNotifyOrBuilder
            public int getFloorId() {
                return this.floorId_;
            }

            public Builder setFloorId(int value) {
                this.floorId_ = value;
                onChanged();
                return this;
            }

            public Builder clearFloorId() {
                this.floorId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerLevelStarCondNotifyOuterClass.TowerLevelStarCondNotifyOrBuilder
            public int getLevelIndex() {
                return this.levelIndex_;
            }

            public Builder setLevelIndex(int value) {
                this.levelIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevelIndex() {
                this.levelIndex_ = 0;
                onChanged();
                return this;
            }

            private void ensureCondDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.condDataList_ = new ArrayList(this.condDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TowerLevelStarCondNotifyOuterClass.TowerLevelStarCondNotifyOrBuilder
            public List<TowerLevelStarCondDataOuterClass.TowerLevelStarCondData> getCondDataListList() {
                if (this.condDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.condDataList_);
                }
                return this.condDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.TowerLevelStarCondNotifyOuterClass.TowerLevelStarCondNotifyOrBuilder
            public int getCondDataListCount() {
                if (this.condDataListBuilder_ == null) {
                    return this.condDataList_.size();
                }
                return this.condDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.TowerLevelStarCondNotifyOuterClass.TowerLevelStarCondNotifyOrBuilder
            public TowerLevelStarCondDataOuterClass.TowerLevelStarCondData getCondDataList(int index) {
                if (this.condDataListBuilder_ == null) {
                    return this.condDataList_.get(index);
                }
                return this.condDataListBuilder_.getMessage(index);
            }

            public Builder setCondDataList(int index, TowerLevelStarCondDataOuterClass.TowerLevelStarCondData value) {
                if (this.condDataListBuilder_ != null) {
                    this.condDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCondDataListIsMutable();
                    this.condDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setCondDataList(int index, TowerLevelStarCondDataOuterClass.TowerLevelStarCondData.Builder builderForValue) {
                if (this.condDataListBuilder_ == null) {
                    ensureCondDataListIsMutable();
                    this.condDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.condDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addCondDataList(TowerLevelStarCondDataOuterClass.TowerLevelStarCondData value) {
                if (this.condDataListBuilder_ != null) {
                    this.condDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCondDataListIsMutable();
                    this.condDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addCondDataList(int index, TowerLevelStarCondDataOuterClass.TowerLevelStarCondData value) {
                if (this.condDataListBuilder_ != null) {
                    this.condDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCondDataListIsMutable();
                    this.condDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addCondDataList(TowerLevelStarCondDataOuterClass.TowerLevelStarCondData.Builder builderForValue) {
                if (this.condDataListBuilder_ == null) {
                    ensureCondDataListIsMutable();
                    this.condDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.condDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addCondDataList(int index, TowerLevelStarCondDataOuterClass.TowerLevelStarCondData.Builder builderForValue) {
                if (this.condDataListBuilder_ == null) {
                    ensureCondDataListIsMutable();
                    this.condDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.condDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllCondDataList(Iterable<? extends TowerLevelStarCondDataOuterClass.TowerLevelStarCondData> values) {
                if (this.condDataListBuilder_ == null) {
                    ensureCondDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.condDataList_);
                    onChanged();
                } else {
                    this.condDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearCondDataList() {
                if (this.condDataListBuilder_ == null) {
                    this.condDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.condDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeCondDataList(int index) {
                if (this.condDataListBuilder_ == null) {
                    ensureCondDataListIsMutable();
                    this.condDataList_.remove(index);
                    onChanged();
                } else {
                    this.condDataListBuilder_.remove(index);
                }
                return this;
            }

            public TowerLevelStarCondDataOuterClass.TowerLevelStarCondData.Builder getCondDataListBuilder(int index) {
                return getCondDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TowerLevelStarCondNotifyOuterClass.TowerLevelStarCondNotifyOrBuilder
            public TowerLevelStarCondDataOuterClass.TowerLevelStarCondDataOrBuilder getCondDataListOrBuilder(int index) {
                if (this.condDataListBuilder_ == null) {
                    return this.condDataList_.get(index);
                }
                return this.condDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TowerLevelStarCondNotifyOuterClass.TowerLevelStarCondNotifyOrBuilder
            public List<? extends TowerLevelStarCondDataOuterClass.TowerLevelStarCondDataOrBuilder> getCondDataListOrBuilderList() {
                if (this.condDataListBuilder_ != null) {
                    return this.condDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.condDataList_);
            }

            public TowerLevelStarCondDataOuterClass.TowerLevelStarCondData.Builder addCondDataListBuilder() {
                return getCondDataListFieldBuilder().addBuilder(TowerLevelStarCondDataOuterClass.TowerLevelStarCondData.getDefaultInstance());
            }

            public TowerLevelStarCondDataOuterClass.TowerLevelStarCondData.Builder addCondDataListBuilder(int index) {
                return getCondDataListFieldBuilder().addBuilder(index, TowerLevelStarCondDataOuterClass.TowerLevelStarCondData.getDefaultInstance());
            }

            public List<TowerLevelStarCondDataOuterClass.TowerLevelStarCondData.Builder> getCondDataListBuilderList() {
                return getCondDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<TowerLevelStarCondDataOuterClass.TowerLevelStarCondData, TowerLevelStarCondDataOuterClass.TowerLevelStarCondData.Builder, TowerLevelStarCondDataOuterClass.TowerLevelStarCondDataOrBuilder> getCondDataListFieldBuilder() {
                if (this.condDataListBuilder_ == null) {
                    this.condDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.condDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.condDataList_ = null;
                }
                return this.condDataListBuilder_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static TowerLevelStarCondNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TowerLevelStarCondNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TowerLevelStarCondNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TowerLevelStarCondNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        TowerLevelStarCondDataOuterClass.getDescriptor();
    }
}
