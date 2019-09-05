package com.example.miguel.eva1_8_frag_weather.Fragments;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.miguel.eva1_8_frag_weather.Activities.MainActivity;
import com.example.miguel.eva1_8_frag_weather.Adapters.WeatherAdapter;
import com.example.miguel.eva1_8_frag_weather.Models.Clima;
import com.example.miguel.eva1_8_frag_weather.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemFragment extends Fragment{

    private List<Clima> lstCiudades = new ArrayList<>();
    private ListView llCiudades;

    private OnListFragmentInteractionListener mListener;

    private Context context;

    private View view;

    public ItemFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_item, container, false);

        llCiudades = view.findViewById(R.id.llCiudades);

        ConexionClima ccClimaCiudad = new ConexionClima();
        ccClimaCiudad.execute();

        return view;
    }

    class ConexionClima extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            String sUrl = "https://samples.openweathermap.org/data/2.5/find?lat=55.5&lon=37.5&cnt=10&appid=b6907d289e10d714a6e88b30761fae22";
            String sResu = "";

            try {
                URL url = new URL(sUrl);
                HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
                if (httpCon.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader brDatosJSON = new BufferedReader(
                            new InputStreamReader(
                                    httpCon.getInputStream()
                            )
                    );
                    sResu = brDatosJSON.readLine();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sResu;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (!s.equals("")) {
                try {
                    JSONObject jsDatos = new JSONObject(s);
                    JSONArray ajsCiudades = jsDatos.getJSONArray("list");

                    for(int i = 0; i < ajsCiudades.length(); i++){
                        JSONObject jsActual = ajsCiudades.getJSONObject(i);
                        Clima cCiudad = new Clima();
                        cCiudad.setCiudad(jsActual.getString("name"));
                        JSONObject jsMain = jsActual.getJSONObject("main");
                        cCiudad.setTemp(jsMain.getDouble("temp"));
                        JSONArray ajsClimas = jsActual.getJSONArray("weather");
                        JSONObject jsClima = ajsClimas.getJSONObject(0);
                        cCiudad.setClima(jsClima.getString("main"));
                        cCiudad.setDesc_clima(jsClima.getString("description"));

                        int iId = jsClima.getInt("id");
                        if(iId < 300){ //TORMENTAS
                            cCiudad.setImagen_clima(R.drawable.thunderstorm);
                        }else if(iId < 400){ //LLUVIA LIGERA
                            cCiudad.setImagen_clima(R.drawable.light_rain);
                        }else if(iId < 600){ //LLUVIA INTENSA
                            cCiudad.setImagen_clima(R.drawable.rainy);
                        }else if(iId < 700){ //NIEVE
                            cCiudad.setImagen_clima(R.drawable.snow);
                        }else if(iId < 800){ //ATMOSFERA
                            cCiudad.setImagen_clima(R.drawable.tornado);
                        }else if(iId == 800){ //DESPEJADO
                            cCiudad.setImagen_clima(R.drawable.sunny);
                        }else if(iId > 800){ //SEMI NUBLADO
                            cCiudad.setImagen_clima(R.drawable.cloudy);
                        }
                        lstCiudades.add(cCiudad);
                    }
                    llCiudades.setAdapter(new WeatherAdapter(context, R.layout.list_item, lstCiudades));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Clima item);
    }

}
