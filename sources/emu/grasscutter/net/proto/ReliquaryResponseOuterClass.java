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
import emu.grasscutter.net.proto.Unk2700GBBDJMDIDEI;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryResponseOuterClass.class */
public final class ReliquaryResponseOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017ReliquaryResponse.proto\u001a\u0019Unk2700_GBBDJMDIDEI.proto\"Z\n\u0011ReliquaryResponse\u00121\n\u0013Unk2700_DMDHDIHGPFA\u0018\b \u0003(\u000b2\u0014.Unk2700_GBBDJMDIDEI\u0012\u0012\n\nequip_type\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{Unk2700GBBDJMDIDEI.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ReliquaryResponse_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ReliquaryResponse_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ReliquaryResponse_descriptor, new String[]{"Unk2700DMDHDIHGPFA", "EquipType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryResponseOuterClass$ReliquaryResponseOrBuilder.class */
    public interface ReliquaryResponseOrBuilder extends MessageOrBuilder {
        List<Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI> getUnk2700DMDHDIHGPFAList();

        Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI getUnk2700DMDHDIHGPFA(int i);

        int getUnk2700DMDHDIHGPFACount();

        List<? extends Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEIOrBuilder> getUnk2700DMDHDIHGPFAOrBuilderList();

        Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEIOrBuilder getUnk2700DMDHDIHGPFAOrBuilder(int i);

        int getEquipType();
    }

    private ReliquaryResponseOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryResponseOuterClass$ReliquaryResponse.class */
    public static final class ReliquaryResponse extends GeneratedMessageV3 implements ReliquaryResponseOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK2700_DMDHDIHGPFA_FIELD_NUMBER = 8;
        private List<Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI> unk2700DMDHDIHGPFA_;
        public static final int EQUIP_TYPE_FIELD_NUMBER = 3;
        private int equipType_;
        private byte memoizedIsInitialized;
        private static final ReliquaryResponse DEFAULT_INSTANCE = new ReliquaryResponse();
        private static final Parser<ReliquaryResponse> PARSER = new AbstractParser<ReliquaryResponse>() { // from class: emu.grasscutter.net.proto.ReliquaryResponseOuterClass.ReliquaryResponse.1
            @Override // com.google.protobuf.Parser
            public ReliquaryResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ReliquaryResponse(input, extensionRegistry);
            }
        };

        private ReliquaryResponse(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ReliquaryResponse() {
            this.memoizedIsInitialized = -1;
            this.unk2700DMDHDIHGPFA_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ReliquaryResponse();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ReliquaryResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 24:
                                    this.equipType_ = input.readUInt32();
                                    break;
                                case 66:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.unk2700DMDHDIHGPFA_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.unk2700DMDHDIHGPFA_.add((Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI) input.readMessage(Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI.parser(), extensionRegistry));
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
                    this.unk2700DMDHDIHGPFA_ = Collections.unmodifiableList(this.unk2700DMDHDIHGPFA_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ReliquaryResponseOuterClass.internal_static_ReliquaryResponse_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ReliquaryResponseOuterClass.internal_static_ReliquaryResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ReliquaryResponse.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ReliquaryResponseOuterClass.ReliquaryResponseOrBuilder
        public List<Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI> getUnk2700DMDHDIHGPFAList() {
            return this.unk2700DMDHDIHGPFA_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryResponseOuterClass.ReliquaryResponseOrBuilder
        public List<? extends Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEIOrBuilder> getUnk2700DMDHDIHGPFAOrBuilderList() {
            return this.unk2700DMDHDIHGPFA_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryResponseOuterClass.ReliquaryResponseOrBuilder
        public int getUnk2700DMDHDIHGPFACount() {
            return this.unk2700DMDHDIHGPFA_.size();
        }

        @Override // emu.grasscutter.net.proto.ReliquaryResponseOuterClass.ReliquaryResponseOrBuilder
        public Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI getUnk2700DMDHDIHGPFA(int index) {
            return this.unk2700DMDHDIHGPFA_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ReliquaryResponseOuterClass.ReliquaryResponseOrBuilder
        public Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEIOrBuilder getUnk2700DMDHDIHGPFAOrBuilder(int index) {
            return this.unk2700DMDHDIHGPFA_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ReliquaryResponseOuterClass.ReliquaryResponseOrBuilder
        public int getEquipType() {
            return this.equipType_;
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
            if (this.equipType_ != 0) {
                output.writeUInt32(3, this.equipType_);
            }
            for (int i = 0; i < this.unk2700DMDHDIHGPFA_.size(); i++) {
                output.writeMessage(8, this.unk2700DMDHDIHGPFA_.get(i));
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
            if (this.equipType_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.equipType_);
            }
            for (int i = 0; i < this.unk2700DMDHDIHGPFA_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(8, this.unk2700DMDHDIHGPFA_.get(i));
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
            if (!(obj instanceof ReliquaryResponse)) {
                return equals(obj);
            }
            ReliquaryResponse other = (ReliquaryResponse) obj;
            return getUnk2700DMDHDIHGPFAList().equals(other.getUnk2700DMDHDIHGPFAList()) && getEquipType() == other.getEquipType() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getUnk2700DMDHDIHGPFACount() > 0) {
                hash = (53 * ((37 * hash) + 8)) + getUnk2700DMDHDIHGPFAList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 3)) + getEquipType())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ReliquaryResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ReliquaryResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReliquaryResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ReliquaryResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReliquaryResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ReliquaryResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReliquaryResponse parseFrom(InputStream input) throws IOException {
            return (ReliquaryResponse) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ReliquaryResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReliquaryResponse) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ReliquaryResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (ReliquaryResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ReliquaryResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReliquaryResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ReliquaryResponse parseFrom(CodedInputStream input) throws IOException {
            return (ReliquaryResponse) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ReliquaryResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReliquaryResponse) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ReliquaryResponse prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryResponseOuterClass$ReliquaryResponse$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ReliquaryResponseOrBuilder {
            private int bitField0_;
            private List<Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI> unk2700DMDHDIHGPFA_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI, Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI.Builder, Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEIOrBuilder> unk2700DMDHDIHGPFABuilder_;
            private int equipType_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ReliquaryResponseOuterClass.internal_static_ReliquaryResponse_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ReliquaryResponseOuterClass.internal_static_ReliquaryResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ReliquaryResponse.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ReliquaryResponse.alwaysUseFieldBuilders) {
                    getUnk2700DMDHDIHGPFAFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.unk2700DMDHDIHGPFABuilder_ == null) {
                    this.unk2700DMDHDIHGPFA_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.unk2700DMDHDIHGPFABuilder_.clear();
                }
                this.equipType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ReliquaryResponseOuterClass.internal_static_ReliquaryResponse_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ReliquaryResponse getDefaultInstanceForType() {
                return ReliquaryResponse.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ReliquaryResponse build() {
                ReliquaryResponse result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ReliquaryResponse buildPartial() {
                ReliquaryResponse result = new ReliquaryResponse(this);
                int i = this.bitField0_;
                if (this.unk2700DMDHDIHGPFABuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.unk2700DMDHDIHGPFA_ = Collections.unmodifiableList(this.unk2700DMDHDIHGPFA_);
                        this.bitField0_ &= -2;
                    }
                    result.unk2700DMDHDIHGPFA_ = this.unk2700DMDHDIHGPFA_;
                } else {
                    result.unk2700DMDHDIHGPFA_ = this.unk2700DMDHDIHGPFABuilder_.build();
                }
                result.equipType_ = this.equipType_;
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
                if (other instanceof ReliquaryResponse) {
                    return mergeFrom((ReliquaryResponse) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ReliquaryResponse other) {
                if (other == ReliquaryResponse.getDefaultInstance()) {
                    return this;
                }
                if (this.unk2700DMDHDIHGPFABuilder_ == null) {
                    if (!other.unk2700DMDHDIHGPFA_.isEmpty()) {
                        if (this.unk2700DMDHDIHGPFA_.isEmpty()) {
                            this.unk2700DMDHDIHGPFA_ = other.unk2700DMDHDIHGPFA_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureUnk2700DMDHDIHGPFAIsMutable();
                            this.unk2700DMDHDIHGPFA_.addAll(other.unk2700DMDHDIHGPFA_);
                        }
                        onChanged();
                    }
                } else if (!other.unk2700DMDHDIHGPFA_.isEmpty()) {
                    if (this.unk2700DMDHDIHGPFABuilder_.isEmpty()) {
                        this.unk2700DMDHDIHGPFABuilder_.dispose();
                        this.unk2700DMDHDIHGPFABuilder_ = null;
                        this.unk2700DMDHDIHGPFA_ = other.unk2700DMDHDIHGPFA_;
                        this.bitField0_ &= -2;
                        this.unk2700DMDHDIHGPFABuilder_ = ReliquaryResponse.alwaysUseFieldBuilders ? getUnk2700DMDHDIHGPFAFieldBuilder() : null;
                    } else {
                        this.unk2700DMDHDIHGPFABuilder_.addAllMessages(other.unk2700DMDHDIHGPFA_);
                    }
                }
                if (other.getEquipType() != 0) {
                    setEquipType(other.getEquipType());
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
                ReliquaryResponse parsedMessage = null;
                try {
                    try {
                        parsedMessage = ReliquaryResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ReliquaryResponse) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureUnk2700DMDHDIHGPFAIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unk2700DMDHDIHGPFA_ = new ArrayList(this.unk2700DMDHDIHGPFA_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ReliquaryResponseOuterClass.ReliquaryResponseOrBuilder
            public List<Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI> getUnk2700DMDHDIHGPFAList() {
                if (this.unk2700DMDHDIHGPFABuilder_ == null) {
                    return Collections.unmodifiableList(this.unk2700DMDHDIHGPFA_);
                }
                return this.unk2700DMDHDIHGPFABuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ReliquaryResponseOuterClass.ReliquaryResponseOrBuilder
            public int getUnk2700DMDHDIHGPFACount() {
                if (this.unk2700DMDHDIHGPFABuilder_ == null) {
                    return this.unk2700DMDHDIHGPFA_.size();
                }
                return this.unk2700DMDHDIHGPFABuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ReliquaryResponseOuterClass.ReliquaryResponseOrBuilder
            public Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI getUnk2700DMDHDIHGPFA(int index) {
                if (this.unk2700DMDHDIHGPFABuilder_ == null) {
                    return this.unk2700DMDHDIHGPFA_.get(index);
                }
                return this.unk2700DMDHDIHGPFABuilder_.getMessage(index);
            }

            public Builder setUnk2700DMDHDIHGPFA(int index, Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI value) {
                if (this.unk2700DMDHDIHGPFABuilder_ != null) {
                    this.unk2700DMDHDIHGPFABuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnk2700DMDHDIHGPFAIsMutable();
                    this.unk2700DMDHDIHGPFA_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setUnk2700DMDHDIHGPFA(int index, Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI.Builder builderForValue) {
                if (this.unk2700DMDHDIHGPFABuilder_ == null) {
                    ensureUnk2700DMDHDIHGPFAIsMutable();
                    this.unk2700DMDHDIHGPFA_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.unk2700DMDHDIHGPFABuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUnk2700DMDHDIHGPFA(Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI value) {
                if (this.unk2700DMDHDIHGPFABuilder_ != null) {
                    this.unk2700DMDHDIHGPFABuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnk2700DMDHDIHGPFAIsMutable();
                    this.unk2700DMDHDIHGPFA_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addUnk2700DMDHDIHGPFA(int index, Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI value) {
                if (this.unk2700DMDHDIHGPFABuilder_ != null) {
                    this.unk2700DMDHDIHGPFABuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnk2700DMDHDIHGPFAIsMutable();
                    this.unk2700DMDHDIHGPFA_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addUnk2700DMDHDIHGPFA(Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI.Builder builderForValue) {
                if (this.unk2700DMDHDIHGPFABuilder_ == null) {
                    ensureUnk2700DMDHDIHGPFAIsMutable();
                    this.unk2700DMDHDIHGPFA_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.unk2700DMDHDIHGPFABuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUnk2700DMDHDIHGPFA(int index, Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI.Builder builderForValue) {
                if (this.unk2700DMDHDIHGPFABuilder_ == null) {
                    ensureUnk2700DMDHDIHGPFAIsMutable();
                    this.unk2700DMDHDIHGPFA_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.unk2700DMDHDIHGPFABuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUnk2700DMDHDIHGPFA(Iterable<? extends Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI> values) {
                if (this.unk2700DMDHDIHGPFABuilder_ == null) {
                    ensureUnk2700DMDHDIHGPFAIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk2700DMDHDIHGPFA_);
                    onChanged();
                } else {
                    this.unk2700DMDHDIHGPFABuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUnk2700DMDHDIHGPFA() {
                if (this.unk2700DMDHDIHGPFABuilder_ == null) {
                    this.unk2700DMDHDIHGPFA_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.unk2700DMDHDIHGPFABuilder_.clear();
                }
                return this;
            }

            public Builder removeUnk2700DMDHDIHGPFA(int index) {
                if (this.unk2700DMDHDIHGPFABuilder_ == null) {
                    ensureUnk2700DMDHDIHGPFAIsMutable();
                    this.unk2700DMDHDIHGPFA_.remove(index);
                    onChanged();
                } else {
                    this.unk2700DMDHDIHGPFABuilder_.remove(index);
                }
                return this;
            }

            public Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI.Builder getUnk2700DMDHDIHGPFABuilder(int index) {
                return getUnk2700DMDHDIHGPFAFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ReliquaryResponseOuterClass.ReliquaryResponseOrBuilder
            public Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEIOrBuilder getUnk2700DMDHDIHGPFAOrBuilder(int index) {
                if (this.unk2700DMDHDIHGPFABuilder_ == null) {
                    return this.unk2700DMDHDIHGPFA_.get(index);
                }
                return this.unk2700DMDHDIHGPFABuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ReliquaryResponseOuterClass.ReliquaryResponseOrBuilder
            public List<? extends Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEIOrBuilder> getUnk2700DMDHDIHGPFAOrBuilderList() {
                if (this.unk2700DMDHDIHGPFABuilder_ != null) {
                    return this.unk2700DMDHDIHGPFABuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.unk2700DMDHDIHGPFA_);
            }

            public Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI.Builder addUnk2700DMDHDIHGPFABuilder() {
                return getUnk2700DMDHDIHGPFAFieldBuilder().addBuilder(Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI.getDefaultInstance());
            }

            public Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI.Builder addUnk2700DMDHDIHGPFABuilder(int index) {
                return getUnk2700DMDHDIHGPFAFieldBuilder().addBuilder(index, Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI.getDefaultInstance());
            }

            public List<Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI.Builder> getUnk2700DMDHDIHGPFABuilderList() {
                return getUnk2700DMDHDIHGPFAFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI, Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI.Builder, Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEIOrBuilder> getUnk2700DMDHDIHGPFAFieldBuilder() {
                if (this.unk2700DMDHDIHGPFABuilder_ == null) {
                    this.unk2700DMDHDIHGPFABuilder_ = new RepeatedFieldBuilderV3<>(this.unk2700DMDHDIHGPFA_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.unk2700DMDHDIHGPFA_ = null;
                }
                return this.unk2700DMDHDIHGPFABuilder_;
            }

            @Override // emu.grasscutter.net.proto.ReliquaryResponseOuterClass.ReliquaryResponseOrBuilder
            public int getEquipType() {
                return this.equipType_;
            }

            public Builder setEquipType(int value) {
                this.equipType_ = value;
                onChanged();
                return this;
            }

            public Builder clearEquipType() {
                this.equipType_ = 0;
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

        public static ReliquaryResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReliquaryResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ReliquaryResponse> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ReliquaryResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Unk2700GBBDJMDIDEI.getDescriptor();
    }
}
