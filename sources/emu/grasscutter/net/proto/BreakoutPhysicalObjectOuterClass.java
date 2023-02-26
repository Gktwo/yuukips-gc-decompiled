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
import emu.grasscutter.net.proto.BreakoutBrickInfoOuterClass;
import emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass;
import emu.grasscutter.net.proto.BreakoutVector2OuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutPhysicalObjectOuterClass.class */
public final class BreakoutPhysicalObjectOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cBreakoutPhysicalObject.proto\u001a\u0015BreakoutVector2.proto\u001a$BreakoutPhysicalObjectModifier.proto\u001a\u0017BreakoutBrickInfo.proto\"\u0003\n\u0016BreakoutPhysicalObject\u0012\n\n\u0002id\u0018\u0001 \u0001(\r\u0012\r\n\u0005index\u0018\u0002 \u0001(\r\u0012\u0010\n\bisActive\u0018\u0003 \u0001(\b\u0012\u001d\n\u0003pos\u0018\u0004 \u0001(\u000b2\u0010.BreakoutVector2\u0012%\n\u000bmjehpphliia\u0018\u0005 \u0001(\u000b2\u0010.BreakoutVector2\u0012\r\n\u0005speed\u0018\u0006 \u0001(\u0005\u0012\u0013\n\u000bdlgpedplibk\u0018\u0007 \u0001(\r\u0012\r\n\u0005state\u0018\b \u0001(\r\u0012\u0013\n\u000belementType\u0018\t \u0001(\r\u0012\u0013\n\u000binhflokdoal\u0018\n \u0001(\r\u00124\n\u000bdlijmbkhdif\u0018\u000b \u0003(\u000b2\u001f.BreakoutPhysicalObjectModifier\u0012\u0013\n\u000babolecjpbhb\u0018\f \u0001(\u0005\u0012$\n\binfoList\u0018\r \u0003(\u000b2\u0012.BreakoutBrickInfo\u0012\u0013\n\u000bhmgmjglmbpl\u0018\u000e \u0001(\r\u0012\u0013\n\u000bapiembahlab\u0018\u000f \u0001(\r\u0012\u000e\n\u0006offset\u0018\u0010 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BreakoutVector2OuterClass.getDescriptor(), BreakoutPhysicalObjectModifierOuterClass.getDescriptor(), BreakoutBrickInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BreakoutPhysicalObject_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BreakoutPhysicalObject_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BreakoutPhysicalObject_descriptor, new String[]{"Id", "Index", "IsActive", "Pos", "Mjehpphliia", "Speed", "Dlgpedplibk", "State", "ElementType", "Inhflokdoal", "Dlijmbkhdif", "Abolecjpbhb", "InfoList", "Hmgmjglmbpl", "Apiembahlab", "Offset"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutPhysicalObjectOuterClass$BreakoutPhysicalObjectOrBuilder.class */
    public interface BreakoutPhysicalObjectOrBuilder extends MessageOrBuilder {
        int getId();

        int getIndex();

        boolean getIsActive();

        boolean hasPos();

        BreakoutVector2OuterClass.BreakoutVector2 getPos();

        BreakoutVector2OuterClass.BreakoutVector2OrBuilder getPosOrBuilder();

        boolean hasMjehpphliia();

        BreakoutVector2OuterClass.BreakoutVector2 getMjehpphliia();

        BreakoutVector2OuterClass.BreakoutVector2OrBuilder getMjehpphliiaOrBuilder();

        int getSpeed();

        int getDlgpedplibk();

        int getState();

        int getElementType();

        int getInhflokdoal();

        List<BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier> getDlijmbkhdifList();

        BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier getDlijmbkhdif(int i);

        int getDlijmbkhdifCount();

        List<? extends BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder> getDlijmbkhdifOrBuilderList();

        BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder getDlijmbkhdifOrBuilder(int i);

        int getAbolecjpbhb();

        List<BreakoutBrickInfoOuterClass.BreakoutBrickInfo> getInfoListList();

        BreakoutBrickInfoOuterClass.BreakoutBrickInfo getInfoList(int i);

        int getInfoListCount();

        List<? extends BreakoutBrickInfoOuterClass.BreakoutBrickInfoOrBuilder> getInfoListOrBuilderList();

        BreakoutBrickInfoOuterClass.BreakoutBrickInfoOrBuilder getInfoListOrBuilder(int i);

        int getHmgmjglmbpl();

        int getApiembahlab();

        int getOffset();
    }

    private BreakoutPhysicalObjectOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutPhysicalObjectOuterClass$BreakoutPhysicalObject.class */
    public static final class BreakoutPhysicalObject extends GeneratedMessageV3 implements BreakoutPhysicalObjectOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int INDEX_FIELD_NUMBER = 2;
        private int index_;
        public static final int ISACTIVE_FIELD_NUMBER = 3;
        private boolean isActive_;
        public static final int POS_FIELD_NUMBER = 4;
        private BreakoutVector2OuterClass.BreakoutVector2 pos_;
        public static final int MJEHPPHLIIA_FIELD_NUMBER = 5;
        private BreakoutVector2OuterClass.BreakoutVector2 mjehpphliia_;
        public static final int SPEED_FIELD_NUMBER = 6;
        private int speed_;
        public static final int DLGPEDPLIBK_FIELD_NUMBER = 7;
        private int dlgpedplibk_;
        public static final int STATE_FIELD_NUMBER = 8;
        private int state_;
        public static final int ELEMENTTYPE_FIELD_NUMBER = 9;
        private int elementType_;
        public static final int INHFLOKDOAL_FIELD_NUMBER = 10;
        private int inhflokdoal_;
        public static final int DLIJMBKHDIF_FIELD_NUMBER = 11;
        private List<BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier> dlijmbkhdif_;
        public static final int ABOLECJPBHB_FIELD_NUMBER = 12;
        private int abolecjpbhb_;
        public static final int INFOLIST_FIELD_NUMBER = 13;
        private List<BreakoutBrickInfoOuterClass.BreakoutBrickInfo> infoList_;
        public static final int HMGMJGLMBPL_FIELD_NUMBER = 14;
        private int hmgmjglmbpl_;
        public static final int APIEMBAHLAB_FIELD_NUMBER = 15;
        private int apiembahlab_;
        public static final int OFFSET_FIELD_NUMBER = 16;
        private int offset_;
        private byte memoizedIsInitialized;
        private static final BreakoutPhysicalObject DEFAULT_INSTANCE = new BreakoutPhysicalObject();
        private static final Parser<BreakoutPhysicalObject> PARSER = new AbstractParser<BreakoutPhysicalObject>() { // from class: emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.1
            @Override // com.google.protobuf.Parser
            public BreakoutPhysicalObject parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BreakoutPhysicalObject(input, extensionRegistry);
            }
        };

        private BreakoutPhysicalObject(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BreakoutPhysicalObject() {
            this.memoizedIsInitialized = -1;
            this.dlijmbkhdif_ = Collections.emptyList();
            this.infoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BreakoutPhysicalObject();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:98:0x0226 */
        private BreakoutPhysicalObject(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.id_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.index_ = input.readUInt32();
                                    break;
                                case 24:
                                    this.isActive_ = input.readBool();
                                    break;
                                case 34:
                                    BreakoutVector2OuterClass.BreakoutVector2.Builder subBuilder = this.pos_ != null ? this.pos_.toBuilder() : null;
                                    this.pos_ = (BreakoutVector2OuterClass.BreakoutVector2) input.readMessage(BreakoutVector2OuterClass.BreakoutVector2.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.pos_);
                                        this.pos_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 42:
                                    BreakoutVector2OuterClass.BreakoutVector2.Builder subBuilder2 = this.mjehpphliia_ != null ? this.mjehpphliia_.toBuilder() : null;
                                    this.mjehpphliia_ = (BreakoutVector2OuterClass.BreakoutVector2) input.readMessage(BreakoutVector2OuterClass.BreakoutVector2.parser(), extensionRegistry);
                                    if (subBuilder2 == null) {
                                        break;
                                    } else {
                                        subBuilder2.mergeFrom(this.mjehpphliia_);
                                        this.mjehpphliia_ = subBuilder2.buildPartial();
                                        break;
                                    }
                                case 48:
                                    this.speed_ = input.readInt32();
                                    break;
                                case 56:
                                    this.dlgpedplibk_ = input.readUInt32();
                                    break;
                                case 64:
                                    this.state_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.elementType_ = input.readUInt32();
                                    break;
                                case 80:
                                    this.inhflokdoal_ = input.readUInt32();
                                    break;
                                case 90:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.dlijmbkhdif_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.dlijmbkhdif_.add((BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier) input.readMessage(BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier.parser(), extensionRegistry));
                                    break;
                                case 96:
                                    this.abolecjpbhb_ = input.readInt32();
                                    break;
                                case 106:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.infoList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.infoList_.add((BreakoutBrickInfoOuterClass.BreakoutBrickInfo) input.readMessage(BreakoutBrickInfoOuterClass.BreakoutBrickInfo.parser(), extensionRegistry));
                                    break;
                                case 112:
                                    this.hmgmjglmbpl_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.apiembahlab_ = input.readUInt32();
                                    break;
                                case 128:
                                    this.offset_ = input.readInt32();
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
                    this.dlijmbkhdif_ = Collections.unmodifiableList(this.dlijmbkhdif_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.infoList_ = Collections.unmodifiableList(this.infoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BreakoutPhysicalObjectOuterClass.internal_static_BreakoutPhysicalObject_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BreakoutPhysicalObjectOuterClass.internal_static_BreakoutPhysicalObject_fieldAccessorTable.ensureFieldAccessorsInitialized(BreakoutPhysicalObject.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public int getIndex() {
            return this.index_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public boolean getIsActive() {
            return this.isActive_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public boolean hasPos() {
            return this.pos_ != null;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public BreakoutVector2OuterClass.BreakoutVector2 getPos() {
            return this.pos_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.pos_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public BreakoutVector2OuterClass.BreakoutVector2OrBuilder getPosOrBuilder() {
            return getPos();
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public boolean hasMjehpphliia() {
            return this.mjehpphliia_ != null;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public BreakoutVector2OuterClass.BreakoutVector2 getMjehpphliia() {
            return this.mjehpphliia_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.mjehpphliia_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public BreakoutVector2OuterClass.BreakoutVector2OrBuilder getMjehpphliiaOrBuilder() {
            return getMjehpphliia();
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public int getSpeed() {
            return this.speed_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public int getDlgpedplibk() {
            return this.dlgpedplibk_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public int getState() {
            return this.state_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public int getElementType() {
            return this.elementType_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public int getInhflokdoal() {
            return this.inhflokdoal_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public List<BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier> getDlijmbkhdifList() {
            return this.dlijmbkhdif_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public List<? extends BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder> getDlijmbkhdifOrBuilderList() {
            return this.dlijmbkhdif_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public int getDlijmbkhdifCount() {
            return this.dlijmbkhdif_.size();
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier getDlijmbkhdif(int index) {
            return this.dlijmbkhdif_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder getDlijmbkhdifOrBuilder(int index) {
            return this.dlijmbkhdif_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public int getAbolecjpbhb() {
            return this.abolecjpbhb_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public List<BreakoutBrickInfoOuterClass.BreakoutBrickInfo> getInfoListList() {
            return this.infoList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public List<? extends BreakoutBrickInfoOuterClass.BreakoutBrickInfoOrBuilder> getInfoListOrBuilderList() {
            return this.infoList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public int getInfoListCount() {
            return this.infoList_.size();
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public BreakoutBrickInfoOuterClass.BreakoutBrickInfo getInfoList(int index) {
            return this.infoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public BreakoutBrickInfoOuterClass.BreakoutBrickInfoOrBuilder getInfoListOrBuilder(int index) {
            return this.infoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public int getHmgmjglmbpl() {
            return this.hmgmjglmbpl_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public int getApiembahlab() {
            return this.apiembahlab_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
        public int getOffset() {
            return this.offset_;
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
            if (this.id_ != 0) {
                output.writeUInt32(1, this.id_);
            }
            if (this.index_ != 0) {
                output.writeUInt32(2, this.index_);
            }
            if (this.isActive_) {
                output.writeBool(3, this.isActive_);
            }
            if (this.pos_ != null) {
                output.writeMessage(4, getPos());
            }
            if (this.mjehpphliia_ != null) {
                output.writeMessage(5, getMjehpphliia());
            }
            if (this.speed_ != 0) {
                output.writeInt32(6, this.speed_);
            }
            if (this.dlgpedplibk_ != 0) {
                output.writeUInt32(7, this.dlgpedplibk_);
            }
            if (this.state_ != 0) {
                output.writeUInt32(8, this.state_);
            }
            if (this.elementType_ != 0) {
                output.writeUInt32(9, this.elementType_);
            }
            if (this.inhflokdoal_ != 0) {
                output.writeUInt32(10, this.inhflokdoal_);
            }
            for (int i = 0; i < this.dlijmbkhdif_.size(); i++) {
                output.writeMessage(11, this.dlijmbkhdif_.get(i));
            }
            if (this.abolecjpbhb_ != 0) {
                output.writeInt32(12, this.abolecjpbhb_);
            }
            for (int i2 = 0; i2 < this.infoList_.size(); i2++) {
                output.writeMessage(13, this.infoList_.get(i2));
            }
            if (this.hmgmjglmbpl_ != 0) {
                output.writeUInt32(14, this.hmgmjglmbpl_);
            }
            if (this.apiembahlab_ != 0) {
                output.writeUInt32(15, this.apiembahlab_);
            }
            if (this.offset_ != 0) {
                output.writeInt32(16, this.offset_);
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
            if (this.id_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.id_);
            }
            if (this.index_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.index_);
            }
            if (this.isActive_) {
                size2 += CodedOutputStream.computeBoolSize(3, this.isActive_);
            }
            if (this.pos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(4, getPos());
            }
            if (this.mjehpphliia_ != null) {
                size2 += CodedOutputStream.computeMessageSize(5, getMjehpphliia());
            }
            if (this.speed_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(6, this.speed_);
            }
            if (this.dlgpedplibk_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.dlgpedplibk_);
            }
            if (this.state_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.state_);
            }
            if (this.elementType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.elementType_);
            }
            if (this.inhflokdoal_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.inhflokdoal_);
            }
            for (int i = 0; i < this.dlijmbkhdif_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.dlijmbkhdif_.get(i));
            }
            if (this.abolecjpbhb_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(12, this.abolecjpbhb_);
            }
            for (int i2 = 0; i2 < this.infoList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(13, this.infoList_.get(i2));
            }
            if (this.hmgmjglmbpl_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.hmgmjglmbpl_);
            }
            if (this.apiembahlab_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.apiembahlab_);
            }
            if (this.offset_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(16, this.offset_);
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
            if (!(obj instanceof BreakoutPhysicalObject)) {
                return equals(obj);
            }
            BreakoutPhysicalObject other = (BreakoutPhysicalObject) obj;
            if (getId() != other.getId() || getIndex() != other.getIndex() || getIsActive() != other.getIsActive() || hasPos() != other.hasPos()) {
                return false;
            }
            if ((!hasPos() || getPos().equals(other.getPos())) && hasMjehpphliia() == other.hasMjehpphliia()) {
                return (!hasMjehpphliia() || getMjehpphliia().equals(other.getMjehpphliia())) && getSpeed() == other.getSpeed() && getDlgpedplibk() == other.getDlgpedplibk() && getState() == other.getState() && getElementType() == other.getElementType() && getInhflokdoal() == other.getInhflokdoal() && getDlijmbkhdifList().equals(other.getDlijmbkhdifList()) && getAbolecjpbhb() == other.getAbolecjpbhb() && getInfoListList().equals(other.getInfoListList()) && getHmgmjglmbpl() == other.getHmgmjglmbpl() && getApiembahlab() == other.getApiembahlab() && getOffset() == other.getOffset() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getId())) + 2)) + getIndex())) + 3)) + Internal.hashBoolean(getIsActive());
            if (hasPos()) {
                hash = (53 * ((37 * hash) + 4)) + getPos().hashCode();
            }
            if (hasMjehpphliia()) {
                hash = (53 * ((37 * hash) + 5)) + getMjehpphliia().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 6)) + getSpeed())) + 7)) + getDlgpedplibk())) + 8)) + getState())) + 9)) + getElementType())) + 10)) + getInhflokdoal();
            if (getDlijmbkhdifCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 11)) + getDlijmbkhdifList().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 12)) + getAbolecjpbhb();
            if (getInfoListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 13)) + getInfoListList().hashCode();
            }
            int hash4 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash3) + 14)) + getHmgmjglmbpl())) + 15)) + getApiembahlab())) + 16)) + getOffset())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static BreakoutPhysicalObject parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutPhysicalObject parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutPhysicalObject parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutPhysicalObject parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutPhysicalObject parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutPhysicalObject parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutPhysicalObject parseFrom(InputStream input) throws IOException {
            return (BreakoutPhysicalObject) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BreakoutPhysicalObject parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutPhysicalObject) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BreakoutPhysicalObject parseDelimitedFrom(InputStream input) throws IOException {
            return (BreakoutPhysicalObject) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BreakoutPhysicalObject parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutPhysicalObject) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BreakoutPhysicalObject parseFrom(CodedInputStream input) throws IOException {
            return (BreakoutPhysicalObject) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BreakoutPhysicalObject parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutPhysicalObject) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BreakoutPhysicalObject prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutPhysicalObjectOuterClass$BreakoutPhysicalObject$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BreakoutPhysicalObjectOrBuilder {
            private int bitField0_;
            private int id_;
            private int index_;
            private boolean isActive_;
            private BreakoutVector2OuterClass.BreakoutVector2 pos_;
            private SingleFieldBuilderV3<BreakoutVector2OuterClass.BreakoutVector2, BreakoutVector2OuterClass.BreakoutVector2.Builder, BreakoutVector2OuterClass.BreakoutVector2OrBuilder> posBuilder_;
            private BreakoutVector2OuterClass.BreakoutVector2 mjehpphliia_;
            private SingleFieldBuilderV3<BreakoutVector2OuterClass.BreakoutVector2, BreakoutVector2OuterClass.BreakoutVector2.Builder, BreakoutVector2OuterClass.BreakoutVector2OrBuilder> mjehpphliiaBuilder_;
            private int speed_;
            private int dlgpedplibk_;
            private int state_;
            private int elementType_;
            private int inhflokdoal_;
            private RepeatedFieldBuilderV3<BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier, BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier.Builder, BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder> dlijmbkhdifBuilder_;
            private int abolecjpbhb_;
            private RepeatedFieldBuilderV3<BreakoutBrickInfoOuterClass.BreakoutBrickInfo, BreakoutBrickInfoOuterClass.BreakoutBrickInfo.Builder, BreakoutBrickInfoOuterClass.BreakoutBrickInfoOrBuilder> infoListBuilder_;
            private int hmgmjglmbpl_;
            private int apiembahlab_;
            private int offset_;
            private List<BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier> dlijmbkhdif_ = Collections.emptyList();
            private List<BreakoutBrickInfoOuterClass.BreakoutBrickInfo> infoList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return BreakoutPhysicalObjectOuterClass.internal_static_BreakoutPhysicalObject_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BreakoutPhysicalObjectOuterClass.internal_static_BreakoutPhysicalObject_fieldAccessorTable.ensureFieldAccessorsInitialized(BreakoutPhysicalObject.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BreakoutPhysicalObject.alwaysUseFieldBuilders) {
                    getDlijmbkhdifFieldBuilder();
                    getInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.id_ = 0;
                this.index_ = 0;
                this.isActive_ = false;
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                if (this.mjehpphliiaBuilder_ == null) {
                    this.mjehpphliia_ = null;
                } else {
                    this.mjehpphliia_ = null;
                    this.mjehpphliiaBuilder_ = null;
                }
                this.speed_ = 0;
                this.dlgpedplibk_ = 0;
                this.state_ = 0;
                this.elementType_ = 0;
                this.inhflokdoal_ = 0;
                if (this.dlijmbkhdifBuilder_ == null) {
                    this.dlijmbkhdif_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.dlijmbkhdifBuilder_.clear();
                }
                this.abolecjpbhb_ = 0;
                if (this.infoListBuilder_ == null) {
                    this.infoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.infoListBuilder_.clear();
                }
                this.hmgmjglmbpl_ = 0;
                this.apiembahlab_ = 0;
                this.offset_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BreakoutPhysicalObjectOuterClass.internal_static_BreakoutPhysicalObject_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BreakoutPhysicalObject getDefaultInstanceForType() {
                return BreakoutPhysicalObject.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BreakoutPhysicalObject build() {
                BreakoutPhysicalObject result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BreakoutPhysicalObject buildPartial() {
                BreakoutPhysicalObject result = new BreakoutPhysicalObject(this);
                int i = this.bitField0_;
                result.id_ = this.id_;
                result.index_ = this.index_;
                result.isActive_ = this.isActive_;
                if (this.posBuilder_ == null) {
                    result.pos_ = this.pos_;
                } else {
                    result.pos_ = this.posBuilder_.build();
                }
                if (this.mjehpphliiaBuilder_ == null) {
                    result.mjehpphliia_ = this.mjehpphliia_;
                } else {
                    result.mjehpphliia_ = this.mjehpphliiaBuilder_.build();
                }
                result.speed_ = this.speed_;
                result.dlgpedplibk_ = this.dlgpedplibk_;
                result.state_ = this.state_;
                result.elementType_ = this.elementType_;
                result.inhflokdoal_ = this.inhflokdoal_;
                if (this.dlijmbkhdifBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.dlijmbkhdif_ = Collections.unmodifiableList(this.dlijmbkhdif_);
                        this.bitField0_ &= -2;
                    }
                    result.dlijmbkhdif_ = this.dlijmbkhdif_;
                } else {
                    result.dlijmbkhdif_ = this.dlijmbkhdifBuilder_.build();
                }
                result.abolecjpbhb_ = this.abolecjpbhb_;
                if (this.infoListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.infoList_ = Collections.unmodifiableList(this.infoList_);
                        this.bitField0_ &= -3;
                    }
                    result.infoList_ = this.infoList_;
                } else {
                    result.infoList_ = this.infoListBuilder_.build();
                }
                result.hmgmjglmbpl_ = this.hmgmjglmbpl_;
                result.apiembahlab_ = this.apiembahlab_;
                result.offset_ = this.offset_;
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
                if (other instanceof BreakoutPhysicalObject) {
                    return mergeFrom((BreakoutPhysicalObject) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BreakoutPhysicalObject other) {
                if (other == BreakoutPhysicalObject.getDefaultInstance()) {
                    return this;
                }
                if (other.getId() != 0) {
                    setId(other.getId());
                }
                if (other.getIndex() != 0) {
                    setIndex(other.getIndex());
                }
                if (other.getIsActive()) {
                    setIsActive(other.getIsActive());
                }
                if (other.hasPos()) {
                    mergePos(other.getPos());
                }
                if (other.hasMjehpphliia()) {
                    mergeMjehpphliia(other.getMjehpphliia());
                }
                if (other.getSpeed() != 0) {
                    setSpeed(other.getSpeed());
                }
                if (other.getDlgpedplibk() != 0) {
                    setDlgpedplibk(other.getDlgpedplibk());
                }
                if (other.getState() != 0) {
                    setState(other.getState());
                }
                if (other.getElementType() != 0) {
                    setElementType(other.getElementType());
                }
                if (other.getInhflokdoal() != 0) {
                    setInhflokdoal(other.getInhflokdoal());
                }
                if (this.dlijmbkhdifBuilder_ == null) {
                    if (!other.dlijmbkhdif_.isEmpty()) {
                        if (this.dlijmbkhdif_.isEmpty()) {
                            this.dlijmbkhdif_ = other.dlijmbkhdif_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDlijmbkhdifIsMutable();
                            this.dlijmbkhdif_.addAll(other.dlijmbkhdif_);
                        }
                        onChanged();
                    }
                } else if (!other.dlijmbkhdif_.isEmpty()) {
                    if (this.dlijmbkhdifBuilder_.isEmpty()) {
                        this.dlijmbkhdifBuilder_.dispose();
                        this.dlijmbkhdifBuilder_ = null;
                        this.dlijmbkhdif_ = other.dlijmbkhdif_;
                        this.bitField0_ &= -2;
                        this.dlijmbkhdifBuilder_ = BreakoutPhysicalObject.alwaysUseFieldBuilders ? getDlijmbkhdifFieldBuilder() : null;
                    } else {
                        this.dlijmbkhdifBuilder_.addAllMessages(other.dlijmbkhdif_);
                    }
                }
                if (other.getAbolecjpbhb() != 0) {
                    setAbolecjpbhb(other.getAbolecjpbhb());
                }
                if (this.infoListBuilder_ == null) {
                    if (!other.infoList_.isEmpty()) {
                        if (this.infoList_.isEmpty()) {
                            this.infoList_ = other.infoList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureInfoListIsMutable();
                            this.infoList_.addAll(other.infoList_);
                        }
                        onChanged();
                    }
                } else if (!other.infoList_.isEmpty()) {
                    if (this.infoListBuilder_.isEmpty()) {
                        this.infoListBuilder_.dispose();
                        this.infoListBuilder_ = null;
                        this.infoList_ = other.infoList_;
                        this.bitField0_ &= -3;
                        this.infoListBuilder_ = BreakoutPhysicalObject.alwaysUseFieldBuilders ? getInfoListFieldBuilder() : null;
                    } else {
                        this.infoListBuilder_.addAllMessages(other.infoList_);
                    }
                }
                if (other.getHmgmjglmbpl() != 0) {
                    setHmgmjglmbpl(other.getHmgmjglmbpl());
                }
                if (other.getApiembahlab() != 0) {
                    setApiembahlab(other.getApiembahlab());
                }
                if (other.getOffset() != 0) {
                    setOffset(other.getOffset());
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
                BreakoutPhysicalObject parsedMessage = null;
                try {
                    try {
                        parsedMessage = BreakoutPhysicalObject.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BreakoutPhysicalObject) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public int getId() {
                return this.id_;
            }

            public Builder setId(int value) {
                this.id_ = value;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public int getIndex() {
                return this.index_;
            }

            public Builder setIndex(int value) {
                this.index_ = value;
                onChanged();
                return this;
            }

            public Builder clearIndex() {
                this.index_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public boolean getIsActive() {
                return this.isActive_;
            }

            public Builder setIsActive(boolean value) {
                this.isActive_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsActive() {
                this.isActive_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public boolean hasPos() {
                return (this.posBuilder_ == null && this.pos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public BreakoutVector2OuterClass.BreakoutVector2 getPos() {
                if (this.posBuilder_ == null) {
                    return this.pos_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.pos_;
                }
                return this.posBuilder_.getMessage();
            }

            public Builder setPos(BreakoutVector2OuterClass.BreakoutVector2 value) {
                if (this.posBuilder_ != null) {
                    this.posBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.pos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPos(BreakoutVector2OuterClass.BreakoutVector2.Builder builderForValue) {
                if (this.posBuilder_ == null) {
                    this.pos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.posBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePos(BreakoutVector2OuterClass.BreakoutVector2 value) {
                if (this.posBuilder_ == null) {
                    if (this.pos_ != null) {
                        this.pos_ = BreakoutVector2OuterClass.BreakoutVector2.newBuilder(this.pos_).mergeFrom(value).buildPartial();
                    } else {
                        this.pos_ = value;
                    }
                    onChanged();
                } else {
                    this.posBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPos() {
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                    onChanged();
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                return this;
            }

            public BreakoutVector2OuterClass.BreakoutVector2.Builder getPosBuilder() {
                onChanged();
                return getPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public BreakoutVector2OuterClass.BreakoutVector2OrBuilder getPosOrBuilder() {
                if (this.posBuilder_ != null) {
                    return this.posBuilder_.getMessageOrBuilder();
                }
                return this.pos_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.pos_;
            }

            private SingleFieldBuilderV3<BreakoutVector2OuterClass.BreakoutVector2, BreakoutVector2OuterClass.BreakoutVector2.Builder, BreakoutVector2OuterClass.BreakoutVector2OrBuilder> getPosFieldBuilder() {
                if (this.posBuilder_ == null) {
                    this.posBuilder_ = new SingleFieldBuilderV3<>(getPos(), getParentForChildren(), isClean());
                    this.pos_ = null;
                }
                return this.posBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public boolean hasMjehpphliia() {
                return (this.mjehpphliiaBuilder_ == null && this.mjehpphliia_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public BreakoutVector2OuterClass.BreakoutVector2 getMjehpphliia() {
                if (this.mjehpphliiaBuilder_ == null) {
                    return this.mjehpphliia_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.mjehpphliia_;
                }
                return this.mjehpphliiaBuilder_.getMessage();
            }

            public Builder setMjehpphliia(BreakoutVector2OuterClass.BreakoutVector2 value) {
                if (this.mjehpphliiaBuilder_ != null) {
                    this.mjehpphliiaBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.mjehpphliia_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setMjehpphliia(BreakoutVector2OuterClass.BreakoutVector2.Builder builderForValue) {
                if (this.mjehpphliiaBuilder_ == null) {
                    this.mjehpphliia_ = builderForValue.build();
                    onChanged();
                } else {
                    this.mjehpphliiaBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeMjehpphliia(BreakoutVector2OuterClass.BreakoutVector2 value) {
                if (this.mjehpphliiaBuilder_ == null) {
                    if (this.mjehpphliia_ != null) {
                        this.mjehpphliia_ = BreakoutVector2OuterClass.BreakoutVector2.newBuilder(this.mjehpphliia_).mergeFrom(value).buildPartial();
                    } else {
                        this.mjehpphliia_ = value;
                    }
                    onChanged();
                } else {
                    this.mjehpphliiaBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearMjehpphliia() {
                if (this.mjehpphliiaBuilder_ == null) {
                    this.mjehpphliia_ = null;
                    onChanged();
                } else {
                    this.mjehpphliia_ = null;
                    this.mjehpphliiaBuilder_ = null;
                }
                return this;
            }

            public BreakoutVector2OuterClass.BreakoutVector2.Builder getMjehpphliiaBuilder() {
                onChanged();
                return getMjehpphliiaFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public BreakoutVector2OuterClass.BreakoutVector2OrBuilder getMjehpphliiaOrBuilder() {
                if (this.mjehpphliiaBuilder_ != null) {
                    return this.mjehpphliiaBuilder_.getMessageOrBuilder();
                }
                return this.mjehpphliia_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.mjehpphliia_;
            }

            private SingleFieldBuilderV3<BreakoutVector2OuterClass.BreakoutVector2, BreakoutVector2OuterClass.BreakoutVector2.Builder, BreakoutVector2OuterClass.BreakoutVector2OrBuilder> getMjehpphliiaFieldBuilder() {
                if (this.mjehpphliiaBuilder_ == null) {
                    this.mjehpphliiaBuilder_ = new SingleFieldBuilderV3<>(getMjehpphliia(), getParentForChildren(), isClean());
                    this.mjehpphliia_ = null;
                }
                return this.mjehpphliiaBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public int getSpeed() {
                return this.speed_;
            }

            public Builder setSpeed(int value) {
                this.speed_ = value;
                onChanged();
                return this;
            }

            public Builder clearSpeed() {
                this.speed_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public int getDlgpedplibk() {
                return this.dlgpedplibk_;
            }

            public Builder setDlgpedplibk(int value) {
                this.dlgpedplibk_ = value;
                onChanged();
                return this;
            }

            public Builder clearDlgpedplibk() {
                this.dlgpedplibk_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public int getState() {
                return this.state_;
            }

            public Builder setState(int value) {
                this.state_ = value;
                onChanged();
                return this;
            }

            public Builder clearState() {
                this.state_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public int getElementType() {
                return this.elementType_;
            }

            public Builder setElementType(int value) {
                this.elementType_ = value;
                onChanged();
                return this;
            }

            public Builder clearElementType() {
                this.elementType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public int getInhflokdoal() {
                return this.inhflokdoal_;
            }

            public Builder setInhflokdoal(int value) {
                this.inhflokdoal_ = value;
                onChanged();
                return this;
            }

            public Builder clearInhflokdoal() {
                this.inhflokdoal_ = 0;
                onChanged();
                return this;
            }

            private void ensureDlijmbkhdifIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.dlijmbkhdif_ = new ArrayList(this.dlijmbkhdif_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public List<BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier> getDlijmbkhdifList() {
                if (this.dlijmbkhdifBuilder_ == null) {
                    return Collections.unmodifiableList(this.dlijmbkhdif_);
                }
                return this.dlijmbkhdifBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public int getDlijmbkhdifCount() {
                if (this.dlijmbkhdifBuilder_ == null) {
                    return this.dlijmbkhdif_.size();
                }
                return this.dlijmbkhdifBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier getDlijmbkhdif(int index) {
                if (this.dlijmbkhdifBuilder_ == null) {
                    return this.dlijmbkhdif_.get(index);
                }
                return this.dlijmbkhdifBuilder_.getMessage(index);
            }

            public Builder setDlijmbkhdif(int index, BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier value) {
                if (this.dlijmbkhdifBuilder_ != null) {
                    this.dlijmbkhdifBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDlijmbkhdifIsMutable();
                    this.dlijmbkhdif_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDlijmbkhdif(int index, BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier.Builder builderForValue) {
                if (this.dlijmbkhdifBuilder_ == null) {
                    ensureDlijmbkhdifIsMutable();
                    this.dlijmbkhdif_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dlijmbkhdifBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDlijmbkhdif(BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier value) {
                if (this.dlijmbkhdifBuilder_ != null) {
                    this.dlijmbkhdifBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDlijmbkhdifIsMutable();
                    this.dlijmbkhdif_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDlijmbkhdif(int index, BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier value) {
                if (this.dlijmbkhdifBuilder_ != null) {
                    this.dlijmbkhdifBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDlijmbkhdifIsMutable();
                    this.dlijmbkhdif_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDlijmbkhdif(BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier.Builder builderForValue) {
                if (this.dlijmbkhdifBuilder_ == null) {
                    ensureDlijmbkhdifIsMutable();
                    this.dlijmbkhdif_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dlijmbkhdifBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDlijmbkhdif(int index, BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier.Builder builderForValue) {
                if (this.dlijmbkhdifBuilder_ == null) {
                    ensureDlijmbkhdifIsMutable();
                    this.dlijmbkhdif_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dlijmbkhdifBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDlijmbkhdif(Iterable<? extends BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier> values) {
                if (this.dlijmbkhdifBuilder_ == null) {
                    ensureDlijmbkhdifIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.dlijmbkhdif_);
                    onChanged();
                } else {
                    this.dlijmbkhdifBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDlijmbkhdif() {
                if (this.dlijmbkhdifBuilder_ == null) {
                    this.dlijmbkhdif_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.dlijmbkhdifBuilder_.clear();
                }
                return this;
            }

            public Builder removeDlijmbkhdif(int index) {
                if (this.dlijmbkhdifBuilder_ == null) {
                    ensureDlijmbkhdifIsMutable();
                    this.dlijmbkhdif_.remove(index);
                    onChanged();
                } else {
                    this.dlijmbkhdifBuilder_.remove(index);
                }
                return this;
            }

            public BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier.Builder getDlijmbkhdifBuilder(int index) {
                return getDlijmbkhdifFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder getDlijmbkhdifOrBuilder(int index) {
                if (this.dlijmbkhdifBuilder_ == null) {
                    return this.dlijmbkhdif_.get(index);
                }
                return this.dlijmbkhdifBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public List<? extends BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder> getDlijmbkhdifOrBuilderList() {
                if (this.dlijmbkhdifBuilder_ != null) {
                    return this.dlijmbkhdifBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.dlijmbkhdif_);
            }

            public BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier.Builder addDlijmbkhdifBuilder() {
                return getDlijmbkhdifFieldBuilder().addBuilder(BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier.getDefaultInstance());
            }

            public BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier.Builder addDlijmbkhdifBuilder(int index) {
                return getDlijmbkhdifFieldBuilder().addBuilder(index, BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier.getDefaultInstance());
            }

            public List<BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier.Builder> getDlijmbkhdifBuilderList() {
                return getDlijmbkhdifFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier, BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier.Builder, BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder> getDlijmbkhdifFieldBuilder() {
                if (this.dlijmbkhdifBuilder_ == null) {
                    this.dlijmbkhdifBuilder_ = new RepeatedFieldBuilderV3<>(this.dlijmbkhdif_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.dlijmbkhdif_ = null;
                }
                return this.dlijmbkhdifBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public int getAbolecjpbhb() {
                return this.abolecjpbhb_;
            }

            public Builder setAbolecjpbhb(int value) {
                this.abolecjpbhb_ = value;
                onChanged();
                return this;
            }

            public Builder clearAbolecjpbhb() {
                this.abolecjpbhb_ = 0;
                onChanged();
                return this;
            }

            private void ensureInfoListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.infoList_ = new ArrayList(this.infoList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public List<BreakoutBrickInfoOuterClass.BreakoutBrickInfo> getInfoListList() {
                if (this.infoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.infoList_);
                }
                return this.infoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public int getInfoListCount() {
                if (this.infoListBuilder_ == null) {
                    return this.infoList_.size();
                }
                return this.infoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public BreakoutBrickInfoOuterClass.BreakoutBrickInfo getInfoList(int index) {
                if (this.infoListBuilder_ == null) {
                    return this.infoList_.get(index);
                }
                return this.infoListBuilder_.getMessage(index);
            }

            public Builder setInfoList(int index, BreakoutBrickInfoOuterClass.BreakoutBrickInfo value) {
                if (this.infoListBuilder_ != null) {
                    this.infoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInfoListIsMutable();
                    this.infoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setInfoList(int index, BreakoutBrickInfoOuterClass.BreakoutBrickInfo.Builder builderForValue) {
                if (this.infoListBuilder_ == null) {
                    ensureInfoListIsMutable();
                    this.infoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.infoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addInfoList(BreakoutBrickInfoOuterClass.BreakoutBrickInfo value) {
                if (this.infoListBuilder_ != null) {
                    this.infoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInfoListIsMutable();
                    this.infoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addInfoList(int index, BreakoutBrickInfoOuterClass.BreakoutBrickInfo value) {
                if (this.infoListBuilder_ != null) {
                    this.infoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInfoListIsMutable();
                    this.infoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addInfoList(BreakoutBrickInfoOuterClass.BreakoutBrickInfo.Builder builderForValue) {
                if (this.infoListBuilder_ == null) {
                    ensureInfoListIsMutable();
                    this.infoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.infoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addInfoList(int index, BreakoutBrickInfoOuterClass.BreakoutBrickInfo.Builder builderForValue) {
                if (this.infoListBuilder_ == null) {
                    ensureInfoListIsMutable();
                    this.infoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.infoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllInfoList(Iterable<? extends BreakoutBrickInfoOuterClass.BreakoutBrickInfo> values) {
                if (this.infoListBuilder_ == null) {
                    ensureInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.infoList_);
                    onChanged();
                } else {
                    this.infoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearInfoList() {
                if (this.infoListBuilder_ == null) {
                    this.infoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.infoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeInfoList(int index) {
                if (this.infoListBuilder_ == null) {
                    ensureInfoListIsMutable();
                    this.infoList_.remove(index);
                    onChanged();
                } else {
                    this.infoListBuilder_.remove(index);
                }
                return this;
            }

            public BreakoutBrickInfoOuterClass.BreakoutBrickInfo.Builder getInfoListBuilder(int index) {
                return getInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public BreakoutBrickInfoOuterClass.BreakoutBrickInfoOrBuilder getInfoListOrBuilder(int index) {
                if (this.infoListBuilder_ == null) {
                    return this.infoList_.get(index);
                }
                return this.infoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public List<? extends BreakoutBrickInfoOuterClass.BreakoutBrickInfoOrBuilder> getInfoListOrBuilderList() {
                if (this.infoListBuilder_ != null) {
                    return this.infoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.infoList_);
            }

            public BreakoutBrickInfoOuterClass.BreakoutBrickInfo.Builder addInfoListBuilder() {
                return getInfoListFieldBuilder().addBuilder(BreakoutBrickInfoOuterClass.BreakoutBrickInfo.getDefaultInstance());
            }

            public BreakoutBrickInfoOuterClass.BreakoutBrickInfo.Builder addInfoListBuilder(int index) {
                return getInfoListFieldBuilder().addBuilder(index, BreakoutBrickInfoOuterClass.BreakoutBrickInfo.getDefaultInstance());
            }

            public List<BreakoutBrickInfoOuterClass.BreakoutBrickInfo.Builder> getInfoListBuilderList() {
                return getInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BreakoutBrickInfoOuterClass.BreakoutBrickInfo, BreakoutBrickInfoOuterClass.BreakoutBrickInfo.Builder, BreakoutBrickInfoOuterClass.BreakoutBrickInfoOrBuilder> getInfoListFieldBuilder() {
                if (this.infoListBuilder_ == null) {
                    this.infoListBuilder_ = new RepeatedFieldBuilderV3<>(this.infoList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.infoList_ = null;
                }
                return this.infoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public int getHmgmjglmbpl() {
                return this.hmgmjglmbpl_;
            }

            public Builder setHmgmjglmbpl(int value) {
                this.hmgmjglmbpl_ = value;
                onChanged();
                return this;
            }

            public Builder clearHmgmjglmbpl() {
                this.hmgmjglmbpl_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public int getApiembahlab() {
                return this.apiembahlab_;
            }

            public Builder setApiembahlab(int value) {
                this.apiembahlab_ = value;
                onChanged();
                return this;
            }

            public Builder clearApiembahlab() {
                this.apiembahlab_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder
            public int getOffset() {
                return this.offset_;
            }

            public Builder setOffset(int value) {
                this.offset_ = value;
                onChanged();
                return this;
            }

            public Builder clearOffset() {
                this.offset_ = 0;
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

        public static BreakoutPhysicalObject getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BreakoutPhysicalObject> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BreakoutPhysicalObject> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BreakoutPhysicalObject getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BreakoutVector2OuterClass.getDescriptor();
        BreakoutPhysicalObjectModifierOuterClass.getDescriptor();
        BreakoutBrickInfoOuterClass.getDescriptor();
    }
}
