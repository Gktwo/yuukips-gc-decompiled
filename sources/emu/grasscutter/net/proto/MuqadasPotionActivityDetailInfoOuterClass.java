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
import emu.grasscutter.net.proto.MuqadasPotionLevelDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MuqadasPotionActivityDetailInfoOuterClass.class */
public final class MuqadasPotionActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n%MuqadasPotionActivityDetailInfo.proto\u001a\u001cMuqadasPotionLevelData.proto\"b\n\u001fMuqadasPotionActivityDetailInfo\u0012?\n\u001emuqadas_potion_level_data_list\u0018\u0005 \u0003(\u000b2\u0017.MuqadasPotionLevelDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MuqadasPotionLevelDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MuqadasPotionActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_MuqadasPotionActivityDetailInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f805x4e2a0cbc = new GeneratedMessageV3.FieldAccessorTable(internal_static_MuqadasPotionActivityDetailInfo_descriptor, new String[]{"MuqadasPotionLevelDataList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MuqadasPotionActivityDetailInfoOuterClass$MuqadasPotionActivityDetailInfoOrBuilder.class */
    public interface MuqadasPotionActivityDetailInfoOrBuilder extends MessageOrBuilder {
        List<MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData> getMuqadasPotionLevelDataListList();

        MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData getMuqadasPotionLevelDataList(int i);

        int getMuqadasPotionLevelDataListCount();

        List<? extends MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelDataOrBuilder> getMuqadasPotionLevelDataListOrBuilderList();

        MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelDataOrBuilder getMuqadasPotionLevelDataListOrBuilder(int i);
    }

    private MuqadasPotionActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MuqadasPotionActivityDetailInfoOuterClass$MuqadasPotionActivityDetailInfo.class */
    public static final class MuqadasPotionActivityDetailInfo extends GeneratedMessageV3 implements MuqadasPotionActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MUQADAS_POTION_LEVEL_DATA_LIST_FIELD_NUMBER = 5;
        private List<MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData> muqadasPotionLevelDataList_;
        private byte memoizedIsInitialized;
        private static final MuqadasPotionActivityDetailInfo DEFAULT_INSTANCE = new MuqadasPotionActivityDetailInfo();
        private static final Parser<MuqadasPotionActivityDetailInfo> PARSER = new AbstractParser<MuqadasPotionActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public MuqadasPotionActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MuqadasPotionActivityDetailInfo(input, extensionRegistry);
            }
        };

        private MuqadasPotionActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MuqadasPotionActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.muqadasPotionLevelDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MuqadasPotionActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MuqadasPotionActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 42:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.muqadasPotionLevelDataList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.muqadasPotionLevelDataList_.add((MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData) input.readMessage(MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData.parser(), extensionRegistry));
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
                    this.muqadasPotionLevelDataList_ = Collections.unmodifiableList(this.muqadasPotionLevelDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MuqadasPotionActivityDetailInfoOuterClass.internal_static_MuqadasPotionActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MuqadasPotionActivityDetailInfoOuterClass.f805x4e2a0cbc.ensureFieldAccessorsInitialized(MuqadasPotionActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfoOrBuilder
        public List<MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData> getMuqadasPotionLevelDataListList() {
            return this.muqadasPotionLevelDataList_;
        }

        @Override // emu.grasscutter.net.proto.MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfoOrBuilder
        public List<? extends MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelDataOrBuilder> getMuqadasPotionLevelDataListOrBuilderList() {
            return this.muqadasPotionLevelDataList_;
        }

        @Override // emu.grasscutter.net.proto.MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfoOrBuilder
        public int getMuqadasPotionLevelDataListCount() {
            return this.muqadasPotionLevelDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfoOrBuilder
        public MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData getMuqadasPotionLevelDataList(int index) {
            return this.muqadasPotionLevelDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfoOrBuilder
        public MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelDataOrBuilder getMuqadasPotionLevelDataListOrBuilder(int index) {
            return this.muqadasPotionLevelDataList_.get(index);
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
            for (int i = 0; i < this.muqadasPotionLevelDataList_.size(); i++) {
                output.writeMessage(5, this.muqadasPotionLevelDataList_.get(i));
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
            for (int i = 0; i < this.muqadasPotionLevelDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.muqadasPotionLevelDataList_.get(i));
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
            if (!(obj instanceof MuqadasPotionActivityDetailInfo)) {
                return equals(obj);
            }
            MuqadasPotionActivityDetailInfo other = (MuqadasPotionActivityDetailInfo) obj;
            return getMuqadasPotionLevelDataListList().equals(other.getMuqadasPotionLevelDataListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getMuqadasPotionLevelDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getMuqadasPotionLevelDataListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MuqadasPotionActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MuqadasPotionActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MuqadasPotionActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MuqadasPotionActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MuqadasPotionActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MuqadasPotionActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MuqadasPotionActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (MuqadasPotionActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MuqadasPotionActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MuqadasPotionActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MuqadasPotionActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (MuqadasPotionActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MuqadasPotionActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MuqadasPotionActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MuqadasPotionActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (MuqadasPotionActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MuqadasPotionActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MuqadasPotionActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MuqadasPotionActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MuqadasPotionActivityDetailInfoOuterClass$MuqadasPotionActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MuqadasPotionActivityDetailInfoOrBuilder {
            private int bitField0_;
            private List<MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData> muqadasPotionLevelDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData, MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData.Builder, MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelDataOrBuilder> muqadasPotionLevelDataListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MuqadasPotionActivityDetailInfoOuterClass.internal_static_MuqadasPotionActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MuqadasPotionActivityDetailInfoOuterClass.f805x4e2a0cbc.ensureFieldAccessorsInitialized(MuqadasPotionActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MuqadasPotionActivityDetailInfo.alwaysUseFieldBuilders) {
                    getMuqadasPotionLevelDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.muqadasPotionLevelDataListBuilder_ == null) {
                    this.muqadasPotionLevelDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.muqadasPotionLevelDataListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MuqadasPotionActivityDetailInfoOuterClass.internal_static_MuqadasPotionActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MuqadasPotionActivityDetailInfo getDefaultInstanceForType() {
                return MuqadasPotionActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MuqadasPotionActivityDetailInfo build() {
                MuqadasPotionActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MuqadasPotionActivityDetailInfo buildPartial() {
                MuqadasPotionActivityDetailInfo result = new MuqadasPotionActivityDetailInfo(this);
                int i = this.bitField0_;
                if (this.muqadasPotionLevelDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.muqadasPotionLevelDataList_ = Collections.unmodifiableList(this.muqadasPotionLevelDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.muqadasPotionLevelDataList_ = this.muqadasPotionLevelDataList_;
                } else {
                    result.muqadasPotionLevelDataList_ = this.muqadasPotionLevelDataListBuilder_.build();
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
                if (other instanceof MuqadasPotionActivityDetailInfo) {
                    return mergeFrom((MuqadasPotionActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MuqadasPotionActivityDetailInfo other) {
                if (other == MuqadasPotionActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.muqadasPotionLevelDataListBuilder_ == null) {
                    if (!other.muqadasPotionLevelDataList_.isEmpty()) {
                        if (this.muqadasPotionLevelDataList_.isEmpty()) {
                            this.muqadasPotionLevelDataList_ = other.muqadasPotionLevelDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureMuqadasPotionLevelDataListIsMutable();
                            this.muqadasPotionLevelDataList_.addAll(other.muqadasPotionLevelDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.muqadasPotionLevelDataList_.isEmpty()) {
                    if (this.muqadasPotionLevelDataListBuilder_.isEmpty()) {
                        this.muqadasPotionLevelDataListBuilder_.dispose();
                        this.muqadasPotionLevelDataListBuilder_ = null;
                        this.muqadasPotionLevelDataList_ = other.muqadasPotionLevelDataList_;
                        this.bitField0_ &= -2;
                        this.muqadasPotionLevelDataListBuilder_ = MuqadasPotionActivityDetailInfo.alwaysUseFieldBuilders ? getMuqadasPotionLevelDataListFieldBuilder() : null;
                    } else {
                        this.muqadasPotionLevelDataListBuilder_.addAllMessages(other.muqadasPotionLevelDataList_);
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
                MuqadasPotionActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = MuqadasPotionActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MuqadasPotionActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureMuqadasPotionLevelDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.muqadasPotionLevelDataList_ = new ArrayList(this.muqadasPotionLevelDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfoOrBuilder
            public List<MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData> getMuqadasPotionLevelDataListList() {
                if (this.muqadasPotionLevelDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.muqadasPotionLevelDataList_);
                }
                return this.muqadasPotionLevelDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfoOrBuilder
            public int getMuqadasPotionLevelDataListCount() {
                if (this.muqadasPotionLevelDataListBuilder_ == null) {
                    return this.muqadasPotionLevelDataList_.size();
                }
                return this.muqadasPotionLevelDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfoOrBuilder
            public MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData getMuqadasPotionLevelDataList(int index) {
                if (this.muqadasPotionLevelDataListBuilder_ == null) {
                    return this.muqadasPotionLevelDataList_.get(index);
                }
                return this.muqadasPotionLevelDataListBuilder_.getMessage(index);
            }

            public Builder setMuqadasPotionLevelDataList(int index, MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData value) {
                if (this.muqadasPotionLevelDataListBuilder_ != null) {
                    this.muqadasPotionLevelDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMuqadasPotionLevelDataListIsMutable();
                    this.muqadasPotionLevelDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMuqadasPotionLevelDataList(int index, MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData.Builder builderForValue) {
                if (this.muqadasPotionLevelDataListBuilder_ == null) {
                    ensureMuqadasPotionLevelDataListIsMutable();
                    this.muqadasPotionLevelDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.muqadasPotionLevelDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMuqadasPotionLevelDataList(MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData value) {
                if (this.muqadasPotionLevelDataListBuilder_ != null) {
                    this.muqadasPotionLevelDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMuqadasPotionLevelDataListIsMutable();
                    this.muqadasPotionLevelDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMuqadasPotionLevelDataList(int index, MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData value) {
                if (this.muqadasPotionLevelDataListBuilder_ != null) {
                    this.muqadasPotionLevelDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMuqadasPotionLevelDataListIsMutable();
                    this.muqadasPotionLevelDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMuqadasPotionLevelDataList(MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData.Builder builderForValue) {
                if (this.muqadasPotionLevelDataListBuilder_ == null) {
                    ensureMuqadasPotionLevelDataListIsMutable();
                    this.muqadasPotionLevelDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.muqadasPotionLevelDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMuqadasPotionLevelDataList(int index, MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData.Builder builderForValue) {
                if (this.muqadasPotionLevelDataListBuilder_ == null) {
                    ensureMuqadasPotionLevelDataListIsMutable();
                    this.muqadasPotionLevelDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.muqadasPotionLevelDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMuqadasPotionLevelDataList(Iterable<? extends MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData> values) {
                if (this.muqadasPotionLevelDataListBuilder_ == null) {
                    ensureMuqadasPotionLevelDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.muqadasPotionLevelDataList_);
                    onChanged();
                } else {
                    this.muqadasPotionLevelDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMuqadasPotionLevelDataList() {
                if (this.muqadasPotionLevelDataListBuilder_ == null) {
                    this.muqadasPotionLevelDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.muqadasPotionLevelDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeMuqadasPotionLevelDataList(int index) {
                if (this.muqadasPotionLevelDataListBuilder_ == null) {
                    ensureMuqadasPotionLevelDataListIsMutable();
                    this.muqadasPotionLevelDataList_.remove(index);
                    onChanged();
                } else {
                    this.muqadasPotionLevelDataListBuilder_.remove(index);
                }
                return this;
            }

            public MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData.Builder getMuqadasPotionLevelDataListBuilder(int index) {
                return getMuqadasPotionLevelDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfoOrBuilder
            public MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelDataOrBuilder getMuqadasPotionLevelDataListOrBuilder(int index) {
                if (this.muqadasPotionLevelDataListBuilder_ == null) {
                    return this.muqadasPotionLevelDataList_.get(index);
                }
                return this.muqadasPotionLevelDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfoOrBuilder
            public List<? extends MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelDataOrBuilder> getMuqadasPotionLevelDataListOrBuilderList() {
                if (this.muqadasPotionLevelDataListBuilder_ != null) {
                    return this.muqadasPotionLevelDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.muqadasPotionLevelDataList_);
            }

            public MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData.Builder addMuqadasPotionLevelDataListBuilder() {
                return getMuqadasPotionLevelDataListFieldBuilder().addBuilder(MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData.getDefaultInstance());
            }

            public MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData.Builder addMuqadasPotionLevelDataListBuilder(int index) {
                return getMuqadasPotionLevelDataListFieldBuilder().addBuilder(index, MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData.getDefaultInstance());
            }

            public List<MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData.Builder> getMuqadasPotionLevelDataListBuilderList() {
                return getMuqadasPotionLevelDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData, MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelData.Builder, MuqadasPotionLevelDataOuterClass.MuqadasPotionLevelDataOrBuilder> getMuqadasPotionLevelDataListFieldBuilder() {
                if (this.muqadasPotionLevelDataListBuilder_ == null) {
                    this.muqadasPotionLevelDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.muqadasPotionLevelDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.muqadasPotionLevelDataList_ = null;
                }
                return this.muqadasPotionLevelDataListBuilder_;
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

        public static MuqadasPotionActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MuqadasPotionActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MuqadasPotionActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MuqadasPotionActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MuqadasPotionLevelDataOuterClass.getDescriptor();
    }
}
