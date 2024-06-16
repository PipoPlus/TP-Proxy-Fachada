package org.example;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class PersonaDao {
    private int idActual;

    private Connection obtenerConexion() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mi_base_de_datos", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public Persona personaPorId(int id) {
        String sql = "select p.nombre "
                + "from personas p "
                + "where p.id = ?";
        try (Connection conn = obtenerConexion();
             PreparedStatement statement =
                     conn.prepareStatement(sql);) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            String nombrePersona = null;
            while (result.next()) {
                nombrePersona = result.getString(1);
            }
            this.idActual = id;
            return new Persona(id, nombrePersona, new Proxy(this));
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<Telefono> telefonoPorId() {
        Set<Telefono> telefonos = new HashSet<>();
        String sql = "SELECT t.numero FROM telefonos t WHERE t.idPersona = ?";
        try (Connection conn = obtenerConexion();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, idActual);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String numero = result.getString(1);
                telefonos.add(new Telefono(numero));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return telefonos;
    }
}

