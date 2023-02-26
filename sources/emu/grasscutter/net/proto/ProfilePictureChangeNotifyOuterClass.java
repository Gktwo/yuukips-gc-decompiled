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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ProfilePictureChangeNotifyOuterClass.class */
public final class ProfilePictureChangeNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n ProfilePictureChangeNotify.proto\u001a\u0014ProfilePicture.proto\"E\n\u001aProfilePictureChangeNotify\u0012'\n\u000eprofilePicture\u0018\r \u0001(\u000b2\u000f.ProfilePictureB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ProfilePictureOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ProfilePictureChangeNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ProfilePictureChangeNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ProfilePictureChangeNotify_descriptor, new String[]{"ProfilePicture"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ProfilePictureChangeNotifyOuterClass$ProfilePictureChangeNotifyOrBuilder.class */
    public interface ProfilePictureChangeNotifyOrBuilder extends MessageOrBuilder {
        boolean hasProfilePicture();

        ProfilePictureOuterClass.ProfilePicture getProfilePicture();

        ProfilePictureOuterClass.ProfilePictureOrBuilder getProfilePictureOrBuilder();
    }

    private ProfilePictureChangeNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ProfilePictureChangeNotifyOuterClass$ProfilePictureChangeNotify.class */
    public static final class ProfilePictureChangeNotify extends GeneratedMessageV3 implements ProfilePictureChangeNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PROFILEPICTURE_FIELD_NUMBER = 13;
        private ProfilePictureOuterClass.ProfilePicture profilePicture_;
        private byte memoizedIsInitialized;
        private static final ProfilePictureChangeNotify DEFAULT_INSTANCE = new ProfilePictureChangeNotify();
        private static final Parser<ProfilePictureChangeNotify> PARSER = new AbstractParser<ProfilePictureChangeNotify>() { // from class: emu.grasscutter.net.proto.ProfilePictureChangeNotifyOuterClass.ProfilePictureChangeNotify.1
            @Override // com.google.protobuf.Parser
            public ProfilePictureChangeNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ProfilePictureChangeNotify(input, extensionRegistry);
            }
        };

        private ProfilePictureChangeNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ProfilePictureChangeNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ProfilePictureChangeNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ProfilePictureChangeNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 106:
                                ProfilePictureOuterClass.ProfilePicture.Builder subBuilder = this.profilePicture_ != null ? this.profilePicture_.toBuilder() : null;
                                this.profilePicture_ = (ProfilePictureOuterClass.ProfilePicture) input.readMessage(ProfilePictureOuterClass.ProfilePicture.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.profilePicture_);
                                    this.profilePicture_ = subBuilder.buildPartial();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ProfilePictureChangeNotifyOuterClass.internal_static_ProfilePictureChangeNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ProfilePictureChangeNotifyOuterClass.internal_static_ProfilePictureChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ProfilePictureChangeNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ProfilePictureChangeNotifyOuterClass.ProfilePictureChangeNotifyOrBuilder
        public boolean hasProfilePicture() {
            return this.profilePicture_ != null;
        }

        @Override // emu.grasscutter.net.proto.ProfilePictureChangeNotifyOuterClass.ProfilePictureChangeNotifyOrBuilder
        public ProfilePictureOuterClass.ProfilePicture getProfilePicture() {
            return this.profilePicture_ == null ? ProfilePictureOuterClass.ProfilePicture.getDefaultInstance() : this.profilePicture_;
        }

        @Override // emu.grasscutter.net.proto.ProfilePictureChangeNotifyOuterClass.ProfilePictureChangeNotifyOrBuilder
        public ProfilePictureOuterClass.ProfilePictureOrBuilder getProfilePictureOrBuilder() {
            return getProfilePicture();
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
                output.writeMessage(13, getProfilePicture());
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
                size2 = 0 + CodedOutputStream.computeMessageSize(13, getProfilePicture());
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
            if (!(obj instanceof ProfilePictureChangeNotify)) {
                return equals(obj);
            }
            ProfilePictureChangeNotify other = (ProfilePictureChangeNotify) obj;
            if (hasProfilePicture() != other.hasProfilePicture()) {
                return false;
            }
            return (!hasProfilePicture() || getProfilePicture().equals(other.getProfilePicture())) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasProfilePicture()) {
                hash = (53 * ((37 * hash) + 13)) + getProfilePicture().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ProfilePictureChangeNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ProfilePictureChangeNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ProfilePictureChangeNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ProfilePictureChangeNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ProfilePictureChangeNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ProfilePictureChangeNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ProfilePictureChangeNotify parseFrom(InputStream input) throws IOException {
            return (ProfilePictureChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ProfilePictureChangeNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ProfilePictureChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ProfilePictureChangeNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ProfilePictureChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ProfilePictureChangeNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ProfilePictureChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ProfilePictureChangeNotify parseFrom(CodedInputStream input) throws IOException {
            return (ProfilePictureChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ProfilePictureChangeNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ProfilePictureChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ProfilePictureChangeNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ProfilePictureChangeNotifyOuterClass$ProfilePictureChangeNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ProfilePictureChangeNotifyOrBuilder {
            private ProfilePictureOuterClass.ProfilePicture profilePicture_;
            private SingleFieldBuilderV3<ProfilePictureOuterClass.ProfilePicture, ProfilePictureOuterClass.ProfilePicture.Builder, ProfilePictureOuterClass.ProfilePictureOrBuilder> profilePictureBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ProfilePictureChangeNotifyOuterClass.internal_static_ProfilePictureChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ProfilePictureChangeNotifyOuterClass.internal_static_ProfilePictureChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ProfilePictureChangeNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ProfilePictureChangeNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.profilePictureBuilder_ == null) {
                    this.profilePicture_ = null;
                } else {
                    this.profilePicture_ = null;
                    this.profilePictureBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ProfilePictureChangeNotifyOuterClass.internal_static_ProfilePictureChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ProfilePictureChangeNotify getDefaultInstanceForType() {
                return ProfilePictureChangeNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ProfilePictureChangeNotify build() {
                ProfilePictureChangeNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ProfilePictureChangeNotify buildPartial() {
                ProfilePictureChangeNotify result = new ProfilePictureChangeNotify(this);
                if (this.profilePictureBuilder_ == null) {
                    result.profilePicture_ = this.profilePicture_;
                } else {
                    result.profilePicture_ = this.profilePictureBuilder_.build();
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
                if (other instanceof ProfilePictureChangeNotify) {
                    return mergeFrom((ProfilePictureChangeNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ProfilePictureChangeNotify other) {
                if (other == ProfilePictureChangeNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasProfilePicture()) {
                    mergeProfilePicture(other.getProfilePicture());
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
                ProfilePictureChangeNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ProfilePictureChangeNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ProfilePictureChangeNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ProfilePictureChangeNotifyOuterClass.ProfilePictureChangeNotifyOrBuilder
            public boolean hasProfilePicture() {
                return (this.profilePictureBuilder_ == null && this.profilePicture_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ProfilePictureChangeNotifyOuterClass.ProfilePictureChangeNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.ProfilePictureChangeNotifyOuterClass.ProfilePictureChangeNotifyOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static ProfilePictureChangeNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ProfilePictureChangeNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ProfilePictureChangeNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ProfilePictureChangeNotify getDefaultInstanceForType() {
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
