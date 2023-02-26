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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.GameplayRecommendationReliquaryMainPropDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GameplayRecommendationReliquaryResponseOuterClass.class */
public final class GameplayRecommendationReliquaryResponseOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n-GameplayRecommendationReliquaryResponse.proto\u001a1GameplayRecommendationReliquaryMainPropData.proto\"\n'GameplayRecommendationReliquaryResponse\u0012A\n\u000bnbbpegfkpac\u0018\f \u0003(\u000b2,.GameplayRecommendationReliquaryMainPropData\u0012\u0011\n\tequipType\u0018\u000f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{GameplayRecommendationReliquaryMainPropDataOuterClass.getDescriptor()});

    /* renamed from: internal_static_GameplayRecommendationReliquaryResponse_descriptor */
    private static final Descriptors.Descriptor f727x24103e67 = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_GameplayRecommendationReliquaryResponse_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f728x71ea0de5 = new GeneratedMessageV3.FieldAccessorTable(f727x24103e67, new String[]{"Nbbpegfkpac", "EquipType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GameplayRecommendationReliquaryResponseOuterClass$GameplayRecommendationReliquaryResponseOrBuilder.class */
    public interface GameplayRecommendationReliquaryResponseOrBuilder extends MessageOrBuilder {
        List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> getNbbpegfkpacList();

        GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData getNbbpegfkpac(int i);

        int getNbbpegfkpacCount();

        List<? extends GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder> getNbbpegfkpacOrBuilderList();

        GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder getNbbpegfkpacOrBuilder(int i);

        int getEquipType();
    }

    private GameplayRecommendationReliquaryResponseOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GameplayRecommendationReliquaryResponseOuterClass$GameplayRecommendationReliquaryResponse.class */
    public static final class GameplayRecommendationReliquaryResponse extends GeneratedMessageV3 implements GameplayRecommendationReliquaryResponseOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int NBBPEGFKPAC_FIELD_NUMBER = 12;
        private List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> nbbpegfkpac_;
        public static final int EQUIPTYPE_FIELD_NUMBER = 15;
        private int equipType_;
        private byte memoizedIsInitialized;
        private static final GameplayRecommendationReliquaryResponse DEFAULT_INSTANCE = new GameplayRecommendationReliquaryResponse();
        private static final Parser<GameplayRecommendationReliquaryResponse> PARSER = new AbstractParser<GameplayRecommendationReliquaryResponse>() { // from class: emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponse.1
            @Override // com.google.protobuf.Parser
            public GameplayRecommendationReliquaryResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GameplayRecommendationReliquaryResponse(input, extensionRegistry);
            }
        };

        private GameplayRecommendationReliquaryResponse(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GameplayRecommendationReliquaryResponse() {
            this.memoizedIsInitialized = -1;
            this.nbbpegfkpac_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GameplayRecommendationReliquaryResponse();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GameplayRecommendationReliquaryResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 98:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.nbbpegfkpac_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.nbbpegfkpac_.add((GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData) input.readMessage(GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.parser(), extensionRegistry));
                                    break;
                                case 120:
                                    this.equipType_ = input.readUInt32();
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
                    this.nbbpegfkpac_ = Collections.unmodifiableList(this.nbbpegfkpac_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GameplayRecommendationReliquaryResponseOuterClass.f727x24103e67;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GameplayRecommendationReliquaryResponseOuterClass.f728x71ea0de5.ensureFieldAccessorsInitialized(GameplayRecommendationReliquaryResponse.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
        public List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> getNbbpegfkpacList() {
            return this.nbbpegfkpac_;
        }

        @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
        public List<? extends GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder> getNbbpegfkpacOrBuilderList() {
            return this.nbbpegfkpac_;
        }

        @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
        public int getNbbpegfkpacCount() {
            return this.nbbpegfkpac_.size();
        }

        @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
        public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData getNbbpegfkpac(int index) {
            return this.nbbpegfkpac_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
        public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder getNbbpegfkpacOrBuilder(int index) {
            return this.nbbpegfkpac_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
        public int getEquipType() {
            return this.equipType_;
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
            for (int i = 0; i < this.nbbpegfkpac_.size(); i++) {
                output.writeMessage(12, this.nbbpegfkpac_.get(i));
            }
            if (this.equipType_ != 0) {
                output.writeUInt32(15, this.equipType_);
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
            for (int i = 0; i < this.nbbpegfkpac_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(12, this.nbbpegfkpac_.get(i));
            }
            if (this.equipType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.equipType_);
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
            if (!(obj instanceof GameplayRecommendationReliquaryResponse)) {
                return equals(obj);
            }
            GameplayRecommendationReliquaryResponse other = (GameplayRecommendationReliquaryResponse) obj;
            return getNbbpegfkpacList().equals(other.getNbbpegfkpacList()) && getEquipType() == other.getEquipType() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getNbbpegfkpacCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getNbbpegfkpacList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 15)) + getEquipType())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GameplayRecommendationReliquaryResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GameplayRecommendationReliquaryResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GameplayRecommendationReliquaryResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GameplayRecommendationReliquaryResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GameplayRecommendationReliquaryResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GameplayRecommendationReliquaryResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GameplayRecommendationReliquaryResponse parseFrom(InputStream input) throws IOException {
            return (GameplayRecommendationReliquaryResponse) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GameplayRecommendationReliquaryResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GameplayRecommendationReliquaryResponse) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GameplayRecommendationReliquaryResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GameplayRecommendationReliquaryResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GameplayRecommendationReliquaryResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GameplayRecommendationReliquaryResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GameplayRecommendationReliquaryResponse parseFrom(CodedInputStream input) throws IOException {
            return (GameplayRecommendationReliquaryResponse) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GameplayRecommendationReliquaryResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GameplayRecommendationReliquaryResponse) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GameplayRecommendationReliquaryResponse prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GameplayRecommendationReliquaryResponseOuterClass$GameplayRecommendationReliquaryResponse$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GameplayRecommendationReliquaryResponseOrBuilder {
            private int bitField0_;
            private List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> nbbpegfkpac_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder> nbbpegfkpacBuilder_;
            private int equipType_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GameplayRecommendationReliquaryResponseOuterClass.f727x24103e67;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GameplayRecommendationReliquaryResponseOuterClass.f728x71ea0de5.ensureFieldAccessorsInitialized(GameplayRecommendationReliquaryResponse.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GameplayRecommendationReliquaryResponse.alwaysUseFieldBuilders) {
                    getNbbpegfkpacFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.nbbpegfkpacBuilder_ == null) {
                    this.nbbpegfkpac_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.nbbpegfkpacBuilder_.clear();
                }
                this.equipType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GameplayRecommendationReliquaryResponseOuterClass.f727x24103e67;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GameplayRecommendationReliquaryResponse getDefaultInstanceForType() {
                return GameplayRecommendationReliquaryResponse.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GameplayRecommendationReliquaryResponse build() {
                GameplayRecommendationReliquaryResponse result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GameplayRecommendationReliquaryResponse buildPartial() {
                GameplayRecommendationReliquaryResponse result = new GameplayRecommendationReliquaryResponse(this);
                int i = this.bitField0_;
                if (this.nbbpegfkpacBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.nbbpegfkpac_ = Collections.unmodifiableList(this.nbbpegfkpac_);
                        this.bitField0_ &= -2;
                    }
                    result.nbbpegfkpac_ = this.nbbpegfkpac_;
                } else {
                    result.nbbpegfkpac_ = this.nbbpegfkpacBuilder_.build();
                }
                result.equipType_ = this.equipType_;
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
                if (other instanceof GameplayRecommendationReliquaryResponse) {
                    return mergeFrom((GameplayRecommendationReliquaryResponse) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GameplayRecommendationReliquaryResponse other) {
                if (other == GameplayRecommendationReliquaryResponse.getDefaultInstance()) {
                    return this;
                }
                if (this.nbbpegfkpacBuilder_ == null) {
                    if (!other.nbbpegfkpac_.isEmpty()) {
                        if (this.nbbpegfkpac_.isEmpty()) {
                            this.nbbpegfkpac_ = other.nbbpegfkpac_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureNbbpegfkpacIsMutable();
                            this.nbbpegfkpac_.addAll(other.nbbpegfkpac_);
                        }
                        onChanged();
                    }
                } else if (!other.nbbpegfkpac_.isEmpty()) {
                    if (this.nbbpegfkpacBuilder_.isEmpty()) {
                        this.nbbpegfkpacBuilder_.dispose();
                        this.nbbpegfkpacBuilder_ = null;
                        this.nbbpegfkpac_ = other.nbbpegfkpac_;
                        this.bitField0_ &= -2;
                        this.nbbpegfkpacBuilder_ = GameplayRecommendationReliquaryResponse.alwaysUseFieldBuilders ? getNbbpegfkpacFieldBuilder() : null;
                    } else {
                        this.nbbpegfkpacBuilder_.addAllMessages(other.nbbpegfkpac_);
                    }
                }
                if (other.getEquipType() != 0) {
                    setEquipType(other.getEquipType());
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
                GameplayRecommendationReliquaryResponse parsedMessage = null;
                try {
                    try {
                        parsedMessage = GameplayRecommendationReliquaryResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GameplayRecommendationReliquaryResponse) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureNbbpegfkpacIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.nbbpegfkpac_ = new ArrayList(this.nbbpegfkpac_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
            public List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> getNbbpegfkpacList() {
                if (this.nbbpegfkpacBuilder_ == null) {
                    return Collections.unmodifiableList(this.nbbpegfkpac_);
                }
                return this.nbbpegfkpacBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
            public int getNbbpegfkpacCount() {
                if (this.nbbpegfkpacBuilder_ == null) {
                    return this.nbbpegfkpac_.size();
                }
                return this.nbbpegfkpacBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
            public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData getNbbpegfkpac(int index) {
                if (this.nbbpegfkpacBuilder_ == null) {
                    return this.nbbpegfkpac_.get(index);
                }
                return this.nbbpegfkpacBuilder_.getMessage(index);
            }

            public Builder setNbbpegfkpac(int index, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData value) {
                if (this.nbbpegfkpacBuilder_ != null) {
                    this.nbbpegfkpacBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureNbbpegfkpacIsMutable();
                    this.nbbpegfkpac_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setNbbpegfkpac(int index, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder builderForValue) {
                if (this.nbbpegfkpacBuilder_ == null) {
                    ensureNbbpegfkpacIsMutable();
                    this.nbbpegfkpac_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.nbbpegfkpacBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addNbbpegfkpac(GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData value) {
                if (this.nbbpegfkpacBuilder_ != null) {
                    this.nbbpegfkpacBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureNbbpegfkpacIsMutable();
                    this.nbbpegfkpac_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addNbbpegfkpac(int index, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData value) {
                if (this.nbbpegfkpacBuilder_ != null) {
                    this.nbbpegfkpacBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureNbbpegfkpacIsMutable();
                    this.nbbpegfkpac_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addNbbpegfkpac(GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder builderForValue) {
                if (this.nbbpegfkpacBuilder_ == null) {
                    ensureNbbpegfkpacIsMutable();
                    this.nbbpegfkpac_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.nbbpegfkpacBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addNbbpegfkpac(int index, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder builderForValue) {
                if (this.nbbpegfkpacBuilder_ == null) {
                    ensureNbbpegfkpacIsMutable();
                    this.nbbpegfkpac_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.nbbpegfkpacBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllNbbpegfkpac(Iterable<? extends GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> values) {
                if (this.nbbpegfkpacBuilder_ == null) {
                    ensureNbbpegfkpacIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.nbbpegfkpac_);
                    onChanged();
                } else {
                    this.nbbpegfkpacBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearNbbpegfkpac() {
                if (this.nbbpegfkpacBuilder_ == null) {
                    this.nbbpegfkpac_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.nbbpegfkpacBuilder_.clear();
                }
                return this;
            }

            public Builder removeNbbpegfkpac(int index) {
                if (this.nbbpegfkpacBuilder_ == null) {
                    ensureNbbpegfkpacIsMutable();
                    this.nbbpegfkpac_.remove(index);
                    onChanged();
                } else {
                    this.nbbpegfkpacBuilder_.remove(index);
                }
                return this;
            }

            public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder getNbbpegfkpacBuilder(int index) {
                return getNbbpegfkpacFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
            public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder getNbbpegfkpacOrBuilder(int index) {
                if (this.nbbpegfkpacBuilder_ == null) {
                    return this.nbbpegfkpac_.get(index);
                }
                return this.nbbpegfkpacBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
            public List<? extends GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder> getNbbpegfkpacOrBuilderList() {
                if (this.nbbpegfkpacBuilder_ != null) {
                    return this.nbbpegfkpacBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.nbbpegfkpac_);
            }

            public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder addNbbpegfkpacBuilder() {
                return getNbbpegfkpacFieldBuilder().addBuilder(GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.getDefaultInstance());
            }

            public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder addNbbpegfkpacBuilder(int index) {
                return getNbbpegfkpacFieldBuilder().addBuilder(index, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.getDefaultInstance());
            }

            public List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder> getNbbpegfkpacBuilderList() {
                return getNbbpegfkpacFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder> getNbbpegfkpacFieldBuilder() {
                if (this.nbbpegfkpacBuilder_ == null) {
                    this.nbbpegfkpacBuilder_ = new RepeatedFieldBuilderV3<>(this.nbbpegfkpac_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.nbbpegfkpac_ = null;
                }
                return this.nbbpegfkpacBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
            public int getEquipType() {
                return this.equipType_;
            }

            public Builder setEquipType(int value) {
                this.equipType_ = value;
                onChanged();
                return this;
            }

            public Builder clearEquipType() {
                this.equipType_ = 0;
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

        public static GameplayRecommendationReliquaryResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GameplayRecommendationReliquaryResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GameplayRecommendationReliquaryResponse> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GameplayRecommendationReliquaryResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        GameplayRecommendationReliquaryMainPropDataOuterClass.getDescriptor();
    }
}
