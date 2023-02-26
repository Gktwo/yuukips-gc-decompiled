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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonWayPointNotifyOuterClass.class */
public final class DungeonWayPointNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bDungeonWayPointNotify.proto\"B\n\u0015DungeonWayPointNotify\u0012\u001a\n\u0012activeWayPointList\u0018\u000f \u0003(\r\u0012\r\n\u0005isAdd\u0018\u0003 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_DungeonWayPointNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DungeonWayPointNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DungeonWayPointNotify_descriptor, new String[]{"ActiveWayPointList", "IsAdd"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonWayPointNotifyOuterClass$DungeonWayPointNotifyOrBuilder.class */
    public interface DungeonWayPointNotifyOrBuilder extends MessageOrBuilder {
        List<Integer> getActiveWayPointListList();

        int getActiveWayPointListCount();

        int getActiveWayPointList(int i);

        boolean getIsAdd();
    }

    private DungeonWayPointNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonWayPointNotifyOuterClass$DungeonWayPointNotify.class */
    public static final class DungeonWayPointNotify extends GeneratedMessageV3 implements DungeonWayPointNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ACTIVEWAYPOINTLIST_FIELD_NUMBER = 15;
        private Internal.IntList activeWayPointList_;
        private int activeWayPointListMemoizedSerializedSize;
        public static final int ISADD_FIELD_NUMBER = 3;
        private boolean isAdd_;
        private byte memoizedIsInitialized;
        private static final DungeonWayPointNotify DEFAULT_INSTANCE = new DungeonWayPointNotify();
        private static final Parser<DungeonWayPointNotify> PARSER = new AbstractParser<DungeonWayPointNotify>() { // from class: emu.grasscutter.net.proto.DungeonWayPointNotifyOuterClass.DungeonWayPointNotify.1
            @Override // com.google.protobuf.Parser
            public DungeonWayPointNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DungeonWayPointNotify(input, extensionRegistry);
            }
        };

        private DungeonWayPointNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.activeWayPointListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private DungeonWayPointNotify() {
            this.activeWayPointListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.activeWayPointList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DungeonWayPointNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DungeonWayPointNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 24:
                                    this.isAdd_ = input.readBool();
                                    break;
                                case 120:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.activeWayPointList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.activeWayPointList_.addInt(input.readUInt32());
                                    break;
                                case 122:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.activeWayPointList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.activeWayPointList_.addInt(input.readUInt32());
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
                    this.activeWayPointList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DungeonWayPointNotifyOuterClass.internal_static_DungeonWayPointNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DungeonWayPointNotifyOuterClass.internal_static_DungeonWayPointNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(DungeonWayPointNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DungeonWayPointNotifyOuterClass.DungeonWayPointNotifyOrBuilder
        public List<Integer> getActiveWayPointListList() {
            return this.activeWayPointList_;
        }

        @Override // emu.grasscutter.net.proto.DungeonWayPointNotifyOuterClass.DungeonWayPointNotifyOrBuilder
        public int getActiveWayPointListCount() {
            return this.activeWayPointList_.size();
        }

        @Override // emu.grasscutter.net.proto.DungeonWayPointNotifyOuterClass.DungeonWayPointNotifyOrBuilder
        public int getActiveWayPointList(int index) {
            return this.activeWayPointList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.DungeonWayPointNotifyOuterClass.DungeonWayPointNotifyOrBuilder
        public boolean getIsAdd() {
            return this.isAdd_;
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
            if (this.isAdd_) {
                output.writeBool(3, this.isAdd_);
            }
            if (getActiveWayPointListList().size() > 0) {
                output.writeUInt32NoTag(122);
                output.writeUInt32NoTag(this.activeWayPointListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.activeWayPointList_.size(); i++) {
                output.writeUInt32NoTag(this.activeWayPointList_.getInt(i));
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
            if (this.isAdd_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(3, this.isAdd_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.activeWayPointList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.activeWayPointList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getActiveWayPointListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.activeWayPointListMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DungeonWayPointNotify)) {
                return equals(obj);
            }
            DungeonWayPointNotify other = (DungeonWayPointNotify) obj;
            return getActiveWayPointListList().equals(other.getActiveWayPointListList()) && getIsAdd() == other.getIsAdd() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getActiveWayPointListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getActiveWayPointListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 3)) + Internal.hashBoolean(getIsAdd()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DungeonWayPointNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonWayPointNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonWayPointNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonWayPointNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonWayPointNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonWayPointNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonWayPointNotify parseFrom(InputStream input) throws IOException {
            return (DungeonWayPointNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DungeonWayPointNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonWayPointNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DungeonWayPointNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (DungeonWayPointNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DungeonWayPointNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonWayPointNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DungeonWayPointNotify parseFrom(CodedInputStream input) throws IOException {
            return (DungeonWayPointNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DungeonWayPointNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonWayPointNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DungeonWayPointNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonWayPointNotifyOuterClass$DungeonWayPointNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DungeonWayPointNotifyOrBuilder {
            private int bitField0_;
            private Internal.IntList activeWayPointList_ = DungeonWayPointNotify.emptyIntList();
            private boolean isAdd_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DungeonWayPointNotifyOuterClass.internal_static_DungeonWayPointNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DungeonWayPointNotifyOuterClass.internal_static_DungeonWayPointNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(DungeonWayPointNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DungeonWayPointNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.activeWayPointList_ = DungeonWayPointNotify.emptyIntList();
                this.bitField0_ &= -2;
                this.isAdd_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DungeonWayPointNotifyOuterClass.internal_static_DungeonWayPointNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DungeonWayPointNotify getDefaultInstanceForType() {
                return DungeonWayPointNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DungeonWayPointNotify build() {
                DungeonWayPointNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DungeonWayPointNotify buildPartial() {
                DungeonWayPointNotify result = new DungeonWayPointNotify(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.activeWayPointList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.activeWayPointList_ = this.activeWayPointList_;
                result.isAdd_ = this.isAdd_;
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
                if (other instanceof DungeonWayPointNotify) {
                    return mergeFrom((DungeonWayPointNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DungeonWayPointNotify other) {
                if (other == DungeonWayPointNotify.getDefaultInstance()) {
                    return this;
                }
                if (!other.activeWayPointList_.isEmpty()) {
                    if (this.activeWayPointList_.isEmpty()) {
                        this.activeWayPointList_ = other.activeWayPointList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureActiveWayPointListIsMutable();
                        this.activeWayPointList_.addAll(other.activeWayPointList_);
                    }
                    onChanged();
                }
                if (other.getIsAdd()) {
                    setIsAdd(other.getIsAdd());
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
                DungeonWayPointNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = DungeonWayPointNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DungeonWayPointNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureActiveWayPointListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.activeWayPointList_ = DungeonWayPointNotify.mutableCopy(this.activeWayPointList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.DungeonWayPointNotifyOuterClass.DungeonWayPointNotifyOrBuilder
            public List<Integer> getActiveWayPointListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.activeWayPointList_) : this.activeWayPointList_;
            }

            @Override // emu.grasscutter.net.proto.DungeonWayPointNotifyOuterClass.DungeonWayPointNotifyOrBuilder
            public int getActiveWayPointListCount() {
                return this.activeWayPointList_.size();
            }

            @Override // emu.grasscutter.net.proto.DungeonWayPointNotifyOuterClass.DungeonWayPointNotifyOrBuilder
            public int getActiveWayPointList(int index) {
                return this.activeWayPointList_.getInt(index);
            }

            public Builder setActiveWayPointList(int index, int value) {
                ensureActiveWayPointListIsMutable();
                this.activeWayPointList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addActiveWayPointList(int value) {
                ensureActiveWayPointListIsMutable();
                this.activeWayPointList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllActiveWayPointList(Iterable<? extends Integer> values) {
                ensureActiveWayPointListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.activeWayPointList_);
                onChanged();
                return this;
            }

            public Builder clearActiveWayPointList() {
                this.activeWayPointList_ = DungeonWayPointNotify.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonWayPointNotifyOuterClass.DungeonWayPointNotifyOrBuilder
            public boolean getIsAdd() {
                return this.isAdd_;
            }

            public Builder setIsAdd(boolean value) {
                this.isAdd_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsAdd() {
                this.isAdd_ = false;
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

        public static DungeonWayPointNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DungeonWayPointNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DungeonWayPointNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DungeonWayPointNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
