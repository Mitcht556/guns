package handmadeguns2.add;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gvclib.item.ItemArmor_NewObj;
import gvclib.item.ItemArmor_NewVanilla;
import handmadeguns2.mod_HandmadeGuns2;
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

public class HMGAddArmor2
{
  static List<ArrayList<String>> mainList = new ArrayList();
  public static List Guns = new ArrayList();
  
  static String GunName = null;
  static String Namegun = null;
  static String FileName = null;
  static int kazu;
  static double health;
  static boolean canex;
  static String texture;
  static Item[] addi;
  public static List addit = new ArrayList();
  
  static Item magazine;;
  
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
  
  static String armortex;
  static String armorobj;
  
  static int part;
  
  static int damage;
  
  static int hardness;
  
  static boolean r_h;
  static boolean r_b;
  static boolean r_ra;
  static boolean r_la;
  static boolean r_rl;
  static boolean r_ll;
  
  static double motion = 1D;
  static boolean booster = false;
  static boolean para = false;
  static boolean fall = false;
  static double paraspeed = 0.4;
  
  //0305
  static boolean ga;
  static String gatex;
  static float tou;
  static boolean tps;
  
  //10/31
  static int sell_eme;
  static int sell_iron;
  static int sell_red;
  
  public static void load(boolean isClient, File file1, RegistryEvent.Register<Item> event)
  {
	  {
		  health = 100D;
		  Namegun = null;
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
		   damage = 430;
		   part = 1;
		   hardness = 2;
		   r_h = true;
		   r_b = true;
		   r_ra = true;
		   r_la = true;
		   r_rl = true;
		   r_ll = true;
		   
		   motion = 1D;
		   booster = false;
		   para = false;
		   fall = false;
		   paraspeed = 0.4D;
		   
		   ga = false;
		   gatex = null;
		   tou = 1.0F;
		   tps = true;
		   
		   sell_eme = 1;
			 sell_iron = 1;
			 sell_red = 1;
	  }
	  
	  
	  try {
		  File file = file1;
          if (checkBeforeReadfile(file))
          {
        	  BufferedReader br = new BufferedReader(new FileReader(file));  // ファイルを開く
          
          String str;
          while((str = br.readLine()) != null){  // 1行ずつ読み込む
        	  String[] type = str.split(",");
        	  int guntype = 0;
        	  if (type.length != 0)
              {//1
        			  if(type[0].equals("Texture")){
        				  texture = type[1];
            		  }
        			  if(type[0].equals("ArmorTexture")){
        				  armortex = type[1];
            		  }
        			  if(type[0].equals("ArmorObj")){
        				  armorobj = type[1];
            		  }
        			  if (type[0].equals("ArmorDamage")) {
        				  damage = Integer.parseInt(type[1]);
						}
        			  if (type[0].equals("ArmorParts")) {
        				  part = Integer.parseInt(type[1]);
						}
        			  
        			  if (type[0].equals("Hardness")) {
        				  hardness = Integer.parseInt(type[1]);
						}
        			  
        			  if (type[0].equals("Render_Head")) {
        				  r_h = Boolean.parseBoolean(type[1]);
						}
        			  if (type[0].equals("Render_Body")) {
        				  r_b = Boolean.parseBoolean(type[1]);
						}
        			  if (type[0].equals("Render_RightArm")) {
        				  r_ra = Boolean.parseBoolean(type[1]);
						}
        			  if (type[0].equals("Render_LeftArm")) {
        				  r_la = Boolean.parseBoolean(type[1]);
						}
        			  if (type[0].equals("Render_RightLeg")) {
        				  r_rl = Boolean.parseBoolean(type[1]);
						}
        			  if (type[0].equals("Render_LeftLeg")) {
        				  r_ll = Boolean.parseBoolean(type[1]);
						}
        			  
        			  //0214
        			  if (type[0].equals("Motion")) {
        				  motion = Double.parseDouble(type[1]);
						}
        			  if (type[0].equals("Booster")) {
        				  booster = Boolean.parseBoolean(type[1]);
						}
        			  if (type[0].equals("Parachute")) {
        				  para = Boolean.parseBoolean(type[1]);
						}
        			  if (type[0].equals("ResistanceFall")) {
        				  fall = Boolean.parseBoolean(type[1]);
						}
        			  if (type[0].equals("ParachuteSpeed")) {
        				  paraspeed = Double.parseDouble(type[1]);
						}
        			  
        			  
        			  //0305
        			  if (type[0].equals("Head_Overlay")) {
        				  ga = Boolean.parseBoolean(type[1]);
						}
        			  if(type[0].equals("OverlayTexture")){
        				  gatex = type[1];
            		  }
        			  if (type[0].equals("Transparency")) {
        				  tou = Float.parseFloat(type[1]);
						}
        			  if (type[0].equals("Overlay_TPS")) {
        				  tps = Boolean.parseBoolean(type[1]);
						}
        			          		
        			  if (type[0].equals("Sell_EMERALD")) {
							sell_eme = Integer.parseInt(type[1]);
						}
						if (type[0].equals("Sell_IRONINGOT")) {
							sell_iron = Integer.parseInt(type[1]);
						}
						if (type[0].equals("Sell_REDSTONE")) {
							sell_red = Integer.parseInt(type[1]);
						}
        			  
        			  if(type[0].equals("Name")){
        				  Namegun = type[1];
            		  }
        			  
        			  
        			  
        			  EntityEquipmentSlot slot = null;
        			  if(part == 0){
        				  slot = slot.HEAD;
        			  }else if(part == 1){
        				  slot = slot.CHEST;
        			  }else if(part == 2){
        				  slot = slot.LEGS;
        			  }else{
        				  slot = slot.FEET;
        			  }
        			  
                		if(type[0].equals("Armor")){
                			//ArmorMaterial fuarmor = EnumHelper.addArmorMaterial("HMAArmor", damage, new int[] { 4, 10, 6, 2 }, 10);
                			ArmorMaterial fuarmor = EnumHelper.addArmorMaterial("HMAArmor",
                					"handmadeguns2:textures/armor/" + armortex, damage, 
                					new int[] {hardness, hardness, hardness, hardness }, 10, null, tou);
                			GunName = type[1];
                  			Item newgun	= new ItemArmor_NewObj(fuarmor, slot).setUnlocalizedName(GunName)
                  					.setRegistryName(mod_HandmadeGuns2.MOD_ID,GunName)
                  					.setCreativeTab(mod_HandmadeGuns2.tabhmg);
                  			event.getRegistry().register(newgun);
                    		ItemArmor_NewObj iiitem = (ItemArmor_NewObj)newgun;
                    		Add(iiitem, isClient, 0);
                    		
                    		Guns.add(newgun);
                    		{
								mod_HandmadeGuns2.am_model_item[mod_HandmadeGuns2.am_model_id] = newgun;
								mod_HandmadeGuns2.am_model_name[mod_HandmadeGuns2.am_model_id] = GunName;
								++mod_HandmadeGuns2.am_model_id;
							}
                    		mod_HandmadeGuns2.gun_eme[mod_HandmadeGuns2.gun_id] = sell_eme;
							mod_HandmadeGuns2.gun_iron[mod_HandmadeGuns2.gun_id] = sell_iron;
							mod_HandmadeGuns2.gun_red[mod_HandmadeGuns2.gun_id] = sell_red;
							mod_HandmadeGuns2.gun_item[mod_HandmadeGuns2.gun_id] = newgun;
							++mod_HandmadeGuns2.gun_id;
                		}else if(type[0].equals("Armor_Normal")){
                			//ArmorMaterial fuarmor = EnumHelper.addArmorMaterial("HMAArmor", damage, new int[] { 4, 10, 6, 2 }, 10);
                			ArmorMaterial fuarmor = EnumHelper.addArmorMaterial("HMAArmor",
                					"handmadeguns2:textures/armor/" + armortex, damage, 
                					new int[] {hardness, hardness, hardness, hardness }, 10, null, tou);
                			GunName = type[1];
                  			Item newgun	= new ItemArmor_NewVanilla(fuarmor, slot).setRegistryName(mod_HandmadeGuns2.MOD_ID,GunName)
                  					.setCreativeTab(mod_HandmadeGuns2.tabhmg);
                  			event.getRegistry().register(newgun);
                    		ItemArmor_NewVanilla iiitem = (ItemArmor_NewVanilla)newgun;
                    		AddV(iiitem, isClient, 0);
                    		
                    		Guns.add(newgun);
                    		{
								mod_HandmadeGuns2.am_model_item[mod_HandmadeGuns2.am_model_id] = newgun;
								mod_HandmadeGuns2.am_model_name[mod_HandmadeGuns2.am_model_id] = GunName;
								++mod_HandmadeGuns2.am_model_id;
							}
                    		mod_HandmadeGuns2.gun_eme[mod_HandmadeGuns2.gun_id] = sell_eme;
							mod_HandmadeGuns2.gun_iron[mod_HandmadeGuns2.gun_id] = sell_iron;
							mod_HandmadeGuns2.gun_red[mod_HandmadeGuns2.gun_id] = sell_red;
							mod_HandmadeGuns2.gun_item[mod_HandmadeGuns2.gun_id] = newgun;
							++mod_HandmadeGuns2.gun_id;
                		}else{
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
                		
                		
                		
              }//1
        	  
        	  
        	  
        	  
        	  
          }
          br.close();  // ファイルを閉じる
          }
          else 
          {
        	  
          }
      } catch (FileNotFoundException ex) {
          ex.printStackTrace();
      } catch (IOException ex) {
          ex.printStackTrace();
      }
  }
  
  private static boolean checkBeforeReadfile(File file){
	    if (file.exists()){
	      if (file.isFile() && file.canRead()){
	        return true;
	      }
	    }

	    return false;
	  }
  
  public static void Add(ItemArmor_NewObj iiitem, boolean isClient, int id){
		//0308
		iiitem.render_head = r_h;
		iiitem.render_body = r_b;
		iiitem.render_rarm = r_ra;
		iiitem.render_larm = r_la;
		iiitem.render_rleg = r_rl;
		iiitem.render_lleg = r_ll;
		//0214
		iiitem.motion = motion;
		iiitem.booster = booster;
		iiitem.para = para;
		iiitem.fall = fall;
		iiitem.paraspeed = paraspeed;
		
		//0305
		iiitem.gazo = ga;
		iiitem.gazotex = "handmadeguns2:textures/misc/" + gatex;
		iiitem.tou = tou;
		iiitem.tps = tps;
		
		if (isClient) {
			iiitem.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("handmadeguns2:textures/armor/" + armorobj));
    		iiitem.obj_tex = "handmadeguns2:textures/armor/" + armortex;
		}
}
  public static void AddV(ItemArmor_NewVanilla iiitem, boolean isClient, int id){
		//0308

		iiitem.render_head = r_h;
		iiitem.render_body = r_b;
		iiitem.render_rarm = r_ra;
		iiitem.render_larm = r_la;
		iiitem.render_rleg = r_rl;
		iiitem.render_lleg = r_ll;
		//0214
		iiitem.motion = motion;
		iiitem.booster = booster;
		iiitem.para = para;
		iiitem.fall = fall;
		iiitem.paraspeed = paraspeed;
		
		//0305
		iiitem.gazo = ga;
		iiitem.gazotex = gatex;
		iiitem.tou = tou;
		iiitem.tps = tps;
		
		if (isClient) {
			iiitem.obj_model = AdvancedModelLoader.loadModel(new ResourceLocation("handmadeguns2:textures/armor/" + armorobj));
  		iiitem.obj_tex = "handmadeguns2:textures/armor/" + armortex;
		}
}
  
}

