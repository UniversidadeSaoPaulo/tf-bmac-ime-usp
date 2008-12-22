package tf.helpers;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
 
/**
 * Recupera configra��es guardadas no tf.properties
 * @author chester
 *
 */
public class ConfigHelper {
    
	/**
	 * @return diret�rio com as classes da aplica��o
	 */
	public static String getClaspathApp() {
		return "c:\\java\\tf\\code\\target\\classes";
	}
	
	/**
	 * @return diret�rio no qual ser�o colocadas as classes compiladas dinamicamente
	 */
	public static String getClasspathDinamico() {
		return "c:\\java\\classes_dinamicas";
	}
	
}
 
