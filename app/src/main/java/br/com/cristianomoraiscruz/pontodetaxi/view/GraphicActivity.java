package br.com.cristianomoraiscruz.pontodetaxi.view;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

import br.com.cristianomoraiscruz.pontodetaxi.R;
import br.com.cristianomoraiscruz.pontodetaxi.database.Database;

public class GraphicActivity extends AppCompatActivity{

    private BarChart barChart;
    Database db = new Database();

    float valueMensal, valueDespesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_barchart);

        barChart = findViewById(R.id.chart);

        valueMensal = Float.parseFloat(String.valueOf(db.getMensalidadeTotal(this)));
        valueDespesa = Float.parseFloat(String.valueOf(db.getDespesaTotal(this)));

        BarDataSet barDataSet1 = new BarDataSet(barEntries1(), "Mensalidade");
        barDataSet1.setColor(Color.BLUE);

        BarDataSet barDataSet2 = new BarDataSet(barEntries2(), "Despesas");
        barDataSet2.setColor(Color.RED);

        BarData data = new BarData(barDataSet1, barDataSet2);
        barChart.setData(data);

//        String[] days = new String[] {"2020", "Jan", "Fev", "Ter", "Qua", "Qui", "Sex", "Sáb"};

        XAxis xAxis = barChart.getXAxis();

//        xAxis.setValueFormatter(new IndexAxisValueFormatter(days));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);

        barChart.setDragEnabled(true);
        barChart.setVisibleXRangeMaximum(1);

        float barSpace = 0.08f;
        float groupSpace = 0.44f;

        data.setBarWidth(0.10f);
        barChart.getXAxis().setAxisMinimum(0);
        barChart.getXAxis().setAxisMaximum(0 + barChart.getBarData().getGroupWidth(groupSpace,barSpace)*7);

//        barChart.getAxisLeft().setAxisMinimum(0);

        barChart.groupBars(0, groupSpace, barSpace);

        barChart.invalidate();

    }

    private ArrayList<BarEntry>barEntries1(){
        ArrayList<BarEntry>barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, valueMensal));
        return barEntries;
    }

    private ArrayList<BarEntry>barEntries2(){
        ArrayList<BarEntry>barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 2000));

        return barEntries;
    }
}
