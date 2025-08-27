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
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import objmodel.AdvancedModelLoader;

public class HMGAddBlockItem22
{
  static List<ArrayList<String>> mainList = new ArrayList();
  public static List Guns = new ArrayList();
  static Item itema;
  static Item itemb;
  static Item itemc;
  static Item itemd;
  static Item iteme;
  static Item itemf;
  static Item itemg;
  static Item itemh;
  static Item itemi;
  static String re1 = "abc";
  static String re2 = "def";
  static String re3 = "ghi";
  static String USname = null;
  static String JPname = null;
  
  public static void load(boolean isClient, InputStream inputStream, String domain,  RegistryEvent.Register<Item> event) 
  {
	  {
		  itema = Item.getItemById(0);
		itemb = Item.getItemById(0);
		itemc = Item.getItemById(0);
		itemd = Item.getItemById(0);
		iteme = Item.getItemById(0);
		itemf = Item.getItemById(0);
		itemg = Item.getItemById(0);
		itemh = Item.getItemById(0);
		itemi = Item.getItemById(0);
		re1 = "abc";
		re2 = "def";
		re3 = "ghi";
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
        			  if (type[0].equals("USname")) {
							USname = type[1];
						}
						if (type[0].equals("JPname")) {
							JPname = type[1];
						}
        			  
                		if(type[0].equals("Crafter")){
                			Block block;
                			block = (Block)Block.REGISTRY.getObject(new ResourceLocation(mod_HandmadeGuns2.MOD_ID + ":" + type[1]));
                			if(block != null)event.getRegistry().register(new ItemBlock(block).setRegistryName(mod_HandmadeGuns2.MOD_ID, type[1]));
                		}
                		
                		
                		if(type[0].equals("Recipe1")){
	          				  re1 = type[1];
	              		    }
	                		if(type[0].equals("Recipe2")){
	            				  re2 = type[1];
	                		}
	                		if(type[0].equals("Recipe3")){
	            				  re3 = type[1];
	                		    }
	                		if(type[0].equals("ItemA")){
	                			if(!type[1].equals("null")) {
	                				itema = event.getRegistry().getValue(new ResourceLocation(type[1], type[2]));
	                			}else {
	                				itema = Items.AIR;
	                			}
	                	    }
	                		if(type[0].equals("ItemB")){
	                			if(!type[1].equals("null")) {
	                				itemb = event.getRegistry().getValue(new ResourceLocation(type[1], type[2]));
	                			}else {
	                				itemb = Items.AIR;
	                			}
	                	    }
	                		if(type[0].equals("ItemC")){
	                			if(!type[1].equals("null")) {
	                				itemc = event.getRegistry().getValue(new ResourceLocation(type[1], type[2]));
	                			}else {
	                				itemc = Items.AIR;
	                			}
	                	    }
	                		if(type[0].equals("ItemD")){
	                			if(!type[1].equals("null")) {
	                				itemd = event.getRegistry().getValue(new ResourceLocation(type[1], type[2]));
	                			}else {
	                				itemd = Items.AIR;
	                			}
	                	    }
	                		if(type[0].equals("ItemE")){
	                			if(!type[1].equals("null")) {
	                				iteme = event.getRegistry().getValue(new ResourceLocation(type[1], type[2]));
	                			}else {
	                				iteme = Items.AIR;
	                			}
	                	    }
	                		if(type[0].equals("ItemF")){
	                			if(!type[1].equals("null")) {
	                				itemf = event.getRegistry().getValue(new ResourceLocation(type[1], type[2]));
	                			}else {
	                				itemf = Items.AIR;
	                			}
	                	    }
	                		if(type[0].equals("ItemG")){
	                			if(!type[1].equals("null")) {
	                				itemg = event.getRegistry().getValue(new ResourceLocation(type[1], type[2]));
	                			}else {
	                				itemg = Items.AIR;
	                			}
	                	    }
	                		if(type[0].equals("ItemH")){
	                			if(!type[1].equals("null")) {
	                				itemh = event.getRegistry().getValue(new ResourceLocation(type[1], type[2]));
	                			}else {
	                				itemh = Items.AIR;
	                			}
	                	    }
	                		if(type[0].equals("ItemI")){
	                			if(!type[1].equals("null")) {
	                				itemi = event.getRegistry().getValue(new ResourceLocation(type[1], type[2]));
	                			}else {
	                				itemi = Items.AIR;
	                			}
	                	    }
	                		if(type[0].equals("addNewRecipe")){
	                			Item additem = event.getRegistry().getValue(new ResourceLocation(type[1], type[2]));
	              			  int kazu1 = Integer.parseInt(type[3]);
	              			GameRegistry.addShapedRecipe(
	              					new ResourceLocation(type[2]),
	              	                new ResourceLocation("handmadeguns2"),
	              	                new ItemStack(additem, kazu1), new Object[]{
	              	                		"abc",
	    	                  				"def",
	    	                  				"ghi", 
	    	                  				'a',itema,
	    	                  				'b',itemb,
	    	                  				'c',itemc,
	    	                  				'd',itemd,
	    	                  				'e',iteme,
	    	                  				'f',itemf,
	    	                  				'g',itemg,
	    	                  				'h',itemh,
	    	                  				'i',itemi
	              				 });
	                		}
	                		
	                		if(type[0].equals("addNewShapelessRecipe")){
	                			Item additem = event.getRegistry().getValue(new ResourceLocation(type[1], type[2]));
		              			  int kazu1 = Integer.parseInt(type[3]);
		              			  if(itemb == Items.AIR) {
		              				GameRegistry.addShapelessRecipe(
		                					new ResourceLocation(type[2]),
			              	                new ResourceLocation("handmadeguns2"),
			              	                new ItemStack(additem, kazu1), new Ingredient[]{ 
			              	            		Ingredient.fromItem(itema)
		                					});
		              			  }
		              			else if(itemc == Items.AIR) {
		              				GameRegistry.addShapelessRecipe(
		                					new ResourceLocation(type[2]),
			              	                new ResourceLocation("handmadeguns2"),
			              	                new ItemStack(additem, kazu1), new Ingredient[]{ 
			              	            		Ingredient.fromItem(itema),
			              	            		Ingredient.fromItem(itemb),
		                					});
		              			  }
		              			else if(itemd == Items.AIR) {
		              				GameRegistry.addShapelessRecipe(
		                					new ResourceLocation(type[2]),
			              	                new ResourceLocation("handmadeguns2"),
			              	                new ItemStack(additem, kazu1), new Ingredient[]{ 
			              	            		Ingredient.fromItem(itema),
			              	            		Ingredient.fromItem(itemb),
			              	            		Ingredient.fromItem(itemc)
		                					});
		              			  }
		              			else if(iteme == Items.AIR) {
		              				GameRegistry.addShapelessRecipe(
		                					new ResourceLocation(type[2]),
			              	                new ResourceLocation("handmadeguns2"),
			              	                new ItemStack(additem, kazu1), new Ingredient[]{ 
			              	            		Ingredient.fromItem(itema),
			              	            		Ingredient.fromItem(itemb),
			              	            		Ingredient.fromItem(itemc),
			              	            		Ingredient.fromItem(itemd)
		                					});
		              			  }
		              			else if(itemf == Items.AIR) {
		              				GameRegistry.addShapelessRecipe(
		                					new ResourceLocation(type[2]),
			              	                new ResourceLocation("handmadeguns2"),
			              	                new ItemStack(additem, kazu1), new Ingredient[]{ 
			              	            		Ingredient.fromItem(itema),
			              	            		Ingredient.fromItem(itemb),
			              	            		Ingredient.fromItem(itemc),
			              	            		Ingredient.fromItem(itemd),
			              	            		Ingredient.fromItem(iteme)
		                					});
		              			  }
		              			else if(itemg == Items.AIR) {
		              				GameRegistry.addShapelessRecipe(
		                					new ResourceLocation(type[2]),
			              	                new ResourceLocation("handmadeguns2"),
			              	                new ItemStack(additem, kazu1), new Ingredient[]{ 
			              	            		Ingredient.fromItem(itema),
			              	            		Ingredient.fromItem(itemb),
			              	            		Ingredient.fromItem(itemc),
			              	            		Ingredient.fromItem(itemd),
			              	            		Ingredient.fromItem(iteme),
			              	            		Ingredient.fromItem(itemf)
		                					});
		              			  }
		              			else if(itemh == Items.AIR) {
		              				GameRegistry.addShapelessRecipe(
		                					new ResourceLocation(type[2]),
			              	                new ResourceLocation("handmadeguns2"),
			              	                new ItemStack(additem, kazu1), new Ingredient[]{ 
			              	            		Ingredient.fromItem(itema),
			              	            		Ingredient.fromItem(itemb),
			              	            		Ingredient.fromItem(itemc),
			              	            		Ingredient.fromItem(itemd),
			              	            		Ingredient.fromItem(iteme),
			              	            		Ingredient.fromItem(itemf),
			              	            		Ingredient.fromItem(itemg)
		                					});
		              			  }
		              			else if(itemi == Items.AIR) {
		              				GameRegistry.addShapelessRecipe(
		                					new ResourceLocation(type[2]),
			              	                new ResourceLocation("handmadeguns2"),
			              	                new ItemStack(additem, kazu1), new Ingredient[]{ 
			              	            		Ingredient.fromItem(itema),
			              	            		Ingredient.fromItem(itemb),
			              	            		Ingredient.fromItem(itemc),
			              	            		Ingredient.fromItem(itemd),
			              	            		Ingredient.fromItem(iteme),
			              	            		Ingredient.fromItem(itemf),
			              	            		Ingredient.fromItem(itemg),
			              	            		Ingredient.fromItem(itemh)
		                					});
		              			  }
		              			else {
		              				GameRegistry.addShapelessRecipe(
		                					new ResourceLocation(type[2]),
			              	                new ResourceLocation("handmadeguns2"),
			              	                new ItemStack(additem, kazu1), new Ingredient[]{ 
			              	            		Ingredient.fromItem(itema),
			              	            		Ingredient.fromItem(itemb), 
			              	            		Ingredient.fromItem(itemc),
			              	            		Ingredient.fromItem(itemd),
			              	            		Ingredient.fromItem(iteme),
			              	            		Ingredient.fromItem(itemf),
			              	            		Ingredient.fromItem(itemg),
			              	            		Ingredient.fromItem(itemh),
			              	            		Ingredient.fromItem(itemi)
		                					});
		              			  }
		              			  
		              			  
	                			/*GameRegistry.addShapelessRecipe(
	                					new ResourceLocation(type[2]),
		              	                new ResourceLocation("handmadeguns2"),
		              	                new ItemStack(additem, kazu1), new Ingredient[]{ 
		              	            		Ingredient.fromItem(itema),
		              	            		Ingredient.fromItem(itemb), 
		              	            		Ingredient.fromItem(itemc),
		              	            		Ingredient.fromItem(itemd),
		              	            		Ingredient.fromItem(iteme),
		              	            		Ingredient.fromItem(itemf),
		              	            		Ingredient.fromItem(itemg),
		              	            		Ingredient.fromItem(itemh),
		              	            		Ingredient.fromItem(itemi)
	                					});*/
	                		}
	                		if(type[0].equals("reset")){
	                			itema = Item.getItemById(0);
	                			itemb = Item.getItemById(0);
	                			itemc = Item.getItemById(0);
	                			itemd = Item.getItemById(0);
	                			iteme = Item.getItemById(0);
	                			itemf = Item.getItemById(0);
	                			itemg = Item.getItemById(0);
	                			itemh = Item.getItemById(0);
	                			itemi = Item.getItemById(0);
	                			re1 = "abc";
	                			re2 = "def";
	                			re3 = "ghi";
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
	    				File.separatorChar + "lang"+ File.separatorChar +  "gunname" + File.separatorChar + GunName);
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