package net.abcdroid.ejmroboguice;

import net.abcdroid.ejmroboguice.service.EjmService;

import com.google.inject.Inject;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class LecturaActivity extends RoboActivity implements OnClickListener {

	@Inject
	EjmService ejmService;
	
	@InjectView(R.id.lblInfo)
	TextView lblInfo;
	
	@InjectView(R.id.btnEscritura)
	Button btnIrEscritura;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lectura_datos);
        btnIrEscritura.setOnClickListener(this);
        lblInfo.setText("Valor en el service : "+ejmService.obtenerInformacion());
    }
	
	@Override
	public void onClick(View arg) {
		if(arg.equals(btnIrEscritura)){
			Intent i = new Intent(this,EjmRoboGuiceActivity.class);
			startActivity(i);
    	    finish();
		}
	}
}
