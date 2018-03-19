/*
 * TCSS 305 
 * Assignment 3 - Easy Street
 */

package model;

import java.util.Map;

/**
 * This is an AbstractVehicle class which implements Vehicle interface. 
 * @author prabhjot singh
 * @version 1/27/2016
 */
public abstract class AbstractVehicle implements Vehicle {

    /** Instance field for x coordinate. */
    private int myX;
    /** Instance field for y coordinate. */
    private int myY;
    /** Instance field for starting x. */
    private final int myStartingX;
    /** Instance field for starting y. */
    private final int myStartingY;
    /** Instance field for direction. */
    private Direction myDirection;
    /** Instance field for starting direction. */
    private final Direction myStartingDir;
    /** Instance field for death time. */
    private final int myDeathTime;
    /** Instance field for death time count. */
    private int myTimeCount;

    /**
     * This is a constructor for an abstract class to initialize fields.
     * 
     * @param theX is the x coordinate value.
     * @param theY is the y coordinate value.
     * @param theDirection is the current direction.
     * @param theDeathTime is the death time.
     */
    protected AbstractVehicle(final int theX, final int theY, final Direction theDirection,
                              final int theDeathTime) {
        myX = theX;
        myY = theY;
        myDirection = theDirection;

        myStartingX = theX;
        myStartingY = theY;
        myStartingDir = theDirection;

        myDeathTime = theDeathTime;
        myTimeCount = theDeathTime;

    }

    @Override
    public abstract boolean canPass(Terrain theTerrain, Light theLight);

    @Override
    public abstract Direction chooseDirection(Map<Direction, Terrain> theNeighbors);

    @Override
    public void collide(final Vehicle theOther) {
        if ((theOther.isAlive() && isAlive()) && (theOther.getDeathTime() < myTimeCount)) {
            myTimeCount = 0;
        }
    }

    @Override
    public int getDeathTime() { 
        return myDeathTime;
    }

    @Override
    public String getImageFileName() {
        String nameImage = getClass().getSimpleName().toLowerCase() + ".gif";
        if (!isAlive()) {
            nameImage = getClass().getSimpleName().toLowerCase() + "_dead.gif";
        } 
        return nameImage;
    }

    @Override
    public Direction getDirection() {
        return myDirection;
    }

    @Override
    public int getX() {
        return myX;
    }

    @Override
    public int getY() {
        return myY;
    }

    @Override
    public boolean isAlive() {
        return myTimeCount == myDeathTime;
    }

    @Override
    public void poke() {
        if (isAlive()) {
            myDirection = Direction.random();
        } else {
            myTimeCount++;
        }
    }

    @Override
    public void reset() {
        myX = myStartingX;
        myY = myStartingY;
        myDirection = myStartingDir;
        myTimeCount = myDeathTime;
    }

    @Override
    public void setDirection(final Direction theDir) {
        myDirection = theDir;
    }

    @Override
    public void setX(final int theX) {
        myX = theX;
    }


    @Override
    public void setY(final int theY) {
        myY = theY;

    }

}
