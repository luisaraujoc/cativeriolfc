package com.luisaraujoc.cativeriolfc.Services;

import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.Dao.GuestDao;
import com.luisaraujoc.cativeriolfc.Entity.Guest;

import java.util.List;

public class GuestService {

    private static GuestDao guestDao = DaoFactory.createGuestDao();

    public static Guest insert(Guest guest) {
        return guestDao.insert(guest);
    }

    public static List<Guest> findAll() {
        return guestDao.findAll();
    }

    public static Guest findById(Long id) {
        return guestDao.findById(id);
    }

    public static void delete(Long id) {
        guestDao.delete(id);
    }

    public static Guest update(Long id, Guest guest) {
        return guestDao.update(id, guest);
    }
}
