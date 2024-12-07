/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1trimestre.pantallas;

/**
 *
 * @author Alfonso
 */
public class Proveedor {
    String nit;
    String direccion;
    String empresa;
    String telefono;
    String ciudad;
    String pais;

    // Constructor
    public Proveedor(String nit, String direccion, String empresa, String telefono, String ciudad, String pais) {
        this.nit = nit;
        this.direccion = direccion;
        this.empresa = empresa;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.pais = pais;
    }
     public Proveedor() {

    }

    // Getters y Setters
    public String getNit() {
        return nit;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getEmpresa() {
        return empresa;
    }
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
     
}
