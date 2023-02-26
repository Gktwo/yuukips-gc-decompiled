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
import emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass;
import emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass;
import emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChallnelerSlabInfoOuterClass.class */
public final class ChallnelerSlabInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018ChallnelerSlabInfo.proto\u001a\u001bChannelerSlabBuffInfo.proto\u001a'ChannelerSlabLoopDungeonStageInfo.proto\u001a!ChannelerSlabChallengeStage.proto\"Æ\u0001\n\u0012ChallnelerSlabInfo\u0012(\n\bbuffInfo\u0018\r \u0001(\u000b2\u0016.ChannelerSlabBuffInfo\u0012\u0013\n\u000bplayEndTime\u0018\u0007 \u0001(\r\u0012@\n\u0014loopDungeonStageInfo\u0018\u0004 \u0001(\u000b2\".ChannelerSlabLoopDungeonStageInfo\u0012/\n\tstageList\u0018\t \u0003(\u000b2\u001c.ChannelerSlabChallengeStageB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ChannelerSlabBuffInfoOuterClass.getDescriptor(), ChannelerSlabLoopDungeonStageInfoOuterClass.getDescriptor(), ChannelerSlabChallengeStageOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ChallnelerSlabInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChallnelerSlabInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChallnelerSlabInfo_descriptor, new String[]{"BuffInfo", "PlayEndTime", "LoopDungeonStageInfo", "StageList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChallnelerSlabInfoOuterClass$ChallnelerSlabInfoOrBuilder.class */
    public interface ChallnelerSlabInfoOrBuilder extends MessageOrBuilder {
        boolean hasBuffInfo();

        ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfo getBuffInfo();

        ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder getBuffInfoOrBuilder();

        int getPlayEndTime();

        boolean hasLoopDungeonStageInfo();

        ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfo getLoopDungeonStageInfo();

        ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder getLoopDungeonStageInfoOrBuilder();

        List<ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage> getStageListList();

        ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage getStageList(int i);

        int getStageListCount();

        List<? extends ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder> getStageListOrBuilderList();

        ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder getStageListOrBuilder(int i);
    }

    private ChallnelerSlabInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChallnelerSlabInfoOuterClass$ChallnelerSlabInfo.class */
    public static final class ChallnelerSlabInfo extends GeneratedMessageV3 implements ChallnelerSlabInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BUFFINFO_FIELD_NUMBER = 13;
        private ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfo buffInfo_;
        public static final int PLAYENDTIME_FIELD_NUMBER = 7;
        private int playEndTime_;
        public static final int LOOPDUNGEONSTAGEINFO_FIELD_NUMBER = 4;
        private ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfo loopDungeonStageInfo_;
        public static final int STAGELIST_FIELD_NUMBER = 9;
        private List<ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage> stageList_;
        private byte memoizedIsInitialized;
        private static final ChallnelerSlabInfo DEFAULT_INSTANCE = new ChallnelerSlabInfo();
        private static final Parser<ChallnelerSlabInfo> PARSER = new AbstractParser<ChallnelerSlabInfo>() { // from class: emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo.1
            @Override // com.google.protobuf.Parser
            public ChallnelerSlabInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChallnelerSlabInfo(input, extensionRegistry);
            }
        };

        private ChallnelerSlabInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ChallnelerSlabInfo() {
            this.memoizedIsInitialized = -1;
            this.stageList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChallnelerSlabInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChallnelerSlabInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 34:
                                ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfo.Builder subBuilder = this.loopDungeonStageInfo_ != null ? this.loopDungeonStageInfo_.toBuilder() : null;
                                this.loopDungeonStageInfo_ = (ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfo) input.readMessage(ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.loopDungeonStageInfo_);
                                    this.loopDungeonStageInfo_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 56:
                                this.playEndTime_ = input.readUInt32();
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.stageList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.stageList_.add((ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage) input.readMessage(ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage.parser(), extensionRegistry));
                                break;
                            case 106:
                                ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfo.Builder subBuilder2 = this.buffInfo_ != null ? this.buffInfo_.toBuilder() : null;
                                this.buffInfo_ = (ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfo) input.readMessage(ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfo.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.buffInfo_);
                                    this.buffInfo_ = subBuilder2.buildPartial();
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
                    this.stageList_ = Collections.unmodifiableList(this.stageList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ChallnelerSlabInfoOuterClass.internal_static_ChallnelerSlabInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChallnelerSlabInfoOuterClass.internal_static_ChallnelerSlabInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallnelerSlabInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
        public boolean hasBuffInfo() {
            return this.buffInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
        public ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfo getBuffInfo() {
            return this.buffInfo_ == null ? ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfo.getDefaultInstance() : this.buffInfo_;
        }

        @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
        public ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder getBuffInfoOrBuilder() {
            return getBuffInfo();
        }

        @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
        public int getPlayEndTime() {
            return this.playEndTime_;
        }

        @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
        public boolean hasLoopDungeonStageInfo() {
            return this.loopDungeonStageInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
        public ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfo getLoopDungeonStageInfo() {
            return this.loopDungeonStageInfo_ == null ? ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfo.getDefaultInstance() : this.loopDungeonStageInfo_;
        }

        @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
        public ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder getLoopDungeonStageInfoOrBuilder() {
            return getLoopDungeonStageInfo();
        }

        @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
        public List<ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage> getStageListList() {
            return this.stageList_;
        }

        @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
        public List<? extends ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder> getStageListOrBuilderList() {
            return this.stageList_;
        }

        @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
        public int getStageListCount() {
            return this.stageList_.size();
        }

        @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
        public ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage getStageList(int index) {
            return this.stageList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
        public ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder getStageListOrBuilder(int index) {
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
            if (this.loopDungeonStageInfo_ != null) {
                output.writeMessage(4, getLoopDungeonStageInfo());
            }
            if (this.playEndTime_ != 0) {
                output.writeUInt32(7, this.playEndTime_);
            }
            for (int i = 0; i < this.stageList_.size(); i++) {
                output.writeMessage(9, this.stageList_.get(i));
            }
            if (this.buffInfo_ != null) {
                output.writeMessage(13, getBuffInfo());
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
            if (this.loopDungeonStageInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(4, getLoopDungeonStageInfo());
            }
            if (this.playEndTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.playEndTime_);
            }
            for (int i = 0; i < this.stageList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(9, this.stageList_.get(i));
            }
            if (this.buffInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(13, getBuffInfo());
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
            if (!(obj instanceof ChallnelerSlabInfo)) {
                return equals(obj);
            }
            ChallnelerSlabInfo other = (ChallnelerSlabInfo) obj;
            if (hasBuffInfo() != other.hasBuffInfo()) {
                return false;
            }
            if ((!hasBuffInfo() || getBuffInfo().equals(other.getBuffInfo())) && getPlayEndTime() == other.getPlayEndTime() && hasLoopDungeonStageInfo() == other.hasLoopDungeonStageInfo()) {
                return (!hasLoopDungeonStageInfo() || getLoopDungeonStageInfo().equals(other.getLoopDungeonStageInfo())) && getStageListList().equals(other.getStageListList()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasBuffInfo()) {
                hash = (53 * ((37 * hash) + 13)) + getBuffInfo().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 7)) + getPlayEndTime();
            if (hasLoopDungeonStageInfo()) {
                hash2 = (53 * ((37 * hash2) + 4)) + getLoopDungeonStageInfo().hashCode();
            }
            if (getStageListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 9)) + getStageListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static ChallnelerSlabInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChallnelerSlabInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChallnelerSlabInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChallnelerSlabInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChallnelerSlabInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChallnelerSlabInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChallnelerSlabInfo parseFrom(InputStream input) throws IOException {
            return (ChallnelerSlabInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChallnelerSlabInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChallnelerSlabInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChallnelerSlabInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ChallnelerSlabInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChallnelerSlabInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChallnelerSlabInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChallnelerSlabInfo parseFrom(CodedInputStream input) throws IOException {
            return (ChallnelerSlabInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChallnelerSlabInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChallnelerSlabInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChallnelerSlabInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChallnelerSlabInfoOuterClass$ChallnelerSlabInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChallnelerSlabInfoOrBuilder {
            private int bitField0_;
            private ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfo buffInfo_;
            private SingleFieldBuilderV3<ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfo, ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfo.Builder, ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder> buffInfoBuilder_;
            private int playEndTime_;
            private ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfo loopDungeonStageInfo_;
            private SingleFieldBuilderV3<ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfo, ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfo.Builder, ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder> loopDungeonStageInfoBuilder_;
            private List<ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage> stageList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage, ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage.Builder, ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder> stageListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ChallnelerSlabInfoOuterClass.internal_static_ChallnelerSlabInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChallnelerSlabInfoOuterClass.internal_static_ChallnelerSlabInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallnelerSlabInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChallnelerSlabInfo.alwaysUseFieldBuilders) {
                    getStageListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.buffInfoBuilder_ == null) {
                    this.buffInfo_ = null;
                } else {
                    this.buffInfo_ = null;
                    this.buffInfoBuilder_ = null;
                }
                this.playEndTime_ = 0;
                if (this.loopDungeonStageInfoBuilder_ == null) {
                    this.loopDungeonStageInfo_ = null;
                } else {
                    this.loopDungeonStageInfo_ = null;
                    this.loopDungeonStageInfoBuilder_ = null;
                }
                if (this.stageListBuilder_ == null) {
                    this.stageList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.stageListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChallnelerSlabInfoOuterClass.internal_static_ChallnelerSlabInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChallnelerSlabInfo getDefaultInstanceForType() {
                return ChallnelerSlabInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChallnelerSlabInfo build() {
                ChallnelerSlabInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChallnelerSlabInfo buildPartial() {
                ChallnelerSlabInfo result = new ChallnelerSlabInfo(this);
                int i = this.bitField0_;
                if (this.buffInfoBuilder_ == null) {
                    result.buffInfo_ = this.buffInfo_;
                } else {
                    result.buffInfo_ = this.buffInfoBuilder_.build();
                }
                result.playEndTime_ = this.playEndTime_;
                if (this.loopDungeonStageInfoBuilder_ == null) {
                    result.loopDungeonStageInfo_ = this.loopDungeonStageInfo_;
                } else {
                    result.loopDungeonStageInfo_ = this.loopDungeonStageInfoBuilder_.build();
                }
                if (this.stageListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.stageList_ = Collections.unmodifiableList(this.stageList_);
                        this.bitField0_ &= -2;
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
                if (other instanceof ChallnelerSlabInfo) {
                    return mergeFrom((ChallnelerSlabInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChallnelerSlabInfo other) {
                if (other == ChallnelerSlabInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasBuffInfo()) {
                    mergeBuffInfo(other.getBuffInfo());
                }
                if (other.getPlayEndTime() != 0) {
                    setPlayEndTime(other.getPlayEndTime());
                }
                if (other.hasLoopDungeonStageInfo()) {
                    mergeLoopDungeonStageInfo(other.getLoopDungeonStageInfo());
                }
                if (this.stageListBuilder_ == null) {
                    if (!other.stageList_.isEmpty()) {
                        if (this.stageList_.isEmpty()) {
                            this.stageList_ = other.stageList_;
                            this.bitField0_ &= -2;
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
                        this.bitField0_ &= -2;
                        this.stageListBuilder_ = ChallnelerSlabInfo.alwaysUseFieldBuilders ? getStageListFieldBuilder() : null;
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
                ChallnelerSlabInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChallnelerSlabInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChallnelerSlabInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
            public boolean hasBuffInfo() {
                return (this.buffInfoBuilder_ == null && this.buffInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
            public ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfo getBuffInfo() {
                if (this.buffInfoBuilder_ == null) {
                    return this.buffInfo_ == null ? ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfo.getDefaultInstance() : this.buffInfo_;
                }
                return this.buffInfoBuilder_.getMessage();
            }

            public Builder setBuffInfo(ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfo value) {
                if (this.buffInfoBuilder_ != null) {
                    this.buffInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.buffInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setBuffInfo(ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfo.Builder builderForValue) {
                if (this.buffInfoBuilder_ == null) {
                    this.buffInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.buffInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeBuffInfo(ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfo value) {
                if (this.buffInfoBuilder_ == null) {
                    if (this.buffInfo_ != null) {
                        this.buffInfo_ = ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfo.newBuilder(this.buffInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.buffInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.buffInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearBuffInfo() {
                if (this.buffInfoBuilder_ == null) {
                    this.buffInfo_ = null;
                    onChanged();
                } else {
                    this.buffInfo_ = null;
                    this.buffInfoBuilder_ = null;
                }
                return this;
            }

            public ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfo.Builder getBuffInfoBuilder() {
                onChanged();
                return getBuffInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
            public ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder getBuffInfoOrBuilder() {
                if (this.buffInfoBuilder_ != null) {
                    return this.buffInfoBuilder_.getMessageOrBuilder();
                }
                return this.buffInfo_ == null ? ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfo.getDefaultInstance() : this.buffInfo_;
            }

            private SingleFieldBuilderV3<ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfo, ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfo.Builder, ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder> getBuffInfoFieldBuilder() {
                if (this.buffInfoBuilder_ == null) {
                    this.buffInfoBuilder_ = new SingleFieldBuilderV3<>(getBuffInfo(), getParentForChildren(), isClean());
                    this.buffInfo_ = null;
                }
                return this.buffInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
            public int getPlayEndTime() {
                return this.playEndTime_;
            }

            public Builder setPlayEndTime(int value) {
                this.playEndTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayEndTime() {
                this.playEndTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
            public boolean hasLoopDungeonStageInfo() {
                return (this.loopDungeonStageInfoBuilder_ == null && this.loopDungeonStageInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
            public ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfo getLoopDungeonStageInfo() {
                if (this.loopDungeonStageInfoBuilder_ == null) {
                    return this.loopDungeonStageInfo_ == null ? ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfo.getDefaultInstance() : this.loopDungeonStageInfo_;
                }
                return this.loopDungeonStageInfoBuilder_.getMessage();
            }

            public Builder setLoopDungeonStageInfo(ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfo value) {
                if (this.loopDungeonStageInfoBuilder_ != null) {
                    this.loopDungeonStageInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.loopDungeonStageInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setLoopDungeonStageInfo(ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfo.Builder builderForValue) {
                if (this.loopDungeonStageInfoBuilder_ == null) {
                    this.loopDungeonStageInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.loopDungeonStageInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeLoopDungeonStageInfo(ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfo value) {
                if (this.loopDungeonStageInfoBuilder_ == null) {
                    if (this.loopDungeonStageInfo_ != null) {
                        this.loopDungeonStageInfo_ = ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfo.newBuilder(this.loopDungeonStageInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.loopDungeonStageInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.loopDungeonStageInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearLoopDungeonStageInfo() {
                if (this.loopDungeonStageInfoBuilder_ == null) {
                    this.loopDungeonStageInfo_ = null;
                    onChanged();
                } else {
                    this.loopDungeonStageInfo_ = null;
                    this.loopDungeonStageInfoBuilder_ = null;
                }
                return this;
            }

            public ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfo.Builder getLoopDungeonStageInfoBuilder() {
                onChanged();
                return getLoopDungeonStageInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
            public ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder getLoopDungeonStageInfoOrBuilder() {
                if (this.loopDungeonStageInfoBuilder_ != null) {
                    return this.loopDungeonStageInfoBuilder_.getMessageOrBuilder();
                }
                return this.loopDungeonStageInfo_ == null ? ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfo.getDefaultInstance() : this.loopDungeonStageInfo_;
            }

            private SingleFieldBuilderV3<ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfo, ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfo.Builder, ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder> getLoopDungeonStageInfoFieldBuilder() {
                if (this.loopDungeonStageInfoBuilder_ == null) {
                    this.loopDungeonStageInfoBuilder_ = new SingleFieldBuilderV3<>(getLoopDungeonStageInfo(), getParentForChildren(), isClean());
                    this.loopDungeonStageInfo_ = null;
                }
                return this.loopDungeonStageInfoBuilder_;
            }

            private void ensureStageListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.stageList_ = new ArrayList(this.stageList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
            public List<ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage> getStageListList() {
                if (this.stageListBuilder_ == null) {
                    return Collections.unmodifiableList(this.stageList_);
                }
                return this.stageListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
            public int getStageListCount() {
                if (this.stageListBuilder_ == null) {
                    return this.stageList_.size();
                }
                return this.stageListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
            public ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage getStageList(int index) {
                if (this.stageListBuilder_ == null) {
                    return this.stageList_.get(index);
                }
                return this.stageListBuilder_.getMessage(index);
            }

            public Builder setStageList(int index, ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage value) {
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

            public Builder setStageList(int index, ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage.Builder builderForValue) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    this.stageList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addStageList(ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage value) {
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

            public Builder addStageList(int index, ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage value) {
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

            public Builder addStageList(ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage.Builder builderForValue) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    this.stageList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.stageListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addStageList(int index, ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage.Builder builderForValue) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    this.stageList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllStageList(Iterable<? extends ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage> values) {
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
                    this.bitField0_ &= -2;
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

            public ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage.Builder getStageListBuilder(int index) {
                return getStageListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
            public ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder getStageListOrBuilder(int index) {
                if (this.stageListBuilder_ == null) {
                    return this.stageList_.get(index);
                }
                return this.stageListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder
            public List<? extends ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder> getStageListOrBuilderList() {
                if (this.stageListBuilder_ != null) {
                    return this.stageListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.stageList_);
            }

            public ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage.Builder addStageListBuilder() {
                return getStageListFieldBuilder().addBuilder(ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage.getDefaultInstance());
            }

            public ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage.Builder addStageListBuilder(int index) {
                return getStageListFieldBuilder().addBuilder(index, ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage.getDefaultInstance());
            }

            public List<ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage.Builder> getStageListBuilderList() {
                return getStageListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage, ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage.Builder, ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder> getStageListFieldBuilder() {
                if (this.stageListBuilder_ == null) {
                    this.stageListBuilder_ = new RepeatedFieldBuilderV3<>(this.stageList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
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

        public static ChallnelerSlabInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChallnelerSlabInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChallnelerSlabInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChallnelerSlabInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ChannelerSlabBuffInfoOuterClass.getDescriptor();
        ChannelerSlabLoopDungeonStageInfoOuterClass.getDescriptor();
        ChannelerSlabChallengeStageOuterClass.getDescriptor();
    }
}
