package com.luisaraujoc.cativeriolfc;

import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Entity.Team;
import com.luisaraujoc.cativeriolfc.Enum.Role;
import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.Dao.PersonDao;
import com.luisaraujoc.cativeriolfc.Util.generateTeam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class daoTester {
    public static void main(String[] args) throws ParseException {
        List<Person> pList = new ArrayList<Person>();
        PersonDao pdao = DaoFactory.createPersonDao();
        List<Person> persons = pdao.findAll();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        for (int i = 0; i < 25; i++) {
            pList.add(persons.get(i));
        }
        Date date = sdf.parse("11/07/2024");
        GameDay gd = new GameDay(4, date, pList);

        generateTeam.handleCreation(gd);





    }
}
