package jroldan.acdat.listadetareas;

public class Tarea {

    private String nombre;
    private String descripcion;
    private String importancia;
    private String fechaFinalizacion;
    private String enlace;
    private String imagen;

    public Tarea(String nombre, String descripcion, String importancia, String fechaFinalizacion, String enlace, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.importancia = importancia;
        this.fechaFinalizacion = fechaFinalizacion;
        this.enlace = enlace;
        this.imagen = imagen;
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

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
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

    @Override
    public String toString() {
        return this.nombre + "\n" + this.fechaFinalizacion + "\nImportancia: " + this.importancia;
    }
}
