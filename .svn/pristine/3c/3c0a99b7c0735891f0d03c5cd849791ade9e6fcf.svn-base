/*
 * TCSS 305 
 * Assignment 3 - Easy Street
 */

package model;

import java.util.Map;

/**
 * This bicycle class extends an AbstractVehicle class 
 * to move bicycle according to the given specifications.
 * @author prabhjot singh
 * @version 1/27/2016
 */
public class Bicycle extends AbstractVehicle {
    // Static fields

    /**
     * Number of steps this object must skip if it's dead.
     */
    private static final int MY_DEATH_TIME = 30;

    // Constructor

    /**
     * This is a constructor which construct a Bicycle object.
     * 
     * @param theX is the position of Bicycle on x-axis.
     * @param theY is the position of Bicycle on y-axis.
     * @param theDir is the current direction of Bicycle.
     */
    public Bicycle(final int theX, final int theY, 
                   final Direction theDir) {
        super(theX, theY, theDir, MY_DEATH_TIME);
    }

    // Instance methods

    /**
     * Returns the direction the bicycle would like to move, based on the given
     * map of the terrain of its neighbors and the given status of the street
     * lights.
     * 
     * @param theNeighbors The map of neighboring terrain.
     * @return the direction this bicycle would like to move.
     */
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        final Direction current = this.getDirection();
        Direction changeDirection = null;
            
        if (theNeighbors.get(current) == Terrain.TRAIL) {
            changeDirection = current;
        } else if (theNeighbors.get(current.left()) == Terrain.TRAIL) {
            changeDirection = current.left();
        } else if (theNeighbors.get(current.right()) == Terrain.TRAIL) {
            changeDirection = current.right();
        } else if (theNeighbors.get(current) == Terrain.STREET
                        || theNeighbors.get(current) == Terrain.LIGHT) {
            changeDirection = current;
        } else if (theNeighbors.get(current.left()) == Terrain.STREET
                        || theNeighbors.get(current.left()) == Terrain.LIGHT) {
            changeDirection = current.left();
        } else if (theNeighbors.get(current.right()) == Terrain.STREET
                        || theNeighbors.get(current.right()) == Terrain.LIGHT) {
            changeDirection = current.right();
        } else {
            changeDirection = current.reverse();
        }
        this.setDirection(changeDirection);
        return changeDirection;
    }

    /**
     * Returns whether or not the bicycle may move onto the given type of
     * terrain, when the street lights are the given color.
     * 
     * @param theTerrain The terrain.
     * @param theLight The light color.
     * @return whether or not this bicycle may move onto the given type of
     *         terrain when the street lights are the given color.
     */
    public boolean canPass(final Terrain theTerrain, final Light theLight) {

        boolean pass = false;
        if (theTerrain == Terrain.STREET || theTerrain == Terrain.TRAIL) {
            pass = true;
        } else if (theTerrain == Terrain.LIGHT && theLight == Light.GREEN) {
            pass = true;
        }
        return pass;
    }


}
