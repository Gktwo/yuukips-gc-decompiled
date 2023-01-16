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
import emu.grasscutter.net.proto.CrystalLinkTeamInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrystalLinkLevelInfoOuterClass.class */
public final class CrystalLinkLevelInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aCrystalLinkLevelInfo.proto\u001a\u0019CrystalLinkTeamInfo.proto\"{\n\u0014CrystalLinkLevelInfo\u0012\u000f\n\u0007is_open\u0018\u0004 \u0001(\b\u0012,\n\u000eteam_info_list\u0018\u0003 \u0003(\u000b2\u0014.CrystalLinkTeamInfo\u0012\u0010\n\blevel_id\u0018\u000e \u0001(\r\u0012\u0012\n\nbest_score\u0018\u0007 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CrystalLinkTeamInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CrystalLinkLevelInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CrystalLinkLevelInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CrystalLinkLevelInfo_descriptor, new String[]{"IsOpen", "TeamInfoList", "LevelId", "BestScore"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrystalLinkLevelInfoOuterClass$CrystalLinkLevelInfoOrBuilder.class */
    public interface CrystalLinkLevelInfoOrBuilder extends MessageOrBuilder {
        boolean getIsOpen();

        List<CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo> getTeamInfoListList();

        CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo getTeamInfoList(int i);

        int getTeamInfoListCount();

        List<? extends CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder> getTeamInfoListOrBuilderList();

        CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder getTeamInfoListOrBuilder(int i);

        int getLevelId();

        int getBestScore();
    }

    private CrystalLinkLevelInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrystalLinkLevelInfoOuterClass$CrystalLinkLevelInfo.class */
    public static final class CrystalLinkLevelInfo extends GeneratedMessageV3 implements CrystalLinkLevelInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_OPEN_FIELD_NUMBER = 4;
        private boolean isOpen_;
        public static final int TEAM_INFO_LIST_FIELD_NUMBER = 3;
        private List<CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo> teamInfoList_;
        public static final int LEVEL_ID_FIELD_NUMBER = 14;
        private int levelId_;
        public static final int BEST_SCORE_FIELD_NUMBER = 7;
        private int bestScore_;
        private byte memoizedIsInitialized;
        private static final CrystalLinkLevelInfo DEFAULT_INSTANCE = new CrystalLinkLevelInfo();
        private static final Parser<CrystalLinkLevelInfo> PARSER = new AbstractParser<CrystalLinkLevelInfo>() { // from class: emu.grasscutter.net.proto.CrystalLinkLevelInfoOuterClass.CrystalLinkLevelInfo.1
            @Override // com.google.protobuf.Parser
            public CrystalLinkLevelInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CrystalLinkLevelInfo(input, extensionRegistry);
            }
        };

        private CrystalLinkLevelInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CrystalLinkLevelInfo() {
            this.memoizedIsInitialized = -1;
            this.teamInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CrystalLinkLevelInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CrystalLinkLevelInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 26:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.teamInfoList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.teamInfoList_.add((CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo) input.readMessage(CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo.parser(), extensionRegistry));
                                break;
                            case 32:
                                this.isOpen_ = input.readBool();
                                break;
                            case 56:
                                this.bestScore_ = input.readUInt32();
                                break;
                            case 112:
                                this.levelId_ = input.readUInt32();
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
            return CrystalLinkLevelInfoOuterClass.internal_static_CrystalLinkLevelInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CrystalLinkLevelInfoOuterClass.internal_static_CrystalLinkLevelInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CrystalLinkLevelInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkLevelInfoOuterClass.CrystalLinkLevelInfoOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkLevelInfoOuterClass.CrystalLinkLevelInfoOrBuilder
        public List<CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo> getTeamInfoListList() {
            return this.teamInfoList_;
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkLevelInfoOuterClass.CrystalLinkLevelInfoOrBuilder
        public List<? extends CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder> getTeamInfoListOrBuilderList() {
            return this.teamInfoList_;
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkLevelInfoOuterClass.CrystalLinkLevelInfoOrBuilder
        public int getTeamInfoListCount() {
            return this.teamInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkLevelInfoOuterClass.CrystalLinkLevelInfoOrBuilder
        public CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo getTeamInfoList(int index) {
            return this.teamInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkLevelInfoOuterClass.CrystalLinkLevelInfoOrBuilder
        public CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder getTeamInfoListOrBuilder(int index) {
            return this.teamInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkLevelInfoOuterClass.CrystalLinkLevelInfoOrBuilder
        public int getLevelId() {
            return this.levelId_;
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkLevelInfoOuterClass.CrystalLinkLevelInfoOrBuilder
        public int getBestScore() {
            return this.bestScore_;
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
            for (int i = 0; i < this.teamInfoList_.size(); i++) {
                output.writeMessage(3, this.teamInfoList_.get(i));
            }
            if (this.isOpen_) {
                output.writeBool(4, this.isOpen_);
            }
            if (this.bestScore_ != 0) {
                output.writeUInt32(7, this.bestScore_);
            }
            if (this.levelId_ != 0) {
                output.writeUInt32(14, this.levelId_);
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
            for (int i = 0; i < this.teamInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.teamInfoList_.get(i));
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.isOpen_);
            }
            if (this.bestScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.bestScore_);
            }
            if (this.levelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.levelId_);
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
            if (!(obj instanceof CrystalLinkLevelInfo)) {
                return equals(obj);
            }
            CrystalLinkLevelInfo other = (CrystalLinkLevelInfo) obj;
            return getIsOpen() == other.getIsOpen() && getTeamInfoListList().equals(other.getTeamInfoListList()) && getLevelId() == other.getLevelId() && getBestScore() == other.getBestScore() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + Internal.hashBoolean(getIsOpen());
            if (getTeamInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getTeamInfoListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 14)) + getLevelId())) + 7)) + getBestScore())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static CrystalLinkLevelInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CrystalLinkLevelInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CrystalLinkLevelInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CrystalLinkLevelInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CrystalLinkLevelInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CrystalLinkLevelInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CrystalLinkLevelInfo parseFrom(InputStream input) throws IOException {
            return (CrystalLinkLevelInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CrystalLinkLevelInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CrystalLinkLevelInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CrystalLinkLevelInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (CrystalLinkLevelInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CrystalLinkLevelInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CrystalLinkLevelInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CrystalLinkLevelInfo parseFrom(CodedInputStream input) throws IOException {
            return (CrystalLinkLevelInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CrystalLinkLevelInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CrystalLinkLevelInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CrystalLinkLevelInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrystalLinkLevelInfoOuterClass$CrystalLinkLevelInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CrystalLinkLevelInfoOrBuilder {
            private int bitField0_;
            private boolean isOpen_;
            private List<CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo> teamInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo, CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo.Builder, CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder> teamInfoListBuilder_;
            private int levelId_;
            private int bestScore_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CrystalLinkLevelInfoOuterClass.internal_static_CrystalLinkLevelInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CrystalLinkLevelInfoOuterClass.internal_static_CrystalLinkLevelInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CrystalLinkLevelInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CrystalLinkLevelInfo.alwaysUseFieldBuilders) {
                    getTeamInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isOpen_ = false;
                if (this.teamInfoListBuilder_ == null) {
                    this.teamInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.teamInfoListBuilder_.clear();
                }
                this.levelId_ = 0;
                this.bestScore_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CrystalLinkLevelInfoOuterClass.internal_static_CrystalLinkLevelInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CrystalLinkLevelInfo getDefaultInstanceForType() {
                return CrystalLinkLevelInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CrystalLinkLevelInfo build() {
                CrystalLinkLevelInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CrystalLinkLevelInfo buildPartial() {
                CrystalLinkLevelInfo result = new CrystalLinkLevelInfo(this);
                int i = this.bitField0_;
                result.isOpen_ = this.isOpen_;
                if (this.teamInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.teamInfoList_ = Collections.unmodifiableList(this.teamInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.teamInfoList_ = this.teamInfoList_;
                } else {
                    result.teamInfoList_ = this.teamInfoListBuilder_.build();
                }
                result.levelId_ = this.levelId_;
                result.bestScore_ = this.bestScore_;
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
                if (other instanceof CrystalLinkLevelInfo) {
                    return mergeFrom((CrystalLinkLevelInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CrystalLinkLevelInfo other) {
                if (other == CrystalLinkLevelInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
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
                        this.teamInfoListBuilder_ = CrystalLinkLevelInfo.alwaysUseFieldBuilders ? getTeamInfoListFieldBuilder() : null;
                    } else {
                        this.teamInfoListBuilder_.addAllMessages(other.teamInfoList_);
                    }
                }
                if (other.getLevelId() != 0) {
                    setLevelId(other.getLevelId());
                }
                if (other.getBestScore() != 0) {
                    setBestScore(other.getBestScore());
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
                CrystalLinkLevelInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = CrystalLinkLevelInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CrystalLinkLevelInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkLevelInfoOuterClass.CrystalLinkLevelInfoOrBuilder
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

            private void ensureTeamInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.teamInfoList_ = new ArrayList(this.teamInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkLevelInfoOuterClass.CrystalLinkLevelInfoOrBuilder
            public List<CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo> getTeamInfoListList() {
                if (this.teamInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.teamInfoList_);
                }
                return this.teamInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkLevelInfoOuterClass.CrystalLinkLevelInfoOrBuilder
            public int getTeamInfoListCount() {
                if (this.teamInfoListBuilder_ == null) {
                    return this.teamInfoList_.size();
                }
                return this.teamInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkLevelInfoOuterClass.CrystalLinkLevelInfoOrBuilder
            public CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo getTeamInfoList(int index) {
                if (this.teamInfoListBuilder_ == null) {
                    return this.teamInfoList_.get(index);
                }
                return this.teamInfoListBuilder_.getMessage(index);
            }

            public Builder setTeamInfoList(int index, CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo value) {
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

            public Builder setTeamInfoList(int index, CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo.Builder builderForValue) {
                if (this.teamInfoListBuilder_ == null) {
                    ensureTeamInfoListIsMutable();
                    this.teamInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.teamInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTeamInfoList(CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo value) {
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

            public Builder addTeamInfoList(int index, CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo value) {
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

            public Builder addTeamInfoList(CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo.Builder builderForValue) {
                if (this.teamInfoListBuilder_ == null) {
                    ensureTeamInfoListIsMutable();
                    this.teamInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.teamInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTeamInfoList(int index, CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo.Builder builderForValue) {
                if (this.teamInfoListBuilder_ == null) {
                    ensureTeamInfoListIsMutable();
                    this.teamInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.teamInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTeamInfoList(Iterable<? extends CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo> values) {
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

            public CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo.Builder getTeamInfoListBuilder(int index) {
                return getTeamInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkLevelInfoOuterClass.CrystalLinkLevelInfoOrBuilder
            public CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder getTeamInfoListOrBuilder(int index) {
                if (this.teamInfoListBuilder_ == null) {
                    return this.teamInfoList_.get(index);
                }
                return this.teamInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkLevelInfoOuterClass.CrystalLinkLevelInfoOrBuilder
            public List<? extends CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder> getTeamInfoListOrBuilderList() {
                if (this.teamInfoListBuilder_ != null) {
                    return this.teamInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.teamInfoList_);
            }

            public CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo.Builder addTeamInfoListBuilder() {
                return getTeamInfoListFieldBuilder().addBuilder(CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo.getDefaultInstance());
            }

            public CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo.Builder addTeamInfoListBuilder(int index) {
                return getTeamInfoListFieldBuilder().addBuilder(index, CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo.getDefaultInstance());
            }

            public List<CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo.Builder> getTeamInfoListBuilderList() {
                return getTeamInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo, CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo.Builder, CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder> getTeamInfoListFieldBuilder() {
                if (this.teamInfoListBuilder_ == null) {
                    this.teamInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.teamInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.teamInfoList_ = null;
                }
                return this.teamInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkLevelInfoOuterClass.CrystalLinkLevelInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.CrystalLinkLevelInfoOuterClass.CrystalLinkLevelInfoOrBuilder
            public int getBestScore() {
                return this.bestScore_;
            }

            public Builder setBestScore(int value) {
                this.bestScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearBestScore() {
                this.bestScore_ = 0;
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

        public static CrystalLinkLevelInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CrystalLinkLevelInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CrystalLinkLevelInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CrystalLinkLevelInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CrystalLinkTeamInfoOuterClass.getDescriptor();
    }
}
