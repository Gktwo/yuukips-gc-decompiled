package emu.grasscutter.command.commands;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.database.DatabaseHelper;
import emu.grasscutter.game.mail.Mail;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.utils.Language;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import org.jline.console.Printer;

@Command(label = "sendMail", usage = {"(<userId>|all) [<templateId>]", "help"}, permission = "server.sendmail", targetRequirement = Command.TargetRequirement.NONE)
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/SendMailCommand.class */
public final class SendMailCommand implements CommandHandler {
    private static final HashMap<Integer, MailBuilder> mailBeingConstructed = new HashMap<>();

    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        int senderId;
        MailBuilder mailBuilder;
        if (sender != null) {
            senderId = sender.getUid();
        } else {
            senderId = -1;
        }
        if (!mailBeingConstructed.containsKey(Integer.valueOf(senderId))) {
            switch (args.size()) {
                case 1:
                    String lowerCase = args.get(0).toLowerCase();
                    char c = 65535;
                    switch (lowerCase.hashCode()) {
                        case 96673:
                            if (lowerCase.equals(Printer.ALL)) {
                                c = 1;
                                break;
                            }
                            break;
                        case 3198785:
                            if (lowerCase.equals("help")) {
                                c = 0;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            sendUsageMessage(sender, new String[0]);
                            return;
                        case 1:
                            mailBuilder = new MailBuilder(true, new Mail());
                            break;
                        default:
                            if (DatabaseHelper.getPlayerByUid(Integer.parseInt(args.get(0))) != null) {
                                mailBuilder = new MailBuilder(Integer.parseInt(args.get(0)), new Mail());
                                break;
                            } else {
                                CommandHandler.sendMessage(sender, Language.translate(sender, "commands.sendMail.user_not_exist", args.get(0)));
                                return;
                            }
                    }
                    mailBeingConstructed.put(Integer.valueOf(senderId), mailBuilder);
                    CommandHandler.sendMessage(sender, Language.translate(sender, "commands.sendMail.start_composition", new Object[0]));
                    return;
                case 2:
                    CommandHandler.sendMessage(sender, Language.translate(sender, "commands.sendMail.templates", new Object[0]));
                    return;
                default:
                    CommandHandler.sendMessage(sender, Language.translate(sender, "commands.sendMail.invalid_arguments", new Object[0]));
                    return;
            }
        } else {
            MailBuilder mailBuilder2 = mailBeingConstructed.get(Integer.valueOf(senderId));
            if (args.size() >= 1) {
                String lowerCase2 = args.get(0).toLowerCase();
                char c2 = 65535;
                switch (lowerCase2.hashCode()) {
                    case -1274442605:
                        if (lowerCase2.equals("finish")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 3198785:
                        if (lowerCase2.equals("help")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 3540994:
                        if (lowerCase2.equals("stop")) {
                            c2 = 0;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        mailBeingConstructed.remove(Integer.valueOf(senderId));
                        CommandHandler.sendMessage(sender, Language.translate(sender, "commands.sendMail.send_cancel", new Object[0]));
                        return;
                    case 1:
                        if (mailBuilder2.constructionStage == 3) {
                            if (!mailBuilder2.sendToAll) {
                                Grasscutter.getGameServer().getPlayerByUid(mailBuilder2.recipient, true).sendMail(mailBuilder2.mail);
                                CommandHandler.sendMessage(sender, Language.translate(sender, "commands.sendMail.send_done", Integer.valueOf(mailBuilder2.recipient)));
                            } else {
                                DatabaseHelper.getByGameClass(Player.class).forEach(player -> {
                                    ((Player) Objects.requireNonNullElse(Grasscutter.getGameServer().getPlayerByUid(player.getUid(), false), player)).sendMail(mailBuilder2.mail);
                                });
                                CommandHandler.sendMessage(sender, Language.translate(sender, "commands.sendMail.send_all_done", new Object[0]));
                            }
                            mailBeingConstructed.remove(Integer.valueOf(senderId));
                            return;
                        }
                        CommandHandler.sendMessage(sender, Language.translate(sender, "commands.sendMail.not_composition_end", getConstructionArgs(mailBuilder2.constructionStage, sender)));
                        return;
                    case 2:
                        CommandHandler.sendMessage(sender, Language.translate(sender, "commands.sendMail.please_use", getConstructionArgs(mailBuilder2.constructionStage, sender)));
                        return;
                    default:
                        switch (mailBuilder2.constructionStage) {
                            case 0:
                                String title = String.join(" ", args.subList(0, args.size()));
                                mailBuilder2.mail.mailContent.title = title;
                                CommandHandler.sendMessage(sender, Language.translate(sender, "commands.sendMail.set_title", title));
                                mailBuilder2.constructionStage++;
                                return;
                            case 1:
                                String contents = String.join(" ", args.subList(0, args.size()));
                                mailBuilder2.mail.mailContent.content = contents;
                                CommandHandler.sendMessage(sender, Language.translate(sender, "commands.sendMail.set_contents", contents));
                                mailBuilder2.constructionStage++;
                                return;
                            case 2:
                                String msgSender = String.join(" ", args.subList(0, args.size()));
                                mailBuilder2.mail.mailContent.sender = msgSender;
                                CommandHandler.sendMessage(sender, Language.translate(sender, "commands.sendMail.set_message_sender", msgSender));
                                mailBuilder2.constructionStage++;
                                return;
                            case 3:
                                int lvl = 1;
                                int amount = 1;
                                switch (args.size()) {
                                    case 1:
                                        try {
                                            int item = Integer.parseInt(args.get(0));
                                            mailBuilder2.mail.itemList.add(new Mail.MailItem(item, amount, lvl));
                                            CommandHandler.sendMessage(sender, Language.translate(sender, "commands.sendMail.send", Integer.valueOf(amount), Integer.valueOf(item), Integer.valueOf(lvl)));
                                            return;
                                        } catch (IndexOutOfBoundsException | NullPointerException | NumberFormatException e) {
                                            CommandHandler.sendMessage(sender, Language.translate(sender, "commands.generic.invalid.itemId", new Object[0]));
                                            return;
                                        }
                                    case 2:
                                        try {
                                            amount = Integer.parseInt(args.get(1));
                                            int item = Integer.parseInt(args.get(0));
                                            mailBuilder2.mail.itemList.add(new Mail.MailItem(item, amount, lvl));
                                            CommandHandler.sendMessage(sender, Language.translate(sender, "commands.sendMail.send", Integer.valueOf(amount), Integer.valueOf(item), Integer.valueOf(lvl)));
                                            return;
                                        } catch (IndexOutOfBoundsException | NullPointerException | NumberFormatException e2) {
                                            CommandHandler.sendMessage(sender, Language.translate(sender, "commands.generic.invalid.amount", new Object[0]));
                                            return;
                                        }
                                    case 3:
                                        try {
                                            lvl = Integer.parseInt(args.get(2));
                                            amount = Integer.parseInt(args.get(1));
                                            int item = Integer.parseInt(args.get(0));
                                            mailBuilder2.mail.itemList.add(new Mail.MailItem(item, amount, lvl));
                                            CommandHandler.sendMessage(sender, Language.translate(sender, "commands.sendMail.send", Integer.valueOf(amount), Integer.valueOf(item), Integer.valueOf(lvl)));
                                            return;
                                        } catch (IndexOutOfBoundsException | NullPointerException | NumberFormatException e3) {
                                            CommandHandler.sendMessage(sender, Language.translate(sender, "commands.generic.invalid.itemLevel", new Object[0]));
                                            return;
                                        }
                                    case 4:
                                        try {
                                            Integer.parseInt(args.get(3));
                                            lvl = Integer.parseInt(args.get(2));
                                            amount = Integer.parseInt(args.get(1));
                                            int item = Integer.parseInt(args.get(0));
                                            mailBuilder2.mail.itemList.add(new Mail.MailItem(item, amount, lvl));
                                            CommandHandler.sendMessage(sender, Language.translate(sender, "commands.sendMail.send", Integer.valueOf(amount), Integer.valueOf(item), Integer.valueOf(lvl)));
                                            return;
                                        } catch (IndexOutOfBoundsException | NullPointerException | NumberFormatException e4) {
                                            CommandHandler.sendMessage(sender, Language.translate(sender, "commands.generic.invalid.itemRefinement", new Object[0]));
                                            return;
                                        }
                                    default:
                                        CommandHandler.sendTranslatedMessage(sender, "commands.sendMail.give_usage", new Object[0]);
                                        return;
                                }
                            default:
                                return;
                        }
                }
            } else {
                CommandHandler.sendMessage(sender, Language.translate(sender, "commands.sendMail.invalid_arguments_please_use", getConstructionArgs(mailBuilder2.constructionStage, sender)));
            }
        }
    }

    private String getConstructionArgs(int stage, Player sender) {
        switch (stage) {
            case 0:
                return Language.translate(sender, "commands.sendMail.title", new Object[0]);
            case 1:
                return Language.translate(sender, "commands.sendMail.message", new Object[0]);
            case 2:
                return Language.translate(sender, "commands.sendMail.sender", new Object[0]);
            case 3:
                return Language.translate(sender, "commands.sendMail.arguments", new Object[0]);
            default:
                return Language.translate(sender, "commands.sendMail.error", Integer.valueOf(stage));
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/SendMailCommand$MailBuilder.class */
    public static class MailBuilder {
        public int recipient;
        public boolean sendToAll;
        public int constructionStage;
        public Mail mail;

        public MailBuilder(int recipient, Mail mail) {
            this.recipient = recipient;
            this.sendToAll = false;
            this.constructionStage = 0;
            this.mail = mail;
        }

        public MailBuilder(boolean sendToAll, Mail mail) {
            if (sendToAll) {
                this.recipient = 0;
                this.sendToAll = true;
                this.constructionStage = 0;
                this.mail = mail;
                return;
            }
            Grasscutter.getLogger().error("Please use MailBuilder(int, mail) when not sending to all");
        }
    }
}
