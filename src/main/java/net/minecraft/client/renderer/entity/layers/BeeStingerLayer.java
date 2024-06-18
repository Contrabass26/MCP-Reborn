package net.minecraft.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BeeStingerLayer<T extends LivingEntity, M extends PlayerModel<T>> extends StuckInBodyLayer<T, M> {
    private static final ResourceLocation BEE_STINGER_LOCATION = ResourceLocation.withDefaultNamespace("textures/entity/bee/bee_stinger.png");

    public BeeStingerLayer(LivingEntityRenderer<T, M> p_116580_) {
        super(p_116580_);
    }

    @Override
    protected int numStuck(T p_116582_) {
        return p_116582_.getStingerCount();
    }

    @Override
    protected void renderStuckItem(
        PoseStack p_116584_, MultiBufferSource p_116585_, int p_116586_, Entity p_116587_, float p_116588_, float p_116589_, float p_116590_, float p_116591_
    ) {
        float f = Mth.sqrt(p_116588_ * p_116588_ + p_116590_ * p_116590_);
        float f1 = (float)(Math.atan2((double)p_116588_, (double)p_116590_) * 180.0F / (float)Math.PI);
        float f2 = (float)(Math.atan2((double)p_116589_, (double)f) * 180.0F / (float)Math.PI);
        p_116584_.translate(0.0F, 0.0F, 0.0F);
        p_116584_.mulPose(Axis.YP.rotationDegrees(f1 - 90.0F));
        p_116584_.mulPose(Axis.ZP.rotationDegrees(f2));
        float f3 = 0.0F;
        float f4 = 0.125F;
        float f5 = 0.0F;
        float f6 = 0.0625F;
        float f7 = 0.03125F;
        p_116584_.mulPose(Axis.XP.rotationDegrees(45.0F));
        p_116584_.scale(0.03125F, 0.03125F, 0.03125F);
        p_116584_.translate(2.5F, 0.0F, 0.0F);
        VertexConsumer vertexconsumer = p_116585_.getBuffer(RenderType.entityCutoutNoCull(BEE_STINGER_LOCATION));

        for (int i = 0; i < 4; i++) {
            p_116584_.mulPose(Axis.XP.rotationDegrees(90.0F));
            PoseStack.Pose posestack$pose = p_116584_.last();
            vertex(vertexconsumer, posestack$pose, -4.5F, -1, 0.0F, 0.0F, p_116586_);
            vertex(vertexconsumer, posestack$pose, 4.5F, -1, 0.125F, 0.0F, p_116586_);
            vertex(vertexconsumer, posestack$pose, 4.5F, 1, 0.125F, 0.0625F, p_116586_);
            vertex(vertexconsumer, posestack$pose, -4.5F, 1, 0.0F, 0.0625F, p_116586_);
        }
    }

    private static void vertex(
        VertexConsumer p_254470_, PoseStack.Pose p_336218_, float p_253749_, int p_254520_, float p_254099_, float p_253914_, int p_254168_
    ) {
        p_254470_.addVertex(p_336218_, p_253749_, (float)p_254520_, 0.0F)
            .setColor(-1)
            .setUv(p_254099_, p_253914_)
            .setOverlay(OverlayTexture.NO_OVERLAY)
            .setLight(p_254168_)
            .setNormal(p_336218_, 0.0F, 1.0F, 0.0F);
    }
}