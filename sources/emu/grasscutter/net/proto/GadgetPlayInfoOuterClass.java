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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.GadgetCrucibleInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetPlayInfoOuterClass.class */
public final class GadgetPlayInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014GadgetPlayInfo.proto\u001a\u0018GadgetCrucibleInfo.proto\"Å\u0001\n\u000eGadgetPlayInfo\u0012\u0011\n\tplay_type\u0018\u0001 \u0001(\r\u0012\u0010\n\bduration\u0018\u0002 \u0001(\r\u0012\u001b\n\u0013progress_stage_list\u0018\u0003 \u0003(\r\u0012\u0010\n\bstart_cd\u0018\u0004 \u0001(\r\u0012\u0012\n\nstart_time\u0018\u0005 \u0001(\r\u0012\u0010\n\bprogress\u0018\u0006 \u0001(\r\u0012,\n\rcrucible_info\u0018\u0015 \u0001(\u000b2\u0013.GadgetCrucibleInfoH��B\u000b\n\tplay_infoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{GadgetCrucibleInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GadgetPlayInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GadgetPlayInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GadgetPlayInfo_descriptor, new String[]{"PlayType", "Duration", "ProgressStageList", "StartCd", "StartTime", "Progress", "CrucibleInfo", "PlayInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetPlayInfoOuterClass$GadgetPlayInfoOrBuilder.class */
    public interface GadgetPlayInfoOrBuilder extends MessageOrBuilder {
        int getPlayType();

        int getDuration();

        List<Integer> getProgressStageListList();

        int getProgressStageListCount();

        int getProgressStageList(int i);

        int getStartCd();

        int getStartTime();

        int getProgress();

        boolean hasCrucibleInfo();

        GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo getCrucibleInfo();

        GadgetCrucibleInfoOuterClass.GadgetCrucibleInfoOrBuilder getCrucibleInfoOrBuilder();

        GadgetPlayInfo.PlayInfoCase getPlayInfoCase();
    }

    private GadgetPlayInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetPlayInfoOuterClass$GadgetPlayInfo.class */
    public static final class GadgetPlayInfo extends GeneratedMessageV3 implements GadgetPlayInfoOrBuilder {
        private static final long serialVersionUID = 0;
        private int playInfoCase_;
        private Object playInfo_;
        public static final int PLAY_TYPE_FIELD_NUMBER = 1;
        private int playType_;
        public static final int DURATION_FIELD_NUMBER = 2;
        private int duration_;
        public static final int PROGRESS_STAGE_LIST_FIELD_NUMBER = 3;
        private Internal.IntList progressStageList_;
        private int progressStageListMemoizedSerializedSize;
        public static final int START_CD_FIELD_NUMBER = 4;
        private int startCd_;
        public static final int START_TIME_FIELD_NUMBER = 5;
        private int startTime_;
        public static final int PROGRESS_FIELD_NUMBER = 6;
        private int progress_;
        public static final int CRUCIBLE_INFO_FIELD_NUMBER = 21;
        private byte memoizedIsInitialized;
        private static final GadgetPlayInfo DEFAULT_INSTANCE = new GadgetPlayInfo();
        private static final Parser<GadgetPlayInfo> PARSER = new AbstractParser<GadgetPlayInfo>() { // from class: emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfo.1
            @Override // com.google.protobuf.Parser
            public GadgetPlayInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GadgetPlayInfo(input, extensionRegistry);
            }
        };

        private GadgetPlayInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.playInfoCase_ = 0;
            this.progressStageListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GadgetPlayInfo() {
            this.playInfoCase_ = 0;
            this.progressStageListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.progressStageList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GadgetPlayInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GadgetPlayInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.playType_ = input.readUInt32();
                                break;
                            case 16:
                                this.duration_ = input.readUInt32();
                                break;
                            case 24:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.progressStageList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.progressStageList_.addInt(input.readUInt32());
                                break;
                            case 26:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.progressStageList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.progressStageList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 32:
                                this.startCd_ = input.readUInt32();
                                break;
                            case 40:
                                this.startTime_ = input.readUInt32();
                                break;
                            case 48:
                                this.progress_ = input.readUInt32();
                                break;
                            case 170:
                                GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo.Builder subBuilder = this.playInfoCase_ == 21 ? ((GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo) this.playInfo_).toBuilder() : null;
                                this.playInfo_ = input.readMessage(GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo.parser(), extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo) this.playInfo_);
                                    this.playInfo_ = subBuilder.buildPartial();
                                }
                                this.playInfoCase_ = 21;
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
                    this.progressStageList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GadgetPlayInfoOuterClass.internal_static_GadgetPlayInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GadgetPlayInfoOuterClass.internal_static_GadgetPlayInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GadgetPlayInfo.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetPlayInfoOuterClass$GadgetPlayInfo$PlayInfoCase.class */
        public enum PlayInfoCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            CRUCIBLE_INFO(21),
            PLAYINFO_NOT_SET(0);
            
            private final int value;

            PlayInfoCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static PlayInfoCase valueOf(int value) {
                return forNumber(value);
            }

            public static PlayInfoCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return PLAYINFO_NOT_SET;
                    case 21:
                        return CRUCIBLE_INFO;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
        public PlayInfoCase getPlayInfoCase() {
            return PlayInfoCase.forNumber(this.playInfoCase_);
        }

        @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
        public int getPlayType() {
            return this.playType_;
        }

        @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
        public int getDuration() {
            return this.duration_;
        }

        @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
        public List<Integer> getProgressStageListList() {
            return this.progressStageList_;
        }

        @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
        public int getProgressStageListCount() {
            return this.progressStageList_.size();
        }

        @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
        public int getProgressStageList(int index) {
            return this.progressStageList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
        public int getStartCd() {
            return this.startCd_;
        }

        @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
        public int getStartTime() {
            return this.startTime_;
        }

        @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
        public int getProgress() {
            return this.progress_;
        }

        @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
        public boolean hasCrucibleInfo() {
            return this.playInfoCase_ == 21;
        }

        @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
        public GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo getCrucibleInfo() {
            if (this.playInfoCase_ == 21) {
                return (GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo) this.playInfo_;
            }
            return GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
        public GadgetCrucibleInfoOuterClass.GadgetCrucibleInfoOrBuilder getCrucibleInfoOrBuilder() {
            if (this.playInfoCase_ == 21) {
                return (GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo) this.playInfo_;
            }
            return GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo.getDefaultInstance();
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
            if (this.playType_ != 0) {
                output.writeUInt32(1, this.playType_);
            }
            if (this.duration_ != 0) {
                output.writeUInt32(2, this.duration_);
            }
            if (getProgressStageListList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.progressStageListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.progressStageList_.size(); i++) {
                output.writeUInt32NoTag(this.progressStageList_.getInt(i));
            }
            if (this.startCd_ != 0) {
                output.writeUInt32(4, this.startCd_);
            }
            if (this.startTime_ != 0) {
                output.writeUInt32(5, this.startTime_);
            }
            if (this.progress_ != 0) {
                output.writeUInt32(6, this.progress_);
            }
            if (this.playInfoCase_ == 21) {
                output.writeMessage(21, (GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo) this.playInfo_);
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
            if (this.playType_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.playType_);
            }
            if (this.duration_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.duration_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.progressStageList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.progressStageList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getProgressStageListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.progressStageListMemoizedSerializedSize = dataSize;
            if (this.startCd_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(4, this.startCd_);
            }
            if (this.startTime_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(5, this.startTime_);
            }
            if (this.progress_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(6, this.progress_);
            }
            if (this.playInfoCase_ == 21) {
                size3 += CodedOutputStream.computeMessageSize(21, (GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo) this.playInfo_);
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
            if (!(obj instanceof GadgetPlayInfo)) {
                return equals(obj);
            }
            GadgetPlayInfo other = (GadgetPlayInfo) obj;
            if (getPlayType() != other.getPlayType() || getDuration() != other.getDuration() || !getProgressStageListList().equals(other.getProgressStageListList()) || getStartCd() != other.getStartCd() || getStartTime() != other.getStartTime() || getProgress() != other.getProgress() || !getPlayInfoCase().equals(other.getPlayInfoCase())) {
                return false;
            }
            switch (this.playInfoCase_) {
                case 21:
                    if (!getCrucibleInfo().equals(other.getCrucibleInfo())) {
                        return false;
                    }
                    break;
            }
            return this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getPlayType())) + 2)) + getDuration();
            if (getProgressStageListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getProgressStageListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 4)) + getStartCd())) + 5)) + getStartTime())) + 6)) + getProgress();
            switch (this.playInfoCase_) {
                case 21:
                    hash2 = (53 * ((37 * hash2) + 21)) + getCrucibleInfo().hashCode();
                    break;
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static GadgetPlayInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GadgetPlayInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GadgetPlayInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GadgetPlayInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GadgetPlayInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GadgetPlayInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GadgetPlayInfo parseFrom(InputStream input) throws IOException {
            return (GadgetPlayInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GadgetPlayInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GadgetPlayInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GadgetPlayInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (GadgetPlayInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GadgetPlayInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GadgetPlayInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GadgetPlayInfo parseFrom(CodedInputStream input) throws IOException {
            return (GadgetPlayInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GadgetPlayInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GadgetPlayInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GadgetPlayInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetPlayInfoOuterClass$GadgetPlayInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GadgetPlayInfoOrBuilder {
            private Object playInfo_;
            private int bitField0_;
            private int playType_;
            private int duration_;
            private int startCd_;
            private int startTime_;
            private int progress_;
            private SingleFieldBuilderV3<GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo, GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo.Builder, GadgetCrucibleInfoOuterClass.GadgetCrucibleInfoOrBuilder> crucibleInfoBuilder_;
            private int playInfoCase_ = 0;
            private Internal.IntList progressStageList_ = GadgetPlayInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return GadgetPlayInfoOuterClass.internal_static_GadgetPlayInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GadgetPlayInfoOuterClass.internal_static_GadgetPlayInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GadgetPlayInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GadgetPlayInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.playType_ = 0;
                this.duration_ = 0;
                this.progressStageList_ = GadgetPlayInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.startCd_ = 0;
                this.startTime_ = 0;
                this.progress_ = 0;
                this.playInfoCase_ = 0;
                this.playInfo_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GadgetPlayInfoOuterClass.internal_static_GadgetPlayInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GadgetPlayInfo getDefaultInstanceForType() {
                return GadgetPlayInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GadgetPlayInfo build() {
                GadgetPlayInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GadgetPlayInfo buildPartial() {
                GadgetPlayInfo result = new GadgetPlayInfo(this);
                int i = this.bitField0_;
                result.playType_ = this.playType_;
                result.duration_ = this.duration_;
                if ((this.bitField0_ & 1) != 0) {
                    this.progressStageList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.progressStageList_ = this.progressStageList_;
                result.startCd_ = this.startCd_;
                result.startTime_ = this.startTime_;
                result.progress_ = this.progress_;
                if (this.playInfoCase_ == 21) {
                    if (this.crucibleInfoBuilder_ == null) {
                        result.playInfo_ = this.playInfo_;
                    } else {
                        result.playInfo_ = this.crucibleInfoBuilder_.build();
                    }
                }
                result.playInfoCase_ = this.playInfoCase_;
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
                if (other instanceof GadgetPlayInfo) {
                    return mergeFrom((GadgetPlayInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GadgetPlayInfo other) {
                if (other == GadgetPlayInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getPlayType() != 0) {
                    setPlayType(other.getPlayType());
                }
                if (other.getDuration() != 0) {
                    setDuration(other.getDuration());
                }
                if (!other.progressStageList_.isEmpty()) {
                    if (this.progressStageList_.isEmpty()) {
                        this.progressStageList_ = other.progressStageList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureProgressStageListIsMutable();
                        this.progressStageList_.addAll(other.progressStageList_);
                    }
                    onChanged();
                }
                if (other.getStartCd() != 0) {
                    setStartCd(other.getStartCd());
                }
                if (other.getStartTime() != 0) {
                    setStartTime(other.getStartTime());
                }
                if (other.getProgress() != 0) {
                    setProgress(other.getProgress());
                }
                switch (other.getPlayInfoCase()) {
                    case CRUCIBLE_INFO:
                        mergeCrucibleInfo(other.getCrucibleInfo());
                        break;
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
                GadgetPlayInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = GadgetPlayInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GadgetPlayInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
            public PlayInfoCase getPlayInfoCase() {
                return PlayInfoCase.forNumber(this.playInfoCase_);
            }

            public Builder clearPlayInfo() {
                this.playInfoCase_ = 0;
                this.playInfo_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
            public int getPlayType() {
                return this.playType_;
            }

            public Builder setPlayType(int value) {
                this.playType_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayType() {
                this.playType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
            public int getDuration() {
                return this.duration_;
            }

            public Builder setDuration(int value) {
                this.duration_ = value;
                onChanged();
                return this;
            }

            public Builder clearDuration() {
                this.duration_ = 0;
                onChanged();
                return this;
            }

            private void ensureProgressStageListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.progressStageList_ = GadgetPlayInfo.mutableCopy(this.progressStageList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
            public List<Integer> getProgressStageListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.progressStageList_) : this.progressStageList_;
            }

            @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
            public int getProgressStageListCount() {
                return this.progressStageList_.size();
            }

            @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
            public int getProgressStageList(int index) {
                return this.progressStageList_.getInt(index);
            }

            public Builder setProgressStageList(int index, int value) {
                ensureProgressStageListIsMutable();
                this.progressStageList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addProgressStageList(int value) {
                ensureProgressStageListIsMutable();
                this.progressStageList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllProgressStageList(Iterable<? extends Integer> values) {
                ensureProgressStageListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.progressStageList_);
                onChanged();
                return this;
            }

            public Builder clearProgressStageList() {
                this.progressStageList_ = GadgetPlayInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
            public int getStartCd() {
                return this.startCd_;
            }

            public Builder setStartCd(int value) {
                this.startCd_ = value;
                onChanged();
                return this;
            }

            public Builder clearStartCd() {
                this.startCd_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
            public int getStartTime() {
                return this.startTime_;
            }

            public Builder setStartTime(int value) {
                this.startTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearStartTime() {
                this.startTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
            public int getProgress() {
                return this.progress_;
            }

            public Builder setProgress(int value) {
                this.progress_ = value;
                onChanged();
                return this;
            }

            public Builder clearProgress() {
                this.progress_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
            public boolean hasCrucibleInfo() {
                return this.playInfoCase_ == 21;
            }

            @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
            public GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo getCrucibleInfo() {
                if (this.crucibleInfoBuilder_ == null) {
                    if (this.playInfoCase_ == 21) {
                        return (GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo) this.playInfo_;
                    }
                    return GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo.getDefaultInstance();
                } else if (this.playInfoCase_ == 21) {
                    return this.crucibleInfoBuilder_.getMessage();
                } else {
                    return GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo.getDefaultInstance();
                }
            }

            public Builder setCrucibleInfo(GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo value) {
                if (this.crucibleInfoBuilder_ != null) {
                    this.crucibleInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.playInfo_ = value;
                    onChanged();
                }
                this.playInfoCase_ = 21;
                return this;
            }

            public Builder setCrucibleInfo(GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo.Builder builderForValue) {
                if (this.crucibleInfoBuilder_ == null) {
                    this.playInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.crucibleInfoBuilder_.setMessage(builderForValue.build());
                }
                this.playInfoCase_ = 21;
                return this;
            }

            public Builder mergeCrucibleInfo(GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo value) {
                if (this.crucibleInfoBuilder_ == null) {
                    if (this.playInfoCase_ != 21 || this.playInfo_ == GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo.getDefaultInstance()) {
                        this.playInfo_ = value;
                    } else {
                        this.playInfo_ = GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo.newBuilder((GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo) this.playInfo_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.playInfoCase_ == 21) {
                        this.crucibleInfoBuilder_.mergeFrom(value);
                    }
                    this.crucibleInfoBuilder_.setMessage(value);
                }
                this.playInfoCase_ = 21;
                return this;
            }

            public Builder clearCrucibleInfo() {
                if (this.crucibleInfoBuilder_ != null) {
                    if (this.playInfoCase_ == 21) {
                        this.playInfoCase_ = 0;
                        this.playInfo_ = null;
                    }
                    this.crucibleInfoBuilder_.clear();
                } else if (this.playInfoCase_ == 21) {
                    this.playInfoCase_ = 0;
                    this.playInfo_ = null;
                    onChanged();
                }
                return this;
            }

            public GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo.Builder getCrucibleInfoBuilder() {
                return getCrucibleInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder
            public GadgetCrucibleInfoOuterClass.GadgetCrucibleInfoOrBuilder getCrucibleInfoOrBuilder() {
                if (this.playInfoCase_ == 21 && this.crucibleInfoBuilder_ != null) {
                    return this.crucibleInfoBuilder_.getMessageOrBuilder();
                }
                if (this.playInfoCase_ == 21) {
                    return (GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo) this.playInfo_;
                }
                return GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo, GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo.Builder, GadgetCrucibleInfoOuterClass.GadgetCrucibleInfoOrBuilder> getCrucibleInfoFieldBuilder() {
                if (this.crucibleInfoBuilder_ == null) {
                    if (this.playInfoCase_ != 21) {
                        this.playInfo_ = GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo.getDefaultInstance();
                    }
                    this.crucibleInfoBuilder_ = new SingleFieldBuilderV3<>((GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo) this.playInfo_, getParentForChildren(), isClean());
                    this.playInfo_ = null;
                }
                this.playInfoCase_ = 21;
                onChanged();
                return this.crucibleInfoBuilder_;
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

        public static GadgetPlayInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GadgetPlayInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GadgetPlayInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GadgetPlayInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        GadgetCrucibleInfoOuterClass.getDescriptor();
    }
}
