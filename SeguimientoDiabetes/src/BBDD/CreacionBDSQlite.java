package BBDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class CreacionBDSQlite extends SQLiteOpenHelper {
 
    //Nombre de la base de datos
    public static final String NOMBREBD = "bdprueba.sqlite";
    //Versi�n de la base de datos
    public static final int VERSION = 1;
    //Nombre de la tabla (puede haber tantas como necesitemos)
    public static final String NOMBRE_TABLA = "tablaMediciones";
    //Establecemos los nombres de las columnas
    public static final String KEY_ID = "_id";
    public final static String KEY_COL1 = "fecha";
    public final static String KEY_COL2 = "tipoMedicion";
    public final static String KEY_COL3 = "medicion";
    
    
    //Constructor
    public CreacionBDSQlite(Context context) {
        //Aqu� le pasamos el contexto, el nombre de la base de datos, el cursor que no lo necesitamos y la version de la base de datos.
        super(context, NOMBREBD, null, VERSION);
    }
 
    //Aqu� crearemos la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        /*En la siguiente linea lo que estamos haciendo es crear la base de datos 
         * con una tabla llamada tablaprueba
         * dos campos uno llamado id que almacenar� un n�mero entero, que ser� clave primaria con autoincremento y que no podr� ser null
         * y otro campo llamado nombre que ser� de tipo texto  
         */
       // db.execSQL("create table " + NOMBRE_TABLA + "(" + 
      //   KEY_ID + " integer primary key autoincrement not null, " + 
       //  KEY_COL1 + "text);" );
        //db.execSQL("create table tablaprueba(id integer primary key, nombre text)");
    	db.execSQL("create table tablaMediciones(_id integer primary key, fecha DATE NOT NULL DEFAULT current_date , tipoMedicion text, medicion integer)");

    	//db.execSQL("create table tablaMediciones(_id integer primary key, tipoMedicion text, medicion integer)");
        //db.execSQL("create table tablaprueba(fecha CURRENT_DATE PRIMARY KEY, nombre text)");
    	//dentro de los par�ntesis tambi�n podr�a ir perfectamente "create table tablaprueba(id integer primary key autoincrement not null, nombre text);" esto y lo anterior es lo mismo
       
    }
 
    
    	public static void insertarCampo(SQLiteDatabase db, String fecha, String tipoMedicion, Integer medicion){

    
    	
    	//Entra en el if si nombre contiene algun caracter que no sea un espacio
    	
    		//Insertamos el dato en la tabla
    		//bd.execSQL("insert into tablaprueba values(null,'"+ nombre +"');");
    		ContentValues valores = new ContentValues();
    		//String fecha = "";

    		valores.put("fecha", fecha);
    		valores.put("tipoMedicion", tipoMedicion);
    		valores.put("medicion", medicion);
    		 
    		db.insert("tablaMediciones", null, valores);
    		
    	}
    
    	public static String consulta(SQLiteDatabase db, String fecha, String tipoMedicion) {
    		
    		 
            Cursor fila = db.rawQuery(
                    "select * FROM tablaMediciones WHERE fecha='"+fecha+"' AND tipoMedicion='"+tipoMedicion+"'", null);
            if (fila.moveToFirst()) {
            	return fila.getString(3);

            	
            }
            
            db.close();
        	return null;

        }
    
    //Aqu� se actualizar� la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {    
    }
    
    

  }
        
    
    
   