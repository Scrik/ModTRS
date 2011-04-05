package yetanotherx.bukkitplugin.ModTRS.command;

import java.sql.SQLException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import yetanotherx.bukkitplugin.ModTRS.ModTRS;
import yetanotherx.bukkitplugin.ModTRS.ModTRSMessage;
import yetanotherx.bukkitplugin.ModTRS.sql.ModTRSRequest;
import yetanotherx.bukkitplugin.ModTRS.sql.ModTRSUser;
import yetanotherx.bukkitplugin.ModTRS.sql.ModTRSUserTable;

public class ModreqCommand implements CommandExecutor {

    public ModreqCommand(ModTRS parent) {
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {

	String[] split = args;
	String joined = CommandHandler.implode(split, " ");
	Player player = (Player) sender;

	try {
	    ModTRSUser user = ModTRSUserTable.getUserFromName(player.getName());

	    if( user == null ) {
		user = new ModTRSUser();
		user.setName(player.getName());
		user.insert();
		user = ModTRSUserTable.getUserFromName(player.getName());
	    }

	    ModTRSRequest request = new ModTRSRequest();

	    request.setUserId(user.getId());
	    request.setText(joined);
	    request.setTimestamp(System.currentTimeMillis());
	    request.setWorld(player.getWorld().getName());
	    request.setX(player.getLocation().getBlockX());
	    request.setY(player.getLocation().getBlockY());
	    request.setZ(player.getLocation().getBlockZ());
	    request.insert();
	    player.sendMessage( ModTRSMessage.messageSent );

	    //TODO: Error checking
	}
	catch( SQLException e ) {
	    e.printStackTrace();
	    player.sendMessage( ModTRSMessage.messageNotSent );
	}

	return true;

    }

}
