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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FishPoolInfoOuterClass.class */
public final class FishPoolInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012FishPoolInfo.proto\"O\n\fFishPoolInfo\u0012\u000f\n\u0007pool_id\u0018\u0001 \u0001(\r\u0012\u0016\n\u000efish_area_list\u0018\u0002 \u0003(\r\u0012\u0016\n\u000etoday_fish_num\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_FishPoolInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FishPoolInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FishPoolInfo_descriptor, new String[]{"PoolId", "FishAreaList", "TodayFishNum"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FishPoolInfoOuterClass$FishPoolInfoOrBuilder.class */
    public interface FishPoolInfoOrBuilder extends MessageOrBuilder {
        int getPoolId();

        List<Integer> getFishAreaListList();

        int getFishAreaListCount();

        int getFishAreaList(int i);

        int getTodayFishNum();
    }

    private FishPoolInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FishPoolInfoOuterClass$FishPoolInfo.class */
    public static final class FishPoolInfo extends GeneratedMessageV3 implements FishPoolInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int POOL_ID_FIELD_NUMBER = 1;
        private int poolId_;
        public static final int FISH_AREA_LIST_FIELD_NUMBER = 2;
        private Internal.IntList fishAreaList_;
        private int fishAreaListMemoizedSerializedSize;
        public static final int TODAY_FISH_NUM_FIELD_NUMBER = 3;
        private int todayFishNum_;
        private byte memoizedIsInitialized;
        private static final FishPoolInfo DEFAULT_INSTANCE = new FishPoolInfo();
        private static final Parser<FishPoolInfo> PARSER = new AbstractParser<FishPoolInfo>() { // from class: emu.grasscutter.net.proto.FishPoolInfoOuterClass.FishPoolInfo.1
            @Override // com.google.protobuf.Parser
            public FishPoolInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FishPoolInfo(input, extensionRegistry);
            }
        };

        private FishPoolInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.fishAreaListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private FishPoolInfo() {
            this.fishAreaListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.fishAreaList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FishPoolInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FishPoolInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.poolId_ = input.readUInt32();
                                break;
                            case 16:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.fishAreaList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.fishAreaList_.addInt(input.readUInt32());
                                break;
                            case 18:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.fishAreaList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.fishAreaList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 24:
                                this.todayFishNum_ = input.readUInt32();
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
                    this.fishAreaList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FishPoolInfoOuterClass.internal_static_FishPoolInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FishPoolInfoOuterClass.internal_static_FishPoolInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FishPoolInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FishPoolInfoOuterClass.FishPoolInfoOrBuilder
        public int getPoolId() {
            return this.poolId_;
        }

        @Override // emu.grasscutter.net.proto.FishPoolInfoOuterClass.FishPoolInfoOrBuilder
        public List<Integer> getFishAreaListList() {
            return this.fishAreaList_;
        }

        @Override // emu.grasscutter.net.proto.FishPoolInfoOuterClass.FishPoolInfoOrBuilder
        public int getFishAreaListCount() {
            return this.fishAreaList_.size();
        }

        @Override // emu.grasscutter.net.proto.FishPoolInfoOuterClass.FishPoolInfoOrBuilder
        public int getFishAreaList(int index) {
            return this.fishAreaList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.FishPoolInfoOuterClass.FishPoolInfoOrBuilder
        public int getTodayFishNum() {
            return this.todayFishNum_;
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
            if (this.poolId_ != 0) {
                output.writeUInt32(1, this.poolId_);
            }
            if (getFishAreaListList().size() > 0) {
                output.writeUInt32NoTag(18);
                output.writeUInt32NoTag(this.fishAreaListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.fishAreaList_.size(); i++) {
                output.writeUInt32NoTag(this.fishAreaList_.getInt(i));
            }
            if (this.todayFishNum_ != 0) {
                output.writeUInt32(3, this.todayFishNum_);
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
            if (this.poolId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.poolId_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.fishAreaList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.fishAreaList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getFishAreaListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.fishAreaListMemoizedSerializedSize = dataSize;
            if (this.todayFishNum_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(3, this.todayFishNum_);
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
            if (!(obj instanceof FishPoolInfo)) {
                return equals(obj);
            }
            FishPoolInfo other = (FishPoolInfo) obj;
            return getPoolId() == other.getPoolId() && getFishAreaListList().equals(other.getFishAreaListList()) && getTodayFishNum() == other.getTodayFishNum() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getPoolId();
            if (getFishAreaListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getFishAreaListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 3)) + getTodayFishNum())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FishPoolInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FishPoolInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FishPoolInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FishPoolInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FishPoolInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FishPoolInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FishPoolInfo parseFrom(InputStream input) throws IOException {
            return (FishPoolInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FishPoolInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FishPoolInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FishPoolInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (FishPoolInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FishPoolInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FishPoolInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FishPoolInfo parseFrom(CodedInputStream input) throws IOException {
            return (FishPoolInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FishPoolInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FishPoolInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FishPoolInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FishPoolInfoOuterClass$FishPoolInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FishPoolInfoOrBuilder {
            private int bitField0_;
            private int poolId_;
            private Internal.IntList fishAreaList_ = FishPoolInfo.emptyIntList();
            private int todayFishNum_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FishPoolInfoOuterClass.internal_static_FishPoolInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FishPoolInfoOuterClass.internal_static_FishPoolInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FishPoolInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FishPoolInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.poolId_ = 0;
                this.fishAreaList_ = FishPoolInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.todayFishNum_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FishPoolInfoOuterClass.internal_static_FishPoolInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FishPoolInfo getDefaultInstanceForType() {
                return FishPoolInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FishPoolInfo build() {
                FishPoolInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FishPoolInfo buildPartial() {
                FishPoolInfo result = new FishPoolInfo(this);
                int i = this.bitField0_;
                result.poolId_ = this.poolId_;
                if ((this.bitField0_ & 1) != 0) {
                    this.fishAreaList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.fishAreaList_ = this.fishAreaList_;
                result.todayFishNum_ = this.todayFishNum_;
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
                if (other instanceof FishPoolInfo) {
                    return mergeFrom((FishPoolInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FishPoolInfo other) {
                if (other == FishPoolInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getPoolId() != 0) {
                    setPoolId(other.getPoolId());
                }
                if (!other.fishAreaList_.isEmpty()) {
                    if (this.fishAreaList_.isEmpty()) {
                        this.fishAreaList_ = other.fishAreaList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFishAreaListIsMutable();
                        this.fishAreaList_.addAll(other.fishAreaList_);
                    }
                    onChanged();
                }
                if (other.getTodayFishNum() != 0) {
                    setTodayFishNum(other.getTodayFishNum());
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
                FishPoolInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = FishPoolInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FishPoolInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FishPoolInfoOuterClass.FishPoolInfoOrBuilder
            public int getPoolId() {
                return this.poolId_;
            }

            public Builder setPoolId(int value) {
                this.poolId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPoolId() {
                this.poolId_ = 0;
                onChanged();
                return this;
            }

            private void ensureFishAreaListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.fishAreaList_ = FishPoolInfo.mutableCopy(this.fishAreaList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.FishPoolInfoOuterClass.FishPoolInfoOrBuilder
            public List<Integer> getFishAreaListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.fishAreaList_) : this.fishAreaList_;
            }

            @Override // emu.grasscutter.net.proto.FishPoolInfoOuterClass.FishPoolInfoOrBuilder
            public int getFishAreaListCount() {
                return this.fishAreaList_.size();
            }

            @Override // emu.grasscutter.net.proto.FishPoolInfoOuterClass.FishPoolInfoOrBuilder
            public int getFishAreaList(int index) {
                return this.fishAreaList_.getInt(index);
            }

            public Builder setFishAreaList(int index, int value) {
                ensureFishAreaListIsMutable();
                this.fishAreaList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addFishAreaList(int value) {
                ensureFishAreaListIsMutable();
                this.fishAreaList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllFishAreaList(Iterable<? extends Integer> values) {
                ensureFishAreaListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.fishAreaList_);
                onChanged();
                return this;
            }

            public Builder clearFishAreaList() {
                this.fishAreaList_ = FishPoolInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FishPoolInfoOuterClass.FishPoolInfoOrBuilder
            public int getTodayFishNum() {
                return this.todayFishNum_;
            }

            public Builder setTodayFishNum(int value) {
                this.todayFishNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearTodayFishNum() {
                this.todayFishNum_ = 0;
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

        public static FishPoolInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FishPoolInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FishPoolInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FishPoolInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
