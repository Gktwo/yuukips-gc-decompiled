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
import emu.grasscutter.net.proto.AvatarSatiationDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSatiationDataNotifyOuterClass.class */
public final class AvatarSatiationDataNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fAvatarSatiationDataNotify.proto\u001a\u0019AvatarSatiationData.proto\"L\n\u0019AvatarSatiationDataNotify\u0012/\n\u0011satiationDataList\u0018\t \u0003(\u000b2\u0014.AvatarSatiationDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AvatarSatiationDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AvatarSatiationDataNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarSatiationDataNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarSatiationDataNotify_descriptor, new String[]{"SatiationDataList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSatiationDataNotifyOuterClass$AvatarSatiationDataNotifyOrBuilder.class */
    public interface AvatarSatiationDataNotifyOrBuilder extends MessageOrBuilder {
        List<AvatarSatiationDataOuterClass.AvatarSatiationData> getSatiationDataListList();

        AvatarSatiationDataOuterClass.AvatarSatiationData getSatiationDataList(int i);

        int getSatiationDataListCount();

        List<? extends AvatarSatiationDataOuterClass.AvatarSatiationDataOrBuilder> getSatiationDataListOrBuilderList();

        AvatarSatiationDataOuterClass.AvatarSatiationDataOrBuilder getSatiationDataListOrBuilder(int i);
    }

    private AvatarSatiationDataNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSatiationDataNotifyOuterClass$AvatarSatiationDataNotify.class */
    public static final class AvatarSatiationDataNotify extends GeneratedMessageV3 implements AvatarSatiationDataNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SATIATIONDATALIST_FIELD_NUMBER = 9;
        private List<AvatarSatiationDataOuterClass.AvatarSatiationData> satiationDataList_;
        private byte memoizedIsInitialized;
        private static final AvatarSatiationDataNotify DEFAULT_INSTANCE = new AvatarSatiationDataNotify();
        private static final Parser<AvatarSatiationDataNotify> PARSER = new AbstractParser<AvatarSatiationDataNotify>() { // from class: emu.grasscutter.net.proto.AvatarSatiationDataNotifyOuterClass.AvatarSatiationDataNotify.1
            @Override // com.google.protobuf.Parser
            public AvatarSatiationDataNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarSatiationDataNotify(input, extensionRegistry);
            }
        };

        private AvatarSatiationDataNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarSatiationDataNotify() {
            this.memoizedIsInitialized = -1;
            this.satiationDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarSatiationDataNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarSatiationDataNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 74:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.satiationDataList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.satiationDataList_.add((AvatarSatiationDataOuterClass.AvatarSatiationData) input.readMessage(AvatarSatiationDataOuterClass.AvatarSatiationData.parser(), extensionRegistry));
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
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.satiationDataList_ = Collections.unmodifiableList(this.satiationDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvatarSatiationDataNotifyOuterClass.internal_static_AvatarSatiationDataNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarSatiationDataNotifyOuterClass.internal_static_AvatarSatiationDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarSatiationDataNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarSatiationDataNotifyOuterClass.AvatarSatiationDataNotifyOrBuilder
        public List<AvatarSatiationDataOuterClass.AvatarSatiationData> getSatiationDataListList() {
            return this.satiationDataList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSatiationDataNotifyOuterClass.AvatarSatiationDataNotifyOrBuilder
        public List<? extends AvatarSatiationDataOuterClass.AvatarSatiationDataOrBuilder> getSatiationDataListOrBuilderList() {
            return this.satiationDataList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSatiationDataNotifyOuterClass.AvatarSatiationDataNotifyOrBuilder
        public int getSatiationDataListCount() {
            return this.satiationDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarSatiationDataNotifyOuterClass.AvatarSatiationDataNotifyOrBuilder
        public AvatarSatiationDataOuterClass.AvatarSatiationData getSatiationDataList(int index) {
            return this.satiationDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarSatiationDataNotifyOuterClass.AvatarSatiationDataNotifyOrBuilder
        public AvatarSatiationDataOuterClass.AvatarSatiationDataOrBuilder getSatiationDataListOrBuilder(int index) {
            return this.satiationDataList_.get(index);
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
            for (int i = 0; i < this.satiationDataList_.size(); i++) {
                output.writeMessage(9, this.satiationDataList_.get(i));
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
            for (int i = 0; i < this.satiationDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(9, this.satiationDataList_.get(i));
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
            if (!(obj instanceof AvatarSatiationDataNotify)) {
                return equals(obj);
            }
            AvatarSatiationDataNotify other = (AvatarSatiationDataNotify) obj;
            return getSatiationDataListList().equals(other.getSatiationDataListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getSatiationDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getSatiationDataListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AvatarSatiationDataNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarSatiationDataNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarSatiationDataNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarSatiationDataNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarSatiationDataNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarSatiationDataNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarSatiationDataNotify parseFrom(InputStream input) throws IOException {
            return (AvatarSatiationDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarSatiationDataNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarSatiationDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarSatiationDataNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarSatiationDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarSatiationDataNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarSatiationDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarSatiationDataNotify parseFrom(CodedInputStream input) throws IOException {
            return (AvatarSatiationDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarSatiationDataNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarSatiationDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarSatiationDataNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSatiationDataNotifyOuterClass$AvatarSatiationDataNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarSatiationDataNotifyOrBuilder {
            private int bitField0_;
            private List<AvatarSatiationDataOuterClass.AvatarSatiationData> satiationDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<AvatarSatiationDataOuterClass.AvatarSatiationData, AvatarSatiationDataOuterClass.AvatarSatiationData.Builder, AvatarSatiationDataOuterClass.AvatarSatiationDataOrBuilder> satiationDataListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarSatiationDataNotifyOuterClass.internal_static_AvatarSatiationDataNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarSatiationDataNotifyOuterClass.internal_static_AvatarSatiationDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarSatiationDataNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarSatiationDataNotify.alwaysUseFieldBuilders) {
                    getSatiationDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.satiationDataListBuilder_ == null) {
                    this.satiationDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.satiationDataListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarSatiationDataNotifyOuterClass.internal_static_AvatarSatiationDataNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarSatiationDataNotify getDefaultInstanceForType() {
                return AvatarSatiationDataNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarSatiationDataNotify build() {
                AvatarSatiationDataNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarSatiationDataNotify buildPartial() {
                AvatarSatiationDataNotify result = new AvatarSatiationDataNotify(this);
                int i = this.bitField0_;
                if (this.satiationDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.satiationDataList_ = Collections.unmodifiableList(this.satiationDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.satiationDataList_ = this.satiationDataList_;
                } else {
                    result.satiationDataList_ = this.satiationDataListBuilder_.build();
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
                if (other instanceof AvatarSatiationDataNotify) {
                    return mergeFrom((AvatarSatiationDataNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarSatiationDataNotify other) {
                if (other == AvatarSatiationDataNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.satiationDataListBuilder_ == null) {
                    if (!other.satiationDataList_.isEmpty()) {
                        if (this.satiationDataList_.isEmpty()) {
                            this.satiationDataList_ = other.satiationDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureSatiationDataListIsMutable();
                            this.satiationDataList_.addAll(other.satiationDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.satiationDataList_.isEmpty()) {
                    if (this.satiationDataListBuilder_.isEmpty()) {
                        this.satiationDataListBuilder_.dispose();
                        this.satiationDataListBuilder_ = null;
                        this.satiationDataList_ = other.satiationDataList_;
                        this.bitField0_ &= -2;
                        this.satiationDataListBuilder_ = AvatarSatiationDataNotify.alwaysUseFieldBuilders ? getSatiationDataListFieldBuilder() : null;
                    } else {
                        this.satiationDataListBuilder_.addAllMessages(other.satiationDataList_);
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
                AvatarSatiationDataNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarSatiationDataNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarSatiationDataNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureSatiationDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.satiationDataList_ = new ArrayList(this.satiationDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarSatiationDataNotifyOuterClass.AvatarSatiationDataNotifyOrBuilder
            public List<AvatarSatiationDataOuterClass.AvatarSatiationData> getSatiationDataListList() {
                if (this.satiationDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.satiationDataList_);
                }
                return this.satiationDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AvatarSatiationDataNotifyOuterClass.AvatarSatiationDataNotifyOrBuilder
            public int getSatiationDataListCount() {
                if (this.satiationDataListBuilder_ == null) {
                    return this.satiationDataList_.size();
                }
                return this.satiationDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AvatarSatiationDataNotifyOuterClass.AvatarSatiationDataNotifyOrBuilder
            public AvatarSatiationDataOuterClass.AvatarSatiationData getSatiationDataList(int index) {
                if (this.satiationDataListBuilder_ == null) {
                    return this.satiationDataList_.get(index);
                }
                return this.satiationDataListBuilder_.getMessage(index);
            }

            public Builder setSatiationDataList(int index, AvatarSatiationDataOuterClass.AvatarSatiationData value) {
                if (this.satiationDataListBuilder_ != null) {
                    this.satiationDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSatiationDataListIsMutable();
                    this.satiationDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setSatiationDataList(int index, AvatarSatiationDataOuterClass.AvatarSatiationData.Builder builderForValue) {
                if (this.satiationDataListBuilder_ == null) {
                    ensureSatiationDataListIsMutable();
                    this.satiationDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.satiationDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addSatiationDataList(AvatarSatiationDataOuterClass.AvatarSatiationData value) {
                if (this.satiationDataListBuilder_ != null) {
                    this.satiationDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSatiationDataListIsMutable();
                    this.satiationDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addSatiationDataList(int index, AvatarSatiationDataOuterClass.AvatarSatiationData value) {
                if (this.satiationDataListBuilder_ != null) {
                    this.satiationDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSatiationDataListIsMutable();
                    this.satiationDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addSatiationDataList(AvatarSatiationDataOuterClass.AvatarSatiationData.Builder builderForValue) {
                if (this.satiationDataListBuilder_ == null) {
                    ensureSatiationDataListIsMutable();
                    this.satiationDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.satiationDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addSatiationDataList(int index, AvatarSatiationDataOuterClass.AvatarSatiationData.Builder builderForValue) {
                if (this.satiationDataListBuilder_ == null) {
                    ensureSatiationDataListIsMutable();
                    this.satiationDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.satiationDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllSatiationDataList(Iterable<? extends AvatarSatiationDataOuterClass.AvatarSatiationData> values) {
                if (this.satiationDataListBuilder_ == null) {
                    ensureSatiationDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.satiationDataList_);
                    onChanged();
                } else {
                    this.satiationDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearSatiationDataList() {
                if (this.satiationDataListBuilder_ == null) {
                    this.satiationDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.satiationDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeSatiationDataList(int index) {
                if (this.satiationDataListBuilder_ == null) {
                    ensureSatiationDataListIsMutable();
                    this.satiationDataList_.remove(index);
                    onChanged();
                } else {
                    this.satiationDataListBuilder_.remove(index);
                }
                return this;
            }

            public AvatarSatiationDataOuterClass.AvatarSatiationData.Builder getSatiationDataListBuilder(int index) {
                return getSatiationDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AvatarSatiationDataNotifyOuterClass.AvatarSatiationDataNotifyOrBuilder
            public AvatarSatiationDataOuterClass.AvatarSatiationDataOrBuilder getSatiationDataListOrBuilder(int index) {
                if (this.satiationDataListBuilder_ == null) {
                    return this.satiationDataList_.get(index);
                }
                return this.satiationDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AvatarSatiationDataNotifyOuterClass.AvatarSatiationDataNotifyOrBuilder
            public List<? extends AvatarSatiationDataOuterClass.AvatarSatiationDataOrBuilder> getSatiationDataListOrBuilderList() {
                if (this.satiationDataListBuilder_ != null) {
                    return this.satiationDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.satiationDataList_);
            }

            public AvatarSatiationDataOuterClass.AvatarSatiationData.Builder addSatiationDataListBuilder() {
                return getSatiationDataListFieldBuilder().addBuilder(AvatarSatiationDataOuterClass.AvatarSatiationData.getDefaultInstance());
            }

            public AvatarSatiationDataOuterClass.AvatarSatiationData.Builder addSatiationDataListBuilder(int index) {
                return getSatiationDataListFieldBuilder().addBuilder(index, AvatarSatiationDataOuterClass.AvatarSatiationData.getDefaultInstance());
            }

            public List<AvatarSatiationDataOuterClass.AvatarSatiationData.Builder> getSatiationDataListBuilderList() {
                return getSatiationDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AvatarSatiationDataOuterClass.AvatarSatiationData, AvatarSatiationDataOuterClass.AvatarSatiationData.Builder, AvatarSatiationDataOuterClass.AvatarSatiationDataOrBuilder> getSatiationDataListFieldBuilder() {
                if (this.satiationDataListBuilder_ == null) {
                    this.satiationDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.satiationDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.satiationDataList_ = null;
                }
                return this.satiationDataListBuilder_;
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

        public static AvatarSatiationDataNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarSatiationDataNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarSatiationDataNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarSatiationDataNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AvatarSatiationDataOuterClass.getDescriptor();
    }
}
