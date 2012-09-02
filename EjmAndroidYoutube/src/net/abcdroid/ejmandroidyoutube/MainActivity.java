package net.abcdroid.ejmandroidyoutube;

import java.util.List;

import net.abcdroid.ejmandroidyoutube.service.VideoService;
import net.abcdroid.ejmandroidyoutube.view.domain.ItemVideo;
import net.abcdroid.ejmandroidyoutube.view.domain.ItemVideoListAdapter;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.widget.ListView;

import com.google.inject.Inject;

public class MainActivity extends RoboActivity {

	@Inject
	VideoService videoService;
	
	@InjectView(R.id.listaEpisodios)
    ListView listaEpisodios;
	
	ItemVideoListAdapter adaptador;
	List<ItemVideo> listaVideos;
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        listaVideos = videoService.obtenerVideos();
    	adaptador = new ItemVideoListAdapter(this,R.layout.inicio_lista_itemvideo,listaVideos);
    	listaEpisodios.setAdapter(adaptador);
    }
}