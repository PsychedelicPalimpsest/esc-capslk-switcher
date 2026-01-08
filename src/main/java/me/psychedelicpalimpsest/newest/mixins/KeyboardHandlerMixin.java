/**
 * Copyright (C) 2025 - PsychedelicPalimpsest
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package me.psychedelicpalimpsest.newest.mixins;

import net.minecraft.client.KeyboardHandler;
import net.minecraft.client.input.KeyEvent;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(KeyboardHandler.class)
public class KeyboardHandlerMixin {

    @ModifyVariable(
            method = "keyPress",
            at = @At("HEAD"),          // Must be HEAD for arguments
            argsOnly = true,           // Only target method parameters, not local vars
            index = 4                  // Parameter index (0 = 'this', 1 = first param)
    )
    public KeyEvent onKeyInput(KeyEvent value) {
        if (value.isEscape()) {
            value = new KeyEvent(GLFW.GLFW_KEY_CAPS_LOCK, value.scancode(), value.modifiers());
        } else if (value.input() == GLFW.GLFW_KEY_CAPS_LOCK) {
            value = new KeyEvent(GLFW.GLFW_KEY_ESCAPE, value.scancode(), value.modifiers());
        }

        return value;
    }



}
