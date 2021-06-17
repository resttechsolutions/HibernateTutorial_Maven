/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resttechsoutions.hibernatetutorial.domain;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Rafael Estrella
 */
@Entity
@Table(name = "ORDENES")
public class Ordenes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDENID")
    private int ordenId;
    
    @Column(name = "EMPLEADOID")
    private int empleadoId;
    
    @Column(name = "CLIENTEID")
    private int clienteId;
    
    
    @Column(name = "FECHAORDEN")
    private Date fechaOrden;
    
    @Column(name = "DESCUENTO")
    private int descuento;
    
    

    public Ordenes() {
        super();
    }

    public Ordenes(int ordenId) {
        this();
        this.ordenId = ordenId;
    }

    public Ordenes(int ordenId, int empleadoId) {
        this(ordenId);
        this.empleadoId = empleadoId;
    }

    public Ordenes(int ordenId, int empleadoId, int clienteId) {
        this(ordenId, empleadoId);
        this.clienteId = clienteId;
    }

    public Ordenes(int ordenId, int empleadoId, int clienteId, Date fechaOrden) {
        this(ordenId,empleadoId,clienteId);
        this.fechaOrden = fechaOrden;
    }

    public Ordenes(int ordenId, int empleadoId, int clienteId, Date fechaOrden, int descuento) {
        this(ordenId,empleadoId,clienteId,fechaOrden);
        this.descuento = descuento;
    }

    public int getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(int ordenId) {
        this.ordenId = ordenId;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.ordenId;
        hash = 17 * hash + this.empleadoId;
        hash = 17 * hash + this.clienteId;
        hash = 17 * hash + Objects.hashCode(this.fechaOrden);
        hash = 17 * hash + this.descuento;
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
        final Ordenes other = (Ordenes) obj;
        if (this.ordenId != other.ordenId) {
            return false;
        }
        if (this.empleadoId != other.empleadoId) {
            return false;
        }
        if (this.clienteId != other.clienteId) {
            return false;
        }
        if (this.descuento != other.descuento) {
            return false;
        }
        if (!Objects.equals(this.fechaOrden, other.fechaOrden)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ordenes{ordenId=").append(ordenId);
        sb.append(", empleadoId=").append(empleadoId);
        sb.append(", clienteId=").append(clienteId);
        sb.append(", fechaOrden=").append(fechaOrden);
        sb.append(", descuento=").append(descuento);
        sb.append('}');
        return sb.toString();
    }
}
