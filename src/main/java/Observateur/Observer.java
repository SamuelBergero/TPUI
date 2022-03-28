package Observateur;

import java.util.ArrayList;

public class Observer {
    private ArrayList<Observateur> observateurs = new ArrayList<Observateur>();

    public void notifyAll(Object o){
        observateurs.forEach(x->x.update(o));
    }

    public void observeBy(Observateur o){
        observateurs.add(o);
    }
}
