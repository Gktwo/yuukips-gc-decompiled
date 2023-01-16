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
import emu.grasscutter.net.proto.OfficialCustomDungeonOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UgcActivityDetailInfoOuterClass.class */
public final class UgcActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bUgcActivityDetailInfo.proto\u001a\u001bOfficialCustomDungeon.proto\"¬\u0001\n\u0015UgcActivityDetailInfo\u0012\u0015\n\ris_enable_ugc\u0018\u000e \u0001(\b\u0012<\n\u001cofficial_custom_dungeon_list\u0018\n \u0003(\u000b2\u0016.OfficialCustomDungeon\u0012\u001f\n\u0017custom_dungeon_group_id\u0018\u0004 \u0001(\r\u0012\u001d\n\u0015is_ugc_feature_closed\u0018\t \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{OfficialCustomDungeonOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_UgcActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_UgcActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_UgcActivityDetailInfo_descriptor, new String[]{"IsEnableUgc", "OfficialCustomDungeonList", "CustomDungeonGroupId", "IsUgcFeatureClosed"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UgcActivityDetailInfoOuterClass$UgcActivityDetailInfoOrBuilder.class */
    public interface UgcActivityDetailInfoOrBuilder extends MessageOrBuilder {
        boolean getIsEnableUgc();

        List<OfficialCustomDungeonOuterClass.OfficialCustomDungeon> getOfficialCustomDungeonListList();

        OfficialCustomDungeonOuterClass.OfficialCustomDungeon getOfficialCustomDungeonList(int i);

        int getOfficialCustomDungeonListCount();

        List<? extends OfficialCustomDungeonOuterClass.OfficialCustomDungeonOrBuilder> getOfficialCustomDungeonListOrBuilderList();

        OfficialCustomDungeonOuterClass.OfficialCustomDungeonOrBuilder getOfficialCustomDungeonListOrBuilder(int i);

        int getCustomDungeonGroupId();

        boolean getIsUgcFeatureClosed();
    }

    private UgcActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UgcActivityDetailInfoOuterClass$UgcActivityDetailInfo.class */
    public static final class UgcActivityDetailInfo extends GeneratedMessageV3 implements UgcActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_ENABLE_UGC_FIELD_NUMBER = 14;
        private boolean isEnableUgc_;
        public static final int OFFICIAL_CUSTOM_DUNGEON_LIST_FIELD_NUMBER = 10;
        private List<OfficialCustomDungeonOuterClass.OfficialCustomDungeon> officialCustomDungeonList_;
        public static final int CUSTOM_DUNGEON_GROUP_ID_FIELD_NUMBER = 4;
        private int customDungeonGroupId_;
        public static final int IS_UGC_FEATURE_CLOSED_FIELD_NUMBER = 9;
        private boolean isUgcFeatureClosed_;
        private byte memoizedIsInitialized;
        private static final UgcActivityDetailInfo DEFAULT_INSTANCE = new UgcActivityDetailInfo();
        private static final Parser<UgcActivityDetailInfo> PARSER = new AbstractParser<UgcActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public UgcActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new UgcActivityDetailInfo(input, extensionRegistry);
            }
        };

        private UgcActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private UgcActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.officialCustomDungeonList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new UgcActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UgcActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                this.customDungeonGroupId_ = input.readUInt32();
                                break;
                            case 72:
                                this.isUgcFeatureClosed_ = input.readBool();
                                break;
                            case 82:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.officialCustomDungeonList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.officialCustomDungeonList_.add((OfficialCustomDungeonOuterClass.OfficialCustomDungeon) input.readMessage(OfficialCustomDungeonOuterClass.OfficialCustomDungeon.parser(), extensionRegistry));
                                break;
                            case 112:
                                this.isEnableUgc_ = input.readBool();
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
                    this.officialCustomDungeonList_ = Collections.unmodifiableList(this.officialCustomDungeonList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return UgcActivityDetailInfoOuterClass.internal_static_UgcActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return UgcActivityDetailInfoOuterClass.internal_static_UgcActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(UgcActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.UgcActivityDetailInfoOuterClass.UgcActivityDetailInfoOrBuilder
        public boolean getIsEnableUgc() {
            return this.isEnableUgc_;
        }

        @Override // emu.grasscutter.net.proto.UgcActivityDetailInfoOuterClass.UgcActivityDetailInfoOrBuilder
        public List<OfficialCustomDungeonOuterClass.OfficialCustomDungeon> getOfficialCustomDungeonListList() {
            return this.officialCustomDungeonList_;
        }

        @Override // emu.grasscutter.net.proto.UgcActivityDetailInfoOuterClass.UgcActivityDetailInfoOrBuilder
        public List<? extends OfficialCustomDungeonOuterClass.OfficialCustomDungeonOrBuilder> getOfficialCustomDungeonListOrBuilderList() {
            return this.officialCustomDungeonList_;
        }

        @Override // emu.grasscutter.net.proto.UgcActivityDetailInfoOuterClass.UgcActivityDetailInfoOrBuilder
        public int getOfficialCustomDungeonListCount() {
            return this.officialCustomDungeonList_.size();
        }

        @Override // emu.grasscutter.net.proto.UgcActivityDetailInfoOuterClass.UgcActivityDetailInfoOrBuilder
        public OfficialCustomDungeonOuterClass.OfficialCustomDungeon getOfficialCustomDungeonList(int index) {
            return this.officialCustomDungeonList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.UgcActivityDetailInfoOuterClass.UgcActivityDetailInfoOrBuilder
        public OfficialCustomDungeonOuterClass.OfficialCustomDungeonOrBuilder getOfficialCustomDungeonListOrBuilder(int index) {
            return this.officialCustomDungeonList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.UgcActivityDetailInfoOuterClass.UgcActivityDetailInfoOrBuilder
        public int getCustomDungeonGroupId() {
            return this.customDungeonGroupId_;
        }

        @Override // emu.grasscutter.net.proto.UgcActivityDetailInfoOuterClass.UgcActivityDetailInfoOrBuilder
        public boolean getIsUgcFeatureClosed() {
            return this.isUgcFeatureClosed_;
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
            if (this.customDungeonGroupId_ != 0) {
                output.writeUInt32(4, this.customDungeonGroupId_);
            }
            if (this.isUgcFeatureClosed_) {
                output.writeBool(9, this.isUgcFeatureClosed_);
            }
            for (int i = 0; i < this.officialCustomDungeonList_.size(); i++) {
                output.writeMessage(10, this.officialCustomDungeonList_.get(i));
            }
            if (this.isEnableUgc_) {
                output.writeBool(14, this.isEnableUgc_);
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
            if (this.customDungeonGroupId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.customDungeonGroupId_);
            }
            if (this.isUgcFeatureClosed_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.isUgcFeatureClosed_);
            }
            for (int i = 0; i < this.officialCustomDungeonList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(10, this.officialCustomDungeonList_.get(i));
            }
            if (this.isEnableUgc_) {
                size2 += CodedOutputStream.computeBoolSize(14, this.isEnableUgc_);
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
            if (!(obj instanceof UgcActivityDetailInfo)) {
                return equals(obj);
            }
            UgcActivityDetailInfo other = (UgcActivityDetailInfo) obj;
            return getIsEnableUgc() == other.getIsEnableUgc() && getOfficialCustomDungeonListList().equals(other.getOfficialCustomDungeonListList()) && getCustomDungeonGroupId() == other.getCustomDungeonGroupId() && getIsUgcFeatureClosed() == other.getIsUgcFeatureClosed() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + Internal.hashBoolean(getIsEnableUgc());
            if (getOfficialCustomDungeonListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getOfficialCustomDungeonListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 4)) + getCustomDungeonGroupId())) + 9)) + Internal.hashBoolean(getIsUgcFeatureClosed()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static UgcActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UgcActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UgcActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UgcActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UgcActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UgcActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UgcActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (UgcActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UgcActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UgcActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static UgcActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (UgcActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static UgcActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UgcActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static UgcActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (UgcActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UgcActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UgcActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UgcActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UgcActivityDetailInfoOuterClass$UgcActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UgcActivityDetailInfoOrBuilder {
            private int bitField0_;
            private boolean isEnableUgc_;
            private List<OfficialCustomDungeonOuterClass.OfficialCustomDungeon> officialCustomDungeonList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<OfficialCustomDungeonOuterClass.OfficialCustomDungeon, OfficialCustomDungeonOuterClass.OfficialCustomDungeon.Builder, OfficialCustomDungeonOuterClass.OfficialCustomDungeonOrBuilder> officialCustomDungeonListBuilder_;
            private int customDungeonGroupId_;
            private boolean isUgcFeatureClosed_;

            public static final Descriptors.Descriptor getDescriptor() {
                return UgcActivityDetailInfoOuterClass.internal_static_UgcActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return UgcActivityDetailInfoOuterClass.internal_static_UgcActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(UgcActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (UgcActivityDetailInfo.alwaysUseFieldBuilders) {
                    getOfficialCustomDungeonListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isEnableUgc_ = false;
                if (this.officialCustomDungeonListBuilder_ == null) {
                    this.officialCustomDungeonList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.officialCustomDungeonListBuilder_.clear();
                }
                this.customDungeonGroupId_ = 0;
                this.isUgcFeatureClosed_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return UgcActivityDetailInfoOuterClass.internal_static_UgcActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public UgcActivityDetailInfo getDefaultInstanceForType() {
                return UgcActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UgcActivityDetailInfo build() {
                UgcActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UgcActivityDetailInfo buildPartial() {
                UgcActivityDetailInfo result = new UgcActivityDetailInfo(this);
                int i = this.bitField0_;
                result.isEnableUgc_ = this.isEnableUgc_;
                if (this.officialCustomDungeonListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.officialCustomDungeonList_ = Collections.unmodifiableList(this.officialCustomDungeonList_);
                        this.bitField0_ &= -2;
                    }
                    result.officialCustomDungeonList_ = this.officialCustomDungeonList_;
                } else {
                    result.officialCustomDungeonList_ = this.officialCustomDungeonListBuilder_.build();
                }
                result.customDungeonGroupId_ = this.customDungeonGroupId_;
                result.isUgcFeatureClosed_ = this.isUgcFeatureClosed_;
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
                if (other instanceof UgcActivityDetailInfo) {
                    return mergeFrom((UgcActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(UgcActivityDetailInfo other) {
                if (other == UgcActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsEnableUgc()) {
                    setIsEnableUgc(other.getIsEnableUgc());
                }
                if (this.officialCustomDungeonListBuilder_ == null) {
                    if (!other.officialCustomDungeonList_.isEmpty()) {
                        if (this.officialCustomDungeonList_.isEmpty()) {
                            this.officialCustomDungeonList_ = other.officialCustomDungeonList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureOfficialCustomDungeonListIsMutable();
                            this.officialCustomDungeonList_.addAll(other.officialCustomDungeonList_);
                        }
                        onChanged();
                    }
                } else if (!other.officialCustomDungeonList_.isEmpty()) {
                    if (this.officialCustomDungeonListBuilder_.isEmpty()) {
                        this.officialCustomDungeonListBuilder_.dispose();
                        this.officialCustomDungeonListBuilder_ = null;
                        this.officialCustomDungeonList_ = other.officialCustomDungeonList_;
                        this.bitField0_ &= -2;
                        this.officialCustomDungeonListBuilder_ = UgcActivityDetailInfo.alwaysUseFieldBuilders ? getOfficialCustomDungeonListFieldBuilder() : null;
                    } else {
                        this.officialCustomDungeonListBuilder_.addAllMessages(other.officialCustomDungeonList_);
                    }
                }
                if (other.getCustomDungeonGroupId() != 0) {
                    setCustomDungeonGroupId(other.getCustomDungeonGroupId());
                }
                if (other.getIsUgcFeatureClosed()) {
                    setIsUgcFeatureClosed(other.getIsUgcFeatureClosed());
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
                UgcActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = UgcActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (UgcActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.UgcActivityDetailInfoOuterClass.UgcActivityDetailInfoOrBuilder
            public boolean getIsEnableUgc() {
                return this.isEnableUgc_;
            }

            public Builder setIsEnableUgc(boolean value) {
                this.isEnableUgc_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsEnableUgc() {
                this.isEnableUgc_ = false;
                onChanged();
                return this;
            }

            private void ensureOfficialCustomDungeonListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.officialCustomDungeonList_ = new ArrayList(this.officialCustomDungeonList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.UgcActivityDetailInfoOuterClass.UgcActivityDetailInfoOrBuilder
            public List<OfficialCustomDungeonOuterClass.OfficialCustomDungeon> getOfficialCustomDungeonListList() {
                if (this.officialCustomDungeonListBuilder_ == null) {
                    return Collections.unmodifiableList(this.officialCustomDungeonList_);
                }
                return this.officialCustomDungeonListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.UgcActivityDetailInfoOuterClass.UgcActivityDetailInfoOrBuilder
            public int getOfficialCustomDungeonListCount() {
                if (this.officialCustomDungeonListBuilder_ == null) {
                    return this.officialCustomDungeonList_.size();
                }
                return this.officialCustomDungeonListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.UgcActivityDetailInfoOuterClass.UgcActivityDetailInfoOrBuilder
            public OfficialCustomDungeonOuterClass.OfficialCustomDungeon getOfficialCustomDungeonList(int index) {
                if (this.officialCustomDungeonListBuilder_ == null) {
                    return this.officialCustomDungeonList_.get(index);
                }
                return this.officialCustomDungeonListBuilder_.getMessage(index);
            }

            public Builder setOfficialCustomDungeonList(int index, OfficialCustomDungeonOuterClass.OfficialCustomDungeon value) {
                if (this.officialCustomDungeonListBuilder_ != null) {
                    this.officialCustomDungeonListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOfficialCustomDungeonListIsMutable();
                    this.officialCustomDungeonList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setOfficialCustomDungeonList(int index, OfficialCustomDungeonOuterClass.OfficialCustomDungeon.Builder builderForValue) {
                if (this.officialCustomDungeonListBuilder_ == null) {
                    ensureOfficialCustomDungeonListIsMutable();
                    this.officialCustomDungeonList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.officialCustomDungeonListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addOfficialCustomDungeonList(OfficialCustomDungeonOuterClass.OfficialCustomDungeon value) {
                if (this.officialCustomDungeonListBuilder_ != null) {
                    this.officialCustomDungeonListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOfficialCustomDungeonListIsMutable();
                    this.officialCustomDungeonList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addOfficialCustomDungeonList(int index, OfficialCustomDungeonOuterClass.OfficialCustomDungeon value) {
                if (this.officialCustomDungeonListBuilder_ != null) {
                    this.officialCustomDungeonListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOfficialCustomDungeonListIsMutable();
                    this.officialCustomDungeonList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addOfficialCustomDungeonList(OfficialCustomDungeonOuterClass.OfficialCustomDungeon.Builder builderForValue) {
                if (this.officialCustomDungeonListBuilder_ == null) {
                    ensureOfficialCustomDungeonListIsMutable();
                    this.officialCustomDungeonList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.officialCustomDungeonListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addOfficialCustomDungeonList(int index, OfficialCustomDungeonOuterClass.OfficialCustomDungeon.Builder builderForValue) {
                if (this.officialCustomDungeonListBuilder_ == null) {
                    ensureOfficialCustomDungeonListIsMutable();
                    this.officialCustomDungeonList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.officialCustomDungeonListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllOfficialCustomDungeonList(Iterable<? extends OfficialCustomDungeonOuterClass.OfficialCustomDungeon> values) {
                if (this.officialCustomDungeonListBuilder_ == null) {
                    ensureOfficialCustomDungeonListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.officialCustomDungeonList_);
                    onChanged();
                } else {
                    this.officialCustomDungeonListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearOfficialCustomDungeonList() {
                if (this.officialCustomDungeonListBuilder_ == null) {
                    this.officialCustomDungeonList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.officialCustomDungeonListBuilder_.clear();
                }
                return this;
            }

            public Builder removeOfficialCustomDungeonList(int index) {
                if (this.officialCustomDungeonListBuilder_ == null) {
                    ensureOfficialCustomDungeonListIsMutable();
                    this.officialCustomDungeonList_.remove(index);
                    onChanged();
                } else {
                    this.officialCustomDungeonListBuilder_.remove(index);
                }
                return this;
            }

            public OfficialCustomDungeonOuterClass.OfficialCustomDungeon.Builder getOfficialCustomDungeonListBuilder(int index) {
                return getOfficialCustomDungeonListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.UgcActivityDetailInfoOuterClass.UgcActivityDetailInfoOrBuilder
            public OfficialCustomDungeonOuterClass.OfficialCustomDungeonOrBuilder getOfficialCustomDungeonListOrBuilder(int index) {
                if (this.officialCustomDungeonListBuilder_ == null) {
                    return this.officialCustomDungeonList_.get(index);
                }
                return this.officialCustomDungeonListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.UgcActivityDetailInfoOuterClass.UgcActivityDetailInfoOrBuilder
            public List<? extends OfficialCustomDungeonOuterClass.OfficialCustomDungeonOrBuilder> getOfficialCustomDungeonListOrBuilderList() {
                if (this.officialCustomDungeonListBuilder_ != null) {
                    return this.officialCustomDungeonListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.officialCustomDungeonList_);
            }

            public OfficialCustomDungeonOuterClass.OfficialCustomDungeon.Builder addOfficialCustomDungeonListBuilder() {
                return getOfficialCustomDungeonListFieldBuilder().addBuilder(OfficialCustomDungeonOuterClass.OfficialCustomDungeon.getDefaultInstance());
            }

            public OfficialCustomDungeonOuterClass.OfficialCustomDungeon.Builder addOfficialCustomDungeonListBuilder(int index) {
                return getOfficialCustomDungeonListFieldBuilder().addBuilder(index, OfficialCustomDungeonOuterClass.OfficialCustomDungeon.getDefaultInstance());
            }

            public List<OfficialCustomDungeonOuterClass.OfficialCustomDungeon.Builder> getOfficialCustomDungeonListBuilderList() {
                return getOfficialCustomDungeonListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<OfficialCustomDungeonOuterClass.OfficialCustomDungeon, OfficialCustomDungeonOuterClass.OfficialCustomDungeon.Builder, OfficialCustomDungeonOuterClass.OfficialCustomDungeonOrBuilder> getOfficialCustomDungeonListFieldBuilder() {
                if (this.officialCustomDungeonListBuilder_ == null) {
                    this.officialCustomDungeonListBuilder_ = new RepeatedFieldBuilderV3<>(this.officialCustomDungeonList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.officialCustomDungeonList_ = null;
                }
                return this.officialCustomDungeonListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.UgcActivityDetailInfoOuterClass.UgcActivityDetailInfoOrBuilder
            public int getCustomDungeonGroupId() {
                return this.customDungeonGroupId_;
            }

            public Builder setCustomDungeonGroupId(int value) {
                this.customDungeonGroupId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCustomDungeonGroupId() {
                this.customDungeonGroupId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UgcActivityDetailInfoOuterClass.UgcActivityDetailInfoOrBuilder
            public boolean getIsUgcFeatureClosed() {
                return this.isUgcFeatureClosed_;
            }

            public Builder setIsUgcFeatureClosed(boolean value) {
                this.isUgcFeatureClosed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsUgcFeatureClosed() {
                this.isUgcFeatureClosed_ = false;
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

        public static UgcActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UgcActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<UgcActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UgcActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        OfficialCustomDungeonOuterClass.getDescriptor();
    }
}
