package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.AvatarSkillData;
import emu.grasscutter.data.excels.AvatarSkillDepotData;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.utils.Language;
import java.util.List;
import org.jline.console.Printer;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;

@Command(label = "talent", usage = {"set <talentId> <level>", "(n|e|q|all) <level>", "getid"}, permission = "player.settalent", permissionTargeted = "player.settalent.others")
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/TalentCommand.class */
public final class TalentCommand implements CommandHandler {
    private void setTalentLevel(Player sender, Avatar avatar, int skillId, int newLevel) {
        if (avatar.setSkillLevel(skillId, newLevel)) {
            CommandHandler.sendTranslatedMessage(sender, "commands.talent.set_id", Integer.valueOf(skillId), Language.getTextMapKey(GameData.getAvatarSkillDataMap().get(skillId).getNameTextMapHash()), Integer.valueOf(newLevel));
        } else {
            CommandHandler.sendTranslatedMessage(sender, "commands.talent.out_of_range", new Object[0]);
        }
    }

    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        int skillId;
        if (args.size() < 1) {
            sendUsageMessage(sender, new String[0]);
            return;
        }
        Avatar avatar = targetPlayer.getTeamManager().getCurrentAvatarEntity().getAvatar();
        AvatarSkillDepotData skillDepot = avatar.getSkillDepot();
        if (skillDepot == null) {
            CommandHandler.sendTranslatedMessage(sender, "commands.talent.invalid_skill_id", new Object[0]);
            return;
        }
        String cmdSwitch = args.get(0).toLowerCase();
        char c = 65535;
        switch (cmdSwitch.hashCode()) {
            case 101:
                if (cmdSwitch.equals("e")) {
                    c = 3;
                    break;
                }
                break;
            case 110:
                if (cmdSwitch.equals("n")) {
                    c = 2;
                    break;
                }
                break;
            case 113:
                if (cmdSwitch.equals("q")) {
                    c = 4;
                    break;
                }
                break;
            case 96673:
                if (cmdSwitch.equals(Printer.ALL)) {
                    c = 5;
                    break;
                }
                break;
            case 113762:
                if (cmdSwitch.equals("set")) {
                    c = 1;
                    break;
                }
                break;
            case 98246385:
                if (cmdSwitch.equals("getid")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 1:
                if (args.size() < 3) {
                    sendUsageMessage(sender, new String[0]);
                    return;
                }
                try {
                    try {
                        setTalentLevel(sender, avatar, Integer.parseInt(args.get(1)), Integer.parseInt(args.get(2)));
                        return;
                    } catch (IndexOutOfBoundsException | NullPointerException | NumberFormatException e) {
                        CommandHandler.sendTranslatedMessage(sender, "commands.talent.invalid_level", new Object[0]);
                        return;
                    }
                } catch (IndexOutOfBoundsException | NullPointerException | NumberFormatException e2) {
                    CommandHandler.sendTranslatedMessage(sender, "commands.talent.invalid_skill_id", new Object[0]);
                    return;
                }
            case 2:
            case 3:
            case 4:
                if (args.size() < 2) {
                    sendUsageMessage(sender, new String[0]);
                    return;
                }
                try {
                    int newLevel = Integer.parseInt(args.get(1));
                    char c2 = 65535;
                    switch (cmdSwitch.hashCode()) {
                        case 101:
                            if (cmdSwitch.equals("e")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 113:
                            if (cmdSwitch.equals("q")) {
                                c2 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 1:
                            skillId = skillDepot.getSkills().get(1).intValue();
                            break;
                        case 2:
                            skillId = skillDepot.getEnergySkill();
                            break;
                        default:
                            skillId = skillDepot.getSkills().get(0).intValue();
                            break;
                    }
                    setTalentLevel(sender, avatar, skillId, newLevel);
                    return;
                } catch (IndexOutOfBoundsException | NullPointerException | NumberFormatException e3) {
                    CommandHandler.sendTranslatedMessage(sender, "commands.talent.invalid_level", new Object[0]);
                    return;
                }
            case 5:
                if (args.size() < 2) {
                    sendUsageMessage(sender, new String[0]);
                    return;
                }
                try {
                    int newLevel2 = Integer.parseInt(args.get(1));
                    if (newLevel2 < 1 || newLevel2 > 15) {
                        CommandHandler.sendTranslatedMessage(sender, "commands.talent.out_of_range", new Object[0]);
                        return;
                    } else {
                        skillDepot.getSkillsAndEnergySkill().forEach(id -> {
                            setTalentLevel(sender, sender, newLevel2, avatar);
                        });
                        return;
                    }
                } catch (NumberFormatException e4) {
                    CommandHandler.sendTranslatedMessage(sender, "commands.talent.invalid_level", new Object[0]);
                    return;
                }
            case 6:
                Int2ObjectMap<AvatarSkillData> map = GameData.getAvatarSkillDataMap();
                skillDepot.getSkillsAndEnergySkill().forEach(id -> {
                    AvatarSkillData talent = (AvatarSkillData) map.get(id);
                    if (talent != null) {
                        CommandHandler.sendTranslatedMessage(sender, "commands.talent.id_desc", Integer.valueOf(id), Language.getTextMapKey(talent.getNameTextMapHash()), Language.getTextMapKey(talent.getDescTextMapHash()));
                    }
                });
                return;
            default:
                sendUsageMessage(sender, new String[0]);
                return;
        }
    }
}
