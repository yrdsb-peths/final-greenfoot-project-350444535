import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class playerCharacter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playerCharacter extends Actor
{
    /**
     * Act - do whatever the playerCharacter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] runningRight = new GreenfootImage[12];
    GreenfootImage[] runningLeft = new GreenfootImage[12];
    GreenfootImage[] fallingRight = new GreenfootImage[1];
    GreenfootImage[] fallingLeft = new GreenfootImage[1];
    
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    int imageIndex = 0;
    public playerCharacter()
    {
        for(int i = 0; i < runningRight.length; i++)
        {
            runningRight[i] = new GreenfootImage("images/Running-Virtual/Running" + i + ".png");
            runningRight[i].scale(50, 50);
        }
        
        for(int i = 0; i < runningLeft.length; i++)
        {
            runningLeft[i] = new GreenfootImage("images/Running-Virtual/Running" + i + ".png");
            runningLeft[i].mirrorHorizontally();
            runningLeft[i].scale(50, 50);
        }
        
        animationTimer.mark();
        
        setImage(runningRight[0]);
    }
    public void animateWalking()
    {
        if(animationTimer.millisElapsed() < 150)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            setImage(runningRight[imageIndex]);
            imageIndex = (imageIndex + 1) % runningRight.length;
        }
        else
        {
            setImage(runningLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % runningLeft.length;
        }
    }
    public void animateFalling()
    {
        
    }
    public void act()
    {
        // Add your action code here.
        
        if(isTouching(Terrain1.class) || isTouching(Terrain2.class) || isTouching(Terrain3.class))
        {
        }
        else
        {
            setLocation(getX(), getY() + 2);
        }
        
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
            facing = "left";
            if(isTouching(Terrain2.class))
            {
                move(2);
                if(Greenfoot.isKeyDown("up"))
                {
                    jump();
                }
            }
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(2);
            facing = "right";
            if(isTouching(Terrain2.class))
            {
                move(-2);
                if(Greenfoot.isKeyDown("up"))
                {
                    jump();
                }
            }
        }
        else if(Greenfoot.isKeyDown("up"))
        {
            jump();
        }
        
        finish();
        
        if(isTouching(Terrain1.class) || isTouching(Terrain3.class))
        {
            animateWalking();
        }
        else if(!isTouching(Terrain1.class) || !isTouching(Terrain2.class) || !isTouching(Terrain3.class))
        {
    
        }
    }
    public void jump()
        {
        
            
            if(isTouching(Terrain1.class) || isTouching(Terrain3.class)) //on ground level
            {
                if(facing.equals("left"))
                {
                    setLocation(getX(), getY() - 15);
                    move(-2);
                    Greenfoot.delay(5);
                    setLocation(getX(), getY() - 15);
                    move(-2);
                    Greenfoot.delay(5);
                    setLocation(getX(), getY() - 15);
                    move(-2);
                    Greenfoot.delay(5);
                }
                else if(facing.equals("right"))
                {
                    setLocation(getX(), getY() - 15);
                    move(2);
                    Greenfoot.delay(5);
                    setLocation(getX(), getY() - 15);
                    move(2);
                    Greenfoot.delay(5);
                    setLocation(getX(), getY() - 15);
                    move(2);
                    Greenfoot.delay(5);
                }
                else
                {
                    setLocation(getX(), getY() - 15);
                    Greenfoot.delay(5);
                    setLocation(getX(), getY() - 15);
                    Greenfoot.delay(5);
                    setLocation(getX(), getY() - 15);
                    Greenfoot.delay(5); 
                }
            }
            else
            {
                
            }    
        }
    public void finish()
        {
            if(isTouching(Finish.class))
            {
                removeTouching(Finish.class);
                MyWorld world = (MyWorld) getWorld();
            }
        }
}
