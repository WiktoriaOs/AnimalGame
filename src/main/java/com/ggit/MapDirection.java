package com.ggit;


public enum MapDirection{
        POLNOC(0,1), POLUDNIE(0,-1), WSCHOD(1,0), ZACHOD(-1,0);
    private final Vector2D unitVector;
        MapDirection(int x, int y){
            unitVector= new Vector2D(x,y);

        }

    public Vector2D getUnitVector() {
        return unitVector;
    }
}

