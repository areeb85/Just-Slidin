package com.swe.justslidin.models;

import com.swe.justslidin.MainController;

/**
* Character class that handles everything related to the player character.
*  This class deals with the player creation object, positioning with hitboxes, and movement.
* @author: Danny and Maaz
*
 */

public class Character extends Elements {
    private float rad;
    private Position pos;
    private HitBox hitBox;
//    private MainController mc;

    /**
    * Constructor that creates a new Character with a certain x- and y-coordinate, radius, and hitbox.
    * @param x x-coordinate for player position
    * @param y y-coordinate for player position
    * @param rad radius holds the radius value.
     */
    public Character(float x, float y, float rad) {
        super();
        this.pos = new Position(x,y);
        this.hitBox =
                new HitBox(x - rad, x + rad, y + rad, y - rad);
        this.rad = rad;
    }

    /**
    * Moves the character to the left by 10 units and updates hitbox to reflect the new position.
    *
     */
    public void moveLeft() {
        this.pos.left(10f);
        this.hitBox.updateLeft(-10f);
        this.hitBox.updateRight(-10f);
    }

    /**
    * Moves the character to the right by 10 units and updates character's hitbox w/ new coordinates.
    *
     */
    public void moveRight() {
        this.pos.right(10f);
        this.hitBox.updateLeft(10f);
        this.hitBox.updateRight(10f);
    }

    /**
    * Returns the Position of the Character. Composed of x- and y-coordinate.
    * @return: position
     */
    public Position getPosition () {return this.pos;}


    /**
    * Returns HitBox of the Character. Composed of 4-coordinates to get height and width.
    * @return: hitbox values of player character.
     */
    public HitBox getHitBox() {
        return this.hitBox;
    }

    /**
    * Returns radius of the Character object. Composed of a single value.
    * @return: radius of Character object.
     */
    public float getRadius() {
        return this.rad;
    }

    /**
    * returns a String variable with all the relevant information of the Character
    * @return: String with Character, radius, position, and hitbox coordinates
     */
    @Override
    public String toString() {
        float li[] = hitBox.getBox();
        return "Character{" +
                "rad=" + rad +
                ", pos=" + pos +
                ", hitBox=" + li[0] + " " +  li[1] + " " + li[2] + " " +  li[3] +
                '}';
    }

}
