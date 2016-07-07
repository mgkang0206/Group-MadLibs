package com.genassembly.dotdashdot.listexample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mauve3 on 7/7/16.
 */
public class SimpleAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final ArrayList<MadLibs> libs;

    public SimpleAdapter(Context context, ArrayList<MadLibs> libs) {
        //super();
        inflater = LayoutInflater.from(context);
        this.libs = libs;
    }

    @Override
    public int getCount() {
        return libs.size();
    }

    @Override
    public Object getItem(int position) {
        return libs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.d("Postion: " , "" + position);

        View v = convertView;
        TextView words, genre, spaces;

        if (v == null) {

            v = inflater.inflate(R.layout.list_item, parent, false);
            //v.setTag(R.id.numWords, v.findViewById(R.id.numWords));
            //v.setTag(R.id.genre, v.findViewById(R.id.genre));
            //v.setTag(R.id.numSpaces, v.findViewById(R.id.numSpaces));
        }

        words = (TextView) v.findViewById(R.id.numWords);
        genre = (TextView) v.findViewById(R.id.genre);
        spaces = (TextView) v.findViewById(R.id.numSpaces);

        Log.d("words: " , "" + words);
        Log.d("genre: " , "" + genre);
        Log.d("spaces: " , "" + spaces);

        Log.d("words info: " , "" + libs.get(position).getWords());
        Log.d("genre info: " , "" + libs.get(position).getGenre());
        Log.d("spaces info: ", "" + libs.get(position).getSpaces());

        words.setText(String.valueOf(libs.get(position).getWords()));
        genre.setText(String.valueOf(libs.get(position).getGenre()));
        spaces.setText(String.valueOf(libs.get(position).getSpaces()));

        /*TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        textView.setText(values[position]);
        // change the icon for Windows and iPhone
        String s = values[position];
        if (s.startsWith("iPhone")) {
            imageView.setImageResource(R.drawable.no);
        } else {
            imageView.setImageResource(R.drawable.ok);
        }*/

        return v;
    }
}
