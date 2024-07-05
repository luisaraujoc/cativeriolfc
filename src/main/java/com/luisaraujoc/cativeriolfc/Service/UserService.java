package com.luisaraujoc.cativeriolfc.Service;

import com.luisaraujoc.cativeriolfc.DAO.PersonDAO;
import com.luisaraujoc.cativeriolfc.DAO.UserDAO;
import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Entity.User;
import com.luisaraujoc.cativeriolfc.Util.Cryptography;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserDAO userDAO;
    private final PersonDAO personDAO;

    public UserService(UserDAO userDAO, PersonDAO personDAO) {
        this.userDAO = userDAO;
        this.personDAO = personDAO;
    }

    @Transactional
    public void createUserAndPerson(User user, Person person) {
        personDAO.save(person);
        user.setPerson(person); // Assuming person ID is auto-generated and set by database
        
        // Criptografa a senha antes de armazenar no banco de dados
        String encryptedPassword = Cryptography.encrypt(user.getPassword());
        user.setPassword(encryptedPassword);
        
        userDAO.save(user);
    }

    public User findUserById(Integer id) {
        return userDAO.findById(id);
    }

    public Person findPersonById(Integer id) {
        return personDAO.findById(id);
    }
}
