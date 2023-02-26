package emu.grasscutter.net.proto;

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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TriggerCreateGadgetToEquipPartNotifyOuterClass.class */
public final class TriggerCreateGadgetToEquipPartNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n*TriggerCreateGadgetToEquipPartNotify.proto\"u\n$TriggerCreateGadgetToEquipPartNotify\u0012\u0010\n\bentityId\u0018\u0003 \u0001(\r\u0012\u0010\n\bgadgetId\u0018\u0005 \u0001(\r\u0012\u0016\n\u000egadgetEntityId\u0018\u0004 \u0001(\r\u0012\u0011\n\tequipPart\u0018\u0007 \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TriggerCreateGadgetToEquipPartNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_TriggerCreateGadgetToEquipPartNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f868xffc3fdac = new GeneratedMessageV3.FieldAccessorTable(internal_static_TriggerCreateGadgetToEquipPartNotify_descriptor, new String[]{"EntityId", "GadgetId", "GadgetEntityId", "EquipPart"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TriggerCreateGadgetToEquipPartNotifyOuterClass$TriggerCreateGadgetToEquipPartNotifyOrBuilder.class */
    public interface TriggerCreateGadgetToEquipPartNotifyOrBuilder extends MessageOrBuilder {
        int getEntityId();

        int getGadgetId();

        int getGadgetEntityId();

        String getEquipPart();

        ByteString getEquipPartBytes();
    }

    private TriggerCreateGadgetToEquipPartNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TriggerCreateGadgetToEquipPartNotifyOuterClass$TriggerCreateGadgetToEquipPartNotify.class */
    public static final class TriggerCreateGadgetToEquipPartNotify extends GeneratedMessageV3 implements TriggerCreateGadgetToEquipPartNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTITYID_FIELD_NUMBER = 3;
        private int entityId_;
        public static final int GADGETID_FIELD_NUMBER = 5;
        private int gadgetId_;
        public static final int GADGETENTITYID_FIELD_NUMBER = 4;
        private int gadgetEntityId_;
        public static final int EQUIPPART_FIELD_NUMBER = 7;
        private volatile Object equipPart_;
        private byte memoizedIsInitialized;
        private static final TriggerCreateGadgetToEquipPartNotify DEFAULT_INSTANCE = new TriggerCreateGadgetToEquipPartNotify();
        private static final Parser<TriggerCreateGadgetToEquipPartNotify> PARSER = new AbstractParser<TriggerCreateGadgetToEquipPartNotify>() { // from class: emu.grasscutter.net.proto.TriggerCreateGadgetToEquipPartNotifyOuterClass.TriggerCreateGadgetToEquipPartNotify.1
            @Override // com.google.protobuf.Parser
            public TriggerCreateGadgetToEquipPartNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TriggerCreateGadgetToEquipPartNotify(input, extensionRegistry);
            }
        };

        private TriggerCreateGadgetToEquipPartNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TriggerCreateGadgetToEquipPartNotify() {
            this.memoizedIsInitialized = -1;
            this.equipPart_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TriggerCreateGadgetToEquipPartNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TriggerCreateGadgetToEquipPartNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
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
                                this.entityId_ = input.readUInt32();
                                break;
                            case 32:
                                this.gadgetEntityId_ = input.readUInt32();
                                break;
                            case 40:
                                this.gadgetId_ = input.readUInt32();
                                break;
                            case 58:
                                this.equipPart_ = input.readStringRequireUtf8();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TriggerCreateGadgetToEquipPartNotifyOuterClass.internal_static_TriggerCreateGadgetToEquipPartNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TriggerCreateGadgetToEquipPartNotifyOuterClass.f868xffc3fdac.ensureFieldAccessorsInitialized(TriggerCreateGadgetToEquipPartNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TriggerCreateGadgetToEquipPartNotifyOuterClass.TriggerCreateGadgetToEquipPartNotifyOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.TriggerCreateGadgetToEquipPartNotifyOuterClass.TriggerCreateGadgetToEquipPartNotifyOrBuilder
        public int getGadgetId() {
            return this.gadgetId_;
        }

        @Override // emu.grasscutter.net.proto.TriggerCreateGadgetToEquipPartNotifyOuterClass.TriggerCreateGadgetToEquipPartNotifyOrBuilder
        public int getGadgetEntityId() {
            return this.gadgetEntityId_;
        }

        @Override // emu.grasscutter.net.proto.TriggerCreateGadgetToEquipPartNotifyOuterClass.TriggerCreateGadgetToEquipPartNotifyOrBuilder
        public String getEquipPart() {
            Object ref = this.equipPart_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.equipPart_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.TriggerCreateGadgetToEquipPartNotifyOuterClass.TriggerCreateGadgetToEquipPartNotifyOrBuilder
        public ByteString getEquipPartBytes() {
            Object ref = this.equipPart_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.equipPart_ = b;
            return b;
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
            if (this.entityId_ != 0) {
                output.writeUInt32(3, this.entityId_);
            }
            if (this.gadgetEntityId_ != 0) {
                output.writeUInt32(4, this.gadgetEntityId_);
            }
            if (this.gadgetId_ != 0) {
                output.writeUInt32(5, this.gadgetId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.equipPart_)) {
                GeneratedMessageV3.writeString(output, 7, this.equipPart_);
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
            if (this.entityId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.entityId_);
            }
            if (this.gadgetEntityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.gadgetEntityId_);
            }
            if (this.gadgetId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.gadgetId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.equipPart_)) {
                size2 += GeneratedMessageV3.computeStringSize(7, this.equipPart_);
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
            if (!(obj instanceof TriggerCreateGadgetToEquipPartNotify)) {
                return equals(obj);
            }
            TriggerCreateGadgetToEquipPartNotify other = (TriggerCreateGadgetToEquipPartNotify) obj;
            return getEntityId() == other.getEntityId() && getGadgetId() == other.getGadgetId() && getGadgetEntityId() == other.getGadgetEntityId() && getEquipPart().equals(other.getEquipPart()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getEntityId())) + 5)) + getGadgetId())) + 4)) + getGadgetEntityId())) + 7)) + getEquipPart().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static TriggerCreateGadgetToEquipPartNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TriggerCreateGadgetToEquipPartNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TriggerCreateGadgetToEquipPartNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TriggerCreateGadgetToEquipPartNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TriggerCreateGadgetToEquipPartNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TriggerCreateGadgetToEquipPartNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TriggerCreateGadgetToEquipPartNotify parseFrom(InputStream input) throws IOException {
            return (TriggerCreateGadgetToEquipPartNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TriggerCreateGadgetToEquipPartNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TriggerCreateGadgetToEquipPartNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TriggerCreateGadgetToEquipPartNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (TriggerCreateGadgetToEquipPartNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TriggerCreateGadgetToEquipPartNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TriggerCreateGadgetToEquipPartNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TriggerCreateGadgetToEquipPartNotify parseFrom(CodedInputStream input) throws IOException {
            return (TriggerCreateGadgetToEquipPartNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TriggerCreateGadgetToEquipPartNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TriggerCreateGadgetToEquipPartNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TriggerCreateGadgetToEquipPartNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TriggerCreateGadgetToEquipPartNotifyOuterClass$TriggerCreateGadgetToEquipPartNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TriggerCreateGadgetToEquipPartNotifyOrBuilder {
            private int entityId_;
            private int gadgetId_;
            private int gadgetEntityId_;
            private Object equipPart_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return TriggerCreateGadgetToEquipPartNotifyOuterClass.internal_static_TriggerCreateGadgetToEquipPartNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TriggerCreateGadgetToEquipPartNotifyOuterClass.f868xffc3fdac.ensureFieldAccessorsInitialized(TriggerCreateGadgetToEquipPartNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TriggerCreateGadgetToEquipPartNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.entityId_ = 0;
                this.gadgetId_ = 0;
                this.gadgetEntityId_ = 0;
                this.equipPart_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TriggerCreateGadgetToEquipPartNotifyOuterClass.internal_static_TriggerCreateGadgetToEquipPartNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TriggerCreateGadgetToEquipPartNotify getDefaultInstanceForType() {
                return TriggerCreateGadgetToEquipPartNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TriggerCreateGadgetToEquipPartNotify build() {
                TriggerCreateGadgetToEquipPartNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TriggerCreateGadgetToEquipPartNotify buildPartial() {
                TriggerCreateGadgetToEquipPartNotify result = new TriggerCreateGadgetToEquipPartNotify(this);
                result.entityId_ = this.entityId_;
                result.gadgetId_ = this.gadgetId_;
                result.gadgetEntityId_ = this.gadgetEntityId_;
                result.equipPart_ = this.equipPart_;
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
                if (other instanceof TriggerCreateGadgetToEquipPartNotify) {
                    return mergeFrom((TriggerCreateGadgetToEquipPartNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TriggerCreateGadgetToEquipPartNotify other) {
                if (other == TriggerCreateGadgetToEquipPartNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.getGadgetId() != 0) {
                    setGadgetId(other.getGadgetId());
                }
                if (other.getGadgetEntityId() != 0) {
                    setGadgetEntityId(other.getGadgetEntityId());
                }
                if (!other.getEquipPart().isEmpty()) {
                    this.equipPart_ = other.equipPart_;
                    onChanged();
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
                TriggerCreateGadgetToEquipPartNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = TriggerCreateGadgetToEquipPartNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TriggerCreateGadgetToEquipPartNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TriggerCreateGadgetToEquipPartNotifyOuterClass.TriggerCreateGadgetToEquipPartNotifyOrBuilder
            public int getEntityId() {
                return this.entityId_;
            }

            public Builder setEntityId(int value) {
                this.entityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearEntityId() {
                this.entityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TriggerCreateGadgetToEquipPartNotifyOuterClass.TriggerCreateGadgetToEquipPartNotifyOrBuilder
            public int getGadgetId() {
                return this.gadgetId_;
            }

            public Builder setGadgetId(int value) {
                this.gadgetId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGadgetId() {
                this.gadgetId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TriggerCreateGadgetToEquipPartNotifyOuterClass.TriggerCreateGadgetToEquipPartNotifyOrBuilder
            public int getGadgetEntityId() {
                return this.gadgetEntityId_;
            }

            public Builder setGadgetEntityId(int value) {
                this.gadgetEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGadgetEntityId() {
                this.gadgetEntityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TriggerCreateGadgetToEquipPartNotifyOuterClass.TriggerCreateGadgetToEquipPartNotifyOrBuilder
            public String getEquipPart() {
                Object ref = this.equipPart_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.equipPart_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.TriggerCreateGadgetToEquipPartNotifyOuterClass.TriggerCreateGadgetToEquipPartNotifyOrBuilder
            public ByteString getEquipPartBytes() {
                Object ref = this.equipPart_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.equipPart_ = b;
                return b;
            }

            public Builder setEquipPart(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.equipPart_ = value;
                onChanged();
                return this;
            }

            public Builder clearEquipPart() {
                this.equipPart_ = TriggerCreateGadgetToEquipPartNotify.getDefaultInstance().getEquipPart();
                onChanged();
                return this;
            }

            public Builder setEquipPartBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                TriggerCreateGadgetToEquipPartNotify.checkByteStringIsUtf8(value);
                this.equipPart_ = value;
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

        public static TriggerCreateGadgetToEquipPartNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TriggerCreateGadgetToEquipPartNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TriggerCreateGadgetToEquipPartNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TriggerCreateGadgetToEquipPartNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
