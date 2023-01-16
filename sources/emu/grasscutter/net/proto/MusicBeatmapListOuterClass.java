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
import emu.grasscutter.net.proto.MusicBeatmapNoteOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicBeatmapListOuterClass.class */
public final class MusicBeatmapListOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016MusicBeatmapList.proto\u001a\u0016MusicBeatmapNote.proto\"@\n\u0010MusicBeatmapList\u0012,\n\u0011beatmap_note_list\u0018\u0001 \u0003(\u000b2\u0011.MusicBeatmapNoteB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MusicBeatmapNoteOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MusicBeatmapList_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MusicBeatmapList_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MusicBeatmapList_descriptor, new String[]{"BeatmapNoteList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicBeatmapListOuterClass$MusicBeatmapListOrBuilder.class */
    public interface MusicBeatmapListOrBuilder extends MessageOrBuilder {
        List<MusicBeatmapNoteOuterClass.MusicBeatmapNote> getBeatmapNoteListList();

        MusicBeatmapNoteOuterClass.MusicBeatmapNote getBeatmapNoteList(int i);

        int getBeatmapNoteListCount();

        List<? extends MusicBeatmapNoteOuterClass.MusicBeatmapNoteOrBuilder> getBeatmapNoteListOrBuilderList();

        MusicBeatmapNoteOuterClass.MusicBeatmapNoteOrBuilder getBeatmapNoteListOrBuilder(int i);
    }

    private MusicBeatmapListOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicBeatmapListOuterClass$MusicBeatmapList.class */
    public static final class MusicBeatmapList extends GeneratedMessageV3 implements MusicBeatmapListOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BEATMAP_NOTE_LIST_FIELD_NUMBER = 1;
        private List<MusicBeatmapNoteOuterClass.MusicBeatmapNote> beatmapNoteList_;
        private byte memoizedIsInitialized;
        private static final MusicBeatmapList DEFAULT_INSTANCE = new MusicBeatmapList();
        private static final Parser<MusicBeatmapList> PARSER = new AbstractParser<MusicBeatmapList>() { // from class: emu.grasscutter.net.proto.MusicBeatmapListOuterClass.MusicBeatmapList.1
            @Override // com.google.protobuf.Parser
            public MusicBeatmapList parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MusicBeatmapList(input, extensionRegistry);
            }
        };

        private MusicBeatmapList(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MusicBeatmapList() {
            this.memoizedIsInitialized = -1;
            this.beatmapNoteList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MusicBeatmapList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MusicBeatmapList(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 10:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.beatmapNoteList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.beatmapNoteList_.add((MusicBeatmapNoteOuterClass.MusicBeatmapNote) input.readMessage(MusicBeatmapNoteOuterClass.MusicBeatmapNote.parser(), extensionRegistry));
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
                    this.beatmapNoteList_ = Collections.unmodifiableList(this.beatmapNoteList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MusicBeatmapListOuterClass.internal_static_MusicBeatmapList_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MusicBeatmapListOuterClass.internal_static_MusicBeatmapList_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicBeatmapList.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MusicBeatmapListOuterClass.MusicBeatmapListOrBuilder
        public List<MusicBeatmapNoteOuterClass.MusicBeatmapNote> getBeatmapNoteListList() {
            return this.beatmapNoteList_;
        }

        @Override // emu.grasscutter.net.proto.MusicBeatmapListOuterClass.MusicBeatmapListOrBuilder
        public List<? extends MusicBeatmapNoteOuterClass.MusicBeatmapNoteOrBuilder> getBeatmapNoteListOrBuilderList() {
            return this.beatmapNoteList_;
        }

        @Override // emu.grasscutter.net.proto.MusicBeatmapListOuterClass.MusicBeatmapListOrBuilder
        public int getBeatmapNoteListCount() {
            return this.beatmapNoteList_.size();
        }

        @Override // emu.grasscutter.net.proto.MusicBeatmapListOuterClass.MusicBeatmapListOrBuilder
        public MusicBeatmapNoteOuterClass.MusicBeatmapNote getBeatmapNoteList(int index) {
            return this.beatmapNoteList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MusicBeatmapListOuterClass.MusicBeatmapListOrBuilder
        public MusicBeatmapNoteOuterClass.MusicBeatmapNoteOrBuilder getBeatmapNoteListOrBuilder(int index) {
            return this.beatmapNoteList_.get(index);
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
            for (int i = 0; i < this.beatmapNoteList_.size(); i++) {
                output.writeMessage(1, this.beatmapNoteList_.get(i));
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
            for (int i = 0; i < this.beatmapNoteList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.beatmapNoteList_.get(i));
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
            if (!(obj instanceof MusicBeatmapList)) {
                return equals(obj);
            }
            MusicBeatmapList other = (MusicBeatmapList) obj;
            return getBeatmapNoteListList().equals(other.getBeatmapNoteListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getBeatmapNoteListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getBeatmapNoteListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MusicBeatmapList parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicBeatmapList parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicBeatmapList parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicBeatmapList parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicBeatmapList parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicBeatmapList parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicBeatmapList parseFrom(InputStream input) throws IOException {
            return (MusicBeatmapList) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicBeatmapList parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicBeatmapList) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicBeatmapList parseDelimitedFrom(InputStream input) throws IOException {
            return (MusicBeatmapList) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MusicBeatmapList parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicBeatmapList) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicBeatmapList parseFrom(CodedInputStream input) throws IOException {
            return (MusicBeatmapList) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicBeatmapList parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicBeatmapList) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MusicBeatmapList prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicBeatmapListOuterClass$MusicBeatmapList$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MusicBeatmapListOrBuilder {
            private int bitField0_;
            private List<MusicBeatmapNoteOuterClass.MusicBeatmapNote> beatmapNoteList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<MusicBeatmapNoteOuterClass.MusicBeatmapNote, MusicBeatmapNoteOuterClass.MusicBeatmapNote.Builder, MusicBeatmapNoteOuterClass.MusicBeatmapNoteOrBuilder> beatmapNoteListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MusicBeatmapListOuterClass.internal_static_MusicBeatmapList_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MusicBeatmapListOuterClass.internal_static_MusicBeatmapList_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicBeatmapList.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MusicBeatmapList.alwaysUseFieldBuilders) {
                    getBeatmapNoteListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.beatmapNoteListBuilder_ == null) {
                    this.beatmapNoteList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.beatmapNoteListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MusicBeatmapListOuterClass.internal_static_MusicBeatmapList_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MusicBeatmapList getDefaultInstanceForType() {
                return MusicBeatmapList.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicBeatmapList build() {
                MusicBeatmapList result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicBeatmapList buildPartial() {
                MusicBeatmapList result = new MusicBeatmapList(this);
                int i = this.bitField0_;
                if (this.beatmapNoteListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.beatmapNoteList_ = Collections.unmodifiableList(this.beatmapNoteList_);
                        this.bitField0_ &= -2;
                    }
                    result.beatmapNoteList_ = this.beatmapNoteList_;
                } else {
                    result.beatmapNoteList_ = this.beatmapNoteListBuilder_.build();
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
                if (other instanceof MusicBeatmapList) {
                    return mergeFrom((MusicBeatmapList) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MusicBeatmapList other) {
                if (other == MusicBeatmapList.getDefaultInstance()) {
                    return this;
                }
                if (this.beatmapNoteListBuilder_ == null) {
                    if (!other.beatmapNoteList_.isEmpty()) {
                        if (this.beatmapNoteList_.isEmpty()) {
                            this.beatmapNoteList_ = other.beatmapNoteList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureBeatmapNoteListIsMutable();
                            this.beatmapNoteList_.addAll(other.beatmapNoteList_);
                        }
                        onChanged();
                    }
                } else if (!other.beatmapNoteList_.isEmpty()) {
                    if (this.beatmapNoteListBuilder_.isEmpty()) {
                        this.beatmapNoteListBuilder_.dispose();
                        this.beatmapNoteListBuilder_ = null;
                        this.beatmapNoteList_ = other.beatmapNoteList_;
                        this.bitField0_ &= -2;
                        this.beatmapNoteListBuilder_ = MusicBeatmapList.alwaysUseFieldBuilders ? getBeatmapNoteListFieldBuilder() : null;
                    } else {
                        this.beatmapNoteListBuilder_.addAllMessages(other.beatmapNoteList_);
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
                MusicBeatmapList parsedMessage = null;
                try {
                    try {
                        parsedMessage = MusicBeatmapList.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MusicBeatmapList) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureBeatmapNoteListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.beatmapNoteList_ = new ArrayList(this.beatmapNoteList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.MusicBeatmapListOuterClass.MusicBeatmapListOrBuilder
            public List<MusicBeatmapNoteOuterClass.MusicBeatmapNote> getBeatmapNoteListList() {
                if (this.beatmapNoteListBuilder_ == null) {
                    return Collections.unmodifiableList(this.beatmapNoteList_);
                }
                return this.beatmapNoteListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.MusicBeatmapListOuterClass.MusicBeatmapListOrBuilder
            public int getBeatmapNoteListCount() {
                if (this.beatmapNoteListBuilder_ == null) {
                    return this.beatmapNoteList_.size();
                }
                return this.beatmapNoteListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.MusicBeatmapListOuterClass.MusicBeatmapListOrBuilder
            public MusicBeatmapNoteOuterClass.MusicBeatmapNote getBeatmapNoteList(int index) {
                if (this.beatmapNoteListBuilder_ == null) {
                    return this.beatmapNoteList_.get(index);
                }
                return this.beatmapNoteListBuilder_.getMessage(index);
            }

            public Builder setBeatmapNoteList(int index, MusicBeatmapNoteOuterClass.MusicBeatmapNote value) {
                if (this.beatmapNoteListBuilder_ != null) {
                    this.beatmapNoteListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBeatmapNoteListIsMutable();
                    this.beatmapNoteList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setBeatmapNoteList(int index, MusicBeatmapNoteOuterClass.MusicBeatmapNote.Builder builderForValue) {
                if (this.beatmapNoteListBuilder_ == null) {
                    ensureBeatmapNoteListIsMutable();
                    this.beatmapNoteList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.beatmapNoteListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addBeatmapNoteList(MusicBeatmapNoteOuterClass.MusicBeatmapNote value) {
                if (this.beatmapNoteListBuilder_ != null) {
                    this.beatmapNoteListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBeatmapNoteListIsMutable();
                    this.beatmapNoteList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addBeatmapNoteList(int index, MusicBeatmapNoteOuterClass.MusicBeatmapNote value) {
                if (this.beatmapNoteListBuilder_ != null) {
                    this.beatmapNoteListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBeatmapNoteListIsMutable();
                    this.beatmapNoteList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addBeatmapNoteList(MusicBeatmapNoteOuterClass.MusicBeatmapNote.Builder builderForValue) {
                if (this.beatmapNoteListBuilder_ == null) {
                    ensureBeatmapNoteListIsMutable();
                    this.beatmapNoteList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.beatmapNoteListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addBeatmapNoteList(int index, MusicBeatmapNoteOuterClass.MusicBeatmapNote.Builder builderForValue) {
                if (this.beatmapNoteListBuilder_ == null) {
                    ensureBeatmapNoteListIsMutable();
                    this.beatmapNoteList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.beatmapNoteListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllBeatmapNoteList(Iterable<? extends MusicBeatmapNoteOuterClass.MusicBeatmapNote> values) {
                if (this.beatmapNoteListBuilder_ == null) {
                    ensureBeatmapNoteListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.beatmapNoteList_);
                    onChanged();
                } else {
                    this.beatmapNoteListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearBeatmapNoteList() {
                if (this.beatmapNoteListBuilder_ == null) {
                    this.beatmapNoteList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.beatmapNoteListBuilder_.clear();
                }
                return this;
            }

            public Builder removeBeatmapNoteList(int index) {
                if (this.beatmapNoteListBuilder_ == null) {
                    ensureBeatmapNoteListIsMutable();
                    this.beatmapNoteList_.remove(index);
                    onChanged();
                } else {
                    this.beatmapNoteListBuilder_.remove(index);
                }
                return this;
            }

            public MusicBeatmapNoteOuterClass.MusicBeatmapNote.Builder getBeatmapNoteListBuilder(int index) {
                return getBeatmapNoteListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MusicBeatmapListOuterClass.MusicBeatmapListOrBuilder
            public MusicBeatmapNoteOuterClass.MusicBeatmapNoteOrBuilder getBeatmapNoteListOrBuilder(int index) {
                if (this.beatmapNoteListBuilder_ == null) {
                    return this.beatmapNoteList_.get(index);
                }
                return this.beatmapNoteListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MusicBeatmapListOuterClass.MusicBeatmapListOrBuilder
            public List<? extends MusicBeatmapNoteOuterClass.MusicBeatmapNoteOrBuilder> getBeatmapNoteListOrBuilderList() {
                if (this.beatmapNoteListBuilder_ != null) {
                    return this.beatmapNoteListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.beatmapNoteList_);
            }

            public MusicBeatmapNoteOuterClass.MusicBeatmapNote.Builder addBeatmapNoteListBuilder() {
                return getBeatmapNoteListFieldBuilder().addBuilder(MusicBeatmapNoteOuterClass.MusicBeatmapNote.getDefaultInstance());
            }

            public MusicBeatmapNoteOuterClass.MusicBeatmapNote.Builder addBeatmapNoteListBuilder(int index) {
                return getBeatmapNoteListFieldBuilder().addBuilder(index, MusicBeatmapNoteOuterClass.MusicBeatmapNote.getDefaultInstance());
            }

            public List<MusicBeatmapNoteOuterClass.MusicBeatmapNote.Builder> getBeatmapNoteListBuilderList() {
                return getBeatmapNoteListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<MusicBeatmapNoteOuterClass.MusicBeatmapNote, MusicBeatmapNoteOuterClass.MusicBeatmapNote.Builder, MusicBeatmapNoteOuterClass.MusicBeatmapNoteOrBuilder> getBeatmapNoteListFieldBuilder() {
                if (this.beatmapNoteListBuilder_ == null) {
                    this.beatmapNoteListBuilder_ = new RepeatedFieldBuilderV3<>(this.beatmapNoteList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.beatmapNoteList_ = null;
                }
                return this.beatmapNoteListBuilder_;
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

        public static MusicBeatmapList getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MusicBeatmapList> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MusicBeatmapList> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MusicBeatmapList getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MusicBeatmapNoteOuterClass.getDescriptor();
    }
}
