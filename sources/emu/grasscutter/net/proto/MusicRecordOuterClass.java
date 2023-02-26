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
import emu.grasscutter.net.proto.UgcMusicTrackOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicRecordOuterClass.class */
public final class MusicRecordOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011MusicRecord.proto\u001a\u0013UgcMusicTrack.proto\"F\n\u000bMusicRecord\u0012&\n\u000emusicTrackList\u0018\u0003 \u0003(\u000b2\u000e.UgcMusicTrack\u0012\u000f\n\u0007musicId\u0018\u0002 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{UgcMusicTrackOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MusicRecord_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MusicRecord_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MusicRecord_descriptor, new String[]{"MusicTrackList", "MusicId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicRecordOuterClass$MusicRecordOrBuilder.class */
    public interface MusicRecordOrBuilder extends MessageOrBuilder {
        List<UgcMusicTrackOuterClass.UgcMusicTrack> getMusicTrackListList();

        UgcMusicTrackOuterClass.UgcMusicTrack getMusicTrackList(int i);

        int getMusicTrackListCount();

        List<? extends UgcMusicTrackOuterClass.UgcMusicTrackOrBuilder> getMusicTrackListOrBuilderList();

        UgcMusicTrackOuterClass.UgcMusicTrackOrBuilder getMusicTrackListOrBuilder(int i);

        int getMusicId();
    }

    private MusicRecordOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicRecordOuterClass$MusicRecord.class */
    public static final class MusicRecord extends GeneratedMessageV3 implements MusicRecordOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MUSICTRACKLIST_FIELD_NUMBER = 3;
        private List<UgcMusicTrackOuterClass.UgcMusicTrack> musicTrackList_;
        public static final int MUSICID_FIELD_NUMBER = 2;
        private int musicId_;
        private byte memoizedIsInitialized;
        private static final MusicRecord DEFAULT_INSTANCE = new MusicRecord();
        private static final Parser<MusicRecord> PARSER = new AbstractParser<MusicRecord>() { // from class: emu.grasscutter.net.proto.MusicRecordOuterClass.MusicRecord.1
            @Override // com.google.protobuf.Parser
            public MusicRecord parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MusicRecord(input, extensionRegistry);
            }
        };

        private MusicRecord(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MusicRecord() {
            this.memoizedIsInitialized = -1;
            this.musicTrackList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MusicRecord();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MusicRecord(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 16:
                                    this.musicId_ = input.readUInt32();
                                    break;
                                case 26:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.musicTrackList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.musicTrackList_.add((UgcMusicTrackOuterClass.UgcMusicTrack) input.readMessage(UgcMusicTrackOuterClass.UgcMusicTrack.parser(), extensionRegistry));
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
                    this.musicTrackList_ = Collections.unmodifiableList(this.musicTrackList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MusicRecordOuterClass.internal_static_MusicRecord_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MusicRecordOuterClass.internal_static_MusicRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicRecord.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MusicRecordOuterClass.MusicRecordOrBuilder
        public List<UgcMusicTrackOuterClass.UgcMusicTrack> getMusicTrackListList() {
            return this.musicTrackList_;
        }

        @Override // emu.grasscutter.net.proto.MusicRecordOuterClass.MusicRecordOrBuilder
        public List<? extends UgcMusicTrackOuterClass.UgcMusicTrackOrBuilder> getMusicTrackListOrBuilderList() {
            return this.musicTrackList_;
        }

        @Override // emu.grasscutter.net.proto.MusicRecordOuterClass.MusicRecordOrBuilder
        public int getMusicTrackListCount() {
            return this.musicTrackList_.size();
        }

        @Override // emu.grasscutter.net.proto.MusicRecordOuterClass.MusicRecordOrBuilder
        public UgcMusicTrackOuterClass.UgcMusicTrack getMusicTrackList(int index) {
            return this.musicTrackList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MusicRecordOuterClass.MusicRecordOrBuilder
        public UgcMusicTrackOuterClass.UgcMusicTrackOrBuilder getMusicTrackListOrBuilder(int index) {
            return this.musicTrackList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MusicRecordOuterClass.MusicRecordOrBuilder
        public int getMusicId() {
            return this.musicId_;
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
            if (this.musicId_ != 0) {
                output.writeUInt32(2, this.musicId_);
            }
            for (int i = 0; i < this.musicTrackList_.size(); i++) {
                output.writeMessage(3, this.musicTrackList_.get(i));
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
            if (this.musicId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.musicId_);
            }
            for (int i = 0; i < this.musicTrackList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.musicTrackList_.get(i));
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
            if (!(obj instanceof MusicRecord)) {
                return equals(obj);
            }
            MusicRecord other = (MusicRecord) obj;
            return getMusicTrackListList().equals(other.getMusicTrackListList()) && getMusicId() == other.getMusicId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getMusicTrackListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getMusicTrackListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 2)) + getMusicId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MusicRecord parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicRecord parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicRecord parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicRecord parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicRecord parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicRecord parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicRecord parseFrom(InputStream input) throws IOException {
            return (MusicRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicRecord parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicRecord parseDelimitedFrom(InputStream input) throws IOException {
            return (MusicRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MusicRecord parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicRecord parseFrom(CodedInputStream input) throws IOException {
            return (MusicRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicRecord parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MusicRecord prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicRecordOuterClass$MusicRecord$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MusicRecordOrBuilder {
            private int bitField0_;
            private List<UgcMusicTrackOuterClass.UgcMusicTrack> musicTrackList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<UgcMusicTrackOuterClass.UgcMusicTrack, UgcMusicTrackOuterClass.UgcMusicTrack.Builder, UgcMusicTrackOuterClass.UgcMusicTrackOrBuilder> musicTrackListBuilder_;
            private int musicId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MusicRecordOuterClass.internal_static_MusicRecord_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MusicRecordOuterClass.internal_static_MusicRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicRecord.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MusicRecord.alwaysUseFieldBuilders) {
                    getMusicTrackListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.musicTrackListBuilder_ == null) {
                    this.musicTrackList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.musicTrackListBuilder_.clear();
                }
                this.musicId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MusicRecordOuterClass.internal_static_MusicRecord_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MusicRecord getDefaultInstanceForType() {
                return MusicRecord.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicRecord build() {
                MusicRecord result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicRecord buildPartial() {
                MusicRecord result = new MusicRecord(this);
                int i = this.bitField0_;
                if (this.musicTrackListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.musicTrackList_ = Collections.unmodifiableList(this.musicTrackList_);
                        this.bitField0_ &= -2;
                    }
                    result.musicTrackList_ = this.musicTrackList_;
                } else {
                    result.musicTrackList_ = this.musicTrackListBuilder_.build();
                }
                result.musicId_ = this.musicId_;
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
                if (other instanceof MusicRecord) {
                    return mergeFrom((MusicRecord) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MusicRecord other) {
                if (other == MusicRecord.getDefaultInstance()) {
                    return this;
                }
                if (this.musicTrackListBuilder_ == null) {
                    if (!other.musicTrackList_.isEmpty()) {
                        if (this.musicTrackList_.isEmpty()) {
                            this.musicTrackList_ = other.musicTrackList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureMusicTrackListIsMutable();
                            this.musicTrackList_.addAll(other.musicTrackList_);
                        }
                        onChanged();
                    }
                } else if (!other.musicTrackList_.isEmpty()) {
                    if (this.musicTrackListBuilder_.isEmpty()) {
                        this.musicTrackListBuilder_.dispose();
                        this.musicTrackListBuilder_ = null;
                        this.musicTrackList_ = other.musicTrackList_;
                        this.bitField0_ &= -2;
                        this.musicTrackListBuilder_ = MusicRecord.alwaysUseFieldBuilders ? getMusicTrackListFieldBuilder() : null;
                    } else {
                        this.musicTrackListBuilder_.addAllMessages(other.musicTrackList_);
                    }
                }
                if (other.getMusicId() != 0) {
                    setMusicId(other.getMusicId());
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
                MusicRecord parsedMessage = null;
                try {
                    try {
                        parsedMessage = MusicRecord.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MusicRecord) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureMusicTrackListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.musicTrackList_ = new ArrayList(this.musicTrackList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.MusicRecordOuterClass.MusicRecordOrBuilder
            public List<UgcMusicTrackOuterClass.UgcMusicTrack> getMusicTrackListList() {
                if (this.musicTrackListBuilder_ == null) {
                    return Collections.unmodifiableList(this.musicTrackList_);
                }
                return this.musicTrackListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.MusicRecordOuterClass.MusicRecordOrBuilder
            public int getMusicTrackListCount() {
                if (this.musicTrackListBuilder_ == null) {
                    return this.musicTrackList_.size();
                }
                return this.musicTrackListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.MusicRecordOuterClass.MusicRecordOrBuilder
            public UgcMusicTrackOuterClass.UgcMusicTrack getMusicTrackList(int index) {
                if (this.musicTrackListBuilder_ == null) {
                    return this.musicTrackList_.get(index);
                }
                return this.musicTrackListBuilder_.getMessage(index);
            }

            public Builder setMusicTrackList(int index, UgcMusicTrackOuterClass.UgcMusicTrack value) {
                if (this.musicTrackListBuilder_ != null) {
                    this.musicTrackListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMusicTrackListIsMutable();
                    this.musicTrackList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMusicTrackList(int index, UgcMusicTrackOuterClass.UgcMusicTrack.Builder builderForValue) {
                if (this.musicTrackListBuilder_ == null) {
                    ensureMusicTrackListIsMutable();
                    this.musicTrackList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.musicTrackListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMusicTrackList(UgcMusicTrackOuterClass.UgcMusicTrack value) {
                if (this.musicTrackListBuilder_ != null) {
                    this.musicTrackListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMusicTrackListIsMutable();
                    this.musicTrackList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMusicTrackList(int index, UgcMusicTrackOuterClass.UgcMusicTrack value) {
                if (this.musicTrackListBuilder_ != null) {
                    this.musicTrackListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMusicTrackListIsMutable();
                    this.musicTrackList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMusicTrackList(UgcMusicTrackOuterClass.UgcMusicTrack.Builder builderForValue) {
                if (this.musicTrackListBuilder_ == null) {
                    ensureMusicTrackListIsMutable();
                    this.musicTrackList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.musicTrackListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMusicTrackList(int index, UgcMusicTrackOuterClass.UgcMusicTrack.Builder builderForValue) {
                if (this.musicTrackListBuilder_ == null) {
                    ensureMusicTrackListIsMutable();
                    this.musicTrackList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.musicTrackListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMusicTrackList(Iterable<? extends UgcMusicTrackOuterClass.UgcMusicTrack> values) {
                if (this.musicTrackListBuilder_ == null) {
                    ensureMusicTrackListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.musicTrackList_);
                    onChanged();
                } else {
                    this.musicTrackListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMusicTrackList() {
                if (this.musicTrackListBuilder_ == null) {
                    this.musicTrackList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.musicTrackListBuilder_.clear();
                }
                return this;
            }

            public Builder removeMusicTrackList(int index) {
                if (this.musicTrackListBuilder_ == null) {
                    ensureMusicTrackListIsMutable();
                    this.musicTrackList_.remove(index);
                    onChanged();
                } else {
                    this.musicTrackListBuilder_.remove(index);
                }
                return this;
            }

            public UgcMusicTrackOuterClass.UgcMusicTrack.Builder getMusicTrackListBuilder(int index) {
                return getMusicTrackListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MusicRecordOuterClass.MusicRecordOrBuilder
            public UgcMusicTrackOuterClass.UgcMusicTrackOrBuilder getMusicTrackListOrBuilder(int index) {
                if (this.musicTrackListBuilder_ == null) {
                    return this.musicTrackList_.get(index);
                }
                return this.musicTrackListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MusicRecordOuterClass.MusicRecordOrBuilder
            public List<? extends UgcMusicTrackOuterClass.UgcMusicTrackOrBuilder> getMusicTrackListOrBuilderList() {
                if (this.musicTrackListBuilder_ != null) {
                    return this.musicTrackListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.musicTrackList_);
            }

            public UgcMusicTrackOuterClass.UgcMusicTrack.Builder addMusicTrackListBuilder() {
                return getMusicTrackListFieldBuilder().addBuilder(UgcMusicTrackOuterClass.UgcMusicTrack.getDefaultInstance());
            }

            public UgcMusicTrackOuterClass.UgcMusicTrack.Builder addMusicTrackListBuilder(int index) {
                return getMusicTrackListFieldBuilder().addBuilder(index, UgcMusicTrackOuterClass.UgcMusicTrack.getDefaultInstance());
            }

            public List<UgcMusicTrackOuterClass.UgcMusicTrack.Builder> getMusicTrackListBuilderList() {
                return getMusicTrackListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<UgcMusicTrackOuterClass.UgcMusicTrack, UgcMusicTrackOuterClass.UgcMusicTrack.Builder, UgcMusicTrackOuterClass.UgcMusicTrackOrBuilder> getMusicTrackListFieldBuilder() {
                if (this.musicTrackListBuilder_ == null) {
                    this.musicTrackListBuilder_ = new RepeatedFieldBuilderV3<>(this.musicTrackList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.musicTrackList_ = null;
                }
                return this.musicTrackListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.MusicRecordOuterClass.MusicRecordOrBuilder
            public int getMusicId() {
                return this.musicId_;
            }

            public Builder setMusicId(int value) {
                this.musicId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMusicId() {
                this.musicId_ = 0;
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

        public static MusicRecord getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MusicRecord> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MusicRecord> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MusicRecord getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        UgcMusicTrackOuterClass.getDescriptor();
    }
}
