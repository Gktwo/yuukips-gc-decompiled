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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.ChannelerSlabChallengeOuterClass;
import emu.grasscutter.net.proto.ChannelerSlabOneoffDungeonOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabChallengeStageOuterClass.class */
public final class ChannelerSlabChallengeStageOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!ChannelerSlabChallengeStage.proto\u001a\u001cChannelerSlabChallenge.proto\u001a ChannelerSlabOneoffDungeon.proto\"·\u0001\n\u001bChannelerSlabChallengeStage\u0012\u000f\n\u0007is_open\u0018\u0004 \u0001(\b\u00121\n\fdungeon_info\u0018\f \u0001(\u000b2\u001b.ChannelerSlabOneoffDungeon\u0012\u0011\n\topen_time\u0018\r \u0001(\r\u0012\u0010\n\bstage_id\u0018\u0001 \u0001(\r\u0012/\n\u000echallenge_list\u0018\u0002 \u0003(\u000b2\u0017.ChannelerSlabChallengeB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ChannelerSlabChallengeOuterClass.getDescriptor(), ChannelerSlabOneoffDungeonOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ChannelerSlabChallengeStage_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChannelerSlabChallengeStage_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChannelerSlabChallengeStage_descriptor, new String[]{"IsOpen", "DungeonInfo", "OpenTime", "StageId", "ChallengeList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabChallengeStageOuterClass$ChannelerSlabChallengeStageOrBuilder.class */
    public interface ChannelerSlabChallengeStageOrBuilder extends MessageOrBuilder {
        boolean getIsOpen();

        boolean hasDungeonInfo();

        ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeon getDungeonInfo();

        ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeonOrBuilder getDungeonInfoOrBuilder();

        int getOpenTime();

        int getStageId();

        List<ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge> getChallengeListList();

        ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge getChallengeList(int i);

        int getChallengeListCount();

        List<? extends ChannelerSlabChallengeOuterClass.ChannelerSlabChallengeOrBuilder> getChallengeListOrBuilderList();

        ChannelerSlabChallengeOuterClass.ChannelerSlabChallengeOrBuilder getChallengeListOrBuilder(int i);
    }

    private ChannelerSlabChallengeStageOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabChallengeStageOuterClass$ChannelerSlabChallengeStage.class */
    public static final class ChannelerSlabChallengeStage extends GeneratedMessageV3 implements ChannelerSlabChallengeStageOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_OPEN_FIELD_NUMBER = 4;
        private boolean isOpen_;
        public static final int DUNGEON_INFO_FIELD_NUMBER = 12;
        private ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeon dungeonInfo_;
        public static final int OPEN_TIME_FIELD_NUMBER = 13;
        private int openTime_;
        public static final int STAGE_ID_FIELD_NUMBER = 1;
        private int stageId_;
        public static final int CHALLENGE_LIST_FIELD_NUMBER = 2;
        private List<ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge> challengeList_;
        private byte memoizedIsInitialized;
        private static final ChannelerSlabChallengeStage DEFAULT_INSTANCE = new ChannelerSlabChallengeStage();
        private static final Parser<ChannelerSlabChallengeStage> PARSER = new AbstractParser<ChannelerSlabChallengeStage>() { // from class: emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStage.1
            @Override // com.google.protobuf.Parser
            public ChannelerSlabChallengeStage parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChannelerSlabChallengeStage(input, extensionRegistry);
            }
        };

        private ChannelerSlabChallengeStage(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ChannelerSlabChallengeStage() {
            this.memoizedIsInitialized = -1;
            this.challengeList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChannelerSlabChallengeStage();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChannelerSlabChallengeStage(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.stageId_ = input.readUInt32();
                                break;
                            case 18:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.challengeList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.challengeList_.add((ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge) input.readMessage(ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge.parser(), extensionRegistry));
                                break;
                            case 32:
                                this.isOpen_ = input.readBool();
                                break;
                            case 98:
                                ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeon.Builder subBuilder = this.dungeonInfo_ != null ? this.dungeonInfo_.toBuilder() : null;
                                this.dungeonInfo_ = (ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeon) input.readMessage(ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeon.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.dungeonInfo_);
                                    this.dungeonInfo_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 104:
                                this.openTime_ = input.readUInt32();
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
                    this.challengeList_ = Collections.unmodifiableList(this.challengeList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ChannelerSlabChallengeStageOuterClass.internal_static_ChannelerSlabChallengeStage_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChannelerSlabChallengeStageOuterClass.internal_static_ChannelerSlabChallengeStage_fieldAccessorTable.ensureFieldAccessorsInitialized(ChannelerSlabChallengeStage.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder
        public boolean hasDungeonInfo() {
            return this.dungeonInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder
        public ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeon getDungeonInfo() {
            return this.dungeonInfo_ == null ? ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeon.getDefaultInstance() : this.dungeonInfo_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder
        public ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeonOrBuilder getDungeonInfoOrBuilder() {
            return getDungeonInfo();
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder
        public int getOpenTime() {
            return this.openTime_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder
        public List<ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge> getChallengeListList() {
            return this.challengeList_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder
        public List<? extends ChannelerSlabChallengeOuterClass.ChannelerSlabChallengeOrBuilder> getChallengeListOrBuilderList() {
            return this.challengeList_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder
        public int getChallengeListCount() {
            return this.challengeList_.size();
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder
        public ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge getChallengeList(int index) {
            return this.challengeList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder
        public ChannelerSlabChallengeOuterClass.ChannelerSlabChallengeOrBuilder getChallengeListOrBuilder(int index) {
            return this.challengeList_.get(index);
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
            if (this.stageId_ != 0) {
                output.writeUInt32(1, this.stageId_);
            }
            for (int i = 0; i < this.challengeList_.size(); i++) {
                output.writeMessage(2, this.challengeList_.get(i));
            }
            if (this.isOpen_) {
                output.writeBool(4, this.isOpen_);
            }
            if (this.dungeonInfo_ != null) {
                output.writeMessage(12, getDungeonInfo());
            }
            if (this.openTime_ != 0) {
                output.writeUInt32(13, this.openTime_);
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.stageId_);
            }
            for (int i = 0; i < this.challengeList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.challengeList_.get(i));
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.isOpen_);
            }
            if (this.dungeonInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(12, getDungeonInfo());
            }
            if (this.openTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.openTime_);
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
            if (!(obj instanceof ChannelerSlabChallengeStage)) {
                return equals(obj);
            }
            ChannelerSlabChallengeStage other = (ChannelerSlabChallengeStage) obj;
            if (getIsOpen() == other.getIsOpen() && hasDungeonInfo() == other.hasDungeonInfo()) {
                return (!hasDungeonInfo() || getDungeonInfo().equals(other.getDungeonInfo())) && getOpenTime() == other.getOpenTime() && getStageId() == other.getStageId() && getChallengeListList().equals(other.getChallengeListList()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + Internal.hashBoolean(getIsOpen());
            if (hasDungeonInfo()) {
                hash = (53 * ((37 * hash) + 12)) + getDungeonInfo().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * hash) + 13)) + getOpenTime())) + 1)) + getStageId();
            if (getChallengeListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 2)) + getChallengeListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static ChannelerSlabChallengeStage parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabChallengeStage parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabChallengeStage parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabChallengeStage parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabChallengeStage parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabChallengeStage parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabChallengeStage parseFrom(InputStream input) throws IOException {
            return (ChannelerSlabChallengeStage) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChannelerSlabChallengeStage parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabChallengeStage) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChannelerSlabChallengeStage parseDelimitedFrom(InputStream input) throws IOException {
            return (ChannelerSlabChallengeStage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChannelerSlabChallengeStage parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabChallengeStage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChannelerSlabChallengeStage parseFrom(CodedInputStream input) throws IOException {
            return (ChannelerSlabChallengeStage) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChannelerSlabChallengeStage parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabChallengeStage) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChannelerSlabChallengeStage prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabChallengeStageOuterClass$ChannelerSlabChallengeStage$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChannelerSlabChallengeStageOrBuilder {
            private int bitField0_;
            private boolean isOpen_;
            private ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeon dungeonInfo_;
            private SingleFieldBuilderV3<ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeon, ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeon.Builder, ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeonOrBuilder> dungeonInfoBuilder_;
            private int openTime_;
            private int stageId_;
            private List<ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge> challengeList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge, ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge.Builder, ChannelerSlabChallengeOuterClass.ChannelerSlabChallengeOrBuilder> challengeListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ChannelerSlabChallengeStageOuterClass.internal_static_ChannelerSlabChallengeStage_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChannelerSlabChallengeStageOuterClass.internal_static_ChannelerSlabChallengeStage_fieldAccessorTable.ensureFieldAccessorsInitialized(ChannelerSlabChallengeStage.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChannelerSlabChallengeStage.alwaysUseFieldBuilders) {
                    getChallengeListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isOpen_ = false;
                if (this.dungeonInfoBuilder_ == null) {
                    this.dungeonInfo_ = null;
                } else {
                    this.dungeonInfo_ = null;
                    this.dungeonInfoBuilder_ = null;
                }
                this.openTime_ = 0;
                this.stageId_ = 0;
                if (this.challengeListBuilder_ == null) {
                    this.challengeList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.challengeListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChannelerSlabChallengeStageOuterClass.internal_static_ChannelerSlabChallengeStage_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChannelerSlabChallengeStage getDefaultInstanceForType() {
                return ChannelerSlabChallengeStage.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChannelerSlabChallengeStage build() {
                ChannelerSlabChallengeStage result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChannelerSlabChallengeStage buildPartial() {
                ChannelerSlabChallengeStage result = new ChannelerSlabChallengeStage(this);
                int i = this.bitField0_;
                result.isOpen_ = this.isOpen_;
                if (this.dungeonInfoBuilder_ == null) {
                    result.dungeonInfo_ = this.dungeonInfo_;
                } else {
                    result.dungeonInfo_ = this.dungeonInfoBuilder_.build();
                }
                result.openTime_ = this.openTime_;
                result.stageId_ = this.stageId_;
                if (this.challengeListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.challengeList_ = Collections.unmodifiableList(this.challengeList_);
                        this.bitField0_ &= -2;
                    }
                    result.challengeList_ = this.challengeList_;
                } else {
                    result.challengeList_ = this.challengeListBuilder_.build();
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
                if (other instanceof ChannelerSlabChallengeStage) {
                    return mergeFrom((ChannelerSlabChallengeStage) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChannelerSlabChallengeStage other) {
                if (other == ChannelerSlabChallengeStage.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (other.hasDungeonInfo()) {
                    mergeDungeonInfo(other.getDungeonInfo());
                }
                if (other.getOpenTime() != 0) {
                    setOpenTime(other.getOpenTime());
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (this.challengeListBuilder_ == null) {
                    if (!other.challengeList_.isEmpty()) {
                        if (this.challengeList_.isEmpty()) {
                            this.challengeList_ = other.challengeList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureChallengeListIsMutable();
                            this.challengeList_.addAll(other.challengeList_);
                        }
                        onChanged();
                    }
                } else if (!other.challengeList_.isEmpty()) {
                    if (this.challengeListBuilder_.isEmpty()) {
                        this.challengeListBuilder_.dispose();
                        this.challengeListBuilder_ = null;
                        this.challengeList_ = other.challengeList_;
                        this.bitField0_ &= -2;
                        this.challengeListBuilder_ = ChannelerSlabChallengeStage.alwaysUseFieldBuilders ? getChallengeListFieldBuilder() : null;
                    } else {
                        this.challengeListBuilder_.addAllMessages(other.challengeList_);
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
                ChannelerSlabChallengeStage parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChannelerSlabChallengeStage.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChannelerSlabChallengeStage) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            public Builder setIsOpen(boolean value) {
                this.isOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.isOpen_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder
            public boolean hasDungeonInfo() {
                return (this.dungeonInfoBuilder_ == null && this.dungeonInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder
            public ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeon getDungeonInfo() {
                if (this.dungeonInfoBuilder_ == null) {
                    return this.dungeonInfo_ == null ? ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeon.getDefaultInstance() : this.dungeonInfo_;
                }
                return this.dungeonInfoBuilder_.getMessage();
            }

            public Builder setDungeonInfo(ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeon value) {
                if (this.dungeonInfoBuilder_ != null) {
                    this.dungeonInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.dungeonInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setDungeonInfo(ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeon.Builder builderForValue) {
                if (this.dungeonInfoBuilder_ == null) {
                    this.dungeonInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.dungeonInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeDungeonInfo(ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeon value) {
                if (this.dungeonInfoBuilder_ == null) {
                    if (this.dungeonInfo_ != null) {
                        this.dungeonInfo_ = ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeon.newBuilder(this.dungeonInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.dungeonInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.dungeonInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearDungeonInfo() {
                if (this.dungeonInfoBuilder_ == null) {
                    this.dungeonInfo_ = null;
                    onChanged();
                } else {
                    this.dungeonInfo_ = null;
                    this.dungeonInfoBuilder_ = null;
                }
                return this;
            }

            public ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeon.Builder getDungeonInfoBuilder() {
                onChanged();
                return getDungeonInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder
            public ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeonOrBuilder getDungeonInfoOrBuilder() {
                if (this.dungeonInfoBuilder_ != null) {
                    return this.dungeonInfoBuilder_.getMessageOrBuilder();
                }
                return this.dungeonInfo_ == null ? ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeon.getDefaultInstance() : this.dungeonInfo_;
            }

            private SingleFieldBuilderV3<ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeon, ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeon.Builder, ChannelerSlabOneoffDungeonOuterClass.ChannelerSlabOneoffDungeonOrBuilder> getDungeonInfoFieldBuilder() {
                if (this.dungeonInfoBuilder_ == null) {
                    this.dungeonInfoBuilder_ = new SingleFieldBuilderV3<>(getDungeonInfo(), getParentForChildren(), isClean());
                    this.dungeonInfo_ = null;
                }
                return this.dungeonInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder
            public int getOpenTime() {
                return this.openTime_;
            }

            public Builder setOpenTime(int value) {
                this.openTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearOpenTime() {
                this.openTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder
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

            private void ensureChallengeListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.challengeList_ = new ArrayList(this.challengeList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder
            public List<ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge> getChallengeListList() {
                if (this.challengeListBuilder_ == null) {
                    return Collections.unmodifiableList(this.challengeList_);
                }
                return this.challengeListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder
            public int getChallengeListCount() {
                if (this.challengeListBuilder_ == null) {
                    return this.challengeList_.size();
                }
                return this.challengeListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder
            public ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge getChallengeList(int index) {
                if (this.challengeListBuilder_ == null) {
                    return this.challengeList_.get(index);
                }
                return this.challengeListBuilder_.getMessage(index);
            }

            public Builder setChallengeList(int index, ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge value) {
                if (this.challengeListBuilder_ != null) {
                    this.challengeListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChallengeListIsMutable();
                    this.challengeList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setChallengeList(int index, ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge.Builder builderForValue) {
                if (this.challengeListBuilder_ == null) {
                    ensureChallengeListIsMutable();
                    this.challengeList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.challengeListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addChallengeList(ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge value) {
                if (this.challengeListBuilder_ != null) {
                    this.challengeListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChallengeListIsMutable();
                    this.challengeList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addChallengeList(int index, ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge value) {
                if (this.challengeListBuilder_ != null) {
                    this.challengeListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChallengeListIsMutable();
                    this.challengeList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addChallengeList(ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge.Builder builderForValue) {
                if (this.challengeListBuilder_ == null) {
                    ensureChallengeListIsMutable();
                    this.challengeList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.challengeListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addChallengeList(int index, ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge.Builder builderForValue) {
                if (this.challengeListBuilder_ == null) {
                    ensureChallengeListIsMutable();
                    this.challengeList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.challengeListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllChallengeList(Iterable<? extends ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge> values) {
                if (this.challengeListBuilder_ == null) {
                    ensureChallengeListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.challengeList_);
                    onChanged();
                } else {
                    this.challengeListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearChallengeList() {
                if (this.challengeListBuilder_ == null) {
                    this.challengeList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.challengeListBuilder_.clear();
                }
                return this;
            }

            public Builder removeChallengeList(int index) {
                if (this.challengeListBuilder_ == null) {
                    ensureChallengeListIsMutable();
                    this.challengeList_.remove(index);
                    onChanged();
                } else {
                    this.challengeListBuilder_.remove(index);
                }
                return this;
            }

            public ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge.Builder getChallengeListBuilder(int index) {
                return getChallengeListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder
            public ChannelerSlabChallengeOuterClass.ChannelerSlabChallengeOrBuilder getChallengeListOrBuilder(int index) {
                if (this.challengeListBuilder_ == null) {
                    return this.challengeList_.get(index);
                }
                return this.challengeListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeStageOuterClass.ChannelerSlabChallengeStageOrBuilder
            public List<? extends ChannelerSlabChallengeOuterClass.ChannelerSlabChallengeOrBuilder> getChallengeListOrBuilderList() {
                if (this.challengeListBuilder_ != null) {
                    return this.challengeListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.challengeList_);
            }

            public ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge.Builder addChallengeListBuilder() {
                return getChallengeListFieldBuilder().addBuilder(ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge.getDefaultInstance());
            }

            public ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge.Builder addChallengeListBuilder(int index) {
                return getChallengeListFieldBuilder().addBuilder(index, ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge.getDefaultInstance());
            }

            public List<ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge.Builder> getChallengeListBuilderList() {
                return getChallengeListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge, ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge.Builder, ChannelerSlabChallengeOuterClass.ChannelerSlabChallengeOrBuilder> getChallengeListFieldBuilder() {
                if (this.challengeListBuilder_ == null) {
                    this.challengeListBuilder_ = new RepeatedFieldBuilderV3<>(this.challengeList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.challengeList_ = null;
                }
                return this.challengeListBuilder_;
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

        public static ChannelerSlabChallengeStage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChannelerSlabChallengeStage> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChannelerSlabChallengeStage> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChannelerSlabChallengeStage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ChannelerSlabChallengeOuterClass.getDescriptor();
        ChannelerSlabOneoffDungeonOuterClass.getDescriptor();
    }
}
