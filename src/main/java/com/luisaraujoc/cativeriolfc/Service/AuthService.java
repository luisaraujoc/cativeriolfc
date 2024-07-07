package com.luisaraujoc.cativeriolfc.Service;

import com.luisaraujoc.cativeriolfc.DAO.UserDAO;
import com.luisaraujoc.cativeriolfc.Entity.User;
import com.luisaraujoc.cativeriolfc.Util.Cryptography;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserDAO userDAO;

    public AuthService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean login(String email, String password) {
        User user = userDAO.findByEmail(email);
        if (user != null) {
            return Cryptography.checkPassword(password, user.getPassword());
        }
        return false;
    }
}