package com.example.aula2;
import java.util.ArrayList;

public class PlanetaController {
    PlanetaDao planetaDao;

    public void addPlaneta(Planeta planeta){

    }
    public ArrayList<Planeta> getPlanetas(){
        return planetaDao.getPlaneta();
    }

    public ArrayList<String> getNomePlanetas(){
        ArrayList<String> nomes = new ArrayList<String>();
        for (Planeta planeta : planetaDao.getPlanetas()){
            nomes.add(planeta.nome);
        }
        return nomes;
    }

}
