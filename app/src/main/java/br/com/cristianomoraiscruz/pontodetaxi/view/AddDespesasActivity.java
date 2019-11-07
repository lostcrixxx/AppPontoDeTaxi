package br.com.cristianomoraiscruz.pontodetaxi.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.azimolabs.maskformatter.MaskFormatter;

import br.com.cristianomoraiscruz.pontodetaxi.R;
import br.com.cristianomoraiscruz.pontodetaxi.controller.Constants;

public class AddDespesasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_despesas);

//        MaskFormatter ibanMaskFormatter1 = new MaskFormatter(Constants.MASK_DATE, edtDate);
//        edtDate.addTextChangedListener(ibanMaskFormatter1);
    }
}
