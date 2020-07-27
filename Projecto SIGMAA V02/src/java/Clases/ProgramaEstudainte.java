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
public class ProgramaEstudainte {
    
    private int codigoPrograma;
    private String nombrePrograma;

    public ProgramaEstudainte() {
    }

    public ProgramaEstudainte(int codigoPrograma, String nombrePrograma) {
        this.codigoPrograma = codigoPrograma;
        this.nombrePrograma = nombrePrograma;
    }

    /**
     * @return the codigoPrograma
     */
    public int getCodigoPrograma() {
        return codigoPrograma;
    }

    /**
     * @param codigoPrograma the codigoPrograma to set
     */
    public void setCodigoPrograma(int codigoPrograma) {
        this.codigoPrograma = codigoPrograma;
    }

    /**
     * @return the nombrePrograma
     */
    public String getNombrePrograma() {
        return nombrePrograma;
    }

    /**
     * @param nombrePrograma the nombrePrograma to set
     */
    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }
    
    
}
