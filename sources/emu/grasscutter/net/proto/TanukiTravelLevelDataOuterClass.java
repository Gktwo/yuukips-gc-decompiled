package emu.grasscutter.net.proto;

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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TanukiTravelLevelDataOuterClass.class */
public final class TanukiTravelLevelDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bTanukiTravelLevelData.proto\"M\n\u0015TanukiTravelLevelData\u0012\u0011\n\tis_finish\u0018\u0007 \u0001(\b\u0012\u000f\n\u0007is_open\u0018\t \u0001(\b\u0012\u0010\n\broute_id\u0018\b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TanukiTravelLevelData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TanukiTravelLevelData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TanukiTravelLevelData_descriptor, new String[]{"IsFinish", "IsOpen", "RouteId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TanukiTravelLevelDataOuterClass$TanukiTravelLevelDataOrBuilder.class */
    public interface TanukiTravelLevelDataOrBuilder extends MessageOrBuilder {
        boolean getIsFinish();

        boolean getIsOpen();

        int getRouteId();
    }

    private TanukiTravelLevelDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TanukiTravelLevelDataOuterClass$TanukiTravelLevelData.class */
    public static final class TanukiTravelLevelData extends GeneratedMessageV3 implements TanukiTravelLevelDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_FINISH_FIELD_NUMBER = 7;
        private boolean isFinish_;
        public static final int IS_OPEN_FIELD_NUMBER = 9;
        private boolean isOpen_;
        public static final int ROUTE_ID_FIELD_NUMBER = 8;
        private int routeId_;
        private byte memoizedIsInitialized;
        private static final TanukiTravelLevelData DEFAULT_INSTANCE = new TanukiTravelLevelData();
        private static final Parser<TanukiTravelLevelData> PARSER = new AbstractParser<TanukiTravelLevelData>() { // from class: emu.grasscutter.net.proto.TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.1
            @Override // com.google.protobuf.Parser
            public TanukiTravelLevelData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TanukiTravelLevelData(input, extensionRegistry);
            }
        };

        private TanukiTravelLevelData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TanukiTravelLevelData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TanukiTravelLevelData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TanukiTravelLevelData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 56:
                                    this.isFinish_ = input.readBool();
                                    break;
                                case 64:
                                    this.routeId_ = input.readUInt32();
                                    break;
                                case 72:
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
                        }
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
            return TanukiTravelLevelDataOuterClass.internal_static_TanukiTravelLevelData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TanukiTravelLevelDataOuterClass.internal_static_TanukiTravelLevelData_fieldAccessorTable.ensureFieldAccessorsInitialized(TanukiTravelLevelData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TanukiTravelLevelDataOuterClass.TanukiTravelLevelDataOrBuilder
        public boolean getIsFinish() {
            return this.isFinish_;
        }

        @Override // emu.grasscutter.net.proto.TanukiTravelLevelDataOuterClass.TanukiTravelLevelDataOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.TanukiTravelLevelDataOuterClass.TanukiTravelLevelDataOrBuilder
        public int getRouteId() {
            return this.routeId_;
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
            if (this.isFinish_) {
                output.writeBool(7, this.isFinish_);
            }
            if (this.routeId_ != 0) {
                output.writeUInt32(8, this.routeId_);
            }
            if (this.isOpen_) {
                output.writeBool(9, this.isOpen_);
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
            if (this.isFinish_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(7, this.isFinish_);
            }
            if (this.routeId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.routeId_);
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.isOpen_);
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
            if (!(obj instanceof TanukiTravelLevelData)) {
                return equals(obj);
            }
            TanukiTravelLevelData other = (TanukiTravelLevelData) obj;
            return getIsFinish() == other.getIsFinish() && getIsOpen() == other.getIsOpen() && getRouteId() == other.getRouteId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + Internal.hashBoolean(getIsFinish()))) + 9)) + Internal.hashBoolean(getIsOpen()))) + 8)) + getRouteId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static TanukiTravelLevelData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TanukiTravelLevelData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TanukiTravelLevelData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TanukiTravelLevelData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TanukiTravelLevelData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TanukiTravelLevelData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TanukiTravelLevelData parseFrom(InputStream input) throws IOException {
            return (TanukiTravelLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TanukiTravelLevelData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TanukiTravelLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TanukiTravelLevelData parseDelimitedFrom(InputStream input) throws IOException {
            return (TanukiTravelLevelData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TanukiTravelLevelData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TanukiTravelLevelData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TanukiTravelLevelData parseFrom(CodedInputStream input) throws IOException {
            return (TanukiTravelLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TanukiTravelLevelData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TanukiTravelLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TanukiTravelLevelData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TanukiTravelLevelDataOuterClass$TanukiTravelLevelData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TanukiTravelLevelDataOrBuilder {
            private boolean isFinish_;
            private boolean isOpen_;
            private int routeId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TanukiTravelLevelDataOuterClass.internal_static_TanukiTravelLevelData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TanukiTravelLevelDataOuterClass.internal_static_TanukiTravelLevelData_fieldAccessorTable.ensureFieldAccessorsInitialized(TanukiTravelLevelData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TanukiTravelLevelData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isFinish_ = false;
                this.isOpen_ = false;
                this.routeId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TanukiTravelLevelDataOuterClass.internal_static_TanukiTravelLevelData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TanukiTravelLevelData getDefaultInstanceForType() {
                return TanukiTravelLevelData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TanukiTravelLevelData build() {
                TanukiTravelLevelData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TanukiTravelLevelData buildPartial() {
                TanukiTravelLevelData result = new TanukiTravelLevelData(this);
                result.isFinish_ = this.isFinish_;
                result.isOpen_ = this.isOpen_;
                result.routeId_ = this.routeId_;
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
                if (other instanceof TanukiTravelLevelData) {
                    return mergeFrom((TanukiTravelLevelData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TanukiTravelLevelData other) {
                if (other == TanukiTravelLevelData.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsFinish()) {
                    setIsFinish(other.getIsFinish());
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (other.getRouteId() != 0) {
                    setRouteId(other.getRouteId());
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
                TanukiTravelLevelData parsedMessage = null;
                try {
                    try {
                        parsedMessage = TanukiTravelLevelData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TanukiTravelLevelData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TanukiTravelLevelDataOuterClass.TanukiTravelLevelDataOrBuilder
            public boolean getIsFinish() {
                return this.isFinish_;
            }

            public Builder setIsFinish(boolean value) {
                this.isFinish_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFinish() {
                this.isFinish_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TanukiTravelLevelDataOuterClass.TanukiTravelLevelDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.TanukiTravelLevelDataOuterClass.TanukiTravelLevelDataOrBuilder
            public int getRouteId() {
                return this.routeId_;
            }

            public Builder setRouteId(int value) {
                this.routeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRouteId() {
                this.routeId_ = 0;
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

        public static TanukiTravelLevelData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TanukiTravelLevelData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TanukiTravelLevelData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TanukiTravelLevelData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
