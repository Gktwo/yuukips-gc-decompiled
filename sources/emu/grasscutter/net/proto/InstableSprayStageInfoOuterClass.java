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
import emu.grasscutter.net.proto.InstableSprayTeamInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InstableSprayStageInfoOuterClass.class */
public final class InstableSprayStageInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cInstableSprayStageInfo.proto\u001a\u001bInstableSprayTeamInfo.proto\"\u0001\n\u0016InstableSprayStageInfo\u0012\u0013\n\u000bis_finished\u0018\f \u0001(\b\u0012\u0010\n\bstage_id\u0018\u0002 \u0001(\r\u0012.\n\u000eteam_info_list\u0018\t \u0003(\u000b2\u0016.InstableSprayTeamInfo\u0012\u0011\n\tmax_score\u0018\u0007 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{InstableSprayTeamInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_InstableSprayStageInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_InstableSprayStageInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_InstableSprayStageInfo_descriptor, new String[]{"IsFinished", "StageId", "TeamInfoList", "MaxScore"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InstableSprayStageInfoOuterClass$InstableSprayStageInfoOrBuilder.class */
    public interface InstableSprayStageInfoOrBuilder extends MessageOrBuilder {
        boolean getIsFinished();

        int getStageId();

        List<InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo> getTeamInfoListList();

        InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo getTeamInfoList(int i);

        int getTeamInfoListCount();

        List<? extends InstableSprayTeamInfoOuterClass.InstableSprayTeamInfoOrBuilder> getTeamInfoListOrBuilderList();

        InstableSprayTeamInfoOuterClass.InstableSprayTeamInfoOrBuilder getTeamInfoListOrBuilder(int i);

        int getMaxScore();
    }

    private InstableSprayStageInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InstableSprayStageInfoOuterClass$InstableSprayStageInfo.class */
    public static final class InstableSprayStageInfo extends GeneratedMessageV3 implements InstableSprayStageInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_FINISHED_FIELD_NUMBER = 12;
        private boolean isFinished_;
        public static final int STAGE_ID_FIELD_NUMBER = 2;
        private int stageId_;
        public static final int TEAM_INFO_LIST_FIELD_NUMBER = 9;
        private List<InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo> teamInfoList_;
        public static final int MAX_SCORE_FIELD_NUMBER = 7;
        private int maxScore_;
        private byte memoizedIsInitialized;
        private static final InstableSprayStageInfo DEFAULT_INSTANCE = new InstableSprayStageInfo();
        private static final Parser<InstableSprayStageInfo> PARSER = new AbstractParser<InstableSprayStageInfo>() { // from class: emu.grasscutter.net.proto.InstableSprayStageInfoOuterClass.InstableSprayStageInfo.1
            @Override // com.google.protobuf.Parser
            public InstableSprayStageInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new InstableSprayStageInfo(input, extensionRegistry);
            }
        };

        private InstableSprayStageInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private InstableSprayStageInfo() {
            this.memoizedIsInitialized = -1;
            this.teamInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new InstableSprayStageInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private InstableSprayStageInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                this.stageId_ = input.readUInt32();
                                break;
                            case 56:
                                this.maxScore_ = input.readUInt32();
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.teamInfoList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.teamInfoList_.add((InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo) input.readMessage(InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo.parser(), extensionRegistry));
                                break;
                            case 96:
                                this.isFinished_ = input.readBool();
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
                    this.teamInfoList_ = Collections.unmodifiableList(this.teamInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return InstableSprayStageInfoOuterClass.internal_static_InstableSprayStageInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return InstableSprayStageInfoOuterClass.internal_static_InstableSprayStageInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(InstableSprayStageInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.InstableSprayStageInfoOuterClass.InstableSprayStageInfoOrBuilder
        public boolean getIsFinished() {
            return this.isFinished_;
        }

        @Override // emu.grasscutter.net.proto.InstableSprayStageInfoOuterClass.InstableSprayStageInfoOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.InstableSprayStageInfoOuterClass.InstableSprayStageInfoOrBuilder
        public List<InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo> getTeamInfoListList() {
            return this.teamInfoList_;
        }

        @Override // emu.grasscutter.net.proto.InstableSprayStageInfoOuterClass.InstableSprayStageInfoOrBuilder
        public List<? extends InstableSprayTeamInfoOuterClass.InstableSprayTeamInfoOrBuilder> getTeamInfoListOrBuilderList() {
            return this.teamInfoList_;
        }

        @Override // emu.grasscutter.net.proto.InstableSprayStageInfoOuterClass.InstableSprayStageInfoOrBuilder
        public int getTeamInfoListCount() {
            return this.teamInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.InstableSprayStageInfoOuterClass.InstableSprayStageInfoOrBuilder
        public InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo getTeamInfoList(int index) {
            return this.teamInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.InstableSprayStageInfoOuterClass.InstableSprayStageInfoOrBuilder
        public InstableSprayTeamInfoOuterClass.InstableSprayTeamInfoOrBuilder getTeamInfoListOrBuilder(int index) {
            return this.teamInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.InstableSprayStageInfoOuterClass.InstableSprayStageInfoOrBuilder
        public int getMaxScore() {
            return this.maxScore_;
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
                output.writeUInt32(2, this.stageId_);
            }
            if (this.maxScore_ != 0) {
                output.writeUInt32(7, this.maxScore_);
            }
            for (int i = 0; i < this.teamInfoList_.size(); i++) {
                output.writeMessage(9, this.teamInfoList_.get(i));
            }
            if (this.isFinished_) {
                output.writeBool(12, this.isFinished_);
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.stageId_);
            }
            if (this.maxScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.maxScore_);
            }
            for (int i = 0; i < this.teamInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(9, this.teamInfoList_.get(i));
            }
            if (this.isFinished_) {
                size2 += CodedOutputStream.computeBoolSize(12, this.isFinished_);
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
            if (!(obj instanceof InstableSprayStageInfo)) {
                return equals(obj);
            }
            InstableSprayStageInfo other = (InstableSprayStageInfo) obj;
            return getIsFinished() == other.getIsFinished() && getStageId() == other.getStageId() && getTeamInfoListList().equals(other.getTeamInfoListList()) && getMaxScore() == other.getMaxScore() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + Internal.hashBoolean(getIsFinished()))) + 2)) + getStageId();
            if (getTeamInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getTeamInfoListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 7)) + getMaxScore())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static InstableSprayStageInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InstableSprayStageInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InstableSprayStageInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InstableSprayStageInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InstableSprayStageInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InstableSprayStageInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InstableSprayStageInfo parseFrom(InputStream input) throws IOException {
            return (InstableSprayStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static InstableSprayStageInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InstableSprayStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static InstableSprayStageInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (InstableSprayStageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static InstableSprayStageInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InstableSprayStageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static InstableSprayStageInfo parseFrom(CodedInputStream input) throws IOException {
            return (InstableSprayStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static InstableSprayStageInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InstableSprayStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(InstableSprayStageInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InstableSprayStageInfoOuterClass$InstableSprayStageInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements InstableSprayStageInfoOrBuilder {
            private int bitField0_;
            private boolean isFinished_;
            private int stageId_;
            private List<InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo> teamInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo, InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo.Builder, InstableSprayTeamInfoOuterClass.InstableSprayTeamInfoOrBuilder> teamInfoListBuilder_;
            private int maxScore_;

            public static final Descriptors.Descriptor getDescriptor() {
                return InstableSprayStageInfoOuterClass.internal_static_InstableSprayStageInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return InstableSprayStageInfoOuterClass.internal_static_InstableSprayStageInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(InstableSprayStageInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (InstableSprayStageInfo.alwaysUseFieldBuilders) {
                    getTeamInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isFinished_ = false;
                this.stageId_ = 0;
                if (this.teamInfoListBuilder_ == null) {
                    this.teamInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.teamInfoListBuilder_.clear();
                }
                this.maxScore_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return InstableSprayStageInfoOuterClass.internal_static_InstableSprayStageInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public InstableSprayStageInfo getDefaultInstanceForType() {
                return InstableSprayStageInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public InstableSprayStageInfo build() {
                InstableSprayStageInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public InstableSprayStageInfo buildPartial() {
                InstableSprayStageInfo result = new InstableSprayStageInfo(this);
                int i = this.bitField0_;
                result.isFinished_ = this.isFinished_;
                result.stageId_ = this.stageId_;
                if (this.teamInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.teamInfoList_ = Collections.unmodifiableList(this.teamInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.teamInfoList_ = this.teamInfoList_;
                } else {
                    result.teamInfoList_ = this.teamInfoListBuilder_.build();
                }
                result.maxScore_ = this.maxScore_;
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
                if (other instanceof InstableSprayStageInfo) {
                    return mergeFrom((InstableSprayStageInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(InstableSprayStageInfo other) {
                if (other == InstableSprayStageInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsFinished()) {
                    setIsFinished(other.getIsFinished());
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (this.teamInfoListBuilder_ == null) {
                    if (!other.teamInfoList_.isEmpty()) {
                        if (this.teamInfoList_.isEmpty()) {
                            this.teamInfoList_ = other.teamInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureTeamInfoListIsMutable();
                            this.teamInfoList_.addAll(other.teamInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.teamInfoList_.isEmpty()) {
                    if (this.teamInfoListBuilder_.isEmpty()) {
                        this.teamInfoListBuilder_.dispose();
                        this.teamInfoListBuilder_ = null;
                        this.teamInfoList_ = other.teamInfoList_;
                        this.bitField0_ &= -2;
                        this.teamInfoListBuilder_ = InstableSprayStageInfo.alwaysUseFieldBuilders ? getTeamInfoListFieldBuilder() : null;
                    } else {
                        this.teamInfoListBuilder_.addAllMessages(other.teamInfoList_);
                    }
                }
                if (other.getMaxScore() != 0) {
                    setMaxScore(other.getMaxScore());
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
                InstableSprayStageInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = InstableSprayStageInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (InstableSprayStageInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.InstableSprayStageInfoOuterClass.InstableSprayStageInfoOrBuilder
            public boolean getIsFinished() {
                return this.isFinished_;
            }

            public Builder setIsFinished(boolean value) {
                this.isFinished_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFinished() {
                this.isFinished_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.InstableSprayStageInfoOuterClass.InstableSprayStageInfoOrBuilder
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

            private void ensureTeamInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.teamInfoList_ = new ArrayList(this.teamInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.InstableSprayStageInfoOuterClass.InstableSprayStageInfoOrBuilder
            public List<InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo> getTeamInfoListList() {
                if (this.teamInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.teamInfoList_);
                }
                return this.teamInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.InstableSprayStageInfoOuterClass.InstableSprayStageInfoOrBuilder
            public int getTeamInfoListCount() {
                if (this.teamInfoListBuilder_ == null) {
                    return this.teamInfoList_.size();
                }
                return this.teamInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.InstableSprayStageInfoOuterClass.InstableSprayStageInfoOrBuilder
            public InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo getTeamInfoList(int index) {
                if (this.teamInfoListBuilder_ == null) {
                    return this.teamInfoList_.get(index);
                }
                return this.teamInfoListBuilder_.getMessage(index);
            }

            public Builder setTeamInfoList(int index, InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo value) {
                if (this.teamInfoListBuilder_ != null) {
                    this.teamInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTeamInfoListIsMutable();
                    this.teamInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTeamInfoList(int index, InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo.Builder builderForValue) {
                if (this.teamInfoListBuilder_ == null) {
                    ensureTeamInfoListIsMutable();
                    this.teamInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.teamInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTeamInfoList(InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo value) {
                if (this.teamInfoListBuilder_ != null) {
                    this.teamInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTeamInfoListIsMutable();
                    this.teamInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTeamInfoList(int index, InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo value) {
                if (this.teamInfoListBuilder_ != null) {
                    this.teamInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTeamInfoListIsMutable();
                    this.teamInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTeamInfoList(InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo.Builder builderForValue) {
                if (this.teamInfoListBuilder_ == null) {
                    ensureTeamInfoListIsMutable();
                    this.teamInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.teamInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTeamInfoList(int index, InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo.Builder builderForValue) {
                if (this.teamInfoListBuilder_ == null) {
                    ensureTeamInfoListIsMutable();
                    this.teamInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.teamInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTeamInfoList(Iterable<? extends InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo> values) {
                if (this.teamInfoListBuilder_ == null) {
                    ensureTeamInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.teamInfoList_);
                    onChanged();
                } else {
                    this.teamInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTeamInfoList() {
                if (this.teamInfoListBuilder_ == null) {
                    this.teamInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.teamInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTeamInfoList(int index) {
                if (this.teamInfoListBuilder_ == null) {
                    ensureTeamInfoListIsMutable();
                    this.teamInfoList_.remove(index);
                    onChanged();
                } else {
                    this.teamInfoListBuilder_.remove(index);
                }
                return this;
            }

            public InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo.Builder getTeamInfoListBuilder(int index) {
                return getTeamInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.InstableSprayStageInfoOuterClass.InstableSprayStageInfoOrBuilder
            public InstableSprayTeamInfoOuterClass.InstableSprayTeamInfoOrBuilder getTeamInfoListOrBuilder(int index) {
                if (this.teamInfoListBuilder_ == null) {
                    return this.teamInfoList_.get(index);
                }
                return this.teamInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.InstableSprayStageInfoOuterClass.InstableSprayStageInfoOrBuilder
            public List<? extends InstableSprayTeamInfoOuterClass.InstableSprayTeamInfoOrBuilder> getTeamInfoListOrBuilderList() {
                if (this.teamInfoListBuilder_ != null) {
                    return this.teamInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.teamInfoList_);
            }

            public InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo.Builder addTeamInfoListBuilder() {
                return getTeamInfoListFieldBuilder().addBuilder(InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo.getDefaultInstance());
            }

            public InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo.Builder addTeamInfoListBuilder(int index) {
                return getTeamInfoListFieldBuilder().addBuilder(index, InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo.getDefaultInstance());
            }

            public List<InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo.Builder> getTeamInfoListBuilderList() {
                return getTeamInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo, InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo.Builder, InstableSprayTeamInfoOuterClass.InstableSprayTeamInfoOrBuilder> getTeamInfoListFieldBuilder() {
                if (this.teamInfoListBuilder_ == null) {
                    this.teamInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.teamInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.teamInfoList_ = null;
                }
                return this.teamInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.InstableSprayStageInfoOuterClass.InstableSprayStageInfoOrBuilder
            public int getMaxScore() {
                return this.maxScore_;
            }

            public Builder setMaxScore(int value) {
                this.maxScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxScore() {
                this.maxScore_ = 0;
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

        public static InstableSprayStageInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<InstableSprayStageInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<InstableSprayStageInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public InstableSprayStageInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        InstableSprayTeamInfoOuterClass.getDescriptor();
    }
}
