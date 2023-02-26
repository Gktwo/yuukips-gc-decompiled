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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DeliveryInfoOuterClass.class */
public final class DeliveryInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012DeliveryInfo.proto\"[\n\fDeliveryInfo\u0012\u0010\n\bdayIndex\u0018\u0006 \u0001(\r\u0012\"\n\u001afinishedDeliveryQuestIndex\u0018\u0007 \u0003(\r\u0012\u0015\n\risTakenReward\u0018\u0004 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_DeliveryInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DeliveryInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DeliveryInfo_descriptor, new String[]{"DayIndex", "FinishedDeliveryQuestIndex", "IsTakenReward"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DeliveryInfoOuterClass$DeliveryInfoOrBuilder.class */
    public interface DeliveryInfoOrBuilder extends MessageOrBuilder {
        int getDayIndex();

        List<Integer> getFinishedDeliveryQuestIndexList();

        int getFinishedDeliveryQuestIndexCount();

        int getFinishedDeliveryQuestIndex(int i);

        boolean getIsTakenReward();
    }

    private DeliveryInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DeliveryInfoOuterClass$DeliveryInfo.class */
    public static final class DeliveryInfo extends GeneratedMessageV3 implements DeliveryInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DAYINDEX_FIELD_NUMBER = 6;
        private int dayIndex_;
        public static final int FINISHEDDELIVERYQUESTINDEX_FIELD_NUMBER = 7;
        private Internal.IntList finishedDeliveryQuestIndex_;
        private int finishedDeliveryQuestIndexMemoizedSerializedSize;
        public static final int ISTAKENREWARD_FIELD_NUMBER = 4;
        private boolean isTakenReward_;
        private byte memoizedIsInitialized;
        private static final DeliveryInfo DEFAULT_INSTANCE = new DeliveryInfo();
        private static final Parser<DeliveryInfo> PARSER = new AbstractParser<DeliveryInfo>() { // from class: emu.grasscutter.net.proto.DeliveryInfoOuterClass.DeliveryInfo.1
            @Override // com.google.protobuf.Parser
            public DeliveryInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DeliveryInfo(input, extensionRegistry);
            }
        };

        private DeliveryInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.finishedDeliveryQuestIndexMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private DeliveryInfo() {
            this.finishedDeliveryQuestIndexMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.finishedDeliveryQuestIndex_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DeliveryInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DeliveryInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.isTakenReward_ = input.readBool();
                                break;
                            case 48:
                                this.dayIndex_ = input.readUInt32();
                                break;
                            case 56:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.finishedDeliveryQuestIndex_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.finishedDeliveryQuestIndex_.addInt(input.readUInt32());
                                break;
                            case 58:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.finishedDeliveryQuestIndex_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.finishedDeliveryQuestIndex_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
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
                    this.finishedDeliveryQuestIndex_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DeliveryInfoOuterClass.internal_static_DeliveryInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DeliveryInfoOuterClass.internal_static_DeliveryInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DeliveryInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DeliveryInfoOuterClass.DeliveryInfoOrBuilder
        public int getDayIndex() {
            return this.dayIndex_;
        }

        @Override // emu.grasscutter.net.proto.DeliveryInfoOuterClass.DeliveryInfoOrBuilder
        public List<Integer> getFinishedDeliveryQuestIndexList() {
            return this.finishedDeliveryQuestIndex_;
        }

        @Override // emu.grasscutter.net.proto.DeliveryInfoOuterClass.DeliveryInfoOrBuilder
        public int getFinishedDeliveryQuestIndexCount() {
            return this.finishedDeliveryQuestIndex_.size();
        }

        @Override // emu.grasscutter.net.proto.DeliveryInfoOuterClass.DeliveryInfoOrBuilder
        public int getFinishedDeliveryQuestIndex(int index) {
            return this.finishedDeliveryQuestIndex_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.DeliveryInfoOuterClass.DeliveryInfoOrBuilder
        public boolean getIsTakenReward() {
            return this.isTakenReward_;
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
            if (this.isTakenReward_) {
                output.writeBool(4, this.isTakenReward_);
            }
            if (this.dayIndex_ != 0) {
                output.writeUInt32(6, this.dayIndex_);
            }
            if (getFinishedDeliveryQuestIndexList().size() > 0) {
                output.writeUInt32NoTag(58);
                output.writeUInt32NoTag(this.finishedDeliveryQuestIndexMemoizedSerializedSize);
            }
            for (int i = 0; i < this.finishedDeliveryQuestIndex_.size(); i++) {
                output.writeUInt32NoTag(this.finishedDeliveryQuestIndex_.getInt(i));
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
            if (this.isTakenReward_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(4, this.isTakenReward_);
            }
            if (this.dayIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.dayIndex_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.finishedDeliveryQuestIndex_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.finishedDeliveryQuestIndex_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getFinishedDeliveryQuestIndexList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.finishedDeliveryQuestIndexMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DeliveryInfo)) {
                return equals(obj);
            }
            DeliveryInfo other = (DeliveryInfo) obj;
            return getDayIndex() == other.getDayIndex() && getFinishedDeliveryQuestIndexList().equals(other.getFinishedDeliveryQuestIndexList()) && getIsTakenReward() == other.getIsTakenReward() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getDayIndex();
            if (getFinishedDeliveryQuestIndexCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getFinishedDeliveryQuestIndexList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 4)) + Internal.hashBoolean(getIsTakenReward()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DeliveryInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DeliveryInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DeliveryInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DeliveryInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DeliveryInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DeliveryInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DeliveryInfo parseFrom(InputStream input) throws IOException {
            return (DeliveryInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DeliveryInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DeliveryInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DeliveryInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (DeliveryInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DeliveryInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DeliveryInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DeliveryInfo parseFrom(CodedInputStream input) throws IOException {
            return (DeliveryInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DeliveryInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DeliveryInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DeliveryInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DeliveryInfoOuterClass$DeliveryInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DeliveryInfoOrBuilder {
            private int bitField0_;
            private int dayIndex_;
            private Internal.IntList finishedDeliveryQuestIndex_ = DeliveryInfo.emptyIntList();
            private boolean isTakenReward_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DeliveryInfoOuterClass.internal_static_DeliveryInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DeliveryInfoOuterClass.internal_static_DeliveryInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DeliveryInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DeliveryInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.dayIndex_ = 0;
                this.finishedDeliveryQuestIndex_ = DeliveryInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.isTakenReward_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DeliveryInfoOuterClass.internal_static_DeliveryInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DeliveryInfo getDefaultInstanceForType() {
                return DeliveryInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DeliveryInfo build() {
                DeliveryInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DeliveryInfo buildPartial() {
                DeliveryInfo result = new DeliveryInfo(this);
                int i = this.bitField0_;
                result.dayIndex_ = this.dayIndex_;
                if ((this.bitField0_ & 1) != 0) {
                    this.finishedDeliveryQuestIndex_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.finishedDeliveryQuestIndex_ = this.finishedDeliveryQuestIndex_;
                result.isTakenReward_ = this.isTakenReward_;
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
                if (other instanceof DeliveryInfo) {
                    return mergeFrom((DeliveryInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DeliveryInfo other) {
                if (other == DeliveryInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getDayIndex() != 0) {
                    setDayIndex(other.getDayIndex());
                }
                if (!other.finishedDeliveryQuestIndex_.isEmpty()) {
                    if (this.finishedDeliveryQuestIndex_.isEmpty()) {
                        this.finishedDeliveryQuestIndex_ = other.finishedDeliveryQuestIndex_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFinishedDeliveryQuestIndexIsMutable();
                        this.finishedDeliveryQuestIndex_.addAll(other.finishedDeliveryQuestIndex_);
                    }
                    onChanged();
                }
                if (other.getIsTakenReward()) {
                    setIsTakenReward(other.getIsTakenReward());
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
                DeliveryInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = DeliveryInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DeliveryInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DeliveryInfoOuterClass.DeliveryInfoOrBuilder
            public int getDayIndex() {
                return this.dayIndex_;
            }

            public Builder setDayIndex(int value) {
                this.dayIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearDayIndex() {
                this.dayIndex_ = 0;
                onChanged();
                return this;
            }

            private void ensureFinishedDeliveryQuestIndexIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.finishedDeliveryQuestIndex_ = DeliveryInfo.mutableCopy(this.finishedDeliveryQuestIndex_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.DeliveryInfoOuterClass.DeliveryInfoOrBuilder
            public List<Integer> getFinishedDeliveryQuestIndexList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.finishedDeliveryQuestIndex_) : this.finishedDeliveryQuestIndex_;
            }

            @Override // emu.grasscutter.net.proto.DeliveryInfoOuterClass.DeliveryInfoOrBuilder
            public int getFinishedDeliveryQuestIndexCount() {
                return this.finishedDeliveryQuestIndex_.size();
            }

            @Override // emu.grasscutter.net.proto.DeliveryInfoOuterClass.DeliveryInfoOrBuilder
            public int getFinishedDeliveryQuestIndex(int index) {
                return this.finishedDeliveryQuestIndex_.getInt(index);
            }

            public Builder setFinishedDeliveryQuestIndex(int index, int value) {
                ensureFinishedDeliveryQuestIndexIsMutable();
                this.finishedDeliveryQuestIndex_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addFinishedDeliveryQuestIndex(int value) {
                ensureFinishedDeliveryQuestIndexIsMutable();
                this.finishedDeliveryQuestIndex_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllFinishedDeliveryQuestIndex(Iterable<? extends Integer> values) {
                ensureFinishedDeliveryQuestIndexIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.finishedDeliveryQuestIndex_);
                onChanged();
                return this;
            }

            public Builder clearFinishedDeliveryQuestIndex() {
                this.finishedDeliveryQuestIndex_ = DeliveryInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DeliveryInfoOuterClass.DeliveryInfoOrBuilder
            public boolean getIsTakenReward() {
                return this.isTakenReward_;
            }

            public Builder setIsTakenReward(boolean value) {
                this.isTakenReward_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsTakenReward() {
                this.isTakenReward_ = false;
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

        public static DeliveryInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DeliveryInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DeliveryInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DeliveryInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
