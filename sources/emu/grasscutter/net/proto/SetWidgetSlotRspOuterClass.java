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
import emu.grasscutter.net.proto.WidgetSlotOpOuterClass;
import emu.grasscutter.net.proto.WidgetSlotTagOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetWidgetSlotRspOuterClass.class */
public final class SetWidgetSlotRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016SetWidgetSlotRsp.proto\u001a\u0012WidgetSlotOp.proto\u001a\u0013WidgetSlotTag.proto\"u\n\u0010SetWidgetSlotRsp\u0012\u0013\n\u000bmaterial_id\u0018\u0004 \u0001(\r\u0012\u000f\n\u0007retcode\u0018\u0001 \u0001(\u0005\u0012 \n\btag_list\u0018\u000f \u0003(\u000e2\u000e.WidgetSlotTag\u0012\u0019\n\u0002op\u0018\u0005 \u0001(\u000e2\r.WidgetSlotOpB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{WidgetSlotOpOuterClass.getDescriptor(), WidgetSlotTagOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SetWidgetSlotRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SetWidgetSlotRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SetWidgetSlotRsp_descriptor, new String[]{"MaterialId", "Retcode", "TagList", "Op"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetWidgetSlotRspOuterClass$SetWidgetSlotRspOrBuilder.class */
    public interface SetWidgetSlotRspOrBuilder extends MessageOrBuilder {
        int getMaterialId();

        int getRetcode();

        List<WidgetSlotTagOuterClass.WidgetSlotTag> getTagListList();

        int getTagListCount();

        WidgetSlotTagOuterClass.WidgetSlotTag getTagList(int i);

        List<Integer> getTagListValueList();

        int getTagListValue(int i);

        int getOpValue();

        WidgetSlotOpOuterClass.WidgetSlotOp getOp();
    }

    private SetWidgetSlotRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetWidgetSlotRspOuterClass$SetWidgetSlotRsp.class */
    public static final class SetWidgetSlotRsp extends GeneratedMessageV3 implements SetWidgetSlotRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MATERIAL_ID_FIELD_NUMBER = 4;
        private int materialId_;
        public static final int RETCODE_FIELD_NUMBER = 1;
        private int retcode_;
        public static final int TAG_LIST_FIELD_NUMBER = 15;
        private List<Integer> tagList_;
        private int tagListMemoizedSerializedSize;
        public static final int OP_FIELD_NUMBER = 5;
        private int op_;
        private byte memoizedIsInitialized;
        private static final Internal.ListAdapter.Converter<Integer, WidgetSlotTagOuterClass.WidgetSlotTag> tagList_converter_ = new Internal.ListAdapter.Converter<Integer, WidgetSlotTagOuterClass.WidgetSlotTag>() { // from class: emu.grasscutter.net.proto.SetWidgetSlotRspOuterClass.SetWidgetSlotRsp.1
            public WidgetSlotTagOuterClass.WidgetSlotTag convert(Integer from) {
                WidgetSlotTagOuterClass.WidgetSlotTag result = WidgetSlotTagOuterClass.WidgetSlotTag.valueOf(from.intValue());
                return result == null ? WidgetSlotTagOuterClass.WidgetSlotTag.UNRECOGNIZED : result;
            }
        };
        private static final SetWidgetSlotRsp DEFAULT_INSTANCE = new SetWidgetSlotRsp();
        private static final Parser<SetWidgetSlotRsp> PARSER = new AbstractParser<SetWidgetSlotRsp>() { // from class: emu.grasscutter.net.proto.SetWidgetSlotRspOuterClass.SetWidgetSlotRsp.2
            @Override // com.google.protobuf.Parser
            public SetWidgetSlotRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SetWidgetSlotRsp(input, extensionRegistry);
            }
        };

        private SetWidgetSlotRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SetWidgetSlotRsp() {
            this.memoizedIsInitialized = -1;
            this.tagList_ = Collections.emptyList();
            this.op_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SetWidgetSlotRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SetWidgetSlotRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 32:
                                    this.materialId_ = input.readUInt32();
                                    break;
                                case 40:
                                    this.op_ = input.readEnum();
                                    break;
                                case 120:
                                    int rawValue = input.readEnum();
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.tagList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.tagList_.add(Integer.valueOf(rawValue));
                                    break;
                                case 122:
                                    int oldLimit = input.pushLimit(input.readRawVarint32());
                                    while (input.getBytesUntilLimit() > 0) {
                                        int rawValue2 = input.readEnum();
                                        if ((mutable_bitField0_ & 1) == 0) {
                                            this.tagList_ = new ArrayList();
                                            mutable_bitField0_ |= 1;
                                        }
                                        this.tagList_.add(Integer.valueOf(rawValue2));
                                    }
                                    input.popLimit(oldLimit);
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
                    this.tagList_ = Collections.unmodifiableList(this.tagList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SetWidgetSlotRspOuterClass.internal_static_SetWidgetSlotRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SetWidgetSlotRspOuterClass.internal_static_SetWidgetSlotRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(SetWidgetSlotRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SetWidgetSlotRspOuterClass.SetWidgetSlotRspOrBuilder
        public int getMaterialId() {
            return this.materialId_;
        }

        @Override // emu.grasscutter.net.proto.SetWidgetSlotRspOuterClass.SetWidgetSlotRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.SetWidgetSlotRspOuterClass.SetWidgetSlotRspOrBuilder
        public List<WidgetSlotTagOuterClass.WidgetSlotTag> getTagListList() {
            return new Internal.ListAdapter(this.tagList_, tagList_converter_);
        }

        @Override // emu.grasscutter.net.proto.SetWidgetSlotRspOuterClass.SetWidgetSlotRspOrBuilder
        public int getTagListCount() {
            return this.tagList_.size();
        }

        @Override // emu.grasscutter.net.proto.SetWidgetSlotRspOuterClass.SetWidgetSlotRspOrBuilder
        public WidgetSlotTagOuterClass.WidgetSlotTag getTagList(int index) {
            return tagList_converter_.convert(this.tagList_.get(index));
        }

        @Override // emu.grasscutter.net.proto.SetWidgetSlotRspOuterClass.SetWidgetSlotRspOrBuilder
        public List<Integer> getTagListValueList() {
            return this.tagList_;
        }

        @Override // emu.grasscutter.net.proto.SetWidgetSlotRspOuterClass.SetWidgetSlotRspOrBuilder
        public int getTagListValue(int index) {
            return this.tagList_.get(index).intValue();
        }

        @Override // emu.grasscutter.net.proto.SetWidgetSlotRspOuterClass.SetWidgetSlotRspOrBuilder
        public int getOpValue() {
            return this.op_;
        }

        @Override // emu.grasscutter.net.proto.SetWidgetSlotRspOuterClass.SetWidgetSlotRspOrBuilder
        public WidgetSlotOpOuterClass.WidgetSlotOp getOp() {
            WidgetSlotOpOuterClass.WidgetSlotOp result = WidgetSlotOpOuterClass.WidgetSlotOp.valueOf(this.op_);
            return result == null ? WidgetSlotOpOuterClass.WidgetSlotOp.UNRECOGNIZED : result;
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
            if (this.retcode_ != 0) {
                output.writeInt32(1, this.retcode_);
            }
            if (this.materialId_ != 0) {
                output.writeUInt32(4, this.materialId_);
            }
            if (this.op_ != WidgetSlotOpOuterClass.WidgetSlotOp.WIDGET_SLOT_OP_ATTACH.getNumber()) {
                output.writeEnum(5, this.op_);
            }
            if (getTagListList().size() > 0) {
                output.writeUInt32NoTag(122);
                output.writeUInt32NoTag(this.tagListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.tagList_.size(); i++) {
                output.writeEnumNoTag(this.tagList_.get(i).intValue());
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
            if (this.retcode_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(1, this.retcode_);
            }
            if (this.materialId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.materialId_);
            }
            if (this.op_ != WidgetSlotOpOuterClass.WidgetSlotOp.WIDGET_SLOT_OP_ATTACH.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(5, this.op_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.tagList_.size(); i++) {
                dataSize += CodedOutputStream.computeEnumSizeNoTag(this.tagList_.get(i).intValue());
            }
            int size3 = size2 + dataSize;
            if (!getTagListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeUInt32SizeNoTag(dataSize);
            }
            this.tagListMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SetWidgetSlotRsp)) {
                return equals(obj);
            }
            SetWidgetSlotRsp other = (SetWidgetSlotRsp) obj;
            return getMaterialId() == other.getMaterialId() && getRetcode() == other.getRetcode() && this.tagList_.equals(other.tagList_) && this.op_ == other.op_ && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getMaterialId())) + 1)) + getRetcode();
            if (getTagListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + this.tagList_.hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 5)) + this.op_)) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SetWidgetSlotRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetWidgetSlotRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetWidgetSlotRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetWidgetSlotRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetWidgetSlotRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetWidgetSlotRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetWidgetSlotRsp parseFrom(InputStream input) throws IOException {
            return (SetWidgetSlotRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetWidgetSlotRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetWidgetSlotRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetWidgetSlotRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (SetWidgetSlotRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SetWidgetSlotRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetWidgetSlotRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetWidgetSlotRsp parseFrom(CodedInputStream input) throws IOException {
            return (SetWidgetSlotRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetWidgetSlotRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetWidgetSlotRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SetWidgetSlotRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetWidgetSlotRspOuterClass$SetWidgetSlotRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SetWidgetSlotRspOrBuilder {
            private int bitField0_;
            private int materialId_;
            private int retcode_;
            private List<Integer> tagList_ = Collections.emptyList();
            private int op_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return SetWidgetSlotRspOuterClass.internal_static_SetWidgetSlotRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SetWidgetSlotRspOuterClass.internal_static_SetWidgetSlotRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(SetWidgetSlotRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SetWidgetSlotRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.materialId_ = 0;
                this.retcode_ = 0;
                this.tagList_ = Collections.emptyList();
                this.bitField0_ &= -2;
                this.op_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SetWidgetSlotRspOuterClass.internal_static_SetWidgetSlotRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SetWidgetSlotRsp getDefaultInstanceForType() {
                return SetWidgetSlotRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetWidgetSlotRsp build() {
                SetWidgetSlotRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetWidgetSlotRsp buildPartial() {
                SetWidgetSlotRsp result = new SetWidgetSlotRsp(this);
                int i = this.bitField0_;
                result.materialId_ = this.materialId_;
                result.retcode_ = this.retcode_;
                if ((this.bitField0_ & 1) != 0) {
                    this.tagList_ = Collections.unmodifiableList(this.tagList_);
                    this.bitField0_ &= -2;
                }
                result.tagList_ = this.tagList_;
                result.op_ = this.op_;
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
                if (other instanceof SetWidgetSlotRsp) {
                    return mergeFrom((SetWidgetSlotRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SetWidgetSlotRsp other) {
                if (other == SetWidgetSlotRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getMaterialId() != 0) {
                    setMaterialId(other.getMaterialId());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (!other.tagList_.isEmpty()) {
                    if (this.tagList_.isEmpty()) {
                        this.tagList_ = other.tagList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureTagListIsMutable();
                        this.tagList_.addAll(other.tagList_);
                    }
                    onChanged();
                }
                if (other.op_ != 0) {
                    setOpValue(other.getOpValue());
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
                SetWidgetSlotRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = SetWidgetSlotRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SetWidgetSlotRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SetWidgetSlotRspOuterClass.SetWidgetSlotRspOrBuilder
            public int getMaterialId() {
                return this.materialId_;
            }

            public Builder setMaterialId(int value) {
                this.materialId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaterialId() {
                this.materialId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SetWidgetSlotRspOuterClass.SetWidgetSlotRspOrBuilder
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

            private void ensureTagListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.tagList_ = new ArrayList(this.tagList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SetWidgetSlotRspOuterClass.SetWidgetSlotRspOrBuilder
            public List<WidgetSlotTagOuterClass.WidgetSlotTag> getTagListList() {
                return new Internal.ListAdapter(this.tagList_, SetWidgetSlotRsp.tagList_converter_);
            }

            @Override // emu.grasscutter.net.proto.SetWidgetSlotRspOuterClass.SetWidgetSlotRspOrBuilder
            public int getTagListCount() {
                return this.tagList_.size();
            }

            @Override // emu.grasscutter.net.proto.SetWidgetSlotRspOuterClass.SetWidgetSlotRspOrBuilder
            public WidgetSlotTagOuterClass.WidgetSlotTag getTagList(int index) {
                return SetWidgetSlotRsp.tagList_converter_.convert(this.tagList_.get(index));
            }

            public Builder setTagList(int index, WidgetSlotTagOuterClass.WidgetSlotTag value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureTagListIsMutable();
                this.tagList_.set(index, Integer.valueOf(value.getNumber()));
                onChanged();
                return this;
            }

            public Builder addTagList(WidgetSlotTagOuterClass.WidgetSlotTag value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureTagListIsMutable();
                this.tagList_.add(Integer.valueOf(value.getNumber()));
                onChanged();
                return this;
            }

            public Builder addAllTagList(Iterable<? extends WidgetSlotTagOuterClass.WidgetSlotTag> values) {
                ensureTagListIsMutable();
                for (WidgetSlotTagOuterClass.WidgetSlotTag value : values) {
                    this.tagList_.add(Integer.valueOf(value.getNumber()));
                }
                onChanged();
                return this;
            }

            public Builder clearTagList() {
                this.tagList_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SetWidgetSlotRspOuterClass.SetWidgetSlotRspOrBuilder
            public List<Integer> getTagListValueList() {
                return Collections.unmodifiableList(this.tagList_);
            }

            @Override // emu.grasscutter.net.proto.SetWidgetSlotRspOuterClass.SetWidgetSlotRspOrBuilder
            public int getTagListValue(int index) {
                return this.tagList_.get(index).intValue();
            }

            public Builder setTagListValue(int index, int value) {
                ensureTagListIsMutable();
                this.tagList_.set(index, Integer.valueOf(value));
                onChanged();
                return this;
            }

            public Builder addTagListValue(int value) {
                ensureTagListIsMutable();
                this.tagList_.add(Integer.valueOf(value));
                onChanged();
                return this;
            }

            public Builder addAllTagListValue(Iterable<Integer> values) {
                ensureTagListIsMutable();
                for (Integer num : values) {
                    this.tagList_.add(Integer.valueOf(num.intValue()));
                }
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SetWidgetSlotRspOuterClass.SetWidgetSlotRspOrBuilder
            public int getOpValue() {
                return this.op_;
            }

            public Builder setOpValue(int value) {
                this.op_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SetWidgetSlotRspOuterClass.SetWidgetSlotRspOrBuilder
            public WidgetSlotOpOuterClass.WidgetSlotOp getOp() {
                WidgetSlotOpOuterClass.WidgetSlotOp result = WidgetSlotOpOuterClass.WidgetSlotOp.valueOf(this.op_);
                return result == null ? WidgetSlotOpOuterClass.WidgetSlotOp.UNRECOGNIZED : result;
            }

            public Builder setOp(WidgetSlotOpOuterClass.WidgetSlotOp value) {
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static SetWidgetSlotRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SetWidgetSlotRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SetWidgetSlotRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SetWidgetSlotRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        WidgetSlotOpOuterClass.getDescriptor();
        WidgetSlotTagOuterClass.getDescriptor();
    }
}
