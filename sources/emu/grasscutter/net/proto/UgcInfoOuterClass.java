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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UgcInfoOuterClass.class */
public final class UgcInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\rUgcInfo.proto\u001a\u001bOfficialCustomDungeon.proto\"\u0001\n\u0007UgcInfo\u0012\u001a\n\u0012isUgcFeatureClosed\u0018\u0005 \u0001(\b\u00129\n\u0019officialCustomDungeonList\u0018\n \u0003(\u000b2\u0016.OfficialCustomDungeon\u0012\u0013\n\u000bisEnableUgc\u0018\u000f \u0001(\b\u0012\u001c\n\u0014customDungeonGroupId\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{OfficialCustomDungeonOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_UgcInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_UgcInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_UgcInfo_descriptor, new String[]{"IsUgcFeatureClosed", "OfficialCustomDungeonList", "IsEnableUgc", "CustomDungeonGroupId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UgcInfoOuterClass$UgcInfoOrBuilder.class */
    public interface UgcInfoOrBuilder extends MessageOrBuilder {
        boolean getIsUgcFeatureClosed();

        List<OfficialCustomDungeonOuterClass.OfficialCustomDungeon> getOfficialCustomDungeonListList();

        OfficialCustomDungeonOuterClass.OfficialCustomDungeon getOfficialCustomDungeonList(int i);

        int getOfficialCustomDungeonListCount();

        List<? extends OfficialCustomDungeonOuterClass.OfficialCustomDungeonOrBuilder> getOfficialCustomDungeonListOrBuilderList();

        OfficialCustomDungeonOuterClass.OfficialCustomDungeonOrBuilder getOfficialCustomDungeonListOrBuilder(int i);

        boolean getIsEnableUgc();

        int getCustomDungeonGroupId();
    }

    private UgcInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UgcInfoOuterClass$UgcInfo.class */
    public static final class UgcInfo extends GeneratedMessageV3 implements UgcInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISUGCFEATURECLOSED_FIELD_NUMBER = 5;
        private boolean isUgcFeatureClosed_;
        public static final int OFFICIALCUSTOMDUNGEONLIST_FIELD_NUMBER = 10;
        private List<OfficialCustomDungeonOuterClass.OfficialCustomDungeon> officialCustomDungeonList_;
        public static final int ISENABLEUGC_FIELD_NUMBER = 15;
        private boolean isEnableUgc_;
        public static final int CUSTOMDUNGEONGROUPID_FIELD_NUMBER = 3;
        private int customDungeonGroupId_;
        private byte memoizedIsInitialized;
        private static final UgcInfo DEFAULT_INSTANCE = new UgcInfo();
        private static final Parser<UgcInfo> PARSER = new AbstractParser<UgcInfo>() { // from class: emu.grasscutter.net.proto.UgcInfoOuterClass.UgcInfo.1
            @Override // com.google.protobuf.Parser
            public UgcInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new UgcInfo(input, extensionRegistry);
            }
        };

        private UgcInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private UgcInfo() {
            this.memoizedIsInitialized = -1;
            this.officialCustomDungeonList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new UgcInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UgcInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.customDungeonGroupId_ = input.readUInt32();
                                break;
                            case 40:
                                this.isUgcFeatureClosed_ = input.readBool();
                                break;
                            case 82:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.officialCustomDungeonList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.officialCustomDungeonList_.add((OfficialCustomDungeonOuterClass.OfficialCustomDungeon) input.readMessage(OfficialCustomDungeonOuterClass.OfficialCustomDungeon.parser(), extensionRegistry));
                                break;
                            case 120:
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
            return UgcInfoOuterClass.internal_static_UgcInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return UgcInfoOuterClass.internal_static_UgcInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(UgcInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.UgcInfoOuterClass.UgcInfoOrBuilder
        public boolean getIsUgcFeatureClosed() {
            return this.isUgcFeatureClosed_;
        }

        @Override // emu.grasscutter.net.proto.UgcInfoOuterClass.UgcInfoOrBuilder
        public List<OfficialCustomDungeonOuterClass.OfficialCustomDungeon> getOfficialCustomDungeonListList() {
            return this.officialCustomDungeonList_;
        }

        @Override // emu.grasscutter.net.proto.UgcInfoOuterClass.UgcInfoOrBuilder
        public List<? extends OfficialCustomDungeonOuterClass.OfficialCustomDungeonOrBuilder> getOfficialCustomDungeonListOrBuilderList() {
            return this.officialCustomDungeonList_;
        }

        @Override // emu.grasscutter.net.proto.UgcInfoOuterClass.UgcInfoOrBuilder
        public int getOfficialCustomDungeonListCount() {
            return this.officialCustomDungeonList_.size();
        }

        @Override // emu.grasscutter.net.proto.UgcInfoOuterClass.UgcInfoOrBuilder
        public OfficialCustomDungeonOuterClass.OfficialCustomDungeon getOfficialCustomDungeonList(int index) {
            return this.officialCustomDungeonList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.UgcInfoOuterClass.UgcInfoOrBuilder
        public OfficialCustomDungeonOuterClass.OfficialCustomDungeonOrBuilder getOfficialCustomDungeonListOrBuilder(int index) {
            return this.officialCustomDungeonList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.UgcInfoOuterClass.UgcInfoOrBuilder
        public boolean getIsEnableUgc() {
            return this.isEnableUgc_;
        }

        @Override // emu.grasscutter.net.proto.UgcInfoOuterClass.UgcInfoOrBuilder
        public int getCustomDungeonGroupId() {
            return this.customDungeonGroupId_;
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
                output.writeUInt32(3, this.customDungeonGroupId_);
            }
            if (this.isUgcFeatureClosed_) {
                output.writeBool(5, this.isUgcFeatureClosed_);
            }
            for (int i = 0; i < this.officialCustomDungeonList_.size(); i++) {
                output.writeMessage(10, this.officialCustomDungeonList_.get(i));
            }
            if (this.isEnableUgc_) {
                output.writeBool(15, this.isEnableUgc_);
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.customDungeonGroupId_);
            }
            if (this.isUgcFeatureClosed_) {
                size2 += CodedOutputStream.computeBoolSize(5, this.isUgcFeatureClosed_);
            }
            for (int i = 0; i < this.officialCustomDungeonList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(10, this.officialCustomDungeonList_.get(i));
            }
            if (this.isEnableUgc_) {
                size2 += CodedOutputStream.computeBoolSize(15, this.isEnableUgc_);
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
            if (!(obj instanceof UgcInfo)) {
                return equals(obj);
            }
            UgcInfo other = (UgcInfo) obj;
            return getIsUgcFeatureClosed() == other.getIsUgcFeatureClosed() && getOfficialCustomDungeonListList().equals(other.getOfficialCustomDungeonListList()) && getIsEnableUgc() == other.getIsEnableUgc() && getCustomDungeonGroupId() == other.getCustomDungeonGroupId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + Internal.hashBoolean(getIsUgcFeatureClosed());
            if (getOfficialCustomDungeonListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getOfficialCustomDungeonListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 15)) + Internal.hashBoolean(getIsEnableUgc()))) + 3)) + getCustomDungeonGroupId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static UgcInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UgcInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UgcInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UgcInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UgcInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UgcInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UgcInfo parseFrom(InputStream input) throws IOException {
            return (UgcInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UgcInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UgcInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static UgcInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (UgcInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static UgcInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UgcInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static UgcInfo parseFrom(CodedInputStream input) throws IOException {
            return (UgcInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UgcInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UgcInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UgcInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UgcInfoOuterClass$UgcInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UgcInfoOrBuilder {
            private int bitField0_;
            private boolean isUgcFeatureClosed_;
            private List<OfficialCustomDungeonOuterClass.OfficialCustomDungeon> officialCustomDungeonList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<OfficialCustomDungeonOuterClass.OfficialCustomDungeon, OfficialCustomDungeonOuterClass.OfficialCustomDungeon.Builder, OfficialCustomDungeonOuterClass.OfficialCustomDungeonOrBuilder> officialCustomDungeonListBuilder_;
            private boolean isEnableUgc_;
            private int customDungeonGroupId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return UgcInfoOuterClass.internal_static_UgcInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return UgcInfoOuterClass.internal_static_UgcInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(UgcInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (UgcInfo.alwaysUseFieldBuilders) {
                    getOfficialCustomDungeonListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isUgcFeatureClosed_ = false;
                if (this.officialCustomDungeonListBuilder_ == null) {
                    this.officialCustomDungeonList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.officialCustomDungeonListBuilder_.clear();
                }
                this.isEnableUgc_ = false;
                this.customDungeonGroupId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return UgcInfoOuterClass.internal_static_UgcInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public UgcInfo getDefaultInstanceForType() {
                return UgcInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UgcInfo build() {
                UgcInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UgcInfo buildPartial() {
                UgcInfo result = new UgcInfo(this);
                int i = this.bitField0_;
                result.isUgcFeatureClosed_ = this.isUgcFeatureClosed_;
                if (this.officialCustomDungeonListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.officialCustomDungeonList_ = Collections.unmodifiableList(this.officialCustomDungeonList_);
                        this.bitField0_ &= -2;
                    }
                    result.officialCustomDungeonList_ = this.officialCustomDungeonList_;
                } else {
                    result.officialCustomDungeonList_ = this.officialCustomDungeonListBuilder_.build();
                }
                result.isEnableUgc_ = this.isEnableUgc_;
                result.customDungeonGroupId_ = this.customDungeonGroupId_;
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
                if (other instanceof UgcInfo) {
                    return mergeFrom((UgcInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(UgcInfo other) {
                if (other == UgcInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsUgcFeatureClosed()) {
                    setIsUgcFeatureClosed(other.getIsUgcFeatureClosed());
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
                        this.officialCustomDungeonListBuilder_ = UgcInfo.alwaysUseFieldBuilders ? getOfficialCustomDungeonListFieldBuilder() : null;
                    } else {
                        this.officialCustomDungeonListBuilder_.addAllMessages(other.officialCustomDungeonList_);
                    }
                }
                if (other.getIsEnableUgc()) {
                    setIsEnableUgc(other.getIsEnableUgc());
                }
                if (other.getCustomDungeonGroupId() != 0) {
                    setCustomDungeonGroupId(other.getCustomDungeonGroupId());
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
                UgcInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = UgcInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (UgcInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.UgcInfoOuterClass.UgcInfoOrBuilder
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

            private void ensureOfficialCustomDungeonListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.officialCustomDungeonList_ = new ArrayList(this.officialCustomDungeonList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.UgcInfoOuterClass.UgcInfoOrBuilder
            public List<OfficialCustomDungeonOuterClass.OfficialCustomDungeon> getOfficialCustomDungeonListList() {
                if (this.officialCustomDungeonListBuilder_ == null) {
                    return Collections.unmodifiableList(this.officialCustomDungeonList_);
                }
                return this.officialCustomDungeonListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.UgcInfoOuterClass.UgcInfoOrBuilder
            public int getOfficialCustomDungeonListCount() {
                if (this.officialCustomDungeonListBuilder_ == null) {
                    return this.officialCustomDungeonList_.size();
                }
                return this.officialCustomDungeonListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.UgcInfoOuterClass.UgcInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.UgcInfoOuterClass.UgcInfoOrBuilder
            public OfficialCustomDungeonOuterClass.OfficialCustomDungeonOrBuilder getOfficialCustomDungeonListOrBuilder(int index) {
                if (this.officialCustomDungeonListBuilder_ == null) {
                    return this.officialCustomDungeonList_.get(index);
                }
                return this.officialCustomDungeonListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.UgcInfoOuterClass.UgcInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.UgcInfoOuterClass.UgcInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.UgcInfoOuterClass.UgcInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static UgcInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UgcInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<UgcInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UgcInfo getDefaultInstanceForType() {
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
