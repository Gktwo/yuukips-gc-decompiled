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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorktopOptionNotifyOuterClass.class */
public final class WorktopOptionNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019WorktopOptionNotify.proto\"D\n\u0013WorktopOptionNotify\u0012\u0013\n\u000boption_list\u0018\n \u0003(\r\u0012\u0018\n\u0010gadget_entity_id\u0018\b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_WorktopOptionNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WorktopOptionNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WorktopOptionNotify_descriptor, new String[]{"OptionList", "GadgetEntityId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorktopOptionNotifyOuterClass$WorktopOptionNotifyOrBuilder.class */
    public interface WorktopOptionNotifyOrBuilder extends MessageOrBuilder {
        List<Integer> getOptionListList();

        int getOptionListCount();

        int getOptionList(int i);

        int getGadgetEntityId();
    }

    private WorktopOptionNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorktopOptionNotifyOuterClass$WorktopOptionNotify.class */
    public static final class WorktopOptionNotify extends GeneratedMessageV3 implements WorktopOptionNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int OPTION_LIST_FIELD_NUMBER = 10;
        private Internal.IntList optionList_;
        private int optionListMemoizedSerializedSize;
        public static final int GADGET_ENTITY_ID_FIELD_NUMBER = 8;
        private int gadgetEntityId_;
        private byte memoizedIsInitialized;
        private static final WorktopOptionNotify DEFAULT_INSTANCE = new WorktopOptionNotify();
        private static final Parser<WorktopOptionNotify> PARSER = new AbstractParser<WorktopOptionNotify>() { // from class: emu.grasscutter.net.proto.WorktopOptionNotifyOuterClass.WorktopOptionNotify.1
            @Override // com.google.protobuf.Parser
            public WorktopOptionNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WorktopOptionNotify(input, extensionRegistry);
            }
        };

        private WorktopOptionNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.optionListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private WorktopOptionNotify() {
            this.optionListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.optionList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WorktopOptionNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WorktopOptionNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 64:
                                    this.gadgetEntityId_ = input.readUInt32();
                                    break;
                                case 80:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.optionList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.optionList_.addInt(input.readUInt32());
                                    break;
                                case 82:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.optionList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.optionList_.addInt(input.readUInt32());
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
                    this.optionList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WorktopOptionNotifyOuterClass.internal_static_WorktopOptionNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WorktopOptionNotifyOuterClass.internal_static_WorktopOptionNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WorktopOptionNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WorktopOptionNotifyOuterClass.WorktopOptionNotifyOrBuilder
        public List<Integer> getOptionListList() {
            return this.optionList_;
        }

        @Override // emu.grasscutter.net.proto.WorktopOptionNotifyOuterClass.WorktopOptionNotifyOrBuilder
        public int getOptionListCount() {
            return this.optionList_.size();
        }

        @Override // emu.grasscutter.net.proto.WorktopOptionNotifyOuterClass.WorktopOptionNotifyOrBuilder
        public int getOptionList(int index) {
            return this.optionList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.WorktopOptionNotifyOuterClass.WorktopOptionNotifyOrBuilder
        public int getGadgetEntityId() {
            return this.gadgetEntityId_;
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
            if (this.gadgetEntityId_ != 0) {
                output.writeUInt32(8, this.gadgetEntityId_);
            }
            if (getOptionListList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.optionListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.optionList_.size(); i++) {
                output.writeUInt32NoTag(this.optionList_.getInt(i));
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
            if (this.gadgetEntityId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(8, this.gadgetEntityId_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.optionList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.optionList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getOptionListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.optionListMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WorktopOptionNotify)) {
                return equals(obj);
            }
            WorktopOptionNotify other = (WorktopOptionNotify) obj;
            return getOptionListList().equals(other.getOptionListList()) && getGadgetEntityId() == other.getGadgetEntityId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getOptionListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getOptionListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 8)) + getGadgetEntityId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WorktopOptionNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WorktopOptionNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorktopOptionNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WorktopOptionNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorktopOptionNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WorktopOptionNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorktopOptionNotify parseFrom(InputStream input) throws IOException {
            return (WorktopOptionNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WorktopOptionNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorktopOptionNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WorktopOptionNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (WorktopOptionNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WorktopOptionNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorktopOptionNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WorktopOptionNotify parseFrom(CodedInputStream input) throws IOException {
            return (WorktopOptionNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WorktopOptionNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorktopOptionNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WorktopOptionNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorktopOptionNotifyOuterClass$WorktopOptionNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WorktopOptionNotifyOrBuilder {
            private int bitField0_;
            private Internal.IntList optionList_ = WorktopOptionNotify.emptyIntList();
            private int gadgetEntityId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WorktopOptionNotifyOuterClass.internal_static_WorktopOptionNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WorktopOptionNotifyOuterClass.internal_static_WorktopOptionNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WorktopOptionNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WorktopOptionNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.optionList_ = WorktopOptionNotify.emptyIntList();
                this.bitField0_ &= -2;
                this.gadgetEntityId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WorktopOptionNotifyOuterClass.internal_static_WorktopOptionNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WorktopOptionNotify getDefaultInstanceForType() {
                return WorktopOptionNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WorktopOptionNotify build() {
                WorktopOptionNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WorktopOptionNotify buildPartial() {
                WorktopOptionNotify result = new WorktopOptionNotify(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.optionList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.optionList_ = this.optionList_;
                result.gadgetEntityId_ = this.gadgetEntityId_;
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
                if (other instanceof WorktopOptionNotify) {
                    return mergeFrom((WorktopOptionNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WorktopOptionNotify other) {
                if (other == WorktopOptionNotify.getDefaultInstance()) {
                    return this;
                }
                if (!other.optionList_.isEmpty()) {
                    if (this.optionList_.isEmpty()) {
                        this.optionList_ = other.optionList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureOptionListIsMutable();
                        this.optionList_.addAll(other.optionList_);
                    }
                    onChanged();
                }
                if (other.getGadgetEntityId() != 0) {
                    setGadgetEntityId(other.getGadgetEntityId());
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
                WorktopOptionNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = WorktopOptionNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WorktopOptionNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureOptionListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.optionList_ = WorktopOptionNotify.mutableCopy(this.optionList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.WorktopOptionNotifyOuterClass.WorktopOptionNotifyOrBuilder
            public List<Integer> getOptionListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.optionList_) : this.optionList_;
            }

            @Override // emu.grasscutter.net.proto.WorktopOptionNotifyOuterClass.WorktopOptionNotifyOrBuilder
            public int getOptionListCount() {
                return this.optionList_.size();
            }

            @Override // emu.grasscutter.net.proto.WorktopOptionNotifyOuterClass.WorktopOptionNotifyOrBuilder
            public int getOptionList(int index) {
                return this.optionList_.getInt(index);
            }

            public Builder setOptionList(int index, int value) {
                ensureOptionListIsMutable();
                this.optionList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addOptionList(int value) {
                ensureOptionListIsMutable();
                this.optionList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllOptionList(Iterable<? extends Integer> values) {
                ensureOptionListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.optionList_);
                onChanged();
                return this;
            }

            public Builder clearOptionList() {
                this.optionList_ = WorktopOptionNotify.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WorktopOptionNotifyOuterClass.WorktopOptionNotifyOrBuilder
            public int getGadgetEntityId() {
                return this.gadgetEntityId_;
            }

            public Builder setGadgetEntityId(int value) {
                this.gadgetEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGadgetEntityId() {
                this.gadgetEntityId_ = 0;
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

        public static WorktopOptionNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WorktopOptionNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WorktopOptionNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WorktopOptionNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
