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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StatueGadgetInfoOuterClass.class */
public final class StatueGadgetInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016StatueGadgetInfo.proto\"2\n\u0010StatueGadgetInfo\u0012\u001e\n\u0016opened_statue_uid_list\u0018\u0001 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_StatueGadgetInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_StatueGadgetInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_StatueGadgetInfo_descriptor, new String[]{"OpenedStatueUidList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StatueGadgetInfoOuterClass$StatueGadgetInfoOrBuilder.class */
    public interface StatueGadgetInfoOrBuilder extends MessageOrBuilder {
        List<Integer> getOpenedStatueUidListList();

        int getOpenedStatueUidListCount();

        int getOpenedStatueUidList(int i);
    }

    private StatueGadgetInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StatueGadgetInfoOuterClass$StatueGadgetInfo.class */
    public static final class StatueGadgetInfo extends GeneratedMessageV3 implements StatueGadgetInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int OPENED_STATUE_UID_LIST_FIELD_NUMBER = 1;
        private Internal.IntList openedStatueUidList_;
        private int openedStatueUidListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final StatueGadgetInfo DEFAULT_INSTANCE = new StatueGadgetInfo();
        private static final Parser<StatueGadgetInfo> PARSER = new AbstractParser<StatueGadgetInfo>() { // from class: emu.grasscutter.net.proto.StatueGadgetInfoOuterClass.StatueGadgetInfo.1
            @Override // com.google.protobuf.Parser
            public StatueGadgetInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new StatueGadgetInfo(input, extensionRegistry);
            }
        };

        private StatueGadgetInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.openedStatueUidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private StatueGadgetInfo() {
            this.openedStatueUidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.openedStatueUidList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new StatueGadgetInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private StatueGadgetInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.openedStatueUidList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.openedStatueUidList_.addInt(input.readUInt32());
                                    break;
                                case 10:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.openedStatueUidList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.openedStatueUidList_.addInt(input.readUInt32());
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
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.openedStatueUidList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StatueGadgetInfoOuterClass.internal_static_StatueGadgetInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StatueGadgetInfoOuterClass.internal_static_StatueGadgetInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(StatueGadgetInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.StatueGadgetInfoOuterClass.StatueGadgetInfoOrBuilder
        public List<Integer> getOpenedStatueUidListList() {
            return this.openedStatueUidList_;
        }

        @Override // emu.grasscutter.net.proto.StatueGadgetInfoOuterClass.StatueGadgetInfoOrBuilder
        public int getOpenedStatueUidListCount() {
            return this.openedStatueUidList_.size();
        }

        @Override // emu.grasscutter.net.proto.StatueGadgetInfoOuterClass.StatueGadgetInfoOrBuilder
        public int getOpenedStatueUidList(int index) {
            return this.openedStatueUidList_.getInt(index);
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
            if (getOpenedStatueUidListList().size() > 0) {
                output.writeUInt32NoTag(10);
                output.writeUInt32NoTag(this.openedStatueUidListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.openedStatueUidList_.size(); i++) {
                output.writeUInt32NoTag(this.openedStatueUidList_.getInt(i));
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.openedStatueUidList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.openedStatueUidList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getOpenedStatueUidListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.openedStatueUidListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof StatueGadgetInfo)) {
                return equals(obj);
            }
            StatueGadgetInfo other = (StatueGadgetInfo) obj;
            return getOpenedStatueUidListList().equals(other.getOpenedStatueUidListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getOpenedStatueUidListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getOpenedStatueUidListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static StatueGadgetInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static StatueGadgetInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static StatueGadgetInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static StatueGadgetInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static StatueGadgetInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static StatueGadgetInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static StatueGadgetInfo parseFrom(InputStream input) throws IOException {
            return (StatueGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static StatueGadgetInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StatueGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static StatueGadgetInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (StatueGadgetInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static StatueGadgetInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StatueGadgetInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static StatueGadgetInfo parseFrom(CodedInputStream input) throws IOException {
            return (StatueGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static StatueGadgetInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StatueGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(StatueGadgetInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StatueGadgetInfoOuterClass$StatueGadgetInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements StatueGadgetInfoOrBuilder {
            private int bitField0_;
            private Internal.IntList openedStatueUidList_ = StatueGadgetInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return StatueGadgetInfoOuterClass.internal_static_StatueGadgetInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StatueGadgetInfoOuterClass.internal_static_StatueGadgetInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(StatueGadgetInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (StatueGadgetInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.openedStatueUidList_ = StatueGadgetInfo.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return StatueGadgetInfoOuterClass.internal_static_StatueGadgetInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public StatueGadgetInfo getDefaultInstanceForType() {
                return StatueGadgetInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public StatueGadgetInfo build() {
                StatueGadgetInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public StatueGadgetInfo buildPartial() {
                StatueGadgetInfo result = new StatueGadgetInfo(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.openedStatueUidList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.openedStatueUidList_ = this.openedStatueUidList_;
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
                if (other instanceof StatueGadgetInfo) {
                    return mergeFrom((StatueGadgetInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(StatueGadgetInfo other) {
                if (other == StatueGadgetInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.openedStatueUidList_.isEmpty()) {
                    if (this.openedStatueUidList_.isEmpty()) {
                        this.openedStatueUidList_ = other.openedStatueUidList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureOpenedStatueUidListIsMutable();
                        this.openedStatueUidList_.addAll(other.openedStatueUidList_);
                    }
                    onChanged();
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
                StatueGadgetInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = StatueGadgetInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (StatueGadgetInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureOpenedStatueUidListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.openedStatueUidList_ = StatueGadgetInfo.mutableCopy(this.openedStatueUidList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.StatueGadgetInfoOuterClass.StatueGadgetInfoOrBuilder
            public List<Integer> getOpenedStatueUidListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.openedStatueUidList_) : this.openedStatueUidList_;
            }

            @Override // emu.grasscutter.net.proto.StatueGadgetInfoOuterClass.StatueGadgetInfoOrBuilder
            public int getOpenedStatueUidListCount() {
                return this.openedStatueUidList_.size();
            }

            @Override // emu.grasscutter.net.proto.StatueGadgetInfoOuterClass.StatueGadgetInfoOrBuilder
            public int getOpenedStatueUidList(int index) {
                return this.openedStatueUidList_.getInt(index);
            }

            public Builder setOpenedStatueUidList(int index, int value) {
                ensureOpenedStatueUidListIsMutable();
                this.openedStatueUidList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addOpenedStatueUidList(int value) {
                ensureOpenedStatueUidListIsMutable();
                this.openedStatueUidList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllOpenedStatueUidList(Iterable<? extends Integer> values) {
                ensureOpenedStatueUidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.openedStatueUidList_);
                onChanged();
                return this;
            }

            public Builder clearOpenedStatueUidList() {
                this.openedStatueUidList_ = StatueGadgetInfo.emptyIntList();
                this.bitField0_ &= -2;
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

        public static StatueGadgetInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StatueGadgetInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<StatueGadgetInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public StatueGadgetInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
