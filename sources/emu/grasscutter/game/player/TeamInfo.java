package emu.grasscutter.game.player;

import dev.morphia.annotations.Entity;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.net.proto.AvatarTeamOuterClass;
import java.util.ArrayList;
import java.util.List;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/game/player/TeamInfo.class */
public class TeamInfo {
    private String name;
    private List<Integer> avatars;

    public TeamInfo() {
        this.name = "";
        this.avatars = new ArrayList(Configuration.GAME_OPTIONS.avatarLimits.singlePlayerTeam);
    }

    public TeamInfo(List<Integer> avatars) {
        this.name = "";
        this.avatars = avatars;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getAvatars() {
        return this.avatars;
    }

    public int size() {
        return this.avatars.size();
    }

    public boolean contains(Avatar avatar) {
        return getAvatars().contains(Integer.valueOf(avatar.getAvatarId()));
    }

    public boolean addAvatar(Avatar avatar) {
        if (contains(avatar)) {
            return false;
        }
        getAvatars().add(Integer.valueOf(avatar.getAvatarId()));
        return true;
    }

    public boolean removeAvatar(int slot) {
        if (size() <= 1) {
            return false;
        }
        getAvatars().remove(slot);
        return true;
    }

    public void copyFrom(TeamInfo team) {
        copyFrom(team, Configuration.GAME_OPTIONS.avatarLimits.singlePlayerTeam);
    }

    public void copyFrom(TeamInfo team, int maxTeamSize) {
        List<Integer> avatarIds = new ArrayList<>(team.getAvatars());
        getAvatars().clear();
        int len = Math.min(avatarIds.size(), maxTeamSize);
        for (int i = 0; i < len; i++) {
            getAvatars().add(Integer.valueOf(avatarIds.get(i).intValue()));
        }
    }

    public AvatarTeamOuterClass.AvatarTeam toProto(Player player) {
        AvatarTeamOuterClass.AvatarTeam.Builder avatarTeam = AvatarTeamOuterClass.AvatarTeam.newBuilder().setTeamName(getName());
        for (int i = 0; i < getAvatars().size(); i++) {
            avatarTeam.addAvatarGuidList(player.getAvatars().getAvatarById(getAvatars().get(i).intValue()).getGuid());
        }
        return avatarTeam.build();
    }
}
