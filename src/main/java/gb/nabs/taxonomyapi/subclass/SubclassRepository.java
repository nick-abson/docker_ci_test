package gb.nabs.taxonomyapi.subclass;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

// standard CRUD operations provide by JPA implementation of  CrudRepository()
// the common methods have type requirements, so we need to specify generic types (Class and type of PK)
public interface SubclassRepository extends CrudRepository <Subclass,String>{

    // if we follow the standard JPA naming conventions e.g findBy<Class> or FindBy<Property name>
    // JPA will create the implementation automatically
    // if you want to use a propertyName as the WHERE clause use e.g DivisionId
    public List<Subclass> findSubclassesByDivisionId(String divisionId);

}
