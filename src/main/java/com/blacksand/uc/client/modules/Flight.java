package com.blacksand.uc.client.modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public class Flight {

    private static int MAX_SPEED = 3;

    private static int toggle = 0;
    private static double FALL_SPEED = -0.04;
    private static double acceleration = 0.1;

    public static void Tick(MinecraftClient client) {
        if(client.player != null && Modules.flightEnabled) {
            boolean jmpPressed = client.options.jumpKey.isPressed();
            boolean fwrdPressed = client.options.forwardKey.isPressed();
            boolean lftPressed = client.options.leftKey.isPressed();
            boolean rghtPressed = client.options.rightKey.isPressed();
            boolean backPressed = client.options.backKey.isPressed();

            Entity target = client.player;
            if(client.player.hasVehicle()) {
                target = client.player.getVehicle();
            }

            Vec3d velocity = target.getVelocity();
            Vec3d newVelocity = new Vec3d(velocity.x, -FALL_SPEED, velocity.z);

            if(jmpPressed) {
                if(fwrdPressed) {
                    newVelocity = client.player.getRotationVector().multiply(acceleration);
                }

                if(lftPressed && !client.player.hasVehicle()) {
                    newVelocity = client.player.getRotationVector().multiply(acceleration).rotateY((float) (-270*(Math.PI/180)));
                    newVelocity = new Vec3d(newVelocity.x, 0, newVelocity.z);
                }

                if(rghtPressed && !client.player.hasVehicle()) {
                    newVelocity = client.player.getRotationVector().multiply(acceleration).rotateY((float) (270*(Math.PI/180)));
                    newVelocity = new Vec3d(newVelocity.x, 0, newVelocity.z);
                }

                if(backPressed) {
                    newVelocity = client.player.getRotationVector().negate().multiply(acceleration);
                }

                newVelocity = new Vec3d(newVelocity.x, (toggle == 0 && newVelocity.y > FALL_SPEED) ? FALL_SPEED : newVelocity.y, newVelocity.z);
                target.setVelocity(newVelocity);

                if(fwrdPressed || lftPressed || rghtPressed || backPressed) {
                    acceleration += acceleration < MAX_SPEED ? 0.1 : 0.0;
                } else if(acceleration > 0.2) {
                    acceleration -= 0.2;
                }
            }

            if(toggle == 0 || newVelocity.y <= -0.04) {
                toggle = 40;
            }
            toggle--;
        }
    }
}
