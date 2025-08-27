package handmadeguns2;







import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import handmadeguns2.add.AddLanguageHMG2;
import handmadeguns2.add.HMG2ModelRegistry;
import handmadeguns2.add.HMGAddArmor22;
import handmadeguns2.add.HMGAddBlock22;
import handmadeguns2.add.HMGAddBlockItem22;
import handmadeguns2.add.HMGAddGuns22;
import handmadeguns2.add.HMGAddRecipe22;
import handmadeguns2.add.HMGAddSounds2;
import handmadeguns2.add.HMGAttachmentGuns22;
import handmadeguns2.block.Block_AttachmentMachine;
import handmadeguns2.block.Block_Crafter2;
import handmadeguns2.block.Block_Handing2;
import handmadeguns2.block.Block_MagazineMachine;
import handmadeguns2.block.TileEntity_AttachmentMachine;
import handmadeguns2.block.TileEntity_Crafter2;
import handmadeguns2.block.TileEntity_MagazineMachine;
import handmadeguns2.gui.GuiHandlerHMG2;
import handmadeguns2.network.HMGPacketHandler2;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;




@Mod(
		modid	= mod_HandmadeGuns2.MOD_ID,
		name	= mod_HandmadeGuns2.MOD_ID,
		version	= "1.12.2", 
		acceptedMinecraftVersions="[1.12.2]", 
		useMetadata=true
		)
@EventBusSubscriber
public class mod_HandmadeGuns2 {
	@SidedProxy(clientSide = "handmadeguns2.ClientProxyHMG2", serverSide = "handmadeguns2.CommonSideProxyHMG2")
	public static CommonSideProxyHMG2 proxy;
	public static final String MOD_ID = "handmadeguns2";
	@Mod.Instance(MOD_ID)
	 
    public static mod_HandmadeGuns2 INSTANCE;
	//public static final KeyBinding Speedreload = new KeyBinding("Key.reload", Keyboard.KEY_R, "GVCGunsPlus");
	
	public static boolean isDebugMessage = true;
	
	public static boolean cfg_exprotion = true;
	public static boolean cfg_FriendFireLMM;
	public static boolean cfg_RenderGunSizeLMM;
	public static boolean cfg_RenderGunAttachmentLMM;
	
	public static boolean cfg_ZoomRender;
	public static int cfg_FOV;
	
	public static boolean cfg_RenderPlayer;
	
	public static boolean cfg_canEjectCartridge;
	public static int cfg_Cartridgetime;
	
	public static boolean cfg_muzzleflash;
	
	public static int cfg_ADS_Sneaking;
	public static boolean cfg_Flash;
	
	
	public static Item hmg2_icon;
	
	public static Block hmg2_handing;
	public static Block hmg2_handing2;
	public static Block hmg2_handing3;
	
	public static Block hmg2_crafter;
	public static int gun_id = 0;
	public static int[] gun_eme = new int[1024];
	public static int[] gun_iron = new int[1024];
	public static int[] gun_red = new int[1024];
	public static Item[] gun_item = new Item[1024];
	
	public static Block hmg2_magazine_machine;
	public static int magazine_id = 0;
	public static int[] magazine_gunpowder = new int[1024];
	public static int[] magazine_iron = new int[1024];
	public static int[] magazine_kazu = new int[1024];
	public static Item[] magazine_item = new Item[1024];
	
	public static Block hmg2_attachment_machine;
	public static int attachment_id = 0;
	public static int[] attachment_red = new int[1024];
	public static int[] attachment_iron = new int[1024];
	public static Item[] attachment_item = new Item[1024];
	
	public static int gun_model_id = 0;
	public static Item[] gun_model_item = new Item[1024];
	public static String[] gun_model_item_domain = new String[1024];//24/01/03
	public static String[] gun_model_name = new String[1024];
	
	public static int am_model_id = 0;
	public static Item[] am_model_item = new Item[1024];
	public static String[] am_model_item_domain = new String[1024];//24/01/03
	public static String[] am_model_name = new String[1024];
	
	public static int armor_model_id = 0;
	public static Item[] armor_model_item = new Item[1024];
	public static String[] armor_model_item_domain = new String[1024];//24/01/03
	public static String[] armor_model_name = new String[1024];
	
	public static int block_model_id = 0;
	public static Block[] block_model_item = new Block[1024];
	public static String[] block_model_item_domain = new String[1024];//24/01/03
	public static String[] block_model_name = new String[1024];
	
	//public static Item[] guns;
	public static List guns = new ArrayList();
	
	public static int add_pack_id = 0;
	public static String[] add_pack_name = new String[1024];
	
	public static int add_gun_id = 0;
	public static String[] add_gun_name = new String[1024];
	
	public static int add_sound_id = 0;
	public static String[] add_sound_name = new String[1024];
	
	public static int add_attachment_id = 0;
	public static String[] add_attachment_name = new String[1024];
	
	public static int add_armor_id = 0;
	public static String[] add_armor_name = new String[1024];
	
	public static int add_recipe_id = 0;
	public static String[] add_recipe_name = new String[1024];
	
	public static int add_crafter_id = 0;
	public static String[] add_crafter_name = new String[1024];
	
	//protected static final File optionsDir = new File(Minecraft.getMinecraft().mcDataDir,"config" + File.separatorChar + "handmadeguns");
	
	public static int counter_crafter = 0;
	public static int counter_crafter_counter = 0;
	public static String[] craftercount = new String[1024];
    public static String[][] guncount = new String[1024][1024];
    public static int[][] emecount = new int[1024][1024];
    public static int[] crafter_gunid = new int[1024];
    public static String[] crafter_gunid_tag = new String[1024];
	
	protected static File configFile;
	
	public static final CreativeTabs tabhmg = new HMGCreativeTab2("HMG2Tab");
	

	@Mod.EventHandler
    public void construct(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
	}
	
	
	//@net.minecraftforge.fml.common.Mod.EventHandler
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent pEvent) {
		configFile = pEvent.getSuggestedConfigurationFile();
		Configuration lconf = new Configuration(configFile);
		lconf.load();
		cfg_FriendFireLMM	= lconf.get("LMM", "cfg_FriendFireLMM", false).getBoolean(false);
		cfg_RenderGunSizeLMM	= lconf.get("LMM", "cfg_RenderGunSizeLMM", false).getBoolean(false);
		cfg_RenderGunAttachmentLMM	= lconf.get("LMM", "cfg_RenderGunAttachmentLMM", false).getBoolean(false);
		cfg_ZoomRender	= lconf.get("Render", "cfg_ZoomRender", true).getBoolean(true);
		cfg_FOV	= lconf.get("Render", "cfg_FOV", 70).getInt(70);
		cfg_RenderPlayer	= lconf.get("Render", "cfg_RenderPlayer", false).getBoolean(false);
		cfg_canEjectCartridge	= lconf.get("Cartridge", "cfg_canEjectCartridge", true).getBoolean(true);
		cfg_Cartridgetime	= lconf.get("Cartridge", "cfg_Cartridgetime", 200).getInt(200);
		cfg_muzzleflash	= lconf.get("Gun", "cfg_MuzzleFlash", true).getBoolean(true);
		cfg_ADS_Sneaking	= lconf.get("Gun", "cfg_ADS_Sneaking",  0).getInt(0);
		cfg_Flash	= lconf.get("Render", "cfg_Flash", true).getBoolean(true);
		lconf.save();
	   // ResourceLocation aa = new ResourceLocation("handmadeguns").getResourceDomain();
	    FMLCommonHandler.instance().bus().register(this);
		proxy.ProxyFile();
		
	    {
	    	//AddLanguageHMG2.load(pEvent.getSide().isClient(), MOD_ID, proxy.ProxyFile());
	    
	    HMGFileLoader2.load(this.INSTANCE);
	    	
	    }
	    HMGPacketHandler2.init();
	}
	
	
	@SubscribeEvent
	protected static void IregisterSoundEvents(RegistryEvent.Register<SoundEvent> event) {	
		HMGAddSounds2.load(event);
	}
	
	@SubscribeEvent
    protected static void registerBlocks(RegistryEvent.Register<Block> event){
		hmg2_crafter	= new Block_Crafter2(false).setUnlocalizedName("hmg2_crafter")
				.setRegistryName(MOD_ID, "hmg2_crafter").setCreativeTab(tabhmg);
		event.getRegistry().register(hmg2_crafter);
		
		hmg2_magazine_machine	= new Block_MagazineMachine(false).setUnlocalizedName("hmg2_magazine_machine")
				.setRegistryName(MOD_ID, "hmg2_magazine_machine").setCreativeTab(tabhmg);
		event.getRegistry().register(hmg2_magazine_machine);
		
		hmg2_attachment_machine	= new Block_AttachmentMachine(false).setUnlocalizedName("hmg2_attachment_machine")
				.setRegistryName(MOD_ID, "hmg2_attachment_machine").setCreativeTab(tabhmg);
		event.getRegistry().register(hmg2_attachment_machine);
		
		hmg2_handing	= new Block_Handing2(false).setUnlocalizedName("hmg2_handing")
				.setRegistryName(MOD_ID, "hmg2_handing").setCreativeTab(tabhmg);
		event.getRegistry().register(hmg2_handing);
		hmg2_handing2	= new Block_Handing2(false).setUnlocalizedName("hmg2_handing2")
				.setRegistryName(MOD_ID, "hmg2_handing2").setCreativeTab(tabhmg);
		event.getRegistry().register(hmg2_handing2);
		hmg2_handing3	= new Block_Handing2(false).setUnlocalizedName("hmg2_handing3")
				.setRegistryName(MOD_ID, "hmg2_handing3").setCreativeTab(tabhmg);
		event.getRegistry().register(hmg2_handing3);
		
		
		{
			for(int i0 = 0; i0 < mod_HandmadeGuns2.add_pack_id; ++i0) {
				for(int i1 = 0; i1 < mod_HandmadeGuns2.add_crafter_id; ++i1) {
					InputStream inputStream = HMGFileLoader2.class.getResourceAsStream("/assets/handmadeguns2/addgun/" 
				+  mod_HandmadeGuns2.add_pack_name[i0]
				+ "/crafter/" + mod_HandmadeGuns2.add_crafter_name[i1]);
							if(inputStream != null) {
								HMGAddBlock22.load(proxy.getClient(), inputStream, mod_HandmadeGuns2.add_pack_name[i0], event);
							}
				}
			}
		}
		
		GameRegistry.registerTileEntity(TileEntity_Crafter2.class, "TileEntity_Crafter2");
		GameRegistry.registerTileEntity(TileEntity_MagazineMachine.class, "TileEntity_MagazineMachine");
		GameRegistry.registerTileEntity(TileEntity_AttachmentMachine.class, "TileEntity_AttachmentMachine");
	}
	
	@SubscribeEvent
    protected static void registerItems(RegistryEvent.Register<Item> event){
		
		
		/*{
			File packFile = FMLCommonHandler.instance().findContainerFor(mod_HandmadeGuns2.INSTANCE).getSource();
			File directory1 = new File(packFile.toURI().getPath() + "assets/handmadeguns2/addgun/attachment");
			File[] filelist1 = directory1.listFiles();
			{
				if (filelist1 != null) {
					System.out.println(String.format("attachmenttttttttttttttttttttttttt"));
					for (int ii = 0; ii < filelist1.length; ii++) {
						if (filelist1[ii].isFile()) {
							HMGAddAttachment2.load(proxy.getClient(), filelist1[ii], event);
						}
					}
				}
			}
		}
		{
			File packFile = FMLCommonHandler.instance().findContainerFor(mod_HandmadeGuns2.INSTANCE).getSource();
			File directory1 = new File(packFile.toURI().getPath() + "assets/handmadeguns2/addgun/guns");
			File[] filelist1 = directory1.listFiles();
			{
				if (filelist1 != null) {
					System.out.println(String.format("gunnnnnnnnnnnnnnnnnnn"));
					for (int ii = 0; ii < filelist1.length; ii++) {
						if (filelist1[ii].isFile()) {
							HMGAddGuns2.load(proxy.getClient(), filelist1[ii], event);
						}
					}
				}
			}
		}
		{
			File packFile = FMLCommonHandler.instance().findContainerFor(mod_HandmadeGuns2.INSTANCE).getSource();
			File directory1 = new File(packFile.toURI().getPath() + "assets/handmadeguns2/addgun/armor");
			File[] filelist1 = directory1.listFiles();
			{
				if (filelist1 != null) {
					System.out.println(String.format("armorrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr"));
					for (int ii = 0; ii < filelist1.length; ii++) {
						if (filelist1[ii].isFile()) {
							HMGAddArmor2.load(proxy.getClient(), filelist1[ii], event);
						}
					}
				}
			}
		}*/
		
		{
			for(int i0 = 0; i0 < mod_HandmadeGuns2.add_pack_id; ++i0) {
				for(int i1 = 0; i1 < mod_HandmadeGuns2.add_crafter_id; ++i1) {
					InputStream inputStream = HMGFileLoader2.class.getResourceAsStream("/assets/handmadeguns2/addgun/" 
				+  mod_HandmadeGuns2.add_pack_name[i0]
				+ "/crafter/" + mod_HandmadeGuns2.add_crafter_name[i1]);
							if(inputStream != null) {
								HMGAddBlockItem22.load(proxy.getClient(), inputStream, mod_HandmadeGuns2.add_pack_name[i0], event);
							}
				}
			}
		}
		
		{
			for(int i0 = 0; i0 < mod_HandmadeGuns2.add_pack_id; ++i0) {
				for(int i1 = 0; i1 < mod_HandmadeGuns2.add_attachment_id; ++i1) {
					InputStream inputStream = HMGFileLoader2.class.getResourceAsStream("/assets/handmadeguns2/addgun/" 
				+  mod_HandmadeGuns2.add_pack_name[i0]
				+ "/attachment/" + mod_HandmadeGuns2.add_attachment_name[i1]);
							if(inputStream != null) {
								HMGAttachmentGuns22.load(proxy.getClient(), inputStream, mod_HandmadeGuns2.add_pack_name[i0], event);
							}
				}
			}
		}
		{
			net.minecraftforge.fml.common.ProgressManager.ProgressBar bar= net.minecraftforge.fml.common.ProgressManager.push("HMG2 Loading", mod_HandmadeGuns2.add_gun_id, true);
			for(int i0 = 0; i0 < mod_HandmadeGuns2.add_pack_id; ++i0) {
				
				for(int i1 = 0; i1 < mod_HandmadeGuns2.add_gun_id; ++i1) {
					InputStream inputStream = HMGFileLoader2.class.getResourceAsStream("/assets/handmadeguns2/addgun/" 
				+  mod_HandmadeGuns2.add_pack_name[i0]
				+ "/guns/" + mod_HandmadeGuns2.add_gun_name[i1]);
							if(inputStream != null) {
								
								HMGAddGuns22.load(proxy.getClient(), inputStream, mod_HandmadeGuns2.add_pack_name[i0], event);
								bar.step("load");
							}
				}
			}
			net.minecraftforge.fml.common.ProgressManager.pop(bar);
		}
		{
			for(int i0 = 0; i0 < mod_HandmadeGuns2.add_pack_id; ++i0) {
				for(int i1 = 0; i1 < mod_HandmadeGuns2.add_armor_id; ++i1) {
					InputStream inputStream = HMGFileLoader2.class.getResourceAsStream("/assets/handmadeguns2/addgun/" 
				+  mod_HandmadeGuns2.add_pack_name[i0]
				+ "/armor/" + mod_HandmadeGuns2.add_armor_name[i1]);
							if(inputStream != null) {
								HMGAddArmor22.load(proxy.getClient(), inputStream, mod_HandmadeGuns2.add_pack_name[i0], event);
							}
				}
			}
		}
		
		{
			for(int i0 = 0; i0 < mod_HandmadeGuns2.add_pack_id; ++i0) {
				for(int i1 = 0; i1 < mod_HandmadeGuns2.add_recipe_id; ++i1) {
					InputStream inputStream = HMGFileLoader2.class.getResourceAsStream("/assets/handmadeguns2/addgun/" 
				+  mod_HandmadeGuns2.add_pack_name[i0]
				+ "/recipe/" + mod_HandmadeGuns2.add_recipe_name[i1]);
							if(inputStream != null) {
								HMGAddRecipe22.load(proxy.getClient(), inputStream, mod_HandmadeGuns2.add_pack_name[i0], event);
							}
				}
			}
		}
		
		hmg2_icon	= new Item().setUnlocalizedName("hmg2_icon")
				.setRegistryName(MOD_ID, "hmg2_icon");
		event.getRegistry().register(hmg2_icon);
		
		    event.getRegistry().register(new ItemBlock(hmg2_crafter).setRegistryName(MOD_ID, "hmg2_crafter"));
		    
		    event.getRegistry().register(new ItemBlock(hmg2_magazine_machine).setRegistryName(MOD_ID, "hmg2_magazine_machine"));
		    
		    event.getRegistry().register(new ItemBlock(hmg2_attachment_machine).setRegistryName(MOD_ID, "hmg2_attachment_machine"));
		    
		    event.getRegistry().register(new ItemBlock(hmg2_handing).setRegistryName(MOD_ID, "hmg2_handing"));
		    event.getRegistry().register(new ItemBlock(hmg2_handing2).setRegistryName(MOD_ID, "hmg2_handing3"));
		    event.getRegistry().register(new ItemBlock(hmg2_handing3).setRegistryName(MOD_ID, "hmg2_handing2"));
		    
		    AddLanguageHMG2.load(proxy.getClient(), MOD_ID, proxy.ProxyFile());
	}
	
	
	
	@SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void registerModels(ModelRegistryEvent event) {
		HMG2ModelRegistry.registry(INSTANCE, event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent pEvent) {
		int D = Short.MAX_VALUE;

		GameRegistry.addShapedRecipe(new ResourceLocation("hmg2_crafter"),
                new ResourceLocation("handmadeguns2"),
                new ItemStack(hmg2_crafter, 1), new Object[]{
                		"iri",
                		"rbr",
                		"iri",
    					'i', Items.IRON_INGOT,
    					'r', Items.REDSTONE,
    					'b',Items.EMERALD
			 });
		
		GameRegistry.addShapedRecipe(new ResourceLocation("hmg2_magazine_machine"),
                new ResourceLocation("handmadeguns2"),
                new ItemStack(hmg2_magazine_machine, 1), new Object[]{
                		"iri",
                		"rrr",
                		"iri",
    					'i', Items.IRON_INGOT,
    					'r', Items.GUNPOWDER
			 });
		
		GameRegistry.addShapedRecipe(new ResourceLocation("hmg2_attachment_machine"),
                new ResourceLocation("handmadeguns2"),
                new ItemStack(hmg2_attachment_machine, 1), new Object[]{
                		"iri",
                		"rgr",
                		"iri",
    					'i', Items.IRON_INGOT,
    					'r', Items.GUNPOWDER,
    					'g', Items.GOLD_INGOT
			 });
		
		GameRegistry.addShapedRecipe(new ResourceLocation("hmg2_handing"),
                new ResourceLocation("handmadeguns2"),
                new ItemStack(hmg2_handing, 1), new Object[]{
                		"s  ",
                		"ss ",
                		"www",
    					's', Items.STICK,
    					'w', new ItemStack(Blocks.PLANKS, 1, D)
			 });
		GameRegistry.addShapedRecipe(new ResourceLocation("hmg2_handing2"),
                new ResourceLocation("handmadeguns2"),
                new ItemStack(hmg2_handing2, 1), new Object[]{
                		"w ",
                		"ws",
                		"w ",
    					's', Items.STICK,
    					'w', new ItemStack(Blocks.PLANKS, 1, D)
			 });
		GameRegistry.addShapedRecipe(new ResourceLocation("hmg2_handing3"),
                new ResourceLocation("handmadeguns2"),
                new ItemStack(hmg2_handing3, 1), new Object[]{
                		"ss",
    					's', Blocks.OBSIDIAN
			 });
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this.INSTANCE, new GuiHandlerHMG2());
		FMLCommonHandler.instance().bus().register(this);
		proxy.getClient();
		proxy.reisterRenderers();
	}
	
}

	
	
