package bank;

import java.sql.*;
import java.util.ArrayList;

public class TypeOperationDao implements Dao<TypeOperation> {

    private static final String URL = "jdbc:mariadb://localhost:3322/bank";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "6jBUDOSBl4CSx28RRtc1";

    @Override
    public void create(TypeOperation typeOperation) {
        // à implémenter
    }

    @Override
    public void update(TypeOperation typeOperation) {
        // à implémenter
    }

    @Override
    public void delete(String nomType) {
        // à implémenter
    }

    @Override
    public TypeOperation findById(String nomType) {
        TypeOperation typeOperation = null;
        String sql = "SELECT * FROM b_type_operation WHERE t_nom = ?";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, nomType);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                typeOperation = new TypeOperation(nomType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return typeOperation;
    }

    @Override
    public ArrayList<TypeOperation> findAll() {
        ArrayList<TypeOperation> typeOperations = new ArrayList<>();
        String sql = "SELECT * FROM b_type_operation";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String nomType = resultSet.getString("t_nom");
                typeOperations.add(new TypeOperation(nomType));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return typeOperations;
    }
}
