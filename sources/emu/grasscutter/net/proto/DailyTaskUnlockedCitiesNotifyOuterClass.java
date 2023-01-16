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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DailyTaskUnlockedCitiesNotifyOuterClass.class */
public final class DailyTaskUnlockedCitiesNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#DailyTaskUnlockedCitiesNotify.proto\";\n\u001dDailyTaskUnlockedCitiesNotify\u0012\u001a\n\u0012unlocked_city_list\u0018\u000f \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_DailyTaskUnlockedCitiesNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DailyTaskUnlockedCitiesNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DailyTaskUnlockedCitiesNotify_descriptor, new String[]{"UnlockedCityList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DailyTaskUnlockedCitiesNotifyOuterClass$DailyTaskUnlockedCitiesNotifyOrBuilder.class */
    public interface DailyTaskUnlockedCitiesNotifyOrBuilder extends MessageOrBuilder {
        List<Integer> getUnlockedCityListList();

        int getUnlockedCityListCount();

        int getUnlockedCityList(int i);
    }

    private DailyTaskUnlockedCitiesNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DailyTaskUnlockedCitiesNotifyOuterClass$DailyTaskUnlockedCitiesNotify.class */
    public static final class DailyTaskUnlockedCitiesNotify extends GeneratedMessageV3 implements DailyTaskUnlockedCitiesNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNLOCKED_CITY_LIST_FIELD_NUMBER = 15;
        private Internal.IntList unlockedCityList_;
        private int unlockedCityListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final DailyTaskUnlockedCitiesNotify DEFAULT_INSTANCE = new DailyTaskUnlockedCitiesNotify();
        private static final Parser<DailyTaskUnlockedCitiesNotify> PARSER = new AbstractParser<DailyTaskUnlockedCitiesNotify>() { // from class: emu.grasscutter.net.proto.DailyTaskUnlockedCitiesNotifyOuterClass.DailyTaskUnlockedCitiesNotify.1
            @Override // com.google.protobuf.Parser
            public DailyTaskUnlockedCitiesNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DailyTaskUnlockedCitiesNotify(input, extensionRegistry);
            }
        };

        private DailyTaskUnlockedCitiesNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unlockedCityListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private DailyTaskUnlockedCitiesNotify() {
            this.unlockedCityListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.unlockedCityList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DailyTaskUnlockedCitiesNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DailyTaskUnlockedCitiesNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 120:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.unlockedCityList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.unlockedCityList_.addInt(input.readUInt32());
                                    break;
                                case 122:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.unlockedCityList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.unlockedCityList_.addInt(input.readUInt32());
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
                    this.unlockedCityList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DailyTaskUnlockedCitiesNotifyOuterClass.internal_static_DailyTaskUnlockedCitiesNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DailyTaskUnlockedCitiesNotifyOuterClass.internal_static_DailyTaskUnlockedCitiesNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyTaskUnlockedCitiesNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DailyTaskUnlockedCitiesNotifyOuterClass.DailyTaskUnlockedCitiesNotifyOrBuilder
        public List<Integer> getUnlockedCityListList() {
            return this.unlockedCityList_;
        }

        @Override // emu.grasscutter.net.proto.DailyTaskUnlockedCitiesNotifyOuterClass.DailyTaskUnlockedCitiesNotifyOrBuilder
        public int getUnlockedCityListCount() {
            return this.unlockedCityList_.size();
        }

        @Override // emu.grasscutter.net.proto.DailyTaskUnlockedCitiesNotifyOuterClass.DailyTaskUnlockedCitiesNotifyOrBuilder
        public int getUnlockedCityList(int index) {
            return this.unlockedCityList_.getInt(index);
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
            if (getUnlockedCityListList().size() > 0) {
                output.writeUInt32NoTag(122);
                output.writeUInt32NoTag(this.unlockedCityListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.unlockedCityList_.size(); i++) {
                output.writeUInt32NoTag(this.unlockedCityList_.getInt(i));
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
            for (int i = 0; i < this.unlockedCityList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.unlockedCityList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getUnlockedCityListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.unlockedCityListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DailyTaskUnlockedCitiesNotify)) {
                return equals(obj);
            }
            DailyTaskUnlockedCitiesNotify other = (DailyTaskUnlockedCitiesNotify) obj;
            return getUnlockedCityListList().equals(other.getUnlockedCityListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getUnlockedCityListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getUnlockedCityListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DailyTaskUnlockedCitiesNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DailyTaskUnlockedCitiesNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DailyTaskUnlockedCitiesNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DailyTaskUnlockedCitiesNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DailyTaskUnlockedCitiesNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DailyTaskUnlockedCitiesNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DailyTaskUnlockedCitiesNotify parseFrom(InputStream input) throws IOException {
            return (DailyTaskUnlockedCitiesNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DailyTaskUnlockedCitiesNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyTaskUnlockedCitiesNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DailyTaskUnlockedCitiesNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (DailyTaskUnlockedCitiesNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DailyTaskUnlockedCitiesNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyTaskUnlockedCitiesNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DailyTaskUnlockedCitiesNotify parseFrom(CodedInputStream input) throws IOException {
            return (DailyTaskUnlockedCitiesNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DailyTaskUnlockedCitiesNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyTaskUnlockedCitiesNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DailyTaskUnlockedCitiesNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DailyTaskUnlockedCitiesNotifyOuterClass$DailyTaskUnlockedCitiesNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DailyTaskUnlockedCitiesNotifyOrBuilder {
            private int bitField0_;
            private Internal.IntList unlockedCityList_ = DailyTaskUnlockedCitiesNotify.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return DailyTaskUnlockedCitiesNotifyOuterClass.internal_static_DailyTaskUnlockedCitiesNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DailyTaskUnlockedCitiesNotifyOuterClass.internal_static_DailyTaskUnlockedCitiesNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyTaskUnlockedCitiesNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DailyTaskUnlockedCitiesNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unlockedCityList_ = DailyTaskUnlockedCitiesNotify.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DailyTaskUnlockedCitiesNotifyOuterClass.internal_static_DailyTaskUnlockedCitiesNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DailyTaskUnlockedCitiesNotify getDefaultInstanceForType() {
                return DailyTaskUnlockedCitiesNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DailyTaskUnlockedCitiesNotify build() {
                DailyTaskUnlockedCitiesNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DailyTaskUnlockedCitiesNotify buildPartial() {
                DailyTaskUnlockedCitiesNotify result = new DailyTaskUnlockedCitiesNotify(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.unlockedCityList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.unlockedCityList_ = this.unlockedCityList_;
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
                if (other instanceof DailyTaskUnlockedCitiesNotify) {
                    return mergeFrom((DailyTaskUnlockedCitiesNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DailyTaskUnlockedCitiesNotify other) {
                if (other == DailyTaskUnlockedCitiesNotify.getDefaultInstance()) {
                    return this;
                }
                if (!other.unlockedCityList_.isEmpty()) {
                    if (this.unlockedCityList_.isEmpty()) {
                        this.unlockedCityList_ = other.unlockedCityList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUnlockedCityListIsMutable();
                        this.unlockedCityList_.addAll(other.unlockedCityList_);
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
                DailyTaskUnlockedCitiesNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = DailyTaskUnlockedCitiesNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DailyTaskUnlockedCitiesNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureUnlockedCityListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unlockedCityList_ = DailyTaskUnlockedCitiesNotify.mutableCopy(this.unlockedCityList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.DailyTaskUnlockedCitiesNotifyOuterClass.DailyTaskUnlockedCitiesNotifyOrBuilder
            public List<Integer> getUnlockedCityListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.unlockedCityList_) : this.unlockedCityList_;
            }

            @Override // emu.grasscutter.net.proto.DailyTaskUnlockedCitiesNotifyOuterClass.DailyTaskUnlockedCitiesNotifyOrBuilder
            public int getUnlockedCityListCount() {
                return this.unlockedCityList_.size();
            }

            @Override // emu.grasscutter.net.proto.DailyTaskUnlockedCitiesNotifyOuterClass.DailyTaskUnlockedCitiesNotifyOrBuilder
            public int getUnlockedCityList(int index) {
                return this.unlockedCityList_.getInt(index);
            }

            public Builder setUnlockedCityList(int index, int value) {
                ensureUnlockedCityListIsMutable();
                this.unlockedCityList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnlockedCityList(int value) {
                ensureUnlockedCityListIsMutable();
                this.unlockedCityList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnlockedCityList(Iterable<? extends Integer> values) {
                ensureUnlockedCityListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unlockedCityList_);
                onChanged();
                return this;
            }

            public Builder clearUnlockedCityList() {
                this.unlockedCityList_ = DailyTaskUnlockedCitiesNotify.emptyIntList();
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

        public static DailyTaskUnlockedCitiesNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DailyTaskUnlockedCitiesNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DailyTaskUnlockedCitiesNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DailyTaskUnlockedCitiesNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
