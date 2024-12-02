/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author PROGRAMACION
 */
public class Usuario {
    private String nombre;
    private String apellidos;
    private String dni;
    private String email;
    private String nacionalidad;
    private String preferencias;
    private String noticias;

    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, String dni, String email, String nacionalidad, String preferencias, String noticias) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
        this.nacionalidad = nacionalidad;
        this.preferencias = preferencias;
        this.noticias = noticias;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }     

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    public String getNoticias() {
        return noticias;
    }

    public void setNoticias(String noticias) {
        this.noticias = noticias;
    }        
}
