package handmadeguns2.gui;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.opengl.GL11;

import handmadeguns2.mod_HandmadeGuns2;
import handmadeguns2.block.TileEntity_MagazineMachine;
import handmadeguns2.network.HMGMessageKeyPressed2;
import handmadeguns2.network.HMGPacketHandler2;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class BlockGuiInventory_MagazineMachine extends GuiContainer
{
    private static final ResourceLocation FURNACE_GUI_TEXTURES = new ResourceLocation("handmadeguns2:textures/gui/magazinemachine.png");
    /** The player inventory bound to this GUI. */
    private final InventoryPlayer playerInventory;
    private final IInventory tileFurnace;
    private final TileEntity_MagazineMachine tile;
    
    private GuiButton next;
    private GuiButton back;

    public BlockGuiInventory_MagazineMachine(InventoryPlayer playerInv, IInventory furnaceInv, TileEntity_MagazineMachine t)
    {
        super(new BlockContainerInventory_MagazineMachine(playerInv, furnaceInv));
        this.playerInventory = playerInv;
        this.tileFurnace = furnaceInv;
        this.tile = t;
    }
    public void initGui()
    {
    	super.initGui();
    	this.next = this.addButton(new GuiButton(0, this.width / 2 - 10, this.height / 2 - 69, 20, 20, I18n.format("next")));
    	this.back = this.addButton(new GuiButton(1, this.width / 2 - 60, this.height / 2 - 69, 20, 20, I18n.format("back")));
    }
    protected void actionPerformed(GuiButton button) throws IOException
    {
    	 if (button.id == 0)
         {
    		 if(tile.sell_id < (mod_HandmadeGuns2.magazine_id - 1)) {
    			 ++tile.sell_id;
    		 }else {
    			 tile.sell_id = 0;
    		 }
    		 HMGPacketHandler2.INSTANCE.sendToServer(new HMGMessageKeyPressed2(3, tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ()));
         }
    	 if (button.id == 1)
         {
    		 if(tile.sell_id > 0) {
    			 --tile.sell_id;
    		 }else {
    			 tile.sell_id = (mod_HandmadeGuns2.magazine_id - 1);
    		 }
    		 HMGPacketHandler2.INSTANCE.sendToServer(new HMGMessageKeyPressed2(4, tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ()));
         }
    }
    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = this.tileFurnace.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draws the background layer of this container (behind the items).
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(FURNACE_GUI_TEXTURES);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        
        {
        	FontRenderer fontReader = mc.fontRenderer;
    		mc.fontRenderer.setUnicodeFlag(mc.isUnicode());
    		RenderItem renderitem = mc.getRenderItem();
        	GL11.glPushMatrix();
    		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    		GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
    				GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE,
    				GlStateManager.DestFactor.ZERO);
    		mc.renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        	{
				ItemStack item = new ItemStack(mod_HandmadeGuns2.magazine_item[tile.sell_id]);
				if (!item.isEmpty()) {
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.4F);
					int posx =   k + 56;
					int posy =   l + 17;
					renderitem.renderItemIntoGUI(item, posx, posy);
					boolean onitem = mouseX >= posx && mouseY >= posy && mouseX < posx + 16 && mouseY < posy + 16;
					if(onitem)
					{
						this.renderToolTip(item, mouseX, mouseY);
					}
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					String d2 = String.format("%1$3d", mod_HandmadeGuns2.magazine_kazu[tile.sell_id]);
					fontReader.drawString(d2,  posx + 5, posy + 8, Color.GREEN.getRGB());
					//String d2 = String.format("%1$3d", doll.getRemain_S());
					//fontReader.drawString(d2,  k + 115, l + 80, 0xFFFFFF);
				}
			}
        	{
				ItemStack item = new ItemStack(Items.GUNPOWDER);
				if (!item.isEmpty()) {
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.4F);
					renderitem.renderItemIntoGUI(item, k + 74, l + 35);
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					String d2 = String.format("%1$3d", mod_HandmadeGuns2.magazine_gunpowder[tile.sell_id]);
					fontReader.drawString(d2,  k + 82, l + 45, 0xFFFFFF);
				}
			}
        	{
				ItemStack item = new ItemStack(Items.IRON_INGOT);
				if (!item.isEmpty()) {
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.4F);
					renderitem.renderItemIntoGUI(item, k + 38, l + 35);
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					String d2 = String.format("%1$3d", mod_HandmadeGuns2.magazine_iron[tile.sell_id]);
					fontReader.drawString(d2,  k + 46, l + 45, 0xFFFFFF);
				}
			}
        	GL11.glPopMatrix();
        }
    }

    private int getCookProgressScaled(int pixels)
    {
        int i = this.tileFurnace.getField(2);
        int j = this.tileFurnace.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }

    private int getBurnLeftScaled(int pixels)
    {
        int i = this.tileFurnace.getField(1);

        if (i == 0)
        {
            i = 200;
        }

        return this.tileFurnace.getField(0) * pixels / i;
    }
}