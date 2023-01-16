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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.DigMarkPointOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DigActivityDetailInfoOuterClass.class */
public final class DigActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bDigActivityDetailInfo.proto\u001a\u0012DigMarkPoint.proto\"l\n\u0015DigActivityDetailInfo\u0012\u0010\n\bstage_id\u0018\u0003 \u0001(\r\u0012*\n\u0013dig_mark_point_list\u0018\f \u0003(\u000b2\r.DigMarkPoint\u0012\u0015\n\rstage_id_list\u0018\u0005 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{DigMarkPointOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_DigActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DigActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DigActivityDetailInfo_descriptor, new String[]{"StageId", "DigMarkPointList", "StageIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DigActivityDetailInfoOuterClass$DigActivityDetailInfoOrBuilder.class */
    public interface DigActivityDetailInfoOrBuilder extends MessageOrBuilder {
        int getStageId();

        List<DigMarkPointOuterClass.DigMarkPoint> getDigMarkPointListList();

        DigMarkPointOuterClass.DigMarkPoint getDigMarkPointList(int i);

        int getDigMarkPointListCount();

        List<? extends DigMarkPointOuterClass.DigMarkPointOrBuilder> getDigMarkPointListOrBuilderList();

        DigMarkPointOuterClass.DigMarkPointOrBuilder getDigMarkPointListOrBuilder(int i);

        List<Integer> getStageIdListList();

        int getStageIdListCount();

        int getStageIdList(int i);
    }

    private DigActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DigActivityDetailInfoOuterClass$DigActivityDetailInfo.class */
    public static final class DigActivityDetailInfo extends GeneratedMessageV3 implements DigActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STAGE_ID_FIELD_NUMBER = 3;
        private int stageId_;
        public static final int DIG_MARK_POINT_LIST_FIELD_NUMBER = 12;
        private List<DigMarkPointOuterClass.DigMarkPoint> digMarkPointList_;
        public static final int STAGE_ID_LIST_FIELD_NUMBER = 5;
        private Internal.IntList stageIdList_;
        private int stageIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final DigActivityDetailInfo DEFAULT_INSTANCE = new DigActivityDetailInfo();
        private static final Parser<DigActivityDetailInfo> PARSER = new AbstractParser<DigActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.DigActivityDetailInfoOuterClass.DigActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public DigActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DigActivityDetailInfo(input, extensionRegistry);
            }
        };

        private DigActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.stageIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private DigActivityDetailInfo() {
            this.stageIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.digMarkPointList_ = Collections.emptyList();
            this.stageIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DigActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:70:0x010d */
        private DigActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.stageId_ = input.readUInt32();
                                break;
                            case 40:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.stageIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.stageIdList_.addInt(input.readUInt32());
                                break;
                            case 42:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.stageIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.stageIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 98:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.digMarkPointList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.digMarkPointList_.add((DigMarkPointOuterClass.DigMarkPoint) input.readMessage(DigMarkPointOuterClass.DigMarkPoint.parser(), extensionRegistry));
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                        done = done;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 2) != 0) {
                    this.stageIdList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.digMarkPointList_ = Collections.unmodifiableList(this.digMarkPointList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DigActivityDetailInfoOuterClass.internal_static_DigActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DigActivityDetailInfoOuterClass.internal_static_DigActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DigActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder
        public List<DigMarkPointOuterClass.DigMarkPoint> getDigMarkPointListList() {
            return this.digMarkPointList_;
        }

        @Override // emu.grasscutter.net.proto.DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder
        public List<? extends DigMarkPointOuterClass.DigMarkPointOrBuilder> getDigMarkPointListOrBuilderList() {
            return this.digMarkPointList_;
        }

        @Override // emu.grasscutter.net.proto.DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder
        public int getDigMarkPointListCount() {
            return this.digMarkPointList_.size();
        }

        @Override // emu.grasscutter.net.proto.DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder
        public DigMarkPointOuterClass.DigMarkPoint getDigMarkPointList(int index) {
            return this.digMarkPointList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder
        public DigMarkPointOuterClass.DigMarkPointOrBuilder getDigMarkPointListOrBuilder(int index) {
            return this.digMarkPointList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder
        public List<Integer> getStageIdListList() {
            return this.stageIdList_;
        }

        @Override // emu.grasscutter.net.proto.DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder
        public int getStageIdListCount() {
            return this.stageIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder
        public int getStageIdList(int index) {
            return this.stageIdList_.getInt(index);
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
            getSerializedSize();
            if (this.stageId_ != 0) {
                output.writeUInt32(3, this.stageId_);
            }
            if (getStageIdListList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.stageIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.stageIdList_.size(); i++) {
                output.writeUInt32NoTag(this.stageIdList_.getInt(i));
            }
            for (int i2 = 0; i2 < this.digMarkPointList_.size(); i2++) {
                output.writeMessage(12, this.digMarkPointList_.get(i2));
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
            if (this.stageId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.stageId_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.stageIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.stageIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getStageIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.stageIdListMemoizedSerializedSize = dataSize;
            for (int i2 = 0; i2 < this.digMarkPointList_.size(); i2++) {
                size3 += CodedOutputStream.computeMessageSize(12, this.digMarkPointList_.get(i2));
            }
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DigActivityDetailInfo)) {
                return equals(obj);
            }
            DigActivityDetailInfo other = (DigActivityDetailInfo) obj;
            return getStageId() == other.getStageId() && getDigMarkPointListList().equals(other.getDigMarkPointListList()) && getStageIdListList().equals(other.getStageIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getStageId();
            if (getDigMarkPointListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getDigMarkPointListList().hashCode();
            }
            if (getStageIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getStageIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DigActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DigActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DigActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DigActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DigActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DigActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DigActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (DigActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DigActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DigActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DigActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (DigActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DigActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DigActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DigActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (DigActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DigActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DigActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DigActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DigActivityDetailInfoOuterClass$DigActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DigActivityDetailInfoOrBuilder {
            private int bitField0_;
            private int stageId_;
            private RepeatedFieldBuilderV3<DigMarkPointOuterClass.DigMarkPoint, DigMarkPointOuterClass.DigMarkPoint.Builder, DigMarkPointOuterClass.DigMarkPointOrBuilder> digMarkPointListBuilder_;
            private List<DigMarkPointOuterClass.DigMarkPoint> digMarkPointList_ = Collections.emptyList();
            private Internal.IntList stageIdList_ = DigActivityDetailInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return DigActivityDetailInfoOuterClass.internal_static_DigActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DigActivityDetailInfoOuterClass.internal_static_DigActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DigActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DigActivityDetailInfo.alwaysUseFieldBuilders) {
                    getDigMarkPointListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.stageId_ = 0;
                if (this.digMarkPointListBuilder_ == null) {
                    this.digMarkPointList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.digMarkPointListBuilder_.clear();
                }
                this.stageIdList_ = DigActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DigActivityDetailInfoOuterClass.internal_static_DigActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DigActivityDetailInfo getDefaultInstanceForType() {
                return DigActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DigActivityDetailInfo build() {
                DigActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DigActivityDetailInfo buildPartial() {
                DigActivityDetailInfo result = new DigActivityDetailInfo(this);
                int i = this.bitField0_;
                result.stageId_ = this.stageId_;
                if (this.digMarkPointListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.digMarkPointList_ = Collections.unmodifiableList(this.digMarkPointList_);
                        this.bitField0_ &= -2;
                    }
                    result.digMarkPointList_ = this.digMarkPointList_;
                } else {
                    result.digMarkPointList_ = this.digMarkPointListBuilder_.build();
                }
                if ((this.bitField0_ & 2) != 0) {
                    this.stageIdList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.stageIdList_ = this.stageIdList_;
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
                if (other instanceof DigActivityDetailInfo) {
                    return mergeFrom((DigActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DigActivityDetailInfo other) {
                if (other == DigActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (this.digMarkPointListBuilder_ == null) {
                    if (!other.digMarkPointList_.isEmpty()) {
                        if (this.digMarkPointList_.isEmpty()) {
                            this.digMarkPointList_ = other.digMarkPointList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDigMarkPointListIsMutable();
                            this.digMarkPointList_.addAll(other.digMarkPointList_);
                        }
                        onChanged();
                    }
                } else if (!other.digMarkPointList_.isEmpty()) {
                    if (this.digMarkPointListBuilder_.isEmpty()) {
                        this.digMarkPointListBuilder_.dispose();
                        this.digMarkPointListBuilder_ = null;
                        this.digMarkPointList_ = other.digMarkPointList_;
                        this.bitField0_ &= -2;
                        this.digMarkPointListBuilder_ = DigActivityDetailInfo.alwaysUseFieldBuilders ? getDigMarkPointListFieldBuilder() : null;
                    } else {
                        this.digMarkPointListBuilder_.addAllMessages(other.digMarkPointList_);
                    }
                }
                if (!other.stageIdList_.isEmpty()) {
                    if (this.stageIdList_.isEmpty()) {
                        this.stageIdList_ = other.stageIdList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureStageIdListIsMutable();
                        this.stageIdList_.addAll(other.stageIdList_);
                    }
                    onChanged();
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
                DigActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = DigActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DigActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder
            public int getStageId() {
                return this.stageId_;
            }

            public Builder setStageId(int value) {
                this.stageId_ = value;
                onChanged();
                return this;
            }

            public Builder clearStageId() {
                this.stageId_ = 0;
                onChanged();
                return this;
            }

            private void ensureDigMarkPointListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.digMarkPointList_ = new ArrayList(this.digMarkPointList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder
            public List<DigMarkPointOuterClass.DigMarkPoint> getDigMarkPointListList() {
                if (this.digMarkPointListBuilder_ == null) {
                    return Collections.unmodifiableList(this.digMarkPointList_);
                }
                return this.digMarkPointListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder
            public int getDigMarkPointListCount() {
                if (this.digMarkPointListBuilder_ == null) {
                    return this.digMarkPointList_.size();
                }
                return this.digMarkPointListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder
            public DigMarkPointOuterClass.DigMarkPoint getDigMarkPointList(int index) {
                if (this.digMarkPointListBuilder_ == null) {
                    return this.digMarkPointList_.get(index);
                }
                return this.digMarkPointListBuilder_.getMessage(index);
            }

            public Builder setDigMarkPointList(int index, DigMarkPointOuterClass.DigMarkPoint value) {
                if (this.digMarkPointListBuilder_ != null) {
                    this.digMarkPointListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDigMarkPointListIsMutable();
                    this.digMarkPointList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDigMarkPointList(int index, DigMarkPointOuterClass.DigMarkPoint.Builder builderForValue) {
                if (this.digMarkPointListBuilder_ == null) {
                    ensureDigMarkPointListIsMutable();
                    this.digMarkPointList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.digMarkPointListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDigMarkPointList(DigMarkPointOuterClass.DigMarkPoint value) {
                if (this.digMarkPointListBuilder_ != null) {
                    this.digMarkPointListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDigMarkPointListIsMutable();
                    this.digMarkPointList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDigMarkPointList(int index, DigMarkPointOuterClass.DigMarkPoint value) {
                if (this.digMarkPointListBuilder_ != null) {
                    this.digMarkPointListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDigMarkPointListIsMutable();
                    this.digMarkPointList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDigMarkPointList(DigMarkPointOuterClass.DigMarkPoint.Builder builderForValue) {
                if (this.digMarkPointListBuilder_ == null) {
                    ensureDigMarkPointListIsMutable();
                    this.digMarkPointList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.digMarkPointListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDigMarkPointList(int index, DigMarkPointOuterClass.DigMarkPoint.Builder builderForValue) {
                if (this.digMarkPointListBuilder_ == null) {
                    ensureDigMarkPointListIsMutable();
                    this.digMarkPointList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.digMarkPointListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDigMarkPointList(Iterable<? extends DigMarkPointOuterClass.DigMarkPoint> values) {
                if (this.digMarkPointListBuilder_ == null) {
                    ensureDigMarkPointListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.digMarkPointList_);
                    onChanged();
                } else {
                    this.digMarkPointListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDigMarkPointList() {
                if (this.digMarkPointListBuilder_ == null) {
                    this.digMarkPointList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.digMarkPointListBuilder_.clear();
                }
                return this;
            }

            public Builder removeDigMarkPointList(int index) {
                if (this.digMarkPointListBuilder_ == null) {
                    ensureDigMarkPointListIsMutable();
                    this.digMarkPointList_.remove(index);
                    onChanged();
                } else {
                    this.digMarkPointListBuilder_.remove(index);
                }
                return this;
            }

            public DigMarkPointOuterClass.DigMarkPoint.Builder getDigMarkPointListBuilder(int index) {
                return getDigMarkPointListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder
            public DigMarkPointOuterClass.DigMarkPointOrBuilder getDigMarkPointListOrBuilder(int index) {
                if (this.digMarkPointListBuilder_ == null) {
                    return this.digMarkPointList_.get(index);
                }
                return this.digMarkPointListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder
            public List<? extends DigMarkPointOuterClass.DigMarkPointOrBuilder> getDigMarkPointListOrBuilderList() {
                if (this.digMarkPointListBuilder_ != null) {
                    return this.digMarkPointListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.digMarkPointList_);
            }

            public DigMarkPointOuterClass.DigMarkPoint.Builder addDigMarkPointListBuilder() {
                return getDigMarkPointListFieldBuilder().addBuilder(DigMarkPointOuterClass.DigMarkPoint.getDefaultInstance());
            }

            public DigMarkPointOuterClass.DigMarkPoint.Builder addDigMarkPointListBuilder(int index) {
                return getDigMarkPointListFieldBuilder().addBuilder(index, DigMarkPointOuterClass.DigMarkPoint.getDefaultInstance());
            }

            public List<DigMarkPointOuterClass.DigMarkPoint.Builder> getDigMarkPointListBuilderList() {
                return getDigMarkPointListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<DigMarkPointOuterClass.DigMarkPoint, DigMarkPointOuterClass.DigMarkPoint.Builder, DigMarkPointOuterClass.DigMarkPointOrBuilder> getDigMarkPointListFieldBuilder() {
                if (this.digMarkPointListBuilder_ == null) {
                    this.digMarkPointListBuilder_ = new RepeatedFieldBuilderV3<>(this.digMarkPointList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.digMarkPointList_ = null;
                }
                return this.digMarkPointListBuilder_;
            }

            private void ensureStageIdListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.stageIdList_ = DigActivityDetailInfo.mutableCopy(this.stageIdList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder
            public List<Integer> getStageIdListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.stageIdList_) : this.stageIdList_;
            }

            @Override // emu.grasscutter.net.proto.DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder
            public int getStageIdListCount() {
                return this.stageIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder
            public int getStageIdList(int index) {
                return this.stageIdList_.getInt(index);
            }

            public Builder setStageIdList(int index, int value) {
                ensureStageIdListIsMutable();
                this.stageIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addStageIdList(int value) {
                ensureStageIdListIsMutable();
                this.stageIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllStageIdList(Iterable<? extends Integer> values) {
                ensureStageIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.stageIdList_);
                onChanged();
                return this;
            }

            public Builder clearStageIdList() {
                this.stageIdList_ = DigActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
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

        public static DigActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DigActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DigActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DigActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        DigMarkPointOuterClass.getDescriptor();
    }
}
