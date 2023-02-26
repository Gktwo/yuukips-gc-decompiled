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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusTrainingMonsterPreviewDetailOuterClass.class */
public final class FungusTrainingMonsterPreviewDetailOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n(FungusTrainingMonsterPreviewDetail.proto\"Y\n\"FungusTrainingMonsterPreviewDetail\u0012\u0011\n\tmonsterId\u0018\u0003 \u0001(\r\u0012\r\n\u0005level\u0018\u0005 \u0001(\r\u0012\u0011\n\taffixList\u0018\u000b \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_FungusTrainingMonsterPreviewDetail_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_FungusTrainingMonsterPreviewDetail_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f716x99eb633e = new GeneratedMessageV3.FieldAccessorTable(internal_static_FungusTrainingMonsterPreviewDetail_descriptor, new String[]{"MonsterId", "Level", "AffixList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusTrainingMonsterPreviewDetailOuterClass$FungusTrainingMonsterPreviewDetailOrBuilder.class */
    public interface FungusTrainingMonsterPreviewDetailOrBuilder extends MessageOrBuilder {
        int getMonsterId();

        int getLevel();

        List<Integer> getAffixListList();

        int getAffixListCount();

        int getAffixList(int i);
    }

    private FungusTrainingMonsterPreviewDetailOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusTrainingMonsterPreviewDetailOuterClass$FungusTrainingMonsterPreviewDetail.class */
    public static final class FungusTrainingMonsterPreviewDetail extends GeneratedMessageV3 implements FungusTrainingMonsterPreviewDetailOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MONSTERID_FIELD_NUMBER = 3;
        private int monsterId_;
        public static final int LEVEL_FIELD_NUMBER = 5;
        private int level_;
        public static final int AFFIXLIST_FIELD_NUMBER = 11;
        private Internal.IntList affixList_;
        private int affixListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final FungusTrainingMonsterPreviewDetail DEFAULT_INSTANCE = new FungusTrainingMonsterPreviewDetail();
        private static final Parser<FungusTrainingMonsterPreviewDetail> PARSER = new AbstractParser<FungusTrainingMonsterPreviewDetail>() { // from class: emu.grasscutter.net.proto.FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail.1
            @Override // com.google.protobuf.Parser
            public FungusTrainingMonsterPreviewDetail parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FungusTrainingMonsterPreviewDetail(input, extensionRegistry);
            }
        };

        private FungusTrainingMonsterPreviewDetail(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.affixListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private FungusTrainingMonsterPreviewDetail() {
            this.affixListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.affixList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FungusTrainingMonsterPreviewDetail();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FungusTrainingMonsterPreviewDetail(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.monsterId_ = input.readUInt32();
                                break;
                            case 40:
                                this.level_ = input.readUInt32();
                                break;
                            case 88:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.affixList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.affixList_.addInt(input.readUInt32());
                                break;
                            case 90:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.affixList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.affixList_.addInt(input.readUInt32());
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
                    this.affixList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FungusTrainingMonsterPreviewDetailOuterClass.internal_static_FungusTrainingMonsterPreviewDetail_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FungusTrainingMonsterPreviewDetailOuterClass.f716x99eb633e.ensureFieldAccessorsInitialized(FungusTrainingMonsterPreviewDetail.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetailOrBuilder
        public int getMonsterId() {
            return this.monsterId_;
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetailOrBuilder
        public int getLevel() {
            return this.level_;
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetailOrBuilder
        public List<Integer> getAffixListList() {
            return this.affixList_;
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetailOrBuilder
        public int getAffixListCount() {
            return this.affixList_.size();
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetailOrBuilder
        public int getAffixList(int index) {
            return this.affixList_.getInt(index);
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
            if (this.monsterId_ != 0) {
                output.writeUInt32(3, this.monsterId_);
            }
            if (this.level_ != 0) {
                output.writeUInt32(5, this.level_);
            }
            if (getAffixListList().size() > 0) {
                output.writeUInt32NoTag(90);
                output.writeUInt32NoTag(this.affixListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.affixList_.size(); i++) {
                output.writeUInt32NoTag(this.affixList_.getInt(i));
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
            if (this.monsterId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.monsterId_);
            }
            if (this.level_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.level_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.affixList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.affixList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getAffixListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.affixListMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FungusTrainingMonsterPreviewDetail)) {
                return equals(obj);
            }
            FungusTrainingMonsterPreviewDetail other = (FungusTrainingMonsterPreviewDetail) obj;
            return getMonsterId() == other.getMonsterId() && getLevel() == other.getLevel() && getAffixListList().equals(other.getAffixListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getMonsterId())) + 5)) + getLevel();
            if (getAffixListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getAffixListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FungusTrainingMonsterPreviewDetail parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FungusTrainingMonsterPreviewDetail parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FungusTrainingMonsterPreviewDetail parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FungusTrainingMonsterPreviewDetail parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FungusTrainingMonsterPreviewDetail parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FungusTrainingMonsterPreviewDetail parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FungusTrainingMonsterPreviewDetail parseFrom(InputStream input) throws IOException {
            return (FungusTrainingMonsterPreviewDetail) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FungusTrainingMonsterPreviewDetail parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FungusTrainingMonsterPreviewDetail) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FungusTrainingMonsterPreviewDetail parseDelimitedFrom(InputStream input) throws IOException {
            return (FungusTrainingMonsterPreviewDetail) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FungusTrainingMonsterPreviewDetail parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FungusTrainingMonsterPreviewDetail) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FungusTrainingMonsterPreviewDetail parseFrom(CodedInputStream input) throws IOException {
            return (FungusTrainingMonsterPreviewDetail) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FungusTrainingMonsterPreviewDetail parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FungusTrainingMonsterPreviewDetail) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FungusTrainingMonsterPreviewDetail prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusTrainingMonsterPreviewDetailOuterClass$FungusTrainingMonsterPreviewDetail$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FungusTrainingMonsterPreviewDetailOrBuilder {
            private int bitField0_;
            private int monsterId_;
            private int level_;
            private Internal.IntList affixList_ = FungusTrainingMonsterPreviewDetail.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return FungusTrainingMonsterPreviewDetailOuterClass.internal_static_FungusTrainingMonsterPreviewDetail_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FungusTrainingMonsterPreviewDetailOuterClass.f716x99eb633e.ensureFieldAccessorsInitialized(FungusTrainingMonsterPreviewDetail.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FungusTrainingMonsterPreviewDetail.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.monsterId_ = 0;
                this.level_ = 0;
                this.affixList_ = FungusTrainingMonsterPreviewDetail.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FungusTrainingMonsterPreviewDetailOuterClass.internal_static_FungusTrainingMonsterPreviewDetail_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FungusTrainingMonsterPreviewDetail getDefaultInstanceForType() {
                return FungusTrainingMonsterPreviewDetail.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FungusTrainingMonsterPreviewDetail build() {
                FungusTrainingMonsterPreviewDetail result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FungusTrainingMonsterPreviewDetail buildPartial() {
                FungusTrainingMonsterPreviewDetail result = new FungusTrainingMonsterPreviewDetail(this);
                int i = this.bitField0_;
                result.monsterId_ = this.monsterId_;
                result.level_ = this.level_;
                if ((this.bitField0_ & 1) != 0) {
                    this.affixList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.affixList_ = this.affixList_;
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
                if (other instanceof FungusTrainingMonsterPreviewDetail) {
                    return mergeFrom((FungusTrainingMonsterPreviewDetail) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FungusTrainingMonsterPreviewDetail other) {
                if (other == FungusTrainingMonsterPreviewDetail.getDefaultInstance()) {
                    return this;
                }
                if (other.getMonsterId() != 0) {
                    setMonsterId(other.getMonsterId());
                }
                if (other.getLevel() != 0) {
                    setLevel(other.getLevel());
                }
                if (!other.affixList_.isEmpty()) {
                    if (this.affixList_.isEmpty()) {
                        this.affixList_ = other.affixList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureAffixListIsMutable();
                        this.affixList_.addAll(other.affixList_);
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
                FungusTrainingMonsterPreviewDetail parsedMessage = null;
                try {
                    try {
                        parsedMessage = FungusTrainingMonsterPreviewDetail.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FungusTrainingMonsterPreviewDetail) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetailOrBuilder
            public int getMonsterId() {
                return this.monsterId_;
            }

            public Builder setMonsterId(int value) {
                this.monsterId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMonsterId() {
                this.monsterId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetailOrBuilder
            public int getLevel() {
                return this.level_;
            }

            public Builder setLevel(int value) {
                this.level_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevel() {
                this.level_ = 0;
                onChanged();
                return this;
            }

            private void ensureAffixListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.affixList_ = FungusTrainingMonsterPreviewDetail.mutableCopy(this.affixList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetailOrBuilder
            public List<Integer> getAffixListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.affixList_) : this.affixList_;
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetailOrBuilder
            public int getAffixListCount() {
                return this.affixList_.size();
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetailOrBuilder
            public int getAffixList(int index) {
                return this.affixList_.getInt(index);
            }

            public Builder setAffixList(int index, int value) {
                ensureAffixListIsMutable();
                this.affixList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addAffixList(int value) {
                ensureAffixListIsMutable();
                this.affixList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllAffixList(Iterable<? extends Integer> values) {
                ensureAffixListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.affixList_);
                onChanged();
                return this;
            }

            public Builder clearAffixList() {
                this.affixList_ = FungusTrainingMonsterPreviewDetail.emptyIntList();
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

        public static FungusTrainingMonsterPreviewDetail getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FungusTrainingMonsterPreviewDetail> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FungusTrainingMonsterPreviewDetail> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FungusTrainingMonsterPreviewDetail getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
