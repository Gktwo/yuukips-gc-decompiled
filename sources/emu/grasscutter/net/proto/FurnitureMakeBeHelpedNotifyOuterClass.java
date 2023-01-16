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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.FurnitureMakeBeHelpedDataOuterClass;
import emu.grasscutter.net.proto.FurnitureMakeSlotOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeBeHelpedNotifyOuterClass.class */
public final class FurnitureMakeBeHelpedNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!FurnitureMakeBeHelpedNotify.proto\u001a\u001fFurnitureMakeBeHelpedData.proto\u001a\u0017FurnitureMakeSlot.proto\"\u0001\n\u001bFurnitureMakeBeHelpedNotify\u0012>\n\u001afurniture_make_helped_data\u0018\f \u0001(\u000b2\u001a.FurnitureMakeBeHelpedData\u0012/\n\u0013furniture_make_slot\u0018\u0003 \u0001(\u000b2\u0012.FurnitureMakeSlotB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FurnitureMakeBeHelpedDataOuterClass.getDescriptor(), FurnitureMakeSlotOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FurnitureMakeBeHelpedNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FurnitureMakeBeHelpedNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FurnitureMakeBeHelpedNotify_descriptor, new String[]{"FurnitureMakeHelpedData", "FurnitureMakeSlot"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeBeHelpedNotifyOuterClass$FurnitureMakeBeHelpedNotifyOrBuilder.class */
    public interface FurnitureMakeBeHelpedNotifyOrBuilder extends MessageOrBuilder {
        boolean hasFurnitureMakeHelpedData();

        FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData getFurnitureMakeHelpedData();

        FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder getFurnitureMakeHelpedDataOrBuilder();

        boolean hasFurnitureMakeSlot();

        FurnitureMakeSlotOuterClass.FurnitureMakeSlot getFurnitureMakeSlot();

        FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder getFurnitureMakeSlotOrBuilder();
    }

    private FurnitureMakeBeHelpedNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeBeHelpedNotifyOuterClass$FurnitureMakeBeHelpedNotify.class */
    public static final class FurnitureMakeBeHelpedNotify extends GeneratedMessageV3 implements FurnitureMakeBeHelpedNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FURNITURE_MAKE_HELPED_DATA_FIELD_NUMBER = 12;
        private FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData furnitureMakeHelpedData_;
        public static final int FURNITURE_MAKE_SLOT_FIELD_NUMBER = 3;
        private FurnitureMakeSlotOuterClass.FurnitureMakeSlot furnitureMakeSlot_;
        private byte memoizedIsInitialized;
        private static final FurnitureMakeBeHelpedNotify DEFAULT_INSTANCE = new FurnitureMakeBeHelpedNotify();
        private static final Parser<FurnitureMakeBeHelpedNotify> PARSER = new AbstractParser<FurnitureMakeBeHelpedNotify>() { // from class: emu.grasscutter.net.proto.FurnitureMakeBeHelpedNotifyOuterClass.FurnitureMakeBeHelpedNotify.1
            @Override // com.google.protobuf.Parser
            public FurnitureMakeBeHelpedNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FurnitureMakeBeHelpedNotify(input, extensionRegistry);
            }
        };

        private FurnitureMakeBeHelpedNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FurnitureMakeBeHelpedNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FurnitureMakeBeHelpedNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FurnitureMakeBeHelpedNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 26:
                                    FurnitureMakeSlotOuterClass.FurnitureMakeSlot.Builder subBuilder = this.furnitureMakeSlot_ != null ? this.furnitureMakeSlot_.toBuilder() : null;
                                    this.furnitureMakeSlot_ = (FurnitureMakeSlotOuterClass.FurnitureMakeSlot) input.readMessage(FurnitureMakeSlotOuterClass.FurnitureMakeSlot.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.furnitureMakeSlot_);
                                        this.furnitureMakeSlot_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 98:
                                    FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.Builder subBuilder2 = this.furnitureMakeHelpedData_ != null ? this.furnitureMakeHelpedData_.toBuilder() : null;
                                    this.furnitureMakeHelpedData_ = (FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData) input.readMessage(FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.parser(), extensionRegistry);
                                    if (subBuilder2 == null) {
                                        break;
                                    } else {
                                        subBuilder2.mergeFrom(this.furnitureMakeHelpedData_);
                                        this.furnitureMakeHelpedData_ = subBuilder2.buildPartial();
                                        break;
                                    }
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FurnitureMakeBeHelpedNotifyOuterClass.internal_static_FurnitureMakeBeHelpedNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FurnitureMakeBeHelpedNotifyOuterClass.internal_static_FurnitureMakeBeHelpedNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(FurnitureMakeBeHelpedNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedNotifyOuterClass.FurnitureMakeBeHelpedNotifyOrBuilder
        public boolean hasFurnitureMakeHelpedData() {
            return this.furnitureMakeHelpedData_ != null;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedNotifyOuterClass.FurnitureMakeBeHelpedNotifyOrBuilder
        public FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData getFurnitureMakeHelpedData() {
            return this.furnitureMakeHelpedData_ == null ? FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.getDefaultInstance() : this.furnitureMakeHelpedData_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedNotifyOuterClass.FurnitureMakeBeHelpedNotifyOrBuilder
        public FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder getFurnitureMakeHelpedDataOrBuilder() {
            return getFurnitureMakeHelpedData();
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedNotifyOuterClass.FurnitureMakeBeHelpedNotifyOrBuilder
        public boolean hasFurnitureMakeSlot() {
            return this.furnitureMakeSlot_ != null;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedNotifyOuterClass.FurnitureMakeBeHelpedNotifyOrBuilder
        public FurnitureMakeSlotOuterClass.FurnitureMakeSlot getFurnitureMakeSlot() {
            return this.furnitureMakeSlot_ == null ? FurnitureMakeSlotOuterClass.FurnitureMakeSlot.getDefaultInstance() : this.furnitureMakeSlot_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedNotifyOuterClass.FurnitureMakeBeHelpedNotifyOrBuilder
        public FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder getFurnitureMakeSlotOrBuilder() {
            return getFurnitureMakeSlot();
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
            if (this.furnitureMakeSlot_ != null) {
                output.writeMessage(3, getFurnitureMakeSlot());
            }
            if (this.furnitureMakeHelpedData_ != null) {
                output.writeMessage(12, getFurnitureMakeHelpedData());
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
            if (this.furnitureMakeSlot_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(3, getFurnitureMakeSlot());
            }
            if (this.furnitureMakeHelpedData_ != null) {
                size2 += CodedOutputStream.computeMessageSize(12, getFurnitureMakeHelpedData());
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
            if (!(obj instanceof FurnitureMakeBeHelpedNotify)) {
                return equals(obj);
            }
            FurnitureMakeBeHelpedNotify other = (FurnitureMakeBeHelpedNotify) obj;
            if (hasFurnitureMakeHelpedData() != other.hasFurnitureMakeHelpedData()) {
                return false;
            }
            if ((!hasFurnitureMakeHelpedData() || getFurnitureMakeHelpedData().equals(other.getFurnitureMakeHelpedData())) && hasFurnitureMakeSlot() == other.hasFurnitureMakeSlot()) {
                return (!hasFurnitureMakeSlot() || getFurnitureMakeSlot().equals(other.getFurnitureMakeSlot())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasFurnitureMakeHelpedData()) {
                hash = (53 * ((37 * hash) + 12)) + getFurnitureMakeHelpedData().hashCode();
            }
            if (hasFurnitureMakeSlot()) {
                hash = (53 * ((37 * hash) + 3)) + getFurnitureMakeSlot().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FurnitureMakeBeHelpedNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeBeHelpedNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeBeHelpedNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeBeHelpedNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeBeHelpedNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeBeHelpedNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeBeHelpedNotify parseFrom(InputStream input) throws IOException {
            return (FurnitureMakeBeHelpedNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FurnitureMakeBeHelpedNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeBeHelpedNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FurnitureMakeBeHelpedNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (FurnitureMakeBeHelpedNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FurnitureMakeBeHelpedNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeBeHelpedNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FurnitureMakeBeHelpedNotify parseFrom(CodedInputStream input) throws IOException {
            return (FurnitureMakeBeHelpedNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FurnitureMakeBeHelpedNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeBeHelpedNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FurnitureMakeBeHelpedNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeBeHelpedNotifyOuterClass$FurnitureMakeBeHelpedNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FurnitureMakeBeHelpedNotifyOrBuilder {
            private FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData furnitureMakeHelpedData_;
            private SingleFieldBuilderV3<FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData, FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.Builder, FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder> furnitureMakeHelpedDataBuilder_;
            private FurnitureMakeSlotOuterClass.FurnitureMakeSlot furnitureMakeSlot_;
            private SingleFieldBuilderV3<FurnitureMakeSlotOuterClass.FurnitureMakeSlot, FurnitureMakeSlotOuterClass.FurnitureMakeSlot.Builder, FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder> furnitureMakeSlotBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FurnitureMakeBeHelpedNotifyOuterClass.internal_static_FurnitureMakeBeHelpedNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FurnitureMakeBeHelpedNotifyOuterClass.internal_static_FurnitureMakeBeHelpedNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(FurnitureMakeBeHelpedNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FurnitureMakeBeHelpedNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.furnitureMakeHelpedDataBuilder_ == null) {
                    this.furnitureMakeHelpedData_ = null;
                } else {
                    this.furnitureMakeHelpedData_ = null;
                    this.furnitureMakeHelpedDataBuilder_ = null;
                }
                if (this.furnitureMakeSlotBuilder_ == null) {
                    this.furnitureMakeSlot_ = null;
                } else {
                    this.furnitureMakeSlot_ = null;
                    this.furnitureMakeSlotBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FurnitureMakeBeHelpedNotifyOuterClass.internal_static_FurnitureMakeBeHelpedNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FurnitureMakeBeHelpedNotify getDefaultInstanceForType() {
                return FurnitureMakeBeHelpedNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FurnitureMakeBeHelpedNotify build() {
                FurnitureMakeBeHelpedNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FurnitureMakeBeHelpedNotify buildPartial() {
                FurnitureMakeBeHelpedNotify result = new FurnitureMakeBeHelpedNotify(this);
                if (this.furnitureMakeHelpedDataBuilder_ == null) {
                    result.furnitureMakeHelpedData_ = this.furnitureMakeHelpedData_;
                } else {
                    result.furnitureMakeHelpedData_ = this.furnitureMakeHelpedDataBuilder_.build();
                }
                if (this.furnitureMakeSlotBuilder_ == null) {
                    result.furnitureMakeSlot_ = this.furnitureMakeSlot_;
                } else {
                    result.furnitureMakeSlot_ = this.furnitureMakeSlotBuilder_.build();
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
                if (other instanceof FurnitureMakeBeHelpedNotify) {
                    return mergeFrom((FurnitureMakeBeHelpedNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FurnitureMakeBeHelpedNotify other) {
                if (other == FurnitureMakeBeHelpedNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasFurnitureMakeHelpedData()) {
                    mergeFurnitureMakeHelpedData(other.getFurnitureMakeHelpedData());
                }
                if (other.hasFurnitureMakeSlot()) {
                    mergeFurnitureMakeSlot(other.getFurnitureMakeSlot());
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
                FurnitureMakeBeHelpedNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = FurnitureMakeBeHelpedNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FurnitureMakeBeHelpedNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedNotifyOuterClass.FurnitureMakeBeHelpedNotifyOrBuilder
            public boolean hasFurnitureMakeHelpedData() {
                return (this.furnitureMakeHelpedDataBuilder_ == null && this.furnitureMakeHelpedData_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedNotifyOuterClass.FurnitureMakeBeHelpedNotifyOrBuilder
            public FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData getFurnitureMakeHelpedData() {
                if (this.furnitureMakeHelpedDataBuilder_ == null) {
                    return this.furnitureMakeHelpedData_ == null ? FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.getDefaultInstance() : this.furnitureMakeHelpedData_;
                }
                return this.furnitureMakeHelpedDataBuilder_.getMessage();
            }

            public Builder setFurnitureMakeHelpedData(FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData value) {
                if (this.furnitureMakeHelpedDataBuilder_ != null) {
                    this.furnitureMakeHelpedDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.furnitureMakeHelpedData_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setFurnitureMakeHelpedData(FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.Builder builderForValue) {
                if (this.furnitureMakeHelpedDataBuilder_ == null) {
                    this.furnitureMakeHelpedData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.furnitureMakeHelpedDataBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeFurnitureMakeHelpedData(FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData value) {
                if (this.furnitureMakeHelpedDataBuilder_ == null) {
                    if (this.furnitureMakeHelpedData_ != null) {
                        this.furnitureMakeHelpedData_ = FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.newBuilder(this.furnitureMakeHelpedData_).mergeFrom(value).buildPartial();
                    } else {
                        this.furnitureMakeHelpedData_ = value;
                    }
                    onChanged();
                } else {
                    this.furnitureMakeHelpedDataBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearFurnitureMakeHelpedData() {
                if (this.furnitureMakeHelpedDataBuilder_ == null) {
                    this.furnitureMakeHelpedData_ = null;
                    onChanged();
                } else {
                    this.furnitureMakeHelpedData_ = null;
                    this.furnitureMakeHelpedDataBuilder_ = null;
                }
                return this;
            }

            public FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.Builder getFurnitureMakeHelpedDataBuilder() {
                onChanged();
                return getFurnitureMakeHelpedDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedNotifyOuterClass.FurnitureMakeBeHelpedNotifyOrBuilder
            public FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder getFurnitureMakeHelpedDataOrBuilder() {
                if (this.furnitureMakeHelpedDataBuilder_ != null) {
                    return this.furnitureMakeHelpedDataBuilder_.getMessageOrBuilder();
                }
                return this.furnitureMakeHelpedData_ == null ? FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.getDefaultInstance() : this.furnitureMakeHelpedData_;
            }

            private SingleFieldBuilderV3<FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData, FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.Builder, FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder> getFurnitureMakeHelpedDataFieldBuilder() {
                if (this.furnitureMakeHelpedDataBuilder_ == null) {
                    this.furnitureMakeHelpedDataBuilder_ = new SingleFieldBuilderV3<>(getFurnitureMakeHelpedData(), getParentForChildren(), isClean());
                    this.furnitureMakeHelpedData_ = null;
                }
                return this.furnitureMakeHelpedDataBuilder_;
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedNotifyOuterClass.FurnitureMakeBeHelpedNotifyOrBuilder
            public boolean hasFurnitureMakeSlot() {
                return (this.furnitureMakeSlotBuilder_ == null && this.furnitureMakeSlot_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedNotifyOuterClass.FurnitureMakeBeHelpedNotifyOrBuilder
            public FurnitureMakeSlotOuterClass.FurnitureMakeSlot getFurnitureMakeSlot() {
                if (this.furnitureMakeSlotBuilder_ == null) {
                    return this.furnitureMakeSlot_ == null ? FurnitureMakeSlotOuterClass.FurnitureMakeSlot.getDefaultInstance() : this.furnitureMakeSlot_;
                }
                return this.furnitureMakeSlotBuilder_.getMessage();
            }

            public Builder setFurnitureMakeSlot(FurnitureMakeSlotOuterClass.FurnitureMakeSlot value) {
                if (this.furnitureMakeSlotBuilder_ != null) {
                    this.furnitureMakeSlotBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.furnitureMakeSlot_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setFurnitureMakeSlot(FurnitureMakeSlotOuterClass.FurnitureMakeSlot.Builder builderForValue) {
                if (this.furnitureMakeSlotBuilder_ == null) {
                    this.furnitureMakeSlot_ = builderForValue.build();
                    onChanged();
                } else {
                    this.furnitureMakeSlotBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeFurnitureMakeSlot(FurnitureMakeSlotOuterClass.FurnitureMakeSlot value) {
                if (this.furnitureMakeSlotBuilder_ == null) {
                    if (this.furnitureMakeSlot_ != null) {
                        this.furnitureMakeSlot_ = FurnitureMakeSlotOuterClass.FurnitureMakeSlot.newBuilder(this.furnitureMakeSlot_).mergeFrom(value).buildPartial();
                    } else {
                        this.furnitureMakeSlot_ = value;
                    }
                    onChanged();
                } else {
                    this.furnitureMakeSlotBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearFurnitureMakeSlot() {
                if (this.furnitureMakeSlotBuilder_ == null) {
                    this.furnitureMakeSlot_ = null;
                    onChanged();
                } else {
                    this.furnitureMakeSlot_ = null;
                    this.furnitureMakeSlotBuilder_ = null;
                }
                return this;
            }

            public FurnitureMakeSlotOuterClass.FurnitureMakeSlot.Builder getFurnitureMakeSlotBuilder() {
                onChanged();
                return getFurnitureMakeSlotFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedNotifyOuterClass.FurnitureMakeBeHelpedNotifyOrBuilder
            public FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder getFurnitureMakeSlotOrBuilder() {
                if (this.furnitureMakeSlotBuilder_ != null) {
                    return this.furnitureMakeSlotBuilder_.getMessageOrBuilder();
                }
                return this.furnitureMakeSlot_ == null ? FurnitureMakeSlotOuterClass.FurnitureMakeSlot.getDefaultInstance() : this.furnitureMakeSlot_;
            }

            private SingleFieldBuilderV3<FurnitureMakeSlotOuterClass.FurnitureMakeSlot, FurnitureMakeSlotOuterClass.FurnitureMakeSlot.Builder, FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder> getFurnitureMakeSlotFieldBuilder() {
                if (this.furnitureMakeSlotBuilder_ == null) {
                    this.furnitureMakeSlotBuilder_ = new SingleFieldBuilderV3<>(getFurnitureMakeSlot(), getParentForChildren(), isClean());
                    this.furnitureMakeSlot_ = null;
                }
                return this.furnitureMakeSlotBuilder_;
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

        public static FurnitureMakeBeHelpedNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FurnitureMakeBeHelpedNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FurnitureMakeBeHelpedNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FurnitureMakeBeHelpedNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FurnitureMakeBeHelpedDataOuterClass.getDescriptor();
        FurnitureMakeSlotOuterClass.getDescriptor();
    }
}
