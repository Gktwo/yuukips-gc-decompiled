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
import emu.grasscutter.net.proto.WidgetSlotDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerWidgetInfoOuterClass.class */
public final class PlayerWidgetInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016PlayerWidgetInfo.proto\u001a\u0014WidgetSlotData.proto\"C\n\u0010PlayerWidgetInfo\u0012\u000b\n\u0003uid\u0018\u0006 \u0001(\r\u0012\"\n\tslot_list\u0018\u0004 \u0003(\u000b2\u000f.WidgetSlotDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{WidgetSlotDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlayerWidgetInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerWidgetInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerWidgetInfo_descriptor, new String[]{"Uid", "SlotList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerWidgetInfoOuterClass$PlayerWidgetInfoOrBuilder.class */
    public interface PlayerWidgetInfoOrBuilder extends MessageOrBuilder {
        int getUid();

        List<WidgetSlotDataOuterClass.WidgetSlotData> getSlotListList();

        WidgetSlotDataOuterClass.WidgetSlotData getSlotList(int i);

        int getSlotListCount();

        List<? extends WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder> getSlotListOrBuilderList();

        WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder getSlotListOrBuilder(int i);
    }

    private PlayerWidgetInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerWidgetInfoOuterClass$PlayerWidgetInfo.class */
    public static final class PlayerWidgetInfo extends GeneratedMessageV3 implements PlayerWidgetInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UID_FIELD_NUMBER = 6;
        private int uid_;
        public static final int SLOT_LIST_FIELD_NUMBER = 4;
        private List<WidgetSlotDataOuterClass.WidgetSlotData> slotList_;
        private byte memoizedIsInitialized;
        private static final PlayerWidgetInfo DEFAULT_INSTANCE = new PlayerWidgetInfo();
        private static final Parser<PlayerWidgetInfo> PARSER = new AbstractParser<PlayerWidgetInfo>() { // from class: emu.grasscutter.net.proto.PlayerWidgetInfoOuterClass.PlayerWidgetInfo.1
            @Override // com.google.protobuf.Parser
            public PlayerWidgetInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerWidgetInfo(input, extensionRegistry);
            }
        };

        private PlayerWidgetInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerWidgetInfo() {
            this.memoizedIsInitialized = -1;
            this.slotList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerWidgetInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerWidgetInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 34:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.slotList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.slotList_.add((WidgetSlotDataOuterClass.WidgetSlotData) input.readMessage(WidgetSlotDataOuterClass.WidgetSlotData.parser(), extensionRegistry));
                                    break;
                                case 48:
                                    this.uid_ = input.readUInt32();
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
                    this.slotList_ = Collections.unmodifiableList(this.slotList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PlayerWidgetInfoOuterClass.internal_static_PlayerWidgetInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerWidgetInfoOuterClass.internal_static_PlayerWidgetInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerWidgetInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerWidgetInfoOuterClass.PlayerWidgetInfoOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // emu.grasscutter.net.proto.PlayerWidgetInfoOuterClass.PlayerWidgetInfoOrBuilder
        public List<WidgetSlotDataOuterClass.WidgetSlotData> getSlotListList() {
            return this.slotList_;
        }

        @Override // emu.grasscutter.net.proto.PlayerWidgetInfoOuterClass.PlayerWidgetInfoOrBuilder
        public List<? extends WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder> getSlotListOrBuilderList() {
            return this.slotList_;
        }

        @Override // emu.grasscutter.net.proto.PlayerWidgetInfoOuterClass.PlayerWidgetInfoOrBuilder
        public int getSlotListCount() {
            return this.slotList_.size();
        }

        @Override // emu.grasscutter.net.proto.PlayerWidgetInfoOuterClass.PlayerWidgetInfoOrBuilder
        public WidgetSlotDataOuterClass.WidgetSlotData getSlotList(int index) {
            return this.slotList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerWidgetInfoOuterClass.PlayerWidgetInfoOrBuilder
        public WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder getSlotListOrBuilder(int index) {
            return this.slotList_.get(index);
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
            for (int i = 0; i < this.slotList_.size(); i++) {
                output.writeMessage(4, this.slotList_.get(i));
            }
            if (this.uid_ != 0) {
                output.writeUInt32(6, this.uid_);
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
            for (int i = 0; i < this.slotList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.slotList_.get(i));
            }
            if (this.uid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.uid_);
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
            if (!(obj instanceof PlayerWidgetInfo)) {
                return equals(obj);
            }
            PlayerWidgetInfo other = (PlayerWidgetInfo) obj;
            return getUid() == other.getUid() && getSlotListList().equals(other.getSlotListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getUid();
            if (getSlotListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getSlotListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PlayerWidgetInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerWidgetInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerWidgetInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerWidgetInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerWidgetInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerWidgetInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerWidgetInfo parseFrom(InputStream input) throws IOException {
            return (PlayerWidgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerWidgetInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerWidgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerWidgetInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerWidgetInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerWidgetInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerWidgetInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerWidgetInfo parseFrom(CodedInputStream input) throws IOException {
            return (PlayerWidgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerWidgetInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerWidgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerWidgetInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerWidgetInfoOuterClass$PlayerWidgetInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerWidgetInfoOrBuilder {
            private int bitField0_;
            private int uid_;
            private List<WidgetSlotDataOuterClass.WidgetSlotData> slotList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<WidgetSlotDataOuterClass.WidgetSlotData, WidgetSlotDataOuterClass.WidgetSlotData.Builder, WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder> slotListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerWidgetInfoOuterClass.internal_static_PlayerWidgetInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerWidgetInfoOuterClass.internal_static_PlayerWidgetInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerWidgetInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerWidgetInfo.alwaysUseFieldBuilders) {
                    getSlotListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.uid_ = 0;
                if (this.slotListBuilder_ == null) {
                    this.slotList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.slotListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerWidgetInfoOuterClass.internal_static_PlayerWidgetInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerWidgetInfo getDefaultInstanceForType() {
                return PlayerWidgetInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerWidgetInfo build() {
                PlayerWidgetInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerWidgetInfo buildPartial() {
                PlayerWidgetInfo result = new PlayerWidgetInfo(this);
                int i = this.bitField0_;
                result.uid_ = this.uid_;
                if (this.slotListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.slotList_ = Collections.unmodifiableList(this.slotList_);
                        this.bitField0_ &= -2;
                    }
                    result.slotList_ = this.slotList_;
                } else {
                    result.slotList_ = this.slotListBuilder_.build();
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
                if (other instanceof PlayerWidgetInfo) {
                    return mergeFrom((PlayerWidgetInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerWidgetInfo other) {
                if (other == PlayerWidgetInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
                }
                if (this.slotListBuilder_ == null) {
                    if (!other.slotList_.isEmpty()) {
                        if (this.slotList_.isEmpty()) {
                            this.slotList_ = other.slotList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureSlotListIsMutable();
                            this.slotList_.addAll(other.slotList_);
                        }
                        onChanged();
                    }
                } else if (!other.slotList_.isEmpty()) {
                    if (this.slotListBuilder_.isEmpty()) {
                        this.slotListBuilder_.dispose();
                        this.slotListBuilder_ = null;
                        this.slotList_ = other.slotList_;
                        this.bitField0_ &= -2;
                        this.slotListBuilder_ = PlayerWidgetInfo.alwaysUseFieldBuilders ? getSlotListFieldBuilder() : null;
                    } else {
                        this.slotListBuilder_.addAllMessages(other.slotList_);
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
                PlayerWidgetInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerWidgetInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerWidgetInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerWidgetInfoOuterClass.PlayerWidgetInfoOrBuilder
            public int getUid() {
                return this.uid_;
            }

            public Builder setUid(int value) {
                this.uid_ = value;
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.uid_ = 0;
                onChanged();
                return this;
            }

            private void ensureSlotListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.slotList_ = new ArrayList(this.slotList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerWidgetInfoOuterClass.PlayerWidgetInfoOrBuilder
            public List<WidgetSlotDataOuterClass.WidgetSlotData> getSlotListList() {
                if (this.slotListBuilder_ == null) {
                    return Collections.unmodifiableList(this.slotList_);
                }
                return this.slotListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.PlayerWidgetInfoOuterClass.PlayerWidgetInfoOrBuilder
            public int getSlotListCount() {
                if (this.slotListBuilder_ == null) {
                    return this.slotList_.size();
                }
                return this.slotListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.PlayerWidgetInfoOuterClass.PlayerWidgetInfoOrBuilder
            public WidgetSlotDataOuterClass.WidgetSlotData getSlotList(int index) {
                if (this.slotListBuilder_ == null) {
                    return this.slotList_.get(index);
                }
                return this.slotListBuilder_.getMessage(index);
            }

            public Builder setSlotList(int index, WidgetSlotDataOuterClass.WidgetSlotData value) {
                if (this.slotListBuilder_ != null) {
                    this.slotListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSlotListIsMutable();
                    this.slotList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setSlotList(int index, WidgetSlotDataOuterClass.WidgetSlotData.Builder builderForValue) {
                if (this.slotListBuilder_ == null) {
                    ensureSlotListIsMutable();
                    this.slotList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.slotListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addSlotList(WidgetSlotDataOuterClass.WidgetSlotData value) {
                if (this.slotListBuilder_ != null) {
                    this.slotListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSlotListIsMutable();
                    this.slotList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addSlotList(int index, WidgetSlotDataOuterClass.WidgetSlotData value) {
                if (this.slotListBuilder_ != null) {
                    this.slotListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSlotListIsMutable();
                    this.slotList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addSlotList(WidgetSlotDataOuterClass.WidgetSlotData.Builder builderForValue) {
                if (this.slotListBuilder_ == null) {
                    ensureSlotListIsMutable();
                    this.slotList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.slotListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addSlotList(int index, WidgetSlotDataOuterClass.WidgetSlotData.Builder builderForValue) {
                if (this.slotListBuilder_ == null) {
                    ensureSlotListIsMutable();
                    this.slotList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.slotListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllSlotList(Iterable<? extends WidgetSlotDataOuterClass.WidgetSlotData> values) {
                if (this.slotListBuilder_ == null) {
                    ensureSlotListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.slotList_);
                    onChanged();
                } else {
                    this.slotListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearSlotList() {
                if (this.slotListBuilder_ == null) {
                    this.slotList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.slotListBuilder_.clear();
                }
                return this;
            }

            public Builder removeSlotList(int index) {
                if (this.slotListBuilder_ == null) {
                    ensureSlotListIsMutable();
                    this.slotList_.remove(index);
                    onChanged();
                } else {
                    this.slotListBuilder_.remove(index);
                }
                return this;
            }

            public WidgetSlotDataOuterClass.WidgetSlotData.Builder getSlotListBuilder(int index) {
                return getSlotListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PlayerWidgetInfoOuterClass.PlayerWidgetInfoOrBuilder
            public WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder getSlotListOrBuilder(int index) {
                if (this.slotListBuilder_ == null) {
                    return this.slotList_.get(index);
                }
                return this.slotListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PlayerWidgetInfoOuterClass.PlayerWidgetInfoOrBuilder
            public List<? extends WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder> getSlotListOrBuilderList() {
                if (this.slotListBuilder_ != null) {
                    return this.slotListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.slotList_);
            }

            public WidgetSlotDataOuterClass.WidgetSlotData.Builder addSlotListBuilder() {
                return getSlotListFieldBuilder().addBuilder(WidgetSlotDataOuterClass.WidgetSlotData.getDefaultInstance());
            }

            public WidgetSlotDataOuterClass.WidgetSlotData.Builder addSlotListBuilder(int index) {
                return getSlotListFieldBuilder().addBuilder(index, WidgetSlotDataOuterClass.WidgetSlotData.getDefaultInstance());
            }

            public List<WidgetSlotDataOuterClass.WidgetSlotData.Builder> getSlotListBuilderList() {
                return getSlotListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<WidgetSlotDataOuterClass.WidgetSlotData, WidgetSlotDataOuterClass.WidgetSlotData.Builder, WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder> getSlotListFieldBuilder() {
                if (this.slotListBuilder_ == null) {
                    this.slotListBuilder_ = new RepeatedFieldBuilderV3<>(this.slotList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.slotList_ = null;
                }
                return this.slotListBuilder_;
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

        public static PlayerWidgetInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerWidgetInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerWidgetInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerWidgetInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        WidgetSlotDataOuterClass.getDescriptor();
    }
}