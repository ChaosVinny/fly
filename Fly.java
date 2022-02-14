# EXAMPLE:

#package me.netclient.module.modules.movement;

#import org.lwjgl.input.Keyboard;

#import me.netclient.event.events.UpdateEvent;
#import me.netclient.baseclient.module.AntiCheat;
#import me.netclient.baseclient.module.Category;
#import me.netclient.baseclient.module.Module;

public class Fly extends Module {

	public Fly() { 
#Change With what do you want		super("Fly", "VOLAH", Keyboard.KEY_F, Category.MOVEMENT);
	}

	private boolean isFlying;
	private boolean allowFlying;

	@Override
	public void setup() {
		moduleSettings.addDefault("speed", 1.0D);
	}

	@Override
	public void onEnable() {
		this.isFlying = mc.thePlayer.capabilities.isFlying;
		this.allowFlying = mc.thePlayer.capabilities.allowFlying;

		mc.thePlayer.capabilities.allowFlying = true;
	}

	@Override
	public void onDisable() {
		mc.thePlayer.capabilities.allowFlying = allowFlying;
		mc.thePlayer.capabilities.isFlying = isFlying;
	}

	@Override
	public void onUpdate(UpdateEvent event) {
		double speed = moduleSettings.getDouble("speed");

		speed = speed * 2;

		mc.thePlayer.capabilities.isFlying = true;
	}

}