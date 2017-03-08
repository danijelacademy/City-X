package com.example.Controller.Domain;
import com.example.Domain.City;
import com.example.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.apache.coyote.http11.Constants.a;

@Component
public class Repository {

    @Autowired
    private DataSource dataSource;

    //FÖRSTA METOD BÖRJAR HÄR.

    public City getcity(int id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT* FROM locations WHERE ID = ?")) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    throw new SQLException();
                }
                else return rsCity(rs);
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
