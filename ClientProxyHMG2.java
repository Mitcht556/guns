package handmadeguns2;


import java.io.File;

import handmadeguns2.block.TileEntity_Crafter2E;
import handmadeguns2.block.TileEntity_Handind2;
import handmadeguns2.render.TileRender_Crafter2E;
import handmadeguns2.render.TileRender_Handind2;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxyHMG2 extends CommonSideProxyHMG2 {
	@Override
	public File ProxyFile(){
		return Minecraft.getMinecraft().mcDataDir;
	}
	 @Override
	    public EntityPlayer getEntityPlayerInstance() {
	        return Minecraft.getMinecraft().player;
	    }
	 
    @Override
	public World getCilentWorld(){
		return FMLClientHandler.instance().getClient().world;
		}
    
    @Override
    public void registerClientInfo() {
        //ClientRegistry.registerKeyBinding(Speedreload);
    }
    
    @Override
    public boolean getClient() {
        return true;
    }
    
    @Override
	public void reisterRenderers(){
    	Minecraft mc = FMLClientHandler.instance().getClient();
    	ClientRegistry.registerTileEntity(TileEntity_Handind2.class, "TileEntity_Handind2", new TileRender_Handind2());
    	ClientRegistry.registerTileEntity(TileEntity_Crafter2E.class, "TileEntity_Crafter2E", new TileRender_Crafter2E(mc.getRenderItem(), mc.getRenderManager()));
    }
    
    @Override
    public void registerTileEntity() {
    	
    }
    
    @Override
    public void InitRendering()
    {
    	//ClientRegistry.bindTileEntitySpecialRenderer(GVCTileEntityItemG36.class, new GVCRenderItemG36());
    }

    @Override
    public boolean jumped(){
		return Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown();
		//return false;
	}
    
    @Override
    public boolean leftclick(){
		return Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown();
		//return false;
	}
    /*@Override
    public boolean Fclick(){
		return this.Knife.getIsKeyPressed();
	}
    @Override
    public boolean ADSclick(){
		return this.ADS.getIsKeyPressed();
	}*/
}