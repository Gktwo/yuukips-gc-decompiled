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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.MistTrialBestAvatarOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MistTrialLevelDataOuterClass.class */
public final class MistTrialLevelDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018MistTrialLevelData.proto\u001a\u0019MistTrialBestAvatar.proto\"¹\u0001\n\u0012MistTrialLevelData\u0012\u0010\n\bopenTime\u0018\u0002 \u0001(\r\u0012\u0015\n\rfirstPassTime\u0018\u0004 \u0001(\r\u0012\u000f\n\u0007levelId\u0018\f \u0001(\r\u0012\u000e\n\u0006isOpen\u0018\u0006 \u0001(\b\u0012+\n\rbestHitAvatar\u0018\u000e \u0001(\u000b2\u0014.MistTrialBestAvatar\u0012,\n\u000ebestAvatarList\u0018\r \u0003(\u000b2\u0014.MistTrialBestAvatarB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MistTrialBestAvatarOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MistTrialLevelData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MistTrialLevelData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MistTrialLevelData_descriptor, new String[]{"OpenTime", "FirstPassTime", "LevelId", "IsOpen", "BestHitAvatar", "BestAvatarList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MistTrialLevelDataOuterClass$MistTrialLevelDataOrBuilder.class */
    public interface MistTrialLevelDataOrBuilder extends MessageOrBuilder {
        int getOpenTime();

        int getFirstPassTime();

        int getLevelId();

        boolean getIsOpen();

        boolean hasBestHitAvatar();

        MistTrialBestAvatarOuterClass.MistTrialBestAvatar getBestHitAvatar();

        MistTrialBestAvatarOuterClass.MistTrialBestAvatarOrBuilder getBestHitAvatarOrBuilder();

        List<MistTrialBestAvatarOuterClass.MistTrialBestAvatar> getBestAvatarListList();

        MistTrialBestAvatarOuterClass.MistTrialBestAvatar getBestAvatarList(int i);

        int getBestAvatarListCount();

        List<? extends MistTrialBestAvatarOuterClass.MistTrialBestAvatarOrBuilder> getBestAvatarListOrBuilderList();

        MistTrialBestAvatarOuterClass.MistTrialBestAvatarOrBuilder getBestAvatarListOrBuilder(int i);
    }

    private MistTrialLevelDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MistTrialLevelDataOuterClass$MistTrialLevelData.class */
    public static final class MistTrialLevelData extends GeneratedMessageV3 implements MistTrialLevelDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int OPENTIME_FIELD_NUMBER = 2;
        private int openTime_;
        public static final int FIRSTPASSTIME_FIELD_NUMBER = 4;
        private int firstPassTime_;
        public static final int LEVELID_FIELD_NUMBER = 12;
        private int levelId_;
        public static final int ISOPEN_FIELD_NUMBER = 6;
        private boolean isOpen_;
        public static final int BESTHITAVATAR_FIELD_NUMBER = 14;
        private MistTrialBestAvatarOuterClass.MistTrialBestAvatar bestHitAvatar_;
        public static final int BESTAVATARLIST_FIELD_NUMBER = 13;
        private List<MistTrialBestAvatarOuterClass.MistTrialBestAvatar> bestAvatarList_;
        private byte memoizedIsInitialized;
        private static final MistTrialLevelData DEFAULT_INSTANCE = new MistTrialLevelData();
        private static final Parser<MistTrialLevelData> PARSER = new AbstractParser<MistTrialLevelData>() { // from class: emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelData.1
            @Override // com.google.protobuf.Parser
            public MistTrialLevelData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MistTrialLevelData(input, extensionRegistry);
            }
        };

        private MistTrialLevelData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MistTrialLevelData() {
            this.memoizedIsInitialized = -1;
            this.bestAvatarList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MistTrialLevelData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MistTrialLevelData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.openTime_ = input.readUInt32();
                                    break;
                                case 32:
                                    this.firstPassTime_ = input.readUInt32();
                                    break;
                                case 48:
                                    this.isOpen_ = input.readBool();
                                    break;
                                case 96:
                                    this.levelId_ = input.readUInt32();
                                    break;
                                case 106:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.bestAvatarList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.bestAvatarList_.add((MistTrialBestAvatarOuterClass.MistTrialBestAvatar) input.readMessage(MistTrialBestAvatarOuterClass.MistTrialBestAvatar.parser(), extensionRegistry));
                                    break;
                                case 114:
                                    MistTrialBestAvatarOuterClass.MistTrialBestAvatar.Builder subBuilder = this.bestHitAvatar_ != null ? this.bestHitAvatar_.toBuilder() : null;
                                    this.bestHitAvatar_ = (MistTrialBestAvatarOuterClass.MistTrialBestAvatar) input.readMessage(MistTrialBestAvatarOuterClass.MistTrialBestAvatar.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.bestHitAvatar_);
                                        this.bestHitAvatar_ = subBuilder.buildPartial();
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
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.bestAvatarList_ = Collections.unmodifiableList(this.bestAvatarList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MistTrialLevelDataOuterClass.internal_static_MistTrialLevelData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MistTrialLevelDataOuterClass.internal_static_MistTrialLevelData_fieldAccessorTable.ensureFieldAccessorsInitialized(MistTrialLevelData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
        public int getOpenTime() {
            return this.openTime_;
        }

        @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
        public int getFirstPassTime() {
            return this.firstPassTime_;
        }

        @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
        public int getLevelId() {
            return this.levelId_;
        }

        @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
        public boolean hasBestHitAvatar() {
            return this.bestHitAvatar_ != null;
        }

        @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
        public MistTrialBestAvatarOuterClass.MistTrialBestAvatar getBestHitAvatar() {
            return this.bestHitAvatar_ == null ? MistTrialBestAvatarOuterClass.MistTrialBestAvatar.getDefaultInstance() : this.bestHitAvatar_;
        }

        @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
        public MistTrialBestAvatarOuterClass.MistTrialBestAvatarOrBuilder getBestHitAvatarOrBuilder() {
            return getBestHitAvatar();
        }

        @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
        public List<MistTrialBestAvatarOuterClass.MistTrialBestAvatar> getBestAvatarListList() {
            return this.bestAvatarList_;
        }

        @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
        public List<? extends MistTrialBestAvatarOuterClass.MistTrialBestAvatarOrBuilder> getBestAvatarListOrBuilderList() {
            return this.bestAvatarList_;
        }

        @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
        public int getBestAvatarListCount() {
            return this.bestAvatarList_.size();
        }

        @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
        public MistTrialBestAvatarOuterClass.MistTrialBestAvatar getBestAvatarList(int index) {
            return this.bestAvatarList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
        public MistTrialBestAvatarOuterClass.MistTrialBestAvatarOrBuilder getBestAvatarListOrBuilder(int index) {
            return this.bestAvatarList_.get(index);
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
            if (this.openTime_ != 0) {
                output.writeUInt32(2, this.openTime_);
            }
            if (this.firstPassTime_ != 0) {
                output.writeUInt32(4, this.firstPassTime_);
            }
            if (this.isOpen_) {
                output.writeBool(6, this.isOpen_);
            }
            if (this.levelId_ != 0) {
                output.writeUInt32(12, this.levelId_);
            }
            for (int i = 0; i < this.bestAvatarList_.size(); i++) {
                output.writeMessage(13, this.bestAvatarList_.get(i));
            }
            if (this.bestHitAvatar_ != null) {
                output.writeMessage(14, getBestHitAvatar());
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
            if (this.openTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.openTime_);
            }
            if (this.firstPassTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.firstPassTime_);
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.isOpen_);
            }
            if (this.levelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.levelId_);
            }
            for (int i = 0; i < this.bestAvatarList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(13, this.bestAvatarList_.get(i));
            }
            if (this.bestHitAvatar_ != null) {
                size2 += CodedOutputStream.computeMessageSize(14, getBestHitAvatar());
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
            if (!(obj instanceof MistTrialLevelData)) {
                return equals(obj);
            }
            MistTrialLevelData other = (MistTrialLevelData) obj;
            if (getOpenTime() == other.getOpenTime() && getFirstPassTime() == other.getFirstPassTime() && getLevelId() == other.getLevelId() && getIsOpen() == other.getIsOpen() && hasBestHitAvatar() == other.hasBestHitAvatar()) {
                return (!hasBestHitAvatar() || getBestHitAvatar().equals(other.getBestHitAvatar())) && getBestAvatarListList().equals(other.getBestAvatarListList()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + getOpenTime())) + 4)) + getFirstPassTime())) + 12)) + getLevelId())) + 6)) + Internal.hashBoolean(getIsOpen());
            if (hasBestHitAvatar()) {
                hash = (53 * ((37 * hash) + 14)) + getBestHitAvatar().hashCode();
            }
            if (getBestAvatarListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getBestAvatarListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MistTrialLevelData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MistTrialLevelData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MistTrialLevelData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MistTrialLevelData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MistTrialLevelData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MistTrialLevelData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MistTrialLevelData parseFrom(InputStream input) throws IOException {
            return (MistTrialLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MistTrialLevelData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MistTrialLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MistTrialLevelData parseDelimitedFrom(InputStream input) throws IOException {
            return (MistTrialLevelData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MistTrialLevelData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MistTrialLevelData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MistTrialLevelData parseFrom(CodedInputStream input) throws IOException {
            return (MistTrialLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MistTrialLevelData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MistTrialLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MistTrialLevelData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MistTrialLevelDataOuterClass$MistTrialLevelData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MistTrialLevelDataOrBuilder {
            private int bitField0_;
            private int openTime_;
            private int firstPassTime_;
            private int levelId_;
            private boolean isOpen_;
            private MistTrialBestAvatarOuterClass.MistTrialBestAvatar bestHitAvatar_;
            private SingleFieldBuilderV3<MistTrialBestAvatarOuterClass.MistTrialBestAvatar, MistTrialBestAvatarOuterClass.MistTrialBestAvatar.Builder, MistTrialBestAvatarOuterClass.MistTrialBestAvatarOrBuilder> bestHitAvatarBuilder_;
            private List<MistTrialBestAvatarOuterClass.MistTrialBestAvatar> bestAvatarList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<MistTrialBestAvatarOuterClass.MistTrialBestAvatar, MistTrialBestAvatarOuterClass.MistTrialBestAvatar.Builder, MistTrialBestAvatarOuterClass.MistTrialBestAvatarOrBuilder> bestAvatarListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MistTrialLevelDataOuterClass.internal_static_MistTrialLevelData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MistTrialLevelDataOuterClass.internal_static_MistTrialLevelData_fieldAccessorTable.ensureFieldAccessorsInitialized(MistTrialLevelData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MistTrialLevelData.alwaysUseFieldBuilders) {
                    getBestAvatarListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.openTime_ = 0;
                this.firstPassTime_ = 0;
                this.levelId_ = 0;
                this.isOpen_ = false;
                if (this.bestHitAvatarBuilder_ == null) {
                    this.bestHitAvatar_ = null;
                } else {
                    this.bestHitAvatar_ = null;
                    this.bestHitAvatarBuilder_ = null;
                }
                if (this.bestAvatarListBuilder_ == null) {
                    this.bestAvatarList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.bestAvatarListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MistTrialLevelDataOuterClass.internal_static_MistTrialLevelData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MistTrialLevelData getDefaultInstanceForType() {
                return MistTrialLevelData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MistTrialLevelData build() {
                MistTrialLevelData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MistTrialLevelData buildPartial() {
                MistTrialLevelData result = new MistTrialLevelData(this);
                int i = this.bitField0_;
                result.openTime_ = this.openTime_;
                result.firstPassTime_ = this.firstPassTime_;
                result.levelId_ = this.levelId_;
                result.isOpen_ = this.isOpen_;
                if (this.bestHitAvatarBuilder_ == null) {
                    result.bestHitAvatar_ = this.bestHitAvatar_;
                } else {
                    result.bestHitAvatar_ = this.bestHitAvatarBuilder_.build();
                }
                if (this.bestAvatarListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.bestAvatarList_ = Collections.unmodifiableList(this.bestAvatarList_);
                        this.bitField0_ &= -2;
                    }
                    result.bestAvatarList_ = this.bestAvatarList_;
                } else {
                    result.bestAvatarList_ = this.bestAvatarListBuilder_.build();
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
                if (other instanceof MistTrialLevelData) {
                    return mergeFrom((MistTrialLevelData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MistTrialLevelData other) {
                if (other == MistTrialLevelData.getDefaultInstance()) {
                    return this;
                }
                if (other.getOpenTime() != 0) {
                    setOpenTime(other.getOpenTime());
                }
                if (other.getFirstPassTime() != 0) {
                    setFirstPassTime(other.getFirstPassTime());
                }
                if (other.getLevelId() != 0) {
                    setLevelId(other.getLevelId());
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (other.hasBestHitAvatar()) {
                    mergeBestHitAvatar(other.getBestHitAvatar());
                }
                if (this.bestAvatarListBuilder_ == null) {
                    if (!other.bestAvatarList_.isEmpty()) {
                        if (this.bestAvatarList_.isEmpty()) {
                            this.bestAvatarList_ = other.bestAvatarList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureBestAvatarListIsMutable();
                            this.bestAvatarList_.addAll(other.bestAvatarList_);
                        }
                        onChanged();
                    }
                } else if (!other.bestAvatarList_.isEmpty()) {
                    if (this.bestAvatarListBuilder_.isEmpty()) {
                        this.bestAvatarListBuilder_.dispose();
                        this.bestAvatarListBuilder_ = null;
                        this.bestAvatarList_ = other.bestAvatarList_;
                        this.bitField0_ &= -2;
                        this.bestAvatarListBuilder_ = MistTrialLevelData.alwaysUseFieldBuilders ? getBestAvatarListFieldBuilder() : null;
                    } else {
                        this.bestAvatarListBuilder_.addAllMessages(other.bestAvatarList_);
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
                MistTrialLevelData parsedMessage = null;
                try {
                    try {
                        parsedMessage = MistTrialLevelData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MistTrialLevelData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
            public int getOpenTime() {
                return this.openTime_;
            }

            public Builder setOpenTime(int value) {
                this.openTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearOpenTime() {
                this.openTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
            public int getFirstPassTime() {
                return this.firstPassTime_;
            }

            public Builder setFirstPassTime(int value) {
                this.firstPassTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearFirstPassTime() {
                this.firstPassTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
            public int getLevelId() {
                return this.levelId_;
            }

            public Builder setLevelId(int value) {
                this.levelId_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevelId() {
                this.levelId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            public Builder setIsOpen(boolean value) {
                this.isOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.isOpen_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
            public boolean hasBestHitAvatar() {
                return (this.bestHitAvatarBuilder_ == null && this.bestHitAvatar_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
            public MistTrialBestAvatarOuterClass.MistTrialBestAvatar getBestHitAvatar() {
                if (this.bestHitAvatarBuilder_ == null) {
                    return this.bestHitAvatar_ == null ? MistTrialBestAvatarOuterClass.MistTrialBestAvatar.getDefaultInstance() : this.bestHitAvatar_;
                }
                return this.bestHitAvatarBuilder_.getMessage();
            }

            public Builder setBestHitAvatar(MistTrialBestAvatarOuterClass.MistTrialBestAvatar value) {
                if (this.bestHitAvatarBuilder_ != null) {
                    this.bestHitAvatarBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.bestHitAvatar_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setBestHitAvatar(MistTrialBestAvatarOuterClass.MistTrialBestAvatar.Builder builderForValue) {
                if (this.bestHitAvatarBuilder_ == null) {
                    this.bestHitAvatar_ = builderForValue.build();
                    onChanged();
                } else {
                    this.bestHitAvatarBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeBestHitAvatar(MistTrialBestAvatarOuterClass.MistTrialBestAvatar value) {
                if (this.bestHitAvatarBuilder_ == null) {
                    if (this.bestHitAvatar_ != null) {
                        this.bestHitAvatar_ = MistTrialBestAvatarOuterClass.MistTrialBestAvatar.newBuilder(this.bestHitAvatar_).mergeFrom(value).buildPartial();
                    } else {
                        this.bestHitAvatar_ = value;
                    }
                    onChanged();
                } else {
                    this.bestHitAvatarBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearBestHitAvatar() {
                if (this.bestHitAvatarBuilder_ == null) {
                    this.bestHitAvatar_ = null;
                    onChanged();
                } else {
                    this.bestHitAvatar_ = null;
                    this.bestHitAvatarBuilder_ = null;
                }
                return this;
            }

            public MistTrialBestAvatarOuterClass.MistTrialBestAvatar.Builder getBestHitAvatarBuilder() {
                onChanged();
                return getBestHitAvatarFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
            public MistTrialBestAvatarOuterClass.MistTrialBestAvatarOrBuilder getBestHitAvatarOrBuilder() {
                if (this.bestHitAvatarBuilder_ != null) {
                    return this.bestHitAvatarBuilder_.getMessageOrBuilder();
                }
                return this.bestHitAvatar_ == null ? MistTrialBestAvatarOuterClass.MistTrialBestAvatar.getDefaultInstance() : this.bestHitAvatar_;
            }

            private SingleFieldBuilderV3<MistTrialBestAvatarOuterClass.MistTrialBestAvatar, MistTrialBestAvatarOuterClass.MistTrialBestAvatar.Builder, MistTrialBestAvatarOuterClass.MistTrialBestAvatarOrBuilder> getBestHitAvatarFieldBuilder() {
                if (this.bestHitAvatarBuilder_ == null) {
                    this.bestHitAvatarBuilder_ = new SingleFieldBuilderV3<>(getBestHitAvatar(), getParentForChildren(), isClean());
                    this.bestHitAvatar_ = null;
                }
                return this.bestHitAvatarBuilder_;
            }

            private void ensureBestAvatarListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.bestAvatarList_ = new ArrayList(this.bestAvatarList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
            public List<MistTrialBestAvatarOuterClass.MistTrialBestAvatar> getBestAvatarListList() {
                if (this.bestAvatarListBuilder_ == null) {
                    return Collections.unmodifiableList(this.bestAvatarList_);
                }
                return this.bestAvatarListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
            public int getBestAvatarListCount() {
                if (this.bestAvatarListBuilder_ == null) {
                    return this.bestAvatarList_.size();
                }
                return this.bestAvatarListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
            public MistTrialBestAvatarOuterClass.MistTrialBestAvatar getBestAvatarList(int index) {
                if (this.bestAvatarListBuilder_ == null) {
                    return this.bestAvatarList_.get(index);
                }
                return this.bestAvatarListBuilder_.getMessage(index);
            }

            public Builder setBestAvatarList(int index, MistTrialBestAvatarOuterClass.MistTrialBestAvatar value) {
                if (this.bestAvatarListBuilder_ != null) {
                    this.bestAvatarListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBestAvatarListIsMutable();
                    this.bestAvatarList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setBestAvatarList(int index, MistTrialBestAvatarOuterClass.MistTrialBestAvatar.Builder builderForValue) {
                if (this.bestAvatarListBuilder_ == null) {
                    ensureBestAvatarListIsMutable();
                    this.bestAvatarList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.bestAvatarListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addBestAvatarList(MistTrialBestAvatarOuterClass.MistTrialBestAvatar value) {
                if (this.bestAvatarListBuilder_ != null) {
                    this.bestAvatarListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBestAvatarListIsMutable();
                    this.bestAvatarList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addBestAvatarList(int index, MistTrialBestAvatarOuterClass.MistTrialBestAvatar value) {
                if (this.bestAvatarListBuilder_ != null) {
                    this.bestAvatarListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBestAvatarListIsMutable();
                    this.bestAvatarList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addBestAvatarList(MistTrialBestAvatarOuterClass.MistTrialBestAvatar.Builder builderForValue) {
                if (this.bestAvatarListBuilder_ == null) {
                    ensureBestAvatarListIsMutable();
                    this.bestAvatarList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.bestAvatarListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addBestAvatarList(int index, MistTrialBestAvatarOuterClass.MistTrialBestAvatar.Builder builderForValue) {
                if (this.bestAvatarListBuilder_ == null) {
                    ensureBestAvatarListIsMutable();
                    this.bestAvatarList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.bestAvatarListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllBestAvatarList(Iterable<? extends MistTrialBestAvatarOuterClass.MistTrialBestAvatar> values) {
                if (this.bestAvatarListBuilder_ == null) {
                    ensureBestAvatarListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.bestAvatarList_);
                    onChanged();
                } else {
                    this.bestAvatarListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearBestAvatarList() {
                if (this.bestAvatarListBuilder_ == null) {
                    this.bestAvatarList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.bestAvatarListBuilder_.clear();
                }
                return this;
            }

            public Builder removeBestAvatarList(int index) {
                if (this.bestAvatarListBuilder_ == null) {
                    ensureBestAvatarListIsMutable();
                    this.bestAvatarList_.remove(index);
                    onChanged();
                } else {
                    this.bestAvatarListBuilder_.remove(index);
                }
                return this;
            }

            public MistTrialBestAvatarOuterClass.MistTrialBestAvatar.Builder getBestAvatarListBuilder(int index) {
                return getBestAvatarListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
            public MistTrialBestAvatarOuterClass.MistTrialBestAvatarOrBuilder getBestAvatarListOrBuilder(int index) {
                if (this.bestAvatarListBuilder_ == null) {
                    return this.bestAvatarList_.get(index);
                }
                return this.bestAvatarListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder
            public List<? extends MistTrialBestAvatarOuterClass.MistTrialBestAvatarOrBuilder> getBestAvatarListOrBuilderList() {
                if (this.bestAvatarListBuilder_ != null) {
                    return this.bestAvatarListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.bestAvatarList_);
            }

            public MistTrialBestAvatarOuterClass.MistTrialBestAvatar.Builder addBestAvatarListBuilder() {
                return getBestAvatarListFieldBuilder().addBuilder(MistTrialBestAvatarOuterClass.MistTrialBestAvatar.getDefaultInstance());
            }

            public MistTrialBestAvatarOuterClass.MistTrialBestAvatar.Builder addBestAvatarListBuilder(int index) {
                return getBestAvatarListFieldBuilder().addBuilder(index, MistTrialBestAvatarOuterClass.MistTrialBestAvatar.getDefaultInstance());
            }

            public List<MistTrialBestAvatarOuterClass.MistTrialBestAvatar.Builder> getBestAvatarListBuilderList() {
                return getBestAvatarListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<MistTrialBestAvatarOuterClass.MistTrialBestAvatar, MistTrialBestAvatarOuterClass.MistTrialBestAvatar.Builder, MistTrialBestAvatarOuterClass.MistTrialBestAvatarOrBuilder> getBestAvatarListFieldBuilder() {
                if (this.bestAvatarListBuilder_ == null) {
                    this.bestAvatarListBuilder_ = new RepeatedFieldBuilderV3<>(this.bestAvatarList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.bestAvatarList_ = null;
                }
                return this.bestAvatarListBuilder_;
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

        public static MistTrialLevelData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MistTrialLevelData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MistTrialLevelData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MistTrialLevelData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MistTrialBestAvatarOuterClass.getDescriptor();
    }
}
