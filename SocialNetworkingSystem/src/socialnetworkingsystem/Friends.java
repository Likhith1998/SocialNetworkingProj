package socialnetworkingsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Properties;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LIKHITH
 */
public class Friends extends javax.swing.JFrame {

    /**
     * Creates new form Friends
     */
    
    private static String username;
    
    private void initTextfield()
    {
        String s = username+"_Friends_info.txt";
        File f = new File(s);
        String filename = f.getAbsolutePath();
        jTextArea1.setEditable(true);
        if(f.length()==0)
        {
            
            jTextArea1.setText("Oops!You have\nno Friends added");
            
        }
        else
        {
            try
            {
                FileReader reader = new FileReader(filename);
                BufferedReader br = new BufferedReader(reader);
                jTextArea1.read(br,null);
                br.close();
                reader.close();
                jTextArea1.requestFocus();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error loading Friends file","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
        jTextArea1.setEditable(false);
    }
    
    public Friends(String username) {
        this.username=username;
        initComponents();
        jLabel4.setText(username);
        initTextfield();
    }
    
    private void updateFriendfile() 
    {
        String frndusername = jTextField1.getText();
        if(frndusername.equals(username))
        {
            JOptionPane.showMessageDialog(null,"You are always friends with yourself","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        String usernamefrndtxtfile = username+"_Friends_info.txt";
        String frndfilename = frndusername+".txt";
        String frndfrndtxtfile = frndusername+"_Friends_info.txt";
        File f = new File(frndfilename);
        if(f.exists())
        {
            
            try
            {
                HashMap <String,String> hm = new HashMap<String,String>();
                Properties properties = new Properties();
                FileInputStream f1 = new FileInputStream(usernamefrndtxtfile);
                properties.load(f1);
                f1.close();
                for (String key : properties.stringPropertyNames()) 
                {
                    hm.put(key, properties.get(key).toString());
                }     
                if(hm.get(frndusername)==null)
                {
                    hm.put(frndusername,"        ");
                    properties.putAll(hm);
                    FileOutputStream f2 = new FileOutputStream(usernamefrndtxtfile);
                    properties.store(f2,null);
                    f2.close();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Already a friend","ERROR",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error updating file","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            try
            {
                HashMap <String,String> hm1 = new HashMap<String,String>();
                Properties properties1 = new Properties();
                FileInputStream f3 = new FileInputStream(frndfrndtxtfile);
                properties1.load(f3);
                f3.close();
                for (String key : properties1.stringPropertyNames()) 
                {
                    hm1.put(key, properties1.get(key).toString());
                }     
                if(hm1.get(frndusername)==null)
                {
                    hm1.put(username,"       ");
                    properties1.putAll(hm1);
                    FileOutputStream f4 = new FileOutputStream(frndfrndtxtfile);
                    properties1.store(f4,null);
                    f4.close();
                    JOptionPane.showMessageDialog(null,"Successfully added as friend","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Already a friend","ERROR",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error updating file","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"No user with such username exists","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    
    private void displayFriendslist()
    {
        initTextfield();
    }
    
    private void initTextPane(String frnd)
    {
        File f = new File(frnd+".txt");
        if(f.exists())
        {
            File file = new File(frnd+"_Personal_info.txt");
            String filename = file.getAbsolutePath();
            try
            {
                FileReader reader = new FileReader(filename);
                BufferedReader br = new BufferedReader(reader);
                jTextPane1.read(br,null);
                br.close();
                reader.close();
                jTextPane1.requestFocus();
            }
            catch(IOException e)
            {
                jTextPane1.setText("No Personal Information to Show");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"No user with such username exists","ERROR",JOptionPane.ERROR_MESSAGE);  
        }
        
    }
    
    private void displayProfile()
    {
        String s = jTextField1.getText();
        String frndusername = s+".txt";
        String usernamefrndtxt = username+"_Friends_info.txt";
        if(s.isEmpty()||s.equals("  Search by friend username"))
        {
            JOptionPane.showMessageDialog(null,"No username is typed","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            File f = new File(frndusername);
            if(f.exists())
            {
                jTextPane1.setEditable(true);
                initTextPane(s);
                jTextPane1.setEditable(false);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No user with such username exists","ERROR",JOptionPane.ERROR_MESSAGE);  
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(1, 115, 155));
        jPanel1.setForeground(new java.awt.Color(1, 115, 155));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jTextPane1.setEditable(false);
        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(jTextPane1);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(204, 204, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Oops!\nYou have no \nFriends added");
        jScrollPane1.setViewportView(jTextArea1);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setText("Friends List");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel8.setText("Friend Profile");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jTextField1.setText("  Search by friend username");
        jTextField1.setBorder(null);
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(1, 115, 155));
        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("View Profile");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(1, 115, 155));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Add Friend");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 770, 500));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/socialnetworkingsystem/icon.png"))); // NOI18N
        jLabel1.setToolTipText("Profile");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/socialnetworkingsystem/magnifier-tool (1).png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 20, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/socialnetworkingsystem/user (1).png"))); // NOI18N
        jLabel4.setToolTipText("Profile");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 170, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/socialnetworkingsystem/earth-globe-tool.png"))); // NOI18N
        jLabel2.setToolTipText("Notifications");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 25, 24));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/socialnetworkingsystem/send.png"))); // NOI18N
        jLabel6.setToolTipText("Messages");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 25, 24));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Manage profile", "Privacy options", "Delete Account", "Logout" }));
        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 100, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/socialnetworkingsystem/users.png"))); // NOI18N
        jLabel7.setToolTipText("Friends");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 25, 24));

        jTextField2.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jTextField2.setText("  Search");
        jTextField2.setBorder(null);
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 240, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        Profile profile = new Profile(username);
        profile.setSize(getSize());
        profile.setLocationRelativeTo(null);
        profile.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // TODO add your handling code here:
        jTextField1.setText("");
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        PersonalInfo pi = new PersonalInfo(username);
        pi.setSize(getSize());
        pi.setLocationRelativeTo(null);
        pi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jComboBox1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:

        if(jComboBox1.getSelectedItem().toString().equals("Manage profile"))
        {
            setVisible(false);
            ManageProfile mp = new ManageProfile(username);
            mp.setSize(getSize());
            mp.setLocationRelativeTo(null);
            mp.setVisible(true);
            this.dispose();
        }
        if(jComboBox1.getSelectedItem().toString().equals("Privacy options"))
        {
            setVisible(false);
            PrivacyOptions po = new PrivacyOptions(username);
            po.setSize(getSize());
            po.setLocationRelativeTo(null);
            po.setVisible(true);
            this.dispose();
        }
        if(jComboBox1.getSelectedItem().toString().equals("Delete Account"))
        {
            File f1 = new File(username+".txt");
            try
            {
                FileOutputStream f = new FileOutputStream(f1);
                f.close();
                Path file;
                file = Paths.get(username+".txt");
                Files.setAttribute(file, "dos:hidden", false);
                f1.delete();
            }
            catch(IOException e)
            {
                //JOptionPane.showMessageDialog(null,"Error deleting Account","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            
            
            f1.delete();
            File f2=new File(username+"_Personal_info.txt");
            f2.delete();
            File f3 = new File(username+"_Friends_info.txt");
            f3.delete();
            
            
            setVisible(false);
            //Delete the Account
            Home home = new Home();
            home.setSize(getSize());
            home.setLocationRelativeTo(null);
            home.setVisible(true);
            this.dispose();
        }
        if(jComboBox1.getSelectedItem().toString().equals("Logout"))
        {
            setVisible(false);
            SignIn signIn = new SignIn();
            signIn.setSize(getSize());
            signIn.setLocationRelativeTo(null);
            signIn.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeInvisible

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel7MouseClicked

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        displayProfile();
        jTextField1.setText("");
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        updateFriendfile();
        displayFriendslist();
        jTextField1.setText("");
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Friends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Friends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Friends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Friends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Friends(username).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
