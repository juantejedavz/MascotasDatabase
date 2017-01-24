package mx.blogspot.juanmtejedav.mascotasmenufragmentsinterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;

import java.util.ArrayList;

import mx.blogspot.juanmtejedav.mascotasmenufragmentsinterface.Adaptadores.MascotaAdaptador;
import mx.blogspot.juanmtejedav.mascotasmenufragmentsinterface.Fragments.IRecyclerViewFragmentView;
import mx.blogspot.juanmtejedav.mascotasmenufragmentsinterface.Fragments.RecyclerViewFragment;
import mx.blogspot.juanmtejedav.mascotasmenufragmentsinterface.POJO.Mascota;
import mx.blogspot.juanmtejedav.mascotasmenufragmentsinterface.Presentador.IRecyclerViewFragmentPresenter;
import mx.blogspot.juanmtejedav.mascotasmenufragmentsinterface.Presentador.RecyclerViewFragmentPresenter;

/**
 * Created by juantejeda1 on 06/08/16.
 */
public class MascotasFav extends AppCompatActivity implements IRecyclerViewFragmentView {

    ArrayList<Mascota> mascotasFav;
    Toolbar miActionBar;
    private RecyclerView listaMascotasFav;
    private LinearLayoutManager llm;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascota_fav);

        toolbar(miActionBar);

        listaMascotasFav = (RecyclerView) findViewById(R.id.rvMascotasFav);

        // layoutSetting();
        // inicializarVistasFav();
        // inicializarAdaptador();

        presenter = new RecyclerViewFragmentPresenter(this, MascotasFav.this);
    }

    public void layoutSetting() {
        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasFav.setLayoutManager(llm);
    }

    public void inicializarVistasFav() {
        mascotasFav = new ArrayList<Mascota>();
        for (Mascota mascota : RecyclerViewFragment.mascotas) {
            if (mascota.getLikes() > 0) {
                mascotasFav.add(mascota);
            }
        }
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adapter = new MascotaAdaptador(mascotasFav);
        listaMascotasFav.setAdapter(adapter);
    }


    public void toolbar(Toolbar miActionBar) {
        miActionBar = (Toolbar) findViewById(R.id.toolB2);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void generarLinearLayoutVertical() {
        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasFav.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotas);
        return mascotaAdaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador mascotaAdaptador) {
        listaMascotasFav.setAdapter(mascotaAdaptador);
    }
}

