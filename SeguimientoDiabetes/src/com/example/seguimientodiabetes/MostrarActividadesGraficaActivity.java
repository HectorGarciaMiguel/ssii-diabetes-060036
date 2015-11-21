package com.example.seguimientodiabetes;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.seguimientodiabetes.seguimientodiabetes.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MostrarActividadesGraficaActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_actividades_grafica);
        
        GraphView graph = new GraphView(this);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                  new DataPoint(0, 1),
                  new DataPoint(1, 5),
                  new DataPoint(2, 3),
                  new DataPoint(3, 2),
                  new DataPoint(4, 6)
        });
        graph.addSeries(series);
        
        

            LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
            layout.addView(graph);

            TextView tv3=new TextView(getApplicationContext());
            tv3.setText("                ");
            layout.addView(tv3);
        
        
        
        
        
        
    }

}