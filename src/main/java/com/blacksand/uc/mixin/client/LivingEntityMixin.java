package com.blacksand.uc.mixin.client;

import com.blacksand.uc.client.modules.Modules;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Inject(method = "removeStatusEffect", at = @At("HEAD"), cancellable = true)
    public void removeStatusEffect(StatusEffect type, CallbackInfoReturnable<Boolean> cir) {
        if((ClientPlayerEntity)(Object)this != null) {
            if(Modules.fullbrightEnabled && type.equals(StatusEffects.NIGHT_VISION)) {
                cir.setReturnValue(true);
            }
        }
    }
}
