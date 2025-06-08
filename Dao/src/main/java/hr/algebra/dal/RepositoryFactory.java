/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal;

import hr.algebra.dal.sql.DataSourceSingleton;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dnlbe
 */
public class RepositoryFactory {

    private static Repository repository;

    private static final String PATH = "/config/repository.properties";

    private static final Properties PROPERTIES = new Properties();
    private static final String CLASS_NAME = "CLASS_NAME";

    static {
        try (InputStream is = RepositoryFactory.class.getResourceAsStream(PATH)) {
            PROPERTIES.load(is);
            repository = (Repository) Class.forName(PROPERTIES.getProperty(CLASS_NAME))
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (Exception ex) {
            Logger.getLogger(DataSourceSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private RepositoryFactory() {
    }

    // LAZY SINGLETON
    public static Repository getRepository() throws Exception {
        return repository;
    }
}
