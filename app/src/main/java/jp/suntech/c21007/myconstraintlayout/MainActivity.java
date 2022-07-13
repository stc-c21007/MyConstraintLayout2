package jp.suntech.c21007.myconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btSend = findViewById(R.id.btSend);
        HelloListener listener = new HelloListener();   //リスナのインスタンス生成
        btSend.setOnClickListener(listener);           //ボタンにリスナを組み込む

        Button btConfirm = findViewById(R.id.btConfirm);
        btConfirm.setOnClickListener(listener);

        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(listener);
    }

    //リスナ・クラス <= イベントの監視
    private class HelloListener implements View.OnClickListener{

        //イベントハンドラ <= イベント発生時の処理
        @Override
        public void onClick(View view) {
            //トーストメッセージ用文字列変数を用意
            String msg = "";
            //名前入力欄であるEditTextオブジェクトを取得
            EditText input1 = findViewById(R.id.etName);
            EditText input2 = findViewById(R.id.etMail);
            EditText input3 = findViewById(R.id.etEmailtitle);
            EditText input4 = findViewById(R.id.etComment);
            //メッセージを送信するTextViewオブジェクトを取得
            TextView output = findViewById(R.id.btSend);

            //タップされた画面部品のidのR値を取得
            int id  = view.getId();

            String inputStr1 = input1.getText().toString();
            String inputStr2 = input2.getText().toString();
            String inputStr3 = input3.getText().toString();
            String inputStr4 = input4.getText().toString();

            String toastText = "名前：" + inputStr1 + "\nメールアドレス：" + inputStr2 + "\nタイトル：" + inputStr3 + "\n質問内容：" + inputStr4;

            //idのR値に応じて処理を分岐
            switch (id){
                //確認ボタンの場合・・・
                case R.id.btConfirm:
                    //メッセージを表示
                    //注文確認ダイアログフラグメントオブジェクトを生成
                    OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment(toastText);
                    //ダイアログ表示
                    dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragment");
//                    Toast.makeText(MainActivity.this, toastText, Toast.LENGTH_LONG).show();
                    break;

                //送信ボタンの場合・・・
                case R.id.btSend:
                    //メッセージを表示
                    Toast.makeText(MainActivity.this, toastText, Toast.LENGTH_LONG).show();
                    break;

                //クリアボタンの場合・・・
                case R.id.btClear:
                    input1.setText("");
                    input2.setText("");
                    input3.setText("");
                    input4.setText("");
                    break;
            }

        }
    }
}