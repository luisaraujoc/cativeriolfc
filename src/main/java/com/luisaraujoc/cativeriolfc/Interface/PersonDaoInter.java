package com.luisaraujoc.cativeriolfc.Interface;

import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Person;

import java.util.List;

public interface PersonDaoInter {
    public Person insert(Person obj);
    public Person update(Long id, Person obj);
    public void delete(Long id);
    public Person findById(Long id);
    public List<Person> findAll();
}
