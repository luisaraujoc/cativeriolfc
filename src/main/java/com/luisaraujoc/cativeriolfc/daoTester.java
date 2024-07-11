package com.luisaraujoc.cativeriolfc;

import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Enum.Role;
import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.Dao.PersonDao;

public class daoTester {
    public static void main(String[] args) {
        PersonDao pDao = DaoFactory.createPersonDao();
        pDao.delete(10L);
    }
}
