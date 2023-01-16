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
import emu.grasscutter.net.proto.BattlePassRewardTakeOptionOuterClass;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeBattlePassRewardRspOuterClass.class */
public final class TakeBattlePassRewardRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dTakeBattlePassRewardRsp.proto\u001a BattlePassRewardTakeOption.proto\u001a\u000fItemParam.proto\"\u0001\n\u0017TakeBattlePassRewardRsp\u0012\u000f\n\u0007retcode\u0018\u0006 \u0001(\u0005\u00125\n\u0010take_option_list\u0018\u0007 \u0003(\u000b2\u001b.BattlePassRewardTakeOption\u0012\u001d\n\titem_list\u0018\u0004 \u0003(\u000b2\n.ItemParamB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BattlePassRewardTakeOptionOuterClass.getDescriptor(), ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TakeBattlePassRewardRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TakeBattlePassRewardRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TakeBattlePassRewardRsp_descriptor, new String[]{"Retcode", "TakeOptionList", "ItemList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeBattlePassRewardRspOuterClass$TakeBattlePassRewardRspOrBuilder.class */
    public interface TakeBattlePassRewardRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        List<BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption> getTakeOptionListList();

        BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption getTakeOptionList(int i);

        int getTakeOptionListCount();

        List<? extends BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder> getTakeOptionListOrBuilderList();

        BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder getTakeOptionListOrBuilder(int i);

        List<ItemParamOuterClass.ItemParam> getItemListList();

        ItemParamOuterClass.ItemParam getItemList(int i);

        int getItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getItemListOrBuilder(int i);
    }

    private TakeBattlePassRewardRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeBattlePassRewardRspOuterClass$TakeBattlePassRewardRsp.class */
    public static final class TakeBattlePassRewardRsp extends GeneratedMessageV3 implements TakeBattlePassRewardRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 6;
        private int retcode_;
        public static final int TAKE_OPTION_LIST_FIELD_NUMBER = 7;
        private List<BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption> takeOptionList_;
        public static final int ITEM_LIST_FIELD_NUMBER = 4;
        private List<ItemParamOuterClass.ItemParam> itemList_;
        private byte memoizedIsInitialized;
        private static final TakeBattlePassRewardRsp DEFAULT_INSTANCE = new TakeBattlePassRewardRsp();
        private static final Parser<TakeBattlePassRewardRsp> PARSER = new AbstractParser<TakeBattlePassRewardRsp>() { // from class: emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRsp.1
            @Override // com.google.protobuf.Parser
            public TakeBattlePassRewardRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TakeBattlePassRewardRsp(input, extensionRegistry);
            }
        };

        private TakeBattlePassRewardRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TakeBattlePassRewardRsp() {
            this.memoizedIsInitialized = -1;
            this.takeOptionList_ = Collections.emptyList();
            this.itemList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TakeBattlePassRewardRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:60:0x00cb */
        private TakeBattlePassRewardRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 34:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.itemList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.itemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                break;
                            case 48:
                                this.retcode_ = input.readInt32();
                                break;
                            case 58:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.takeOptionList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.takeOptionList_.add((BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption) input.readMessage(BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 2) != 0) {
                    this.itemList_ = Collections.unmodifiableList(this.itemList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.takeOptionList_ = Collections.unmodifiableList(this.takeOptionList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TakeBattlePassRewardRspOuterClass.internal_static_TakeBattlePassRewardRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TakeBattlePassRewardRspOuterClass.internal_static_TakeBattlePassRewardRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(TakeBattlePassRewardRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRspOrBuilder
        public List<BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption> getTakeOptionListList() {
            return this.takeOptionList_;
        }

        @Override // emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRspOrBuilder
        public List<? extends BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder> getTakeOptionListOrBuilderList() {
            return this.takeOptionList_;
        }

        @Override // emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRspOrBuilder
        public int getTakeOptionListCount() {
            return this.takeOptionList_.size();
        }

        @Override // emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRspOrBuilder
        public BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption getTakeOptionList(int index) {
            return this.takeOptionList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRspOrBuilder
        public BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder getTakeOptionListOrBuilder(int index) {
            return this.takeOptionList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRspOrBuilder
        public List<ItemParamOuterClass.ItemParam> getItemListList() {
            return this.itemList_;
        }

        @Override // emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRspOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemListOrBuilderList() {
            return this.itemList_;
        }

        @Override // emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRspOrBuilder
        public int getItemListCount() {
            return this.itemList_.size();
        }

        @Override // emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRspOrBuilder
        public ItemParamOuterClass.ItemParam getItemList(int index) {
            return this.itemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRspOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getItemListOrBuilder(int index) {
            return this.itemList_.get(index);
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
            for (int i = 0; i < this.itemList_.size(); i++) {
                output.writeMessage(4, this.itemList_.get(i));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(6, this.retcode_);
            }
            for (int i2 = 0; i2 < this.takeOptionList_.size(); i2++) {
                output.writeMessage(7, this.takeOptionList_.get(i2));
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
            for (int i = 0; i < this.itemList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.itemList_.get(i));
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(6, this.retcode_);
            }
            for (int i2 = 0; i2 < this.takeOptionList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.takeOptionList_.get(i2));
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
            if (!(obj instanceof TakeBattlePassRewardRsp)) {
                return equals(obj);
            }
            TakeBattlePassRewardRsp other = (TakeBattlePassRewardRsp) obj;
            return getRetcode() == other.getRetcode() && getTakeOptionListList().equals(other.getTakeOptionListList()) && getItemListList().equals(other.getItemListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getRetcode();
            if (getTakeOptionListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getTakeOptionListList().hashCode();
            }
            if (getItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getItemListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TakeBattlePassRewardRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeBattlePassRewardRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeBattlePassRewardRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeBattlePassRewardRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeBattlePassRewardRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeBattlePassRewardRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeBattlePassRewardRsp parseFrom(InputStream input) throws IOException {
            return (TakeBattlePassRewardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeBattlePassRewardRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeBattlePassRewardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeBattlePassRewardRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (TakeBattlePassRewardRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TakeBattlePassRewardRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeBattlePassRewardRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeBattlePassRewardRsp parseFrom(CodedInputStream input) throws IOException {
            return (TakeBattlePassRewardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeBattlePassRewardRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeBattlePassRewardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TakeBattlePassRewardRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeBattlePassRewardRspOuterClass$TakeBattlePassRewardRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TakeBattlePassRewardRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private RepeatedFieldBuilderV3<BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption, BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.Builder, BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder> takeOptionListBuilder_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> itemListBuilder_;
            private List<BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption> takeOptionList_ = Collections.emptyList();
            private List<ItemParamOuterClass.ItemParam> itemList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return TakeBattlePassRewardRspOuterClass.internal_static_TakeBattlePassRewardRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TakeBattlePassRewardRspOuterClass.internal_static_TakeBattlePassRewardRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(TakeBattlePassRewardRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TakeBattlePassRewardRsp.alwaysUseFieldBuilders) {
                    getTakeOptionListFieldBuilder();
                    getItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                if (this.takeOptionListBuilder_ == null) {
                    this.takeOptionList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.takeOptionListBuilder_.clear();
                }
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.itemListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TakeBattlePassRewardRspOuterClass.internal_static_TakeBattlePassRewardRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TakeBattlePassRewardRsp getDefaultInstanceForType() {
                return TakeBattlePassRewardRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeBattlePassRewardRsp build() {
                TakeBattlePassRewardRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeBattlePassRewardRsp buildPartial() {
                TakeBattlePassRewardRsp result = new TakeBattlePassRewardRsp(this);
                int i = this.bitField0_;
                result.retcode_ = this.retcode_;
                if (this.takeOptionListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.takeOptionList_ = Collections.unmodifiableList(this.takeOptionList_);
                        this.bitField0_ &= -2;
                    }
                    result.takeOptionList_ = this.takeOptionList_;
                } else {
                    result.takeOptionList_ = this.takeOptionListBuilder_.build();
                }
                if (this.itemListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.itemList_ = Collections.unmodifiableList(this.itemList_);
                        this.bitField0_ &= -3;
                    }
                    result.itemList_ = this.itemList_;
                } else {
                    result.itemList_ = this.itemListBuilder_.build();
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
                if (other instanceof TakeBattlePassRewardRsp) {
                    return mergeFrom((TakeBattlePassRewardRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TakeBattlePassRewardRsp other) {
                if (other == TakeBattlePassRewardRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (this.takeOptionListBuilder_ == null) {
                    if (!other.takeOptionList_.isEmpty()) {
                        if (this.takeOptionList_.isEmpty()) {
                            this.takeOptionList_ = other.takeOptionList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureTakeOptionListIsMutable();
                            this.takeOptionList_.addAll(other.takeOptionList_);
                        }
                        onChanged();
                    }
                } else if (!other.takeOptionList_.isEmpty()) {
                    if (this.takeOptionListBuilder_.isEmpty()) {
                        this.takeOptionListBuilder_.dispose();
                        this.takeOptionListBuilder_ = null;
                        this.takeOptionList_ = other.takeOptionList_;
                        this.bitField0_ &= -2;
                        this.takeOptionListBuilder_ = TakeBattlePassRewardRsp.alwaysUseFieldBuilders ? getTakeOptionListFieldBuilder() : null;
                    } else {
                        this.takeOptionListBuilder_.addAllMessages(other.takeOptionList_);
                    }
                }
                if (this.itemListBuilder_ == null) {
                    if (!other.itemList_.isEmpty()) {
                        if (this.itemList_.isEmpty()) {
                            this.itemList_ = other.itemList_;
                            this.bitField0_ &= -3;
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
                        this.bitField0_ &= -3;
                        this.itemListBuilder_ = TakeBattlePassRewardRsp.alwaysUseFieldBuilders ? getItemListFieldBuilder() : null;
                    } else {
                        this.itemListBuilder_.addAllMessages(other.itemList_);
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
                TakeBattlePassRewardRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = TakeBattlePassRewardRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TakeBattlePassRewardRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
                onChanged();
                return this;
            }

            private void ensureTakeOptionListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.takeOptionList_ = new ArrayList(this.takeOptionList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRspOrBuilder
            public List<BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption> getTakeOptionListList() {
                if (this.takeOptionListBuilder_ == null) {
                    return Collections.unmodifiableList(this.takeOptionList_);
                }
                return this.takeOptionListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRspOrBuilder
            public int getTakeOptionListCount() {
                if (this.takeOptionListBuilder_ == null) {
                    return this.takeOptionList_.size();
                }
                return this.takeOptionListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRspOrBuilder
            public BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption getTakeOptionList(int index) {
                if (this.takeOptionListBuilder_ == null) {
                    return this.takeOptionList_.get(index);
                }
                return this.takeOptionListBuilder_.getMessage(index);
            }

            public Builder setTakeOptionList(int index, BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption value) {
                if (this.takeOptionListBuilder_ != null) {
                    this.takeOptionListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTakeOptionListIsMutable();
                    this.takeOptionList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTakeOptionList(int index, BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.Builder builderForValue) {
                if (this.takeOptionListBuilder_ == null) {
                    ensureTakeOptionListIsMutable();
                    this.takeOptionList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.takeOptionListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTakeOptionList(BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption value) {
                if (this.takeOptionListBuilder_ != null) {
                    this.takeOptionListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTakeOptionListIsMutable();
                    this.takeOptionList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTakeOptionList(int index, BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption value) {
                if (this.takeOptionListBuilder_ != null) {
                    this.takeOptionListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTakeOptionListIsMutable();
                    this.takeOptionList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTakeOptionList(BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.Builder builderForValue) {
                if (this.takeOptionListBuilder_ == null) {
                    ensureTakeOptionListIsMutable();
                    this.takeOptionList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.takeOptionListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTakeOptionList(int index, BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.Builder builderForValue) {
                if (this.takeOptionListBuilder_ == null) {
                    ensureTakeOptionListIsMutable();
                    this.takeOptionList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.takeOptionListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTakeOptionList(Iterable<? extends BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption> values) {
                if (this.takeOptionListBuilder_ == null) {
                    ensureTakeOptionListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.takeOptionList_);
                    onChanged();
                } else {
                    this.takeOptionListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTakeOptionList() {
                if (this.takeOptionListBuilder_ == null) {
                    this.takeOptionList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.takeOptionListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTakeOptionList(int index) {
                if (this.takeOptionListBuilder_ == null) {
                    ensureTakeOptionListIsMutable();
                    this.takeOptionList_.remove(index);
                    onChanged();
                } else {
                    this.takeOptionListBuilder_.remove(index);
                }
                return this;
            }

            public BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.Builder getTakeOptionListBuilder(int index) {
                return getTakeOptionListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRspOrBuilder
            public BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder getTakeOptionListOrBuilder(int index) {
                if (this.takeOptionListBuilder_ == null) {
                    return this.takeOptionList_.get(index);
                }
                return this.takeOptionListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRspOrBuilder
            public List<? extends BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder> getTakeOptionListOrBuilderList() {
                if (this.takeOptionListBuilder_ != null) {
                    return this.takeOptionListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.takeOptionList_);
            }

            public BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.Builder addTakeOptionListBuilder() {
                return getTakeOptionListFieldBuilder().addBuilder(BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.getDefaultInstance());
            }

            public BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.Builder addTakeOptionListBuilder(int index) {
                return getTakeOptionListFieldBuilder().addBuilder(index, BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.getDefaultInstance());
            }

            public List<BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.Builder> getTakeOptionListBuilderList() {
                return getTakeOptionListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption, BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.Builder, BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder> getTakeOptionListFieldBuilder() {
                if (this.takeOptionListBuilder_ == null) {
                    this.takeOptionListBuilder_ = new RepeatedFieldBuilderV3<>(this.takeOptionList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.takeOptionList_ = null;
                }
                return this.takeOptionListBuilder_;
            }

            private void ensureItemListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.itemList_ = new ArrayList(this.itemList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRspOrBuilder
            public List<ItemParamOuterClass.ItemParam> getItemListList() {
                if (this.itemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.itemList_);
                }
                return this.itemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRspOrBuilder
            public int getItemListCount() {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.size();
                }
                return this.itemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRspOrBuilder
            public ItemParamOuterClass.ItemParam getItemList(int index) {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.get(index);
                }
                return this.itemListBuilder_.getMessage(index);
            }

            public Builder setItemList(int index, ItemParamOuterClass.ItemParam value) {
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

            public Builder setItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addItemList(ItemParamOuterClass.ItemParam value) {
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

            public Builder addItemList(int index, ItemParamOuterClass.ItemParam value) {
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

            public Builder addItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
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
                    this.bitField0_ &= -3;
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

            public ItemParamOuterClass.ItemParam.Builder getItemListBuilder(int index) {
                return getItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRspOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getItemListOrBuilder(int index) {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.get(index);
                }
                return this.itemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRspOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemListOrBuilderList() {
                if (this.itemListBuilder_ != null) {
                    return this.itemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.itemList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addItemListBuilder() {
                return getItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addItemListBuilder(int index) {
                return getItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getItemListBuilderList() {
                return getItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getItemListFieldBuilder() {
                if (this.itemListBuilder_ == null) {
                    this.itemListBuilder_ = new RepeatedFieldBuilderV3<>(this.itemList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.itemList_ = null;
                }
                return this.itemListBuilder_;
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

        public static TakeBattlePassRewardRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TakeBattlePassRewardRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TakeBattlePassRewardRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TakeBattlePassRewardRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BattlePassRewardTakeOptionOuterClass.getDescriptor();
        ItemParamOuterClass.getDescriptor();
    }
}
