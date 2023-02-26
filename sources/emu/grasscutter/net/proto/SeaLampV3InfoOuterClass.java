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
import emu.grasscutter.net.proto.BDKPJAMLNCLOuterClass;
import emu.grasscutter.net.proto.FKJCFGLHNPMOuterClass;
import emu.grasscutter.net.proto.MEIDIANHEDDOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SeaLampV3InfoOuterClass.class */
public final class SeaLampV3InfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013SeaLampV3Info.proto\u001a\u0011BDKPJAMLNCL.proto\u001a\u0011MEIDIANHEDD.proto\u001a\u0011FKJCFGLHNPM.proto\"r\n\rSeaLampV3Info\u0012\u001e\n\braceInfo\u0018\u0004 \u0001(\u000b2\f.BDKPJAMLNCL\u0012\u001e\n\bcampInfo\u0018\u000b \u0001(\u000b2\f.MEIDIANHEDD\u0012!\n\u000bjpegcngalgi\u0018\u0003 \u0001(\u000b2\f.FKJCFGLHNPMB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BDKPJAMLNCLOuterClass.getDescriptor(), MEIDIANHEDDOuterClass.getDescriptor(), FKJCFGLHNPMOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SeaLampV3Info_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SeaLampV3Info_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SeaLampV3Info_descriptor, new String[]{"RaceInfo", "CampInfo", "Jpegcngalgi"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SeaLampV3InfoOuterClass$SeaLampV3InfoOrBuilder.class */
    public interface SeaLampV3InfoOrBuilder extends MessageOrBuilder {
        boolean hasRaceInfo();

        BDKPJAMLNCLOuterClass.BDKPJAMLNCL getRaceInfo();

        BDKPJAMLNCLOuterClass.BDKPJAMLNCLOrBuilder getRaceInfoOrBuilder();

        boolean hasCampInfo();

        MEIDIANHEDDOuterClass.MEIDIANHEDD getCampInfo();

        MEIDIANHEDDOuterClass.MEIDIANHEDDOrBuilder getCampInfoOrBuilder();

        boolean hasJpegcngalgi();

        FKJCFGLHNPMOuterClass.FKJCFGLHNPM getJpegcngalgi();

        FKJCFGLHNPMOuterClass.FKJCFGLHNPMOrBuilder getJpegcngalgiOrBuilder();
    }

    private SeaLampV3InfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SeaLampV3InfoOuterClass$SeaLampV3Info.class */
    public static final class SeaLampV3Info extends GeneratedMessageV3 implements SeaLampV3InfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RACEINFO_FIELD_NUMBER = 4;
        private BDKPJAMLNCLOuterClass.BDKPJAMLNCL raceInfo_;
        public static final int CAMPINFO_FIELD_NUMBER = 11;
        private MEIDIANHEDDOuterClass.MEIDIANHEDD campInfo_;
        public static final int JPEGCNGALGI_FIELD_NUMBER = 3;
        private FKJCFGLHNPMOuterClass.FKJCFGLHNPM jpegcngalgi_;
        private byte memoizedIsInitialized;
        private static final SeaLampV3Info DEFAULT_INSTANCE = new SeaLampV3Info();
        private static final Parser<SeaLampV3Info> PARSER = new AbstractParser<SeaLampV3Info>() { // from class: emu.grasscutter.net.proto.SeaLampV3InfoOuterClass.SeaLampV3Info.1
            @Override // com.google.protobuf.Parser
            public SeaLampV3Info parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SeaLampV3Info(input, extensionRegistry);
            }
        };

        private SeaLampV3Info(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SeaLampV3Info() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SeaLampV3Info();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SeaLampV3Info(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 26:
                                FKJCFGLHNPMOuterClass.FKJCFGLHNPM.Builder subBuilder = this.jpegcngalgi_ != null ? this.jpegcngalgi_.toBuilder() : null;
                                this.jpegcngalgi_ = (FKJCFGLHNPMOuterClass.FKJCFGLHNPM) input.readMessage(FKJCFGLHNPMOuterClass.FKJCFGLHNPM.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.jpegcngalgi_);
                                    this.jpegcngalgi_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 34:
                                BDKPJAMLNCLOuterClass.BDKPJAMLNCL.Builder subBuilder2 = this.raceInfo_ != null ? this.raceInfo_.toBuilder() : null;
                                this.raceInfo_ = (BDKPJAMLNCLOuterClass.BDKPJAMLNCL) input.readMessage(BDKPJAMLNCLOuterClass.BDKPJAMLNCL.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.raceInfo_);
                                    this.raceInfo_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 90:
                                MEIDIANHEDDOuterClass.MEIDIANHEDD.Builder subBuilder3 = this.campInfo_ != null ? this.campInfo_.toBuilder() : null;
                                this.campInfo_ = (MEIDIANHEDDOuterClass.MEIDIANHEDD) input.readMessage(MEIDIANHEDDOuterClass.MEIDIANHEDD.parser(), extensionRegistry);
                                if (subBuilder3 == null) {
                                    break;
                                } else {
                                    subBuilder3.mergeFrom(this.campInfo_);
                                    this.campInfo_ = subBuilder3.buildPartial();
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
            return SeaLampV3InfoOuterClass.internal_static_SeaLampV3Info_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SeaLampV3InfoOuterClass.internal_static_SeaLampV3Info_fieldAccessorTable.ensureFieldAccessorsInitialized(SeaLampV3Info.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder
        public boolean hasRaceInfo() {
            return this.raceInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder
        public BDKPJAMLNCLOuterClass.BDKPJAMLNCL getRaceInfo() {
            return this.raceInfo_ == null ? BDKPJAMLNCLOuterClass.BDKPJAMLNCL.getDefaultInstance() : this.raceInfo_;
        }

        @Override // emu.grasscutter.net.proto.SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder
        public BDKPJAMLNCLOuterClass.BDKPJAMLNCLOrBuilder getRaceInfoOrBuilder() {
            return getRaceInfo();
        }

        @Override // emu.grasscutter.net.proto.SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder
        public boolean hasCampInfo() {
            return this.campInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder
        public MEIDIANHEDDOuterClass.MEIDIANHEDD getCampInfo() {
            return this.campInfo_ == null ? MEIDIANHEDDOuterClass.MEIDIANHEDD.getDefaultInstance() : this.campInfo_;
        }

        @Override // emu.grasscutter.net.proto.SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder
        public MEIDIANHEDDOuterClass.MEIDIANHEDDOrBuilder getCampInfoOrBuilder() {
            return getCampInfo();
        }

        @Override // emu.grasscutter.net.proto.SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder
        public boolean hasJpegcngalgi() {
            return this.jpegcngalgi_ != null;
        }

        @Override // emu.grasscutter.net.proto.SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder
        public FKJCFGLHNPMOuterClass.FKJCFGLHNPM getJpegcngalgi() {
            return this.jpegcngalgi_ == null ? FKJCFGLHNPMOuterClass.FKJCFGLHNPM.getDefaultInstance() : this.jpegcngalgi_;
        }

        @Override // emu.grasscutter.net.proto.SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder
        public FKJCFGLHNPMOuterClass.FKJCFGLHNPMOrBuilder getJpegcngalgiOrBuilder() {
            return getJpegcngalgi();
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
            if (this.jpegcngalgi_ != null) {
                output.writeMessage(3, getJpegcngalgi());
            }
            if (this.raceInfo_ != null) {
                output.writeMessage(4, getRaceInfo());
            }
            if (this.campInfo_ != null) {
                output.writeMessage(11, getCampInfo());
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
            if (this.jpegcngalgi_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(3, getJpegcngalgi());
            }
            if (this.raceInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(4, getRaceInfo());
            }
            if (this.campInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(11, getCampInfo());
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
            if (!(obj instanceof SeaLampV3Info)) {
                return equals(obj);
            }
            SeaLampV3Info other = (SeaLampV3Info) obj;
            if (hasRaceInfo() != other.hasRaceInfo()) {
                return false;
            }
            if ((hasRaceInfo() && !getRaceInfo().equals(other.getRaceInfo())) || hasCampInfo() != other.hasCampInfo()) {
                return false;
            }
            if ((!hasCampInfo() || getCampInfo().equals(other.getCampInfo())) && hasJpegcngalgi() == other.hasJpegcngalgi()) {
                return (!hasJpegcngalgi() || getJpegcngalgi().equals(other.getJpegcngalgi())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasRaceInfo()) {
                hash = (53 * ((37 * hash) + 4)) + getRaceInfo().hashCode();
            }
            if (hasCampInfo()) {
                hash = (53 * ((37 * hash) + 11)) + getCampInfo().hashCode();
            }
            if (hasJpegcngalgi()) {
                hash = (53 * ((37 * hash) + 3)) + getJpegcngalgi().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SeaLampV3Info parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SeaLampV3Info parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SeaLampV3Info parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SeaLampV3Info parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SeaLampV3Info parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SeaLampV3Info parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SeaLampV3Info parseFrom(InputStream input) throws IOException {
            return (SeaLampV3Info) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SeaLampV3Info parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SeaLampV3Info) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SeaLampV3Info parseDelimitedFrom(InputStream input) throws IOException {
            return (SeaLampV3Info) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SeaLampV3Info parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SeaLampV3Info) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SeaLampV3Info parseFrom(CodedInputStream input) throws IOException {
            return (SeaLampV3Info) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SeaLampV3Info parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SeaLampV3Info) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SeaLampV3Info prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SeaLampV3InfoOuterClass$SeaLampV3Info$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SeaLampV3InfoOrBuilder {
            private BDKPJAMLNCLOuterClass.BDKPJAMLNCL raceInfo_;
            private SingleFieldBuilderV3<BDKPJAMLNCLOuterClass.BDKPJAMLNCL, BDKPJAMLNCLOuterClass.BDKPJAMLNCL.Builder, BDKPJAMLNCLOuterClass.BDKPJAMLNCLOrBuilder> raceInfoBuilder_;
            private MEIDIANHEDDOuterClass.MEIDIANHEDD campInfo_;
            private SingleFieldBuilderV3<MEIDIANHEDDOuterClass.MEIDIANHEDD, MEIDIANHEDDOuterClass.MEIDIANHEDD.Builder, MEIDIANHEDDOuterClass.MEIDIANHEDDOrBuilder> campInfoBuilder_;
            private FKJCFGLHNPMOuterClass.FKJCFGLHNPM jpegcngalgi_;
            private SingleFieldBuilderV3<FKJCFGLHNPMOuterClass.FKJCFGLHNPM, FKJCFGLHNPMOuterClass.FKJCFGLHNPM.Builder, FKJCFGLHNPMOuterClass.FKJCFGLHNPMOrBuilder> jpegcngalgiBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SeaLampV3InfoOuterClass.internal_static_SeaLampV3Info_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SeaLampV3InfoOuterClass.internal_static_SeaLampV3Info_fieldAccessorTable.ensureFieldAccessorsInitialized(SeaLampV3Info.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SeaLampV3Info.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.raceInfoBuilder_ == null) {
                    this.raceInfo_ = null;
                } else {
                    this.raceInfo_ = null;
                    this.raceInfoBuilder_ = null;
                }
                if (this.campInfoBuilder_ == null) {
                    this.campInfo_ = null;
                } else {
                    this.campInfo_ = null;
                    this.campInfoBuilder_ = null;
                }
                if (this.jpegcngalgiBuilder_ == null) {
                    this.jpegcngalgi_ = null;
                } else {
                    this.jpegcngalgi_ = null;
                    this.jpegcngalgiBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SeaLampV3InfoOuterClass.internal_static_SeaLampV3Info_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SeaLampV3Info getDefaultInstanceForType() {
                return SeaLampV3Info.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SeaLampV3Info build() {
                SeaLampV3Info result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SeaLampV3Info buildPartial() {
                SeaLampV3Info result = new SeaLampV3Info(this);
                if (this.raceInfoBuilder_ == null) {
                    result.raceInfo_ = this.raceInfo_;
                } else {
                    result.raceInfo_ = this.raceInfoBuilder_.build();
                }
                if (this.campInfoBuilder_ == null) {
                    result.campInfo_ = this.campInfo_;
                } else {
                    result.campInfo_ = this.campInfoBuilder_.build();
                }
                if (this.jpegcngalgiBuilder_ == null) {
                    result.jpegcngalgi_ = this.jpegcngalgi_;
                } else {
                    result.jpegcngalgi_ = this.jpegcngalgiBuilder_.build();
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
                if (other instanceof SeaLampV3Info) {
                    return mergeFrom((SeaLampV3Info) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SeaLampV3Info other) {
                if (other == SeaLampV3Info.getDefaultInstance()) {
                    return this;
                }
                if (other.hasRaceInfo()) {
                    mergeRaceInfo(other.getRaceInfo());
                }
                if (other.hasCampInfo()) {
                    mergeCampInfo(other.getCampInfo());
                }
                if (other.hasJpegcngalgi()) {
                    mergeJpegcngalgi(other.getJpegcngalgi());
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
                SeaLampV3Info parsedMessage = null;
                try {
                    try {
                        parsedMessage = SeaLampV3Info.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SeaLampV3Info) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder
            public boolean hasRaceInfo() {
                return (this.raceInfoBuilder_ == null && this.raceInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder
            public BDKPJAMLNCLOuterClass.BDKPJAMLNCL getRaceInfo() {
                if (this.raceInfoBuilder_ == null) {
                    return this.raceInfo_ == null ? BDKPJAMLNCLOuterClass.BDKPJAMLNCL.getDefaultInstance() : this.raceInfo_;
                }
                return this.raceInfoBuilder_.getMessage();
            }

            public Builder setRaceInfo(BDKPJAMLNCLOuterClass.BDKPJAMLNCL value) {
                if (this.raceInfoBuilder_ != null) {
                    this.raceInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.raceInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setRaceInfo(BDKPJAMLNCLOuterClass.BDKPJAMLNCL.Builder builderForValue) {
                if (this.raceInfoBuilder_ == null) {
                    this.raceInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.raceInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeRaceInfo(BDKPJAMLNCLOuterClass.BDKPJAMLNCL value) {
                if (this.raceInfoBuilder_ == null) {
                    if (this.raceInfo_ != null) {
                        this.raceInfo_ = BDKPJAMLNCLOuterClass.BDKPJAMLNCL.newBuilder(this.raceInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.raceInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.raceInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearRaceInfo() {
                if (this.raceInfoBuilder_ == null) {
                    this.raceInfo_ = null;
                    onChanged();
                } else {
                    this.raceInfo_ = null;
                    this.raceInfoBuilder_ = null;
                }
                return this;
            }

            public BDKPJAMLNCLOuterClass.BDKPJAMLNCL.Builder getRaceInfoBuilder() {
                onChanged();
                return getRaceInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder
            public BDKPJAMLNCLOuterClass.BDKPJAMLNCLOrBuilder getRaceInfoOrBuilder() {
                if (this.raceInfoBuilder_ != null) {
                    return this.raceInfoBuilder_.getMessageOrBuilder();
                }
                return this.raceInfo_ == null ? BDKPJAMLNCLOuterClass.BDKPJAMLNCL.getDefaultInstance() : this.raceInfo_;
            }

            private SingleFieldBuilderV3<BDKPJAMLNCLOuterClass.BDKPJAMLNCL, BDKPJAMLNCLOuterClass.BDKPJAMLNCL.Builder, BDKPJAMLNCLOuterClass.BDKPJAMLNCLOrBuilder> getRaceInfoFieldBuilder() {
                if (this.raceInfoBuilder_ == null) {
                    this.raceInfoBuilder_ = new SingleFieldBuilderV3<>(getRaceInfo(), getParentForChildren(), isClean());
                    this.raceInfo_ = null;
                }
                return this.raceInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder
            public boolean hasCampInfo() {
                return (this.campInfoBuilder_ == null && this.campInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder
            public MEIDIANHEDDOuterClass.MEIDIANHEDD getCampInfo() {
                if (this.campInfoBuilder_ == null) {
                    return this.campInfo_ == null ? MEIDIANHEDDOuterClass.MEIDIANHEDD.getDefaultInstance() : this.campInfo_;
                }
                return this.campInfoBuilder_.getMessage();
            }

            public Builder setCampInfo(MEIDIANHEDDOuterClass.MEIDIANHEDD value) {
                if (this.campInfoBuilder_ != null) {
                    this.campInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.campInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setCampInfo(MEIDIANHEDDOuterClass.MEIDIANHEDD.Builder builderForValue) {
                if (this.campInfoBuilder_ == null) {
                    this.campInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.campInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeCampInfo(MEIDIANHEDDOuterClass.MEIDIANHEDD value) {
                if (this.campInfoBuilder_ == null) {
                    if (this.campInfo_ != null) {
                        this.campInfo_ = MEIDIANHEDDOuterClass.MEIDIANHEDD.newBuilder(this.campInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.campInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.campInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearCampInfo() {
                if (this.campInfoBuilder_ == null) {
                    this.campInfo_ = null;
                    onChanged();
                } else {
                    this.campInfo_ = null;
                    this.campInfoBuilder_ = null;
                }
                return this;
            }

            public MEIDIANHEDDOuterClass.MEIDIANHEDD.Builder getCampInfoBuilder() {
                onChanged();
                return getCampInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder
            public MEIDIANHEDDOuterClass.MEIDIANHEDDOrBuilder getCampInfoOrBuilder() {
                if (this.campInfoBuilder_ != null) {
                    return this.campInfoBuilder_.getMessageOrBuilder();
                }
                return this.campInfo_ == null ? MEIDIANHEDDOuterClass.MEIDIANHEDD.getDefaultInstance() : this.campInfo_;
            }

            private SingleFieldBuilderV3<MEIDIANHEDDOuterClass.MEIDIANHEDD, MEIDIANHEDDOuterClass.MEIDIANHEDD.Builder, MEIDIANHEDDOuterClass.MEIDIANHEDDOrBuilder> getCampInfoFieldBuilder() {
                if (this.campInfoBuilder_ == null) {
                    this.campInfoBuilder_ = new SingleFieldBuilderV3<>(getCampInfo(), getParentForChildren(), isClean());
                    this.campInfo_ = null;
                }
                return this.campInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder
            public boolean hasJpegcngalgi() {
                return (this.jpegcngalgiBuilder_ == null && this.jpegcngalgi_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder
            public FKJCFGLHNPMOuterClass.FKJCFGLHNPM getJpegcngalgi() {
                if (this.jpegcngalgiBuilder_ == null) {
                    return this.jpegcngalgi_ == null ? FKJCFGLHNPMOuterClass.FKJCFGLHNPM.getDefaultInstance() : this.jpegcngalgi_;
                }
                return this.jpegcngalgiBuilder_.getMessage();
            }

            public Builder setJpegcngalgi(FKJCFGLHNPMOuterClass.FKJCFGLHNPM value) {
                if (this.jpegcngalgiBuilder_ != null) {
                    this.jpegcngalgiBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.jpegcngalgi_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setJpegcngalgi(FKJCFGLHNPMOuterClass.FKJCFGLHNPM.Builder builderForValue) {
                if (this.jpegcngalgiBuilder_ == null) {
                    this.jpegcngalgi_ = builderForValue.build();
                    onChanged();
                } else {
                    this.jpegcngalgiBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeJpegcngalgi(FKJCFGLHNPMOuterClass.FKJCFGLHNPM value) {
                if (this.jpegcngalgiBuilder_ == null) {
                    if (this.jpegcngalgi_ != null) {
                        this.jpegcngalgi_ = FKJCFGLHNPMOuterClass.FKJCFGLHNPM.newBuilder(this.jpegcngalgi_).mergeFrom(value).buildPartial();
                    } else {
                        this.jpegcngalgi_ = value;
                    }
                    onChanged();
                } else {
                    this.jpegcngalgiBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearJpegcngalgi() {
                if (this.jpegcngalgiBuilder_ == null) {
                    this.jpegcngalgi_ = null;
                    onChanged();
                } else {
                    this.jpegcngalgi_ = null;
                    this.jpegcngalgiBuilder_ = null;
                }
                return this;
            }

            public FKJCFGLHNPMOuterClass.FKJCFGLHNPM.Builder getJpegcngalgiBuilder() {
                onChanged();
                return getJpegcngalgiFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder
            public FKJCFGLHNPMOuterClass.FKJCFGLHNPMOrBuilder getJpegcngalgiOrBuilder() {
                if (this.jpegcngalgiBuilder_ != null) {
                    return this.jpegcngalgiBuilder_.getMessageOrBuilder();
                }
                return this.jpegcngalgi_ == null ? FKJCFGLHNPMOuterClass.FKJCFGLHNPM.getDefaultInstance() : this.jpegcngalgi_;
            }

            private SingleFieldBuilderV3<FKJCFGLHNPMOuterClass.FKJCFGLHNPM, FKJCFGLHNPMOuterClass.FKJCFGLHNPM.Builder, FKJCFGLHNPMOuterClass.FKJCFGLHNPMOrBuilder> getJpegcngalgiFieldBuilder() {
                if (this.jpegcngalgiBuilder_ == null) {
                    this.jpegcngalgiBuilder_ = new SingleFieldBuilderV3<>(getJpegcngalgi(), getParentForChildren(), isClean());
                    this.jpegcngalgi_ = null;
                }
                return this.jpegcngalgiBuilder_;
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

        public static SeaLampV3Info getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SeaLampV3Info> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SeaLampV3Info> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SeaLampV3Info getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BDKPJAMLNCLOuterClass.getDescriptor();
        MEIDIANHEDDOuterClass.getDescriptor();
        FKJCFGLHNPMOuterClass.getDescriptor();
    }
}
