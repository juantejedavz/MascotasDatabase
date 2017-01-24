package mx.blogspot.juanmtejedav.mascotasmenufragmentsinterface.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.blogspot.juanmtejedav.mascotasmenufragmentsinterface.Adaptadores.MascotaAdaptador;
import mx.blogspot.juanmtejedav.mascotasmenufragmentsinterface.POJO.Mascota;
import mx.blogspot.juanmtejedav.mascotasmenufragmentsinterface.Presentador.IRecyclerViewFragmentPresenter;
import mx.blogspot.juanmtejedav.mascotasmenufragmentsinterface.Presentador.RecyclerViewFragmentPresenter;
import mx.blogspot.juanmtejedav.mascotasmenufragmentsinterface.R;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {

    public static ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    public RecyclerViewFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        //inicializarDatos();

        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        return v;
    }

    public void inicializarDatos() {

    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotas);
        return mascotaAdaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador mascotaAdaptador) {
        rvMascotas.setAdapter(mascotaAdaptador);
    }
}
