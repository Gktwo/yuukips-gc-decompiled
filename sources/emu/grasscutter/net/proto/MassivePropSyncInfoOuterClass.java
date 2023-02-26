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
import emu.grasscutter.net.proto.MassivePropParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MassivePropSyncInfoOuterClass.class */
public final class MassivePropSyncInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019MassivePropSyncInfo.proto\u001a\u0016MassivePropParam.proto\"F\n\u0013MassivePropSyncInfo\u0012\n\n\u0002id\u0018\u0001 \u0001(\u0003\u0012#\n\bpropList\u0018\u0002 \u0003(\u000b2\u0011.MassivePropParamB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MassivePropParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MassivePropSyncInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MassivePropSyncInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MassivePropSyncInfo_descriptor, new String[]{"Id", "PropList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MassivePropSyncInfoOuterClass$MassivePropSyncInfoOrBuilder.class */
    public interface MassivePropSyncInfoOrBuilder extends MessageOrBuilder {
        long getId();

        List<MassivePropParamOuterClass.MassivePropParam> getPropListList();

        MassivePropParamOuterClass.MassivePropParam getPropList(int i);

        int getPropListCount();

        List<? extends MassivePropParamOuterClass.MassivePropParamOrBuilder> getPropListOrBuilderList();

        MassivePropParamOuterClass.MassivePropParamOrBuilder getPropListOrBuilder(int i);
    }

    private MassivePropSyncInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MassivePropSyncInfoOuterClass$MassivePropSyncInfo.class */
    public static final class MassivePropSyncInfo extends GeneratedMessageV3 implements MassivePropSyncInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ID_FIELD_NUMBER = 1;
        private long id_;
        public static final int PROPLIST_FIELD_NUMBER = 2;
        private List<MassivePropParamOuterClass.MassivePropParam> propList_;
        private byte memoizedIsInitialized;
        private static final MassivePropSyncInfo DEFAULT_INSTANCE = new MassivePropSyncInfo();
        private static final Parser<MassivePropSyncInfo> PARSER = new AbstractParser<MassivePropSyncInfo>() { // from class: emu.grasscutter.net.proto.MassivePropSyncInfoOuterClass.MassivePropSyncInfo.1
            @Override // com.google.protobuf.Parser
            public MassivePropSyncInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MassivePropSyncInfo(input, extensionRegistry);
            }
        };

        private MassivePropSyncInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MassivePropSyncInfo() {
            this.memoizedIsInitialized = -1;
            this.propList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MassivePropSyncInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MassivePropSyncInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.id_ = input.readInt64();
                                    break;
                                case 18:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.propList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.propList_.add((MassivePropParamOuterClass.MassivePropParam) input.readMessage(MassivePropParamOuterClass.MassivePropParam.parser(), extensionRegistry));
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.propList_ = Collections.unmodifiableList(this.propList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MassivePropSyncInfoOuterClass.internal_static_MassivePropSyncInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MassivePropSyncInfoOuterClass.internal_static_MassivePropSyncInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MassivePropSyncInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MassivePropSyncInfoOuterClass.MassivePropSyncInfoOrBuilder
        public long getId() {
            return this.id_;
        }

        @Override // emu.grasscutter.net.proto.MassivePropSyncInfoOuterClass.MassivePropSyncInfoOrBuilder
        public List<MassivePropParamOuterClass.MassivePropParam> getPropListList() {
            return this.propList_;
        }

        @Override // emu.grasscutter.net.proto.MassivePropSyncInfoOuterClass.MassivePropSyncInfoOrBuilder
        public List<? extends MassivePropParamOuterClass.MassivePropParamOrBuilder> getPropListOrBuilderList() {
            return this.propList_;
        }

        @Override // emu.grasscutter.net.proto.MassivePropSyncInfoOuterClass.MassivePropSyncInfoOrBuilder
        public int getPropListCount() {
            return this.propList_.size();
        }

        @Override // emu.grasscutter.net.proto.MassivePropSyncInfoOuterClass.MassivePropSyncInfoOrBuilder
        public MassivePropParamOuterClass.MassivePropParam getPropList(int index) {
            return this.propList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MassivePropSyncInfoOuterClass.MassivePropSyncInfoOrBuilder
        public MassivePropParamOuterClass.MassivePropParamOrBuilder getPropListOrBuilder(int index) {
            return this.propList_.get(index);
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
            if (this.id_ != 0) {
                output.writeInt64(1, this.id_);
            }
            for (int i = 0; i < this.propList_.size(); i++) {
                output.writeMessage(2, this.propList_.get(i));
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
            if (this.id_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt64Size(1, this.id_);
            }
            for (int i = 0; i < this.propList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.propList_.get(i));
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
            if (!(obj instanceof MassivePropSyncInfo)) {
                return equals(obj);
            }
            MassivePropSyncInfo other = (MassivePropSyncInfo) obj;
            return getId() == other.getId() && getPropListList().equals(other.getPropListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + Internal.hashLong(getId());
            if (getPropListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getPropListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MassivePropSyncInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MassivePropSyncInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MassivePropSyncInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MassivePropSyncInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MassivePropSyncInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MassivePropSyncInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MassivePropSyncInfo parseFrom(InputStream input) throws IOException {
            return (MassivePropSyncInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MassivePropSyncInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MassivePropSyncInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MassivePropSyncInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (MassivePropSyncInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MassivePropSyncInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MassivePropSyncInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MassivePropSyncInfo parseFrom(CodedInputStream input) throws IOException {
            return (MassivePropSyncInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MassivePropSyncInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MassivePropSyncInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MassivePropSyncInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MassivePropSyncInfoOuterClass$MassivePropSyncInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MassivePropSyncInfoOrBuilder {
            private int bitField0_;
            private long id_;
            private List<MassivePropParamOuterClass.MassivePropParam> propList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<MassivePropParamOuterClass.MassivePropParam, MassivePropParamOuterClass.MassivePropParam.Builder, MassivePropParamOuterClass.MassivePropParamOrBuilder> propListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MassivePropSyncInfoOuterClass.internal_static_MassivePropSyncInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MassivePropSyncInfoOuterClass.internal_static_MassivePropSyncInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MassivePropSyncInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MassivePropSyncInfo.alwaysUseFieldBuilders) {
                    getPropListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.id_ = 0;
                if (this.propListBuilder_ == null) {
                    this.propList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.propListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MassivePropSyncInfoOuterClass.internal_static_MassivePropSyncInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MassivePropSyncInfo getDefaultInstanceForType() {
                return MassivePropSyncInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MassivePropSyncInfo build() {
                MassivePropSyncInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MassivePropSyncInfo buildPartial() {
                MassivePropSyncInfo result = new MassivePropSyncInfo(this);
                int i = this.bitField0_;
                result.id_ = this.id_;
                if (this.propListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.propList_ = Collections.unmodifiableList(this.propList_);
                        this.bitField0_ &= -2;
                    }
                    result.propList_ = this.propList_;
                } else {
                    result.propList_ = this.propListBuilder_.build();
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
                if (other instanceof MassivePropSyncInfo) {
                    return mergeFrom((MassivePropSyncInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MassivePropSyncInfo other) {
                if (other == MassivePropSyncInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getId() != 0) {
                    setId(other.getId());
                }
                if (this.propListBuilder_ == null) {
                    if (!other.propList_.isEmpty()) {
                        if (this.propList_.isEmpty()) {
                            this.propList_ = other.propList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensurePropListIsMutable();
                            this.propList_.addAll(other.propList_);
                        }
                        onChanged();
                    }
                } else if (!other.propList_.isEmpty()) {
                    if (this.propListBuilder_.isEmpty()) {
                        this.propListBuilder_.dispose();
                        this.propListBuilder_ = null;
                        this.propList_ = other.propList_;
                        this.bitField0_ &= -2;
                        this.propListBuilder_ = MassivePropSyncInfo.alwaysUseFieldBuilders ? getPropListFieldBuilder() : null;
                    } else {
                        this.propListBuilder_.addAllMessages(other.propList_);
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
                MassivePropSyncInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = MassivePropSyncInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MassivePropSyncInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MassivePropSyncInfoOuterClass.MassivePropSyncInfoOrBuilder
            public long getId() {
                return this.id_;
            }

            public Builder setId(long value) {
                this.id_ = value;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = 0;
                onChanged();
                return this;
            }

            private void ensurePropListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.propList_ = new ArrayList(this.propList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.MassivePropSyncInfoOuterClass.MassivePropSyncInfoOrBuilder
            public List<MassivePropParamOuterClass.MassivePropParam> getPropListList() {
                if (this.propListBuilder_ == null) {
                    return Collections.unmodifiableList(this.propList_);
                }
                return this.propListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.MassivePropSyncInfoOuterClass.MassivePropSyncInfoOrBuilder
            public int getPropListCount() {
                if (this.propListBuilder_ == null) {
                    return this.propList_.size();
                }
                return this.propListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.MassivePropSyncInfoOuterClass.MassivePropSyncInfoOrBuilder
            public MassivePropParamOuterClass.MassivePropParam getPropList(int index) {
                if (this.propListBuilder_ == null) {
                    return this.propList_.get(index);
                }
                return this.propListBuilder_.getMessage(index);
            }

            public Builder setPropList(int index, MassivePropParamOuterClass.MassivePropParam value) {
                if (this.propListBuilder_ != null) {
                    this.propListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePropListIsMutable();
                    this.propList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setPropList(int index, MassivePropParamOuterClass.MassivePropParam.Builder builderForValue) {
                if (this.propListBuilder_ == null) {
                    ensurePropListIsMutable();
                    this.propList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.propListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addPropList(MassivePropParamOuterClass.MassivePropParam value) {
                if (this.propListBuilder_ != null) {
                    this.propListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePropListIsMutable();
                    this.propList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addPropList(int index, MassivePropParamOuterClass.MassivePropParam value) {
                if (this.propListBuilder_ != null) {
                    this.propListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePropListIsMutable();
                    this.propList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addPropList(MassivePropParamOuterClass.MassivePropParam.Builder builderForValue) {
                if (this.propListBuilder_ == null) {
                    ensurePropListIsMutable();
                    this.propList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.propListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addPropList(int index, MassivePropParamOuterClass.MassivePropParam.Builder builderForValue) {
                if (this.propListBuilder_ == null) {
                    ensurePropListIsMutable();
                    this.propList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.propListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllPropList(Iterable<? extends MassivePropParamOuterClass.MassivePropParam> values) {
                if (this.propListBuilder_ == null) {
                    ensurePropListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.propList_);
                    onChanged();
                } else {
                    this.propListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearPropList() {
                if (this.propListBuilder_ == null) {
                    this.propList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.propListBuilder_.clear();
                }
                return this;
            }

            public Builder removePropList(int index) {
                if (this.propListBuilder_ == null) {
                    ensurePropListIsMutable();
                    this.propList_.remove(index);
                    onChanged();
                } else {
                    this.propListBuilder_.remove(index);
                }
                return this;
            }

            public MassivePropParamOuterClass.MassivePropParam.Builder getPropListBuilder(int index) {
                return getPropListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MassivePropSyncInfoOuterClass.MassivePropSyncInfoOrBuilder
            public MassivePropParamOuterClass.MassivePropParamOrBuilder getPropListOrBuilder(int index) {
                if (this.propListBuilder_ == null) {
                    return this.propList_.get(index);
                }
                return this.propListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MassivePropSyncInfoOuterClass.MassivePropSyncInfoOrBuilder
            public List<? extends MassivePropParamOuterClass.MassivePropParamOrBuilder> getPropListOrBuilderList() {
                if (this.propListBuilder_ != null) {
                    return this.propListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.propList_);
            }

            public MassivePropParamOuterClass.MassivePropParam.Builder addPropListBuilder() {
                return getPropListFieldBuilder().addBuilder(MassivePropParamOuterClass.MassivePropParam.getDefaultInstance());
            }

            public MassivePropParamOuterClass.MassivePropParam.Builder addPropListBuilder(int index) {
                return getPropListFieldBuilder().addBuilder(index, MassivePropParamOuterClass.MassivePropParam.getDefaultInstance());
            }

            public List<MassivePropParamOuterClass.MassivePropParam.Builder> getPropListBuilderList() {
                return getPropListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<MassivePropParamOuterClass.MassivePropParam, MassivePropParamOuterClass.MassivePropParam.Builder, MassivePropParamOuterClass.MassivePropParamOrBuilder> getPropListFieldBuilder() {
                if (this.propListBuilder_ == null) {
                    this.propListBuilder_ = new RepeatedFieldBuilderV3<>(this.propList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.propList_ = null;
                }
                return this.propListBuilder_;
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

        public static MassivePropSyncInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MassivePropSyncInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MassivePropSyncInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MassivePropSyncInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MassivePropParamOuterClass.getDescriptor();
    }
}
