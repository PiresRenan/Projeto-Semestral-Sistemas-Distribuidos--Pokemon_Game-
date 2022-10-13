package presenter;

import view.AdmWindow;

public class AdmUser {
    
    private AdmWindow janelaAdm;
    
    public AdmUser() {
        janelaAdm = new AdmWindow();
    }
    
    public void newPokemon() {
        janelaAdm.list.add("a", null);
    }
}
