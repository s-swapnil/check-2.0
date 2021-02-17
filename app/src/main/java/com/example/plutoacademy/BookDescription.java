package com.example.plutoacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BookDescription extends AppCompatActivity {

    private String mBookImage;
    private int mRecBookNo;
    private String mTitle;
    private String mBuy;
    private String mAuthor;
    private JSONArray mRecc;

    TextView bookNameTxtview,authorNameTxtview,bookRecNoTxtView;
    ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_description);

        bookNameTxtview=findViewById(R.id.BookName);
        authorNameTxtview=findViewById(R.id.AuthorName);
        bookRecNoTxtView=findViewById(R.id.BookRec);
        bookImage=findViewById(R.id.BookImg);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null)
        {
            mBookImage=bundle.getString(BooksFragment.BOOK_IMAGE);
            mRecBookNo=bundle.getInt(BooksFragment.BOOK_SIZE);
            mTitle=bundle.getString(BooksFragment.BOOK_TITLE);
            mBuy=bundle.getString(BooksFragment.BOOK_BUY);
            mAuthor=bundle.getString(BooksFragment.BOOK_AUTHOR);
            mBookImage=bundle.getString(BooksFragment.BOOK_IMAGE);
            try {
                mRecc=new JSONObject(BooksFragment.BOOK_RECCS).getJSONArray("recommenders");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            bookNameTxtview.setText(mTitle);
            authorNameTxtview.setText(mAuthor);
            bookRecNoTxtView.setText(String.valueOf(mRecBookNo));
            Glide.with(BookDescription.this).load(mBookImage).into(bookImage);

        }



    }
}