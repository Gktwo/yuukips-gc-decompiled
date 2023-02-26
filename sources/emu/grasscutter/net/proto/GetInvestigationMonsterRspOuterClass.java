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
import emu.grasscutter.net.proto.InvestigationMonsterOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetInvestigationMonsterRspOuterClass.class */
public final class GetInvestigationMonsterRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n GetInvestigationMonsterRsp.proto\u001a\u001aInvestigationMonster.proto\"m\n\u001aGetInvestigationMonsterRsp\u0012\u000f\n\u0007retcode\u0018\u0006 \u0001(\u0005\u0012+\n\fmonster_list\u0018\u0002 \u0003(\u000b2\u0015.InvestigationMonster\u0012\u0011\n\tisForMark\u0018\u000b \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{InvestigationMonsterOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetInvestigationMonsterRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetInvestigationMonsterRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetInvestigationMonsterRsp_descriptor, new String[]{"Retcode", "MonsterList", "IsForMark"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetInvestigationMonsterRspOuterClass$GetInvestigationMonsterRspOrBuilder.class */
    public interface GetInvestigationMonsterRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        List<InvestigationMonsterOuterClass.InvestigationMonster> getMonsterListList();

        InvestigationMonsterOuterClass.InvestigationMonster getMonsterList(int i);

        int getMonsterListCount();

        List<? extends InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder> getMonsterListOrBuilderList();

        InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder getMonsterListOrBuilder(int i);

        boolean getIsForMark();
    }

    private GetInvestigationMonsterRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetInvestigationMonsterRspOuterClass$GetInvestigationMonsterRsp.class */
    public static final class GetInvestigationMonsterRsp extends GeneratedMessageV3 implements GetInvestigationMonsterRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 6;
        private int retcode_;
        public static final int MONSTER_LIST_FIELD_NUMBER = 2;
        private List<InvestigationMonsterOuterClass.InvestigationMonster> monsterList_;
        public static final int ISFORMARK_FIELD_NUMBER = 11;
        private boolean isForMark_;
        private byte memoizedIsInitialized;
        private static final GetInvestigationMonsterRsp DEFAULT_INSTANCE = new GetInvestigationMonsterRsp();
        private static final Parser<GetInvestigationMonsterRsp> PARSER = new AbstractParser<GetInvestigationMonsterRsp>() { // from class: emu.grasscutter.net.proto.GetInvestigationMonsterRspOuterClass.GetInvestigationMonsterRsp.1
            @Override // com.google.protobuf.Parser
            public GetInvestigationMonsterRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetInvestigationMonsterRsp(input, extensionRegistry);
            }
        };

        private GetInvestigationMonsterRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetInvestigationMonsterRsp() {
            this.memoizedIsInitialized = -1;
            this.monsterList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetInvestigationMonsterRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetInvestigationMonsterRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 18:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.monsterList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.monsterList_.add((InvestigationMonsterOuterClass.InvestigationMonster) input.readMessage(InvestigationMonsterOuterClass.InvestigationMonster.parser(), extensionRegistry));
                                break;
                            case 48:
                                this.retcode_ = input.readInt32();
                                break;
                            case 88:
                                this.isForMark_ = input.readBool();
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
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.monsterList_ = Collections.unmodifiableList(this.monsterList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetInvestigationMonsterRspOuterClass.internal_static_GetInvestigationMonsterRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetInvestigationMonsterRspOuterClass.internal_static_GetInvestigationMonsterRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetInvestigationMonsterRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetInvestigationMonsterRspOuterClass.GetInvestigationMonsterRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GetInvestigationMonsterRspOuterClass.GetInvestigationMonsterRspOrBuilder
        public List<InvestigationMonsterOuterClass.InvestigationMonster> getMonsterListList() {
            return this.monsterList_;
        }

        @Override // emu.grasscutter.net.proto.GetInvestigationMonsterRspOuterClass.GetInvestigationMonsterRspOrBuilder
        public List<? extends InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder> getMonsterListOrBuilderList() {
            return this.monsterList_;
        }

        @Override // emu.grasscutter.net.proto.GetInvestigationMonsterRspOuterClass.GetInvestigationMonsterRspOrBuilder
        public int getMonsterListCount() {
            return this.monsterList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetInvestigationMonsterRspOuterClass.GetInvestigationMonsterRspOrBuilder
        public InvestigationMonsterOuterClass.InvestigationMonster getMonsterList(int index) {
            return this.monsterList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetInvestigationMonsterRspOuterClass.GetInvestigationMonsterRspOrBuilder
        public InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder getMonsterListOrBuilder(int index) {
            return this.monsterList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetInvestigationMonsterRspOuterClass.GetInvestigationMonsterRspOrBuilder
        public boolean getIsForMark() {
            return this.isForMark_;
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
            for (int i = 0; i < this.monsterList_.size(); i++) {
                output.writeMessage(2, this.monsterList_.get(i));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(6, this.retcode_);
            }
            if (this.isForMark_) {
                output.writeBool(11, this.isForMark_);
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
            for (int i = 0; i < this.monsterList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.monsterList_.get(i));
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(6, this.retcode_);
            }
            if (this.isForMark_) {
                size2 += CodedOutputStream.computeBoolSize(11, this.isForMark_);
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
            if (!(obj instanceof GetInvestigationMonsterRsp)) {
                return equals(obj);
            }
            GetInvestigationMonsterRsp other = (GetInvestigationMonsterRsp) obj;
            return getRetcode() == other.getRetcode() && getMonsterListList().equals(other.getMonsterListList()) && getIsForMark() == other.getIsForMark() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getRetcode();
            if (getMonsterListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getMonsterListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 11)) + Internal.hashBoolean(getIsForMark()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetInvestigationMonsterRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetInvestigationMonsterRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetInvestigationMonsterRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetInvestigationMonsterRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetInvestigationMonsterRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetInvestigationMonsterRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetInvestigationMonsterRsp parseFrom(InputStream input) throws IOException {
            return (GetInvestigationMonsterRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetInvestigationMonsterRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetInvestigationMonsterRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetInvestigationMonsterRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetInvestigationMonsterRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetInvestigationMonsterRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetInvestigationMonsterRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetInvestigationMonsterRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetInvestigationMonsterRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetInvestigationMonsterRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetInvestigationMonsterRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetInvestigationMonsterRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetInvestigationMonsterRspOuterClass$GetInvestigationMonsterRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetInvestigationMonsterRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private List<InvestigationMonsterOuterClass.InvestigationMonster> monsterList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<InvestigationMonsterOuterClass.InvestigationMonster, InvestigationMonsterOuterClass.InvestigationMonster.Builder, InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder> monsterListBuilder_;
            private boolean isForMark_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetInvestigationMonsterRspOuterClass.internal_static_GetInvestigationMonsterRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetInvestigationMonsterRspOuterClass.internal_static_GetInvestigationMonsterRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetInvestigationMonsterRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetInvestigationMonsterRsp.alwaysUseFieldBuilders) {
                    getMonsterListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                if (this.monsterListBuilder_ == null) {
                    this.monsterList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.monsterListBuilder_.clear();
                }
                this.isForMark_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetInvestigationMonsterRspOuterClass.internal_static_GetInvestigationMonsterRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetInvestigationMonsterRsp getDefaultInstanceForType() {
                return GetInvestigationMonsterRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetInvestigationMonsterRsp build() {
                GetInvestigationMonsterRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetInvestigationMonsterRsp buildPartial() {
                GetInvestigationMonsterRsp result = new GetInvestigationMonsterRsp(this);
                int i = this.bitField0_;
                result.retcode_ = this.retcode_;
                if (this.monsterListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.monsterList_ = Collections.unmodifiableList(this.monsterList_);
                        this.bitField0_ &= -2;
                    }
                    result.monsterList_ = this.monsterList_;
                } else {
                    result.monsterList_ = this.monsterListBuilder_.build();
                }
                result.isForMark_ = this.isForMark_;
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
                if (other instanceof GetInvestigationMonsterRsp) {
                    return mergeFrom((GetInvestigationMonsterRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetInvestigationMonsterRsp other) {
                if (other == GetInvestigationMonsterRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (this.monsterListBuilder_ == null) {
                    if (!other.monsterList_.isEmpty()) {
                        if (this.monsterList_.isEmpty()) {
                            this.monsterList_ = other.monsterList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureMonsterListIsMutable();
                            this.monsterList_.addAll(other.monsterList_);
                        }
                        onChanged();
                    }
                } else if (!other.monsterList_.isEmpty()) {
                    if (this.monsterListBuilder_.isEmpty()) {
                        this.monsterListBuilder_.dispose();
                        this.monsterListBuilder_ = null;
                        this.monsterList_ = other.monsterList_;
                        this.bitField0_ &= -2;
                        this.monsterListBuilder_ = GetInvestigationMonsterRsp.alwaysUseFieldBuilders ? getMonsterListFieldBuilder() : null;
                    } else {
                        this.monsterListBuilder_.addAllMessages(other.monsterList_);
                    }
                }
                if (other.getIsForMark()) {
                    setIsForMark(other.getIsForMark());
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
                GetInvestigationMonsterRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetInvestigationMonsterRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetInvestigationMonsterRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetInvestigationMonsterRspOuterClass.GetInvestigationMonsterRspOrBuilder
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

            private void ensureMonsterListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.monsterList_ = new ArrayList(this.monsterList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetInvestigationMonsterRspOuterClass.GetInvestigationMonsterRspOrBuilder
            public List<InvestigationMonsterOuterClass.InvestigationMonster> getMonsterListList() {
                if (this.monsterListBuilder_ == null) {
                    return Collections.unmodifiableList(this.monsterList_);
                }
                return this.monsterListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GetInvestigationMonsterRspOuterClass.GetInvestigationMonsterRspOrBuilder
            public int getMonsterListCount() {
                if (this.monsterListBuilder_ == null) {
                    return this.monsterList_.size();
                }
                return this.monsterListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GetInvestigationMonsterRspOuterClass.GetInvestigationMonsterRspOrBuilder
            public InvestigationMonsterOuterClass.InvestigationMonster getMonsterList(int index) {
                if (this.monsterListBuilder_ == null) {
                    return this.monsterList_.get(index);
                }
                return this.monsterListBuilder_.getMessage(index);
            }

            public Builder setMonsterList(int index, InvestigationMonsterOuterClass.InvestigationMonster value) {
                if (this.monsterListBuilder_ != null) {
                    this.monsterListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMonsterListIsMutable();
                    this.monsterList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMonsterList(int index, InvestigationMonsterOuterClass.InvestigationMonster.Builder builderForValue) {
                if (this.monsterListBuilder_ == null) {
                    ensureMonsterListIsMutable();
                    this.monsterList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.monsterListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMonsterList(InvestigationMonsterOuterClass.InvestigationMonster value) {
                if (this.monsterListBuilder_ != null) {
                    this.monsterListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMonsterListIsMutable();
                    this.monsterList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMonsterList(int index, InvestigationMonsterOuterClass.InvestigationMonster value) {
                if (this.monsterListBuilder_ != null) {
                    this.monsterListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMonsterListIsMutable();
                    this.monsterList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMonsterList(InvestigationMonsterOuterClass.InvestigationMonster.Builder builderForValue) {
                if (this.monsterListBuilder_ == null) {
                    ensureMonsterListIsMutable();
                    this.monsterList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.monsterListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMonsterList(int index, InvestigationMonsterOuterClass.InvestigationMonster.Builder builderForValue) {
                if (this.monsterListBuilder_ == null) {
                    ensureMonsterListIsMutable();
                    this.monsterList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.monsterListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMonsterList(Iterable<? extends InvestigationMonsterOuterClass.InvestigationMonster> values) {
                if (this.monsterListBuilder_ == null) {
                    ensureMonsterListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.monsterList_);
                    onChanged();
                } else {
                    this.monsterListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMonsterList() {
                if (this.monsterListBuilder_ == null) {
                    this.monsterList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.monsterListBuilder_.clear();
                }
                return this;
            }

            public Builder removeMonsterList(int index) {
                if (this.monsterListBuilder_ == null) {
                    ensureMonsterListIsMutable();
                    this.monsterList_.remove(index);
                    onChanged();
                } else {
                    this.monsterListBuilder_.remove(index);
                }
                return this;
            }

            public InvestigationMonsterOuterClass.InvestigationMonster.Builder getMonsterListBuilder(int index) {
                return getMonsterListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetInvestigationMonsterRspOuterClass.GetInvestigationMonsterRspOrBuilder
            public InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder getMonsterListOrBuilder(int index) {
                if (this.monsterListBuilder_ == null) {
                    return this.monsterList_.get(index);
                }
                return this.monsterListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetInvestigationMonsterRspOuterClass.GetInvestigationMonsterRspOrBuilder
            public List<? extends InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder> getMonsterListOrBuilderList() {
                if (this.monsterListBuilder_ != null) {
                    return this.monsterListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.monsterList_);
            }

            public InvestigationMonsterOuterClass.InvestigationMonster.Builder addMonsterListBuilder() {
                return getMonsterListFieldBuilder().addBuilder(InvestigationMonsterOuterClass.InvestigationMonster.getDefaultInstance());
            }

            public InvestigationMonsterOuterClass.InvestigationMonster.Builder addMonsterListBuilder(int index) {
                return getMonsterListFieldBuilder().addBuilder(index, InvestigationMonsterOuterClass.InvestigationMonster.getDefaultInstance());
            }

            public List<InvestigationMonsterOuterClass.InvestigationMonster.Builder> getMonsterListBuilderList() {
                return getMonsterListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<InvestigationMonsterOuterClass.InvestigationMonster, InvestigationMonsterOuterClass.InvestigationMonster.Builder, InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder> getMonsterListFieldBuilder() {
                if (this.monsterListBuilder_ == null) {
                    this.monsterListBuilder_ = new RepeatedFieldBuilderV3<>(this.monsterList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.monsterList_ = null;
                }
                return this.monsterListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GetInvestigationMonsterRspOuterClass.GetInvestigationMonsterRspOrBuilder
            public boolean getIsForMark() {
                return this.isForMark_;
            }

            public Builder setIsForMark(boolean value) {
                this.isForMark_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsForMark() {
                this.isForMark_ = false;
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

        public static GetInvestigationMonsterRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetInvestigationMonsterRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetInvestigationMonsterRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetInvestigationMonsterRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        InvestigationMonsterOuterClass.getDescriptor();
    }
}
