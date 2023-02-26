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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ParamListOuterClass.class */
public final class ParamListOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fParamList.proto\"\u001e\n\tParamList\u0012\u0011\n\tparamList\u0018\u0001 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ParamList_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ParamList_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ParamList_descriptor, new String[]{"ParamList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ParamListOuterClass$ParamListOrBuilder.class */
    public interface ParamListOrBuilder extends MessageOrBuilder {
        List<Integer> getParamListList();

        int getParamListCount();

        int getParamList(int i);
    }

    private ParamListOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ParamListOuterClass$ParamList.class */
    public static final class ParamList extends GeneratedMessageV3 implements ParamListOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PARAMLIST_FIELD_NUMBER = 1;
        private Internal.IntList paramList_;
        private int paramListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final ParamList DEFAULT_INSTANCE = new ParamList();
        private static final Parser<ParamList> PARSER = new AbstractParser<ParamList>() { // from class: emu.grasscutter.net.proto.ParamListOuterClass.ParamList.1
            @Override // com.google.protobuf.Parser
            public ParamList parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ParamList(input, extensionRegistry);
            }
        };

        private ParamList(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.paramListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ParamList() {
            this.paramListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.paramList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ParamList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ParamList(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.paramList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.paramList_.addInt(input.readUInt32());
                                    break;
                                case 10:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.paramList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.paramList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
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
                    this.paramList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ParamListOuterClass.internal_static_ParamList_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ParamListOuterClass.internal_static_ParamList_fieldAccessorTable.ensureFieldAccessorsInitialized(ParamList.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ParamListOuterClass.ParamListOrBuilder
        public List<Integer> getParamListList() {
            return this.paramList_;
        }

        @Override // emu.grasscutter.net.proto.ParamListOuterClass.ParamListOrBuilder
        public int getParamListCount() {
            return this.paramList_.size();
        }

        @Override // emu.grasscutter.net.proto.ParamListOuterClass.ParamListOrBuilder
        public int getParamList(int index) {
            return this.paramList_.getInt(index);
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
            if (getParamListList().size() > 0) {
                output.writeUInt32NoTag(10);
                output.writeUInt32NoTag(this.paramListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.paramList_.size(); i++) {
                output.writeUInt32NoTag(this.paramList_.getInt(i));
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.paramList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.paramList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getParamListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.paramListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ParamList)) {
                return equals(obj);
            }
            ParamList other = (ParamList) obj;
            return getParamListList().equals(other.getParamListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getParamListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getParamListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ParamList parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ParamList parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ParamList parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ParamList parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ParamList parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ParamList parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ParamList parseFrom(InputStream input) throws IOException {
            return (ParamList) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ParamList parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ParamList) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ParamList parseDelimitedFrom(InputStream input) throws IOException {
            return (ParamList) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ParamList parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ParamList) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ParamList parseFrom(CodedInputStream input) throws IOException {
            return (ParamList) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ParamList parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ParamList) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ParamList prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ParamListOuterClass$ParamList$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ParamListOrBuilder {
            private int bitField0_;
            private Internal.IntList paramList_ = ParamList.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ParamListOuterClass.internal_static_ParamList_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ParamListOuterClass.internal_static_ParamList_fieldAccessorTable.ensureFieldAccessorsInitialized(ParamList.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ParamList.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.paramList_ = ParamList.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ParamListOuterClass.internal_static_ParamList_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ParamList getDefaultInstanceForType() {
                return ParamList.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ParamList build() {
                ParamList result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ParamList buildPartial() {
                ParamList result = new ParamList(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.paramList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.paramList_ = this.paramList_;
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
                if (other instanceof ParamList) {
                    return mergeFrom((ParamList) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ParamList other) {
                if (other == ParamList.getDefaultInstance()) {
                    return this;
                }
                if (!other.paramList_.isEmpty()) {
                    if (this.paramList_.isEmpty()) {
                        this.paramList_ = other.paramList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureParamListIsMutable();
                        this.paramList_.addAll(other.paramList_);
                    }
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
                ParamList parsedMessage = null;
                try {
                    try {
                        parsedMessage = ParamList.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ParamList) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureParamListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.paramList_ = ParamList.mutableCopy(this.paramList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ParamListOuterClass.ParamListOrBuilder
            public List<Integer> getParamListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.paramList_) : this.paramList_;
            }

            @Override // emu.grasscutter.net.proto.ParamListOuterClass.ParamListOrBuilder
            public int getParamListCount() {
                return this.paramList_.size();
            }

            @Override // emu.grasscutter.net.proto.ParamListOuterClass.ParamListOrBuilder
            public int getParamList(int index) {
                return this.paramList_.getInt(index);
            }

            public Builder setParamList(int index, int value) {
                ensureParamListIsMutable();
                this.paramList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addParamList(int value) {
                ensureParamListIsMutable();
                this.paramList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllParamList(Iterable<? extends Integer> values) {
                ensureParamListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.paramList_);
                onChanged();
                return this;
            }

            public Builder clearParamList() {
                this.paramList_ = ParamList.emptyIntList();
                this.bitField0_ &= -2;
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

        public static ParamList getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ParamList> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ParamList> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ParamList getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
