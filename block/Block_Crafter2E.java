package handmadeguns2.block;

import java.util.Random;

import handmadeguns2.mod_HandmadeGuns2;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Block_Crafter2E extends BlockContainer
{
    
    //public String TAGs;
    
    private final String TAGs;

    public Block_Crafter2E(String ta)
    {
    	 super(Material.IRON);
         this.setHardness(3F);
         this.setResistance(10.0F);
         this.setSoundType(SoundType.METAL);
         TAGs = ta;
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    /*public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(mod_HandmadeGuns2.hmg2_crafter);
    }*/

    public String getTAGs() {
    	return TAGs;
    }
    
    
    /**
     * Called when the block is right clicked by a player.
     */
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	{
    		TileEntity tileentity = worldIn.getTileEntity(pos);
             if (tileentity instanceof TileEntity_Crafter2E) {
            	 TileEntity_Crafter2E crafter = (TileEntity_Crafter2E) tileentity;
                 ItemStack itemstack = playerIn.getHeldItemMainhand();
                 if(!itemstack.isEmpty() && itemstack.getItem() == Items.EMERALD){
                	 
                	 
                	 for(int g = 0;g < mod_HandmadeGuns2.counter_crafter_counter; ++g) {
							if(mod_HandmadeGuns2.craftercount[g].equals(TAGs)) {
								System.out.println(String.format("VVVVVVVVVVVVVVVVVVVVVVVVvv"));
		                    	 Item gun = (Item)Item.REGISTRY.getObject(new ResourceLocation(mod_HandmadeGuns2.MOD_ID + ":" + mod_HandmadeGuns2.guncount[crafter.gun_select][g]));
		                         ItemStack ite = new ItemStack(gun);
		                         if(!ite.isEmpty() && itemstack.getCount() >= mod_HandmadeGuns2.emecount[crafter.gun_select][g]){
		                             ///dropItemStack(p_51532_, p_51533_.getX(), p_51533_.getY() + 1, p_51533_.getZ(), ite);
		                             itemstack.setCount(itemstack.getCount() - mod_HandmadeGuns2.emecount[crafter.gun_select][g]);
		                        	 System.out.println(String.format("000000000000000000000000000000000"));
		                        	 spawnAsEntity(worldIn, pos, ite);
		                         }
		                         break;
							}
                	 }
                 }else{
                	 for(int g = 0;g < mod_HandmadeGuns2.counter_crafter_counter; ++g) {
							if(mod_HandmadeGuns2.craftercount[g].equals(TAGs)) {
								boolean flag = false;
			                    	 for(int id = 1;id < (1024 - crafter.gun_select); ++id) {
			                    		 if(mod_HandmadeGuns2.crafter_gunid_tag[crafter.gun_select + id]!= null 
			                    				 && mod_HandmadeGuns2.crafter_gunid_tag[crafter.gun_select + id].equals(TAGs)) {
			                    			 crafter.gun_select = crafter.gun_select + id;
			                    			 System.out.println(String.valueOf(crafter.gun_select));
					                         break;
				                    	 }
			                    		 if(id == 1024 - crafter.gun_select - 1) {
			                    			 flag = true;
			                    			 System.out.println(String.format("LLLLLLLLLLLLLLLLLLLLLLL"));
			                    		 }
			                    	 }
			                    	 if(flag) {
			                    		 //crafter.gun_select = 0;
			                    		 for(int id = 0;id < (1024 - crafter.gun_select); ++id) {
			                    			 if(mod_HandmadeGuns2.crafter_gunid_tag[0 + id]!= null 
				                    				 && mod_HandmadeGuns2.crafter_gunid_tag[0 + id].equals(TAGs)) {
				                    			 crafter.gun_select = 0 + id;
				                    			 System.out.println(String.valueOf(crafter.gun_select));
						                         break;
					                    	 }
			                    		 }
				                         System.out.println(String.format("555555555555555555555"));
				                         break;
			                    	 }
								break;
							}
                	 }
                 }
             }
    	}
        
        return true;
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntity_Crafter2E();
    }

    

    public boolean hasComparatorInputOverride(IBlockState state)
    {
        return true;
    }

    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos)
    {
        return Container.calcRedstone(worldIn.getTileEntity(pos));
    }

    /*public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(mod_HandmadeGuns2.hmg2_crafter);
    }*/

    /**
     * The type of render function called. MODEL for mixed tesr and static model, MODELBLOCK_ANIMATED for TESR-only,
     * LIQUID for vanilla liquids, INVISIBLE to skip all rendering
     */
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
}