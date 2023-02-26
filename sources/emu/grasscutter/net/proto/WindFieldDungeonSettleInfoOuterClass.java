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
import emu.grasscutter.net.proto.WindFieldDungeonFailReasonOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindFieldDungeonSettleInfoOuterClass.class */
public final class WindFieldDungeonSettleInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n WindFieldDungeonSettleInfo.proto\u001a WindFieldDungeonFailReason.proto\"\u0001\n\u001aWindFieldDungeonSettleInfo\u0012\u001b\n\u0013Unk3300_EMCOILGACOC\u0018\u0006 \u0003(\r\u0012/\n\nfailReason\u0018\f \u0001(\u000e2\u001b.WindFieldDungeonFailReason\u0012\u001b\n\u0013Unk3300_FJGFOJBGBKM\u0018\u0003 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{WindFieldDungeonFailReasonOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WindFieldDungeonSettleInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WindFieldDungeonSettleInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WindFieldDungeonSettleInfo_descriptor, new String[]{"Unk3300EMCOILGACOC", "FailReason", "Unk3300FJGFOJBGBKM"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindFieldDungeonSettleInfoOuterClass$WindFieldDungeonSettleInfoOrBuilder.class */
    public interface WindFieldDungeonSettleInfoOrBuilder extends MessageOrBuilder {
        List<Integer> getUnk3300EMCOILGACOCList();

        int getUnk3300EMCOILGACOCCount();

        int getUnk3300EMCOILGACOC(int i);

        int getFailReasonValue();

        WindFieldDungeonFailReasonOuterClass.WindFieldDungeonFailReason getFailReason();

        List<Integer> getUnk3300FJGFOJBGBKMList();

        int getUnk3300FJGFOJBGBKMCount();

        int getUnk3300FJGFOJBGBKM(int i);
    }

    private WindFieldDungeonSettleInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindFieldDungeonSettleInfoOuterClass$WindFieldDungeonSettleInfo.class */
    public static final class WindFieldDungeonSettleInfo extends GeneratedMessageV3 implements WindFieldDungeonSettleInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_EMCOILGACOC_FIELD_NUMBER = 6;
        private Internal.IntList unk3300EMCOILGACOC_;
        private int unk3300EMCOILGACOCMemoizedSerializedSize;
        public static final int FAILREASON_FIELD_NUMBER = 12;
        private int failReason_;
        public static final int UNK3300_FJGFOJBGBKM_FIELD_NUMBER = 3;
        private Internal.IntList unk3300FJGFOJBGBKM_;
        private int unk3300FJGFOJBGBKMMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final WindFieldDungeonSettleInfo DEFAULT_INSTANCE = new WindFieldDungeonSettleInfo();
        private static final Parser<WindFieldDungeonSettleInfo> PARSER = new AbstractParser<WindFieldDungeonSettleInfo>() { // from class: emu.grasscutter.net.proto.WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfo.1
            @Override // com.google.protobuf.Parser
            public WindFieldDungeonSettleInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WindFieldDungeonSettleInfo(input, extensionRegistry);
            }
        };

        private WindFieldDungeonSettleInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unk3300EMCOILGACOCMemoizedSerializedSize = -1;
            this.unk3300FJGFOJBGBKMMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private WindFieldDungeonSettleInfo() {
            this.unk3300EMCOILGACOCMemoizedSerializedSize = -1;
            this.unk3300FJGFOJBGBKMMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.unk3300EMCOILGACOC_ = emptyIntList();
            this.failReason_ = 0;
            this.unk3300FJGFOJBGBKM_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WindFieldDungeonSettleInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x0153 */
        private WindFieldDungeonSettleInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.unk3300FJGFOJBGBKM_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.unk3300FJGFOJBGBKM_.addInt(input.readUInt32());
                                break;
                            case 26:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300FJGFOJBGBKM_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300FJGFOJBGBKM_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 48:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.unk3300EMCOILGACOC_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.unk3300EMCOILGACOC_.addInt(input.readUInt32());
                                break;
                            case 50:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300EMCOILGACOC_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300EMCOILGACOC_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 96:
                                this.failReason_ = input.readEnum();
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
                    this.unk3300FJGFOJBGBKM_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.unk3300EMCOILGACOC_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WindFieldDungeonSettleInfoOuterClass.internal_static_WindFieldDungeonSettleInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WindFieldDungeonSettleInfoOuterClass.internal_static_WindFieldDungeonSettleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WindFieldDungeonSettleInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfoOrBuilder
        public List<Integer> getUnk3300EMCOILGACOCList() {
            return this.unk3300EMCOILGACOC_;
        }

        @Override // emu.grasscutter.net.proto.WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfoOrBuilder
        public int getUnk3300EMCOILGACOCCount() {
            return this.unk3300EMCOILGACOC_.size();
        }

        @Override // emu.grasscutter.net.proto.WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfoOrBuilder
        public int getUnk3300EMCOILGACOC(int index) {
            return this.unk3300EMCOILGACOC_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfoOrBuilder
        public int getFailReasonValue() {
            return this.failReason_;
        }

        @Override // emu.grasscutter.net.proto.WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfoOrBuilder
        public WindFieldDungeonFailReasonOuterClass.WindFieldDungeonFailReason getFailReason() {
            WindFieldDungeonFailReasonOuterClass.WindFieldDungeonFailReason result = WindFieldDungeonFailReasonOuterClass.WindFieldDungeonFailReason.valueOf(this.failReason_);
            return result == null ? WindFieldDungeonFailReasonOuterClass.WindFieldDungeonFailReason.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfoOrBuilder
        public List<Integer> getUnk3300FJGFOJBGBKMList() {
            return this.unk3300FJGFOJBGBKM_;
        }

        @Override // emu.grasscutter.net.proto.WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfoOrBuilder
        public int getUnk3300FJGFOJBGBKMCount() {
            return this.unk3300FJGFOJBGBKM_.size();
        }

        @Override // emu.grasscutter.net.proto.WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfoOrBuilder
        public int getUnk3300FJGFOJBGBKM(int index) {
            return this.unk3300FJGFOJBGBKM_.getInt(index);
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
            if (getUnk3300FJGFOJBGBKMList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.unk3300FJGFOJBGBKMMemoizedSerializedSize);
            }
            for (int i = 0; i < this.unk3300FJGFOJBGBKM_.size(); i++) {
                output.writeUInt32NoTag(this.unk3300FJGFOJBGBKM_.getInt(i));
            }
            if (getUnk3300EMCOILGACOCList().size() > 0) {
                output.writeUInt32NoTag(50);
                output.writeUInt32NoTag(this.unk3300EMCOILGACOCMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.unk3300EMCOILGACOC_.size(); i2++) {
                output.writeUInt32NoTag(this.unk3300EMCOILGACOC_.getInt(i2));
            }
            if (this.failReason_ != WindFieldDungeonFailReasonOuterClass.WindFieldDungeonFailReason.WIND_FIELD_DUNGEON_FAIL_REASON_NONE.getNumber()) {
                output.writeEnum(12, this.failReason_);
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.unk3300FJGFOJBGBKM_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300FJGFOJBGBKM_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getUnk3300FJGFOJBGBKMList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.unk3300FJGFOJBGBKMMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.unk3300EMCOILGACOC_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300EMCOILGACOC_.getInt(i2));
            }
            int size3 = size2 + dataSize2;
            if (!getUnk3300EMCOILGACOCList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unk3300EMCOILGACOCMemoizedSerializedSize = dataSize2;
            if (this.failReason_ != WindFieldDungeonFailReasonOuterClass.WindFieldDungeonFailReason.WIND_FIELD_DUNGEON_FAIL_REASON_NONE.getNumber()) {
                size3 += CodedOutputStream.computeEnumSize(12, this.failReason_);
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
            if (!(obj instanceof WindFieldDungeonSettleInfo)) {
                return equals(obj);
            }
            WindFieldDungeonSettleInfo other = (WindFieldDungeonSettleInfo) obj;
            return getUnk3300EMCOILGACOCList().equals(other.getUnk3300EMCOILGACOCList()) && this.failReason_ == other.failReason_ && getUnk3300FJGFOJBGBKMList().equals(other.getUnk3300FJGFOJBGBKMList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getUnk3300EMCOILGACOCCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getUnk3300EMCOILGACOCList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 12)) + this.failReason_;
            if (getUnk3300FJGFOJBGBKMCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 3)) + getUnk3300FJGFOJBGBKMList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static WindFieldDungeonSettleInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WindFieldDungeonSettleInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WindFieldDungeonSettleInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WindFieldDungeonSettleInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WindFieldDungeonSettleInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WindFieldDungeonSettleInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WindFieldDungeonSettleInfo parseFrom(InputStream input) throws IOException {
            return (WindFieldDungeonSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WindFieldDungeonSettleInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WindFieldDungeonSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WindFieldDungeonSettleInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (WindFieldDungeonSettleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WindFieldDungeonSettleInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WindFieldDungeonSettleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WindFieldDungeonSettleInfo parseFrom(CodedInputStream input) throws IOException {
            return (WindFieldDungeonSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WindFieldDungeonSettleInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WindFieldDungeonSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WindFieldDungeonSettleInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindFieldDungeonSettleInfoOuterClass$WindFieldDungeonSettleInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WindFieldDungeonSettleInfoOrBuilder {
            private int bitField0_;
            private Internal.IntList unk3300EMCOILGACOC_ = WindFieldDungeonSettleInfo.emptyIntList();
            private int failReason_ = 0;
            private Internal.IntList unk3300FJGFOJBGBKM_ = WindFieldDungeonSettleInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return WindFieldDungeonSettleInfoOuterClass.internal_static_WindFieldDungeonSettleInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WindFieldDungeonSettleInfoOuterClass.internal_static_WindFieldDungeonSettleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WindFieldDungeonSettleInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WindFieldDungeonSettleInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300EMCOILGACOC_ = WindFieldDungeonSettleInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.failReason_ = 0;
                this.unk3300FJGFOJBGBKM_ = WindFieldDungeonSettleInfo.emptyIntList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WindFieldDungeonSettleInfoOuterClass.internal_static_WindFieldDungeonSettleInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WindFieldDungeonSettleInfo getDefaultInstanceForType() {
                return WindFieldDungeonSettleInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WindFieldDungeonSettleInfo build() {
                WindFieldDungeonSettleInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WindFieldDungeonSettleInfo buildPartial() {
                WindFieldDungeonSettleInfo result = new WindFieldDungeonSettleInfo(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.unk3300EMCOILGACOC_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.unk3300EMCOILGACOC_ = this.unk3300EMCOILGACOC_;
                result.failReason_ = this.failReason_;
                if ((this.bitField0_ & 2) != 0) {
                    this.unk3300FJGFOJBGBKM_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.unk3300FJGFOJBGBKM_ = this.unk3300FJGFOJBGBKM_;
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
                if (other instanceof WindFieldDungeonSettleInfo) {
                    return mergeFrom((WindFieldDungeonSettleInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WindFieldDungeonSettleInfo other) {
                if (other == WindFieldDungeonSettleInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.unk3300EMCOILGACOC_.isEmpty()) {
                    if (this.unk3300EMCOILGACOC_.isEmpty()) {
                        this.unk3300EMCOILGACOC_ = other.unk3300EMCOILGACOC_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUnk3300EMCOILGACOCIsMutable();
                        this.unk3300EMCOILGACOC_.addAll(other.unk3300EMCOILGACOC_);
                    }
                    onChanged();
                }
                if (other.failReason_ != 0) {
                    setFailReasonValue(other.getFailReasonValue());
                }
                if (!other.unk3300FJGFOJBGBKM_.isEmpty()) {
                    if (this.unk3300FJGFOJBGBKM_.isEmpty()) {
                        this.unk3300FJGFOJBGBKM_ = other.unk3300FJGFOJBGBKM_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureUnk3300FJGFOJBGBKMIsMutable();
                        this.unk3300FJGFOJBGBKM_.addAll(other.unk3300FJGFOJBGBKM_);
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
                WindFieldDungeonSettleInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = WindFieldDungeonSettleInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WindFieldDungeonSettleInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureUnk3300EMCOILGACOCIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unk3300EMCOILGACOC_ = WindFieldDungeonSettleInfo.mutableCopy(this.unk3300EMCOILGACOC_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfoOrBuilder
            public List<Integer> getUnk3300EMCOILGACOCList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.unk3300EMCOILGACOC_) : this.unk3300EMCOILGACOC_;
            }

            @Override // emu.grasscutter.net.proto.WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfoOrBuilder
            public int getUnk3300EMCOILGACOCCount() {
                return this.unk3300EMCOILGACOC_.size();
            }

            @Override // emu.grasscutter.net.proto.WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfoOrBuilder
            public int getUnk3300EMCOILGACOC(int index) {
                return this.unk3300EMCOILGACOC_.getInt(index);
            }

            public Builder setUnk3300EMCOILGACOC(int index, int value) {
                ensureUnk3300EMCOILGACOCIsMutable();
                this.unk3300EMCOILGACOC_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300EMCOILGACOC(int value) {
                ensureUnk3300EMCOILGACOCIsMutable();
                this.unk3300EMCOILGACOC_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300EMCOILGACOC(Iterable<? extends Integer> values) {
                ensureUnk3300EMCOILGACOCIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300EMCOILGACOC_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300EMCOILGACOC() {
                this.unk3300EMCOILGACOC_ = WindFieldDungeonSettleInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfoOrBuilder
            public int getFailReasonValue() {
                return this.failReason_;
            }

            public Builder setFailReasonValue(int value) {
                this.failReason_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfoOrBuilder
            public WindFieldDungeonFailReasonOuterClass.WindFieldDungeonFailReason getFailReason() {
                WindFieldDungeonFailReasonOuterClass.WindFieldDungeonFailReason result = WindFieldDungeonFailReasonOuterClass.WindFieldDungeonFailReason.valueOf(this.failReason_);
                return result == null ? WindFieldDungeonFailReasonOuterClass.WindFieldDungeonFailReason.UNRECOGNIZED : result;
            }

            public Builder setFailReason(WindFieldDungeonFailReasonOuterClass.WindFieldDungeonFailReason value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.failReason_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearFailReason() {
                this.failReason_ = 0;
                onChanged();
                return this;
            }

            private void ensureUnk3300FJGFOJBGBKMIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unk3300FJGFOJBGBKM_ = WindFieldDungeonSettleInfo.mutableCopy(this.unk3300FJGFOJBGBKM_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfoOrBuilder
            public List<Integer> getUnk3300FJGFOJBGBKMList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.unk3300FJGFOJBGBKM_) : this.unk3300FJGFOJBGBKM_;
            }

            @Override // emu.grasscutter.net.proto.WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfoOrBuilder
            public int getUnk3300FJGFOJBGBKMCount() {
                return this.unk3300FJGFOJBGBKM_.size();
            }

            @Override // emu.grasscutter.net.proto.WindFieldDungeonSettleInfoOuterClass.WindFieldDungeonSettleInfoOrBuilder
            public int getUnk3300FJGFOJBGBKM(int index) {
                return this.unk3300FJGFOJBGBKM_.getInt(index);
            }

            public Builder setUnk3300FJGFOJBGBKM(int index, int value) {
                ensureUnk3300FJGFOJBGBKMIsMutable();
                this.unk3300FJGFOJBGBKM_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300FJGFOJBGBKM(int value) {
                ensureUnk3300FJGFOJBGBKMIsMutable();
                this.unk3300FJGFOJBGBKM_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300FJGFOJBGBKM(Iterable<? extends Integer> values) {
                ensureUnk3300FJGFOJBGBKMIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300FJGFOJBGBKM_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300FJGFOJBGBKM() {
                this.unk3300FJGFOJBGBKM_ = WindFieldDungeonSettleInfo.emptyIntList();
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

        public static WindFieldDungeonSettleInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WindFieldDungeonSettleInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WindFieldDungeonSettleInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WindFieldDungeonSettleInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        WindFieldDungeonFailReasonOuterClass.getDescriptor();
    }
}
