package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Base_Act extends AppCompatActivity {
    private EditText et1,et2,et3;
    private Button btnUno,btnDos,btnTres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        btnUno = findViewById(R.id.btn1);
        btnDos = findViewById(R.id.btn2);
        btnTres = findViewById(R.id.btn3);
    }

    public void añadirOrdenado(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "gestion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if (!et1.getText().toString().isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("codigo",et1.getText().toString());
            registro.put("codigo",et2.getText().toString());
            registro.put("codigo",et3.getText().toString());

            BaseDeDatos.insert("ordenadores", null,registro);
            BaseDeDatos.close();
            Toast.makeText(this,"se ha ingresado un ordenador",Toast.LENGTH_LONG).show();
        }
    }



    public void AñadirLibro(View view ){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BIBLIOTECA",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if(!et1.getText().toString().isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("codigo",et1.getText().toString());
            registro.put("nombre",et2.getText().toString());
            registro.put("precio",et3.getText().toString());

            BaseDeDatos.insert("libros",null,registro);

            BaseDeDatos.close();

            Toast.makeText(this, "Se ha ingresado un Libro.", Toast.LENGTH_LONG).show();
        }
    }
    public void EliminarLibro(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BIBLIOTECA",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et1.getText().toString();

        BaseDeDatos.delete("libros","codigo="+codigo,null);
        BaseDeDatos.close();
        Toast.makeText(this, "Se ha eliminado un Libro con el codigo: "+codigo, Toast.LENGTH_LONG).show();
    }
    public void ModificarLibro(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BIBLIOTECA",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put("codigo", et1.getText().toString());
        content.put("nombre", et2.getText().toString());
        content.put("precio", et3.getText().toString());

        String codigo = et1.getText().toString();
        if(!et1.getText().toString().isEmpty()) {
            BaseDeDatos.update("libros", content, "codigo=" + codigo, null);
            Toast.makeText(this, "Se ha actualizado un Libro con el codigo: "+codigo, Toast.LENGTH_LONG).show();
        }
    }
}
