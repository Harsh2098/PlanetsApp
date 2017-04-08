package com.hmproductions.planetsdrawer;

/**
 * Created by Harsh Mahajan on 8/4/2017.
 */

public class Planet
{
    private String mName;
    private int mDistance;

    Planet(String name, int distance)
    {
        mName = name;
        mDistance = distance;
    }

    String getName() {
        return mName;
    }


    int getDistance() {
        return mDistance;
    }
}
