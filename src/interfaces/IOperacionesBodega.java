/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import modelo.bodegaDTO.Ikardex;
import modelo.operacionesDAO.KIngreso;

/**
 *
 * @author Ricky
 */
public interface IOperacionesBodega {
     void Registrar(KIngreso ingreso);
     void buscar(Ikardex codigo);
}
