package net.abcdroid.ejmandroidyoutube.view.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemVideo implements Parcelable {

	private String titulo;
	private String ruta;
	private String miniatura;
	
	public ItemVideo(){}
	
	public ItemVideo(Parcel source){
        titulo = source.readString();
        ruta = source.readString();
        miniatura = source.readString();
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getMiniatura() {
		return miniatura;
	}
	public void setMiniatura(String miniatura) {
		this.miniatura = miniatura;
	}
	
	@Override
	public String toString() {
		return titulo;
	}
	
	@Override
	public int describeContents() {
		return hashCode();
	}
	
	@Override
	public void writeToParcel(Parcel destino, int flags) {
		destino.writeString(titulo);
		destino.writeString(ruta);
		destino.writeString(miniatura);
	}
	
    public static final Parcelable.Creator<ItemVideo> CREATOR = new Parcelable.Creator<ItemVideo>() {

        public ItemVideo createFromParcel(Parcel in){
            return new ItemVideo(in);
        }

        public ItemVideo[] newArray(int size){
            return new ItemVideo[size];
        }

    };
}