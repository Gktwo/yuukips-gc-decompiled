package emu.grasscutter.game.avatar;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.AvatarData;
import emu.grasscutter.data.excels.AvatarSkillDepotData;
import emu.grasscutter.database.DatabaseHelper;
import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.player.BasePlayerManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.packet.send.PacketAvatarChangeCostumeNotify;
import emu.grasscutter.server.packet.send.PacketAvatarFlycloakChangeNotify;
import java.util.Iterator;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import p014it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import p014it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/avatar/AvatarStorage.class */
public class AvatarStorage extends BasePlayerManager implements Iterable<Avatar> {
    private final Int2ObjectMap<Avatar> avatars = new Int2ObjectOpenHashMap();
    private final Long2ObjectMap<Avatar> avatarsGuid = new Long2ObjectOpenHashMap();

    public AvatarStorage(Player player) {
        super(player);
    }

    public Int2ObjectMap<Avatar> getAvatars() {
        return this.avatars;
    }

    public int getAvatarCount() {
        return this.avatars.size();
    }

    public Avatar getAvatarById(int id) {
        return getAvatars().get(id);
    }

    public Avatar getAvatarByGuid(long id) {
        return this.avatarsGuid.get(id);
    }

    public boolean hasAvatar(int id) {
        return getAvatars().containsKey(id);
    }

    public boolean addAvatar(Avatar avatar) {
        if (avatar.getAvatarData() == null || hasAvatar(avatar.getAvatarId())) {
            return false;
        }
        avatar.setOwner(getPlayer());
        this.avatars.put(avatar.getAvatarId(), (int) avatar);
        this.avatarsGuid.put(avatar.getGuid(), (long) avatar);
        avatar.save();
        return true;
    }

    public void addStartingWeapon(Avatar avatar) {
        if (avatar.getPlayer() == getPlayer()) {
            GameItem weapon = new GameItem(avatar.getAvatarData().getInitialWeapon());
            if (weapon.getItemData() != null) {
                getPlayer().getInventory().addItem(weapon);
                avatar.equipItem(weapon, true);
            }
        }
    }

    public boolean wearFlycloak(long avatarGuid, int flycloakId) {
        Avatar avatar = getAvatarByGuid(avatarGuid);
        if (avatar == null || !getPlayer().getFlyCloakList().contains(Integer.valueOf(flycloakId))) {
            return false;
        }
        avatar.setFlyCloak(flycloakId);
        avatar.save();
        getPlayer().sendPacket(new PacketAvatarFlycloakChangeNotify(avatar));
        return true;
    }

    public boolean changeCostume(long avatarGuid, int costumeId) {
        Avatar avatar = getAvatarByGuid(avatarGuid);
        if (avatar == null) {
            return false;
        }
        if (costumeId != 0 && !getPlayer().getCostumeList().contains(Integer.valueOf(costumeId))) {
            return false;
        }
        avatar.setCostume(costumeId);
        avatar.save();
        EntityAvatar entity = avatar.getAsEntity();
        if (entity == null) {
            getPlayer().sendPacket(new PacketAvatarChangeCostumeNotify(new EntityAvatar(avatar)));
            return true;
        }
        getPlayer().getScene().broadcastPacket(new PacketAvatarChangeCostumeNotify(entity));
        return true;
    }

    public void loadFromDatabase() {
        for (Avatar avatar : DatabaseHelper.getAvatars(getPlayer())) {
            if (avatar.getObjectId() != null) {
                AvatarData avatarData = GameData.getAvatarDataMap().get(avatar.getAvatarId());
                AvatarSkillDepotData skillDepot = GameData.getAvatarSkillDepotDataMap().get(avatar.getSkillDepotId());
                if (!(avatarData == null || skillDepot == null)) {
                    avatar.setAvatarData(avatarData);
                    avatar.setSkillDepot(skillDepot);
                    avatar.setOwner(getPlayer());
                    avatar.recalcConstellations();
                    this.avatars.put(avatar.getAvatarId(), (int) avatar);
                    this.avatarsGuid.put(avatar.getGuid(), (long) avatar);
                }
            }
        }
    }

    public void postLoad() {
        Iterator<Avatar> it = iterator();
        while (it.hasNext()) {
            Avatar avatar = it.next();
            if (avatar.getWeapon() == null) {
                addStartingWeapon(avatar);
            }
            avatar.recalcStats();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Avatar> iterator() {
        return getAvatars().values().iterator();
    }
}
