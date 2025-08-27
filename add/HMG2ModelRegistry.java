package handmadeguns2.add;

import gvclib.Createjson;
import handmadeguns2.mod_HandmadeGuns2;
import net.minecraftforge.client.event.ModelRegistryEvent;

public class HMG2ModelRegistry {
	public static void registry(mod_HandmadeGuns2 mod, ModelRegistryEvent event){
		
		for(int id = 0; id < mod.gun_model_id; ++id) {
			if(mod.gun_model_item_domain[id] != null) {
				Createjson.addjsongun_domain(mod.gun_model_item[id], mod.MOD_ID, mod.gun_model_name[id], mod.gun_model_item_domain[id] , true);
			}else {
				Createjson.addjsongun(mod.gun_model_item[id], mod.MOD_ID, mod.gun_model_name[id], true);
			}
		}
		for(int id = 0; id < mod.am_model_id; ++id) {
			if(mod.am_model_item_domain[id] != null) {
				Createjson.addjson_domain(mod.am_model_item[id], mod.MOD_ID, mod.am_model_name[id], mod.am_model_item_domain[id] , true);
			}else {
				Createjson.addjson(mod.am_model_item[id], mod.MOD_ID, mod.am_model_name[id], true);
			}
		}
		for(int id = 0; id < mod.armor_model_id; ++id) {
			if(mod.armor_model_item_domain[id] != null) {
				Createjson.addjson_domain(mod.armor_model_item[id], mod.MOD_ID, mod.armor_model_name[id], mod.armor_model_item_domain[id] , true);
			}else {
				Createjson.addjson(mod.armor_model_item[id], mod.MOD_ID, mod.armor_model_name[id], true);
			}
		}
		for(int id = 0; id < mod.block_model_id; ++id) {
			Createjson.addjsonblock(mod.block_model_item[id], mod.MOD_ID, mod.block_model_name[id], true);
		}
		Createjson.addjson(mod.hmg2_icon, mod.MOD_ID, "hmg2_icon", false);
		
		Createjson.addjsonblock(mod.hmg2_crafter, mod.MOD_ID, "hmg2_crafter", false);
		Createjson.addjsonblock(mod.hmg2_magazine_machine, mod.MOD_ID, "hmg2_magazine_machine", false);
		Createjson.addjsonblock(mod.hmg2_attachment_machine, mod.MOD_ID, "hmg2_attachment_machine", false);
		
		Createjson.addjsonblock(mod.hmg2_handing, mod.MOD_ID, "hmg2_handing", false);
		Createjson.addjsonblock(mod.hmg2_handing2, mod.MOD_ID, "hmg2_handing2", false);
		Createjson.addjsonblock(mod.hmg2_handing3, mod.MOD_ID, "hmg2_handing3", false);
	}
}
