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
import emu.grasscutter.net.proto.GravenInnocenceRaceLevelInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocenceRaceInfoOuterClass.class */
public final class GravenInnocenceRaceInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dGravenInnocenceRaceInfo.proto\u001a\"GravenInnocenceRaceLevelInfo.proto\"Q\n\u0017GravenInnocenceRaceInfo\u00126\n\u000flevel_info_list\u0018\t \u0003(\u000b2\u001d.GravenInnocenceRaceLevelInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{GravenInnocenceRaceLevelInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GravenInnocenceRaceInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GravenInnocenceRaceInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GravenInnocenceRaceInfo_descriptor, new String[]{"LevelInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocenceRaceInfoOuterClass$GravenInnocenceRaceInfoOrBuilder.class */
    public interface GravenInnocenceRaceInfoOrBuilder extends MessageOrBuilder {
        List<GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo> getLevelInfoListList();

        GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo getLevelInfoList(int i);

        int getLevelInfoListCount();

        List<? extends GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfoOrBuilder> getLevelInfoListOrBuilderList();

        GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfoOrBuilder getLevelInfoListOrBuilder(int i);
    }

    private GravenInnocenceRaceInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocenceRaceInfoOuterClass$GravenInnocenceRaceInfo.class */
    public static final class GravenInnocenceRaceInfo extends GeneratedMessageV3 implements GravenInnocenceRaceInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LEVEL_INFO_LIST_FIELD_NUMBER = 9;
        private List<GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo> levelInfoList_;
        private byte memoizedIsInitialized;
        private static final GravenInnocenceRaceInfo DEFAULT_INSTANCE = new GravenInnocenceRaceInfo();
        private static final Parser<GravenInnocenceRaceInfo> PARSER = new AbstractParser<GravenInnocenceRaceInfo>() { // from class: emu.grasscutter.net.proto.GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo.1
            @Override // com.google.protobuf.Parser
            public GravenInnocenceRaceInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GravenInnocenceRaceInfo(input, extensionRegistry);
            }
        };

        private GravenInnocenceRaceInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GravenInnocenceRaceInfo() {
            this.memoizedIsInitialized = -1;
            this.levelInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GravenInnocenceRaceInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GravenInnocenceRaceInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 74:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.levelInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.levelInfoList_.add((GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo) input.readMessage(GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo.parser(), extensionRegistry));
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
                    this.levelInfoList_ = Collections.unmodifiableList(this.levelInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GravenInnocenceRaceInfoOuterClass.internal_static_GravenInnocenceRaceInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GravenInnocenceRaceInfoOuterClass.internal_static_GravenInnocenceRaceInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GravenInnocenceRaceInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfoOrBuilder
        public List<GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo> getLevelInfoListList() {
            return this.levelInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfoOrBuilder
        public List<? extends GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfoOrBuilder> getLevelInfoListOrBuilderList() {
            return this.levelInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfoOrBuilder
        public int getLevelInfoListCount() {
            return this.levelInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfoOrBuilder
        public GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo getLevelInfoList(int index) {
            return this.levelInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfoOrBuilder
        public GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfoOrBuilder getLevelInfoListOrBuilder(int index) {
            return this.levelInfoList_.get(index);
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
            for (int i = 0; i < this.levelInfoList_.size(); i++) {
                output.writeMessage(9, this.levelInfoList_.get(i));
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
            for (int i = 0; i < this.levelInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(9, this.levelInfoList_.get(i));
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
            if (!(obj instanceof GravenInnocenceRaceInfo)) {
                return equals(obj);
            }
            GravenInnocenceRaceInfo other = (GravenInnocenceRaceInfo) obj;
            return getLevelInfoListList().equals(other.getLevelInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getLevelInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getLevelInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GravenInnocenceRaceInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GravenInnocenceRaceInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GravenInnocenceRaceInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GravenInnocenceRaceInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GravenInnocenceRaceInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GravenInnocenceRaceInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GravenInnocenceRaceInfo parseFrom(InputStream input) throws IOException {
            return (GravenInnocenceRaceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GravenInnocenceRaceInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GravenInnocenceRaceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GravenInnocenceRaceInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (GravenInnocenceRaceInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GravenInnocenceRaceInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GravenInnocenceRaceInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GravenInnocenceRaceInfo parseFrom(CodedInputStream input) throws IOException {
            return (GravenInnocenceRaceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GravenInnocenceRaceInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GravenInnocenceRaceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GravenInnocenceRaceInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocenceRaceInfoOuterClass$GravenInnocenceRaceInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GravenInnocenceRaceInfoOrBuilder {
            private int bitField0_;
            private List<GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo> levelInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo, GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo.Builder, GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfoOrBuilder> levelInfoListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GravenInnocenceRaceInfoOuterClass.internal_static_GravenInnocenceRaceInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GravenInnocenceRaceInfoOuterClass.internal_static_GravenInnocenceRaceInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GravenInnocenceRaceInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GravenInnocenceRaceInfo.alwaysUseFieldBuilders) {
                    getLevelInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.levelInfoListBuilder_ == null) {
                    this.levelInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.levelInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GravenInnocenceRaceInfoOuterClass.internal_static_GravenInnocenceRaceInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GravenInnocenceRaceInfo getDefaultInstanceForType() {
                return GravenInnocenceRaceInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GravenInnocenceRaceInfo build() {
                GravenInnocenceRaceInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GravenInnocenceRaceInfo buildPartial() {
                GravenInnocenceRaceInfo result = new GravenInnocenceRaceInfo(this);
                int i = this.bitField0_;
                if (this.levelInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.levelInfoList_ = Collections.unmodifiableList(this.levelInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.levelInfoList_ = this.levelInfoList_;
                } else {
                    result.levelInfoList_ = this.levelInfoListBuilder_.build();
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
                if (other instanceof GravenInnocenceRaceInfo) {
                    return mergeFrom((GravenInnocenceRaceInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GravenInnocenceRaceInfo other) {
                if (other == GravenInnocenceRaceInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.levelInfoListBuilder_ == null) {
                    if (!other.levelInfoList_.isEmpty()) {
                        if (this.levelInfoList_.isEmpty()) {
                            this.levelInfoList_ = other.levelInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureLevelInfoListIsMutable();
                            this.levelInfoList_.addAll(other.levelInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.levelInfoList_.isEmpty()) {
                    if (this.levelInfoListBuilder_.isEmpty()) {
                        this.levelInfoListBuilder_.dispose();
                        this.levelInfoListBuilder_ = null;
                        this.levelInfoList_ = other.levelInfoList_;
                        this.bitField0_ &= -2;
                        this.levelInfoListBuilder_ = GravenInnocenceRaceInfo.alwaysUseFieldBuilders ? getLevelInfoListFieldBuilder() : null;
                    } else {
                        this.levelInfoListBuilder_.addAllMessages(other.levelInfoList_);
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
                GravenInnocenceRaceInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = GravenInnocenceRaceInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GravenInnocenceRaceInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureLevelInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.levelInfoList_ = new ArrayList(this.levelInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfoOrBuilder
            public List<GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo> getLevelInfoListList() {
                if (this.levelInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.levelInfoList_);
                }
                return this.levelInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfoOrBuilder
            public int getLevelInfoListCount() {
                if (this.levelInfoListBuilder_ == null) {
                    return this.levelInfoList_.size();
                }
                return this.levelInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfoOrBuilder
            public GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo getLevelInfoList(int index) {
                if (this.levelInfoListBuilder_ == null) {
                    return this.levelInfoList_.get(index);
                }
                return this.levelInfoListBuilder_.getMessage(index);
            }

            public Builder setLevelInfoList(int index, GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo value) {
                if (this.levelInfoListBuilder_ != null) {
                    this.levelInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLevelInfoListIsMutable();
                    this.levelInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setLevelInfoList(int index, GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo.Builder builderForValue) {
                if (this.levelInfoListBuilder_ == null) {
                    ensureLevelInfoListIsMutable();
                    this.levelInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.levelInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addLevelInfoList(GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo value) {
                if (this.levelInfoListBuilder_ != null) {
                    this.levelInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLevelInfoListIsMutable();
                    this.levelInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addLevelInfoList(int index, GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo value) {
                if (this.levelInfoListBuilder_ != null) {
                    this.levelInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLevelInfoListIsMutable();
                    this.levelInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addLevelInfoList(GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo.Builder builderForValue) {
                if (this.levelInfoListBuilder_ == null) {
                    ensureLevelInfoListIsMutable();
                    this.levelInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.levelInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addLevelInfoList(int index, GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo.Builder builderForValue) {
                if (this.levelInfoListBuilder_ == null) {
                    ensureLevelInfoListIsMutable();
                    this.levelInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.levelInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllLevelInfoList(Iterable<? extends GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo> values) {
                if (this.levelInfoListBuilder_ == null) {
                    ensureLevelInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.levelInfoList_);
                    onChanged();
                } else {
                    this.levelInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearLevelInfoList() {
                if (this.levelInfoListBuilder_ == null) {
                    this.levelInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.levelInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeLevelInfoList(int index) {
                if (this.levelInfoListBuilder_ == null) {
                    ensureLevelInfoListIsMutable();
                    this.levelInfoList_.remove(index);
                    onChanged();
                } else {
                    this.levelInfoListBuilder_.remove(index);
                }
                return this;
            }

            public GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo.Builder getLevelInfoListBuilder(int index) {
                return getLevelInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfoOrBuilder
            public GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfoOrBuilder getLevelInfoListOrBuilder(int index) {
                if (this.levelInfoListBuilder_ == null) {
                    return this.levelInfoList_.get(index);
                }
                return this.levelInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfoOrBuilder
            public List<? extends GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfoOrBuilder> getLevelInfoListOrBuilderList() {
                if (this.levelInfoListBuilder_ != null) {
                    return this.levelInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.levelInfoList_);
            }

            public GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo.Builder addLevelInfoListBuilder() {
                return getLevelInfoListFieldBuilder().addBuilder(GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo.getDefaultInstance());
            }

            public GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo.Builder addLevelInfoListBuilder(int index) {
                return getLevelInfoListFieldBuilder().addBuilder(index, GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo.getDefaultInstance());
            }

            public List<GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo.Builder> getLevelInfoListBuilderList() {
                return getLevelInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo, GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfo.Builder, GravenInnocenceRaceLevelInfoOuterClass.GravenInnocenceRaceLevelInfoOrBuilder> getLevelInfoListFieldBuilder() {
                if (this.levelInfoListBuilder_ == null) {
                    this.levelInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.levelInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.levelInfoList_ = null;
                }
                return this.levelInfoListBuilder_;
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

        public static GravenInnocenceRaceInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GravenInnocenceRaceInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GravenInnocenceRaceInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GravenInnocenceRaceInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        GravenInnocenceRaceLevelInfoOuterClass.getDescriptor();
    }
}
