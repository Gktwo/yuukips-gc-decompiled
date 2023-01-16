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
import emu.grasscutter.net.proto.AnchorPointDataOuterClass;
import emu.grasscutter.net.proto.ClientCollectorDataOuterClass;
import emu.grasscutter.net.proto.LunchBoxDataOuterClass;
import emu.grasscutter.net.proto.OneoffGatherPointDetectorDataOuterClass;
import emu.grasscutter.net.proto.SkyCrystalDetectorDataOuterClass;
import emu.grasscutter.net.proto.WeatherWizardDataOuterClass;
import emu.grasscutter.net.proto.WidgetCoolDownDataOuterClass;
import emu.grasscutter.net.proto.WidgetSlotDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AllWidgetDataNotifyOuterClass.class */
public final class AllWidgetDataNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019AllWidgetDataNotify.proto\u001a\u0015AnchorPointData.proto\u001a\u0019ClientCollectorData.proto\u001a\u0012LunchBoxData.proto\u001a#OneoffGatherPointDetectorData.proto\u001a\u001cSkyCrystalDetectorData.proto\u001a\u0017WeatherWizardData.proto\u001a\u0018WidgetCoolDownData.proto\u001a\u0014WidgetSlotData.proto\"Ã\u0004\n\u0013AllWidgetDataNotify\u0012%\n\u001dnext_anchor_point_usable_time\u0018\u0005 \u0001(\r\u0012%\n\u000elunch_box_data\u0018\u0001 \u0001(\u000b2\r.LunchBoxData\u0012N\n&oneoff_gather_point_detector_data_list\u0018\u000e \u0003(\u000b2\u001e.OneoffGatherPointDetectorData\u0012\"\n\tslot_list\u0018\u0006 \u0003(\u000b2\u000f.WidgetSlotData\u0012%\n\u001dbackground_active_widget_list\u0018\t \u0003(\r\u00126\n\u0019cool_down_group_data_list\u0018\u0003 \u0003(\u000b2\u0013.WidgetCoolDownData\u0012:\n\u0019sky_crystal_detector_data\u0018\u0004 \u0001(\u000b2\u0017.SkyCrystalDetectorData\u00128\n\u001aclient_collector_data_list\u0018\u0007 \u0003(\u000b2\u0014.ClientCollectorData\u0012/\n\u0013weather_wizard_data\u0018\u000f \u0001(\u000b2\u0012.WeatherWizardData\u00127\n\u001anormal_cool_down_data_list\u0018\n \u0003(\u000b2\u0013.WidgetCoolDownData\u0012+\n\u0011anchor_point_list\u0018\r \u0003(\u000b2\u0010.AnchorPointDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AnchorPointDataOuterClass.getDescriptor(), ClientCollectorDataOuterClass.getDescriptor(), LunchBoxDataOuterClass.getDescriptor(), OneoffGatherPointDetectorDataOuterClass.getDescriptor(), SkyCrystalDetectorDataOuterClass.getDescriptor(), WeatherWizardDataOuterClass.getDescriptor(), WidgetCoolDownDataOuterClass.getDescriptor(), WidgetSlotDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AllWidgetDataNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AllWidgetDataNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AllWidgetDataNotify_descriptor, new String[]{"NextAnchorPointUsableTime", "LunchBoxData", "OneoffGatherPointDetectorDataList", "SlotList", "BackgroundActiveWidgetList", "CoolDownGroupDataList", "SkyCrystalDetectorData", "ClientCollectorDataList", "WeatherWizardData", "NormalCoolDownDataList", "AnchorPointList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AllWidgetDataNotifyOuterClass$AllWidgetDataNotifyOrBuilder.class */
    public interface AllWidgetDataNotifyOrBuilder extends MessageOrBuilder {
        int getNextAnchorPointUsableTime();

        boolean hasLunchBoxData();

        LunchBoxDataOuterClass.LunchBoxData getLunchBoxData();

        LunchBoxDataOuterClass.LunchBoxDataOrBuilder getLunchBoxDataOrBuilder();

        List<OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData> getOneoffGatherPointDetectorDataListList();

        OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData getOneoffGatherPointDetectorDataList(int i);

        int getOneoffGatherPointDetectorDataListCount();

        List<? extends OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder> getOneoffGatherPointDetectorDataListOrBuilderList();

        OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder getOneoffGatherPointDetectorDataListOrBuilder(int i);

        List<WidgetSlotDataOuterClass.WidgetSlotData> getSlotListList();

        WidgetSlotDataOuterClass.WidgetSlotData getSlotList(int i);

        int getSlotListCount();

        List<? extends WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder> getSlotListOrBuilderList();

        WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder getSlotListOrBuilder(int i);

        List<Integer> getBackgroundActiveWidgetListList();

        int getBackgroundActiveWidgetListCount();

        int getBackgroundActiveWidgetList(int i);

        List<WidgetCoolDownDataOuterClass.WidgetCoolDownData> getCoolDownGroupDataListList();

        WidgetCoolDownDataOuterClass.WidgetCoolDownData getCoolDownGroupDataList(int i);

        int getCoolDownGroupDataListCount();

        List<? extends WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder> getCoolDownGroupDataListOrBuilderList();

        WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder getCoolDownGroupDataListOrBuilder(int i);

        boolean hasSkyCrystalDetectorData();

        SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData getSkyCrystalDetectorData();

        SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorDataOrBuilder getSkyCrystalDetectorDataOrBuilder();

        List<ClientCollectorDataOuterClass.ClientCollectorData> getClientCollectorDataListList();

        ClientCollectorDataOuterClass.ClientCollectorData getClientCollectorDataList(int i);

        int getClientCollectorDataListCount();

        List<? extends ClientCollectorDataOuterClass.ClientCollectorDataOrBuilder> getClientCollectorDataListOrBuilderList();

        ClientCollectorDataOuterClass.ClientCollectorDataOrBuilder getClientCollectorDataListOrBuilder(int i);

        boolean hasWeatherWizardData();

        WeatherWizardDataOuterClass.WeatherWizardData getWeatherWizardData();

        WeatherWizardDataOuterClass.WeatherWizardDataOrBuilder getWeatherWizardDataOrBuilder();

        List<WidgetCoolDownDataOuterClass.WidgetCoolDownData> getNormalCoolDownDataListList();

        WidgetCoolDownDataOuterClass.WidgetCoolDownData getNormalCoolDownDataList(int i);

        int getNormalCoolDownDataListCount();

        List<? extends WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder> getNormalCoolDownDataListOrBuilderList();

        WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder getNormalCoolDownDataListOrBuilder(int i);

        List<AnchorPointDataOuterClass.AnchorPointData> getAnchorPointListList();

        AnchorPointDataOuterClass.AnchorPointData getAnchorPointList(int i);

        int getAnchorPointListCount();

        List<? extends AnchorPointDataOuterClass.AnchorPointDataOrBuilder> getAnchorPointListOrBuilderList();

        AnchorPointDataOuterClass.AnchorPointDataOrBuilder getAnchorPointListOrBuilder(int i);
    }

    private AllWidgetDataNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AllWidgetDataNotifyOuterClass$AllWidgetDataNotify.class */
    public static final class AllWidgetDataNotify extends GeneratedMessageV3 implements AllWidgetDataNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int NEXT_ANCHOR_POINT_USABLE_TIME_FIELD_NUMBER = 5;
        private int nextAnchorPointUsableTime_;
        public static final int LUNCH_BOX_DATA_FIELD_NUMBER = 1;
        private LunchBoxDataOuterClass.LunchBoxData lunchBoxData_;
        public static final int ONEOFF_GATHER_POINT_DETECTOR_DATA_LIST_FIELD_NUMBER = 14;
        private List<OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData> oneoffGatherPointDetectorDataList_;
        public static final int SLOT_LIST_FIELD_NUMBER = 6;
        private List<WidgetSlotDataOuterClass.WidgetSlotData> slotList_;
        public static final int BACKGROUND_ACTIVE_WIDGET_LIST_FIELD_NUMBER = 9;
        private Internal.IntList backgroundActiveWidgetList_;
        private int backgroundActiveWidgetListMemoizedSerializedSize;
        public static final int COOL_DOWN_GROUP_DATA_LIST_FIELD_NUMBER = 3;
        private List<WidgetCoolDownDataOuterClass.WidgetCoolDownData> coolDownGroupDataList_;
        public static final int SKY_CRYSTAL_DETECTOR_DATA_FIELD_NUMBER = 4;
        private SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData skyCrystalDetectorData_;
        public static final int CLIENT_COLLECTOR_DATA_LIST_FIELD_NUMBER = 7;
        private List<ClientCollectorDataOuterClass.ClientCollectorData> clientCollectorDataList_;
        public static final int WEATHER_WIZARD_DATA_FIELD_NUMBER = 15;
        private WeatherWizardDataOuterClass.WeatherWizardData weatherWizardData_;
        public static final int NORMAL_COOL_DOWN_DATA_LIST_FIELD_NUMBER = 10;
        private List<WidgetCoolDownDataOuterClass.WidgetCoolDownData> normalCoolDownDataList_;
        public static final int ANCHOR_POINT_LIST_FIELD_NUMBER = 13;
        private List<AnchorPointDataOuterClass.AnchorPointData> anchorPointList_;
        private byte memoizedIsInitialized;
        private static final AllWidgetDataNotify DEFAULT_INSTANCE = new AllWidgetDataNotify();
        private static final Parser<AllWidgetDataNotify> PARSER = new AbstractParser<AllWidgetDataNotify>() { // from class: emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotify.1
            @Override // com.google.protobuf.Parser
            public AllWidgetDataNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AllWidgetDataNotify(input, extensionRegistry);
            }
        };

        private AllWidgetDataNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.backgroundActiveWidgetListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private AllWidgetDataNotify() {
            this.backgroundActiveWidgetListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.oneoffGatherPointDetectorDataList_ = Collections.emptyList();
            this.slotList_ = Collections.emptyList();
            this.backgroundActiveWidgetList_ = emptyIntList();
            this.coolDownGroupDataList_ = Collections.emptyList();
            this.clientCollectorDataList_ = Collections.emptyList();
            this.normalCoolDownDataList_ = Collections.emptyList();
            this.anchorPointList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AllWidgetDataNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:149:0x02ed */
        private AllWidgetDataNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 10:
                                    LunchBoxDataOuterClass.LunchBoxData.Builder subBuilder = this.lunchBoxData_ != null ? this.lunchBoxData_.toBuilder() : null;
                                    this.lunchBoxData_ = (LunchBoxDataOuterClass.LunchBoxData) input.readMessage(LunchBoxDataOuterClass.LunchBoxData.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.lunchBoxData_);
                                        this.lunchBoxData_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 26:
                                    if ((mutable_bitField0_ & 8) == 0) {
                                        this.coolDownGroupDataList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                    }
                                    this.coolDownGroupDataList_.add((WidgetCoolDownDataOuterClass.WidgetCoolDownData) input.readMessage(WidgetCoolDownDataOuterClass.WidgetCoolDownData.parser(), extensionRegistry));
                                    break;
                                case 34:
                                    SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData.Builder subBuilder2 = this.skyCrystalDetectorData_ != null ? this.skyCrystalDetectorData_.toBuilder() : null;
                                    this.skyCrystalDetectorData_ = (SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData) input.readMessage(SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData.parser(), extensionRegistry);
                                    if (subBuilder2 == null) {
                                        break;
                                    } else {
                                        subBuilder2.mergeFrom(this.skyCrystalDetectorData_);
                                        this.skyCrystalDetectorData_ = subBuilder2.buildPartial();
                                        break;
                                    }
                                case 40:
                                    this.nextAnchorPointUsableTime_ = input.readUInt32();
                                    break;
                                case 50:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.slotList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.slotList_.add((WidgetSlotDataOuterClass.WidgetSlotData) input.readMessage(WidgetSlotDataOuterClass.WidgetSlotData.parser(), extensionRegistry));
                                    break;
                                case 58:
                                    if ((mutable_bitField0_ & 16) == 0) {
                                        this.clientCollectorDataList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                    }
                                    this.clientCollectorDataList_.add((ClientCollectorDataOuterClass.ClientCollectorData) input.readMessage(ClientCollectorDataOuterClass.ClientCollectorData.parser(), extensionRegistry));
                                    break;
                                case 72:
                                    if ((mutable_bitField0_ & 4) == 0) {
                                        this.backgroundActiveWidgetList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                    }
                                    this.backgroundActiveWidgetList_.addInt(input.readUInt32());
                                    break;
                                case 74:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.backgroundActiveWidgetList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.backgroundActiveWidgetList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 82:
                                    if ((mutable_bitField0_ & 32) == 0) {
                                        this.normalCoolDownDataList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 32) == 1 ? 1 : 0;
                                    }
                                    this.normalCoolDownDataList_.add((WidgetCoolDownDataOuterClass.WidgetCoolDownData) input.readMessage(WidgetCoolDownDataOuterClass.WidgetCoolDownData.parser(), extensionRegistry));
                                    break;
                                case 106:
                                    if ((mutable_bitField0_ & 64) == 0) {
                                        this.anchorPointList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 64) == 1 ? 1 : 0;
                                    }
                                    this.anchorPointList_.add((AnchorPointDataOuterClass.AnchorPointData) input.readMessage(AnchorPointDataOuterClass.AnchorPointData.parser(), extensionRegistry));
                                    break;
                                case 114:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.oneoffGatherPointDetectorDataList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.oneoffGatherPointDetectorDataList_.add((OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData) input.readMessage(OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.parser(), extensionRegistry));
                                    break;
                                case 122:
                                    WeatherWizardDataOuterClass.WeatherWizardData.Builder subBuilder3 = this.weatherWizardData_ != null ? this.weatherWizardData_.toBuilder() : null;
                                    this.weatherWizardData_ = (WeatherWizardDataOuterClass.WeatherWizardData) input.readMessage(WeatherWizardDataOuterClass.WeatherWizardData.parser(), extensionRegistry);
                                    if (subBuilder3 == null) {
                                        break;
                                    } else {
                                        subBuilder3.mergeFrom(this.weatherWizardData_);
                                        this.weatherWizardData_ = subBuilder3.buildPartial();
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
                            done = done;
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 8) != 0) {
                    this.coolDownGroupDataList_ = Collections.unmodifiableList(this.coolDownGroupDataList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.slotList_ = Collections.unmodifiableList(this.slotList_);
                }
                if ((mutable_bitField0_ & 16) != 0) {
                    this.clientCollectorDataList_ = Collections.unmodifiableList(this.clientCollectorDataList_);
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.backgroundActiveWidgetList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 32) != 0) {
                    this.normalCoolDownDataList_ = Collections.unmodifiableList(this.normalCoolDownDataList_);
                }
                if ((mutable_bitField0_ & 64) != 0) {
                    this.anchorPointList_ = Collections.unmodifiableList(this.anchorPointList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.oneoffGatherPointDetectorDataList_ = Collections.unmodifiableList(this.oneoffGatherPointDetectorDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AllWidgetDataNotifyOuterClass.internal_static_AllWidgetDataNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AllWidgetDataNotifyOuterClass.internal_static_AllWidgetDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AllWidgetDataNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public int getNextAnchorPointUsableTime() {
            return this.nextAnchorPointUsableTime_;
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public boolean hasLunchBoxData() {
            return this.lunchBoxData_ != null;
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public LunchBoxDataOuterClass.LunchBoxData getLunchBoxData() {
            return this.lunchBoxData_ == null ? LunchBoxDataOuterClass.LunchBoxData.getDefaultInstance() : this.lunchBoxData_;
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public LunchBoxDataOuterClass.LunchBoxDataOrBuilder getLunchBoxDataOrBuilder() {
            return getLunchBoxData();
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public List<OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData> getOneoffGatherPointDetectorDataListList() {
            return this.oneoffGatherPointDetectorDataList_;
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public List<? extends OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder> getOneoffGatherPointDetectorDataListOrBuilderList() {
            return this.oneoffGatherPointDetectorDataList_;
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public int getOneoffGatherPointDetectorDataListCount() {
            return this.oneoffGatherPointDetectorDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData getOneoffGatherPointDetectorDataList(int index) {
            return this.oneoffGatherPointDetectorDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder getOneoffGatherPointDetectorDataListOrBuilder(int index) {
            return this.oneoffGatherPointDetectorDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public List<WidgetSlotDataOuterClass.WidgetSlotData> getSlotListList() {
            return this.slotList_;
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public List<? extends WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder> getSlotListOrBuilderList() {
            return this.slotList_;
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public int getSlotListCount() {
            return this.slotList_.size();
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public WidgetSlotDataOuterClass.WidgetSlotData getSlotList(int index) {
            return this.slotList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder getSlotListOrBuilder(int index) {
            return this.slotList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public List<Integer> getBackgroundActiveWidgetListList() {
            return this.backgroundActiveWidgetList_;
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public int getBackgroundActiveWidgetListCount() {
            return this.backgroundActiveWidgetList_.size();
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public int getBackgroundActiveWidgetList(int index) {
            return this.backgroundActiveWidgetList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public List<WidgetCoolDownDataOuterClass.WidgetCoolDownData> getCoolDownGroupDataListList() {
            return this.coolDownGroupDataList_;
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public List<? extends WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder> getCoolDownGroupDataListOrBuilderList() {
            return this.coolDownGroupDataList_;
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public int getCoolDownGroupDataListCount() {
            return this.coolDownGroupDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public WidgetCoolDownDataOuterClass.WidgetCoolDownData getCoolDownGroupDataList(int index) {
            return this.coolDownGroupDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder getCoolDownGroupDataListOrBuilder(int index) {
            return this.coolDownGroupDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public boolean hasSkyCrystalDetectorData() {
            return this.skyCrystalDetectorData_ != null;
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData getSkyCrystalDetectorData() {
            return this.skyCrystalDetectorData_ == null ? SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData.getDefaultInstance() : this.skyCrystalDetectorData_;
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorDataOrBuilder getSkyCrystalDetectorDataOrBuilder() {
            return getSkyCrystalDetectorData();
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public List<ClientCollectorDataOuterClass.ClientCollectorData> getClientCollectorDataListList() {
            return this.clientCollectorDataList_;
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public List<? extends ClientCollectorDataOuterClass.ClientCollectorDataOrBuilder> getClientCollectorDataListOrBuilderList() {
            return this.clientCollectorDataList_;
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public int getClientCollectorDataListCount() {
            return this.clientCollectorDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public ClientCollectorDataOuterClass.ClientCollectorData getClientCollectorDataList(int index) {
            return this.clientCollectorDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public ClientCollectorDataOuterClass.ClientCollectorDataOrBuilder getClientCollectorDataListOrBuilder(int index) {
            return this.clientCollectorDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public boolean hasWeatherWizardData() {
            return this.weatherWizardData_ != null;
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public WeatherWizardDataOuterClass.WeatherWizardData getWeatherWizardData() {
            return this.weatherWizardData_ == null ? WeatherWizardDataOuterClass.WeatherWizardData.getDefaultInstance() : this.weatherWizardData_;
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public WeatherWizardDataOuterClass.WeatherWizardDataOrBuilder getWeatherWizardDataOrBuilder() {
            return getWeatherWizardData();
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public List<WidgetCoolDownDataOuterClass.WidgetCoolDownData> getNormalCoolDownDataListList() {
            return this.normalCoolDownDataList_;
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public List<? extends WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder> getNormalCoolDownDataListOrBuilderList() {
            return this.normalCoolDownDataList_;
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public int getNormalCoolDownDataListCount() {
            return this.normalCoolDownDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public WidgetCoolDownDataOuterClass.WidgetCoolDownData getNormalCoolDownDataList(int index) {
            return this.normalCoolDownDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder getNormalCoolDownDataListOrBuilder(int index) {
            return this.normalCoolDownDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public List<AnchorPointDataOuterClass.AnchorPointData> getAnchorPointListList() {
            return this.anchorPointList_;
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public List<? extends AnchorPointDataOuterClass.AnchorPointDataOrBuilder> getAnchorPointListOrBuilderList() {
            return this.anchorPointList_;
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public int getAnchorPointListCount() {
            return this.anchorPointList_.size();
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public AnchorPointDataOuterClass.AnchorPointData getAnchorPointList(int index) {
            return this.anchorPointList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
        public AnchorPointDataOuterClass.AnchorPointDataOrBuilder getAnchorPointListOrBuilder(int index) {
            return this.anchorPointList_.get(index);
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
            getSerializedSize();
            if (this.lunchBoxData_ != null) {
                output.writeMessage(1, getLunchBoxData());
            }
            for (int i = 0; i < this.coolDownGroupDataList_.size(); i++) {
                output.writeMessage(3, this.coolDownGroupDataList_.get(i));
            }
            if (this.skyCrystalDetectorData_ != null) {
                output.writeMessage(4, getSkyCrystalDetectorData());
            }
            if (this.nextAnchorPointUsableTime_ != 0) {
                output.writeUInt32(5, this.nextAnchorPointUsableTime_);
            }
            for (int i2 = 0; i2 < this.slotList_.size(); i2++) {
                output.writeMessage(6, this.slotList_.get(i2));
            }
            for (int i3 = 0; i3 < this.clientCollectorDataList_.size(); i3++) {
                output.writeMessage(7, this.clientCollectorDataList_.get(i3));
            }
            if (getBackgroundActiveWidgetListList().size() > 0) {
                output.writeUInt32NoTag(74);
                output.writeUInt32NoTag(this.backgroundActiveWidgetListMemoizedSerializedSize);
            }
            for (int i4 = 0; i4 < this.backgroundActiveWidgetList_.size(); i4++) {
                output.writeUInt32NoTag(this.backgroundActiveWidgetList_.getInt(i4));
            }
            for (int i5 = 0; i5 < this.normalCoolDownDataList_.size(); i5++) {
                output.writeMessage(10, this.normalCoolDownDataList_.get(i5));
            }
            for (int i6 = 0; i6 < this.anchorPointList_.size(); i6++) {
                output.writeMessage(13, this.anchorPointList_.get(i6));
            }
            for (int i7 = 0; i7 < this.oneoffGatherPointDetectorDataList_.size(); i7++) {
                output.writeMessage(14, this.oneoffGatherPointDetectorDataList_.get(i7));
            }
            if (this.weatherWizardData_ != null) {
                output.writeMessage(15, getWeatherWizardData());
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
            if (this.lunchBoxData_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(1, getLunchBoxData());
            }
            for (int i = 0; i < this.coolDownGroupDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.coolDownGroupDataList_.get(i));
            }
            if (this.skyCrystalDetectorData_ != null) {
                size2 += CodedOutputStream.computeMessageSize(4, getSkyCrystalDetectorData());
            }
            if (this.nextAnchorPointUsableTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.nextAnchorPointUsableTime_);
            }
            for (int i2 = 0; i2 < this.slotList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(6, this.slotList_.get(i2));
            }
            for (int i3 = 0; i3 < this.clientCollectorDataList_.size(); i3++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.clientCollectorDataList_.get(i3));
            }
            int dataSize = 0;
            for (int i4 = 0; i4 < this.backgroundActiveWidgetList_.size(); i4++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.backgroundActiveWidgetList_.getInt(i4));
            }
            int size3 = size2 + dataSize;
            if (!getBackgroundActiveWidgetListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.backgroundActiveWidgetListMemoizedSerializedSize = dataSize;
            for (int i5 = 0; i5 < this.normalCoolDownDataList_.size(); i5++) {
                size3 += CodedOutputStream.computeMessageSize(10, this.normalCoolDownDataList_.get(i5));
            }
            for (int i6 = 0; i6 < this.anchorPointList_.size(); i6++) {
                size3 += CodedOutputStream.computeMessageSize(13, this.anchorPointList_.get(i6));
            }
            for (int i7 = 0; i7 < this.oneoffGatherPointDetectorDataList_.size(); i7++) {
                size3 += CodedOutputStream.computeMessageSize(14, this.oneoffGatherPointDetectorDataList_.get(i7));
            }
            if (this.weatherWizardData_ != null) {
                size3 += CodedOutputStream.computeMessageSize(15, getWeatherWizardData());
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
            if (!(obj instanceof AllWidgetDataNotify)) {
                return equals(obj);
            }
            AllWidgetDataNotify other = (AllWidgetDataNotify) obj;
            if (getNextAnchorPointUsableTime() != other.getNextAnchorPointUsableTime() || hasLunchBoxData() != other.hasLunchBoxData()) {
                return false;
            }
            if ((hasLunchBoxData() && !getLunchBoxData().equals(other.getLunchBoxData())) || !getOneoffGatherPointDetectorDataListList().equals(other.getOneoffGatherPointDetectorDataListList()) || !getSlotListList().equals(other.getSlotListList()) || !getBackgroundActiveWidgetListList().equals(other.getBackgroundActiveWidgetListList()) || !getCoolDownGroupDataListList().equals(other.getCoolDownGroupDataListList()) || hasSkyCrystalDetectorData() != other.hasSkyCrystalDetectorData()) {
                return false;
            }
            if ((!hasSkyCrystalDetectorData() || getSkyCrystalDetectorData().equals(other.getSkyCrystalDetectorData())) && getClientCollectorDataListList().equals(other.getClientCollectorDataListList()) && hasWeatherWizardData() == other.hasWeatherWizardData()) {
                return (!hasWeatherWizardData() || getWeatherWizardData().equals(other.getWeatherWizardData())) && getNormalCoolDownDataListList().equals(other.getNormalCoolDownDataListList()) && getAnchorPointListList().equals(other.getAnchorPointListList()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getNextAnchorPointUsableTime();
            if (hasLunchBoxData()) {
                hash = (53 * ((37 * hash) + 1)) + getLunchBoxData().hashCode();
            }
            if (getOneoffGatherPointDetectorDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getOneoffGatherPointDetectorDataListList().hashCode();
            }
            if (getSlotListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getSlotListList().hashCode();
            }
            if (getBackgroundActiveWidgetListCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getBackgroundActiveWidgetListList().hashCode();
            }
            if (getCoolDownGroupDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getCoolDownGroupDataListList().hashCode();
            }
            if (hasSkyCrystalDetectorData()) {
                hash = (53 * ((37 * hash) + 4)) + getSkyCrystalDetectorData().hashCode();
            }
            if (getClientCollectorDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getClientCollectorDataListList().hashCode();
            }
            if (hasWeatherWizardData()) {
                hash = (53 * ((37 * hash) + 15)) + getWeatherWizardData().hashCode();
            }
            if (getNormalCoolDownDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getNormalCoolDownDataListList().hashCode();
            }
            if (getAnchorPointListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getAnchorPointListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AllWidgetDataNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AllWidgetDataNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AllWidgetDataNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AllWidgetDataNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AllWidgetDataNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AllWidgetDataNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AllWidgetDataNotify parseFrom(InputStream input) throws IOException {
            return (AllWidgetDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AllWidgetDataNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AllWidgetDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AllWidgetDataNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (AllWidgetDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AllWidgetDataNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AllWidgetDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AllWidgetDataNotify parseFrom(CodedInputStream input) throws IOException {
            return (AllWidgetDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AllWidgetDataNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AllWidgetDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AllWidgetDataNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AllWidgetDataNotifyOuterClass$AllWidgetDataNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AllWidgetDataNotifyOrBuilder {
            private int bitField0_;
            private int nextAnchorPointUsableTime_;
            private LunchBoxDataOuterClass.LunchBoxData lunchBoxData_;
            private SingleFieldBuilderV3<LunchBoxDataOuterClass.LunchBoxData, LunchBoxDataOuterClass.LunchBoxData.Builder, LunchBoxDataOuterClass.LunchBoxDataOrBuilder> lunchBoxDataBuilder_;
            private RepeatedFieldBuilderV3<OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData, OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.Builder, OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder> oneoffGatherPointDetectorDataListBuilder_;
            private RepeatedFieldBuilderV3<WidgetSlotDataOuterClass.WidgetSlotData, WidgetSlotDataOuterClass.WidgetSlotData.Builder, WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder> slotListBuilder_;
            private RepeatedFieldBuilderV3<WidgetCoolDownDataOuterClass.WidgetCoolDownData, WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder, WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder> coolDownGroupDataListBuilder_;
            private SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData skyCrystalDetectorData_;
            private SingleFieldBuilderV3<SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData, SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData.Builder, SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorDataOrBuilder> skyCrystalDetectorDataBuilder_;
            private RepeatedFieldBuilderV3<ClientCollectorDataOuterClass.ClientCollectorData, ClientCollectorDataOuterClass.ClientCollectorData.Builder, ClientCollectorDataOuterClass.ClientCollectorDataOrBuilder> clientCollectorDataListBuilder_;
            private WeatherWizardDataOuterClass.WeatherWizardData weatherWizardData_;
            private SingleFieldBuilderV3<WeatherWizardDataOuterClass.WeatherWizardData, WeatherWizardDataOuterClass.WeatherWizardData.Builder, WeatherWizardDataOuterClass.WeatherWizardDataOrBuilder> weatherWizardDataBuilder_;
            private RepeatedFieldBuilderV3<WidgetCoolDownDataOuterClass.WidgetCoolDownData, WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder, WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder> normalCoolDownDataListBuilder_;
            private RepeatedFieldBuilderV3<AnchorPointDataOuterClass.AnchorPointData, AnchorPointDataOuterClass.AnchorPointData.Builder, AnchorPointDataOuterClass.AnchorPointDataOrBuilder> anchorPointListBuilder_;
            private List<OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData> oneoffGatherPointDetectorDataList_ = Collections.emptyList();
            private List<WidgetSlotDataOuterClass.WidgetSlotData> slotList_ = Collections.emptyList();
            private Internal.IntList backgroundActiveWidgetList_ = AllWidgetDataNotify.emptyIntList();
            private List<WidgetCoolDownDataOuterClass.WidgetCoolDownData> coolDownGroupDataList_ = Collections.emptyList();
            private List<ClientCollectorDataOuterClass.ClientCollectorData> clientCollectorDataList_ = Collections.emptyList();
            private List<WidgetCoolDownDataOuterClass.WidgetCoolDownData> normalCoolDownDataList_ = Collections.emptyList();
            private List<AnchorPointDataOuterClass.AnchorPointData> anchorPointList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return AllWidgetDataNotifyOuterClass.internal_static_AllWidgetDataNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AllWidgetDataNotifyOuterClass.internal_static_AllWidgetDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AllWidgetDataNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AllWidgetDataNotify.alwaysUseFieldBuilders) {
                    getOneoffGatherPointDetectorDataListFieldBuilder();
                    getSlotListFieldBuilder();
                    getCoolDownGroupDataListFieldBuilder();
                    getClientCollectorDataListFieldBuilder();
                    getNormalCoolDownDataListFieldBuilder();
                    getAnchorPointListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.nextAnchorPointUsableTime_ = 0;
                if (this.lunchBoxDataBuilder_ == null) {
                    this.lunchBoxData_ = null;
                } else {
                    this.lunchBoxData_ = null;
                    this.lunchBoxDataBuilder_ = null;
                }
                if (this.oneoffGatherPointDetectorDataListBuilder_ == null) {
                    this.oneoffGatherPointDetectorDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.oneoffGatherPointDetectorDataListBuilder_.clear();
                }
                if (this.slotListBuilder_ == null) {
                    this.slotList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.slotListBuilder_.clear();
                }
                this.backgroundActiveWidgetList_ = AllWidgetDataNotify.emptyIntList();
                this.bitField0_ &= -5;
                if (this.coolDownGroupDataListBuilder_ == null) {
                    this.coolDownGroupDataList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.coolDownGroupDataListBuilder_.clear();
                }
                if (this.skyCrystalDetectorDataBuilder_ == null) {
                    this.skyCrystalDetectorData_ = null;
                } else {
                    this.skyCrystalDetectorData_ = null;
                    this.skyCrystalDetectorDataBuilder_ = null;
                }
                if (this.clientCollectorDataListBuilder_ == null) {
                    this.clientCollectorDataList_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                } else {
                    this.clientCollectorDataListBuilder_.clear();
                }
                if (this.weatherWizardDataBuilder_ == null) {
                    this.weatherWizardData_ = null;
                } else {
                    this.weatherWizardData_ = null;
                    this.weatherWizardDataBuilder_ = null;
                }
                if (this.normalCoolDownDataListBuilder_ == null) {
                    this.normalCoolDownDataList_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                } else {
                    this.normalCoolDownDataListBuilder_.clear();
                }
                if (this.anchorPointListBuilder_ == null) {
                    this.anchorPointList_ = Collections.emptyList();
                    this.bitField0_ &= -65;
                } else {
                    this.anchorPointListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AllWidgetDataNotifyOuterClass.internal_static_AllWidgetDataNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AllWidgetDataNotify getDefaultInstanceForType() {
                return AllWidgetDataNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AllWidgetDataNotify build() {
                AllWidgetDataNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AllWidgetDataNotify buildPartial() {
                AllWidgetDataNotify result = new AllWidgetDataNotify(this);
                int i = this.bitField0_;
                result.nextAnchorPointUsableTime_ = this.nextAnchorPointUsableTime_;
                if (this.lunchBoxDataBuilder_ == null) {
                    result.lunchBoxData_ = this.lunchBoxData_;
                } else {
                    result.lunchBoxData_ = this.lunchBoxDataBuilder_.build();
                }
                if (this.oneoffGatherPointDetectorDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.oneoffGatherPointDetectorDataList_ = Collections.unmodifiableList(this.oneoffGatherPointDetectorDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.oneoffGatherPointDetectorDataList_ = this.oneoffGatherPointDetectorDataList_;
                } else {
                    result.oneoffGatherPointDetectorDataList_ = this.oneoffGatherPointDetectorDataListBuilder_.build();
                }
                if (this.slotListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.slotList_ = Collections.unmodifiableList(this.slotList_);
                        this.bitField0_ &= -3;
                    }
                    result.slotList_ = this.slotList_;
                } else {
                    result.slotList_ = this.slotListBuilder_.build();
                }
                if ((this.bitField0_ & 4) != 0) {
                    this.backgroundActiveWidgetList_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.backgroundActiveWidgetList_ = this.backgroundActiveWidgetList_;
                if (this.coolDownGroupDataListBuilder_ == null) {
                    if ((this.bitField0_ & 8) != 0) {
                        this.coolDownGroupDataList_ = Collections.unmodifiableList(this.coolDownGroupDataList_);
                        this.bitField0_ &= -9;
                    }
                    result.coolDownGroupDataList_ = this.coolDownGroupDataList_;
                } else {
                    result.coolDownGroupDataList_ = this.coolDownGroupDataListBuilder_.build();
                }
                if (this.skyCrystalDetectorDataBuilder_ == null) {
                    result.skyCrystalDetectorData_ = this.skyCrystalDetectorData_;
                } else {
                    result.skyCrystalDetectorData_ = this.skyCrystalDetectorDataBuilder_.build();
                }
                if (this.clientCollectorDataListBuilder_ == null) {
                    if ((this.bitField0_ & 16) != 0) {
                        this.clientCollectorDataList_ = Collections.unmodifiableList(this.clientCollectorDataList_);
                        this.bitField0_ &= -17;
                    }
                    result.clientCollectorDataList_ = this.clientCollectorDataList_;
                } else {
                    result.clientCollectorDataList_ = this.clientCollectorDataListBuilder_.build();
                }
                if (this.weatherWizardDataBuilder_ == null) {
                    result.weatherWizardData_ = this.weatherWizardData_;
                } else {
                    result.weatherWizardData_ = this.weatherWizardDataBuilder_.build();
                }
                if (this.normalCoolDownDataListBuilder_ == null) {
                    if ((this.bitField0_ & 32) != 0) {
                        this.normalCoolDownDataList_ = Collections.unmodifiableList(this.normalCoolDownDataList_);
                        this.bitField0_ &= -33;
                    }
                    result.normalCoolDownDataList_ = this.normalCoolDownDataList_;
                } else {
                    result.normalCoolDownDataList_ = this.normalCoolDownDataListBuilder_.build();
                }
                if (this.anchorPointListBuilder_ == null) {
                    if ((this.bitField0_ & 64) != 0) {
                        this.anchorPointList_ = Collections.unmodifiableList(this.anchorPointList_);
                        this.bitField0_ &= -65;
                    }
                    result.anchorPointList_ = this.anchorPointList_;
                } else {
                    result.anchorPointList_ = this.anchorPointListBuilder_.build();
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
                if (other instanceof AllWidgetDataNotify) {
                    return mergeFrom((AllWidgetDataNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AllWidgetDataNotify other) {
                if (other == AllWidgetDataNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getNextAnchorPointUsableTime() != 0) {
                    setNextAnchorPointUsableTime(other.getNextAnchorPointUsableTime());
                }
                if (other.hasLunchBoxData()) {
                    mergeLunchBoxData(other.getLunchBoxData());
                }
                if (this.oneoffGatherPointDetectorDataListBuilder_ == null) {
                    if (!other.oneoffGatherPointDetectorDataList_.isEmpty()) {
                        if (this.oneoffGatherPointDetectorDataList_.isEmpty()) {
                            this.oneoffGatherPointDetectorDataList_ = other.oneoffGatherPointDetectorDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureOneoffGatherPointDetectorDataListIsMutable();
                            this.oneoffGatherPointDetectorDataList_.addAll(other.oneoffGatherPointDetectorDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.oneoffGatherPointDetectorDataList_.isEmpty()) {
                    if (this.oneoffGatherPointDetectorDataListBuilder_.isEmpty()) {
                        this.oneoffGatherPointDetectorDataListBuilder_.dispose();
                        this.oneoffGatherPointDetectorDataListBuilder_ = null;
                        this.oneoffGatherPointDetectorDataList_ = other.oneoffGatherPointDetectorDataList_;
                        this.bitField0_ &= -2;
                        this.oneoffGatherPointDetectorDataListBuilder_ = AllWidgetDataNotify.alwaysUseFieldBuilders ? getOneoffGatherPointDetectorDataListFieldBuilder() : null;
                    } else {
                        this.oneoffGatherPointDetectorDataListBuilder_.addAllMessages(other.oneoffGatherPointDetectorDataList_);
                    }
                }
                if (this.slotListBuilder_ == null) {
                    if (!other.slotList_.isEmpty()) {
                        if (this.slotList_.isEmpty()) {
                            this.slotList_ = other.slotList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureSlotListIsMutable();
                            this.slotList_.addAll(other.slotList_);
                        }
                        onChanged();
                    }
                } else if (!other.slotList_.isEmpty()) {
                    if (this.slotListBuilder_.isEmpty()) {
                        this.slotListBuilder_.dispose();
                        this.slotListBuilder_ = null;
                        this.slotList_ = other.slotList_;
                        this.bitField0_ &= -3;
                        this.slotListBuilder_ = AllWidgetDataNotify.alwaysUseFieldBuilders ? getSlotListFieldBuilder() : null;
                    } else {
                        this.slotListBuilder_.addAllMessages(other.slotList_);
                    }
                }
                if (!other.backgroundActiveWidgetList_.isEmpty()) {
                    if (this.backgroundActiveWidgetList_.isEmpty()) {
                        this.backgroundActiveWidgetList_ = other.backgroundActiveWidgetList_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureBackgroundActiveWidgetListIsMutable();
                        this.backgroundActiveWidgetList_.addAll(other.backgroundActiveWidgetList_);
                    }
                    onChanged();
                }
                if (this.coolDownGroupDataListBuilder_ == null) {
                    if (!other.coolDownGroupDataList_.isEmpty()) {
                        if (this.coolDownGroupDataList_.isEmpty()) {
                            this.coolDownGroupDataList_ = other.coolDownGroupDataList_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureCoolDownGroupDataListIsMutable();
                            this.coolDownGroupDataList_.addAll(other.coolDownGroupDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.coolDownGroupDataList_.isEmpty()) {
                    if (this.coolDownGroupDataListBuilder_.isEmpty()) {
                        this.coolDownGroupDataListBuilder_.dispose();
                        this.coolDownGroupDataListBuilder_ = null;
                        this.coolDownGroupDataList_ = other.coolDownGroupDataList_;
                        this.bitField0_ &= -9;
                        this.coolDownGroupDataListBuilder_ = AllWidgetDataNotify.alwaysUseFieldBuilders ? getCoolDownGroupDataListFieldBuilder() : null;
                    } else {
                        this.coolDownGroupDataListBuilder_.addAllMessages(other.coolDownGroupDataList_);
                    }
                }
                if (other.hasSkyCrystalDetectorData()) {
                    mergeSkyCrystalDetectorData(other.getSkyCrystalDetectorData());
                }
                if (this.clientCollectorDataListBuilder_ == null) {
                    if (!other.clientCollectorDataList_.isEmpty()) {
                        if (this.clientCollectorDataList_.isEmpty()) {
                            this.clientCollectorDataList_ = other.clientCollectorDataList_;
                            this.bitField0_ &= -17;
                        } else {
                            ensureClientCollectorDataListIsMutable();
                            this.clientCollectorDataList_.addAll(other.clientCollectorDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.clientCollectorDataList_.isEmpty()) {
                    if (this.clientCollectorDataListBuilder_.isEmpty()) {
                        this.clientCollectorDataListBuilder_.dispose();
                        this.clientCollectorDataListBuilder_ = null;
                        this.clientCollectorDataList_ = other.clientCollectorDataList_;
                        this.bitField0_ &= -17;
                        this.clientCollectorDataListBuilder_ = AllWidgetDataNotify.alwaysUseFieldBuilders ? getClientCollectorDataListFieldBuilder() : null;
                    } else {
                        this.clientCollectorDataListBuilder_.addAllMessages(other.clientCollectorDataList_);
                    }
                }
                if (other.hasWeatherWizardData()) {
                    mergeWeatherWizardData(other.getWeatherWizardData());
                }
                if (this.normalCoolDownDataListBuilder_ == null) {
                    if (!other.normalCoolDownDataList_.isEmpty()) {
                        if (this.normalCoolDownDataList_.isEmpty()) {
                            this.normalCoolDownDataList_ = other.normalCoolDownDataList_;
                            this.bitField0_ &= -33;
                        } else {
                            ensureNormalCoolDownDataListIsMutable();
                            this.normalCoolDownDataList_.addAll(other.normalCoolDownDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.normalCoolDownDataList_.isEmpty()) {
                    if (this.normalCoolDownDataListBuilder_.isEmpty()) {
                        this.normalCoolDownDataListBuilder_.dispose();
                        this.normalCoolDownDataListBuilder_ = null;
                        this.normalCoolDownDataList_ = other.normalCoolDownDataList_;
                        this.bitField0_ &= -33;
                        this.normalCoolDownDataListBuilder_ = AllWidgetDataNotify.alwaysUseFieldBuilders ? getNormalCoolDownDataListFieldBuilder() : null;
                    } else {
                        this.normalCoolDownDataListBuilder_.addAllMessages(other.normalCoolDownDataList_);
                    }
                }
                if (this.anchorPointListBuilder_ == null) {
                    if (!other.anchorPointList_.isEmpty()) {
                        if (this.anchorPointList_.isEmpty()) {
                            this.anchorPointList_ = other.anchorPointList_;
                            this.bitField0_ &= -65;
                        } else {
                            ensureAnchorPointListIsMutable();
                            this.anchorPointList_.addAll(other.anchorPointList_);
                        }
                        onChanged();
                    }
                } else if (!other.anchorPointList_.isEmpty()) {
                    if (this.anchorPointListBuilder_.isEmpty()) {
                        this.anchorPointListBuilder_.dispose();
                        this.anchorPointListBuilder_ = null;
                        this.anchorPointList_ = other.anchorPointList_;
                        this.bitField0_ &= -65;
                        this.anchorPointListBuilder_ = AllWidgetDataNotify.alwaysUseFieldBuilders ? getAnchorPointListFieldBuilder() : null;
                    } else {
                        this.anchorPointListBuilder_.addAllMessages(other.anchorPointList_);
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
                AllWidgetDataNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = AllWidgetDataNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AllWidgetDataNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public int getNextAnchorPointUsableTime() {
                return this.nextAnchorPointUsableTime_;
            }

            public Builder setNextAnchorPointUsableTime(int value) {
                this.nextAnchorPointUsableTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearNextAnchorPointUsableTime() {
                this.nextAnchorPointUsableTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public boolean hasLunchBoxData() {
                return (this.lunchBoxDataBuilder_ == null && this.lunchBoxData_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public LunchBoxDataOuterClass.LunchBoxData getLunchBoxData() {
                if (this.lunchBoxDataBuilder_ == null) {
                    return this.lunchBoxData_ == null ? LunchBoxDataOuterClass.LunchBoxData.getDefaultInstance() : this.lunchBoxData_;
                }
                return this.lunchBoxDataBuilder_.getMessage();
            }

            public Builder setLunchBoxData(LunchBoxDataOuterClass.LunchBoxData value) {
                if (this.lunchBoxDataBuilder_ != null) {
                    this.lunchBoxDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.lunchBoxData_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setLunchBoxData(LunchBoxDataOuterClass.LunchBoxData.Builder builderForValue) {
                if (this.lunchBoxDataBuilder_ == null) {
                    this.lunchBoxData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.lunchBoxDataBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeLunchBoxData(LunchBoxDataOuterClass.LunchBoxData value) {
                if (this.lunchBoxDataBuilder_ == null) {
                    if (this.lunchBoxData_ != null) {
                        this.lunchBoxData_ = LunchBoxDataOuterClass.LunchBoxData.newBuilder(this.lunchBoxData_).mergeFrom(value).buildPartial();
                    } else {
                        this.lunchBoxData_ = value;
                    }
                    onChanged();
                } else {
                    this.lunchBoxDataBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearLunchBoxData() {
                if (this.lunchBoxDataBuilder_ == null) {
                    this.lunchBoxData_ = null;
                    onChanged();
                } else {
                    this.lunchBoxData_ = null;
                    this.lunchBoxDataBuilder_ = null;
                }
                return this;
            }

            public LunchBoxDataOuterClass.LunchBoxData.Builder getLunchBoxDataBuilder() {
                onChanged();
                return getLunchBoxDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public LunchBoxDataOuterClass.LunchBoxDataOrBuilder getLunchBoxDataOrBuilder() {
                if (this.lunchBoxDataBuilder_ != null) {
                    return this.lunchBoxDataBuilder_.getMessageOrBuilder();
                }
                return this.lunchBoxData_ == null ? LunchBoxDataOuterClass.LunchBoxData.getDefaultInstance() : this.lunchBoxData_;
            }

            private SingleFieldBuilderV3<LunchBoxDataOuterClass.LunchBoxData, LunchBoxDataOuterClass.LunchBoxData.Builder, LunchBoxDataOuterClass.LunchBoxDataOrBuilder> getLunchBoxDataFieldBuilder() {
                if (this.lunchBoxDataBuilder_ == null) {
                    this.lunchBoxDataBuilder_ = new SingleFieldBuilderV3<>(getLunchBoxData(), getParentForChildren(), isClean());
                    this.lunchBoxData_ = null;
                }
                return this.lunchBoxDataBuilder_;
            }

            private void ensureOneoffGatherPointDetectorDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.oneoffGatherPointDetectorDataList_ = new ArrayList(this.oneoffGatherPointDetectorDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public List<OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData> getOneoffGatherPointDetectorDataListList() {
                if (this.oneoffGatherPointDetectorDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.oneoffGatherPointDetectorDataList_);
                }
                return this.oneoffGatherPointDetectorDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public int getOneoffGatherPointDetectorDataListCount() {
                if (this.oneoffGatherPointDetectorDataListBuilder_ == null) {
                    return this.oneoffGatherPointDetectorDataList_.size();
                }
                return this.oneoffGatherPointDetectorDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData getOneoffGatherPointDetectorDataList(int index) {
                if (this.oneoffGatherPointDetectorDataListBuilder_ == null) {
                    return this.oneoffGatherPointDetectorDataList_.get(index);
                }
                return this.oneoffGatherPointDetectorDataListBuilder_.getMessage(index);
            }

            public Builder setOneoffGatherPointDetectorDataList(int index, OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData value) {
                if (this.oneoffGatherPointDetectorDataListBuilder_ != null) {
                    this.oneoffGatherPointDetectorDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOneoffGatherPointDetectorDataListIsMutable();
                    this.oneoffGatherPointDetectorDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setOneoffGatherPointDetectorDataList(int index, OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.Builder builderForValue) {
                if (this.oneoffGatherPointDetectorDataListBuilder_ == null) {
                    ensureOneoffGatherPointDetectorDataListIsMutable();
                    this.oneoffGatherPointDetectorDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.oneoffGatherPointDetectorDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addOneoffGatherPointDetectorDataList(OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData value) {
                if (this.oneoffGatherPointDetectorDataListBuilder_ != null) {
                    this.oneoffGatherPointDetectorDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOneoffGatherPointDetectorDataListIsMutable();
                    this.oneoffGatherPointDetectorDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addOneoffGatherPointDetectorDataList(int index, OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData value) {
                if (this.oneoffGatherPointDetectorDataListBuilder_ != null) {
                    this.oneoffGatherPointDetectorDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOneoffGatherPointDetectorDataListIsMutable();
                    this.oneoffGatherPointDetectorDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addOneoffGatherPointDetectorDataList(OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.Builder builderForValue) {
                if (this.oneoffGatherPointDetectorDataListBuilder_ == null) {
                    ensureOneoffGatherPointDetectorDataListIsMutable();
                    this.oneoffGatherPointDetectorDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.oneoffGatherPointDetectorDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addOneoffGatherPointDetectorDataList(int index, OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.Builder builderForValue) {
                if (this.oneoffGatherPointDetectorDataListBuilder_ == null) {
                    ensureOneoffGatherPointDetectorDataListIsMutable();
                    this.oneoffGatherPointDetectorDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.oneoffGatherPointDetectorDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllOneoffGatherPointDetectorDataList(Iterable<? extends OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData> values) {
                if (this.oneoffGatherPointDetectorDataListBuilder_ == null) {
                    ensureOneoffGatherPointDetectorDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.oneoffGatherPointDetectorDataList_);
                    onChanged();
                } else {
                    this.oneoffGatherPointDetectorDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearOneoffGatherPointDetectorDataList() {
                if (this.oneoffGatherPointDetectorDataListBuilder_ == null) {
                    this.oneoffGatherPointDetectorDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.oneoffGatherPointDetectorDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeOneoffGatherPointDetectorDataList(int index) {
                if (this.oneoffGatherPointDetectorDataListBuilder_ == null) {
                    ensureOneoffGatherPointDetectorDataListIsMutable();
                    this.oneoffGatherPointDetectorDataList_.remove(index);
                    onChanged();
                } else {
                    this.oneoffGatherPointDetectorDataListBuilder_.remove(index);
                }
                return this;
            }

            public OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.Builder getOneoffGatherPointDetectorDataListBuilder(int index) {
                return getOneoffGatherPointDetectorDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder getOneoffGatherPointDetectorDataListOrBuilder(int index) {
                if (this.oneoffGatherPointDetectorDataListBuilder_ == null) {
                    return this.oneoffGatherPointDetectorDataList_.get(index);
                }
                return this.oneoffGatherPointDetectorDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public List<? extends OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder> getOneoffGatherPointDetectorDataListOrBuilderList() {
                if (this.oneoffGatherPointDetectorDataListBuilder_ != null) {
                    return this.oneoffGatherPointDetectorDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.oneoffGatherPointDetectorDataList_);
            }

            public OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.Builder addOneoffGatherPointDetectorDataListBuilder() {
                return getOneoffGatherPointDetectorDataListFieldBuilder().addBuilder(OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.getDefaultInstance());
            }

            public OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.Builder addOneoffGatherPointDetectorDataListBuilder(int index) {
                return getOneoffGatherPointDetectorDataListFieldBuilder().addBuilder(index, OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.getDefaultInstance());
            }

            public List<OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.Builder> getOneoffGatherPointDetectorDataListBuilderList() {
                return getOneoffGatherPointDetectorDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData, OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.Builder, OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder> getOneoffGatherPointDetectorDataListFieldBuilder() {
                if (this.oneoffGatherPointDetectorDataListBuilder_ == null) {
                    this.oneoffGatherPointDetectorDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.oneoffGatherPointDetectorDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.oneoffGatherPointDetectorDataList_ = null;
                }
                return this.oneoffGatherPointDetectorDataListBuilder_;
            }

            private void ensureSlotListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.slotList_ = new ArrayList(this.slotList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public List<WidgetSlotDataOuterClass.WidgetSlotData> getSlotListList() {
                if (this.slotListBuilder_ == null) {
                    return Collections.unmodifiableList(this.slotList_);
                }
                return this.slotListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public int getSlotListCount() {
                if (this.slotListBuilder_ == null) {
                    return this.slotList_.size();
                }
                return this.slotListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public WidgetSlotDataOuterClass.WidgetSlotData getSlotList(int index) {
                if (this.slotListBuilder_ == null) {
                    return this.slotList_.get(index);
                }
                return this.slotListBuilder_.getMessage(index);
            }

            public Builder setSlotList(int index, WidgetSlotDataOuterClass.WidgetSlotData value) {
                if (this.slotListBuilder_ != null) {
                    this.slotListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSlotListIsMutable();
                    this.slotList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setSlotList(int index, WidgetSlotDataOuterClass.WidgetSlotData.Builder builderForValue) {
                if (this.slotListBuilder_ == null) {
                    ensureSlotListIsMutable();
                    this.slotList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.slotListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addSlotList(WidgetSlotDataOuterClass.WidgetSlotData value) {
                if (this.slotListBuilder_ != null) {
                    this.slotListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSlotListIsMutable();
                    this.slotList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addSlotList(int index, WidgetSlotDataOuterClass.WidgetSlotData value) {
                if (this.slotListBuilder_ != null) {
                    this.slotListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSlotListIsMutable();
                    this.slotList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addSlotList(WidgetSlotDataOuterClass.WidgetSlotData.Builder builderForValue) {
                if (this.slotListBuilder_ == null) {
                    ensureSlotListIsMutable();
                    this.slotList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.slotListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addSlotList(int index, WidgetSlotDataOuterClass.WidgetSlotData.Builder builderForValue) {
                if (this.slotListBuilder_ == null) {
                    ensureSlotListIsMutable();
                    this.slotList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.slotListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllSlotList(Iterable<? extends WidgetSlotDataOuterClass.WidgetSlotData> values) {
                if (this.slotListBuilder_ == null) {
                    ensureSlotListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.slotList_);
                    onChanged();
                } else {
                    this.slotListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearSlotList() {
                if (this.slotListBuilder_ == null) {
                    this.slotList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.slotListBuilder_.clear();
                }
                return this;
            }

            public Builder removeSlotList(int index) {
                if (this.slotListBuilder_ == null) {
                    ensureSlotListIsMutable();
                    this.slotList_.remove(index);
                    onChanged();
                } else {
                    this.slotListBuilder_.remove(index);
                }
                return this;
            }

            public WidgetSlotDataOuterClass.WidgetSlotData.Builder getSlotListBuilder(int index) {
                return getSlotListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder getSlotListOrBuilder(int index) {
                if (this.slotListBuilder_ == null) {
                    return this.slotList_.get(index);
                }
                return this.slotListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public List<? extends WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder> getSlotListOrBuilderList() {
                if (this.slotListBuilder_ != null) {
                    return this.slotListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.slotList_);
            }

            public WidgetSlotDataOuterClass.WidgetSlotData.Builder addSlotListBuilder() {
                return getSlotListFieldBuilder().addBuilder(WidgetSlotDataOuterClass.WidgetSlotData.getDefaultInstance());
            }

            public WidgetSlotDataOuterClass.WidgetSlotData.Builder addSlotListBuilder(int index) {
                return getSlotListFieldBuilder().addBuilder(index, WidgetSlotDataOuterClass.WidgetSlotData.getDefaultInstance());
            }

            public List<WidgetSlotDataOuterClass.WidgetSlotData.Builder> getSlotListBuilderList() {
                return getSlotListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<WidgetSlotDataOuterClass.WidgetSlotData, WidgetSlotDataOuterClass.WidgetSlotData.Builder, WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder> getSlotListFieldBuilder() {
                if (this.slotListBuilder_ == null) {
                    this.slotListBuilder_ = new RepeatedFieldBuilderV3<>(this.slotList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.slotList_ = null;
                }
                return this.slotListBuilder_;
            }

            private void ensureBackgroundActiveWidgetListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.backgroundActiveWidgetList_ = AllWidgetDataNotify.mutableCopy(this.backgroundActiveWidgetList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public List<Integer> getBackgroundActiveWidgetListList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.backgroundActiveWidgetList_) : this.backgroundActiveWidgetList_;
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public int getBackgroundActiveWidgetListCount() {
                return this.backgroundActiveWidgetList_.size();
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public int getBackgroundActiveWidgetList(int index) {
                return this.backgroundActiveWidgetList_.getInt(index);
            }

            public Builder setBackgroundActiveWidgetList(int index, int value) {
                ensureBackgroundActiveWidgetListIsMutable();
                this.backgroundActiveWidgetList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addBackgroundActiveWidgetList(int value) {
                ensureBackgroundActiveWidgetListIsMutable();
                this.backgroundActiveWidgetList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllBackgroundActiveWidgetList(Iterable<? extends Integer> values) {
                ensureBackgroundActiveWidgetListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.backgroundActiveWidgetList_);
                onChanged();
                return this;
            }

            public Builder clearBackgroundActiveWidgetList() {
                this.backgroundActiveWidgetList_ = AllWidgetDataNotify.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            private void ensureCoolDownGroupDataListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.coolDownGroupDataList_ = new ArrayList(this.coolDownGroupDataList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public List<WidgetCoolDownDataOuterClass.WidgetCoolDownData> getCoolDownGroupDataListList() {
                if (this.coolDownGroupDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.coolDownGroupDataList_);
                }
                return this.coolDownGroupDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public int getCoolDownGroupDataListCount() {
                if (this.coolDownGroupDataListBuilder_ == null) {
                    return this.coolDownGroupDataList_.size();
                }
                return this.coolDownGroupDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public WidgetCoolDownDataOuterClass.WidgetCoolDownData getCoolDownGroupDataList(int index) {
                if (this.coolDownGroupDataListBuilder_ == null) {
                    return this.coolDownGroupDataList_.get(index);
                }
                return this.coolDownGroupDataListBuilder_.getMessage(index);
            }

            public Builder setCoolDownGroupDataList(int index, WidgetCoolDownDataOuterClass.WidgetCoolDownData value) {
                if (this.coolDownGroupDataListBuilder_ != null) {
                    this.coolDownGroupDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCoolDownGroupDataListIsMutable();
                    this.coolDownGroupDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setCoolDownGroupDataList(int index, WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder builderForValue) {
                if (this.coolDownGroupDataListBuilder_ == null) {
                    ensureCoolDownGroupDataListIsMutable();
                    this.coolDownGroupDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.coolDownGroupDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addCoolDownGroupDataList(WidgetCoolDownDataOuterClass.WidgetCoolDownData value) {
                if (this.coolDownGroupDataListBuilder_ != null) {
                    this.coolDownGroupDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCoolDownGroupDataListIsMutable();
                    this.coolDownGroupDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addCoolDownGroupDataList(int index, WidgetCoolDownDataOuterClass.WidgetCoolDownData value) {
                if (this.coolDownGroupDataListBuilder_ != null) {
                    this.coolDownGroupDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCoolDownGroupDataListIsMutable();
                    this.coolDownGroupDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addCoolDownGroupDataList(WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder builderForValue) {
                if (this.coolDownGroupDataListBuilder_ == null) {
                    ensureCoolDownGroupDataListIsMutable();
                    this.coolDownGroupDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.coolDownGroupDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addCoolDownGroupDataList(int index, WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder builderForValue) {
                if (this.coolDownGroupDataListBuilder_ == null) {
                    ensureCoolDownGroupDataListIsMutable();
                    this.coolDownGroupDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.coolDownGroupDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllCoolDownGroupDataList(Iterable<? extends WidgetCoolDownDataOuterClass.WidgetCoolDownData> values) {
                if (this.coolDownGroupDataListBuilder_ == null) {
                    ensureCoolDownGroupDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.coolDownGroupDataList_);
                    onChanged();
                } else {
                    this.coolDownGroupDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearCoolDownGroupDataList() {
                if (this.coolDownGroupDataListBuilder_ == null) {
                    this.coolDownGroupDataList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    this.coolDownGroupDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeCoolDownGroupDataList(int index) {
                if (this.coolDownGroupDataListBuilder_ == null) {
                    ensureCoolDownGroupDataListIsMutable();
                    this.coolDownGroupDataList_.remove(index);
                    onChanged();
                } else {
                    this.coolDownGroupDataListBuilder_.remove(index);
                }
                return this;
            }

            public WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder getCoolDownGroupDataListBuilder(int index) {
                return getCoolDownGroupDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder getCoolDownGroupDataListOrBuilder(int index) {
                if (this.coolDownGroupDataListBuilder_ == null) {
                    return this.coolDownGroupDataList_.get(index);
                }
                return this.coolDownGroupDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public List<? extends WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder> getCoolDownGroupDataListOrBuilderList() {
                if (this.coolDownGroupDataListBuilder_ != null) {
                    return this.coolDownGroupDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.coolDownGroupDataList_);
            }

            public WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder addCoolDownGroupDataListBuilder() {
                return getCoolDownGroupDataListFieldBuilder().addBuilder(WidgetCoolDownDataOuterClass.WidgetCoolDownData.getDefaultInstance());
            }

            public WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder addCoolDownGroupDataListBuilder(int index) {
                return getCoolDownGroupDataListFieldBuilder().addBuilder(index, WidgetCoolDownDataOuterClass.WidgetCoolDownData.getDefaultInstance());
            }

            public List<WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder> getCoolDownGroupDataListBuilderList() {
                return getCoolDownGroupDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<WidgetCoolDownDataOuterClass.WidgetCoolDownData, WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder, WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder> getCoolDownGroupDataListFieldBuilder() {
                if (this.coolDownGroupDataListBuilder_ == null) {
                    this.coolDownGroupDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.coolDownGroupDataList_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.coolDownGroupDataList_ = null;
                }
                return this.coolDownGroupDataListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public boolean hasSkyCrystalDetectorData() {
                return (this.skyCrystalDetectorDataBuilder_ == null && this.skyCrystalDetectorData_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData getSkyCrystalDetectorData() {
                if (this.skyCrystalDetectorDataBuilder_ == null) {
                    return this.skyCrystalDetectorData_ == null ? SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData.getDefaultInstance() : this.skyCrystalDetectorData_;
                }
                return this.skyCrystalDetectorDataBuilder_.getMessage();
            }

            public Builder setSkyCrystalDetectorData(SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData value) {
                if (this.skyCrystalDetectorDataBuilder_ != null) {
                    this.skyCrystalDetectorDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.skyCrystalDetectorData_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setSkyCrystalDetectorData(SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData.Builder builderForValue) {
                if (this.skyCrystalDetectorDataBuilder_ == null) {
                    this.skyCrystalDetectorData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.skyCrystalDetectorDataBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeSkyCrystalDetectorData(SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData value) {
                if (this.skyCrystalDetectorDataBuilder_ == null) {
                    if (this.skyCrystalDetectorData_ != null) {
                        this.skyCrystalDetectorData_ = SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData.newBuilder(this.skyCrystalDetectorData_).mergeFrom(value).buildPartial();
                    } else {
                        this.skyCrystalDetectorData_ = value;
                    }
                    onChanged();
                } else {
                    this.skyCrystalDetectorDataBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearSkyCrystalDetectorData() {
                if (this.skyCrystalDetectorDataBuilder_ == null) {
                    this.skyCrystalDetectorData_ = null;
                    onChanged();
                } else {
                    this.skyCrystalDetectorData_ = null;
                    this.skyCrystalDetectorDataBuilder_ = null;
                }
                return this;
            }

            public SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData.Builder getSkyCrystalDetectorDataBuilder() {
                onChanged();
                return getSkyCrystalDetectorDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorDataOrBuilder getSkyCrystalDetectorDataOrBuilder() {
                if (this.skyCrystalDetectorDataBuilder_ != null) {
                    return this.skyCrystalDetectorDataBuilder_.getMessageOrBuilder();
                }
                return this.skyCrystalDetectorData_ == null ? SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData.getDefaultInstance() : this.skyCrystalDetectorData_;
            }

            private SingleFieldBuilderV3<SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData, SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData.Builder, SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorDataOrBuilder> getSkyCrystalDetectorDataFieldBuilder() {
                if (this.skyCrystalDetectorDataBuilder_ == null) {
                    this.skyCrystalDetectorDataBuilder_ = new SingleFieldBuilderV3<>(getSkyCrystalDetectorData(), getParentForChildren(), isClean());
                    this.skyCrystalDetectorData_ = null;
                }
                return this.skyCrystalDetectorDataBuilder_;
            }

            private void ensureClientCollectorDataListIsMutable() {
                if ((this.bitField0_ & 16) == 0) {
                    this.clientCollectorDataList_ = new ArrayList(this.clientCollectorDataList_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public List<ClientCollectorDataOuterClass.ClientCollectorData> getClientCollectorDataListList() {
                if (this.clientCollectorDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.clientCollectorDataList_);
                }
                return this.clientCollectorDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public int getClientCollectorDataListCount() {
                if (this.clientCollectorDataListBuilder_ == null) {
                    return this.clientCollectorDataList_.size();
                }
                return this.clientCollectorDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public ClientCollectorDataOuterClass.ClientCollectorData getClientCollectorDataList(int index) {
                if (this.clientCollectorDataListBuilder_ == null) {
                    return this.clientCollectorDataList_.get(index);
                }
                return this.clientCollectorDataListBuilder_.getMessage(index);
            }

            public Builder setClientCollectorDataList(int index, ClientCollectorDataOuterClass.ClientCollectorData value) {
                if (this.clientCollectorDataListBuilder_ != null) {
                    this.clientCollectorDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureClientCollectorDataListIsMutable();
                    this.clientCollectorDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setClientCollectorDataList(int index, ClientCollectorDataOuterClass.ClientCollectorData.Builder builderForValue) {
                if (this.clientCollectorDataListBuilder_ == null) {
                    ensureClientCollectorDataListIsMutable();
                    this.clientCollectorDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.clientCollectorDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addClientCollectorDataList(ClientCollectorDataOuterClass.ClientCollectorData value) {
                if (this.clientCollectorDataListBuilder_ != null) {
                    this.clientCollectorDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureClientCollectorDataListIsMutable();
                    this.clientCollectorDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addClientCollectorDataList(int index, ClientCollectorDataOuterClass.ClientCollectorData value) {
                if (this.clientCollectorDataListBuilder_ != null) {
                    this.clientCollectorDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureClientCollectorDataListIsMutable();
                    this.clientCollectorDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addClientCollectorDataList(ClientCollectorDataOuterClass.ClientCollectorData.Builder builderForValue) {
                if (this.clientCollectorDataListBuilder_ == null) {
                    ensureClientCollectorDataListIsMutable();
                    this.clientCollectorDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.clientCollectorDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addClientCollectorDataList(int index, ClientCollectorDataOuterClass.ClientCollectorData.Builder builderForValue) {
                if (this.clientCollectorDataListBuilder_ == null) {
                    ensureClientCollectorDataListIsMutable();
                    this.clientCollectorDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.clientCollectorDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllClientCollectorDataList(Iterable<? extends ClientCollectorDataOuterClass.ClientCollectorData> values) {
                if (this.clientCollectorDataListBuilder_ == null) {
                    ensureClientCollectorDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.clientCollectorDataList_);
                    onChanged();
                } else {
                    this.clientCollectorDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearClientCollectorDataList() {
                if (this.clientCollectorDataListBuilder_ == null) {
                    this.clientCollectorDataList_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    onChanged();
                } else {
                    this.clientCollectorDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeClientCollectorDataList(int index) {
                if (this.clientCollectorDataListBuilder_ == null) {
                    ensureClientCollectorDataListIsMutable();
                    this.clientCollectorDataList_.remove(index);
                    onChanged();
                } else {
                    this.clientCollectorDataListBuilder_.remove(index);
                }
                return this;
            }

            public ClientCollectorDataOuterClass.ClientCollectorData.Builder getClientCollectorDataListBuilder(int index) {
                return getClientCollectorDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public ClientCollectorDataOuterClass.ClientCollectorDataOrBuilder getClientCollectorDataListOrBuilder(int index) {
                if (this.clientCollectorDataListBuilder_ == null) {
                    return this.clientCollectorDataList_.get(index);
                }
                return this.clientCollectorDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public List<? extends ClientCollectorDataOuterClass.ClientCollectorDataOrBuilder> getClientCollectorDataListOrBuilderList() {
                if (this.clientCollectorDataListBuilder_ != null) {
                    return this.clientCollectorDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.clientCollectorDataList_);
            }

            public ClientCollectorDataOuterClass.ClientCollectorData.Builder addClientCollectorDataListBuilder() {
                return getClientCollectorDataListFieldBuilder().addBuilder(ClientCollectorDataOuterClass.ClientCollectorData.getDefaultInstance());
            }

            public ClientCollectorDataOuterClass.ClientCollectorData.Builder addClientCollectorDataListBuilder(int index) {
                return getClientCollectorDataListFieldBuilder().addBuilder(index, ClientCollectorDataOuterClass.ClientCollectorData.getDefaultInstance());
            }

            public List<ClientCollectorDataOuterClass.ClientCollectorData.Builder> getClientCollectorDataListBuilderList() {
                return getClientCollectorDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ClientCollectorDataOuterClass.ClientCollectorData, ClientCollectorDataOuterClass.ClientCollectorData.Builder, ClientCollectorDataOuterClass.ClientCollectorDataOrBuilder> getClientCollectorDataListFieldBuilder() {
                if (this.clientCollectorDataListBuilder_ == null) {
                    this.clientCollectorDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.clientCollectorDataList_, (this.bitField0_ & 16) != 0, getParentForChildren(), isClean());
                    this.clientCollectorDataList_ = null;
                }
                return this.clientCollectorDataListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public boolean hasWeatherWizardData() {
                return (this.weatherWizardDataBuilder_ == null && this.weatherWizardData_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public WeatherWizardDataOuterClass.WeatherWizardData getWeatherWizardData() {
                if (this.weatherWizardDataBuilder_ == null) {
                    return this.weatherWizardData_ == null ? WeatherWizardDataOuterClass.WeatherWizardData.getDefaultInstance() : this.weatherWizardData_;
                }
                return this.weatherWizardDataBuilder_.getMessage();
            }

            public Builder setWeatherWizardData(WeatherWizardDataOuterClass.WeatherWizardData value) {
                if (this.weatherWizardDataBuilder_ != null) {
                    this.weatherWizardDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.weatherWizardData_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setWeatherWizardData(WeatherWizardDataOuterClass.WeatherWizardData.Builder builderForValue) {
                if (this.weatherWizardDataBuilder_ == null) {
                    this.weatherWizardData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.weatherWizardDataBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeWeatherWizardData(WeatherWizardDataOuterClass.WeatherWizardData value) {
                if (this.weatherWizardDataBuilder_ == null) {
                    if (this.weatherWizardData_ != null) {
                        this.weatherWizardData_ = WeatherWizardDataOuterClass.WeatherWizardData.newBuilder(this.weatherWizardData_).mergeFrom(value).buildPartial();
                    } else {
                        this.weatherWizardData_ = value;
                    }
                    onChanged();
                } else {
                    this.weatherWizardDataBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearWeatherWizardData() {
                if (this.weatherWizardDataBuilder_ == null) {
                    this.weatherWizardData_ = null;
                    onChanged();
                } else {
                    this.weatherWizardData_ = null;
                    this.weatherWizardDataBuilder_ = null;
                }
                return this;
            }

            public WeatherWizardDataOuterClass.WeatherWizardData.Builder getWeatherWizardDataBuilder() {
                onChanged();
                return getWeatherWizardDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public WeatherWizardDataOuterClass.WeatherWizardDataOrBuilder getWeatherWizardDataOrBuilder() {
                if (this.weatherWizardDataBuilder_ != null) {
                    return this.weatherWizardDataBuilder_.getMessageOrBuilder();
                }
                return this.weatherWizardData_ == null ? WeatherWizardDataOuterClass.WeatherWizardData.getDefaultInstance() : this.weatherWizardData_;
            }

            private SingleFieldBuilderV3<WeatherWizardDataOuterClass.WeatherWizardData, WeatherWizardDataOuterClass.WeatherWizardData.Builder, WeatherWizardDataOuterClass.WeatherWizardDataOrBuilder> getWeatherWizardDataFieldBuilder() {
                if (this.weatherWizardDataBuilder_ == null) {
                    this.weatherWizardDataBuilder_ = new SingleFieldBuilderV3<>(getWeatherWizardData(), getParentForChildren(), isClean());
                    this.weatherWizardData_ = null;
                }
                return this.weatherWizardDataBuilder_;
            }

            private void ensureNormalCoolDownDataListIsMutable() {
                if ((this.bitField0_ & 32) == 0) {
                    this.normalCoolDownDataList_ = new ArrayList(this.normalCoolDownDataList_);
                    this.bitField0_ |= 32;
                }
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public List<WidgetCoolDownDataOuterClass.WidgetCoolDownData> getNormalCoolDownDataListList() {
                if (this.normalCoolDownDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.normalCoolDownDataList_);
                }
                return this.normalCoolDownDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public int getNormalCoolDownDataListCount() {
                if (this.normalCoolDownDataListBuilder_ == null) {
                    return this.normalCoolDownDataList_.size();
                }
                return this.normalCoolDownDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public WidgetCoolDownDataOuterClass.WidgetCoolDownData getNormalCoolDownDataList(int index) {
                if (this.normalCoolDownDataListBuilder_ == null) {
                    return this.normalCoolDownDataList_.get(index);
                }
                return this.normalCoolDownDataListBuilder_.getMessage(index);
            }

            public Builder setNormalCoolDownDataList(int index, WidgetCoolDownDataOuterClass.WidgetCoolDownData value) {
                if (this.normalCoolDownDataListBuilder_ != null) {
                    this.normalCoolDownDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureNormalCoolDownDataListIsMutable();
                    this.normalCoolDownDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setNormalCoolDownDataList(int index, WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder builderForValue) {
                if (this.normalCoolDownDataListBuilder_ == null) {
                    ensureNormalCoolDownDataListIsMutable();
                    this.normalCoolDownDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.normalCoolDownDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addNormalCoolDownDataList(WidgetCoolDownDataOuterClass.WidgetCoolDownData value) {
                if (this.normalCoolDownDataListBuilder_ != null) {
                    this.normalCoolDownDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureNormalCoolDownDataListIsMutable();
                    this.normalCoolDownDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addNormalCoolDownDataList(int index, WidgetCoolDownDataOuterClass.WidgetCoolDownData value) {
                if (this.normalCoolDownDataListBuilder_ != null) {
                    this.normalCoolDownDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureNormalCoolDownDataListIsMutable();
                    this.normalCoolDownDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addNormalCoolDownDataList(WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder builderForValue) {
                if (this.normalCoolDownDataListBuilder_ == null) {
                    ensureNormalCoolDownDataListIsMutable();
                    this.normalCoolDownDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.normalCoolDownDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addNormalCoolDownDataList(int index, WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder builderForValue) {
                if (this.normalCoolDownDataListBuilder_ == null) {
                    ensureNormalCoolDownDataListIsMutable();
                    this.normalCoolDownDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.normalCoolDownDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllNormalCoolDownDataList(Iterable<? extends WidgetCoolDownDataOuterClass.WidgetCoolDownData> values) {
                if (this.normalCoolDownDataListBuilder_ == null) {
                    ensureNormalCoolDownDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.normalCoolDownDataList_);
                    onChanged();
                } else {
                    this.normalCoolDownDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearNormalCoolDownDataList() {
                if (this.normalCoolDownDataListBuilder_ == null) {
                    this.normalCoolDownDataList_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                    onChanged();
                } else {
                    this.normalCoolDownDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeNormalCoolDownDataList(int index) {
                if (this.normalCoolDownDataListBuilder_ == null) {
                    ensureNormalCoolDownDataListIsMutable();
                    this.normalCoolDownDataList_.remove(index);
                    onChanged();
                } else {
                    this.normalCoolDownDataListBuilder_.remove(index);
                }
                return this;
            }

            public WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder getNormalCoolDownDataListBuilder(int index) {
                return getNormalCoolDownDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder getNormalCoolDownDataListOrBuilder(int index) {
                if (this.normalCoolDownDataListBuilder_ == null) {
                    return this.normalCoolDownDataList_.get(index);
                }
                return this.normalCoolDownDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public List<? extends WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder> getNormalCoolDownDataListOrBuilderList() {
                if (this.normalCoolDownDataListBuilder_ != null) {
                    return this.normalCoolDownDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.normalCoolDownDataList_);
            }

            public WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder addNormalCoolDownDataListBuilder() {
                return getNormalCoolDownDataListFieldBuilder().addBuilder(WidgetCoolDownDataOuterClass.WidgetCoolDownData.getDefaultInstance());
            }

            public WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder addNormalCoolDownDataListBuilder(int index) {
                return getNormalCoolDownDataListFieldBuilder().addBuilder(index, WidgetCoolDownDataOuterClass.WidgetCoolDownData.getDefaultInstance());
            }

            public List<WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder> getNormalCoolDownDataListBuilderList() {
                return getNormalCoolDownDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<WidgetCoolDownDataOuterClass.WidgetCoolDownData, WidgetCoolDownDataOuterClass.WidgetCoolDownData.Builder, WidgetCoolDownDataOuterClass.WidgetCoolDownDataOrBuilder> getNormalCoolDownDataListFieldBuilder() {
                if (this.normalCoolDownDataListBuilder_ == null) {
                    this.normalCoolDownDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.normalCoolDownDataList_, (this.bitField0_ & 32) != 0, getParentForChildren(), isClean());
                    this.normalCoolDownDataList_ = null;
                }
                return this.normalCoolDownDataListBuilder_;
            }

            private void ensureAnchorPointListIsMutable() {
                if ((this.bitField0_ & 64) == 0) {
                    this.anchorPointList_ = new ArrayList(this.anchorPointList_);
                    this.bitField0_ |= 64;
                }
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public List<AnchorPointDataOuterClass.AnchorPointData> getAnchorPointListList() {
                if (this.anchorPointListBuilder_ == null) {
                    return Collections.unmodifiableList(this.anchorPointList_);
                }
                return this.anchorPointListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public int getAnchorPointListCount() {
                if (this.anchorPointListBuilder_ == null) {
                    return this.anchorPointList_.size();
                }
                return this.anchorPointListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public AnchorPointDataOuterClass.AnchorPointData getAnchorPointList(int index) {
                if (this.anchorPointListBuilder_ == null) {
                    return this.anchorPointList_.get(index);
                }
                return this.anchorPointListBuilder_.getMessage(index);
            }

            public Builder setAnchorPointList(int index, AnchorPointDataOuterClass.AnchorPointData value) {
                if (this.anchorPointListBuilder_ != null) {
                    this.anchorPointListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAnchorPointListIsMutable();
                    this.anchorPointList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setAnchorPointList(int index, AnchorPointDataOuterClass.AnchorPointData.Builder builderForValue) {
                if (this.anchorPointListBuilder_ == null) {
                    ensureAnchorPointListIsMutable();
                    this.anchorPointList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.anchorPointListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAnchorPointList(AnchorPointDataOuterClass.AnchorPointData value) {
                if (this.anchorPointListBuilder_ != null) {
                    this.anchorPointListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAnchorPointListIsMutable();
                    this.anchorPointList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addAnchorPointList(int index, AnchorPointDataOuterClass.AnchorPointData value) {
                if (this.anchorPointListBuilder_ != null) {
                    this.anchorPointListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAnchorPointListIsMutable();
                    this.anchorPointList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addAnchorPointList(AnchorPointDataOuterClass.AnchorPointData.Builder builderForValue) {
                if (this.anchorPointListBuilder_ == null) {
                    ensureAnchorPointListIsMutable();
                    this.anchorPointList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.anchorPointListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAnchorPointList(int index, AnchorPointDataOuterClass.AnchorPointData.Builder builderForValue) {
                if (this.anchorPointListBuilder_ == null) {
                    ensureAnchorPointListIsMutable();
                    this.anchorPointList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.anchorPointListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAnchorPointList(Iterable<? extends AnchorPointDataOuterClass.AnchorPointData> values) {
                if (this.anchorPointListBuilder_ == null) {
                    ensureAnchorPointListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.anchorPointList_);
                    onChanged();
                } else {
                    this.anchorPointListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAnchorPointList() {
                if (this.anchorPointListBuilder_ == null) {
                    this.anchorPointList_ = Collections.emptyList();
                    this.bitField0_ &= -65;
                    onChanged();
                } else {
                    this.anchorPointListBuilder_.clear();
                }
                return this;
            }

            public Builder removeAnchorPointList(int index) {
                if (this.anchorPointListBuilder_ == null) {
                    ensureAnchorPointListIsMutable();
                    this.anchorPointList_.remove(index);
                    onChanged();
                } else {
                    this.anchorPointListBuilder_.remove(index);
                }
                return this;
            }

            public AnchorPointDataOuterClass.AnchorPointData.Builder getAnchorPointListBuilder(int index) {
                return getAnchorPointListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public AnchorPointDataOuterClass.AnchorPointDataOrBuilder getAnchorPointListOrBuilder(int index) {
                if (this.anchorPointListBuilder_ == null) {
                    return this.anchorPointList_.get(index);
                }
                return this.anchorPointListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass.AllWidgetDataNotifyOrBuilder
            public List<? extends AnchorPointDataOuterClass.AnchorPointDataOrBuilder> getAnchorPointListOrBuilderList() {
                if (this.anchorPointListBuilder_ != null) {
                    return this.anchorPointListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.anchorPointList_);
            }

            public AnchorPointDataOuterClass.AnchorPointData.Builder addAnchorPointListBuilder() {
                return getAnchorPointListFieldBuilder().addBuilder(AnchorPointDataOuterClass.AnchorPointData.getDefaultInstance());
            }

            public AnchorPointDataOuterClass.AnchorPointData.Builder addAnchorPointListBuilder(int index) {
                return getAnchorPointListFieldBuilder().addBuilder(index, AnchorPointDataOuterClass.AnchorPointData.getDefaultInstance());
            }

            public List<AnchorPointDataOuterClass.AnchorPointData.Builder> getAnchorPointListBuilderList() {
                return getAnchorPointListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AnchorPointDataOuterClass.AnchorPointData, AnchorPointDataOuterClass.AnchorPointData.Builder, AnchorPointDataOuterClass.AnchorPointDataOrBuilder> getAnchorPointListFieldBuilder() {
                if (this.anchorPointListBuilder_ == null) {
                    this.anchorPointListBuilder_ = new RepeatedFieldBuilderV3<>(this.anchorPointList_, (this.bitField0_ & 64) != 0, getParentForChildren(), isClean());
                    this.anchorPointList_ = null;
                }
                return this.anchorPointListBuilder_;
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

        public static AllWidgetDataNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AllWidgetDataNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AllWidgetDataNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AllWidgetDataNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AnchorPointDataOuterClass.getDescriptor();
        ClientCollectorDataOuterClass.getDescriptor();
        LunchBoxDataOuterClass.getDescriptor();
        OneoffGatherPointDetectorDataOuterClass.getDescriptor();
        SkyCrystalDetectorDataOuterClass.getDescriptor();
        WeatherWizardDataOuterClass.getDescriptor();
        WidgetCoolDownDataOuterClass.getDescriptor();
        WidgetSlotDataOuterClass.getDescriptor();
    }
}
