package jroldan.acdat.listadetareas.model;

import java.io.Serializable;

public class Tarea implements Serializable {

    private int id;
    private String nombre;
    private String descripcion;
    private String importancia;
    private String finalizacion;
    private String enlace;
    private String imagen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImportancia() {
        return importancia;
    }

    public void setImportancia(String importancia) {
        this.importancia = importancia;
    }

    public String getFinalizacion() {
        return finalizacion;
    }

    public void setFinalizacion(String finalizacion) {
        this.finalizacion = finalizacion;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Tarea(int id, String nombre, String descripcion, String importancia, String finalizacion, String enlace, String imagen) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.importancia = importancia;
        this.finalizacion = finalizacion;
        this.enlace = enlace;
        this.imagen = imagen;
    }

    public Tarea(String nombre, String descripcion, String importancia, String finalizacion, String enlace, String imagen) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.importancia = importancia;
        this.finalizacion = finalizacion;
        this.enlace = enlace;
        this.imagen = imagen;
    }

    public Tarea() {}

    @Override
    public String toString() {
        return this.nombre + "\n" + this.finalizacion + "\nImportancia: " + this.importancia;
    }
}