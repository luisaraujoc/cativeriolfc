package com.luisaraujoc.cativeriolfc.dao.interfac;



import com.luisaraujoc.cativeriolfc.Entity.User;

import java.util.List;

public interface UserDaoInter {

    User insert(User obj, Long personId);
    User update(Long id, User obj);
    void delete(Long id);
    User findById(Long id);
    List<User> findAll();


}
