package com.luisaraujoc.cativeriolfc;

import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Entity.Team;
import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.Dao.PersonDao;
import com.luisaraujoc.cativeriolfc.Util.GenerateTeam;

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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        Date date = sdf.parse("2024-07-12");
        GameDay gd = new GameDay(1, date, pList);

        gd.findCurrentPlayers();

        for (Person person : gd.getCurrentPlayers()) {
            System.out.println(person);
        }

        GenerateTeam.handleCreation(gd);

        for(Team t : gd.getTeams()) {
            System.out.println(t.getName());

            for(Person p : t.getPlayers()) {
                System.out.println(p.getName());
            }

            System.out.println("==============================================");
        }




    }
}
