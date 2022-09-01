package com.blacksand.uc.client.gui.screen;

import com.blacksand.uc.client.UCClient;
import com.blacksand.uc.client.modules.Modules;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.text.Text;

public class ModuleScreen extends Screen {

    private Screen parent;
    private GameOptions options;

    public ModuleScreen(Screen parent, GameOptions options) {
        super(Text.literal("Modules"));

        this.parent = parent;
        this.options = options;
    }

    public void init() {
        this.addDrawableChild(new ButtonWidget(10, 20, 80, 20, Modules.xrayEnabled ? Text.literal("X-Ray: On") : Text.literal("X-Ray: Off"), button -> {
            Modules.xrayEnabled = !Modules.xrayEnabled;
            button.setMessage(Modules.xrayEnabled ? Text.literal("X-Ray: On") : Text.literal("X-Ray: Off"));
            UCClient.defaultGamma = options.getGamma().getValue().equals(1000.0) ? UCClient.defaultGamma : options.getGamma().getValue();
            options.getGamma().setValue(Modules.xrayEnabled ? 1000.0 : UCClient.defaultGamma);
            client.worldRenderer.reload();
        }));

        this.addDrawableChild(new ButtonWidget(10, 50, 80, 20, Modules.fullbrightEnabled ? Text.literal("Fullbright: On") : Text.literal("Fullbright: Off"), button -> {
            Modules.fullbrightEnabled = !Modules.fullbrightEnabled;
            button.setMessage(Modules.fullbrightEnabled ? Text.literal("Fullbright: On") : Text.literal("Fullbright: Off"));
            if(Modules.fullbrightEnabled) {
                client.player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, Integer.MAX_VALUE));
            } else {
                client.player.removeStatusEffect(StatusEffects.NIGHT_VISION);
            }
        }));

        this.addDrawableChild(new ButtonWidget(10,80,80,20, Modules.flightEnabled ? Text.literal("Flight: On") : Text.literal("Flight: Off"),button -> {
            Modules.flightEnabled = !Modules.flightEnabled;
            button.setMessage(Modules.flightEnabled ? Text.literal("Flight: On") : Text.literal("Flight: Off"));
        }));
    }
}