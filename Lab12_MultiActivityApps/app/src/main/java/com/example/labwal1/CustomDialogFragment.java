package com.example.labwal1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class CustomDialogFragment extends DialogFragment {

    private IGradient grad;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        grad = (IGradient) context;
    }

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Окно фона главного окна")
                .setPositiveButton("Картинка",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        grad.Img();
                    }
                })
                .setNegativeButton("Градиент",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        grad.Paint();
                    }
                })
                .setNeutralButton("Стандартный фон",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        grad.Standart();
                    }
                })
                .create();
    }
}