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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.IrodoriChessDataOuterClass;
import emu.grasscutter.net.proto.IrodoriFlowerDataOuterClass;
import emu.grasscutter.net.proto.IrodoriMasterLevelInfoOuterClass;
import emu.grasscutter.net.proto.IrodoriPoetryDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriActivityDetailInfoOuterClass.class */
public final class IrodoriActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fIrodoriActivityDetailInfo.proto\u001a\u0016IrodoriChessData.proto\u001a\u0017IrodoriFlowerData.proto\u001a\u001cIrodoriMasterLevelInfo.proto\u001a\u0017IrodoriPoetryData.proto\"È\u0001\n\u0019IrodoriActivityDetailInfo\u0012%\n\nchess_data\u0018\u0005 \u0001(\u000b2\u0011.IrodoriChessData\u0012'\n\u000bflower_data\u0018\u0003 \u0001(\u000b2\u0012.IrodoriFlowerData\u0012'\n\u000bpoetry_data\u0018\u0006 \u0001(\u000b2\u0012.IrodoriPoetryData\u00122\n\u0011master_level_list\u0018\u0001 \u0003(\u000b2\u0017.IrodoriMasterLevelInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{IrodoriChessDataOuterClass.getDescriptor(), IrodoriFlowerDataOuterClass.getDescriptor(), IrodoriMasterLevelInfoOuterClass.getDescriptor(), IrodoriPoetryDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_IrodoriActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_IrodoriActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_IrodoriActivityDetailInfo_descriptor, new String[]{"ChessData", "FlowerData", "PoetryData", "MasterLevelList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriActivityDetailInfoOuterClass$IrodoriActivityDetailInfoOrBuilder.class */
    public interface IrodoriActivityDetailInfoOrBuilder extends MessageOrBuilder {
        boolean hasChessData();

        IrodoriChessDataOuterClass.IrodoriChessData getChessData();

        IrodoriChessDataOuterClass.IrodoriChessDataOrBuilder getChessDataOrBuilder();

        boolean hasFlowerData();

        IrodoriFlowerDataOuterClass.IrodoriFlowerData getFlowerData();

        IrodoriFlowerDataOuterClass.IrodoriFlowerDataOrBuilder getFlowerDataOrBuilder();

        boolean hasPoetryData();

        IrodoriPoetryDataOuterClass.IrodoriPoetryData getPoetryData();

        IrodoriPoetryDataOuterClass.IrodoriPoetryDataOrBuilder getPoetryDataOrBuilder();

        List<IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo> getMasterLevelListList();

        IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo getMasterLevelList(int i);

        int getMasterLevelListCount();

        List<? extends IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfoOrBuilder> getMasterLevelListOrBuilderList();

        IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfoOrBuilder getMasterLevelListOrBuilder(int i);
    }

    private IrodoriActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriActivityDetailInfoOuterClass$IrodoriActivityDetailInfo.class */
    public static final class IrodoriActivityDetailInfo extends GeneratedMessageV3 implements IrodoriActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CHESS_DATA_FIELD_NUMBER = 5;
        private IrodoriChessDataOuterClass.IrodoriChessData chessData_;
        public static final int FLOWER_DATA_FIELD_NUMBER = 3;
        private IrodoriFlowerDataOuterClass.IrodoriFlowerData flowerData_;
        public static final int POETRY_DATA_FIELD_NUMBER = 6;
        private IrodoriPoetryDataOuterClass.IrodoriPoetryData poetryData_;
        public static final int MASTER_LEVEL_LIST_FIELD_NUMBER = 1;
        private List<IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo> masterLevelList_;
        private byte memoizedIsInitialized;
        private static final IrodoriActivityDetailInfo DEFAULT_INSTANCE = new IrodoriActivityDetailInfo();
        private static final Parser<IrodoriActivityDetailInfo> PARSER = new AbstractParser<IrodoriActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public IrodoriActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new IrodoriActivityDetailInfo(input, extensionRegistry);
            }
        };

        private IrodoriActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private IrodoriActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.masterLevelList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new IrodoriActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private IrodoriActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 10:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.masterLevelList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.masterLevelList_.add((IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo) input.readMessage(IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo.parser(), extensionRegistry));
                                break;
                            case 26:
                                IrodoriFlowerDataOuterClass.IrodoriFlowerData.Builder subBuilder = this.flowerData_ != null ? this.flowerData_.toBuilder() : null;
                                this.flowerData_ = (IrodoriFlowerDataOuterClass.IrodoriFlowerData) input.readMessage(IrodoriFlowerDataOuterClass.IrodoriFlowerData.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.flowerData_);
                                    this.flowerData_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 42:
                                IrodoriChessDataOuterClass.IrodoriChessData.Builder subBuilder2 = this.chessData_ != null ? this.chessData_.toBuilder() : null;
                                this.chessData_ = (IrodoriChessDataOuterClass.IrodoriChessData) input.readMessage(IrodoriChessDataOuterClass.IrodoriChessData.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.chessData_);
                                    this.chessData_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 50:
                                IrodoriPoetryDataOuterClass.IrodoriPoetryData.Builder subBuilder3 = this.poetryData_ != null ? this.poetryData_.toBuilder() : null;
                                this.poetryData_ = (IrodoriPoetryDataOuterClass.IrodoriPoetryData) input.readMessage(IrodoriPoetryDataOuterClass.IrodoriPoetryData.parser(), extensionRegistry);
                                if (subBuilder3 == null) {
                                    break;
                                } else {
                                    subBuilder3.mergeFrom(this.poetryData_);
                                    this.poetryData_ = subBuilder3.buildPartial();
                                    break;
                                }
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
                    this.masterLevelList_ = Collections.unmodifiableList(this.masterLevelList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return IrodoriActivityDetailInfoOuterClass.internal_static_IrodoriActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return IrodoriActivityDetailInfoOuterClass.internal_static_IrodoriActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
        public boolean hasChessData() {
            return this.chessData_ != null;
        }

        @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
        public IrodoriChessDataOuterClass.IrodoriChessData getChessData() {
            return this.chessData_ == null ? IrodoriChessDataOuterClass.IrodoriChessData.getDefaultInstance() : this.chessData_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
        public IrodoriChessDataOuterClass.IrodoriChessDataOrBuilder getChessDataOrBuilder() {
            return getChessData();
        }

        @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
        public boolean hasFlowerData() {
            return this.flowerData_ != null;
        }

        @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
        public IrodoriFlowerDataOuterClass.IrodoriFlowerData getFlowerData() {
            return this.flowerData_ == null ? IrodoriFlowerDataOuterClass.IrodoriFlowerData.getDefaultInstance() : this.flowerData_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
        public IrodoriFlowerDataOuterClass.IrodoriFlowerDataOrBuilder getFlowerDataOrBuilder() {
            return getFlowerData();
        }

        @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
        public boolean hasPoetryData() {
            return this.poetryData_ != null;
        }

        @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
        public IrodoriPoetryDataOuterClass.IrodoriPoetryData getPoetryData() {
            return this.poetryData_ == null ? IrodoriPoetryDataOuterClass.IrodoriPoetryData.getDefaultInstance() : this.poetryData_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
        public IrodoriPoetryDataOuterClass.IrodoriPoetryDataOrBuilder getPoetryDataOrBuilder() {
            return getPoetryData();
        }

        @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
        public List<IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo> getMasterLevelListList() {
            return this.masterLevelList_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
        public List<? extends IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfoOrBuilder> getMasterLevelListOrBuilderList() {
            return this.masterLevelList_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
        public int getMasterLevelListCount() {
            return this.masterLevelList_.size();
        }

        @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
        public IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo getMasterLevelList(int index) {
            return this.masterLevelList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
        public IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfoOrBuilder getMasterLevelListOrBuilder(int index) {
            return this.masterLevelList_.get(index);
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
            for (int i = 0; i < this.masterLevelList_.size(); i++) {
                output.writeMessage(1, this.masterLevelList_.get(i));
            }
            if (this.flowerData_ != null) {
                output.writeMessage(3, getFlowerData());
            }
            if (this.chessData_ != null) {
                output.writeMessage(5, getChessData());
            }
            if (this.poetryData_ != null) {
                output.writeMessage(6, getPoetryData());
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
            for (int i = 0; i < this.masterLevelList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.masterLevelList_.get(i));
            }
            if (this.flowerData_ != null) {
                size2 += CodedOutputStream.computeMessageSize(3, getFlowerData());
            }
            if (this.chessData_ != null) {
                size2 += CodedOutputStream.computeMessageSize(5, getChessData());
            }
            if (this.poetryData_ != null) {
                size2 += CodedOutputStream.computeMessageSize(6, getPoetryData());
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
            if (!(obj instanceof IrodoriActivityDetailInfo)) {
                return equals(obj);
            }
            IrodoriActivityDetailInfo other = (IrodoriActivityDetailInfo) obj;
            if (hasChessData() != other.hasChessData()) {
                return false;
            }
            if ((hasChessData() && !getChessData().equals(other.getChessData())) || hasFlowerData() != other.hasFlowerData()) {
                return false;
            }
            if ((!hasFlowerData() || getFlowerData().equals(other.getFlowerData())) && hasPoetryData() == other.hasPoetryData()) {
                return (!hasPoetryData() || getPoetryData().equals(other.getPoetryData())) && getMasterLevelListList().equals(other.getMasterLevelListList()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasChessData()) {
                hash = (53 * ((37 * hash) + 5)) + getChessData().hashCode();
            }
            if (hasFlowerData()) {
                hash = (53 * ((37 * hash) + 3)) + getFlowerData().hashCode();
            }
            if (hasPoetryData()) {
                hash = (53 * ((37 * hash) + 6)) + getPoetryData().hashCode();
            }
            if (getMasterLevelListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getMasterLevelListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static IrodoriActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (IrodoriActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (IrodoriActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static IrodoriActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (IrodoriActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(IrodoriActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriActivityDetailInfoOuterClass$IrodoriActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements IrodoriActivityDetailInfoOrBuilder {
            private int bitField0_;
            private IrodoriChessDataOuterClass.IrodoriChessData chessData_;
            private SingleFieldBuilderV3<IrodoriChessDataOuterClass.IrodoriChessData, IrodoriChessDataOuterClass.IrodoriChessData.Builder, IrodoriChessDataOuterClass.IrodoriChessDataOrBuilder> chessDataBuilder_;
            private IrodoriFlowerDataOuterClass.IrodoriFlowerData flowerData_;
            private SingleFieldBuilderV3<IrodoriFlowerDataOuterClass.IrodoriFlowerData, IrodoriFlowerDataOuterClass.IrodoriFlowerData.Builder, IrodoriFlowerDataOuterClass.IrodoriFlowerDataOrBuilder> flowerDataBuilder_;
            private IrodoriPoetryDataOuterClass.IrodoriPoetryData poetryData_;
            private SingleFieldBuilderV3<IrodoriPoetryDataOuterClass.IrodoriPoetryData, IrodoriPoetryDataOuterClass.IrodoriPoetryData.Builder, IrodoriPoetryDataOuterClass.IrodoriPoetryDataOrBuilder> poetryDataBuilder_;
            private List<IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo> masterLevelList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo, IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo.Builder, IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfoOrBuilder> masterLevelListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return IrodoriActivityDetailInfoOuterClass.internal_static_IrodoriActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return IrodoriActivityDetailInfoOuterClass.internal_static_IrodoriActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (IrodoriActivityDetailInfo.alwaysUseFieldBuilders) {
                    getMasterLevelListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.chessDataBuilder_ == null) {
                    this.chessData_ = null;
                } else {
                    this.chessData_ = null;
                    this.chessDataBuilder_ = null;
                }
                if (this.flowerDataBuilder_ == null) {
                    this.flowerData_ = null;
                } else {
                    this.flowerData_ = null;
                    this.flowerDataBuilder_ = null;
                }
                if (this.poetryDataBuilder_ == null) {
                    this.poetryData_ = null;
                } else {
                    this.poetryData_ = null;
                    this.poetryDataBuilder_ = null;
                }
                if (this.masterLevelListBuilder_ == null) {
                    this.masterLevelList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.masterLevelListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return IrodoriActivityDetailInfoOuterClass.internal_static_IrodoriActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public IrodoriActivityDetailInfo getDefaultInstanceForType() {
                return IrodoriActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriActivityDetailInfo build() {
                IrodoriActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriActivityDetailInfo buildPartial() {
                IrodoriActivityDetailInfo result = new IrodoriActivityDetailInfo(this);
                int i = this.bitField0_;
                if (this.chessDataBuilder_ == null) {
                    result.chessData_ = this.chessData_;
                } else {
                    result.chessData_ = this.chessDataBuilder_.build();
                }
                if (this.flowerDataBuilder_ == null) {
                    result.flowerData_ = this.flowerData_;
                } else {
                    result.flowerData_ = this.flowerDataBuilder_.build();
                }
                if (this.poetryDataBuilder_ == null) {
                    result.poetryData_ = this.poetryData_;
                } else {
                    result.poetryData_ = this.poetryDataBuilder_.build();
                }
                if (this.masterLevelListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.masterLevelList_ = Collections.unmodifiableList(this.masterLevelList_);
                        this.bitField0_ &= -2;
                    }
                    result.masterLevelList_ = this.masterLevelList_;
                } else {
                    result.masterLevelList_ = this.masterLevelListBuilder_.build();
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
                if (other instanceof IrodoriActivityDetailInfo) {
                    return mergeFrom((IrodoriActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(IrodoriActivityDetailInfo other) {
                if (other == IrodoriActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasChessData()) {
                    mergeChessData(other.getChessData());
                }
                if (other.hasFlowerData()) {
                    mergeFlowerData(other.getFlowerData());
                }
                if (other.hasPoetryData()) {
                    mergePoetryData(other.getPoetryData());
                }
                if (this.masterLevelListBuilder_ == null) {
                    if (!other.masterLevelList_.isEmpty()) {
                        if (this.masterLevelList_.isEmpty()) {
                            this.masterLevelList_ = other.masterLevelList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureMasterLevelListIsMutable();
                            this.masterLevelList_.addAll(other.masterLevelList_);
                        }
                        onChanged();
                    }
                } else if (!other.masterLevelList_.isEmpty()) {
                    if (this.masterLevelListBuilder_.isEmpty()) {
                        this.masterLevelListBuilder_.dispose();
                        this.masterLevelListBuilder_ = null;
                        this.masterLevelList_ = other.masterLevelList_;
                        this.bitField0_ &= -2;
                        this.masterLevelListBuilder_ = IrodoriActivityDetailInfo.alwaysUseFieldBuilders ? getMasterLevelListFieldBuilder() : null;
                    } else {
                        this.masterLevelListBuilder_.addAllMessages(other.masterLevelList_);
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
                IrodoriActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = IrodoriActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (IrodoriActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
            public boolean hasChessData() {
                return (this.chessDataBuilder_ == null && this.chessData_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
            public IrodoriChessDataOuterClass.IrodoriChessData getChessData() {
                if (this.chessDataBuilder_ == null) {
                    return this.chessData_ == null ? IrodoriChessDataOuterClass.IrodoriChessData.getDefaultInstance() : this.chessData_;
                }
                return this.chessDataBuilder_.getMessage();
            }

            public Builder setChessData(IrodoriChessDataOuterClass.IrodoriChessData value) {
                if (this.chessDataBuilder_ != null) {
                    this.chessDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.chessData_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setChessData(IrodoriChessDataOuterClass.IrodoriChessData.Builder builderForValue) {
                if (this.chessDataBuilder_ == null) {
                    this.chessData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.chessDataBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeChessData(IrodoriChessDataOuterClass.IrodoriChessData value) {
                if (this.chessDataBuilder_ == null) {
                    if (this.chessData_ != null) {
                        this.chessData_ = IrodoriChessDataOuterClass.IrodoriChessData.newBuilder(this.chessData_).mergeFrom(value).buildPartial();
                    } else {
                        this.chessData_ = value;
                    }
                    onChanged();
                } else {
                    this.chessDataBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearChessData() {
                if (this.chessDataBuilder_ == null) {
                    this.chessData_ = null;
                    onChanged();
                } else {
                    this.chessData_ = null;
                    this.chessDataBuilder_ = null;
                }
                return this;
            }

            public IrodoriChessDataOuterClass.IrodoriChessData.Builder getChessDataBuilder() {
                onChanged();
                return getChessDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
            public IrodoriChessDataOuterClass.IrodoriChessDataOrBuilder getChessDataOrBuilder() {
                if (this.chessDataBuilder_ != null) {
                    return this.chessDataBuilder_.getMessageOrBuilder();
                }
                return this.chessData_ == null ? IrodoriChessDataOuterClass.IrodoriChessData.getDefaultInstance() : this.chessData_;
            }

            private SingleFieldBuilderV3<IrodoriChessDataOuterClass.IrodoriChessData, IrodoriChessDataOuterClass.IrodoriChessData.Builder, IrodoriChessDataOuterClass.IrodoriChessDataOrBuilder> getChessDataFieldBuilder() {
                if (this.chessDataBuilder_ == null) {
                    this.chessDataBuilder_ = new SingleFieldBuilderV3<>(getChessData(), getParentForChildren(), isClean());
                    this.chessData_ = null;
                }
                return this.chessDataBuilder_;
            }

            @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
            public boolean hasFlowerData() {
                return (this.flowerDataBuilder_ == null && this.flowerData_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
            public IrodoriFlowerDataOuterClass.IrodoriFlowerData getFlowerData() {
                if (this.flowerDataBuilder_ == null) {
                    return this.flowerData_ == null ? IrodoriFlowerDataOuterClass.IrodoriFlowerData.getDefaultInstance() : this.flowerData_;
                }
                return this.flowerDataBuilder_.getMessage();
            }

            public Builder setFlowerData(IrodoriFlowerDataOuterClass.IrodoriFlowerData value) {
                if (this.flowerDataBuilder_ != null) {
                    this.flowerDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.flowerData_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setFlowerData(IrodoriFlowerDataOuterClass.IrodoriFlowerData.Builder builderForValue) {
                if (this.flowerDataBuilder_ == null) {
                    this.flowerData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.flowerDataBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeFlowerData(IrodoriFlowerDataOuterClass.IrodoriFlowerData value) {
                if (this.flowerDataBuilder_ == null) {
                    if (this.flowerData_ != null) {
                        this.flowerData_ = IrodoriFlowerDataOuterClass.IrodoriFlowerData.newBuilder(this.flowerData_).mergeFrom(value).buildPartial();
                    } else {
                        this.flowerData_ = value;
                    }
                    onChanged();
                } else {
                    this.flowerDataBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearFlowerData() {
                if (this.flowerDataBuilder_ == null) {
                    this.flowerData_ = null;
                    onChanged();
                } else {
                    this.flowerData_ = null;
                    this.flowerDataBuilder_ = null;
                }
                return this;
            }

            public IrodoriFlowerDataOuterClass.IrodoriFlowerData.Builder getFlowerDataBuilder() {
                onChanged();
                return getFlowerDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
            public IrodoriFlowerDataOuterClass.IrodoriFlowerDataOrBuilder getFlowerDataOrBuilder() {
                if (this.flowerDataBuilder_ != null) {
                    return this.flowerDataBuilder_.getMessageOrBuilder();
                }
                return this.flowerData_ == null ? IrodoriFlowerDataOuterClass.IrodoriFlowerData.getDefaultInstance() : this.flowerData_;
            }

            private SingleFieldBuilderV3<IrodoriFlowerDataOuterClass.IrodoriFlowerData, IrodoriFlowerDataOuterClass.IrodoriFlowerData.Builder, IrodoriFlowerDataOuterClass.IrodoriFlowerDataOrBuilder> getFlowerDataFieldBuilder() {
                if (this.flowerDataBuilder_ == null) {
                    this.flowerDataBuilder_ = new SingleFieldBuilderV3<>(getFlowerData(), getParentForChildren(), isClean());
                    this.flowerData_ = null;
                }
                return this.flowerDataBuilder_;
            }

            @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
            public boolean hasPoetryData() {
                return (this.poetryDataBuilder_ == null && this.poetryData_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
            public IrodoriPoetryDataOuterClass.IrodoriPoetryData getPoetryData() {
                if (this.poetryDataBuilder_ == null) {
                    return this.poetryData_ == null ? IrodoriPoetryDataOuterClass.IrodoriPoetryData.getDefaultInstance() : this.poetryData_;
                }
                return this.poetryDataBuilder_.getMessage();
            }

            public Builder setPoetryData(IrodoriPoetryDataOuterClass.IrodoriPoetryData value) {
                if (this.poetryDataBuilder_ != null) {
                    this.poetryDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.poetryData_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPoetryData(IrodoriPoetryDataOuterClass.IrodoriPoetryData.Builder builderForValue) {
                if (this.poetryDataBuilder_ == null) {
                    this.poetryData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.poetryDataBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePoetryData(IrodoriPoetryDataOuterClass.IrodoriPoetryData value) {
                if (this.poetryDataBuilder_ == null) {
                    if (this.poetryData_ != null) {
                        this.poetryData_ = IrodoriPoetryDataOuterClass.IrodoriPoetryData.newBuilder(this.poetryData_).mergeFrom(value).buildPartial();
                    } else {
                        this.poetryData_ = value;
                    }
                    onChanged();
                } else {
                    this.poetryDataBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPoetryData() {
                if (this.poetryDataBuilder_ == null) {
                    this.poetryData_ = null;
                    onChanged();
                } else {
                    this.poetryData_ = null;
                    this.poetryDataBuilder_ = null;
                }
                return this;
            }

            public IrodoriPoetryDataOuterClass.IrodoriPoetryData.Builder getPoetryDataBuilder() {
                onChanged();
                return getPoetryDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
            public IrodoriPoetryDataOuterClass.IrodoriPoetryDataOrBuilder getPoetryDataOrBuilder() {
                if (this.poetryDataBuilder_ != null) {
                    return this.poetryDataBuilder_.getMessageOrBuilder();
                }
                return this.poetryData_ == null ? IrodoriPoetryDataOuterClass.IrodoriPoetryData.getDefaultInstance() : this.poetryData_;
            }

            private SingleFieldBuilderV3<IrodoriPoetryDataOuterClass.IrodoriPoetryData, IrodoriPoetryDataOuterClass.IrodoriPoetryData.Builder, IrodoriPoetryDataOuterClass.IrodoriPoetryDataOrBuilder> getPoetryDataFieldBuilder() {
                if (this.poetryDataBuilder_ == null) {
                    this.poetryDataBuilder_ = new SingleFieldBuilderV3<>(getPoetryData(), getParentForChildren(), isClean());
                    this.poetryData_ = null;
                }
                return this.poetryDataBuilder_;
            }

            private void ensureMasterLevelListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.masterLevelList_ = new ArrayList(this.masterLevelList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
            public List<IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo> getMasterLevelListList() {
                if (this.masterLevelListBuilder_ == null) {
                    return Collections.unmodifiableList(this.masterLevelList_);
                }
                return this.masterLevelListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
            public int getMasterLevelListCount() {
                if (this.masterLevelListBuilder_ == null) {
                    return this.masterLevelList_.size();
                }
                return this.masterLevelListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
            public IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo getMasterLevelList(int index) {
                if (this.masterLevelListBuilder_ == null) {
                    return this.masterLevelList_.get(index);
                }
                return this.masterLevelListBuilder_.getMessage(index);
            }

            public Builder setMasterLevelList(int index, IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo value) {
                if (this.masterLevelListBuilder_ != null) {
                    this.masterLevelListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMasterLevelListIsMutable();
                    this.masterLevelList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMasterLevelList(int index, IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo.Builder builderForValue) {
                if (this.masterLevelListBuilder_ == null) {
                    ensureMasterLevelListIsMutable();
                    this.masterLevelList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.masterLevelListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMasterLevelList(IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo value) {
                if (this.masterLevelListBuilder_ != null) {
                    this.masterLevelListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMasterLevelListIsMutable();
                    this.masterLevelList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMasterLevelList(int index, IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo value) {
                if (this.masterLevelListBuilder_ != null) {
                    this.masterLevelListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMasterLevelListIsMutable();
                    this.masterLevelList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMasterLevelList(IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo.Builder builderForValue) {
                if (this.masterLevelListBuilder_ == null) {
                    ensureMasterLevelListIsMutable();
                    this.masterLevelList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.masterLevelListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMasterLevelList(int index, IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo.Builder builderForValue) {
                if (this.masterLevelListBuilder_ == null) {
                    ensureMasterLevelListIsMutable();
                    this.masterLevelList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.masterLevelListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMasterLevelList(Iterable<? extends IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo> values) {
                if (this.masterLevelListBuilder_ == null) {
                    ensureMasterLevelListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.masterLevelList_);
                    onChanged();
                } else {
                    this.masterLevelListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMasterLevelList() {
                if (this.masterLevelListBuilder_ == null) {
                    this.masterLevelList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.masterLevelListBuilder_.clear();
                }
                return this;
            }

            public Builder removeMasterLevelList(int index) {
                if (this.masterLevelListBuilder_ == null) {
                    ensureMasterLevelListIsMutable();
                    this.masterLevelList_.remove(index);
                    onChanged();
                } else {
                    this.masterLevelListBuilder_.remove(index);
                }
                return this;
            }

            public IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo.Builder getMasterLevelListBuilder(int index) {
                return getMasterLevelListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
            public IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfoOrBuilder getMasterLevelListOrBuilder(int index) {
                if (this.masterLevelListBuilder_ == null) {
                    return this.masterLevelList_.get(index);
                }
                return this.masterLevelListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder
            public List<? extends IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfoOrBuilder> getMasterLevelListOrBuilderList() {
                if (this.masterLevelListBuilder_ != null) {
                    return this.masterLevelListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.masterLevelList_);
            }

            public IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo.Builder addMasterLevelListBuilder() {
                return getMasterLevelListFieldBuilder().addBuilder(IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo.getDefaultInstance());
            }

            public IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo.Builder addMasterLevelListBuilder(int index) {
                return getMasterLevelListFieldBuilder().addBuilder(index, IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo.getDefaultInstance());
            }

            public List<IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo.Builder> getMasterLevelListBuilderList() {
                return getMasterLevelListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo, IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo.Builder, IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfoOrBuilder> getMasterLevelListFieldBuilder() {
                if (this.masterLevelListBuilder_ == null) {
                    this.masterLevelListBuilder_ = new RepeatedFieldBuilderV3<>(this.masterLevelList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.masterLevelList_ = null;
                }
                return this.masterLevelListBuilder_;
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

        public static IrodoriActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<IrodoriActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<IrodoriActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public IrodoriActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        IrodoriChessDataOuterClass.getDescriptor();
        IrodoriFlowerDataOuterClass.getDescriptor();
        IrodoriMasterLevelInfoOuterClass.getDescriptor();
        IrodoriPoetryDataOuterClass.getDescriptor();
    }
}
