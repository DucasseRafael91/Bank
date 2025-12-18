package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CompteDao implements Dao<Compte> {

    private static final String URL = "jdbc:mariadb://localhost:3322/bank";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "6jBUDOSBl4CSx28RRtc1";

    @Override
    public void create(Compte compte) {

    }

    @Override
    public void update(Compte compte) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Compte findById(String num_compte) {
        Compte compte = null;
        String sql = "SELECT * FROM b_compte WHERE c_nm_compte = ?";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, num_compte);
            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    String titulaire = resultSet.getString("c_titulaire");
                    double solde = resultSet.getDouble("c_solde");
                    compte = new Compte(num_compte,titulaire, solde);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return compte;
    }

    @Override
    public ArrayList<Compte> findAll() {
		return null;

    }

}
