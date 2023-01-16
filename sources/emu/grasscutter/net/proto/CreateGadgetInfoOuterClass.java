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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.GadgetBornTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CreateGadgetInfoOuterClass.class */
public final class CreateGadgetInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016CreateGadgetInfo.proto\u001a\u0014GadgetBornType.proto\"\u0001\n\u0010CreateGadgetInfo\u0012\"\n\tborn_type\u0018\u0001 \u0001(\u000e2\u000f.GadgetBornType\u0012&\n\u0005chest\u0018\u0002 \u0001(\u000b2\u0017.CreateGadgetInfo.Chest\u001a8\n\u0005Chest\u0012\u0015\n\rchest_drop_id\u0018\u0001 \u0001(\r\u0012\u0018\n\u0010is_show_cutscene\u0018\u0002 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{GadgetBornTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CreateGadgetInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CreateGadgetInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CreateGadgetInfo_descriptor, new String[]{"BornType", "Chest"});
    private static final Descriptors.Descriptor internal_static_CreateGadgetInfo_Chest_descriptor = internal_static_CreateGadgetInfo_descriptor.getNestedTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CreateGadgetInfo_Chest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CreateGadgetInfo_Chest_descriptor, new String[]{"ChestDropId", "IsShowCutscene"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CreateGadgetInfoOuterClass$CreateGadgetInfoOrBuilder.class */
    public interface CreateGadgetInfoOrBuilder extends MessageOrBuilder {
        int getBornTypeValue();

        GadgetBornTypeOuterClass.GadgetBornType getBornType();

        boolean hasChest();

        CreateGadgetInfo.Chest getChest();

        CreateGadgetInfo.ChestOrBuilder getChestOrBuilder();
    }

    private CreateGadgetInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CreateGadgetInfoOuterClass$CreateGadgetInfo.class */
    public static final class CreateGadgetInfo extends GeneratedMessageV3 implements CreateGadgetInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BORN_TYPE_FIELD_NUMBER = 1;
        private int bornType_;
        public static final int CHEST_FIELD_NUMBER = 2;
        private Chest chest_;
        private byte memoizedIsInitialized;
        private static final CreateGadgetInfo DEFAULT_INSTANCE = new CreateGadgetInfo();
        private static final Parser<CreateGadgetInfo> PARSER = new AbstractParser<CreateGadgetInfo>() { // from class: emu.grasscutter.net.proto.CreateGadgetInfoOuterClass.CreateGadgetInfo.1
            @Override // com.google.protobuf.Parser
            public CreateGadgetInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CreateGadgetInfo(input, extensionRegistry);
            }
        };

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CreateGadgetInfoOuterClass$CreateGadgetInfo$ChestOrBuilder.class */
        public interface ChestOrBuilder extends MessageOrBuilder {
            int getChestDropId();

            boolean getIsShowCutscene();
        }

        private CreateGadgetInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CreateGadgetInfo() {
            this.memoizedIsInitialized = -1;
            this.bornType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CreateGadgetInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CreateGadgetInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.bornType_ = input.readEnum();
                                    break;
                                case 18:
                                    Chest.Builder subBuilder = this.chest_ != null ? this.chest_.toBuilder() : null;
                                    this.chest_ = (Chest) input.readMessage(Chest.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.chest_);
                                        this.chest_ = subBuilder.buildPartial();
                                        break;
                                    }
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
            return CreateGadgetInfoOuterClass.internal_static_CreateGadgetInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CreateGadgetInfoOuterClass.internal_static_CreateGadgetInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CreateGadgetInfo.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CreateGadgetInfoOuterClass$CreateGadgetInfo$Chest.class */
        public static final class Chest extends GeneratedMessageV3 implements ChestOrBuilder {
            private static final long serialVersionUID = 0;
            public static final int CHEST_DROP_ID_FIELD_NUMBER = 1;
            private int chestDropId_;
            public static final int IS_SHOW_CUTSCENE_FIELD_NUMBER = 2;
            private boolean isShowCutscene_;
            private byte memoizedIsInitialized;
            private static final Chest DEFAULT_INSTANCE = new Chest();
            private static final Parser<Chest> PARSER = new AbstractParser<Chest>() { // from class: emu.grasscutter.net.proto.CreateGadgetInfoOuterClass.CreateGadgetInfo.Chest.1
                @Override // com.google.protobuf.Parser
                public Chest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new Chest(input, extensionRegistry);
                }
            };

            private Chest(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = -1;
            }

            private Chest() {
                this.memoizedIsInitialized = -1;
            }

            /* access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageV3
            public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
                return new Chest();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private Chest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.chestDropId_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.isShowCutscene_ = input.readBool();
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
                return CreateGadgetInfoOuterClass.internal_static_CreateGadgetInfo_Chest_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CreateGadgetInfoOuterClass.internal_static_CreateGadgetInfo_Chest_fieldAccessorTable.ensureFieldAccessorsInitialized(Chest.class, Builder.class);
            }

            @Override // emu.grasscutter.net.proto.CreateGadgetInfoOuterClass.CreateGadgetInfo.ChestOrBuilder
            public int getChestDropId() {
                return this.chestDropId_;
            }

            @Override // emu.grasscutter.net.proto.CreateGadgetInfoOuterClass.CreateGadgetInfo.ChestOrBuilder
            public boolean getIsShowCutscene() {
                return this.isShowCutscene_;
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
                if (this.chestDropId_ != 0) {
                    output.writeUInt32(1, this.chestDropId_);
                }
                if (this.isShowCutscene_) {
                    output.writeBool(2, this.isShowCutscene_);
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
                if (this.chestDropId_ != 0) {
                    size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.chestDropId_);
                }
                if (this.isShowCutscene_) {
                    size2 += CodedOutputStream.computeBoolSize(2, this.isShowCutscene_);
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
                if (!(obj instanceof Chest)) {
                    return equals(obj);
                }
                Chest other = (Chest) obj;
                return getChestDropId() == other.getChestDropId() && getIsShowCutscene() == other.getIsShowCutscene() && this.unknownFields.equals(other.unknownFields);
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getChestDropId())) + 2)) + Internal.hashBoolean(getIsShowCutscene()))) + this.unknownFields.hashCode();
                this.memoizedHashCode = hash;
                return hash;
            }

            public static Chest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static Chest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static Chest parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static Chest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static Chest parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static Chest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static Chest parseFrom(InputStream input) throws IOException {
                return (Chest) GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static Chest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Chest) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            public static Chest parseDelimitedFrom(InputStream input) throws IOException {
                return (Chest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
            }

            public static Chest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Chest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
            }

            public static Chest parseFrom(CodedInputStream input) throws IOException {
                return (Chest) GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static Chest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Chest) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(Chest prototype) {
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

            /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CreateGadgetInfoOuterClass$CreateGadgetInfo$Chest$Builder.class */
            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChestOrBuilder {
                private int chestDropId_;
                private boolean isShowCutscene_;

                public static final Descriptors.Descriptor getDescriptor() {
                    return CreateGadgetInfoOuterClass.internal_static_CreateGadgetInfo_Chest_descriptor;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return CreateGadgetInfoOuterClass.internal_static_CreateGadgetInfo_Chest_fieldAccessorTable.ensureFieldAccessorsInitialized(Chest.class, Builder.class);
                }

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent parent) {
                    super(parent);
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (Chest.alwaysUseFieldBuilders) {
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder clear() {
                    clear();
                    this.chestDropId_ = 0;
                    this.isShowCutscene_ = false;
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return CreateGadgetInfoOuterClass.internal_static_CreateGadgetInfo_Chest_descriptor;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public Chest getDefaultInstanceForType() {
                    return Chest.getDefaultInstance();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Chest build() {
                    Chest result = buildPartial();
                    if (result.isInitialized()) {
                        return result;
                    }
                    throw newUninitializedMessageException((Message) result);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Chest buildPartial() {
                    Chest result = new Chest(this);
                    result.chestDropId_ = this.chestDropId_;
                    result.isShowCutscene_ = this.isShowCutscene_;
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
                    if (other instanceof Chest) {
                        return mergeFrom((Chest) other);
                    }
                    mergeFrom(other);
                    return this;
                }

                public Builder mergeFrom(Chest other) {
                    if (other == Chest.getDefaultInstance()) {
                        return this;
                    }
                    if (other.getChestDropId() != 0) {
                        setChestDropId(other.getChestDropId());
                    }
                    if (other.getIsShowCutscene()) {
                        setIsShowCutscene(other.getIsShowCutscene());
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
                    Chest parsedMessage = null;
                    try {
                        try {
                            parsedMessage = Chest.PARSER.parsePartialFrom(input, extensionRegistry);
                            if (parsedMessage != null) {
                                mergeFrom(parsedMessage);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            parsedMessage = (Chest) e.getUnfinishedMessage();
                            throw e.unwrapIOException();
                        }
                    } catch (Throwable th) {
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        throw th;
                    }
                }

                @Override // emu.grasscutter.net.proto.CreateGadgetInfoOuterClass.CreateGadgetInfo.ChestOrBuilder
                public int getChestDropId() {
                    return this.chestDropId_;
                }

                public Builder setChestDropId(int value) {
                    this.chestDropId_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearChestDropId() {
                    this.chestDropId_ = 0;
                    onChanged();
                    return this;
                }

                @Override // emu.grasscutter.net.proto.CreateGadgetInfoOuterClass.CreateGadgetInfo.ChestOrBuilder
                public boolean getIsShowCutscene() {
                    return this.isShowCutscene_;
                }

                public Builder setIsShowCutscene(boolean value) {
                    this.isShowCutscene_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearIsShowCutscene() {
                    this.isShowCutscene_ = false;
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

            public static Chest getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Chest> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Parser<Chest> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Chest getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        @Override // emu.grasscutter.net.proto.CreateGadgetInfoOuterClass.CreateGadgetInfoOrBuilder
        public int getBornTypeValue() {
            return this.bornType_;
        }

        @Override // emu.grasscutter.net.proto.CreateGadgetInfoOuterClass.CreateGadgetInfoOrBuilder
        public GadgetBornTypeOuterClass.GadgetBornType getBornType() {
            GadgetBornTypeOuterClass.GadgetBornType result = GadgetBornTypeOuterClass.GadgetBornType.valueOf(this.bornType_);
            return result == null ? GadgetBornTypeOuterClass.GadgetBornType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.CreateGadgetInfoOuterClass.CreateGadgetInfoOrBuilder
        public boolean hasChest() {
            return this.chest_ != null;
        }

        @Override // emu.grasscutter.net.proto.CreateGadgetInfoOuterClass.CreateGadgetInfoOrBuilder
        public Chest getChest() {
            return this.chest_ == null ? Chest.getDefaultInstance() : this.chest_;
        }

        @Override // emu.grasscutter.net.proto.CreateGadgetInfoOuterClass.CreateGadgetInfoOrBuilder
        public ChestOrBuilder getChestOrBuilder() {
            return getChest();
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
            if (this.bornType_ != GadgetBornTypeOuterClass.GadgetBornType.GADGET_BORN_TYPE_NONE.getNumber()) {
                output.writeEnum(1, this.bornType_);
            }
            if (this.chest_ != null) {
                output.writeMessage(2, getChest());
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
            if (this.bornType_ != GadgetBornTypeOuterClass.GadgetBornType.GADGET_BORN_TYPE_NONE.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(1, this.bornType_);
            }
            if (this.chest_ != null) {
                size2 += CodedOutputStream.computeMessageSize(2, getChest());
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
            if (!(obj instanceof CreateGadgetInfo)) {
                return equals(obj);
            }
            CreateGadgetInfo other = (CreateGadgetInfo) obj;
            if (this.bornType_ == other.bornType_ && hasChest() == other.hasChest()) {
                return (!hasChest() || getChest().equals(other.getChest())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + this.bornType_;
            if (hasChest()) {
                hash = (53 * ((37 * hash) + 2)) + getChest().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static CreateGadgetInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CreateGadgetInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CreateGadgetInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CreateGadgetInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CreateGadgetInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CreateGadgetInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CreateGadgetInfo parseFrom(InputStream input) throws IOException {
            return (CreateGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CreateGadgetInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CreateGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CreateGadgetInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (CreateGadgetInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CreateGadgetInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CreateGadgetInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CreateGadgetInfo parseFrom(CodedInputStream input) throws IOException {
            return (CreateGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CreateGadgetInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CreateGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CreateGadgetInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CreateGadgetInfoOuterClass$CreateGadgetInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CreateGadgetInfoOrBuilder {
            private int bornType_ = 0;
            private Chest chest_;
            private SingleFieldBuilderV3<Chest, Chest.Builder, ChestOrBuilder> chestBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CreateGadgetInfoOuterClass.internal_static_CreateGadgetInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CreateGadgetInfoOuterClass.internal_static_CreateGadgetInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CreateGadgetInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CreateGadgetInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.bornType_ = 0;
                if (this.chestBuilder_ == null) {
                    this.chest_ = null;
                } else {
                    this.chest_ = null;
                    this.chestBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CreateGadgetInfoOuterClass.internal_static_CreateGadgetInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CreateGadgetInfo getDefaultInstanceForType() {
                return CreateGadgetInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CreateGadgetInfo build() {
                CreateGadgetInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CreateGadgetInfo buildPartial() {
                CreateGadgetInfo result = new CreateGadgetInfo(this);
                result.bornType_ = this.bornType_;
                if (this.chestBuilder_ == null) {
                    result.chest_ = this.chest_;
                } else {
                    result.chest_ = this.chestBuilder_.build();
                }
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
                if (other instanceof CreateGadgetInfo) {
                    return mergeFrom((CreateGadgetInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CreateGadgetInfo other) {
                if (other == CreateGadgetInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.bornType_ != 0) {
                    setBornTypeValue(other.getBornTypeValue());
                }
                if (other.hasChest()) {
                    mergeChest(other.getChest());
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
                CreateGadgetInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = CreateGadgetInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CreateGadgetInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CreateGadgetInfoOuterClass.CreateGadgetInfoOrBuilder
            public int getBornTypeValue() {
                return this.bornType_;
            }

            public Builder setBornTypeValue(int value) {
                this.bornType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CreateGadgetInfoOuterClass.CreateGadgetInfoOrBuilder
            public GadgetBornTypeOuterClass.GadgetBornType getBornType() {
                GadgetBornTypeOuterClass.GadgetBornType result = GadgetBornTypeOuterClass.GadgetBornType.valueOf(this.bornType_);
                return result == null ? GadgetBornTypeOuterClass.GadgetBornType.UNRECOGNIZED : result;
            }

            public Builder setBornType(GadgetBornTypeOuterClass.GadgetBornType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bornType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearBornType() {
                this.bornType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CreateGadgetInfoOuterClass.CreateGadgetInfoOrBuilder
            public boolean hasChest() {
                return (this.chestBuilder_ == null && this.chest_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.CreateGadgetInfoOuterClass.CreateGadgetInfoOrBuilder
            public Chest getChest() {
                if (this.chestBuilder_ == null) {
                    return this.chest_ == null ? Chest.getDefaultInstance() : this.chest_;
                }
                return this.chestBuilder_.getMessage();
            }

            public Builder setChest(Chest value) {
                if (this.chestBuilder_ != null) {
                    this.chestBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.chest_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setChest(Chest.Builder builderForValue) {
                if (this.chestBuilder_ == null) {
                    this.chest_ = builderForValue.build();
                    onChanged();
                } else {
                    this.chestBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeChest(Chest value) {
                if (this.chestBuilder_ == null) {
                    if (this.chest_ != null) {
                        this.chest_ = Chest.newBuilder(this.chest_).mergeFrom(value).buildPartial();
                    } else {
                        this.chest_ = value;
                    }
                    onChanged();
                } else {
                    this.chestBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearChest() {
                if (this.chestBuilder_ == null) {
                    this.chest_ = null;
                    onChanged();
                } else {
                    this.chest_ = null;
                    this.chestBuilder_ = null;
                }
                return this;
            }

            public Chest.Builder getChestBuilder() {
                onChanged();
                return getChestFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.CreateGadgetInfoOuterClass.CreateGadgetInfoOrBuilder
            public ChestOrBuilder getChestOrBuilder() {
                if (this.chestBuilder_ != null) {
                    return this.chestBuilder_.getMessageOrBuilder();
                }
                return this.chest_ == null ? Chest.getDefaultInstance() : this.chest_;
            }

            private SingleFieldBuilderV3<Chest, Chest.Builder, ChestOrBuilder> getChestFieldBuilder() {
                if (this.chestBuilder_ == null) {
                    this.chestBuilder_ = new SingleFieldBuilderV3<>(getChest(), getParentForChildren(), isClean());
                    this.chest_ = null;
                }
                return this.chestBuilder_;
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

        public static CreateGadgetInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CreateGadgetInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CreateGadgetInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CreateGadgetInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        GadgetBornTypeOuterClass.getDescriptor();
    }
}
