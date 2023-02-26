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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryFilterOuterClass.class */
public final class QueryFilterOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011QueryFilter.proto\"/\n\u000bQueryFilter\u0012\u0010\n\bareaMask\u0018\t \u0001(\u0005\u0012\u000e\n\u0006typeId\u0018\u0003 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_QueryFilter_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_QueryFilter_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_QueryFilter_descriptor, new String[]{"AreaMask", "TypeId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryFilterOuterClass$QueryFilterOrBuilder.class */
    public interface QueryFilterOrBuilder extends MessageOrBuilder {
        int getAreaMask();

        int getTypeId();
    }

    private QueryFilterOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryFilterOuterClass$QueryFilter.class */
    public static final class QueryFilter extends GeneratedMessageV3 implements QueryFilterOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AREAMASK_FIELD_NUMBER = 9;
        private int areaMask_;
        public static final int TYPEID_FIELD_NUMBER = 3;
        private int typeId_;
        private byte memoizedIsInitialized;
        private static final QueryFilter DEFAULT_INSTANCE = new QueryFilter();
        private static final Parser<QueryFilter> PARSER = new AbstractParser<QueryFilter>() { // from class: emu.grasscutter.net.proto.QueryFilterOuterClass.QueryFilter.1
            @Override // com.google.protobuf.Parser
            public QueryFilter parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new QueryFilter(input, extensionRegistry);
            }
        };

        private QueryFilter(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private QueryFilter() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new QueryFilter();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QueryFilter(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.typeId_ = input.readInt32();
                                break;
                            case 72:
                                this.areaMask_ = input.readInt32();
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
            return QueryFilterOuterClass.internal_static_QueryFilter_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QueryFilterOuterClass.internal_static_QueryFilter_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryFilter.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.QueryFilterOuterClass.QueryFilterOrBuilder
        public int getAreaMask() {
            return this.areaMask_;
        }

        @Override // emu.grasscutter.net.proto.QueryFilterOuterClass.QueryFilterOrBuilder
        public int getTypeId() {
            return this.typeId_;
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
            if (this.typeId_ != 0) {
                output.writeInt32(3, this.typeId_);
            }
            if (this.areaMask_ != 0) {
                output.writeInt32(9, this.areaMask_);
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
            if (this.typeId_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(3, this.typeId_);
            }
            if (this.areaMask_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(9, this.areaMask_);
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
            if (!(obj instanceof QueryFilter)) {
                return equals(obj);
            }
            QueryFilter other = (QueryFilter) obj;
            return getAreaMask() == other.getAreaMask() && getTypeId() == other.getTypeId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getAreaMask())) + 3)) + getTypeId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static QueryFilter parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QueryFilter parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryFilter parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QueryFilter parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryFilter parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QueryFilter parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryFilter parseFrom(InputStream input) throws IOException {
            return (QueryFilter) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QueryFilter parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryFilter) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static QueryFilter parseDelimitedFrom(InputStream input) throws IOException {
            return (QueryFilter) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static QueryFilter parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryFilter) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static QueryFilter parseFrom(CodedInputStream input) throws IOException {
            return (QueryFilter) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QueryFilter parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryFilter) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QueryFilter prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryFilterOuterClass$QueryFilter$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QueryFilterOrBuilder {
            private int areaMask_;
            private int typeId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return QueryFilterOuterClass.internal_static_QueryFilter_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QueryFilterOuterClass.internal_static_QueryFilter_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryFilter.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (QueryFilter.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.areaMask_ = 0;
                this.typeId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QueryFilterOuterClass.internal_static_QueryFilter_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public QueryFilter getDefaultInstanceForType() {
                return QueryFilter.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QueryFilter build() {
                QueryFilter result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QueryFilter buildPartial() {
                QueryFilter result = new QueryFilter(this);
                result.areaMask_ = this.areaMask_;
                result.typeId_ = this.typeId_;
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
                if (other instanceof QueryFilter) {
                    return mergeFrom((QueryFilter) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(QueryFilter other) {
                if (other == QueryFilter.getDefaultInstance()) {
                    return this;
                }
                if (other.getAreaMask() != 0) {
                    setAreaMask(other.getAreaMask());
                }
                if (other.getTypeId() != 0) {
                    setTypeId(other.getTypeId());
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
                QueryFilter parsedMessage = null;
                try {
                    try {
                        parsedMessage = QueryFilter.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QueryFilter) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.QueryFilterOuterClass.QueryFilterOrBuilder
            public int getAreaMask() {
                return this.areaMask_;
            }

            public Builder setAreaMask(int value) {
                this.areaMask_ = value;
                onChanged();
                return this;
            }

            public Builder clearAreaMask() {
                this.areaMask_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QueryFilterOuterClass.QueryFilterOrBuilder
            public int getTypeId() {
                return this.typeId_;
            }

            public Builder setTypeId(int value) {
                this.typeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTypeId() {
                this.typeId_ = 0;
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

        public static QueryFilter getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QueryFilter> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<QueryFilter> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QueryFilter getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
