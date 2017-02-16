/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sphere;

import sphere.Exception.InvalidRadiusException;

/**
 *
 * @author Jayuk
 */
public class SphereUnit {

    private int radius;

    public SphereUnit() {
        radius = 1;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) throws InvalidRadiusException {
        if (radius < 0) {
            throw new InvalidRadiusException("Radius tidak valid");
        }
        this.radius = radius;
    }

    public int getVolume() {
        return(int) (1.3 * 3.14 * ( radius * radius * radius));        
    }

    public int getLuasPermukaan() {
        return(int)( 4 * 3.14 * (radius * radius));
    }

    public int getDiameter() {
        return 2 * radius;
    }
    public static void main(String[] args) {
        SphereUnit sphere = new SphereUnit();
        System.out.println(sphere.getVolume());
        System.out.println(sphere.getLuasPermukaan());
    }
    
}
