package handmadeguns2.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvclib.item.ItemGunBase;
import handmadeguns2.block.TileEntity_Handind2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import objmodel.AdvancedModelLoader;
import objmodel.IModelCustom;

@SideOnly(Side.CLIENT)
public class TileRender_Handind2 extends TileEntitySpecialRenderer<TileEntity_Handind2> {
	private static final ResourceLocation box = new ResourceLocation("textures/blocks/planks_oak.png");
	private static final IModelCustom box_model = AdvancedModelLoader.loadModel(
			new ResourceLocation("handmadeguns2:textures/modelrack/rack.obj"));
	private static final ResourceLocation box2 = new ResourceLocation("textures/blocks/planks_oak.png");
	private static final IModelCustom box_model2 = AdvancedModelLoader.loadModel(new ResourceLocation("handmadeguns2:textures/modelrack/rack2.obj"));
	private static final ResourceLocation box3 = new ResourceLocation("textures/blocks/obsidian.png");
	private static final IModelCustom box_model3 = AdvancedModelLoader.loadModel(new ResourceLocation("handmadeguns2:textures/modelrack/rack3.mqo"));

	public TileRender_Handind2() {
	}

	public void render(TileEntity_Handind2 tile, double x, double y, double z, float partialTicks, int destroyStage,
			float alpha) {
		Minecraft minecraft = Minecraft.getMinecraft();

		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glTranslatef((float) x + 0.5F, (float) y + 0F, (float) z + 0.5F);
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		GL11.glColor4f(1F, 1F, 1F, 1.0F);
		
		if(tile.houkou == 1){
			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
		}else if(tile.houkou == 2){
			GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		}else if(tile.houkou == 3){
			GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
		}else {
			
		}
		
		
		if(tile.id == 1){
			this.bindTexture(box2);
			box_model2.renderPart("mat1");
			ItemStack main = (ItemStack) tile.furnaceItemStacks.get(0);
			ItemStack off = (ItemStack) tile.furnaceItemStacks.get(1);
			ItemStack head = (ItemStack) tile.furnaceItemStacks.get(2);
			if (!main.isEmpty()) {
				ItemStack stack = main;
				if (stack != null && stack.getItem() instanceof ItemGunBase) {
					GL11.glPushMatrix();
					ItemGunBase gun = (ItemGunBase) stack.getItem();
					GL11.glScalef(0.1875F, 0.1875F, 0.1875F);
					GlStateManager.translate(1.0F, 3F, -1.8F);
					GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
					Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(gun.obj_tex));
					gun.obj_model.renderPart("mat1");
					gun.obj_model.renderPart("mat2");
					gun.obj_model.renderPart("mat3");
					//Layermat.rendersight( entity,  stack,  gun);
					//Layermat.renderattachment( entity,  stack,  gun);
					gun.obj_model.renderPart("mat20");
					gun.obj_model.renderPart("mat21");
					gun.obj_model.renderPart("mat22");
					gun.obj_model.renderPart("mat25");
					gun.obj_model.renderPart("mat100");
					gun.obj_model.renderPart("mat31");
					gun.obj_model.renderPart("mat32");/**/
					GL11.glPopMatrix();
				}
			}
		}else if(tile.id == 2){
			this.bindTexture(box3);
			box_model3.renderPart("mat1");
			ItemStack main = (ItemStack) tile.furnaceItemStacks.get(0);
			ItemStack off = (ItemStack) tile.furnaceItemStacks.get(1);
			ItemStack head = (ItemStack) tile.furnaceItemStacks.get(2);
			if (!main.isEmpty()) {
				ItemStack stack = main;
				if (stack != null && stack.getItem() instanceof ItemGunBase) {
				GL11.glPushMatrix();
				ItemGunBase gun = (ItemGunBase) stack.getItem();
				GL11.glScalef(0.1875F, 0.1875F, 0.1875F);
				GlStateManager.translate(1.0F, 2F, 0.0F);
				GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(gun.obj_tex));
			gun.obj_model.renderPart("mat1");
			gun.obj_model.renderPart("mat2");
			gun.obj_model.renderPart("mat3");
			gun.obj_model.renderPart("mat20");
			gun.obj_model.renderPart("mat21");
			gun.obj_model.renderPart("mat22");
			gun.obj_model.renderPart("mat25");
			gun.obj_model.renderPart("mat100");
			gun.obj_model.renderPart("mat31");
			gun.obj_model.renderPart("mat32");/**/
			GL11.glPopMatrix();
			}
		}
		}
		else
		{
			this.bindTexture(box);
			box_model.renderPart("mat1");
			ItemStack main = (ItemStack) tile.furnaceItemStacks.get(0);
			ItemStack off = (ItemStack) tile.furnaceItemStacks.get(1);
			ItemStack head = (ItemStack) tile.furnaceItemStacks.get(2);
			if (!main.isEmpty()) {
				ItemStack stack = main;
				if (stack != null && stack.getItem() instanceof ItemGunBase) {
					GL11.glPushMatrix();
					ItemGunBase gun = (ItemGunBase) stack.getItem();
					GL11.glScalef(0.1875F, 0.1875F, 0.1875F);
					GlStateManager.translate(1.0F, 2F, 0.0F);
					GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
					Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(gun.obj_tex));
					gun.obj_model.renderPart("mat1");
					gun.obj_model.renderPart("mat2");
					gun.obj_model.renderPart("mat3");
					//Layermat.rendersight( entity,  stack,  gun);
					//Layermat.renderattachment( entity,  stack,  gun);
					gun.obj_model.renderPart("mat20");
					gun.obj_model.renderPart("mat21");
					gun.obj_model.renderPart("mat22");
					gun.obj_model.renderPart("mat25");
					gun.obj_model.renderPart("mat100");
					gun.obj_model.renderPart("mat31");
					gun.obj_model.renderPart("mat32");/**/
					GL11.glPopMatrix();
				}
			}
			if (!off.isEmpty()) {
				ItemStack stack = off;
				if (stack != null && stack.getItem() instanceof ItemGunBase) {
					GL11.glPushMatrix();
					ItemGunBase gun = (ItemGunBase) stack.getItem();
					GL11.glScalef(0.1875F, 0.1875F, 0.1875F);
					GlStateManager.translate(1.0F, 3F, -1.8F);
					GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
					Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(gun.obj_tex));
					gun.obj_model.renderPart("mat1");
					gun.obj_model.renderPart("mat2");
					gun.obj_model.renderPart("mat3");
					//Layermat.rendersight( entity,  stack,  gun);
					//Layermat.renderattachment( entity,  stack,  gun);
					gun.obj_model.renderPart("mat20");
					gun.obj_model.renderPart("mat21");
					gun.obj_model.renderPart("mat22");
					gun.obj_model.renderPart("mat25");
					gun.obj_model.renderPart("mat100");
					gun.obj_model.renderPart("mat31");
					gun.obj_model.renderPart("mat32");/**/
					GL11.glPopMatrix();
				}
			}
			if (!head.isEmpty()) {
				ItemStack stack = head;
				if (stack != null && stack.getItem() instanceof ItemGunBase) {
					GL11.glPushMatrix();
					ItemGunBase gun = (ItemGunBase) stack.getItem();
					GL11.glScalef(0.1875F, 0.1875F, 0.1875F);
					GlStateManager.translate(1.0F, 1F, 1.8F);
					GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
					Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(gun.obj_tex));
					gun.obj_model.renderPart("mat1");
					gun.obj_model.renderPart("mat2");
					gun.obj_model.renderPart("mat3");
					//Layermat.rendersight( entity,  stack,  gun);
					//Layermat.renderattachment( entity,  stack,  gun);
					gun.obj_model.renderPart("mat20");
					gun.obj_model.renderPart("mat21");
					gun.obj_model.renderPart("mat22");
					gun.obj_model.renderPart("mat25");
					gun.obj_model.renderPart("mat100");
					gun.obj_model.renderPart("mat31");
					gun.obj_model.renderPart("mat32");/**/
					GL11.glPopMatrix();
				}
			}
		}
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();

	}
}