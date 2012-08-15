package net.abcdroid.roboguicesqlite;

import java.util.List;

import net.abcdroid.roboguicesqlite.dbo.PersonaDbo;
import net.abcdroid.roboguicesqlite.service.PersonasService;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.google.inject.Inject;

public class ListadoActivity extends RoboActivity implements OnClickListener {

	@Inject
	PersonasService personasService;
	
	@InjectView(R.id.lblPersonas)
	TextView txtPersonas;
	
	@InjectView(R.id.btnIrARegistro)
	Button btnIrARegistro;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_personas);
        
        List<PersonaDbo> lstPersonas = personasService.listarPersonas();
        
        String texto = "";
        if(lstPersonas!=null){
        	for(PersonaDbo p:lstPersonas){
        		texto = texto + p.toString() + "\n";
        	}
        }
        
        txtPersonas.setText(texto);
        
        btnIrARegistro.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		if(v.equals(btnIrARegistro)){
			Intent i = new Intent(this,RegistroActivity.class);
			startActivity(i);
			finish();
		}	
	}
    
}