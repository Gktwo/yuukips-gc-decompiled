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
import emu.grasscutter.net.proto.UgcMusicNoteOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UgcMusicTrackOuterClass.class */
public final class UgcMusicTrackOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013UgcMusicTrack.proto\u001a\u0012UgcMusicNote.proto\"5\n\rUgcMusicTrack\u0012$\n\rmusicNoteList\u0018\r \u0003(\u000b2\r.UgcMusicNoteB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{UgcMusicNoteOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_UgcMusicTrack_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_UgcMusicTrack_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_UgcMusicTrack_descriptor, new String[]{"MusicNoteList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UgcMusicTrackOuterClass$UgcMusicTrackOrBuilder.class */
    public interface UgcMusicTrackOrBuilder extends MessageOrBuilder {
        List<UgcMusicNoteOuterClass.UgcMusicNote> getMusicNoteListList();

        UgcMusicNoteOuterClass.UgcMusicNote getMusicNoteList(int i);

        int getMusicNoteListCount();

        List<? extends UgcMusicNoteOuterClass.UgcMusicNoteOrBuilder> getMusicNoteListOrBuilderList();

        UgcMusicNoteOuterClass.UgcMusicNoteOrBuilder getMusicNoteListOrBuilder(int i);
    }

    private UgcMusicTrackOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UgcMusicTrackOuterClass$UgcMusicTrack.class */
    public static final class UgcMusicTrack extends GeneratedMessageV3 implements UgcMusicTrackOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MUSICNOTELIST_FIELD_NUMBER = 13;
        private List<UgcMusicNoteOuterClass.UgcMusicNote> musicNoteList_;
        private byte memoizedIsInitialized;
        private static final UgcMusicTrack DEFAULT_INSTANCE = new UgcMusicTrack();
        private static final Parser<UgcMusicTrack> PARSER = new AbstractParser<UgcMusicTrack>() { // from class: emu.grasscutter.net.proto.UgcMusicTrackOuterClass.UgcMusicTrack.1
            @Override // com.google.protobuf.Parser
            public UgcMusicTrack parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new UgcMusicTrack(input, extensionRegistry);
            }
        };

        private UgcMusicTrack(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private UgcMusicTrack() {
            this.memoizedIsInitialized = -1;
            this.musicNoteList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new UgcMusicTrack();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UgcMusicTrack(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 106:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.musicNoteList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.musicNoteList_.add((UgcMusicNoteOuterClass.UgcMusicNote) input.readMessage(UgcMusicNoteOuterClass.UgcMusicNote.parser(), extensionRegistry));
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
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.musicNoteList_ = Collections.unmodifiableList(this.musicNoteList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return UgcMusicTrackOuterClass.internal_static_UgcMusicTrack_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return UgcMusicTrackOuterClass.internal_static_UgcMusicTrack_fieldAccessorTable.ensureFieldAccessorsInitialized(UgcMusicTrack.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.UgcMusicTrackOuterClass.UgcMusicTrackOrBuilder
        public List<UgcMusicNoteOuterClass.UgcMusicNote> getMusicNoteListList() {
            return this.musicNoteList_;
        }

        @Override // emu.grasscutter.net.proto.UgcMusicTrackOuterClass.UgcMusicTrackOrBuilder
        public List<? extends UgcMusicNoteOuterClass.UgcMusicNoteOrBuilder> getMusicNoteListOrBuilderList() {
            return this.musicNoteList_;
        }

        @Override // emu.grasscutter.net.proto.UgcMusicTrackOuterClass.UgcMusicTrackOrBuilder
        public int getMusicNoteListCount() {
            return this.musicNoteList_.size();
        }

        @Override // emu.grasscutter.net.proto.UgcMusicTrackOuterClass.UgcMusicTrackOrBuilder
        public UgcMusicNoteOuterClass.UgcMusicNote getMusicNoteList(int index) {
            return this.musicNoteList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.UgcMusicTrackOuterClass.UgcMusicTrackOrBuilder
        public UgcMusicNoteOuterClass.UgcMusicNoteOrBuilder getMusicNoteListOrBuilder(int index) {
            return this.musicNoteList_.get(index);
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
            for (int i = 0; i < this.musicNoteList_.size(); i++) {
                output.writeMessage(13, this.musicNoteList_.get(i));
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
            for (int i = 0; i < this.musicNoteList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(13, this.musicNoteList_.get(i));
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
            if (!(obj instanceof UgcMusicTrack)) {
                return equals(obj);
            }
            UgcMusicTrack other = (UgcMusicTrack) obj;
            return getMusicNoteListList().equals(other.getMusicNoteListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getMusicNoteListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getMusicNoteListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static UgcMusicTrack parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UgcMusicTrack parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UgcMusicTrack parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UgcMusicTrack parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UgcMusicTrack parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UgcMusicTrack parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UgcMusicTrack parseFrom(InputStream input) throws IOException {
            return (UgcMusicTrack) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UgcMusicTrack parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UgcMusicTrack) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static UgcMusicTrack parseDelimitedFrom(InputStream input) throws IOException {
            return (UgcMusicTrack) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static UgcMusicTrack parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UgcMusicTrack) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static UgcMusicTrack parseFrom(CodedInputStream input) throws IOException {
            return (UgcMusicTrack) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UgcMusicTrack parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UgcMusicTrack) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UgcMusicTrack prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UgcMusicTrackOuterClass$UgcMusicTrack$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UgcMusicTrackOrBuilder {
            private int bitField0_;
            private List<UgcMusicNoteOuterClass.UgcMusicNote> musicNoteList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<UgcMusicNoteOuterClass.UgcMusicNote, UgcMusicNoteOuterClass.UgcMusicNote.Builder, UgcMusicNoteOuterClass.UgcMusicNoteOrBuilder> musicNoteListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return UgcMusicTrackOuterClass.internal_static_UgcMusicTrack_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return UgcMusicTrackOuterClass.internal_static_UgcMusicTrack_fieldAccessorTable.ensureFieldAccessorsInitialized(UgcMusicTrack.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (UgcMusicTrack.alwaysUseFieldBuilders) {
                    getMusicNoteListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.musicNoteListBuilder_ == null) {
                    this.musicNoteList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.musicNoteListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return UgcMusicTrackOuterClass.internal_static_UgcMusicTrack_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public UgcMusicTrack getDefaultInstanceForType() {
                return UgcMusicTrack.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UgcMusicTrack build() {
                UgcMusicTrack result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UgcMusicTrack buildPartial() {
                UgcMusicTrack result = new UgcMusicTrack(this);
                int i = this.bitField0_;
                if (this.musicNoteListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.musicNoteList_ = Collections.unmodifiableList(this.musicNoteList_);
                        this.bitField0_ &= -2;
                    }
                    result.musicNoteList_ = this.musicNoteList_;
                } else {
                    result.musicNoteList_ = this.musicNoteListBuilder_.build();
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
                if (other instanceof UgcMusicTrack) {
                    return mergeFrom((UgcMusicTrack) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(UgcMusicTrack other) {
                if (other == UgcMusicTrack.getDefaultInstance()) {
                    return this;
                }
                if (this.musicNoteListBuilder_ == null) {
                    if (!other.musicNoteList_.isEmpty()) {
                        if (this.musicNoteList_.isEmpty()) {
                            this.musicNoteList_ = other.musicNoteList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureMusicNoteListIsMutable();
                            this.musicNoteList_.addAll(other.musicNoteList_);
                        }
                        onChanged();
                    }
                } else if (!other.musicNoteList_.isEmpty()) {
                    if (this.musicNoteListBuilder_.isEmpty()) {
                        this.musicNoteListBuilder_.dispose();
                        this.musicNoteListBuilder_ = null;
                        this.musicNoteList_ = other.musicNoteList_;
                        this.bitField0_ &= -2;
                        this.musicNoteListBuilder_ = UgcMusicTrack.alwaysUseFieldBuilders ? getMusicNoteListFieldBuilder() : null;
                    } else {
                        this.musicNoteListBuilder_.addAllMessages(other.musicNoteList_);
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
                UgcMusicTrack parsedMessage = null;
                try {
                    try {
                        parsedMessage = UgcMusicTrack.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (UgcMusicTrack) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureMusicNoteListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.musicNoteList_ = new ArrayList(this.musicNoteList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.UgcMusicTrackOuterClass.UgcMusicTrackOrBuilder
            public List<UgcMusicNoteOuterClass.UgcMusicNote> getMusicNoteListList() {
                if (this.musicNoteListBuilder_ == null) {
                    return Collections.unmodifiableList(this.musicNoteList_);
                }
                return this.musicNoteListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.UgcMusicTrackOuterClass.UgcMusicTrackOrBuilder
            public int getMusicNoteListCount() {
                if (this.musicNoteListBuilder_ == null) {
                    return this.musicNoteList_.size();
                }
                return this.musicNoteListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.UgcMusicTrackOuterClass.UgcMusicTrackOrBuilder
            public UgcMusicNoteOuterClass.UgcMusicNote getMusicNoteList(int index) {
                if (this.musicNoteListBuilder_ == null) {
                    return this.musicNoteList_.get(index);
                }
                return this.musicNoteListBuilder_.getMessage(index);
            }

            public Builder setMusicNoteList(int index, UgcMusicNoteOuterClass.UgcMusicNote value) {
                if (this.musicNoteListBuilder_ != null) {
                    this.musicNoteListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMusicNoteListIsMutable();
                    this.musicNoteList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMusicNoteList(int index, UgcMusicNoteOuterClass.UgcMusicNote.Builder builderForValue) {
                if (this.musicNoteListBuilder_ == null) {
                    ensureMusicNoteListIsMutable();
                    this.musicNoteList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.musicNoteListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMusicNoteList(UgcMusicNoteOuterClass.UgcMusicNote value) {
                if (this.musicNoteListBuilder_ != null) {
                    this.musicNoteListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMusicNoteListIsMutable();
                    this.musicNoteList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMusicNoteList(int index, UgcMusicNoteOuterClass.UgcMusicNote value) {
                if (this.musicNoteListBuilder_ != null) {
                    this.musicNoteListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMusicNoteListIsMutable();
                    this.musicNoteList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMusicNoteList(UgcMusicNoteOuterClass.UgcMusicNote.Builder builderForValue) {
                if (this.musicNoteListBuilder_ == null) {
                    ensureMusicNoteListIsMutable();
                    this.musicNoteList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.musicNoteListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMusicNoteList(int index, UgcMusicNoteOuterClass.UgcMusicNote.Builder builderForValue) {
                if (this.musicNoteListBuilder_ == null) {
                    ensureMusicNoteListIsMutable();
                    this.musicNoteList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.musicNoteListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMusicNoteList(Iterable<? extends UgcMusicNoteOuterClass.UgcMusicNote> values) {
                if (this.musicNoteListBuilder_ == null) {
                    ensureMusicNoteListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.musicNoteList_);
                    onChanged();
                } else {
                    this.musicNoteListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMusicNoteList() {
                if (this.musicNoteListBuilder_ == null) {
                    this.musicNoteList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.musicNoteListBuilder_.clear();
                }
                return this;
            }

            public Builder removeMusicNoteList(int index) {
                if (this.musicNoteListBuilder_ == null) {
                    ensureMusicNoteListIsMutable();
                    this.musicNoteList_.remove(index);
                    onChanged();
                } else {
                    this.musicNoteListBuilder_.remove(index);
                }
                return this;
            }

            public UgcMusicNoteOuterClass.UgcMusicNote.Builder getMusicNoteListBuilder(int index) {
                return getMusicNoteListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.UgcMusicTrackOuterClass.UgcMusicTrackOrBuilder
            public UgcMusicNoteOuterClass.UgcMusicNoteOrBuilder getMusicNoteListOrBuilder(int index) {
                if (this.musicNoteListBuilder_ == null) {
                    return this.musicNoteList_.get(index);
                }
                return this.musicNoteListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.UgcMusicTrackOuterClass.UgcMusicTrackOrBuilder
            public List<? extends UgcMusicNoteOuterClass.UgcMusicNoteOrBuilder> getMusicNoteListOrBuilderList() {
                if (this.musicNoteListBuilder_ != null) {
                    return this.musicNoteListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.musicNoteList_);
            }

            public UgcMusicNoteOuterClass.UgcMusicNote.Builder addMusicNoteListBuilder() {
                return getMusicNoteListFieldBuilder().addBuilder(UgcMusicNoteOuterClass.UgcMusicNote.getDefaultInstance());
            }

            public UgcMusicNoteOuterClass.UgcMusicNote.Builder addMusicNoteListBuilder(int index) {
                return getMusicNoteListFieldBuilder().addBuilder(index, UgcMusicNoteOuterClass.UgcMusicNote.getDefaultInstance());
            }

            public List<UgcMusicNoteOuterClass.UgcMusicNote.Builder> getMusicNoteListBuilderList() {
                return getMusicNoteListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<UgcMusicNoteOuterClass.UgcMusicNote, UgcMusicNoteOuterClass.UgcMusicNote.Builder, UgcMusicNoteOuterClass.UgcMusicNoteOrBuilder> getMusicNoteListFieldBuilder() {
                if (this.musicNoteListBuilder_ == null) {
                    this.musicNoteListBuilder_ = new RepeatedFieldBuilderV3<>(this.musicNoteList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.musicNoteList_ = null;
                }
                return this.musicNoteListBuilder_;
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

        public static UgcMusicTrack getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UgcMusicTrack> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<UgcMusicTrack> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UgcMusicTrack getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        UgcMusicNoteOuterClass.getDescriptor();
    }
}
