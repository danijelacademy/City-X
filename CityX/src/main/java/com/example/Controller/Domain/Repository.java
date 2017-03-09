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
             PreparedStatement ps = conn.prepareStatement("SELECT* FROM locations")) {
            try (ResultSet rs = ps.executeQuery()) {
                List<City> citys = new ArrayList<>();
                while(rs.next()){
                    citys.add(rsCity(rs));
                }
                return citys;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    private City rsCity(ResultSet rs) throws SQLException {
        return new City(
                rs.getInt(1),
                rs.getString(2),
                rs.getDouble(3),
                rs.getDouble(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7)
        );

    }
}
