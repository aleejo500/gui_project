package gui;

import java.awt.image.BufferedImage;

/** Image du métro parisien */
public class PlanMetro {
    /** La longueur de l'image */
    private int width;
    /** La hauteur de l'image */
    private int height;

    /** Constructeur */
    public PlanMetro(int width, int height) {
	super(width, height, BufferedImage.TYPE_INT_RGB);
	this.width = width;
	this.height = height;
    }

    /**  */
}
