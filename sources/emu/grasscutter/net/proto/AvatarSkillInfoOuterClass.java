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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSkillInfoOuterClass.class */
public final class AvatarSkillInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015AvatarSkillInfo.proto\"U\n\u000fAvatarSkillInfo\u0012\u0012\n\npassCdTime\u0018\u0001 \u0001(\r\u0012\u0016\n\u000efullCdTimeList\u0018\u0002 \u0003(\r\u0012\u0016\n\u000emaxChargeCount\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AvatarSkillInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarSkillInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarSkillInfo_descriptor, new String[]{"PassCdTime", "FullCdTimeList", "MaxChargeCount"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSkillInfoOuterClass$AvatarSkillInfoOrBuilder.class */
    public interface AvatarSkillInfoOrBuilder extends MessageOrBuilder {
        int getPassCdTime();

        List<Integer> getFullCdTimeListList();

        int getFullCdTimeListCount();

        int getFullCdTimeList(int i);

        int getMaxChargeCount();
    }

    private AvatarSkillInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSkillInfoOuterClass$AvatarSkillInfo.class */
    public static final class AvatarSkillInfo extends GeneratedMessageV3 implements AvatarSkillInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PASSCDTIME_FIELD_NUMBER = 1;
        private int passCdTime_;
        public static final int FULLCDTIMELIST_FIELD_NUMBER = 2;
        private Internal.IntList fullCdTimeList_;
        private int fullCdTimeListMemoizedSerializedSize;
        public static final int MAXCHARGECOUNT_FIELD_NUMBER = 3;
        private int maxChargeCount_;
        private byte memoizedIsInitialized;
        private static final AvatarSkillInfo DEFAULT_INSTANCE = new AvatarSkillInfo();
        private static final Parser<AvatarSkillInfo> PARSER = new AbstractParser<AvatarSkillInfo>() { // from class: emu.grasscutter.net.proto.AvatarSkillInfoOuterClass.AvatarSkillInfo.1
            @Override // com.google.protobuf.Parser
            public AvatarSkillInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarSkillInfo(input, extensionRegistry);
            }
        };

        private AvatarSkillInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.fullCdTimeListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private AvatarSkillInfo() {
            this.fullCdTimeListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.fullCdTimeList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarSkillInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarSkillInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.passCdTime_ = input.readUInt32();
                                break;
                            case 16:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.fullCdTimeList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.fullCdTimeList_.addInt(input.readUInt32());
                                break;
                            case 18:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.fullCdTimeList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.fullCdTimeList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 24:
                                this.maxChargeCount_ = input.readUInt32();
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
                    this.fullCdTimeList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvatarSkillInfoOuterClass.internal_static_AvatarSkillInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarSkillInfoOuterClass.internal_static_AvatarSkillInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarSkillInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillInfoOuterClass.AvatarSkillInfoOrBuilder
        public int getPassCdTime() {
            return this.passCdTime_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillInfoOuterClass.AvatarSkillInfoOrBuilder
        public List<Integer> getFullCdTimeListList() {
            return this.fullCdTimeList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillInfoOuterClass.AvatarSkillInfoOrBuilder
        public int getFullCdTimeListCount() {
            return this.fullCdTimeList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillInfoOuterClass.AvatarSkillInfoOrBuilder
        public int getFullCdTimeList(int index) {
            return this.fullCdTimeList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillInfoOuterClass.AvatarSkillInfoOrBuilder
        public int getMaxChargeCount() {
            return this.maxChargeCount_;
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
            if (this.passCdTime_ != 0) {
                output.writeUInt32(1, this.passCdTime_);
            }
            if (getFullCdTimeListList().size() > 0) {
                output.writeUInt32NoTag(18);
                output.writeUInt32NoTag(this.fullCdTimeListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.fullCdTimeList_.size(); i++) {
                output.writeUInt32NoTag(this.fullCdTimeList_.getInt(i));
            }
            if (this.maxChargeCount_ != 0) {
                output.writeUInt32(3, this.maxChargeCount_);
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
            if (this.passCdTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.passCdTime_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.fullCdTimeList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.fullCdTimeList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getFullCdTimeListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.fullCdTimeListMemoizedSerializedSize = dataSize;
            if (this.maxChargeCount_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(3, this.maxChargeCount_);
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
            if (!(obj instanceof AvatarSkillInfo)) {
                return equals(obj);
            }
            AvatarSkillInfo other = (AvatarSkillInfo) obj;
            return getPassCdTime() == other.getPassCdTime() && getFullCdTimeListList().equals(other.getFullCdTimeListList()) && getMaxChargeCount() == other.getMaxChargeCount() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getPassCdTime();
            if (getFullCdTimeListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getFullCdTimeListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 3)) + getMaxChargeCount())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AvatarSkillInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarSkillInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarSkillInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarSkillInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarSkillInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarSkillInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarSkillInfo parseFrom(InputStream input) throws IOException {
            return (AvatarSkillInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarSkillInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarSkillInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarSkillInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarSkillInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarSkillInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarSkillInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarSkillInfo parseFrom(CodedInputStream input) throws IOException {
            return (AvatarSkillInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarSkillInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarSkillInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarSkillInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSkillInfoOuterClass$AvatarSkillInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarSkillInfoOrBuilder {
            private int bitField0_;
            private int passCdTime_;
            private Internal.IntList fullCdTimeList_ = AvatarSkillInfo.emptyIntList();
            private int maxChargeCount_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarSkillInfoOuterClass.internal_static_AvatarSkillInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarSkillInfoOuterClass.internal_static_AvatarSkillInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarSkillInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarSkillInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.passCdTime_ = 0;
                this.fullCdTimeList_ = AvatarSkillInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.maxChargeCount_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarSkillInfoOuterClass.internal_static_AvatarSkillInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarSkillInfo getDefaultInstanceForType() {
                return AvatarSkillInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarSkillInfo build() {
                AvatarSkillInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarSkillInfo buildPartial() {
                AvatarSkillInfo result = new AvatarSkillInfo(this);
                int i = this.bitField0_;
                result.passCdTime_ = this.passCdTime_;
                if ((this.bitField0_ & 1) != 0) {
                    this.fullCdTimeList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.fullCdTimeList_ = this.fullCdTimeList_;
                result.maxChargeCount_ = this.maxChargeCount_;
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
                if (other instanceof AvatarSkillInfo) {
                    return mergeFrom((AvatarSkillInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarSkillInfo other) {
                if (other == AvatarSkillInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getPassCdTime() != 0) {
                    setPassCdTime(other.getPassCdTime());
                }
                if (!other.fullCdTimeList_.isEmpty()) {
                    if (this.fullCdTimeList_.isEmpty()) {
                        this.fullCdTimeList_ = other.fullCdTimeList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFullCdTimeListIsMutable();
                        this.fullCdTimeList_.addAll(other.fullCdTimeList_);
                    }
                    onChanged();
                }
                if (other.getMaxChargeCount() != 0) {
                    setMaxChargeCount(other.getMaxChargeCount());
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
                AvatarSkillInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarSkillInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarSkillInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillInfoOuterClass.AvatarSkillInfoOrBuilder
            public int getPassCdTime() {
                return this.passCdTime_;
            }

            public Builder setPassCdTime(int value) {
                this.passCdTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearPassCdTime() {
                this.passCdTime_ = 0;
                onChanged();
                return this;
            }

            private void ensureFullCdTimeListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.fullCdTimeList_ = AvatarSkillInfo.mutableCopy(this.fullCdTimeList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillInfoOuterClass.AvatarSkillInfoOrBuilder
            public List<Integer> getFullCdTimeListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.fullCdTimeList_) : this.fullCdTimeList_;
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillInfoOuterClass.AvatarSkillInfoOrBuilder
            public int getFullCdTimeListCount() {
                return this.fullCdTimeList_.size();
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillInfoOuterClass.AvatarSkillInfoOrBuilder
            public int getFullCdTimeList(int index) {
                return this.fullCdTimeList_.getInt(index);
            }

            public Builder setFullCdTimeList(int index, int value) {
                ensureFullCdTimeListIsMutable();
                this.fullCdTimeList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addFullCdTimeList(int value) {
                ensureFullCdTimeListIsMutable();
                this.fullCdTimeList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllFullCdTimeList(Iterable<? extends Integer> values) {
                ensureFullCdTimeListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.fullCdTimeList_);
                onChanged();
                return this;
            }

            public Builder clearFullCdTimeList() {
                this.fullCdTimeList_ = AvatarSkillInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillInfoOuterClass.AvatarSkillInfoOrBuilder
            public int getMaxChargeCount() {
                return this.maxChargeCount_;
            }

            public Builder setMaxChargeCount(int value) {
                this.maxChargeCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxChargeCount() {
                this.maxChargeCount_ = 0;
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

        public static AvatarSkillInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarSkillInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarSkillInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarSkillInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
