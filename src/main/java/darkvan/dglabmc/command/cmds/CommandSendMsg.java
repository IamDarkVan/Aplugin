package darkvan.dglabmc.command.cmds;

import darkvan.dglabmc.Client;
import darkvan.dglabmc.command.CmdException;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

import static darkvan.dglabmc.DGlabMC.clients;
import static darkvan.dglabmc.utils.ClientUtils.getClientById;
import static darkvan.dglabmc.utils.ClientUtils.isClientIdExist;

public class CommandSendMsg extends Command{
    public CommandSendMsg(@NotNull CommandSender sender, @NotNull String[] args, @Nullable String perm) {
        super(sender, args, 3, null, "/dglab send-msg <clientId> <message> -- 直接向app发送消息(可空格 不推荐使用)", perm);
    }

    @Override
    protected void errorHandle() throws CmdException {
        if (!isClientIdExist(args[1])) throw new CmdException("未找到客户端");
    }

    @Override
    protected void run() {
        getClientById(args[1]).output(String.join(" ",Arrays.copyOfRange(args, 2, length)));
        sender.sendMessage("已成功发送" + String.join(" ",Arrays.copyOfRange(args, 2, length)));
    }

    @Override
    public List<String> tabComplete() {
        if (length == 2) return clients.stream().map(Client::getClientId).toList();
        return null;
    }
}
