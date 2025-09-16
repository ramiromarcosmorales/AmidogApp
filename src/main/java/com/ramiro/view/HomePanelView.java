/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.ramiro.view;

import com.ramiro.utils.Services;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Usuario
 */
public class HomePanelView extends javax.swing.JPanel {
    private final Services services;
    /**
     * Creates new form HomePanelView
     */
    public HomePanelView(Services services) {
        this.services = services;
        initComponents();
        refreshStats();
        
        setOpaque(false);
        
        final java.awt.Color HEADER_BG = new java.awt.Color(0x1E,0x1E,0x1E);
        final java.awt.Color HEADER_FG = new java.awt.Color(224,224,224);

        javax.swing.table.JTableHeader th = tableProxTurnos.getTableHeader();
        th.setDefaultRenderer(new javax.swing.table.DefaultTableCellRenderer() {
        private final javax.swing.border.EmptyBorder pad = new javax.swing.border.EmptyBorder(8,12,8,12);
        @Override
        public java.awt.Component getTableCellRendererComponent(
            javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setOpaque(true);
        setBackground(HEADER_BG);
        setForeground(HEADER_FG);
        setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13));
        setBorder(pad);
        setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        return this;
        }
    });
    th.setReorderingAllowed(false);
    th.setPreferredSize(new java.awt.Dimension(th.getWidth(), 36));
    
    // --- Hacer NO editable la tabla (sin deshabilitarla visualmente) ---
    tableProxTurnos.setDefaultEditor(Object.class, null); // bloquea edición de todas las celdas

    // --- Header (títulos de columnas) ---
    JTableHeader h = tableProxTurnos.getTableHeader();
    h.setReorderingAllowed(false);
    h.setPreferredSize(new java.awt.Dimension(h.getWidth(), 36));
    h.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13));
    h.setForeground(new java.awt.Color(224,224,224));
    h.setBackground(new java.awt.Color(0x1E, 0x1E, 0x1E)); // #1E1E1E
    h.setOpaque(true);

    // --- Colores y estilo de filas (mantenemos el color que ya tenías) ---
    final java.awt.Color ROW_BG = new java.awt.Color(48,51,54);   // mismo color de filas
    final java.awt.Color ROW_FG = new java.awt.Color(190,195,199);
    final java.awt.Color ROW_SEL_BG = new java.awt.Color(58,62,66);
    final java.awt.Color ROW_SEL_FG = java.awt.Color.WHITE;

    tableProxTurnos.setRowHeight(36);
    tableProxTurnos.setShowHorizontalLines(false);
    tableProxTurnos.setShowVerticalLines(false);
    tableProxTurnos.setIntercellSpacing(new java.awt.Dimension(0, 8));
    tableProxTurnos.setBackground(ROW_BG);
    tableProxTurnos.setForeground(ROW_FG);

    javax.swing.table.DefaultTableCellRenderer base = new javax.swing.table.DefaultTableCellRenderer() {
        private final javax.swing.border.EmptyBorder pad = new javax.swing.border.EmptyBorder(8,12,8,12);
        @Override
        public java.awt.Component getTableCellRendererComponent(
                javax.swing.JTable t, Object v, boolean sel, boolean foc, int r, int c) {
            super.getTableCellRendererComponent(t, v, sel, foc, r, c);
            setBorder(pad);
            setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13));
            setForeground(sel ? ROW_SEL_FG : ROW_FG);
            setBackground(sel ? ROW_SEL_BG : ROW_BG);
            return this;
        }
    };

    // aplicar a todas las columnas
    for (int i = 0; i < tableProxTurnos.getColumnModel().getColumnCount(); i++) {
        tableProxTurnos.getColumnModel().getColumn(i).setCellRenderer(base);
    }

    // centrar Fecha y Hora
    javax.swing.table.DefaultTableCellRenderer center = new javax.swing.table.DefaultTableCellRenderer();
    center.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    center.setBorder(new javax.swing.border.EmptyBorder(8,12,8,12));
    center.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13));
    center.setForeground(ROW_FG);
    center.setBackground(ROW_BG);
    tableProxTurnos.getColumnModel().getColumn(0).setCellRenderer(center); // Fecha
    tableProxTurnos.getColumnModel().getColumn(1).setCellRenderer(center); // Hora

    // scroll “card”
    jScrollPane1.getViewport().setBackground(ROW_BG);
    jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54,57,63), 1, true));
    
    }
    
    public void refreshStats() {
        int cantidadTurnos = services.turnos.obtenerTurnos().size();
        int cantidadProps = services.props.buscarPropietarios().size();
        int cantidadPerros = services.perros.obtenerPerros().size();
        
        lblCantTurnos.setText(String.valueOf(cantidadTurnos));
        lblCantProps.setText(String.valueOf(cantidadProps));
        lblCantPerros.setText(String.valueOf(cantidadPerros));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardTurnos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblProxTurnos = new javax.swing.JLabel();
        cardCantTurnos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblCantTurnos = new javax.swing.JLabel();
        cardCantTurnos1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblCantProps = new javax.swing.JLabel();
        cardCantTurnos2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblCantPerros = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProxTurnos = new javax.swing.JTable();

        cardTurnos.setBackground(new java.awt.Color(44, 47, 51));
        cardTurnos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 57, 63), 1, true));

        jLabel1.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Próximos Turnos");

        lblProxTurnos.setFont(new java.awt.Font("Roboto Medium", 1, 36)); // NOI18N
        lblProxTurnos.setForeground(new java.awt.Color(176, 179, 184));
        lblProxTurnos.setText("5");

        javax.swing.GroupLayout cardTurnosLayout = new javax.swing.GroupLayout(cardTurnos);
        cardTurnos.setLayout(cardTurnosLayout);
        cardTurnosLayout.setHorizontalGroup(
            cardTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardTurnosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addGroup(cardTurnosLayout.createSequentialGroup()
                        .addComponent(lblProxTurnos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        cardTurnosLayout.setVerticalGroup(
            cardTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardTurnosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProxTurnos)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        cardCantTurnos.setBackground(new java.awt.Color(44, 47, 51));
        cardCantTurnos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 57, 63)));

        jLabel5.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cantidad Turnos");

        lblCantTurnos.setFont(new java.awt.Font("Roboto Medium", 1, 36)); // NOI18N
        lblCantTurnos.setForeground(new java.awt.Color(176, 179, 184));
        lblCantTurnos.setText("5");

        javax.swing.GroupLayout cardCantTurnosLayout = new javax.swing.GroupLayout(cardCantTurnos);
        cardCantTurnos.setLayout(cardCantTurnosLayout);
        cardCantTurnosLayout.setHorizontalGroup(
            cardCantTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardCantTurnosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardCantTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addGroup(cardCantTurnosLayout.createSequentialGroup()
                        .addComponent(lblCantTurnos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        cardCantTurnosLayout.setVerticalGroup(
            cardCantTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardCantTurnosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCantTurnos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cardCantTurnos1.setBackground(new java.awt.Color(44, 47, 51));
        cardCantTurnos1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 57, 63)));

        jLabel4.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Propietarios");

        lblCantProps.setFont(new java.awt.Font("Roboto Medium", 1, 36)); // NOI18N
        lblCantProps.setForeground(new java.awt.Color(176, 179, 184));
        lblCantProps.setText("5");

        javax.swing.GroupLayout cardCantTurnos1Layout = new javax.swing.GroupLayout(cardCantTurnos1);
        cardCantTurnos1.setLayout(cardCantTurnos1Layout);
        cardCantTurnos1Layout.setHorizontalGroup(
            cardCantTurnos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardCantTurnos1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardCantTurnos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addGroup(cardCantTurnos1Layout.createSequentialGroup()
                        .addComponent(lblCantProps)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        cardCantTurnos1Layout.setVerticalGroup(
            cardCantTurnos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardCantTurnos1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCantProps)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cardCantTurnos2.setBackground(new java.awt.Color(44, 47, 51));
        cardCantTurnos2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 57, 63)));

        jLabel6.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Perros");

        lblCantPerros.setFont(new java.awt.Font("Roboto Medium", 1, 36)); // NOI18N
        lblCantPerros.setForeground(new java.awt.Color(176, 179, 184));
        lblCantPerros.setText("5");

        javax.swing.GroupLayout cardCantTurnos2Layout = new javax.swing.GroupLayout(cardCantTurnos2);
        cardCantTurnos2.setLayout(cardCantTurnos2Layout);
        cardCantTurnos2Layout.setHorizontalGroup(
            cardCantTurnos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardCantTurnos2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardCantTurnos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addGroup(cardCantTurnos2Layout.createSequentialGroup()
                        .addComponent(lblCantPerros)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        cardCantTurnos2Layout.setVerticalGroup(
            cardCantTurnos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardCantTurnos2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCantPerros)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(44, 47, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 57, 63)));

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Próximos Turnos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        tableProxTurnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Apr 25 2025", "10:00", "Ramiro Marcos Morales", "Matilda", "Baño y Corte"},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Hora", "Propietario", "Perro", "Motivo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableProxTurnos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 913, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(71, 71, 71)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cardTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(cardCantTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(49, 49, 49)
                            .addComponent(cardCantTurnos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(52, 52, 52)
                            .addComponent(cardCantTurnos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(84, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cardCantTurnos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cardCantTurnos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cardCantTurnos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cardTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(36, 36, 36)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(21, 21, 21)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(29, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardCantTurnos;
    private javax.swing.JPanel cardCantTurnos1;
    private javax.swing.JPanel cardCantTurnos2;
    private javax.swing.JPanel cardTurnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantPerros;
    private javax.swing.JLabel lblCantProps;
    private javax.swing.JLabel lblCantTurnos;
    private javax.swing.JLabel lblProxTurnos;
    private javax.swing.JTable tableProxTurnos;
    // End of variables declaration//GEN-END:variables
}
