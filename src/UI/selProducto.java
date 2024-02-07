/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BEAN.DetVenta;
import BEAN.Producto;
import DAO.DetVentaDAO;
import DAO.ProductoDAO;
import UTIL.Util;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup; //para agrupar los botones circulares
import javax.swing.JFrame;

/**
 *
 * @author James
 */
public class selProducto extends javax.swing.JFrame {

    /**
     * Creates new form selProducto
     */
    DetVentaDAO dvd = new DetVentaDAO();
    DefaultTableModel dtm,dtmt;
    ProductoDAO proDAO;
    DetVentaDAO detVDAO;
    public selProducto() {
        initComponents();
        proDAO = new ProductoDAO();
        detVDAO = new DetVentaDAO();
        dtm = (DefaultTableModel)this.tblCompra_Venta.getModel();
        dtmt = (DefaultTableModel)this.tblCompra_Venta.getModel();
        llenaTablaVC(false, "");
        
        //===============================================
            rbnCompra.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    llenaTablaVC(false, ""); // Llena la tabla con datos de compra
                }
            }
        });
        
            rbnVenta.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    llenaTablaVC(true, ""); // Llena la tabla con datos de venta
                }
            }
        });
        
            btnRegistrarCompra.addActionListener(new ActionListener() {
                @Override
             public void actionPerformed(ActionEvent e) {
                 // Crear una instancia del JFrame selCompra
                 selCompra compraFrame = new selCompra();

                 // Hacer visible el nuevo JFrame
                 compraFrame.setVisible(true);

                 // Cerrar el JFrame actual
                 dispose(); // Opcional, cierra el JFrame actual si no lo necesitas más
             }
        });
             btnRegistrarVenta.addActionListener(new ActionListener() {
                @Override
             public void actionPerformed(ActionEvent e) {
                 // Crear una instancia del JFrame selCompra
                 selVenta compraFrame = new selVenta();

                 // Hacer visible el nuevo JFrame
                 compraFrame.setVisible(true);

                 // Cerrar el JFrame actual
                 dispose(); // Opcional, cierra el JFrame actual si no lo necesitas más
             }
        });
             btnCategoria.addActionListener(new ActionListener() {
                @Override
             public void actionPerformed(ActionEvent e) {
                 // Crear una instancia del JFrame selCompra
                 frmCategoria compraFrame = new frmCategoria();

                 // Hacer visible el nuevo JFrame
                 compraFrame.setVisible(true);

                 // Cerrar el JFrame actual
                 dispose(); // Opcional, cierra el JFrame actual si no lo necesitas más
             }
        });
            
           
        //==============================================    
    }
    
    private void llenaTablaVC(boolean sw, String Cod) {
    // Lógica para llenar la tabla según el valor de sw
        if (sw) {
            // Llena la tabla con datos de venta
            Vector<DetVenta> LisT = detVDAO.ListaItem(sw, Cod);
            dtm.setRowCount(0); // Limpiar la tabla antes de llenarla con nuevos datos

            for (int i = 0; i < LisT.size(); i++) {
                Vector vec = new Vector();

                vec.addElement(LisT.get(i).getIdVenta());
                vec.addElement(LisT.get(i).getDescripcion());
                vec.addElement(LisT.get(i).getPrecioVenta());
                vec.addElement(LisT.get(i).getCantidadv());
                vec.addElement(LisT.get(i).getCostoTotal());
                vec.addElement(LisT.get(i).getFecha());
                dtm.addRow(vec); // Agrega una la fila a la tabla
            }
            sumVenta(); // Calcula la suma de las ventas

        } 
        else {
            // Llenar la tabla con datos de compra
            Vector<Producto> listaProd = proDAO.listaProductos(sw, Cod);
            dtmt.setRowCount(0); // Limpiar la tabla antes de llenarla con nuevos datos

            for (int i = 0; i < listaProd.size(); i++) {
                Vector vec = new Vector();
                // Agregar los datos de Producto a la fila
                vec.addElement(listaProd.get(i).getIdProducto());
                vec.addElement(listaProd.get(i).getNombreProducto());
                vec.addElement(listaProd.get(i).getPrecioProducto());
                vec.addElement(listaProd.get(i).getCantidad());
                vec.addElement(listaProd.get(i).getCostoTotal());
                vec.addElement(listaProd.get(i).getFecha());
                dtmt.addRow(vec); // Agregar la fila a la tabla
            }
            sumCompra(); // Calcula la suma de las compras

        }
    }
    
    
 
    //una funcion para traer la suma de los costos de la compra o de la venta
    private void sumVenta(){
        Util util = new Util();
        String saleSuma = util.obtenerSumaV();
        txtTotalCompra_Venta.setText(saleSuma);
    }
    
    private void sumCompra(){
        Util util = new Util();
        String saleSumaC = util.obtenerSuma();
        txtTotalCompra_Venta.setText(saleSumaC);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel1 = new java.awt.Panel();
        btnRegistrarCompra = new java.awt.Button();
        btnRegistrarVenta = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompra_Venta = new javax.swing.JTable();
        btnExportExcel = new java.awt.Button();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new java.awt.Button();
        label1 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTotalCompra_Venta = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        rbnCompra = new javax.swing.JRadioButton();
        rbnVenta = new javax.swing.JRadioButton();
        btnCategoria = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));

        btnRegistrarCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarCompra.setLabel("REGISTRAR COMPRA");
        btnRegistrarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCompraActionPerformed(evt);
            }
        });

        btnRegistrarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarVenta.setLabel("REGISTRAR   VENTA");
        btnRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVentaActionPerformed(evt);
            }
        });

        tblCompra_Venta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Precio", "Cantidad", "Costo Total", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCompra_Venta);

        btnExportExcel.setLabel("EXPORTAR EXCEL");
        btnExportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportExcelActionPerformed(evt);
            }
        });

        btnBuscar.setLabel("BUSCAR");

        label1.setVisible(false);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 24)); // NOI18N
        jLabel1.setText("GESTIÓN DE COMPRA-VENTA");

        jLabel7.setText("TOTAL S/");

        jPanel2.setLayout(null);

        buttonGroup1.add(rbnCompra);
        rbnCompra.setSelected(true);
        rbnCompra.setText("COMPRA");
        rbnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnCompraActionPerformed(evt);
            }
        });
        jPanel2.add(rbnCompra);
        rbnCompra.setBounds(10, 10, 90, 23);

        buttonGroup1.add(rbnVenta);
        rbnVenta.setText("VENTA");
        jPanel2.add(rbnVenta);
        rbnVenta.setBounds(110, 10, 80, 23);

        btnCategoria.setText("categorias");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCategoria))
                        .addGap(51, 51, 51)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(btnExportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalCompra_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(641, 641, 641))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(btnRegistrarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)
                                .addComponent(btnRegistrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92)
                                .addComponent(btnCategoria))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTotalCompra_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnExportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(51, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel2.getAccessibleContext().setAccessibleName("Seleccionar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 947, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbnCompraActionPerformed

    private void btnExportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportExcelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportExcelActionPerformed

    private void btnRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarVentaActionPerformed

    private void btnRegistrarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCompraActionPerformed
        // TODO add your handling code here:
    
    }//GEN-LAST:event_btnRegistrarCompraActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(selProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(selProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(selProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(selProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new selProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnBuscar;
    private javax.swing.JButton btnCategoria;
    private java.awt.Button btnExportExcel;
    private java.awt.Button btnRegistrarCompra;
    private java.awt.Button btnRegistrarVenta;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Panel panel1;
    private javax.swing.JRadioButton rbnCompra;
    private javax.swing.JRadioButton rbnVenta;
    private javax.swing.JTable tblCompra_Venta;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtTotalCompra_Venta;
    // End of variables declaration//GEN-END:variables
}
