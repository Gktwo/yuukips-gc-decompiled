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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetWidgetSlotReqOuterClass.class */
public final class SetWidgetSlotReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016SetWidgetSlotReq.proto\u001a\u0012WidgetSlotOp.proto\u001a\u0013WidgetSlotTag.proto\"b\n\u0010SetWidgetSlotReq\u0012\u001f\n\u0007tagList\u0018\r \u0003(\u000e2\u000e.WidgetSlotTag\u0012\u0019\n\u0002op\u0018\u0003 \u0001(\u000e2\r.WidgetSlotOp\u0012\u0012\n\nmaterialId\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{WidgetSlotOpOuterClass.getDescriptor(), WidgetSlotTagOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SetWidgetSlotReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SetWidgetSlotReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SetWidgetSlotReq_descriptor, new String[]{"TagList", "Op", "MaterialId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetWidgetSlotReqOuterClass$SetWidgetSlotReqOrBuilder.class */
    public interface SetWidgetSlotReqOrBuilder extends MessageOrBuilder {
        List<WidgetSlotTagOuterClass.WidgetSlotTag> getTagListList();

        int getTagListCount();

        WidgetSlotTagOuterClass.WidgetSlotTag getTagList(int i);

        List<Integer> getTagListValueList();

        int getTagListValue(int i);

        int getOpValue();

        WidgetSlotOpOuterClass.WidgetSlotOp getOp();

        int getMaterialId();
    }

    private SetWidgetSlotReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetWidgetSlotReqOuterClass$SetWidgetSlotReq.class */
    public static final class SetWidgetSlotReq extends GeneratedMessageV3 implements SetWidgetSlotReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TAGLIST_FIELD_NUMBER = 13;
        private List<Integer> tagList_;
        private int tagListMemoizedSerializedSize;
        public static final int OP_FIELD_NUMBER = 3;
        private int op_;
        public static final int MATERIALID_FIELD_NUMBER = 4;
        private int materialId_;
        private byte memoizedIsInitialized;
        private static final Internal.ListAdapter.Converter<Integer, WidgetSlotTagOuterClass.WidgetSlotTag> tagList_converter_ = new Internal.ListAdapter.Converter<Integer, WidgetSlotTagOuterClass.WidgetSlotTag>() { // from class: emu.grasscutter.net.proto.SetWidgetSlotReqOuterClass.SetWidgetSlotReq.1
            public WidgetSlotTagOuterClass.WidgetSlotTag convert(Integer from) {
                WidgetSlotTagOuterClass.WidgetSlotTag result = WidgetSlotTagOuterClass.WidgetSlotTag.valueOf(from.intValue());
                return result == null ? WidgetSlotTagOuterClass.WidgetSlotTag.UNRECOGNIZED : result;
            }
        };
        private static final SetWidgetSlotReq DEFAULT_INSTANCE = new SetWidgetSlotReq();
        private static final Parser<SetWidgetSlotReq> PARSER = new AbstractParser<SetWidgetSlotReq>() { // from class: emu.grasscutter.net.proto.SetWidgetSlotReqOuterClass.SetWidgetSlotReq.2
            @Override // com.google.protobuf.Parser
            public SetWidgetSlotReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SetWidgetSlotReq(input, extensionRegistry);
            }
        };

        private SetWidgetSlotReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SetWidgetSlotReq() {
            this.memoizedIsInitialized = -1;
            this.tagList_ = Collections.emptyList();
            this.op_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SetWidgetSlotReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SetWidgetSlotReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.op_ = input.readEnum();
                                break;
                            case 32:
                                this.materialId_ = input.readUInt32();
                                break;
                            case 104:
                                int rawValue = input.readEnum();
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.tagList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.tagList_.add(Integer.valueOf(rawValue));
                                break;
                            case 106:
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
            return SetWidgetSlotReqOuterClass.internal_static_SetWidgetSlotReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SetWidgetSlotReqOuterClass.internal_static_SetWidgetSlotReq_fieldAccessorTable.ensureFieldAccessorsInitialized(SetWidgetSlotReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SetWidgetSlotReqOuterClass.SetWidgetSlotReqOrBuilder
        public List<WidgetSlotTagOuterClass.WidgetSlotTag> getTagListList() {
            return new Internal.ListAdapter(this.tagList_, tagList_converter_);
        }

        @Override // emu.grasscutter.net.proto.SetWidgetSlotReqOuterClass.SetWidgetSlotReqOrBuilder
        public int getTagListCount() {
            return this.tagList_.size();
        }

        @Override // emu.grasscutter.net.proto.SetWidgetSlotReqOuterClass.SetWidgetSlotReqOrBuilder
        public WidgetSlotTagOuterClass.WidgetSlotTag getTagList(int index) {
            return tagList_converter_.convert(this.tagList_.get(index));
        }

        @Override // emu.grasscutter.net.proto.SetWidgetSlotReqOuterClass.SetWidgetSlotReqOrBuilder
        public List<Integer> getTagListValueList() {
            return this.tagList_;
        }

        @Override // emu.grasscutter.net.proto.SetWidgetSlotReqOuterClass.SetWidgetSlotReqOrBuilder
        public int getTagListValue(int index) {
            return this.tagList_.get(index).intValue();
        }

        @Override // emu.grasscutter.net.proto.SetWidgetSlotReqOuterClass.SetWidgetSlotReqOrBuilder
        public int getOpValue() {
            return this.op_;
        }

        @Override // emu.grasscutter.net.proto.SetWidgetSlotReqOuterClass.SetWidgetSlotReqOrBuilder
        public WidgetSlotOpOuterClass.WidgetSlotOp getOp() {
            WidgetSlotOpOuterClass.WidgetSlotOp result = WidgetSlotOpOuterClass.WidgetSlotOp.valueOf(this.op_);
            return result == null ? WidgetSlotOpOuterClass.WidgetSlotOp.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.SetWidgetSlotReqOuterClass.SetWidgetSlotReqOrBuilder
        public int getMaterialId() {
            return this.materialId_;
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
            if (this.op_ != WidgetSlotOpOuterClass.WidgetSlotOp.WIDGET_SLOT_OP_ATTACH.getNumber()) {
                output.writeEnum(3, this.op_);
            }
            if (this.materialId_ != 0) {
                output.writeUInt32(4, this.materialId_);
            }
            if (getTagListList().size() > 0) {
                output.writeUInt32NoTag(106);
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
            if (this.op_ != WidgetSlotOpOuterClass.WidgetSlotOp.WIDGET_SLOT_OP_ATTACH.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(3, this.op_);
            }
            if (this.materialId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.materialId_);
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
            if (!(obj instanceof SetWidgetSlotReq)) {
                return equals(obj);
            }
            SetWidgetSlotReq other = (SetWidgetSlotReq) obj;
            return this.tagList_.equals(other.tagList_) && this.op_ == other.op_ && getMaterialId() == other.getMaterialId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getTagListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + this.tagList_.hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 3)) + this.op_)) + 4)) + getMaterialId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SetWidgetSlotReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetWidgetSlotReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetWidgetSlotReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetWidgetSlotReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetWidgetSlotReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetWidgetSlotReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetWidgetSlotReq parseFrom(InputStream input) throws IOException {
            return (SetWidgetSlotReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetWidgetSlotReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetWidgetSlotReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetWidgetSlotReq parseDelimitedFrom(InputStream input) throws IOException {
            return (SetWidgetSlotReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SetWidgetSlotReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetWidgetSlotReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetWidgetSlotReq parseFrom(CodedInputStream input) throws IOException {
            return (SetWidgetSlotReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetWidgetSlotReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetWidgetSlotReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SetWidgetSlotReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetWidgetSlotReqOuterClass$SetWidgetSlotReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SetWidgetSlotReqOrBuilder {
            private int bitField0_;
            private List<Integer> tagList_ = Collections.emptyList();
            private int op_ = 0;
            private int materialId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SetWidgetSlotReqOuterClass.internal_static_SetWidgetSlotReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SetWidgetSlotReqOuterClass.internal_static_SetWidgetSlotReq_fieldAccessorTable.ensureFieldAccessorsInitialized(SetWidgetSlotReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SetWidgetSlotReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.tagList_ = Collections.emptyList();
                this.bitField0_ &= -2;
                this.op_ = 0;
                this.materialId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SetWidgetSlotReqOuterClass.internal_static_SetWidgetSlotReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SetWidgetSlotReq getDefaultInstanceForType() {
                return SetWidgetSlotReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetWidgetSlotReq build() {
                SetWidgetSlotReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetWidgetSlotReq buildPartial() {
                SetWidgetSlotReq result = new SetWidgetSlotReq(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.tagList_ = Collections.unmodifiableList(this.tagList_);
                    this.bitField0_ &= -2;
                }
                result.tagList_ = this.tagList_;
                result.op_ = this.op_;
                result.materialId_ = this.materialId_;
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
                if (other instanceof SetWidgetSlotReq) {
                    return mergeFrom((SetWidgetSlotReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SetWidgetSlotReq other) {
                if (other == SetWidgetSlotReq.getDefaultInstance()) {
                    return this;
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
                if (other.getMaterialId() != 0) {
                    setMaterialId(other.getMaterialId());
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
                SetWidgetSlotReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = SetWidgetSlotReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SetWidgetSlotReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureTagListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.tagList_ = new ArrayList(this.tagList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SetWidgetSlotReqOuterClass.SetWidgetSlotReqOrBuilder
            public List<WidgetSlotTagOuterClass.WidgetSlotTag> getTagListList() {
                return new Internal.ListAdapter(this.tagList_, SetWidgetSlotReq.tagList_converter_);
            }

            @Override // emu.grasscutter.net.proto.SetWidgetSlotReqOuterClass.SetWidgetSlotReqOrBuilder
            public int getTagListCount() {
                return this.tagList_.size();
            }

            @Override // emu.grasscutter.net.proto.SetWidgetSlotReqOuterClass.SetWidgetSlotReqOrBuilder
            public WidgetSlotTagOuterClass.WidgetSlotTag getTagList(int index) {
                return SetWidgetSlotReq.tagList_converter_.convert(this.tagList_.get(index));
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

            @Override // emu.grasscutter.net.proto.SetWidgetSlotReqOuterClass.SetWidgetSlotReqOrBuilder
            public List<Integer> getTagListValueList() {
                return Collections.unmodifiableList(this.tagList_);
            }

            @Override // emu.grasscutter.net.proto.SetWidgetSlotReqOuterClass.SetWidgetSlotReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.SetWidgetSlotReqOuterClass.SetWidgetSlotReqOrBuilder
            public int getOpValue() {
                return this.op_;
            }

            public Builder setOpValue(int value) {
                this.op_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SetWidgetSlotReqOuterClass.SetWidgetSlotReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.SetWidgetSlotReqOuterClass.SetWidgetSlotReqOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static SetWidgetSlotReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SetWidgetSlotReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SetWidgetSlotReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SetWidgetSlotReq getDefaultInstanceForType() {
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
