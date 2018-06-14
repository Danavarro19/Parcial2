/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concrete.Edifiacion;

import Abstract.Elemento;

/**
 *
 * @author intel
 */
public interface ManejadordeRecursos {
   
    Elemento generarRecurso(Enum Recurso);
    int generarRecurso();
    
}
