package handmadeguns2.add;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import handmadeguns2.mod_HandmadeGuns2;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraftforge.event.RegistryEvent;

public class HMGAddSounds2
{
  static List<ArrayList<String>> mainList = new ArrayList();
  public static List Guns = new ArrayList();
  
  public static String[] soundsfile = new String[255];
  
  public static final RegistryNamespaced<ResourceLocation, SoundEvent> REGISTRY = net.minecraftforge.registries.GameData.getWrapper(SoundEvent.class);
  private static int soundEventId;
  
  
  public static void load(RegistryEvent.Register<SoundEvent> event)
  {
	  int files = 0;
	  //InputStream inputStream = HMGAddSounds2.class.getResourceAsStream("/assets/handmadeguns2/add/sounds/");
	  File directory1 = new File(mod_HandmadeGuns2.proxy.ProxyFile(),"mods" + File.separatorChar + "handmadeguns2" 
              + File.separatorChar +  "assets" + File.separatorChar + "handmadeguns2" + File.separatorChar +
			  "sounds");
	    File[] filelist1 = directory1.listFiles();
	    if(filelist1 == null)return;
	    for (int i = 0 ; i < filelist1.length ; i++){
	      if (filelist1[i].isFile()){
	    	  soundsfile[i] = getNameWithoutExtension(filelist1, i);
	    	  //soundsfile[i] = filelist1[i].getName();
	    	  final ResourceLocation soundID = new ResourceLocation(mod_HandmadeGuns2.MOD_ID, "handmadeguns2."+soundsfile[i]);
	 		 //GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));
	    	  event.getRegistry().register(new SoundEvent(soundID).setRegistryName("handmadeguns2."+soundsfile[i]));
	    	  System.out.println(String.format("handmadeguns2-" + soundsfile[i]));
	    	  if(SoundEvent.REGISTRY.getObject(soundID) == null) {
	    		  System.out.println(String.format("handmadeguns2-" + "null"));
	    	  }
	        }
	      }
	    
	    try {
	    	File newfile = new File(mod_HandmadeGuns2.proxy.ProxyFile(),"mods" + File.separatorChar + "handmadeguns2" 
	                + File.separatorChar +  "assets" + File.separatorChar + "handmadeguns2" + File.separatorChar + "sounds.json");
	    	  newfile.createNewFile();
	    	  BufferedWriter bw = new BufferedWriter(new FileWriter(newfile));
	    	  bw.write("{");
	    	  bw.newLine();
	    	  for (int i = 0 ; i < filelist1.length ; i++){
	    		  String s = "\"handmadeguns2." + soundsfile[i] + "\"";
	    		  String c = "\"category\"";
	    		  String n = "\"neutral\"";
	    		  String ss = "\"sounds\"";
	    		  String na = "\"name\"";
	    		  String st = "\"stream\"";
	    		  bw.write(s + ": {" + c + ": " + n + "," + ss + ": [{" + na +": \"handmadeguns2:" + soundsfile[i] + "\","+ st + ": true}]},");
	    		  bw.newLine();
	    		  
	    	  }
	    	  {
	    		  String s = "\"handmadeguns2." + "nulls" + "\"";
	    		  String c = "\"category\"";
	    		  String n = "\"neutral\"";
	    		  String ss = "\"sounds\"";
	    		  String na = "\"name\"";
	    		  String st = "\"stream\"";
	    		  bw.write(s + ": {" + c + ": " + n + "," + ss + ": [{" + na +": \"handmadeguns2:" + "nulls" + "\","+ st + ": true}]}");
	    		  bw.newLine();
	    	  }
	    	  bw.write("}");
	    	bw.close();
	  } catch (FileNotFoundException ex) {
	    ex.printStackTrace();
	  } catch (IOException ex) {
	    ex.printStackTrace();
	  }
	    
	    
  }
  
  public static String getNameWithoutExtension(File[] filelist1, int i)
  {
    String fileName = filelist1[i].getName();
    int index = fileName.lastIndexOf('.');
    if (index!=-1)
    {
      return fileName.substring(0, index);
    }
    return "";
  }
  
  private static boolean checkBeforeReadfile(File file){
	    if (file.exists()){
	      if (file.isFile() && file.canRead()){
	        return true;
	      }
	    }

	    return false;
	  }
}
