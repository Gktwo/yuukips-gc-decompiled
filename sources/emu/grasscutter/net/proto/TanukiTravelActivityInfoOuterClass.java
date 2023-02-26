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
import emu.grasscutter.net.proto.TanukiTravelLevelDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TanukiTravelActivityInfoOuterClass.class */
public final class TanukiTravelActivityInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eTanukiTravelActivityInfo.proto\u001a\u001bTanukiTravelLevelData.proto\"\u0001\n\u0018TanukiTravelActivityInfo\u0012\u001a\n\u0012finishedLevelIndex\u0018\u000b \u0001(\r\u0012\u0014\n\fleftMonsters\u0018\u0002 \u0001(\b\u00129\n\u0019tanukiTravelLevelDataList\u0018\u0006 \u0003(\u000b2\u0016.TanukiTravelLevelDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{TanukiTravelLevelDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TanukiTravelActivityInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TanukiTravelActivityInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TanukiTravelActivityInfo_descriptor, new String[]{"FinishedLevelIndex", "LeftMonsters", "TanukiTravelLevelDataList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TanukiTravelActivityInfoOuterClass$TanukiTravelActivityInfoOrBuilder.class */
    public interface TanukiTravelActivityInfoOrBuilder extends MessageOrBuilder {
        int getFinishedLevelIndex();

        boolean getLeftMonsters();

        List<TanukiTravelLevelDataOuterClass.TanukiTravelLevelData> getTanukiTravelLevelDataListList();

        TanukiTravelLevelDataOuterClass.TanukiTravelLevelData getTanukiTravelLevelDataList(int i);

        int getTanukiTravelLevelDataListCount();

        List<? extends TanukiTravelLevelDataOuterClass.TanukiTravelLevelDataOrBuilder> getTanukiTravelLevelDataListOrBuilderList();

        TanukiTravelLevelDataOuterClass.TanukiTravelLevelDataOrBuilder getTanukiTravelLevelDataListOrBuilder(int i);
    }

    private TanukiTravelActivityInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TanukiTravelActivityInfoOuterClass$TanukiTravelActivityInfo.class */
    public static final class TanukiTravelActivityInfo extends GeneratedMessageV3 implements TanukiTravelActivityInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FINISHEDLEVELINDEX_FIELD_NUMBER = 11;
        private int finishedLevelIndex_;
        public static final int LEFTMONSTERS_FIELD_NUMBER = 2;
        private boolean leftMonsters_;
        public static final int TANUKITRAVELLEVELDATALIST_FIELD_NUMBER = 6;
        private List<TanukiTravelLevelDataOuterClass.TanukiTravelLevelData> tanukiTravelLevelDataList_;
        private byte memoizedIsInitialized;
        private static final TanukiTravelActivityInfo DEFAULT_INSTANCE = new TanukiTravelActivityInfo();
        private static final Parser<TanukiTravelActivityInfo> PARSER = new AbstractParser<TanukiTravelActivityInfo>() { // from class: emu.grasscutter.net.proto.TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo.1
            @Override // com.google.protobuf.Parser
            public TanukiTravelActivityInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TanukiTravelActivityInfo(input, extensionRegistry);
            }
        };

        private TanukiTravelActivityInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TanukiTravelActivityInfo() {
            this.memoizedIsInitialized = -1;
            this.tanukiTravelLevelDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TanukiTravelActivityInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TanukiTravelActivityInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                this.leftMonsters_ = input.readBool();
                                break;
                            case 50:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.tanukiTravelLevelDataList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.tanukiTravelLevelDataList_.add((TanukiTravelLevelDataOuterClass.TanukiTravelLevelData) input.readMessage(TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.parser(), extensionRegistry));
                                break;
                            case 88:
                                this.finishedLevelIndex_ = input.readUInt32();
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
                    this.tanukiTravelLevelDataList_ = Collections.unmodifiableList(this.tanukiTravelLevelDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TanukiTravelActivityInfoOuterClass.internal_static_TanukiTravelActivityInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TanukiTravelActivityInfoOuterClass.internal_static_TanukiTravelActivityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TanukiTravelActivityInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfoOrBuilder
        public int getFinishedLevelIndex() {
            return this.finishedLevelIndex_;
        }

        @Override // emu.grasscutter.net.proto.TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfoOrBuilder
        public boolean getLeftMonsters() {
            return this.leftMonsters_;
        }

        @Override // emu.grasscutter.net.proto.TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfoOrBuilder
        public List<TanukiTravelLevelDataOuterClass.TanukiTravelLevelData> getTanukiTravelLevelDataListList() {
            return this.tanukiTravelLevelDataList_;
        }

        @Override // emu.grasscutter.net.proto.TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfoOrBuilder
        public List<? extends TanukiTravelLevelDataOuterClass.TanukiTravelLevelDataOrBuilder> getTanukiTravelLevelDataListOrBuilderList() {
            return this.tanukiTravelLevelDataList_;
        }

        @Override // emu.grasscutter.net.proto.TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfoOrBuilder
        public int getTanukiTravelLevelDataListCount() {
            return this.tanukiTravelLevelDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfoOrBuilder
        public TanukiTravelLevelDataOuterClass.TanukiTravelLevelData getTanukiTravelLevelDataList(int index) {
            return this.tanukiTravelLevelDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfoOrBuilder
        public TanukiTravelLevelDataOuterClass.TanukiTravelLevelDataOrBuilder getTanukiTravelLevelDataListOrBuilder(int index) {
            return this.tanukiTravelLevelDataList_.get(index);
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
            if (this.leftMonsters_) {
                output.writeBool(2, this.leftMonsters_);
            }
            for (int i = 0; i < this.tanukiTravelLevelDataList_.size(); i++) {
                output.writeMessage(6, this.tanukiTravelLevelDataList_.get(i));
            }
            if (this.finishedLevelIndex_ != 0) {
                output.writeUInt32(11, this.finishedLevelIndex_);
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
            if (this.leftMonsters_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(2, this.leftMonsters_);
            }
            for (int i = 0; i < this.tanukiTravelLevelDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(6, this.tanukiTravelLevelDataList_.get(i));
            }
            if (this.finishedLevelIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.finishedLevelIndex_);
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
            if (!(obj instanceof TanukiTravelActivityInfo)) {
                return equals(obj);
            }
            TanukiTravelActivityInfo other = (TanukiTravelActivityInfo) obj;
            return getFinishedLevelIndex() == other.getFinishedLevelIndex() && getLeftMonsters() == other.getLeftMonsters() && getTanukiTravelLevelDataListList().equals(other.getTanukiTravelLevelDataListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getFinishedLevelIndex())) + 2)) + Internal.hashBoolean(getLeftMonsters());
            if (getTanukiTravelLevelDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getTanukiTravelLevelDataListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TanukiTravelActivityInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TanukiTravelActivityInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TanukiTravelActivityInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TanukiTravelActivityInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TanukiTravelActivityInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TanukiTravelActivityInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TanukiTravelActivityInfo parseFrom(InputStream input) throws IOException {
            return (TanukiTravelActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TanukiTravelActivityInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TanukiTravelActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TanukiTravelActivityInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (TanukiTravelActivityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TanukiTravelActivityInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TanukiTravelActivityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TanukiTravelActivityInfo parseFrom(CodedInputStream input) throws IOException {
            return (TanukiTravelActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TanukiTravelActivityInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TanukiTravelActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TanukiTravelActivityInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TanukiTravelActivityInfoOuterClass$TanukiTravelActivityInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TanukiTravelActivityInfoOrBuilder {
            private int bitField0_;
            private int finishedLevelIndex_;
            private boolean leftMonsters_;
            private List<TanukiTravelLevelDataOuterClass.TanukiTravelLevelData> tanukiTravelLevelDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<TanukiTravelLevelDataOuterClass.TanukiTravelLevelData, TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.Builder, TanukiTravelLevelDataOuterClass.TanukiTravelLevelDataOrBuilder> tanukiTravelLevelDataListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TanukiTravelActivityInfoOuterClass.internal_static_TanukiTravelActivityInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TanukiTravelActivityInfoOuterClass.internal_static_TanukiTravelActivityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TanukiTravelActivityInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TanukiTravelActivityInfo.alwaysUseFieldBuilders) {
                    getTanukiTravelLevelDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.finishedLevelIndex_ = 0;
                this.leftMonsters_ = false;
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    this.tanukiTravelLevelDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.tanukiTravelLevelDataListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TanukiTravelActivityInfoOuterClass.internal_static_TanukiTravelActivityInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TanukiTravelActivityInfo getDefaultInstanceForType() {
                return TanukiTravelActivityInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TanukiTravelActivityInfo build() {
                TanukiTravelActivityInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TanukiTravelActivityInfo buildPartial() {
                TanukiTravelActivityInfo result = new TanukiTravelActivityInfo(this);
                int i = this.bitField0_;
                result.finishedLevelIndex_ = this.finishedLevelIndex_;
                result.leftMonsters_ = this.leftMonsters_;
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.tanukiTravelLevelDataList_ = Collections.unmodifiableList(this.tanukiTravelLevelDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.tanukiTravelLevelDataList_ = this.tanukiTravelLevelDataList_;
                } else {
                    result.tanukiTravelLevelDataList_ = this.tanukiTravelLevelDataListBuilder_.build();
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
                if (other instanceof TanukiTravelActivityInfo) {
                    return mergeFrom((TanukiTravelActivityInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TanukiTravelActivityInfo other) {
                if (other == TanukiTravelActivityInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getFinishedLevelIndex() != 0) {
                    setFinishedLevelIndex(other.getFinishedLevelIndex());
                }
                if (other.getLeftMonsters()) {
                    setLeftMonsters(other.getLeftMonsters());
                }
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    if (!other.tanukiTravelLevelDataList_.isEmpty()) {
                        if (this.tanukiTravelLevelDataList_.isEmpty()) {
                            this.tanukiTravelLevelDataList_ = other.tanukiTravelLevelDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureTanukiTravelLevelDataListIsMutable();
                            this.tanukiTravelLevelDataList_.addAll(other.tanukiTravelLevelDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.tanukiTravelLevelDataList_.isEmpty()) {
                    if (this.tanukiTravelLevelDataListBuilder_.isEmpty()) {
                        this.tanukiTravelLevelDataListBuilder_.dispose();
                        this.tanukiTravelLevelDataListBuilder_ = null;
                        this.tanukiTravelLevelDataList_ = other.tanukiTravelLevelDataList_;
                        this.bitField0_ &= -2;
                        this.tanukiTravelLevelDataListBuilder_ = TanukiTravelActivityInfo.alwaysUseFieldBuilders ? getTanukiTravelLevelDataListFieldBuilder() : null;
                    } else {
                        this.tanukiTravelLevelDataListBuilder_.addAllMessages(other.tanukiTravelLevelDataList_);
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
                TanukiTravelActivityInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = TanukiTravelActivityInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TanukiTravelActivityInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfoOrBuilder
            public int getFinishedLevelIndex() {
                return this.finishedLevelIndex_;
            }

            public Builder setFinishedLevelIndex(int value) {
                this.finishedLevelIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearFinishedLevelIndex() {
                this.finishedLevelIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfoOrBuilder
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

            private void ensureTanukiTravelLevelDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.tanukiTravelLevelDataList_ = new ArrayList(this.tanukiTravelLevelDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfoOrBuilder
            public List<TanukiTravelLevelDataOuterClass.TanukiTravelLevelData> getTanukiTravelLevelDataListList() {
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.tanukiTravelLevelDataList_);
                }
                return this.tanukiTravelLevelDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfoOrBuilder
            public int getTanukiTravelLevelDataListCount() {
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    return this.tanukiTravelLevelDataList_.size();
                }
                return this.tanukiTravelLevelDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfoOrBuilder
            public TanukiTravelLevelDataOuterClass.TanukiTravelLevelData getTanukiTravelLevelDataList(int index) {
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    return this.tanukiTravelLevelDataList_.get(index);
                }
                return this.tanukiTravelLevelDataListBuilder_.getMessage(index);
            }

            public Builder setTanukiTravelLevelDataList(int index, TanukiTravelLevelDataOuterClass.TanukiTravelLevelData value) {
                if (this.tanukiTravelLevelDataListBuilder_ != null) {
                    this.tanukiTravelLevelDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTanukiTravelLevelDataListIsMutable();
                    this.tanukiTravelLevelDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTanukiTravelLevelDataList(int index, TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.Builder builderForValue) {
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    ensureTanukiTravelLevelDataListIsMutable();
                    this.tanukiTravelLevelDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.tanukiTravelLevelDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTanukiTravelLevelDataList(TanukiTravelLevelDataOuterClass.TanukiTravelLevelData value) {
                if (this.tanukiTravelLevelDataListBuilder_ != null) {
                    this.tanukiTravelLevelDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTanukiTravelLevelDataListIsMutable();
                    this.tanukiTravelLevelDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTanukiTravelLevelDataList(int index, TanukiTravelLevelDataOuterClass.TanukiTravelLevelData value) {
                if (this.tanukiTravelLevelDataListBuilder_ != null) {
                    this.tanukiTravelLevelDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTanukiTravelLevelDataListIsMutable();
                    this.tanukiTravelLevelDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTanukiTravelLevelDataList(TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.Builder builderForValue) {
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    ensureTanukiTravelLevelDataListIsMutable();
                    this.tanukiTravelLevelDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.tanukiTravelLevelDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTanukiTravelLevelDataList(int index, TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.Builder builderForValue) {
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    ensureTanukiTravelLevelDataListIsMutable();
                    this.tanukiTravelLevelDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.tanukiTravelLevelDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTanukiTravelLevelDataList(Iterable<? extends TanukiTravelLevelDataOuterClass.TanukiTravelLevelData> values) {
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    ensureTanukiTravelLevelDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.tanukiTravelLevelDataList_);
                    onChanged();
                } else {
                    this.tanukiTravelLevelDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTanukiTravelLevelDataList() {
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    this.tanukiTravelLevelDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.tanukiTravelLevelDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTanukiTravelLevelDataList(int index) {
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    ensureTanukiTravelLevelDataListIsMutable();
                    this.tanukiTravelLevelDataList_.remove(index);
                    onChanged();
                } else {
                    this.tanukiTravelLevelDataListBuilder_.remove(index);
                }
                return this;
            }

            public TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.Builder getTanukiTravelLevelDataListBuilder(int index) {
                return getTanukiTravelLevelDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfoOrBuilder
            public TanukiTravelLevelDataOuterClass.TanukiTravelLevelDataOrBuilder getTanukiTravelLevelDataListOrBuilder(int index) {
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    return this.tanukiTravelLevelDataList_.get(index);
                }
                return this.tanukiTravelLevelDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfoOrBuilder
            public List<? extends TanukiTravelLevelDataOuterClass.TanukiTravelLevelDataOrBuilder> getTanukiTravelLevelDataListOrBuilderList() {
                if (this.tanukiTravelLevelDataListBuilder_ != null) {
                    return this.tanukiTravelLevelDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.tanukiTravelLevelDataList_);
            }

            public TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.Builder addTanukiTravelLevelDataListBuilder() {
                return getTanukiTravelLevelDataListFieldBuilder().addBuilder(TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.getDefaultInstance());
            }

            public TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.Builder addTanukiTravelLevelDataListBuilder(int index) {
                return getTanukiTravelLevelDataListFieldBuilder().addBuilder(index, TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.getDefaultInstance());
            }

            public List<TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.Builder> getTanukiTravelLevelDataListBuilderList() {
                return getTanukiTravelLevelDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<TanukiTravelLevelDataOuterClass.TanukiTravelLevelData, TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.Builder, TanukiTravelLevelDataOuterClass.TanukiTravelLevelDataOrBuilder> getTanukiTravelLevelDataListFieldBuilder() {
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    this.tanukiTravelLevelDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.tanukiTravelLevelDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.tanukiTravelLevelDataList_ = null;
                }
                return this.tanukiTravelLevelDataListBuilder_;
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

        public static TanukiTravelActivityInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TanukiTravelActivityInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TanukiTravelActivityInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TanukiTravelActivityInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        TanukiTravelLevelDataOuterClass.getDescriptor();
    }
}
