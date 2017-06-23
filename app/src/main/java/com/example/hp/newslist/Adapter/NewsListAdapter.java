package com.example.hp.newslist.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.newslist.Model.Articles;
import com.example.hp.newslist.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsListAdapter extends ArrayAdapter<Articles> {
    private ArrayList<Articles> articles;

    public NewsListAdapter(Context c, ArrayList<Articles> articles) {
        super(c, 0, articles);
        this.articles = articles;
    }

    public Articles getItem(int position) {
        return articles.get(position);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Articles article = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_item, parent, false);
        }

        ImageView img = (ImageView) convertView.findViewById(R.id.image);
        Picasso.with(getContext()).load(article.getImageUrl()).resize(300, 300).centerCrop().placeholder(R.drawable.defaults).into(img);

        TextView text = (TextView) convertView.findViewById(R.id.text);
        text.setText(article.getTitle());

        return convertView;
    }
}