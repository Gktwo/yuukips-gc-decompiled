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
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.ExpeditionChallengeInfoOuterClass;
import emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ExpeditionInfoOuterClass.class */
public final class ExpeditionInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014ExpeditionInfo.proto\u001a\u001dExpeditionChallengeInfo.proto\u001a\u0018ExpeditionPathInfo.proto\"Ý\u0001\n\u000eExpeditionInfo\u00126\n\u0014exceededItemTypeList\u0018\u0002 \u0003(\u000b2\u0018.ExpeditionChallengeInfo\u0012\u0014\n\fleftMonsters\u0018\f \u0001(\b\u0012\u001b\n\u0013Unk3300_MNPBCNEDKAJ\u0018\u0003 \u0001(\r\u0012\u0018\n\u0010contentCloseTime\u0018\t \u0001(\r\u0012\u001b\n\u0013Unk3300_GJLCAJOFCKL\u0018\u0004 \u0001(\r\u0012)\n\fpathInfoList\u0018\r \u0003(\u000b2\u0013.ExpeditionPathInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ExpeditionChallengeInfoOuterClass.getDescriptor(), ExpeditionPathInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ExpeditionInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ExpeditionInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ExpeditionInfo_descriptor, new String[]{"ExceededItemTypeList", "LeftMonsters", "Unk3300MNPBCNEDKAJ", "ContentCloseTime", "Unk3300GJLCAJOFCKL", "PathInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ExpeditionInfoOuterClass$ExpeditionInfoOrBuilder.class */
    public interface ExpeditionInfoOrBuilder extends MessageOrBuilder {
        List<ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo> getExceededItemTypeListList();

        ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo getExceededItemTypeList(int i);

        int getExceededItemTypeListCount();

        List<? extends ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfoOrBuilder> getExceededItemTypeListOrBuilderList();

        ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfoOrBuilder getExceededItemTypeListOrBuilder(int i);

        boolean getLeftMonsters();

        int getUnk3300MNPBCNEDKAJ();

        int getContentCloseTime();

        int getUnk3300GJLCAJOFCKL();

        List<ExpeditionPathInfoOuterClass.ExpeditionPathInfo> getPathInfoListList();

        ExpeditionPathInfoOuterClass.ExpeditionPathInfo getPathInfoList(int i);

        int getPathInfoListCount();

        List<? extends ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder> getPathInfoListOrBuilderList();

        ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder getPathInfoListOrBuilder(int i);
    }

    private ExpeditionInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ExpeditionInfoOuterClass$ExpeditionInfo.class */
    public static final class ExpeditionInfo extends GeneratedMessageV3 implements ExpeditionInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int EXCEEDEDITEMTYPELIST_FIELD_NUMBER = 2;
        private List<ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo> exceededItemTypeList_;
        public static final int LEFTMONSTERS_FIELD_NUMBER = 12;
        private boolean leftMonsters_;
        public static final int UNK3300_MNPBCNEDKAJ_FIELD_NUMBER = 3;
        private int unk3300MNPBCNEDKAJ_;
        public static final int CONTENTCLOSETIME_FIELD_NUMBER = 9;
        private int contentCloseTime_;
        public static final int UNK3300_GJLCAJOFCKL_FIELD_NUMBER = 4;
        private int unk3300GJLCAJOFCKL_;
        public static final int PATHINFOLIST_FIELD_NUMBER = 13;
        private List<ExpeditionPathInfoOuterClass.ExpeditionPathInfo> pathInfoList_;
        private byte memoizedIsInitialized;
        private static final ExpeditionInfo DEFAULT_INSTANCE = new ExpeditionInfo();
        private static final Parser<ExpeditionInfo> PARSER = new AbstractParser<ExpeditionInfo>() { // from class: emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfo.1
            @Override // com.google.protobuf.Parser
            public ExpeditionInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ExpeditionInfo(input, extensionRegistry);
            }
        };

        private ExpeditionInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ExpeditionInfo() {
            this.memoizedIsInitialized = -1;
            this.exceededItemTypeList_ = Collections.emptyList();
            this.pathInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ExpeditionInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:66:0x0104 */
        private ExpeditionInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 18:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.exceededItemTypeList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.exceededItemTypeList_.add((ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo) input.readMessage(ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.parser(), extensionRegistry));
                                    break;
                                case 24:
                                    this.unk3300MNPBCNEDKAJ_ = input.readUInt32();
                                    break;
                                case 32:
                                    this.unk3300GJLCAJOFCKL_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.contentCloseTime_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.leftMonsters_ = input.readBool();
                                    break;
                                case 106:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.pathInfoList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.pathInfoList_.add((ExpeditionPathInfoOuterClass.ExpeditionPathInfo) input.readMessage(ExpeditionPathInfoOuterClass.ExpeditionPathInfo.parser(), extensionRegistry));
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                            done = done;
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.exceededItemTypeList_ = Collections.unmodifiableList(this.exceededItemTypeList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.pathInfoList_ = Collections.unmodifiableList(this.pathInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ExpeditionInfoOuterClass.internal_static_ExpeditionInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ExpeditionInfoOuterClass.internal_static_ExpeditionInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ExpeditionInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
        public List<ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo> getExceededItemTypeListList() {
            return this.exceededItemTypeList_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
        public List<? extends ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfoOrBuilder> getExceededItemTypeListOrBuilderList() {
            return this.exceededItemTypeList_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
        public int getExceededItemTypeListCount() {
            return this.exceededItemTypeList_.size();
        }

        @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
        public ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo getExceededItemTypeList(int index) {
            return this.exceededItemTypeList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
        public ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfoOrBuilder getExceededItemTypeListOrBuilder(int index) {
            return this.exceededItemTypeList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
        public boolean getLeftMonsters() {
            return this.leftMonsters_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
        public int getUnk3300MNPBCNEDKAJ() {
            return this.unk3300MNPBCNEDKAJ_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
        public int getContentCloseTime() {
            return this.contentCloseTime_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
        public int getUnk3300GJLCAJOFCKL() {
            return this.unk3300GJLCAJOFCKL_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
        public List<ExpeditionPathInfoOuterClass.ExpeditionPathInfo> getPathInfoListList() {
            return this.pathInfoList_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
        public List<? extends ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder> getPathInfoListOrBuilderList() {
            return this.pathInfoList_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
        public int getPathInfoListCount() {
            return this.pathInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
        public ExpeditionPathInfoOuterClass.ExpeditionPathInfo getPathInfoList(int index) {
            return this.pathInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
        public ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder getPathInfoListOrBuilder(int index) {
            return this.pathInfoList_.get(index);
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
            for (int i = 0; i < this.exceededItemTypeList_.size(); i++) {
                output.writeMessage(2, this.exceededItemTypeList_.get(i));
            }
            if (this.unk3300MNPBCNEDKAJ_ != 0) {
                output.writeUInt32(3, this.unk3300MNPBCNEDKAJ_);
            }
            if (this.unk3300GJLCAJOFCKL_ != 0) {
                output.writeUInt32(4, this.unk3300GJLCAJOFCKL_);
            }
            if (this.contentCloseTime_ != 0) {
                output.writeUInt32(9, this.contentCloseTime_);
            }
            if (this.leftMonsters_) {
                output.writeBool(12, this.leftMonsters_);
            }
            for (int i2 = 0; i2 < this.pathInfoList_.size(); i2++) {
                output.writeMessage(13, this.pathInfoList_.get(i2));
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
            for (int i = 0; i < this.exceededItemTypeList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.exceededItemTypeList_.get(i));
            }
            if (this.unk3300MNPBCNEDKAJ_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.unk3300MNPBCNEDKAJ_);
            }
            if (this.unk3300GJLCAJOFCKL_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.unk3300GJLCAJOFCKL_);
            }
            if (this.contentCloseTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.contentCloseTime_);
            }
            if (this.leftMonsters_) {
                size2 += CodedOutputStream.computeBoolSize(12, this.leftMonsters_);
            }
            for (int i2 = 0; i2 < this.pathInfoList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(13, this.pathInfoList_.get(i2));
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
            if (!(obj instanceof ExpeditionInfo)) {
                return equals(obj);
            }
            ExpeditionInfo other = (ExpeditionInfo) obj;
            return getExceededItemTypeListList().equals(other.getExceededItemTypeListList()) && getLeftMonsters() == other.getLeftMonsters() && getUnk3300MNPBCNEDKAJ() == other.getUnk3300MNPBCNEDKAJ() && getContentCloseTime() == other.getContentCloseTime() && getUnk3300GJLCAJOFCKL() == other.getUnk3300GJLCAJOFCKL() && getPathInfoListList().equals(other.getPathInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getExceededItemTypeListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getExceededItemTypeListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 12)) + Internal.hashBoolean(getLeftMonsters()))) + 3)) + getUnk3300MNPBCNEDKAJ())) + 9)) + getContentCloseTime())) + 4)) + getUnk3300GJLCAJOFCKL();
            if (getPathInfoListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 13)) + getPathInfoListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static ExpeditionInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ExpeditionInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ExpeditionInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ExpeditionInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ExpeditionInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ExpeditionInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ExpeditionInfo parseFrom(InputStream input) throws IOException {
            return (ExpeditionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ExpeditionInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExpeditionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ExpeditionInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ExpeditionInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ExpeditionInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExpeditionInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ExpeditionInfo parseFrom(CodedInputStream input) throws IOException {
            return (ExpeditionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ExpeditionInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExpeditionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ExpeditionInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ExpeditionInfoOuterClass$ExpeditionInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ExpeditionInfoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo, ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.Builder, ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfoOrBuilder> exceededItemTypeListBuilder_;
            private boolean leftMonsters_;
            private int unk3300MNPBCNEDKAJ_;
            private int contentCloseTime_;
            private int unk3300GJLCAJOFCKL_;
            private RepeatedFieldBuilderV3<ExpeditionPathInfoOuterClass.ExpeditionPathInfo, ExpeditionPathInfoOuterClass.ExpeditionPathInfo.Builder, ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder> pathInfoListBuilder_;
            private List<ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo> exceededItemTypeList_ = Collections.emptyList();
            private List<ExpeditionPathInfoOuterClass.ExpeditionPathInfo> pathInfoList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ExpeditionInfoOuterClass.internal_static_ExpeditionInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ExpeditionInfoOuterClass.internal_static_ExpeditionInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ExpeditionInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ExpeditionInfo.alwaysUseFieldBuilders) {
                    getExceededItemTypeListFieldBuilder();
                    getPathInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.exceededItemTypeListBuilder_ == null) {
                    this.exceededItemTypeList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.exceededItemTypeListBuilder_.clear();
                }
                this.leftMonsters_ = false;
                this.unk3300MNPBCNEDKAJ_ = 0;
                this.contentCloseTime_ = 0;
                this.unk3300GJLCAJOFCKL_ = 0;
                if (this.pathInfoListBuilder_ == null) {
                    this.pathInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.pathInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ExpeditionInfoOuterClass.internal_static_ExpeditionInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ExpeditionInfo getDefaultInstanceForType() {
                return ExpeditionInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ExpeditionInfo build() {
                ExpeditionInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ExpeditionInfo buildPartial() {
                ExpeditionInfo result = new ExpeditionInfo(this);
                int i = this.bitField0_;
                if (this.exceededItemTypeListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.exceededItemTypeList_ = Collections.unmodifiableList(this.exceededItemTypeList_);
                        this.bitField0_ &= -2;
                    }
                    result.exceededItemTypeList_ = this.exceededItemTypeList_;
                } else {
                    result.exceededItemTypeList_ = this.exceededItemTypeListBuilder_.build();
                }
                result.leftMonsters_ = this.leftMonsters_;
                result.unk3300MNPBCNEDKAJ_ = this.unk3300MNPBCNEDKAJ_;
                result.contentCloseTime_ = this.contentCloseTime_;
                result.unk3300GJLCAJOFCKL_ = this.unk3300GJLCAJOFCKL_;
                if (this.pathInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.pathInfoList_ = Collections.unmodifiableList(this.pathInfoList_);
                        this.bitField0_ &= -3;
                    }
                    result.pathInfoList_ = this.pathInfoList_;
                } else {
                    result.pathInfoList_ = this.pathInfoListBuilder_.build();
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
                if (other instanceof ExpeditionInfo) {
                    return mergeFrom((ExpeditionInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ExpeditionInfo other) {
                if (other == ExpeditionInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.exceededItemTypeListBuilder_ == null) {
                    if (!other.exceededItemTypeList_.isEmpty()) {
                        if (this.exceededItemTypeList_.isEmpty()) {
                            this.exceededItemTypeList_ = other.exceededItemTypeList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureExceededItemTypeListIsMutable();
                            this.exceededItemTypeList_.addAll(other.exceededItemTypeList_);
                        }
                        onChanged();
                    }
                } else if (!other.exceededItemTypeList_.isEmpty()) {
                    if (this.exceededItemTypeListBuilder_.isEmpty()) {
                        this.exceededItemTypeListBuilder_.dispose();
                        this.exceededItemTypeListBuilder_ = null;
                        this.exceededItemTypeList_ = other.exceededItemTypeList_;
                        this.bitField0_ &= -2;
                        this.exceededItemTypeListBuilder_ = ExpeditionInfo.alwaysUseFieldBuilders ? getExceededItemTypeListFieldBuilder() : null;
                    } else {
                        this.exceededItemTypeListBuilder_.addAllMessages(other.exceededItemTypeList_);
                    }
                }
                if (other.getLeftMonsters()) {
                    setLeftMonsters(other.getLeftMonsters());
                }
                if (other.getUnk3300MNPBCNEDKAJ() != 0) {
                    setUnk3300MNPBCNEDKAJ(other.getUnk3300MNPBCNEDKAJ());
                }
                if (other.getContentCloseTime() != 0) {
                    setContentCloseTime(other.getContentCloseTime());
                }
                if (other.getUnk3300GJLCAJOFCKL() != 0) {
                    setUnk3300GJLCAJOFCKL(other.getUnk3300GJLCAJOFCKL());
                }
                if (this.pathInfoListBuilder_ == null) {
                    if (!other.pathInfoList_.isEmpty()) {
                        if (this.pathInfoList_.isEmpty()) {
                            this.pathInfoList_ = other.pathInfoList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensurePathInfoListIsMutable();
                            this.pathInfoList_.addAll(other.pathInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.pathInfoList_.isEmpty()) {
                    if (this.pathInfoListBuilder_.isEmpty()) {
                        this.pathInfoListBuilder_.dispose();
                        this.pathInfoListBuilder_ = null;
                        this.pathInfoList_ = other.pathInfoList_;
                        this.bitField0_ &= -3;
                        this.pathInfoListBuilder_ = ExpeditionInfo.alwaysUseFieldBuilders ? getPathInfoListFieldBuilder() : null;
                    } else {
                        this.pathInfoListBuilder_.addAllMessages(other.pathInfoList_);
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
                ExpeditionInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ExpeditionInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ExpeditionInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureExceededItemTypeListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.exceededItemTypeList_ = new ArrayList(this.exceededItemTypeList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
            public List<ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo> getExceededItemTypeListList() {
                if (this.exceededItemTypeListBuilder_ == null) {
                    return Collections.unmodifiableList(this.exceededItemTypeList_);
                }
                return this.exceededItemTypeListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
            public int getExceededItemTypeListCount() {
                if (this.exceededItemTypeListBuilder_ == null) {
                    return this.exceededItemTypeList_.size();
                }
                return this.exceededItemTypeListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
            public ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo getExceededItemTypeList(int index) {
                if (this.exceededItemTypeListBuilder_ == null) {
                    return this.exceededItemTypeList_.get(index);
                }
                return this.exceededItemTypeListBuilder_.getMessage(index);
            }

            public Builder setExceededItemTypeList(int index, ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo value) {
                if (this.exceededItemTypeListBuilder_ != null) {
                    this.exceededItemTypeListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExceededItemTypeListIsMutable();
                    this.exceededItemTypeList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setExceededItemTypeList(int index, ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.Builder builderForValue) {
                if (this.exceededItemTypeListBuilder_ == null) {
                    ensureExceededItemTypeListIsMutable();
                    this.exceededItemTypeList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.exceededItemTypeListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addExceededItemTypeList(ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo value) {
                if (this.exceededItemTypeListBuilder_ != null) {
                    this.exceededItemTypeListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExceededItemTypeListIsMutable();
                    this.exceededItemTypeList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addExceededItemTypeList(int index, ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo value) {
                if (this.exceededItemTypeListBuilder_ != null) {
                    this.exceededItemTypeListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExceededItemTypeListIsMutable();
                    this.exceededItemTypeList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addExceededItemTypeList(ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.Builder builderForValue) {
                if (this.exceededItemTypeListBuilder_ == null) {
                    ensureExceededItemTypeListIsMutable();
                    this.exceededItemTypeList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.exceededItemTypeListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addExceededItemTypeList(int index, ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.Builder builderForValue) {
                if (this.exceededItemTypeListBuilder_ == null) {
                    ensureExceededItemTypeListIsMutable();
                    this.exceededItemTypeList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.exceededItemTypeListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllExceededItemTypeList(Iterable<? extends ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo> values) {
                if (this.exceededItemTypeListBuilder_ == null) {
                    ensureExceededItemTypeListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.exceededItemTypeList_);
                    onChanged();
                } else {
                    this.exceededItemTypeListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearExceededItemTypeList() {
                if (this.exceededItemTypeListBuilder_ == null) {
                    this.exceededItemTypeList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.exceededItemTypeListBuilder_.clear();
                }
                return this;
            }

            public Builder removeExceededItemTypeList(int index) {
                if (this.exceededItemTypeListBuilder_ == null) {
                    ensureExceededItemTypeListIsMutable();
                    this.exceededItemTypeList_.remove(index);
                    onChanged();
                } else {
                    this.exceededItemTypeListBuilder_.remove(index);
                }
                return this;
            }

            public ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.Builder getExceededItemTypeListBuilder(int index) {
                return getExceededItemTypeListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
            public ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfoOrBuilder getExceededItemTypeListOrBuilder(int index) {
                if (this.exceededItemTypeListBuilder_ == null) {
                    return this.exceededItemTypeList_.get(index);
                }
                return this.exceededItemTypeListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
            public List<? extends ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfoOrBuilder> getExceededItemTypeListOrBuilderList() {
                if (this.exceededItemTypeListBuilder_ != null) {
                    return this.exceededItemTypeListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.exceededItemTypeList_);
            }

            public ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.Builder addExceededItemTypeListBuilder() {
                return getExceededItemTypeListFieldBuilder().addBuilder(ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.getDefaultInstance());
            }

            public ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.Builder addExceededItemTypeListBuilder(int index) {
                return getExceededItemTypeListFieldBuilder().addBuilder(index, ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.getDefaultInstance());
            }

            public List<ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.Builder> getExceededItemTypeListBuilderList() {
                return getExceededItemTypeListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo, ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.Builder, ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfoOrBuilder> getExceededItemTypeListFieldBuilder() {
                if (this.exceededItemTypeListBuilder_ == null) {
                    this.exceededItemTypeListBuilder_ = new RepeatedFieldBuilderV3<>(this.exceededItemTypeList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.exceededItemTypeList_ = null;
                }
                return this.exceededItemTypeListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
            public boolean getLeftMonsters() {
                return this.leftMonsters_;
            }

            public Builder setLeftMonsters(boolean value) {
                this.leftMonsters_ = value;
                onChanged();
                return this;
            }

            public Builder clearLeftMonsters() {
                this.leftMonsters_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
            public int getUnk3300MNPBCNEDKAJ() {
                return this.unk3300MNPBCNEDKAJ_;
            }

            public Builder setUnk3300MNPBCNEDKAJ(int value) {
                this.unk3300MNPBCNEDKAJ_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300MNPBCNEDKAJ() {
                this.unk3300MNPBCNEDKAJ_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
            public int getContentCloseTime() {
                return this.contentCloseTime_;
            }

            public Builder setContentCloseTime(int value) {
                this.contentCloseTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearContentCloseTime() {
                this.contentCloseTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
            public int getUnk3300GJLCAJOFCKL() {
                return this.unk3300GJLCAJOFCKL_;
            }

            public Builder setUnk3300GJLCAJOFCKL(int value) {
                this.unk3300GJLCAJOFCKL_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300GJLCAJOFCKL() {
                this.unk3300GJLCAJOFCKL_ = 0;
                onChanged();
                return this;
            }

            private void ensurePathInfoListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.pathInfoList_ = new ArrayList(this.pathInfoList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
            public List<ExpeditionPathInfoOuterClass.ExpeditionPathInfo> getPathInfoListList() {
                if (this.pathInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.pathInfoList_);
                }
                return this.pathInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
            public int getPathInfoListCount() {
                if (this.pathInfoListBuilder_ == null) {
                    return this.pathInfoList_.size();
                }
                return this.pathInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
            public ExpeditionPathInfoOuterClass.ExpeditionPathInfo getPathInfoList(int index) {
                if (this.pathInfoListBuilder_ == null) {
                    return this.pathInfoList_.get(index);
                }
                return this.pathInfoListBuilder_.getMessage(index);
            }

            public Builder setPathInfoList(int index, ExpeditionPathInfoOuterClass.ExpeditionPathInfo value) {
                if (this.pathInfoListBuilder_ != null) {
                    this.pathInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePathInfoListIsMutable();
                    this.pathInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setPathInfoList(int index, ExpeditionPathInfoOuterClass.ExpeditionPathInfo.Builder builderForValue) {
                if (this.pathInfoListBuilder_ == null) {
                    ensurePathInfoListIsMutable();
                    this.pathInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.pathInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addPathInfoList(ExpeditionPathInfoOuterClass.ExpeditionPathInfo value) {
                if (this.pathInfoListBuilder_ != null) {
                    this.pathInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePathInfoListIsMutable();
                    this.pathInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addPathInfoList(int index, ExpeditionPathInfoOuterClass.ExpeditionPathInfo value) {
                if (this.pathInfoListBuilder_ != null) {
                    this.pathInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePathInfoListIsMutable();
                    this.pathInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addPathInfoList(ExpeditionPathInfoOuterClass.ExpeditionPathInfo.Builder builderForValue) {
                if (this.pathInfoListBuilder_ == null) {
                    ensurePathInfoListIsMutable();
                    this.pathInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.pathInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addPathInfoList(int index, ExpeditionPathInfoOuterClass.ExpeditionPathInfo.Builder builderForValue) {
                if (this.pathInfoListBuilder_ == null) {
                    ensurePathInfoListIsMutable();
                    this.pathInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.pathInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllPathInfoList(Iterable<? extends ExpeditionPathInfoOuterClass.ExpeditionPathInfo> values) {
                if (this.pathInfoListBuilder_ == null) {
                    ensurePathInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.pathInfoList_);
                    onChanged();
                } else {
                    this.pathInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearPathInfoList() {
                if (this.pathInfoListBuilder_ == null) {
                    this.pathInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.pathInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removePathInfoList(int index) {
                if (this.pathInfoListBuilder_ == null) {
                    ensurePathInfoListIsMutable();
                    this.pathInfoList_.remove(index);
                    onChanged();
                } else {
                    this.pathInfoListBuilder_.remove(index);
                }
                return this;
            }

            public ExpeditionPathInfoOuterClass.ExpeditionPathInfo.Builder getPathInfoListBuilder(int index) {
                return getPathInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
            public ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder getPathInfoListOrBuilder(int index) {
                if (this.pathInfoListBuilder_ == null) {
                    return this.pathInfoList_.get(index);
                }
                return this.pathInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder
            public List<? extends ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder> getPathInfoListOrBuilderList() {
                if (this.pathInfoListBuilder_ != null) {
                    return this.pathInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.pathInfoList_);
            }

            public ExpeditionPathInfoOuterClass.ExpeditionPathInfo.Builder addPathInfoListBuilder() {
                return getPathInfoListFieldBuilder().addBuilder(ExpeditionPathInfoOuterClass.ExpeditionPathInfo.getDefaultInstance());
            }

            public ExpeditionPathInfoOuterClass.ExpeditionPathInfo.Builder addPathInfoListBuilder(int index) {
                return getPathInfoListFieldBuilder().addBuilder(index, ExpeditionPathInfoOuterClass.ExpeditionPathInfo.getDefaultInstance());
            }

            public List<ExpeditionPathInfoOuterClass.ExpeditionPathInfo.Builder> getPathInfoListBuilderList() {
                return getPathInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ExpeditionPathInfoOuterClass.ExpeditionPathInfo, ExpeditionPathInfoOuterClass.ExpeditionPathInfo.Builder, ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder> getPathInfoListFieldBuilder() {
                if (this.pathInfoListBuilder_ == null) {
                    this.pathInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.pathInfoList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.pathInfoList_ = null;
                }
                return this.pathInfoListBuilder_;
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

        public static ExpeditionInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ExpeditionInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ExpeditionInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ExpeditionInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ExpeditionChallengeInfoOuterClass.getDescriptor();
        ExpeditionPathInfoOuterClass.getDescriptor();
    }
}
