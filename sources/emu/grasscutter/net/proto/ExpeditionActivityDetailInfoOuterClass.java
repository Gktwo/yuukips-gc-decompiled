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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ExpeditionActivityDetailInfoOuterClass.class */
public final class ExpeditionActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"ExpeditionActivityDetailInfo.proto\u001a\u001dExpeditionChallengeInfo.proto\u001a\u0018ExpeditionPathInfo.proto\"ó\u0001\n\u001cExpeditionActivityDetailInfo\u0012\u001b\n\u0013Unk3300_GJLCAJOFCKL\u0018\t \u0001(\r\u00125\n\u0013challenge_info_list\u0018\u000f \u0003(\u000b2\u0018.ExpeditionChallengeInfo\u0012\u001b\n\u0013Unk3300_MNPBCNEDKAJ\u0018\u0003 \u0001(\r\u0012+\n\u000epath_info_list\u0018\u000b \u0003(\u000b2\u0013.ExpeditionPathInfo\u0012\u0019\n\u0011is_content_closed\u0018\u0004 \u0001(\b\u0012\u001a\n\u0012content_close_time\u0018\u0006 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ExpeditionChallengeInfoOuterClass.getDescriptor(), ExpeditionPathInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ExpeditionActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ExpeditionActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ExpeditionActivityDetailInfo_descriptor, new String[]{"Unk3300GJLCAJOFCKL", "ChallengeInfoList", "Unk3300MNPBCNEDKAJ", "PathInfoList", "IsContentClosed", "ContentCloseTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ExpeditionActivityDetailInfoOuterClass$ExpeditionActivityDetailInfoOrBuilder.class */
    public interface ExpeditionActivityDetailInfoOrBuilder extends MessageOrBuilder {
        int getUnk3300GJLCAJOFCKL();

        List<ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo> getChallengeInfoListList();

        ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo getChallengeInfoList(int i);

        int getChallengeInfoListCount();

        List<? extends ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfoOrBuilder> getChallengeInfoListOrBuilderList();

        ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfoOrBuilder getChallengeInfoListOrBuilder(int i);

        int getUnk3300MNPBCNEDKAJ();

        List<ExpeditionPathInfoOuterClass.ExpeditionPathInfo> getPathInfoListList();

        ExpeditionPathInfoOuterClass.ExpeditionPathInfo getPathInfoList(int i);

        int getPathInfoListCount();

        List<? extends ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder> getPathInfoListOrBuilderList();

        ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder getPathInfoListOrBuilder(int i);

        boolean getIsContentClosed();

        int getContentCloseTime();
    }

    private ExpeditionActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ExpeditionActivityDetailInfoOuterClass$ExpeditionActivityDetailInfo.class */
    public static final class ExpeditionActivityDetailInfo extends GeneratedMessageV3 implements ExpeditionActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_GJLCAJOFCKL_FIELD_NUMBER = 9;
        private int unk3300GJLCAJOFCKL_;
        public static final int CHALLENGE_INFO_LIST_FIELD_NUMBER = 15;
        private List<ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo> challengeInfoList_;
        public static final int UNK3300_MNPBCNEDKAJ_FIELD_NUMBER = 3;
        private int unk3300MNPBCNEDKAJ_;
        public static final int PATH_INFO_LIST_FIELD_NUMBER = 11;
        private List<ExpeditionPathInfoOuterClass.ExpeditionPathInfo> pathInfoList_;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 4;
        private boolean isContentClosed_;
        public static final int CONTENT_CLOSE_TIME_FIELD_NUMBER = 6;
        private int contentCloseTime_;
        private byte memoizedIsInitialized;
        private static final ExpeditionActivityDetailInfo DEFAULT_INSTANCE = new ExpeditionActivityDetailInfo();
        private static final Parser<ExpeditionActivityDetailInfo> PARSER = new AbstractParser<ExpeditionActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public ExpeditionActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ExpeditionActivityDetailInfo(input, extensionRegistry);
            }
        };

        private ExpeditionActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ExpeditionActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.challengeInfoList_ = Collections.emptyList();
            this.pathInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ExpeditionActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:66:0x0104 */
        private ExpeditionActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 24:
                                    this.unk3300MNPBCNEDKAJ_ = input.readUInt32();
                                    break;
                                case 32:
                                    this.isContentClosed_ = input.readBool();
                                    break;
                                case 48:
                                    this.contentCloseTime_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.unk3300GJLCAJOFCKL_ = input.readUInt32();
                                    break;
                                case 90:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.pathInfoList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.pathInfoList_.add((ExpeditionPathInfoOuterClass.ExpeditionPathInfo) input.readMessage(ExpeditionPathInfoOuterClass.ExpeditionPathInfo.parser(), extensionRegistry));
                                    break;
                                case 122:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.challengeInfoList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.challengeInfoList_.add((ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo) input.readMessage(ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 2) != 0) {
                    this.pathInfoList_ = Collections.unmodifiableList(this.pathInfoList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.challengeInfoList_ = Collections.unmodifiableList(this.challengeInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ExpeditionActivityDetailInfoOuterClass.internal_static_ExpeditionActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ExpeditionActivityDetailInfoOuterClass.internal_static_ExpeditionActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ExpeditionActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
        public int getUnk3300GJLCAJOFCKL() {
            return this.unk3300GJLCAJOFCKL_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
        public List<ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo> getChallengeInfoListList() {
            return this.challengeInfoList_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
        public List<? extends ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfoOrBuilder> getChallengeInfoListOrBuilderList() {
            return this.challengeInfoList_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
        public int getChallengeInfoListCount() {
            return this.challengeInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
        public ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo getChallengeInfoList(int index) {
            return this.challengeInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
        public ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfoOrBuilder getChallengeInfoListOrBuilder(int index) {
            return this.challengeInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
        public int getUnk3300MNPBCNEDKAJ() {
            return this.unk3300MNPBCNEDKAJ_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
        public List<ExpeditionPathInfoOuterClass.ExpeditionPathInfo> getPathInfoListList() {
            return this.pathInfoList_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
        public List<? extends ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder> getPathInfoListOrBuilderList() {
            return this.pathInfoList_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
        public int getPathInfoListCount() {
            return this.pathInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
        public ExpeditionPathInfoOuterClass.ExpeditionPathInfo getPathInfoList(int index) {
            return this.pathInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
        public ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder getPathInfoListOrBuilder(int index) {
            return this.pathInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
        public int getContentCloseTime() {
            return this.contentCloseTime_;
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
            if (this.unk3300MNPBCNEDKAJ_ != 0) {
                output.writeUInt32(3, this.unk3300MNPBCNEDKAJ_);
            }
            if (this.isContentClosed_) {
                output.writeBool(4, this.isContentClosed_);
            }
            if (this.contentCloseTime_ != 0) {
                output.writeUInt32(6, this.contentCloseTime_);
            }
            if (this.unk3300GJLCAJOFCKL_ != 0) {
                output.writeUInt32(9, this.unk3300GJLCAJOFCKL_);
            }
            for (int i = 0; i < this.pathInfoList_.size(); i++) {
                output.writeMessage(11, this.pathInfoList_.get(i));
            }
            for (int i2 = 0; i2 < this.challengeInfoList_.size(); i2++) {
                output.writeMessage(15, this.challengeInfoList_.get(i2));
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
            if (this.unk3300MNPBCNEDKAJ_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.unk3300MNPBCNEDKAJ_);
            }
            if (this.isContentClosed_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.isContentClosed_);
            }
            if (this.contentCloseTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.contentCloseTime_);
            }
            if (this.unk3300GJLCAJOFCKL_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.unk3300GJLCAJOFCKL_);
            }
            for (int i = 0; i < this.pathInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.pathInfoList_.get(i));
            }
            for (int i2 = 0; i2 < this.challengeInfoList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(15, this.challengeInfoList_.get(i2));
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
            if (!(obj instanceof ExpeditionActivityDetailInfo)) {
                return equals(obj);
            }
            ExpeditionActivityDetailInfo other = (ExpeditionActivityDetailInfo) obj;
            return getUnk3300GJLCAJOFCKL() == other.getUnk3300GJLCAJOFCKL() && getChallengeInfoListList().equals(other.getChallengeInfoListList()) && getUnk3300MNPBCNEDKAJ() == other.getUnk3300MNPBCNEDKAJ() && getPathInfoListList().equals(other.getPathInfoListList()) && getIsContentClosed() == other.getIsContentClosed() && getContentCloseTime() == other.getContentCloseTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getUnk3300GJLCAJOFCKL();
            if (getChallengeInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getChallengeInfoListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 3)) + getUnk3300MNPBCNEDKAJ();
            if (getPathInfoListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 11)) + getPathInfoListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * ((53 * ((37 * hash2) + 4)) + Internal.hashBoolean(getIsContentClosed()))) + 6)) + getContentCloseTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static ExpeditionActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ExpeditionActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ExpeditionActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ExpeditionActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ExpeditionActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ExpeditionActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ExpeditionActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (ExpeditionActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ExpeditionActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExpeditionActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ExpeditionActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ExpeditionActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ExpeditionActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExpeditionActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ExpeditionActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (ExpeditionActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ExpeditionActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExpeditionActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ExpeditionActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ExpeditionActivityDetailInfoOuterClass$ExpeditionActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ExpeditionActivityDetailInfoOrBuilder {
            private int bitField0_;
            private int unk3300GJLCAJOFCKL_;
            private RepeatedFieldBuilderV3<ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo, ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.Builder, ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfoOrBuilder> challengeInfoListBuilder_;
            private int unk3300MNPBCNEDKAJ_;
            private RepeatedFieldBuilderV3<ExpeditionPathInfoOuterClass.ExpeditionPathInfo, ExpeditionPathInfoOuterClass.ExpeditionPathInfo.Builder, ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder> pathInfoListBuilder_;
            private boolean isContentClosed_;
            private int contentCloseTime_;
            private List<ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo> challengeInfoList_ = Collections.emptyList();
            private List<ExpeditionPathInfoOuterClass.ExpeditionPathInfo> pathInfoList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ExpeditionActivityDetailInfoOuterClass.internal_static_ExpeditionActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ExpeditionActivityDetailInfoOuterClass.internal_static_ExpeditionActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ExpeditionActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ExpeditionActivityDetailInfo.alwaysUseFieldBuilders) {
                    getChallengeInfoListFieldBuilder();
                    getPathInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300GJLCAJOFCKL_ = 0;
                if (this.challengeInfoListBuilder_ == null) {
                    this.challengeInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.challengeInfoListBuilder_.clear();
                }
                this.unk3300MNPBCNEDKAJ_ = 0;
                if (this.pathInfoListBuilder_ == null) {
                    this.pathInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.pathInfoListBuilder_.clear();
                }
                this.isContentClosed_ = false;
                this.contentCloseTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ExpeditionActivityDetailInfoOuterClass.internal_static_ExpeditionActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ExpeditionActivityDetailInfo getDefaultInstanceForType() {
                return ExpeditionActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ExpeditionActivityDetailInfo build() {
                ExpeditionActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ExpeditionActivityDetailInfo buildPartial() {
                ExpeditionActivityDetailInfo result = new ExpeditionActivityDetailInfo(this);
                int i = this.bitField0_;
                result.unk3300GJLCAJOFCKL_ = this.unk3300GJLCAJOFCKL_;
                if (this.challengeInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.challengeInfoList_ = Collections.unmodifiableList(this.challengeInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.challengeInfoList_ = this.challengeInfoList_;
                } else {
                    result.challengeInfoList_ = this.challengeInfoListBuilder_.build();
                }
                result.unk3300MNPBCNEDKAJ_ = this.unk3300MNPBCNEDKAJ_;
                if (this.pathInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.pathInfoList_ = Collections.unmodifiableList(this.pathInfoList_);
                        this.bitField0_ &= -3;
                    }
                    result.pathInfoList_ = this.pathInfoList_;
                } else {
                    result.pathInfoList_ = this.pathInfoListBuilder_.build();
                }
                result.isContentClosed_ = this.isContentClosed_;
                result.contentCloseTime_ = this.contentCloseTime_;
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
                if (other instanceof ExpeditionActivityDetailInfo) {
                    return mergeFrom((ExpeditionActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ExpeditionActivityDetailInfo other) {
                if (other == ExpeditionActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300GJLCAJOFCKL() != 0) {
                    setUnk3300GJLCAJOFCKL(other.getUnk3300GJLCAJOFCKL());
                }
                if (this.challengeInfoListBuilder_ == null) {
                    if (!other.challengeInfoList_.isEmpty()) {
                        if (this.challengeInfoList_.isEmpty()) {
                            this.challengeInfoList_ = other.challengeInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureChallengeInfoListIsMutable();
                            this.challengeInfoList_.addAll(other.challengeInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.challengeInfoList_.isEmpty()) {
                    if (this.challengeInfoListBuilder_.isEmpty()) {
                        this.challengeInfoListBuilder_.dispose();
                        this.challengeInfoListBuilder_ = null;
                        this.challengeInfoList_ = other.challengeInfoList_;
                        this.bitField0_ &= -2;
                        this.challengeInfoListBuilder_ = ExpeditionActivityDetailInfo.alwaysUseFieldBuilders ? getChallengeInfoListFieldBuilder() : null;
                    } else {
                        this.challengeInfoListBuilder_.addAllMessages(other.challengeInfoList_);
                    }
                }
                if (other.getUnk3300MNPBCNEDKAJ() != 0) {
                    setUnk3300MNPBCNEDKAJ(other.getUnk3300MNPBCNEDKAJ());
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
                        this.pathInfoListBuilder_ = ExpeditionActivityDetailInfo.alwaysUseFieldBuilders ? getPathInfoListFieldBuilder() : null;
                    } else {
                        this.pathInfoListBuilder_.addAllMessages(other.pathInfoList_);
                    }
                }
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
                }
                if (other.getContentCloseTime() != 0) {
                    setContentCloseTime(other.getContentCloseTime());
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
                ExpeditionActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ExpeditionActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ExpeditionActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
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

            private void ensureChallengeInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.challengeInfoList_ = new ArrayList(this.challengeInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
            public List<ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo> getChallengeInfoListList() {
                if (this.challengeInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.challengeInfoList_);
                }
                return this.challengeInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
            public int getChallengeInfoListCount() {
                if (this.challengeInfoListBuilder_ == null) {
                    return this.challengeInfoList_.size();
                }
                return this.challengeInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
            public ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo getChallengeInfoList(int index) {
                if (this.challengeInfoListBuilder_ == null) {
                    return this.challengeInfoList_.get(index);
                }
                return this.challengeInfoListBuilder_.getMessage(index);
            }

            public Builder setChallengeInfoList(int index, ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo value) {
                if (this.challengeInfoListBuilder_ != null) {
                    this.challengeInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChallengeInfoListIsMutable();
                    this.challengeInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setChallengeInfoList(int index, ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.Builder builderForValue) {
                if (this.challengeInfoListBuilder_ == null) {
                    ensureChallengeInfoListIsMutable();
                    this.challengeInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.challengeInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addChallengeInfoList(ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo value) {
                if (this.challengeInfoListBuilder_ != null) {
                    this.challengeInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChallengeInfoListIsMutable();
                    this.challengeInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addChallengeInfoList(int index, ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo value) {
                if (this.challengeInfoListBuilder_ != null) {
                    this.challengeInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChallengeInfoListIsMutable();
                    this.challengeInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addChallengeInfoList(ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.Builder builderForValue) {
                if (this.challengeInfoListBuilder_ == null) {
                    ensureChallengeInfoListIsMutable();
                    this.challengeInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.challengeInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addChallengeInfoList(int index, ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.Builder builderForValue) {
                if (this.challengeInfoListBuilder_ == null) {
                    ensureChallengeInfoListIsMutable();
                    this.challengeInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.challengeInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllChallengeInfoList(Iterable<? extends ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo> values) {
                if (this.challengeInfoListBuilder_ == null) {
                    ensureChallengeInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.challengeInfoList_);
                    onChanged();
                } else {
                    this.challengeInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearChallengeInfoList() {
                if (this.challengeInfoListBuilder_ == null) {
                    this.challengeInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.challengeInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeChallengeInfoList(int index) {
                if (this.challengeInfoListBuilder_ == null) {
                    ensureChallengeInfoListIsMutable();
                    this.challengeInfoList_.remove(index);
                    onChanged();
                } else {
                    this.challengeInfoListBuilder_.remove(index);
                }
                return this;
            }

            public ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.Builder getChallengeInfoListBuilder(int index) {
                return getChallengeInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
            public ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfoOrBuilder getChallengeInfoListOrBuilder(int index) {
                if (this.challengeInfoListBuilder_ == null) {
                    return this.challengeInfoList_.get(index);
                }
                return this.challengeInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
            public List<? extends ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfoOrBuilder> getChallengeInfoListOrBuilderList() {
                if (this.challengeInfoListBuilder_ != null) {
                    return this.challengeInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.challengeInfoList_);
            }

            public ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.Builder addChallengeInfoListBuilder() {
                return getChallengeInfoListFieldBuilder().addBuilder(ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.getDefaultInstance());
            }

            public ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.Builder addChallengeInfoListBuilder(int index) {
                return getChallengeInfoListFieldBuilder().addBuilder(index, ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.getDefaultInstance());
            }

            public List<ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.Builder> getChallengeInfoListBuilderList() {
                return getChallengeInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo, ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfo.Builder, ExpeditionChallengeInfoOuterClass.ExpeditionChallengeInfoOrBuilder> getChallengeInfoListFieldBuilder() {
                if (this.challengeInfoListBuilder_ == null) {
                    this.challengeInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.challengeInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.challengeInfoList_ = null;
                }
                return this.challengeInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
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

            private void ensurePathInfoListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.pathInfoList_ = new ArrayList(this.pathInfoList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
            public List<ExpeditionPathInfoOuterClass.ExpeditionPathInfo> getPathInfoListList() {
                if (this.pathInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.pathInfoList_);
                }
                return this.pathInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
            public int getPathInfoListCount() {
                if (this.pathInfoListBuilder_ == null) {
                    return this.pathInfoList_.size();
                }
                return this.pathInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
            public ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder getPathInfoListOrBuilder(int index) {
                if (this.pathInfoListBuilder_ == null) {
                    return this.pathInfoList_.get(index);
                }
                return this.pathInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
            public boolean getIsContentClosed() {
                return this.isContentClosed_;
            }

            public Builder setIsContentClosed(boolean value) {
                this.isContentClosed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsContentClosed() {
                this.isContentClosed_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static ExpeditionActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ExpeditionActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ExpeditionActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ExpeditionActivityDetailInfo getDefaultInstanceForType() {
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
