package jroldan.acdat.listadetareas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String SERVIDOR = "http://159.65.61.233/";

    private Button btnAnadirTarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAnadirTarea = (Button)findViewById(R.id.btnAnadirTarea);
        btnAnadirTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}