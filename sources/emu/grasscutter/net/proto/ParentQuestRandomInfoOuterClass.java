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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ParentQuestRandomInfoOuterClass.class */
public final class ParentQuestRandomInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bParentQuestRandomInfo.proto\"S\n\u0015ParentQuestRandomInfo\u0012\u0012\n\nentranceId\u0018\u0001 \u0001(\r\u0012\u0012\n\nfactorList\u0018\u0003 \u0003(\r\u0012\u0012\n\ntemplateId\u0018\u0006 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ParentQuestRandomInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ParentQuestRandomInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ParentQuestRandomInfo_descriptor, new String[]{"EntranceId", "FactorList", "TemplateId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ParentQuestRandomInfoOuterClass$ParentQuestRandomInfoOrBuilder.class */
    public interface ParentQuestRandomInfoOrBuilder extends MessageOrBuilder {
        int getEntranceId();

        List<Integer> getFactorListList();

        int getFactorListCount();

        int getFactorList(int i);

        int getTemplateId();
    }

    private ParentQuestRandomInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ParentQuestRandomInfoOuterClass$ParentQuestRandomInfo.class */
    public static final class ParentQuestRandomInfo extends GeneratedMessageV3 implements ParentQuestRandomInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTRANCEID_FIELD_NUMBER = 1;
        private int entranceId_;
        public static final int FACTORLIST_FIELD_NUMBER = 3;
        private Internal.IntList factorList_;
        private int factorListMemoizedSerializedSize;
        public static final int TEMPLATEID_FIELD_NUMBER = 6;
        private int templateId_;
        private byte memoizedIsInitialized;
        private static final ParentQuestRandomInfo DEFAULT_INSTANCE = new ParentQuestRandomInfo();
        private static final Parser<ParentQuestRandomInfo> PARSER = new AbstractParser<ParentQuestRandomInfo>() { // from class: emu.grasscutter.net.proto.ParentQuestRandomInfoOuterClass.ParentQuestRandomInfo.1
            @Override // com.google.protobuf.Parser
            public ParentQuestRandomInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ParentQuestRandomInfo(input, extensionRegistry);
            }
        };

        private ParentQuestRandomInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.factorListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ParentQuestRandomInfo() {
            this.factorListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.factorList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ParentQuestRandomInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ParentQuestRandomInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.entranceId_ = input.readUInt32();
                                break;
                            case 24:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.factorList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.factorList_.addInt(input.readUInt32());
                                break;
                            case 26:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.factorList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.factorList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 48:
                                this.templateId_ = input.readUInt32();
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
                    this.factorList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ParentQuestRandomInfoOuterClass.internal_static_ParentQuestRandomInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ParentQuestRandomInfoOuterClass.internal_static_ParentQuestRandomInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ParentQuestRandomInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ParentQuestRandomInfoOuterClass.ParentQuestRandomInfoOrBuilder
        public int getEntranceId() {
            return this.entranceId_;
        }

        @Override // emu.grasscutter.net.proto.ParentQuestRandomInfoOuterClass.ParentQuestRandomInfoOrBuilder
        public List<Integer> getFactorListList() {
            return this.factorList_;
        }

        @Override // emu.grasscutter.net.proto.ParentQuestRandomInfoOuterClass.ParentQuestRandomInfoOrBuilder
        public int getFactorListCount() {
            return this.factorList_.size();
        }

        @Override // emu.grasscutter.net.proto.ParentQuestRandomInfoOuterClass.ParentQuestRandomInfoOrBuilder
        public int getFactorList(int index) {
            return this.factorList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.ParentQuestRandomInfoOuterClass.ParentQuestRandomInfoOrBuilder
        public int getTemplateId() {
            return this.templateId_;
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
            if (this.entranceId_ != 0) {
                output.writeUInt32(1, this.entranceId_);
            }
            if (getFactorListList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.factorListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.factorList_.size(); i++) {
                output.writeUInt32NoTag(this.factorList_.getInt(i));
            }
            if (this.templateId_ != 0) {
                output.writeUInt32(6, this.templateId_);
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
            if (this.entranceId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.entranceId_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.factorList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.factorList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getFactorListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.factorListMemoizedSerializedSize = dataSize;
            if (this.templateId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(6, this.templateId_);
            }
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ParentQuestRandomInfo)) {
                return equals(obj);
            }
            ParentQuestRandomInfo other = (ParentQuestRandomInfo) obj;
            return getEntranceId() == other.getEntranceId() && getFactorListList().equals(other.getFactorListList()) && getTemplateId() == other.getTemplateId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getEntranceId();
            if (getFactorListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getFactorListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 6)) + getTemplateId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ParentQuestRandomInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ParentQuestRandomInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ParentQuestRandomInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ParentQuestRandomInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ParentQuestRandomInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ParentQuestRandomInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ParentQuestRandomInfo parseFrom(InputStream input) throws IOException {
            return (ParentQuestRandomInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ParentQuestRandomInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ParentQuestRandomInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ParentQuestRandomInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ParentQuestRandomInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ParentQuestRandomInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ParentQuestRandomInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ParentQuestRandomInfo parseFrom(CodedInputStream input) throws IOException {
            return (ParentQuestRandomInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ParentQuestRandomInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ParentQuestRandomInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ParentQuestRandomInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ParentQuestRandomInfoOuterClass$ParentQuestRandomInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ParentQuestRandomInfoOrBuilder {
            private int bitField0_;
            private int entranceId_;
            private Internal.IntList factorList_ = ParentQuestRandomInfo.emptyIntList();
            private int templateId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ParentQuestRandomInfoOuterClass.internal_static_ParentQuestRandomInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ParentQuestRandomInfoOuterClass.internal_static_ParentQuestRandomInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ParentQuestRandomInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ParentQuestRandomInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.entranceId_ = 0;
                this.factorList_ = ParentQuestRandomInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.templateId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ParentQuestRandomInfoOuterClass.internal_static_ParentQuestRandomInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ParentQuestRandomInfo getDefaultInstanceForType() {
                return ParentQuestRandomInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ParentQuestRandomInfo build() {
                ParentQuestRandomInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ParentQuestRandomInfo buildPartial() {
                ParentQuestRandomInfo result = new ParentQuestRandomInfo(this);
                int i = this.bitField0_;
                result.entranceId_ = this.entranceId_;
                if ((this.bitField0_ & 1) != 0) {
                    this.factorList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.factorList_ = this.factorList_;
                result.templateId_ = this.templateId_;
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
                if (other instanceof ParentQuestRandomInfo) {
                    return mergeFrom((ParentQuestRandomInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ParentQuestRandomInfo other) {
                if (other == ParentQuestRandomInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getEntranceId() != 0) {
                    setEntranceId(other.getEntranceId());
                }
                if (!other.factorList_.isEmpty()) {
                    if (this.factorList_.isEmpty()) {
                        this.factorList_ = other.factorList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFactorListIsMutable();
                        this.factorList_.addAll(other.factorList_);
                    }
                    onChanged();
                }
                if (other.getTemplateId() != 0) {
                    setTemplateId(other.getTemplateId());
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
                ParentQuestRandomInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ParentQuestRandomInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ParentQuestRandomInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ParentQuestRandomInfoOuterClass.ParentQuestRandomInfoOrBuilder
            public int getEntranceId() {
                return this.entranceId_;
            }

            public Builder setEntranceId(int value) {
                this.entranceId_ = value;
                onChanged();
                return this;
            }

            public Builder clearEntranceId() {
                this.entranceId_ = 0;
                onChanged();
                return this;
            }

            private void ensureFactorListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.factorList_ = ParentQuestRandomInfo.mutableCopy(this.factorList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ParentQuestRandomInfoOuterClass.ParentQuestRandomInfoOrBuilder
            public List<Integer> getFactorListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.factorList_) : this.factorList_;
            }

            @Override // emu.grasscutter.net.proto.ParentQuestRandomInfoOuterClass.ParentQuestRandomInfoOrBuilder
            public int getFactorListCount() {
                return this.factorList_.size();
            }

            @Override // emu.grasscutter.net.proto.ParentQuestRandomInfoOuterClass.ParentQuestRandomInfoOrBuilder
            public int getFactorList(int index) {
                return this.factorList_.getInt(index);
            }

            public Builder setFactorList(int index, int value) {
                ensureFactorListIsMutable();
                this.factorList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addFactorList(int value) {
                ensureFactorListIsMutable();
                this.factorList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllFactorList(Iterable<? extends Integer> values) {
                ensureFactorListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.factorList_);
                onChanged();
                return this;
            }

            public Builder clearFactorList() {
                this.factorList_ = ParentQuestRandomInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ParentQuestRandomInfoOuterClass.ParentQuestRandomInfoOrBuilder
            public int getTemplateId() {
                return this.templateId_;
            }

            public Builder setTemplateId(int value) {
                this.templateId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTemplateId() {
                this.templateId_ = 0;
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

        public static ParentQuestRandomInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ParentQuestRandomInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ParentQuestRandomInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ParentQuestRandomInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
