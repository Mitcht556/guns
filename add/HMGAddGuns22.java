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
import handmadeguns2.block.Block_Crafter2E;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import objmodel.AdvancedModelLoader;

public class HMGAddGuns22 {
	
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
	  
	  static String tag = null;
	  
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
			
			tag = null;
		}
		boolean itemdome = false;
		String item_domain_name = null;
		
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
						
						if (type[0].equals("ADD_LIST")) {
							addlist = Boolean.parseBoolean(type[1]);
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
						if (type[0].equals("USname")) {
							USname = type[1];
						}
						if (type[0].equals("JPname")) {
							JPname = type[1];
						}
						
						if (type[0].equals("Crafter")) {
							tag = type[1];
						}
						if (type[0].equals("Item_domain")) {
							itemdome = Boolean.parseBoolean(type[1]);
							if(itemdome) {
								item_domain_name = type[2];
							}
						}
						
						if (type[0].equals("SEMIAUTO")) {
							String GunName = type[1];
							newgun = new ItemGun_SR().setUnlocalizedName(GunName).setRegistryName(mod_HandmadeGuns2.MOD_ID,GunName)
											.setCreativeTab(mod_HandmadeGuns2.tabhmg);
							ItemGunBase gun = (ItemGunBase) newgun;
							event.getRegistry().register(newgun);
							{
								mod_HandmadeGuns2.gun_model_item[mod_HandmadeGuns2.gun_model_id] = newgun;
								{//24/01/03
									if(item_domain_name != null) {
										mod_HandmadeGuns2.gun_model_item_domain[mod_HandmadeGuns2.gun_model_id] = item_domain_name;
									}else {
										mod_HandmadeGuns2.gun_model_item_domain[mod_HandmadeGuns2.gun_model_id] = null;
									}
								}
								mod_HandmadeGuns2.gun_model_name[mod_HandmadeGuns2.gun_model_id] = GunName;
								++mod_HandmadeGuns2.gun_model_id;
							}
							if(addlist){
								mod_HandmadeGuns2.gun_eme[mod_HandmadeGuns2.gun_id] = sell_eme;
								mod_HandmadeGuns2.gun_iron[mod_HandmadeGuns2.gun_id] = sell_iron;
								mod_HandmadeGuns2.gun_red[mod_HandmadeGuns2.gun_id] = sell_red;
								mod_HandmadeGuns2.gun_item[mod_HandmadeGuns2.gun_id] = newgun;
								++mod_HandmadeGuns2.gun_id;
							}
							createlang(GunName);
							{
								if(tag != null) {
									System.out.println(String.format("aaaaaaaaaaaaaaaaaaaaa"));
									for(int g = 0;g < mod_HandmadeGuns2.counter_crafter_counter; ++g) {
										if(mod_HandmadeGuns2.craftercount[g].equals(tag)) {
										//	Block block = (Block)Block.REGISTRY.getObject(new ResourceLocation(mod_HandmadeGuns2.MOD_ID + ":" + tag));
										//	ItemBlock bitem = new ItemBlock(block);
											mod_HandmadeGuns2.guncount[mod_HandmadeGuns2.counter_crafter][g] = GunName;
											mod_HandmadeGuns2.emecount[mod_HandmadeGuns2.counter_crafter][g] = sell_eme;
											mod_HandmadeGuns2.crafter_gunid[mod_HandmadeGuns2.counter_crafter] = mod_HandmadeGuns2.counter_crafter;
											mod_HandmadeGuns2.crafter_gunid_tag[mod_HandmadeGuns2.counter_crafter] = tag;
											++mod_HandmadeGuns2.counter_crafter;
											break;
										}
									}
									
									/*Block block;
		                			block = (Block)Block.REGISTRY.getObject(new ResourceLocation(mod_HandmadeGuns2.MOD_ID + ":" + tag));
		                			//TileEntity tileentity = block
		                			if(block != null) {
		                				System.out.println(String.format("VVVVVVVVVVVVVVVVVVVVVVVVvv"));
		                				Block_Crafter2E be = (Block_Crafter2E) block;
		                				be.guncount[be.counter] = newgun;
		                				be.emecount[be.counter] = sell_eme;
		                				++be.counter;
		                			}*/
								}
							}
						}
						if (type[0].equals("FULLAUTO")) {
							String GunName = type[1];
							newgun = new ItemGun_AR().setUnlocalizedName(GunName).setRegistryName(mod_HandmadeGuns2.MOD_ID,GunName)
											.setCreativeTab(mod_HandmadeGuns2.tabhmg);
							ItemGunBase gun = (ItemGunBase) newgun;
							event.getRegistry().register(newgun);
							{
								mod_HandmadeGuns2.gun_model_item[mod_HandmadeGuns2.gun_model_id] = newgun;
								{//24/01/03
									if(item_domain_name != null) {
										mod_HandmadeGuns2.gun_model_item_domain[mod_HandmadeGuns2.gun_model_id] = item_domain_name;
									}else {
										mod_HandmadeGuns2.gun_model_item_domain[mod_HandmadeGuns2.gun_model_id] = null;
									}
								}
								mod_HandmadeGuns2.gun_model_name[mod_HandmadeGuns2.gun_model_id] = GunName;
								++mod_HandmadeGuns2.gun_model_id;
							}
							if(addlist){
								mod_HandmadeGuns2.gun_eme[mod_HandmadeGuns2.gun_id] = sell_eme;
								mod_HandmadeGuns2.gun_iron[mod_HandmadeGuns2.gun_id] = sell_iron;
								mod_HandmadeGuns2.gun_red[mod_HandmadeGuns2.gun_id] = sell_red;
								mod_HandmadeGuns2.gun_item[mod_HandmadeGuns2.gun_id] = newgun;
								++mod_HandmadeGuns2.gun_id;
							}
							createlang(GunName);
							{
								if(tag != null) {
									System.out.println(String.format("aaaaaaaaaaaaaaaaaaaaa"));
									for(int g = 0;g < mod_HandmadeGuns2.counter_crafter_counter; ++g) {
										if(mod_HandmadeGuns2.craftercount[g].equals(tag)) {
											mod_HandmadeGuns2.guncount[mod_HandmadeGuns2.counter_crafter][g] = GunName;
											mod_HandmadeGuns2.emecount[mod_HandmadeGuns2.counter_crafter][g] = sell_eme;
											mod_HandmadeGuns2.crafter_gunid[mod_HandmadeGuns2.counter_crafter] = mod_HandmadeGuns2.counter_crafter;
											mod_HandmadeGuns2.crafter_gunid_tag[mod_HandmadeGuns2.counter_crafter] = tag;
											++mod_HandmadeGuns2.counter_crafter;
											break;
										}
									}
									
									/*Block block;
		                			block = (Block)Block.REGISTRY.getObject(new ResourceLocation(mod_HandmadeGuns2.MOD_ID + ":" + tag));
		                			//TileEntity tileentity = block
		                			if(block != null) {
		                				System.out.println(String.format("VVVVVVVVVVVVVVVVVVVVVVVVvv"));
		                				Block_Crafter2E be = (Block_Crafter2E) block;
		                				be.guncount[be.counter] = newgun;
		                				be.emecount[be.counter] = sell_eme;
		                				++be.counter;
		                			}*/
								}
							}
						}
						if (type[0].equals("GRENADE")) {
							String GunName = type[1];
							newgun = new ItemGun_Grenade().setUnlocalizedName(GunName).setRegistryName(mod_HandmadeGuns2.MOD_ID,GunName)
											.setCreativeTab(mod_HandmadeGuns2.tabhmg);
							ItemGunBase gun = (ItemGunBase) newgun;
							event.getRegistry().register(newgun);
							{
								mod_HandmadeGuns2.gun_model_item[mod_HandmadeGuns2.gun_model_id] = newgun;
								{//24/01/03
									if(itemdome && item_domain_name != null) {
										mod_HandmadeGuns2.gun_model_item_domain[mod_HandmadeGuns2.gun_model_id] = item_domain_name;
									}else {
										mod_HandmadeGuns2.gun_model_item_domain[mod_HandmadeGuns2.gun_model_id] = null;
									}
								}
								mod_HandmadeGuns2.gun_model_name[mod_HandmadeGuns2.gun_model_id] = GunName;
								++mod_HandmadeGuns2.gun_model_id;
							}
							if(addlist){
								mod_HandmadeGuns2.gun_eme[mod_HandmadeGuns2.gun_id] = sell_eme;
								mod_HandmadeGuns2.gun_iron[mod_HandmadeGuns2.gun_id] = sell_iron;
								mod_HandmadeGuns2.gun_red[mod_HandmadeGuns2.gun_id] = sell_red;
								mod_HandmadeGuns2.gun_item[mod_HandmadeGuns2.gun_id] = newgun;
								++mod_HandmadeGuns2.gun_id;
							}
							createlang(GunName);
							if(tag != null) {
								System.out.println(String.format("aaaaaaaaaaaaaaaaaaaaa"));
								for(int g = 0;g < mod_HandmadeGuns2.counter_crafter_counter; ++g) {
									if(mod_HandmadeGuns2.craftercount[g].equals(tag)) {
										mod_HandmadeGuns2.guncount[mod_HandmadeGuns2.counter_crafter][g] = GunName;
										mod_HandmadeGuns2.emecount[mod_HandmadeGuns2.counter_crafter][g] = sell_eme;
										mod_HandmadeGuns2.crafter_gunid[mod_HandmadeGuns2.counter_crafter] = mod_HandmadeGuns2.counter_crafter;
										mod_HandmadeGuns2.crafter_gunid_tag[mod_HandmadeGuns2.counter_crafter] = tag;
										++mod_HandmadeGuns2.counter_crafter;
										break;
									}
								}
							}
						}
						if (type[0].equals("SHIELD")) {
							String GunName = type[1];
							newgun = new ItemGun_Shield().setUnlocalizedName(GunName).setRegistryName(mod_HandmadeGuns2.MOD_ID,GunName)
											.setCreativeTab(mod_HandmadeGuns2.tabhmg);
							ItemGunBase gun = (ItemGunBase) newgun;
							event.getRegistry().register(newgun);
							{
								mod_HandmadeGuns2.gun_model_item[mod_HandmadeGuns2.gun_model_id] = newgun;
								{//24/01/03
									if(itemdome && item_domain_name != null) {
										mod_HandmadeGuns2.gun_model_item_domain[mod_HandmadeGuns2.gun_model_id] = item_domain_name;
									}else {
										mod_HandmadeGuns2.gun_model_item_domain[mod_HandmadeGuns2.gun_model_id] = null;
									}
								}
								mod_HandmadeGuns2.gun_model_name[mod_HandmadeGuns2.gun_model_id] = GunName;
								++mod_HandmadeGuns2.gun_model_id;
							}
							if(addlist){
								mod_HandmadeGuns2.gun_eme[mod_HandmadeGuns2.gun_id] = sell_eme;
								mod_HandmadeGuns2.gun_iron[mod_HandmadeGuns2.gun_id] = sell_iron;
								mod_HandmadeGuns2.gun_red[mod_HandmadeGuns2.gun_id] = sell_red;
								mod_HandmadeGuns2.gun_item[mod_HandmadeGuns2.gun_id] = newgun;
								++mod_HandmadeGuns2.gun_id;
							}
							createlang(GunName);
							if(tag != null) {
								System.out.println(String.format("aaaaaaaaaaaaaaaaaaaaa"));
								for(int g = 0;g < mod_HandmadeGuns2.counter_crafter_counter; ++g) {
									if(mod_HandmadeGuns2.craftercount[g].equals(tag)) {
										mod_HandmadeGuns2.guncount[mod_HandmadeGuns2.counter_crafter][g] = GunName;
										mod_HandmadeGuns2.emecount[mod_HandmadeGuns2.counter_crafter][g] = sell_eme;
										mod_HandmadeGuns2.crafter_gunid[mod_HandmadeGuns2.counter_crafter] = mod_HandmadeGuns2.counter_crafter;
										mod_HandmadeGuns2.crafter_gunid_tag[mod_HandmadeGuns2.counter_crafter] = tag;
										++mod_HandmadeGuns2.counter_crafter;
										break;
									}
								}
							}
						}
						if (type[0].equals("SWORD")) {
							String GunName = type[1];
							newgun = new ItemGun_SWORD().setUnlocalizedName(GunName).setRegistryName(mod_HandmadeGuns2.MOD_ID,GunName)
											.setCreativeTab(mod_HandmadeGuns2.tabhmg);
							ItemGunBase gun = (ItemGunBase) newgun;
							event.getRegistry().register(newgun);
							{
								mod_HandmadeGuns2.gun_model_item[mod_HandmadeGuns2.gun_model_id] = newgun;
								{//24/01/03
									if(itemdome && item_domain_name != null) {
										mod_HandmadeGuns2.gun_model_item_domain[mod_HandmadeGuns2.gun_model_id] = item_domain_name;
									}else {
										mod_HandmadeGuns2.gun_model_item_domain[mod_HandmadeGuns2.gun_model_id] = null;
									}
								}
								mod_HandmadeGuns2.gun_model_name[mod_HandmadeGuns2.gun_model_id] = GunName;
								++mod_HandmadeGuns2.gun_model_id;
							}
							if(addlist){
								mod_HandmadeGuns2.gun_eme[mod_HandmadeGuns2.gun_id] = sell_eme;
								mod_HandmadeGuns2.gun_iron[mod_HandmadeGuns2.gun_id] = sell_iron;
								mod_HandmadeGuns2.gun_red[mod_HandmadeGuns2.gun_id] = sell_red;
								mod_HandmadeGuns2.gun_item[mod_HandmadeGuns2.gun_id] = newgun;
								++mod_HandmadeGuns2.gun_id;
							}
							createlang(GunName);
							if(tag != null) {
								System.out.println(String.format("aaaaaaaaaaaaaaaaaaaaa"));
								for(int g = 0;g < mod_HandmadeGuns2.counter_crafter_counter; ++g) {
									if(mod_HandmadeGuns2.craftercount[g].equals(tag)) {
										mod_HandmadeGuns2.guncount[mod_HandmadeGuns2.counter_crafter][g] = GunName;
										mod_HandmadeGuns2.emecount[mod_HandmadeGuns2.counter_crafter][g] = sell_eme;
										mod_HandmadeGuns2.crafter_gunid[mod_HandmadeGuns2.counter_crafter] = mod_HandmadeGuns2.counter_crafter;
										mod_HandmadeGuns2.crafter_gunid_tag[mod_HandmadeGuns2.counter_crafter] = tag;
										++mod_HandmadeGuns2.counter_crafter;
										break;
									}
								}
							}
						}
						if(newgun != null && newgun instanceof  ItemGunBase) {
							ItemGunBase gun = (ItemGunBase) newgun;
							
							if(mod_HandmadeGuns2.proxy.getClient()){
								gun.canobj = true;
								gun.obj_true = true;
								if (type[0].equals("ObjModel")) {
									gun.obj_model = AdvancedModelLoader
											.loadModel(new ResourceLocation("handmadeguns2:addgun/" +domain + "/addmodel/" + type[1]));
								}
								if (type[0].equals("ObjTexture")) {
									gun.obj_tex = "handmadeguns2:addgun/" +domain + "/addmodel/" + type[1];
								}
								gun.arm_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvclib:textures/model/arm.obj"));
								gun.arm_model2 = AdvancedModelLoader.loadModel(new ResourceLocation("gvclib:textures/model/arm2.obj"));
								gun.flash_model = AdvancedModelLoader.loadModel(new ResourceLocation("gvclib:textures/model/flash.obj"));
								{
									if (type[0].equals("Reload_Motion")) {
										gun.newreload = Boolean.parseBoolean(type[1]);
									}
									if (type[0].equals("ReloadMotionType")) {
										gun.reloadmotion = Integer.parseInt(type[1]);
									}
									String reloadm = null;
									if (type[0].equals("ReloadMotion")) {
										reloadm = type[1];
									}
									if(reloadm != null) {
									ResourceLocation reloadmotion = new ResourceLocation("handmadeguns2:addgun/" +domain + "/addreload/" + reloadm);
									ReloadMotionReader.read(gun, reloadmotion);
									}
									String recoilm = null;
									if (type[0].equals("RecoilMotionType")) {
										gun.recoilmotion = Boolean.parseBoolean(type[1]);
									}
									if (type[0].equals("RecoilMotion")) {
										recoilm = type[1];
									}
									if(recoilm != null) {
									ResourceLocation recoilmotion = new ResourceLocation("handmadeguns2:addgun/" +domain + "/addreload/" + recoilm);
									RecoilMotionReader.read(gun, recoilmotion);
									}
								}
							}
							
							gun.modid = mod_HandmadeGuns2.MOD_ID;
							LoadGunStatusBase.load(gun, event, null, type,"handmadeguns2:addgun/" +domain + "/addoverlay/","handmadeguns2:addgun/" +domain + "/addentity/");
							
							/*
							if (type[0].equals("information1")) {
								gun.information1 = type[1];
							}
							if (type[0].equals("information2")) {
								gun.information2 = type[1];
							}
							if (type[0].equals("information3")) {
								gun.information3 = type[1];
							}
							
							if(type[0].equals("Stack")){
								gun.setMaxStackSize(Integer.parseInt(type[1]));
		            	   }
							
							if (type[0].equals("Knife")) {
								gun.knife = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("Bullet_Type")) {
								gun.gun_type = gun.mobbullettype = Integer.parseInt(type[1]);
							}
							if (type[0].equals("BulletPower")) {
								gun.powor = Integer.parseInt(type[1]);
							}
							if (type[0].equals("BulletSpeed")) {
								gun.speed = Float.parseFloat(type[1]);
							}
							if (type[0].equals("BlletSpread")) {
								gun.bure = Float.parseFloat(type[1]);
							}
							if (type[0].equals("BlletSpread_ADS")) {
								gun.bure_ads = Float.parseFloat(type[1]);
							}
							if (type[0].equals("Recoil")) {
								gun.recoil = Double.parseDouble(type[1]);
							}
							if (type[0].equals("Recoil_ADS")) {
								gun.recoil_ads = Float.parseFloat(type[1]);
							}
							if (type[0].equals("ReloadTime")) {
								gun.reloadtime = Integer.parseInt(type[1]);
							}
							if (type[0].equals("RemainingBullet")) {
								gun.setMaxDamage(Integer.parseInt(type[1]));
							}
							if (type[0].equals("Attacking")) {
								gun.attackDamage = Float.parseFloat(type[1]);
							}
							if (type[0].equals("AttackingSpeed")) {
								gun.attackSpeed = Double.parseDouble(type[1]);
							}
							if (type[0].equals("Motion")) {
								gun.motion = Double.parseDouble(type[1]);
							}
							if (type[0].equals("Zoom")) {
								gun.scopezoom = Float.parseFloat(type[1]);
								gun.scopezoombase = Float.parseFloat(type[1]);
							}
							if (type[0].equals("ZoomRender")) {
								gun.model_zoomrender = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("ZoomRenderType")) {
								gun.zoomre = Boolean.parseBoolean(type[1]);
								gun.zoomren = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("ZoomRenderTypeTxture")) {
								gun.zoomrent = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("Cycle")) {
								gun.cycle = gun.cocktime = gun.mobcycle = Integer.parseInt(type[1]);
							}
							if (type[0].equals("Explosion")) {
								gun.exlevel = Float.parseFloat(type[1]);
							}
							if (type[0].equals("BlockDestory")) {
								gun.canex = Boolean.parseBoolean(type[1]);
							}
							
							//手榴弾専用
							if (type[0].equals("Explosion_Fire")) {
								gun.exfire = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("Explosion_Smoke")) {
								gun.exsmoke = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("Explosion_Flash")) {
								gun.exflash = Boolean.parseBoolean(type[1]);
							}
							
							if (type[0].equals("Bullet_living_time")) {
								gun.bullet_time_max = Integer.parseInt(type[1]);
							}
							
							gun.modid = mod_HandmadeGuns2.MOD_ID;
							if (type[0].equals("GunSound")) {
								gun.sound = type[1];
								gun.soundbase = type[1];
								gun.soundsu = type[2];
							}
							if (type[0].equals("GunSoundReload")) {
								gun.soundre = type[1];
							}
							if (type[0].equals("GunSoundCooking")) {
								gun.soundco = type[1];
							}
							
							//modelset
							if (type[0].equals("ModelEquipped")) {
								gun.model_x = Float.parseFloat(type[1]);
								gun.model_y = Float.parseFloat(type[2]);
								gun.model_z = Float.parseFloat(type[3]);
							}
							if (type[0].equals("ModelHigh")) {
								gun.model_y_ads = Float.parseFloat(type[1]);
							}
							if (type[0].equals("ModelWidthX")) {
								gun.model_x_ads = Float.parseFloat(type[1]);
							}
							if (type[0].equals("ModelWidthZ")) {
								gun.model_z_ads = Float.parseFloat(type[1]);
							}
							if (type[0].equals("ModelRotationX")) {
								gun.rotationx = Float.parseFloat(type[1]);
							}
							if (type[0].equals("ModelRotationY")) {
								gun.rotationy = Float.parseFloat(type[1]);
							}
							if (type[0].equals("ModelRotationZ")) {
								gun.rotationz = Float.parseFloat(type[1]);
							}
							
							//arm
							if (type[0].equals("ModelArm")) {
								gun.canarm = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("ModelArmOffsetR")) {
								gun.arm_r_posx = Float.parseFloat(type[1]);
								gun.arm_r_posy = Float.parseFloat(type[2]);
								gun.arm_r_posz = Float.parseFloat(type[3]);
							}
							if (type[0].equals("ModelArmOffsetL")) {
								gun.arm_l_posx = Float.parseFloat(type[1]);
								gun.arm_l_posy = Float.parseFloat(type[2]);
								gun.arm_l_posz = Float.parseFloat(type[3]);
							}
							if (type[0].equals("ModelArmScaleR")) {
								gun.arm_scale_r = Float.parseFloat(type[1]);
							}
							if (type[0].equals("ModelArmScaleL")) {
								gun.arm_scale_l = Float.parseFloat(type[1]);
							}
							
							if (type[0].equals("Mat31Point")) {
								gun.mat31posx = Float.parseFloat(type[1]);
								gun.mat31posy = Float.parseFloat(type[2]);
								gun.mat31posz = Float.parseFloat(type[3]);
							}
							if (type[0].equals("Mat31Rotation")) {
								gun.mat31rotex = Float.parseFloat(type[1]);
								gun.mat31rotey = Float.parseFloat(type[2]);
								gun.mat31rotez = Float.parseFloat(type[3]);
							}
							if (type[0].equals("Mat32Point")) {
								gun.mat32posx = Float.parseFloat(type[1]);
								gun.mat32posy = Float.parseFloat(type[2]);
								gun.mat32posz = Float.parseFloat(type[3]);
							}
							if (type[0].equals("Mat32Rotation")) {
								gun.mat32rotex = Float.parseFloat(type[1]);
								gun.mat32rotey = Float.parseFloat(type[2]);
								gun.mat32rotez = Float.parseFloat(type[3]);
							}
							
							if (type[0].equals("Mat22")) {
								gun.mat22 = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("Mat22Point")) {
								gun.mat22offsetx = Float.parseFloat(type[1]);
								gun.mat22offsety = Float.parseFloat(type[2]);
								gun.mat22offsetz = Float.parseFloat(type[3]);
							}
							if (type[0].equals("Mat22Rotation")) {
								gun.mat22rotationx = Float.parseFloat(type[1]);
								gun.mat22rotationy = Float.parseFloat(type[2]);
								gun.mat22rotationz = Float.parseFloat(type[3]);
							}
							if (type[0].equals("Mat25Point")) {
								gun.mat25offsetx = Float.parseFloat(type[1]);
								gun.mat25offsety = Float.parseFloat(type[2]);
								gun.mat25offsetz = Float.parseFloat(type[3]);
							}
							if (type[0].equals("Mat25Rotation")) {
								gun.mat25rotationx = Float.parseFloat(type[1]);
								gun.mat25rotationy = Float.parseFloat(type[2]);
								gun.mat25rotationz = Float.parseFloat(type[3]);
							}
							
							if (type[0].equals("SprintingPoint")) {
								gun.Sprintoffsetx = Float.parseFloat(type[1]);
								gun.Sprintoffsety = Float.parseFloat(type[2]);
								gun.Sprintoffsetz = Float.parseFloat(type[3]);
							}
							if (type[0].equals("SprintingRotation")) {
								gun.Sprintrotationx = Float.parseFloat(type[1]);
								gun.Sprintrotationy = Float.parseFloat(type[2]);
								gun.Sprintrotationz = Float.parseFloat(type[3]);
							}
							if (type[0].equals("ShotGun_Pellet")) {
								gun.shotgun_pellet = Integer.parseInt(type[1]);
							}
							
							if (type[0].equals("Fire_Offset_y")) {
								gun.fire_roteoffset_y = Float.parseFloat(type[1]);
							}
							
							if (type[0].equals("Cartridge")) {
								gun.bullet_c = Boolean.parseBoolean(type[1]);
							}
							
							//01/27
							if (type[0].equals("MuzzleJump")) {
								gun.jump = Float.parseFloat(type[1]);
							}
							if (type[0].equals("Mat2")) {
								gun.mat2 = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("Mat25")) {
								gun.mat25 = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("CockedLeftHand")) {
								gun.cock_left = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("ALLCocked")) {
								gun.all_jump = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("BulletGravity")) {
								gun.gra = Float.parseFloat(type[1]);
							}
							
							
							if (type[0].equals("Mat2_CockZ")) {
								gun.model_cock_z = Float.parseFloat(type[1]);
							}
							
							//0214
							if (type[0].equals("CartridgeType")) {
								gun.c_type = Integer.parseInt(type[1]);
							}
							if (type[0].equals("DropMagazine")) {
								gun.canmagazine = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("ReloadMat31")) {
								gun.remat31 = Boolean.parseBoolean(type[1]);
							}
							
							
							
							
							//
							if (type[0].equals("ScopeTexture")) {
								gun.adstexture = "handmadeguns2:addgun/" +domain + "/addoverlay/" + type[1];
							}
							if (type[0].equals("RenderCross")) {
								gun.rendercross = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("Automatic")) {
								gun.semi = Boolean.parseBoolean(type[1]);
							}

							if (type[0].equals("Reload_type")) {
								gun.reload_type = Integer.parseInt(type[1]);
							}
							
							if (type[0].equals("Magazine")) {
								int ii = Integer.parseInt(type[1]);
								if (ii == 0) {
									gun.magazine = event.getRegistry().getValue(new ResourceLocation(type[2], type[3]));
								}
							}
							if (type[0].equals("Magazine_defalt")) {
								if(gun.magazine == null) {
									int ii = Integer.parseInt(type[1]);
									if (ii == 0) {
										gun.magazine = event.getRegistry().getValue(new ResourceLocation(type[2], type[3]));
									}
								}
							}
							if (type[0].equals("MagazineSG")) {
								int ii = Integer.parseInt(type[1]);
								if (ii == 0) {
									gun.magazinesg =  event.getRegistry().getValue(new ResourceLocation(type[2], type[3]));
								}
							}
							if (type[0].equals("MagazineGL")) {
								int ii = Integer.parseInt(type[1]);
								if (ii == 0) {
									gun.magazinegl =  event.getRegistry().getValue(new ResourceLocation(type[2], type[3]));
								}
							}
							
							
							
							if (type[0].equals("Fire_point")) {
								gun.fire_posx = Float.parseFloat(type[1]);
								gun.fire_posy = Float.parseFloat(type[2]);
								gun.fire_posz = Float.parseFloat(type[3]);
							}
							if (type[0].equals("Fire_point_ADS")) {
								gun.fire_posx_ads = Float.parseFloat(type[1]);
								gun.fire_posy_ads = Float.parseFloat(type[2]);
								gun.fire_posz_ads = Float.parseFloat(type[3]);
							}
							
							
							if (type[0].equals("Bullet_Model")) {
								gun.bullet_model = "handmadeguns2:addgun/" +domain + "/addentity/" + type[1];
							}
							if (type[0].equals("Bullet_Texture")) {
								gun.bullet_tex = "handmadeguns2:addgun/" +domain + "/addentity/" + type[1];
							}
							if (type[0].equals("Flash_Model")) {
								gun.bulletf_model = "handmadeguns2:addgun/" +domain + "/addentity/" + type[1];
							}
							if (type[0].equals("Flash_Texture")) {
								gun.bulletf_tex = "handmadeguns2:addgun/" +domain + "/addentity/" + type[1];
							}
							if (type[0].equals("Cartridge_Model")) {
								gun.cartridge_model = "handmadeguns2:addgun/" +domain + "/addentity/" + type[1];
							}
							if (type[0].equals("Cartridge_Texture")) {
								gun.cartridge_tex ="handmadeguns2:addgun/" +domain + "/addentity/" + type[1];
							}
							if (type[0].equals("SightSetPoint")) {
								gun.am_sight_x = gun.am_sightbase_x = Float.parseFloat(type[1]);
								gun.am_sight_y = gun.am_sightbase_y = Float.parseFloat(type[2]);
								gun.am_sight_z = gun.am_sightbase_z = Float.parseFloat(type[3]);
							}
							if (type[0].equals("LightSetPoint")) {
								gun.am_light_x = Float.parseFloat(type[1]);
								gun.am_light_y = Float.parseFloat(type[2]);
								gun.am_light_z = Float.parseFloat(type[3]);
							}
							if (type[0].equals("LightSetAngle")) {
								gun.am_light_xr = Float.parseFloat(type[1]);
								gun.am_light_yr = Float.parseFloat(type[2]);
								gun.am_light_zr = Float.parseFloat(type[3]);
							}
							if (type[0].equals("MuzzleSetPoint")) {
								gun.am_supu_x = Float.parseFloat(type[1]);
								gun.am_supu_y = Float.parseFloat(type[2]);
								gun.am_supu_z = Float.parseFloat(type[3]);
							}
							if (type[0].equals("MuzzleSetAngle")) {
								gun.am_supu_xr = Float.parseFloat(type[1]);
								gun.am_supu_yr = Float.parseFloat(type[2]);
								gun.am_supu_zr = Float.parseFloat(type[3]);
							}
							if (type[0].equals("GripSetPoint")) {
								gun.am_grip_x = Float.parseFloat(type[1]);
								gun.am_grip_y = Float.parseFloat(type[2]);
								gun.am_grip_z = Float.parseFloat(type[3]);
							}
							if (type[0].equals("GripSetAngle")) {
								gun.am_grip_xr = Float.parseFloat(type[1]);
								gun.am_grip_yr = Float.parseFloat(type[2]);
								gun.am_grip_zr = Float.parseFloat(type[3]);
							}
							
							if (type[0].equals("Mugen")) {
								gun.mugen = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("MugenMag")) {
								gun.mugenmaga = Boolean.parseBoolean(type[1]);
							}
							
							
							if (type[0].equals("Shield_defence")) {
								gun.Shield_defence = Float.parseFloat(type[1]);
							}
							if (type[0].equals("AAM")) {
								gun.aam = Boolean.parseBoolean(type[1]);
							}
							
							if (type[0].equals("Render_Sight")) {
								gun.render_sight = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("Render_Light")) {
								gun.render_light = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("Render_Muzz")) {
								gun.render_muss = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("Render_Grip")) {
								gun.render_grip = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("Render_mat4_default")) {
								gun.render_mat4_unam = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("Render_mat6_default")) {
								gun.render_mat6_unam = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("Render_mat8_default")) {
								gun.render_mat8_unam = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("Render_mat9_default")) {
								gun.render_mat9_unam = Boolean.parseBoolean(type[1]);
							}
							
							if (type[0].equals("Render_crosshair_ADS")) {
								gun.render_cross_sneak = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("RenderingLight")) {
								gun.rendering_light = Boolean.parseBoolean(type[1]);
							}
							
							if (type[0].equals("gun_can_use_underbarrel")) {
								gun.gun_can_use_underbarrel = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("gun_can_get_underbarrel")) {
								gun.gun_can_get_underbarrel = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("gun_can_set_underbarrel")) {
								gun.gun_can_set_underbarrel = Boolean.parseBoolean(type[1]);
							}
							if (type[0].equals("gun_underbarrel_x")) {
								gun.gun_underbarrel_x = Float.parseFloat(type[1]);
							}
							if (type[0].equals("gun_underbarrel_y")) {
								gun.gun_underbarrel_y = Float.parseFloat(type[1]);
							}
							if (type[0].equals("gun_underbarrel_z")) {
								gun.gun_underbarrel_z = Float.parseFloat(type[1]);
							}
							
							if (type[0].equals("Render_Gun_CrossHair")) {
								gun.render_gvc_cross = Boolean.parseBoolean(type[1]);
							}
							
							if (type[0].equals("Mob_maxrange")) {
								gun.mobmax = Integer.parseInt(type[1]);
							}
							if (type[0].equals("Mob_lookrange")) {
								gun.mobrange = Integer.parseInt(type[1]);
							}
							if (type[0].equals("Mob_cooltime")) {
								gun.mobammo = Integer.parseInt(type[1]);
							}
							if (type[0].equals("Mob_barst")) {
								gun.mobbarst = Integer.parseInt(type[1]);
							}*/
							
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
