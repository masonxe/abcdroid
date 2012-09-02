package net.abcdroid.ejmandroidyoutube.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.abcdroid.ejmandroidyoutube.dao.VideoDao;
import net.abcdroid.ejmandroidyoutube.dao.domain.Video;
import net.abcdroid.ejmandroidyoutube.service.VideoService;
import net.abcdroid.ejmandroidyoutube.view.domain.ItemVideo;

import com.google.inject.Inject;

public class VideoServiceImpl implements VideoService {

	@Inject
	VideoDao videoDao;
	
	@Override
	public List<ItemVideo> obtenerVideos() {
		
		List<ItemVideo> rpta = null;
		List<Video> lista = videoDao.obtenerVideos();

		if(lista!=null){
			int dim = lista.size();
			if(dim>0){
				rpta = new ArrayList<ItemVideo>();
				for(int i = 0;i<dim ;i++){
					Video x = lista.get(i);
					ItemVideo aux = new ItemVideo();
					aux.setTitulo(x.getTitulo());
					aux.setRuta(x.getRuta());
					try{
						//Se coloca uno para tomar la segunda foto
						//ya que la primera es muy grande
						aux.setMiniatura(x.getMiniaturas().get(1).getRuta());
					}catch(NullPointerException npe){
						aux.setMiniatura("");
					}
					rpta.add(aux);
				}
			}
		}
		
		return rpta;
	}

}