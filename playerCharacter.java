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
    Label label102 = new Label("You Died!", 100);
    Label label103 = new Label("Click reset to retry", 50);
    Label label104 = new Label("You Win!", 100);
    GreenfootImage[] runningRight = new GreenfootImage[12];
    GreenfootImage[] runningLeft = new GreenfootImage[12];
    GreenfootImage[] idleRight = new GreenfootImage[11];
    GreenfootImage[] idleLeft = new GreenfootImage[11];
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    SimpleTimer idleTimer = new SimpleTimer();
    int imageIndex = 0;
    int idleImageIndex = 0;
    int respawnLevel = 0;
    int life = 1;
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
        
        for(int a = 0; a < idleRight.length; a++)
        {
            idleRight[a] = new GreenfootImage("images/idle-Virtual/Idle" + a + ".png");
            idleRight[a].scale(50, 50);
        }
        
        for(int a = 0; a < idleLeft.length; a++)
        {
            idleLeft[a] = new GreenfootImage("images/idle-Virtual/Idle" + a + ".png");
            idleLeft[a].mirrorHorizontally();
            idleLeft[a].scale(50, 50);
        }
        
        idleTimer.mark();
        
        setImage(idleRight[0]);
    }
    public void animateWalking()//walking animation
    {
        if(animationTimer.millisElapsed() < 100)
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
    public void animateFalling()//falling animation
    {
        if(facing.equals("right"))
        {
            GreenfootImage fallingRight = new GreenfootImage("images/Fall.png");
            fallingRight.scale(50,50);
            setImage(fallingRight);
        }
        else
        {
            GreenfootImage fallingLeft = new GreenfootImage("images/Fall.png");
            fallingLeft.mirrorHorizontally();
            fallingLeft.scale(50,50);
            setImage(fallingLeft);
        }
    }
    public void animateHit()
    {
        if(facing.equals("right"))
        {
            GreenfootImage hitRight = new GreenfootImage("images/hit0.png");
            hitRight.scale(50,50);
            setImage(hitRight);
            Greenfoot.delay(2);
            GreenfootImage hitRightTwo = new GreenfootImage("images/hit1.png");
            hitRightTwo.scale(50,50);
            setImage(hitRightTwo);
        }
        else
        {
            GreenfootImage hitLeft = new GreenfootImage("images/hit0.png");
            hitLeft.mirrorHorizontally();
            hitLeft.scale(50,50);
            setImage(hitLeft);
            Greenfoot.delay(2);
            GreenfootImage hitLeftTwo = new GreenfootImage("images/hit1.png");
            hitLeftTwo.mirrorHorizontally();
            hitLeftTwo.scale(50,50);
            setImage(hitLeftTwo);
        }
    }
    public void animateIdle()
    {
        if(idleTimer.millisElapsed() < 150)
        {
            return;
        }
        idleTimer.mark();
        if(facing.equals("right"))
        {
            setImage(idleRight[idleImageIndex]);
            idleImageIndex = (idleImageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[idleImageIndex]);
            idleImageIndex = (idleImageIndex + 1) % idleLeft.length;
        } 
    }
    public void act()
    {
        // Add your action code here.
        if(life == 1)
        {
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
                if(isTouching(Terrain2.class) || isTouching(Terrain4.class))
                {
                    move(2);
                }
                if(Greenfoot.isKeyDown("up"))
                {
                    jump();
                }
            }
            else if(Greenfoot.isKeyDown("right"))
            {
                move(2);
                facing = "right";
                if(isTouching(Terrain2.class) || isTouching(Terrain4.class))
                {
                    move(-2);
                }
                if(Greenfoot.isKeyDown("up"))
                {
                    jump();
                }
            }
            else if(Greenfoot.isKeyDown("up"))
            {
                jump();
            }
            
            finish();
            
            if(isTouching(Spikes.class))
            {
                spiked();
            }
            
            if(isTouching(Fan.class))
            {
                setLocation(getX(), getY() - 30);
                Greenfoot.delay(5);
                setLocation(getX(), getY() - 30);
                Greenfoot.delay(5);
                setLocation(getX(), getY() - 20);
                Greenfoot.delay(5);
                setLocation(getX(), getY() - 20);
                Greenfoot.delay(5);
                setLocation(getX(), getY() - 20);
                Greenfoot.delay(5);
            }
            
            if(isTouching(Terrain1.class) || isTouching(Terrain3.class))
            {
                if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right"))
                {
                    animateWalking();   
                }
                else
                {
                    animateIdle();
                }
            }
            else if(!isTouching(Terrain1.class) || !isTouching(Terrain2.class) || !isTouching(Terrain3.class))
            {
                animateFalling();
            }
        }
        else
        {
            GreenfootImage death = new GreenfootImage("images/Death.png");
            setImage(death);
        }
    }
    public void jump()//jump code
    {
        if(isTouching(Terrain1.class) || isTouching(Terrain3.class) && !isTouching(Terrain2.class)) //on ground
        {
            if(facing.equals("right"))
            {
                GreenfootImage jumpRight = new GreenfootImage("images/Jump.png");
                jumpRight.scale(50,50);
                setImage(jumpRight);
            }
            else
            {
                GreenfootImage jumpLeft = new GreenfootImage("images/Jump.png");
                jumpLeft.mirrorHorizontally();
                jumpLeft.scale(50,50);
                setImage(jumpLeft);
            } 
            if(facing.equals("left"))
            {
                setLocation(getX(), getY() - 15);
                move(-10);
                Greenfoot.delay(5);
                if(!isTouching(Terrain1.class) || !isTouching(Terrain3.class))
                {
                    setLocation(getX(), getY() - 15);
                    move(-15);
                    Greenfoot.delay(5);
                    if(!isTouching(Terrain1.class) || !isTouching(Terrain3.class))
                    {
                        setLocation(getX(), getY() - 20);
                        move(-20);
                        Greenfoot.delay(5);
                    }
                    else
                    {
                        
                    }
                }
                else
                {
                    
                }
                
                
            }
            else if(facing.equals("right"))
            {
                
                
                setLocation(getX(), getY() - 15);
                move(10);
                Greenfoot.delay(5);
                if(!isTouching(Terrain1.class) || !isTouching(Terrain3.class))
                {
                    setLocation(getX(), getY() - 15);
                    move(15);
                    Greenfoot.delay(5);
                    if(!isTouching(Terrain1.class) || !isTouching(Terrain3.class))
                    {
                        setLocation(getX(), getY() - 20);
                        move(20);
                        Greenfoot.delay(5);
                    }
                    else
                    {
                        
                    }
                }
                else
                {
                    
                }
                
            }
        }
        else
        {
            
        }    
    }
    public void spiked()// code when the character hits spikes
    {
        //getWorld().removeObjects(getWorld().getObjects(playerCharacter.class));
        getWorld().addObject(label102, 300, 200);
        getWorld().addObject(label103, 300, 300);
        life++;
    }
    public void finish()//finish code (when touching the trophy)
    {
        if(isTouching(Finish.class))
        {
            removeTouching(Finish.class);
            MyWorld world = (MyWorld) getWorld();
            getWorld().addObject(label104, 300, 200);
        }
    }
}
