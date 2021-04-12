package hu.nive.ujratervezes.zarovizsga.peoplesql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {

    private final DataSource dataSource;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT ip_address FROM people WHERE first_name = ? AND last_name = ?")) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);

            return getIpByName(statement);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot read file or error by insert or connect", sqle);
        }

    }

    private String getIpByName(PreparedStatement statement) throws SQLException {
        String ipAddress = null;
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                return resultSet.getString("ip_address");
            }
        } catch (SQLException sqlexeption) {
            throw new IllegalStateException("Cannot execute");
        }
        throw new IllegalArgumentException("Cannot find people with this name.");
    }

}


