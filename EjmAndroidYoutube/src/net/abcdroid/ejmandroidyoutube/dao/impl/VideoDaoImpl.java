package net.abcdroid.ejmandroidyoutube.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import net.abcdroid.ejmandroidyoutube.config.Constantes;
import net.abcdroid.ejmandroidyoutube.dao.VideoDao;
import net.abcdroid.ejmandroidyoutube.dao.domain.Miniatura;
import net.abcdroid.ejmandroidyoutube.dao.domain.Video;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.util.Log;

public class VideoDaoImpl implements VideoDao {
	
	@Override
	public List<Video> obtenerVideos(){
		int start_index = 1;
		int max_results = Constantes.MAX_VIDEOS_POR_PAGINA;
		return obtenerVideos(start_index,max_results);
	}
	
	@Override
	public List<Video> obtenerVideos(int start_index,int max_results)  {
		List<Video> lista = null;
		String ruta = Constantes.FEED_URL + Constantes.USER_ID + "/" + Constantes.TIPO_VIDEO_SUBIDAS_TOTALES + "?start-index="+start_index+"&amp;max-results="+max_results;
		Log.v(VideoDaoImpl.class.getSimpleName(),"Ruta = "+ruta);
		URL url = null;
		URLConnection connection = null;
		HttpURLConnection httpConnection = null;
		
		try {
			lista = new ArrayList<Video>();
			url = new URL(ruta);
			connection = url.openConnection();
			httpConnection = (HttpURLConnection)connection; 
			
			int responseCode = httpConnection.getResponseCode(); 
			
			if (responseCode == HttpURLConnection.HTTP_OK) { 
				 InputStream in = httpConnection.getInputStream(); 

                 DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                 DocumentBuilder db = dbf.newDocumentBuilder();

                 // Parse the earthquake feed.
                 Document dom = db.parse(in);      
                 Element docEle = dom.getDocumentElement();
                 
                 NodeList nl = docEle.getElementsByTagName("entry");
                 
                 if (nl != null && nl.getLength() > 0) {
                     for (int i = 0 ; i < nl.getLength(); i++) {
                    	 Video v = new Video();
                    	 Element entry = (Element)nl.item(i);
                        
                    	 //Seteando el titulo
                    	 Element title = (Element)entry.getElementsByTagName("title").item(0);
                         v.setTitulo(title.getFirstChild().getNodeValue());
                         
                         //Seteando las miniaturas
                         Element mediaGroup = (Element)entry.getElementsByTagName("media:group").item(0);
                         NodeList thumbnails = mediaGroup.getElementsByTagName("media:thumbnail");
                         List<Miniatura> listaMiniaturas = new ArrayList<Miniatura>();
                         for(int j = 0; j<thumbnails.getLength();j++){
                        	 Element e = (Element)thumbnails.item(j);
                        	 Miniatura m = new Miniatura();
                        	 m.setRuta(e.getAttribute("url"));
                        	 m.setWidth(e.getAttribute("width"));
                        	 m.setHeight(e.getAttribute("height"));
                        	 m.setTime(e.getAttribute("time"));
                        	 listaMiniaturas.add(m);
                         }
                         v.setMiniaturas(listaMiniaturas);
                         
                         //Seteando la url del video
                         NodeList datosVideo = mediaGroup.getElementsByTagName("media:content");
                    	 Element e = (Element)datosVideo.item(datosVideo.getLength()-1);
                    	 v.setRuta(e.getAttribute("url"));
                         
                         lista.add(v);
                     }
                 }
			}


		} catch (MalformedURLException e) {
			Log.v(VideoDaoImpl.class.getSimpleName(), e.getMessage());
			lista = null;
		} catch (IOException e) {
			Log.v(VideoDaoImpl.class.getSimpleName(), e.getMessage());
			lista = null;
		} catch (ParserConfigurationException e) {
			Log.v(VideoDaoImpl.class.getSimpleName(), e.getMessage());
			lista = null;
		} catch (SAXException e) {
			Log.v(VideoDaoImpl.class.getSimpleName(), e.getMessage());
			lista = null;
		}
		return lista;
	}

}