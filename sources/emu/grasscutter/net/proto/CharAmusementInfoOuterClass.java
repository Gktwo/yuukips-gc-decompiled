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
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.CharAmusementAvatarInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CharAmusementInfoOuterClass.class */
public final class CharAmusementInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017CharAmusementInfo.proto\u001a\u001dCharAmusementAvatarInfo.proto\"\u0001\n\u0011CharAmusementInfo\u00120\n\u000eavatarInfoList\u0018\u000b \u0003(\u000b2\u0018.CharAmusementAvatarInfo\u0012\u0013\n\u000bemdkpmhihmp\u0018\u0003 \u0001(\r\u0012\u000f\n\u0007levelId\u0018\u0006 \u0001(\r\u0012\u000f\n\u0007stageId\u0018\b \u0001(\r\u0012\u0013\n\u000binllhgjoaco\u0018\u0005 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CharAmusementAvatarInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CharAmusementInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CharAmusementInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CharAmusementInfo_descriptor, new String[]{"AvatarInfoList", "Emdkpmhihmp", "LevelId", "StageId", "Inllhgjoaco"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CharAmusementInfoOuterClass$CharAmusementInfoOrBuilder.class */
    public interface CharAmusementInfoOrBuilder extends MessageOrBuilder {
        List<CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo> getAvatarInfoListList();

        CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo getAvatarInfoList(int i);

        int getAvatarInfoListCount();

        List<? extends CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfoOrBuilder> getAvatarInfoListOrBuilderList();

        CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfoOrBuilder getAvatarInfoListOrBuilder(int i);

        int getEmdkpmhihmp();

        int getLevelId();

        int getStageId();

        int getInllhgjoaco();
    }

    private CharAmusementInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CharAmusementInfoOuterClass$CharAmusementInfo.class */
    public static final class CharAmusementInfo extends GeneratedMessageV3 implements CharAmusementInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATARINFOLIST_FIELD_NUMBER = 11;
        private List<CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo> avatarInfoList_;
        public static final int EMDKPMHIHMP_FIELD_NUMBER = 3;
        private int emdkpmhihmp_;
        public static final int LEVELID_FIELD_NUMBER = 6;
        private int levelId_;
        public static final int STAGEID_FIELD_NUMBER = 8;
        private int stageId_;
        public static final int INLLHGJOACO_FIELD_NUMBER = 5;
        private int inllhgjoaco_;
        private byte memoizedIsInitialized;
        private static final CharAmusementInfo DEFAULT_INSTANCE = new CharAmusementInfo();
        private static final Parser<CharAmusementInfo> PARSER = new AbstractParser<CharAmusementInfo>() { // from class: emu.grasscutter.net.proto.CharAmusementInfoOuterClass.CharAmusementInfo.1
            @Override // com.google.protobuf.Parser
            public CharAmusementInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CharAmusementInfo(input, extensionRegistry);
            }
        };

        private CharAmusementInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CharAmusementInfo() {
            this.memoizedIsInitialized = -1;
            this.avatarInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CharAmusementInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CharAmusementInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.emdkpmhihmp_ = input.readUInt32();
                                break;
                            case 40:
                                this.inllhgjoaco_ = input.readUInt32();
                                break;
                            case 48:
                                this.levelId_ = input.readUInt32();
                                break;
                            case 64:
                                this.stageId_ = input.readUInt32();
                                break;
                            case 90:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.avatarInfoList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.avatarInfoList_.add((CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo) input.readMessage(CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo.parser(), extensionRegistry));
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
                    this.avatarInfoList_ = Collections.unmodifiableList(this.avatarInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CharAmusementInfoOuterClass.internal_static_CharAmusementInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CharAmusementInfoOuterClass.internal_static_CharAmusementInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CharAmusementInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder
        public List<CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo> getAvatarInfoListList() {
            return this.avatarInfoList_;
        }

        @Override // emu.grasscutter.net.proto.CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder
        public List<? extends CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfoOrBuilder> getAvatarInfoListOrBuilderList() {
            return this.avatarInfoList_;
        }

        @Override // emu.grasscutter.net.proto.CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder
        public int getAvatarInfoListCount() {
            return this.avatarInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder
        public CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo getAvatarInfoList(int index) {
            return this.avatarInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder
        public CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfoOrBuilder getAvatarInfoListOrBuilder(int index) {
            return this.avatarInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder
        public int getEmdkpmhihmp() {
            return this.emdkpmhihmp_;
        }

        @Override // emu.grasscutter.net.proto.CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder
        public int getLevelId() {
            return this.levelId_;
        }

        @Override // emu.grasscutter.net.proto.CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder
        public int getInllhgjoaco() {
            return this.inllhgjoaco_;
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
            if (this.emdkpmhihmp_ != 0) {
                output.writeUInt32(3, this.emdkpmhihmp_);
            }
            if (this.inllhgjoaco_ != 0) {
                output.writeUInt32(5, this.inllhgjoaco_);
            }
            if (this.levelId_ != 0) {
                output.writeUInt32(6, this.levelId_);
            }
            if (this.stageId_ != 0) {
                output.writeUInt32(8, this.stageId_);
            }
            for (int i = 0; i < this.avatarInfoList_.size(); i++) {
                output.writeMessage(11, this.avatarInfoList_.get(i));
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
            if (this.emdkpmhihmp_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.emdkpmhihmp_);
            }
            if (this.inllhgjoaco_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.inllhgjoaco_);
            }
            if (this.levelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.levelId_);
            }
            if (this.stageId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.stageId_);
            }
            for (int i = 0; i < this.avatarInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.avatarInfoList_.get(i));
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
            if (!(obj instanceof CharAmusementInfo)) {
                return equals(obj);
            }
            CharAmusementInfo other = (CharAmusementInfo) obj;
            return getAvatarInfoListList().equals(other.getAvatarInfoListList()) && getEmdkpmhihmp() == other.getEmdkpmhihmp() && getLevelId() == other.getLevelId() && getStageId() == other.getStageId() && getInllhgjoaco() == other.getInllhgjoaco() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getAvatarInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getAvatarInfoListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 3)) + getEmdkpmhihmp())) + 6)) + getLevelId())) + 8)) + getStageId())) + 5)) + getInllhgjoaco())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static CharAmusementInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CharAmusementInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CharAmusementInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CharAmusementInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CharAmusementInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CharAmusementInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CharAmusementInfo parseFrom(InputStream input) throws IOException {
            return (CharAmusementInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CharAmusementInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CharAmusementInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CharAmusementInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (CharAmusementInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CharAmusementInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CharAmusementInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CharAmusementInfo parseFrom(CodedInputStream input) throws IOException {
            return (CharAmusementInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CharAmusementInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CharAmusementInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CharAmusementInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CharAmusementInfoOuterClass$CharAmusementInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CharAmusementInfoOrBuilder {
            private int bitField0_;
            private List<CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo> avatarInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo, CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo.Builder, CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfoOrBuilder> avatarInfoListBuilder_;
            private int emdkpmhihmp_;
            private int levelId_;
            private int stageId_;
            private int inllhgjoaco_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CharAmusementInfoOuterClass.internal_static_CharAmusementInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CharAmusementInfoOuterClass.internal_static_CharAmusementInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CharAmusementInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CharAmusementInfo.alwaysUseFieldBuilders) {
                    getAvatarInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.avatarInfoListBuilder_ == null) {
                    this.avatarInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.avatarInfoListBuilder_.clear();
                }
                this.emdkpmhihmp_ = 0;
                this.levelId_ = 0;
                this.stageId_ = 0;
                this.inllhgjoaco_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CharAmusementInfoOuterClass.internal_static_CharAmusementInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CharAmusementInfo getDefaultInstanceForType() {
                return CharAmusementInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CharAmusementInfo build() {
                CharAmusementInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CharAmusementInfo buildPartial() {
                CharAmusementInfo result = new CharAmusementInfo(this);
                int i = this.bitField0_;
                if (this.avatarInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.avatarInfoList_ = Collections.unmodifiableList(this.avatarInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.avatarInfoList_ = this.avatarInfoList_;
                } else {
                    result.avatarInfoList_ = this.avatarInfoListBuilder_.build();
                }
                result.emdkpmhihmp_ = this.emdkpmhihmp_;
                result.levelId_ = this.levelId_;
                result.stageId_ = this.stageId_;
                result.inllhgjoaco_ = this.inllhgjoaco_;
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
                if (other instanceof CharAmusementInfo) {
                    return mergeFrom((CharAmusementInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CharAmusementInfo other) {
                if (other == CharAmusementInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.avatarInfoListBuilder_ == null) {
                    if (!other.avatarInfoList_.isEmpty()) {
                        if (this.avatarInfoList_.isEmpty()) {
                            this.avatarInfoList_ = other.avatarInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureAvatarInfoListIsMutable();
                            this.avatarInfoList_.addAll(other.avatarInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.avatarInfoList_.isEmpty()) {
                    if (this.avatarInfoListBuilder_.isEmpty()) {
                        this.avatarInfoListBuilder_.dispose();
                        this.avatarInfoListBuilder_ = null;
                        this.avatarInfoList_ = other.avatarInfoList_;
                        this.bitField0_ &= -2;
                        this.avatarInfoListBuilder_ = CharAmusementInfo.alwaysUseFieldBuilders ? getAvatarInfoListFieldBuilder() : null;
                    } else {
                        this.avatarInfoListBuilder_.addAllMessages(other.avatarInfoList_);
                    }
                }
                if (other.getEmdkpmhihmp() != 0) {
                    setEmdkpmhihmp(other.getEmdkpmhihmp());
                }
                if (other.getLevelId() != 0) {
                    setLevelId(other.getLevelId());
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (other.getInllhgjoaco() != 0) {
                    setInllhgjoaco(other.getInllhgjoaco());
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
                CharAmusementInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = CharAmusementInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CharAmusementInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureAvatarInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.avatarInfoList_ = new ArrayList(this.avatarInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder
            public List<CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo> getAvatarInfoListList() {
                if (this.avatarInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.avatarInfoList_);
                }
                return this.avatarInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder
            public int getAvatarInfoListCount() {
                if (this.avatarInfoListBuilder_ == null) {
                    return this.avatarInfoList_.size();
                }
                return this.avatarInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder
            public CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo getAvatarInfoList(int index) {
                if (this.avatarInfoListBuilder_ == null) {
                    return this.avatarInfoList_.get(index);
                }
                return this.avatarInfoListBuilder_.getMessage(index);
            }

            public Builder setAvatarInfoList(int index, CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo value) {
                if (this.avatarInfoListBuilder_ != null) {
                    this.avatarInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setAvatarInfoList(int index, CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo.Builder builderForValue) {
                if (this.avatarInfoListBuilder_ == null) {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAvatarInfoList(CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo value) {
                if (this.avatarInfoListBuilder_ != null) {
                    this.avatarInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addAvatarInfoList(int index, CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo value) {
                if (this.avatarInfoListBuilder_ != null) {
                    this.avatarInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addAvatarInfoList(CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo.Builder builderForValue) {
                if (this.avatarInfoListBuilder_ == null) {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.avatarInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAvatarInfoList(int index, CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo.Builder builderForValue) {
                if (this.avatarInfoListBuilder_ == null) {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAvatarInfoList(Iterable<? extends CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo> values) {
                if (this.avatarInfoListBuilder_ == null) {
                    ensureAvatarInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.avatarInfoList_);
                    onChanged();
                } else {
                    this.avatarInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAvatarInfoList() {
                if (this.avatarInfoListBuilder_ == null) {
                    this.avatarInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.avatarInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeAvatarInfoList(int index) {
                if (this.avatarInfoListBuilder_ == null) {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.remove(index);
                    onChanged();
                } else {
                    this.avatarInfoListBuilder_.remove(index);
                }
                return this;
            }

            public CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo.Builder getAvatarInfoListBuilder(int index) {
                return getAvatarInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder
            public CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfoOrBuilder getAvatarInfoListOrBuilder(int index) {
                if (this.avatarInfoListBuilder_ == null) {
                    return this.avatarInfoList_.get(index);
                }
                return this.avatarInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder
            public List<? extends CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfoOrBuilder> getAvatarInfoListOrBuilderList() {
                if (this.avatarInfoListBuilder_ != null) {
                    return this.avatarInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.avatarInfoList_);
            }

            public CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo.Builder addAvatarInfoListBuilder() {
                return getAvatarInfoListFieldBuilder().addBuilder(CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo.getDefaultInstance());
            }

            public CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo.Builder addAvatarInfoListBuilder(int index) {
                return getAvatarInfoListFieldBuilder().addBuilder(index, CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo.getDefaultInstance());
            }

            public List<CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo.Builder> getAvatarInfoListBuilderList() {
                return getAvatarInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo, CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo.Builder, CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfoOrBuilder> getAvatarInfoListFieldBuilder() {
                if (this.avatarInfoListBuilder_ == null) {
                    this.avatarInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.avatarInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.avatarInfoList_ = null;
                }
                return this.avatarInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder
            public int getEmdkpmhihmp() {
                return this.emdkpmhihmp_;
            }

            public Builder setEmdkpmhihmp(int value) {
                this.emdkpmhihmp_ = value;
                onChanged();
                return this;
            }

            public Builder clearEmdkpmhihmp() {
                this.emdkpmhihmp_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder
            public int getLevelId() {
                return this.levelId_;
            }

            public Builder setLevelId(int value) {
                this.levelId_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevelId() {
                this.levelId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder
            public int getInllhgjoaco() {
                return this.inllhgjoaco_;
            }

            public Builder setInllhgjoaco(int value) {
                this.inllhgjoaco_ = value;
                onChanged();
                return this;
            }

            public Builder clearInllhgjoaco() {
                this.inllhgjoaco_ = 0;
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

        public static CharAmusementInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CharAmusementInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CharAmusementInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CharAmusementInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CharAmusementAvatarInfoOuterClass.getDescriptor();
    }
}
