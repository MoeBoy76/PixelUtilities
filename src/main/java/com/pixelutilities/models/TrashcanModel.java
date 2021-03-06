// Date: 12/27/2013 1:30:17 AM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX


package com.pixelutilities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TrashcanModel extends ModelBase {
    //fields
    ModelRenderer BottomCan1;
    ModelRenderer BottomCan2;
    ModelRenderer BottomCan3;
    ModelRenderer BottomCan4;
    ModelRenderer BottomCan5;
    ModelRenderer BottomCan6;
    ModelRenderer BottomCan7;
    ModelRenderer BottomCan8;
    ModelRenderer SideCan1;
    ModelRenderer SideCan2;
    ModelRenderer SideCan3;
    ModelRenderer SideCan4;
    ModelRenderer SideCan5;
    ModelRenderer SideCan6;
    ModelRenderer SideCan7;
    ModelRenderer SideCan8;

    public TrashcanModel() {
        textureWidth = 64;
        textureHeight = 32;

        BottomCan1 = new ModelRenderer(this, 0, 0);
        BottomCan1.addBox(4.7F, 0F, 0F, 5, 1, 4);
        BottomCan1.setRotationPoint(-4.9F, 23F, 1.8F);
        BottomCan1.setTextureSize(64, 32);
        BottomCan1.mirror = true;
        setRotation(BottomCan1, 0F, 0.7853982F, 0F);
        BottomCan2 = new ModelRenderer(this, 0, 0);
        BottomCan2.addBox(0F, 0F, -4F, 4, 1, 5);
        BottomCan2.setRotationPoint(-2F, 23F, 3.7F);
        BottomCan2.setTextureSize(64, 32);
        BottomCan2.mirror = true;
        setRotation(BottomCan2, 0F, 0F, 0F);
        BottomCan3 = new ModelRenderer(this, 0, 0);
        BottomCan3.addBox(-4F, 0F, 4.7F, 4, 1, 5);
        BottomCan3.setRotationPoint(-2F, 23F, -5F);
        BottomCan3.setTextureSize(64, 32);
        BottomCan3.mirror = true;
        setRotation(BottomCan3, 0F, 0.7853982F, 0F);
        BottomCan4 = new ModelRenderer(this, 0, 0);
        BottomCan4.addBox(-4F, 0F, 0F, 5, 1, 4);
        BottomCan4.setRotationPoint(3.9F, 23F, -2.1F);
        BottomCan4.setTextureSize(64, 32);
        BottomCan4.mirror = true;
        setRotation(BottomCan4, 0F, 0F, 0F);
        BottomCan5 = new ModelRenderer(this, 0, 0);
        BottomCan5.addBox(0F, 0F, 0F, 4, 1, 5);
        BottomCan5.setRotationPoint(-2F, 23F, -5F);
        BottomCan5.setTextureSize(64, 32);
        BottomCan5.mirror = true;
        setRotation(BottomCan5, 0F, 0F, 0F);
        BottomCan6 = new ModelRenderer(this, 0, 0);
        BottomCan6.addBox(-4F, 0F, 0F, 4, 1, 5);
        BottomCan6.setRotationPoint(-2F, 23F, -5F);
        BottomCan6.setTextureSize(64, 32);
        BottomCan6.mirror = true;
        setRotation(BottomCan6, 0F, 0.7853982F, 0F);
        BottomCan7 = new ModelRenderer(this, 0, 0);
        BottomCan7.addBox(0F, 0F, 0F, 5, 1, 4);
        BottomCan7.setRotationPoint(-4.9F, 23F, -2.2F);
        BottomCan7.setTextureSize(64, 32);
        BottomCan7.mirror = true;
        setRotation(BottomCan7, 0F, 0F, 0F);
        BottomCan8 = new ModelRenderer(this, 0, 0);
        BottomCan8.addBox(0F, 0F, 0F, 5, 1, 4);
        BottomCan8.setRotationPoint(-4.9F, 23F, 1.8F);
        BottomCan8.setTextureSize(64, 32);
        BottomCan8.mirror = true;
        setRotation(BottomCan8, 0F, 0.7853982F, 0F);
        SideCan1 = new ModelRenderer(this, 0, 0);
        SideCan1.addBox(0F, 0F, 0F, 4, 12, 1);
        SideCan1.setRotationPoint(-2F, 12F, 3.7F);
        SideCan1.setTextureSize(64, 32);
        SideCan1.mirror = true;
        setRotation(SideCan1, 0F, 0F, 0F);
        SideCan2 = new ModelRenderer(this, 0, 0);
        SideCan2.addBox(-4F, 0F, 8.7F, 4, 12, 1);
        SideCan2.setRotationPoint(-2F, 12F, -5F);
        SideCan2.setTextureSize(64, 32);
        SideCan2.mirror = true;
        setRotation(SideCan2, 0F, 0.7853982F, 0F);
        SideCan3 = new ModelRenderer(this, 0, 0);
        SideCan3.addBox(0F, 0F, 0F, 1, 12, 4);
        SideCan3.setRotationPoint(3.9F, 12F, -2.1F);
        SideCan3.setTextureSize(64, 32);
        SideCan3.mirror = true;
        setRotation(SideCan3, 0F, 0F, 0F);
        SideCan4 = new ModelRenderer(this, 0, 0);
        SideCan4.addBox(8.7F, 0F, 0F, 1, 12, 4);
        SideCan4.setRotationPoint(-4.9F, 12F, 1.8F);
        SideCan4.setTextureSize(64, 32);
        SideCan4.mirror = true;
        setRotation(SideCan4, 0F, 0.7853982F, 0F);
        SideCan5 = new ModelRenderer(this, 0, 0);
        SideCan5.addBox(0F, 0F, 0F, 4, 12, 1);
        SideCan5.setRotationPoint(-2F, 12F, -5F);
        SideCan5.setTextureSize(64, 32);
        SideCan5.mirror = true;
        setRotation(SideCan5, 0F, 0F, 0F);
        SideCan6 = new ModelRenderer(this, 0, 0);
        SideCan6.addBox(-4F, 0F, 0F, 4, 12, 1);
        SideCan6.setRotationPoint(-2F, 12F, -5F);
        SideCan6.setTextureSize(64, 32);
        SideCan6.mirror = true;
        setRotation(SideCan6, 0F, 0.7853982F, 0F);
        SideCan7 = new ModelRenderer(this, 0, 0);
        SideCan7.addBox(0F, 0F, 0F, 1, 12, 4);
        SideCan7.setRotationPoint(-4.9F, 12F, -2.2F);
        SideCan7.setTextureSize(64, 32);
        SideCan7.mirror = true;
        setRotation(SideCan7, 0F, 0F, 0F);
        SideCan8 = new ModelRenderer(this, 0, 0);
        SideCan8.addBox(0F, 0F, 0F, 1, 12, 4);
        SideCan8.setRotationPoint(-4.9F, 12F, 1.8F);
        SideCan8.setTextureSize(64, 32);
        SideCan8.mirror = true;
        setRotation(SideCan8, 0F, 0.7853982F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        BottomCan1.render(f5);
        BottomCan2.render(f5);
        BottomCan3.render(f5);
        BottomCan4.render(f5);
        BottomCan5.render(f5);
        BottomCan6.render(f5);
        BottomCan7.render(f5);
        BottomCan8.render(f5);
        SideCan1.render(f5);
        SideCan2.render(f5);
        SideCan3.render(f5);
        SideCan4.render(f5);
        SideCan5.render(f5);
        SideCan6.render(f5);
        SideCan7.render(f5);
        SideCan8.render(f5);
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
