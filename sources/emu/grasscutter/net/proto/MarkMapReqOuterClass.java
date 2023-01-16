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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.MapMarkPointOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MarkMapReqOuterClass.class */
public final class MarkMapReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010MarkMapReq.proto\u001a\u0012MapMarkPoint.proto\"Á\u0001\n\nMarkMapReq\u0012!\n\u0002op\u0018\u0003 \u0001(\u000e2\u0015.MarkMapReq.Operation\u0012\u001a\n\u0003old\u0018\u0006 \u0001(\u000b2\r.MapMarkPoint\u0012\u001b\n\u0004mark\u0018\r \u0001(\u000b2\r.MapMarkPoint\"W\n\tOperation\u0012\u0011\n\rOPERATION_ADD\u0010��\u0012\u0011\n\rOPERATION_MOD\u0010\u0001\u0012\u0011\n\rOPERATION_DEL\u0010\u0002\u0012\u0011\n\rOPERATION_GET\u0010\u0003B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MapMarkPointOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MarkMapReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MarkMapReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MarkMapReq_descriptor, new String[]{"Op", "Old", "Mark"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MarkMapReqOuterClass$MarkMapReqOrBuilder.class */
    public interface MarkMapReqOrBuilder extends MessageOrBuilder {
        int getOpValue();

        MarkMapReq.Operation getOp();

        boolean hasOld();

        MapMarkPointOuterClass.MapMarkPoint getOld();

        MapMarkPointOuterClass.MapMarkPointOrBuilder getOldOrBuilder();

        boolean hasMark();

        MapMarkPointOuterClass.MapMarkPoint getMark();

        MapMarkPointOuterClass.MapMarkPointOrBuilder getMarkOrBuilder();
    }

    private MarkMapReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MarkMapReqOuterClass$MarkMapReq.class */
    public static final class MarkMapReq extends GeneratedMessageV3 implements MarkMapReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int OP_FIELD_NUMBER = 3;
        private int op_;
        public static final int OLD_FIELD_NUMBER = 6;
        private MapMarkPointOuterClass.MapMarkPoint old_;
        public static final int MARK_FIELD_NUMBER = 13;
        private MapMarkPointOuterClass.MapMarkPoint mark_;
        private byte memoizedIsInitialized;
        private static final MarkMapReq DEFAULT_INSTANCE = new MarkMapReq();
        private static final Parser<MarkMapReq> PARSER = new AbstractParser<MarkMapReq>() { // from class: emu.grasscutter.net.proto.MarkMapReqOuterClass.MarkMapReq.1
            @Override // com.google.protobuf.Parser
            public MarkMapReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MarkMapReq(input, extensionRegistry);
            }
        };

        private MarkMapReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MarkMapReq() {
            this.memoizedIsInitialized = -1;
            this.op_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MarkMapReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MarkMapReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.op_ = input.readEnum();
                                break;
                            case 50:
                                MapMarkPointOuterClass.MapMarkPoint.Builder subBuilder = this.old_ != null ? this.old_.toBuilder() : null;
                                this.old_ = (MapMarkPointOuterClass.MapMarkPoint) input.readMessage(MapMarkPointOuterClass.MapMarkPoint.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.old_);
                                    this.old_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 106:
                                MapMarkPointOuterClass.MapMarkPoint.Builder subBuilder2 = this.mark_ != null ? this.mark_.toBuilder() : null;
                                this.mark_ = (MapMarkPointOuterClass.MapMarkPoint) input.readMessage(MapMarkPointOuterClass.MapMarkPoint.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.mark_);
                                    this.mark_ = subBuilder2.buildPartial();
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
            return MarkMapReqOuterClass.internal_static_MarkMapReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MarkMapReqOuterClass.internal_static_MarkMapReq_fieldAccessorTable.ensureFieldAccessorsInitialized(MarkMapReq.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MarkMapReqOuterClass$MarkMapReq$Operation.class */
        public enum Operation implements ProtocolMessageEnum {
            OPERATION_ADD(0),
            OPERATION_MOD(1),
            OPERATION_DEL(2),
            OPERATION_GET(3),
            UNRECOGNIZED(-1);
            
            public static final int OPERATION_ADD_VALUE = 0;
            public static final int OPERATION_MOD_VALUE = 1;
            public static final int OPERATION_DEL_VALUE = 2;
            public static final int OPERATION_GET_VALUE = 3;
            private static final Internal.EnumLiteMap<Operation> internalValueMap = new Internal.EnumLiteMap<Operation>() { // from class: emu.grasscutter.net.proto.MarkMapReqOuterClass.MarkMapReq.Operation.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Operation findValueByNumber(int number) {
                    return Operation.forNumber(number);
                }
            };
            private static final Operation[] VALUES = values();
            private final int value;

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static Operation valueOf(int value) {
                return forNumber(value);
            }

            public static Operation forNumber(int value) {
                switch (value) {
                    case 0:
                        return OPERATION_ADD;
                    case 1:
                        return OPERATION_MOD;
                    case 2:
                        return OPERATION_DEL;
                    case 3:
                        return OPERATION_GET;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<Operation> internalGetValueMap() {
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
                return MarkMapReq.getDescriptor().getEnumTypes().get(0);
            }

            public static Operation valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                } else if (desc.getIndex() == -1) {
                    return UNRECOGNIZED;
                } else {
                    return VALUES[desc.getIndex()];
                }
            }

            Operation(int value) {
                this.value = value;
            }
        }

        @Override // emu.grasscutter.net.proto.MarkMapReqOuterClass.MarkMapReqOrBuilder
        public int getOpValue() {
            return this.op_;
        }

        @Override // emu.grasscutter.net.proto.MarkMapReqOuterClass.MarkMapReqOrBuilder
        public Operation getOp() {
            Operation result = Operation.valueOf(this.op_);
            return result == null ? Operation.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.MarkMapReqOuterClass.MarkMapReqOrBuilder
        public boolean hasOld() {
            return this.old_ != null;
        }

        @Override // emu.grasscutter.net.proto.MarkMapReqOuterClass.MarkMapReqOrBuilder
        public MapMarkPointOuterClass.MapMarkPoint getOld() {
            return this.old_ == null ? MapMarkPointOuterClass.MapMarkPoint.getDefaultInstance() : this.old_;
        }

        @Override // emu.grasscutter.net.proto.MarkMapReqOuterClass.MarkMapReqOrBuilder
        public MapMarkPointOuterClass.MapMarkPointOrBuilder getOldOrBuilder() {
            return getOld();
        }

        @Override // emu.grasscutter.net.proto.MarkMapReqOuterClass.MarkMapReqOrBuilder
        public boolean hasMark() {
            return this.mark_ != null;
        }

        @Override // emu.grasscutter.net.proto.MarkMapReqOuterClass.MarkMapReqOrBuilder
        public MapMarkPointOuterClass.MapMarkPoint getMark() {
            return this.mark_ == null ? MapMarkPointOuterClass.MapMarkPoint.getDefaultInstance() : this.mark_;
        }

        @Override // emu.grasscutter.net.proto.MarkMapReqOuterClass.MarkMapReqOrBuilder
        public MapMarkPointOuterClass.MapMarkPointOrBuilder getMarkOrBuilder() {
            return getMark();
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
            if (this.op_ != Operation.OPERATION_ADD.getNumber()) {
                output.writeEnum(3, this.op_);
            }
            if (this.old_ != null) {
                output.writeMessage(6, getOld());
            }
            if (this.mark_ != null) {
                output.writeMessage(13, getMark());
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
            if (this.op_ != Operation.OPERATION_ADD.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(3, this.op_);
            }
            if (this.old_ != null) {
                size2 += CodedOutputStream.computeMessageSize(6, getOld());
            }
            if (this.mark_ != null) {
                size2 += CodedOutputStream.computeMessageSize(13, getMark());
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
            if (!(obj instanceof MarkMapReq)) {
                return equals(obj);
            }
            MarkMapReq other = (MarkMapReq) obj;
            if (this.op_ != other.op_ || hasOld() != other.hasOld()) {
                return false;
            }
            if ((!hasOld() || getOld().equals(other.getOld())) && hasMark() == other.hasMark()) {
                return (!hasMark() || getMark().equals(other.getMark())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + this.op_;
            if (hasOld()) {
                hash = (53 * ((37 * hash) + 6)) + getOld().hashCode();
            }
            if (hasMark()) {
                hash = (53 * ((37 * hash) + 13)) + getMark().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MarkMapReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MarkMapReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MarkMapReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MarkMapReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MarkMapReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MarkMapReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MarkMapReq parseFrom(InputStream input) throws IOException {
            return (MarkMapReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MarkMapReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MarkMapReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MarkMapReq parseDelimitedFrom(InputStream input) throws IOException {
            return (MarkMapReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MarkMapReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MarkMapReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MarkMapReq parseFrom(CodedInputStream input) throws IOException {
            return (MarkMapReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MarkMapReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MarkMapReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MarkMapReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MarkMapReqOuterClass$MarkMapReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MarkMapReqOrBuilder {
            private int op_ = 0;
            private MapMarkPointOuterClass.MapMarkPoint old_;
            private SingleFieldBuilderV3<MapMarkPointOuterClass.MapMarkPoint, MapMarkPointOuterClass.MapMarkPoint.Builder, MapMarkPointOuterClass.MapMarkPointOrBuilder> oldBuilder_;
            private MapMarkPointOuterClass.MapMarkPoint mark_;
            private SingleFieldBuilderV3<MapMarkPointOuterClass.MapMarkPoint, MapMarkPointOuterClass.MapMarkPoint.Builder, MapMarkPointOuterClass.MapMarkPointOrBuilder> markBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MarkMapReqOuterClass.internal_static_MarkMapReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MarkMapReqOuterClass.internal_static_MarkMapReq_fieldAccessorTable.ensureFieldAccessorsInitialized(MarkMapReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MarkMapReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.op_ = 0;
                if (this.oldBuilder_ == null) {
                    this.old_ = null;
                } else {
                    this.old_ = null;
                    this.oldBuilder_ = null;
                }
                if (this.markBuilder_ == null) {
                    this.mark_ = null;
                } else {
                    this.mark_ = null;
                    this.markBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MarkMapReqOuterClass.internal_static_MarkMapReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MarkMapReq getDefaultInstanceForType() {
                return MarkMapReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MarkMapReq build() {
                MarkMapReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MarkMapReq buildPartial() {
                MarkMapReq result = new MarkMapReq(this);
                result.op_ = this.op_;
                if (this.oldBuilder_ == null) {
                    result.old_ = this.old_;
                } else {
                    result.old_ = this.oldBuilder_.build();
                }
                if (this.markBuilder_ == null) {
                    result.mark_ = this.mark_;
                } else {
                    result.mark_ = this.markBuilder_.build();
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
                if (other instanceof MarkMapReq) {
                    return mergeFrom((MarkMapReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MarkMapReq other) {
                if (other == MarkMapReq.getDefaultInstance()) {
                    return this;
                }
                if (other.op_ != 0) {
                    setOpValue(other.getOpValue());
                }
                if (other.hasOld()) {
                    mergeOld(other.getOld());
                }
                if (other.hasMark()) {
                    mergeMark(other.getMark());
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
                MarkMapReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = MarkMapReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MarkMapReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MarkMapReqOuterClass.MarkMapReqOrBuilder
            public int getOpValue() {
                return this.op_;
            }

            public Builder setOpValue(int value) {
                this.op_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MarkMapReqOuterClass.MarkMapReqOrBuilder
            public Operation getOp() {
                Operation result = Operation.valueOf(this.op_);
                return result == null ? Operation.UNRECOGNIZED : result;
            }

            public Builder setOp(Operation value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.op_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearOp() {
                this.op_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MarkMapReqOuterClass.MarkMapReqOrBuilder
            public boolean hasOld() {
                return (this.oldBuilder_ == null && this.old_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.MarkMapReqOuterClass.MarkMapReqOrBuilder
            public MapMarkPointOuterClass.MapMarkPoint getOld() {
                if (this.oldBuilder_ == null) {
                    return this.old_ == null ? MapMarkPointOuterClass.MapMarkPoint.getDefaultInstance() : this.old_;
                }
                return this.oldBuilder_.getMessage();
            }

            public Builder setOld(MapMarkPointOuterClass.MapMarkPoint value) {
                if (this.oldBuilder_ != null) {
                    this.oldBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.old_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setOld(MapMarkPointOuterClass.MapMarkPoint.Builder builderForValue) {
                if (this.oldBuilder_ == null) {
                    this.old_ = builderForValue.build();
                    onChanged();
                } else {
                    this.oldBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeOld(MapMarkPointOuterClass.MapMarkPoint value) {
                if (this.oldBuilder_ == null) {
                    if (this.old_ != null) {
                        this.old_ = MapMarkPointOuterClass.MapMarkPoint.newBuilder(this.old_).mergeFrom(value).buildPartial();
                    } else {
                        this.old_ = value;
                    }
                    onChanged();
                } else {
                    this.oldBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearOld() {
                if (this.oldBuilder_ == null) {
                    this.old_ = null;
                    onChanged();
                } else {
                    this.old_ = null;
                    this.oldBuilder_ = null;
                }
                return this;
            }

            public MapMarkPointOuterClass.MapMarkPoint.Builder getOldBuilder() {
                onChanged();
                return getOldFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.MarkMapReqOuterClass.MarkMapReqOrBuilder
            public MapMarkPointOuterClass.MapMarkPointOrBuilder getOldOrBuilder() {
                if (this.oldBuilder_ != null) {
                    return this.oldBuilder_.getMessageOrBuilder();
                }
                return this.old_ == null ? MapMarkPointOuterClass.MapMarkPoint.getDefaultInstance() : this.old_;
            }

            private SingleFieldBuilderV3<MapMarkPointOuterClass.MapMarkPoint, MapMarkPointOuterClass.MapMarkPoint.Builder, MapMarkPointOuterClass.MapMarkPointOrBuilder> getOldFieldBuilder() {
                if (this.oldBuilder_ == null) {
                    this.oldBuilder_ = new SingleFieldBuilderV3<>(getOld(), getParentForChildren(), isClean());
                    this.old_ = null;
                }
                return this.oldBuilder_;
            }

            @Override // emu.grasscutter.net.proto.MarkMapReqOuterClass.MarkMapReqOrBuilder
            public boolean hasMark() {
                return (this.markBuilder_ == null && this.mark_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.MarkMapReqOuterClass.MarkMapReqOrBuilder
            public MapMarkPointOuterClass.MapMarkPoint getMark() {
                if (this.markBuilder_ == null) {
                    return this.mark_ == null ? MapMarkPointOuterClass.MapMarkPoint.getDefaultInstance() : this.mark_;
                }
                return this.markBuilder_.getMessage();
            }

            public Builder setMark(MapMarkPointOuterClass.MapMarkPoint value) {
                if (this.markBuilder_ != null) {
                    this.markBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.mark_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setMark(MapMarkPointOuterClass.MapMarkPoint.Builder builderForValue) {
                if (this.markBuilder_ == null) {
                    this.mark_ = builderForValue.build();
                    onChanged();
                } else {
                    this.markBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeMark(MapMarkPointOuterClass.MapMarkPoint value) {
                if (this.markBuilder_ == null) {
                    if (this.mark_ != null) {
                        this.mark_ = MapMarkPointOuterClass.MapMarkPoint.newBuilder(this.mark_).mergeFrom(value).buildPartial();
                    } else {
                        this.mark_ = value;
                    }
                    onChanged();
                } else {
                    this.markBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearMark() {
                if (this.markBuilder_ == null) {
                    this.mark_ = null;
                    onChanged();
                } else {
                    this.mark_ = null;
                    this.markBuilder_ = null;
                }
                return this;
            }

            public MapMarkPointOuterClass.MapMarkPoint.Builder getMarkBuilder() {
                onChanged();
                return getMarkFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.MarkMapReqOuterClass.MarkMapReqOrBuilder
            public MapMarkPointOuterClass.MapMarkPointOrBuilder getMarkOrBuilder() {
                if (this.markBuilder_ != null) {
                    return this.markBuilder_.getMessageOrBuilder();
                }
                return this.mark_ == null ? MapMarkPointOuterClass.MapMarkPoint.getDefaultInstance() : this.mark_;
            }

            private SingleFieldBuilderV3<MapMarkPointOuterClass.MapMarkPoint, MapMarkPointOuterClass.MapMarkPoint.Builder, MapMarkPointOuterClass.MapMarkPointOrBuilder> getMarkFieldBuilder() {
                if (this.markBuilder_ == null) {
                    this.markBuilder_ = new SingleFieldBuilderV3<>(getMark(), getParentForChildren(), isClean());
                    this.mark_ = null;
                }
                return this.markBuilder_;
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

        public static MarkMapReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MarkMapReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MarkMapReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MarkMapReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MapMarkPointOuterClass.getDescriptor();
    }
}
