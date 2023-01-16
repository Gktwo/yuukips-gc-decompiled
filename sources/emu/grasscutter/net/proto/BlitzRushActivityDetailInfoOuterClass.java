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
import emu.grasscutter.net.proto.BlitzRushStageOuterClass;
import emu.grasscutter.net.proto.ParkourLevelInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BlitzRushActivityDetailInfoOuterClass.class */
public final class BlitzRushActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!BlitzRushActivityDetailInfo.proto\u001a\u0014BlitzRushStage.proto\u001a\u0016ParkourLevelInfo.proto\"­\u0001\n\u001bBlitzRushActivityDetailInfo\u0012\u0019\n\u0011is_content_closed\u0018\u0001 \u0001(\b\u0012\u001a\n\u0012content_close_time\u0018\b \u0001(\r\u00122\n\u0017parkour_level_info_list\u0018\u0004 \u0003(\u000b2\u0011.ParkourLevelInfo\u0012#\n\nstage_list\u0018\u0006 \u0003(\u000b2\u000f.BlitzRushStageB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BlitzRushStageOuterClass.getDescriptor(), ParkourLevelInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BlitzRushActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BlitzRushActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BlitzRushActivityDetailInfo_descriptor, new String[]{"IsContentClosed", "ContentCloseTime", "ParkourLevelInfoList", "StageList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BlitzRushActivityDetailInfoOuterClass$BlitzRushActivityDetailInfoOrBuilder.class */
    public interface BlitzRushActivityDetailInfoOrBuilder extends MessageOrBuilder {
        boolean getIsContentClosed();

        int getContentCloseTime();

        List<ParkourLevelInfoOuterClass.ParkourLevelInfo> getParkourLevelInfoListList();

        ParkourLevelInfoOuterClass.ParkourLevelInfo getParkourLevelInfoList(int i);

        int getParkourLevelInfoListCount();

        List<? extends ParkourLevelInfoOuterClass.ParkourLevelInfoOrBuilder> getParkourLevelInfoListOrBuilderList();

        ParkourLevelInfoOuterClass.ParkourLevelInfoOrBuilder getParkourLevelInfoListOrBuilder(int i);

        List<BlitzRushStageOuterClass.BlitzRushStage> getStageListList();

        BlitzRushStageOuterClass.BlitzRushStage getStageList(int i);

        int getStageListCount();

        List<? extends BlitzRushStageOuterClass.BlitzRushStageOrBuilder> getStageListOrBuilderList();

        BlitzRushStageOuterClass.BlitzRushStageOrBuilder getStageListOrBuilder(int i);
    }

    private BlitzRushActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BlitzRushActivityDetailInfoOuterClass$BlitzRushActivityDetailInfo.class */
    public static final class BlitzRushActivityDetailInfo extends GeneratedMessageV3 implements BlitzRushActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 1;
        private boolean isContentClosed_;
        public static final int CONTENT_CLOSE_TIME_FIELD_NUMBER = 8;
        private int contentCloseTime_;
        public static final int PARKOUR_LEVEL_INFO_LIST_FIELD_NUMBER = 4;
        private List<ParkourLevelInfoOuterClass.ParkourLevelInfo> parkourLevelInfoList_;
        public static final int STAGE_LIST_FIELD_NUMBER = 6;
        private List<BlitzRushStageOuterClass.BlitzRushStage> stageList_;
        private byte memoizedIsInitialized;
        private static final BlitzRushActivityDetailInfo DEFAULT_INSTANCE = new BlitzRushActivityDetailInfo();
        private static final Parser<BlitzRushActivityDetailInfo> PARSER = new AbstractParser<BlitzRushActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public BlitzRushActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BlitzRushActivityDetailInfo(input, extensionRegistry);
            }
        };

        private BlitzRushActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BlitzRushActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.parkourLevelInfoList_ = Collections.emptyList();
            this.stageList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BlitzRushActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:62:0x00de */
        private BlitzRushActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.isContentClosed_ = input.readBool();
                                break;
                            case 34:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.parkourLevelInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.parkourLevelInfoList_.add((ParkourLevelInfoOuterClass.ParkourLevelInfo) input.readMessage(ParkourLevelInfoOuterClass.ParkourLevelInfo.parser(), extensionRegistry));
                                break;
                            case 50:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.stageList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.stageList_.add((BlitzRushStageOuterClass.BlitzRushStage) input.readMessage(BlitzRushStageOuterClass.BlitzRushStage.parser(), extensionRegistry));
                                break;
                            case 64:
                                this.contentCloseTime_ = input.readUInt32();
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
                    this.parkourLevelInfoList_ = Collections.unmodifiableList(this.parkourLevelInfoList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.stageList_ = Collections.unmodifiableList(this.stageList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BlitzRushActivityDetailInfoOuterClass.internal_static_BlitzRushActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BlitzRushActivityDetailInfoOuterClass.internal_static_BlitzRushActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BlitzRushActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
        }

        @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
        public int getContentCloseTime() {
            return this.contentCloseTime_;
        }

        @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
        public List<ParkourLevelInfoOuterClass.ParkourLevelInfo> getParkourLevelInfoListList() {
            return this.parkourLevelInfoList_;
        }

        @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
        public List<? extends ParkourLevelInfoOuterClass.ParkourLevelInfoOrBuilder> getParkourLevelInfoListOrBuilderList() {
            return this.parkourLevelInfoList_;
        }

        @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
        public int getParkourLevelInfoListCount() {
            return this.parkourLevelInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
        public ParkourLevelInfoOuterClass.ParkourLevelInfo getParkourLevelInfoList(int index) {
            return this.parkourLevelInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
        public ParkourLevelInfoOuterClass.ParkourLevelInfoOrBuilder getParkourLevelInfoListOrBuilder(int index) {
            return this.parkourLevelInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
        public List<BlitzRushStageOuterClass.BlitzRushStage> getStageListList() {
            return this.stageList_;
        }

        @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
        public List<? extends BlitzRushStageOuterClass.BlitzRushStageOrBuilder> getStageListOrBuilderList() {
            return this.stageList_;
        }

        @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
        public int getStageListCount() {
            return this.stageList_.size();
        }

        @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
        public BlitzRushStageOuterClass.BlitzRushStage getStageList(int index) {
            return this.stageList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
        public BlitzRushStageOuterClass.BlitzRushStageOrBuilder getStageListOrBuilder(int index) {
            return this.stageList_.get(index);
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
            if (this.isContentClosed_) {
                output.writeBool(1, this.isContentClosed_);
            }
            for (int i = 0; i < this.parkourLevelInfoList_.size(); i++) {
                output.writeMessage(4, this.parkourLevelInfoList_.get(i));
            }
            for (int i2 = 0; i2 < this.stageList_.size(); i2++) {
                output.writeMessage(6, this.stageList_.get(i2));
            }
            if (this.contentCloseTime_ != 0) {
                output.writeUInt32(8, this.contentCloseTime_);
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
            if (this.isContentClosed_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.isContentClosed_);
            }
            for (int i = 0; i < this.parkourLevelInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.parkourLevelInfoList_.get(i));
            }
            for (int i2 = 0; i2 < this.stageList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(6, this.stageList_.get(i2));
            }
            if (this.contentCloseTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.contentCloseTime_);
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
            if (!(obj instanceof BlitzRushActivityDetailInfo)) {
                return equals(obj);
            }
            BlitzRushActivityDetailInfo other = (BlitzRushActivityDetailInfo) obj;
            return getIsContentClosed() == other.getIsContentClosed() && getContentCloseTime() == other.getContentCloseTime() && getParkourLevelInfoListList().equals(other.getParkourLevelInfoListList()) && getStageListList().equals(other.getStageListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + Internal.hashBoolean(getIsContentClosed()))) + 8)) + getContentCloseTime();
            if (getParkourLevelInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getParkourLevelInfoListList().hashCode();
            }
            if (getStageListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getStageListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static BlitzRushActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BlitzRushActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BlitzRushActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BlitzRushActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BlitzRushActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BlitzRushActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BlitzRushActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (BlitzRushActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BlitzRushActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlitzRushActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BlitzRushActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BlitzRushActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BlitzRushActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlitzRushActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BlitzRushActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (BlitzRushActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BlitzRushActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlitzRushActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BlitzRushActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BlitzRushActivityDetailInfoOuterClass$BlitzRushActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BlitzRushActivityDetailInfoOrBuilder {
            private int bitField0_;
            private boolean isContentClosed_;
            private int contentCloseTime_;
            private RepeatedFieldBuilderV3<ParkourLevelInfoOuterClass.ParkourLevelInfo, ParkourLevelInfoOuterClass.ParkourLevelInfo.Builder, ParkourLevelInfoOuterClass.ParkourLevelInfoOrBuilder> parkourLevelInfoListBuilder_;
            private RepeatedFieldBuilderV3<BlitzRushStageOuterClass.BlitzRushStage, BlitzRushStageOuterClass.BlitzRushStage.Builder, BlitzRushStageOuterClass.BlitzRushStageOrBuilder> stageListBuilder_;
            private List<ParkourLevelInfoOuterClass.ParkourLevelInfo> parkourLevelInfoList_ = Collections.emptyList();
            private List<BlitzRushStageOuterClass.BlitzRushStage> stageList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return BlitzRushActivityDetailInfoOuterClass.internal_static_BlitzRushActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BlitzRushActivityDetailInfoOuterClass.internal_static_BlitzRushActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BlitzRushActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BlitzRushActivityDetailInfo.alwaysUseFieldBuilders) {
                    getParkourLevelInfoListFieldBuilder();
                    getStageListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isContentClosed_ = false;
                this.contentCloseTime_ = 0;
                if (this.parkourLevelInfoListBuilder_ == null) {
                    this.parkourLevelInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.parkourLevelInfoListBuilder_.clear();
                }
                if (this.stageListBuilder_ == null) {
                    this.stageList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.stageListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BlitzRushActivityDetailInfoOuterClass.internal_static_BlitzRushActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BlitzRushActivityDetailInfo getDefaultInstanceForType() {
                return BlitzRushActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BlitzRushActivityDetailInfo build() {
                BlitzRushActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BlitzRushActivityDetailInfo buildPartial() {
                BlitzRushActivityDetailInfo result = new BlitzRushActivityDetailInfo(this);
                int i = this.bitField0_;
                result.isContentClosed_ = this.isContentClosed_;
                result.contentCloseTime_ = this.contentCloseTime_;
                if (this.parkourLevelInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.parkourLevelInfoList_ = Collections.unmodifiableList(this.parkourLevelInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.parkourLevelInfoList_ = this.parkourLevelInfoList_;
                } else {
                    result.parkourLevelInfoList_ = this.parkourLevelInfoListBuilder_.build();
                }
                if (this.stageListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.stageList_ = Collections.unmodifiableList(this.stageList_);
                        this.bitField0_ &= -3;
                    }
                    result.stageList_ = this.stageList_;
                } else {
                    result.stageList_ = this.stageListBuilder_.build();
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
                if (other instanceof BlitzRushActivityDetailInfo) {
                    return mergeFrom((BlitzRushActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BlitzRushActivityDetailInfo other) {
                if (other == BlitzRushActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
                }
                if (other.getContentCloseTime() != 0) {
                    setContentCloseTime(other.getContentCloseTime());
                }
                if (this.parkourLevelInfoListBuilder_ == null) {
                    if (!other.parkourLevelInfoList_.isEmpty()) {
                        if (this.parkourLevelInfoList_.isEmpty()) {
                            this.parkourLevelInfoList_ = other.parkourLevelInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureParkourLevelInfoListIsMutable();
                            this.parkourLevelInfoList_.addAll(other.parkourLevelInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.parkourLevelInfoList_.isEmpty()) {
                    if (this.parkourLevelInfoListBuilder_.isEmpty()) {
                        this.parkourLevelInfoListBuilder_.dispose();
                        this.parkourLevelInfoListBuilder_ = null;
                        this.parkourLevelInfoList_ = other.parkourLevelInfoList_;
                        this.bitField0_ &= -2;
                        this.parkourLevelInfoListBuilder_ = BlitzRushActivityDetailInfo.alwaysUseFieldBuilders ? getParkourLevelInfoListFieldBuilder() : null;
                    } else {
                        this.parkourLevelInfoListBuilder_.addAllMessages(other.parkourLevelInfoList_);
                    }
                }
                if (this.stageListBuilder_ == null) {
                    if (!other.stageList_.isEmpty()) {
                        if (this.stageList_.isEmpty()) {
                            this.stageList_ = other.stageList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureStageListIsMutable();
                            this.stageList_.addAll(other.stageList_);
                        }
                        onChanged();
                    }
                } else if (!other.stageList_.isEmpty()) {
                    if (this.stageListBuilder_.isEmpty()) {
                        this.stageListBuilder_.dispose();
                        this.stageListBuilder_ = null;
                        this.stageList_ = other.stageList_;
                        this.bitField0_ &= -3;
                        this.stageListBuilder_ = BlitzRushActivityDetailInfo.alwaysUseFieldBuilders ? getStageListFieldBuilder() : null;
                    } else {
                        this.stageListBuilder_.addAllMessages(other.stageList_);
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
                BlitzRushActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BlitzRushActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BlitzRushActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
            public boolean getIsContentClosed() {
                return this.isContentClosed_;
            }

            public Builder setIsContentClosed(boolean value) {
                this.isContentClosed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsContentClosed() {
                this.isContentClosed_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
            public int getContentCloseTime() {
                return this.contentCloseTime_;
            }

            public Builder setContentCloseTime(int value) {
                this.contentCloseTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearContentCloseTime() {
                this.contentCloseTime_ = 0;
                onChanged();
                return this;
            }

            private void ensureParkourLevelInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.parkourLevelInfoList_ = new ArrayList(this.parkourLevelInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
            public List<ParkourLevelInfoOuterClass.ParkourLevelInfo> getParkourLevelInfoListList() {
                if (this.parkourLevelInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.parkourLevelInfoList_);
                }
                return this.parkourLevelInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
            public int getParkourLevelInfoListCount() {
                if (this.parkourLevelInfoListBuilder_ == null) {
                    return this.parkourLevelInfoList_.size();
                }
                return this.parkourLevelInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
            public ParkourLevelInfoOuterClass.ParkourLevelInfo getParkourLevelInfoList(int index) {
                if (this.parkourLevelInfoListBuilder_ == null) {
                    return this.parkourLevelInfoList_.get(index);
                }
                return this.parkourLevelInfoListBuilder_.getMessage(index);
            }

            public Builder setParkourLevelInfoList(int index, ParkourLevelInfoOuterClass.ParkourLevelInfo value) {
                if (this.parkourLevelInfoListBuilder_ != null) {
                    this.parkourLevelInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureParkourLevelInfoListIsMutable();
                    this.parkourLevelInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setParkourLevelInfoList(int index, ParkourLevelInfoOuterClass.ParkourLevelInfo.Builder builderForValue) {
                if (this.parkourLevelInfoListBuilder_ == null) {
                    ensureParkourLevelInfoListIsMutable();
                    this.parkourLevelInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.parkourLevelInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addParkourLevelInfoList(ParkourLevelInfoOuterClass.ParkourLevelInfo value) {
                if (this.parkourLevelInfoListBuilder_ != null) {
                    this.parkourLevelInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureParkourLevelInfoListIsMutable();
                    this.parkourLevelInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addParkourLevelInfoList(int index, ParkourLevelInfoOuterClass.ParkourLevelInfo value) {
                if (this.parkourLevelInfoListBuilder_ != null) {
                    this.parkourLevelInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureParkourLevelInfoListIsMutable();
                    this.parkourLevelInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addParkourLevelInfoList(ParkourLevelInfoOuterClass.ParkourLevelInfo.Builder builderForValue) {
                if (this.parkourLevelInfoListBuilder_ == null) {
                    ensureParkourLevelInfoListIsMutable();
                    this.parkourLevelInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.parkourLevelInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addParkourLevelInfoList(int index, ParkourLevelInfoOuterClass.ParkourLevelInfo.Builder builderForValue) {
                if (this.parkourLevelInfoListBuilder_ == null) {
                    ensureParkourLevelInfoListIsMutable();
                    this.parkourLevelInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.parkourLevelInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllParkourLevelInfoList(Iterable<? extends ParkourLevelInfoOuterClass.ParkourLevelInfo> values) {
                if (this.parkourLevelInfoListBuilder_ == null) {
                    ensureParkourLevelInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.parkourLevelInfoList_);
                    onChanged();
                } else {
                    this.parkourLevelInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearParkourLevelInfoList() {
                if (this.parkourLevelInfoListBuilder_ == null) {
                    this.parkourLevelInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.parkourLevelInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeParkourLevelInfoList(int index) {
                if (this.parkourLevelInfoListBuilder_ == null) {
                    ensureParkourLevelInfoListIsMutable();
                    this.parkourLevelInfoList_.remove(index);
                    onChanged();
                } else {
                    this.parkourLevelInfoListBuilder_.remove(index);
                }
                return this;
            }

            public ParkourLevelInfoOuterClass.ParkourLevelInfo.Builder getParkourLevelInfoListBuilder(int index) {
                return getParkourLevelInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
            public ParkourLevelInfoOuterClass.ParkourLevelInfoOrBuilder getParkourLevelInfoListOrBuilder(int index) {
                if (this.parkourLevelInfoListBuilder_ == null) {
                    return this.parkourLevelInfoList_.get(index);
                }
                return this.parkourLevelInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
            public List<? extends ParkourLevelInfoOuterClass.ParkourLevelInfoOrBuilder> getParkourLevelInfoListOrBuilderList() {
                if (this.parkourLevelInfoListBuilder_ != null) {
                    return this.parkourLevelInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.parkourLevelInfoList_);
            }

            public ParkourLevelInfoOuterClass.ParkourLevelInfo.Builder addParkourLevelInfoListBuilder() {
                return getParkourLevelInfoListFieldBuilder().addBuilder(ParkourLevelInfoOuterClass.ParkourLevelInfo.getDefaultInstance());
            }

            public ParkourLevelInfoOuterClass.ParkourLevelInfo.Builder addParkourLevelInfoListBuilder(int index) {
                return getParkourLevelInfoListFieldBuilder().addBuilder(index, ParkourLevelInfoOuterClass.ParkourLevelInfo.getDefaultInstance());
            }

            public List<ParkourLevelInfoOuterClass.ParkourLevelInfo.Builder> getParkourLevelInfoListBuilderList() {
                return getParkourLevelInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ParkourLevelInfoOuterClass.ParkourLevelInfo, ParkourLevelInfoOuterClass.ParkourLevelInfo.Builder, ParkourLevelInfoOuterClass.ParkourLevelInfoOrBuilder> getParkourLevelInfoListFieldBuilder() {
                if (this.parkourLevelInfoListBuilder_ == null) {
                    this.parkourLevelInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.parkourLevelInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.parkourLevelInfoList_ = null;
                }
                return this.parkourLevelInfoListBuilder_;
            }

            private void ensureStageListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.stageList_ = new ArrayList(this.stageList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
            public List<BlitzRushStageOuterClass.BlitzRushStage> getStageListList() {
                if (this.stageListBuilder_ == null) {
                    return Collections.unmodifiableList(this.stageList_);
                }
                return this.stageListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
            public int getStageListCount() {
                if (this.stageListBuilder_ == null) {
                    return this.stageList_.size();
                }
                return this.stageListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
            public BlitzRushStageOuterClass.BlitzRushStage getStageList(int index) {
                if (this.stageListBuilder_ == null) {
                    return this.stageList_.get(index);
                }
                return this.stageListBuilder_.getMessage(index);
            }

            public Builder setStageList(int index, BlitzRushStageOuterClass.BlitzRushStage value) {
                if (this.stageListBuilder_ != null) {
                    this.stageListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageListIsMutable();
                    this.stageList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setStageList(int index, BlitzRushStageOuterClass.BlitzRushStage.Builder builderForValue) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    this.stageList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addStageList(BlitzRushStageOuterClass.BlitzRushStage value) {
                if (this.stageListBuilder_ != null) {
                    this.stageListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageListIsMutable();
                    this.stageList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addStageList(int index, BlitzRushStageOuterClass.BlitzRushStage value) {
                if (this.stageListBuilder_ != null) {
                    this.stageListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageListIsMutable();
                    this.stageList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addStageList(BlitzRushStageOuterClass.BlitzRushStage.Builder builderForValue) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    this.stageList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.stageListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addStageList(int index, BlitzRushStageOuterClass.BlitzRushStage.Builder builderForValue) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    this.stageList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllStageList(Iterable<? extends BlitzRushStageOuterClass.BlitzRushStage> values) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.stageList_);
                    onChanged();
                } else {
                    this.stageListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearStageList() {
                if (this.stageListBuilder_ == null) {
                    this.stageList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.stageListBuilder_.clear();
                }
                return this;
            }

            public Builder removeStageList(int index) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    this.stageList_.remove(index);
                    onChanged();
                } else {
                    this.stageListBuilder_.remove(index);
                }
                return this;
            }

            public BlitzRushStageOuterClass.BlitzRushStage.Builder getStageListBuilder(int index) {
                return getStageListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
            public BlitzRushStageOuterClass.BlitzRushStageOrBuilder getStageListOrBuilder(int index) {
                if (this.stageListBuilder_ == null) {
                    return this.stageList_.get(index);
                }
                return this.stageListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder
            public List<? extends BlitzRushStageOuterClass.BlitzRushStageOrBuilder> getStageListOrBuilderList() {
                if (this.stageListBuilder_ != null) {
                    return this.stageListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.stageList_);
            }

            public BlitzRushStageOuterClass.BlitzRushStage.Builder addStageListBuilder() {
                return getStageListFieldBuilder().addBuilder(BlitzRushStageOuterClass.BlitzRushStage.getDefaultInstance());
            }

            public BlitzRushStageOuterClass.BlitzRushStage.Builder addStageListBuilder(int index) {
                return getStageListFieldBuilder().addBuilder(index, BlitzRushStageOuterClass.BlitzRushStage.getDefaultInstance());
            }

            public List<BlitzRushStageOuterClass.BlitzRushStage.Builder> getStageListBuilderList() {
                return getStageListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BlitzRushStageOuterClass.BlitzRushStage, BlitzRushStageOuterClass.BlitzRushStage.Builder, BlitzRushStageOuterClass.BlitzRushStageOrBuilder> getStageListFieldBuilder() {
                if (this.stageListBuilder_ == null) {
                    this.stageListBuilder_ = new RepeatedFieldBuilderV3<>(this.stageList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.stageList_ = null;
                }
                return this.stageListBuilder_;
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

        public static BlitzRushActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BlitzRushActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BlitzRushActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BlitzRushActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BlitzRushStageOuterClass.getDescriptor();
        ParkourLevelInfoOuterClass.getDescriptor();
    }
}
