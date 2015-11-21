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
      
        
        //Conexión a la base de datos
        CreacionBDSQlite crearBD = new CreacionBDSQlite(this);
        //crearBD.onCreate(bd);
        
        bd = crearBD.getWritableDatabase();//Método de la clase heredada SQLiteOpenHelper para utilizar la base de datos
         		
    }
    
    
    
    //Método al que se llamará al hacer click  en el botón del layout 
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
    		
    		
    		
    		
    		
    		/*EJEMPLOS DE ACTUALIZACIÓN Y BORRADO DE CAMPOS
    		* Aquí estamos cambiando el nombre de Pepito por Pedro Pikapiedras
        	* 
        	* Con el método execSQL()
        	* bd.execSQL("UPDATE tablaprueba SET nombre='Pedro Pikapiedras' WHERE nombre='Pepito' ");
        	* 
        	* Con el método update()
        	* ContentValues valores2 = new ContentValues();
    		* valores2.put("nombre", "Pedro Pikapiedras");
    		* bd.update("tablaprueba", valores2,"nombre='Pepito'",null);
    		* 
    		* Aquí borramos el usuario con el nombre Pepito
    		* Con el método execSQL()
    		* bd.execSQL("DELETE FROM tablaprueba WHERE nombre='Pepito'");
    		* 
    		* Con el método delete()
    		* bd.delete("tablaprueba", "nombre='Pepito'", null);
        	*/
    	
    
    	
    	
    	
    	
    }

    public static String consultar(){
    	
    	Cursor contenido = bd.rawQuery("Select id,nombre from tablaprueba", null);
    	String textoDevolver = contenido.getString(1);
    	return textoDevolver;
    	
    	
    }

}



