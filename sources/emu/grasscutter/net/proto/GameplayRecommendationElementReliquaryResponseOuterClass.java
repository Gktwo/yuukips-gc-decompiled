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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GameplayRecommendationElementReliquaryResponseOuterClass.class */
public final class GameplayRecommendationElementReliquaryResponseOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n4GameplayRecommendationElementReliquaryResponse.proto\u001a1GameplayRecommendationReliquaryMainPropData.proto\"¥\u0001\n.GameplayRecommendationElementReliquaryResponse\u0012\u0014\n\felement_type\u0018\u0001 \u0001(\r\u0012\u0012\n\nequip_type\u0018\t \u0001(\r\u0012I\n\u0013main_prop_data_list\u0018\u0005 \u0003(\u000b2,.GameplayRecommendationReliquaryMainPropDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{GameplayRecommendationReliquaryMainPropDataOuterClass.getDescriptor()});

    /* renamed from: internal_static_GameplayRecommendationElementReliquaryResponse_descriptor */
    private static final Descriptors.Descriptor f735xb16bfc67 = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_GameplayRecommendationElementReliquaryResponse_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f736x3ea7cbe5 = new GeneratedMessageV3.FieldAccessorTable(f735xb16bfc67, new String[]{"ElementType", "EquipType", "MainPropDataList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GameplayRecommendationElementReliquaryResponseOuterClass$GameplayRecommendationElementReliquaryResponseOrBuilder.class */
    public interface GameplayRecommendationElementReliquaryResponseOrBuilder extends MessageOrBuilder {
        int getElementType();

        int getEquipType();

        List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> getMainPropDataListList();

        GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData getMainPropDataList(int i);

        int getMainPropDataListCount();

        List<? extends GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder> getMainPropDataListOrBuilderList();

        GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder getMainPropDataListOrBuilder(int i);
    }

    private GameplayRecommendationElementReliquaryResponseOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GameplayRecommendationElementReliquaryResponseOuterClass$GameplayRecommendationElementReliquaryResponse.class */
    public static final class GameplayRecommendationElementReliquaryResponse extends GeneratedMessageV3 implements GameplayRecommendationElementReliquaryResponseOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ELEMENT_TYPE_FIELD_NUMBER = 1;
        private int elementType_;
        public static final int EQUIP_TYPE_FIELD_NUMBER = 9;
        private int equipType_;
        public static final int MAIN_PROP_DATA_LIST_FIELD_NUMBER = 5;
        private List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> mainPropDataList_;
        private byte memoizedIsInitialized;
        private static final GameplayRecommendationElementReliquaryResponse DEFAULT_INSTANCE = new GameplayRecommendationElementReliquaryResponse();
        private static final Parser<GameplayRecommendationElementReliquaryResponse> PARSER = new AbstractParser<GameplayRecommendationElementReliquaryResponse>() { // from class: emu.grasscutter.net.proto.GameplayRecommendationElementReliquaryResponseOuterClass.GameplayRecommendationElementReliquaryResponse.1
            @Override // com.google.protobuf.Parser
            public GameplayRecommendationElementReliquaryResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GameplayRecommendationElementReliquaryResponse(input, extensionRegistry);
            }
        };

        private GameplayRecommendationElementReliquaryResponse(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GameplayRecommendationElementReliquaryResponse() {
            this.memoizedIsInitialized = -1;
            this.mainPropDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GameplayRecommendationElementReliquaryResponse();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GameplayRecommendationElementReliquaryResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.elementType_ = input.readUInt32();
                                break;
                            case 42:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.mainPropDataList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.mainPropDataList_.add((GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData) input.readMessage(GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.parser(), extensionRegistry));
                                break;
                            case 72:
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
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.mainPropDataList_ = Collections.unmodifiableList(this.mainPropDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GameplayRecommendationElementReliquaryResponseOuterClass.f735xb16bfc67;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GameplayRecommendationElementReliquaryResponseOuterClass.f736x3ea7cbe5.ensureFieldAccessorsInitialized(GameplayRecommendationElementReliquaryResponse.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GameplayRecommendationElementReliquaryResponseOuterClass.GameplayRecommendationElementReliquaryResponseOrBuilder
        public int getElementType() {
            return this.elementType_;
        }

        @Override // emu.grasscutter.net.proto.GameplayRecommendationElementReliquaryResponseOuterClass.GameplayRecommendationElementReliquaryResponseOrBuilder
        public int getEquipType() {
            return this.equipType_;
        }

        @Override // emu.grasscutter.net.proto.GameplayRecommendationElementReliquaryResponseOuterClass.GameplayRecommendationElementReliquaryResponseOrBuilder
        public List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> getMainPropDataListList() {
            return this.mainPropDataList_;
        }

        @Override // emu.grasscutter.net.proto.GameplayRecommendationElementReliquaryResponseOuterClass.GameplayRecommendationElementReliquaryResponseOrBuilder
        public List<? extends GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder> getMainPropDataListOrBuilderList() {
            return this.mainPropDataList_;
        }

        @Override // emu.grasscutter.net.proto.GameplayRecommendationElementReliquaryResponseOuterClass.GameplayRecommendationElementReliquaryResponseOrBuilder
        public int getMainPropDataListCount() {
            return this.mainPropDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.GameplayRecommendationElementReliquaryResponseOuterClass.GameplayRecommendationElementReliquaryResponseOrBuilder
        public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData getMainPropDataList(int index) {
            return this.mainPropDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GameplayRecommendationElementReliquaryResponseOuterClass.GameplayRecommendationElementReliquaryResponseOrBuilder
        public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder getMainPropDataListOrBuilder(int index) {
            return this.mainPropDataList_.get(index);
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
            if (this.elementType_ != 0) {
                output.writeUInt32(1, this.elementType_);
            }
            for (int i = 0; i < this.mainPropDataList_.size(); i++) {
                output.writeMessage(5, this.mainPropDataList_.get(i));
            }
            if (this.equipType_ != 0) {
                output.writeUInt32(9, this.equipType_);
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
            if (this.elementType_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.elementType_);
            }
            for (int i = 0; i < this.mainPropDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.mainPropDataList_.get(i));
            }
            if (this.equipType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.equipType_);
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
            if (!(obj instanceof GameplayRecommendationElementReliquaryResponse)) {
                return equals(obj);
            }
            GameplayRecommendationElementReliquaryResponse other = (GameplayRecommendationElementReliquaryResponse) obj;
            return getElementType() == other.getElementType() && getEquipType() == other.getEquipType() && getMainPropDataListList().equals(other.getMainPropDataListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getElementType())) + 9)) + getEquipType();
            if (getMainPropDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getMainPropDataListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GameplayRecommendationElementReliquaryResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GameplayRecommendationElementReliquaryResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GameplayRecommendationElementReliquaryResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GameplayRecommendationElementReliquaryResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GameplayRecommendationElementReliquaryResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GameplayRecommendationElementReliquaryResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GameplayRecommendationElementReliquaryResponse parseFrom(InputStream input) throws IOException {
            return (GameplayRecommendationElementReliquaryResponse) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GameplayRecommendationElementReliquaryResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GameplayRecommendationElementReliquaryResponse) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GameplayRecommendationElementReliquaryResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GameplayRecommendationElementReliquaryResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GameplayRecommendationElementReliquaryResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GameplayRecommendationElementReliquaryResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GameplayRecommendationElementReliquaryResponse parseFrom(CodedInputStream input) throws IOException {
            return (GameplayRecommendationElementReliquaryResponse) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GameplayRecommendationElementReliquaryResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GameplayRecommendationElementReliquaryResponse) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GameplayRecommendationElementReliquaryResponse prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GameplayRecommendationElementReliquaryResponseOuterClass$GameplayRecommendationElementReliquaryResponse$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GameplayRecommendationElementReliquaryResponseOrBuilder {
            private int bitField0_;
            private int elementType_;
            private int equipType_;
            private List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> mainPropDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder> mainPropDataListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GameplayRecommendationElementReliquaryResponseOuterClass.f735xb16bfc67;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GameplayRecommendationElementReliquaryResponseOuterClass.f736x3ea7cbe5.ensureFieldAccessorsInitialized(GameplayRecommendationElementReliquaryResponse.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GameplayRecommendationElementReliquaryResponse.alwaysUseFieldBuilders) {
                    getMainPropDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.elementType_ = 0;
                this.equipType_ = 0;
                if (this.mainPropDataListBuilder_ == null) {
                    this.mainPropDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.mainPropDataListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GameplayRecommendationElementReliquaryResponseOuterClass.f735xb16bfc67;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GameplayRecommendationElementReliquaryResponse getDefaultInstanceForType() {
                return GameplayRecommendationElementReliquaryResponse.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GameplayRecommendationElementReliquaryResponse build() {
                GameplayRecommendationElementReliquaryResponse result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GameplayRecommendationElementReliquaryResponse buildPartial() {
                GameplayRecommendationElementReliquaryResponse result = new GameplayRecommendationElementReliquaryResponse(this);
                int i = this.bitField0_;
                result.elementType_ = this.elementType_;
                result.equipType_ = this.equipType_;
                if (this.mainPropDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.mainPropDataList_ = Collections.unmodifiableList(this.mainPropDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.mainPropDataList_ = this.mainPropDataList_;
                } else {
                    result.mainPropDataList_ = this.mainPropDataListBuilder_.build();
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
                if (other instanceof GameplayRecommendationElementReliquaryResponse) {
                    return mergeFrom((GameplayRecommendationElementReliquaryResponse) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GameplayRecommendationElementReliquaryResponse other) {
                if (other == GameplayRecommendationElementReliquaryResponse.getDefaultInstance()) {
                    return this;
                }
                if (other.getElementType() != 0) {
                    setElementType(other.getElementType());
                }
                if (other.getEquipType() != 0) {
                    setEquipType(other.getEquipType());
                }
                if (this.mainPropDataListBuilder_ == null) {
                    if (!other.mainPropDataList_.isEmpty()) {
                        if (this.mainPropDataList_.isEmpty()) {
                            this.mainPropDataList_ = other.mainPropDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureMainPropDataListIsMutable();
                            this.mainPropDataList_.addAll(other.mainPropDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.mainPropDataList_.isEmpty()) {
                    if (this.mainPropDataListBuilder_.isEmpty()) {
                        this.mainPropDataListBuilder_.dispose();
                        this.mainPropDataListBuilder_ = null;
                        this.mainPropDataList_ = other.mainPropDataList_;
                        this.bitField0_ &= -2;
                        this.mainPropDataListBuilder_ = GameplayRecommendationElementReliquaryResponse.alwaysUseFieldBuilders ? getMainPropDataListFieldBuilder() : null;
                    } else {
                        this.mainPropDataListBuilder_.addAllMessages(other.mainPropDataList_);
                    }
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
                GameplayRecommendationElementReliquaryResponse parsedMessage = null;
                try {
                    try {
                        parsedMessage = GameplayRecommendationElementReliquaryResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GameplayRecommendationElementReliquaryResponse) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GameplayRecommendationElementReliquaryResponseOuterClass.GameplayRecommendationElementReliquaryResponseOrBuilder
            public int getElementType() {
                return this.elementType_;
            }

            public Builder setElementType(int value) {
                this.elementType_ = value;
                onChanged();
                return this;
            }

            public Builder clearElementType() {
                this.elementType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GameplayRecommendationElementReliquaryResponseOuterClass.GameplayRecommendationElementReliquaryResponseOrBuilder
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

            private void ensureMainPropDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.mainPropDataList_ = new ArrayList(this.mainPropDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GameplayRecommendationElementReliquaryResponseOuterClass.GameplayRecommendationElementReliquaryResponseOrBuilder
            public List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> getMainPropDataListList() {
                if (this.mainPropDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.mainPropDataList_);
                }
                return this.mainPropDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GameplayRecommendationElementReliquaryResponseOuterClass.GameplayRecommendationElementReliquaryResponseOrBuilder
            public int getMainPropDataListCount() {
                if (this.mainPropDataListBuilder_ == null) {
                    return this.mainPropDataList_.size();
                }
                return this.mainPropDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GameplayRecommendationElementReliquaryResponseOuterClass.GameplayRecommendationElementReliquaryResponseOrBuilder
            public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData getMainPropDataList(int index) {
                if (this.mainPropDataListBuilder_ == null) {
                    return this.mainPropDataList_.get(index);
                }
                return this.mainPropDataListBuilder_.getMessage(index);
            }

            public Builder setMainPropDataList(int index, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData value) {
                if (this.mainPropDataListBuilder_ != null) {
                    this.mainPropDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMainPropDataListIsMutable();
                    this.mainPropDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMainPropDataList(int index, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder builderForValue) {
                if (this.mainPropDataListBuilder_ == null) {
                    ensureMainPropDataListIsMutable();
                    this.mainPropDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.mainPropDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMainPropDataList(GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData value) {
                if (this.mainPropDataListBuilder_ != null) {
                    this.mainPropDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMainPropDataListIsMutable();
                    this.mainPropDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMainPropDataList(int index, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData value) {
                if (this.mainPropDataListBuilder_ != null) {
                    this.mainPropDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMainPropDataListIsMutable();
                    this.mainPropDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMainPropDataList(GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder builderForValue) {
                if (this.mainPropDataListBuilder_ == null) {
                    ensureMainPropDataListIsMutable();
                    this.mainPropDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.mainPropDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMainPropDataList(int index, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder builderForValue) {
                if (this.mainPropDataListBuilder_ == null) {
                    ensureMainPropDataListIsMutable();
                    this.mainPropDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.mainPropDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMainPropDataList(Iterable<? extends GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> values) {
                if (this.mainPropDataListBuilder_ == null) {
                    ensureMainPropDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.mainPropDataList_);
                    onChanged();
                } else {
                    this.mainPropDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMainPropDataList() {
                if (this.mainPropDataListBuilder_ == null) {
                    this.mainPropDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.mainPropDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeMainPropDataList(int index) {
                if (this.mainPropDataListBuilder_ == null) {
                    ensureMainPropDataListIsMutable();
                    this.mainPropDataList_.remove(index);
                    onChanged();
                } else {
                    this.mainPropDataListBuilder_.remove(index);
                }
                return this;
            }

            public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder getMainPropDataListBuilder(int index) {
                return getMainPropDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GameplayRecommendationElementReliquaryResponseOuterClass.GameplayRecommendationElementReliquaryResponseOrBuilder
            public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder getMainPropDataListOrBuilder(int index) {
                if (this.mainPropDataListBuilder_ == null) {
                    return this.mainPropDataList_.get(index);
                }
                return this.mainPropDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GameplayRecommendationElementReliquaryResponseOuterClass.GameplayRecommendationElementReliquaryResponseOrBuilder
            public List<? extends GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder> getMainPropDataListOrBuilderList() {
                if (this.mainPropDataListBuilder_ != null) {
                    return this.mainPropDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.mainPropDataList_);
            }

            public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder addMainPropDataListBuilder() {
                return getMainPropDataListFieldBuilder().addBuilder(GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.getDefaultInstance());
            }

            public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder addMainPropDataListBuilder(int index) {
                return getMainPropDataListFieldBuilder().addBuilder(index, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.getDefaultInstance());
            }

            public List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder> getMainPropDataListBuilderList() {
                return getMainPropDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder> getMainPropDataListFieldBuilder() {
                if (this.mainPropDataListBuilder_ == null) {
                    this.mainPropDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.mainPropDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.mainPropDataList_ = null;
                }
                return this.mainPropDataListBuilder_;
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

        public static GameplayRecommendationElementReliquaryResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GameplayRecommendationElementReliquaryResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GameplayRecommendationElementReliquaryResponse> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GameplayRecommendationElementReliquaryResponse getDefaultInstanceForType() {
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
