package Controladores;

import Modelos.*;
import Vistas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author umg
 */
public class DispositivosController implements ActionListener, MouseListener{
 frmPrincipal VistaPrincipal;
 frmDispositivos VistaDispositivos;
  frmConsulta VistaConsulta;
 
 DispositivosModel ModeloEmpleado;
 
    

    public DispositivosController( frmPrincipal VistaPrincipal, frmDispositivos VistaEmpleados,frmConsulta VistaConsulta,DispositivosModel ModeloEmpleado) {
        this.VistaPrincipal = VistaPrincipal;
        this.VistaDispositivos = VistaEmpleados;
        this.VistaConsulta = VistaConsulta;
        this.ModeloEmpleado = ModeloEmpleado;
        
        /*LEVANTAR LAS VISTAS*/
      
      
      /*PONER A LA ESCUCHA LOS BOTONES*/
      this.VistaDispositivos.btnGuardar.addActionListener(this);
      this.VistaConsulta.btnEditar.addActionListener(this);
      this.VistaPrincipal.opcAgregar.addActionListener(this);
      this.VistaPrincipal.opcEditar.addActionListener(this);
      this.VistaConsulta.btnBuscar.addActionListener(this);
      this.VistaConsulta.tablaConsulta.addMouseListener(this);
        
        /*LEVANTAR LA VISTA EMPLEADOR*/
      this.VistaPrincipal.setExtendedState(frmPrincipal.MAXIMIZED_BOTH);
      this.VistaPrincipal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.VistaPrincipal.opcAgregar)
        {
            this.VistaDispositivos.setLocationRelativeTo(null);
            this.VistaDispositivos.setVisible(true);
        }
        if(e.getSource() == this.VistaPrincipal.opcEditar)
        {
            this.VistaConsulta.setLocationRelativeTo(null);
            this.VistaConsulta.setVisible(true);
        }
        if(e.getSource() == this.VistaConsulta.btnBuscar)
        {
            DefaultTableModel TablaModelo2 = this.ModeloEmpleado.ListarDatosConsulta(this.VistaConsulta.txtConsulta.getText());
                this.VistaConsulta.tablaConsulta.setModel(TablaModelo2);
        }
        
        if(e.getSource() == this.VistaConsulta.btnEditar)
        {
            this.ModeloEmpleado.Actualizar(Integer.parseInt(this.VistaConsulta.txt3.getText()),
                    this.VistaConsulta.txt0.getText(),
                    this.VistaConsulta.txt1.getText(),
                    this.VistaConsulta.txt2.getText());
            
            DefaultTableModel TablaModelo2 = this.ModeloEmpleado.ListarDatosConsulta(this.VistaConsulta.txtConsulta.getText());
                this.VistaConsulta.tablaConsulta.setModel(TablaModelo2);
            
            
            
        }
        if (e.getSource() == this.VistaDispositivos.btnGuardar) {
            this.ModeloEmpleado.Guardar(Integer.parseInt(this.VistaDispositivos.txtPrecio.getText()),
                    this.VistaDispositivos.txtDispositivo.getText(),
                    this.VistaDispositivos.txtMarca.getText(),
                    this.VistaDispositivos.txtTipo.getText());
            
            this.VistaDispositivos.txtDispositivo.setText("");
            this.VistaDispositivos.txtMarca.setText("");
            this.VistaDispositivos.txtTipo.setText("");
            this.VistaDispositivos.txtPrecio.setText("");
        }
        
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int fila;
        if(e.getSource()==this.VistaConsulta.tablaConsulta)
        {
            fila = this.VistaConsulta.tablaConsulta.getSelectedRow();
            this.VistaConsulta.txt0.setText(this.VistaConsulta.tablaConsulta.getValueAt(fila, 0).toString());
            
            fila = this.VistaConsulta.tablaConsulta.getSelectedRow();
            this.VistaConsulta.txt1.setText(this.VistaConsulta.tablaConsulta.getValueAt(fila, 1).toString());
            
            fila = this.VistaConsulta.tablaConsulta.getSelectedRow();
            this.VistaConsulta.txt2.setText(this.VistaConsulta.tablaConsulta.getValueAt(fila, 2).toString());
            
            fila = this.VistaConsulta.tablaConsulta.getSelectedRow();
            this.VistaConsulta.txt3.setText(this.VistaConsulta.tablaConsulta.getValueAt(fila, 3).toString());
        }
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        
    }

}
