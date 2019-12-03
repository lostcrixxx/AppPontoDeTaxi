package br.com.cristianomoraiscruz.pontodetaxi.view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

import br.com.cristianomoraiscruz.pontodetaxi.R;

public class GraphicActivity extends AppCompatActivity {

    BarChart mpBarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic);
        mpBarChart = findViewById(R.id.chart1);

        BarDataSet barDataSet1 = new BarDataSet(barEntries1(), "DataSet1");
        barDataSet1.setColor(Color.RED);

        BarData data = new BarData(barDataSet1);
        mpBarChart.setData(data);

        String[] days = new String[]{"Sunday"};
        XAxis xAxis = mpBarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(days));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);

        mpBarChart.setDragEnabled(true);
        mpBarChart.setVisibleXRangeMaximum(3);

        float barSpace = 0.08f;
        float groupSpace= 0.44f;
        data.setBarWidth(0.10f);

        mpBarChart.getXAxis().setAxisMinimum(0);
        mpBarChart.getXAxis().setAxisMaximum(0+mpBarChart.getBarData().getGroupWidth(groupSpace, barSpace)*4);
        mpBarChart.getAxisLeft().setAxisMinimum(0);

        mpBarChart.groupBars(0,groupSpace, barSpace);

        mpBarChart.invalidate();
    }

    private ArrayList<BarEntry> barEntries1(){
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1,2000));
        barEntries.add(new BarEntry(2,791));
        barEntries.add(new BarEntry(3,630));
        barEntries.add(new BarEntry(4,782));
    return barEntries;
    }
}
