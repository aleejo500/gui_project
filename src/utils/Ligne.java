package utils;

/* Classe qui modélise une ligne de transport */
public class Ligne {

    /** L'identifiant de la ligne */
    private int id;
    /** Le nom de la ligne */
    private String nom;
    /** Le type de ligne : metro, bus, rer, tramway ... */
    private String type;

    /** Constructeur */
    public Ligne(int id, String nom, String type) {
        this.id = id;
        this.nom = nom;
        this.type = type;
    }

    /** Retourne le nom de la ligne */
    public String getNom() {
        return nom;
    }
}
