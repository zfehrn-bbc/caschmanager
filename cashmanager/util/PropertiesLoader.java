package cashmanager.cashmanager.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Lädt alle Daten aus dem configs.properties file
 */
public class PropertiesLoader {

  private static final String PROP_FILE = "configs.properties";

  /**
   * Lädt alles aus dem file configs.properties.
   * 
   * @return The properties.
   * @throws IOException
   *           If file config.properties does not exist or cannot be read.
   */
  public static Properties loadProperties() throws IOException {
    Properties prop = new Properties();
    InputStream is = PropertiesLoader.class.getClassLoader()
        .getResourceAsStream(PROP_FILE);

    if (is != null) {
      prop.load(is);
      is.close();
      return prop;
    } else {
      throw new IOException("Konnte die Einstellungen nicht aus " + PROP_FILE + " laden.");
    }
  }
}
