package org.darkstorm.darkbot.mcspambot.commands;

import org.darkstorm.darkbot.mcspambot.MinecraftBotWrapper;
import org.darkstorm.darkbot.minecraftbot.protocol.bidirectional.Packet255KickDisconnect;

public class QuitCommand extends AbstractCommand {

	public QuitCommand(MinecraftBotWrapper bot) {
		super(bot, "quit", "Leave the server");
	}

	@Override
	public void execute(String[] args) {
		controller.say("Leaving!");
		bot.getConnectionHandler().sendPacket(
				new Packet255KickDisconnect("Quit"));
	}
}
