package miami.police.service.impl;

import miami.police.dao.PersonDao;
import miami.police.model.Person;
import miami.police.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PersonServiceImpl implements PersonService {

    private PersonDao dao;

    @Autowired
    public void setDao(PersonDao dao) {
        this.dao = dao;
    }

    public void savePerson(Person person) {
        dao.savePerson(person);
    }


    public List<Person> findAll() {
        return dao.findAll();
    }


    public void deletePersonById(long personId) {
        dao.deletePersonById(personId);
    }
}
