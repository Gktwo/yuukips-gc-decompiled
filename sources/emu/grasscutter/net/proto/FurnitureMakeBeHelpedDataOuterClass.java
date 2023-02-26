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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.ProfilePictureOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeBeHelpedDataOuterClass.class */
public final class FurnitureMakeBeHelpedDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fFurnitureMakeBeHelpedData.proto\u001a\u0014ProfilePicture.proto\"\u0001\n\u0019FurnitureMakeBeHelpedData\u0012\u000b\n\u0003uid\u0018\u0007 \u0001(\r\u0012'\n\u000eprofilePicture\u0018\n \u0001(\u000b2\u000f.ProfilePicture\u0012\f\n\u0004icon\u0018\r \u0001(\r\u0012\f\n\u0004time\u0018\u0004 \u0001(\u0007\u0012\u0012\n\nplayerName\u0018\u0006 \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ProfilePictureOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FurnitureMakeBeHelpedData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FurnitureMakeBeHelpedData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FurnitureMakeBeHelpedData_descriptor, new String[]{"Uid", "ProfilePicture", "Icon", "Time", "PlayerName"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeBeHelpedDataOuterClass$FurnitureMakeBeHelpedDataOrBuilder.class */
    public interface FurnitureMakeBeHelpedDataOrBuilder extends MessageOrBuilder {
        int getUid();

        boolean hasProfilePicture();

        ProfilePictureOuterClass.ProfilePicture getProfilePicture();

        ProfilePictureOuterClass.ProfilePictureOrBuilder getProfilePictureOrBuilder();

        int getIcon();

        int getTime();

        String getPlayerName();

        ByteString getPlayerNameBytes();
    }

    private FurnitureMakeBeHelpedDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeBeHelpedDataOuterClass$FurnitureMakeBeHelpedData.class */
    public static final class FurnitureMakeBeHelpedData extends GeneratedMessageV3 implements FurnitureMakeBeHelpedDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UID_FIELD_NUMBER = 7;
        private int uid_;
        public static final int PROFILEPICTURE_FIELD_NUMBER = 10;
        private ProfilePictureOuterClass.ProfilePicture profilePicture_;
        public static final int ICON_FIELD_NUMBER = 13;
        private int icon_;
        public static final int TIME_FIELD_NUMBER = 4;
        private int time_;
        public static final int PLAYERNAME_FIELD_NUMBER = 6;
        private volatile Object playerName_;
        private byte memoizedIsInitialized;
        private static final FurnitureMakeBeHelpedData DEFAULT_INSTANCE = new FurnitureMakeBeHelpedData();
        private static final Parser<FurnitureMakeBeHelpedData> PARSER = new AbstractParser<FurnitureMakeBeHelpedData>() { // from class: emu.grasscutter.net.proto.FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.1
            @Override // com.google.protobuf.Parser
            public FurnitureMakeBeHelpedData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FurnitureMakeBeHelpedData(input, extensionRegistry);
            }
        };

        private FurnitureMakeBeHelpedData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FurnitureMakeBeHelpedData() {
            this.memoizedIsInitialized = -1;
            this.playerName_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FurnitureMakeBeHelpedData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FurnitureMakeBeHelpedData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 37:
                                this.time_ = input.readFixed32();
                                break;
                            case 50:
                                this.playerName_ = input.readStringRequireUtf8();
                                break;
                            case 56:
                                this.uid_ = input.readUInt32();
                                break;
                            case 82:
                                ProfilePictureOuterClass.ProfilePicture.Builder subBuilder = this.profilePicture_ != null ? this.profilePicture_.toBuilder() : null;
                                this.profilePicture_ = (ProfilePictureOuterClass.ProfilePicture) input.readMessage(ProfilePictureOuterClass.ProfilePicture.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.profilePicture_);
                                    this.profilePicture_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 104:
                                this.icon_ = input.readUInt32();
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
            return FurnitureMakeBeHelpedDataOuterClass.internal_static_FurnitureMakeBeHelpedData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FurnitureMakeBeHelpedDataOuterClass.internal_static_FurnitureMakeBeHelpedData_fieldAccessorTable.ensureFieldAccessorsInitialized(FurnitureMakeBeHelpedData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder
        public boolean hasProfilePicture() {
            return this.profilePicture_ != null;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder
        public ProfilePictureOuterClass.ProfilePicture getProfilePicture() {
            return this.profilePicture_ == null ? ProfilePictureOuterClass.ProfilePicture.getDefaultInstance() : this.profilePicture_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder
        public ProfilePictureOuterClass.ProfilePictureOrBuilder getProfilePictureOrBuilder() {
            return getProfilePicture();
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder
        public int getIcon() {
            return this.icon_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder
        public int getTime() {
            return this.time_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder
        public String getPlayerName() {
            Object ref = this.playerName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.playerName_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder
        public ByteString getPlayerNameBytes() {
            Object ref = this.playerName_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.playerName_ = b;
            return b;
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
            if (this.time_ != 0) {
                output.writeFixed32(4, this.time_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.playerName_)) {
                GeneratedMessageV3.writeString(output, 6, this.playerName_);
            }
            if (this.uid_ != 0) {
                output.writeUInt32(7, this.uid_);
            }
            if (this.profilePicture_ != null) {
                output.writeMessage(10, getProfilePicture());
            }
            if (this.icon_ != 0) {
                output.writeUInt32(13, this.icon_);
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
            if (this.time_ != 0) {
                size2 = 0 + CodedOutputStream.computeFixed32Size(4, this.time_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.playerName_)) {
                size2 += GeneratedMessageV3.computeStringSize(6, this.playerName_);
            }
            if (this.uid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.uid_);
            }
            if (this.profilePicture_ != null) {
                size2 += CodedOutputStream.computeMessageSize(10, getProfilePicture());
            }
            if (this.icon_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.icon_);
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
            if (!(obj instanceof FurnitureMakeBeHelpedData)) {
                return equals(obj);
            }
            FurnitureMakeBeHelpedData other = (FurnitureMakeBeHelpedData) obj;
            if (getUid() == other.getUid() && hasProfilePicture() == other.hasProfilePicture()) {
                return (!hasProfilePicture() || getProfilePicture().equals(other.getProfilePicture())) && getIcon() == other.getIcon() && getTime() == other.getTime() && getPlayerName().equals(other.getPlayerName()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + getUid();
            if (hasProfilePicture()) {
                hash = (53 * ((37 * hash) + 10)) + getProfilePicture().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 13)) + getIcon())) + 4)) + getTime())) + 6)) + getPlayerName().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FurnitureMakeBeHelpedData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeBeHelpedData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeBeHelpedData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeBeHelpedData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeBeHelpedData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeBeHelpedData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeBeHelpedData parseFrom(InputStream input) throws IOException {
            return (FurnitureMakeBeHelpedData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FurnitureMakeBeHelpedData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeBeHelpedData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FurnitureMakeBeHelpedData parseDelimitedFrom(InputStream input) throws IOException {
            return (FurnitureMakeBeHelpedData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FurnitureMakeBeHelpedData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeBeHelpedData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FurnitureMakeBeHelpedData parseFrom(CodedInputStream input) throws IOException {
            return (FurnitureMakeBeHelpedData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FurnitureMakeBeHelpedData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeBeHelpedData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FurnitureMakeBeHelpedData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeBeHelpedDataOuterClass$FurnitureMakeBeHelpedData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FurnitureMakeBeHelpedDataOrBuilder {
            private int uid_;
            private ProfilePictureOuterClass.ProfilePicture profilePicture_;
            private SingleFieldBuilderV3<ProfilePictureOuterClass.ProfilePicture, ProfilePictureOuterClass.ProfilePicture.Builder, ProfilePictureOuterClass.ProfilePictureOrBuilder> profilePictureBuilder_;
            private int icon_;
            private int time_;
            private Object playerName_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return FurnitureMakeBeHelpedDataOuterClass.internal_static_FurnitureMakeBeHelpedData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FurnitureMakeBeHelpedDataOuterClass.internal_static_FurnitureMakeBeHelpedData_fieldAccessorTable.ensureFieldAccessorsInitialized(FurnitureMakeBeHelpedData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FurnitureMakeBeHelpedData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.uid_ = 0;
                if (this.profilePictureBuilder_ == null) {
                    this.profilePicture_ = null;
                } else {
                    this.profilePicture_ = null;
                    this.profilePictureBuilder_ = null;
                }
                this.icon_ = 0;
                this.time_ = 0;
                this.playerName_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FurnitureMakeBeHelpedDataOuterClass.internal_static_FurnitureMakeBeHelpedData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FurnitureMakeBeHelpedData getDefaultInstanceForType() {
                return FurnitureMakeBeHelpedData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FurnitureMakeBeHelpedData build() {
                FurnitureMakeBeHelpedData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FurnitureMakeBeHelpedData buildPartial() {
                FurnitureMakeBeHelpedData result = new FurnitureMakeBeHelpedData(this);
                result.uid_ = this.uid_;
                if (this.profilePictureBuilder_ == null) {
                    result.profilePicture_ = this.profilePicture_;
                } else {
                    result.profilePicture_ = this.profilePictureBuilder_.build();
                }
                result.icon_ = this.icon_;
                result.time_ = this.time_;
                result.playerName_ = this.playerName_;
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
                if (other instanceof FurnitureMakeBeHelpedData) {
                    return mergeFrom((FurnitureMakeBeHelpedData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FurnitureMakeBeHelpedData other) {
                if (other == FurnitureMakeBeHelpedData.getDefaultInstance()) {
                    return this;
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
                }
                if (other.hasProfilePicture()) {
                    mergeProfilePicture(other.getProfilePicture());
                }
                if (other.getIcon() != 0) {
                    setIcon(other.getIcon());
                }
                if (other.getTime() != 0) {
                    setTime(other.getTime());
                }
                if (!other.getPlayerName().isEmpty()) {
                    this.playerName_ = other.playerName_;
                    onChanged();
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
                FurnitureMakeBeHelpedData parsedMessage = null;
                try {
                    try {
                        parsedMessage = FurnitureMakeBeHelpedData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FurnitureMakeBeHelpedData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder
            public boolean hasProfilePicture() {
                return (this.profilePictureBuilder_ == null && this.profilePicture_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder
            public int getIcon() {
                return this.icon_;
            }

            public Builder setIcon(int value) {
                this.icon_ = value;
                onChanged();
                return this;
            }

            public Builder clearIcon() {
                this.icon_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder
            public int getTime() {
                return this.time_;
            }

            public Builder setTime(int value) {
                this.time_ = value;
                onChanged();
                return this;
            }

            public Builder clearTime() {
                this.time_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder
            public String getPlayerName() {
                Object ref = this.playerName_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.playerName_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder
            public ByteString getPlayerNameBytes() {
                Object ref = this.playerName_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.playerName_ = b;
                return b;
            }

            public Builder setPlayerName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.playerName_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerName() {
                this.playerName_ = FurnitureMakeBeHelpedData.getDefaultInstance().getPlayerName();
                onChanged();
                return this;
            }

            public Builder setPlayerNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                FurnitureMakeBeHelpedData.checkByteStringIsUtf8(value);
                this.playerName_ = value;
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

        public static FurnitureMakeBeHelpedData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FurnitureMakeBeHelpedData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FurnitureMakeBeHelpedData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FurnitureMakeBeHelpedData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ProfilePictureOuterClass.getDescriptor();
    }
}
