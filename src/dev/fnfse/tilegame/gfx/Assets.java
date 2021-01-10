package dev.fnfse.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets
{
	private static final int width = 32, height = 32;
	
	public static BufferedImage dirt, grass, stone, tree, player1right;
	public static BufferedImage[] player_down, player_up, player_right, player_left, enemy;
	
	public static void init()
	{
		
		//World
		SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("res/textures/tiles.png"));
		
		dirt = sheet1.crop(width* 3,  0, width, height);
		grass = sheet1.crop(width * 2, 0, width, height);
		stone = sheet1.crop(width * 3, height * 2, width, height);
		tree = sheet1.crop(0, height, width, height);
		
		
		
		//Player
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("res/textures/sheet2.png"));
		
		player_down = new BufferedImage[2];
		player_down[0] = sheet2.crop(width * 2, 0, width, height);
		player_down[1] = sheet2.crop(width * 3, 0, width, height);
		player_up = new BufferedImage[2];
		player_up[0] = sheet2.crop(0, 0, width, height);
		player_up[1] = sheet2.crop(width * 1, 0, width, height);
		player_right = new BufferedImage[2];
		player_right[0] = sheet2.crop(width * 6, 0, width, height);
		player_right[1] = sheet2.crop(width * 7, 0, width, height);
		player_left = new BufferedImage[2];
		player_left[0] = sheet2.crop(width * 4, 0, width, height);
		player_left[1] = sheet2.crop(width * 5, 0, width, height);
		
		
		//Enemy
		SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("res/textures/sheet3.png"));
		enemy = new BufferedImage[2];
		enemy[0] = sheet3.crop(0, 0, width, height);
		enemy[1] = sheet3.crop(width * 1, 0, width, height);
		
		
	}
}
