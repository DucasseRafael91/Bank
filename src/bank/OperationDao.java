package bank;

import java.sql.*;
import java.util.ArrayList;

public class OperationDao implements Dao<Operation> {

    private static final String URL = "jdbc:mariadb://localhost:3322/bank";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "6jBUDOSBl4CSx28RRtc1";

    @Override
    public void create(Operation operation) {

        String sql = "INSERT INTO b_operation (c_num_compte, t_id, o_montant, o_date) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, operation.getCompte());
            ps.setInt(2, operation.getType_operation());
            ps.setDouble(3, operation.getMontant());
            ps.setTimestamp(4, new Timestamp(operation.getDate().getTime()));

            ps.executeUpdate();

            // Récupération de l'id auto-généré
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                operation.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Operation operation) {
        // à implémenter
    }

    @Override
    public void delete(String num_compte) {
        // à implémenter
    }

    @Override
    public Operation findById(String id) {
        Operation operation = null;
        String sql = "SELECT * FROM b_operation WHERE o_id = ?";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(id));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                operation = new Operation(
                    rs.getString("c_num_compte"),
                    rs.getInt("t_id"),
                    rs.getDouble("o_montant"),
                    rs.getTimestamp("o_date")
                );
                operation.setId(rs.getInt("o_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return operation;
    }


    @Override
    public ArrayList<Operation> findAll() {

        ArrayList<Operation> operations = new ArrayList<>();
        String sql = "SELECT * FROM b_operation";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                Operation operation = new Operation(
                    rs.getString("c_num_compte"),
                    rs.getInt("t_id"),
                    rs.getDouble("o_montant"),
                    rs.getTimestamp("o_date")
                );
                operation.setId(rs.getInt("o_id"));
                operations.add(operation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return operations;
    }

}
