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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeVerifyFurnitureDataOuterClass.class */
public final class HomeVerifyFurnitureDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dHomeVerifyFurnitureData.proto\"@\n\u0017HomeVerifyFurnitureData\u0012\f\n\u0004type\u0018\f \u0003(\r\u0012\u000b\n\u0003num\u0018\u0007 \u0001(\r\u0012\n\n\u0002id\u0018\r \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_HomeVerifyFurnitureData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeVerifyFurnitureData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeVerifyFurnitureData_descriptor, new String[]{"Type", "Num", "Id"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeVerifyFurnitureDataOuterClass$HomeVerifyFurnitureDataOrBuilder.class */
    public interface HomeVerifyFurnitureDataOrBuilder extends MessageOrBuilder {
        List<Integer> getTypeList();

        int getTypeCount();

        int getType(int i);

        int getNum();

        int getId();
    }

    private HomeVerifyFurnitureDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeVerifyFurnitureDataOuterClass$HomeVerifyFurnitureData.class */
    public static final class HomeVerifyFurnitureData extends GeneratedMessageV3 implements HomeVerifyFurnitureDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TYPE_FIELD_NUMBER = 12;
        private Internal.IntList type_;
        private int typeMemoizedSerializedSize;
        public static final int NUM_FIELD_NUMBER = 7;
        private int num_;
        public static final int ID_FIELD_NUMBER = 13;
        private int id_;
        private byte memoizedIsInitialized;
        private static final HomeVerifyFurnitureData DEFAULT_INSTANCE = new HomeVerifyFurnitureData();
        private static final Parser<HomeVerifyFurnitureData> PARSER = new AbstractParser<HomeVerifyFurnitureData>() { // from class: emu.grasscutter.net.proto.HomeVerifyFurnitureDataOuterClass.HomeVerifyFurnitureData.1
            @Override // com.google.protobuf.Parser
            public HomeVerifyFurnitureData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeVerifyFurnitureData(input, extensionRegistry);
            }
        };

        private HomeVerifyFurnitureData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.typeMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private HomeVerifyFurnitureData() {
            this.typeMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.type_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeVerifyFurnitureData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeVerifyFurnitureData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 56:
                                this.num_ = input.readUInt32();
                                break;
                            case 96:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.type_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.type_.addInt(input.readUInt32());
                                break;
                            case 98:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.type_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.type_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 104:
                                this.id_ = input.readUInt32();
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
                    this.type_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeVerifyFurnitureDataOuterClass.internal_static_HomeVerifyFurnitureData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeVerifyFurnitureDataOuterClass.internal_static_HomeVerifyFurnitureData_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeVerifyFurnitureData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeVerifyFurnitureDataOuterClass.HomeVerifyFurnitureDataOrBuilder
        public List<Integer> getTypeList() {
            return this.type_;
        }

        @Override // emu.grasscutter.net.proto.HomeVerifyFurnitureDataOuterClass.HomeVerifyFurnitureDataOrBuilder
        public int getTypeCount() {
            return this.type_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeVerifyFurnitureDataOuterClass.HomeVerifyFurnitureDataOrBuilder
        public int getType(int index) {
            return this.type_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.HomeVerifyFurnitureDataOuterClass.HomeVerifyFurnitureDataOrBuilder
        public int getNum() {
            return this.num_;
        }

        @Override // emu.grasscutter.net.proto.HomeVerifyFurnitureDataOuterClass.HomeVerifyFurnitureDataOrBuilder
        public int getId() {
            return this.id_;
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
            getSerializedSize();
            if (this.num_ != 0) {
                output.writeUInt32(7, this.num_);
            }
            if (getTypeList().size() > 0) {
                output.writeUInt32NoTag(98);
                output.writeUInt32NoTag(this.typeMemoizedSerializedSize);
            }
            for (int i = 0; i < this.type_.size(); i++) {
                output.writeUInt32NoTag(this.type_.getInt(i));
            }
            if (this.id_ != 0) {
                output.writeUInt32(13, this.id_);
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
            if (this.num_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(7, this.num_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.type_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.type_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getTypeList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.typeMemoizedSerializedSize = dataSize;
            if (this.id_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(13, this.id_);
            }
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof HomeVerifyFurnitureData)) {
                return equals(obj);
            }
            HomeVerifyFurnitureData other = (HomeVerifyFurnitureData) obj;
            return getTypeList().equals(other.getTypeList()) && getNum() == other.getNum() && getId() == other.getId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getTypeCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getTypeList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 7)) + getNum())) + 13)) + getId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeVerifyFurnitureData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeVerifyFurnitureData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeVerifyFurnitureData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeVerifyFurnitureData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeVerifyFurnitureData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeVerifyFurnitureData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeVerifyFurnitureData parseFrom(InputStream input) throws IOException {
            return (HomeVerifyFurnitureData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeVerifyFurnitureData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeVerifyFurnitureData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeVerifyFurnitureData parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeVerifyFurnitureData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeVerifyFurnitureData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeVerifyFurnitureData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeVerifyFurnitureData parseFrom(CodedInputStream input) throws IOException {
            return (HomeVerifyFurnitureData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeVerifyFurnitureData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeVerifyFurnitureData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeVerifyFurnitureData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeVerifyFurnitureDataOuterClass$HomeVerifyFurnitureData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeVerifyFurnitureDataOrBuilder {
            private int bitField0_;
            private Internal.IntList type_ = HomeVerifyFurnitureData.emptyIntList();
            private int num_;
            private int id_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeVerifyFurnitureDataOuterClass.internal_static_HomeVerifyFurnitureData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeVerifyFurnitureDataOuterClass.internal_static_HomeVerifyFurnitureData_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeVerifyFurnitureData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeVerifyFurnitureData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.type_ = HomeVerifyFurnitureData.emptyIntList();
                this.bitField0_ &= -2;
                this.num_ = 0;
                this.id_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeVerifyFurnitureDataOuterClass.internal_static_HomeVerifyFurnitureData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeVerifyFurnitureData getDefaultInstanceForType() {
                return HomeVerifyFurnitureData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeVerifyFurnitureData build() {
                HomeVerifyFurnitureData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeVerifyFurnitureData buildPartial() {
                HomeVerifyFurnitureData result = new HomeVerifyFurnitureData(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.type_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.type_ = this.type_;
                result.num_ = this.num_;
                result.id_ = this.id_;
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
                if (other instanceof HomeVerifyFurnitureData) {
                    return mergeFrom((HomeVerifyFurnitureData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeVerifyFurnitureData other) {
                if (other == HomeVerifyFurnitureData.getDefaultInstance()) {
                    return this;
                }
                if (!other.type_.isEmpty()) {
                    if (this.type_.isEmpty()) {
                        this.type_ = other.type_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureTypeIsMutable();
                        this.type_.addAll(other.type_);
                    }
                    onChanged();
                }
                if (other.getNum() != 0) {
                    setNum(other.getNum());
                }
                if (other.getId() != 0) {
                    setId(other.getId());
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
                HomeVerifyFurnitureData parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeVerifyFurnitureData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeVerifyFurnitureData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureTypeIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.type_ = HomeVerifyFurnitureData.mutableCopy(this.type_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeVerifyFurnitureDataOuterClass.HomeVerifyFurnitureDataOrBuilder
            public List<Integer> getTypeList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.type_) : this.type_;
            }

            @Override // emu.grasscutter.net.proto.HomeVerifyFurnitureDataOuterClass.HomeVerifyFurnitureDataOrBuilder
            public int getTypeCount() {
                return this.type_.size();
            }

            @Override // emu.grasscutter.net.proto.HomeVerifyFurnitureDataOuterClass.HomeVerifyFurnitureDataOrBuilder
            public int getType(int index) {
                return this.type_.getInt(index);
            }

            public Builder setType(int index, int value) {
                ensureTypeIsMutable();
                this.type_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addType(int value) {
                ensureTypeIsMutable();
                this.type_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllType(Iterable<? extends Integer> values) {
                ensureTypeIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.type_);
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = HomeVerifyFurnitureData.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeVerifyFurnitureDataOuterClass.HomeVerifyFurnitureDataOrBuilder
            public int getNum() {
                return this.num_;
            }

            public Builder setNum(int value) {
                this.num_ = value;
                onChanged();
                return this;
            }

            public Builder clearNum() {
                this.num_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeVerifyFurnitureDataOuterClass.HomeVerifyFurnitureDataOrBuilder
            public int getId() {
                return this.id_;
            }

            public Builder setId(int value) {
                this.id_ = value;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = 0;
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

        public static HomeVerifyFurnitureData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeVerifyFurnitureData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeVerifyFurnitureData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeVerifyFurnitureData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
