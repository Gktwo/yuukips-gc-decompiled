package emu.grasscutter.command.commands;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.config.ConfigContainer;
import emu.grasscutter.game.Account;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.utils.Language;
import emu.grasscutter.utils.Utils;
import java.util.List;
import java.util.Locale;

@Command(label = "language", usage = {"[<language code>]"}, aliases = {"lang"}, targetRequirement = Command.TargetRequirement.NONE)
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/LanguageCommand.class */
public final class LanguageCommand implements CommandHandler {
    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        String curLangCode;
        if (args.isEmpty()) {
            if (sender != null) {
                curLangCode = Utils.getLanguageCode(sender.getAccount().getLocale());
            } else {
                curLangCode = Grasscutter.getLanguage().getLanguageCode();
            }
            CommandHandler.sendMessage(sender, Language.translate(sender, "commands.language.current_language", curLangCode));
            return;
        }
        String langCode = args.get(0);
        Language languageInst = Grasscutter.getLanguage(langCode);
        String actualLangCode = languageInst.getLanguageCode();
        Locale locale = Locale.forLanguageTag(actualLangCode);
        if (sender != null) {
            Account account = sender.getAccount();
            account.setLocale(locale);
            account.save();
        } else {
            Grasscutter.setLanguage(languageInst);
            ConfigContainer config = Grasscutter.getConfig();
            config.language.language = locale;
            Grasscutter.saveConfig(config);
        }
        if (!langCode.equals(actualLangCode)) {
            CommandHandler.sendMessage(sender, Language.translate(sender, "commands.language.language_not_found", langCode));
        }
        CommandHandler.sendMessage(sender, Language.translate(sender, "commands.language.language_changed", actualLangCode));
    }
}
