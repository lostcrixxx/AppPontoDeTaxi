package br.com.cristianomoraiscruz.pontodetaxi.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import br.com.cristianomoraiscruz.pontodetaxi.R;

public class DetranActivity extends AppCompatActivity {

    private final String TAG = "Detran";

    private TextView txtSite;
    private String tmpSite;
    private Spinner spinnerUF;
    private String[] ListUFs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detran);

        txtSite = findViewById(R.id.txtSiteDetran);
        ListUFs = getResources().getStringArray(R.array.ufs);
        initSpinnerUF();
    }

    private void initSpinnerUF() {

//        branchesList = getmResolver().getBranches();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ListUFs);
//        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getNamesFromList(ListUFs));

        spinnerUF = (SearchableSpinner) findViewById(R.id.spinnerUF);
        spinnerUF.setAdapter(arrayAdapter);

//        fixErrorSpinner(spinnerUF); // fixo duplo clique no spinner

        spinnerUF.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Log.d(TAG, ListUFs[position]);
                tmpSite = "http://www.detran." + ListUFs[position] + ".gov.br";
                txtSite.setText(tmpSite);

                if (view != null) {
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        txtSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(tmpSite));
                startActivity(intent);
            }
        });
    }
}
