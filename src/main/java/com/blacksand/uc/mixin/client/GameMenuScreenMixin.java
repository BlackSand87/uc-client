package com.blacksand.uc.mixin.client;

import com.blacksand.uc.client.gui.screen.ModuleScreen;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public class GameMenuScreenMixin extends Screen {
    protected GameMenuScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "initWidgets", at = @At("HEAD"))
    public void initWidgets(CallbackInfo ci) {
        this.addDrawableChild(new ButtonWidget(10,10,70,20,Text.translatable("Modules"), (button) -> {
            this.client.setScreen(new ModuleScreen(this, this.client.options));
        }));
    }
}
