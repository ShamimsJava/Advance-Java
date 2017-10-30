package com.shamim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class CommonMenu {
    public static JMenuBar displayMenu(JFrame f){
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");
        JMenuItem dashboardItem = new JMenuItem("Dashboard");
        
        dashboardItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new Dashboard().setVisible(true);
            }
        });
        
        JMenuItem purchaseItem = new JMenuItem("PurchaseProduct");
        
        purchaseItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new PurchaseProduct().setVisible(true);
            }
        });
        
        JMenuItem salesItem = new JMenuItem("SalesProduct");
        
        salesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new SalesProduct().setVisible(true);
            }
        });
        
        JMenuItem exitItem = new JMenuItem("Exit");
        
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
      
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        fileMenu.add(dashboardItem);
        fileMenu.add(purchaseItem);
        fileMenu.add(salesItem);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fileMenu.add(exitItem);
        return menuBar;
    }
}
