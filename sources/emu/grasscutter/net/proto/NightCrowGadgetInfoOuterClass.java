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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/NightCrowGadgetInfoOuterClass.class */
public final class NightCrowGadgetInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019NightCrowGadgetInfo.proto\"+\n\u0013NightCrowGadgetInfo\u0012\u0014\n\fargumentList\u0018\u0001 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_NightCrowGadgetInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_NightCrowGadgetInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_NightCrowGadgetInfo_descriptor, new String[]{"ArgumentList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/NightCrowGadgetInfoOuterClass$NightCrowGadgetInfoOrBuilder.class */
    public interface NightCrowGadgetInfoOrBuilder extends MessageOrBuilder {
        List<Integer> getArgumentListList();

        int getArgumentListCount();

        int getArgumentList(int i);
    }

    private NightCrowGadgetInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/NightCrowGadgetInfoOuterClass$NightCrowGadgetInfo.class */
    public static final class NightCrowGadgetInfo extends GeneratedMessageV3 implements NightCrowGadgetInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ARGUMENTLIST_FIELD_NUMBER = 1;
        private Internal.IntList argumentList_;
        private int argumentListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final NightCrowGadgetInfo DEFAULT_INSTANCE = new NightCrowGadgetInfo();
        private static final Parser<NightCrowGadgetInfo> PARSER = new AbstractParser<NightCrowGadgetInfo>() { // from class: emu.grasscutter.net.proto.NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo.1
            @Override // com.google.protobuf.Parser
            public NightCrowGadgetInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new NightCrowGadgetInfo(input, extensionRegistry);
            }
        };

        private NightCrowGadgetInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.argumentListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private NightCrowGadgetInfo() {
            this.argumentListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.argumentList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new NightCrowGadgetInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private NightCrowGadgetInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                        this.argumentList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.argumentList_.addInt(input.readUInt32());
                                    break;
                                case 10:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.argumentList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.argumentList_.addInt(input.readUInt32());
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
                    this.argumentList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return NightCrowGadgetInfoOuterClass.internal_static_NightCrowGadgetInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return NightCrowGadgetInfoOuterClass.internal_static_NightCrowGadgetInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(NightCrowGadgetInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.NightCrowGadgetInfoOuterClass.NightCrowGadgetInfoOrBuilder
        public List<Integer> getArgumentListList() {
            return this.argumentList_;
        }

        @Override // emu.grasscutter.net.proto.NightCrowGadgetInfoOuterClass.NightCrowGadgetInfoOrBuilder
        public int getArgumentListCount() {
            return this.argumentList_.size();
        }

        @Override // emu.grasscutter.net.proto.NightCrowGadgetInfoOuterClass.NightCrowGadgetInfoOrBuilder
        public int getArgumentList(int index) {
            return this.argumentList_.getInt(index);
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
            if (getArgumentListList().size() > 0) {
                output.writeUInt32NoTag(10);
                output.writeUInt32NoTag(this.argumentListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.argumentList_.size(); i++) {
                output.writeUInt32NoTag(this.argumentList_.getInt(i));
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
            for (int i = 0; i < this.argumentList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.argumentList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getArgumentListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.argumentListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof NightCrowGadgetInfo)) {
                return equals(obj);
            }
            NightCrowGadgetInfo other = (NightCrowGadgetInfo) obj;
            return getArgumentListList().equals(other.getArgumentListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getArgumentListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getArgumentListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static NightCrowGadgetInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static NightCrowGadgetInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static NightCrowGadgetInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static NightCrowGadgetInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static NightCrowGadgetInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static NightCrowGadgetInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static NightCrowGadgetInfo parseFrom(InputStream input) throws IOException {
            return (NightCrowGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static NightCrowGadgetInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NightCrowGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static NightCrowGadgetInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (NightCrowGadgetInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static NightCrowGadgetInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NightCrowGadgetInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static NightCrowGadgetInfo parseFrom(CodedInputStream input) throws IOException {
            return (NightCrowGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static NightCrowGadgetInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NightCrowGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(NightCrowGadgetInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/NightCrowGadgetInfoOuterClass$NightCrowGadgetInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements NightCrowGadgetInfoOrBuilder {
            private int bitField0_;
            private Internal.IntList argumentList_ = NightCrowGadgetInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return NightCrowGadgetInfoOuterClass.internal_static_NightCrowGadgetInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return NightCrowGadgetInfoOuterClass.internal_static_NightCrowGadgetInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(NightCrowGadgetInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (NightCrowGadgetInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.argumentList_ = NightCrowGadgetInfo.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return NightCrowGadgetInfoOuterClass.internal_static_NightCrowGadgetInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public NightCrowGadgetInfo getDefaultInstanceForType() {
                return NightCrowGadgetInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public NightCrowGadgetInfo build() {
                NightCrowGadgetInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public NightCrowGadgetInfo buildPartial() {
                NightCrowGadgetInfo result = new NightCrowGadgetInfo(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.argumentList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.argumentList_ = this.argumentList_;
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
                if (other instanceof NightCrowGadgetInfo) {
                    return mergeFrom((NightCrowGadgetInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(NightCrowGadgetInfo other) {
                if (other == NightCrowGadgetInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.argumentList_.isEmpty()) {
                    if (this.argumentList_.isEmpty()) {
                        this.argumentList_ = other.argumentList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureArgumentListIsMutable();
                        this.argumentList_.addAll(other.argumentList_);
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
                NightCrowGadgetInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = NightCrowGadgetInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (NightCrowGadgetInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureArgumentListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.argumentList_ = NightCrowGadgetInfo.mutableCopy(this.argumentList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.NightCrowGadgetInfoOuterClass.NightCrowGadgetInfoOrBuilder
            public List<Integer> getArgumentListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.argumentList_) : this.argumentList_;
            }

            @Override // emu.grasscutter.net.proto.NightCrowGadgetInfoOuterClass.NightCrowGadgetInfoOrBuilder
            public int getArgumentListCount() {
                return this.argumentList_.size();
            }

            @Override // emu.grasscutter.net.proto.NightCrowGadgetInfoOuterClass.NightCrowGadgetInfoOrBuilder
            public int getArgumentList(int index) {
                return this.argumentList_.getInt(index);
            }

            public Builder setArgumentList(int index, int value) {
                ensureArgumentListIsMutable();
                this.argumentList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addArgumentList(int value) {
                ensureArgumentListIsMutable();
                this.argumentList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllArgumentList(Iterable<? extends Integer> values) {
                ensureArgumentListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.argumentList_);
                onChanged();
                return this;
            }

            public Builder clearArgumentList() {
                this.argumentList_ = NightCrowGadgetInfo.emptyIntList();
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

        public static NightCrowGadgetInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<NightCrowGadgetInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<NightCrowGadgetInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public NightCrowGadgetInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
