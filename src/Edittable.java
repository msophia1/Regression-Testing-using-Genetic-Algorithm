/**
 * Created by 1021288 on 6/22/2017.
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myprojectbg;
import java.io.*;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

/**
 *
 * @author Administrator
 */
public class Edittable extends javax.swing.JFrame {

    int cn=1002;
    int arr[]=new int[cn];
    int tstno[]=new int[cn];
    String tstdesc[]=new String[cn];
    String tablename;
    Connection con;
    Statement st;
    Boolean flg=false;
    /**
     * Creates new form Edittable
     */
    public Edittable() {
        //initComponents();
    }

    public Edittable(String s)
    {
        tablename=s;
        System.out.println(tablename);

        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:testdsn1");
            st = con.createStatement();
            initComponents();
        }catch(Exception e)
        {
            System.out.println(e.toString());
        }
        setTable();

    }

    private void setTable()
    {
        // cn=Integer.parseInt(jtf.getText());
        int c=0;
        for(int x=0;x<cn;x++)
            tstno[x]=0;
        for(int x=0;x<cn;x++)
            tstdesc[x]="";

        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        try
        {

            String sql = "SELECT * FROM "+tablename;
            ResultSet rs = st.executeQuery(sql);
            model.setRowCount(0);

            while (rs.next())
            {
                String d1, d2, d4, d3,d5;
                int i;

                i = rs.getInt(1);
                tstno[c]=i;
                d1 = rs.getString(2);
                d2 = rs.getString(3);
                d3 = rs.getString(4);
                tstdesc[c]=d3;
                d4 = rs.getString(5);
                d5 = rs.getString(6);

                c++;

                model.addRow(new Object[]{i,d1,d2,d3,d4,d5});
            }
            //  jTextField1.setText(Integer.toString(c));
            cn=c;
            rs.close();

        }

        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GA Tool");
        setIconImage(new ImageIcon("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\myprojectbg1\\src\\icon1.jpg").getImage());
        getContentPane().setLayout(null);

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "ID", "Functional header", "Test case number", "Test case description", "Expected result", "Requirement criticality"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setSelectionBackground(new java.awt.Color(255, 153, 0));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 20, 980, 520);

        jButton1.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jButton1.setText("SAVE CHANGES");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(340, 550, 374, 45);

        jButton2.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(440, 610, 180, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg7.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1200, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==jButton2)
        {
            ProjGA pg=new ProjGA();
            pg.setSize(1000,700);
            pg.show();
            this.hide();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try
        {


            int id[]=new int[cn];
            String fh[]=new String[cn];
            String tn[]=new String[cn];
            String td[]=new String[cn];
            String er[]=new String[cn];
            String rc[]=new String[cn];

            //Object[] val = new Object[6];
            // for (int k = 0; k  < val.length - 1; k++)
            // {
            for (int j = 0; j  < cn; j++)
            {

                id[j] = Integer.parseInt(jTable1.getValueAt(j, 0).toString());
                //System.out.println(val[k]);
                fh[j] = jTable1.getValueAt(j, 1).toString();
                tn[j] = jTable1.getValueAt(j, 2).toString();
                td[j] = jTable1.getValueAt(j, 3).toString();
                er[j] = jTable1.getValueAt(j, 4).toString();
                rc[j] = jTable1.getValueAt(j, 5).toString();
            }

            // boolean b=st.execute("create table "+tablename+" (id Integer,fun_header varchar(10),test_no varchar(10),test_desc varchar(50),expected_result varchar(50),req_cri varchar(10))");
            for (int j = 0; j  < cn; j++)
            {
                Scanner sc=new Scanner(fh[j]);
                while(sc.hasNextInt())
                {
                    sc.next();
                    JOptionPane.showMessageDialog(null,"please enter only valid string for functional header");
                    flg=true;
                }

                Scanner sc1=new Scanner(tn[j]);
                while(sc1.hasNextInt())
                {
                    sc1.next();
                    JOptionPane.showMessageDialog(null,"please enter only valid string for test case number");
                    flg=true;
                }

                Scanner sc2=new Scanner(td[j]);
                while(sc2.hasNextInt())
                {
                    sc2.next();
                    JOptionPane.showMessageDialog(null,"please enter only valid string for test case description");
                    flg=true;
                }

                Scanner sc3=new Scanner(er[j]);
                while(sc3.hasNextInt())
                {
                    sc3.next();
                    JOptionPane.showMessageDialog(null,"please enter only valid string for expected result");
                    flg=true;
                }

                Scanner sc4=new Scanner(rc[j]);
                while(sc4.hasNextInt())
                {
                    sc4.next();
                    JOptionPane.showMessageDialog(null,"please enter only valid string for requirement criticality");
                    flg=true;
                }
            }
            if(flg==false)
            {
                String sql= "delete from "+tablename;
                int u=st.executeUpdate(sql);
                System.out.println("table dropped");

                String query="insert into "+tablename+" values(?,?,?,?,?,?)";
                PreparedStatement pst=con.prepareStatement(query);

                for(int j=0;j<cn;j++)
                {

                    pst.setInt(1,id[j]);
                    pst.setString(2,fh[j]);
                    pst.setString(3,tn[j]);
                    pst.setString(4,td[j]);
                    pst.setString(5,er[j]);
                    pst.setString(6,rc[j]);
                    pst.executeUpdate();
                }
                JOptionPane.showMessageDialog(null,"changes saved successfully");
            }
        }catch(Exception e){System.out.println(e.toString());}

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Edittable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edittable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edittable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edittable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edittable().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
