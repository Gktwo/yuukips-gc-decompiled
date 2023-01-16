package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeDungeonInfoOuterClass.class */
public final class SummerTimeDungeonInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bSummerTimeDungeonInfo.proto\"\u0001\n\u0015SummerTimeDungeonInfo\u0012\u0012\n\ndungeon_id\u0018\t \u0001(\r\u0012\u001b\n\u0013Unk3300_GMKMNHIBPEP\u0018\u0001 \u0001(\r\u0012\u001b\n\u0013Unk3300_HJHODMOIMKG\u0018\b \u0001(\r\u0012\u001b\n\u0013Unk3300_GALEDJLAIPM\u0018\u0005 \u0001(\r\u0012\u001b\n\u0013Unk3300_EGGFJCICOBD\u0018\f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SummerTimeDungeonInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SummerTimeDungeonInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SummerTimeDungeonInfo_descriptor, new String[]{"DungeonId", "Unk3300GMKMNHIBPEP", "Unk3300HJHODMOIMKG", "Unk3300GALEDJLAIPM", "Unk3300EGGFJCICOBD"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeDungeonInfoOuterClass$SummerTimeDungeonInfoOrBuilder.class */
    public interface SummerTimeDungeonInfoOrBuilder extends MessageOrBuilder {
        int getDungeonId();

        int getUnk3300GMKMNHIBPEP();

        int getUnk3300HJHODMOIMKG();

        int getUnk3300GALEDJLAIPM();

        int getUnk3300EGGFJCICOBD();
    }

    private SummerTimeDungeonInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeDungeonInfoOuterClass$SummerTimeDungeonInfo.class */
    public static final class SummerTimeDungeonInfo extends GeneratedMessageV3 implements SummerTimeDungeonInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DUNGEON_ID_FIELD_NUMBER = 9;
        private int dungeonId_;
        public static final int UNK3300_GMKMNHIBPEP_FIELD_NUMBER = 1;
        private int unk3300GMKMNHIBPEP_;
        public static final int UNK3300_HJHODMOIMKG_FIELD_NUMBER = 8;
        private int unk3300HJHODMOIMKG_;
        public static final int UNK3300_GALEDJLAIPM_FIELD_NUMBER = 5;
        private int unk3300GALEDJLAIPM_;
        public static final int UNK3300_EGGFJCICOBD_FIELD_NUMBER = 12;
        private int unk3300EGGFJCICOBD_;
        private byte memoizedIsInitialized;
        private static final SummerTimeDungeonInfo DEFAULT_INSTANCE = new SummerTimeDungeonInfo();
        private static final Parser<SummerTimeDungeonInfo> PARSER = new AbstractParser<SummerTimeDungeonInfo>() { // from class: emu.grasscutter.net.proto.SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo.1
            @Override // com.google.protobuf.Parser
            public SummerTimeDungeonInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SummerTimeDungeonInfo(input, extensionRegistry);
            }
        };

        private SummerTimeDungeonInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SummerTimeDungeonInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SummerTimeDungeonInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SummerTimeDungeonInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 8:
                                this.unk3300GMKMNHIBPEP_ = input.readUInt32();
                                break;
                            case 40:
                                this.unk3300GALEDJLAIPM_ = input.readUInt32();
                                break;
                            case 64:
                                this.unk3300HJHODMOIMKG_ = input.readUInt32();
                                break;
                            case 72:
                                this.dungeonId_ = input.readUInt32();
                                break;
                            case 96:
                                this.unk3300EGGFJCICOBD_ = input.readUInt32();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SummerTimeDungeonInfoOuterClass.internal_static_SummerTimeDungeonInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SummerTimeDungeonInfoOuterClass.internal_static_SummerTimeDungeonInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SummerTimeDungeonInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfoOrBuilder
        public int getDungeonId() {
            return this.dungeonId_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfoOrBuilder
        public int getUnk3300GMKMNHIBPEP() {
            return this.unk3300GMKMNHIBPEP_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfoOrBuilder
        public int getUnk3300HJHODMOIMKG() {
            return this.unk3300HJHODMOIMKG_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfoOrBuilder
        public int getUnk3300GALEDJLAIPM() {
            return this.unk3300GALEDJLAIPM_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfoOrBuilder
        public int getUnk3300EGGFJCICOBD() {
            return this.unk3300EGGFJCICOBD_;
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
            if (this.unk3300GMKMNHIBPEP_ != 0) {
                output.writeUInt32(1, this.unk3300GMKMNHIBPEP_);
            }
            if (this.unk3300GALEDJLAIPM_ != 0) {
                output.writeUInt32(5, this.unk3300GALEDJLAIPM_);
            }
            if (this.unk3300HJHODMOIMKG_ != 0) {
                output.writeUInt32(8, this.unk3300HJHODMOIMKG_);
            }
            if (this.dungeonId_ != 0) {
                output.writeUInt32(9, this.dungeonId_);
            }
            if (this.unk3300EGGFJCICOBD_ != 0) {
                output.writeUInt32(12, this.unk3300EGGFJCICOBD_);
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
            if (this.unk3300GMKMNHIBPEP_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.unk3300GMKMNHIBPEP_);
            }
            if (this.unk3300GALEDJLAIPM_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.unk3300GALEDJLAIPM_);
            }
            if (this.unk3300HJHODMOIMKG_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.unk3300HJHODMOIMKG_);
            }
            if (this.dungeonId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.dungeonId_);
            }
            if (this.unk3300EGGFJCICOBD_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.unk3300EGGFJCICOBD_);
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
            if (!(obj instanceof SummerTimeDungeonInfo)) {
                return equals(obj);
            }
            SummerTimeDungeonInfo other = (SummerTimeDungeonInfo) obj;
            return getDungeonId() == other.getDungeonId() && getUnk3300GMKMNHIBPEP() == other.getUnk3300GMKMNHIBPEP() && getUnk3300HJHODMOIMKG() == other.getUnk3300HJHODMOIMKG() && getUnk3300GALEDJLAIPM() == other.getUnk3300GALEDJLAIPM() && getUnk3300EGGFJCICOBD() == other.getUnk3300EGGFJCICOBD() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getDungeonId())) + 1)) + getUnk3300GMKMNHIBPEP())) + 8)) + getUnk3300HJHODMOIMKG())) + 5)) + getUnk3300GALEDJLAIPM())) + 12)) + getUnk3300EGGFJCICOBD())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static SummerTimeDungeonInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeDungeonInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeDungeonInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeDungeonInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeDungeonInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeDungeonInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeDungeonInfo parseFrom(InputStream input) throws IOException {
            return (SummerTimeDungeonInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SummerTimeDungeonInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeDungeonInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SummerTimeDungeonInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SummerTimeDungeonInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SummerTimeDungeonInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeDungeonInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SummerTimeDungeonInfo parseFrom(CodedInputStream input) throws IOException {
            return (SummerTimeDungeonInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SummerTimeDungeonInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeDungeonInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SummerTimeDungeonInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeDungeonInfoOuterClass$SummerTimeDungeonInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SummerTimeDungeonInfoOrBuilder {
            private int dungeonId_;
            private int unk3300GMKMNHIBPEP_;
            private int unk3300HJHODMOIMKG_;
            private int unk3300GALEDJLAIPM_;
            private int unk3300EGGFJCICOBD_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SummerTimeDungeonInfoOuterClass.internal_static_SummerTimeDungeonInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SummerTimeDungeonInfoOuterClass.internal_static_SummerTimeDungeonInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SummerTimeDungeonInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SummerTimeDungeonInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.dungeonId_ = 0;
                this.unk3300GMKMNHIBPEP_ = 0;
                this.unk3300HJHODMOIMKG_ = 0;
                this.unk3300GALEDJLAIPM_ = 0;
                this.unk3300EGGFJCICOBD_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SummerTimeDungeonInfoOuterClass.internal_static_SummerTimeDungeonInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SummerTimeDungeonInfo getDefaultInstanceForType() {
                return SummerTimeDungeonInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SummerTimeDungeonInfo build() {
                SummerTimeDungeonInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SummerTimeDungeonInfo buildPartial() {
                SummerTimeDungeonInfo result = new SummerTimeDungeonInfo(this);
                result.dungeonId_ = this.dungeonId_;
                result.unk3300GMKMNHIBPEP_ = this.unk3300GMKMNHIBPEP_;
                result.unk3300HJHODMOIMKG_ = this.unk3300HJHODMOIMKG_;
                result.unk3300GALEDJLAIPM_ = this.unk3300GALEDJLAIPM_;
                result.unk3300EGGFJCICOBD_ = this.unk3300EGGFJCICOBD_;
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
                if (other instanceof SummerTimeDungeonInfo) {
                    return mergeFrom((SummerTimeDungeonInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SummerTimeDungeonInfo other) {
                if (other == SummerTimeDungeonInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getDungeonId() != 0) {
                    setDungeonId(other.getDungeonId());
                }
                if (other.getUnk3300GMKMNHIBPEP() != 0) {
                    setUnk3300GMKMNHIBPEP(other.getUnk3300GMKMNHIBPEP());
                }
                if (other.getUnk3300HJHODMOIMKG() != 0) {
                    setUnk3300HJHODMOIMKG(other.getUnk3300HJHODMOIMKG());
                }
                if (other.getUnk3300GALEDJLAIPM() != 0) {
                    setUnk3300GALEDJLAIPM(other.getUnk3300GALEDJLAIPM());
                }
                if (other.getUnk3300EGGFJCICOBD() != 0) {
                    setUnk3300EGGFJCICOBD(other.getUnk3300EGGFJCICOBD());
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
                SummerTimeDungeonInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SummerTimeDungeonInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SummerTimeDungeonInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfoOrBuilder
            public int getDungeonId() {
                return this.dungeonId_;
            }

            public Builder setDungeonId(int value) {
                this.dungeonId_ = value;
                onChanged();
                return this;
            }

            public Builder clearDungeonId() {
                this.dungeonId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfoOrBuilder
            public int getUnk3300GMKMNHIBPEP() {
                return this.unk3300GMKMNHIBPEP_;
            }

            public Builder setUnk3300GMKMNHIBPEP(int value) {
                this.unk3300GMKMNHIBPEP_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300GMKMNHIBPEP() {
                this.unk3300GMKMNHIBPEP_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfoOrBuilder
            public int getUnk3300HJHODMOIMKG() {
                return this.unk3300HJHODMOIMKG_;
            }

            public Builder setUnk3300HJHODMOIMKG(int value) {
                this.unk3300HJHODMOIMKG_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300HJHODMOIMKG() {
                this.unk3300HJHODMOIMKG_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfoOrBuilder
            public int getUnk3300GALEDJLAIPM() {
                return this.unk3300GALEDJLAIPM_;
            }

            public Builder setUnk3300GALEDJLAIPM(int value) {
                this.unk3300GALEDJLAIPM_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300GALEDJLAIPM() {
                this.unk3300GALEDJLAIPM_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfoOrBuilder
            public int getUnk3300EGGFJCICOBD() {
                return this.unk3300EGGFJCICOBD_;
            }

            public Builder setUnk3300EGGFJCICOBD(int value) {
                this.unk3300EGGFJCICOBD_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300EGGFJCICOBD() {
                this.unk3300EGGFJCICOBD_ = 0;
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

        public static SummerTimeDungeonInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SummerTimeDungeonInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SummerTimeDungeonInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SummerTimeDungeonInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
