package handmadeguns2.add;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import gvclib.item.ItemArmor_NewObj;
import gvclib.item.ItemArmor_NewVanilla;
import gvclib.item.ItemAttachment;
import handmadeguns2.mod_HandmadeGuns2;
import handmadeguns2.block.Block_Crafter2E;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import objmodel.AdvancedModelLoader;

public class HMGAddBlock22
{
  static List<ArrayList<String>> mainList = new ArrayList();
  public static List Guns = new ArrayList();
  
  static String tag = null;
  
  static String USname = null;
  static String JPname = null;
  
  public static void load(boolean isClient, InputStream inputStream, String domain,  RegistryEvent.Register<Block> event) 
  {
	  {
		  tag = null;
			 USname = null;
				JPname = null;
	  }
	  boolean itemdome = false;
		String item_domain_name = null;
	  
	  Block blocks = null;
	  
	  try {
		  //File file = file1;
          //if (checkBeforeReadfile(file))
          {
        	  //BufferedReader br = new BufferedReader(new FileReader(file));  // ファイルを開く
        	  BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
          String str;
          while((str = br.readLine()) != null){  // 1行ずつ読み込む
        	  String[] type = str.split(",");
        	  int guntype = 0;
        	  if (type.length != 0)
              {//1
        			  if (type[0].equals("Crafter_Tag")) {
        				  tag = type[1];
						}
        			  
        			  
        			  if (type[0].equals("USname")) {
							USname = type[1];
						}
						if (type[0].equals("JPname")) {
							JPname = type[1];
						}
						if (type[0].equals("Item_domain")) {
							itemdome = Boolean.parseBoolean(type[1]);
							if(itemdome) {
								item_domain_name = type[2];
							}
						}
        			  
                		if(type[0].equals("Crafter")){
                			
                			String GunName = type[1];
                			/*blocks = new ItemAttachment().setUnlocalizedName(GunName).setRegistryName(mod_HandmadeGuns2.MOD_ID,GunName)
											.setCreativeTab(mod_HandmadeGuns2.tabhmg);*/
                			blocks	= new Block_Crafter2E(type[1]).setUnlocalizedName(GunName).setRegistryName(mod_HandmadeGuns2.MOD_ID, GunName).setCreativeTab(mod_HandmadeGuns2.tabhmg);
                			/*{
                				Block_Crafter2E be = (Block_Crafter2E) blocks;
                				be .TAGs = tag;
                			}*/
							event.getRegistry().register(blocks);
							{
								mod_HandmadeGuns2.block_model_item[mod_HandmadeGuns2.block_model_id] = blocks;
								{//24/01/03
									if(itemdome && item_domain_name != null) {
										mod_HandmadeGuns2.block_model_item_domain[mod_HandmadeGuns2.block_model_id] = item_domain_name;
									}else {
										mod_HandmadeGuns2.block_model_item_domain[mod_HandmadeGuns2.block_model_id] = null;
									}
								}
								mod_HandmadeGuns2.block_model_name[mod_HandmadeGuns2.block_model_id] = GunName;
								++mod_HandmadeGuns2.block_model_id;
							}
							mod_HandmadeGuns2.craftercount[mod_HandmadeGuns2.counter_crafter_counter] = type[1];
							++mod_HandmadeGuns2.counter_crafter_counter;
							
							createlang(GunName);
                		}
                		
                		
                		
                		
                		
              }//1
        	  
        	  
        	  
        	  
        	  
          }
          br.close();  // ファイルを閉じる
          }
          
      } catch (FileNotFoundException ex) {
          ex.printStackTrace();
      } catch (IOException ex) {
          ex.printStackTrace();
      }
  }
  
  
  public static void createlang(String GunName) {
		try {
	    	{
	    		File newfile2 = new File(mod_HandmadeGuns2.proxy.ProxyFile(),"mods" + File.separatorChar + "handmadeguns2" 
		                + File.separatorChar +  "assets" + File.separatorChar + "handmadeguns2" + 
	    				File.separatorChar + "lang"+ File.separatorChar +  "block" + File.separatorChar + GunName);
		    	  newfile2.createNewFile();
		    	  BufferedWriter bw = new BufferedWriter(new FileWriter(newfile2));
					if (USname != null) {
						String name = new String(USname.getBytes("UTF8"), "UTF8");
						bw.write("USname,");
						bw.write(USname);
						bw.newLine();
					}
					if (JPname != null) {
						String name = new String(JPname.getBytes("UTF8"), "UTF8");
						bw.write("JPname,");
						bw.write(JPname);
						bw.newLine();
					}
					bw.close();
	    	}
	  } catch (FileNotFoundException ex) {
	    ex.printStackTrace();
	  } catch (IOException ex) {
	    ex.printStackTrace();
	  }
	}
}

