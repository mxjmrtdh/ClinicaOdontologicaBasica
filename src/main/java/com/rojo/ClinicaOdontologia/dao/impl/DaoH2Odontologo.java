package com.rojo.ClinicaOdontologia.dao.impl;

import com.rojo.ClinicaOdontologia.db.H2Connection;
import com.rojo.ClinicaOdontologia.model.Odontologo;
import com.rojo.ClinicaOdontologia.dao.IDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DaoH2Odontologo implements IDao<Odontologo> {
    public static final Logger logger = LoggerFactory.getLogger(DaoH2Odontologo.class);
    public static final String InsertarRegistro = "INSERT INTO Odontologos VALUES(DEFAULT,?,?,?)";
    public static final String ListaTodos = "SELECT * FROM Odontologos";
    public static final String ModificarOdontologo = "Update Odontologos set NumeroMatricula=?, Nombre=?, Apellido=? where Id=?";
    public static final String EliminarOdontologo = "delete from Odontologos WHERE ID=?";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection=null;
        Odontologo odontologoARetornar=null;
        try{
            //Creamos la conexión
            connection= H2Connection.getConnection();
            //ponemos el AutoCommit en false
            connection.setAutoCommit(false);
            //Agregar registro por parametros
            PreparedStatement preparedStatement=connection.prepareStatement(InsertarRegistro, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,odontologo.getNumeroMatricula());
            preparedStatement.setString(2,odontologo.getNombre());
            preparedStatement.setString(3,odontologo.getApellido());
            preparedStatement.executeUpdate();
            //realizamos el commit
            connection.commit();
            //recuperamos el id y creamos el nuevo objeto con datos de la BD
            ResultSet resultSet=preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                Integer id=resultSet.getInt(1);
                odontologoARetornar = new Odontologo(id,odontologo.getNumeroMatricula(),odontologo.getNombre(),odontologo.getApellido());
            }
        }catch (Exception e){
            if(connection != null){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    logger.error(e.getMessage());
                } finally {
                    try {
                        connection.setAutoCommit(true);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return odontologoARetornar;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        return null;
    }

    @Override
    public List<Odontologo> listarTodos() {
        Connection connection = null;
        List<Odontologo> listaOdontologos = new ArrayList<>();
        Odontologo odontologoDesdeBD = null;
        try{
            connection = H2Connection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(ListaTodos);
            while (resultSet.next()){
                Integer idDB = resultSet.getInt(1);
                Integer numeroMatricula = resultSet.getInt(2);
                String nombre = resultSet.getString(3);
                String apellido = resultSet.getString(4);
                odontologoDesdeBD = new Odontologo(idDB, numeroMatricula, nombre, apellido);
                logger.info(String.valueOf(odontologoDesdeBD));
                listaOdontologos.add(odontologoDesdeBD);
            }
            logger.info(listaOdontologos.toString());
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return listaOdontologos;
    }

    @Override
    public void modificar(Odontologo odontologo) {
        Connection connection=null;
        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement=connection.prepareStatement(ModificarOdontologo);
            preparedStatement.setInt(1, odontologo.getNumeroMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.executeUpdate();
            connection.commit();
            logger.info("odontologo modificado"+ odontologo);

        } catch (Exception e){
            if(connection != null){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    logger.error(e.getMessage());
                } finally {
                    try {
                        connection.setAutoCommit(true);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Override
    public void eliminar(Integer id) {
        Connection connection = null;
        Odontologo odontologo=null;
        try{
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);
            odontologo=buscarPorId(id);
            PreparedStatement preparedStatement=connection.prepareStatement(EliminarOdontologo);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
            logger.info("odontologo eliminado "+ id);
        } catch (Exception e){
            if(connection != null){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    logger.error(e.getMessage());
                } finally {
                    try {
                        connection.setAutoCommit(true);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
