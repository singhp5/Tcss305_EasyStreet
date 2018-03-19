/*
 * TCSS 305 
 * Assignment 3 - Easy Street
 */

package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * This Truck class extends an AbstractVehicle class 
 * to move Trucks according to the given specifications.
 * @author prabhjot singh
 * @version 1/27/2016
 */
public class Truck extends AbstractVehicle {

    /**
     * Number of steps this object must skip if it's dead. 
     */
    private static final int MYDEATHTIME = 0;

    /**
     * Constructs a truck object with specified x_coordinate, y_coordinate,
     * direction and terrain.
     * 
     * @param theX the x_coordinate
     * @param theY the y_coordinate
     * @param theDirection the direction
     * 
     */
    public Truck(final int theX, final int theY, final Direction theDirection) {
        super(theX, theY, theDirection, MYDEATHTIME);
    }

    // Instance methods

    /**
     * Returns the direction the truck would like to move, based on the given
     * map of the terrain of its neighbors and the given status of the street
     * lights.
     * @param theNeighbors is the Map of key Direction and values Terrain.
     * @return the direction this truck would like to move.
     */
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        final Random rand = new Random();
        final Direction direction1 = getDirection();



        // Direction the_new_direction = theDirection;

        final Direction[] directionArray = {direction1, 
                        direction1.left(), direction1.right()};
        final List<Direction> possibleDirectionArray = new ArrayList<Direction>();

        // Create the possible direction array for the truck
        for (int i = 0; i < directionArray.length; i++) {
            final Terrain newTerrain = theNeighbors.get(directionArray[i]);
            if (newTerrain == Terrain.STREET || newTerrain == Terrain.LIGHT) {
                possibleDirectionArray.add(directionArray[i]);
            }
        }

        if (possibleDirectionArray.isEmpty()) {
            return direction1.reverse();
        } else {
            final int randomIndex = rand.nextInt(possibleDirectionArray.size());
            return possibleDirectionArray.get(randomIndex);
        }
        // return the_new_direction;
    }

    /**
     * Returns whether or not the truck may move onto the given type of terrain,
     * when the street lights are the given color.
     * 
     * @param theTerrain The terrain.
     * @param theLight The light color.
     * @return whether or not this truck may move onto the given type of terrain
     *         when the street lights are the given color.
     */
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        return theTerrain == Terrain.STREET || theTerrain == Terrain.LIGHT;
    }

}

