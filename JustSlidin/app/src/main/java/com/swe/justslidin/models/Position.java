package com.swe.justslidin.models;

public class Position {

    private float x,y;

    public Position(float v) {
        this.x = v;
        this.y = v;
    }

    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void add(Position p) {
        this.x += p.x;
        this.y += p.y;
    }

    public void left(float by) {
        this.x -= by;
    }

    public void right(float by) {
        this.x += by;
    }

    @Override
    public boolean equals(Object obj) {
        Position p = (Position) obj;
        if (p != null) return x == p.x && y == p.y;
        return false;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }
}
