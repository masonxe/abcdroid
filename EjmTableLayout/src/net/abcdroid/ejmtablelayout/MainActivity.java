package net.abcdroid.ejmtablelayout;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends Activity {

	TableLayout tabla;
	TableLayout cabecera;
	TableRow.LayoutParams layoutFila;
	TableRow.LayoutParams layoutId;
	TableRow.LayoutParams layoutTexto;
	
	private int MAX_FILAS = 10;
	
	Resources rs;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rs = this.getResources();
        tabla = (TableLayout)findViewById(R.id.tabla);
        cabecera = (TableLayout)findViewById(R.id.cabecera);
		layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
		layoutId = new TableRow.LayoutParams(70,TableRow.LayoutParams.WRAP_CONTENT);
		layoutTexto = new TableRow.LayoutParams(160,TableRow.LayoutParams.WRAP_CONTENT);
			
		agregarCabecera();
		agregarFilasTabla();
    }
    
    public void agregarCabecera(){
    	TableRow fila;
    	TextView txtId;
    	TextView txtNombre;
    	
    	fila = new TableRow(this);
		fila.setLayoutParams(layoutFila);
		
		txtId = new TextView(this);
		txtNombre = new TextView(this);
		
		txtId.setText(rs.getString(R.string.id));
		txtId.setGravity(Gravity.CENTER_HORIZONTAL);
		txtId.setTextAppearance(this,R.style.etiqueta);
		txtId.setBackgroundResource(R.drawable.tabla_celda_cabecera);
		txtId.setLayoutParams(layoutId);
		
		txtNombre.setText(rs.getString(R.string.valor));
		txtNombre.setGravity(Gravity.CENTER_HORIZONTAL);
		txtNombre.setTextAppearance(this,R.style.etiqueta);
		txtNombre.setBackgroundResource(R.drawable.tabla_celda_cabecera);
		txtNombre.setLayoutParams(layoutTexto);
		
		fila.addView(txtId);
		fila.addView(txtNombre);
		cabecera.addView(fila);
    }
    
    public void agregarFilasTabla(){
    	
    	TableRow fila;
    	TextView txtId;
    	TextView txtNombre;
    	
    	for(int i = 0;i<MAX_FILAS;i++){
    		int posicion = i + 1;
    		fila = new TableRow(this);
    		fila.setLayoutParams(layoutFila);
    		
    		txtId = new TextView(this);
    		txtNombre = new TextView(this);
    		
    		txtId.setText(String.valueOf(posicion));
    		txtId.setGravity(Gravity.CENTER_HORIZONTAL);
    		txtId.setTextAppearance(this,R.style.etiqueta);
    		txtId.setBackgroundResource(R.drawable.tabla_celda);
    		txtId.setLayoutParams(layoutId);
    		
    		txtNombre.setText("Texto "+posicion);
    		txtNombre.setGravity(Gravity.CENTER_HORIZONTAL);
    		txtNombre.setTextAppearance(this,R.style.etiqueta);
    		txtNombre.setBackgroundResource(R.drawable.tabla_celda);
    		txtNombre.setLayoutParams(layoutTexto);
    		
    		fila.addView(txtId);
    		fila.addView(txtNombre);
    		
    		tabla.addView(fila);
    	}
    }
}