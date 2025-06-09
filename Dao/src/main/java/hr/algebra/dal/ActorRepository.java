/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hr.algebra.dal;

import hr.algebra.model.Actor;
import java.util.List;

/**
 *
 * @author ivanjerkovic
 */
public interface ActorRepository {
    void createActor(Actor actor) throws Exception;
    void updateActor(Actor actor) throws Exception;
    void deleteActor(int id) throws Exception;
    List<Actor> selectActors() throws Exception;
}
