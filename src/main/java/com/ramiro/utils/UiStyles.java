package com.ramiro.utils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.awt.*;

public final class UiStyles {
    private UiStyles() {}

    // Paleta
    private static final Color HEADER_BG   = new Color(0x1E,0x1E,0x1E); // #1E1E1E
    private static final Color HEADER_FG   = new Color(224,224,224);
    private static final Color ROW_BG      = new Color(48,51,54);
    private static final Color ROW_FG      = new Color(190,195,199);
    private static final Color ROW_SEL_BG  = new Color(58,62,66);
    private static final Color ROW_SEL_FG  = Color.WHITE;
    private static final Color CARD_BORDER = new Color(54,57,63);        // #36393F

    /** Aplica el mismo estilo dark que usaste en tableProxTurnos. */
    public static void applyDarkTableStyle(JTable table, JScrollPane scroll, int... centerCols) {
        // No editable (sin deshabilitar)
        table.setDefaultEditor(Object.class, null);

        // Header
        JTableHeader th = table.getTableHeader();
        th.setReorderingAllowed(false);
        th.setPreferredSize(new Dimension(th.getWidth(), 36));
        th.setDefaultRenderer(new DefaultTableCellRenderer() {
            private final EmptyBorder pad = new EmptyBorder(8,12,8,12);
            @Override public Component getTableCellRendererComponent(
                    JTable t, Object v, boolean sel, boolean foc, int r, int c) {
                super.getTableCellRendererComponent(t, v, sel, foc, r, c);
                setOpaque(true);
                setBackground(HEADER_BG);
                setForeground(HEADER_FG);
                setFont(new Font("Segoe UI", Font.BOLD, 13));
                setBorder(pad);
                setHorizontalAlignment(SwingConstants.LEFT);
                return this;
            }
        });

        // Filas
        table.setRowHeight(36);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.setIntercellSpacing(new Dimension(0, 8));
        table.setBackground(ROW_BG);
        table.setForeground(ROW_FG);

        DefaultTableCellRenderer base = new DefaultTableCellRenderer() {
            private final EmptyBorder pad = new EmptyBorder(8,12,8,12);
            @Override public Component getTableCellRendererComponent(
                    JTable t, Object v, boolean sel, boolean foc, int r, int c) {
                super.getTableCellRendererComponent(t, v, sel, foc, r, c);
                setBorder(pad);
                setFont(new Font("Segoe UI", Font.PLAIN, 13));
                setForeground(sel ? ROW_SEL_FG : ROW_FG);
                setBackground(sel ? ROW_SEL_BG : ROW_BG);
                setHorizontalAlignment(SwingConstants.LEFT);
                return this;
            }
        };

        // Asignar a todas las columnas
        TableColumnModel cm = table.getColumnModel();
        for (int i = 0; i < cm.getColumnCount(); i++) {
            cm.getColumn(i).setCellRenderer(base);
        }

        // Columnas centradas (si se piden)
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        center.setBorder(new EmptyBorder(8,12,8,12));
        center.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        center.setForeground(ROW_FG);
        center.setBackground(ROW_BG);
        for (int col : centerCols) {
            if (col >= 0 && col < cm.getColumnCount()) {
                cm.getColumn(col).setCellRenderer(center);
            }
        }

        // Scroll estilo “card”
        if (scroll != null) {
            scroll.getViewport().setBackground(ROW_BG);
            scroll.setBorder(new javax.swing.border.LineBorder(CARD_BORDER, 1, true));
            // esquinitas del header del scroll que a veces quedan claras
            JPanel corner = new JPanel();
            corner.setBackground(HEADER_BG);
            scroll.setCorner(ScrollPaneConstants.UPPER_RIGHT_CORNER, corner);
        }
    }
}
