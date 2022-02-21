package model;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import metiers.Praticien;
import metiers.Visiteur;

public abstract class DAO<T> {
    static Connection connect = null;
    public DAO(Connection conn) {
        connect =conn;
    }
    public ArrayList<Visiteur> findV(String name) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    public ArrayList<Praticien> findP(String name) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}



