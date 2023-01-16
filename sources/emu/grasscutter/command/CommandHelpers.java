package emu.grasscutter.command;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;

/* loaded from: grasscutter.jar:emu/grasscutter/command/CommandHelpers.class */
public class CommandHelpers {
    public static final Pattern lvlRegex = Pattern.compile("(?<!\\w)l(?:vl?)?(\\d+)");
    public static final Pattern amountRegex = Pattern.compile("((?<=(?<!\\w)x)\\d+|\\d+(?=x)(?!x\\d))");
    public static final Pattern refineRegex = Pattern.compile("(?<!\\w)r(\\d+)");
    public static final Pattern rankRegex = Pattern.compile("(\\d+)\\*");
    public static final Pattern constellationRegex = Pattern.compile("(?<!\\w)c(\\d+)");
    public static final Pattern skillLevelRegex = Pattern.compile("sl(\\d+)");
    public static final Pattern stateRegex = Pattern.compile("state(\\d+)");
    public static final Pattern blockRegex = Pattern.compile("blk(\\d+)");
    public static final Pattern groupRegex = Pattern.compile("grp(\\d+)");
    public static final Pattern configRegex = Pattern.compile("cfg(\\d+)");
    public static final Pattern hpRegex = Pattern.compile("(?<!\\w)hp(\\d+)");
    public static final Pattern maxHPRegex = Pattern.compile("maxhp(\\d+)");
    public static final Pattern atkRegex = Pattern.compile("atk(\\d+)");
    public static final Pattern defRegex = Pattern.compile("def(\\d+)");
    public static final Pattern aiRegex = Pattern.compile("ai(\\d+)");

    public static int matchIntOrNeg(Pattern pattern, String arg) {
        Matcher match = pattern.matcher(arg);
        if (!match.find()) {
            return -1;
        }
        try {
            return Integer.parseInt(match.group(1));
        } catch (Exception e) {
            return -1;
        }
    }

    public static <T> List<String> parseIntParameters(List<String> args, @Nonnull T params, Map<Pattern, BiConsumer<T, Integer>> map) {
        args.removeIf(arg -> {
            String argL = arg.toLowerCase();
            boolean deleteArg = false;
            for (Map.Entry entry : map.entrySet()) {
                int argNum = matchIntOrNeg((Pattern) entry.getKey(), argL);
                if (argNum != -1) {
                    ((BiConsumer) entry.getValue()).accept(params, Integer.valueOf(argNum));
                    deleteArg = true;
                }
            }
            return deleteArg;
        });
        return args;
    }
}
