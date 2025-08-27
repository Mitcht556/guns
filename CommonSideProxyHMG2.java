package handmadeguns2;

import java.io.File;

import handmadeguns2.block.TileEntity_Crafter2E;
import handmadeguns2.block.TileEntity_Handind2;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class CommonSideProxyHMG2 {
 
	public File ProxyFile(){
		return new File(".");
	}
	public EntityPlayer getEntityPlayerInstance() {return null;}
	
	public void registerClientInfo(){}
	
	public void IGuiHandler(){}
	
    public void reisterRenderers(){
    	
    	GameRegistry.registerTileEntity(TileEntity_Handind2.class, "TileEntity_Handind2");
    	GameRegistry.registerTileEntity(TileEntity_Crafter2E.class, "TileEntity_Crafter2E");
    }
	
	public World getCilentWorld(){
		return null;}

	public void InitRendering() {
		
	}
	
	public boolean getClient() {
		return false;
	}

	public void registerTileEntity() {		
		//GameRegistry.registerTileEntity(GVCTileEntityItemG36.class, "GVCTileEntitysample");
	}
	public boolean jumped(){
		return false;
	}
	
	public boolean leftclick(){
		return false;
	}
	public boolean Fclick(){
		return false;
	}
	public boolean ADSclick(){
		return false;
	}
	
	
}