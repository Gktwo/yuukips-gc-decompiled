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
import emu.grasscutter.net.proto.WidgetSlotDataOuterClass;
import emu.grasscutter.net.proto.WidgetSlotOpOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetSlotChangeNotifyOuterClass.class */
public final class WidgetSlotChangeNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cWidgetSlotChangeNotify.proto\u001a\u0014WidgetSlotData.proto\u001a\u0012WidgetSlotOp.proto\"R\n\u0016WidgetSlotChangeNotify\u0012\u0019\n\u0002op\u0018\u0005 \u0001(\u000e2\r.WidgetSlotOp\u0012\u001d\n\u0004slot\u0018\u0002 \u0001(\u000b2\u000f.WidgetSlotDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{WidgetSlotDataOuterClass.getDescriptor(), WidgetSlotOpOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WidgetSlotChangeNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WidgetSlotChangeNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WidgetSlotChangeNotify_descriptor, new String[]{"Op", "Slot"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetSlotChangeNotifyOuterClass$WidgetSlotChangeNotifyOrBuilder.class */
    public interface WidgetSlotChangeNotifyOrBuilder extends MessageOrBuilder {
        int getOpValue();

        WidgetSlotOpOuterClass.WidgetSlotOp getOp();

        boolean hasSlot();

        WidgetSlotDataOuterClass.WidgetSlotData getSlot();

        WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder getSlotOrBuilder();
    }

    private WidgetSlotChangeNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetSlotChangeNotifyOuterClass$WidgetSlotChangeNotify.class */
    public static final class WidgetSlotChangeNotify extends GeneratedMessageV3 implements WidgetSlotChangeNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int OP_FIELD_NUMBER = 5;
        private int op_;
        public static final int SLOT_FIELD_NUMBER = 2;
        private WidgetSlotDataOuterClass.WidgetSlotData slot_;
        private byte memoizedIsInitialized;
        private static final WidgetSlotChangeNotify DEFAULT_INSTANCE = new WidgetSlotChangeNotify();
        private static final Parser<WidgetSlotChangeNotify> PARSER = new AbstractParser<WidgetSlotChangeNotify>() { // from class: emu.grasscutter.net.proto.WidgetSlotChangeNotifyOuterClass.WidgetSlotChangeNotify.1
            @Override // com.google.protobuf.Parser
            public WidgetSlotChangeNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WidgetSlotChangeNotify(input, extensionRegistry);
            }
        };

        private WidgetSlotChangeNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WidgetSlotChangeNotify() {
            this.memoizedIsInitialized = -1;
            this.op_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WidgetSlotChangeNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WidgetSlotChangeNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 18:
                                    WidgetSlotDataOuterClass.WidgetSlotData.Builder subBuilder = this.slot_ != null ? this.slot_.toBuilder() : null;
                                    this.slot_ = (WidgetSlotDataOuterClass.WidgetSlotData) input.readMessage(WidgetSlotDataOuterClass.WidgetSlotData.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.slot_);
                                        this.slot_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 40:
                                    this.op_ = input.readEnum();
                                    break;
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
            return WidgetSlotChangeNotifyOuterClass.internal_static_WidgetSlotChangeNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WidgetSlotChangeNotifyOuterClass.internal_static_WidgetSlotChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WidgetSlotChangeNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WidgetSlotChangeNotifyOuterClass.WidgetSlotChangeNotifyOrBuilder
        public int getOpValue() {
            return this.op_;
        }

        @Override // emu.grasscutter.net.proto.WidgetSlotChangeNotifyOuterClass.WidgetSlotChangeNotifyOrBuilder
        public WidgetSlotOpOuterClass.WidgetSlotOp getOp() {
            WidgetSlotOpOuterClass.WidgetSlotOp result = WidgetSlotOpOuterClass.WidgetSlotOp.valueOf(this.op_);
            return result == null ? WidgetSlotOpOuterClass.WidgetSlotOp.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.WidgetSlotChangeNotifyOuterClass.WidgetSlotChangeNotifyOrBuilder
        public boolean hasSlot() {
            return this.slot_ != null;
        }

        @Override // emu.grasscutter.net.proto.WidgetSlotChangeNotifyOuterClass.WidgetSlotChangeNotifyOrBuilder
        public WidgetSlotDataOuterClass.WidgetSlotData getSlot() {
            return this.slot_ == null ? WidgetSlotDataOuterClass.WidgetSlotData.getDefaultInstance() : this.slot_;
        }

        @Override // emu.grasscutter.net.proto.WidgetSlotChangeNotifyOuterClass.WidgetSlotChangeNotifyOrBuilder
        public WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder getSlotOrBuilder() {
            return getSlot();
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
            if (this.slot_ != null) {
                output.writeMessage(2, getSlot());
            }
            if (this.op_ != WidgetSlotOpOuterClass.WidgetSlotOp.WIDGET_SLOT_OP_ATTACH.getNumber()) {
                output.writeEnum(5, this.op_);
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
            if (this.slot_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(2, getSlot());
            }
            if (this.op_ != WidgetSlotOpOuterClass.WidgetSlotOp.WIDGET_SLOT_OP_ATTACH.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(5, this.op_);
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
            if (!(obj instanceof WidgetSlotChangeNotify)) {
                return equals(obj);
            }
            WidgetSlotChangeNotify other = (WidgetSlotChangeNotify) obj;
            if (this.op_ == other.op_ && hasSlot() == other.hasSlot()) {
                return (!hasSlot() || getSlot().equals(other.getSlot())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + this.op_;
            if (hasSlot()) {
                hash = (53 * ((37 * hash) + 2)) + getSlot().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WidgetSlotChangeNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetSlotChangeNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetSlotChangeNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetSlotChangeNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetSlotChangeNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetSlotChangeNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetSlotChangeNotify parseFrom(InputStream input) throws IOException {
            return (WidgetSlotChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WidgetSlotChangeNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetSlotChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WidgetSlotChangeNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (WidgetSlotChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WidgetSlotChangeNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetSlotChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WidgetSlotChangeNotify parseFrom(CodedInputStream input) throws IOException {
            return (WidgetSlotChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WidgetSlotChangeNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetSlotChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WidgetSlotChangeNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetSlotChangeNotifyOuterClass$WidgetSlotChangeNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WidgetSlotChangeNotifyOrBuilder {
            private int op_ = 0;
            private WidgetSlotDataOuterClass.WidgetSlotData slot_;
            private SingleFieldBuilderV3<WidgetSlotDataOuterClass.WidgetSlotData, WidgetSlotDataOuterClass.WidgetSlotData.Builder, WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder> slotBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WidgetSlotChangeNotifyOuterClass.internal_static_WidgetSlotChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WidgetSlotChangeNotifyOuterClass.internal_static_WidgetSlotChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WidgetSlotChangeNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WidgetSlotChangeNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.op_ = 0;
                if (this.slotBuilder_ == null) {
                    this.slot_ = null;
                } else {
                    this.slot_ = null;
                    this.slotBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WidgetSlotChangeNotifyOuterClass.internal_static_WidgetSlotChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WidgetSlotChangeNotify getDefaultInstanceForType() {
                return WidgetSlotChangeNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WidgetSlotChangeNotify build() {
                WidgetSlotChangeNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WidgetSlotChangeNotify buildPartial() {
                WidgetSlotChangeNotify result = new WidgetSlotChangeNotify(this);
                result.op_ = this.op_;
                if (this.slotBuilder_ == null) {
                    result.slot_ = this.slot_;
                } else {
                    result.slot_ = this.slotBuilder_.build();
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
                if (other instanceof WidgetSlotChangeNotify) {
                    return mergeFrom((WidgetSlotChangeNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WidgetSlotChangeNotify other) {
                if (other == WidgetSlotChangeNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.op_ != 0) {
                    setOpValue(other.getOpValue());
                }
                if (other.hasSlot()) {
                    mergeSlot(other.getSlot());
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
                WidgetSlotChangeNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = WidgetSlotChangeNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WidgetSlotChangeNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.WidgetSlotChangeNotifyOuterClass.WidgetSlotChangeNotifyOrBuilder
            public int getOpValue() {
                return this.op_;
            }

            public Builder setOpValue(int value) {
                this.op_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WidgetSlotChangeNotifyOuterClass.WidgetSlotChangeNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.WidgetSlotChangeNotifyOuterClass.WidgetSlotChangeNotifyOrBuilder
            public boolean hasSlot() {
                return (this.slotBuilder_ == null && this.slot_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.WidgetSlotChangeNotifyOuterClass.WidgetSlotChangeNotifyOrBuilder
            public WidgetSlotDataOuterClass.WidgetSlotData getSlot() {
                if (this.slotBuilder_ == null) {
                    return this.slot_ == null ? WidgetSlotDataOuterClass.WidgetSlotData.getDefaultInstance() : this.slot_;
                }
                return this.slotBuilder_.getMessage();
            }

            public Builder setSlot(WidgetSlotDataOuterClass.WidgetSlotData value) {
                if (this.slotBuilder_ != null) {
                    this.slotBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.slot_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setSlot(WidgetSlotDataOuterClass.WidgetSlotData.Builder builderForValue) {
                if (this.slotBuilder_ == null) {
                    this.slot_ = builderForValue.build();
                    onChanged();
                } else {
                    this.slotBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeSlot(WidgetSlotDataOuterClass.WidgetSlotData value) {
                if (this.slotBuilder_ == null) {
                    if (this.slot_ != null) {
                        this.slot_ = WidgetSlotDataOuterClass.WidgetSlotData.newBuilder(this.slot_).mergeFrom(value).buildPartial();
                    } else {
                        this.slot_ = value;
                    }
                    onChanged();
                } else {
                    this.slotBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearSlot() {
                if (this.slotBuilder_ == null) {
                    this.slot_ = null;
                    onChanged();
                } else {
                    this.slot_ = null;
                    this.slotBuilder_ = null;
                }
                return this;
            }

            public WidgetSlotDataOuterClass.WidgetSlotData.Builder getSlotBuilder() {
                onChanged();
                return getSlotFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.WidgetSlotChangeNotifyOuterClass.WidgetSlotChangeNotifyOrBuilder
            public WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder getSlotOrBuilder() {
                if (this.slotBuilder_ != null) {
                    return this.slotBuilder_.getMessageOrBuilder();
                }
                return this.slot_ == null ? WidgetSlotDataOuterClass.WidgetSlotData.getDefaultInstance() : this.slot_;
            }

            private SingleFieldBuilderV3<WidgetSlotDataOuterClass.WidgetSlotData, WidgetSlotDataOuterClass.WidgetSlotData.Builder, WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder> getSlotFieldBuilder() {
                if (this.slotBuilder_ == null) {
                    this.slotBuilder_ = new SingleFieldBuilderV3<>(getSlot(), getParentForChildren(), isClean());
                    this.slot_ = null;
                }
                return this.slotBuilder_;
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

        public static WidgetSlotChangeNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WidgetSlotChangeNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WidgetSlotChangeNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WidgetSlotChangeNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        WidgetSlotDataOuterClass.getDescriptor();
        WidgetSlotOpOuterClass.getDescriptor();
    }
}
