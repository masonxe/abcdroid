package net.abcdroid.ejmandroidyoutube.view.domain;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import net.abcdroid.ejmandroidyoutube.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemVideoListAdapter extends ArrayAdapter<ItemVideo> {
	
	Context context;
	private List<ItemVideo> items;
	 
	public ItemVideoListAdapter(Context context, int textViewResourceId, List<ItemVideo> items) {
		super(context, textViewResourceId, items);
		this.items = items;
		this.context = context;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.inicio_lista_itemvideo, null);
		}
		
		ItemVideo item = items.get(position);
		if (item != null) {
	 
			//poblamos la lista de elementos
			TextView tt = (TextView) v.findViewById(R.id.texto);
			ImageView im = (ImageView) v.findViewById(R.id.icono);
	 
			//Seteando la imagen
			if (im!= null) {
				try {
					URL url = new URL(item.getMiniatura());
					URLConnection conn = url.openConnection();
					conn.connect();
					InputStream is = conn.getInputStream();
		            BufferedInputStream bis = new BufferedInputStream(is);
		            Bitmap bm = BitmapFactory.decodeStream(bis);
		            bis.close();
	                is.close();
	                im.setImageBitmap(bm);
				} catch (MalformedURLException e) {
					Log.v(ItemVideoListAdapter.class.getSimpleName(),e.getMessage());
					im.setImageResource(R.drawable.ic_launcher);
				} catch (IOException e) {
					Log.v(ItemVideoListAdapter.class.getSimpleName(),e.getMessage());
					im.setImageResource(R.drawable.ic_launcher);
				}
				
			}
			if (tt != null) {
				tt.setText(item.getTitulo());
			}
		}
		
		return v;
	}
}