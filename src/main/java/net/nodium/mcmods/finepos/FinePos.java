package net.nodium.mcmods.finepos;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class FinePos implements ModInitializer {
	private static KeyBinding kb_up;
	private static KeyBinding kb_down;
	private static KeyBinding kb_left;
	private static KeyBinding kb_right;

    @Override
    public void onInitialize() {
		kb_up = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.finepos.up",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_UP,
				"category.finepos.arrowkeys"
		));
		kb_down = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.finepos.down",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_DOWN,
				"category.finepos.arrowkeys"
		));
		kb_left = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.finepos.left",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_LEFT,
				"category.finepos.arrowkeys"
		));
		kb_right = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.finepos.right",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_RIGHT,
				"category.finepos.arrowkeys"
		));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (kb_up.wasPressed()) {
				client.player.pitch -= 0.15;
			}
			while (kb_down.wasPressed()) {
				client.player.pitch += 0.15;
			}
			while (kb_left.wasPressed()) {
				client.player.yaw -= 0.15;
			}
			while (kb_right.wasPressed()) {
				client.player.yaw += 0.15;
			}
		});
    }
}
