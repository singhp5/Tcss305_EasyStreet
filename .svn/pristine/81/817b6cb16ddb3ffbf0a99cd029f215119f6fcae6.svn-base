/*
 * TCSS 305 
 * Assignment 3 - Easy Street
 */
package model;

import java.util.Map;

/**
 * This ATV class extends an AbstractVehicle class 
 * to move car according to the given specifications.
 * @author prabhjot singh
 * @version 1/27/2016
 */
public class Atv extends AbstractVehicle {

    /**
     * Number of steps this object must skip if it's dead.
     */
    private static final int MY_DEATH_TIME = 20;

    /**
     * 
     * @param theX is the position of atv on x-axis.
     * @param theY is the position of atv on y-axis.
     * @param theDir is the current direction of Atv.
     */   
    public Atv(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, MY_DEATH_TIME);
    }

    /**
     * Sets canPass() to true for terrain the atv can travel on.
     * Atv runs all lights. 
     * @param theTerrain terrain the atv is trying to go on.
     * @param theLight color of the light when the terrain is a light.
     * @return if the vehicle can travel onto the terrain. 
     */
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        
        return !(theTerrain == Terrain.WALL);
    }
    
    /**
     *  Takes in a map of the terrains in each direction at each update.
     *  Atv selects a random direction until the direction is no longer a wall. 
     *  @param theNeighbors Map of the terrains neighboring the car.
     *  @return The direction the atv chooses.
     */
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        boolean flag;
        final Direction current = this.getDirection();
        Direction changeDirection;
        Direction directionPicked = null;
        do {
            changeDirection = Direction.random();
            if (theNeighbors.get(changeDirection) == Terrain.WALL) {
                flag = false;
            } else if (changeDirection == current.reverse()) {
                flag = false;
            } else {
                flag = true;
                this.setDirection(changeDirection);
                directionPicked = changeDirection;
            }
            
        } while (!flag);
        return directionPicked;
    }

}
