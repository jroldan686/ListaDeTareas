package jroldan.acdat.listadetareas.ui;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import jroldan.acdat.listadetareas.MainActivity;
import jroldan.acdat.listadetareas.R;
import jroldan.acdat.listadetareas.fragments.DatePicketFragment;
import jroldan.acdat.listadetareas.model.Tarea;
import jroldan.acdat.listadetareas.network.ApiAdapter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener, Callback<Tarea>, DatePickerDialog.OnDateSetListener {
    public static final int OK = 1;

    @BindView(R.id.idTarea)
    TextView idTarea;
    @BindView(R.id.nombreTarea)
    EditText nombreTarea;
    @BindView(R.id.descripcionTarea)
    EditText descripcionTarea;
    @BindView(R.id.importanciaTarea)
    Spinner importanciaTarea;
    @BindView(R.id.finalizacionTarea)
    TextView finalizacionTarea;
    @BindView(R.id.enlaceTarea)
    EditText enlaceTarea;
    @BindView(R.id.imagenTarea)
    //Spinner imagenTarea;
    EditText imagenTarea;
    @BindView(R.id.accept)
    Button accept;
    @BindView(R.id.cancel)
    Button cancel;
    @BindView(R.id.btnElegirFecha)
    Button btnElegirFecha;
    //EditText nameSite, linkSite, emailSite;
    //TextView idSite;
    //Button accept, cancel;
    ProgressDialog progreso;
    Tarea t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        ButterKnife.bind(this);
        //idSite = (TextView) findViewById(R.id.idSite);
        //nameSite = (EditText) findViewById(R.id.nameSite);
        //linkSite = (EditText) findViewById(R.id.linkSite);
        //emailSite = (EditText) findViewById(R.id.emailSite);
        //accept = (Button) findViewById(R.id.accept);
        //cancel = (Button) findViewById(R.id.cancel);
        accept.setOnClickListener(this);
        cancel.setOnClickListener(this);
        btnElegirFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePicketFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        Intent i = getIntent();
        t = (Tarea) i.getSerializableExtra("tarea");
        idTarea.setText(String.valueOf(t.getId()));
        nombreTarea.setText(t.getNombre());
        descripcionTarea.setText(t.getDescripcion());
        importanciaTarea.setSelection(Integer.valueOf(t.getImportancia()) - 1);
        finalizacionTarea.setText(t.getFinalizacion());
        enlaceTarea.setText(t.getEnlace());
        //int inicio = MainActivity.RUTAIMG.length();
        //int fin = MainActivity.RUTAIMG.length() + 1;
        //imagenTarea.setSelection(Integer.valueOf(t.getImagen().substring(inicio, fin)) - 1);
        imagenTarea.setText(t.getImagen());
    }

    @Override
    public void onClick(View v) {
        String n, d, i, f, e, img;

        if (v == accept) {
            n = nombreTarea.getText().toString();
            d = descripcionTarea.getText().toString();
            i = importanciaTarea.getSelectedItem().toString();
            f = finalizacionTarea.getText().toString();
            e = enlaceTarea.getText().toString();
            //img = imagenTarea.getSelectedItem().toString();
            img = imagenTarea.getText().toString();
            if (n.isEmpty() || d.isEmpty())
                Toast.makeText(this, "Por favor, completa el nombre y la descripcion", Toast.LENGTH_SHORT).show();
            else {
                t.setNombre(n);
                t.setDescripcion(d);
                t.setImportancia(i);
                t.setFinalizacion(f);
                t.setEnlace(e);
                t.setImagen(img);
                connection(t);
            }
        }
        if (v == cancel)
            finish();
    }

    private void connection(Tarea t) {
        progreso = new ProgressDialog(this);
        progreso.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progreso.setMessage("Conectando . . .");
        progreso.setCancelable(false);
        progreso.show();

        Call<Tarea> call = ApiAdapter.getInstance().updateTarea(t, t.getId());
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Tarea> call, Response<Tarea> response) {
        progreso.dismiss();
        if (response.isSuccessful()) {
            Tarea tarea = response.body();
            Intent i = new Intent();
            Bundle mBundle = new Bundle();
            mBundle.putInt("id", tarea.getId());
            mBundle.putString("nombre", tarea.getNombre());
            mBundle.putString("descripcion", tarea.getDescripcion());
            mBundle.putString("importancia", tarea.getImportancia());
            mBundle.putString("finalizacion", tarea.getFinalizacion());
            mBundle.putString("enlace", tarea.getEnlace());
            mBundle.putString("imagen", tarea.getImagen());
            i.putExtras(mBundle);
            setResult(OK, i);
            finish();
            showMessage("Tarea modificada con exito");
        } else {
            StringBuilder message = new StringBuilder();
            message.append("Error de descarga: " + response.code());
            if (response.body() != null)
                message.append("\n" + response.body());
            if (response.errorBody() != null)
                try {
                    message.append("\n" + response.errorBody().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            showMessage(message.toString());
        }
    }

    @Override
    public void onFailure(Call<Tarea> call, Throwable t) {
        progreso.dismiss();
        if (t != null)
            showMessage("Fallo en la comunicacion\n" + t.getMessage());
    }

    private void showMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        finalizacionTarea.setText(String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime())));
    }
}