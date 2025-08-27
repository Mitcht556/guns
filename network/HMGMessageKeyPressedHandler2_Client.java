package handmadeguns2.network;


import handmadeguns2.mod_HandmadeGuns2;
import handmadeguns2.block.TileEntity_Crafter2;
import handmadeguns2.block.TileEntity_Handind2;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
 
public class HMGMessageKeyPressedHandler2_Client implements IMessageHandler<HMGMessageKeyPressed2_Client, IMessage> {
 
    @Override
    public IMessage onMessage(HMGMessageKeyPressed2_Client message, MessageContext ctx) {
        EntityPlayer entityPlayer = mod_HandmadeGuns2.proxy.getEntityPlayerInstance();
        if (message.key == 1) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_Crafter2) {
        		TileEntity_Crafter2 tile  = (TileEntity_Crafter2) entityPlayer.world.getTileEntity(pos);
        		 if(tile.sell_id < (mod_HandmadeGuns2.gun_id - 1)) {
        			 ++tile.sell_id;
        		 }else {
        			 tile.sell_id = 0;
        		 }
        	}
		}
        if (message.key == 2) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_Crafter2) {
        		TileEntity_Crafter2 tile  = (TileEntity_Crafter2) entityPlayer.world.getTileEntity(pos);
				if (tile.sell_id > 0) {
					--tile.sell_id;
				} else {
					tile.sell_id = (mod_HandmadeGuns2.gun_id - 1);
				}
        	}
		}
        if (message.key == 3) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_Handind2) {
        		TileEntity_Handind2 tile  = (TileEntity_Handind2) entityPlayer.world.getTileEntity(pos);
				Item item = new Item().getItemById(message.item_id);
				if(item != null) {
					tile.furnaceItemStacks.set(0, new ItemStack(item));
				}
        	}
		}
        if (message.key == 4) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_Handind2) {
        		TileEntity_Handind2 tile  = (TileEntity_Handind2) entityPlayer.world.getTileEntity(pos);
				Item item = new Item().getItemById(message.item_id);
				if(item != null) {
					tile.furnaceItemStacks.set(1, new ItemStack(item));
				}
        	}
		}
        if (message.key == 5) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_Handind2) {
        		TileEntity_Handind2 tile  = (TileEntity_Handind2) entityPlayer.world.getTileEntity(pos);
				Item item = new Item().getItemById(message.item_id);
				if(item != null) {
					tile.furnaceItemStacks.set(2, new ItemStack(item));
				}
        	}
		}
        if (message.key == 6) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_Handind2) {
        		TileEntity_Handind2 tile  = (TileEntity_Handind2) entityPlayer.world.getTileEntity(pos);
        		tile.houkou = message.item_id;
        	}
		}
        return null;
    }
}