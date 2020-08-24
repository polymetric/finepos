package net.nodium.mcmods.mcah_fine_rotations;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.LiteralText;
import org.lwjgl.glfw.GLFW;

public class FineRotations implements ModInitializer {
	private static KeyBinding kb_up;
	private static KeyBinding kb_down;
	private static KeyBinding kb_left;
	private static KeyBinding kb_right;

    @Override
    public void onInitialize() {
		kb_up = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.mcah_fine_rotations.up",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_UP,
				"category.mcah_fine_rotations.arrowkeys"
		));
		kb_down = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.mcah_fine_rotations.down",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_DOWN,
				"category.mcah_fine_rotations.arrowkeys"
		));
		kb_left = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.mcah_fine_rotations.left",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_LEFT,
				"category.mcah_fine_rotations.arrowkeys"
		));
		kb_right = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.mcah_fine_rotations.right",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_RIGHT,
				"category.mcah_fine_rotations.arrowkeys"
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
