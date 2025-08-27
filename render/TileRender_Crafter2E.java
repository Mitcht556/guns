package handmadeguns2.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import gvcr2.mod_GVCR2;
import handmadeguns2.mod_HandmadeGuns2;
import handmadeguns2.block.Block_Crafter2E;
import handmadeguns2.block.TileEntity_Crafter2E;
import handmadeguns2.block.TileEntity_Handind2;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class TileRender_Crafter2E extends TileEntitySpecialRenderer<TileEntity_Crafter2E> {
	
	private final RenderItem itemRenderer;
	protected final RenderManager renderManager;
	public TileRender_Crafter2E(RenderItem itemRendererIn, RenderManager renderManagerIn) {
		 this.itemRenderer = itemRendererIn;
		 renderManager = renderManagerIn;
	}

	public void render(TileEntity_Crafter2E tile, double x, double y, double z, float partialTicks, int destroyStage,
			float alpha) {
		/*stack.pushPose();
        stack.mulPose(Vector3f.YP.rotationDegrees(180.0F));
        stack.translate(-0.5F, 0.0F, -0.5F);
        VertexConsumer vertexconsumer = buffer.getBuffer(RenderGVCBlockTYpe.gunrender(TEXTURES));
        MODEL.renderPart(vertexconsumer,stack,"obj2");

        stack.pushPose();
        VertexConsumer vertexconsumer2 = buffer.getBuffer(RenderGVCBlockTYpe.gunrender(TEXTURES2));
        MODEL.renderPart(vertexconsumer2,stack,"obj1");
        stack.popPose();*/
		GL11.glPushMatrix();
//		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GlStateManager.enableRescaleNormal();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 0F, (float) z + 0.5F);
		
		GlStateManager.translate(0.0F, 1.3F, 0.0F);
		
		GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
		
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		GL11.glColor4f(1F, 1F, 1F, 1.0F);
		

		this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        {
        	
            ///stack.mulPose(Vector3f.YP.rotationDegrees(be.getLevel().getGameTime()));
//        	GlStateManager.rotate(tile.getWorld().getWorldTime(), 0.0F, 1.0F, 0.0F);
            /*Item gun = Registry.ITEM.get(new ResourceLocation("handmadeguns2", mod_HandmadeGuns2.gun_item[be.gun_select]));
            ItemStack ite = new ItemStack(gun);


            this.itemRenderer.renderStatic(ite,
                    ItemTransforms.TransformType.GROUND, 200, OverlayTexture.WHITE_OVERLAY_V, stack, buffer, 1000);
*/
        	if(tile.getWorld().getBlockState(tile.getPos()).getBlock() instanceof Block_Crafter2E) 
        	{
        		Block_Crafter2E be = (Block_Crafter2E) tile.getWorld().getBlockState(tile.getPos()).getBlock();
        		 for(int g = 0;g < mod_HandmadeGuns2.counter_crafter_counter; ++g) {
						if(mod_HandmadeGuns2.craftercount[g].equals(be.getTAGs())) {
							Item gun = (Item)Item.REGISTRY.getObject(new ResourceLocation(mod_HandmadeGuns2.MOD_ID + ":" + mod_HandmadeGuns2.guncount[tile.gun_select][g]));
			                ItemStack ite = new ItemStack(gun);
			                GL11.glColor4f(1F, 1F, 1F, 1.0F);
			                
			                this.itemRenderer.renderItem(ite, ItemCameraTransforms.TransformType.GROUND);
			                GL11.glPushMatrix();
			                //renderLivingLabel(String.valueOf(mod_HandmadeGuns2.emecount[tile.gun_select][g]), x, y, z, 64);
			                FontRenderer fontRendererIn = this.getFontRendererFromRenderManager();
			                String str = String.valueOf(mod_HandmadeGuns2.emecount[tile.gun_select][g]);
			                GlStateManager.translate(0.0F, 1.0F, 0.0F);
			        //        fontRendererIn.drawString(str, -fontRendererIn.getStringWidth(str) / 2, 0, 553648127);
			                GL11.glPopMatrix();
			                {
			                	
			                	ItemStack itee = new ItemStack(Items.EMERALD);
			                	GlStateManager.translate(0.5F, -0.2F, 0.0F);
			                	this.itemRenderer.renderItem(itee, ItemCameraTransforms.TransformType.GROUND);
			                	
			                }
			                
			                break;
						}
        		 }
        		
        	}
        	
            ///stack.mulPose(Vector3f.YP.rotationDegrees(180.0F - partialTicks));
        }
        //stack.popPose();
//        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GlStateManager.disableRescaleNormal();
		GL11.glPopMatrix();
	}
	
	public FontRenderer getFontRendererFromRenderManager()
    {
        return this.renderManager.getFontRenderer();
    }
	
	protected void renderLivingLabel(String str, double x, double y, double z, int maxDistance)
    {
        //double d0 = entityIn.getDistanceSq(this.renderManager.renderViewEntity);

        //if (d0 <= (double)(maxDistance * maxDistance))
        {
            //boolean flag = entityIn.isSneaking();
            float f = this.renderManager.playerViewY;
            float f1 = this.renderManager.playerViewX;
            boolean flag1 = this.renderManager.options.thirdPersonView == 2;
            float f2 = 1.0F + 0.5F - (0.0F);
            int i = "deadmau5".equals(str) ? -10 : 0;
            EntityRenderer.drawNameplate(this.getFontRendererFromRenderManager(), str, (float)x, (float)y + 0, (float)z, 0, 0, 0, flag1, false);
            //EntityRenderer.drawNameplate(this.getFontRendererFromRenderManager(), str, (float)x, (float)y + f2, (float)z, i, f, f1, flag1, false);
        }
    }
	
}
