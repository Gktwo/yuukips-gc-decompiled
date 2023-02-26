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
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.MailCollectStateOuterClass;
import emu.grasscutter.net.proto.MailItemOuterClass;
import emu.grasscutter.net.proto.MailTextContentOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MailDataOuterClass.class */
public final class MailDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000eMailData.proto\u001a\u0015MailTextContent.proto\u001a\u0016MailCollectState.proto\u001a\u000eMailItem.proto\"\u0002\n\bMailData\u0012\u000e\n\u0006mailId\u0018\u0001 \u0001(\r\u0012)\n\u000fmailTextContent\u0018\u0004 \u0001(\u000b2\u0010.MailTextContent\u0012\u001b\n\bitemList\u0018\u0007 \u0003(\u000b2\t.MailItem\u0012\u0010\n\bsendTime\u0018\b \u0001(\r\u0012\u0012\n\nexpireTime\u0018\t \u0001(\r\u0012\u0012\n\nimportance\u0018\n \u0001(\r\u0012\u000e\n\u0006isRead\u0018\u000b \u0001(\b\u0012\u0017\n\u000fisAttachmentGot\u0018\f \u0001(\b\u0012\u0010\n\bconfigId\u0018\r \u0001(\r\u0012\u0014\n\fargumentList\u0018\u000e \u0003(\t\u0012'\n\fcollectState\u0018\u000f \u0001(\u000e2\u0011.MailCollectStateB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MailTextContentOuterClass.getDescriptor(), MailCollectStateOuterClass.getDescriptor(), MailItemOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MailData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MailData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MailData_descriptor, new String[]{"MailId", "MailTextContent", "ItemList", "SendTime", "ExpireTime", "Importance", "IsRead", "IsAttachmentGot", "ConfigId", "ArgumentList", "CollectState"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MailDataOuterClass$MailDataOrBuilder.class */
    public interface MailDataOrBuilder extends MessageOrBuilder {
        int getMailId();

        boolean hasMailTextContent();

        MailTextContentOuterClass.MailTextContent getMailTextContent();

        MailTextContentOuterClass.MailTextContentOrBuilder getMailTextContentOrBuilder();

        List<MailItemOuterClass.MailItem> getItemListList();

        MailItemOuterClass.MailItem getItemList(int i);

        int getItemListCount();

        List<? extends MailItemOuterClass.MailItemOrBuilder> getItemListOrBuilderList();

        MailItemOuterClass.MailItemOrBuilder getItemListOrBuilder(int i);

        int getSendTime();

        int getExpireTime();

        int getImportance();

        boolean getIsRead();

        boolean getIsAttachmentGot();

        int getConfigId();

        List<String> getArgumentListList();

        int getArgumentListCount();

        String getArgumentList(int i);

        ByteString getArgumentListBytes(int i);

        int getCollectStateValue();

        MailCollectStateOuterClass.MailCollectState getCollectState();
    }

    private MailDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MailDataOuterClass$MailData.class */
    public static final class MailData extends GeneratedMessageV3 implements MailDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MAILID_FIELD_NUMBER = 1;
        private int mailId_;
        public static final int MAILTEXTCONTENT_FIELD_NUMBER = 4;
        private MailTextContentOuterClass.MailTextContent mailTextContent_;
        public static final int ITEMLIST_FIELD_NUMBER = 7;
        private List<MailItemOuterClass.MailItem> itemList_;
        public static final int SENDTIME_FIELD_NUMBER = 8;
        private int sendTime_;
        public static final int EXPIRETIME_FIELD_NUMBER = 9;
        private int expireTime_;
        public static final int IMPORTANCE_FIELD_NUMBER = 10;
        private int importance_;
        public static final int ISREAD_FIELD_NUMBER = 11;
        private boolean isRead_;
        public static final int ISATTACHMENTGOT_FIELD_NUMBER = 12;
        private boolean isAttachmentGot_;
        public static final int CONFIGID_FIELD_NUMBER = 13;
        private int configId_;
        public static final int ARGUMENTLIST_FIELD_NUMBER = 14;
        private LazyStringList argumentList_;
        public static final int COLLECTSTATE_FIELD_NUMBER = 15;
        private int collectState_;
        private byte memoizedIsInitialized;
        private static final MailData DEFAULT_INSTANCE = new MailData();
        private static final Parser<MailData> PARSER = new AbstractParser<MailData>() { // from class: emu.grasscutter.net.proto.MailDataOuterClass.MailData.1
            @Override // com.google.protobuf.Parser
            public MailData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MailData(input, extensionRegistry);
            }
        };

        private MailData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MailData() {
            this.memoizedIsInitialized = -1;
            this.itemList_ = Collections.emptyList();
            this.argumentList_ = LazyStringArrayList.EMPTY;
            this.collectState_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MailData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:82:0x0196 */
        private MailData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 8:
                                this.mailId_ = input.readUInt32();
                                break;
                            case 34:
                                MailTextContentOuterClass.MailTextContent.Builder subBuilder = this.mailTextContent_ != null ? this.mailTextContent_.toBuilder() : null;
                                this.mailTextContent_ = (MailTextContentOuterClass.MailTextContent) input.readMessage(MailTextContentOuterClass.MailTextContent.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.mailTextContent_);
                                    this.mailTextContent_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 58:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.itemList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.itemList_.add((MailItemOuterClass.MailItem) input.readMessage(MailItemOuterClass.MailItem.parser(), extensionRegistry));
                                break;
                            case 64:
                                this.sendTime_ = input.readUInt32();
                                break;
                            case 72:
                                this.expireTime_ = input.readUInt32();
                                break;
                            case 80:
                                this.importance_ = input.readUInt32();
                                break;
                            case 88:
                                this.isRead_ = input.readBool();
                                break;
                            case 96:
                                this.isAttachmentGot_ = input.readBool();
                                break;
                            case 104:
                                this.configId_ = input.readUInt32();
                                break;
                            case 114:
                                String s = input.readStringRequireUtf8();
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.argumentList_ = new LazyStringArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.argumentList_.add(s);
                                break;
                            case 120:
                                this.collectState_ = input.readEnum();
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
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.itemList_ = Collections.unmodifiableList(this.itemList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.argumentList_ = this.argumentList_.getUnmodifiableView();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MailDataOuterClass.internal_static_MailData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MailDataOuterClass.internal_static_MailData_fieldAccessorTable.ensureFieldAccessorsInitialized(MailData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
        public int getMailId() {
            return this.mailId_;
        }

        @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
        public boolean hasMailTextContent() {
            return this.mailTextContent_ != null;
        }

        @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
        public MailTextContentOuterClass.MailTextContent getMailTextContent() {
            return this.mailTextContent_ == null ? MailTextContentOuterClass.MailTextContent.getDefaultInstance() : this.mailTextContent_;
        }

        @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
        public MailTextContentOuterClass.MailTextContentOrBuilder getMailTextContentOrBuilder() {
            return getMailTextContent();
        }

        @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
        public List<MailItemOuterClass.MailItem> getItemListList() {
            return this.itemList_;
        }

        @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
        public List<? extends MailItemOuterClass.MailItemOrBuilder> getItemListOrBuilderList() {
            return this.itemList_;
        }

        @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
        public int getItemListCount() {
            return this.itemList_.size();
        }

        @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
        public MailItemOuterClass.MailItem getItemList(int index) {
            return this.itemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
        public MailItemOuterClass.MailItemOrBuilder getItemListOrBuilder(int index) {
            return this.itemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
        public int getSendTime() {
            return this.sendTime_;
        }

        @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
        public int getExpireTime() {
            return this.expireTime_;
        }

        @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
        public int getImportance() {
            return this.importance_;
        }

        @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
        public boolean getIsRead() {
            return this.isRead_;
        }

        @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
        public boolean getIsAttachmentGot() {
            return this.isAttachmentGot_;
        }

        @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
        public int getConfigId() {
            return this.configId_;
        }

        @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
        public ProtocolStringList getArgumentListList() {
            return this.argumentList_;
        }

        @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
        public int getArgumentListCount() {
            return this.argumentList_.size();
        }

        @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
        public String getArgumentList(int index) {
            return (String) this.argumentList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
        public ByteString getArgumentListBytes(int index) {
            return this.argumentList_.getByteString(index);
        }

        @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
        public int getCollectStateValue() {
            return this.collectState_;
        }

        @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
        public MailCollectStateOuterClass.MailCollectState getCollectState() {
            MailCollectStateOuterClass.MailCollectState result = MailCollectStateOuterClass.MailCollectState.valueOf(this.collectState_);
            return result == null ? MailCollectStateOuterClass.MailCollectState.UNRECOGNIZED : result;
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
            if (this.mailId_ != 0) {
                output.writeUInt32(1, this.mailId_);
            }
            if (this.mailTextContent_ != null) {
                output.writeMessage(4, getMailTextContent());
            }
            for (int i = 0; i < this.itemList_.size(); i++) {
                output.writeMessage(7, this.itemList_.get(i));
            }
            if (this.sendTime_ != 0) {
                output.writeUInt32(8, this.sendTime_);
            }
            if (this.expireTime_ != 0) {
                output.writeUInt32(9, this.expireTime_);
            }
            if (this.importance_ != 0) {
                output.writeUInt32(10, this.importance_);
            }
            if (this.isRead_) {
                output.writeBool(11, this.isRead_);
            }
            if (this.isAttachmentGot_) {
                output.writeBool(12, this.isAttachmentGot_);
            }
            if (this.configId_ != 0) {
                output.writeUInt32(13, this.configId_);
            }
            for (int i2 = 0; i2 < this.argumentList_.size(); i2++) {
                GeneratedMessageV3.writeString(output, 14, this.argumentList_.getRaw(i2));
            }
            if (this.collectState_ != MailCollectStateOuterClass.MailCollectState.MAIL_COLLECT_STATE_COLLECTIBLE_UNKNOWN.getNumber()) {
                output.writeEnum(15, this.collectState_);
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
            if (this.mailId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.mailId_);
            }
            if (this.mailTextContent_ != null) {
                size2 += CodedOutputStream.computeMessageSize(4, getMailTextContent());
            }
            for (int i = 0; i < this.itemList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.itemList_.get(i));
            }
            if (this.sendTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.sendTime_);
            }
            if (this.expireTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.expireTime_);
            }
            if (this.importance_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.importance_);
            }
            if (this.isRead_) {
                size2 += CodedOutputStream.computeBoolSize(11, this.isRead_);
            }
            if (this.isAttachmentGot_) {
                size2 += CodedOutputStream.computeBoolSize(12, this.isAttachmentGot_);
            }
            if (this.configId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.configId_);
            }
            int dataSize = 0;
            for (int i2 = 0; i2 < this.argumentList_.size(); i2++) {
                dataSize += computeStringSizeNoTag(this.argumentList_.getRaw(i2));
            }
            int size3 = size2 + dataSize + (1 * getArgumentListList().size());
            if (this.collectState_ != MailCollectStateOuterClass.MailCollectState.MAIL_COLLECT_STATE_COLLECTIBLE_UNKNOWN.getNumber()) {
                size3 += CodedOutputStream.computeEnumSize(15, this.collectState_);
            }
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MailData)) {
                return equals(obj);
            }
            MailData other = (MailData) obj;
            if (getMailId() == other.getMailId() && hasMailTextContent() == other.hasMailTextContent()) {
                return (!hasMailTextContent() || getMailTextContent().equals(other.getMailTextContent())) && getItemListList().equals(other.getItemListList()) && getSendTime() == other.getSendTime() && getExpireTime() == other.getExpireTime() && getImportance() == other.getImportance() && getIsRead() == other.getIsRead() && getIsAttachmentGot() == other.getIsAttachmentGot() && getConfigId() == other.getConfigId() && getArgumentListList().equals(other.getArgumentListList()) && this.collectState_ == other.collectState_ && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getMailId();
            if (hasMailTextContent()) {
                hash = (53 * ((37 * hash) + 4)) + getMailTextContent().hashCode();
            }
            if (getItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getItemListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 8)) + getSendTime())) + 9)) + getExpireTime())) + 10)) + getImportance())) + 11)) + Internal.hashBoolean(getIsRead()))) + 12)) + Internal.hashBoolean(getIsAttachmentGot()))) + 13)) + getConfigId();
            if (getArgumentListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 14)) + getArgumentListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 15)) + this.collectState_)) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static MailData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MailData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MailData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MailData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailData parseFrom(InputStream input) throws IOException {
            return (MailData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MailData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MailData parseDelimitedFrom(InputStream input) throws IOException {
            return (MailData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MailData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MailData parseFrom(CodedInputStream input) throws IOException {
            return (MailData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MailData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MailData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MailDataOuterClass$MailData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MailDataOrBuilder {
            private int bitField0_;
            private int mailId_;
            private MailTextContentOuterClass.MailTextContent mailTextContent_;
            private SingleFieldBuilderV3<MailTextContentOuterClass.MailTextContent, MailTextContentOuterClass.MailTextContent.Builder, MailTextContentOuterClass.MailTextContentOrBuilder> mailTextContentBuilder_;
            private RepeatedFieldBuilderV3<MailItemOuterClass.MailItem, MailItemOuterClass.MailItem.Builder, MailItemOuterClass.MailItemOrBuilder> itemListBuilder_;
            private int sendTime_;
            private int expireTime_;
            private int importance_;
            private boolean isRead_;
            private boolean isAttachmentGot_;
            private int configId_;
            private List<MailItemOuterClass.MailItem> itemList_ = Collections.emptyList();
            private LazyStringList argumentList_ = LazyStringArrayList.EMPTY;
            private int collectState_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return MailDataOuterClass.internal_static_MailData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MailDataOuterClass.internal_static_MailData_fieldAccessorTable.ensureFieldAccessorsInitialized(MailData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MailData.alwaysUseFieldBuilders) {
                    getItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.mailId_ = 0;
                if (this.mailTextContentBuilder_ == null) {
                    this.mailTextContent_ = null;
                } else {
                    this.mailTextContent_ = null;
                    this.mailTextContentBuilder_ = null;
                }
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.itemListBuilder_.clear();
                }
                this.sendTime_ = 0;
                this.expireTime_ = 0;
                this.importance_ = 0;
                this.isRead_ = false;
                this.isAttachmentGot_ = false;
                this.configId_ = 0;
                this.argumentList_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -3;
                this.collectState_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MailDataOuterClass.internal_static_MailData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MailData getDefaultInstanceForType() {
                return MailData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MailData build() {
                MailData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MailData buildPartial() {
                MailData result = new MailData(this);
                int i = this.bitField0_;
                result.mailId_ = this.mailId_;
                if (this.mailTextContentBuilder_ == null) {
                    result.mailTextContent_ = this.mailTextContent_;
                } else {
                    result.mailTextContent_ = this.mailTextContentBuilder_.build();
                }
                if (this.itemListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.itemList_ = Collections.unmodifiableList(this.itemList_);
                        this.bitField0_ &= -2;
                    }
                    result.itemList_ = this.itemList_;
                } else {
                    result.itemList_ = this.itemListBuilder_.build();
                }
                result.sendTime_ = this.sendTime_;
                result.expireTime_ = this.expireTime_;
                result.importance_ = this.importance_;
                result.isRead_ = this.isRead_;
                result.isAttachmentGot_ = this.isAttachmentGot_;
                result.configId_ = this.configId_;
                if ((this.bitField0_ & 2) != 0) {
                    this.argumentList_ = this.argumentList_.getUnmodifiableView();
                    this.bitField0_ &= -3;
                }
                result.argumentList_ = this.argumentList_;
                result.collectState_ = this.collectState_;
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
                if (other instanceof MailData) {
                    return mergeFrom((MailData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MailData other) {
                if (other == MailData.getDefaultInstance()) {
                    return this;
                }
                if (other.getMailId() != 0) {
                    setMailId(other.getMailId());
                }
                if (other.hasMailTextContent()) {
                    mergeMailTextContent(other.getMailTextContent());
                }
                if (this.itemListBuilder_ == null) {
                    if (!other.itemList_.isEmpty()) {
                        if (this.itemList_.isEmpty()) {
                            this.itemList_ = other.itemList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureItemListIsMutable();
                            this.itemList_.addAll(other.itemList_);
                        }
                        onChanged();
                    }
                } else if (!other.itemList_.isEmpty()) {
                    if (this.itemListBuilder_.isEmpty()) {
                        this.itemListBuilder_.dispose();
                        this.itemListBuilder_ = null;
                        this.itemList_ = other.itemList_;
                        this.bitField0_ &= -2;
                        this.itemListBuilder_ = MailData.alwaysUseFieldBuilders ? getItemListFieldBuilder() : null;
                    } else {
                        this.itemListBuilder_.addAllMessages(other.itemList_);
                    }
                }
                if (other.getSendTime() != 0) {
                    setSendTime(other.getSendTime());
                }
                if (other.getExpireTime() != 0) {
                    setExpireTime(other.getExpireTime());
                }
                if (other.getImportance() != 0) {
                    setImportance(other.getImportance());
                }
                if (other.getIsRead()) {
                    setIsRead(other.getIsRead());
                }
                if (other.getIsAttachmentGot()) {
                    setIsAttachmentGot(other.getIsAttachmentGot());
                }
                if (other.getConfigId() != 0) {
                    setConfigId(other.getConfigId());
                }
                if (!other.argumentList_.isEmpty()) {
                    if (this.argumentList_.isEmpty()) {
                        this.argumentList_ = other.argumentList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureArgumentListIsMutable();
                        this.argumentList_.addAll(other.argumentList_);
                    }
                    onChanged();
                }
                if (other.collectState_ != 0) {
                    setCollectStateValue(other.getCollectStateValue());
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
                MailData parsedMessage = null;
                try {
                    try {
                        parsedMessage = MailData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MailData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
            public int getMailId() {
                return this.mailId_;
            }

            public Builder setMailId(int value) {
                this.mailId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMailId() {
                this.mailId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
            public boolean hasMailTextContent() {
                return (this.mailTextContentBuilder_ == null && this.mailTextContent_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
            public MailTextContentOuterClass.MailTextContent getMailTextContent() {
                if (this.mailTextContentBuilder_ == null) {
                    return this.mailTextContent_ == null ? MailTextContentOuterClass.MailTextContent.getDefaultInstance() : this.mailTextContent_;
                }
                return this.mailTextContentBuilder_.getMessage();
            }

            public Builder setMailTextContent(MailTextContentOuterClass.MailTextContent value) {
                if (this.mailTextContentBuilder_ != null) {
                    this.mailTextContentBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.mailTextContent_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setMailTextContent(MailTextContentOuterClass.MailTextContent.Builder builderForValue) {
                if (this.mailTextContentBuilder_ == null) {
                    this.mailTextContent_ = builderForValue.build();
                    onChanged();
                } else {
                    this.mailTextContentBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeMailTextContent(MailTextContentOuterClass.MailTextContent value) {
                if (this.mailTextContentBuilder_ == null) {
                    if (this.mailTextContent_ != null) {
                        this.mailTextContent_ = MailTextContentOuterClass.MailTextContent.newBuilder(this.mailTextContent_).mergeFrom(value).buildPartial();
                    } else {
                        this.mailTextContent_ = value;
                    }
                    onChanged();
                } else {
                    this.mailTextContentBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearMailTextContent() {
                if (this.mailTextContentBuilder_ == null) {
                    this.mailTextContent_ = null;
                    onChanged();
                } else {
                    this.mailTextContent_ = null;
                    this.mailTextContentBuilder_ = null;
                }
                return this;
            }

            public MailTextContentOuterClass.MailTextContent.Builder getMailTextContentBuilder() {
                onChanged();
                return getMailTextContentFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
            public MailTextContentOuterClass.MailTextContentOrBuilder getMailTextContentOrBuilder() {
                if (this.mailTextContentBuilder_ != null) {
                    return this.mailTextContentBuilder_.getMessageOrBuilder();
                }
                return this.mailTextContent_ == null ? MailTextContentOuterClass.MailTextContent.getDefaultInstance() : this.mailTextContent_;
            }

            private SingleFieldBuilderV3<MailTextContentOuterClass.MailTextContent, MailTextContentOuterClass.MailTextContent.Builder, MailTextContentOuterClass.MailTextContentOrBuilder> getMailTextContentFieldBuilder() {
                if (this.mailTextContentBuilder_ == null) {
                    this.mailTextContentBuilder_ = new SingleFieldBuilderV3<>(getMailTextContent(), getParentForChildren(), isClean());
                    this.mailTextContent_ = null;
                }
                return this.mailTextContentBuilder_;
            }

            private void ensureItemListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.itemList_ = new ArrayList(this.itemList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
            public List<MailItemOuterClass.MailItem> getItemListList() {
                if (this.itemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.itemList_);
                }
                return this.itemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
            public int getItemListCount() {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.size();
                }
                return this.itemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
            public MailItemOuterClass.MailItem getItemList(int index) {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.get(index);
                }
                return this.itemListBuilder_.getMessage(index);
            }

            public Builder setItemList(int index, MailItemOuterClass.MailItem value) {
                if (this.itemListBuilder_ != null) {
                    this.itemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemListIsMutable();
                    this.itemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setItemList(int index, MailItemOuterClass.MailItem.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addItemList(MailItemOuterClass.MailItem value) {
                if (this.itemListBuilder_ != null) {
                    this.itemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemListIsMutable();
                    this.itemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addItemList(int index, MailItemOuterClass.MailItem value) {
                if (this.itemListBuilder_ != null) {
                    this.itemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemListIsMutable();
                    this.itemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addItemList(MailItemOuterClass.MailItem.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addItemList(int index, MailItemOuterClass.MailItem.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllItemList(Iterable<? extends MailItemOuterClass.MailItem> values) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.itemList_);
                    onChanged();
                } else {
                    this.itemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearItemList() {
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.itemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeItemList(int index) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.remove(index);
                    onChanged();
                } else {
                    this.itemListBuilder_.remove(index);
                }
                return this;
            }

            public MailItemOuterClass.MailItem.Builder getItemListBuilder(int index) {
                return getItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
            public MailItemOuterClass.MailItemOrBuilder getItemListOrBuilder(int index) {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.get(index);
                }
                return this.itemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
            public List<? extends MailItemOuterClass.MailItemOrBuilder> getItemListOrBuilderList() {
                if (this.itemListBuilder_ != null) {
                    return this.itemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.itemList_);
            }

            public MailItemOuterClass.MailItem.Builder addItemListBuilder() {
                return getItemListFieldBuilder().addBuilder(MailItemOuterClass.MailItem.getDefaultInstance());
            }

            public MailItemOuterClass.MailItem.Builder addItemListBuilder(int index) {
                return getItemListFieldBuilder().addBuilder(index, MailItemOuterClass.MailItem.getDefaultInstance());
            }

            public List<MailItemOuterClass.MailItem.Builder> getItemListBuilderList() {
                return getItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<MailItemOuterClass.MailItem, MailItemOuterClass.MailItem.Builder, MailItemOuterClass.MailItemOrBuilder> getItemListFieldBuilder() {
                if (this.itemListBuilder_ == null) {
                    this.itemListBuilder_ = new RepeatedFieldBuilderV3<>(this.itemList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.itemList_ = null;
                }
                return this.itemListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
            public int getSendTime() {
                return this.sendTime_;
            }

            public Builder setSendTime(int value) {
                this.sendTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearSendTime() {
                this.sendTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
            public int getExpireTime() {
                return this.expireTime_;
            }

            public Builder setExpireTime(int value) {
                this.expireTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearExpireTime() {
                this.expireTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
            public int getImportance() {
                return this.importance_;
            }

            public Builder setImportance(int value) {
                this.importance_ = value;
                onChanged();
                return this;
            }

            public Builder clearImportance() {
                this.importance_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
            public boolean getIsRead() {
                return this.isRead_;
            }

            public Builder setIsRead(boolean value) {
                this.isRead_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsRead() {
                this.isRead_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
            public boolean getIsAttachmentGot() {
                return this.isAttachmentGot_;
            }

            public Builder setIsAttachmentGot(boolean value) {
                this.isAttachmentGot_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsAttachmentGot() {
                this.isAttachmentGot_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
            public int getConfigId() {
                return this.configId_;
            }

            public Builder setConfigId(int value) {
                this.configId_ = value;
                onChanged();
                return this;
            }

            public Builder clearConfigId() {
                this.configId_ = 0;
                onChanged();
                return this;
            }

            private void ensureArgumentListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.argumentList_ = new LazyStringArrayList(this.argumentList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
            public ProtocolStringList getArgumentListList() {
                return this.argumentList_.getUnmodifiableView();
            }

            @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
            public int getArgumentListCount() {
                return this.argumentList_.size();
            }

            @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
            public String getArgumentList(int index) {
                return (String) this.argumentList_.get(index);
            }

            @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
            public ByteString getArgumentListBytes(int index) {
                return this.argumentList_.getByteString(index);
            }

            public Builder setArgumentList(int index, String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureArgumentListIsMutable();
                this.argumentList_.set(index, value);
                onChanged();
                return this;
            }

            public Builder addArgumentList(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureArgumentListIsMutable();
                this.argumentList_.add(value);
                onChanged();
                return this;
            }

            public Builder addAllArgumentList(Iterable<String> values) {
                ensureArgumentListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.argumentList_);
                onChanged();
                return this;
            }

            public Builder clearArgumentList() {
                this.argumentList_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            public Builder addArgumentListBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                MailData.checkByteStringIsUtf8(value);
                ensureArgumentListIsMutable();
                this.argumentList_.add(value);
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
            public int getCollectStateValue() {
                return this.collectState_;
            }

            public Builder setCollectStateValue(int value) {
                this.collectState_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MailDataOuterClass.MailDataOrBuilder
            public MailCollectStateOuterClass.MailCollectState getCollectState() {
                MailCollectStateOuterClass.MailCollectState result = MailCollectStateOuterClass.MailCollectState.valueOf(this.collectState_);
                return result == null ? MailCollectStateOuterClass.MailCollectState.UNRECOGNIZED : result;
            }

            public Builder setCollectState(MailCollectStateOuterClass.MailCollectState value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.collectState_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearCollectState() {
                this.collectState_ = 0;
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

        public static MailData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MailData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MailData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MailData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MailTextContentOuterClass.getDescriptor();
        MailCollectStateOuterClass.getDescriptor();
        MailItemOuterClass.getDescriptor();
    }
}
