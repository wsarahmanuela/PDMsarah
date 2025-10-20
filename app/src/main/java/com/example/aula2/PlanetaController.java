package com.example.aula2;
import java.util.ArrayList;

public class PlanetaController {
    PlanetaDAO planetaDAO;

    public void addPlaneta(Planeta planeta){

    }
    public ArrayList<Planeta> getPlanetas(){
        return planetaDAO.getPlanetas();
    }

    public ArrayList<String> getNomePlanetas(){
        ArrayList<String> nomes = new ArrayList<String>();
        for (Planeta planeta : planetaDAO.getPlanetas()){
            nomes.add(planeta.nome);
        }
        return nomes;
    }

}
