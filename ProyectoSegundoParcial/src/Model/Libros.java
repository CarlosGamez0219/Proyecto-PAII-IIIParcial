
package Model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Dell
 */
public class Libros {
    private int LibrosID;
    private String Titulo;
    private Date FechaPublicacion;
    private int CategoriaId;
    private String Edicion;

    public Libros(int LibrosID, String Titulo, Date FechaPublicacion, int CategoriaId, String Edicion) {
        this.LibrosID = LibrosID;
        this.Titulo = Titulo;
        this.FechaPublicacion = FechaPublicacion;
        this.CategoriaId = CategoriaId;
        this.Edicion = Edicion;
    }
    
    public Libros(){
        
    
    }

    public int getLibrosID() {
        return LibrosID;
    }

    public void setLibrosID(int LibrosID) {
        this.LibrosID = LibrosID;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public Date getFechaPublicacion() {
        return FechaPublicacion;
    }

    public void setFechaPublicacion(Date FechaPublicacion) {
        this.FechaPublicacion = FechaPublicacion;
    }

    public int getCategoriaID() {
        return CategoriaId;
    }

    public void setCategoriaID(int CategoriaId) {
        this.CategoriaId = CategoriaId;
    }

    public String getEdicion() {
        return Edicion;
    }

    public void setEdicion(String Edicion) {
        this.Edicion = Edicion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.LibrosID;
        hash = 37 * hash + Objects.hashCode(this.Titulo);
        hash = 37 * hash + Objects.hashCode(this.FechaPublicacion);
        hash = 37 * hash + this.CategoriaId;
        hash = 37 * hash + Objects.hashCode(this.Edicion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libros other = (Libros) obj;
        if (this.LibrosID != other.LibrosID) {
            return false;
        }
        if (this.CategoriaId != other.CategoriaId) {
            return false;
        }
        if (!Objects.equals(this.Titulo, other.Titulo)) {
            return false;
        }
        if (!Objects.equals(this.Edicion, other.Edicion)) {
            return false;
        }
        return Objects.equals(this.FechaPublicacion, other.FechaPublicacion);
    }
}
