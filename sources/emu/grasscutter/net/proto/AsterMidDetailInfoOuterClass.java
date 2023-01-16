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
import emu.grasscutter.net.proto.AsterMidCampInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AsterMidDetailInfoOuterClass.class */
public final class AsterMidDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018AsterMidDetailInfo.proto\u001a\u0016AsterMidCampInfo.proto\"v\n\u0012AsterMidDetailInfo\u0012\u000f\n\u0007is_open\u0018\r \u0001(\b\u0012$\n\tcamp_list\u0018\u000b \u0003(\u000b2\u0011.AsterMidCampInfo\u0012\u0012\n\nbegin_time\u0018\u0004 \u0001(\r\u0012\u0015\n\rcollect_count\u0018\u0007 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AsterMidCampInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AsterMidDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AsterMidDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AsterMidDetailInfo_descriptor, new String[]{"IsOpen", "CampList", "BeginTime", "CollectCount"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AsterMidDetailInfoOuterClass$AsterMidDetailInfoOrBuilder.class */
    public interface AsterMidDetailInfoOrBuilder extends MessageOrBuilder {
        boolean getIsOpen();

        List<AsterMidCampInfoOuterClass.AsterMidCampInfo> getCampListList();

        AsterMidCampInfoOuterClass.AsterMidCampInfo getCampList(int i);

        int getCampListCount();

        List<? extends AsterMidCampInfoOuterClass.AsterMidCampInfoOrBuilder> getCampListOrBuilderList();

        AsterMidCampInfoOuterClass.AsterMidCampInfoOrBuilder getCampListOrBuilder(int i);

        int getBeginTime();

        int getCollectCount();
    }

    private AsterMidDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AsterMidDetailInfoOuterClass$AsterMidDetailInfo.class */
    public static final class AsterMidDetailInfo extends GeneratedMessageV3 implements AsterMidDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_OPEN_FIELD_NUMBER = 13;
        private boolean isOpen_;
        public static final int CAMP_LIST_FIELD_NUMBER = 11;
        private List<AsterMidCampInfoOuterClass.AsterMidCampInfo> campList_;
        public static final int BEGIN_TIME_FIELD_NUMBER = 4;
        private int beginTime_;
        public static final int COLLECT_COUNT_FIELD_NUMBER = 7;
        private int collectCount_;
        private byte memoizedIsInitialized;
        private static final AsterMidDetailInfo DEFAULT_INSTANCE = new AsterMidDetailInfo();
        private static final Parser<AsterMidDetailInfo> PARSER = new AbstractParser<AsterMidDetailInfo>() { // from class: emu.grasscutter.net.proto.AsterMidDetailInfoOuterClass.AsterMidDetailInfo.1
            @Override // com.google.protobuf.Parser
            public AsterMidDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AsterMidDetailInfo(input, extensionRegistry);
            }
        };

        private AsterMidDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AsterMidDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.campList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AsterMidDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AsterMidDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.beginTime_ = input.readUInt32();
                                break;
                            case 56:
                                this.collectCount_ = input.readUInt32();
                                break;
                            case 90:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.campList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.campList_.add((AsterMidCampInfoOuterClass.AsterMidCampInfo) input.readMessage(AsterMidCampInfoOuterClass.AsterMidCampInfo.parser(), extensionRegistry));
                                break;
                            case 104:
                                this.isOpen_ = input.readBool();
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
                    this.campList_ = Collections.unmodifiableList(this.campList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AsterMidDetailInfoOuterClass.internal_static_AsterMidDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AsterMidDetailInfoOuterClass.internal_static_AsterMidDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AsterMidDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder
        public List<AsterMidCampInfoOuterClass.AsterMidCampInfo> getCampListList() {
            return this.campList_;
        }

        @Override // emu.grasscutter.net.proto.AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder
        public List<? extends AsterMidCampInfoOuterClass.AsterMidCampInfoOrBuilder> getCampListOrBuilderList() {
            return this.campList_;
        }

        @Override // emu.grasscutter.net.proto.AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder
        public int getCampListCount() {
            return this.campList_.size();
        }

        @Override // emu.grasscutter.net.proto.AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder
        public AsterMidCampInfoOuterClass.AsterMidCampInfo getCampList(int index) {
            return this.campList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder
        public AsterMidCampInfoOuterClass.AsterMidCampInfoOrBuilder getCampListOrBuilder(int index) {
            return this.campList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder
        public int getBeginTime() {
            return this.beginTime_;
        }

        @Override // emu.grasscutter.net.proto.AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder
        public int getCollectCount() {
            return this.collectCount_;
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
            if (this.beginTime_ != 0) {
                output.writeUInt32(4, this.beginTime_);
            }
            if (this.collectCount_ != 0) {
                output.writeUInt32(7, this.collectCount_);
            }
            for (int i = 0; i < this.campList_.size(); i++) {
                output.writeMessage(11, this.campList_.get(i));
            }
            if (this.isOpen_) {
                output.writeBool(13, this.isOpen_);
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
            if (this.beginTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.beginTime_);
            }
            if (this.collectCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.collectCount_);
            }
            for (int i = 0; i < this.campList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.campList_.get(i));
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(13, this.isOpen_);
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
            if (!(obj instanceof AsterMidDetailInfo)) {
                return equals(obj);
            }
            AsterMidDetailInfo other = (AsterMidDetailInfo) obj;
            return getIsOpen() == other.getIsOpen() && getCampListList().equals(other.getCampListList()) && getBeginTime() == other.getBeginTime() && getCollectCount() == other.getCollectCount() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + Internal.hashBoolean(getIsOpen());
            if (getCampListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getCampListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 4)) + getBeginTime())) + 7)) + getCollectCount())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AsterMidDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AsterMidDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AsterMidDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AsterMidDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AsterMidDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AsterMidDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AsterMidDetailInfo parseFrom(InputStream input) throws IOException {
            return (AsterMidDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AsterMidDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AsterMidDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AsterMidDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (AsterMidDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AsterMidDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AsterMidDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AsterMidDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (AsterMidDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AsterMidDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AsterMidDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AsterMidDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AsterMidDetailInfoOuterClass$AsterMidDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AsterMidDetailInfoOrBuilder {
            private int bitField0_;
            private boolean isOpen_;
            private List<AsterMidCampInfoOuterClass.AsterMidCampInfo> campList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<AsterMidCampInfoOuterClass.AsterMidCampInfo, AsterMidCampInfoOuterClass.AsterMidCampInfo.Builder, AsterMidCampInfoOuterClass.AsterMidCampInfoOrBuilder> campListBuilder_;
            private int beginTime_;
            private int collectCount_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AsterMidDetailInfoOuterClass.internal_static_AsterMidDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AsterMidDetailInfoOuterClass.internal_static_AsterMidDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AsterMidDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AsterMidDetailInfo.alwaysUseFieldBuilders) {
                    getCampListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isOpen_ = false;
                if (this.campListBuilder_ == null) {
                    this.campList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.campListBuilder_.clear();
                }
                this.beginTime_ = 0;
                this.collectCount_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AsterMidDetailInfoOuterClass.internal_static_AsterMidDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AsterMidDetailInfo getDefaultInstanceForType() {
                return AsterMidDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AsterMidDetailInfo build() {
                AsterMidDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AsterMidDetailInfo buildPartial() {
                AsterMidDetailInfo result = new AsterMidDetailInfo(this);
                int i = this.bitField0_;
                result.isOpen_ = this.isOpen_;
                if (this.campListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.campList_ = Collections.unmodifiableList(this.campList_);
                        this.bitField0_ &= -2;
                    }
                    result.campList_ = this.campList_;
                } else {
                    result.campList_ = this.campListBuilder_.build();
                }
                result.beginTime_ = this.beginTime_;
                result.collectCount_ = this.collectCount_;
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
                if (other instanceof AsterMidDetailInfo) {
                    return mergeFrom((AsterMidDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AsterMidDetailInfo other) {
                if (other == AsterMidDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (this.campListBuilder_ == null) {
                    if (!other.campList_.isEmpty()) {
                        if (this.campList_.isEmpty()) {
                            this.campList_ = other.campList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureCampListIsMutable();
                            this.campList_.addAll(other.campList_);
                        }
                        onChanged();
                    }
                } else if (!other.campList_.isEmpty()) {
                    if (this.campListBuilder_.isEmpty()) {
                        this.campListBuilder_.dispose();
                        this.campListBuilder_ = null;
                        this.campList_ = other.campList_;
                        this.bitField0_ &= -2;
                        this.campListBuilder_ = AsterMidDetailInfo.alwaysUseFieldBuilders ? getCampListFieldBuilder() : null;
                    } else {
                        this.campListBuilder_.addAllMessages(other.campList_);
                    }
                }
                if (other.getBeginTime() != 0) {
                    setBeginTime(other.getBeginTime());
                }
                if (other.getCollectCount() != 0) {
                    setCollectCount(other.getCollectCount());
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
                AsterMidDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = AsterMidDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AsterMidDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder
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

            private void ensureCampListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.campList_ = new ArrayList(this.campList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder
            public List<AsterMidCampInfoOuterClass.AsterMidCampInfo> getCampListList() {
                if (this.campListBuilder_ == null) {
                    return Collections.unmodifiableList(this.campList_);
                }
                return this.campListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder
            public int getCampListCount() {
                if (this.campListBuilder_ == null) {
                    return this.campList_.size();
                }
                return this.campListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder
            public AsterMidCampInfoOuterClass.AsterMidCampInfo getCampList(int index) {
                if (this.campListBuilder_ == null) {
                    return this.campList_.get(index);
                }
                return this.campListBuilder_.getMessage(index);
            }

            public Builder setCampList(int index, AsterMidCampInfoOuterClass.AsterMidCampInfo value) {
                if (this.campListBuilder_ != null) {
                    this.campListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCampListIsMutable();
                    this.campList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setCampList(int index, AsterMidCampInfoOuterClass.AsterMidCampInfo.Builder builderForValue) {
                if (this.campListBuilder_ == null) {
                    ensureCampListIsMutable();
                    this.campList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.campListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addCampList(AsterMidCampInfoOuterClass.AsterMidCampInfo value) {
                if (this.campListBuilder_ != null) {
                    this.campListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCampListIsMutable();
                    this.campList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addCampList(int index, AsterMidCampInfoOuterClass.AsterMidCampInfo value) {
                if (this.campListBuilder_ != null) {
                    this.campListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCampListIsMutable();
                    this.campList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addCampList(AsterMidCampInfoOuterClass.AsterMidCampInfo.Builder builderForValue) {
                if (this.campListBuilder_ == null) {
                    ensureCampListIsMutable();
                    this.campList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.campListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addCampList(int index, AsterMidCampInfoOuterClass.AsterMidCampInfo.Builder builderForValue) {
                if (this.campListBuilder_ == null) {
                    ensureCampListIsMutable();
                    this.campList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.campListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllCampList(Iterable<? extends AsterMidCampInfoOuterClass.AsterMidCampInfo> values) {
                if (this.campListBuilder_ == null) {
                    ensureCampListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.campList_);
                    onChanged();
                } else {
                    this.campListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearCampList() {
                if (this.campListBuilder_ == null) {
                    this.campList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.campListBuilder_.clear();
                }
                return this;
            }

            public Builder removeCampList(int index) {
                if (this.campListBuilder_ == null) {
                    ensureCampListIsMutable();
                    this.campList_.remove(index);
                    onChanged();
                } else {
                    this.campListBuilder_.remove(index);
                }
                return this;
            }

            public AsterMidCampInfoOuterClass.AsterMidCampInfo.Builder getCampListBuilder(int index) {
                return getCampListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder
            public AsterMidCampInfoOuterClass.AsterMidCampInfoOrBuilder getCampListOrBuilder(int index) {
                if (this.campListBuilder_ == null) {
                    return this.campList_.get(index);
                }
                return this.campListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder
            public List<? extends AsterMidCampInfoOuterClass.AsterMidCampInfoOrBuilder> getCampListOrBuilderList() {
                if (this.campListBuilder_ != null) {
                    return this.campListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.campList_);
            }

            public AsterMidCampInfoOuterClass.AsterMidCampInfo.Builder addCampListBuilder() {
                return getCampListFieldBuilder().addBuilder(AsterMidCampInfoOuterClass.AsterMidCampInfo.getDefaultInstance());
            }

            public AsterMidCampInfoOuterClass.AsterMidCampInfo.Builder addCampListBuilder(int index) {
                return getCampListFieldBuilder().addBuilder(index, AsterMidCampInfoOuterClass.AsterMidCampInfo.getDefaultInstance());
            }

            public List<AsterMidCampInfoOuterClass.AsterMidCampInfo.Builder> getCampListBuilderList() {
                return getCampListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AsterMidCampInfoOuterClass.AsterMidCampInfo, AsterMidCampInfoOuterClass.AsterMidCampInfo.Builder, AsterMidCampInfoOuterClass.AsterMidCampInfoOrBuilder> getCampListFieldBuilder() {
                if (this.campListBuilder_ == null) {
                    this.campListBuilder_ = new RepeatedFieldBuilderV3<>(this.campList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.campList_ = null;
                }
                return this.campListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder
            public int getBeginTime() {
                return this.beginTime_;
            }

            public Builder setBeginTime(int value) {
                this.beginTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearBeginTime() {
                this.beginTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder
            public int getCollectCount() {
                return this.collectCount_;
            }

            public Builder setCollectCount(int value) {
                this.collectCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearCollectCount() {
                this.collectCount_ = 0;
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

        public static AsterMidDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AsterMidDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AsterMidDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AsterMidDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AsterMidCampInfoOuterClass.getDescriptor();
    }
}
