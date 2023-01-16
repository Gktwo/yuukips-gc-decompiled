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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MpPlayRewardInfoOuterClass.class */
public final class MpPlayRewardInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016MpPlayRewardInfo.proto\"T\n\u0010MpPlayRewardInfo\u0012\r\n\u0005resin\u0018\u0001 \u0001(\r\u0012\u0017\n\u000fremain_uid_list\u0018\u0002 \u0003(\r\u0012\u0018\n\u0010qualify_uid_list\u0018\u0003 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_MpPlayRewardInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MpPlayRewardInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MpPlayRewardInfo_descriptor, new String[]{"Resin", "RemainUidList", "QualifyUidList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MpPlayRewardInfoOuterClass$MpPlayRewardInfoOrBuilder.class */
    public interface MpPlayRewardInfoOrBuilder extends MessageOrBuilder {
        int getResin();

        List<Integer> getRemainUidListList();

        int getRemainUidListCount();

        int getRemainUidList(int i);

        List<Integer> getQualifyUidListList();

        int getQualifyUidListCount();

        int getQualifyUidList(int i);
    }

    private MpPlayRewardInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MpPlayRewardInfoOuterClass$MpPlayRewardInfo.class */
    public static final class MpPlayRewardInfo extends GeneratedMessageV3 implements MpPlayRewardInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RESIN_FIELD_NUMBER = 1;
        private int resin_;
        public static final int REMAIN_UID_LIST_FIELD_NUMBER = 2;
        private Internal.IntList remainUidList_;
        private int remainUidListMemoizedSerializedSize;
        public static final int QUALIFY_UID_LIST_FIELD_NUMBER = 3;
        private Internal.IntList qualifyUidList_;
        private int qualifyUidListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final MpPlayRewardInfo DEFAULT_INSTANCE = new MpPlayRewardInfo();
        private static final Parser<MpPlayRewardInfo> PARSER = new AbstractParser<MpPlayRewardInfo>() { // from class: emu.grasscutter.net.proto.MpPlayRewardInfoOuterClass.MpPlayRewardInfo.1
            @Override // com.google.protobuf.Parser
            public MpPlayRewardInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MpPlayRewardInfo(input, extensionRegistry);
            }
        };

        private MpPlayRewardInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.remainUidListMemoizedSerializedSize = -1;
            this.qualifyUidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private MpPlayRewardInfo() {
            this.remainUidListMemoizedSerializedSize = -1;
            this.qualifyUidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.remainUidList_ = emptyIntList();
            this.qualifyUidList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MpPlayRewardInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x014f */
        private MpPlayRewardInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.resin_ = input.readUInt32();
                                break;
                            case 16:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.remainUidList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.remainUidList_.addInt(input.readUInt32());
                                break;
                            case 18:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.remainUidList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.remainUidList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 24:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.qualifyUidList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.qualifyUidList_.addInt(input.readUInt32());
                                break;
                            case 26:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.qualifyUidList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.qualifyUidList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.remainUidList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.qualifyUidList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MpPlayRewardInfoOuterClass.internal_static_MpPlayRewardInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MpPlayRewardInfoOuterClass.internal_static_MpPlayRewardInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MpPlayRewardInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MpPlayRewardInfoOuterClass.MpPlayRewardInfoOrBuilder
        public int getResin() {
            return this.resin_;
        }

        @Override // emu.grasscutter.net.proto.MpPlayRewardInfoOuterClass.MpPlayRewardInfoOrBuilder
        public List<Integer> getRemainUidListList() {
            return this.remainUidList_;
        }

        @Override // emu.grasscutter.net.proto.MpPlayRewardInfoOuterClass.MpPlayRewardInfoOrBuilder
        public int getRemainUidListCount() {
            return this.remainUidList_.size();
        }

        @Override // emu.grasscutter.net.proto.MpPlayRewardInfoOuterClass.MpPlayRewardInfoOrBuilder
        public int getRemainUidList(int index) {
            return this.remainUidList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.MpPlayRewardInfoOuterClass.MpPlayRewardInfoOrBuilder
        public List<Integer> getQualifyUidListList() {
            return this.qualifyUidList_;
        }

        @Override // emu.grasscutter.net.proto.MpPlayRewardInfoOuterClass.MpPlayRewardInfoOrBuilder
        public int getQualifyUidListCount() {
            return this.qualifyUidList_.size();
        }

        @Override // emu.grasscutter.net.proto.MpPlayRewardInfoOuterClass.MpPlayRewardInfoOrBuilder
        public int getQualifyUidList(int index) {
            return this.qualifyUidList_.getInt(index);
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
            if (this.resin_ != 0) {
                output.writeUInt32(1, this.resin_);
            }
            if (getRemainUidListList().size() > 0) {
                output.writeUInt32NoTag(18);
                output.writeUInt32NoTag(this.remainUidListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.remainUidList_.size(); i++) {
                output.writeUInt32NoTag(this.remainUidList_.getInt(i));
            }
            if (getQualifyUidListList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.qualifyUidListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.qualifyUidList_.size(); i2++) {
                output.writeUInt32NoTag(this.qualifyUidList_.getInt(i2));
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
            if (this.resin_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.resin_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.remainUidList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.remainUidList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getRemainUidListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.remainUidListMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.qualifyUidList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.qualifyUidList_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getQualifyUidListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.qualifyUidListMemoizedSerializedSize = dataSize2;
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MpPlayRewardInfo)) {
                return equals(obj);
            }
            MpPlayRewardInfo other = (MpPlayRewardInfo) obj;
            return getResin() == other.getResin() && getRemainUidListList().equals(other.getRemainUidListList()) && getQualifyUidListList().equals(other.getQualifyUidListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getResin();
            if (getRemainUidListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getRemainUidListList().hashCode();
            }
            if (getQualifyUidListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getQualifyUidListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MpPlayRewardInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MpPlayRewardInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MpPlayRewardInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MpPlayRewardInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MpPlayRewardInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MpPlayRewardInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MpPlayRewardInfo parseFrom(InputStream input) throws IOException {
            return (MpPlayRewardInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MpPlayRewardInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MpPlayRewardInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MpPlayRewardInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (MpPlayRewardInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MpPlayRewardInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MpPlayRewardInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MpPlayRewardInfo parseFrom(CodedInputStream input) throws IOException {
            return (MpPlayRewardInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MpPlayRewardInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MpPlayRewardInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MpPlayRewardInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MpPlayRewardInfoOuterClass$MpPlayRewardInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MpPlayRewardInfoOrBuilder {
            private int bitField0_;
            private int resin_;
            private Internal.IntList remainUidList_ = MpPlayRewardInfo.emptyIntList();
            private Internal.IntList qualifyUidList_ = MpPlayRewardInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return MpPlayRewardInfoOuterClass.internal_static_MpPlayRewardInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MpPlayRewardInfoOuterClass.internal_static_MpPlayRewardInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MpPlayRewardInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MpPlayRewardInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.resin_ = 0;
                this.remainUidList_ = MpPlayRewardInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.qualifyUidList_ = MpPlayRewardInfo.emptyIntList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MpPlayRewardInfoOuterClass.internal_static_MpPlayRewardInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MpPlayRewardInfo getDefaultInstanceForType() {
                return MpPlayRewardInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MpPlayRewardInfo build() {
                MpPlayRewardInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MpPlayRewardInfo buildPartial() {
                MpPlayRewardInfo result = new MpPlayRewardInfo(this);
                int i = this.bitField0_;
                result.resin_ = this.resin_;
                if ((this.bitField0_ & 1) != 0) {
                    this.remainUidList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.remainUidList_ = this.remainUidList_;
                if ((this.bitField0_ & 2) != 0) {
                    this.qualifyUidList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.qualifyUidList_ = this.qualifyUidList_;
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
                if (other instanceof MpPlayRewardInfo) {
                    return mergeFrom((MpPlayRewardInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MpPlayRewardInfo other) {
                if (other == MpPlayRewardInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getResin() != 0) {
                    setResin(other.getResin());
                }
                if (!other.remainUidList_.isEmpty()) {
                    if (this.remainUidList_.isEmpty()) {
                        this.remainUidList_ = other.remainUidList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRemainUidListIsMutable();
                        this.remainUidList_.addAll(other.remainUidList_);
                    }
                    onChanged();
                }
                if (!other.qualifyUidList_.isEmpty()) {
                    if (this.qualifyUidList_.isEmpty()) {
                        this.qualifyUidList_ = other.qualifyUidList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureQualifyUidListIsMutable();
                        this.qualifyUidList_.addAll(other.qualifyUidList_);
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
                MpPlayRewardInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = MpPlayRewardInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MpPlayRewardInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MpPlayRewardInfoOuterClass.MpPlayRewardInfoOrBuilder
            public int getResin() {
                return this.resin_;
            }

            public Builder setResin(int value) {
                this.resin_ = value;
                onChanged();
                return this;
            }

            public Builder clearResin() {
                this.resin_ = 0;
                onChanged();
                return this;
            }

            private void ensureRemainUidListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.remainUidList_ = MpPlayRewardInfo.mutableCopy(this.remainUidList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.MpPlayRewardInfoOuterClass.MpPlayRewardInfoOrBuilder
            public List<Integer> getRemainUidListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.remainUidList_) : this.remainUidList_;
            }

            @Override // emu.grasscutter.net.proto.MpPlayRewardInfoOuterClass.MpPlayRewardInfoOrBuilder
            public int getRemainUidListCount() {
                return this.remainUidList_.size();
            }

            @Override // emu.grasscutter.net.proto.MpPlayRewardInfoOuterClass.MpPlayRewardInfoOrBuilder
            public int getRemainUidList(int index) {
                return this.remainUidList_.getInt(index);
            }

            public Builder setRemainUidList(int index, int value) {
                ensureRemainUidListIsMutable();
                this.remainUidList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addRemainUidList(int value) {
                ensureRemainUidListIsMutable();
                this.remainUidList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllRemainUidList(Iterable<? extends Integer> values) {
                ensureRemainUidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.remainUidList_);
                onChanged();
                return this;
            }

            public Builder clearRemainUidList() {
                this.remainUidList_ = MpPlayRewardInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureQualifyUidListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.qualifyUidList_ = MpPlayRewardInfo.mutableCopy(this.qualifyUidList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.MpPlayRewardInfoOuterClass.MpPlayRewardInfoOrBuilder
            public List<Integer> getQualifyUidListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.qualifyUidList_) : this.qualifyUidList_;
            }

            @Override // emu.grasscutter.net.proto.MpPlayRewardInfoOuterClass.MpPlayRewardInfoOrBuilder
            public int getQualifyUidListCount() {
                return this.qualifyUidList_.size();
            }

            @Override // emu.grasscutter.net.proto.MpPlayRewardInfoOuterClass.MpPlayRewardInfoOrBuilder
            public int getQualifyUidList(int index) {
                return this.qualifyUidList_.getInt(index);
            }

            public Builder setQualifyUidList(int index, int value) {
                ensureQualifyUidListIsMutable();
                this.qualifyUidList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addQualifyUidList(int value) {
                ensureQualifyUidListIsMutable();
                this.qualifyUidList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllQualifyUidList(Iterable<? extends Integer> values) {
                ensureQualifyUidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.qualifyUidList_);
                onChanged();
                return this;
            }

            public Builder clearQualifyUidList() {
                this.qualifyUidList_ = MpPlayRewardInfo.emptyIntList();
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

        public static MpPlayRewardInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MpPlayRewardInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MpPlayRewardInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MpPlayRewardInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
