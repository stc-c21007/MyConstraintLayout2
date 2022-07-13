package jp.suntech.c21007.myconstraintlayout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import jp.suntech.c21007.myconstraintlayout.R;

public class OrderConfirmDialogFragment extends DialogFragment {
    private String tosttext;

    OrderConfirmDialogFragment(String tosttext){
        this.tosttext = tosttext;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //ダイアログビルダーを生成
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //タイトルを設定
        builder.setTitle(R.string.dialog_title);
        //メッセージを設定
        builder.setMessage(R.string.dialog_msg);
        //Positive Buttonを設定
        builder.setPositiveButton(R.string.dialog_btn_ok, new DialogButtonClickListener());
        //Negative Buttonを設定
        builder.setNegativeButton(R.string.dialog_btn_ng, new DialogButtonClickListener());
        //Neutral Buttonを設定
        //ダイアログオブジェクトを生成し、リターン
        AlertDialog dialog = builder.create();
        return dialog;
    }
    //ダイアログのアクションボタンがタップされたときの処理が記述されたメンバクラス
    public class DialogButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which){
            //タップされたアクションボタンで分岐
            switch (which){
                //Positive Buttonならば
                case DialogInterface.BUTTON_POSITIVE:
                    //トーストの表示
                    Toast.makeText(getActivity(), tosttext, Toast.LENGTH_LONG).show();
                    break;
                //Negative Buttonならば
                case DialogInterface.BUTTON_NEGATIVE:
                    break;
            }

        }
    }
}