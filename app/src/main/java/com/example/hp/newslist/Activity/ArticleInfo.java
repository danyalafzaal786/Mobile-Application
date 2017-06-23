package com.example.hp.newslist.Activity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.newslist.Model.Articles;
import com.example.hp.newslist.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ArticleInfo extends AppCompatActivity {

    Articles article;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.author)
    TextView author;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.link)
    TextView link;
    @BindView(R.id.imageInfo)
    ImageView imageView;

    @OnClick(R.id.link)
    public void onClick() {
        Intent intent = new Intent(ArticleInfo.this, LinkToNewsUrl.class);
        intent.putExtra("url", article.getUrl());
        startActivity(intent);
    }

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_article_info);
        unbinder = ButterKnife.bind(this);

        Intent intent = getIntent();
        article = (Articles) intent.getSerializableExtra("article");

        title.setText(article.getTitle());

        author.setText(article.getAuthor());

        Picasso.with(this.getBaseContext()).load(article.getImageUrl()).placeholder(R.drawable.defaults).resize(300, 300).centerCrop().into(imageView);

        description.setText(article.getDescription());

        String s = "<b>Published Date: </b>";
        s += article.getPublishDate();
        date.setText(Html.fromHtml(s));

        link.setText(article.getUrl());
        link.setPaintFlags(link.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}