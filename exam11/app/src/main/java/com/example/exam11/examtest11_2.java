package com.example.exam11;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class examtest11_2 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리 영화 포스터");

        Gallery gallery = (Gallery) findViewById(R.id.gallery1);

        MyGalleryAdapter galAdapter = new MyGalleryAdapter(this);
        gallery.setAdapter(galAdapter);
    }

    public class MyGalleryAdapter extends BaseAdapter {

        Context context;
        Integer[] posterID = { R.drawable.mov11, R.drawable.mov12,
                R.drawable.mov13, R.drawable.mov14, R.drawable.mov15,
                R.drawable.mov16, R.drawable.mov17, R.drawable.mov18,
                R.drawable.mov19, R.drawable.mov20 };



        String[] posterTitle = { "여인의 향기", "쥬라기 공원", "포레스트 검프", "사랑의 블랙홀",
                "혹성탈출", "아름다운비행", "내이름은 칸", "해리포터", "마더", "킹콩을 들다" };


        public MyGalleryAdapter(Context c) {
            context = c;
        }

        public int getCount() {
            return posterID.length;
        }

        public Object getItem(int arg0) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new Gallery.LayoutParams(200, 300));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5, 5, 5, 5);
            imageview.setImageResource(posterID[position]);

            final int pos = position;
            imageview.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    ImageView ivPoster = (ImageView) findViewById(R.id.ivPoster);
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posterID[pos]);

                    //토스트로 제목을 띄워준다!
                    //1.토스트 객체를 생성
                    //2.뷰를 인플레이터 해서 xml을 java 객체로
                    //3.뷰안의 위젯(뷰)를 바인딩

                    //1.
                    Toast toast = new Toast(examtest11_2.this);
                    //2.
                    View toastView = View.inflate(examtest11_2.this,
                            R.layout.toast,
                            null);
                    //3.
                    TextView tv1 = (TextView) toastView.findViewById(R.id.dlg_tv1);

                    tv1.setText(posterTitle[pos]);

                    toast.setView(toastView);
                    toast.show();

                    return false;
                }
            });

            return imageview;
        }
    }
}
