// Date: 2/16/2013 6:26:20 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX


package com.pixelutilities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTV extends ModelBase {
    //fields
    ModelRenderer FrontLeft;
    ModelRenderer SideRightTop;
    ModelRenderer SideLeft;
    ModelRenderer Front;
    ModelRenderer FrontRight;
    ModelRenderer Top1;
    ModelRenderer BaseRight;
    ModelRenderer Back1;
    ModelRenderer FrontTop;
    ModelRenderer Top2;
    ModelRenderer BaseLeft;
    ModelRenderer SideLeftTop;
    ModelRenderer Screen;
    ModelRenderer SideRight;
    ModelRenderer Back2;

    public ModelTV() {
        textureWidth = 64;
        textureHeight = 64;

        FrontLeft = new ModelRenderer(this, 32, 2);
        FrontLeft.addBox(0F, 0F, 0F, 3, 7, 6);
        FrontLeft.setRotationPoint(3.5F, 17F, -6F);
        FrontLeft.setTextureSize(64, 64);
        FrontLeft.mirror = true;
        setRotation(FrontLeft, 0F, -1.003822F, 0F);
        SideRightTop = new ModelRenderer(this, 0, 0);
        SideRightTop.addBox(0F, -2F, 0F, 2, 2, 9);
        SideRightTop.setRotationPoint(-5.7F, 7F, -3.7F);
        SideRightTop.setTextureSize(64, 64);
        SideRightTop.mirror = true;
        setRotation(SideRightTop, 0F, 0F, 0.7243116F);
        SideLeft = new ModelRenderer(this, 0, 0);
        SideLeft.addBox(-2F, 0F, 0F, 2, 7, 9);
        SideLeft.setRotationPoint(5.7F, 7F, -3.7F);
        SideLeft.setTextureSize(64, 64);
        SideLeft.mirror = true;
        setRotation(SideLeft, 0F, 0F, 0F);
        Front = new ModelRenderer(this, 38, 19);
        Front.addBox(0F, 0F, 0F, 7, 7, 4);
        Front.setRotationPoint(-3.5F, 17F, -6F);
        Front.setTextureSize(64, 64);
        Front.mirror = true;
        setRotation(Front, 0F, 0F, 0F);
        FrontRight = new ModelRenderer(this, 34, 2);
        FrontRight.addBox(-3F, 0F, 0F, 3, 7, 6);
        FrontRight.setRotationPoint(-3.5F, 17F, -6F);
        FrontRight.setTextureSize(64, 64);
        FrontRight.mirror = true;
        setRotation(FrontRight, 0F, 1.003822F, 0F);
        Top1 = new ModelRenderer(this, 0, 0);
        Top1.addBox(0F, -2F, 0F, 4, 2, 9);
        Top1.setRotationPoint(-4.4F, 7.5F, -3.7F);
        Top1.setTextureSize(64, 64);
        Top1.mirror = true;
        setRotation(Top1, 0F, 0F, 0F);
        BaseRight = new ModelRenderer(this, 0, 45);
        BaseRight.addBox(-4F, 0F, 0F, 11, 10, 9);
        BaseRight.setRotationPoint(-1.7F, 14F, -3.7F);
        BaseRight.setTextureSize(64, 64);
        BaseRight.mirror = true;
        setRotation(BaseRight, 0F, 0F, 0F);
        Back1 = new ModelRenderer(this, 0, 0);
        Back1.addBox(-8F, 0F, 0F, 8, 8, 1);
        Back1.setRotationPoint(3.7F, 7F, 5.5F);
        Back1.setTextureSize(64, 64);
        Back1.mirror = true;
        setRotation(Back1, 0F, 0F, 0F);
        FrontTop = new ModelRenderer(this, 0, 0);
        FrontTop.addBox(-3.5F, 0F, -2F, 7, 2, 3);
        FrontTop.setRotationPoint(0F, 16F, -3.5F);
        FrontTop.setTextureSize(64, 64);
        FrontTop.mirror = true;
        setRotation(FrontTop, 0.5948606F, 0F, 0F);
        Top2 = new ModelRenderer(this, 0, 0);
        Top2.addBox(-5F, -2F, 0F, 5, 2, 9);
        Top2.setRotationPoint(4.4F, 7.5F, -3.7F);
        Top2.setTextureSize(64, 64);
        Top2.mirror = true;
        setRotation(Top2, 0F, 0F, 0F);
        BaseLeft = new ModelRenderer(this, 0, 45);
        BaseLeft.addBox(-4F, 0F, 0F, 11, 10, 9);
        BaseLeft.setRotationPoint(-1.3F, 14F, -3.7F);
        BaseLeft.setTextureSize(64, 64);
        BaseLeft.mirror = true;
        setRotation(BaseLeft, 0F, 0F, 0F);
        SideLeftTop = new ModelRenderer(this, 0, 0);
        SideLeftTop.addBox(-2F, -2F, 0F, 2, 2, 9);
        SideLeftTop.setRotationPoint(5.7F, 7F, -3.7F);
        SideLeftTop.setTextureSize(64, 64);
        SideLeftTop.mirror = true;
        setRotation(SideLeftTop, 0F, 0F, -0.7243116F);
        Screen = new ModelRenderer(this, 0, 23);
        Screen.addBox(-8F, 0F, 0F, 8, 8, 9);
        Screen.setRotationPoint(3.7F, 7F, -3.5F);
        Screen.setTextureSize(64, 64);
        Screen.mirror = true;
        setRotation(Screen, 0F, 0F, 0F);
        SideRight = new ModelRenderer(this, 0, 0);
        SideRight.addBox(-2F, 0F, 0F, 2, 7, 9);
        SideRight.setRotationPoint(-3.7F, 7F, -3.7F);
        SideRight.setTextureSize(64, 64);
        SideRight.mirror = true;
        setRotation(SideRight, 0F, 0F, 0F);
        Back2 = new ModelRenderer(this, 0, 0);
        Back2.addBox(-8F, 0F, 0F, 7, 7, 2);
        Back2.setRotationPoint(4.2F, 7.5F, 5.5F);
        Back2.setTextureSize(64, 64);
        Back2.mirror = true;
        setRotation(Back2, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        FrontLeft.render(f5);
        SideRightTop.render(f5);
        SideLeft.render(f5);
        Front.render(f5);
        FrontRight.render(f5);
        Top1.render(f5);
        BaseRight.render(f5);
        Back1.render(f5);
        FrontTop.render(f5);
        Top2.render(f5);
        BaseLeft.render(f5);
        SideLeftTop.render(f5);
        Screen.render(f5);
        SideRight.render(f5);
        Back2.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

}
