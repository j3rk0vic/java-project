/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal.sql;

import hr.algebra.dal.ActorRepository;
import hr.algebra.model.Actor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ivanjerkovic
 */
public class ActorRepositorySql implements ActorRepository {
    
    private static final String ID_ACTOR = "IDActor";
    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";
    
    private static final String CREATE_ACTOR = "{ CALL createActor (?,?,?) }";
    private static final String UPDATE_ACTOR = "{ CALL updateActor (?,?,?) }";
    private static final String DELETE_ACTOR = "{ CALL deleteActor (?) }";
    private static final String SELECT_ACTORS = "{ CALL selectActors }";

    @Override
    public void createActor(Actor actor) throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_ACTOR)) {
            stmt.setString(FIRST_NAME, actor.getFirstName());
            stmt.setString(LAST_NAME, actor.getLastName());
            stmt.registerOutParameter(ID_ACTOR, Types.INTEGER);
            
            stmt.executeUpdate();
            
            actor.setIdActor(stmt.getInt(ID_ACTOR));
        }
    }

    @Override
    public void updateActor(Actor actor) throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_ACTOR)) {
            stmt.setInt(ID_ACTOR, actor.getIdActor());
            stmt.setString(FIRST_NAME, actor.getFirstName());
            stmt.setString(LAST_NAME, actor.getLastName());
            stmt.registerOutParameter(ID_ACTOR, Types.INTEGER);
            
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteActor(int id) throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_ACTOR)) {
            stmt.setInt(ID_ACTOR, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Actor> selectActors() throws Exception {
        List<Actor> actors = new ArrayList<>();
        
        try (Connection con = DataSourceSingleton.getInstance().getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_ACTORS);
                ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                actors.add(new Actor(
                        rs.getInt("IDActor"),
                        rs.getString("FirstName"),
                        rs.getString("LastName")
                ));
            }
        }
        
        return actors;
    }
}
