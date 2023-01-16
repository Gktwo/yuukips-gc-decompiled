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
import emu.grasscutter.net.proto.CrystalLinkAvatarInfoOuterClass;
import emu.grasscutter.net.proto.CrystalLinkBuffInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrystalLinkTeamInfoOuterClass.class */
public final class CrystalLinkTeamInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019CrystalLinkTeamInfo.proto\u001a\u001bCrystalLinkAvatarInfo.proto\u001a\u0019CrystalLinkBuffInfo.proto\"u\n\u0013CrystalLinkTeamInfo\u00120\n\u0010avatar_info_list\u0018\u000e \u0003(\u000b2\u0016.CrystalLinkAvatarInfo\u0012,\n\u000ebuff_info_list\u0018\f \u0003(\u000b2\u0014.CrystalLinkBuffInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CrystalLinkAvatarInfoOuterClass.getDescriptor(), CrystalLinkBuffInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CrystalLinkTeamInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CrystalLinkTeamInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CrystalLinkTeamInfo_descriptor, new String[]{"AvatarInfoList", "BuffInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrystalLinkTeamInfoOuterClass$CrystalLinkTeamInfoOrBuilder.class */
    public interface CrystalLinkTeamInfoOrBuilder extends MessageOrBuilder {
        List<CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo> getAvatarInfoListList();

        CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo getAvatarInfoList(int i);

        int getAvatarInfoListCount();

        List<? extends CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfoOrBuilder> getAvatarInfoListOrBuilderList();

        CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfoOrBuilder getAvatarInfoListOrBuilder(int i);

        List<CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo> getBuffInfoListList();

        CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo getBuffInfoList(int i);

        int getBuffInfoListCount();

        List<? extends CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfoOrBuilder> getBuffInfoListOrBuilderList();

        CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfoOrBuilder getBuffInfoListOrBuilder(int i);
    }

    private CrystalLinkTeamInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrystalLinkTeamInfoOuterClass$CrystalLinkTeamInfo.class */
    public static final class CrystalLinkTeamInfo extends GeneratedMessageV3 implements CrystalLinkTeamInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATAR_INFO_LIST_FIELD_NUMBER = 14;
        private List<CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo> avatarInfoList_;
        public static final int BUFF_INFO_LIST_FIELD_NUMBER = 12;
        private List<CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo> buffInfoList_;
        private byte memoizedIsInitialized;
        private static final CrystalLinkTeamInfo DEFAULT_INSTANCE = new CrystalLinkTeamInfo();
        private static final Parser<CrystalLinkTeamInfo> PARSER = new AbstractParser<CrystalLinkTeamInfo>() { // from class: emu.grasscutter.net.proto.CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfo.1
            @Override // com.google.protobuf.Parser
            public CrystalLinkTeamInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CrystalLinkTeamInfo(input, extensionRegistry);
            }
        };

        private CrystalLinkTeamInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CrystalLinkTeamInfo() {
            this.memoizedIsInitialized = -1;
            this.avatarInfoList_ = Collections.emptyList();
            this.buffInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CrystalLinkTeamInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x00b8 */
        private CrystalLinkTeamInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 98:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.buffInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.buffInfoList_.add((CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo) input.readMessage(CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo.parser(), extensionRegistry));
                                break;
                            case 114:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.avatarInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.avatarInfoList_.add((CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo) input.readMessage(CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 2) != 0) {
                    this.buffInfoList_ = Collections.unmodifiableList(this.buffInfoList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.avatarInfoList_ = Collections.unmodifiableList(this.avatarInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CrystalLinkTeamInfoOuterClass.internal_static_CrystalLinkTeamInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CrystalLinkTeamInfoOuterClass.internal_static_CrystalLinkTeamInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CrystalLinkTeamInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder
        public List<CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo> getAvatarInfoListList() {
            return this.avatarInfoList_;
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder
        public List<? extends CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfoOrBuilder> getAvatarInfoListOrBuilderList() {
            return this.avatarInfoList_;
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder
        public int getAvatarInfoListCount() {
            return this.avatarInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder
        public CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo getAvatarInfoList(int index) {
            return this.avatarInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder
        public CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfoOrBuilder getAvatarInfoListOrBuilder(int index) {
            return this.avatarInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder
        public List<CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo> getBuffInfoListList() {
            return this.buffInfoList_;
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder
        public List<? extends CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfoOrBuilder> getBuffInfoListOrBuilderList() {
            return this.buffInfoList_;
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder
        public int getBuffInfoListCount() {
            return this.buffInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder
        public CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo getBuffInfoList(int index) {
            return this.buffInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder
        public CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfoOrBuilder getBuffInfoListOrBuilder(int index) {
            return this.buffInfoList_.get(index);
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
            for (int i = 0; i < this.buffInfoList_.size(); i++) {
                output.writeMessage(12, this.buffInfoList_.get(i));
            }
            for (int i2 = 0; i2 < this.avatarInfoList_.size(); i2++) {
                output.writeMessage(14, this.avatarInfoList_.get(i2));
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
            for (int i = 0; i < this.buffInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(12, this.buffInfoList_.get(i));
            }
            for (int i2 = 0; i2 < this.avatarInfoList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(14, this.avatarInfoList_.get(i2));
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
            if (!(obj instanceof CrystalLinkTeamInfo)) {
                return equals(obj);
            }
            CrystalLinkTeamInfo other = (CrystalLinkTeamInfo) obj;
            return getAvatarInfoListList().equals(other.getAvatarInfoListList()) && getBuffInfoListList().equals(other.getBuffInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getAvatarInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getAvatarInfoListList().hashCode();
            }
            if (getBuffInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getBuffInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static CrystalLinkTeamInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CrystalLinkTeamInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CrystalLinkTeamInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CrystalLinkTeamInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CrystalLinkTeamInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CrystalLinkTeamInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CrystalLinkTeamInfo parseFrom(InputStream input) throws IOException {
            return (CrystalLinkTeamInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CrystalLinkTeamInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CrystalLinkTeamInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CrystalLinkTeamInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (CrystalLinkTeamInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CrystalLinkTeamInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CrystalLinkTeamInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CrystalLinkTeamInfo parseFrom(CodedInputStream input) throws IOException {
            return (CrystalLinkTeamInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CrystalLinkTeamInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CrystalLinkTeamInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CrystalLinkTeamInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrystalLinkTeamInfoOuterClass$CrystalLinkTeamInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CrystalLinkTeamInfoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo, CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo.Builder, CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfoOrBuilder> avatarInfoListBuilder_;
            private RepeatedFieldBuilderV3<CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo, CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo.Builder, CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfoOrBuilder> buffInfoListBuilder_;
            private List<CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo> avatarInfoList_ = Collections.emptyList();
            private List<CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo> buffInfoList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return CrystalLinkTeamInfoOuterClass.internal_static_CrystalLinkTeamInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CrystalLinkTeamInfoOuterClass.internal_static_CrystalLinkTeamInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CrystalLinkTeamInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CrystalLinkTeamInfo.alwaysUseFieldBuilders) {
                    getAvatarInfoListFieldBuilder();
                    getBuffInfoListFieldBuilder();
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
                if (this.buffInfoListBuilder_ == null) {
                    this.buffInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.buffInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CrystalLinkTeamInfoOuterClass.internal_static_CrystalLinkTeamInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CrystalLinkTeamInfo getDefaultInstanceForType() {
                return CrystalLinkTeamInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CrystalLinkTeamInfo build() {
                CrystalLinkTeamInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CrystalLinkTeamInfo buildPartial() {
                CrystalLinkTeamInfo result = new CrystalLinkTeamInfo(this);
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
                if (this.buffInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.buffInfoList_ = Collections.unmodifiableList(this.buffInfoList_);
                        this.bitField0_ &= -3;
                    }
                    result.buffInfoList_ = this.buffInfoList_;
                } else {
                    result.buffInfoList_ = this.buffInfoListBuilder_.build();
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
                if (other instanceof CrystalLinkTeamInfo) {
                    return mergeFrom((CrystalLinkTeamInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CrystalLinkTeamInfo other) {
                if (other == CrystalLinkTeamInfo.getDefaultInstance()) {
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
                        this.avatarInfoListBuilder_ = CrystalLinkTeamInfo.alwaysUseFieldBuilders ? getAvatarInfoListFieldBuilder() : null;
                    } else {
                        this.avatarInfoListBuilder_.addAllMessages(other.avatarInfoList_);
                    }
                }
                if (this.buffInfoListBuilder_ == null) {
                    if (!other.buffInfoList_.isEmpty()) {
                        if (this.buffInfoList_.isEmpty()) {
                            this.buffInfoList_ = other.buffInfoList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureBuffInfoListIsMutable();
                            this.buffInfoList_.addAll(other.buffInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.buffInfoList_.isEmpty()) {
                    if (this.buffInfoListBuilder_.isEmpty()) {
                        this.buffInfoListBuilder_.dispose();
                        this.buffInfoListBuilder_ = null;
                        this.buffInfoList_ = other.buffInfoList_;
                        this.bitField0_ &= -3;
                        this.buffInfoListBuilder_ = CrystalLinkTeamInfo.alwaysUseFieldBuilders ? getBuffInfoListFieldBuilder() : null;
                    } else {
                        this.buffInfoListBuilder_.addAllMessages(other.buffInfoList_);
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
                CrystalLinkTeamInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = CrystalLinkTeamInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CrystalLinkTeamInfo) e.getUnfinishedMessage();
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

            @Override // emu.grasscutter.net.proto.CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder
            public List<CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo> getAvatarInfoListList() {
                if (this.avatarInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.avatarInfoList_);
                }
                return this.avatarInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder
            public int getAvatarInfoListCount() {
                if (this.avatarInfoListBuilder_ == null) {
                    return this.avatarInfoList_.size();
                }
                return this.avatarInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder
            public CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo getAvatarInfoList(int index) {
                if (this.avatarInfoListBuilder_ == null) {
                    return this.avatarInfoList_.get(index);
                }
                return this.avatarInfoListBuilder_.getMessage(index);
            }

            public Builder setAvatarInfoList(int index, CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo value) {
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

            public Builder setAvatarInfoList(int index, CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo.Builder builderForValue) {
                if (this.avatarInfoListBuilder_ == null) {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAvatarInfoList(CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo value) {
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

            public Builder addAvatarInfoList(int index, CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo value) {
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

            public Builder addAvatarInfoList(CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo.Builder builderForValue) {
                if (this.avatarInfoListBuilder_ == null) {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.avatarInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAvatarInfoList(int index, CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo.Builder builderForValue) {
                if (this.avatarInfoListBuilder_ == null) {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAvatarInfoList(Iterable<? extends CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo> values) {
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

            public CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo.Builder getAvatarInfoListBuilder(int index) {
                return getAvatarInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder
            public CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfoOrBuilder getAvatarInfoListOrBuilder(int index) {
                if (this.avatarInfoListBuilder_ == null) {
                    return this.avatarInfoList_.get(index);
                }
                return this.avatarInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder
            public List<? extends CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfoOrBuilder> getAvatarInfoListOrBuilderList() {
                if (this.avatarInfoListBuilder_ != null) {
                    return this.avatarInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.avatarInfoList_);
            }

            public CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo.Builder addAvatarInfoListBuilder() {
                return getAvatarInfoListFieldBuilder().addBuilder(CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo.getDefaultInstance());
            }

            public CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo.Builder addAvatarInfoListBuilder(int index) {
                return getAvatarInfoListFieldBuilder().addBuilder(index, CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo.getDefaultInstance());
            }

            public List<CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo.Builder> getAvatarInfoListBuilderList() {
                return getAvatarInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo, CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfo.Builder, CrystalLinkAvatarInfoOuterClass.CrystalLinkAvatarInfoOrBuilder> getAvatarInfoListFieldBuilder() {
                if (this.avatarInfoListBuilder_ == null) {
                    this.avatarInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.avatarInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.avatarInfoList_ = null;
                }
                return this.avatarInfoListBuilder_;
            }

            private void ensureBuffInfoListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.buffInfoList_ = new ArrayList(this.buffInfoList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder
            public List<CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo> getBuffInfoListList() {
                if (this.buffInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.buffInfoList_);
                }
                return this.buffInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder
            public int getBuffInfoListCount() {
                if (this.buffInfoListBuilder_ == null) {
                    return this.buffInfoList_.size();
                }
                return this.buffInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder
            public CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo getBuffInfoList(int index) {
                if (this.buffInfoListBuilder_ == null) {
                    return this.buffInfoList_.get(index);
                }
                return this.buffInfoListBuilder_.getMessage(index);
            }

            public Builder setBuffInfoList(int index, CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo value) {
                if (this.buffInfoListBuilder_ != null) {
                    this.buffInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBuffInfoListIsMutable();
                    this.buffInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setBuffInfoList(int index, CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo.Builder builderForValue) {
                if (this.buffInfoListBuilder_ == null) {
                    ensureBuffInfoListIsMutable();
                    this.buffInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.buffInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addBuffInfoList(CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo value) {
                if (this.buffInfoListBuilder_ != null) {
                    this.buffInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBuffInfoListIsMutable();
                    this.buffInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addBuffInfoList(int index, CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo value) {
                if (this.buffInfoListBuilder_ != null) {
                    this.buffInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBuffInfoListIsMutable();
                    this.buffInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addBuffInfoList(CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo.Builder builderForValue) {
                if (this.buffInfoListBuilder_ == null) {
                    ensureBuffInfoListIsMutable();
                    this.buffInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.buffInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addBuffInfoList(int index, CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo.Builder builderForValue) {
                if (this.buffInfoListBuilder_ == null) {
                    ensureBuffInfoListIsMutable();
                    this.buffInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.buffInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllBuffInfoList(Iterable<? extends CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo> values) {
                if (this.buffInfoListBuilder_ == null) {
                    ensureBuffInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.buffInfoList_);
                    onChanged();
                } else {
                    this.buffInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearBuffInfoList() {
                if (this.buffInfoListBuilder_ == null) {
                    this.buffInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.buffInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeBuffInfoList(int index) {
                if (this.buffInfoListBuilder_ == null) {
                    ensureBuffInfoListIsMutable();
                    this.buffInfoList_.remove(index);
                    onChanged();
                } else {
                    this.buffInfoListBuilder_.remove(index);
                }
                return this;
            }

            public CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo.Builder getBuffInfoListBuilder(int index) {
                return getBuffInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder
            public CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfoOrBuilder getBuffInfoListOrBuilder(int index) {
                if (this.buffInfoListBuilder_ == null) {
                    return this.buffInfoList_.get(index);
                }
                return this.buffInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkTeamInfoOuterClass.CrystalLinkTeamInfoOrBuilder
            public List<? extends CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfoOrBuilder> getBuffInfoListOrBuilderList() {
                if (this.buffInfoListBuilder_ != null) {
                    return this.buffInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.buffInfoList_);
            }

            public CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo.Builder addBuffInfoListBuilder() {
                return getBuffInfoListFieldBuilder().addBuilder(CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo.getDefaultInstance());
            }

            public CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo.Builder addBuffInfoListBuilder(int index) {
                return getBuffInfoListFieldBuilder().addBuilder(index, CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo.getDefaultInstance());
            }

            public List<CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo.Builder> getBuffInfoListBuilderList() {
                return getBuffInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo, CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo.Builder, CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfoOrBuilder> getBuffInfoListFieldBuilder() {
                if (this.buffInfoListBuilder_ == null) {
                    this.buffInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.buffInfoList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.buffInfoList_ = null;
                }
                return this.buffInfoListBuilder_;
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

        public static CrystalLinkTeamInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CrystalLinkTeamInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CrystalLinkTeamInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CrystalLinkTeamInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CrystalLinkAvatarInfoOuterClass.getDescriptor();
        CrystalLinkBuffInfoOuterClass.getDescriptor();
    }
}
