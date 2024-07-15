package com.luisaraujoc.cativeriolfc.Sevices;

import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.Dao.PersonDao;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    public  PersonDao personDao = DaoFactory.createPersonDao();

    public  Person insert(Person obj) {
        return personDao.insert(obj);
    }

    public  Person findById(Long id) {
        return personDao.findById(id);
    }
}
