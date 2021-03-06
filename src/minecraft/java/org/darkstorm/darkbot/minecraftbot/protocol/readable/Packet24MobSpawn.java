package org.darkstorm.darkbot.minecraftbot.protocol.readable;

import java.io.*;

import org.darkstorm.darkbot.minecraftbot.protocol.*;
import org.darkstorm.darkbot.minecraftbot.util.IntHashMap;
import org.darkstorm.darkbot.minecraftbot.world.entity.*;

public class Packet24MobSpawn extends AbstractPacket implements ReadablePacket {
	public int entityId;

	public int xPosition, yPosition, zPosition;
	public int velocityX, velocityY, velocityZ;
	public byte yaw, pitch, headYaw;

	public int type;
	private IntHashMap<WatchableObject> metadata;

	public Packet24MobSpawn() {
	}

	public void readData(DataInputStream in) throws IOException {
		entityId = in.readInt();
		type = in.readByte() & 0xff;
		xPosition = in.readInt();
		yPosition = in.readInt();
		zPosition = in.readInt();
		yaw = in.readByte();
		pitch = in.readByte();
		headYaw = in.readByte();
		velocityX = in.readShort();
		velocityY = in.readShort();
		velocityZ = in.readShort();

		metadata = DataWatcher.readWatchableObjects(in);
	}

	public int getId() {
		return 24;
	}

	public IntHashMap<WatchableObject> getMetadata() {
		return metadata;
	}
}
