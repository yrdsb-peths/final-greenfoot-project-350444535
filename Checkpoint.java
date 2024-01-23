import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Checkpoint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Checkpoint extends Actor
{
    /**
     * Act - do whatever the Checkpoint wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
    int checkpointLevel = 0;
    public Checkpoint()
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
    private void levelUp()
    {
        if(checkpointVarW == 1)
        {
            resetWorld();
            worldBuild();
        }
    }
    private void resetWorld()
    {
        getWorld().removeObjects(getWorld().getObjects(Terrain2.class));
        getWorld().removeObjects(getWorld().getObjects(Terrain3.class));
        getWorld().removeObjects(getWorld().getObjects(Spikes.class));
    }
    private void worldBuild()
    {
        checkpointLevel++;
        if(checkpointLevel == 1)
        {
            // All terrain actors here are giving a triple digit number begining with "1" to show level one
            Terrain3 terrain103 = new Terrain3();
            getWorld().addObject(terrain103,386,296);
            terrain103.setLocation(386,296);
            Terrain2 terrain102 = new Terrain2();
            getWorld().addObject(terrain102,386,296);
            Terrain3 terrain132 = new Terrain3();
            getWorld().addObject(terrain132,323,297);
            terrain132.setLocation(323,296);
            Terrain2 terrain122 = new Terrain2();
            getWorld().addObject(terrain122,323,296);
            Terrain3 terrain112 = new Terrain3();
            getWorld().addObject(terrain112,260,297);
            terrain112.setLocation(260,296);
            Terrain2 terrain123 = new Terrain2();
            getWorld().addObject(terrain123,260,296);
            Terrain3 terrain134 = new Terrain3();
            getWorld().addObject(terrain134,197,282);
            terrain134.setLocation(197,282);
            Terrain2 terrain124 = new Terrain2();
            getWorld().addObject(terrain124,197,282);
            Terrain3 terrain135 = new Terrain3();
            getWorld().addObject(terrain135,134,256);
            terrain135.setLocation(134,256);
            Terrain2 terrain125 = new Terrain2();
            getWorld().addObject(terrain125,134,256);
            Terrain3 terrain136 = new Terrain3();
            getWorld().addObject(terrain136,71,222);
            Terrain2 terrain126 = new Terrain2();
            getWorld().addObject(terrain126,71,222);
            Terrain3 terrain137 = new Terrain3();
            getWorld().addObject(terrain137,157,110);
            Terrain2 terrain127 = new Terrain2();
            getWorld().addObject(terrain127,157,110);
            Terrain1 terrain101 = new Terrain1();
            getWorld().addObject(terrain101,224,90);
            Terrain4 terrain181 = new Terrain4();
            getWorld().addObject(terrain181,224,93);
            Checkpoint2 checkpoint101 = new Checkpoint2();
            getWorld().addObject(checkpoint101,272,29);
            Fan fan101 = new Fan();
            getWorld().addObject(fan101,70,195);
            Spikes spikes101 = new Spikes();
            getWorld().addObject(spikes101,260,265);
            Spikes spikes102 = new Spikes();
            getWorld().addObject(spikes102,128,225); 
        }
    }
    public void act()
    {
        // Add your action code here.
        if(isTouching(playerCharacter.class))
        {
            checkpointVarX++;
            checkpointVarW++;
            levelUp();
        }
    
        if(checkpointVarX >= 1)
        {
            animateActivating();
        }
    }
}
