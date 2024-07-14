package com.luisaraujoc.cativeriolfc.Interface;

import com.luisaraujoc.cativeriolfc.Entity.Guest;

import java.util.List;

public interface GuestDaoInter {
    public Guest insert(Guest obj);
    public Guest update(Long id, Guest obj);
    public void delete(Long id);
    public Guest findById(Long id);
    public List<Guest> findAll();
}
