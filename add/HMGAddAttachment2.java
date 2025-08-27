package handmadeguns2.add;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import gvclib.LoadAttachmentStausBase;
import gvclib.item.ItemAttachment;
import handmadeguns2.mod_HandmadeGuns2;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import objmodel.AdvancedModelLoader;

public class HMGAddAttachment2 {

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
	
	static int sell_eme;
	  static int sell_iron;
	  static int sell_red;
	
	public static void load(boolean isClient, File file1, RegistryEvent.Register<Item> event) {
		
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

			sell_eme = 1;
			sell_iron = 1;
			sell_red = 1;
		}
		
		Item newgun = null;
		try {
			File file = file1;
			// File file = new File(configfile,"hmg_handmadeguns.txt");
			if (checkBeforeReadfile(file)) {
				BufferedReader br = new BufferedReader(new FileReader(file)); // ファイルを開く

				String str;
				while ((str = br.readLine()) != null) { // 1行ずつ読み込む
					// System.out.println(str);
					String[] type = str.split(",");

					int guntype = 0;

					if (type.length != 0) {// 1
						
						
						if (type[0].equals("Model_Sight")) {
							String GunName = type[1];
							newgun = new ItemAttachment().setUnlocalizedName(GunName).setRegistryName(mod_HandmadeGuns2.MOD_ID,GunName)
											.setCreativeTab(mod_HandmadeGuns2.tabhmg);
							{
                				ItemAttachment am = (ItemAttachment)newgun;
                				am.id = 101;
                			}
							event.getRegistry().register(newgun);
							{
								mod_HandmadeGuns2.am_model_item[mod_HandmadeGuns2.am_model_id] = newgun;
								mod_HandmadeGuns2.am_model_name[mod_HandmadeGuns2.am_model_id] = GunName;
								++mod_HandmadeGuns2.am_model_id;
							}
						}
						if (type[0].equals("Model_Light")) {
							String GunName = type[1];
							newgun = new ItemAttachment().setUnlocalizedName(GunName).setRegistryName(mod_HandmadeGuns2.MOD_ID,GunName)
											.setCreativeTab(mod_HandmadeGuns2.tabhmg);
							{
                				ItemAttachment am = (ItemAttachment)newgun;
                				am.id = 102;
                			}
							event.getRegistry().register(newgun);
							{
								mod_HandmadeGuns2.am_model_item[mod_HandmadeGuns2.am_model_id] = newgun;
								mod_HandmadeGuns2.am_model_name[mod_HandmadeGuns2.am_model_id] = GunName;
								++mod_HandmadeGuns2.am_model_id;
							}
						}
						if (type[0].equals("Model_Suppressor")) {
							String GunName = type[1];
							newgun = new ItemAttachment().setUnlocalizedName(GunName).setRegistryName(mod_HandmadeGuns2.MOD_ID,GunName)
											.setCreativeTab(mod_HandmadeGuns2.tabhmg);
							{
                				ItemAttachment am = (ItemAttachment)newgun;
                				am.id = 8;
                			}
							event.getRegistry().register(newgun);
							{
								mod_HandmadeGuns2.am_model_item[mod_HandmadeGuns2.am_model_id] = newgun;
								mod_HandmadeGuns2.am_model_name[mod_HandmadeGuns2.am_model_id] = GunName;
								++mod_HandmadeGuns2.am_model_id;
							}
						}
						if (type[0].equals("Model_Grip")) {
							String GunName = type[1];
							newgun = new ItemAttachment().setUnlocalizedName(GunName).setRegistryName(mod_HandmadeGuns2.MOD_ID,GunName)
											.setCreativeTab(mod_HandmadeGuns2.tabhmg);
							{
                				ItemAttachment am = (ItemAttachment)newgun;
                				am.id = 9;
                			}
							event.getRegistry().register(newgun);
							{
								mod_HandmadeGuns2.am_model_item[mod_HandmadeGuns2.am_model_id] = newgun;
								mod_HandmadeGuns2.am_model_name[mod_HandmadeGuns2.am_model_id] = GunName;
								++mod_HandmadeGuns2.am_model_id;
							}
						}
						if (type[0].equals("Magazine")) {
							String GunName = type[1];
							newgun = new ItemAttachment().setUnlocalizedName(GunName).setRegistryName(mod_HandmadeGuns2.MOD_ID,GunName)
											.setCreativeTab(mod_HandmadeGuns2.tabhmg);
							{
                				ItemAttachment am = (ItemAttachment)newgun;
                				am.id = 0;
                			}
							event.getRegistry().register(newgun);
							{
								mod_HandmadeGuns2.am_model_item[mod_HandmadeGuns2.am_model_id] = newgun;
								mod_HandmadeGuns2.am_model_name[mod_HandmadeGuns2.am_model_id] = GunName;
								++mod_HandmadeGuns2.am_model_id;
							}
						}
						if (type[0].equals("Bullet")) {
							String GunName = type[1];
							newgun = new ItemAttachment().setUnlocalizedName(GunName).setRegistryName(mod_HandmadeGuns2.MOD_ID,GunName)
											.setCreativeTab(mod_HandmadeGuns2.tabhmg);
							{
                				ItemAttachment am = (ItemAttachment)newgun;
                				am.id = 0;
                			}
							event.getRegistry().register(newgun);
							{
								mod_HandmadeGuns2.am_model_item[mod_HandmadeGuns2.am_model_id] = newgun;
								mod_HandmadeGuns2.am_model_name[mod_HandmadeGuns2.am_model_id] = GunName;
								++mod_HandmadeGuns2.am_model_id;
							}
						}
						
						if(newgun != null && newgun instanceof  ItemAttachment) {
							ItemAttachment gun = (ItemAttachment) newgun;
							
							if(type[0].equals("Model")){
								gun.objtrue =Boolean.parseBoolean(type[1]);
		            		  }
							if(mod_HandmadeGuns2.proxy.getClient()){
								if (type[0].equals("ObjModel")) {
									gun.obj_model = AdvancedModelLoader
											.loadModel(new ResourceLocation("handmadeguns2:textures/model/" + type[1]));
									gun.obj_model_string = type[1];
								}
								if (type[0].equals("ObjTexture")) {
									gun.obj_tex = "handmadeguns2:textures/model/" + type[1];
								}
								
							}
							if(type[0].equals("Stack")){
								gun.setMaxStackSize(Integer.parseInt(type[1]));
		            	   }
							
							if (type[0].equals("Zoom")) {
								gun.zoom = Float.parseFloat(type[1]);
							}
							if (type[0].equals("Eye_Relief")) {
								gun.eye_relief = Float.parseFloat(type[1]);
							}
							if (type[0].equals("ScopeTexture")) {
								gun.ads_tex = type[1];
							}
							if (type[0].equals("ZoomRender")) {
								gun.zoomrender = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("ZoomRenderHUD")) {
								gun.zoomrendertex = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("CenterPoint")) {
								gun.x = Float.parseFloat(type[1]);
								gun.y = Float.parseFloat(type[2]);
								gun.z = Float.parseFloat(type[3]);
							}
							if (type[0].equals("RoteAngle")) {
								gun.xr = Float.parseFloat(type[1]);
								gun.yr = Float.parseFloat(type[2]);
								gun.zr = Float.parseFloat(type[3]);
							}
							if (type[0].equals("Light_KAZU")) {
								gun.light_kazu = Integer.parseInt(type[1]);
							}
							if (type[0].equals("ColorLevel")) {
								for(int ii = 0; ii < gun.light_kazu; ++ii) {
									gun.colorlevel[ii] = Float.parseFloat(type[1 + ii]);
								}
							}
							if (type[0].equals("AntiRecoil")) {
								gun.recoil = Double.parseDouble(type[1]);
							}
							if (type[0].equals("AntiRecoil_ADS")) {
								gun.recoil_ads = Double.parseDouble(type[1]);
							}
							if (type[0].equals("AntiBure")) {
								gun.bure = Float.parseFloat(type[1]);
							}
							if (type[0].equals("AntiBure_ADS")) {
								gun.bure_ads = Float.parseFloat(type[1]);
							}
							if (type[0].equals("BulletPowerLevel")) {
								gun.power = Float.parseFloat(type[1]);
							}
							if (type[0].equals("BulletExLevel")) {
								gun.exlevel = Float.parseFloat(type[1]);
							}
							if(type[0].equals("BulletPotionID")){
								gun.p_id = Integer.parseInt(type[1]);
		            		  }
							if (type[0].equals("PotionLevel")) {
								gun.p_level = Integer.parseInt(type[1]);
							}
							if (type[0].equals("PotionTime")) {
								gun.p_time = Integer.parseInt(type[1]);
							}
							if(type[0].equals("BulletID")){
								gun.bulletid = Integer.parseInt(type[1]);
		            		  }
							if (type[0].equals("Pellet_GunBase")) {
								gun.notpelletbase = Boolean.parseBoolean(type[1]);
							}
							if(type[0].equals("Pellet")){
								gun.pellet = Integer.parseInt(type[1]);
		            		  }
							if (type[0].equals("RenderingLight")) {
								gun.rendering_light = Boolean.parseBoolean(type[1]);
							}
							
							if (type[0].equals("Grip_Can_Grip")) {
								gun.grip_gripping_point = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("Grip_Can_GripPoint")) {
								gun.grip_gripping_point_x = Float.parseFloat(type[1]);
								gun.grip_gripping_point_y = Float.parseFloat(type[2]);
								gun.grip_gripping_point_z = Float.parseFloat(type[3]);
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
						}
					}
				}
				br.close(); // ファイルを閉じる
			} else {

			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		if(newgun != null && newgun instanceof  ItemAttachment) {
			ItemAttachment gun = (ItemAttachment) newgun;
			if(gun.obj_model != null) {
				LoadAttachmentStausBase.load(gun, event);
			}
		}
		
		
	}

	private static boolean checkBeforeReadfile(File file) {
		if (file.exists()) {
			if (file.isFile() && file.canRead()) {
				return true;
			}
		}

		return false;
	}
}

