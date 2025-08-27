package handmadeguns2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;

public class HMGFileLoader2 {

	public static void load(mod_HandmadeGuns2 mod) {

		{
			File directory_sounds = new File(mod.proxy.ProxyFile(),
					"mods" + File.separatorChar + "handmadeguns2"
							+ File.separatorChar + "assets" + File.separatorChar
							+ "handmadeguns2" + File.separatorChar +
							"sounds");
			
			directory_sounds.mkdirs();
			System.out.println(String.format("aaaaaaaaaaaaaaaaaaaaa"));
		}
		/*try {
			InputStream inputStream = HMGFileLoader2.class.getResourceAsStream("/assets/handmadeguns2/addgun/addlist.txt");
			//if (checkBeforeReadfile(file)) 
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

				String str;
				while ((str = br.readLine()) != null) { // 1行ずつ読み込む
					// System.out.println(str);
					String[] type = str.split(",");

					int guntype = 0;

					if (type.length != 0) {// 1
						if (type[0].equals("sound")) {
							mod_HandmadeGuns2.add_sound_name[mod_HandmadeGuns2.add_sound_id] = type[1];
							++mod_HandmadeGuns2.add_sound_id;
							System.out.println(String.format("bbbbbbbbbbbbbbbbbbbbbbbbbbbb"));
						}
						if (type[0].equals("gun")) {
							mod_HandmadeGuns2.add_gun_name[mod_HandmadeGuns2.add_gun_id] = type[1];
							++mod_HandmadeGuns2.add_gun_id;
							System.out.println(String.format("ggggggggggggggggggggggggggggggggggg"));
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
		*/
		try {
			InputStream inputStream = HMGFileLoader2.class.getResourceAsStream("/assets/handmadeguns2/addgun/addpack.txt");
			//if (checkBeforeReadfile(file)) 
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

				String str;
				while ((str = br.readLine()) != null) { // 1行ずつ読み込む
					// System.out.println(str);
					String[] type = str.split(",");

					int guntype = 0;

					if (type.length != 0) {// 1
						if (type[0].equals("pack")) {
							mod_HandmadeGuns2.add_pack_name[mod_HandmadeGuns2.add_pack_id] = type[1];
							++mod_HandmadeGuns2.add_pack_id;
							System.out.println(String.format("bbbbbbbbbbbbbbbbbbbbbbbbbbbb"));
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
		{
			for(int i0 = 0; i0 < mod_HandmadeGuns2.add_pack_id; ++i0) {
				try {
					InputStream inputStream = HMGFileLoader2.class.getResourceAsStream("/assets/handmadeguns2/addgun/" 
				+ mod_HandmadeGuns2.add_pack_name[i0] +"/addlist.txt");
					{
						BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

						String str;
						while ((str = br.readLine()) != null) { // 1行ずつ読み込む
							String[] type = str.split(",");

							int guntype = 0;

							if (type.length != 0) {// 1
								
								if (type[0].equals("crafter")) {
									mod_HandmadeGuns2.add_crafter_name[mod_HandmadeGuns2.add_crafter_id] = type[1];
									++mod_HandmadeGuns2.add_crafter_id;
								}
								
								if (type[0].equals("sound")) {
									mod_HandmadeGuns2.add_sound_name[mod_HandmadeGuns2.add_sound_id] = type[1];
									++mod_HandmadeGuns2.add_sound_id;
									System.out.println(String.format("bbbbbbbbbbbbbbbbbbbbbbbbbbbb"));
								}
								
								if (type[0].equals("attachment")) {
									mod_HandmadeGuns2.add_attachment_name[mod_HandmadeGuns2.add_attachment_id] = type[1];
									++mod_HandmadeGuns2.add_attachment_id;
								}
								if (type[0].equals("gun")) {
									mod_HandmadeGuns2.add_gun_name[mod_HandmadeGuns2.add_gun_id] = type[1];
									++mod_HandmadeGuns2.add_gun_id;
								}
								if (type[0].equals("armor")) {
									mod_HandmadeGuns2.add_armor_name[mod_HandmadeGuns2.add_armor_id] = type[1];
									++mod_HandmadeGuns2.add_armor_id;
								}
								if (type[0].equals("recipe")) {
									mod_HandmadeGuns2.add_recipe_name[mod_HandmadeGuns2.add_recipe_id] = type[1];
									++mod_HandmadeGuns2.add_recipe_id;
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
		}
		
		{
			for(int i0 = 0; i0 < mod_HandmadeGuns2.add_pack_id; ++i0) {
				for(int i1 = 0; i1 < mod_HandmadeGuns2.add_sound_id; ++i1) {
					InputStream inputStream = HMGFileLoader2.class.getResourceAsStream("/assets/handmadeguns2/addgun/" 
				+  mod_HandmadeGuns2.add_pack_name[i0]
				+ "/addsounds/" + mod_HandmadeGuns2.add_sound_name[i1]);
							if(inputStream != null) {
								File directory1 = new File(mod.proxy.ProxyFile(),
										"mods" + File.separatorChar + "handmadeguns2"
												+ File.separatorChar + "assets" + File.separatorChar
												+ "handmadeguns2" + File.separatorChar +
												"sounds/"+ mod_HandmadeGuns2.add_sound_name[i1]);
								try {
								    Files.copy(inputStream, directory1.toPath());
								} catch (IOException eeee) {
								    eeee.printStackTrace();
								}
							}
				}
			}
		}
			
		
		/*{
			for(int i0 = 0; i0 < mod_HandmadeGuns2.add_sound_id; ++i0) {
				InputStream inputStream = HMGFileLoader2.class.getResourceAsStream("/assets/handmadeguns2/addgun/addsounds/" 
						+ mod_HandmadeGuns2.add_sound_name[i0]);
						if(inputStream != null) {
							File directory1 = new File(mod.proxy.ProxyFile(),
									"mods" + File.separatorChar + "handmadeguns2"
											+ File.separatorChar + "assets" + File.separatorChar
											+ "handmadeguns2" + File.separatorChar +
											"sounds/"+ mod_HandmadeGuns2.add_sound_name[i0]);
							try {
							    Files.copy(inputStream, directory1.toPath());
							} catch (IOException eeee) {
							    eeee.printStackTrace();
							}
						}
			}
		}*/
		
		/*for(int i0 = 0; i0 < 38; ++i0) {
			for(int i1 = 0; i1 < 38; ++i1) {
				for(int i2 = 0; i2 < 38; ++i2) {
					//for(int i3 = 0; i3 < 38; ++i3) 
					{
						//for(int i4 = 0; i4 < 38; ++i4) 
						{
							//for(int i5 = 0; i5 < 38; ++i5) 
							{
								//for(int i6 = 0; i6 < 38; ++i6) 
								{
									//for(int i7 = 0; i7 < 38; ++i7) 
									{
										//for(int i8 = 0; i8 < 38; ++i8)
										{
											//for(int i9 = 0; i9 < 38; ++i9) 
											{
												//for(int i10 = 0; i10 < 38; ++i10) 
												{
													String a = HMG2FileNameLoader.load(i0);
													String b = HMG2FileNameLoader.load(i1);
													String c = HMG2FileNameLoader.load(i2);
													//String d = HMG2FileNameLoader.load(i3);
													/*String e = HMG2FileNameLoader.load(i4);
													String f = HMG2FileNameLoader.load(i5);
													String g = HMG2FileNameLoader.load(i6);
													String h = HMG2FileNameLoader.load(i7);
													String i = HMG2FileNameLoader.load(i8);
													String j = HMG2FileNameLoader.load(i9);
													String k = HMG2FileNameLoader.load(i10);
													
													String filename = a + b + c;
													
													InputStream inputStream = HMGFileLoader2.class.getResourceAsStream("/assets/handmadeguns2/addgun/addsounds/" 
													+ filename +".ogg");
													if(inputStream != null) {
														File directory1 = new File(mod.proxy.ProxyFile(),
																"mods" + File.separatorChar + "handmadeguns2"
																		+ File.separatorChar + "assets" + File.separatorChar
																		+ "handmadeguns2" + File.separatorChar +
																		"sounds/"+ filename +".ogg");
														try {
														    Files.copy(inputStream, directory1.toPath());
														} catch (IOException eeee) {
														    eeee.printStackTrace();
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		*/
		
		
		
		/*
		InputStream inputStream = HMGFileLoader2.class.getResourceAsStream("/assets/handmadeguns2/addgun/addsounds");
		FileInputStream finputStream = (FileInputStream) HMGFileLoader2.class.getResourceAsStream("/assets/handmadeguns2/addgun/addsounds");
		//finputStream.getChannel().
		System.out.println(String.format(HMGFileLoader2.class.getResourceAsStream("/assets/handmadeguns2/addgun/addsounds").toString()));
		File packFile = FMLCommonHandler.instance().findContainerFor(mod_HandmadeGuns2.INSTANCE).getSource();
		//if(FileHandler.isZipped(packFile.toURI().getPath())) {}
		//File directory1 = new File(packFile.toURI().getPath() + "assets/handmadeguns2/addgun/addsounds");
		File directory1 = new File(packFile.toURI().getPath() + "assets/handmadeguns2/addgun/addsounds");
		System.out.println(String.format(packFile.toURI().getPath()));
		//File directory1 = new File(mod.proxy.ProxyFile(),"mods" + File.separatorChar + "handmadeguns2" + File.separatorChar + "addgun");
		File[] filelist1 = directory1.listFiles();
		{
			if (filelist1 != null) {
				System.out.println(String.format("bbbbbbbbbbbbbbbbbbbbbbbbbbb"));
				for (int ii = 0; ii < filelist1.length; ii++) {
					if (filelist1[ii].isFile()) {
						{
							File directory111 = new File(mod.proxy.ProxyFile(),
									"mods" + File.separatorChar + "handmadeguns2"
											+ File.separatorChar + "assets" + File.separatorChar
											+ "handmadeguns2" + File.separatorChar +
											"sounds" + File.separatorChar + filelist1[ii].getName());
							try {
								FileUtils.copyFile(filelist1[ii], directory111);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
				Arrays.sort(filelist1);
			}

		}

		*/
		
		
		/*
		File packFile = FMLCommonHandler.instance().findContainerFor(mod_HandmadeGuns2.INSTANCE).getSource();
		File directory1 = new File(packFile.toURI().getPath() + "assets/handmadeguns2/addgun");
		//File directory1 = new File(mod.proxy.ProxyFile(),"mods" + File.separatorChar + "handmadeguns2" + File.separatorChar + "addgun");
		File[] filelist1 = directory1.listFiles();
		for (int i = 0; i < filelist1.length; i++) {
			if (filelist1[i].isDirectory()) {

				File dire224 = new File(filelist1[i], "addsounds");
				if (dire224 != null) {
					File[] filelist224 = dire224.listFiles();
					if (filelist224 != null) {
						for (int ii = 0; ii < filelist224.length; ii++) {
							if (filelist224[ii].isFile()) {
								{
									File directory111 = new File(mod.proxy.ProxyFile(),
											"mods" + File.separatorChar + "handmadeguns2"
													+ File.separatorChar + "assets" + File.separatorChar
													+ "handmadeguns2" + File.separatorChar +
													"sounds" + File.separatorChar + filelist224[ii].getName());
									File in = new File("C:\\temp\\in.txt");
									File out = new File("C:\\temp\\out.txt");
									try {
										FileUtils.copyFile(filelist224[ii], directory111);
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
							}
						}
					}
				}

			}
		}

		Arrays.sort(filelist1);
*/
	}
}
