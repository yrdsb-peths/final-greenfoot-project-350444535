import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        levelOne();
        
    }

    public void levelOne()
    {
        // All terrain actors are given a single or double digit number

        Terrain1 terrain1 = new Terrain1();
        addObject(terrain1,33,397);
        Terrain1 terrain12 = new Terrain1();
        addObject(terrain12,112,398);
        Terrain1 terrain13 = new Terrain1();
        addObject(terrain13,191,398);
        Terrain1 terrain14 = new Terrain1();
        addObject(terrain14,271,399);
        Terrain1 terrain15 = new Terrain1();
        addObject(terrain15,351,399);
        Terrain1 terrain16 = new Terrain1();
        addObject(terrain16,431,399);
        Terrain1 terrain17 = new Terrain1();
        addObject(terrain17,510,399);
        Terrain1 terrain18 = new Terrain1();
        addObject(terrain18,590,399);

        playerCharacter playerCharacter = new playerCharacter();
        addObject(playerCharacter,22,334);
        

        Terrain3 terrain3 = new Terrain3();
        addObject(terrain3,171,361);
        terrain3.setLocation(170,366);
        Terrain2 terrain2 = new Terrain2();
        addObject(terrain2,170,366);
        Terrain3 terrain32 = new Terrain3();
        addObject(terrain32,217,335);
        terrain32.setLocation(217,338);
        Terrain2 terrain22 = new Terrain2();
        addObject(terrain22,217,338);
        Terrain3 terrain33 = new Terrain3();
        addObject(terrain33,278,338);
        terrain33.setLocation(278,337);
        Terrain2 terrain23 = new Terrain2();
        addObject(terrain23,278,337);
        Terrain3 terrain34 = new Terrain3();
        addObject(terrain34,340,337);
        terrain34.setLocation(340,337);
        Terrain2 terrain24 = new Terrain2();
        addObject(terrain24,340,337);
        Terrain3 terrain35 = new Terrain3();
        addObject(terrain35,387,306);
        terrain35.setLocation(387,307);
        Terrain2 terrain25 = new Terrain2();
        addObject(terrain25,387,307);

        Spikes spikes = new Spikes();
        addObject(spikes,231,308);

        Checkpoint checkpoint = new Checkpoint();
        addObject(checkpoint,466,224);
        Terrain1 terrain60 = new Terrain1();
        addObject(terrain60,454,285);
        Terrain4 terrain61 = new Terrain4();
        addObject(terrain61, 454, 287);
        
        /*
        Terrain3 terrain203 = new Terrain3();
        addObject(terrain203,299,85);
        terrain203.setLocation(300,86);
        Terrain2 terrain202 = new Terrain2();
        addObject(terrain202,300,86);
        
        
        Terrain3 terrain232 = new Terrain3();
        addObject(terrain232,156,81);
        terrain232.setLocation(156,81);
        Terrain2 terrain222 = new Terrain2();
        addObject(terrain222,156,81);
        
        Terrain3 terrain34 = new Terrain3();
        addObject(terrain34,361,85);
        terrain34.setLocation(362,86);
        Terrain2 terrain24 = new Terrain2();
        addObject(terrain24,362,86);
        
        Terrain3 terrain35 = new Terrain3();
        addObject(terrain35,422,85);
        terrain35.setLocation(421,86);
        Terrain2 terrain25 = new Terrain2();
        addObject(terrain25,421,86);
        
        Terrain3 terrain36 = new Terrain3();
        addObject(terrain36,483,85);
        terrain36.setLocation(483,86);
        Terrain2 terrain26 = new Terrain2();
        addObject(terrain26,483,86);
        
        Terrain3 terrain37 = new Terrain3();
        addObject(terrain37,483,131);
        Terrain2 terrain27 = new Terrain2();
        addObject(terrain27,483,130);
        
        Terrain3 terrain38 = new Terrain3();
        addObject(terrain38,528,279);
        terrain38.setLocation(527,278);
        Terrain2 terrain28 = new Terrain2();
        addObject(terrain28,527,278);
        
        Terrain3 terrain39 = new Terrain3();
        addObject(terrain39,574,248);
        terrain39.setLocation(574,248);
        Terrain2 terrain29 = new Terrain2();
        addObject(terrain29,574,248);
        
        Terrain3 terrain310 = new Terrain3();
        addObject(terrain310,448,328);
        terrain310.setLocation(447,326);
        Terrain2 terrain210 = new Terrain2();
        addObject(terrain210,447,326);
        
        Terrain3 terrain311 = new Terrain3();
        addObject(terrain311,448,373);
        Terrain2 terrain211 = new Terrain2();
        addObject(terrain211,449,372);
        
        Terrain3 terrain312 = new Terrain3();
        addObject(terrain312,282,362);
        terrain312.setLocation(282,361);
        Terrain2 terrain212 = new Terrain2();
        addObject(terrain212,282,361);
        
        Terrain3 terrain313 = new Terrain3();
        addObject(terrain313,281,316);
        terrain313.setLocation(281,316);
        Terrain2 terrain213 = new Terrain2();
        addObject(terrain213,281,316);
        
        Terrain3 terrain314 = new Terrain3();
        addObject(terrain314,280,270);
        terrain314.setLocation(280,270);
        Terrain2 terrain214 = new Terrain2();
        addObject(terrain214,280,270);
        
        Terrain3 terrain315 = new Terrain3();
        addObject(terrain315,345,366);
        Terrain2 terrain215 = new Terrain2();
        addObject(terrain215,344,366);
        
        Terrain3 terrain317 = new Terrain3();
        addObject(terrain317,156,126);
        terrain317.setLocation(155,125);
        Terrain2 terrain217 = new Terrain2();
        addObject(terrain217,155,125);
        
        Terrain3 terrain282 = new Terrain3();
        addObject(terrain282,29,365);
        terrain282.setLocation(29,366);
        Terrain2 terrain281 = new Terrain2();
        addObject(terrain281,29,366);
        
        Terrain3 terrain233 = new Terrain3();
        addObject(terrain233,138,34);
        terrain233.setLocation(138,35);
        Terrain2 terrain280 = new Terrain2();
        addObject(terrain280,138,35);
        
        Spikes spikes = new Spikes();
        addObject(spikes,582,219);
        Fan fan = new Fan();
        addObject(fan,344,340);
        Fan fan2 = new Fan();
        addObject(fan2,33,340);
        Spikes spikes2 = new Spikes();
        addObject(spikes2,166,363);
        Spikes spikes3 = new Spikes();
        addObject(spikes3,83,361);
        Terrain3 terrain3 = new Terrain3();
        addObject(terrain3,155,170);
        Terrain3 terrain32 = new Terrain3();
        addObject(terrain32,140,216);
        Terrain3 terrain33 = new Terrain3();
        addObject(terrain33,108,257);
        terrain33.setLocation(108,257);
        Terrain2 terrain2 = new Terrain2();
        addObject(terrain2,108,257);
        terrain32.setLocation(142,219);
        Terrain2 terrain22 = new Terrain2();
        addObject(terrain22,142,219);
        terrain3.setLocation(155,170);
        Terrain2 terrain23 = new Terrain2();
        addObject(terrain23,155,170);
        Fan fan3 = new Fan();
        addObject(fan3,87,230);
        Terrain3 terrain349 = new Terrain3();
        addObject(terrain349,15,129);
        terrain34.setLocation(15,129);
        Terrain2 terrain249 = new Terrain2();
        addObject(terrain249,15,129);
        Finish finish = new Finish();
        addObject(finish,23,75);
        */
        
    }
}
