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
        PersonDao pdao = DaoFactory.createPersonDao();
        List<Person> persons = pdao.findAll();


        GameDay gd = DaoFactory.createGameDayDao().findById(1L);




        GenerateTeam.handleCreation(gd);

        for(Team t : gd.getTeams()) {
            System.out.println(t.getName());

            for (Person p : t.getPlayers()) {
                System.out.println(p.getName());
            }

            System.out.println("==============================================");
        }



    }
}
