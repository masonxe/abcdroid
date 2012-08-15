package net.abcdroid.roboguicesqlite;

import net.abcdroid.roboguicesqlite.dbo.PersonaDbo;
import net.abcdroid.roboguicesqlite.service.PersonasService;
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

public class RegistroActivity extends RoboActivity implements OnClickListener{

	@Inject
	PersonasService personasService;
	
	@InjectView(R.id.txtDni)
	EditText txtDni;
	
	@InjectView(R.id.txtApPaterno)
	EditText txtApPaterno;
	
	@InjectView(R.id.txtApMaterno)
	EditText txtApMaterno;
	
	@InjectView(R.id.txtNombres)
	EditText txtNombres;
	
	@InjectView(R.id.btnRegistrar)
	Button btnRegistrar;
	
	@InjectView(R.id.btnIrAListado)
	Button btnIrListado;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.registrar_persona);
	    btnRegistrar.setOnClickListener(this);
	    btnIrListado.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if(v.equals(btnRegistrar)){
			String strDni = txtDni.getText().toString().trim();
			String strApPaterno = txtApPaterno.getText().toString().trim();
			String strApMaterno = txtApMaterno.getText().toString().trim();
			String strNombres = txtNombres.getText().toString().trim();
			
			if(!strDni.equals("") && !strApPaterno.equals("") && 
			   !strApMaterno.equals("") && !strNombres.equals("")){
				PersonaDbo p = new PersonaDbo();
				p.setDni(strDni);
				p.setApPaterno(strApPaterno);
				p.setApMaterno(strApMaterno);
				p.setNombres(strNombres);
				long rs = personasService.registrarPersona(p);
				
				if(rs!=-1){
					Toast.makeText(this,"Se registro correctamente", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(this,"No se pudo registrar", Toast.LENGTH_SHORT).show();
				}
			}else{
				Toast.makeText(this,"No debe haber campos vacios", Toast.LENGTH_SHORT).show();
			}
		}
		
		if(v.equals(btnIrListado)){
			Intent i = new Intent(this,ListadoActivity.class);
			startActivity(i);
			finish();
		}
		
	}
}