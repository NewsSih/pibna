package com.example.pib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<News> {


    public ListAdapter(@NonNull Context context, ArrayList<News> userarraylist) {
        super(context, R.layout.newcard);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        News news = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.newcard,parent,false);
        }

//        TextView title = convertView.findViewById(R.id.Title);
//        TextView date = convertView.findViewById(R.id.date);

//        title.setText(news.Title);
//        date.setText(news.Date);



        return super.getView(position, convertView, parent);
    }


}
