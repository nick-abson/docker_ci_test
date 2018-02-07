package gb.nabs.taxonomyapi.division;


import org.springframework.data.repository.CrudRepository;

// standard CRUD operations provide by JPA implementation of  CrudRepository()
// the common methods have type requirements, so we need to specify generic types (Class and type of PK)
public interface DivisionRepository extends CrudRepository <Division,String>{

}
