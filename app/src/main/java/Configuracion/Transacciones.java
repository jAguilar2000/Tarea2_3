package Configuracion;

public class Transacciones {
    public static final String DBName = "TAREA2_3";
    public static final String TableFoto = "fotos";
    public static final String id = "id";
    public static final String fotografia = "fotografia";
    public static final String descripcion = "descripcion";

    public static final String CreateTableFotos = "Create table " + TableFoto + " (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, fotografia TEXT, descripcion TEXT )";

    public static final String DropTableFotos = "DROP TABLE IF EXISTS "+ TableFoto;

    public static final String SelectAllFotos = "SELECT * FROM " + TableFoto;
}
