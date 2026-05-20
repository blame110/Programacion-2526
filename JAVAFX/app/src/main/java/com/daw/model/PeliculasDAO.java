package com.daw.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.daw.utils.Db;

public class PeliculasDAO implements AutoCloseable {

    // Whitelist de columnas permitidas para ORDER BY y UPDATE.
    // Esto evita SQL Injection en la cláusula "order by" al rechazar
    // cualquier nombre de columna que no esté en esta lista
    private static final Set<String> COLUMNAS_VALIDAS = new HashSet<>(Arrays.asList(
            "id", "titulo", "clasificacion", "duracion", "sinopsis"));

    private Connection con;

    // Al crear el DAO obtenemos una conexión a la BD
    public PeliculasDAO() {
        this.con = Db.conectar();
    }

    // Devuelve la lista completa de películas como objetos PeliculaCombo
    // Solo recupera id y titulo (lo justo para rellenar ComboBoxes),
    // no toda la fila, para ser más eficiente
    public ArrayList<PeliculaCombo> getListaPeliculas() {
        ArrayList<PeliculaCombo> listaPeliculas = new ArrayList<>();
        String query = "select id, titulo from pelicula";

        try (Statement stmt = this.con.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                PeliculaCombo peliCmb = new PeliculaCombo();
                peliCmb.setId(rs.getInt("id"));
                peliCmb.setTitulo(rs.getString("titulo"));
                listaPeliculas.add(peliCmb);
            }

        } catch (SQLException e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        return listaPeliculas;
    }

    // Filtra películas por clasificación usando PreparedStatement
    // para evitar SQL Injection. El ResultSet queda abierto para que
    // el llamador lo procese y lo cierre
    public ResultSet getPeliculasClasificacion(int clasificacion) {
        String query = "select * from pelicula where clasificacion = ?";

        try {
            PreparedStatement stmt = this.con.prepareStatement(query);
            stmt.setInt(1, clasificacion);
            return stmt.executeQuery();
        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
            return null;
        }
    }

    // Paginación con ordenación dinámica.
    // El offset se calcula como (pagina - 1) * numElementos.
    // El nombre de columna para ORDER BY se valida contra COLUMNAS_VALIDAS
    // para evitar SQL Injection. Los parámetros limit/offset se pasan
    // como valores parametrizados (?)
    public ResultSet getPeliculas(int pagina, int numElementos, String orden, int sentidoOrden) {
        int offset = (pagina - 1) * numElementos;
        String query = "select * from pelicula";

        if (orden != null && COLUMNAS_VALIDAS.contains(orden)) {
            query += " order by " + orden;
            if (sentidoOrden == Db.ORDEN_DESC) {
                query += " desc";
            }
        }

        query += " limit ? offset ?";

        try {
            PreparedStatement stmt = this.con.prepareStatement(query);
            stmt.setInt(1, numElementos);
            stmt.setInt(2, offset);
            return stmt.executeQuery();
        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
            return null;
        }
    }

    // Actualiza dinámicamente los campos que se pasan en el HashMap.
    // Construye la query "UPDATE pelicula SET col1=?, col2=? WHERE id=?"
    // de forma dinámica. Solo acepta nombres de columna de COLUMNAS_VALIDAS.
    // Las columnas "titulo" y "sinopsis" se tratan como String;
    // el resto como int
    public int modificarPelicula(int id, HashMap<String, String> campos) {
        int columnasModificadas = -1;

        try {
            StringBuilder query = new StringBuilder("update pelicula set ");
            boolean primerCampo = true;

            for (Map.Entry<String, String> campo : campos.entrySet()) {
                if (!COLUMNAS_VALIDAS.contains(campo.getKey())) {
                    continue;
                }
                if (primerCampo) {
                    primerCampo = false;
                } else {
                    query.append(",");
                }
                query.append(campo.getKey()).append("=?");
            }

            if (primerCampo) {
                return -1;
            }

            query.append(" where id = ?");

            try (PreparedStatement stmt = con.prepareStatement(query.toString())) {
                int posicion = 1;
                for (Map.Entry<String, String> campo : campos.entrySet()) {
                    if (!COLUMNAS_VALIDAS.contains(campo.getKey())) {
                        continue;
                    }
                    if (campo.getKey().equals("titulo") || campo.getKey().equals("sinopsis")) {
                        stmt.setString(posicion, campo.getValue());
                    } else {
                        stmt.setInt(posicion, Integer.parseInt(campo.getValue()));
                    }
                    posicion++;
                }
                stmt.setInt(posicion, id);
                columnasModificadas = stmt.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        return columnasModificadas;
    }

    // Inserta una nueva película con los datos pasados.
    // Usa PreparedStatement con parámetros para evitar SQL Injection
    public int crearPelicula(String titulo, int clasificacion, int duracion, String sinopsis) {
        int columnasModificadas = -1;
        String query = "insert into pelicula (titulo,clasificacion,duracion,sinopsis) values (?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, titulo);
            stmt.setInt(2, clasificacion);
            stmt.setInt(3, duracion);
            stmt.setString(4, sinopsis);
            columnasModificadas = stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }
        return columnasModificadas;
    }

    // Borra una película por su id
    public int eliminarPeliculas(int id) {
        int columnasBorradas = -1;
        String query = "delete from pelicula where id=?";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, id);
            columnasBorradas = stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("hubo un problema al borrar la id " + id);
            e.printStackTrace();
        }

        return columnasBorradas;
    }

    // Al cerrar el DAO se cierra la conexión si sigue abierta
    @Override
    public void close() throws SQLException {
        if (this.con != null && !this.con.isClosed()) {
            this.con.close();
        }
    }

}
