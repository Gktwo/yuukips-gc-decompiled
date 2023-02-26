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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.OptionTypeOuterClass;
import emu.grasscutter.net.proto.QueryFilterOuterClass;
import emu.grasscutter.net.proto.Vector3IntOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryPathReqOuterClass.class */
public final class QueryPathReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012QueryPathReq.proto\u001a\u0010Vector3Int.proto\u001a\u0010OptionType.proto\u001a\u0011QueryFilter.proto\u001a\fVector.proto\"ÿ\u0001\n\fQueryPathReq\u0012\u000f\n\u0007queryId\u0018\r \u0001(\u0005\u0012\u001f\n\u000edestinationPos\u0018\u0004 \u0003(\u000b2\u0007.Vector\u0012(\n\u0013Unk3300_LHNGPJFOMIK\u0018\u0005 \u0001(\u000b2\u000b.Vector3Int\u0012\u001e\n\tqueryType\u0018\f \u0001(\u000e2\u000b.OptionType\u0012\u001c\n\u0006filter\u0018\u0002 \u0001(\u000b2\f.QueryFilter\u0012(\n\u0013Unk3300_CLGJBBJDOLN\u0018\u000f \u0001(\u000b2\u000b.Vector3Int\u0012\u000f\n\u0007sceneId\u0018\u0007 \u0001(\r\u0012\u001a\n\tsourcePos\u0018\n \u0001(\u000b2\u0007.VectorB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{Vector3IntOuterClass.getDescriptor(), OptionTypeOuterClass.getDescriptor(), QueryFilterOuterClass.getDescriptor(), VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_QueryPathReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_QueryPathReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_QueryPathReq_descriptor, new String[]{"QueryId", "DestinationPos", "Unk3300LHNGPJFOMIK", "QueryType", "Filter", "Unk3300CLGJBBJDOLN", "SceneId", "SourcePos"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryPathReqOuterClass$QueryPathReqOrBuilder.class */
    public interface QueryPathReqOrBuilder extends MessageOrBuilder {
        int getQueryId();

        List<VectorOuterClass.Vector> getDestinationPosList();

        VectorOuterClass.Vector getDestinationPos(int i);

        int getDestinationPosCount();

        List<? extends VectorOuterClass.VectorOrBuilder> getDestinationPosOrBuilderList();

        VectorOuterClass.VectorOrBuilder getDestinationPosOrBuilder(int i);

        boolean hasUnk3300LHNGPJFOMIK();

        Vector3IntOuterClass.Vector3Int getUnk3300LHNGPJFOMIK();

        Vector3IntOuterClass.Vector3IntOrBuilder getUnk3300LHNGPJFOMIKOrBuilder();

        int getQueryTypeValue();

        OptionTypeOuterClass.OptionType getQueryType();

        boolean hasFilter();

        QueryFilterOuterClass.QueryFilter getFilter();

        QueryFilterOuterClass.QueryFilterOrBuilder getFilterOrBuilder();

        boolean hasUnk3300CLGJBBJDOLN();

        Vector3IntOuterClass.Vector3Int getUnk3300CLGJBBJDOLN();

        Vector3IntOuterClass.Vector3IntOrBuilder getUnk3300CLGJBBJDOLNOrBuilder();

        int getSceneId();

        boolean hasSourcePos();

        VectorOuterClass.Vector getSourcePos();

        VectorOuterClass.VectorOrBuilder getSourcePosOrBuilder();
    }

    private QueryPathReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryPathReqOuterClass$QueryPathReq.class */
    public static final class QueryPathReq extends GeneratedMessageV3 implements QueryPathReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int QUERYID_FIELD_NUMBER = 13;
        private int queryId_;
        public static final int DESTINATIONPOS_FIELD_NUMBER = 4;
        private List<VectorOuterClass.Vector> destinationPos_;
        public static final int UNK3300_LHNGPJFOMIK_FIELD_NUMBER = 5;
        private Vector3IntOuterClass.Vector3Int unk3300LHNGPJFOMIK_;
        public static final int QUERYTYPE_FIELD_NUMBER = 12;
        private int queryType_;
        public static final int FILTER_FIELD_NUMBER = 2;
        private QueryFilterOuterClass.QueryFilter filter_;
        public static final int UNK3300_CLGJBBJDOLN_FIELD_NUMBER = 15;
        private Vector3IntOuterClass.Vector3Int unk3300CLGJBBJDOLN_;
        public static final int SCENEID_FIELD_NUMBER = 7;
        private int sceneId_;
        public static final int SOURCEPOS_FIELD_NUMBER = 10;
        private VectorOuterClass.Vector sourcePos_;
        private byte memoizedIsInitialized;
        private static final QueryPathReq DEFAULT_INSTANCE = new QueryPathReq();
        private static final Parser<QueryPathReq> PARSER = new AbstractParser<QueryPathReq>() { // from class: emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReq.1
            @Override // com.google.protobuf.Parser
            public QueryPathReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new QueryPathReq(input, extensionRegistry);
            }
        };

        private QueryPathReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private QueryPathReq() {
            this.memoizedIsInitialized = -1;
            this.destinationPos_ = Collections.emptyList();
            this.queryType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new QueryPathReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QueryPathReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 18:
                                    QueryFilterOuterClass.QueryFilter.Builder subBuilder = this.filter_ != null ? this.filter_.toBuilder() : null;
                                    this.filter_ = (QueryFilterOuterClass.QueryFilter) input.readMessage(QueryFilterOuterClass.QueryFilter.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.filter_);
                                        this.filter_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 34:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.destinationPos_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.destinationPos_.add((VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry));
                                    break;
                                case 42:
                                    Vector3IntOuterClass.Vector3Int.Builder subBuilder2 = this.unk3300LHNGPJFOMIK_ != null ? this.unk3300LHNGPJFOMIK_.toBuilder() : null;
                                    this.unk3300LHNGPJFOMIK_ = (Vector3IntOuterClass.Vector3Int) input.readMessage(Vector3IntOuterClass.Vector3Int.parser(), extensionRegistry);
                                    if (subBuilder2 == null) {
                                        break;
                                    } else {
                                        subBuilder2.mergeFrom(this.unk3300LHNGPJFOMIK_);
                                        this.unk3300LHNGPJFOMIK_ = subBuilder2.buildPartial();
                                        break;
                                    }
                                case 56:
                                    this.sceneId_ = input.readUInt32();
                                    break;
                                case 82:
                                    VectorOuterClass.Vector.Builder subBuilder3 = this.sourcePos_ != null ? this.sourcePos_.toBuilder() : null;
                                    this.sourcePos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder3 == null) {
                                        break;
                                    } else {
                                        subBuilder3.mergeFrom(this.sourcePos_);
                                        this.sourcePos_ = subBuilder3.buildPartial();
                                        break;
                                    }
                                case 96:
                                    this.queryType_ = input.readEnum();
                                    break;
                                case 104:
                                    this.queryId_ = input.readInt32();
                                    break;
                                case 122:
                                    Vector3IntOuterClass.Vector3Int.Builder subBuilder4 = this.unk3300CLGJBBJDOLN_ != null ? this.unk3300CLGJBBJDOLN_.toBuilder() : null;
                                    this.unk3300CLGJBBJDOLN_ = (Vector3IntOuterClass.Vector3Int) input.readMessage(Vector3IntOuterClass.Vector3Int.parser(), extensionRegistry);
                                    if (subBuilder4 == null) {
                                        break;
                                    } else {
                                        subBuilder4.mergeFrom(this.unk3300CLGJBBJDOLN_);
                                        this.unk3300CLGJBBJDOLN_ = subBuilder4.buildPartial();
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
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.destinationPos_ = Collections.unmodifiableList(this.destinationPos_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return QueryPathReqOuterClass.internal_static_QueryPathReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QueryPathReqOuterClass.internal_static_QueryPathReq_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryPathReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
        public int getQueryId() {
            return this.queryId_;
        }

        @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
        public List<VectorOuterClass.Vector> getDestinationPosList() {
            return this.destinationPos_;
        }

        @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
        public List<? extends VectorOuterClass.VectorOrBuilder> getDestinationPosOrBuilderList() {
            return this.destinationPos_;
        }

        @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
        public int getDestinationPosCount() {
            return this.destinationPos_.size();
        }

        @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
        public VectorOuterClass.Vector getDestinationPos(int index) {
            return this.destinationPos_.get(index);
        }

        @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
        public VectorOuterClass.VectorOrBuilder getDestinationPosOrBuilder(int index) {
            return this.destinationPos_.get(index);
        }

        @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
        public boolean hasUnk3300LHNGPJFOMIK() {
            return this.unk3300LHNGPJFOMIK_ != null;
        }

        @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
        public Vector3IntOuterClass.Vector3Int getUnk3300LHNGPJFOMIK() {
            return this.unk3300LHNGPJFOMIK_ == null ? Vector3IntOuterClass.Vector3Int.getDefaultInstance() : this.unk3300LHNGPJFOMIK_;
        }

        @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
        public Vector3IntOuterClass.Vector3IntOrBuilder getUnk3300LHNGPJFOMIKOrBuilder() {
            return getUnk3300LHNGPJFOMIK();
        }

        @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
        public int getQueryTypeValue() {
            return this.queryType_;
        }

        @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
        public OptionTypeOuterClass.OptionType getQueryType() {
            OptionTypeOuterClass.OptionType result = OptionTypeOuterClass.OptionType.valueOf(this.queryType_);
            return result == null ? OptionTypeOuterClass.OptionType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
        public boolean hasFilter() {
            return this.filter_ != null;
        }

        @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
        public QueryFilterOuterClass.QueryFilter getFilter() {
            return this.filter_ == null ? QueryFilterOuterClass.QueryFilter.getDefaultInstance() : this.filter_;
        }

        @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
        public QueryFilterOuterClass.QueryFilterOrBuilder getFilterOrBuilder() {
            return getFilter();
        }

        @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
        public boolean hasUnk3300CLGJBBJDOLN() {
            return this.unk3300CLGJBBJDOLN_ != null;
        }

        @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
        public Vector3IntOuterClass.Vector3Int getUnk3300CLGJBBJDOLN() {
            return this.unk3300CLGJBBJDOLN_ == null ? Vector3IntOuterClass.Vector3Int.getDefaultInstance() : this.unk3300CLGJBBJDOLN_;
        }

        @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
        public Vector3IntOuterClass.Vector3IntOrBuilder getUnk3300CLGJBBJDOLNOrBuilder() {
            return getUnk3300CLGJBBJDOLN();
        }

        @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
        public int getSceneId() {
            return this.sceneId_;
        }

        @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
        public boolean hasSourcePos() {
            return this.sourcePos_ != null;
        }

        @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
        public VectorOuterClass.Vector getSourcePos() {
            return this.sourcePos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.sourcePos_;
        }

        @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
        public VectorOuterClass.VectorOrBuilder getSourcePosOrBuilder() {
            return getSourcePos();
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
            if (this.filter_ != null) {
                output.writeMessage(2, getFilter());
            }
            for (int i = 0; i < this.destinationPos_.size(); i++) {
                output.writeMessage(4, this.destinationPos_.get(i));
            }
            if (this.unk3300LHNGPJFOMIK_ != null) {
                output.writeMessage(5, getUnk3300LHNGPJFOMIK());
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(7, this.sceneId_);
            }
            if (this.sourcePos_ != null) {
                output.writeMessage(10, getSourcePos());
            }
            if (this.queryType_ != OptionTypeOuterClass.OptionType.OPTION_TYPE_NONE.getNumber()) {
                output.writeEnum(12, this.queryType_);
            }
            if (this.queryId_ != 0) {
                output.writeInt32(13, this.queryId_);
            }
            if (this.unk3300CLGJBBJDOLN_ != null) {
                output.writeMessage(15, getUnk3300CLGJBBJDOLN());
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
            if (this.filter_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(2, getFilter());
            }
            for (int i = 0; i < this.destinationPos_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.destinationPos_.get(i));
            }
            if (this.unk3300LHNGPJFOMIK_ != null) {
                size2 += CodedOutputStream.computeMessageSize(5, getUnk3300LHNGPJFOMIK());
            }
            if (this.sceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.sceneId_);
            }
            if (this.sourcePos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(10, getSourcePos());
            }
            if (this.queryType_ != OptionTypeOuterClass.OptionType.OPTION_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(12, this.queryType_);
            }
            if (this.queryId_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(13, this.queryId_);
            }
            if (this.unk3300CLGJBBJDOLN_ != null) {
                size2 += CodedOutputStream.computeMessageSize(15, getUnk3300CLGJBBJDOLN());
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
            if (!(obj instanceof QueryPathReq)) {
                return equals(obj);
            }
            QueryPathReq other = (QueryPathReq) obj;
            if (getQueryId() != other.getQueryId() || !getDestinationPosList().equals(other.getDestinationPosList()) || hasUnk3300LHNGPJFOMIK() != other.hasUnk3300LHNGPJFOMIK()) {
                return false;
            }
            if ((hasUnk3300LHNGPJFOMIK() && !getUnk3300LHNGPJFOMIK().equals(other.getUnk3300LHNGPJFOMIK())) || this.queryType_ != other.queryType_ || hasFilter() != other.hasFilter()) {
                return false;
            }
            if ((hasFilter() && !getFilter().equals(other.getFilter())) || hasUnk3300CLGJBBJDOLN() != other.hasUnk3300CLGJBBJDOLN()) {
                return false;
            }
            if ((!hasUnk3300CLGJBBJDOLN() || getUnk3300CLGJBBJDOLN().equals(other.getUnk3300CLGJBBJDOLN())) && getSceneId() == other.getSceneId() && hasSourcePos() == other.hasSourcePos()) {
                return (!hasSourcePos() || getSourcePos().equals(other.getSourcePos())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + getQueryId();
            if (getDestinationPosCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getDestinationPosList().hashCode();
            }
            if (hasUnk3300LHNGPJFOMIK()) {
                hash = (53 * ((37 * hash) + 5)) + getUnk3300LHNGPJFOMIK().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 12)) + this.queryType_;
            if (hasFilter()) {
                hash2 = (53 * ((37 * hash2) + 2)) + getFilter().hashCode();
            }
            if (hasUnk3300CLGJBBJDOLN()) {
                hash2 = (53 * ((37 * hash2) + 15)) + getUnk3300CLGJBBJDOLN().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 7)) + getSceneId();
            if (hasSourcePos()) {
                hash3 = (53 * ((37 * hash3) + 10)) + getSourcePos().hashCode();
            }
            int hash4 = (29 * hash3) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static QueryPathReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QueryPathReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryPathReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QueryPathReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryPathReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QueryPathReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryPathReq parseFrom(InputStream input) throws IOException {
            return (QueryPathReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QueryPathReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryPathReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static QueryPathReq parseDelimitedFrom(InputStream input) throws IOException {
            return (QueryPathReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static QueryPathReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryPathReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static QueryPathReq parseFrom(CodedInputStream input) throws IOException {
            return (QueryPathReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QueryPathReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryPathReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QueryPathReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryPathReqOuterClass$QueryPathReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QueryPathReqOrBuilder {
            private int bitField0_;
            private int queryId_;
            private RepeatedFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> destinationPosBuilder_;
            private Vector3IntOuterClass.Vector3Int unk3300LHNGPJFOMIK_;
            private SingleFieldBuilderV3<Vector3IntOuterClass.Vector3Int, Vector3IntOuterClass.Vector3Int.Builder, Vector3IntOuterClass.Vector3IntOrBuilder> unk3300LHNGPJFOMIKBuilder_;
            private QueryFilterOuterClass.QueryFilter filter_;
            private SingleFieldBuilderV3<QueryFilterOuterClass.QueryFilter, QueryFilterOuterClass.QueryFilter.Builder, QueryFilterOuterClass.QueryFilterOrBuilder> filterBuilder_;
            private Vector3IntOuterClass.Vector3Int unk3300CLGJBBJDOLN_;
            private SingleFieldBuilderV3<Vector3IntOuterClass.Vector3Int, Vector3IntOuterClass.Vector3Int.Builder, Vector3IntOuterClass.Vector3IntOrBuilder> unk3300CLGJBBJDOLNBuilder_;
            private int sceneId_;
            private VectorOuterClass.Vector sourcePos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> sourcePosBuilder_;
            private List<VectorOuterClass.Vector> destinationPos_ = Collections.emptyList();
            private int queryType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return QueryPathReqOuterClass.internal_static_QueryPathReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QueryPathReqOuterClass.internal_static_QueryPathReq_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryPathReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (QueryPathReq.alwaysUseFieldBuilders) {
                    getDestinationPosFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.queryId_ = 0;
                if (this.destinationPosBuilder_ == null) {
                    this.destinationPos_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.destinationPosBuilder_.clear();
                }
                if (this.unk3300LHNGPJFOMIKBuilder_ == null) {
                    this.unk3300LHNGPJFOMIK_ = null;
                } else {
                    this.unk3300LHNGPJFOMIK_ = null;
                    this.unk3300LHNGPJFOMIKBuilder_ = null;
                }
                this.queryType_ = 0;
                if (this.filterBuilder_ == null) {
                    this.filter_ = null;
                } else {
                    this.filter_ = null;
                    this.filterBuilder_ = null;
                }
                if (this.unk3300CLGJBBJDOLNBuilder_ == null) {
                    this.unk3300CLGJBBJDOLN_ = null;
                } else {
                    this.unk3300CLGJBBJDOLN_ = null;
                    this.unk3300CLGJBBJDOLNBuilder_ = null;
                }
                this.sceneId_ = 0;
                if (this.sourcePosBuilder_ == null) {
                    this.sourcePos_ = null;
                } else {
                    this.sourcePos_ = null;
                    this.sourcePosBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QueryPathReqOuterClass.internal_static_QueryPathReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public QueryPathReq getDefaultInstanceForType() {
                return QueryPathReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QueryPathReq build() {
                QueryPathReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QueryPathReq buildPartial() {
                QueryPathReq result = new QueryPathReq(this);
                int i = this.bitField0_;
                result.queryId_ = this.queryId_;
                if (this.destinationPosBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.destinationPos_ = Collections.unmodifiableList(this.destinationPos_);
                        this.bitField0_ &= -2;
                    }
                    result.destinationPos_ = this.destinationPos_;
                } else {
                    result.destinationPos_ = this.destinationPosBuilder_.build();
                }
                if (this.unk3300LHNGPJFOMIKBuilder_ == null) {
                    result.unk3300LHNGPJFOMIK_ = this.unk3300LHNGPJFOMIK_;
                } else {
                    result.unk3300LHNGPJFOMIK_ = this.unk3300LHNGPJFOMIKBuilder_.build();
                }
                result.queryType_ = this.queryType_;
                if (this.filterBuilder_ == null) {
                    result.filter_ = this.filter_;
                } else {
                    result.filter_ = this.filterBuilder_.build();
                }
                if (this.unk3300CLGJBBJDOLNBuilder_ == null) {
                    result.unk3300CLGJBBJDOLN_ = this.unk3300CLGJBBJDOLN_;
                } else {
                    result.unk3300CLGJBBJDOLN_ = this.unk3300CLGJBBJDOLNBuilder_.build();
                }
                result.sceneId_ = this.sceneId_;
                if (this.sourcePosBuilder_ == null) {
                    result.sourcePos_ = this.sourcePos_;
                } else {
                    result.sourcePos_ = this.sourcePosBuilder_.build();
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
                if (other instanceof QueryPathReq) {
                    return mergeFrom((QueryPathReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(QueryPathReq other) {
                if (other == QueryPathReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getQueryId() != 0) {
                    setQueryId(other.getQueryId());
                }
                if (this.destinationPosBuilder_ == null) {
                    if (!other.destinationPos_.isEmpty()) {
                        if (this.destinationPos_.isEmpty()) {
                            this.destinationPos_ = other.destinationPos_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDestinationPosIsMutable();
                            this.destinationPos_.addAll(other.destinationPos_);
                        }
                        onChanged();
                    }
                } else if (!other.destinationPos_.isEmpty()) {
                    if (this.destinationPosBuilder_.isEmpty()) {
                        this.destinationPosBuilder_.dispose();
                        this.destinationPosBuilder_ = null;
                        this.destinationPos_ = other.destinationPos_;
                        this.bitField0_ &= -2;
                        this.destinationPosBuilder_ = QueryPathReq.alwaysUseFieldBuilders ? getDestinationPosFieldBuilder() : null;
                    } else {
                        this.destinationPosBuilder_.addAllMessages(other.destinationPos_);
                    }
                }
                if (other.hasUnk3300LHNGPJFOMIK()) {
                    mergeUnk3300LHNGPJFOMIK(other.getUnk3300LHNGPJFOMIK());
                }
                if (other.queryType_ != 0) {
                    setQueryTypeValue(other.getQueryTypeValue());
                }
                if (other.hasFilter()) {
                    mergeFilter(other.getFilter());
                }
                if (other.hasUnk3300CLGJBBJDOLN()) {
                    mergeUnk3300CLGJBBJDOLN(other.getUnk3300CLGJBBJDOLN());
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
                }
                if (other.hasSourcePos()) {
                    mergeSourcePos(other.getSourcePos());
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
                QueryPathReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = QueryPathReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QueryPathReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
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

            private void ensureDestinationPosIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.destinationPos_ = new ArrayList(this.destinationPos_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
            public List<VectorOuterClass.Vector> getDestinationPosList() {
                if (this.destinationPosBuilder_ == null) {
                    return Collections.unmodifiableList(this.destinationPos_);
                }
                return this.destinationPosBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
            public int getDestinationPosCount() {
                if (this.destinationPosBuilder_ == null) {
                    return this.destinationPos_.size();
                }
                return this.destinationPosBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
            public VectorOuterClass.Vector getDestinationPos(int index) {
                if (this.destinationPosBuilder_ == null) {
                    return this.destinationPos_.get(index);
                }
                return this.destinationPosBuilder_.getMessage(index);
            }

            public Builder setDestinationPos(int index, VectorOuterClass.Vector value) {
                if (this.destinationPosBuilder_ != null) {
                    this.destinationPosBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDestinationPosIsMutable();
                    this.destinationPos_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDestinationPos(int index, VectorOuterClass.Vector.Builder builderForValue) {
                if (this.destinationPosBuilder_ == null) {
                    ensureDestinationPosIsMutable();
                    this.destinationPos_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.destinationPosBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDestinationPos(VectorOuterClass.Vector value) {
                if (this.destinationPosBuilder_ != null) {
                    this.destinationPosBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDestinationPosIsMutable();
                    this.destinationPos_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDestinationPos(int index, VectorOuterClass.Vector value) {
                if (this.destinationPosBuilder_ != null) {
                    this.destinationPosBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDestinationPosIsMutable();
                    this.destinationPos_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDestinationPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.destinationPosBuilder_ == null) {
                    ensureDestinationPosIsMutable();
                    this.destinationPos_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.destinationPosBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDestinationPos(int index, VectorOuterClass.Vector.Builder builderForValue) {
                if (this.destinationPosBuilder_ == null) {
                    ensureDestinationPosIsMutable();
                    this.destinationPos_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.destinationPosBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDestinationPos(Iterable<? extends VectorOuterClass.Vector> values) {
                if (this.destinationPosBuilder_ == null) {
                    ensureDestinationPosIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.destinationPos_);
                    onChanged();
                } else {
                    this.destinationPosBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDestinationPos() {
                if (this.destinationPosBuilder_ == null) {
                    this.destinationPos_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.destinationPosBuilder_.clear();
                }
                return this;
            }

            public Builder removeDestinationPos(int index) {
                if (this.destinationPosBuilder_ == null) {
                    ensureDestinationPosIsMutable();
                    this.destinationPos_.remove(index);
                    onChanged();
                } else {
                    this.destinationPosBuilder_.remove(index);
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getDestinationPosBuilder(int index) {
                return getDestinationPosFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
            public VectorOuterClass.VectorOrBuilder getDestinationPosOrBuilder(int index) {
                if (this.destinationPosBuilder_ == null) {
                    return this.destinationPos_.get(index);
                }
                return this.destinationPosBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
            public List<? extends VectorOuterClass.VectorOrBuilder> getDestinationPosOrBuilderList() {
                if (this.destinationPosBuilder_ != null) {
                    return this.destinationPosBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.destinationPos_);
            }

            public VectorOuterClass.Vector.Builder addDestinationPosBuilder() {
                return getDestinationPosFieldBuilder().addBuilder(VectorOuterClass.Vector.getDefaultInstance());
            }

            public VectorOuterClass.Vector.Builder addDestinationPosBuilder(int index) {
                return getDestinationPosFieldBuilder().addBuilder(index, VectorOuterClass.Vector.getDefaultInstance());
            }

            public List<VectorOuterClass.Vector.Builder> getDestinationPosBuilderList() {
                return getDestinationPosFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getDestinationPosFieldBuilder() {
                if (this.destinationPosBuilder_ == null) {
                    this.destinationPosBuilder_ = new RepeatedFieldBuilderV3<>(this.destinationPos_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.destinationPos_ = null;
                }
                return this.destinationPosBuilder_;
            }

            @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
            public boolean hasUnk3300LHNGPJFOMIK() {
                return (this.unk3300LHNGPJFOMIKBuilder_ == null && this.unk3300LHNGPJFOMIK_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
            public Vector3IntOuterClass.Vector3Int getUnk3300LHNGPJFOMIK() {
                if (this.unk3300LHNGPJFOMIKBuilder_ == null) {
                    return this.unk3300LHNGPJFOMIK_ == null ? Vector3IntOuterClass.Vector3Int.getDefaultInstance() : this.unk3300LHNGPJFOMIK_;
                }
                return this.unk3300LHNGPJFOMIKBuilder_.getMessage();
            }

            public Builder setUnk3300LHNGPJFOMIK(Vector3IntOuterClass.Vector3Int value) {
                if (this.unk3300LHNGPJFOMIKBuilder_ != null) {
                    this.unk3300LHNGPJFOMIKBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.unk3300LHNGPJFOMIK_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setUnk3300LHNGPJFOMIK(Vector3IntOuterClass.Vector3Int.Builder builderForValue) {
                if (this.unk3300LHNGPJFOMIKBuilder_ == null) {
                    this.unk3300LHNGPJFOMIK_ = builderForValue.build();
                    onChanged();
                } else {
                    this.unk3300LHNGPJFOMIKBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeUnk3300LHNGPJFOMIK(Vector3IntOuterClass.Vector3Int value) {
                if (this.unk3300LHNGPJFOMIKBuilder_ == null) {
                    if (this.unk3300LHNGPJFOMIK_ != null) {
                        this.unk3300LHNGPJFOMIK_ = Vector3IntOuterClass.Vector3Int.newBuilder(this.unk3300LHNGPJFOMIK_).mergeFrom(value).buildPartial();
                    } else {
                        this.unk3300LHNGPJFOMIK_ = value;
                    }
                    onChanged();
                } else {
                    this.unk3300LHNGPJFOMIKBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearUnk3300LHNGPJFOMIK() {
                if (this.unk3300LHNGPJFOMIKBuilder_ == null) {
                    this.unk3300LHNGPJFOMIK_ = null;
                    onChanged();
                } else {
                    this.unk3300LHNGPJFOMIK_ = null;
                    this.unk3300LHNGPJFOMIKBuilder_ = null;
                }
                return this;
            }

            public Vector3IntOuterClass.Vector3Int.Builder getUnk3300LHNGPJFOMIKBuilder() {
                onChanged();
                return getUnk3300LHNGPJFOMIKFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
            public Vector3IntOuterClass.Vector3IntOrBuilder getUnk3300LHNGPJFOMIKOrBuilder() {
                if (this.unk3300LHNGPJFOMIKBuilder_ != null) {
                    return this.unk3300LHNGPJFOMIKBuilder_.getMessageOrBuilder();
                }
                return this.unk3300LHNGPJFOMIK_ == null ? Vector3IntOuterClass.Vector3Int.getDefaultInstance() : this.unk3300LHNGPJFOMIK_;
            }

            private SingleFieldBuilderV3<Vector3IntOuterClass.Vector3Int, Vector3IntOuterClass.Vector3Int.Builder, Vector3IntOuterClass.Vector3IntOrBuilder> getUnk3300LHNGPJFOMIKFieldBuilder() {
                if (this.unk3300LHNGPJFOMIKBuilder_ == null) {
                    this.unk3300LHNGPJFOMIKBuilder_ = new SingleFieldBuilderV3<>(getUnk3300LHNGPJFOMIK(), getParentForChildren(), isClean());
                    this.unk3300LHNGPJFOMIK_ = null;
                }
                return this.unk3300LHNGPJFOMIKBuilder_;
            }

            @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
            public int getQueryTypeValue() {
                return this.queryType_;
            }

            public Builder setQueryTypeValue(int value) {
                this.queryType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
            public OptionTypeOuterClass.OptionType getQueryType() {
                OptionTypeOuterClass.OptionType result = OptionTypeOuterClass.OptionType.valueOf(this.queryType_);
                return result == null ? OptionTypeOuterClass.OptionType.UNRECOGNIZED : result;
            }

            public Builder setQueryType(OptionTypeOuterClass.OptionType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.queryType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearQueryType() {
                this.queryType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
            public boolean hasFilter() {
                return (this.filterBuilder_ == null && this.filter_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
            public QueryFilterOuterClass.QueryFilter getFilter() {
                if (this.filterBuilder_ == null) {
                    return this.filter_ == null ? QueryFilterOuterClass.QueryFilter.getDefaultInstance() : this.filter_;
                }
                return this.filterBuilder_.getMessage();
            }

            public Builder setFilter(QueryFilterOuterClass.QueryFilter value) {
                if (this.filterBuilder_ != null) {
                    this.filterBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.filter_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setFilter(QueryFilterOuterClass.QueryFilter.Builder builderForValue) {
                if (this.filterBuilder_ == null) {
                    this.filter_ = builderForValue.build();
                    onChanged();
                } else {
                    this.filterBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeFilter(QueryFilterOuterClass.QueryFilter value) {
                if (this.filterBuilder_ == null) {
                    if (this.filter_ != null) {
                        this.filter_ = QueryFilterOuterClass.QueryFilter.newBuilder(this.filter_).mergeFrom(value).buildPartial();
                    } else {
                        this.filter_ = value;
                    }
                    onChanged();
                } else {
                    this.filterBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearFilter() {
                if (this.filterBuilder_ == null) {
                    this.filter_ = null;
                    onChanged();
                } else {
                    this.filter_ = null;
                    this.filterBuilder_ = null;
                }
                return this;
            }

            public QueryFilterOuterClass.QueryFilter.Builder getFilterBuilder() {
                onChanged();
                return getFilterFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
            public QueryFilterOuterClass.QueryFilterOrBuilder getFilterOrBuilder() {
                if (this.filterBuilder_ != null) {
                    return this.filterBuilder_.getMessageOrBuilder();
                }
                return this.filter_ == null ? QueryFilterOuterClass.QueryFilter.getDefaultInstance() : this.filter_;
            }

            private SingleFieldBuilderV3<QueryFilterOuterClass.QueryFilter, QueryFilterOuterClass.QueryFilter.Builder, QueryFilterOuterClass.QueryFilterOrBuilder> getFilterFieldBuilder() {
                if (this.filterBuilder_ == null) {
                    this.filterBuilder_ = new SingleFieldBuilderV3<>(getFilter(), getParentForChildren(), isClean());
                    this.filter_ = null;
                }
                return this.filterBuilder_;
            }

            @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
            public boolean hasUnk3300CLGJBBJDOLN() {
                return (this.unk3300CLGJBBJDOLNBuilder_ == null && this.unk3300CLGJBBJDOLN_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
            public Vector3IntOuterClass.Vector3Int getUnk3300CLGJBBJDOLN() {
                if (this.unk3300CLGJBBJDOLNBuilder_ == null) {
                    return this.unk3300CLGJBBJDOLN_ == null ? Vector3IntOuterClass.Vector3Int.getDefaultInstance() : this.unk3300CLGJBBJDOLN_;
                }
                return this.unk3300CLGJBBJDOLNBuilder_.getMessage();
            }

            public Builder setUnk3300CLGJBBJDOLN(Vector3IntOuterClass.Vector3Int value) {
                if (this.unk3300CLGJBBJDOLNBuilder_ != null) {
                    this.unk3300CLGJBBJDOLNBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.unk3300CLGJBBJDOLN_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setUnk3300CLGJBBJDOLN(Vector3IntOuterClass.Vector3Int.Builder builderForValue) {
                if (this.unk3300CLGJBBJDOLNBuilder_ == null) {
                    this.unk3300CLGJBBJDOLN_ = builderForValue.build();
                    onChanged();
                } else {
                    this.unk3300CLGJBBJDOLNBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeUnk3300CLGJBBJDOLN(Vector3IntOuterClass.Vector3Int value) {
                if (this.unk3300CLGJBBJDOLNBuilder_ == null) {
                    if (this.unk3300CLGJBBJDOLN_ != null) {
                        this.unk3300CLGJBBJDOLN_ = Vector3IntOuterClass.Vector3Int.newBuilder(this.unk3300CLGJBBJDOLN_).mergeFrom(value).buildPartial();
                    } else {
                        this.unk3300CLGJBBJDOLN_ = value;
                    }
                    onChanged();
                } else {
                    this.unk3300CLGJBBJDOLNBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearUnk3300CLGJBBJDOLN() {
                if (this.unk3300CLGJBBJDOLNBuilder_ == null) {
                    this.unk3300CLGJBBJDOLN_ = null;
                    onChanged();
                } else {
                    this.unk3300CLGJBBJDOLN_ = null;
                    this.unk3300CLGJBBJDOLNBuilder_ = null;
                }
                return this;
            }

            public Vector3IntOuterClass.Vector3Int.Builder getUnk3300CLGJBBJDOLNBuilder() {
                onChanged();
                return getUnk3300CLGJBBJDOLNFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
            public Vector3IntOuterClass.Vector3IntOrBuilder getUnk3300CLGJBBJDOLNOrBuilder() {
                if (this.unk3300CLGJBBJDOLNBuilder_ != null) {
                    return this.unk3300CLGJBBJDOLNBuilder_.getMessageOrBuilder();
                }
                return this.unk3300CLGJBBJDOLN_ == null ? Vector3IntOuterClass.Vector3Int.getDefaultInstance() : this.unk3300CLGJBBJDOLN_;
            }

            private SingleFieldBuilderV3<Vector3IntOuterClass.Vector3Int, Vector3IntOuterClass.Vector3Int.Builder, Vector3IntOuterClass.Vector3IntOrBuilder> getUnk3300CLGJBBJDOLNFieldBuilder() {
                if (this.unk3300CLGJBBJDOLNBuilder_ == null) {
                    this.unk3300CLGJBBJDOLNBuilder_ = new SingleFieldBuilderV3<>(getUnk3300CLGJBBJDOLN(), getParentForChildren(), isClean());
                    this.unk3300CLGJBBJDOLN_ = null;
                }
                return this.unk3300CLGJBBJDOLNBuilder_;
            }

            @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
            public int getSceneId() {
                return this.sceneId_;
            }

            public Builder setSceneId(int value) {
                this.sceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneId() {
                this.sceneId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
            public boolean hasSourcePos() {
                return (this.sourcePosBuilder_ == null && this.sourcePos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
            public VectorOuterClass.Vector getSourcePos() {
                if (this.sourcePosBuilder_ == null) {
                    return this.sourcePos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.sourcePos_;
                }
                return this.sourcePosBuilder_.getMessage();
            }

            public Builder setSourcePos(VectorOuterClass.Vector value) {
                if (this.sourcePosBuilder_ != null) {
                    this.sourcePosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.sourcePos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setSourcePos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.sourcePosBuilder_ == null) {
                    this.sourcePos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.sourcePosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeSourcePos(VectorOuterClass.Vector value) {
                if (this.sourcePosBuilder_ == null) {
                    if (this.sourcePos_ != null) {
                        this.sourcePos_ = VectorOuterClass.Vector.newBuilder(this.sourcePos_).mergeFrom(value).buildPartial();
                    } else {
                        this.sourcePos_ = value;
                    }
                    onChanged();
                } else {
                    this.sourcePosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearSourcePos() {
                if (this.sourcePosBuilder_ == null) {
                    this.sourcePos_ = null;
                    onChanged();
                } else {
                    this.sourcePos_ = null;
                    this.sourcePosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getSourcePosBuilder() {
                onChanged();
                return getSourcePosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.QueryPathReqOuterClass.QueryPathReqOrBuilder
            public VectorOuterClass.VectorOrBuilder getSourcePosOrBuilder() {
                if (this.sourcePosBuilder_ != null) {
                    return this.sourcePosBuilder_.getMessageOrBuilder();
                }
                return this.sourcePos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.sourcePos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getSourcePosFieldBuilder() {
                if (this.sourcePosBuilder_ == null) {
                    this.sourcePosBuilder_ = new SingleFieldBuilderV3<>(getSourcePos(), getParentForChildren(), isClean());
                    this.sourcePos_ = null;
                }
                return this.sourcePosBuilder_;
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

        public static QueryPathReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QueryPathReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<QueryPathReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QueryPathReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Vector3IntOuterClass.getDescriptor();
        OptionTypeOuterClass.getDescriptor();
        QueryFilterOuterClass.getDescriptor();
        VectorOuterClass.getDescriptor();
    }
}
