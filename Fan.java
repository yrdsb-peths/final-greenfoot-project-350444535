import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fan extends Actor
{
    GreenfootImage[] fanActivated = new GreenfootImage[4];
    SimpleTimer fanAnimationTimer = new SimpleTimer();
    int imageIndex = 0;
    int fanVarX = 0;
    public Fan()
    {
        for(int i = 0; i < fanActivated.length; i++)
        {
            fanActivated[i] = new GreenfootImage("images/Fan-AD/On" + i + ".png");
        }
        fanAnimationTimer.mark();
    }
    public void animate()
    {
        for(int i = 0; i < fanActivated.length; i++)
        {
            if(fanAnimationTimer.millisElapsed() < 100)
            {
                return;
            }
            fanAnimationTimer.mark();
            
            setImage(fanActivated[imageIndex]);
            imageIndex = (imageIndex + 1) % fanActivated.length;
        }
    }
    public void act()
    {
        // Add your action code here.
        animate();
    }
}
