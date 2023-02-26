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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FetterDataOuterClass.class */
public final class FetterDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010FetterData.proto\"J\n\nFetterData\u0012\u0010\n\bfetterId\u0018\u0001 \u0001(\r\u0012\u0013\n\u000bfetterState\u0018\u0002 \u0001(\r\u0012\u0015\n\rcondIndexList\u0018\u0003 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_FetterData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FetterData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FetterData_descriptor, new String[]{"FetterId", "FetterState", "CondIndexList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FetterDataOuterClass$FetterDataOrBuilder.class */
    public interface FetterDataOrBuilder extends MessageOrBuilder {
        int getFetterId();

        int getFetterState();

        List<Integer> getCondIndexListList();

        int getCondIndexListCount();

        int getCondIndexList(int i);
    }

    private FetterDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FetterDataOuterClass$FetterData.class */
    public static final class FetterData extends GeneratedMessageV3 implements FetterDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FETTERID_FIELD_NUMBER = 1;
        private int fetterId_;
        public static final int FETTERSTATE_FIELD_NUMBER = 2;
        private int fetterState_;
        public static final int CONDINDEXLIST_FIELD_NUMBER = 3;
        private Internal.IntList condIndexList_;
        private int condIndexListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final FetterData DEFAULT_INSTANCE = new FetterData();
        private static final Parser<FetterData> PARSER = new AbstractParser<FetterData>() { // from class: emu.grasscutter.net.proto.FetterDataOuterClass.FetterData.1
            @Override // com.google.protobuf.Parser
            public FetterData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FetterData(input, extensionRegistry);
            }
        };

        private FetterData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.condIndexListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private FetterData() {
            this.condIndexListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.condIndexList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FetterData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FetterData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.fetterId_ = input.readUInt32();
                                break;
                            case 16:
                                this.fetterState_ = input.readUInt32();
                                break;
                            case 24:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.condIndexList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.condIndexList_.addInt(input.readUInt32());
                                break;
                            case 26:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.condIndexList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.condIndexList_.addInt(input.readUInt32());
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
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.condIndexList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FetterDataOuterClass.internal_static_FetterData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FetterDataOuterClass.internal_static_FetterData_fieldAccessorTable.ensureFieldAccessorsInitialized(FetterData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FetterDataOuterClass.FetterDataOrBuilder
        public int getFetterId() {
            return this.fetterId_;
        }

        @Override // emu.grasscutter.net.proto.FetterDataOuterClass.FetterDataOrBuilder
        public int getFetterState() {
            return this.fetterState_;
        }

        @Override // emu.grasscutter.net.proto.FetterDataOuterClass.FetterDataOrBuilder
        public List<Integer> getCondIndexListList() {
            return this.condIndexList_;
        }

        @Override // emu.grasscutter.net.proto.FetterDataOuterClass.FetterDataOrBuilder
        public int getCondIndexListCount() {
            return this.condIndexList_.size();
        }

        @Override // emu.grasscutter.net.proto.FetterDataOuterClass.FetterDataOrBuilder
        public int getCondIndexList(int index) {
            return this.condIndexList_.getInt(index);
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
            if (this.fetterId_ != 0) {
                output.writeUInt32(1, this.fetterId_);
            }
            if (this.fetterState_ != 0) {
                output.writeUInt32(2, this.fetterState_);
            }
            if (getCondIndexListList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.condIndexListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.condIndexList_.size(); i++) {
                output.writeUInt32NoTag(this.condIndexList_.getInt(i));
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
            if (this.fetterId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.fetterId_);
            }
            if (this.fetterState_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.fetterState_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.condIndexList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.condIndexList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getCondIndexListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.condIndexListMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FetterData)) {
                return equals(obj);
            }
            FetterData other = (FetterData) obj;
            return getFetterId() == other.getFetterId() && getFetterState() == other.getFetterState() && getCondIndexListList().equals(other.getCondIndexListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getFetterId())) + 2)) + getFetterState();
            if (getCondIndexListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getCondIndexListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FetterData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FetterData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FetterData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FetterData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FetterData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FetterData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FetterData parseFrom(InputStream input) throws IOException {
            return (FetterData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FetterData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FetterData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FetterData parseDelimitedFrom(InputStream input) throws IOException {
            return (FetterData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FetterData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FetterData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FetterData parseFrom(CodedInputStream input) throws IOException {
            return (FetterData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FetterData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FetterData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FetterData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FetterDataOuterClass$FetterData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FetterDataOrBuilder {
            private int bitField0_;
            private int fetterId_;
            private int fetterState_;
            private Internal.IntList condIndexList_ = FetterData.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return FetterDataOuterClass.internal_static_FetterData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FetterDataOuterClass.internal_static_FetterData_fieldAccessorTable.ensureFieldAccessorsInitialized(FetterData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FetterData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.fetterId_ = 0;
                this.fetterState_ = 0;
                this.condIndexList_ = FetterData.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FetterDataOuterClass.internal_static_FetterData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FetterData getDefaultInstanceForType() {
                return FetterData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FetterData build() {
                FetterData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FetterData buildPartial() {
                FetterData result = new FetterData(this);
                int i = this.bitField0_;
                result.fetterId_ = this.fetterId_;
                result.fetterState_ = this.fetterState_;
                if ((this.bitField0_ & 1) != 0) {
                    this.condIndexList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.condIndexList_ = this.condIndexList_;
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
                if (other instanceof FetterData) {
                    return mergeFrom((FetterData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FetterData other) {
                if (other == FetterData.getDefaultInstance()) {
                    return this;
                }
                if (other.getFetterId() != 0) {
                    setFetterId(other.getFetterId());
                }
                if (other.getFetterState() != 0) {
                    setFetterState(other.getFetterState());
                }
                if (!other.condIndexList_.isEmpty()) {
                    if (this.condIndexList_.isEmpty()) {
                        this.condIndexList_ = other.condIndexList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureCondIndexListIsMutable();
                        this.condIndexList_.addAll(other.condIndexList_);
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
                FetterData parsedMessage = null;
                try {
                    try {
                        parsedMessage = FetterData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FetterData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FetterDataOuterClass.FetterDataOrBuilder
            public int getFetterId() {
                return this.fetterId_;
            }

            public Builder setFetterId(int value) {
                this.fetterId_ = value;
                onChanged();
                return this;
            }

            public Builder clearFetterId() {
                this.fetterId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FetterDataOuterClass.FetterDataOrBuilder
            public int getFetterState() {
                return this.fetterState_;
            }

            public Builder setFetterState(int value) {
                this.fetterState_ = value;
                onChanged();
                return this;
            }

            public Builder clearFetterState() {
                this.fetterState_ = 0;
                onChanged();
                return this;
            }

            private void ensureCondIndexListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.condIndexList_ = FetterData.mutableCopy(this.condIndexList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.FetterDataOuterClass.FetterDataOrBuilder
            public List<Integer> getCondIndexListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.condIndexList_) : this.condIndexList_;
            }

            @Override // emu.grasscutter.net.proto.FetterDataOuterClass.FetterDataOrBuilder
            public int getCondIndexListCount() {
                return this.condIndexList_.size();
            }

            @Override // emu.grasscutter.net.proto.FetterDataOuterClass.FetterDataOrBuilder
            public int getCondIndexList(int index) {
                return this.condIndexList_.getInt(index);
            }

            public Builder setCondIndexList(int index, int value) {
                ensureCondIndexListIsMutable();
                this.condIndexList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addCondIndexList(int value) {
                ensureCondIndexListIsMutable();
                this.condIndexList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllCondIndexList(Iterable<? extends Integer> values) {
                ensureCondIndexListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.condIndexList_);
                onChanged();
                return this;
            }

            public Builder clearCondIndexList() {
                this.condIndexList_ = FetterData.emptyIntList();
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

        public static FetterData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FetterData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FetterData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FetterData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
