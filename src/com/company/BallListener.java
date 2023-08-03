package com.company;

public interface BallListener {
    /**
     *
     * @param balls
     * @return 1 -> Golden ball; -1 -> bomb; 0 -> not intersected
     */
    public int isIntersected(Ball balls);
}
