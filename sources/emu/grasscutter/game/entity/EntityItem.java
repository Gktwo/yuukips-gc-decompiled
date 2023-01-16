package emu.grasscutter.game.entity;

import emu.grasscutter.data.excels.ItemData;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.game.props.EntityIdType;
import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass;
import emu.grasscutter.net.proto.AnimatorParameterValueInfoPairOuterClass;
import emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass;
import emu.grasscutter.net.proto.EntityClientDataOuterClass;
import emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass;
import emu.grasscutter.net.proto.GadgetBornTypeOuterClass;
import emu.grasscutter.net.proto.GadgetInteractReqOuterClass;
import emu.grasscutter.net.proto.InteractTypeOuterClass;
import emu.grasscutter.net.proto.MotionInfoOuterClass;
import emu.grasscutter.net.proto.PropPairOuterClass;
import emu.grasscutter.net.proto.ProtEntityTypeOuterClass;
import emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass;
import emu.grasscutter.net.proto.SceneEntityInfoOuterClass;
import emu.grasscutter.net.proto.SceneGadgetInfoOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import emu.grasscutter.server.packet.send.PacketDropHintNotify;
import emu.grasscutter.server.packet.send.PacketGadgetInteractRsp;
import emu.grasscutter.utils.Position;
import emu.grasscutter.utils.ProtoHelper;
import p014it.unimi.dsi.fastutil.ints.Int2FloatMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/entity/EntityItem.class */
public class EntityItem extends EntityBaseGadget {
    private final GameItem item;
    private final long guid;
    private final boolean share;

    public GameItem getItem() {
        return this.item;
    }

    public long getGuid() {
        return this.guid;
    }

    public boolean isShare() {
        return this.share;
    }

    public EntityItem(Scene scene, Player player, ItemData itemData, Position pos, int count) {
        this(scene, player, itemData, pos, count, true);
    }

    public EntityItem(Scene scene, Player player, ItemData itemData, Position pos, int count, boolean share) {
        super(scene, pos, null);
        this.f571id = getScene().getWorld().getNextEntityId(EntityIdType.GADGET);
        this.guid = player == null ? scene.getWorld().getHost().getNextGameGuid() : player.getNextGameGuid();
        this.item = new GameItem(itemData, count);
        this.share = share;
    }

    public ItemData getItemData() {
        return getItem().getItemData();
    }

    public int getCount() {
        return getItem().getCount();
    }

    @Override // emu.grasscutter.game.entity.EntityBaseGadget
    public int getGadgetId() {
        return getItemData().getGadgetId();
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public Int2FloatMap getFightProperties() {
        return null;
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public void onInteract(Player player, GadgetInteractReqOuterClass.GadgetInteractReq interactReq) {
        if (isShare() || ((int) (getGuid() >> 32)) == player.getUid()) {
            getScene().removeEntity(this);
            GameItem item = new GameItem(getItemData(), getCount());
            if (player.getInventory().addItem(item, ActionReason.SubfieldDrop)) {
                player.sendPacket(new PacketDropHintNotify(item.getItemId(), getPosition().toProto()));
                if (!isShare()) {
                    player.sendPacket(new PacketGadgetInteractRsp(this, InteractTypeOuterClass.InteractType.INTERACT_TYPE_PICK_ITEM));
                } else {
                    getScene().broadcastPacket(new PacketGadgetInteractRsp(this, InteractTypeOuterClass.InteractType.INTERACT_TYPE_PICK_ITEM));
                }
            }
        }
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public SceneEntityInfoOuterClass.SceneEntityInfo toProto() {
        SceneEntityInfoOuterClass.SceneEntityInfo.Builder entityInfo = SceneEntityInfoOuterClass.SceneEntityInfo.newBuilder().setEntityId(getId()).setEntityType(ProtEntityTypeOuterClass.ProtEntityType.PROT_ENTITY_TYPE_GADGET).setMotionInfo(MotionInfoOuterClass.MotionInfo.newBuilder().setPos(getPosition().toProto()).setRot(getRotation().toProto()).setSpeed(VectorOuterClass.Vector.newBuilder())).addAnimatorParaList(AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.newBuilder()).setEntityClientData(EntityClientDataOuterClass.EntityClientData.newBuilder()).setEntityAuthorityInfo(EntityAuthorityInfoOuterClass.EntityAuthorityInfo.newBuilder().setAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.newBuilder()).setRendererChangedInfo(EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.newBuilder()).setAiInfo(SceneEntityAiInfoOuterClass.SceneEntityAiInfo.newBuilder().setIsAiOpen(true).setBornPos(VectorOuterClass.Vector.newBuilder())).setBornPos(VectorOuterClass.Vector.newBuilder()).build()).setLifeState(1);
        entityInfo.addPropList(PropPairOuterClass.PropPair.newBuilder().setType(PlayerProperty.PROP_LEVEL.getId()).setPropValue(ProtoHelper.newPropValue(PlayerProperty.PROP_LEVEL, 1)).build());
        if (!(getItemData() == null || getItem() == null)) {
            entityInfo.setGadget(SceneGadgetInfoOuterClass.SceneGadgetInfo.newBuilder().setGadgetId(getItemData().getGadgetId()).setTrifleItem(getItem().toProto()).setBornType(GadgetBornTypeOuterClass.GadgetBornType.GADGET_BORN_TYPE_IN_AIR).setAuthorityPeerId(getWorld().getHostPeerId()).setIsEnableInteract(true));
        }
        return entityInfo.build();
    }
}
