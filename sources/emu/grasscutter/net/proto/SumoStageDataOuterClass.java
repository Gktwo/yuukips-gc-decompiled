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
import emu.grasscutter.net.proto.SumoTeamDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SumoStageDataOuterClass.class */
public final class SumoStageDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013SumoStageData.proto\u001a\u0012SumoTeamData.proto\"z\n\rSumoStageData\u0012\u0010\n\bstage_id\u0018\u0002 \u0001(\r\u0012\u0011\n\topen_time\u0018\u000f \u0001(\r\u0012 \n\tteam_list\u0018\u0001 \u0003(\u000b2\r.SumoTeamData\u0012\u0011\n\tmax_score\u0018\u0007 \u0001(\r\u0012\u000f\n\u0007is_open\u0018\b \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SumoTeamDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SumoStageData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SumoStageData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SumoStageData_descriptor, new String[]{"StageId", "OpenTime", "TeamList", "MaxScore", "IsOpen"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SumoStageDataOuterClass$SumoStageDataOrBuilder.class */
    public interface SumoStageDataOrBuilder extends MessageOrBuilder {
        int getStageId();

        int getOpenTime();

        List<SumoTeamDataOuterClass.SumoTeamData> getTeamListList();

        SumoTeamDataOuterClass.SumoTeamData getTeamList(int i);

        int getTeamListCount();

        List<? extends SumoTeamDataOuterClass.SumoTeamDataOrBuilder> getTeamListOrBuilderList();

        SumoTeamDataOuterClass.SumoTeamDataOrBuilder getTeamListOrBuilder(int i);

        int getMaxScore();

        boolean getIsOpen();
    }

    private SumoStageDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SumoStageDataOuterClass$SumoStageData.class */
    public static final class SumoStageData extends GeneratedMessageV3 implements SumoStageDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STAGE_ID_FIELD_NUMBER = 2;
        private int stageId_;
        public static final int OPEN_TIME_FIELD_NUMBER = 15;
        private int openTime_;
        public static final int TEAM_LIST_FIELD_NUMBER = 1;
        private List<SumoTeamDataOuterClass.SumoTeamData> teamList_;
        public static final int MAX_SCORE_FIELD_NUMBER = 7;
        private int maxScore_;
        public static final int IS_OPEN_FIELD_NUMBER = 8;
        private boolean isOpen_;
        private byte memoizedIsInitialized;
        private static final SumoStageData DEFAULT_INSTANCE = new SumoStageData();
        private static final Parser<SumoStageData> PARSER = new AbstractParser<SumoStageData>() { // from class: emu.grasscutter.net.proto.SumoStageDataOuterClass.SumoStageData.1
            @Override // com.google.protobuf.Parser
            public SumoStageData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SumoStageData(input, extensionRegistry);
            }
        };

        private SumoStageData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SumoStageData() {
            this.memoizedIsInitialized = -1;
            this.teamList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SumoStageData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SumoStageData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.teamList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.teamList_.add((SumoTeamDataOuterClass.SumoTeamData) input.readMessage(SumoTeamDataOuterClass.SumoTeamData.parser(), extensionRegistry));
                                break;
                            case 16:
                                this.stageId_ = input.readUInt32();
                                break;
                            case 56:
                                this.maxScore_ = input.readUInt32();
                                break;
                            case 64:
                                this.isOpen_ = input.readBool();
                                break;
                            case 120:
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
                    this.teamList_ = Collections.unmodifiableList(this.teamList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SumoStageDataOuterClass.internal_static_SumoStageData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SumoStageDataOuterClass.internal_static_SumoStageData_fieldAccessorTable.ensureFieldAccessorsInitialized(SumoStageData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SumoStageDataOuterClass.SumoStageDataOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.SumoStageDataOuterClass.SumoStageDataOrBuilder
        public int getOpenTime() {
            return this.openTime_;
        }

        @Override // emu.grasscutter.net.proto.SumoStageDataOuterClass.SumoStageDataOrBuilder
        public List<SumoTeamDataOuterClass.SumoTeamData> getTeamListList() {
            return this.teamList_;
        }

        @Override // emu.grasscutter.net.proto.SumoStageDataOuterClass.SumoStageDataOrBuilder
        public List<? extends SumoTeamDataOuterClass.SumoTeamDataOrBuilder> getTeamListOrBuilderList() {
            return this.teamList_;
        }

        @Override // emu.grasscutter.net.proto.SumoStageDataOuterClass.SumoStageDataOrBuilder
        public int getTeamListCount() {
            return this.teamList_.size();
        }

        @Override // emu.grasscutter.net.proto.SumoStageDataOuterClass.SumoStageDataOrBuilder
        public SumoTeamDataOuterClass.SumoTeamData getTeamList(int index) {
            return this.teamList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SumoStageDataOuterClass.SumoStageDataOrBuilder
        public SumoTeamDataOuterClass.SumoTeamDataOrBuilder getTeamListOrBuilder(int index) {
            return this.teamList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SumoStageDataOuterClass.SumoStageDataOrBuilder
        public int getMaxScore() {
            return this.maxScore_;
        }

        @Override // emu.grasscutter.net.proto.SumoStageDataOuterClass.SumoStageDataOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
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
            for (int i = 0; i < this.teamList_.size(); i++) {
                output.writeMessage(1, this.teamList_.get(i));
            }
            if (this.stageId_ != 0) {
                output.writeUInt32(2, this.stageId_);
            }
            if (this.maxScore_ != 0) {
                output.writeUInt32(7, this.maxScore_);
            }
            if (this.isOpen_) {
                output.writeBool(8, this.isOpen_);
            }
            if (this.openTime_ != 0) {
                output.writeUInt32(15, this.openTime_);
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
            for (int i = 0; i < this.teamList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.teamList_.get(i));
            }
            if (this.stageId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.stageId_);
            }
            if (this.maxScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.maxScore_);
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.isOpen_);
            }
            if (this.openTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.openTime_);
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
            if (!(obj instanceof SumoStageData)) {
                return equals(obj);
            }
            SumoStageData other = (SumoStageData) obj;
            return getStageId() == other.getStageId() && getOpenTime() == other.getOpenTime() && getTeamListList().equals(other.getTeamListList()) && getMaxScore() == other.getMaxScore() && getIsOpen() == other.getIsOpen() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + getStageId())) + 15)) + getOpenTime();
            if (getTeamListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getTeamListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 7)) + getMaxScore())) + 8)) + Internal.hashBoolean(getIsOpen()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SumoStageData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SumoStageData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SumoStageData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SumoStageData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SumoStageData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SumoStageData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SumoStageData parseFrom(InputStream input) throws IOException {
            return (SumoStageData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SumoStageData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SumoStageData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SumoStageData parseDelimitedFrom(InputStream input) throws IOException {
            return (SumoStageData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SumoStageData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SumoStageData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SumoStageData parseFrom(CodedInputStream input) throws IOException {
            return (SumoStageData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SumoStageData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SumoStageData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SumoStageData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SumoStageDataOuterClass$SumoStageData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SumoStageDataOrBuilder {
            private int bitField0_;
            private int stageId_;
            private int openTime_;
            private List<SumoTeamDataOuterClass.SumoTeamData> teamList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<SumoTeamDataOuterClass.SumoTeamData, SumoTeamDataOuterClass.SumoTeamData.Builder, SumoTeamDataOuterClass.SumoTeamDataOrBuilder> teamListBuilder_;
            private int maxScore_;
            private boolean isOpen_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SumoStageDataOuterClass.internal_static_SumoStageData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SumoStageDataOuterClass.internal_static_SumoStageData_fieldAccessorTable.ensureFieldAccessorsInitialized(SumoStageData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SumoStageData.alwaysUseFieldBuilders) {
                    getTeamListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.stageId_ = 0;
                this.openTime_ = 0;
                if (this.teamListBuilder_ == null) {
                    this.teamList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.teamListBuilder_.clear();
                }
                this.maxScore_ = 0;
                this.isOpen_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SumoStageDataOuterClass.internal_static_SumoStageData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SumoStageData getDefaultInstanceForType() {
                return SumoStageData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SumoStageData build() {
                SumoStageData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SumoStageData buildPartial() {
                SumoStageData result = new SumoStageData(this);
                int i = this.bitField0_;
                result.stageId_ = this.stageId_;
                result.openTime_ = this.openTime_;
                if (this.teamListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.teamList_ = Collections.unmodifiableList(this.teamList_);
                        this.bitField0_ &= -2;
                    }
                    result.teamList_ = this.teamList_;
                } else {
                    result.teamList_ = this.teamListBuilder_.build();
                }
                result.maxScore_ = this.maxScore_;
                result.isOpen_ = this.isOpen_;
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
                if (other instanceof SumoStageData) {
                    return mergeFrom((SumoStageData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SumoStageData other) {
                if (other == SumoStageData.getDefaultInstance()) {
                    return this;
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (other.getOpenTime() != 0) {
                    setOpenTime(other.getOpenTime());
                }
                if (this.teamListBuilder_ == null) {
                    if (!other.teamList_.isEmpty()) {
                        if (this.teamList_.isEmpty()) {
                            this.teamList_ = other.teamList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureTeamListIsMutable();
                            this.teamList_.addAll(other.teamList_);
                        }
                        onChanged();
                    }
                } else if (!other.teamList_.isEmpty()) {
                    if (this.teamListBuilder_.isEmpty()) {
                        this.teamListBuilder_.dispose();
                        this.teamListBuilder_ = null;
                        this.teamList_ = other.teamList_;
                        this.bitField0_ &= -2;
                        this.teamListBuilder_ = SumoStageData.alwaysUseFieldBuilders ? getTeamListFieldBuilder() : null;
                    } else {
                        this.teamListBuilder_.addAllMessages(other.teamList_);
                    }
                }
                if (other.getMaxScore() != 0) {
                    setMaxScore(other.getMaxScore());
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
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
                SumoStageData parsedMessage = null;
                try {
                    try {
                        parsedMessage = SumoStageData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SumoStageData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SumoStageDataOuterClass.SumoStageDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.SumoStageDataOuterClass.SumoStageDataOrBuilder
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

            private void ensureTeamListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.teamList_ = new ArrayList(this.teamList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SumoStageDataOuterClass.SumoStageDataOrBuilder
            public List<SumoTeamDataOuterClass.SumoTeamData> getTeamListList() {
                if (this.teamListBuilder_ == null) {
                    return Collections.unmodifiableList(this.teamList_);
                }
                return this.teamListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SumoStageDataOuterClass.SumoStageDataOrBuilder
            public int getTeamListCount() {
                if (this.teamListBuilder_ == null) {
                    return this.teamList_.size();
                }
                return this.teamListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SumoStageDataOuterClass.SumoStageDataOrBuilder
            public SumoTeamDataOuterClass.SumoTeamData getTeamList(int index) {
                if (this.teamListBuilder_ == null) {
                    return this.teamList_.get(index);
                }
                return this.teamListBuilder_.getMessage(index);
            }

            public Builder setTeamList(int index, SumoTeamDataOuterClass.SumoTeamData value) {
                if (this.teamListBuilder_ != null) {
                    this.teamListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTeamListIsMutable();
                    this.teamList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTeamList(int index, SumoTeamDataOuterClass.SumoTeamData.Builder builderForValue) {
                if (this.teamListBuilder_ == null) {
                    ensureTeamListIsMutable();
                    this.teamList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.teamListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTeamList(SumoTeamDataOuterClass.SumoTeamData value) {
                if (this.teamListBuilder_ != null) {
                    this.teamListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTeamListIsMutable();
                    this.teamList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTeamList(int index, SumoTeamDataOuterClass.SumoTeamData value) {
                if (this.teamListBuilder_ != null) {
                    this.teamListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTeamListIsMutable();
                    this.teamList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTeamList(SumoTeamDataOuterClass.SumoTeamData.Builder builderForValue) {
                if (this.teamListBuilder_ == null) {
                    ensureTeamListIsMutable();
                    this.teamList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.teamListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTeamList(int index, SumoTeamDataOuterClass.SumoTeamData.Builder builderForValue) {
                if (this.teamListBuilder_ == null) {
                    ensureTeamListIsMutable();
                    this.teamList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.teamListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTeamList(Iterable<? extends SumoTeamDataOuterClass.SumoTeamData> values) {
                if (this.teamListBuilder_ == null) {
                    ensureTeamListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.teamList_);
                    onChanged();
                } else {
                    this.teamListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTeamList() {
                if (this.teamListBuilder_ == null) {
                    this.teamList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.teamListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTeamList(int index) {
                if (this.teamListBuilder_ == null) {
                    ensureTeamListIsMutable();
                    this.teamList_.remove(index);
                    onChanged();
                } else {
                    this.teamListBuilder_.remove(index);
                }
                return this;
            }

            public SumoTeamDataOuterClass.SumoTeamData.Builder getTeamListBuilder(int index) {
                return getTeamListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SumoStageDataOuterClass.SumoStageDataOrBuilder
            public SumoTeamDataOuterClass.SumoTeamDataOrBuilder getTeamListOrBuilder(int index) {
                if (this.teamListBuilder_ == null) {
                    return this.teamList_.get(index);
                }
                return this.teamListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SumoStageDataOuterClass.SumoStageDataOrBuilder
            public List<? extends SumoTeamDataOuterClass.SumoTeamDataOrBuilder> getTeamListOrBuilderList() {
                if (this.teamListBuilder_ != null) {
                    return this.teamListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.teamList_);
            }

            public SumoTeamDataOuterClass.SumoTeamData.Builder addTeamListBuilder() {
                return getTeamListFieldBuilder().addBuilder(SumoTeamDataOuterClass.SumoTeamData.getDefaultInstance());
            }

            public SumoTeamDataOuterClass.SumoTeamData.Builder addTeamListBuilder(int index) {
                return getTeamListFieldBuilder().addBuilder(index, SumoTeamDataOuterClass.SumoTeamData.getDefaultInstance());
            }

            public List<SumoTeamDataOuterClass.SumoTeamData.Builder> getTeamListBuilderList() {
                return getTeamListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<SumoTeamDataOuterClass.SumoTeamData, SumoTeamDataOuterClass.SumoTeamData.Builder, SumoTeamDataOuterClass.SumoTeamDataOrBuilder> getTeamListFieldBuilder() {
                if (this.teamListBuilder_ == null) {
                    this.teamListBuilder_ = new RepeatedFieldBuilderV3<>(this.teamList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.teamList_ = null;
                }
                return this.teamListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SumoStageDataOuterClass.SumoStageDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.SumoStageDataOuterClass.SumoStageDataOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static SumoStageData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SumoStageData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SumoStageData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SumoStageData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SumoTeamDataOuterClass.getDescriptor();
    }
}
