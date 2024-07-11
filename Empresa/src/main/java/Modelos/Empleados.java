/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "empleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e"),
    @NamedQuery(name = "Empleados.findByEmpno", query = "SELECT e FROM Empleados e WHERE e.empno = :empno"),
    @NamedQuery(name = "Empleados.findByApellido", query = "SELECT e FROM Empleados e WHERE e.apellido = :apellido"),
    @NamedQuery(name = "Empleados.findByOficio", query = "SELECT e FROM Empleados e WHERE e.oficio = :oficio"),
    @NamedQuery(name = "Empleados.findByFechaalt", query = "SELECT e FROM Empleados e WHERE e.fechaalt = :fechaalt"),
    @NamedQuery(name = "Empleados.findBySalario", query = "SELECT e FROM Empleados e WHERE e.salario = :salario"),
    @NamedQuery(name = "Empleados.findByComision", query = "SELECT e FROM Empleados e WHERE e.comision = :comision")})
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "empno")
    private Integer empno;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "oficio")
    private String oficio;
    @Basic(optional = false)
    @Column(name = "fechaalt")
    @Temporal(TemporalType.DATE)
    private Date fechaalt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "salario")
    private BigDecimal salario;
    @Basic(optional = false)
    @Column(name = "comision")
    private BigDecimal comision;
    @JoinColumn(name = "depno", referencedColumnName = "depno")
    @ManyToOne(optional = false)
    private Departamentos depno;

    public Empleados() {
    }

    public Empleados(Integer empno) {
        this.empno = empno;
    }

    public Empleados(Integer empno, String apellido, String oficio, Date fechaalt, BigDecimal salario, BigDecimal comision, Departamentos departamento) {
        this.empno = empno;
        this.apellido = apellido;
        this.oficio = oficio;
        this.fechaalt = fechaalt;
        this.salario = salario;
        this.comision = comision;
        this.depno=departamento;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public Date getFechaalt() {
        return fechaalt;
    }

    public void setFechaalt(Date fechaalt) {
        this.fechaalt = fechaalt;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    public Departamentos getDepno() {
        return depno;
    }

    public void setDepno(Departamentos depno) {
        this.depno = depno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empno != null ? empno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.empno == null && other.empno != null) || (this.empno != null && !this.empno.equals(other.empno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Empleados[ empno=" + empno + " ]";
    }
    
}
