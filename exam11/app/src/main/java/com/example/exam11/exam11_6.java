package com.example.exam11;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class exam11_6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam11_6);
        setTitle("임포스터");

        final GridView gv = (GridView) findViewById(R.id.gridView1);

                                        // 액티비티는 context의 자식
        MyGridAdapter gAdapter = new MyGridAdapter(this); // 나머지(디자인,데이터)는 MyGridAdapter의 getView메소드안에서  알아서해줌
        gv.setAdapter(gAdapter); // 그리드뷰에 baseAdapter끼워줌

    }





    public class MyGridAdapter extends BaseAdapter {
        Integer[] posterID = {
                R.drawable.mov1, R.drawable.mov2 ,R.drawable.mov3 , R.drawable.mov4 ,R.drawable.mov5, R.drawable.mov6, R.drawable.mov7, R.drawable.mov8, R.drawable.mov9, R.drawable.mov10,
                R.drawable.mov1, R.drawable.mov2 ,R.drawable.mov3 , R.drawable.mov4 ,R.drawable.mov5, R.drawable.mov6, R.drawable.mov7, R.drawable.mov8, R.drawable.mov9, R.drawable.mov10,
                R.drawable.mov1, R.drawable.mov2 ,R.drawable.mov3 , R.drawable.mov4 ,R.drawable.mov5, R.drawable.mov6, R.drawable.mov7, R.drawable.mov8, R.drawable.mov9, R.drawable.mov10
        };
        String[] movieName = {
                "써니", "완득이", "괴물", "영화4", "영화5", "영화6", "영화7", "영화8", "영화9", "영화10",
                "써니", "완득이", "괴물", "영화4", "영화5", "영화6", "영화7", "영화8", "영화9", "영화10",
                "써니", "완득이", "괴물", "영화4", "영화5", "영화6", "영화7", "영화8", "영화9", "영화10"
        };


        Context context;
        public MyGridAdapter(Context c){  // MYIA 를 생성하는곳에서의 정보를 context로 받겠다.
            context = c;
        }
        @Override
        public int getCount() {  //자식 뷰들의 개수를 리턴하는 메소드입니다. 여기서 자식 뷰는 어댑터 뷰의 자식 뷰임을 의미합니다.
            return posterID.length; // pID.length만큼 개수제한
        }

        @Override
        public Object getItem(int position) { // 어댑터 뷰의 자식 뷰가 n개라면, 어댑터 객체가 갖는 항목의 개수 역시 n개입니다.
                                              // getItem 메소드는 항목들 중 하나를 리턴합니다. 여기에서 항목은 자식 뷰의 내용을 갖는 객체입니다.
            return null;
        }

        @Override
        public long getItemId(int position) { //이 메소드는 어댑터가 갖는 항목의 ID를 리턴합니다.
                                              // 단순한 어댑터를 구현하시는 경우라면, 파라미터 position의 값을 그대로 리턴하는 것도 무방합니다.
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) { //자식 뷰들 중 하나를 리턴하는 메소드입니다.
                                        // convertView 파라메터의 값을 확인하여 그것이 생성되었는지 확인할 수 있습니다. 그것의 값이 null이면, 자식 뷰를 생성하세요.
                                        // 화면하나를 구성                                             준

            ImageView imageView = new ImageView(context); // 위 context에서 받아온 정보안에 액티비티를 참조
            imageView.setLayoutParams(new GridView.LayoutParams(200,300)); // 속성변경(그리드뷰에 들어갈꺼니까 그리드뷰속성변경 메소드로 변경)
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER); // 위치 사이즈 속성 변경
            imageView.setPadding(5,5,5,5); // 패딩속성 변경

            imageView.setImageResource(posterID[position]); // posterID[] 주소값 배열에 그리드뷰 포지션에 해당하는데 이미지 설정

            final int pos = position; // 포지션은 지역변수, 리스너에 넘겨주려면 final로 변수선언해서 넘겨줘야함 (원래는)
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(exam11_6.this, R.layout.exam11_6dialog,null); // 띄워줄 화면 객체
                    AlertDialog.Builder dlg = new AlertDialog.Builder(exam11_6.this); // 만들어서 띄워주는 친구
                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);    // dialog.xml에 있는 이미지뷰 바인딩
                    ivPoster.setImageResource(posterID[pos]); //사진
                    dlg.setTitle(movieName[pos]);  // 제목
                    dlg.setIcon(R.drawable.movie_icon); // 아이콘
                    dlg.setView(dialogView); // 빌더에 화면 끼워넣기
                    dlg.setNegativeButton("닫기",null); // 닫기버튼
                    dlg.show(); //보여줄게
                }
            });
            return imageView;   // getView 내부적으로 화면하나씩 리턴 반복
        }
    }
}