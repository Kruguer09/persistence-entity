package Modelos;

import Modelos.Departamentos;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-27T15:57:15", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Empleados.class)
public class Empleados_ { 

    public static volatile SingularAttribute<Empleados, Departamentos> depno;
    public static volatile SingularAttribute<Empleados, String> apellido;
    public static volatile SingularAttribute<Empleados, BigDecimal> salario;
    public static volatile SingularAttribute<Empleados, Departamentos> departamentos;
    public static volatile SingularAttribute<Empleados, Date> fechaalt;
    public static volatile SingularAttribute<Empleados, BigDecimal> comision;
    public static volatile SingularAttribute<Empleados, Integer> empno;
    public static volatile SingularAttribute<Empleados, String> oficio;

}