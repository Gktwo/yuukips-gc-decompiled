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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OfficialCustomDungeonOuterClass.class */
public final class OfficialCustomDungeonOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bOfficialCustomDungeon.proto\">\n\u0015OfficialCustomDungeon\u0012\u0012\n\ndungeon_id\u0018\u0004 \u0001(\r\u0012\u0011\n\twin_times\u0018\r \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_OfficialCustomDungeon_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_OfficialCustomDungeon_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_OfficialCustomDungeon_descriptor, new String[]{"DungeonId", "WinTimes"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OfficialCustomDungeonOuterClass$OfficialCustomDungeonOrBuilder.class */
    public interface OfficialCustomDungeonOrBuilder extends MessageOrBuilder {
        int getDungeonId();

        int getWinTimes();
    }

    private OfficialCustomDungeonOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OfficialCustomDungeonOuterClass$OfficialCustomDungeon.class */
    public static final class OfficialCustomDungeon extends GeneratedMessageV3 implements OfficialCustomDungeonOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DUNGEON_ID_FIELD_NUMBER = 4;
        private int dungeonId_;
        public static final int WIN_TIMES_FIELD_NUMBER = 13;
        private int winTimes_;
        private byte memoizedIsInitialized;
        private static final OfficialCustomDungeon DEFAULT_INSTANCE = new OfficialCustomDungeon();
        private static final Parser<OfficialCustomDungeon> PARSER = new AbstractParser<OfficialCustomDungeon>() { // from class: emu.grasscutter.net.proto.OfficialCustomDungeonOuterClass.OfficialCustomDungeon.1
            @Override // com.google.protobuf.Parser
            public OfficialCustomDungeon parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new OfficialCustomDungeon(input, extensionRegistry);
            }
        };

        private OfficialCustomDungeon(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private OfficialCustomDungeon() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new OfficialCustomDungeon();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OfficialCustomDungeon(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                this.dungeonId_ = input.readUInt32();
                                break;
                            case 104:
                                this.winTimes_ = input.readUInt32();
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
            return OfficialCustomDungeonOuterClass.internal_static_OfficialCustomDungeon_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return OfficialCustomDungeonOuterClass.internal_static_OfficialCustomDungeon_fieldAccessorTable.ensureFieldAccessorsInitialized(OfficialCustomDungeon.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.OfficialCustomDungeonOuterClass.OfficialCustomDungeonOrBuilder
        public int getDungeonId() {
            return this.dungeonId_;
        }

        @Override // emu.grasscutter.net.proto.OfficialCustomDungeonOuterClass.OfficialCustomDungeonOrBuilder
        public int getWinTimes() {
            return this.winTimes_;
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
            if (this.dungeonId_ != 0) {
                output.writeUInt32(4, this.dungeonId_);
            }
            if (this.winTimes_ != 0) {
                output.writeUInt32(13, this.winTimes_);
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
            if (this.dungeonId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.dungeonId_);
            }
            if (this.winTimes_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.winTimes_);
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
            if (!(obj instanceof OfficialCustomDungeon)) {
                return equals(obj);
            }
            OfficialCustomDungeon other = (OfficialCustomDungeon) obj;
            return getDungeonId() == other.getDungeonId() && getWinTimes() == other.getWinTimes() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getDungeonId())) + 13)) + getWinTimes())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static OfficialCustomDungeon parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static OfficialCustomDungeon parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static OfficialCustomDungeon parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static OfficialCustomDungeon parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static OfficialCustomDungeon parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static OfficialCustomDungeon parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static OfficialCustomDungeon parseFrom(InputStream input) throws IOException {
            return (OfficialCustomDungeon) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static OfficialCustomDungeon parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OfficialCustomDungeon) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static OfficialCustomDungeon parseDelimitedFrom(InputStream input) throws IOException {
            return (OfficialCustomDungeon) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static OfficialCustomDungeon parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OfficialCustomDungeon) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static OfficialCustomDungeon parseFrom(CodedInputStream input) throws IOException {
            return (OfficialCustomDungeon) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static OfficialCustomDungeon parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OfficialCustomDungeon) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(OfficialCustomDungeon prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OfficialCustomDungeonOuterClass$OfficialCustomDungeon$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements OfficialCustomDungeonOrBuilder {
            private int dungeonId_;
            private int winTimes_;

            public static final Descriptors.Descriptor getDescriptor() {
                return OfficialCustomDungeonOuterClass.internal_static_OfficialCustomDungeon_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return OfficialCustomDungeonOuterClass.internal_static_OfficialCustomDungeon_fieldAccessorTable.ensureFieldAccessorsInitialized(OfficialCustomDungeon.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (OfficialCustomDungeon.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.dungeonId_ = 0;
                this.winTimes_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return OfficialCustomDungeonOuterClass.internal_static_OfficialCustomDungeon_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public OfficialCustomDungeon getDefaultInstanceForType() {
                return OfficialCustomDungeon.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public OfficialCustomDungeon build() {
                OfficialCustomDungeon result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public OfficialCustomDungeon buildPartial() {
                OfficialCustomDungeon result = new OfficialCustomDungeon(this);
                result.dungeonId_ = this.dungeonId_;
                result.winTimes_ = this.winTimes_;
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
                if (other instanceof OfficialCustomDungeon) {
                    return mergeFrom((OfficialCustomDungeon) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(OfficialCustomDungeon other) {
                if (other == OfficialCustomDungeon.getDefaultInstance()) {
                    return this;
                }
                if (other.getDungeonId() != 0) {
                    setDungeonId(other.getDungeonId());
                }
                if (other.getWinTimes() != 0) {
                    setWinTimes(other.getWinTimes());
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
                OfficialCustomDungeon parsedMessage = null;
                try {
                    try {
                        parsedMessage = OfficialCustomDungeon.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (OfficialCustomDungeon) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.OfficialCustomDungeonOuterClass.OfficialCustomDungeonOrBuilder
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

            @Override // emu.grasscutter.net.proto.OfficialCustomDungeonOuterClass.OfficialCustomDungeonOrBuilder
            public int getWinTimes() {
                return this.winTimes_;
            }

            public Builder setWinTimes(int value) {
                this.winTimes_ = value;
                onChanged();
                return this;
            }

            public Builder clearWinTimes() {
                this.winTimes_ = 0;
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

        public static OfficialCustomDungeon getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<OfficialCustomDungeon> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<OfficialCustomDungeon> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public OfficialCustomDungeon getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
