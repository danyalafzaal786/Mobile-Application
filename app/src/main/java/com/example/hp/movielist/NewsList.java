package com.example.hp.movielist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.R.attr.value;

public class NewsList extends AppCompatActivity {

    @BindView(R.id.progress) ProgressBar progressBar;
    @BindView(R.id.error) TextView textView;
    @BindView(R.id.grid) GridView gridView;
    private Unbinder unbinder;
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        controller = new Controller(this);
        controller.start();
        setContentView(R.layout.activity_list);
        unbinder = ButterKnife.bind(this);
        progressBar.getIndeterminateDrawable().setColorFilter(0xFFFF0000, android.graphics.PorterDuff.Mode.MULTIPLY);
        progressBar.setVisibility(View.VISIBLE);
    }

    public void createView(final News news){
        progressBar.setVisibility(View.GONE);
        if (news == null){
            textView.setVisibility(View.VISIBLE);
            textView.setText("Some Error Occured");
            Toast.makeText(getBaseContext(),"Internet Connection Failed", Toast.LENGTH_SHORT).show();
        } else {
            gridView.setAdapter(new NewsListAdapter(this,news.getArticles()));

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    Articles article = news.getArticles().get(position);
                    Intent intent = new Intent(NewsList.this, ArticleInfo.class);
                    intent.putExtra("article", article);
                    startActivity(intent);
                }
            });
            gridView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onStop(){
        super.onStop();
        controller.cancel();
    }
}
