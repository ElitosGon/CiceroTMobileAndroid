package com.example.ian.myapplication.MainLists;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.example.ian.myapplication.EDA.Guia;
import com.example.ian.myapplication.R;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Ian on 12-05-2017.
 */
public class MejoresAdapter extends BaseAdapter{

    Context context;
    LayoutInflater inflater;


    int [] fotos = {
            R.drawable.persona,
            R.drawable.persona2,
    };


    ArrayList<Guia> guias;

    public MejoresAdapter(Context context, ArrayList<Guia> guias) {
        this.context = context;
        this.guias=guias;
    }


    @Override
    public int getCount() {
        return guias.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.style_stars, parent, false);


        TextView nombre = (TextView)itemView.findViewById(R.id.titulo);
        TextView ciudad = (TextView)itemView.findViewById(R.id.ciudad);
        TextView tours = (TextView)itemView.findViewById(R.id.tours);
        ImageView onestar = (ImageView)itemView.findViewById(R.id.Onestar);
        ImageView twostar = (ImageView)itemView.findViewById(R.id.Twostar);
        ImageView threestar = (ImageView)itemView.findViewById(R.id.Threestar);
        ImageView forstar = (ImageView)itemView.findViewById(R.id.Forstar);
        ImageView fivestar = (ImageView)itemView.findViewById(R.id.Fivestar);



        ImageView foto = (ImageView)itemView.findViewById(R.id.img);

        foto.setImageResource(fotos[position]);

        nombre.setText(guias.get(position).getNombre());
        ciudad.setText(guias.get(position).getLocacion());
        tours.setText(String.valueOf(guias.get(position).getTours())+" Tours");

        int stars = guias.get(position).getEstrellas();

        switch (stars){

            case 0:
                onestar.setImageResource(R.drawable.staroutline);
                twostar.setImageResource(R.drawable.staroutline);
                threestar.setImageResource(R.drawable.staroutline);
                forstar.setImageResource(R.drawable.staroutline);
                fivestar.setImageResource(R.drawable.staroutline);
                break;

            case 1:
                twostar.setImageResource(R.drawable.staroutline);
                threestar.setImageResource(R.drawable.staroutline);
                forstar.setImageResource(R.drawable.staroutline);
                fivestar.setImageResource(R.drawable.staroutline);
                break;
            case 2:
                threestar.setImageResource(R.drawable.staroutline);
                forstar.setImageResource(R.drawable.staroutline);
                fivestar.setImageResource(R.drawable.staroutline);
                break;
            case 3:
                forstar.setImageResource(R.drawable.staroutline);
                fivestar.setImageResource(R.drawable.staroutline);
                break;
            case 4:
                fivestar.setImageResource(R.drawable.staroutline);
                break;
            case 5:
                break;
        }

        return itemView;
    }


    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

}
