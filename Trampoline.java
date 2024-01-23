import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trampoline here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trampoline extends Actor
{
    GreenfootImage[] trampolineActivated = new GreenfootImage[8];
    SimpleTimer trampolineAnimationTimer = new SimpleTimer();
    int imageIndex = 0;
    int tramVarX = 0;
    public Trampoline()
    {
        for(int i = 0; i < trampolineActivated.length; i++)
        {
            trampolineActivated[i] = new GreenfootImage("images/Trampoline-AD/TAD" + i + ".png");
        }
        trampolineAnimationTimer.mark();
    }
    public void animate()
    {
        for(int i = 0; i < trampolineActivated.length; i++)
        {
            if(trampolineAnimationTimer.millisElapsed() < 150)
            {
                return;
            }
            trampolineAnimationTimer.mark();
            
            setImage(trampolineActivated[imageIndex]);
            imageIndex = (imageIndex + 1) % trampolineActivated.length;
        }
    }
    public void act()
    {
        // Add your action code here.
        if(isTouching(playerCharacter.class))
        {
            tramVarX++;
        }
        
        if(tramVarX == 1)
        {
            animate();
            tramVarX = 0;
        }
    }
}
