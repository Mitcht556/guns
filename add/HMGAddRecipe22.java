package handmadeguns2.add;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import gvclib.LoadGunStatusBase;
import gvclib.RecoilMotionReader;
import gvclib.ReloadMotionReader;
import gvclib.item.ItemGunBase;
import gvclib.item.ItemGun_AR;
import gvclib.item.ItemGun_Grenade;
import gvclib.item.ItemGun_SR;
import gvclib.item.ItemGun_SWORD;
import gvclib.item.ItemGun_Shield;
import handmadeguns2.mod_HandmadeGuns2;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import objmodel.AdvancedModelLoader;

public class HMGAddRecipe22 {
	
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
	
	  static boolean addlist = true;
	  
	static int sell_eme;
	  static int sell_iron;
	  static int sell_red;
	
	  static String USname = null;
	  static String JPname = null;
	  
	public static void load(boolean isClient, InputStream inputStream, String domain,  RegistryEvent.Register<Item> event) {
		
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

			addlist = true;
			
			sell_eme = 1;
			sell_iron = 1;
			sell_red = 1;
			USname = null;
			JPname = null;
		}
		
		Item newgun = null;
		try {
			
			// File file = new File(configfile,"hmg_handmadeguns.txt");
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
				//BufferedReader br = new BufferedReader(new FileReader(file)); // ファイルを開く

				String str;
				while ((str = br.readLine()) != null) { // 1行ずつ読み込む
					// System.out.println(str);
					String[] type = str.split(",");

					int guntype = 0;

					if (type.length != 0) {// 1
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
					}
				}
				br.close(); // ファイルを閉じる
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
