package Modelos;

import Modelos.Empleados;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-27T15:57:15", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Departamentos.class)
public class Departamentos_ { 

    public static volatile SingularAttribute<Departamentos, Integer> depno;
    public static volatile SingularAttribute<Departamentos, String> loc;
    public static volatile ListAttribute<Departamentos, Empleados> empleadosList;
    public static volatile SingularAttribute<Departamentos, Empleados> empleados;
    public static volatile SingularAttribute<Departamentos, String> nombre;

}