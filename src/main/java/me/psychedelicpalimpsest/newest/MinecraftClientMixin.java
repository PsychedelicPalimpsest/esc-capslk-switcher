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

package me.psychedelicpalimpsest.newest;

 import me.psychedelicpalimpsest.KeyboardOverride;
 import net.minecraft.client.Keyboard;
 import net.minecraft.client.MinecraftClient;
 import org.spongepowered.asm.mixin.Mixin;
 import org.spongepowered.asm.mixin.injection.At;
 import org.spongepowered.asm.mixin.injection.Redirect;

 @Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

     @Redirect(
             method = "<init>",
             at = @At(value = "NEW", target = "net/minecraft/client/Keyboard")
     )
     private Keyboard redirectKeyboard(MinecraftClient client) {
         return new KeyboardOverride(client);
     }
}
