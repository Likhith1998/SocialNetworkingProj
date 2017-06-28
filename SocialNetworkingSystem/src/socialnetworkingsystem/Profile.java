package socialnetworkingsystem;
import javafx.scene.Cursor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.*;
import javax.swing.text.DefaultHighlighter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LIKHITH
 */
public class Profile extends javax.swing.JFrame {

    /**
     * Creates new form Profile
     */
    private static int postNo=0;
    private static String username;
    
    private void prevTextPane()
    {
        --postNo;
        if(postNo<0||postNo>=noOfPosts())
        {
            JOptionPane.showMessageDialog(null,"No Posts to Show","ERROR",JOptionPane.ERROR_MESSAGE);
            postNo++;
        }
        else
        {
            File file = new File(Integer.toString(postNo)+".txt");    
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
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"No Posts to Show","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void nextTextPane()
    {
        ++postNo;
        if(postNo<0||postNo>=noOfPosts())
        {
            JOptionPane.showMessageDialog(null,"No Posts to Show","ERROR",JOptionPane.ERROR_MESSAGE);
            postNo--;
        }
        else
        {
            File file = new File(Integer.toString(postNo)+".txt");    
            String filename = file.getAbsolutePath();
            try
            {
                FileReader reader = new FileReader(filename);
                BufferedReader br = new BufferedReader(reader);
                jTextPane1.read(br,null);
                br.close();
                jTextPane1.requestFocus();
                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"No Posts to Show","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void initTextPane()
    {
        
        if(postNo<0||postNo>=noOfPosts())
        {
            JOptionPane.showMessageDialog(null,"No Posts to Show","ERROR",JOptionPane.ERROR_MESSAGE);
            postNo--;
        }
        else
        {
            File file = new File(Integer.toString(postNo)+".txt");    
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
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"No Posts to Show","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
    private int noOfPosts()
    {
        File file = new File("NoofPosts.txt");
        String filename = file.getAbsolutePath();
        int noofposts;
        try
        {
            Scanner sc = new Scanner(file);
            noofposts = sc.nextInt();
            
        }
        catch(Exception e)
        {
            noofposts = 10;
        }
        return noofposts;
    }
    
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
    
    
    public Profile(String username) {
        this.username=username;
        initComponents();
        jLabel4.setText(username);
        //postNo=0;
        initTextPane();
        initTextfield();
    }
    

    {
        
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
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

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
        jTextPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Next>>");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("<<Previous");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jTextField1.setText("  Search");
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
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 240, 20));

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
            catch(Exception e)
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
        setVisible(false);
        Friends friends = new Friends(username);
        friends.setSize(getSize());
        friends.setLocationRelativeTo(null);
        friends.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        // TODO add your handling code here:
        jLabel8.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        // TODO add your handling code here:
        jLabel8.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        nextTextPane();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        // TODO add your handling code here:
        jLabel9.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        // TODO add your handling code here:
        jLabel9.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        prevTextPane();
    }//GEN-LAST:event_jLabel9MouseClicked

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
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile(username).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
