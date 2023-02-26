package emu.grasscutter.net.proto;

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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.IrodoriChessMapDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessLevelDataOuterClass.class */
public final class IrodoriChessLevelDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bIrodoriChessLevelData.proto\u001a\u0019IrodoriChessMapData.proto\" \u0001\n\u0015IrodoriChessLevelData\u0012\u000f\n\u0007levelId\u0018\n \u0001(\r\u0012\u0010\n\bopenTime\u0018\u0007 \u0001(\r\u00121\n\u0013Unk3300_BGINEMHBNAD\u0018\u000e \u0001(\u000b2\u0014.IrodoriChessMapData\u00121\n\u0013Unk3300_GCIGNCGOBML\u0018\u000f \u0001(\u000b2\u0014.IrodoriChessMapDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{IrodoriChessMapDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_IrodoriChessLevelData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_IrodoriChessLevelData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_IrodoriChessLevelData_descriptor, new String[]{"LevelId", "OpenTime", "Unk3300BGINEMHBNAD", "Unk3300GCIGNCGOBML"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessLevelDataOuterClass$IrodoriChessLevelDataOrBuilder.class */
    public interface IrodoriChessLevelDataOrBuilder extends MessageOrBuilder {
        int getLevelId();

        int getOpenTime();

        boolean hasUnk3300BGINEMHBNAD();

        IrodoriChessMapDataOuterClass.IrodoriChessMapData getUnk3300BGINEMHBNAD();

        IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder getUnk3300BGINEMHBNADOrBuilder();

        boolean hasUnk3300GCIGNCGOBML();

        IrodoriChessMapDataOuterClass.IrodoriChessMapData getUnk3300GCIGNCGOBML();

        IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder getUnk3300GCIGNCGOBMLOrBuilder();
    }

    private IrodoriChessLevelDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessLevelDataOuterClass$IrodoriChessLevelData.class */
    public static final class IrodoriChessLevelData extends GeneratedMessageV3 implements IrodoriChessLevelDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LEVELID_FIELD_NUMBER = 10;
        private int levelId_;
        public static final int OPENTIME_FIELD_NUMBER = 7;
        private int openTime_;
        public static final int UNK3300_BGINEMHBNAD_FIELD_NUMBER = 14;
        private IrodoriChessMapDataOuterClass.IrodoriChessMapData unk3300BGINEMHBNAD_;
        public static final int UNK3300_GCIGNCGOBML_FIELD_NUMBER = 15;
        private IrodoriChessMapDataOuterClass.IrodoriChessMapData unk3300GCIGNCGOBML_;
        private byte memoizedIsInitialized;
        private static final IrodoriChessLevelData DEFAULT_INSTANCE = new IrodoriChessLevelData();
        private static final Parser<IrodoriChessLevelData> PARSER = new AbstractParser<IrodoriChessLevelData>() { // from class: emu.grasscutter.net.proto.IrodoriChessLevelDataOuterClass.IrodoriChessLevelData.1
            @Override // com.google.protobuf.Parser
            public IrodoriChessLevelData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new IrodoriChessLevelData(input, extensionRegistry);
            }
        };

        private IrodoriChessLevelData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private IrodoriChessLevelData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new IrodoriChessLevelData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private IrodoriChessLevelData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 56:
                                this.openTime_ = input.readUInt32();
                                break;
                            case 80:
                                this.levelId_ = input.readUInt32();
                                break;
                            case 114:
                                IrodoriChessMapDataOuterClass.IrodoriChessMapData.Builder subBuilder = this.unk3300BGINEMHBNAD_ != null ? this.unk3300BGINEMHBNAD_.toBuilder() : null;
                                this.unk3300BGINEMHBNAD_ = (IrodoriChessMapDataOuterClass.IrodoriChessMapData) input.readMessage(IrodoriChessMapDataOuterClass.IrodoriChessMapData.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.unk3300BGINEMHBNAD_);
                                    this.unk3300BGINEMHBNAD_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 122:
                                IrodoriChessMapDataOuterClass.IrodoriChessMapData.Builder subBuilder2 = this.unk3300GCIGNCGOBML_ != null ? this.unk3300GCIGNCGOBML_.toBuilder() : null;
                                this.unk3300GCIGNCGOBML_ = (IrodoriChessMapDataOuterClass.IrodoriChessMapData) input.readMessage(IrodoriChessMapDataOuterClass.IrodoriChessMapData.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.unk3300GCIGNCGOBML_);
                                    this.unk3300GCIGNCGOBML_ = subBuilder2.buildPartial();
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
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return IrodoriChessLevelDataOuterClass.internal_static_IrodoriChessLevelData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return IrodoriChessLevelDataOuterClass.internal_static_IrodoriChessLevelData_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriChessLevelData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder
        public int getLevelId() {
            return this.levelId_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder
        public int getOpenTime() {
            return this.openTime_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder
        public boolean hasUnk3300BGINEMHBNAD() {
            return this.unk3300BGINEMHBNAD_ != null;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder
        public IrodoriChessMapDataOuterClass.IrodoriChessMapData getUnk3300BGINEMHBNAD() {
            return this.unk3300BGINEMHBNAD_ == null ? IrodoriChessMapDataOuterClass.IrodoriChessMapData.getDefaultInstance() : this.unk3300BGINEMHBNAD_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder
        public IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder getUnk3300BGINEMHBNADOrBuilder() {
            return getUnk3300BGINEMHBNAD();
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder
        public boolean hasUnk3300GCIGNCGOBML() {
            return this.unk3300GCIGNCGOBML_ != null;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder
        public IrodoriChessMapDataOuterClass.IrodoriChessMapData getUnk3300GCIGNCGOBML() {
            return this.unk3300GCIGNCGOBML_ == null ? IrodoriChessMapDataOuterClass.IrodoriChessMapData.getDefaultInstance() : this.unk3300GCIGNCGOBML_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder
        public IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder getUnk3300GCIGNCGOBMLOrBuilder() {
            return getUnk3300GCIGNCGOBML();
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
                output.writeUInt32(7, this.openTime_);
            }
            if (this.levelId_ != 0) {
                output.writeUInt32(10, this.levelId_);
            }
            if (this.unk3300BGINEMHBNAD_ != null) {
                output.writeMessage(14, getUnk3300BGINEMHBNAD());
            }
            if (this.unk3300GCIGNCGOBML_ != null) {
                output.writeMessage(15, getUnk3300GCIGNCGOBML());
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(7, this.openTime_);
            }
            if (this.levelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.levelId_);
            }
            if (this.unk3300BGINEMHBNAD_ != null) {
                size2 += CodedOutputStream.computeMessageSize(14, getUnk3300BGINEMHBNAD());
            }
            if (this.unk3300GCIGNCGOBML_ != null) {
                size2 += CodedOutputStream.computeMessageSize(15, getUnk3300GCIGNCGOBML());
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
            if (!(obj instanceof IrodoriChessLevelData)) {
                return equals(obj);
            }
            IrodoriChessLevelData other = (IrodoriChessLevelData) obj;
            if (getLevelId() != other.getLevelId() || getOpenTime() != other.getOpenTime() || hasUnk3300BGINEMHBNAD() != other.hasUnk3300BGINEMHBNAD()) {
                return false;
            }
            if ((!hasUnk3300BGINEMHBNAD() || getUnk3300BGINEMHBNAD().equals(other.getUnk3300BGINEMHBNAD())) && hasUnk3300GCIGNCGOBML() == other.hasUnk3300GCIGNCGOBML()) {
                return (!hasUnk3300GCIGNCGOBML() || getUnk3300GCIGNCGOBML().equals(other.getUnk3300GCIGNCGOBML())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getLevelId())) + 7)) + getOpenTime();
            if (hasUnk3300BGINEMHBNAD()) {
                hash = (53 * ((37 * hash) + 14)) + getUnk3300BGINEMHBNAD().hashCode();
            }
            if (hasUnk3300GCIGNCGOBML()) {
                hash = (53 * ((37 * hash) + 15)) + getUnk3300GCIGNCGOBML().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static IrodoriChessLevelData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessLevelData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessLevelData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessLevelData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessLevelData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessLevelData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessLevelData parseFrom(InputStream input) throws IOException {
            return (IrodoriChessLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriChessLevelData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriChessLevelData parseDelimitedFrom(InputStream input) throws IOException {
            return (IrodoriChessLevelData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static IrodoriChessLevelData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessLevelData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriChessLevelData parseFrom(CodedInputStream input) throws IOException {
            return (IrodoriChessLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriChessLevelData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(IrodoriChessLevelData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessLevelDataOuterClass$IrodoriChessLevelData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements IrodoriChessLevelDataOrBuilder {
            private int levelId_;
            private int openTime_;
            private IrodoriChessMapDataOuterClass.IrodoriChessMapData unk3300BGINEMHBNAD_;
            private SingleFieldBuilderV3<IrodoriChessMapDataOuterClass.IrodoriChessMapData, IrodoriChessMapDataOuterClass.IrodoriChessMapData.Builder, IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder> unk3300BGINEMHBNADBuilder_;
            private IrodoriChessMapDataOuterClass.IrodoriChessMapData unk3300GCIGNCGOBML_;
            private SingleFieldBuilderV3<IrodoriChessMapDataOuterClass.IrodoriChessMapData, IrodoriChessMapDataOuterClass.IrodoriChessMapData.Builder, IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder> unk3300GCIGNCGOBMLBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return IrodoriChessLevelDataOuterClass.internal_static_IrodoriChessLevelData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return IrodoriChessLevelDataOuterClass.internal_static_IrodoriChessLevelData_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriChessLevelData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (IrodoriChessLevelData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.levelId_ = 0;
                this.openTime_ = 0;
                if (this.unk3300BGINEMHBNADBuilder_ == null) {
                    this.unk3300BGINEMHBNAD_ = null;
                } else {
                    this.unk3300BGINEMHBNAD_ = null;
                    this.unk3300BGINEMHBNADBuilder_ = null;
                }
                if (this.unk3300GCIGNCGOBMLBuilder_ == null) {
                    this.unk3300GCIGNCGOBML_ = null;
                } else {
                    this.unk3300GCIGNCGOBML_ = null;
                    this.unk3300GCIGNCGOBMLBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return IrodoriChessLevelDataOuterClass.internal_static_IrodoriChessLevelData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public IrodoriChessLevelData getDefaultInstanceForType() {
                return IrodoriChessLevelData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriChessLevelData build() {
                IrodoriChessLevelData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriChessLevelData buildPartial() {
                IrodoriChessLevelData result = new IrodoriChessLevelData(this);
                result.levelId_ = this.levelId_;
                result.openTime_ = this.openTime_;
                if (this.unk3300BGINEMHBNADBuilder_ == null) {
                    result.unk3300BGINEMHBNAD_ = this.unk3300BGINEMHBNAD_;
                } else {
                    result.unk3300BGINEMHBNAD_ = this.unk3300BGINEMHBNADBuilder_.build();
                }
                if (this.unk3300GCIGNCGOBMLBuilder_ == null) {
                    result.unk3300GCIGNCGOBML_ = this.unk3300GCIGNCGOBML_;
                } else {
                    result.unk3300GCIGNCGOBML_ = this.unk3300GCIGNCGOBMLBuilder_.build();
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
                if (other instanceof IrodoriChessLevelData) {
                    return mergeFrom((IrodoriChessLevelData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(IrodoriChessLevelData other) {
                if (other == IrodoriChessLevelData.getDefaultInstance()) {
                    return this;
                }
                if (other.getLevelId() != 0) {
                    setLevelId(other.getLevelId());
                }
                if (other.getOpenTime() != 0) {
                    setOpenTime(other.getOpenTime());
                }
                if (other.hasUnk3300BGINEMHBNAD()) {
                    mergeUnk3300BGINEMHBNAD(other.getUnk3300BGINEMHBNAD());
                }
                if (other.hasUnk3300GCIGNCGOBML()) {
                    mergeUnk3300GCIGNCGOBML(other.getUnk3300GCIGNCGOBML());
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
                IrodoriChessLevelData parsedMessage = null;
                try {
                    try {
                        parsedMessage = IrodoriChessLevelData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (IrodoriChessLevelData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder
            public boolean hasUnk3300BGINEMHBNAD() {
                return (this.unk3300BGINEMHBNADBuilder_ == null && this.unk3300BGINEMHBNAD_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder
            public IrodoriChessMapDataOuterClass.IrodoriChessMapData getUnk3300BGINEMHBNAD() {
                if (this.unk3300BGINEMHBNADBuilder_ == null) {
                    return this.unk3300BGINEMHBNAD_ == null ? IrodoriChessMapDataOuterClass.IrodoriChessMapData.getDefaultInstance() : this.unk3300BGINEMHBNAD_;
                }
                return this.unk3300BGINEMHBNADBuilder_.getMessage();
            }

            public Builder setUnk3300BGINEMHBNAD(IrodoriChessMapDataOuterClass.IrodoriChessMapData value) {
                if (this.unk3300BGINEMHBNADBuilder_ != null) {
                    this.unk3300BGINEMHBNADBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.unk3300BGINEMHBNAD_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setUnk3300BGINEMHBNAD(IrodoriChessMapDataOuterClass.IrodoriChessMapData.Builder builderForValue) {
                if (this.unk3300BGINEMHBNADBuilder_ == null) {
                    this.unk3300BGINEMHBNAD_ = builderForValue.build();
                    onChanged();
                } else {
                    this.unk3300BGINEMHBNADBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeUnk3300BGINEMHBNAD(IrodoriChessMapDataOuterClass.IrodoriChessMapData value) {
                if (this.unk3300BGINEMHBNADBuilder_ == null) {
                    if (this.unk3300BGINEMHBNAD_ != null) {
                        this.unk3300BGINEMHBNAD_ = IrodoriChessMapDataOuterClass.IrodoriChessMapData.newBuilder(this.unk3300BGINEMHBNAD_).mergeFrom(value).buildPartial();
                    } else {
                        this.unk3300BGINEMHBNAD_ = value;
                    }
                    onChanged();
                } else {
                    this.unk3300BGINEMHBNADBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearUnk3300BGINEMHBNAD() {
                if (this.unk3300BGINEMHBNADBuilder_ == null) {
                    this.unk3300BGINEMHBNAD_ = null;
                    onChanged();
                } else {
                    this.unk3300BGINEMHBNAD_ = null;
                    this.unk3300BGINEMHBNADBuilder_ = null;
                }
                return this;
            }

            public IrodoriChessMapDataOuterClass.IrodoriChessMapData.Builder getUnk3300BGINEMHBNADBuilder() {
                onChanged();
                return getUnk3300BGINEMHBNADFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder
            public IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder getUnk3300BGINEMHBNADOrBuilder() {
                if (this.unk3300BGINEMHBNADBuilder_ != null) {
                    return this.unk3300BGINEMHBNADBuilder_.getMessageOrBuilder();
                }
                return this.unk3300BGINEMHBNAD_ == null ? IrodoriChessMapDataOuterClass.IrodoriChessMapData.getDefaultInstance() : this.unk3300BGINEMHBNAD_;
            }

            private SingleFieldBuilderV3<IrodoriChessMapDataOuterClass.IrodoriChessMapData, IrodoriChessMapDataOuterClass.IrodoriChessMapData.Builder, IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder> getUnk3300BGINEMHBNADFieldBuilder() {
                if (this.unk3300BGINEMHBNADBuilder_ == null) {
                    this.unk3300BGINEMHBNADBuilder_ = new SingleFieldBuilderV3<>(getUnk3300BGINEMHBNAD(), getParentForChildren(), isClean());
                    this.unk3300BGINEMHBNAD_ = null;
                }
                return this.unk3300BGINEMHBNADBuilder_;
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder
            public boolean hasUnk3300GCIGNCGOBML() {
                return (this.unk3300GCIGNCGOBMLBuilder_ == null && this.unk3300GCIGNCGOBML_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder
            public IrodoriChessMapDataOuterClass.IrodoriChessMapData getUnk3300GCIGNCGOBML() {
                if (this.unk3300GCIGNCGOBMLBuilder_ == null) {
                    return this.unk3300GCIGNCGOBML_ == null ? IrodoriChessMapDataOuterClass.IrodoriChessMapData.getDefaultInstance() : this.unk3300GCIGNCGOBML_;
                }
                return this.unk3300GCIGNCGOBMLBuilder_.getMessage();
            }

            public Builder setUnk3300GCIGNCGOBML(IrodoriChessMapDataOuterClass.IrodoriChessMapData value) {
                if (this.unk3300GCIGNCGOBMLBuilder_ != null) {
                    this.unk3300GCIGNCGOBMLBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.unk3300GCIGNCGOBML_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setUnk3300GCIGNCGOBML(IrodoriChessMapDataOuterClass.IrodoriChessMapData.Builder builderForValue) {
                if (this.unk3300GCIGNCGOBMLBuilder_ == null) {
                    this.unk3300GCIGNCGOBML_ = builderForValue.build();
                    onChanged();
                } else {
                    this.unk3300GCIGNCGOBMLBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeUnk3300GCIGNCGOBML(IrodoriChessMapDataOuterClass.IrodoriChessMapData value) {
                if (this.unk3300GCIGNCGOBMLBuilder_ == null) {
                    if (this.unk3300GCIGNCGOBML_ != null) {
                        this.unk3300GCIGNCGOBML_ = IrodoriChessMapDataOuterClass.IrodoriChessMapData.newBuilder(this.unk3300GCIGNCGOBML_).mergeFrom(value).buildPartial();
                    } else {
                        this.unk3300GCIGNCGOBML_ = value;
                    }
                    onChanged();
                } else {
                    this.unk3300GCIGNCGOBMLBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearUnk3300GCIGNCGOBML() {
                if (this.unk3300GCIGNCGOBMLBuilder_ == null) {
                    this.unk3300GCIGNCGOBML_ = null;
                    onChanged();
                } else {
                    this.unk3300GCIGNCGOBML_ = null;
                    this.unk3300GCIGNCGOBMLBuilder_ = null;
                }
                return this;
            }

            public IrodoriChessMapDataOuterClass.IrodoriChessMapData.Builder getUnk3300GCIGNCGOBMLBuilder() {
                onChanged();
                return getUnk3300GCIGNCGOBMLFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder
            public IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder getUnk3300GCIGNCGOBMLOrBuilder() {
                if (this.unk3300GCIGNCGOBMLBuilder_ != null) {
                    return this.unk3300GCIGNCGOBMLBuilder_.getMessageOrBuilder();
                }
                return this.unk3300GCIGNCGOBML_ == null ? IrodoriChessMapDataOuterClass.IrodoriChessMapData.getDefaultInstance() : this.unk3300GCIGNCGOBML_;
            }

            private SingleFieldBuilderV3<IrodoriChessMapDataOuterClass.IrodoriChessMapData, IrodoriChessMapDataOuterClass.IrodoriChessMapData.Builder, IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder> getUnk3300GCIGNCGOBMLFieldBuilder() {
                if (this.unk3300GCIGNCGOBMLBuilder_ == null) {
                    this.unk3300GCIGNCGOBMLBuilder_ = new SingleFieldBuilderV3<>(getUnk3300GCIGNCGOBML(), getParentForChildren(), isClean());
                    this.unk3300GCIGNCGOBML_ = null;
                }
                return this.unk3300GCIGNCGOBMLBuilder_;
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

        public static IrodoriChessLevelData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<IrodoriChessLevelData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<IrodoriChessLevelData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public IrodoriChessLevelData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        IrodoriChessMapDataOuterClass.getDescriptor();
    }
}
