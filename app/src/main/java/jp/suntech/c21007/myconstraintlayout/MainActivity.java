package jp.suntech.c21007.myconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btClick = findViewById(R.id.btSend);
        HelloListener listener = new HelloListener();   //リスナのインスタンス生成
        btClick.setOnClickListener(listener);           //ボタンにリスナを組み込む

        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(listener);
    }

    //リスナ・クラス <= イベントの監視
    private class HelloListener implements View.OnClickListener{

        //イベントハンドラ <= イベント発生時の処理
        @Override
        public void onClick(View view) {
            //名前入力欄であるEditTextオブジェクトを取得
            EditText input1 = findViewById(R.id.etName);
            EditText input2 = findViewById(R.id.etMail);
            EditText input3 = findViewById(R.id.etEmailtitle);
            EditText input4 = findViewById(R.id.etComment);
            //メッセージを送信するTextViewオブジェクトを取得
            TextView output = findViewById(R.id.btSend);

            //タップされた画面部品のidのR値を取得
            int id  = view.getId();
            //idのR値に応じて処理を分岐
            switch (id){
                //送信ボタンの場合・・・
                case R.id.btSend:
                    //入力された名前文字列を取得
                    String inputStr1 = input1.getText().toString();
                    String inputStr2 = input2.getText().toString();
                    String inputStr3 = input3.getText().toString();
                    String inputStr4 = input4.getText().toString();
                    //メッセージを表示
                    output.setText(inputStr1 + "\n" + inputStr2 + "\n" + inputStr3 + "\n" + inputStr4);
                    break;

                //クリアボタンの場合・・・
                case R.id.btClear:
                    input1.setText("");
                    input2.setText("");
                    input3.setText("");
                    input4.setText("");
                    output.setText("");
                    break;
            }

        }
    }
}