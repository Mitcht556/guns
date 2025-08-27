package handmadeguns2.network;


import handmadeguns2.mod_HandmadeGuns2;
import handmadeguns2.block.TileEntity_AttachmentMachine;
import handmadeguns2.block.TileEntity_Crafter2;
import handmadeguns2.block.TileEntity_MagazineMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
 
public class HMGMessageKeyPressedHandler2 implements IMessageHandler<HMGMessageKeyPressed2, IMessage> {
 
    @Override
    public IMessage onMessage(HMGMessageKeyPressed2 message, MessageContext ctx) {
        EntityPlayer entityPlayer = ctx.getServerHandler().player;
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
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_MagazineMachine) {
        		TileEntity_MagazineMachine tile  = (TileEntity_MagazineMachine) entityPlayer.world.getTileEntity(pos);
        		 if(tile.sell_id < (mod_HandmadeGuns2.magazine_id - 1)) {
        			 ++tile.sell_id;
        		 }else {
        			 tile.sell_id = 0;
        		 }
        	}
		}
        if (message.key == 4) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_MagazineMachine) {
        		TileEntity_MagazineMachine tile  = (TileEntity_MagazineMachine) entityPlayer.world.getTileEntity(pos);
				if (tile.sell_id > 0) {
					--tile.sell_id;
				} else {
					tile.sell_id = (mod_HandmadeGuns2.magazine_id - 1);
				}
        	}
		}
        
        if (message.key == 5) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_AttachmentMachine) {
        		TileEntity_AttachmentMachine tile  = (TileEntity_AttachmentMachine) entityPlayer.world.getTileEntity(pos);
        		 if(tile.sell_id < (mod_HandmadeGuns2.attachment_id - 1)) {
        			 ++tile.sell_id;
        		 }else {
        			 tile.sell_id = 0;
        		 }
        	}
		}
        if (message.key == 6) {
        	BlockPos pos = new BlockPos(message.posx, message.posy, message.posz);
        	if(pos != null && entityPlayer.world.getTileEntity(pos) instanceof TileEntity_AttachmentMachine) {
        		TileEntity_AttachmentMachine tile  = (TileEntity_AttachmentMachine) entityPlayer.world.getTileEntity(pos);
				if (tile.sell_id > 0) {
					--tile.sell_id;
				} else {
					tile.sell_id = (mod_HandmadeGuns2.attachment_id - 1);
				}
        	}
		}
        return null;
    }
}