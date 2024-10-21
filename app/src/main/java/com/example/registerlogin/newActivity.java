package com.example.registerlogin;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class newActivity extends AppCompatActivity {

    ImageView ourView = null;
    private int countPair = 0;
    final int[] drawable = new int[]{R.drawable.image2,R.drawable.image7,R.drawable.image3,
            R.drawable.image4,R.drawable.image5,R.drawable.image6,};


    int[] pos = {1,0,2,3,4,5,2,3,1,4,5,0};
    int currentPos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        GridView gridView = (GridView)findViewById(R.id.gridView);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        gridView.setAdapter((imageAdapter));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(currentPos <0){
                    currentPos = position;
                    ourView = (ImageView)view;
                    ((ImageView)view).setImageResource(drawable[pos[position]]);
                }

                else
                {
                    if(currentPos == position){
                        ((ImageView)view).setImageResource((R.drawable.hidden));
                    }

                    else if (pos[currentPos]!=pos[position])
                    {
//                        ((ImageView)view).setImageResource(drawable[pos[position]]);

//                        ((ImageView)view).setImageResource(drawable[pos[position]]);
                        ourView.setImageResource(R.drawable.hidden);

                        Toast.makeText(getApplicationContext(),"Not Match",Toast.LENGTH_SHORT).show();
                    }

                    else
                    {
                        ((ImageView)view).setImageResource(drawable[pos[position]]);
//                        ourView.setImageResource(R.drawable.hidden);
                        countPair++;

                        if(countPair==6)
                        {
                            Toast.makeText(getApplicationContext(),"You Win",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),newActivity2.class);
                            startActivity(intent);
                        }
                    }

                    currentPos = -1;
                }

            }
        });

    }

    public void home(View view) {
        Intent intent = new Intent(getApplicationContext(),games.class);
        startActivity(intent);
        finish();
    }
}

