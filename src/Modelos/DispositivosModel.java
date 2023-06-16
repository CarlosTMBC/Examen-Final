
package Modelos;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DispositivosModel {
Connection MyConexion;
ResultSet result;



public void Actualizar(int precio, String Dispositivos, String Marca, String tipo)
{
        try
        {
          Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.Conectar();
        Statement sentencia = MyConexion.createStatement();
        sentencia.executeQuery("Update Dispositivos23 set Dispositivo ="+"'"+Dispositivos+"',Marca="+"'"+Marca+"',Precio="+"'"+precio+"' where Tipo="+"'"+tipo+"'");
        }
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "No se pudo Actualizar..."+ex.getMessage());
        }
          
}

public void Guardar(int precio, String Dispositivos, String Marca, String Tipo)
{
    try
        {
          Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.Conectar();
        Statement sentencia = MyConexion.createStatement();
        sentencia.executeQuery("Insert into Dispositivos23 values("+"'"+Dispositivos+"',"+"'"+Marca+"',"+"'"+Tipo+"',"+"'"+precio+"')");
        }
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "No se pudo Guardar..."+ex.getMessage());
        }  
}

public DefaultTableModel ListarDatosConsulta(String consulta)
{
    DefaultTableModel TablaModelo = new DefaultTableModel();
    TablaModelo.setRowCount(0);
    TablaModelo.setColumnCount(0);
    
        
        TablaModelo.addColumn("Dispositivo");
        TablaModelo.addColumn("Marca");
        TablaModelo.addColumn("Tipo");
        TablaModelo.addColumn("Precio");


    try
    {
        Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.Conectar();
        Statement sentencia = MyConexion.createStatement();
        result = sentencia.executeQuery("select * from Dispositivos23 where Tipo like '"+consulta +"' order by Tipo asc");
        
        
            while(result.next())
            {
                TablaModelo.addRow(new Object[]{
                result.getString("Dispositivo"),
                result.getString("Marca"),
                result.getString("Tipo"),
                result.getInt("Precio")});
            }
        return TablaModelo;
    }
    
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, "No se Pudo Listar Empleados...."+e.getMessage());
    }
    return TablaModelo;
}
}
