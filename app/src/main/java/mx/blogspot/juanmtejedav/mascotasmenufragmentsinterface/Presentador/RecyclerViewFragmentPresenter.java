package mx.blogspot.juanmtejedav.mascotasmenufragmentsinterface.Presentador;

import android.content.Context;

import java.util.ArrayList;

import mx.blogspot.juanmtejedav.mascotasmenufragmentsinterface.DB.ConstructorMascotas;
import mx.blogspot.juanmtejedav.mascotasmenufragmentsinterface.Fragments.IRecyclerViewFragmentView;
import mx.blogspot.juanmtejedav.mascotasmenufragmentsinterface.POJO.Mascota;

/**
 * Created by juantejeda1 on 20/08/16.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactosBD();
    }

    @Override
    public void obtenerContactosBD() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
