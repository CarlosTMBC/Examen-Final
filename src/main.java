
import Controladores.DispositivosController;
import Modelos.DispositivosModel;
import Vistas.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author umg
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        frmPrincipal VistaPrincipal = new frmPrincipal();
        DispositivosModel ModeloEmpleados = new DispositivosModel();
        frmDispositivos VistaEmpleados = new frmDispositivos(VistaPrincipal,true);
        frmConsulta VistaConsulta = new frmConsulta(VistaPrincipal,true);
        
        DispositivosController ControladorEmpleados = new DispositivosController(VistaPrincipal,VistaEmpleados,VistaConsulta,ModeloEmpleados);
        
    }
    
}
