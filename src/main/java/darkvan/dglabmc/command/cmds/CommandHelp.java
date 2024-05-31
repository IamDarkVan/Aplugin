package darkvan.dglabmc.command.cmds;

import darkvan.dglabmc.command.CmdException;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static darkvan.dglabmc.utils.CommandUtils.sendHelp;


public class CommandHelp extends Command {

    public CommandHelp(@NotNull CommandSender sender, @NotNull String[] args) {
        super("help", sender, args, null, null, "/dglab help -- 显示帮助", "dglab.help");
    }

    @Override
    protected void errorHandle() throws CmdException {
    }

    @Override
    protected void run() {
        sendHelp(sender);
    }

    @Override
    public List<String> tabComplete() {
        return null;
    }
}
