/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BEAN.Categoria;
import DAO.CategoriaDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author James
 */
public class selCategorias extends javax.swing.JDialog {
    DefaultTableModel dtm;
    CategoriaDAO cateDAO;
    Categoria cate;
    public selCategorias(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        cate = new Categoria();
        cateDAO = new CategoriaDAO();
        initComponents();
        dtm = (DefaultTableModel) this.tblProductos.getModel();
        llenaTblCategoria(false, "");
        
    }

    private void llenaTblCategoria(boolean sw, String Cod) {
        Vector<Categoria> listaCate;
        listaCate = cateDAO.listaCategoria(sw, Cod);
        dtm.setRowCount(0);
        for (int i = 0; i < listaCate.size(); i++)
        {
            Vector vec = new Vector();
            vec.addElement(listaCate.get(i).getIdCategoria());
            vec.addElement(listaCate.get(i).getNameCategoria());
            vec.addElement(listaCate.get(i).getDescripcion());
            dtm.addRow(vec);
        }

    }
    public Categoria getCate() {
        return cate;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel1.setText("Buscar");

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdCategoria", "Nombre", "Descripcion"
            }
        ));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        jLabel2.setText("BUSQUEDA DE CATEGORIAS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        if (this.txtBuscar.getText().isEmpty())
        {
            llenaTblCategoria(false, "");
        } else
        {
            llenaTblCategoria(true, this.txtBuscar.getText());
        }
        int idi;
        idi = this.tblProductos.getSelectedRow();
        cate.setIdCategoria(Integer.parseInt(dtm.getValueAt(idi, 0).toString()));
        cate.setNameCategoria(dtm.getValueAt(idi, 1).toString());

        this.dispose();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        // TODO add your handling code here:
        int i;
        i = this.tblProductos.getSelectedRow();
        cate.setIdCategoria(Integer.parseInt(dtm.getValueAt(i, 0).toString()));
        cate.setNameCategoria(dtm.getValueAt(i, 1).toString());

        this.dispose();
    }//GEN-LAST:event_tblProductosMouseClicked

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
