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
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n-GameplayRecommendationReliquaryResponse.proto\u001a1GameplayRecommendationReliquaryMainPropData.proto\"\u0001\n'GameplayRecommendationReliquaryResponse\u0012\u0012\n\nequip_type\u0018\u000b \u0001(\r\u0012I\n\u0013main_prop_data_list\u0018\u0002 \u0003(\u000b2,.GameplayRecommendationReliquaryMainPropDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{GameplayRecommendationReliquaryMainPropDataOuterClass.getDescriptor()});

    /* renamed from: internal_static_GameplayRecommendationReliquaryResponse_descriptor */
    private static final Descriptors.Descriptor f741x24103e67 = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_GameplayRecommendationReliquaryResponse_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f742x71ea0de5 = new GeneratedMessageV3.FieldAccessorTable(f741x24103e67, new String[]{"EquipType", "MainPropDataList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GameplayRecommendationReliquaryResponseOuterClass$GameplayRecommendationReliquaryResponseOrBuilder.class */
    public interface GameplayRecommendationReliquaryResponseOrBuilder extends MessageOrBuilder {
        int getEquipType();

        List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> getMainPropDataListList();

        GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData getMainPropDataList(int i);

        int getMainPropDataListCount();

        List<? extends GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder> getMainPropDataListOrBuilderList();

        GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder getMainPropDataListOrBuilder(int i);
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
        public static final int EQUIP_TYPE_FIELD_NUMBER = 11;
        private int equipType_;
        public static final int MAIN_PROP_DATA_LIST_FIELD_NUMBER = 2;
        private List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> mainPropDataList_;
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
            this.mainPropDataList_ = Collections.emptyList();
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
                                case 18:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.mainPropDataList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.mainPropDataList_.add((GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData) input.readMessage(GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.parser(), extensionRegistry));
                                    break;
                                case 88:
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
                    this.mainPropDataList_ = Collections.unmodifiableList(this.mainPropDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GameplayRecommendationReliquaryResponseOuterClass.f741x24103e67;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GameplayRecommendationReliquaryResponseOuterClass.f742x71ea0de5.ensureFieldAccessorsInitialized(GameplayRecommendationReliquaryResponse.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
        public int getEquipType() {
            return this.equipType_;
        }

        @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
        public List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> getMainPropDataListList() {
            return this.mainPropDataList_;
        }

        @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
        public List<? extends GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder> getMainPropDataListOrBuilderList() {
            return this.mainPropDataList_;
        }

        @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
        public int getMainPropDataListCount() {
            return this.mainPropDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
        public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData getMainPropDataList(int index) {
            return this.mainPropDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
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
            for (int i = 0; i < this.mainPropDataList_.size(); i++) {
                output.writeMessage(2, this.mainPropDataList_.get(i));
            }
            if (this.equipType_ != 0) {
                output.writeUInt32(11, this.equipType_);
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
            for (int i = 0; i < this.mainPropDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.mainPropDataList_.get(i));
            }
            if (this.equipType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.equipType_);
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
            return getEquipType() == other.getEquipType() && getMainPropDataListList().equals(other.getMainPropDataListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getEquipType();
            if (getMainPropDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getMainPropDataListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
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
            private int equipType_;
            private List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> mainPropDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.Builder, GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder> mainPropDataListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GameplayRecommendationReliquaryResponseOuterClass.f741x24103e67;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GameplayRecommendationReliquaryResponseOuterClass.f742x71ea0de5.ensureFieldAccessorsInitialized(GameplayRecommendationReliquaryResponse.class, Builder.class);
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
                    getMainPropDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
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
                return GameplayRecommendationReliquaryResponseOuterClass.f741x24103e67;
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
                        this.mainPropDataListBuilder_ = GameplayRecommendationReliquaryResponse.alwaysUseFieldBuilders ? getMainPropDataListFieldBuilder() : null;
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

            private void ensureMainPropDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.mainPropDataList_ = new ArrayList(this.mainPropDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
            public List<GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData> getMainPropDataListList() {
                if (this.mainPropDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.mainPropDataList_);
                }
                return this.mainPropDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
            public int getMainPropDataListCount() {
                if (this.mainPropDataListBuilder_ == null) {
                    return this.mainPropDataList_.size();
                }
                return this.mainPropDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
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

            @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
            public GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder getMainPropDataListOrBuilder(int index) {
                if (this.mainPropDataListBuilder_ == null) {
                    return this.mainPropDataList_.get(index);
                }
                return this.mainPropDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryResponseOuterClass.GameplayRecommendationReliquaryResponseOrBuilder
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
