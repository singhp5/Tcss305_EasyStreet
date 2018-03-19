/*
 * TCSS 305 
 * Assignment 3 - Easy Street
 */

package model;

import java.util.Map;

/**
 * This Human class extends an AbstractVehicle class 
 * to move humans according to the given specifications.
 * @author prabhjot singh
 * @version 1/27/2016
 */
public class Human extends AbstractVehicle {

    /** Static final constant for death time. */
    public static final int DEATH_TIME = 50;

    /** This is an instance field of terrain. */
    private final Terrain myTerrain;

    /**
     * This is a constructor which construct a Human object.
     * 
     * @param theX is the position of human on x-axis.
     * @param theY is the position of human on y-axis.
     * @param theDirection is the current direction of human.
     * @param theTerrain is the current terrain human will be on.
     */
    public Human(final int theX, final int theY, final Direction theDirection, 
                 final Terrain theTerrain) {
        super(theX, theY, theDirection, DEATH_TIME);
        myTerrain = theTerrain;
    }

    /**
     * This instance method look if human can pass or not.
     * 
     *  @param theTerrain is the terrain the human is on.
     *  @param theLight is the current light color.
     *  @return boolean true if it can pass or false if not.
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        return true;

    }


    /**
     * This instance method will choose the direction for human in which they can move.
     * 
     * @param theNeighbors is the Map of key Direction and values Terrain.
     * @return Direction the human could make a move.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {

        Direction newDirection = Direction.random();
        Terrain newTerrain = theNeighbors.get(newDirection);

        switch (myTerrain) {
            case STREET:
            case LIGHT:
                while (newTerrain != Terrain.STREET && newTerrain != Terrain.LIGHT) {
                    newDirection = Direction.random();
                    newTerrain = theNeighbors.get(newDirection);
                }
                break;
            case WALL:
            case GRASS:
            case TRAIL:
                while (!(newTerrain.equals(myTerrain))) {
                    newDirection = Direction.random();
                    newTerrain = theNeighbors.get(newDirection);
                }
                break;
            default:
                break;
        }
        return newDirection;
    }
}

