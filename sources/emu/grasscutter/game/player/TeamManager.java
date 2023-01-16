package emu.grasscutter.game.player;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Transient;
import emu.grasscutter.GameConstants;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.data.GameData;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.entity.EntityBaseGadget;
import emu.grasscutter.game.props.ElementType;
import emu.grasscutter.game.props.EnterReason;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.game.world.World;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.EnterTypeOuterClass;
import emu.grasscutter.net.proto.MotionStateOuterClass;
import emu.grasscutter.net.proto.PlayerDieTypeOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import emu.grasscutter.server.event.player.PlayerTeamDeathEvent;
import emu.grasscutter.server.packet.send.PacketAddCustomTeamRsp;
import emu.grasscutter.server.packet.send.PacketAvatarDieAnimationEndRsp;
import emu.grasscutter.server.packet.send.PacketAvatarFightPropUpdateNotify;
import emu.grasscutter.server.packet.send.PacketAvatarLifeStateChangeNotify;
import emu.grasscutter.server.packet.send.PacketAvatarTeamUpdateNotify;
import emu.grasscutter.server.packet.send.PacketChangeAvatarRsp;
import emu.grasscutter.server.packet.send.PacketChangeMpTeamAvatarRsp;
import emu.grasscutter.server.packet.send.PacketChangeTeamNameRsp;
import emu.grasscutter.server.packet.send.PacketChooseCurAvatarTeamRsp;
import emu.grasscutter.server.packet.send.PacketCustomTeamListNotify;
import emu.grasscutter.server.packet.send.PacketPlayerEnterSceneNotify;
import emu.grasscutter.server.packet.send.PacketRemoveCustomTeamRsp;
import emu.grasscutter.server.packet.send.PacketSceneTeamUpdateNotify;
import emu.grasscutter.server.packet.send.PacketSetUpAvatarTeamRsp;
import emu.grasscutter.server.packet.send.PacketWorldPlayerDieNotify;
import emu.grasscutter.utils.Position;
import emu.grasscutter.utils.Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import p014it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import p014it.unimi.dsi.fastutil.ints.IntSet;
import p014it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/game/player/TeamManager.class */
public class TeamManager extends BasePlayerDataManager {
    private LinkedHashMap<Integer, TeamInfo> teams;
    private int currentTeamIndex;
    private int currentCharacterIndex;
    @Transient
    private TeamInfo mpTeam;
    @Transient
    private int entityId;
    @Transient
    private final List<EntityAvatar> avatars;
    @Transient
    private final Set<EntityBaseGadget> gadgets;
    @Transient
    private final IntSet teamResonances;
    @Transient
    private final IntSet teamResonancesConfig;
    @Transient
    private int useTemporarilyTeamIndex;
    @Transient
    private List<TeamInfo> temporaryTeam;

    public LinkedHashMap<Integer, TeamInfo> getTeams() {
        return this.teams;
    }

    public int getCurrentCharacterIndex() {
        return this.currentCharacterIndex;
    }

    public void setCurrentCharacterIndex(int currentCharacterIndex) {
        this.currentCharacterIndex = currentCharacterIndex;
    }

    public TeamInfo getMpTeam() {
        return this.mpTeam;
    }

    public void setMpTeam(TeamInfo mpTeam) {
        this.mpTeam = mpTeam;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public Set<EntityBaseGadget> getGadgets() {
        return this.gadgets;
    }

    public IntSet getTeamResonances() {
        return this.teamResonances;
    }

    public IntSet getTeamResonancesConfig() {
        return this.teamResonancesConfig;
    }

    public TeamManager() {
        this.useTemporarilyTeamIndex = -1;
        this.mpTeam = new TeamInfo();
        this.avatars = new ArrayList();
        this.gadgets = new HashSet();
        this.teamResonances = new IntOpenHashSet();
        this.teamResonancesConfig = new IntOpenHashSet();
    }

    public TeamManager(Player player) {
        this();
        setPlayer(player);
        this.teams = new LinkedHashMap<>();
        this.currentTeamIndex = 1;
        for (int i = 1; i <= 4; i++) {
            this.teams.put(Integer.valueOf(i), new TeamInfo());
        }
    }

    public World getWorld() {
        return getPlayer().getWorld();
    }

    public int getTeamId(TeamInfo team) {
        for (int i = 1; i <= this.teams.size(); i++) {
            if (this.teams.get(Integer.valueOf(i)).equals(team)) {
                return i;
            }
        }
        return -1;
    }

    public int getCurrentTeamId() {
        return this.currentTeamIndex;
    }

    private void setCurrentTeamId(int currentTeamIndex) {
        this.currentTeamIndex = currentTeamIndex;
    }

    public long getCurrentCharacterGuid() {
        if (getCurrentAvatarEntity() == null) {
            return 0;
        }
        return getCurrentAvatarEntity().getAvatar().getGuid();
    }

    public TeamInfo getCurrentTeamInfo() {
        if (this.useTemporarilyTeamIndex >= 0 && this.useTemporarilyTeamIndex < this.temporaryTeam.size()) {
            return this.temporaryTeam.get(this.useTemporarilyTeamIndex);
        }
        if (getPlayer().isInMultiplayer()) {
            return getMpTeam();
        }
        return getTeams().get(Integer.valueOf(this.currentTeamIndex));
    }

    public TeamInfo getCurrentSinglePlayerTeamInfo() {
        return getTeams().get(Integer.valueOf(this.currentTeamIndex));
    }

    public List<EntityAvatar> getActiveTeam() {
        return this.avatars;
    }

    public EntityAvatar getCurrentAvatarEntity() {
        try {
            return getActiveTeam().get(this.currentCharacterIndex);
        } catch (Exception e) {
            try {
                return (EntityAvatar) getActiveTeam().stream().findFirst().orElseThrow();
            } catch (Exception e2) {
                Grasscutter.getLogger().error("Error4: ", (Throwable) e);
                return null;
            }
        }
    }

    public boolean isSpawned() {
        try {
            if (getPlayer().getScene() != null) {
                if (getPlayer().getScene().getEntities().containsKey(Integer.valueOf(getCurrentAvatarEntity().getId()))) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            Grasscutter.getLogger().error("Error2: ", (Throwable) e);
            return false;
        }
    }

    public int getMaxTeamSize() {
        if (!getPlayer().isInMultiplayer()) {
            return Configuration.GAME_OPTIONS.avatarLimits.singlePlayerTeam;
        }
        int max = Configuration.GAME_OPTIONS.avatarLimits.multiplayerTeam;
        if (getPlayer().getWorld().getHost() == getPlayer()) {
            return Math.max(1, (int) Math.ceil(((double) max) / ((double) getWorld().getPlayerCount())));
        }
        return Math.max(1, (int) Math.floor(((double) max) / ((double) getWorld().getPlayerCount())));
    }

    public boolean canAddAvatarsToTeam(TeamInfo team, int avatars) {
        return team.size() + avatars <= getMaxTeamSize();
    }

    public boolean canAddAvatarToTeam(TeamInfo team) {
        return canAddAvatarsToTeam(team, 1);
    }

    public boolean canAddAvatarsToCurrentTeam(int avatars) {
        if (this.useTemporarilyTeamIndex != -1) {
            return false;
        }
        return canAddAvatarsToTeam(getCurrentTeamInfo(), avatars);
    }

    public boolean canAddAvatarToCurrentTeam() {
        return canAddAvatarsToCurrentTeam(1);
    }

    public boolean addAvatarsToTeam(TeamInfo team, Collection<Avatar> avatars) {
        if (!canAddAvatarsToTeam(team, avatars.size())) {
            return false;
        }
        team.getAvatars().addAll(avatars.stream().map(a -> {
            return Integer.valueOf(a.getAvatarId());
        }).toList());
        if (!getPlayer().isInMultiplayer()) {
            getPlayer().sendPacket(new PacketAvatarTeamUpdateNotify(getPlayer()));
            int teamId = getTeamId(team);
            if (teamId == -1) {
                return true;
            }
            if (teamId == getCurrentTeamId()) {
                updateTeamEntities(new PacketSetUpAvatarTeamRsp(getPlayer(), teamId, team));
                return true;
            }
            getPlayer().sendPacket(new PacketSetUpAvatarTeamRsp(getPlayer(), teamId, team));
            return true;
        } else if (!team.equals(getMpTeam())) {
            return true;
        } else {
            updateTeamEntities(new PacketChangeMpTeamAvatarRsp(getPlayer(), team));
            return true;
        }
    }

    public boolean addAvatarToTeam(TeamInfo team, Avatar avatar) {
        return addAvatarsToTeam(team, Collections.singleton(avatar));
    }

    public boolean addAvatarsToCurrentTeam(Collection<Avatar> avatars) {
        if (this.useTemporarilyTeamIndex != -1) {
            return false;
        }
        return addAvatarsToTeam(getCurrentTeamInfo(), avatars);
    }

    public boolean addAvatarToCurrentTeam(Avatar avatar) {
        return addAvatarsToCurrentTeam(Collections.singleton(avatar));
    }

    private void updateTeamResonances() {
        getTeamResonances().clear();
        getTeamResonancesConfig().clear();
        if (this.avatars.size() >= 4) {
            Object2IntOpenHashMap<ElementType> elementCounts = new Object2IntOpenHashMap<>();
            getActiveTeam().stream().map((v0) -> {
                return v0.getAvatar();
            }).filter((v0) -> {
                return Objects.nonNull(v0);
            }).map((v0) -> {
                return v0.getSkillDepot();
            }).filter((v0) -> {
                return Objects.nonNull(v0);
            }).map((v0) -> {
                return v0.getElementType();
            }).filter((v0) -> {
                return Objects.nonNull(v0);
            }).forEach(elementType -> {
                elementCounts.addTo(elementType, 1);
            });
            elementCounts.object2IntEntrySet().stream().filter(e -> {
                return e.getIntValue() >= 2;
            }).map(e -> {
                return (ElementType) e.getKey();
            }).filter(elementType -> {
                return elementType.getTeamResonanceId() != 0;
            }).forEach(elementType -> {
                this.teamResonances.add(elementType.getTeamResonanceId());
                this.teamResonancesConfig.add(elementType.getConfigHash());
            });
            if (elementCounts.size() >= 4) {
                this.teamResonances.add(ElementType.Default.getTeamResonanceId());
                this.teamResonancesConfig.add(ElementType.Default.getConfigHash());
            }
        }
    }

    public void updateTeamEntities(BasePacket responsePacket) {
        EntityAvatar currentEntity;
        EntityAvatar entity;
        if (getCurrentTeamInfo().getAvatars().size() > 0 && (currentEntity = getCurrentAvatarEntity()) != null) {
            Int2ObjectMap<EntityAvatar> existingAvatars = new Int2ObjectOpenHashMap<>();
            int prevSelectedAvatarIndex = -1;
            for (EntityAvatar entity2 : getActiveTeam()) {
                existingAvatars.put(entity2.getAvatar().getAvatarId(), (int) entity2);
            }
            getActiveTeam().clear();
            for (int i = 0; i < getCurrentTeamInfo().getAvatars().size(); i++) {
                int avatarId = getCurrentTeamInfo().getAvatars().get(i).intValue();
                if (existingAvatars.containsKey(avatarId)) {
                    entity = existingAvatars.get(avatarId);
                    existingAvatars.remove(avatarId);
                    if (entity == currentEntity) {
                        prevSelectedAvatarIndex = i;
                    }
                } else {
                    entity = new EntityAvatar(getPlayer().getScene(), getPlayer().getAvatars().getAvatarById(avatarId));
                }
                getActiveTeam().add(entity);
            }
            ObjectIterator<EntityAvatar> it = existingAvatars.values().iterator();
            while (it.hasNext()) {
                EntityAvatar entity3 = (EntityAvatar) it.next();
                getPlayer().getScene().removeEntity(entity3);
                entity3.getAvatar().save();
            }
            if (prevSelectedAvatarIndex == -1) {
                prevSelectedAvatarIndex = Math.min(this.currentCharacterIndex, getActiveTeam().size() - 1);
            }
            this.currentCharacterIndex = prevSelectedAvatarIndex;
            updateTeamResonances();
            getPlayer().getWorld().broadcastPacket(new PacketSceneTeamUpdateNotify(getPlayer()));
            getActiveTeam().stream().map((v0) -> {
                return v0.getAvatar();
            }).forEach((v0) -> {
                v0.sendSkillExtraChargeMap();
            });
            if (responsePacket != null) {
                getPlayer().sendPacket(responsePacket);
            }
            try {
                if (currentEntity != getCurrentAvatarEntity()) {
                    getPlayer().getScene().replaceEntity(currentEntity, getCurrentAvatarEntity());
                }
            } catch (Exception e) {
                Grasscutter.getLogger().error("Error1: ", (Throwable) e);
            }
        }
    }

    public synchronized void setupAvatarTeam(int teamId, List<Long> list) {
        TeamInfo teamInfo;
        if (!(list.size() == 0 || list.size() > getMaxTeamSize() || getPlayer().isInMultiplayer() || (teamInfo = getTeams().get(Integer.valueOf(teamId))) == null)) {
            LinkedHashSet<Avatar> newTeam = new LinkedHashSet<>();
            for (Long aLong : list) {
                Avatar avatar = getPlayer().getAvatars().getAvatarByGuid(aLong.longValue());
                if (avatar != null && !newTeam.contains(avatar)) {
                    newTeam.add(avatar);
                } else {
                    return;
                }
            }
            teamInfo.getAvatars().clear();
            addAvatarsToTeam(teamInfo, newTeam);
        }
    }

    public void setupMpTeam(List<Long> list) {
        if (list.size() != 0 && list.size() <= getMaxTeamSize() && getPlayer().isInMultiplayer()) {
            TeamInfo teamInfo = getMpTeam();
            LinkedHashSet<Avatar> newTeam = new LinkedHashSet<>();
            for (Long aLong : list) {
                Avatar avatar = getPlayer().getAvatars().getAvatarByGuid(aLong.longValue());
                if (avatar != null && !newTeam.contains(avatar)) {
                    newTeam.add(avatar);
                } else {
                    return;
                }
            }
            teamInfo.getAvatars().clear();
            addAvatarsToTeam(teamInfo, newTeam);
        }
    }

    public void setupTemporaryTeam(List<List<Long>> guidList) {
        this.temporaryTeam = guidList.stream().map(list -> {
            if (list.size() == 0 || list.size() > getMaxTeamSize()) {
                return null;
            }
            LinkedHashSet<Avatar> newTeam = new LinkedHashSet<>();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Avatar avatar = getPlayer().getAvatars().getAvatarByGuid(((Long) it.next()).longValue());
                if (avatar == null || newTeam.contains(avatar)) {
                    return null;
                }
                newTeam.add(avatar);
            }
            return newTeam.stream().map((v0) -> {
                return v0.getAvatarId();
            }).toList();
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).map(TeamInfo::new).toList();
    }

    public void useTemporaryTeam(int index) {
        this.useTemporarilyTeamIndex = index;
        updateTeamEntities(null);
    }

    public void cleanTemporaryTeam() {
        if (this.useTemporarilyTeamIndex >= 0) {
            this.useTemporarilyTeamIndex = -1;
            this.temporaryTeam = null;
            updateTeamEntities(null);
        }
    }

    public synchronized void setCurrentTeam(int teamId) {
        TeamInfo teamInfo;
        if (!getPlayer().isInMultiplayer() && (teamInfo = getTeams().get(Integer.valueOf(teamId))) != null && teamInfo.getAvatars().size() != 0) {
            setCurrentTeamId(teamId);
            updateTeamEntities(new PacketChooseCurAvatarTeamRsp(teamId));
        }
    }

    public synchronized void setTeamName(int teamId, String teamName) {
        TeamInfo teamInfo = getTeams().get(Integer.valueOf(teamId));
        if (teamInfo != null) {
            teamInfo.setName(teamName);
            getPlayer().sendPacket(new PacketChangeTeamNameRsp(teamId, teamName));
        }
    }

    public synchronized void changeAvatar(long guid) {
        EntityAvatar oldEntity = getCurrentAvatarEntity();
        if (!(oldEntity == null || guid == oldEntity.getAvatar().getGuid())) {
            EntityAvatar newEntity = null;
            int index = -1;
            for (int i = 0; i < getActiveTeam().size(); i++) {
                if (guid == getActiveTeam().get(i).getAvatar().getGuid()) {
                    index = i;
                    newEntity = getActiveTeam().get(i);
                }
            }
            if (index >= 0 && newEntity != oldEntity) {
                setCurrentCharacterIndex(index);
                oldEntity.setMotionState(MotionStateOuterClass.MotionState.MOTION_STATE_STANDBY);
                getPlayer().getScene().replaceEntity(oldEntity, newEntity);
                getPlayer().sendPacket(new PacketChangeAvatarRsp(guid));
            }
        }
    }

    public void onAvatarDie(long dieGuid) {
        PlayerDieTypeOuterClass.PlayerDieType dieType = PlayerDieTypeOuterClass.PlayerDieType.PLAYER_DIE_TYPE_NONE;
        int killedBy = 0;
        EntityAvatar deadAvatar = getCurrentAvatarEntity();
        if (deadAvatar != null) {
            dieType = deadAvatar.getKilledType();
            killedBy = deadAvatar.getKilledBy();
        }
        if (dieType == null) {
            dieType = PlayerDieTypeOuterClass.PlayerDieType.PLAYER_DIE_TYPE_NONE;
        }
        try {
            Grasscutter.getLogger().info("Player die {} kill by {} with {}", Long.valueOf(dieGuid), Integer.valueOf(killedBy), dieType.name());
        } catch (Exception e) {
        }
        if (dieType == PlayerDieTypeOuterClass.PlayerDieType.PLAYER_DIE_TYPE_DRAWN || dieType == PlayerDieTypeOuterClass.PlayerDieType.PLAYER_DIE_TYPE_NONE) {
            getPlayer().sendPacket(new PacketWorldPlayerDieNotify(dieType, killedBy));
        } else {
            EntityAvatar replacement = null;
            int replaceIndex = -1;
            int i = 0;
            while (true) {
                if (i >= getActiveTeam().size()) {
                    break;
                }
                EntityAvatar entity = getActiveTeam().get(i);
                if (entity.isAlive()) {
                    replaceIndex = i;
                    replacement = entity;
                    break;
                }
                i++;
            }
            if (replacement == null) {
                getPlayer().sendPacket(new PacketWorldPlayerDieNotify(dieType, killedBy));
                new PlayerTeamDeathEvent(getPlayer(), getActiveTeam().get(getCurrentCharacterIndex())).call();
            } else {
                setCurrentCharacterIndex(replaceIndex);
                getPlayer().getScene().addEntity(replacement);
            }
        }
        getPlayer().sendPacket(new PacketAvatarDieAnimationEndRsp(dieGuid, 0));
    }

    public boolean reviveAvatar(Avatar avatar) {
        for (EntityAvatar entity : getActiveTeam()) {
            if (entity.getAvatar() == avatar) {
                if (entity.isAlive()) {
                    return false;
                }
                entity.setFightProperty(FightProperty.FIGHT_PROP_CUR_HP, 1.0f);
                getPlayer().sendPacket(new PacketAvatarFightPropUpdateNotify(entity.getAvatar(), FightProperty.FIGHT_PROP_CUR_HP));
                getPlayer().sendPacket(new PacketAvatarLifeStateChangeNotify(entity.getAvatar()));
                return true;
            }
        }
        return false;
    }

    public boolean healAvatar(Avatar avatar, int healRate, int healAmount) {
        for (EntityAvatar entity : getActiveTeam()) {
            if (entity.getAvatar() == avatar) {
                if (!entity.isAlive()) {
                    return false;
                }
                entity.setFightProperty(FightProperty.FIGHT_PROP_CUR_HP, (float) Math.min(((double) entity.getFightProperty(FightProperty.FIGHT_PROP_CUR_HP)) + (((double) (entity.getFightProperty(FightProperty.FIGHT_PROP_MAX_HP) * ((float) healRate))) / 100.0d) + (((double) ((float) healAmount)) / 100.0d), (double) entity.getFightProperty(FightProperty.FIGHT_PROP_MAX_HP)));
                getPlayer().sendPacket(new PacketAvatarFightPropUpdateNotify(entity.getAvatar(), FightProperty.FIGHT_PROP_CUR_HP));
                getPlayer().sendPacket(new PacketAvatarLifeStateChangeNotify(entity.getAvatar()));
                return true;
            }
        }
        return false;
    }

    public void respawnTeam() {
        this.player.getStaminaManager().stopSustainedStaminaHandler();
        for (EntityAvatar entity : getActiveTeam()) {
            entity.setFightProperty(FightProperty.FIGHT_PROP_CUR_HP, entity.getFightProperty(FightProperty.FIGHT_PROP_MAX_HP) * 0.4f);
            getPlayer().sendPacket(new PacketAvatarFightPropUpdateNotify(entity.getAvatar(), FightProperty.FIGHT_PROP_CUR_HP));
            getPlayer().sendPacket(new PacketAvatarLifeStateChangeNotify(entity.getAvatar()));
        }
        try {
            getPlayer().sendPacket(new PacketPlayerEnterSceneNotify(getPlayer(), EnterTypeOuterClass.EnterType.ENTER_TYPE_SELF, EnterReason.Revival, this.player.getSceneId(), getRespawnPosition()));
            this.player.getPosition().set(getRespawnPosition());
        } catch (Exception e) {
            getPlayer().sendPacket(new PacketPlayerEnterSceneNotify(getPlayer(), EnterTypeOuterClass.EnterType.ENTER_TYPE_SELF, EnterReason.Revival, 3, GameConstants.START_POSITION));
            this.player.getPosition().set(GameConstants.START_POSITION);
        }
        getPlayer().sendPacket(new BasePacket(PacketOpcodes.WorldPlayerReviveRsp));
    }

    public Position getRespawnPosition() {
        Position deathPos = getPlayer().getPosition();
        int sceneId = getPlayer().getSceneId();
        return getPlayer().getUnlockedScenePoints(sceneId).stream().map(pointId -> {
            return GameData.getScenePointEntryById(sceneId, pointId.intValue());
        }).filter(point -> {
            return point.getPointData().getType().equals("SceneTransPoint");
        }).min(Comparator.comparingDouble(pos -> {
            return Utils.getDist(pos.getPointData().getTranPos(), deathPos);
        })).get().getPointData().getTranPos();
    }

    public void saveAvatars() {
        for (EntityAvatar entity : getActiveTeam()) {
            entity.getAvatar().save();
        }
    }

    public void onPlayerLogin() {
        updateTeamResonances();
    }

    public synchronized void addNewCustomTeam() {
        if (this.teams.size() == 10) {
            this.player.sendPacket(new PacketAddCustomTeamRsp(RetcodeOuterClass.Retcode.RET_FAIL));
            return;
        }
        int id = -1;
        int i = 5;
        while (true) {
            if (i > 10) {
                break;
            } else if (!this.teams.keySet().contains(Integer.valueOf(i))) {
                id = i;
                break;
            } else {
                i++;
            }
        }
        this.teams.put(Integer.valueOf(id), new TeamInfo());
        this.player.sendPacket(new PacketCustomTeamListNotify(this.player));
        this.player.sendPacket(new PacketAddCustomTeamRsp());
    }

    public synchronized void removeCustomTeam(int id) {
        if (!this.teams.containsKey(Integer.valueOf(id))) {
            this.player.sendPacket(new PacketRemoveCustomTeamRsp(RetcodeOuterClass.Retcode.RET_FAIL, id));
        }
        this.teams.remove(Integer.valueOf(id));
        this.player.sendPacket(new PacketCustomTeamListNotify(this.player));
        this.player.sendPacket(new PacketRemoveCustomTeamRsp(id));
    }
}
