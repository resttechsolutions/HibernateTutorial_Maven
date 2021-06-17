/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resttechsoutions.hibernatetutorial.domain;

import java.util.Objects;
import javax.persistence.Entity;

/**
 *
 * @author Rafael Estrella
 */
@Entity
public class Categorias {
    private int categoriaId;
    private String nombreCat;

    public Categorias() {
        super();
    }

    public Categorias(int categoriaId) {
        this();
        this.categoriaId = categoriaId;
    }

    public Categorias(int categoriaId, String nombreCat) {
        this(categoriaId);
        this.nombreCat = nombreCat;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.categoriaId;
        hash = 79 * hash + Objects.hashCode(this.nombreCat);
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
        final Categorias other = (Categorias) obj;
        if (this.categoriaId != other.categoriaId) {
            return false;
        }
        if (!Objects.equals(this.nombreCat, other.nombreCat)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Categorias{categoriaId=").append(categoriaId);
        sb.append(", nombreCat=").append(nombreCat);
        sb.append('}');
        return sb.toString();
    }
    
    
}
