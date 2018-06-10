/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Abstract.Edificacion;
import static Abstract.Recurso.*;
import Concrete.Edifiacion.GeneradorRecurso;
import Concrete.Edifiacion.RecolectorRecurso;
import java.util.ArrayList;

/**
 *
 * @author intel
 */
public class Territorio {
    
    public static ArrayList<GeneradorRecurso> generadoresRecurso1= new ArrayList<>();
    public static ArrayList<GeneradorRecurso> generadoresRecurso2= new ArrayList<>();
    public static ArrayList<RecolectorRecurso> recolectores= new ArrayList<>();
    public static ArrayList<GeneradorRecurso> cuarteles= new ArrayList<>();
    
    public void agregarEdificacio(Edificacion edificacion){
        switch (edificacion.getTipo()){
        
            case GENERADOR_DE_RECURSOS:
                GeneradorRecurso generador = (GeneradorRecurso) edificacion;
                if (generador.getRecurso()==RECURSO1)
                    generadoresRecurso1.add(generador);
                else if (generador.getRecurso()==RECURSO2)
                    generadoresRecurso2.add(generador);
                else
                   cuarteles.add(generador);
                break;
                
            case REOLECTOR_DE_RECURSOS:
                break;    
        }
    }
    
    public void generarRecurso(){
        for (GeneradorRecurso generador: generadoresRecurso1){ 
            generador.generarRecurso();
        }
    }
    
    public void turnoTerritorio(){
        
    }
    
    
}
