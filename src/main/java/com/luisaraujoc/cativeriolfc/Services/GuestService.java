package com.luisaraujoc.cativeriolfc.Services;

import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.Dao.GuestDao;
import com.luisaraujoc.cativeriolfc.Entity.Guest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GuestService {

    private GuestDao guestDao = DaoFactory.createGuestDao();

    public Guest insert(Guest guest) {
        return guestDao.insert(guest);
    }

    public List<Guest> findAll() {
        return guestDao.findAll();
    }

    public Guest findById(Long id) {
        return guestDao.findById(id);
    }

    public void delete(Long id) {
        guestDao.delete(id);
    }

    public Guest update(Long id, Guest guest) {
        return guestDao.update(id, guest);
    }
}
