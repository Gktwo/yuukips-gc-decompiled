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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StrengthenPointDataOuterClass.class */
public final class StrengthenPointDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019StrengthenPointData.proto\"O\n\u0013StrengthenPointData\u0012\u001b\n\u0013Unk3300_HIKDEKIPCPB\u0018\u0001 \u0001(\r\u0012\u001b\n\u0013Unk3300_NNKPOLLBLDO\u0018\n \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_StrengthenPointData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_StrengthenPointData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_StrengthenPointData_descriptor, new String[]{"Unk3300HIKDEKIPCPB", "Unk3300NNKPOLLBLDO"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StrengthenPointDataOuterClass$StrengthenPointDataOrBuilder.class */
    public interface StrengthenPointDataOrBuilder extends MessageOrBuilder {
        int getUnk3300HIKDEKIPCPB();

        int getUnk3300NNKPOLLBLDO();
    }

    private StrengthenPointDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StrengthenPointDataOuterClass$StrengthenPointData.class */
    public static final class StrengthenPointData extends GeneratedMessageV3 implements StrengthenPointDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_HIKDEKIPCPB_FIELD_NUMBER = 1;
        private int unk3300HIKDEKIPCPB_;
        public static final int UNK3300_NNKPOLLBLDO_FIELD_NUMBER = 10;
        private int unk3300NNKPOLLBLDO_;
        private byte memoizedIsInitialized;
        private static final StrengthenPointData DEFAULT_INSTANCE = new StrengthenPointData();
        private static final Parser<StrengthenPointData> PARSER = new AbstractParser<StrengthenPointData>() { // from class: emu.grasscutter.net.proto.StrengthenPointDataOuterClass.StrengthenPointData.1
            @Override // com.google.protobuf.Parser
            public StrengthenPointData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new StrengthenPointData(input, extensionRegistry);
            }
        };

        private StrengthenPointData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private StrengthenPointData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new StrengthenPointData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private StrengthenPointData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.unk3300HIKDEKIPCPB_ = input.readUInt32();
                                break;
                            case 80:
                                this.unk3300NNKPOLLBLDO_ = input.readUInt32();
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
            return StrengthenPointDataOuterClass.internal_static_StrengthenPointData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StrengthenPointDataOuterClass.internal_static_StrengthenPointData_fieldAccessorTable.ensureFieldAccessorsInitialized(StrengthenPointData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.StrengthenPointDataOuterClass.StrengthenPointDataOrBuilder
        public int getUnk3300HIKDEKIPCPB() {
            return this.unk3300HIKDEKIPCPB_;
        }

        @Override // emu.grasscutter.net.proto.StrengthenPointDataOuterClass.StrengthenPointDataOrBuilder
        public int getUnk3300NNKPOLLBLDO() {
            return this.unk3300NNKPOLLBLDO_;
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
            if (this.unk3300HIKDEKIPCPB_ != 0) {
                output.writeUInt32(1, this.unk3300HIKDEKIPCPB_);
            }
            if (this.unk3300NNKPOLLBLDO_ != 0) {
                output.writeUInt32(10, this.unk3300NNKPOLLBLDO_);
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
            if (this.unk3300HIKDEKIPCPB_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.unk3300HIKDEKIPCPB_);
            }
            if (this.unk3300NNKPOLLBLDO_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.unk3300NNKPOLLBLDO_);
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
            if (!(obj instanceof StrengthenPointData)) {
                return equals(obj);
            }
            StrengthenPointData other = (StrengthenPointData) obj;
            return getUnk3300HIKDEKIPCPB() == other.getUnk3300HIKDEKIPCPB() && getUnk3300NNKPOLLBLDO() == other.getUnk3300NNKPOLLBLDO() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getUnk3300HIKDEKIPCPB())) + 10)) + getUnk3300NNKPOLLBLDO())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static StrengthenPointData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static StrengthenPointData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static StrengthenPointData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static StrengthenPointData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static StrengthenPointData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static StrengthenPointData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static StrengthenPointData parseFrom(InputStream input) throws IOException {
            return (StrengthenPointData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static StrengthenPointData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StrengthenPointData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static StrengthenPointData parseDelimitedFrom(InputStream input) throws IOException {
            return (StrengthenPointData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static StrengthenPointData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StrengthenPointData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static StrengthenPointData parseFrom(CodedInputStream input) throws IOException {
            return (StrengthenPointData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static StrengthenPointData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StrengthenPointData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(StrengthenPointData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StrengthenPointDataOuterClass$StrengthenPointData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements StrengthenPointDataOrBuilder {
            private int unk3300HIKDEKIPCPB_;
            private int unk3300NNKPOLLBLDO_;

            public static final Descriptors.Descriptor getDescriptor() {
                return StrengthenPointDataOuterClass.internal_static_StrengthenPointData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StrengthenPointDataOuterClass.internal_static_StrengthenPointData_fieldAccessorTable.ensureFieldAccessorsInitialized(StrengthenPointData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (StrengthenPointData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300HIKDEKIPCPB_ = 0;
                this.unk3300NNKPOLLBLDO_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return StrengthenPointDataOuterClass.internal_static_StrengthenPointData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public StrengthenPointData getDefaultInstanceForType() {
                return StrengthenPointData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public StrengthenPointData build() {
                StrengthenPointData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public StrengthenPointData buildPartial() {
                StrengthenPointData result = new StrengthenPointData(this);
                result.unk3300HIKDEKIPCPB_ = this.unk3300HIKDEKIPCPB_;
                result.unk3300NNKPOLLBLDO_ = this.unk3300NNKPOLLBLDO_;
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
                if (other instanceof StrengthenPointData) {
                    return mergeFrom((StrengthenPointData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(StrengthenPointData other) {
                if (other == StrengthenPointData.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300HIKDEKIPCPB() != 0) {
                    setUnk3300HIKDEKIPCPB(other.getUnk3300HIKDEKIPCPB());
                }
                if (other.getUnk3300NNKPOLLBLDO() != 0) {
                    setUnk3300NNKPOLLBLDO(other.getUnk3300NNKPOLLBLDO());
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
                StrengthenPointData parsedMessage = null;
                try {
                    try {
                        parsedMessage = StrengthenPointData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (StrengthenPointData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.StrengthenPointDataOuterClass.StrengthenPointDataOrBuilder
            public int getUnk3300HIKDEKIPCPB() {
                return this.unk3300HIKDEKIPCPB_;
            }

            public Builder setUnk3300HIKDEKIPCPB(int value) {
                this.unk3300HIKDEKIPCPB_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300HIKDEKIPCPB() {
                this.unk3300HIKDEKIPCPB_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.StrengthenPointDataOuterClass.StrengthenPointDataOrBuilder
            public int getUnk3300NNKPOLLBLDO() {
                return this.unk3300NNKPOLLBLDO_;
            }

            public Builder setUnk3300NNKPOLLBLDO(int value) {
                this.unk3300NNKPOLLBLDO_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300NNKPOLLBLDO() {
                this.unk3300NNKPOLLBLDO_ = 0;
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

        public static StrengthenPointData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StrengthenPointData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<StrengthenPointData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public StrengthenPointData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
