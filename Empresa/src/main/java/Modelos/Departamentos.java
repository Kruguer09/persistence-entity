/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "departamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamentos.findAll", query = "SELECT d FROM Departamentos d"),
    @NamedQuery(name = "Departamentos.findByDepno", query = "SELECT d FROM Departamentos d WHERE d.depno = :depno"),
    @NamedQuery(name = "Departamentos.findByNombre", query = "SELECT d FROM Departamentos d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Departamentos.findByLoc", query = "SELECT d FROM Departamentos d WHERE d.loc = :loc")})
public class Departamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "depno")
    private Integer depno;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "loc")
    private String loc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depno")
    private List<Empleados> empleadosList;

    public Departamentos() {
    }

    public Departamentos(Integer depno) {
        this.depno = depno;
    }

    public Departamentos(Integer depno, String nombre, String loc) {
        this.depno = depno;
        this.nombre = nombre;
        this.loc = loc;
    }

    public Integer getDepno() {
        return depno;
    }

    public void setDepno(Integer depno) {
        this.depno = depno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @XmlTransient
    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depno != null ? depno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamentos)) {
            return false;
        }
        Departamentos other = (Departamentos) object;
        if ((this.depno == null && other.depno != null) || (this.depno != null && !this.depno.equals(other.depno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Departamentos[ depno=" + depno + " ]";
    }
    
}
