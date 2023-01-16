package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ClimateType;
import java.util.List;

@Command(label = "weather", aliases = {"w"}, usage = {"weather [<weatherId>] [<climateType>]"}, permission = "player.weather", permissionTargeted = "player.weather.others")
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/WeatherCommand.class */
public final class WeatherCommand implements CommandHandler {
    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        int weatherId = targetPlayer.getWeatherId();
        ClimateType climate = ClimateType.CLIMATE_NONE;
        if (args.isEmpty()) {
            CommandHandler.sendTranslatedMessage(sender, "commands.weather.status", Integer.valueOf(weatherId), targetPlayer.getClimate().getShortName());
            return;
        }
        for (String arg : args) {
            ClimateType c = ClimateType.getTypeByShortName(arg.toLowerCase());
            if (c != ClimateType.CLIMATE_NONE) {
                climate = c;
            } else {
                try {
                    weatherId = Integer.parseInt(arg);
                } catch (IndexOutOfBoundsException | NullPointerException | NumberFormatException e) {
                    CommandHandler.sendTranslatedMessage(sender, "commands.generic.invalid.id", new Object[0]);
                    sendUsageMessage(sender, new String[0]);
                    return;
                }
            }
        }
        targetPlayer.setWeather(weatherId, climate);
        CommandHandler.sendTranslatedMessage(sender, "commands.weather.success", Integer.valueOf(weatherId), targetPlayer.getClimate().getShortName());
    }
}
