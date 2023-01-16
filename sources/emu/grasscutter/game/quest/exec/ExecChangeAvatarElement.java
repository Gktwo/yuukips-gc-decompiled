package emu.grasscutter.game.quest.exec;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ElementType;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestExecHandler;

@QuestValue(QuestTrigger.QUEST_EXEC_CHANGE_AVATAR_ELEMET)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/exec/ExecChangeAvatarElement.class */
public class ExecChangeAvatarElement extends QuestExecHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestExecHandler
    public boolean execute(GameQuest quest, QuestData.QuestExecParam condition, String... paramStr) {
        ElementType targetElement = ElementType.getTypeByValue(Integer.parseInt(paramStr[0]));
        Player owner = quest.getOwner();
        Avatar mainAvatar = owner.getAvatars().getAvatarById(owner.getMainCharacterId());
        if (mainAvatar == null) {
            Grasscutter.getLogger().error("Failed to get main avatar for use {}", Integer.valueOf(quest.getOwner().getUid()));
            return false;
        }
        Grasscutter.getLogger().info("Changing avatar element to {} for quest {}", targetElement.name(), Integer.valueOf(quest.getSubQuestId()));
        return mainAvatar.changeElement(targetElement);
    }
}
