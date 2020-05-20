
package Clases;

/**
 *
 * @author Alvaro
 */
public class FacultadCampus {

    private int Id_campus;
    private String nombre_campus;
    private int Id_facultad;
    private String nombre_facultad;
    
    public FacultadCampus() {
    }

    public FacultadCampus(int Id_campus, String nombre_campus, int Id_facultad, String nombre_facultad) {
        this.Id_campus = Id_campus;
        this.nombre_campus = nombre_campus;
        this.Id_facultad = Id_facultad;
        this.nombre_facultad = nombre_facultad;
    }
    
    /**
     * @return the Id_campus
     */
    public int getId_campus() {
        return Id_campus;
    }

    /**
     * @param Id_campus the Id_campus to set
     */
    public void setId_campus(int Id_campus) {
        this.Id_campus = Id_campus;
    }

    /**
     * @return the nombre_campus
     */
    public String getNombre_campus() {
        return nombre_campus;
    }

    /**
     * @param nombre_campus the nombre_campus to set
     */
    public void setNombre_campus(String nombre_campus) {
        this.nombre_campus = nombre_campus;
    }

    /**
     * @return the Id_facultad
     */
    public int getId_facultad() {
        return Id_facultad;
    }

    /**
     * @param Id_facultad the Id_facultad to set
     */
    public void setId_facultad(int Id_facultad) {
        this.Id_facultad = Id_facultad;
    }

    /**
     * @return the nombre_facultad
     */
    public String getNombre_facultad() {
        return nombre_facultad;
    }

    /**
     * @param nombre_facultad the nombre_facultad to set
     */
    public void setNombre_facultad(String nombre_facultad) {
        this.nombre_facultad = nombre_facultad;
    }
    
    
}
