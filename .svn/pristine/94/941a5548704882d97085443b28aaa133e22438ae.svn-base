/*
 * TCSS 305 – Winter 2016
 * Assignment 3 – EasyStreet
 */
package model;

import java.util.Map;

/**
 * This Taxi class extends an AbstractVehicle class 
 * to move car according to the given specifications.
 * @author prabhjot singh
 * @version 1/27/2016
 */
public class Taxi extends AbstractVehicle {

    /** Number of steps this object must skip if it's dead.*/ 
    private static final int MYDEATHTIME = 10;  

    /**Taxi stops at red light. */
    private static final int MYTAXISTOPTIME = 3;

    /**Clock for the stop time. */
    private int  myClockTAXI;


    /**
     * This is a constructor which construct a Car object.
     * 
     * @param theX is the position of Taxi on x-axis.
     * @param theY is the position of Taxi on y-axis.
     * @param theDir is the current direction of Taxi.
     */
    public Taxi(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, MYDEATHTIME);
    }

    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        final Direction taxiDirection = getDirection();

        Direction newTaxiDirection = taxiDirection;

        final Terrain terrainLeft = theNeighbors.get(taxiDirection.left());
        final Terrain terrainRight = theNeighbors.get(taxiDirection.right());

        switch (theNeighbors.get(taxiDirection)) {
            case WALL:
            case GRASS:
            case TRAIL:
                if (terrainLeft == Terrain.STREET || terrainLeft == Terrain.LIGHT) {
                    newTaxiDirection = taxiDirection.left();
                    break;
                } else {
                    if (terrainRight == Terrain.STREET
                                    || terrainLeft == Terrain.LIGHT) {
                        newTaxiDirection = taxiDirection.right();
                        break;
                    } else {
                        newTaxiDirection = taxiDirection.reverse();
                        break;
                    }
                }
            default:
                break;
        }
        return newTaxiDirection;
    }

    /**
     * Returns whether or not the Taxi may move onto the given type of terrain,
     * when the street lights are the given color.
     * 
     * @param theTerrain The terrain.
     * @param theLight The light color.
     * @return whether or not this Taxi may move onto the given type of terrain
     *         when the street lights are the given color.
     */
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean result = false;
        if (theTerrain == Terrain.STREET) {
            result = true;      
        } else if (theTerrain == Terrain.LIGHT) {
            myClockTAXI++;
            if (theLight == Light.GREEN || theLight == Light.YELLOW  
                            || myClockTAXI == MYTAXISTOPTIME) {
                result = true;
                myClockTAXI = 0;
            }

        }

        return result;
    }

}
