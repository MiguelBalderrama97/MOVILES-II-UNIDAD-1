package com.example.miguel.eva1_8_frag_weather.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miguel.eva1_8_frag_weather.Fragments.ItemFragment;
import com.example.miguel.eva1_8_frag_weather.Models.Clima;
import com.example.miguel.eva1_8_frag_weather.R;

import java.util.List;

public class WeatherAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Clima> weathers;

    public WeatherAdapter(){}

    public WeatherAdapter(Context context, int layout, List<Clima> weathers){
        this.context = context;
        this.layout = layout;
        this.weathers = weathers;
    }

    @Override
    public int getCount() {
        return weathers.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgClima;
        TextView txtCiudad, txtClima, txtDesc, txtTemp;

        if(convertView == null){ //NO EXISTE LA FILA, HAY QUE CREARLA
            LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
            convertView = layoutInflater.inflate(layout, parent, false);
        }

//        imgClima = convertView.findViewById(R.id.imgClima3);
        txtCiudad = convertView.findViewById(R.id.txtCiudad3);
        txtDesc = convertView.findViewById(R.id.txtDesc3);
        txtTemp = convertView.findViewById(R.id.txtTemp3);
        txtClima = convertView.findViewById(R.id.txtClima3);

        Clima cClima = weathers.get(position);
//        imgClima.setImageResource(cClima.getImagen_clima());
        txtCiudad.setText(cClima.getCiudad());
        txtDesc.setText(cClima.getDesc_clima());
        txtTemp.setText(cClima.getTemp()+" °F");
        txtClima.setText(cClima.getClima());

        return convertView;
    }
}
