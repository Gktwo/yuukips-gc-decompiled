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
import emu.grasscutter.net.proto.MusicBeatmapListOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicBeatmapOuterClass.class */
public final class MusicBeatmapOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012MusicBeatmap.proto\u001a\u0016MusicBeatmapList.proto\"N\n\fMusicBeatmap\u0012\u0010\n\bmusic_id\u0018\u0001 \u0001(\r\u0012,\n\u0011beatmap_item_list\u0018\u0002 \u0003(\u000b2\u0011.MusicBeatmapListB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MusicBeatmapListOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MusicBeatmap_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MusicBeatmap_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MusicBeatmap_descriptor, new String[]{"MusicId", "BeatmapItemList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicBeatmapOuterClass$MusicBeatmapOrBuilder.class */
    public interface MusicBeatmapOrBuilder extends MessageOrBuilder {
        int getMusicId();

        List<MusicBeatmapListOuterClass.MusicBeatmapList> getBeatmapItemListList();

        MusicBeatmapListOuterClass.MusicBeatmapList getBeatmapItemList(int i);

        int getBeatmapItemListCount();

        List<? extends MusicBeatmapListOuterClass.MusicBeatmapListOrBuilder> getBeatmapItemListOrBuilderList();

        MusicBeatmapListOuterClass.MusicBeatmapListOrBuilder getBeatmapItemListOrBuilder(int i);
    }

    private MusicBeatmapOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicBeatmapOuterClass$MusicBeatmap.class */
    public static final class MusicBeatmap extends GeneratedMessageV3 implements MusicBeatmapOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MUSIC_ID_FIELD_NUMBER = 1;
        private int musicId_;
        public static final int BEATMAP_ITEM_LIST_FIELD_NUMBER = 2;
        private List<MusicBeatmapListOuterClass.MusicBeatmapList> beatmapItemList_;
        private byte memoizedIsInitialized;
        private static final MusicBeatmap DEFAULT_INSTANCE = new MusicBeatmap();
        private static final Parser<MusicBeatmap> PARSER = new AbstractParser<MusicBeatmap>() { // from class: emu.grasscutter.net.proto.MusicBeatmapOuterClass.MusicBeatmap.1
            @Override // com.google.protobuf.Parser
            public MusicBeatmap parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MusicBeatmap(input, extensionRegistry);
            }
        };

        private MusicBeatmap(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MusicBeatmap() {
            this.memoizedIsInitialized = -1;
            this.beatmapItemList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MusicBeatmap();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MusicBeatmap(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.musicId_ = input.readUInt32();
                                    break;
                                case 18:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.beatmapItemList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.beatmapItemList_.add((MusicBeatmapListOuterClass.MusicBeatmapList) input.readMessage(MusicBeatmapListOuterClass.MusicBeatmapList.parser(), extensionRegistry));
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
                    this.beatmapItemList_ = Collections.unmodifiableList(this.beatmapItemList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MusicBeatmapOuterClass.internal_static_MusicBeatmap_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MusicBeatmapOuterClass.internal_static_MusicBeatmap_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicBeatmap.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MusicBeatmapOuterClass.MusicBeatmapOrBuilder
        public int getMusicId() {
            return this.musicId_;
        }

        @Override // emu.grasscutter.net.proto.MusicBeatmapOuterClass.MusicBeatmapOrBuilder
        public List<MusicBeatmapListOuterClass.MusicBeatmapList> getBeatmapItemListList() {
            return this.beatmapItemList_;
        }

        @Override // emu.grasscutter.net.proto.MusicBeatmapOuterClass.MusicBeatmapOrBuilder
        public List<? extends MusicBeatmapListOuterClass.MusicBeatmapListOrBuilder> getBeatmapItemListOrBuilderList() {
            return this.beatmapItemList_;
        }

        @Override // emu.grasscutter.net.proto.MusicBeatmapOuterClass.MusicBeatmapOrBuilder
        public int getBeatmapItemListCount() {
            return this.beatmapItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.MusicBeatmapOuterClass.MusicBeatmapOrBuilder
        public MusicBeatmapListOuterClass.MusicBeatmapList getBeatmapItemList(int index) {
            return this.beatmapItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MusicBeatmapOuterClass.MusicBeatmapOrBuilder
        public MusicBeatmapListOuterClass.MusicBeatmapListOrBuilder getBeatmapItemListOrBuilder(int index) {
            return this.beatmapItemList_.get(index);
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
                output.writeUInt32(1, this.musicId_);
            }
            for (int i = 0; i < this.beatmapItemList_.size(); i++) {
                output.writeMessage(2, this.beatmapItemList_.get(i));
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.musicId_);
            }
            for (int i = 0; i < this.beatmapItemList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.beatmapItemList_.get(i));
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
            if (!(obj instanceof MusicBeatmap)) {
                return equals(obj);
            }
            MusicBeatmap other = (MusicBeatmap) obj;
            return getMusicId() == other.getMusicId() && getBeatmapItemListList().equals(other.getBeatmapItemListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getMusicId();
            if (getBeatmapItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getBeatmapItemListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MusicBeatmap parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicBeatmap parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicBeatmap parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicBeatmap parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicBeatmap parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicBeatmap parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicBeatmap parseFrom(InputStream input) throws IOException {
            return (MusicBeatmap) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicBeatmap parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicBeatmap) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicBeatmap parseDelimitedFrom(InputStream input) throws IOException {
            return (MusicBeatmap) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MusicBeatmap parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicBeatmap) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicBeatmap parseFrom(CodedInputStream input) throws IOException {
            return (MusicBeatmap) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicBeatmap parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicBeatmap) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MusicBeatmap prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicBeatmapOuterClass$MusicBeatmap$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MusicBeatmapOrBuilder {
            private int bitField0_;
            private int musicId_;
            private List<MusicBeatmapListOuterClass.MusicBeatmapList> beatmapItemList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<MusicBeatmapListOuterClass.MusicBeatmapList, MusicBeatmapListOuterClass.MusicBeatmapList.Builder, MusicBeatmapListOuterClass.MusicBeatmapListOrBuilder> beatmapItemListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MusicBeatmapOuterClass.internal_static_MusicBeatmap_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MusicBeatmapOuterClass.internal_static_MusicBeatmap_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicBeatmap.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MusicBeatmap.alwaysUseFieldBuilders) {
                    getBeatmapItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.musicId_ = 0;
                if (this.beatmapItemListBuilder_ == null) {
                    this.beatmapItemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.beatmapItemListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MusicBeatmapOuterClass.internal_static_MusicBeatmap_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MusicBeatmap getDefaultInstanceForType() {
                return MusicBeatmap.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicBeatmap build() {
                MusicBeatmap result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicBeatmap buildPartial() {
                MusicBeatmap result = new MusicBeatmap(this);
                int i = this.bitField0_;
                result.musicId_ = this.musicId_;
                if (this.beatmapItemListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.beatmapItemList_ = Collections.unmodifiableList(this.beatmapItemList_);
                        this.bitField0_ &= -2;
                    }
                    result.beatmapItemList_ = this.beatmapItemList_;
                } else {
                    result.beatmapItemList_ = this.beatmapItemListBuilder_.build();
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
                if (other instanceof MusicBeatmap) {
                    return mergeFrom((MusicBeatmap) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MusicBeatmap other) {
                if (other == MusicBeatmap.getDefaultInstance()) {
                    return this;
                }
                if (other.getMusicId() != 0) {
                    setMusicId(other.getMusicId());
                }
                if (this.beatmapItemListBuilder_ == null) {
                    if (!other.beatmapItemList_.isEmpty()) {
                        if (this.beatmapItemList_.isEmpty()) {
                            this.beatmapItemList_ = other.beatmapItemList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureBeatmapItemListIsMutable();
                            this.beatmapItemList_.addAll(other.beatmapItemList_);
                        }
                        onChanged();
                    }
                } else if (!other.beatmapItemList_.isEmpty()) {
                    if (this.beatmapItemListBuilder_.isEmpty()) {
                        this.beatmapItemListBuilder_.dispose();
                        this.beatmapItemListBuilder_ = null;
                        this.beatmapItemList_ = other.beatmapItemList_;
                        this.bitField0_ &= -2;
                        this.beatmapItemListBuilder_ = MusicBeatmap.alwaysUseFieldBuilders ? getBeatmapItemListFieldBuilder() : null;
                    } else {
                        this.beatmapItemListBuilder_.addAllMessages(other.beatmapItemList_);
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
                MusicBeatmap parsedMessage = null;
                try {
                    try {
                        parsedMessage = MusicBeatmap.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MusicBeatmap) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MusicBeatmapOuterClass.MusicBeatmapOrBuilder
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

            private void ensureBeatmapItemListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.beatmapItemList_ = new ArrayList(this.beatmapItemList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.MusicBeatmapOuterClass.MusicBeatmapOrBuilder
            public List<MusicBeatmapListOuterClass.MusicBeatmapList> getBeatmapItemListList() {
                if (this.beatmapItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.beatmapItemList_);
                }
                return this.beatmapItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.MusicBeatmapOuterClass.MusicBeatmapOrBuilder
            public int getBeatmapItemListCount() {
                if (this.beatmapItemListBuilder_ == null) {
                    return this.beatmapItemList_.size();
                }
                return this.beatmapItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.MusicBeatmapOuterClass.MusicBeatmapOrBuilder
            public MusicBeatmapListOuterClass.MusicBeatmapList getBeatmapItemList(int index) {
                if (this.beatmapItemListBuilder_ == null) {
                    return this.beatmapItemList_.get(index);
                }
                return this.beatmapItemListBuilder_.getMessage(index);
            }

            public Builder setBeatmapItemList(int index, MusicBeatmapListOuterClass.MusicBeatmapList value) {
                if (this.beatmapItemListBuilder_ != null) {
                    this.beatmapItemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBeatmapItemListIsMutable();
                    this.beatmapItemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setBeatmapItemList(int index, MusicBeatmapListOuterClass.MusicBeatmapList.Builder builderForValue) {
                if (this.beatmapItemListBuilder_ == null) {
                    ensureBeatmapItemListIsMutable();
                    this.beatmapItemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.beatmapItemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addBeatmapItemList(MusicBeatmapListOuterClass.MusicBeatmapList value) {
                if (this.beatmapItemListBuilder_ != null) {
                    this.beatmapItemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBeatmapItemListIsMutable();
                    this.beatmapItemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addBeatmapItemList(int index, MusicBeatmapListOuterClass.MusicBeatmapList value) {
                if (this.beatmapItemListBuilder_ != null) {
                    this.beatmapItemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBeatmapItemListIsMutable();
                    this.beatmapItemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addBeatmapItemList(MusicBeatmapListOuterClass.MusicBeatmapList.Builder builderForValue) {
                if (this.beatmapItemListBuilder_ == null) {
                    ensureBeatmapItemListIsMutable();
                    this.beatmapItemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.beatmapItemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addBeatmapItemList(int index, MusicBeatmapListOuterClass.MusicBeatmapList.Builder builderForValue) {
                if (this.beatmapItemListBuilder_ == null) {
                    ensureBeatmapItemListIsMutable();
                    this.beatmapItemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.beatmapItemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllBeatmapItemList(Iterable<? extends MusicBeatmapListOuterClass.MusicBeatmapList> values) {
                if (this.beatmapItemListBuilder_ == null) {
                    ensureBeatmapItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.beatmapItemList_);
                    onChanged();
                } else {
                    this.beatmapItemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearBeatmapItemList() {
                if (this.beatmapItemListBuilder_ == null) {
                    this.beatmapItemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.beatmapItemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeBeatmapItemList(int index) {
                if (this.beatmapItemListBuilder_ == null) {
                    ensureBeatmapItemListIsMutable();
                    this.beatmapItemList_.remove(index);
                    onChanged();
                } else {
                    this.beatmapItemListBuilder_.remove(index);
                }
                return this;
            }

            public MusicBeatmapListOuterClass.MusicBeatmapList.Builder getBeatmapItemListBuilder(int index) {
                return getBeatmapItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MusicBeatmapOuterClass.MusicBeatmapOrBuilder
            public MusicBeatmapListOuterClass.MusicBeatmapListOrBuilder getBeatmapItemListOrBuilder(int index) {
                if (this.beatmapItemListBuilder_ == null) {
                    return this.beatmapItemList_.get(index);
                }
                return this.beatmapItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MusicBeatmapOuterClass.MusicBeatmapOrBuilder
            public List<? extends MusicBeatmapListOuterClass.MusicBeatmapListOrBuilder> getBeatmapItemListOrBuilderList() {
                if (this.beatmapItemListBuilder_ != null) {
                    return this.beatmapItemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.beatmapItemList_);
            }

            public MusicBeatmapListOuterClass.MusicBeatmapList.Builder addBeatmapItemListBuilder() {
                return getBeatmapItemListFieldBuilder().addBuilder(MusicBeatmapListOuterClass.MusicBeatmapList.getDefaultInstance());
            }

            public MusicBeatmapListOuterClass.MusicBeatmapList.Builder addBeatmapItemListBuilder(int index) {
                return getBeatmapItemListFieldBuilder().addBuilder(index, MusicBeatmapListOuterClass.MusicBeatmapList.getDefaultInstance());
            }

            public List<MusicBeatmapListOuterClass.MusicBeatmapList.Builder> getBeatmapItemListBuilderList() {
                return getBeatmapItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<MusicBeatmapListOuterClass.MusicBeatmapList, MusicBeatmapListOuterClass.MusicBeatmapList.Builder, MusicBeatmapListOuterClass.MusicBeatmapListOrBuilder> getBeatmapItemListFieldBuilder() {
                if (this.beatmapItemListBuilder_ == null) {
                    this.beatmapItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.beatmapItemList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.beatmapItemList_ = null;
                }
                return this.beatmapItemListBuilder_;
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

        public static MusicBeatmap getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MusicBeatmap> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MusicBeatmap> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MusicBeatmap getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MusicBeatmapListOuterClass.getDescriptor();
    }
}
