package com.cristianmartin.springaed.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "juego", schema = "juegos", catalog = "")
public class JuegoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "titulo", nullable = true, length = 217)
    private String titulo;
    @Basic
    @Column(name = "desarrolladora", nullable = true, length = 82)
    private String desarrolladora;
    @Basic
    @Column(name = "imagenurl", nullable = true, length = 251)
    private String imagenurl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(String desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    public String getImagenurl() {
        return imagenurl;
    }

    public void setImagenurl(String imagenurl) {
        this.imagenurl = imagenurl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JuegoEntity that = (JuegoEntity) o;

        if (id != that.id) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (desarrolladora != null ? !desarrolladora.equals(that.desarrolladora) : that.desarrolladora != null)
            return false;
        if (imagenurl != null ? !imagenurl.equals(that.imagenurl) : that.imagenurl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (desarrolladora != null ? desarrolladora.hashCode() : 0);
        result = 31 * result + (imagenurl != null ? imagenurl.hashCode() : 0);
        return result;
    }
}
