package net.abcdroid.ejmandroidyoutube.dao;

import java.util.List;

import net.abcdroid.ejmandroidyoutube.dao.domain.Video;

public interface VideoDao {
 
	public List<Video> obtenerVideos();
	public List<Video> obtenerVideos(int start_index,int max_results);
}