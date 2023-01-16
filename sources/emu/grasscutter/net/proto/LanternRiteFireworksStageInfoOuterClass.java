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
import emu.grasscutter.net.proto.LanternRiteFireworksChallengeInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternRiteFireworksStageInfoOuterClass.class */
public final class LanternRiteFireworksStageInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#LanternRiteFireworksStageInfo.proto\u001a'LanternRiteFireworksChallengeInfo.proto\"\u0001\n\u001dLanternRiteFireworksStageInfo\u0012\u0010\n\bstage_id\u0018\u000e \u0001(\r\u0012\u000f\n\u0007is_open\u0018\t \u0001(\b\u0012?\n\u0013challenge_info_list\u0018\u000b \u0003(\u000b2\".LanternRiteFireworksChallengeInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{LanternRiteFireworksChallengeInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_LanternRiteFireworksStageInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_LanternRiteFireworksStageInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_LanternRiteFireworksStageInfo_descriptor, new String[]{"StageId", "IsOpen", "ChallengeInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternRiteFireworksStageInfoOuterClass$LanternRiteFireworksStageInfoOrBuilder.class */
    public interface LanternRiteFireworksStageInfoOrBuilder extends MessageOrBuilder {
        int getStageId();

        boolean getIsOpen();

        List<LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo> getChallengeInfoListList();

        LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo getChallengeInfoList(int i);

        int getChallengeInfoListCount();

        List<? extends LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfoOrBuilder> getChallengeInfoListOrBuilderList();

        LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfoOrBuilder getChallengeInfoListOrBuilder(int i);
    }

    private LanternRiteFireworksStageInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternRiteFireworksStageInfoOuterClass$LanternRiteFireworksStageInfo.class */
    public static final class LanternRiteFireworksStageInfo extends GeneratedMessageV3 implements LanternRiteFireworksStageInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STAGE_ID_FIELD_NUMBER = 14;
        private int stageId_;
        public static final int IS_OPEN_FIELD_NUMBER = 9;
        private boolean isOpen_;
        public static final int CHALLENGE_INFO_LIST_FIELD_NUMBER = 11;
        private List<LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo> challengeInfoList_;
        private byte memoizedIsInitialized;
        private static final LanternRiteFireworksStageInfo DEFAULT_INSTANCE = new LanternRiteFireworksStageInfo();
        private static final Parser<LanternRiteFireworksStageInfo> PARSER = new AbstractParser<LanternRiteFireworksStageInfo>() { // from class: emu.grasscutter.net.proto.LanternRiteFireworksStageInfoOuterClass.LanternRiteFireworksStageInfo.1
            @Override // com.google.protobuf.Parser
            public LanternRiteFireworksStageInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LanternRiteFireworksStageInfo(input, extensionRegistry);
            }
        };

        private LanternRiteFireworksStageInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private LanternRiteFireworksStageInfo() {
            this.memoizedIsInitialized = -1;
            this.challengeInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new LanternRiteFireworksStageInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LanternRiteFireworksStageInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 72:
                                this.isOpen_ = input.readBool();
                                break;
                            case 90:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.challengeInfoList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.challengeInfoList_.add((LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo) input.readMessage(LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo.parser(), extensionRegistry));
                                break;
                            case 112:
                                this.stageId_ = input.readUInt32();
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
                    this.challengeInfoList_ = Collections.unmodifiableList(this.challengeInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LanternRiteFireworksStageInfoOuterClass.internal_static_LanternRiteFireworksStageInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LanternRiteFireworksStageInfoOuterClass.internal_static_LanternRiteFireworksStageInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LanternRiteFireworksStageInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.LanternRiteFireworksStageInfoOuterClass.LanternRiteFireworksStageInfoOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.LanternRiteFireworksStageInfoOuterClass.LanternRiteFireworksStageInfoOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.LanternRiteFireworksStageInfoOuterClass.LanternRiteFireworksStageInfoOrBuilder
        public List<LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo> getChallengeInfoListList() {
            return this.challengeInfoList_;
        }

        @Override // emu.grasscutter.net.proto.LanternRiteFireworksStageInfoOuterClass.LanternRiteFireworksStageInfoOrBuilder
        public List<? extends LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfoOrBuilder> getChallengeInfoListOrBuilderList() {
            return this.challengeInfoList_;
        }

        @Override // emu.grasscutter.net.proto.LanternRiteFireworksStageInfoOuterClass.LanternRiteFireworksStageInfoOrBuilder
        public int getChallengeInfoListCount() {
            return this.challengeInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.LanternRiteFireworksStageInfoOuterClass.LanternRiteFireworksStageInfoOrBuilder
        public LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo getChallengeInfoList(int index) {
            return this.challengeInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.LanternRiteFireworksStageInfoOuterClass.LanternRiteFireworksStageInfoOrBuilder
        public LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfoOrBuilder getChallengeInfoListOrBuilder(int index) {
            return this.challengeInfoList_.get(index);
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
            if (this.isOpen_) {
                output.writeBool(9, this.isOpen_);
            }
            for (int i = 0; i < this.challengeInfoList_.size(); i++) {
                output.writeMessage(11, this.challengeInfoList_.get(i));
            }
            if (this.stageId_ != 0) {
                output.writeUInt32(14, this.stageId_);
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
            if (this.isOpen_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(9, this.isOpen_);
            }
            for (int i = 0; i < this.challengeInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.challengeInfoList_.get(i));
            }
            if (this.stageId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.stageId_);
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
            if (!(obj instanceof LanternRiteFireworksStageInfo)) {
                return equals(obj);
            }
            LanternRiteFireworksStageInfo other = (LanternRiteFireworksStageInfo) obj;
            return getStageId() == other.getStageId() && getIsOpen() == other.getIsOpen() && getChallengeInfoListList().equals(other.getChallengeInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + getStageId())) + 9)) + Internal.hashBoolean(getIsOpen());
            if (getChallengeInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getChallengeInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static LanternRiteFireworksStageInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LanternRiteFireworksStageInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LanternRiteFireworksStageInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LanternRiteFireworksStageInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LanternRiteFireworksStageInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LanternRiteFireworksStageInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LanternRiteFireworksStageInfo parseFrom(InputStream input) throws IOException {
            return (LanternRiteFireworksStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LanternRiteFireworksStageInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LanternRiteFireworksStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static LanternRiteFireworksStageInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (LanternRiteFireworksStageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static LanternRiteFireworksStageInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LanternRiteFireworksStageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static LanternRiteFireworksStageInfo parseFrom(CodedInputStream input) throws IOException {
            return (LanternRiteFireworksStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LanternRiteFireworksStageInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LanternRiteFireworksStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LanternRiteFireworksStageInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternRiteFireworksStageInfoOuterClass$LanternRiteFireworksStageInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LanternRiteFireworksStageInfoOrBuilder {
            private int bitField0_;
            private int stageId_;
            private boolean isOpen_;
            private List<LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo> challengeInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo, LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo.Builder, LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfoOrBuilder> challengeInfoListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return LanternRiteFireworksStageInfoOuterClass.internal_static_LanternRiteFireworksStageInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LanternRiteFireworksStageInfoOuterClass.internal_static_LanternRiteFireworksStageInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LanternRiteFireworksStageInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LanternRiteFireworksStageInfo.alwaysUseFieldBuilders) {
                    getChallengeInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.stageId_ = 0;
                this.isOpen_ = false;
                if (this.challengeInfoListBuilder_ == null) {
                    this.challengeInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.challengeInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LanternRiteFireworksStageInfoOuterClass.internal_static_LanternRiteFireworksStageInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LanternRiteFireworksStageInfo getDefaultInstanceForType() {
                return LanternRiteFireworksStageInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LanternRiteFireworksStageInfo build() {
                LanternRiteFireworksStageInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LanternRiteFireworksStageInfo buildPartial() {
                LanternRiteFireworksStageInfo result = new LanternRiteFireworksStageInfo(this);
                int i = this.bitField0_;
                result.stageId_ = this.stageId_;
                result.isOpen_ = this.isOpen_;
                if (this.challengeInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.challengeInfoList_ = Collections.unmodifiableList(this.challengeInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.challengeInfoList_ = this.challengeInfoList_;
                } else {
                    result.challengeInfoList_ = this.challengeInfoListBuilder_.build();
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
                if (other instanceof LanternRiteFireworksStageInfo) {
                    return mergeFrom((LanternRiteFireworksStageInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LanternRiteFireworksStageInfo other) {
                if (other == LanternRiteFireworksStageInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (this.challengeInfoListBuilder_ == null) {
                    if (!other.challengeInfoList_.isEmpty()) {
                        if (this.challengeInfoList_.isEmpty()) {
                            this.challengeInfoList_ = other.challengeInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureChallengeInfoListIsMutable();
                            this.challengeInfoList_.addAll(other.challengeInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.challengeInfoList_.isEmpty()) {
                    if (this.challengeInfoListBuilder_.isEmpty()) {
                        this.challengeInfoListBuilder_.dispose();
                        this.challengeInfoListBuilder_ = null;
                        this.challengeInfoList_ = other.challengeInfoList_;
                        this.bitField0_ &= -2;
                        this.challengeInfoListBuilder_ = LanternRiteFireworksStageInfo.alwaysUseFieldBuilders ? getChallengeInfoListFieldBuilder() : null;
                    } else {
                        this.challengeInfoListBuilder_.addAllMessages(other.challengeInfoList_);
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
                LanternRiteFireworksStageInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = LanternRiteFireworksStageInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (LanternRiteFireworksStageInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.LanternRiteFireworksStageInfoOuterClass.LanternRiteFireworksStageInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.LanternRiteFireworksStageInfoOuterClass.LanternRiteFireworksStageInfoOrBuilder
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

            private void ensureChallengeInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.challengeInfoList_ = new ArrayList(this.challengeInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.LanternRiteFireworksStageInfoOuterClass.LanternRiteFireworksStageInfoOrBuilder
            public List<LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo> getChallengeInfoListList() {
                if (this.challengeInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.challengeInfoList_);
                }
                return this.challengeInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.LanternRiteFireworksStageInfoOuterClass.LanternRiteFireworksStageInfoOrBuilder
            public int getChallengeInfoListCount() {
                if (this.challengeInfoListBuilder_ == null) {
                    return this.challengeInfoList_.size();
                }
                return this.challengeInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.LanternRiteFireworksStageInfoOuterClass.LanternRiteFireworksStageInfoOrBuilder
            public LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo getChallengeInfoList(int index) {
                if (this.challengeInfoListBuilder_ == null) {
                    return this.challengeInfoList_.get(index);
                }
                return this.challengeInfoListBuilder_.getMessage(index);
            }

            public Builder setChallengeInfoList(int index, LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo value) {
                if (this.challengeInfoListBuilder_ != null) {
                    this.challengeInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChallengeInfoListIsMutable();
                    this.challengeInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setChallengeInfoList(int index, LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo.Builder builderForValue) {
                if (this.challengeInfoListBuilder_ == null) {
                    ensureChallengeInfoListIsMutable();
                    this.challengeInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.challengeInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addChallengeInfoList(LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo value) {
                if (this.challengeInfoListBuilder_ != null) {
                    this.challengeInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChallengeInfoListIsMutable();
                    this.challengeInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addChallengeInfoList(int index, LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo value) {
                if (this.challengeInfoListBuilder_ != null) {
                    this.challengeInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChallengeInfoListIsMutable();
                    this.challengeInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addChallengeInfoList(LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo.Builder builderForValue) {
                if (this.challengeInfoListBuilder_ == null) {
                    ensureChallengeInfoListIsMutable();
                    this.challengeInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.challengeInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addChallengeInfoList(int index, LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo.Builder builderForValue) {
                if (this.challengeInfoListBuilder_ == null) {
                    ensureChallengeInfoListIsMutable();
                    this.challengeInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.challengeInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllChallengeInfoList(Iterable<? extends LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo> values) {
                if (this.challengeInfoListBuilder_ == null) {
                    ensureChallengeInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.challengeInfoList_);
                    onChanged();
                } else {
                    this.challengeInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearChallengeInfoList() {
                if (this.challengeInfoListBuilder_ == null) {
                    this.challengeInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.challengeInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeChallengeInfoList(int index) {
                if (this.challengeInfoListBuilder_ == null) {
                    ensureChallengeInfoListIsMutable();
                    this.challengeInfoList_.remove(index);
                    onChanged();
                } else {
                    this.challengeInfoListBuilder_.remove(index);
                }
                return this;
            }

            public LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo.Builder getChallengeInfoListBuilder(int index) {
                return getChallengeInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.LanternRiteFireworksStageInfoOuterClass.LanternRiteFireworksStageInfoOrBuilder
            public LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfoOrBuilder getChallengeInfoListOrBuilder(int index) {
                if (this.challengeInfoListBuilder_ == null) {
                    return this.challengeInfoList_.get(index);
                }
                return this.challengeInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.LanternRiteFireworksStageInfoOuterClass.LanternRiteFireworksStageInfoOrBuilder
            public List<? extends LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfoOrBuilder> getChallengeInfoListOrBuilderList() {
                if (this.challengeInfoListBuilder_ != null) {
                    return this.challengeInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.challengeInfoList_);
            }

            public LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo.Builder addChallengeInfoListBuilder() {
                return getChallengeInfoListFieldBuilder().addBuilder(LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo.getDefaultInstance());
            }

            public LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo.Builder addChallengeInfoListBuilder(int index) {
                return getChallengeInfoListFieldBuilder().addBuilder(index, LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo.getDefaultInstance());
            }

            public List<LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo.Builder> getChallengeInfoListBuilderList() {
                return getChallengeInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo, LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo.Builder, LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfoOrBuilder> getChallengeInfoListFieldBuilder() {
                if (this.challengeInfoListBuilder_ == null) {
                    this.challengeInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.challengeInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.challengeInfoList_ = null;
                }
                return this.challengeInfoListBuilder_;
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

        public static LanternRiteFireworksStageInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LanternRiteFireworksStageInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LanternRiteFireworksStageInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LanternRiteFireworksStageInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        LanternRiteFireworksChallengeInfoOuterClass.getDescriptor();
    }
}
