/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Alvaro Rubiano
 */
public class Estudiante {
    
    private int identificacion;
    private String nombres;
    private String correo;
    private String telefono;
    private String tipo;
    private int id_campus;
    private int id_facultad;
    private int id_programa;
    private String semestre;
    private String modalidad;
    

    public Estudiante() {
    }

    public Estudiante(int identificacion, String nombres, String correo, String telefono, String tipo, int id_campus, int id_facultad, int id_programa, String semestre, String modalidad) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.correo = correo;
        this.telefono = telefono;
        this.tipo = tipo;
        this.id_campus = id_campus;
        this.id_facultad = id_facultad;
        this.id_programa = id_programa;
        this.semestre = semestre;
        this.modalidad = modalidad;
        
    }

    /**
     * @return the identificacion
     */
    public int getIdentificacion() {
        return identificacion;
    }

    /**
     * @param identificacion the identificacion to set
     */
    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the id_campus
     */
    public int getId_campus() {
        return id_campus;
    }

    /**
     * @param id_campus the id_campus to set
     */
    public void setId_campus(int id_campus) {
        this.id_campus = id_campus;
    }

    /**
     * @return the id_facultad
     */
    public int getId_facultad() {
        return id_facultad;
    }

    /**
     * @param id_facultad the id_facultad to set
     */
    public void setId_facultad(int id_facultad) {
        this.id_facultad = id_facultad;
    }

    /**
     * @return the id_programa
     */
    public int getId_programa() {
        return id_programa;
    }

    /**
     * @param id_programa the id_programa to set
     */
    public void setId_programa(int id_programa) {
        this.id_programa = id_programa;
    }

    /**
     * @return the semestre
     */
    public String getSemestre() {
        return semestre;
    }

    /**
     * @param semestre the semestre to set
     */
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    /**
     * @return the modalidad
     */
    public String getModalidad() {
        return modalidad;
    }

    /**
     * @param modalidad the modalidad to set
     */
    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    
    
}
