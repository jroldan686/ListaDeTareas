package jroldan.acdat.listadetareas.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import jroldan.acdat.listadetareas.R;
import jroldan.acdat.listadetareas.model.Tarea;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TareasAdapter extends RecyclerView.Adapter<TareasAdapter.ViewHolder> {
    public ArrayList<Tarea> mTareas;

    public TareasAdapter(){
        this.mTareas = new ArrayList<>();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imvImagen) ImageView imagen;
        @BindView(R.id.txvNombre) TextView nombre;
        @BindView(R.id.txvDescripcion) TextView descripcion;
        @BindView(R.id.txvFinalizacion) TextView finalizacion;
        @BindView(R.id.txvImportancia) TextView importancia;
        //private TextView name, link;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            //name = (TextView) itemView.findViewById(R.id.textView1);
            //link = (TextView) itemView.findViewById(R.id.textView2);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        // Inflate the custom layout
        LayoutInflater inflater = LayoutInflater.from(context);
        View siteView = inflater.inflate(R.layout.item_view, parent, false);

        // Return a new holder instance
        return new ViewHolder(siteView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Tarea tarea = mTareas.get(position);

        if(!(tarea.getImagen() == null || tarea.getImagen().isEmpty()))
            holder.imagen.setImageURI(Uri.parse(tarea.getImagen()));
        holder.nombre.setText(tarea.getNombre());
        holder.descripcion.setText(tarea.getDescripcion());
        if(tarea.getFinalizacion() == null || tarea.getFinalizacion().isEmpty())
            holder.finalizacion.setText("Fecha no asignada");
        else {
            try {
                SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
                Date date = d.parse(tarea.getFinalizacion());
                holder.finalizacion.setText(DateFormat.getDateInstance().format(date));
            } catch (Exception e) {
                holder.finalizacion.setText(e.getMessage());
            }
        }
        holder.importancia.setText("Importancia: " + tarea.getImportancia());
    }

    public void setTareas(ArrayList<Tarea> tareas) {
        mTareas = tareas;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mTareas.size();
    }

    public Tarea getAt(int position){
        Tarea tarea;
        tarea = this.mTareas.get(position);
        return tarea;
    }

    public void add(Tarea tarea) {
        this.mTareas.add(tarea);
        notifyItemInserted(mTareas.size() - 1);
        notifyItemRangeChanged(0, mTareas.size() - 1);
    }

    public void modifyAt(Tarea tarea, int position) {
        this.mTareas.set(position, tarea);
        notifyItemChanged(position);
    }

    public void removeAt(int position) {
        this.mTareas.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(0, mTareas.size() - 1);
    }
}
