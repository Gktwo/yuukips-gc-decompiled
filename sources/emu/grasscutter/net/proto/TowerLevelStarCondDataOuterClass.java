package emu.grasscutter.net.proto;

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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerLevelStarCondDataOuterClass.class */
public final class TowerLevelStarCondDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cTowerLevelStarCondData.proto\"\u0001\n\u0016TowerLevelStarCondData\u0012\u001b\n\u0013Unk3300_KBCFDFOAJMM\u0018\u000e \u0001(\b\u0012\u001b\n\u0013Unk3300_CPBCNACKAAK\u0018\u0005 \u0001(\b\u0012\u001b\n\u0013Unk3300_JGOLBFMJBCL\u0018\u000b \u0001(\r\u0012\u0012\n\ncond_value\u0018\f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TowerLevelStarCondData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TowerLevelStarCondData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TowerLevelStarCondData_descriptor, new String[]{"Unk3300KBCFDFOAJMM", "Unk3300CPBCNACKAAK", "Unk3300JGOLBFMJBCL", "CondValue"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerLevelStarCondDataOuterClass$TowerLevelStarCondDataOrBuilder.class */
    public interface TowerLevelStarCondDataOrBuilder extends MessageOrBuilder {
        boolean getUnk3300KBCFDFOAJMM();

        boolean getUnk3300CPBCNACKAAK();

        int getUnk3300JGOLBFMJBCL();

        int getCondValue();
    }

    private TowerLevelStarCondDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerLevelStarCondDataOuterClass$TowerLevelStarCondData.class */
    public static final class TowerLevelStarCondData extends GeneratedMessageV3 implements TowerLevelStarCondDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_KBCFDFOAJMM_FIELD_NUMBER = 14;
        private boolean unk3300KBCFDFOAJMM_;
        public static final int UNK3300_CPBCNACKAAK_FIELD_NUMBER = 5;
        private boolean unk3300CPBCNACKAAK_;
        public static final int UNK3300_JGOLBFMJBCL_FIELD_NUMBER = 11;
        private int unk3300JGOLBFMJBCL_;
        public static final int COND_VALUE_FIELD_NUMBER = 12;
        private int condValue_;
        private byte memoizedIsInitialized;
        private static final TowerLevelStarCondData DEFAULT_INSTANCE = new TowerLevelStarCondData();
        private static final Parser<TowerLevelStarCondData> PARSER = new AbstractParser<TowerLevelStarCondData>() { // from class: emu.grasscutter.net.proto.TowerLevelStarCondDataOuterClass.TowerLevelStarCondData.1
            @Override // com.google.protobuf.Parser
            public TowerLevelStarCondData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TowerLevelStarCondData(input, extensionRegistry);
            }
        };

        private TowerLevelStarCondData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TowerLevelStarCondData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TowerLevelStarCondData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TowerLevelStarCondData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 40:
                                    this.unk3300CPBCNACKAAK_ = input.readBool();
                                    break;
                                case 88:
                                    this.unk3300JGOLBFMJBCL_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.condValue_ = input.readUInt32();
                                    break;
                                case 112:
                                    this.unk3300KBCFDFOAJMM_ = input.readBool();
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
            return TowerLevelStarCondDataOuterClass.internal_static_TowerLevelStarCondData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TowerLevelStarCondDataOuterClass.internal_static_TowerLevelStarCondData_fieldAccessorTable.ensureFieldAccessorsInitialized(TowerLevelStarCondData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TowerLevelStarCondDataOuterClass.TowerLevelStarCondDataOrBuilder
        public boolean getUnk3300KBCFDFOAJMM() {
            return this.unk3300KBCFDFOAJMM_;
        }

        @Override // emu.grasscutter.net.proto.TowerLevelStarCondDataOuterClass.TowerLevelStarCondDataOrBuilder
        public boolean getUnk3300CPBCNACKAAK() {
            return this.unk3300CPBCNACKAAK_;
        }

        @Override // emu.grasscutter.net.proto.TowerLevelStarCondDataOuterClass.TowerLevelStarCondDataOrBuilder
        public int getUnk3300JGOLBFMJBCL() {
            return this.unk3300JGOLBFMJBCL_;
        }

        @Override // emu.grasscutter.net.proto.TowerLevelStarCondDataOuterClass.TowerLevelStarCondDataOrBuilder
        public int getCondValue() {
            return this.condValue_;
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
            if (this.unk3300CPBCNACKAAK_) {
                output.writeBool(5, this.unk3300CPBCNACKAAK_);
            }
            if (this.unk3300JGOLBFMJBCL_ != 0) {
                output.writeUInt32(11, this.unk3300JGOLBFMJBCL_);
            }
            if (this.condValue_ != 0) {
                output.writeUInt32(12, this.condValue_);
            }
            if (this.unk3300KBCFDFOAJMM_) {
                output.writeBool(14, this.unk3300KBCFDFOAJMM_);
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
            if (this.unk3300CPBCNACKAAK_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(5, this.unk3300CPBCNACKAAK_);
            }
            if (this.unk3300JGOLBFMJBCL_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.unk3300JGOLBFMJBCL_);
            }
            if (this.condValue_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.condValue_);
            }
            if (this.unk3300KBCFDFOAJMM_) {
                size2 += CodedOutputStream.computeBoolSize(14, this.unk3300KBCFDFOAJMM_);
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
            if (!(obj instanceof TowerLevelStarCondData)) {
                return equals(obj);
            }
            TowerLevelStarCondData other = (TowerLevelStarCondData) obj;
            return getUnk3300KBCFDFOAJMM() == other.getUnk3300KBCFDFOAJMM() && getUnk3300CPBCNACKAAK() == other.getUnk3300CPBCNACKAAK() && getUnk3300JGOLBFMJBCL() == other.getUnk3300JGOLBFMJBCL() && getCondValue() == other.getCondValue() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + Internal.hashBoolean(getUnk3300KBCFDFOAJMM()))) + 5)) + Internal.hashBoolean(getUnk3300CPBCNACKAAK()))) + 11)) + getUnk3300JGOLBFMJBCL())) + 12)) + getCondValue())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static TowerLevelStarCondData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerLevelStarCondData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerLevelStarCondData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerLevelStarCondData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerLevelStarCondData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerLevelStarCondData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerLevelStarCondData parseFrom(InputStream input) throws IOException {
            return (TowerLevelStarCondData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerLevelStarCondData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerLevelStarCondData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerLevelStarCondData parseDelimitedFrom(InputStream input) throws IOException {
            return (TowerLevelStarCondData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TowerLevelStarCondData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerLevelStarCondData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerLevelStarCondData parseFrom(CodedInputStream input) throws IOException {
            return (TowerLevelStarCondData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerLevelStarCondData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerLevelStarCondData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TowerLevelStarCondData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerLevelStarCondDataOuterClass$TowerLevelStarCondData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TowerLevelStarCondDataOrBuilder {
            private boolean unk3300KBCFDFOAJMM_;
            private boolean unk3300CPBCNACKAAK_;
            private int unk3300JGOLBFMJBCL_;
            private int condValue_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TowerLevelStarCondDataOuterClass.internal_static_TowerLevelStarCondData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TowerLevelStarCondDataOuterClass.internal_static_TowerLevelStarCondData_fieldAccessorTable.ensureFieldAccessorsInitialized(TowerLevelStarCondData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TowerLevelStarCondData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300KBCFDFOAJMM_ = false;
                this.unk3300CPBCNACKAAK_ = false;
                this.unk3300JGOLBFMJBCL_ = 0;
                this.condValue_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TowerLevelStarCondDataOuterClass.internal_static_TowerLevelStarCondData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TowerLevelStarCondData getDefaultInstanceForType() {
                return TowerLevelStarCondData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerLevelStarCondData build() {
                TowerLevelStarCondData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerLevelStarCondData buildPartial() {
                TowerLevelStarCondData result = new TowerLevelStarCondData(this);
                result.unk3300KBCFDFOAJMM_ = this.unk3300KBCFDFOAJMM_;
                result.unk3300CPBCNACKAAK_ = this.unk3300CPBCNACKAAK_;
                result.unk3300JGOLBFMJBCL_ = this.unk3300JGOLBFMJBCL_;
                result.condValue_ = this.condValue_;
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
                if (other instanceof TowerLevelStarCondData) {
                    return mergeFrom((TowerLevelStarCondData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TowerLevelStarCondData other) {
                if (other == TowerLevelStarCondData.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300KBCFDFOAJMM()) {
                    setUnk3300KBCFDFOAJMM(other.getUnk3300KBCFDFOAJMM());
                }
                if (other.getUnk3300CPBCNACKAAK()) {
                    setUnk3300CPBCNACKAAK(other.getUnk3300CPBCNACKAAK());
                }
                if (other.getUnk3300JGOLBFMJBCL() != 0) {
                    setUnk3300JGOLBFMJBCL(other.getUnk3300JGOLBFMJBCL());
                }
                if (other.getCondValue() != 0) {
                    setCondValue(other.getCondValue());
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
                TowerLevelStarCondData parsedMessage = null;
                try {
                    try {
                        parsedMessage = TowerLevelStarCondData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TowerLevelStarCondData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TowerLevelStarCondDataOuterClass.TowerLevelStarCondDataOrBuilder
            public boolean getUnk3300KBCFDFOAJMM() {
                return this.unk3300KBCFDFOAJMM_;
            }

            public Builder setUnk3300KBCFDFOAJMM(boolean value) {
                this.unk3300KBCFDFOAJMM_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300KBCFDFOAJMM() {
                this.unk3300KBCFDFOAJMM_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerLevelStarCondDataOuterClass.TowerLevelStarCondDataOrBuilder
            public boolean getUnk3300CPBCNACKAAK() {
                return this.unk3300CPBCNACKAAK_;
            }

            public Builder setUnk3300CPBCNACKAAK(boolean value) {
                this.unk3300CPBCNACKAAK_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300CPBCNACKAAK() {
                this.unk3300CPBCNACKAAK_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerLevelStarCondDataOuterClass.TowerLevelStarCondDataOrBuilder
            public int getUnk3300JGOLBFMJBCL() {
                return this.unk3300JGOLBFMJBCL_;
            }

            public Builder setUnk3300JGOLBFMJBCL(int value) {
                this.unk3300JGOLBFMJBCL_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300JGOLBFMJBCL() {
                this.unk3300JGOLBFMJBCL_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerLevelStarCondDataOuterClass.TowerLevelStarCondDataOrBuilder
            public int getCondValue() {
                return this.condValue_;
            }

            public Builder setCondValue(int value) {
                this.condValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearCondValue() {
                this.condValue_ = 0;
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

        public static TowerLevelStarCondData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TowerLevelStarCondData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TowerLevelStarCondData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TowerLevelStarCondData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
