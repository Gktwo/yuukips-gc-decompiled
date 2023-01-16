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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryPathRspOuterClass.class */
public final class QueryPathRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012QueryPathRsp.proto\u001a\fVector.proto\"å\u0001\n\fQueryPathRsp\u00122\n\fquery_status\u0018\u0003 \u0001(\u000e2\u001c.QueryPathRsp.PathStatusType\u0012\u000f\n\u0007retcode\u0018\n \u0001(\u0005\u0012\u0010\n\bquery_id\u0018\b \u0001(\u0005\u0012\u0018\n\u0007corners\u0018\u0001 \u0003(\u000b2\u0007.Vector\"d\n\u000ePathStatusType\u0012\u0019\n\u0015PATH_STATUS_TYPE_FAIL\u0010��\u0012\u0019\n\u0015PATH_STATUS_TYPE_SUCC\u0010\u0001\u0012\u001c\n\u0018PATH_STATUS_TYPE_PARTIAL\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_QueryPathRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_QueryPathRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_QueryPathRsp_descriptor, new String[]{"QueryStatus", "Retcode", "QueryId", "Corners"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryPathRspOuterClass$QueryPathRspOrBuilder.class */
    public interface QueryPathRspOrBuilder extends MessageOrBuilder {
        int getQueryStatusValue();

        QueryPathRsp.PathStatusType getQueryStatus();

        int getRetcode();

        int getQueryId();

        List<VectorOuterClass.Vector> getCornersList();

        VectorOuterClass.Vector getCorners(int i);

        int getCornersCount();

        List<? extends VectorOuterClass.VectorOrBuilder> getCornersOrBuilderList();

        VectorOuterClass.VectorOrBuilder getCornersOrBuilder(int i);
    }

    private QueryPathRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryPathRspOuterClass$QueryPathRsp.class */
    public static final class QueryPathRsp extends GeneratedMessageV3 implements QueryPathRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int QUERY_STATUS_FIELD_NUMBER = 3;
        private int queryStatus_;
        public static final int RETCODE_FIELD_NUMBER = 10;
        private int retcode_;
        public static final int QUERY_ID_FIELD_NUMBER = 8;
        private int queryId_;
        public static final int CORNERS_FIELD_NUMBER = 1;
        private List<VectorOuterClass.Vector> corners_;
        private byte memoizedIsInitialized;
        private static final QueryPathRsp DEFAULT_INSTANCE = new QueryPathRsp();
        private static final Parser<QueryPathRsp> PARSER = new AbstractParser<QueryPathRsp>() { // from class: emu.grasscutter.net.proto.QueryPathRspOuterClass.QueryPathRsp.1
            @Override // com.google.protobuf.Parser
            public QueryPathRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new QueryPathRsp(input, extensionRegistry);
            }
        };

        private QueryPathRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private QueryPathRsp() {
            this.memoizedIsInitialized = -1;
            this.queryStatus_ = 0;
            this.corners_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new QueryPathRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QueryPathRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 10:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.corners_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.corners_.add((VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry));
                                break;
                            case 24:
                                this.queryStatus_ = input.readEnum();
                                break;
                            case 64:
                                this.queryId_ = input.readInt32();
                                break;
                            case 80:
                                this.retcode_ = input.readInt32();
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
                    this.corners_ = Collections.unmodifiableList(this.corners_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return QueryPathRspOuterClass.internal_static_QueryPathRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QueryPathRspOuterClass.internal_static_QueryPathRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryPathRsp.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryPathRspOuterClass$QueryPathRsp$PathStatusType.class */
        public enum PathStatusType implements ProtocolMessageEnum {
            PATH_STATUS_TYPE_FAIL(0),
            PATH_STATUS_TYPE_SUCC(1),
            PATH_STATUS_TYPE_PARTIAL(2),
            UNRECOGNIZED(-1);
            
            public static final int PATH_STATUS_TYPE_FAIL_VALUE = 0;
            public static final int PATH_STATUS_TYPE_SUCC_VALUE = 1;
            public static final int PATH_STATUS_TYPE_PARTIAL_VALUE = 2;
            private static final Internal.EnumLiteMap<PathStatusType> internalValueMap = new Internal.EnumLiteMap<PathStatusType>() { // from class: emu.grasscutter.net.proto.QueryPathRspOuterClass.QueryPathRsp.PathStatusType.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public PathStatusType findValueByNumber(int number) {
                    return PathStatusType.forNumber(number);
                }
            };
            private static final PathStatusType[] VALUES = values();
            private final int value;

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static PathStatusType valueOf(int value) {
                return forNumber(value);
            }

            public static PathStatusType forNumber(int value) {
                switch (value) {
                    case 0:
                        return PATH_STATUS_TYPE_FAIL;
                    case 1:
                        return PATH_STATUS_TYPE_SUCC;
                    case 2:
                        return PATH_STATUS_TYPE_PARTIAL;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<PathStatusType> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                if (this != UNRECOGNIZED) {
                    return getDescriptor().getValues().get(ordinal());
                }
                throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return QueryPathRsp.getDescriptor().getEnumTypes().get(0);
            }

            public static PathStatusType valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                } else if (desc.getIndex() == -1) {
                    return UNRECOGNIZED;
                } else {
                    return VALUES[desc.getIndex()];
                }
            }

            PathStatusType(int value) {
                this.value = value;
            }
        }

        @Override // emu.grasscutter.net.proto.QueryPathRspOuterClass.QueryPathRspOrBuilder
        public int getQueryStatusValue() {
            return this.queryStatus_;
        }

        @Override // emu.grasscutter.net.proto.QueryPathRspOuterClass.QueryPathRspOrBuilder
        public PathStatusType getQueryStatus() {
            PathStatusType result = PathStatusType.valueOf(this.queryStatus_);
            return result == null ? PathStatusType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.QueryPathRspOuterClass.QueryPathRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.QueryPathRspOuterClass.QueryPathRspOrBuilder
        public int getQueryId() {
            return this.queryId_;
        }

        @Override // emu.grasscutter.net.proto.QueryPathRspOuterClass.QueryPathRspOrBuilder
        public List<VectorOuterClass.Vector> getCornersList() {
            return this.corners_;
        }

        @Override // emu.grasscutter.net.proto.QueryPathRspOuterClass.QueryPathRspOrBuilder
        public List<? extends VectorOuterClass.VectorOrBuilder> getCornersOrBuilderList() {
            return this.corners_;
        }

        @Override // emu.grasscutter.net.proto.QueryPathRspOuterClass.QueryPathRspOrBuilder
        public int getCornersCount() {
            return this.corners_.size();
        }

        @Override // emu.grasscutter.net.proto.QueryPathRspOuterClass.QueryPathRspOrBuilder
        public VectorOuterClass.Vector getCorners(int index) {
            return this.corners_.get(index);
        }

        @Override // emu.grasscutter.net.proto.QueryPathRspOuterClass.QueryPathRspOrBuilder
        public VectorOuterClass.VectorOrBuilder getCornersOrBuilder(int index) {
            return this.corners_.get(index);
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
            for (int i = 0; i < this.corners_.size(); i++) {
                output.writeMessage(1, this.corners_.get(i));
            }
            if (this.queryStatus_ != PathStatusType.PATH_STATUS_TYPE_FAIL.getNumber()) {
                output.writeEnum(3, this.queryStatus_);
            }
            if (this.queryId_ != 0) {
                output.writeInt32(8, this.queryId_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(10, this.retcode_);
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
            for (int i = 0; i < this.corners_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.corners_.get(i));
            }
            if (this.queryStatus_ != PathStatusType.PATH_STATUS_TYPE_FAIL.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(3, this.queryStatus_);
            }
            if (this.queryId_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(8, this.queryId_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(10, this.retcode_);
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
            if (!(obj instanceof QueryPathRsp)) {
                return equals(obj);
            }
            QueryPathRsp other = (QueryPathRsp) obj;
            return this.queryStatus_ == other.queryStatus_ && getRetcode() == other.getRetcode() && getQueryId() == other.getQueryId() && getCornersList().equals(other.getCornersList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + this.queryStatus_)) + 10)) + getRetcode())) + 8)) + getQueryId();
            if (getCornersCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getCornersList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static QueryPathRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QueryPathRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryPathRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QueryPathRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryPathRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QueryPathRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryPathRsp parseFrom(InputStream input) throws IOException {
            return (QueryPathRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QueryPathRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryPathRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static QueryPathRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (QueryPathRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static QueryPathRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryPathRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static QueryPathRsp parseFrom(CodedInputStream input) throws IOException {
            return (QueryPathRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QueryPathRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryPathRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QueryPathRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryPathRspOuterClass$QueryPathRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QueryPathRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private int queryId_;
            private RepeatedFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> cornersBuilder_;
            private int queryStatus_ = 0;
            private List<VectorOuterClass.Vector> corners_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return QueryPathRspOuterClass.internal_static_QueryPathRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QueryPathRspOuterClass.internal_static_QueryPathRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryPathRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (QueryPathRsp.alwaysUseFieldBuilders) {
                    getCornersFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.queryStatus_ = 0;
                this.retcode_ = 0;
                this.queryId_ = 0;
                if (this.cornersBuilder_ == null) {
                    this.corners_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.cornersBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QueryPathRspOuterClass.internal_static_QueryPathRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public QueryPathRsp getDefaultInstanceForType() {
                return QueryPathRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QueryPathRsp build() {
                QueryPathRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QueryPathRsp buildPartial() {
                QueryPathRsp result = new QueryPathRsp(this);
                int i = this.bitField0_;
                result.queryStatus_ = this.queryStatus_;
                result.retcode_ = this.retcode_;
                result.queryId_ = this.queryId_;
                if (this.cornersBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.corners_ = Collections.unmodifiableList(this.corners_);
                        this.bitField0_ &= -2;
                    }
                    result.corners_ = this.corners_;
                } else {
                    result.corners_ = this.cornersBuilder_.build();
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
                if (other instanceof QueryPathRsp) {
                    return mergeFrom((QueryPathRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(QueryPathRsp other) {
                if (other == QueryPathRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.queryStatus_ != 0) {
                    setQueryStatusValue(other.getQueryStatusValue());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getQueryId() != 0) {
                    setQueryId(other.getQueryId());
                }
                if (this.cornersBuilder_ == null) {
                    if (!other.corners_.isEmpty()) {
                        if (this.corners_.isEmpty()) {
                            this.corners_ = other.corners_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureCornersIsMutable();
                            this.corners_.addAll(other.corners_);
                        }
                        onChanged();
                    }
                } else if (!other.corners_.isEmpty()) {
                    if (this.cornersBuilder_.isEmpty()) {
                        this.cornersBuilder_.dispose();
                        this.cornersBuilder_ = null;
                        this.corners_ = other.corners_;
                        this.bitField0_ &= -2;
                        this.cornersBuilder_ = QueryPathRsp.alwaysUseFieldBuilders ? getCornersFieldBuilder() : null;
                    } else {
                        this.cornersBuilder_.addAllMessages(other.corners_);
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
                QueryPathRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = QueryPathRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QueryPathRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.QueryPathRspOuterClass.QueryPathRspOrBuilder
            public int getQueryStatusValue() {
                return this.queryStatus_;
            }

            public Builder setQueryStatusValue(int value) {
                this.queryStatus_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QueryPathRspOuterClass.QueryPathRspOrBuilder
            public PathStatusType getQueryStatus() {
                PathStatusType result = PathStatusType.valueOf(this.queryStatus_);
                return result == null ? PathStatusType.UNRECOGNIZED : result;
            }

            public Builder setQueryStatus(PathStatusType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.queryStatus_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearQueryStatus() {
                this.queryStatus_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QueryPathRspOuterClass.QueryPathRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QueryPathRspOuterClass.QueryPathRspOrBuilder
            public int getQueryId() {
                return this.queryId_;
            }

            public Builder setQueryId(int value) {
                this.queryId_ = value;
                onChanged();
                return this;
            }

            public Builder clearQueryId() {
                this.queryId_ = 0;
                onChanged();
                return this;
            }

            private void ensureCornersIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.corners_ = new ArrayList(this.corners_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.QueryPathRspOuterClass.QueryPathRspOrBuilder
            public List<VectorOuterClass.Vector> getCornersList() {
                if (this.cornersBuilder_ == null) {
                    return Collections.unmodifiableList(this.corners_);
                }
                return this.cornersBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.QueryPathRspOuterClass.QueryPathRspOrBuilder
            public int getCornersCount() {
                if (this.cornersBuilder_ == null) {
                    return this.corners_.size();
                }
                return this.cornersBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.QueryPathRspOuterClass.QueryPathRspOrBuilder
            public VectorOuterClass.Vector getCorners(int index) {
                if (this.cornersBuilder_ == null) {
                    return this.corners_.get(index);
                }
                return this.cornersBuilder_.getMessage(index);
            }

            public Builder setCorners(int index, VectorOuterClass.Vector value) {
                if (this.cornersBuilder_ != null) {
                    this.cornersBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCornersIsMutable();
                    this.corners_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setCorners(int index, VectorOuterClass.Vector.Builder builderForValue) {
                if (this.cornersBuilder_ == null) {
                    ensureCornersIsMutable();
                    this.corners_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.cornersBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addCorners(VectorOuterClass.Vector value) {
                if (this.cornersBuilder_ != null) {
                    this.cornersBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCornersIsMutable();
                    this.corners_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addCorners(int index, VectorOuterClass.Vector value) {
                if (this.cornersBuilder_ != null) {
                    this.cornersBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCornersIsMutable();
                    this.corners_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addCorners(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.cornersBuilder_ == null) {
                    ensureCornersIsMutable();
                    this.corners_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.cornersBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addCorners(int index, VectorOuterClass.Vector.Builder builderForValue) {
                if (this.cornersBuilder_ == null) {
                    ensureCornersIsMutable();
                    this.corners_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.cornersBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllCorners(Iterable<? extends VectorOuterClass.Vector> values) {
                if (this.cornersBuilder_ == null) {
                    ensureCornersIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.corners_);
                    onChanged();
                } else {
                    this.cornersBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearCorners() {
                if (this.cornersBuilder_ == null) {
                    this.corners_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.cornersBuilder_.clear();
                }
                return this;
            }

            public Builder removeCorners(int index) {
                if (this.cornersBuilder_ == null) {
                    ensureCornersIsMutable();
                    this.corners_.remove(index);
                    onChanged();
                } else {
                    this.cornersBuilder_.remove(index);
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getCornersBuilder(int index) {
                return getCornersFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.QueryPathRspOuterClass.QueryPathRspOrBuilder
            public VectorOuterClass.VectorOrBuilder getCornersOrBuilder(int index) {
                if (this.cornersBuilder_ == null) {
                    return this.corners_.get(index);
                }
                return this.cornersBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.QueryPathRspOuterClass.QueryPathRspOrBuilder
            public List<? extends VectorOuterClass.VectorOrBuilder> getCornersOrBuilderList() {
                if (this.cornersBuilder_ != null) {
                    return this.cornersBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.corners_);
            }

            public VectorOuterClass.Vector.Builder addCornersBuilder() {
                return getCornersFieldBuilder().addBuilder(VectorOuterClass.Vector.getDefaultInstance());
            }

            public VectorOuterClass.Vector.Builder addCornersBuilder(int index) {
                return getCornersFieldBuilder().addBuilder(index, VectorOuterClass.Vector.getDefaultInstance());
            }

            public List<VectorOuterClass.Vector.Builder> getCornersBuilderList() {
                return getCornersFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getCornersFieldBuilder() {
                if (this.cornersBuilder_ == null) {
                    this.cornersBuilder_ = new RepeatedFieldBuilderV3<>(this.corners_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.corners_ = null;
                }
                return this.cornersBuilder_;
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

        public static QueryPathRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QueryPathRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<QueryPathRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QueryPathRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VectorOuterClass.getDescriptor();
    }
}
