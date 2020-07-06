package miami.police.dao;


import miami.police.model.Person;

import java.util.List;

public interface PersonDao {
    public void savePerson(Person person);
    public List<Person> findAll();
    public void deletePersonById(long id);
}
