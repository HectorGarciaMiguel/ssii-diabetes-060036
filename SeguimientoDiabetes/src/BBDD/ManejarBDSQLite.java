package BBDD;


import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;



public class ManejarBDSQLite extends Activity {
    

	static SQLiteDatabase bd;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      
        
        //Conexi�n a la base de datos
        CreacionBDSQlite crearBD = new CreacionBDSQlite(this);
        //crearBD.onCreate(bd);
        
        bd = crearBD.getWritableDatabase();//M�todo de la clase heredada SQLiteOpenHelper para utilizar la base de datos
         		
    }
    
    
    
    //M�todo al que se llamar� al hacer click  en el bot�n del layout 
    public static void insertarCampo(Integer medicion){

    
    	
    	//Entra en el if si nombre contiene algun caracter que no sea un espacio
    	
    		//Insertamos el dato en la tabla
    		//bd.execSQL("insert into tablaprueba values(null,'"+ nombre +"');");
    		ContentValues valores = new ContentValues();
    		String fecha = "2012-01-06";
    		String tipoMedicion = "antesComer";

    		valores.put("fecha", fecha);
    		valores.put("tipoMedicion", tipoMedicion);
    		valores.put("meddicion", medicion);
    		
    		bd.insert("tablaMediciones", null, valores);
    		
    		
    		
    		
    		
    		/*EJEMPLOS DE ACTUALIZACI�N Y BORRADO DE CAMPOS
    		* Aqu� estamos cambiando el nombre de Pepito por Pedro Pikapiedras
        	* 
        	* Con el m�todo execSQL()
        	* bd.execSQL("UPDATE tablaprueba SET nombre='Pedro Pikapiedras' WHERE nombre='Pepito' ");
        	* 
        	* Con el m�todo update()
        	* ContentValues valores2 = new ContentValues();
    		* valores2.put("nombre", "Pedro Pikapiedras");
    		* bd.update("tablaprueba", valores2,"nombre='Pepito'",null);
    		* 
    		* Aqu� borramos el usuario con el nombre Pepito
    		* Con el m�todo execSQL()
    		* bd.execSQL("DELETE FROM tablaprueba WHERE nombre='Pepito'");
    		* 
    		* Con el m�todo delete()
    		* bd.delete("tablaprueba", "nombre='Pepito'", null);
        	*/
    	
    
    	
    	
    	
    	
    }

    public static String consultar(){
    	
    	Cursor contenido = bd.rawQuery("Select id,nombre from tablaprueba", null);
    	String textoDevolver = contenido.getString(1);
    	return textoDevolver;
    	
    	
    }

}



