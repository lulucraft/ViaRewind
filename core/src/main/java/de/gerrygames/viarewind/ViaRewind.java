package de.gerrygames.viarewind;

import de.gerrygames.viarewind.api.ViaRewindConfig;
import de.gerrygames.viarewind.api.ViaRewindPlatform;
import lombok.Getter;

public class ViaRewind {
	@Getter
	private static ViaRewindPlatform platform;
	@Getter
	private static ViaRewindConfig config;

	public static void init(ViaRewindPlatform platform, ViaRewindConfig config) {
		ViaRewind.platform = platform;
		ViaRewind.config = config;
	}

	public static ViaRewindPlatform getPlatform() {
		return platform;
	}

	public static ViaRewindConfig getConfig() {
		return config;
	}

}
