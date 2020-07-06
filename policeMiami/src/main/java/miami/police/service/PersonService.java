package miami.police.service;


import miami.police.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;



public interface PersonService {
    public void savePerson(Person person);
    public List<Person> findAll();
    public void deletePersonById(long id);

}
