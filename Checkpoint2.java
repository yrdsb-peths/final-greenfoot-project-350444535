import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Checkpoint2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Checkpoint2 extends Actor
{
    GreenfootImage[] activating = new GreenfootImage[26];
    SimpleTimer activatingTimer = new SimpleTimer();
    int activatingimageIndex = 0;
    GreenfootImage[] activated = new GreenfootImage[10];
    SimpleTimer activatedTimer = new SimpleTimer();
    int activatedImageIndex = 0;
    int checkpointVarW = 0;
    int checkpointVarX = 0;
    int checkpointVarY = 0;
    int checkpointVarZ = 0;
    int checkpoint2Level = 0;
    public Checkpoint2()
    {
        for(int y = 0; y < activating.length; y++)
        {
            activating[y] = new GreenfootImage("images/Checkpoint-AG/AG" + y + ".png");
        }
        activatingTimer.mark();
        
        for(int z = 0; z < activated.length; z++)
        {
            activated[z] = new GreenfootImage("images/Checkpoint-AD/AD" + z + ".png");
        }
        activatedTimer.mark();
    }
    public void animateActivating()
    {
        if(checkpointVarY == 0)
        {
            if(activatingTimer.millisElapsed() < 60)
            {
                return;
            }
            activatingTimer.mark();
            setImage(activating[activatingimageIndex]);
            activatingimageIndex = (activatingimageIndex + 1) % activating.length;
            checkpointVarZ++;
            if(checkpointVarZ >= 25)
            {
                checkpointVarY++;
            }
        }
        if(checkpointVarY >= 1)
        {
            if(activatedTimer.millisElapsed() < 60)
            {
                return;
            }
            activatedTimer.mark();
            setImage(activated[activatedImageIndex]);
            activatedImageIndex = (activatedImageIndex + 1) % activated.length;
        }
    }
    private void levelUp2()
    {
        if(checkpointVarW == 1)
        {
            resetWorld1();
            world2Build();
        }
    }
    private void resetWorld1()
    {
        getWorld().removeObjects(getWorld().getObjects(Terrain2.class));
        getWorld().removeObjects(getWorld().getObjects(Terrain3.class));
        getWorld().removeObjects(getWorld().getObjects(Spikes.class));
        getWorld().removeObjects(getWorld().getObjects(Checkpoint.class));
        getWorld().removeObjects(getWorld().getObjects(Fan.class));
    }
    private void world2Build()
    {
        checkpoint2Level++;
        if(checkpoint2Level == 1)
        {
            // All terrain actors here are giving a triple digit number begining with "2" to show level Two
            Terrain3 terrain203 = new Terrain3();
            getWorld().addObject(terrain203,299,85);
            terrain203.setLocation(300,86);
            Terrain2 terrain202 = new Terrain2();
            getWorld().addObject(terrain202,300,86);
            
            
            Terrain3 terrain232 = new Terrain3();
            getWorld().addObject(terrain232,156,81);
            terrain232.setLocation(156,81);
            Terrain2 terrain222 = new Terrain2();
            getWorld().addObject(terrain222,156,81);
            
            Terrain3 terrain234 = new Terrain3();
            getWorld().addObject(terrain234,361,85);
            terrain234.setLocation(362,86);
            Terrain2 terrain24 = new Terrain2();
            getWorld().addObject(terrain24,362,86);
            
            Terrain3 terrain35 = new Terrain3();
            getWorld().addObject(terrain35,422,85);
            terrain35.setLocation(421,86);
            Terrain2 terrain25 = new Terrain2();
            getWorld().addObject(terrain25,421,86);
            
            Terrain3 terrain36 = new Terrain3();
            getWorld().addObject(terrain36,483,85);
            terrain36.setLocation(483,86);
            Terrain2 terrain26 = new Terrain2();
            getWorld().addObject(terrain26,483,86);
            
            Terrain3 terrain37 = new Terrain3();
            getWorld().addObject(terrain37,483,131);
            Terrain2 terrain27 = new Terrain2();
            getWorld().addObject(terrain27,483,130);
            
            Terrain3 terrain38 = new Terrain3();
            getWorld().addObject(terrain38,528,279);
            terrain38.setLocation(527,278);
            Terrain2 terrain28 = new Terrain2();
            getWorld().addObject(terrain28,527,278);
            
            Terrain3 terrain39 = new Terrain3();
            getWorld().addObject(terrain39,574,248);
            terrain39.setLocation(574,248);
            Terrain2 terrain29 = new Terrain2();
            getWorld().addObject(terrain29,574,248);
            
            Terrain3 terrain310 = new Terrain3();
            getWorld().addObject(terrain310,448,328);
            terrain310.setLocation(447,326);
            Terrain2 terrain210 = new Terrain2();
            getWorld().addObject(terrain210,447,326);
            
            Terrain3 terrain311 = new Terrain3();
            getWorld().addObject(terrain311,448,373);
            Terrain2 terrain211 = new Terrain2();
            getWorld().addObject(terrain211,449,372);
            
            Terrain3 terrain312 = new Terrain3();
            getWorld().addObject(terrain312,282,362);
            terrain312.setLocation(282,361);
            Terrain2 terrain212 = new Terrain2();
            getWorld().addObject(terrain212,282,361);
            
            Terrain3 terrain313 = new Terrain3();
            getWorld().addObject(terrain313,281,316);
            terrain313.setLocation(281,316);
            Terrain2 terrain213 = new Terrain2();
            getWorld().addObject(terrain213,281,316);
            
            Terrain3 terrain314 = new Terrain3();
            getWorld().addObject(terrain314,280,270);
            terrain314.setLocation(280,270);
            Terrain2 terrain214 = new Terrain2();
            getWorld().addObject(terrain214,280,270);
            
            Terrain3 terrain315 = new Terrain3();
            getWorld().addObject(terrain315,345,366);
            Terrain2 terrain215 = new Terrain2();
            getWorld().addObject(terrain215,344,366);
            
            Terrain3 terrain317 = new Terrain3();
            getWorld().addObject(terrain317,156,126);
            terrain317.setLocation(155,125);
            Terrain2 terrain217 = new Terrain2();
            getWorld().addObject(terrain217,155,125);
            
            Terrain3 terrain282 = new Terrain3();
            getWorld().addObject(terrain282,29,365);
            terrain282.setLocation(29,366);
            Terrain2 terrain281 = new Terrain2();
            getWorld().addObject(terrain281,29,366);
            
            Terrain3 terrain233 = new Terrain3();
            getWorld().addObject(terrain233,138,34);
            terrain233.setLocation(138,35);
            Terrain2 terrain280 = new Terrain2();
            getWorld().addObject(terrain280,138,35);
            
            Spikes spikes = new Spikes();
            getWorld().addObject(spikes,582,219);
            Fan fan = new Fan();
            getWorld().addObject(fan,344,340);
            Fan fan2 = new Fan();
            getWorld().addObject(fan2,33,340);
            Spikes spikes2 = new Spikes();
            getWorld().addObject(spikes2,166,363);
            Spikes spikes3 = new Spikes();
            getWorld().addObject(spikes3,83,361);
            
            Terrain3 terrain3 = new Terrain3();
            getWorld().addObject(terrain3,155,170);
            Terrain3 terrain32 = new Terrain3();
            getWorld().addObject(terrain32,140,216);
            Terrain3 terrain33 = new Terrain3();
            getWorld().addObject(terrain33,108,240);
            Terrain2 terrain2 = new Terrain2();
            getWorld().addObject(terrain2,108,240);
            terrain32.setLocation(142,219);
            Terrain2 terrain22 = new Terrain2();
            getWorld().addObject(terrain22,142,219);
            Terrain2 terrain23 = new Terrain2();
            getWorld().addObject(terrain23,155,170);
            
            Fan fan3 = new Fan();
            getWorld().addObject(fan3,87,212);
            
            Terrain3 terrain349 = new Terrain3();
            getWorld().addObject(terrain349,15,129);
            Terrain2 terrain249 = new Terrain2();
            getWorld().addObject(terrain249,15,129);
            
            Finish finish = new Finish();
            getWorld().addObject(finish,23,75);
        }
    }
    /**
     * Act - do whatever the Checkpoint2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(isTouching(playerCharacter.class))
        {
            checkpointVarX++;
            checkpointVarW++;
            levelUp2();
        }
    
        if(checkpointVarX >= 1)
        {
            animateActivating();
        }
    }
}
