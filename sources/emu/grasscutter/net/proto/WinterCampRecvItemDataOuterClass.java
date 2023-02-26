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
import emu.grasscutter.net.proto.ItemParamOuterClass;
import emu.grasscutter.net.proto.ProfilePictureOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampRecvItemDataOuterClass.class */
public final class WinterCampRecvItemDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cWinterCampRecvItemData.proto\u001a\u0014ProfilePicture.proto\u001a\u000fItemParam.proto\"~\n\u0016WinterCampRecvItemData\u0012\u001c\n\bitemList\u0018\t \u0003(\u000b2\n.ItemParam\u0012'\n\u000eprofilePicture\u0018\u0002 \u0001(\u000b2\u000f.ProfilePicture\u0012\u0010\n\bnickname\u0018\b \u0001(\t\u0012\u000b\n\u0003uid\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ProfilePictureOuterClass.getDescriptor(), ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WinterCampRecvItemData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WinterCampRecvItemData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WinterCampRecvItemData_descriptor, new String[]{"ItemList", "ProfilePicture", "Nickname", "Uid"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampRecvItemDataOuterClass$WinterCampRecvItemDataOrBuilder.class */
    public interface WinterCampRecvItemDataOrBuilder extends MessageOrBuilder {
        List<ItemParamOuterClass.ItemParam> getItemListList();

        ItemParamOuterClass.ItemParam getItemList(int i);

        int getItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getItemListOrBuilder(int i);

        boolean hasProfilePicture();

        ProfilePictureOuterClass.ProfilePicture getProfilePicture();

        ProfilePictureOuterClass.ProfilePictureOrBuilder getProfilePictureOrBuilder();

        String getNickname();

        ByteString getNicknameBytes();

        int getUid();
    }

    private WinterCampRecvItemDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampRecvItemDataOuterClass$WinterCampRecvItemData.class */
    public static final class WinterCampRecvItemData extends GeneratedMessageV3 implements WinterCampRecvItemDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ITEMLIST_FIELD_NUMBER = 9;
        private List<ItemParamOuterClass.ItemParam> itemList_;
        public static final int PROFILEPICTURE_FIELD_NUMBER = 2;
        private ProfilePictureOuterClass.ProfilePicture profilePicture_;
        public static final int NICKNAME_FIELD_NUMBER = 8;
        private volatile Object nickname_;
        public static final int UID_FIELD_NUMBER = 3;
        private int uid_;
        private byte memoizedIsInitialized;
        private static final WinterCampRecvItemData DEFAULT_INSTANCE = new WinterCampRecvItemData();
        private static final Parser<WinterCampRecvItemData> PARSER = new AbstractParser<WinterCampRecvItemData>() { // from class: emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.1
            @Override // com.google.protobuf.Parser
            public WinterCampRecvItemData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WinterCampRecvItemData(input, extensionRegistry);
            }
        };

        private WinterCampRecvItemData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WinterCampRecvItemData() {
            this.memoizedIsInitialized = -1;
            this.itemList_ = Collections.emptyList();
            this.nickname_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WinterCampRecvItemData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WinterCampRecvItemData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                ProfilePictureOuterClass.ProfilePicture.Builder subBuilder = this.profilePicture_ != null ? this.profilePicture_.toBuilder() : null;
                                this.profilePicture_ = (ProfilePictureOuterClass.ProfilePicture) input.readMessage(ProfilePictureOuterClass.ProfilePicture.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.profilePicture_);
                                    this.profilePicture_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 24:
                                this.uid_ = input.readUInt32();
                                break;
                            case 66:
                                this.nickname_ = input.readStringRequireUtf8();
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.itemList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.itemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
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
                    this.itemList_ = Collections.unmodifiableList(this.itemList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WinterCampRecvItemDataOuterClass.internal_static_WinterCampRecvItemData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WinterCampRecvItemDataOuterClass.internal_static_WinterCampRecvItemData_fieldAccessorTable.ensureFieldAccessorsInitialized(WinterCampRecvItemData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder
        public List<ItemParamOuterClass.ItemParam> getItemListList() {
            return this.itemList_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemListOrBuilderList() {
            return this.itemList_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder
        public int getItemListCount() {
            return this.itemList_.size();
        }

        @Override // emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder
        public ItemParamOuterClass.ItemParam getItemList(int index) {
            return this.itemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getItemListOrBuilder(int index) {
            return this.itemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder
        public boolean hasProfilePicture() {
            return this.profilePicture_ != null;
        }

        @Override // emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder
        public ProfilePictureOuterClass.ProfilePicture getProfilePicture() {
            return this.profilePicture_ == null ? ProfilePictureOuterClass.ProfilePicture.getDefaultInstance() : this.profilePicture_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder
        public ProfilePictureOuterClass.ProfilePictureOrBuilder getProfilePictureOrBuilder() {
            return getProfilePicture();
        }

        @Override // emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder
        public String getNickname() {
            Object ref = this.nickname_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.nickname_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder
        public ByteString getNicknameBytes() {
            Object ref = this.nickname_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.nickname_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder
        public int getUid() {
            return this.uid_;
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
            if (this.profilePicture_ != null) {
                output.writeMessage(2, getProfilePicture());
            }
            if (this.uid_ != 0) {
                output.writeUInt32(3, this.uid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.nickname_)) {
                GeneratedMessageV3.writeString(output, 8, this.nickname_);
            }
            for (int i = 0; i < this.itemList_.size(); i++) {
                output.writeMessage(9, this.itemList_.get(i));
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
            if (this.profilePicture_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(2, getProfilePicture());
            }
            if (this.uid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.uid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.nickname_)) {
                size2 += GeneratedMessageV3.computeStringSize(8, this.nickname_);
            }
            for (int i = 0; i < this.itemList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(9, this.itemList_.get(i));
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
            if (!(obj instanceof WinterCampRecvItemData)) {
                return equals(obj);
            }
            WinterCampRecvItemData other = (WinterCampRecvItemData) obj;
            if (getItemListList().equals(other.getItemListList()) && hasProfilePicture() == other.hasProfilePicture()) {
                return (!hasProfilePicture() || getProfilePicture().equals(other.getProfilePicture())) && getNickname().equals(other.getNickname()) && getUid() == other.getUid() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getItemListList().hashCode();
            }
            if (hasProfilePicture()) {
                hash = (53 * ((37 * hash) + 2)) + getProfilePicture().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 8)) + getNickname().hashCode())) + 3)) + getUid())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WinterCampRecvItemData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampRecvItemData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampRecvItemData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampRecvItemData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampRecvItemData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampRecvItemData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampRecvItemData parseFrom(InputStream input) throws IOException {
            return (WinterCampRecvItemData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WinterCampRecvItemData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampRecvItemData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WinterCampRecvItemData parseDelimitedFrom(InputStream input) throws IOException {
            return (WinterCampRecvItemData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WinterCampRecvItemData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampRecvItemData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WinterCampRecvItemData parseFrom(CodedInputStream input) throws IOException {
            return (WinterCampRecvItemData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WinterCampRecvItemData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampRecvItemData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WinterCampRecvItemData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampRecvItemDataOuterClass$WinterCampRecvItemData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WinterCampRecvItemDataOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> itemListBuilder_;
            private ProfilePictureOuterClass.ProfilePicture profilePicture_;
            private SingleFieldBuilderV3<ProfilePictureOuterClass.ProfilePicture, ProfilePictureOuterClass.ProfilePicture.Builder, ProfilePictureOuterClass.ProfilePictureOrBuilder> profilePictureBuilder_;
            private int uid_;
            private List<ItemParamOuterClass.ItemParam> itemList_ = Collections.emptyList();
            private Object nickname_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return WinterCampRecvItemDataOuterClass.internal_static_WinterCampRecvItemData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WinterCampRecvItemDataOuterClass.internal_static_WinterCampRecvItemData_fieldAccessorTable.ensureFieldAccessorsInitialized(WinterCampRecvItemData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WinterCampRecvItemData.alwaysUseFieldBuilders) {
                    getItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.itemListBuilder_.clear();
                }
                if (this.profilePictureBuilder_ == null) {
                    this.profilePicture_ = null;
                } else {
                    this.profilePicture_ = null;
                    this.profilePictureBuilder_ = null;
                }
                this.nickname_ = "";
                this.uid_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WinterCampRecvItemDataOuterClass.internal_static_WinterCampRecvItemData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WinterCampRecvItemData getDefaultInstanceForType() {
                return WinterCampRecvItemData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WinterCampRecvItemData build() {
                WinterCampRecvItemData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WinterCampRecvItemData buildPartial() {
                WinterCampRecvItemData result = new WinterCampRecvItemData(this);
                int i = this.bitField0_;
                if (this.itemListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.itemList_ = Collections.unmodifiableList(this.itemList_);
                        this.bitField0_ &= -2;
                    }
                    result.itemList_ = this.itemList_;
                } else {
                    result.itemList_ = this.itemListBuilder_.build();
                }
                if (this.profilePictureBuilder_ == null) {
                    result.profilePicture_ = this.profilePicture_;
                } else {
                    result.profilePicture_ = this.profilePictureBuilder_.build();
                }
                result.nickname_ = this.nickname_;
                result.uid_ = this.uid_;
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
                if (other instanceof WinterCampRecvItemData) {
                    return mergeFrom((WinterCampRecvItemData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WinterCampRecvItemData other) {
                if (other == WinterCampRecvItemData.getDefaultInstance()) {
                    return this;
                }
                if (this.itemListBuilder_ == null) {
                    if (!other.itemList_.isEmpty()) {
                        if (this.itemList_.isEmpty()) {
                            this.itemList_ = other.itemList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureItemListIsMutable();
                            this.itemList_.addAll(other.itemList_);
                        }
                        onChanged();
                    }
                } else if (!other.itemList_.isEmpty()) {
                    if (this.itemListBuilder_.isEmpty()) {
                        this.itemListBuilder_.dispose();
                        this.itemListBuilder_ = null;
                        this.itemList_ = other.itemList_;
                        this.bitField0_ &= -2;
                        this.itemListBuilder_ = WinterCampRecvItemData.alwaysUseFieldBuilders ? getItemListFieldBuilder() : null;
                    } else {
                        this.itemListBuilder_.addAllMessages(other.itemList_);
                    }
                }
                if (other.hasProfilePicture()) {
                    mergeProfilePicture(other.getProfilePicture());
                }
                if (!other.getNickname().isEmpty()) {
                    this.nickname_ = other.nickname_;
                    onChanged();
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
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
                WinterCampRecvItemData parsedMessage = null;
                try {
                    try {
                        parsedMessage = WinterCampRecvItemData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WinterCampRecvItemData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureItemListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.itemList_ = new ArrayList(this.itemList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder
            public List<ItemParamOuterClass.ItemParam> getItemListList() {
                if (this.itemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.itemList_);
                }
                return this.itemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder
            public int getItemListCount() {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.size();
                }
                return this.itemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder
            public ItemParamOuterClass.ItemParam getItemList(int index) {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.get(index);
                }
                return this.itemListBuilder_.getMessage(index);
            }

            public Builder setItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.itemListBuilder_ != null) {
                    this.itemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemListIsMutable();
                    this.itemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addItemList(ItemParamOuterClass.ItemParam value) {
                if (this.itemListBuilder_ != null) {
                    this.itemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemListIsMutable();
                    this.itemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.itemListBuilder_ != null) {
                    this.itemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemListIsMutable();
                    this.itemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.itemList_);
                    onChanged();
                } else {
                    this.itemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearItemList() {
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.itemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeItemList(int index) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.remove(index);
                    onChanged();
                } else {
                    this.itemListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getItemListBuilder(int index) {
                return getItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getItemListOrBuilder(int index) {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.get(index);
                }
                return this.itemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemListOrBuilderList() {
                if (this.itemListBuilder_ != null) {
                    return this.itemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.itemList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addItemListBuilder() {
                return getItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addItemListBuilder(int index) {
                return getItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getItemListBuilderList() {
                return getItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getItemListFieldBuilder() {
                if (this.itemListBuilder_ == null) {
                    this.itemListBuilder_ = new RepeatedFieldBuilderV3<>(this.itemList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.itemList_ = null;
                }
                return this.itemListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder
            public boolean hasProfilePicture() {
                return (this.profilePictureBuilder_ == null && this.profilePicture_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder
            public ProfilePictureOuterClass.ProfilePicture getProfilePicture() {
                if (this.profilePictureBuilder_ == null) {
                    return this.profilePicture_ == null ? ProfilePictureOuterClass.ProfilePicture.getDefaultInstance() : this.profilePicture_;
                }
                return this.profilePictureBuilder_.getMessage();
            }

            public Builder setProfilePicture(ProfilePictureOuterClass.ProfilePicture value) {
                if (this.profilePictureBuilder_ != null) {
                    this.profilePictureBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.profilePicture_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setProfilePicture(ProfilePictureOuterClass.ProfilePicture.Builder builderForValue) {
                if (this.profilePictureBuilder_ == null) {
                    this.profilePicture_ = builderForValue.build();
                    onChanged();
                } else {
                    this.profilePictureBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeProfilePicture(ProfilePictureOuterClass.ProfilePicture value) {
                if (this.profilePictureBuilder_ == null) {
                    if (this.profilePicture_ != null) {
                        this.profilePicture_ = ProfilePictureOuterClass.ProfilePicture.newBuilder(this.profilePicture_).mergeFrom(value).buildPartial();
                    } else {
                        this.profilePicture_ = value;
                    }
                    onChanged();
                } else {
                    this.profilePictureBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearProfilePicture() {
                if (this.profilePictureBuilder_ == null) {
                    this.profilePicture_ = null;
                    onChanged();
                } else {
                    this.profilePicture_ = null;
                    this.profilePictureBuilder_ = null;
                }
                return this;
            }

            public ProfilePictureOuterClass.ProfilePicture.Builder getProfilePictureBuilder() {
                onChanged();
                return getProfilePictureFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder
            public ProfilePictureOuterClass.ProfilePictureOrBuilder getProfilePictureOrBuilder() {
                if (this.profilePictureBuilder_ != null) {
                    return this.profilePictureBuilder_.getMessageOrBuilder();
                }
                return this.profilePicture_ == null ? ProfilePictureOuterClass.ProfilePicture.getDefaultInstance() : this.profilePicture_;
            }

            private SingleFieldBuilderV3<ProfilePictureOuterClass.ProfilePicture, ProfilePictureOuterClass.ProfilePicture.Builder, ProfilePictureOuterClass.ProfilePictureOrBuilder> getProfilePictureFieldBuilder() {
                if (this.profilePictureBuilder_ == null) {
                    this.profilePictureBuilder_ = new SingleFieldBuilderV3<>(getProfilePicture(), getParentForChildren(), isClean());
                    this.profilePicture_ = null;
                }
                return this.profilePictureBuilder_;
            }

            @Override // emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder
            public String getNickname() {
                Object ref = this.nickname_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.nickname_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder
            public ByteString getNicknameBytes() {
                Object ref = this.nickname_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.nickname_ = b;
                return b;
            }

            public Builder setNickname(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.nickname_ = value;
                onChanged();
                return this;
            }

            public Builder clearNickname() {
                this.nickname_ = WinterCampRecvItemData.getDefaultInstance().getNickname();
                onChanged();
                return this;
            }

            public Builder setNicknameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                WinterCampRecvItemData.checkByteStringIsUtf8(value);
                this.nickname_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static WinterCampRecvItemData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WinterCampRecvItemData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WinterCampRecvItemData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WinterCampRecvItemData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ProfilePictureOuterClass.getDescriptor();
        ItemParamOuterClass.getDescriptor();
    }
}
