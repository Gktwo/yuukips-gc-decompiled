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
import emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SalvageStageInfoOuterClass.class */
public final class SalvageStageInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016SalvageStageInfo.proto\u001a\u001aSalvageChallengeInfo.proto\"h\n\u0010SalvageStageInfo\u0012\u000e\n\u0006isOpen\u0018\n \u0001(\b\u0012\u000f\n\u0007stageId\u0018\u000f \u0001(\r\u00123\n\u0014exceededItemTypeList\u0018\u0006 \u0003(\u000b2\u0015.SalvageChallengeInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SalvageChallengeInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SalvageStageInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SalvageStageInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SalvageStageInfo_descriptor, new String[]{"IsOpen", "StageId", "ExceededItemTypeList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SalvageStageInfoOuterClass$SalvageStageInfoOrBuilder.class */
    public interface SalvageStageInfoOrBuilder extends MessageOrBuilder {
        boolean getIsOpen();

        int getStageId();

        List<SalvageChallengeInfoOuterClass.SalvageChallengeInfo> getExceededItemTypeListList();

        SalvageChallengeInfoOuterClass.SalvageChallengeInfo getExceededItemTypeList(int i);

        int getExceededItemTypeListCount();

        List<? extends SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder> getExceededItemTypeListOrBuilderList();

        SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder getExceededItemTypeListOrBuilder(int i);
    }

    private SalvageStageInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SalvageStageInfoOuterClass$SalvageStageInfo.class */
    public static final class SalvageStageInfo extends GeneratedMessageV3 implements SalvageStageInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISOPEN_FIELD_NUMBER = 10;
        private boolean isOpen_;
        public static final int STAGEID_FIELD_NUMBER = 15;
        private int stageId_;
        public static final int EXCEEDEDITEMTYPELIST_FIELD_NUMBER = 6;
        private List<SalvageChallengeInfoOuterClass.SalvageChallengeInfo> exceededItemTypeList_;
        private byte memoizedIsInitialized;
        private static final SalvageStageInfo DEFAULT_INSTANCE = new SalvageStageInfo();
        private static final Parser<SalvageStageInfo> PARSER = new AbstractParser<SalvageStageInfo>() { // from class: emu.grasscutter.net.proto.SalvageStageInfoOuterClass.SalvageStageInfo.1
            @Override // com.google.protobuf.Parser
            public SalvageStageInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SalvageStageInfo(input, extensionRegistry);
            }
        };

        private SalvageStageInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SalvageStageInfo() {
            this.memoizedIsInitialized = -1;
            this.exceededItemTypeList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SalvageStageInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SalvageStageInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 50:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.exceededItemTypeList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.exceededItemTypeList_.add((SalvageChallengeInfoOuterClass.SalvageChallengeInfo) input.readMessage(SalvageChallengeInfoOuterClass.SalvageChallengeInfo.parser(), extensionRegistry));
                                break;
                            case 80:
                                this.isOpen_ = input.readBool();
                                break;
                            case 120:
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
                    this.exceededItemTypeList_ = Collections.unmodifiableList(this.exceededItemTypeList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SalvageStageInfoOuterClass.internal_static_SalvageStageInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SalvageStageInfoOuterClass.internal_static_SalvageStageInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SalvageStageInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder
        public List<SalvageChallengeInfoOuterClass.SalvageChallengeInfo> getExceededItemTypeListList() {
            return this.exceededItemTypeList_;
        }

        @Override // emu.grasscutter.net.proto.SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder
        public List<? extends SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder> getExceededItemTypeListOrBuilderList() {
            return this.exceededItemTypeList_;
        }

        @Override // emu.grasscutter.net.proto.SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder
        public int getExceededItemTypeListCount() {
            return this.exceededItemTypeList_.size();
        }

        @Override // emu.grasscutter.net.proto.SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder
        public SalvageChallengeInfoOuterClass.SalvageChallengeInfo getExceededItemTypeList(int index) {
            return this.exceededItemTypeList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder
        public SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder getExceededItemTypeListOrBuilder(int index) {
            return this.exceededItemTypeList_.get(index);
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
            for (int i = 0; i < this.exceededItemTypeList_.size(); i++) {
                output.writeMessage(6, this.exceededItemTypeList_.get(i));
            }
            if (this.isOpen_) {
                output.writeBool(10, this.isOpen_);
            }
            if (this.stageId_ != 0) {
                output.writeUInt32(15, this.stageId_);
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
            for (int i = 0; i < this.exceededItemTypeList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(6, this.exceededItemTypeList_.get(i));
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(10, this.isOpen_);
            }
            if (this.stageId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.stageId_);
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
            if (!(obj instanceof SalvageStageInfo)) {
                return equals(obj);
            }
            SalvageStageInfo other = (SalvageStageInfo) obj;
            return getIsOpen() == other.getIsOpen() && getStageId() == other.getStageId() && getExceededItemTypeListList().equals(other.getExceededItemTypeListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + Internal.hashBoolean(getIsOpen()))) + 15)) + getStageId();
            if (getExceededItemTypeListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getExceededItemTypeListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SalvageStageInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SalvageStageInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SalvageStageInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SalvageStageInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SalvageStageInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SalvageStageInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SalvageStageInfo parseFrom(InputStream input) throws IOException {
            return (SalvageStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SalvageStageInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SalvageStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SalvageStageInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SalvageStageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SalvageStageInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SalvageStageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SalvageStageInfo parseFrom(CodedInputStream input) throws IOException {
            return (SalvageStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SalvageStageInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SalvageStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SalvageStageInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SalvageStageInfoOuterClass$SalvageStageInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SalvageStageInfoOrBuilder {
            private int bitField0_;
            private boolean isOpen_;
            private int stageId_;
            private List<SalvageChallengeInfoOuterClass.SalvageChallengeInfo> exceededItemTypeList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<SalvageChallengeInfoOuterClass.SalvageChallengeInfo, SalvageChallengeInfoOuterClass.SalvageChallengeInfo.Builder, SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder> exceededItemTypeListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SalvageStageInfoOuterClass.internal_static_SalvageStageInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SalvageStageInfoOuterClass.internal_static_SalvageStageInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SalvageStageInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SalvageStageInfo.alwaysUseFieldBuilders) {
                    getExceededItemTypeListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isOpen_ = false;
                this.stageId_ = 0;
                if (this.exceededItemTypeListBuilder_ == null) {
                    this.exceededItemTypeList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.exceededItemTypeListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SalvageStageInfoOuterClass.internal_static_SalvageStageInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SalvageStageInfo getDefaultInstanceForType() {
                return SalvageStageInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SalvageStageInfo build() {
                SalvageStageInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SalvageStageInfo buildPartial() {
                SalvageStageInfo result = new SalvageStageInfo(this);
                int i = this.bitField0_;
                result.isOpen_ = this.isOpen_;
                result.stageId_ = this.stageId_;
                if (this.exceededItemTypeListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.exceededItemTypeList_ = Collections.unmodifiableList(this.exceededItemTypeList_);
                        this.bitField0_ &= -2;
                    }
                    result.exceededItemTypeList_ = this.exceededItemTypeList_;
                } else {
                    result.exceededItemTypeList_ = this.exceededItemTypeListBuilder_.build();
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
                if (other instanceof SalvageStageInfo) {
                    return mergeFrom((SalvageStageInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SalvageStageInfo other) {
                if (other == SalvageStageInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (this.exceededItemTypeListBuilder_ == null) {
                    if (!other.exceededItemTypeList_.isEmpty()) {
                        if (this.exceededItemTypeList_.isEmpty()) {
                            this.exceededItemTypeList_ = other.exceededItemTypeList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureExceededItemTypeListIsMutable();
                            this.exceededItemTypeList_.addAll(other.exceededItemTypeList_);
                        }
                        onChanged();
                    }
                } else if (!other.exceededItemTypeList_.isEmpty()) {
                    if (this.exceededItemTypeListBuilder_.isEmpty()) {
                        this.exceededItemTypeListBuilder_.dispose();
                        this.exceededItemTypeListBuilder_ = null;
                        this.exceededItemTypeList_ = other.exceededItemTypeList_;
                        this.bitField0_ &= -2;
                        this.exceededItemTypeListBuilder_ = SalvageStageInfo.alwaysUseFieldBuilders ? getExceededItemTypeListFieldBuilder() : null;
                    } else {
                        this.exceededItemTypeListBuilder_.addAllMessages(other.exceededItemTypeList_);
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
                SalvageStageInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SalvageStageInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SalvageStageInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder
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

            private void ensureExceededItemTypeListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.exceededItemTypeList_ = new ArrayList(this.exceededItemTypeList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder
            public List<SalvageChallengeInfoOuterClass.SalvageChallengeInfo> getExceededItemTypeListList() {
                if (this.exceededItemTypeListBuilder_ == null) {
                    return Collections.unmodifiableList(this.exceededItemTypeList_);
                }
                return this.exceededItemTypeListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder
            public int getExceededItemTypeListCount() {
                if (this.exceededItemTypeListBuilder_ == null) {
                    return this.exceededItemTypeList_.size();
                }
                return this.exceededItemTypeListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder
            public SalvageChallengeInfoOuterClass.SalvageChallengeInfo getExceededItemTypeList(int index) {
                if (this.exceededItemTypeListBuilder_ == null) {
                    return this.exceededItemTypeList_.get(index);
                }
                return this.exceededItemTypeListBuilder_.getMessage(index);
            }

            public Builder setExceededItemTypeList(int index, SalvageChallengeInfoOuterClass.SalvageChallengeInfo value) {
                if (this.exceededItemTypeListBuilder_ != null) {
                    this.exceededItemTypeListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExceededItemTypeListIsMutable();
                    this.exceededItemTypeList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setExceededItemTypeList(int index, SalvageChallengeInfoOuterClass.SalvageChallengeInfo.Builder builderForValue) {
                if (this.exceededItemTypeListBuilder_ == null) {
                    ensureExceededItemTypeListIsMutable();
                    this.exceededItemTypeList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.exceededItemTypeListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addExceededItemTypeList(SalvageChallengeInfoOuterClass.SalvageChallengeInfo value) {
                if (this.exceededItemTypeListBuilder_ != null) {
                    this.exceededItemTypeListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExceededItemTypeListIsMutable();
                    this.exceededItemTypeList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addExceededItemTypeList(int index, SalvageChallengeInfoOuterClass.SalvageChallengeInfo value) {
                if (this.exceededItemTypeListBuilder_ != null) {
                    this.exceededItemTypeListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExceededItemTypeListIsMutable();
                    this.exceededItemTypeList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addExceededItemTypeList(SalvageChallengeInfoOuterClass.SalvageChallengeInfo.Builder builderForValue) {
                if (this.exceededItemTypeListBuilder_ == null) {
                    ensureExceededItemTypeListIsMutable();
                    this.exceededItemTypeList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.exceededItemTypeListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addExceededItemTypeList(int index, SalvageChallengeInfoOuterClass.SalvageChallengeInfo.Builder builderForValue) {
                if (this.exceededItemTypeListBuilder_ == null) {
                    ensureExceededItemTypeListIsMutable();
                    this.exceededItemTypeList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.exceededItemTypeListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllExceededItemTypeList(Iterable<? extends SalvageChallengeInfoOuterClass.SalvageChallengeInfo> values) {
                if (this.exceededItemTypeListBuilder_ == null) {
                    ensureExceededItemTypeListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.exceededItemTypeList_);
                    onChanged();
                } else {
                    this.exceededItemTypeListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearExceededItemTypeList() {
                if (this.exceededItemTypeListBuilder_ == null) {
                    this.exceededItemTypeList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.exceededItemTypeListBuilder_.clear();
                }
                return this;
            }

            public Builder removeExceededItemTypeList(int index) {
                if (this.exceededItemTypeListBuilder_ == null) {
                    ensureExceededItemTypeListIsMutable();
                    this.exceededItemTypeList_.remove(index);
                    onChanged();
                } else {
                    this.exceededItemTypeListBuilder_.remove(index);
                }
                return this;
            }

            public SalvageChallengeInfoOuterClass.SalvageChallengeInfo.Builder getExceededItemTypeListBuilder(int index) {
                return getExceededItemTypeListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder
            public SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder getExceededItemTypeListOrBuilder(int index) {
                if (this.exceededItemTypeListBuilder_ == null) {
                    return this.exceededItemTypeList_.get(index);
                }
                return this.exceededItemTypeListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder
            public List<? extends SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder> getExceededItemTypeListOrBuilderList() {
                if (this.exceededItemTypeListBuilder_ != null) {
                    return this.exceededItemTypeListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.exceededItemTypeList_);
            }

            public SalvageChallengeInfoOuterClass.SalvageChallengeInfo.Builder addExceededItemTypeListBuilder() {
                return getExceededItemTypeListFieldBuilder().addBuilder(SalvageChallengeInfoOuterClass.SalvageChallengeInfo.getDefaultInstance());
            }

            public SalvageChallengeInfoOuterClass.SalvageChallengeInfo.Builder addExceededItemTypeListBuilder(int index) {
                return getExceededItemTypeListFieldBuilder().addBuilder(index, SalvageChallengeInfoOuterClass.SalvageChallengeInfo.getDefaultInstance());
            }

            public List<SalvageChallengeInfoOuterClass.SalvageChallengeInfo.Builder> getExceededItemTypeListBuilderList() {
                return getExceededItemTypeListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<SalvageChallengeInfoOuterClass.SalvageChallengeInfo, SalvageChallengeInfoOuterClass.SalvageChallengeInfo.Builder, SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder> getExceededItemTypeListFieldBuilder() {
                if (this.exceededItemTypeListBuilder_ == null) {
                    this.exceededItemTypeListBuilder_ = new RepeatedFieldBuilderV3<>(this.exceededItemTypeList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.exceededItemTypeList_ = null;
                }
                return this.exceededItemTypeListBuilder_;
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

        public static SalvageStageInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SalvageStageInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SalvageStageInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SalvageStageInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SalvageChallengeInfoOuterClass.getDescriptor();
    }
}
