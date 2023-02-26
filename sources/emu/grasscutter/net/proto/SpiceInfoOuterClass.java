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
import emu.grasscutter.net.proto.SpiceStageDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SpiceInfoOuterClass.class */
public final class SpiceInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fSpiceInfo.proto\u001a\u0014SpiceStageData.proto\"r\n\tSpiceInfo\u0012\u001b\n\u0013Unk3300_CIHIAJEGCBO\u0018\b \u0001(\r\u0012+\n\u0012spiceStageDataList\u0018\u000b \u0003(\u000b2\u000f.SpiceStageData\u0012\u001b\n\u0013Unk3300_LAKPMMIPBMI\u0018\u000e \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SpiceStageDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SpiceInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SpiceInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SpiceInfo_descriptor, new String[]{"Unk3300CIHIAJEGCBO", "SpiceStageDataList", "Unk3300LAKPMMIPBMI"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SpiceInfoOuterClass$SpiceInfoOrBuilder.class */
    public interface SpiceInfoOrBuilder extends MessageOrBuilder {
        int getUnk3300CIHIAJEGCBO();

        List<SpiceStageDataOuterClass.SpiceStageData> getSpiceStageDataListList();

        SpiceStageDataOuterClass.SpiceStageData getSpiceStageDataList(int i);

        int getSpiceStageDataListCount();

        List<? extends SpiceStageDataOuterClass.SpiceStageDataOrBuilder> getSpiceStageDataListOrBuilderList();

        SpiceStageDataOuterClass.SpiceStageDataOrBuilder getSpiceStageDataListOrBuilder(int i);

        int getUnk3300LAKPMMIPBMI();
    }

    private SpiceInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SpiceInfoOuterClass$SpiceInfo.class */
    public static final class SpiceInfo extends GeneratedMessageV3 implements SpiceInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_CIHIAJEGCBO_FIELD_NUMBER = 8;
        private int unk3300CIHIAJEGCBO_;
        public static final int SPICESTAGEDATALIST_FIELD_NUMBER = 11;
        private List<SpiceStageDataOuterClass.SpiceStageData> spiceStageDataList_;
        public static final int UNK3300_LAKPMMIPBMI_FIELD_NUMBER = 14;
        private int unk3300LAKPMMIPBMI_;
        private byte memoizedIsInitialized;
        private static final SpiceInfo DEFAULT_INSTANCE = new SpiceInfo();
        private static final Parser<SpiceInfo> PARSER = new AbstractParser<SpiceInfo>() { // from class: emu.grasscutter.net.proto.SpiceInfoOuterClass.SpiceInfo.1
            @Override // com.google.protobuf.Parser
            public SpiceInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SpiceInfo(input, extensionRegistry);
            }
        };

        private SpiceInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SpiceInfo() {
            this.memoizedIsInitialized = -1;
            this.spiceStageDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SpiceInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SpiceInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 64:
                                this.unk3300CIHIAJEGCBO_ = input.readUInt32();
                                break;
                            case 90:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.spiceStageDataList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.spiceStageDataList_.add((SpiceStageDataOuterClass.SpiceStageData) input.readMessage(SpiceStageDataOuterClass.SpiceStageData.parser(), extensionRegistry));
                                break;
                            case 112:
                                this.unk3300LAKPMMIPBMI_ = input.readUInt32();
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
                    this.spiceStageDataList_ = Collections.unmodifiableList(this.spiceStageDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SpiceInfoOuterClass.internal_static_SpiceInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SpiceInfoOuterClass.internal_static_SpiceInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SpiceInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SpiceInfoOuterClass.SpiceInfoOrBuilder
        public int getUnk3300CIHIAJEGCBO() {
            return this.unk3300CIHIAJEGCBO_;
        }

        @Override // emu.grasscutter.net.proto.SpiceInfoOuterClass.SpiceInfoOrBuilder
        public List<SpiceStageDataOuterClass.SpiceStageData> getSpiceStageDataListList() {
            return this.spiceStageDataList_;
        }

        @Override // emu.grasscutter.net.proto.SpiceInfoOuterClass.SpiceInfoOrBuilder
        public List<? extends SpiceStageDataOuterClass.SpiceStageDataOrBuilder> getSpiceStageDataListOrBuilderList() {
            return this.spiceStageDataList_;
        }

        @Override // emu.grasscutter.net.proto.SpiceInfoOuterClass.SpiceInfoOrBuilder
        public int getSpiceStageDataListCount() {
            return this.spiceStageDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.SpiceInfoOuterClass.SpiceInfoOrBuilder
        public SpiceStageDataOuterClass.SpiceStageData getSpiceStageDataList(int index) {
            return this.spiceStageDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SpiceInfoOuterClass.SpiceInfoOrBuilder
        public SpiceStageDataOuterClass.SpiceStageDataOrBuilder getSpiceStageDataListOrBuilder(int index) {
            return this.spiceStageDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SpiceInfoOuterClass.SpiceInfoOrBuilder
        public int getUnk3300LAKPMMIPBMI() {
            return this.unk3300LAKPMMIPBMI_;
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
            if (this.unk3300CIHIAJEGCBO_ != 0) {
                output.writeUInt32(8, this.unk3300CIHIAJEGCBO_);
            }
            for (int i = 0; i < this.spiceStageDataList_.size(); i++) {
                output.writeMessage(11, this.spiceStageDataList_.get(i));
            }
            if (this.unk3300LAKPMMIPBMI_ != 0) {
                output.writeUInt32(14, this.unk3300LAKPMMIPBMI_);
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
            if (this.unk3300CIHIAJEGCBO_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(8, this.unk3300CIHIAJEGCBO_);
            }
            for (int i = 0; i < this.spiceStageDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.spiceStageDataList_.get(i));
            }
            if (this.unk3300LAKPMMIPBMI_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.unk3300LAKPMMIPBMI_);
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
            if (!(obj instanceof SpiceInfo)) {
                return equals(obj);
            }
            SpiceInfo other = (SpiceInfo) obj;
            return getUnk3300CIHIAJEGCBO() == other.getUnk3300CIHIAJEGCBO() && getSpiceStageDataListList().equals(other.getSpiceStageDataListList()) && getUnk3300LAKPMMIPBMI() == other.getUnk3300LAKPMMIPBMI() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + getUnk3300CIHIAJEGCBO();
            if (getSpiceStageDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getSpiceStageDataListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 14)) + getUnk3300LAKPMMIPBMI())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SpiceInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SpiceInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SpiceInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SpiceInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SpiceInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SpiceInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SpiceInfo parseFrom(InputStream input) throws IOException {
            return (SpiceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SpiceInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SpiceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SpiceInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SpiceInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SpiceInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SpiceInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SpiceInfo parseFrom(CodedInputStream input) throws IOException {
            return (SpiceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SpiceInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SpiceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SpiceInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SpiceInfoOuterClass$SpiceInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SpiceInfoOrBuilder {
            private int bitField0_;
            private int unk3300CIHIAJEGCBO_;
            private List<SpiceStageDataOuterClass.SpiceStageData> spiceStageDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<SpiceStageDataOuterClass.SpiceStageData, SpiceStageDataOuterClass.SpiceStageData.Builder, SpiceStageDataOuterClass.SpiceStageDataOrBuilder> spiceStageDataListBuilder_;
            private int unk3300LAKPMMIPBMI_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SpiceInfoOuterClass.internal_static_SpiceInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SpiceInfoOuterClass.internal_static_SpiceInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SpiceInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SpiceInfo.alwaysUseFieldBuilders) {
                    getSpiceStageDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300CIHIAJEGCBO_ = 0;
                if (this.spiceStageDataListBuilder_ == null) {
                    this.spiceStageDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.spiceStageDataListBuilder_.clear();
                }
                this.unk3300LAKPMMIPBMI_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SpiceInfoOuterClass.internal_static_SpiceInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SpiceInfo getDefaultInstanceForType() {
                return SpiceInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SpiceInfo build() {
                SpiceInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SpiceInfo buildPartial() {
                SpiceInfo result = new SpiceInfo(this);
                int i = this.bitField0_;
                result.unk3300CIHIAJEGCBO_ = this.unk3300CIHIAJEGCBO_;
                if (this.spiceStageDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.spiceStageDataList_ = Collections.unmodifiableList(this.spiceStageDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.spiceStageDataList_ = this.spiceStageDataList_;
                } else {
                    result.spiceStageDataList_ = this.spiceStageDataListBuilder_.build();
                }
                result.unk3300LAKPMMIPBMI_ = this.unk3300LAKPMMIPBMI_;
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
                if (other instanceof SpiceInfo) {
                    return mergeFrom((SpiceInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SpiceInfo other) {
                if (other == SpiceInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300CIHIAJEGCBO() != 0) {
                    setUnk3300CIHIAJEGCBO(other.getUnk3300CIHIAJEGCBO());
                }
                if (this.spiceStageDataListBuilder_ == null) {
                    if (!other.spiceStageDataList_.isEmpty()) {
                        if (this.spiceStageDataList_.isEmpty()) {
                            this.spiceStageDataList_ = other.spiceStageDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureSpiceStageDataListIsMutable();
                            this.spiceStageDataList_.addAll(other.spiceStageDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.spiceStageDataList_.isEmpty()) {
                    if (this.spiceStageDataListBuilder_.isEmpty()) {
                        this.spiceStageDataListBuilder_.dispose();
                        this.spiceStageDataListBuilder_ = null;
                        this.spiceStageDataList_ = other.spiceStageDataList_;
                        this.bitField0_ &= -2;
                        this.spiceStageDataListBuilder_ = SpiceInfo.alwaysUseFieldBuilders ? getSpiceStageDataListFieldBuilder() : null;
                    } else {
                        this.spiceStageDataListBuilder_.addAllMessages(other.spiceStageDataList_);
                    }
                }
                if (other.getUnk3300LAKPMMIPBMI() != 0) {
                    setUnk3300LAKPMMIPBMI(other.getUnk3300LAKPMMIPBMI());
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
                SpiceInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SpiceInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SpiceInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SpiceInfoOuterClass.SpiceInfoOrBuilder
            public int getUnk3300CIHIAJEGCBO() {
                return this.unk3300CIHIAJEGCBO_;
            }

            public Builder setUnk3300CIHIAJEGCBO(int value) {
                this.unk3300CIHIAJEGCBO_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300CIHIAJEGCBO() {
                this.unk3300CIHIAJEGCBO_ = 0;
                onChanged();
                return this;
            }

            private void ensureSpiceStageDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.spiceStageDataList_ = new ArrayList(this.spiceStageDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SpiceInfoOuterClass.SpiceInfoOrBuilder
            public List<SpiceStageDataOuterClass.SpiceStageData> getSpiceStageDataListList() {
                if (this.spiceStageDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.spiceStageDataList_);
                }
                return this.spiceStageDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SpiceInfoOuterClass.SpiceInfoOrBuilder
            public int getSpiceStageDataListCount() {
                if (this.spiceStageDataListBuilder_ == null) {
                    return this.spiceStageDataList_.size();
                }
                return this.spiceStageDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SpiceInfoOuterClass.SpiceInfoOrBuilder
            public SpiceStageDataOuterClass.SpiceStageData getSpiceStageDataList(int index) {
                if (this.spiceStageDataListBuilder_ == null) {
                    return this.spiceStageDataList_.get(index);
                }
                return this.spiceStageDataListBuilder_.getMessage(index);
            }

            public Builder setSpiceStageDataList(int index, SpiceStageDataOuterClass.SpiceStageData value) {
                if (this.spiceStageDataListBuilder_ != null) {
                    this.spiceStageDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSpiceStageDataListIsMutable();
                    this.spiceStageDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setSpiceStageDataList(int index, SpiceStageDataOuterClass.SpiceStageData.Builder builderForValue) {
                if (this.spiceStageDataListBuilder_ == null) {
                    ensureSpiceStageDataListIsMutable();
                    this.spiceStageDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.spiceStageDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addSpiceStageDataList(SpiceStageDataOuterClass.SpiceStageData value) {
                if (this.spiceStageDataListBuilder_ != null) {
                    this.spiceStageDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSpiceStageDataListIsMutable();
                    this.spiceStageDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addSpiceStageDataList(int index, SpiceStageDataOuterClass.SpiceStageData value) {
                if (this.spiceStageDataListBuilder_ != null) {
                    this.spiceStageDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSpiceStageDataListIsMutable();
                    this.spiceStageDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addSpiceStageDataList(SpiceStageDataOuterClass.SpiceStageData.Builder builderForValue) {
                if (this.spiceStageDataListBuilder_ == null) {
                    ensureSpiceStageDataListIsMutable();
                    this.spiceStageDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.spiceStageDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addSpiceStageDataList(int index, SpiceStageDataOuterClass.SpiceStageData.Builder builderForValue) {
                if (this.spiceStageDataListBuilder_ == null) {
                    ensureSpiceStageDataListIsMutable();
                    this.spiceStageDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.spiceStageDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllSpiceStageDataList(Iterable<? extends SpiceStageDataOuterClass.SpiceStageData> values) {
                if (this.spiceStageDataListBuilder_ == null) {
                    ensureSpiceStageDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.spiceStageDataList_);
                    onChanged();
                } else {
                    this.spiceStageDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearSpiceStageDataList() {
                if (this.spiceStageDataListBuilder_ == null) {
                    this.spiceStageDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.spiceStageDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeSpiceStageDataList(int index) {
                if (this.spiceStageDataListBuilder_ == null) {
                    ensureSpiceStageDataListIsMutable();
                    this.spiceStageDataList_.remove(index);
                    onChanged();
                } else {
                    this.spiceStageDataListBuilder_.remove(index);
                }
                return this;
            }

            public SpiceStageDataOuterClass.SpiceStageData.Builder getSpiceStageDataListBuilder(int index) {
                return getSpiceStageDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SpiceInfoOuterClass.SpiceInfoOrBuilder
            public SpiceStageDataOuterClass.SpiceStageDataOrBuilder getSpiceStageDataListOrBuilder(int index) {
                if (this.spiceStageDataListBuilder_ == null) {
                    return this.spiceStageDataList_.get(index);
                }
                return this.spiceStageDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SpiceInfoOuterClass.SpiceInfoOrBuilder
            public List<? extends SpiceStageDataOuterClass.SpiceStageDataOrBuilder> getSpiceStageDataListOrBuilderList() {
                if (this.spiceStageDataListBuilder_ != null) {
                    return this.spiceStageDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.spiceStageDataList_);
            }

            public SpiceStageDataOuterClass.SpiceStageData.Builder addSpiceStageDataListBuilder() {
                return getSpiceStageDataListFieldBuilder().addBuilder(SpiceStageDataOuterClass.SpiceStageData.getDefaultInstance());
            }

            public SpiceStageDataOuterClass.SpiceStageData.Builder addSpiceStageDataListBuilder(int index) {
                return getSpiceStageDataListFieldBuilder().addBuilder(index, SpiceStageDataOuterClass.SpiceStageData.getDefaultInstance());
            }

            public List<SpiceStageDataOuterClass.SpiceStageData.Builder> getSpiceStageDataListBuilderList() {
                return getSpiceStageDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<SpiceStageDataOuterClass.SpiceStageData, SpiceStageDataOuterClass.SpiceStageData.Builder, SpiceStageDataOuterClass.SpiceStageDataOrBuilder> getSpiceStageDataListFieldBuilder() {
                if (this.spiceStageDataListBuilder_ == null) {
                    this.spiceStageDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.spiceStageDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.spiceStageDataList_ = null;
                }
                return this.spiceStageDataListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SpiceInfoOuterClass.SpiceInfoOrBuilder
            public int getUnk3300LAKPMMIPBMI() {
                return this.unk3300LAKPMMIPBMI_;
            }

            public Builder setUnk3300LAKPMMIPBMI(int value) {
                this.unk3300LAKPMMIPBMI_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300LAKPMMIPBMI() {
                this.unk3300LAKPMMIPBMI_ = 0;
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

        public static SpiceInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SpiceInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SpiceInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SpiceInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SpiceStageDataOuterClass.getDescriptor();
    }
}
