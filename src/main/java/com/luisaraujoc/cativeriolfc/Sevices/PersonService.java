package com.luisaraujoc.cativeriolfc.Sevices;

import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.Dao.PersonDao;

public class PersonService {

    public static PersonDao personDao = DaoFactory.createPersonDao();

    public static Person insert(Person obj) {
        return personDao.insert(obj);
    }

    public static Person findById(Long id) {
        return personDao.findById(id);
    }
}
