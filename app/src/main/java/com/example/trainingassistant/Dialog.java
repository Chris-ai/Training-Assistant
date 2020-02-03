package com.example.trainingassistant;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;


public class Dialog extends AppCompatDialogFragment {

    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("BroFistStudio")
                .setMessage("Jesteśmy zespołem początkujących programistów, chcących podzielić się rezultatami swojej pracy.\n" +
                        "Dziękujemy za pobranie naszej aplikacji!\n" +
                        "Ikony użyte w aplikacji zostały pobrane ze stron:\nicons8.com\nFlaticon.com")
                .setPositiveButton("Zamknij", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
         return builder.create();
    }
}
