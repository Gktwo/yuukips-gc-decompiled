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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetGadgetDataOuterClass.class */
public final class WidgetGadgetDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016WidgetGadgetData.proto\"@\n\u0010WidgetGadgetData\u0012\u001a\n\u0012gadgetEntityIdList\u0018\u000f \u0003(\r\u0012\u0010\n\bgadgetId\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_WidgetGadgetData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WidgetGadgetData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WidgetGadgetData_descriptor, new String[]{"GadgetEntityIdList", "GadgetId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetGadgetDataOuterClass$WidgetGadgetDataOrBuilder.class */
    public interface WidgetGadgetDataOrBuilder extends MessageOrBuilder {
        List<Integer> getGadgetEntityIdListList();

        int getGadgetEntityIdListCount();

        int getGadgetEntityIdList(int i);

        int getGadgetId();
    }

    private WidgetGadgetDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetGadgetDataOuterClass$WidgetGadgetData.class */
    public static final class WidgetGadgetData extends GeneratedMessageV3 implements WidgetGadgetDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GADGETENTITYIDLIST_FIELD_NUMBER = 15;
        private Internal.IntList gadgetEntityIdList_;
        private int gadgetEntityIdListMemoizedSerializedSize;
        public static final int GADGETID_FIELD_NUMBER = 9;
        private int gadgetId_;
        private byte memoizedIsInitialized;
        private static final WidgetGadgetData DEFAULT_INSTANCE = new WidgetGadgetData();
        private static final Parser<WidgetGadgetData> PARSER = new AbstractParser<WidgetGadgetData>() { // from class: emu.grasscutter.net.proto.WidgetGadgetDataOuterClass.WidgetGadgetData.1
            @Override // com.google.protobuf.Parser
            public WidgetGadgetData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WidgetGadgetData(input, extensionRegistry);
            }
        };

        private WidgetGadgetData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.gadgetEntityIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private WidgetGadgetData() {
            this.gadgetEntityIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.gadgetEntityIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WidgetGadgetData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WidgetGadgetData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 72:
                                    this.gadgetId_ = input.readUInt32();
                                    break;
                                case 120:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.gadgetEntityIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.gadgetEntityIdList_.addInt(input.readUInt32());
                                    break;
                                case 122:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.gadgetEntityIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.gadgetEntityIdList_.addInt(input.readUInt32());
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.gadgetEntityIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WidgetGadgetDataOuterClass.internal_static_WidgetGadgetData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WidgetGadgetDataOuterClass.internal_static_WidgetGadgetData_fieldAccessorTable.ensureFieldAccessorsInitialized(WidgetGadgetData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WidgetGadgetDataOuterClass.WidgetGadgetDataOrBuilder
        public List<Integer> getGadgetEntityIdListList() {
            return this.gadgetEntityIdList_;
        }

        @Override // emu.grasscutter.net.proto.WidgetGadgetDataOuterClass.WidgetGadgetDataOrBuilder
        public int getGadgetEntityIdListCount() {
            return this.gadgetEntityIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.WidgetGadgetDataOuterClass.WidgetGadgetDataOrBuilder
        public int getGadgetEntityIdList(int index) {
            return this.gadgetEntityIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.WidgetGadgetDataOuterClass.WidgetGadgetDataOrBuilder
        public int getGadgetId() {
            return this.gadgetId_;
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
            if (this.gadgetId_ != 0) {
                output.writeUInt32(9, this.gadgetId_);
            }
            if (getGadgetEntityIdListList().size() > 0) {
                output.writeUInt32NoTag(122);
                output.writeUInt32NoTag(this.gadgetEntityIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.gadgetEntityIdList_.size(); i++) {
                output.writeUInt32NoTag(this.gadgetEntityIdList_.getInt(i));
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
            if (this.gadgetId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(9, this.gadgetId_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.gadgetEntityIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.gadgetEntityIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getGadgetEntityIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.gadgetEntityIdListMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WidgetGadgetData)) {
                return equals(obj);
            }
            WidgetGadgetData other = (WidgetGadgetData) obj;
            return getGadgetEntityIdListList().equals(other.getGadgetEntityIdListList()) && getGadgetId() == other.getGadgetId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getGadgetEntityIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getGadgetEntityIdListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 9)) + getGadgetId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WidgetGadgetData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetGadgetData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetGadgetData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetGadgetData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetGadgetData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetGadgetData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetGadgetData parseFrom(InputStream input) throws IOException {
            return (WidgetGadgetData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WidgetGadgetData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetGadgetData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WidgetGadgetData parseDelimitedFrom(InputStream input) throws IOException {
            return (WidgetGadgetData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WidgetGadgetData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetGadgetData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WidgetGadgetData parseFrom(CodedInputStream input) throws IOException {
            return (WidgetGadgetData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WidgetGadgetData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetGadgetData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WidgetGadgetData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetGadgetDataOuterClass$WidgetGadgetData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WidgetGadgetDataOrBuilder {
            private int bitField0_;
            private Internal.IntList gadgetEntityIdList_ = WidgetGadgetData.emptyIntList();
            private int gadgetId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WidgetGadgetDataOuterClass.internal_static_WidgetGadgetData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WidgetGadgetDataOuterClass.internal_static_WidgetGadgetData_fieldAccessorTable.ensureFieldAccessorsInitialized(WidgetGadgetData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WidgetGadgetData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.gadgetEntityIdList_ = WidgetGadgetData.emptyIntList();
                this.bitField0_ &= -2;
                this.gadgetId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WidgetGadgetDataOuterClass.internal_static_WidgetGadgetData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WidgetGadgetData getDefaultInstanceForType() {
                return WidgetGadgetData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WidgetGadgetData build() {
                WidgetGadgetData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WidgetGadgetData buildPartial() {
                WidgetGadgetData result = new WidgetGadgetData(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.gadgetEntityIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.gadgetEntityIdList_ = this.gadgetEntityIdList_;
                result.gadgetId_ = this.gadgetId_;
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
                if (other instanceof WidgetGadgetData) {
                    return mergeFrom((WidgetGadgetData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WidgetGadgetData other) {
                if (other == WidgetGadgetData.getDefaultInstance()) {
                    return this;
                }
                if (!other.gadgetEntityIdList_.isEmpty()) {
                    if (this.gadgetEntityIdList_.isEmpty()) {
                        this.gadgetEntityIdList_ = other.gadgetEntityIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureGadgetEntityIdListIsMutable();
                        this.gadgetEntityIdList_.addAll(other.gadgetEntityIdList_);
                    }
                    onChanged();
                }
                if (other.getGadgetId() != 0) {
                    setGadgetId(other.getGadgetId());
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
                WidgetGadgetData parsedMessage = null;
                try {
                    try {
                        parsedMessage = WidgetGadgetData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WidgetGadgetData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureGadgetEntityIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.gadgetEntityIdList_ = WidgetGadgetData.mutableCopy(this.gadgetEntityIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.WidgetGadgetDataOuterClass.WidgetGadgetDataOrBuilder
            public List<Integer> getGadgetEntityIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.gadgetEntityIdList_) : this.gadgetEntityIdList_;
            }

            @Override // emu.grasscutter.net.proto.WidgetGadgetDataOuterClass.WidgetGadgetDataOrBuilder
            public int getGadgetEntityIdListCount() {
                return this.gadgetEntityIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.WidgetGadgetDataOuterClass.WidgetGadgetDataOrBuilder
            public int getGadgetEntityIdList(int index) {
                return this.gadgetEntityIdList_.getInt(index);
            }

            public Builder setGadgetEntityIdList(int index, int value) {
                ensureGadgetEntityIdListIsMutable();
                this.gadgetEntityIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addGadgetEntityIdList(int value) {
                ensureGadgetEntityIdListIsMutable();
                this.gadgetEntityIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllGadgetEntityIdList(Iterable<? extends Integer> values) {
                ensureGadgetEntityIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.gadgetEntityIdList_);
                onChanged();
                return this;
            }

            public Builder clearGadgetEntityIdList() {
                this.gadgetEntityIdList_ = WidgetGadgetData.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WidgetGadgetDataOuterClass.WidgetGadgetDataOrBuilder
            public int getGadgetId() {
                return this.gadgetId_;
            }

            public Builder setGadgetId(int value) {
                this.gadgetId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGadgetId() {
                this.gadgetId_ = 0;
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

        public static WidgetGadgetData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WidgetGadgetData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WidgetGadgetData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WidgetGadgetData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
