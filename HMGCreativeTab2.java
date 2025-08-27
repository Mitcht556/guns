package handmadeguns2;
 
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
 
public class HMGCreativeTab2 extends CreativeTabs
{
	public HMGCreativeTab2(String label)
	{
		super(label);
	}
 
	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem()
	{
		return new ItemStack(mod_HandmadeGuns2.hmg2_icon);
	}
 
	@Override
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel()
	{
		return "HandmadeGun's2";
	}
 
}