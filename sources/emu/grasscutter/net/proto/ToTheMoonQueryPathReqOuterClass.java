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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.AStarMethodOuterClass;
import emu.grasscutter.net.proto.FilterTypeOuterClass;
import emu.grasscutter.net.proto.OptionTypeOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ToTheMoonQueryPathReqOuterClass.class */
public final class ToTheMoonQueryPathReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bToTheMoonQueryPathReq.proto\u001a\u0010OptionType.proto\u001a\fVector.proto\u001a\u0011AStarMethod.proto\u001a\u0010FilterType.proto\"¨\u0002\n\u0015ToTheMoonQueryPathReq\u0012\u001e\n\tqueryType\u0018\u000f \u0001(\u000e2\u000b.OptionType\u0012\u000f\n\u0007queryId\u0018\u0003 \u0001(\u0005\u0012\u001a\n\tsourcePos\u0018\f \u0001(\u000b2\u0007.Vector\u0012\u000f\n\u0007sceneId\u0018\u0006 \u0001(\r\u0012!\n\u000bastarMethod\u0018\u0001 \u0001(\u000e2\f.AStarMethod\u0012\u001f\n\nfilterType\u0018\b \u0001(\u000e2\u000b.FilterType\u0012\u0012\n\nfuzzyRange\u0018\u0007 \u0001(\u0005\u0012\u001b\n\u0013Unk3300_OFGONAMNIJG\u0018\n \u0001(\b\u0012\u001b\n\u0013Unk3300_BBLMBILIOGP\u0018\u0002 \u0001(\b\u0012\u001f\n\u000edestinationPos\u0018\u0005 \u0001(\u000b2\u0007.VectorB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{OptionTypeOuterClass.getDescriptor(), VectorOuterClass.getDescriptor(), AStarMethodOuterClass.getDescriptor(), FilterTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ToTheMoonQueryPathReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ToTheMoonQueryPathReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ToTheMoonQueryPathReq_descriptor, new String[]{"QueryType", "QueryId", "SourcePos", "SceneId", "AstarMethod", "FilterType", "FuzzyRange", "Unk3300OFGONAMNIJG", "Unk3300BBLMBILIOGP", "DestinationPos"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ToTheMoonQueryPathReqOuterClass$ToTheMoonQueryPathReqOrBuilder.class */
    public interface ToTheMoonQueryPathReqOrBuilder extends MessageOrBuilder {
        int getQueryTypeValue();

        OptionTypeOuterClass.OptionType getQueryType();

        int getQueryId();

        boolean hasSourcePos();

        VectorOuterClass.Vector getSourcePos();

        VectorOuterClass.VectorOrBuilder getSourcePosOrBuilder();

        int getSceneId();

        int getAstarMethodValue();

        AStarMethodOuterClass.AStarMethod getAstarMethod();

        int getFilterTypeValue();

        FilterTypeOuterClass.FilterType getFilterType();

        int getFuzzyRange();

        boolean getUnk3300OFGONAMNIJG();

        boolean getUnk3300BBLMBILIOGP();

        boolean hasDestinationPos();

        VectorOuterClass.Vector getDestinationPos();

        VectorOuterClass.VectorOrBuilder getDestinationPosOrBuilder();
    }

    private ToTheMoonQueryPathReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ToTheMoonQueryPathReqOuterClass$ToTheMoonQueryPathReq.class */
    public static final class ToTheMoonQueryPathReq extends GeneratedMessageV3 implements ToTheMoonQueryPathReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int QUERYTYPE_FIELD_NUMBER = 15;
        private int queryType_;
        public static final int QUERYID_FIELD_NUMBER = 3;
        private int queryId_;
        public static final int SOURCEPOS_FIELD_NUMBER = 12;
        private VectorOuterClass.Vector sourcePos_;
        public static final int SCENEID_FIELD_NUMBER = 6;
        private int sceneId_;
        public static final int ASTARMETHOD_FIELD_NUMBER = 1;
        private int astarMethod_;
        public static final int FILTERTYPE_FIELD_NUMBER = 8;
        private int filterType_;
        public static final int FUZZYRANGE_FIELD_NUMBER = 7;
        private int fuzzyRange_;
        public static final int UNK3300_OFGONAMNIJG_FIELD_NUMBER = 10;
        private boolean unk3300OFGONAMNIJG_;
        public static final int UNK3300_BBLMBILIOGP_FIELD_NUMBER = 2;
        private boolean unk3300BBLMBILIOGP_;
        public static final int DESTINATIONPOS_FIELD_NUMBER = 5;
        private VectorOuterClass.Vector destinationPos_;
        private byte memoizedIsInitialized;
        private static final ToTheMoonQueryPathReq DEFAULT_INSTANCE = new ToTheMoonQueryPathReq();
        private static final Parser<ToTheMoonQueryPathReq> PARSER = new AbstractParser<ToTheMoonQueryPathReq>() { // from class: emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReq.1
            @Override // com.google.protobuf.Parser
            public ToTheMoonQueryPathReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ToTheMoonQueryPathReq(input, extensionRegistry);
            }
        };

        private ToTheMoonQueryPathReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ToTheMoonQueryPathReq() {
            this.memoizedIsInitialized = -1;
            this.queryType_ = 0;
            this.astarMethod_ = 0;
            this.filterType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ToTheMoonQueryPathReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ToTheMoonQueryPathReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.astarMethod_ = input.readEnum();
                                break;
                            case 16:
                                this.unk3300BBLMBILIOGP_ = input.readBool();
                                break;
                            case 24:
                                this.queryId_ = input.readInt32();
                                break;
                            case 42:
                                VectorOuterClass.Vector.Builder subBuilder = this.destinationPos_ != null ? this.destinationPos_.toBuilder() : null;
                                this.destinationPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.destinationPos_);
                                    this.destinationPos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 48:
                                this.sceneId_ = input.readUInt32();
                                break;
                            case 56:
                                this.fuzzyRange_ = input.readInt32();
                                break;
                            case 64:
                                this.filterType_ = input.readEnum();
                                break;
                            case 80:
                                this.unk3300OFGONAMNIJG_ = input.readBool();
                                break;
                            case 98:
                                VectorOuterClass.Vector.Builder subBuilder2 = this.sourcePos_ != null ? this.sourcePos_.toBuilder() : null;
                                this.sourcePos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.sourcePos_);
                                    this.sourcePos_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 120:
                                this.queryType_ = input.readEnum();
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
            return ToTheMoonQueryPathReqOuterClass.internal_static_ToTheMoonQueryPathReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ToTheMoonQueryPathReqOuterClass.internal_static_ToTheMoonQueryPathReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ToTheMoonQueryPathReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public int getQueryTypeValue() {
            return this.queryType_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public OptionTypeOuterClass.OptionType getQueryType() {
            OptionTypeOuterClass.OptionType result = OptionTypeOuterClass.OptionType.valueOf(this.queryType_);
            return result == null ? OptionTypeOuterClass.OptionType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public int getQueryId() {
            return this.queryId_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public boolean hasSourcePos() {
            return this.sourcePos_ != null;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public VectorOuterClass.Vector getSourcePos() {
            return this.sourcePos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.sourcePos_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public VectorOuterClass.VectorOrBuilder getSourcePosOrBuilder() {
            return getSourcePos();
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public int getSceneId() {
            return this.sceneId_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public int getAstarMethodValue() {
            return this.astarMethod_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public AStarMethodOuterClass.AStarMethod getAstarMethod() {
            AStarMethodOuterClass.AStarMethod result = AStarMethodOuterClass.AStarMethod.valueOf(this.astarMethod_);
            return result == null ? AStarMethodOuterClass.AStarMethod.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public int getFilterTypeValue() {
            return this.filterType_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public FilterTypeOuterClass.FilterType getFilterType() {
            FilterTypeOuterClass.FilterType result = FilterTypeOuterClass.FilterType.valueOf(this.filterType_);
            return result == null ? FilterTypeOuterClass.FilterType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public int getFuzzyRange() {
            return this.fuzzyRange_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public boolean getUnk3300OFGONAMNIJG() {
            return this.unk3300OFGONAMNIJG_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public boolean getUnk3300BBLMBILIOGP() {
            return this.unk3300BBLMBILIOGP_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public boolean hasDestinationPos() {
            return this.destinationPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public VectorOuterClass.Vector getDestinationPos() {
            return this.destinationPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.destinationPos_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
        public VectorOuterClass.VectorOrBuilder getDestinationPosOrBuilder() {
            return getDestinationPos();
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
            if (this.astarMethod_ != AStarMethodOuterClass.AStarMethod.A_STAR_METHOD_CLASSIC.getNumber()) {
                output.writeEnum(1, this.astarMethod_);
            }
            if (this.unk3300BBLMBILIOGP_) {
                output.writeBool(2, this.unk3300BBLMBILIOGP_);
            }
            if (this.queryId_ != 0) {
                output.writeInt32(3, this.queryId_);
            }
            if (this.destinationPos_ != null) {
                output.writeMessage(5, getDestinationPos());
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(6, this.sceneId_);
            }
            if (this.fuzzyRange_ != 0) {
                output.writeInt32(7, this.fuzzyRange_);
            }
            if (this.filterType_ != FilterTypeOuterClass.FilterType.FILTER_TYPE_ALL.getNumber()) {
                output.writeEnum(8, this.filterType_);
            }
            if (this.unk3300OFGONAMNIJG_) {
                output.writeBool(10, this.unk3300OFGONAMNIJG_);
            }
            if (this.sourcePos_ != null) {
                output.writeMessage(12, getSourcePos());
            }
            if (this.queryType_ != OptionTypeOuterClass.OptionType.OPTION_TYPE_NONE.getNumber()) {
                output.writeEnum(15, this.queryType_);
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
            if (this.astarMethod_ != AStarMethodOuterClass.AStarMethod.A_STAR_METHOD_CLASSIC.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(1, this.astarMethod_);
            }
            if (this.unk3300BBLMBILIOGP_) {
                size2 += CodedOutputStream.computeBoolSize(2, this.unk3300BBLMBILIOGP_);
            }
            if (this.queryId_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(3, this.queryId_);
            }
            if (this.destinationPos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(5, getDestinationPos());
            }
            if (this.sceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.sceneId_);
            }
            if (this.fuzzyRange_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(7, this.fuzzyRange_);
            }
            if (this.filterType_ != FilterTypeOuterClass.FilterType.FILTER_TYPE_ALL.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(8, this.filterType_);
            }
            if (this.unk3300OFGONAMNIJG_) {
                size2 += CodedOutputStream.computeBoolSize(10, this.unk3300OFGONAMNIJG_);
            }
            if (this.sourcePos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(12, getSourcePos());
            }
            if (this.queryType_ != OptionTypeOuterClass.OptionType.OPTION_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(15, this.queryType_);
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
            if (!(obj instanceof ToTheMoonQueryPathReq)) {
                return equals(obj);
            }
            ToTheMoonQueryPathReq other = (ToTheMoonQueryPathReq) obj;
            if (this.queryType_ != other.queryType_ || getQueryId() != other.getQueryId() || hasSourcePos() != other.hasSourcePos()) {
                return false;
            }
            if ((!hasSourcePos() || getSourcePos().equals(other.getSourcePos())) && getSceneId() == other.getSceneId() && this.astarMethod_ == other.astarMethod_ && this.filterType_ == other.filterType_ && getFuzzyRange() == other.getFuzzyRange() && getUnk3300OFGONAMNIJG() == other.getUnk3300OFGONAMNIJG() && getUnk3300BBLMBILIOGP() == other.getUnk3300BBLMBILIOGP() && hasDestinationPos() == other.hasDestinationPos()) {
                return (!hasDestinationPos() || getDestinationPos().equals(other.getDestinationPos())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + this.queryType_)) + 3)) + getQueryId();
            if (hasSourcePos()) {
                hash = (53 * ((37 * hash) + 12)) + getSourcePos().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 6)) + getSceneId())) + 1)) + this.astarMethod_)) + 8)) + this.filterType_)) + 7)) + getFuzzyRange())) + 10)) + Internal.hashBoolean(getUnk3300OFGONAMNIJG()))) + 2)) + Internal.hashBoolean(getUnk3300BBLMBILIOGP());
            if (hasDestinationPos()) {
                hash2 = (53 * ((37 * hash2) + 5)) + getDestinationPos().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static ToTheMoonQueryPathReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ToTheMoonQueryPathReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ToTheMoonQueryPathReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ToTheMoonQueryPathReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ToTheMoonQueryPathReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ToTheMoonQueryPathReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ToTheMoonQueryPathReq parseFrom(InputStream input) throws IOException {
            return (ToTheMoonQueryPathReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ToTheMoonQueryPathReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ToTheMoonQueryPathReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ToTheMoonQueryPathReq parseDelimitedFrom(InputStream input) throws IOException {
            return (ToTheMoonQueryPathReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ToTheMoonQueryPathReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ToTheMoonQueryPathReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ToTheMoonQueryPathReq parseFrom(CodedInputStream input) throws IOException {
            return (ToTheMoonQueryPathReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ToTheMoonQueryPathReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ToTheMoonQueryPathReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ToTheMoonQueryPathReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ToTheMoonQueryPathReqOuterClass$ToTheMoonQueryPathReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ToTheMoonQueryPathReqOrBuilder {
            private int queryId_;
            private VectorOuterClass.Vector sourcePos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> sourcePosBuilder_;
            private int sceneId_;
            private int fuzzyRange_;
            private boolean unk3300OFGONAMNIJG_;
            private boolean unk3300BBLMBILIOGP_;
            private VectorOuterClass.Vector destinationPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> destinationPosBuilder_;
            private int queryType_ = 0;
            private int astarMethod_ = 0;
            private int filterType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return ToTheMoonQueryPathReqOuterClass.internal_static_ToTheMoonQueryPathReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ToTheMoonQueryPathReqOuterClass.internal_static_ToTheMoonQueryPathReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ToTheMoonQueryPathReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ToTheMoonQueryPathReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.queryType_ = 0;
                this.queryId_ = 0;
                if (this.sourcePosBuilder_ == null) {
                    this.sourcePos_ = null;
                } else {
                    this.sourcePos_ = null;
                    this.sourcePosBuilder_ = null;
                }
                this.sceneId_ = 0;
                this.astarMethod_ = 0;
                this.filterType_ = 0;
                this.fuzzyRange_ = 0;
                this.unk3300OFGONAMNIJG_ = false;
                this.unk3300BBLMBILIOGP_ = false;
                if (this.destinationPosBuilder_ == null) {
                    this.destinationPos_ = null;
                } else {
                    this.destinationPos_ = null;
                    this.destinationPosBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ToTheMoonQueryPathReqOuterClass.internal_static_ToTheMoonQueryPathReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ToTheMoonQueryPathReq getDefaultInstanceForType() {
                return ToTheMoonQueryPathReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ToTheMoonQueryPathReq build() {
                ToTheMoonQueryPathReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ToTheMoonQueryPathReq buildPartial() {
                ToTheMoonQueryPathReq result = new ToTheMoonQueryPathReq(this);
                result.queryType_ = this.queryType_;
                result.queryId_ = this.queryId_;
                if (this.sourcePosBuilder_ == null) {
                    result.sourcePos_ = this.sourcePos_;
                } else {
                    result.sourcePos_ = this.sourcePosBuilder_.build();
                }
                result.sceneId_ = this.sceneId_;
                result.astarMethod_ = this.astarMethod_;
                result.filterType_ = this.filterType_;
                result.fuzzyRange_ = this.fuzzyRange_;
                result.unk3300OFGONAMNIJG_ = this.unk3300OFGONAMNIJG_;
                result.unk3300BBLMBILIOGP_ = this.unk3300BBLMBILIOGP_;
                if (this.destinationPosBuilder_ == null) {
                    result.destinationPos_ = this.destinationPos_;
                } else {
                    result.destinationPos_ = this.destinationPosBuilder_.build();
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
                if (other instanceof ToTheMoonQueryPathReq) {
                    return mergeFrom((ToTheMoonQueryPathReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ToTheMoonQueryPathReq other) {
                if (other == ToTheMoonQueryPathReq.getDefaultInstance()) {
                    return this;
                }
                if (other.queryType_ != 0) {
                    setQueryTypeValue(other.getQueryTypeValue());
                }
                if (other.getQueryId() != 0) {
                    setQueryId(other.getQueryId());
                }
                if (other.hasSourcePos()) {
                    mergeSourcePos(other.getSourcePos());
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
                }
                if (other.astarMethod_ != 0) {
                    setAstarMethodValue(other.getAstarMethodValue());
                }
                if (other.filterType_ != 0) {
                    setFilterTypeValue(other.getFilterTypeValue());
                }
                if (other.getFuzzyRange() != 0) {
                    setFuzzyRange(other.getFuzzyRange());
                }
                if (other.getUnk3300OFGONAMNIJG()) {
                    setUnk3300OFGONAMNIJG(other.getUnk3300OFGONAMNIJG());
                }
                if (other.getUnk3300BBLMBILIOGP()) {
                    setUnk3300BBLMBILIOGP(other.getUnk3300BBLMBILIOGP());
                }
                if (other.hasDestinationPos()) {
                    mergeDestinationPos(other.getDestinationPos());
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
                ToTheMoonQueryPathReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = ToTheMoonQueryPathReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ToTheMoonQueryPathReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public int getQueryTypeValue() {
                return this.queryType_;
            }

            public Builder setQueryTypeValue(int value) {
                this.queryType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public boolean hasSourcePos() {
                return (this.sourcePosBuilder_ == null && this.sourcePos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public int getAstarMethodValue() {
                return this.astarMethod_;
            }

            public Builder setAstarMethodValue(int value) {
                this.astarMethod_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public AStarMethodOuterClass.AStarMethod getAstarMethod() {
                AStarMethodOuterClass.AStarMethod result = AStarMethodOuterClass.AStarMethod.valueOf(this.astarMethod_);
                return result == null ? AStarMethodOuterClass.AStarMethod.UNRECOGNIZED : result;
            }

            public Builder setAstarMethod(AStarMethodOuterClass.AStarMethod value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.astarMethod_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearAstarMethod() {
                this.astarMethod_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public int getFilterTypeValue() {
                return this.filterType_;
            }

            public Builder setFilterTypeValue(int value) {
                this.filterType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public FilterTypeOuterClass.FilterType getFilterType() {
                FilterTypeOuterClass.FilterType result = FilterTypeOuterClass.FilterType.valueOf(this.filterType_);
                return result == null ? FilterTypeOuterClass.FilterType.UNRECOGNIZED : result;
            }

            public Builder setFilterType(FilterTypeOuterClass.FilterType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.filterType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearFilterType() {
                this.filterType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public int getFuzzyRange() {
                return this.fuzzyRange_;
            }

            public Builder setFuzzyRange(int value) {
                this.fuzzyRange_ = value;
                onChanged();
                return this;
            }

            public Builder clearFuzzyRange() {
                this.fuzzyRange_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public boolean getUnk3300OFGONAMNIJG() {
                return this.unk3300OFGONAMNIJG_;
            }

            public Builder setUnk3300OFGONAMNIJG(boolean value) {
                this.unk3300OFGONAMNIJG_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300OFGONAMNIJG() {
                this.unk3300OFGONAMNIJG_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public boolean getUnk3300BBLMBILIOGP() {
                return this.unk3300BBLMBILIOGP_;
            }

            public Builder setUnk3300BBLMBILIOGP(boolean value) {
                this.unk3300BBLMBILIOGP_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300BBLMBILIOGP() {
                this.unk3300BBLMBILIOGP_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public boolean hasDestinationPos() {
                return (this.destinationPosBuilder_ == null && this.destinationPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public VectorOuterClass.Vector getDestinationPos() {
                if (this.destinationPosBuilder_ == null) {
                    return this.destinationPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.destinationPos_;
                }
                return this.destinationPosBuilder_.getMessage();
            }

            public Builder setDestinationPos(VectorOuterClass.Vector value) {
                if (this.destinationPosBuilder_ != null) {
                    this.destinationPosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.destinationPos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setDestinationPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.destinationPosBuilder_ == null) {
                    this.destinationPos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.destinationPosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeDestinationPos(VectorOuterClass.Vector value) {
                if (this.destinationPosBuilder_ == null) {
                    if (this.destinationPos_ != null) {
                        this.destinationPos_ = VectorOuterClass.Vector.newBuilder(this.destinationPos_).mergeFrom(value).buildPartial();
                    } else {
                        this.destinationPos_ = value;
                    }
                    onChanged();
                } else {
                    this.destinationPosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearDestinationPos() {
                if (this.destinationPosBuilder_ == null) {
                    this.destinationPos_ = null;
                    onChanged();
                } else {
                    this.destinationPos_ = null;
                    this.destinationPosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getDestinationPosBuilder() {
                onChanged();
                return getDestinationPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathReqOuterClass.ToTheMoonQueryPathReqOrBuilder
            public VectorOuterClass.VectorOrBuilder getDestinationPosOrBuilder() {
                if (this.destinationPosBuilder_ != null) {
                    return this.destinationPosBuilder_.getMessageOrBuilder();
                }
                return this.destinationPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.destinationPos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getDestinationPosFieldBuilder() {
                if (this.destinationPosBuilder_ == null) {
                    this.destinationPosBuilder_ = new SingleFieldBuilderV3<>(getDestinationPos(), getParentForChildren(), isClean());
                    this.destinationPos_ = null;
                }
                return this.destinationPosBuilder_;
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

        public static ToTheMoonQueryPathReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ToTheMoonQueryPathReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ToTheMoonQueryPathReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ToTheMoonQueryPathReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        OptionTypeOuterClass.getDescriptor();
        VectorOuterClass.getDescriptor();
        AStarMethodOuterClass.getDescriptor();
        FilterTypeOuterClass.getDescriptor();
    }
}
