package handmadeguns2.gui;

import handmadeguns2.block.TileEntity_AttachmentMachine;
import handmadeguns2.block.TileEntity_Crafter2;
import handmadeguns2.block.TileEntity_Handind2;
import handmadeguns2.block.TileEntity_MagazineMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandlerHMG2 implements IGuiHandler {
	/*
	 * ServerでGUIが開かれたときに呼ばれる 通常はContainerを生成する。
	 */
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		if (ID == 0) {
			TileEntity tileentity = player.world.getTileEntity(pos);
			if (!world.isBlockLoaded(pos)) {
				return null;
			}else
            if (tileentity instanceof TileEntity_Crafter2)
            {
            	return new BlockContainerInventory_Crafter2(player.inventory, (TileEntity_Crafter2)tileentity);
            }
		}
		if (ID == 1) {
			TileEntity tileentity = player.world.getTileEntity(pos);
			if (!world.isBlockLoaded(pos)) {
				return null;
			}else
            if (tileentity instanceof TileEntity_Handind2)
            {
            	return new BlockContainerInventory_Handind2(player.inventory, (TileEntity_Handind2)tileentity);
            }
		}
		if (ID == 2) {
			TileEntity tileentity = player.world.getTileEntity(pos);
			if (!world.isBlockLoaded(pos)) {
				return null;
			}else
            if (tileentity instanceof TileEntity_MagazineMachine)
            {
            	return new BlockContainerInventory_MagazineMachine(player.inventory, (TileEntity_MagazineMachine)tileentity);
            }
		}
		if (ID == 3) {
			TileEntity tileentity = player.world.getTileEntity(pos);
			if (!world.isBlockLoaded(pos)) {
				return null;
			}else
            if (tileentity instanceof TileEntity_AttachmentMachine)
            {
            	return new BlockContainerInventory_AttachmentMachine(player.inventory, (TileEntity_AttachmentMachine)tileentity);
            }
		}
		return null;
	}

	/*
	 * ClientでGUIが開かれたときに呼ばれる 通常はGUIを生成する
	 */
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		if (ID == 0) {
			TileEntity tileentity = player.world.getTileEntity(pos);
			if (!world.isBlockLoaded(pos)) {
				return null;
			}else
            if (tileentity instanceof TileEntity_Crafter2)
            {
            	return new BlockGuiInventory_Crafter2(player.inventory, (TileEntity_Crafter2)tileentity, (TileEntity_Crafter2)tileentity);
            }
		}
		if (ID == 1) {
			TileEntity tileentity = player.world.getTileEntity(pos);
			if (!world.isBlockLoaded(pos)) {
				return null;
			}else
            if (tileentity instanceof TileEntity_Handind2)
            {
            	return new BlockGuiInventory_Handind2(player.inventory, (TileEntity_Handind2)tileentity, (TileEntity_Handind2)tileentity);
            }
		}
		if (ID == 2) {
			TileEntity tileentity = player.world.getTileEntity(pos);
			if (!world.isBlockLoaded(pos)) {
				return null;
			}else
            if (tileentity instanceof TileEntity_MagazineMachine)
            {
            	return new BlockGuiInventory_MagazineMachine(player.inventory, (TileEntity_MagazineMachine)tileentity, (TileEntity_MagazineMachine)tileentity);
            }
		}
		if (ID == 3) {
			TileEntity tileentity = player.world.getTileEntity(pos);
			if (!world.isBlockLoaded(pos)) {
				return null;
			}else
            if (tileentity instanceof TileEntity_AttachmentMachine)
            {
            	return new BlockGuiInventory_AttachmentMachine(player.inventory, (TileEntity_AttachmentMachine)tileentity, (TileEntity_AttachmentMachine)tileentity);
            }
		}
		return null;
	}
}