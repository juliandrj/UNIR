package es.edu.unir.farmacia.helpers;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public final class PropertiesHelper {
	
	private static Logger log = Logger.getLogger(PropertiesHelper.class);
	
	private static PropertiesHelper instance;
	private Properties props;
	
	private PropertiesHelper() {
		try{
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			this.props = new Properties();
			this.props.load(loader.getResourceAsStream("farmacia.properties"));
		} catch (IOException ex) {
			log.fatal("No se logro cargar el archivo de propiedades.", ex);
		}
	}
	
	public static String getPropertie(String key) {
		if (instance == null) {
			instance = new PropertiesHelper();
		}
		return instance.props.getProperty(key);
	}

}
