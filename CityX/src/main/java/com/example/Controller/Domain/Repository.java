package com.example.Controller.Domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class Repository {

    @Autowired
    private DataSource dataSource;

    //FÖRSTA METOD BÖRJAR HÄR.

    public List<City> getcitys() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT* FROM locations")) { //Hämtar alla rader i DB
            try (ResultSet rs = ps.executeQuery()) {
                List<City> citys = new ArrayList<>(); //Skapar en array
                while(rs.next()){
                    citys.add(rsCity(rs)); //Lagrar resultaten i arrayen
                }
                return citys;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    private City rsCity(ResultSet rs) throws SQLException {
        return new City(
                rs.getInt(1), //ID
                rs.getString(2),//Stad
                rs.getDouble(3),//longitud
                rs.getDouble(4),//latitud
                rs.getString(5),//hint 1
                rs.getString(6),//hint 2
                rs.getString(7)//hint 3
        );

    }
}
