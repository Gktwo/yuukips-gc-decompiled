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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.ExhibitionDisplayInfoOuterClass;
import emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonSettleExhibitionInfoOuterClass.class */
public final class DungeonSettleExhibitionInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!DungeonSettleExhibitionInfo.proto\u001a\u0016OnlinePlayerInfo.proto\u001a\u001bExhibitionDisplayInfo.proto\"n\n\u001bDungeonSettleExhibitionInfo\u0012(\n\bcardList\u0018\u0002 \u0003(\u000b2\u0016.ExhibitionDisplayInfo\u0012%\n\nplayerInfo\u0018\r \u0001(\u000b2\u0011.OnlinePlayerInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{OnlinePlayerInfoOuterClass.getDescriptor(), ExhibitionDisplayInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_DungeonSettleExhibitionInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DungeonSettleExhibitionInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DungeonSettleExhibitionInfo_descriptor, new String[]{"CardList", "PlayerInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonSettleExhibitionInfoOuterClass$DungeonSettleExhibitionInfoOrBuilder.class */
    public interface DungeonSettleExhibitionInfoOrBuilder extends MessageOrBuilder {
        List<ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo> getCardListList();

        ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo getCardList(int i);

        int getCardListCount();

        List<? extends ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfoOrBuilder> getCardListOrBuilderList();

        ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfoOrBuilder getCardListOrBuilder(int i);

        boolean hasPlayerInfo();

        OnlinePlayerInfoOuterClass.OnlinePlayerInfo getPlayerInfo();

        OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder getPlayerInfoOrBuilder();
    }

    private DungeonSettleExhibitionInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonSettleExhibitionInfoOuterClass$DungeonSettleExhibitionInfo.class */
    public static final class DungeonSettleExhibitionInfo extends GeneratedMessageV3 implements DungeonSettleExhibitionInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CARDLIST_FIELD_NUMBER = 2;
        private List<ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo> cardList_;
        public static final int PLAYERINFO_FIELD_NUMBER = 13;
        private OnlinePlayerInfoOuterClass.OnlinePlayerInfo playerInfo_;
        private byte memoizedIsInitialized;
        private static final DungeonSettleExhibitionInfo DEFAULT_INSTANCE = new DungeonSettleExhibitionInfo();
        private static final Parser<DungeonSettleExhibitionInfo> PARSER = new AbstractParser<DungeonSettleExhibitionInfo>() { // from class: emu.grasscutter.net.proto.DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfo.1
            @Override // com.google.protobuf.Parser
            public DungeonSettleExhibitionInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DungeonSettleExhibitionInfo(input, extensionRegistry);
            }
        };

        private DungeonSettleExhibitionInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DungeonSettleExhibitionInfo() {
            this.memoizedIsInitialized = -1;
            this.cardList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DungeonSettleExhibitionInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DungeonSettleExhibitionInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 18:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.cardList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.cardList_.add((ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo) input.readMessage(ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo.parser(), extensionRegistry));
                                break;
                            case 106:
                                OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder subBuilder = this.playerInfo_ != null ? this.playerInfo_.toBuilder() : null;
                                this.playerInfo_ = (OnlinePlayerInfoOuterClass.OnlinePlayerInfo) input.readMessage(OnlinePlayerInfoOuterClass.OnlinePlayerInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.playerInfo_);
                                    this.playerInfo_ = subBuilder.buildPartial();
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
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.cardList_ = Collections.unmodifiableList(this.cardList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DungeonSettleExhibitionInfoOuterClass.internal_static_DungeonSettleExhibitionInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DungeonSettleExhibitionInfoOuterClass.internal_static_DungeonSettleExhibitionInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DungeonSettleExhibitionInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder
        public List<ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo> getCardListList() {
            return this.cardList_;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder
        public List<? extends ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfoOrBuilder> getCardListOrBuilderList() {
            return this.cardList_;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder
        public int getCardListCount() {
            return this.cardList_.size();
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder
        public ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo getCardList(int index) {
            return this.cardList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder
        public ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfoOrBuilder getCardListOrBuilder(int index) {
            return this.cardList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder
        public boolean hasPlayerInfo() {
            return this.playerInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder
        public OnlinePlayerInfoOuterClass.OnlinePlayerInfo getPlayerInfo() {
            return this.playerInfo_ == null ? OnlinePlayerInfoOuterClass.OnlinePlayerInfo.getDefaultInstance() : this.playerInfo_;
        }

        @Override // emu.grasscutter.net.proto.DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder
        public OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder getPlayerInfoOrBuilder() {
            return getPlayerInfo();
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
            for (int i = 0; i < this.cardList_.size(); i++) {
                output.writeMessage(2, this.cardList_.get(i));
            }
            if (this.playerInfo_ != null) {
                output.writeMessage(13, getPlayerInfo());
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
            for (int i = 0; i < this.cardList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.cardList_.get(i));
            }
            if (this.playerInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(13, getPlayerInfo());
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
            if (!(obj instanceof DungeonSettleExhibitionInfo)) {
                return equals(obj);
            }
            DungeonSettleExhibitionInfo other = (DungeonSettleExhibitionInfo) obj;
            if (getCardListList().equals(other.getCardListList()) && hasPlayerInfo() == other.hasPlayerInfo()) {
                return (!hasPlayerInfo() || getPlayerInfo().equals(other.getPlayerInfo())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getCardListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getCardListList().hashCode();
            }
            if (hasPlayerInfo()) {
                hash = (53 * ((37 * hash) + 13)) + getPlayerInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DungeonSettleExhibitionInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonSettleExhibitionInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonSettleExhibitionInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonSettleExhibitionInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonSettleExhibitionInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonSettleExhibitionInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonSettleExhibitionInfo parseFrom(InputStream input) throws IOException {
            return (DungeonSettleExhibitionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DungeonSettleExhibitionInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonSettleExhibitionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DungeonSettleExhibitionInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (DungeonSettleExhibitionInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DungeonSettleExhibitionInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonSettleExhibitionInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DungeonSettleExhibitionInfo parseFrom(CodedInputStream input) throws IOException {
            return (DungeonSettleExhibitionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DungeonSettleExhibitionInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonSettleExhibitionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DungeonSettleExhibitionInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonSettleExhibitionInfoOuterClass$DungeonSettleExhibitionInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DungeonSettleExhibitionInfoOrBuilder {
            private int bitField0_;
            private List<ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo> cardList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo, ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo.Builder, ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfoOrBuilder> cardListBuilder_;
            private OnlinePlayerInfoOuterClass.OnlinePlayerInfo playerInfo_;
            private SingleFieldBuilderV3<OnlinePlayerInfoOuterClass.OnlinePlayerInfo, OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder, OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder> playerInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DungeonSettleExhibitionInfoOuterClass.internal_static_DungeonSettleExhibitionInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DungeonSettleExhibitionInfoOuterClass.internal_static_DungeonSettleExhibitionInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DungeonSettleExhibitionInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DungeonSettleExhibitionInfo.alwaysUseFieldBuilders) {
                    getCardListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.cardListBuilder_ == null) {
                    this.cardList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.cardListBuilder_.clear();
                }
                if (this.playerInfoBuilder_ == null) {
                    this.playerInfo_ = null;
                } else {
                    this.playerInfo_ = null;
                    this.playerInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DungeonSettleExhibitionInfoOuterClass.internal_static_DungeonSettleExhibitionInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DungeonSettleExhibitionInfo getDefaultInstanceForType() {
                return DungeonSettleExhibitionInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DungeonSettleExhibitionInfo build() {
                DungeonSettleExhibitionInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DungeonSettleExhibitionInfo buildPartial() {
                DungeonSettleExhibitionInfo result = new DungeonSettleExhibitionInfo(this);
                int i = this.bitField0_;
                if (this.cardListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.cardList_ = Collections.unmodifiableList(this.cardList_);
                        this.bitField0_ &= -2;
                    }
                    result.cardList_ = this.cardList_;
                } else {
                    result.cardList_ = this.cardListBuilder_.build();
                }
                if (this.playerInfoBuilder_ == null) {
                    result.playerInfo_ = this.playerInfo_;
                } else {
                    result.playerInfo_ = this.playerInfoBuilder_.build();
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
                if (other instanceof DungeonSettleExhibitionInfo) {
                    return mergeFrom((DungeonSettleExhibitionInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DungeonSettleExhibitionInfo other) {
                if (other == DungeonSettleExhibitionInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.cardListBuilder_ == null) {
                    if (!other.cardList_.isEmpty()) {
                        if (this.cardList_.isEmpty()) {
                            this.cardList_ = other.cardList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureCardListIsMutable();
                            this.cardList_.addAll(other.cardList_);
                        }
                        onChanged();
                    }
                } else if (!other.cardList_.isEmpty()) {
                    if (this.cardListBuilder_.isEmpty()) {
                        this.cardListBuilder_.dispose();
                        this.cardListBuilder_ = null;
                        this.cardList_ = other.cardList_;
                        this.bitField0_ &= -2;
                        this.cardListBuilder_ = DungeonSettleExhibitionInfo.alwaysUseFieldBuilders ? getCardListFieldBuilder() : null;
                    } else {
                        this.cardListBuilder_.addAllMessages(other.cardList_);
                    }
                }
                if (other.hasPlayerInfo()) {
                    mergePlayerInfo(other.getPlayerInfo());
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
                DungeonSettleExhibitionInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = DungeonSettleExhibitionInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DungeonSettleExhibitionInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureCardListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.cardList_ = new ArrayList(this.cardList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder
            public List<ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo> getCardListList() {
                if (this.cardListBuilder_ == null) {
                    return Collections.unmodifiableList(this.cardList_);
                }
                return this.cardListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder
            public int getCardListCount() {
                if (this.cardListBuilder_ == null) {
                    return this.cardList_.size();
                }
                return this.cardListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder
            public ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo getCardList(int index) {
                if (this.cardListBuilder_ == null) {
                    return this.cardList_.get(index);
                }
                return this.cardListBuilder_.getMessage(index);
            }

            public Builder setCardList(int index, ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo value) {
                if (this.cardListBuilder_ != null) {
                    this.cardListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCardListIsMutable();
                    this.cardList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setCardList(int index, ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo.Builder builderForValue) {
                if (this.cardListBuilder_ == null) {
                    ensureCardListIsMutable();
                    this.cardList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.cardListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addCardList(ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo value) {
                if (this.cardListBuilder_ != null) {
                    this.cardListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCardListIsMutable();
                    this.cardList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addCardList(int index, ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo value) {
                if (this.cardListBuilder_ != null) {
                    this.cardListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCardListIsMutable();
                    this.cardList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addCardList(ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo.Builder builderForValue) {
                if (this.cardListBuilder_ == null) {
                    ensureCardListIsMutable();
                    this.cardList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.cardListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addCardList(int index, ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo.Builder builderForValue) {
                if (this.cardListBuilder_ == null) {
                    ensureCardListIsMutable();
                    this.cardList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.cardListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllCardList(Iterable<? extends ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo> values) {
                if (this.cardListBuilder_ == null) {
                    ensureCardListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.cardList_);
                    onChanged();
                } else {
                    this.cardListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearCardList() {
                if (this.cardListBuilder_ == null) {
                    this.cardList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.cardListBuilder_.clear();
                }
                return this;
            }

            public Builder removeCardList(int index) {
                if (this.cardListBuilder_ == null) {
                    ensureCardListIsMutable();
                    this.cardList_.remove(index);
                    onChanged();
                } else {
                    this.cardListBuilder_.remove(index);
                }
                return this;
            }

            public ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo.Builder getCardListBuilder(int index) {
                return getCardListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder
            public ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfoOrBuilder getCardListOrBuilder(int index) {
                if (this.cardListBuilder_ == null) {
                    return this.cardList_.get(index);
                }
                return this.cardListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder
            public List<? extends ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfoOrBuilder> getCardListOrBuilderList() {
                if (this.cardListBuilder_ != null) {
                    return this.cardListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.cardList_);
            }

            public ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo.Builder addCardListBuilder() {
                return getCardListFieldBuilder().addBuilder(ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo.getDefaultInstance());
            }

            public ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo.Builder addCardListBuilder(int index) {
                return getCardListFieldBuilder().addBuilder(index, ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo.getDefaultInstance());
            }

            public List<ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo.Builder> getCardListBuilderList() {
                return getCardListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo, ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfo.Builder, ExhibitionDisplayInfoOuterClass.ExhibitionDisplayInfoOrBuilder> getCardListFieldBuilder() {
                if (this.cardListBuilder_ == null) {
                    this.cardListBuilder_ = new RepeatedFieldBuilderV3<>(this.cardList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.cardList_ = null;
                }
                return this.cardListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder
            public boolean hasPlayerInfo() {
                return (this.playerInfoBuilder_ == null && this.playerInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder
            public OnlinePlayerInfoOuterClass.OnlinePlayerInfo getPlayerInfo() {
                if (this.playerInfoBuilder_ == null) {
                    return this.playerInfo_ == null ? OnlinePlayerInfoOuterClass.OnlinePlayerInfo.getDefaultInstance() : this.playerInfo_;
                }
                return this.playerInfoBuilder_.getMessage();
            }

            public Builder setPlayerInfo(OnlinePlayerInfoOuterClass.OnlinePlayerInfo value) {
                if (this.playerInfoBuilder_ != null) {
                    this.playerInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.playerInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPlayerInfo(OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder builderForValue) {
                if (this.playerInfoBuilder_ == null) {
                    this.playerInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.playerInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePlayerInfo(OnlinePlayerInfoOuterClass.OnlinePlayerInfo value) {
                if (this.playerInfoBuilder_ == null) {
                    if (this.playerInfo_ != null) {
                        this.playerInfo_ = OnlinePlayerInfoOuterClass.OnlinePlayerInfo.newBuilder(this.playerInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.playerInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.playerInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPlayerInfo() {
                if (this.playerInfoBuilder_ == null) {
                    this.playerInfo_ = null;
                    onChanged();
                } else {
                    this.playerInfo_ = null;
                    this.playerInfoBuilder_ = null;
                }
                return this;
            }

            public OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder getPlayerInfoBuilder() {
                onChanged();
                return getPlayerInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.DungeonSettleExhibitionInfoOuterClass.DungeonSettleExhibitionInfoOrBuilder
            public OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder getPlayerInfoOrBuilder() {
                if (this.playerInfoBuilder_ != null) {
                    return this.playerInfoBuilder_.getMessageOrBuilder();
                }
                return this.playerInfo_ == null ? OnlinePlayerInfoOuterClass.OnlinePlayerInfo.getDefaultInstance() : this.playerInfo_;
            }

            private SingleFieldBuilderV3<OnlinePlayerInfoOuterClass.OnlinePlayerInfo, OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder, OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder> getPlayerInfoFieldBuilder() {
                if (this.playerInfoBuilder_ == null) {
                    this.playerInfoBuilder_ = new SingleFieldBuilderV3<>(getPlayerInfo(), getParentForChildren(), isClean());
                    this.playerInfo_ = null;
                }
                return this.playerInfoBuilder_;
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

        public static DungeonSettleExhibitionInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DungeonSettleExhibitionInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DungeonSettleExhibitionInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DungeonSettleExhibitionInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        OnlinePlayerInfoOuterClass.getDescriptor();
        ExhibitionDisplayInfoOuterClass.getDescriptor();
    }
}
