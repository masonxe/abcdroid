package net.abcdroid.ejmroboguice;

import net.abcdroid.ejmroboguice.service.EjmService;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.inject.Inject;

public class EjmRoboGuiceActivity extends RoboActivity implements OnClickListener {
	
	
	@Inject
	EjmService ejmService;
	
	@InjectView(R.id.txtInfo)
	EditText txtInfo;
	
	@InjectView(R.id.btnRegistro)
	Button btnRegistro;
	
	@InjectView(R.id.btnLectura)
	Button btnIrLectura;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingreso_datos);
        btnRegistro.setOnClickListener(this);
        btnIrLectura.setOnClickListener(this);
    }

	@Override
	public void onClick(View arg) {
		if(arg.equals(btnRegistro)){
			String info = txtInfo.getText().toString();
			info = info.trim();
			
			if(!info.equals("")){
				ejmService.guardarInformacion(info);
				Toast.makeText(this,"Se guardo el valor : "+info, Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(this,"El valor no debe estar vacio",Toast.LENGTH_SHORT).show();
			}
		}
		
		if(arg.equals(btnIrLectura)){
			Intent i = new Intent(this,LecturaActivity.class);
			startActivity(i);
    	    finish();
		}
	}
	
}