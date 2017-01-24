package mx.blogspot.juanmtejedav.mascotasmenufragmentsinterface.Fragments;

import java.util.ArrayList;

import mx.blogspot.juanmtejedav.mascotasmenufragmentsinterface.Adaptadores.MascotaAdaptador;
import mx.blogspot.juanmtejedav.mascotasmenufragmentsinterface.POJO.Mascota;

/**
 * Created by juantejeda1 on 20/08/16.
 */
public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador mascotaAdaptador);

}
