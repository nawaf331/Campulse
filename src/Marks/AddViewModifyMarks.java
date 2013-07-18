/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package marks;

import Run.Runner;
import Run.dbConnect;
import com.mysql.jdbc.Statement;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author test
 */
public class AddViewModifyMarks extends javax.swing.JFrame implements CellEditorListener {

    /**
     * Creates new form AddViewModifyMarks
     */
    private int tempSem = 0;
    private int tempSub = 0;
    private int tempDept = 0;
    private static boolean EditMode = false;

    public AddViewModifyMarks() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/main_package/resources/icon.png")).getImage());
        hierarchy();
        setLocationRelativeTo(null);
        filldeptCombo();
        //deptCB.setSelectedIndex(1);
        fillSubjectCode();
        //subCodeCB.setSelectedIndex(1);

        marksTable.getDefaultEditor(String.class).addCellEditorListener(this);

    }

    private void fillSubjectCode() {
        DefaultComboBoxModel modelComboBox = new DefaultComboBoxModel();
        subCodeCB.setModel(modelComboBox);
        if (subCodeCB != null) {
            String deptCodeTemp = deptCB.getSelectedItem().toString();
            String semTemp = semCB.getSelectedItem().toString();
            //collectionOfDeptCode=null;        
            String subjectCodeQuery = "Select SubCode from subject where D_DeptCode=\"" + deptCodeTemp + "\" AND Sem=\"" + semTemp + "\";";
            System.out.println("QUery:" + subjectCodeQuery);
            try {
                ResultSet rs1 = dbConnect.getCon().createStatement().executeQuery(subjectCodeQuery);
                //  ResultSet rs1 = dbConnect.getStmt().executeQuery(subjectCodeQuery);
                while (rs1.next()) {

                    modelComboBox.addElement(rs1.getString("SubCode"));
                }
                rs1.close();
            } catch (Exception e) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(this, "Fill Subject Code: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        deptCB = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        marksTable = new javax.swing.JTable();
        USN = new javax.swing.JTextField();
        subCodeCB = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        semCB = new javax.swing.JComboBox();
        DisplayInfoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Marks View");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Marks View", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        deptCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CS", "EC", "ME", "IS", "TE" }));
        deptCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptCBActionPerformed(evt);
            }
        });

        marksTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        marksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "USN", "Internal1", "Internal2", "Internal3", "Classes Held", "Classes Attended", "Internal average", "External"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            boolean[] canEditModify = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                if(EditMode==true)
                return canEditModify[columnIndex];
                else
                return canEdit [columnIndex];
            }
        });
        marksTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(marksTable);

        USN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                USNKeyReleased(evt);
            }
        });

        subCodeCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "06CS661", "06IS662", "02ME442", "06EC456" }));
        subCodeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subCodeCBActionPerformed(evt);
            }
        });

        jLabel1.setText("Department :");

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_package/resources/Button-cancel-icon.png"))); // NOI18N
        cancelButton.setText("    Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_package/resources/Text-Edit-icon.png"))); // NOI18N
        editButton.setText("Allow Editing Marks");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_package/resources/home-icon-small.png"))); // NOI18N
        homeButton.setText("   Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Enter USN/Name :");

        jLabel3.setText("Subject Code :");

        jLabel2.setText("Sem :");

        semCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        semCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(USN, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(semCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(subCodeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                                .addComponent(cancelButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(deptCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editButton))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, editButton, homeButton});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(deptCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editButton))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cancelButton)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(semCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(subCodeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(USN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancelButton, homeButton});

        DisplayInfoLabel.setText("<USN> <marks> got updated");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(DisplayInfoLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DisplayInfoLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private String collectionOfDeptCode;

    private void filldeptCombo() {
        DefaultComboBoxModel modelComboBox = new DefaultComboBoxModel();
        deptCB.setModel(modelComboBox);
        //collectionOfDeptCode=null;        
        String sql = "Select DeptCode from department order by DeptName";
        try {
            ResultSet rs = dbConnect.getCon().createStatement().executeQuery(sql);
            while (rs.next()) {

                modelComboBox.addElement(rs.getString("DeptCode"));
            }
            rs.close();
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Fill dept ComboBox" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    void fillTableMarks() {
        DefaultTableModel model = (DefaultTableModel) marksTable.getModel();

        String deptCode = deptCB.getSelectedItem().toString();
        String sem = semCB.getSelectedItem().toString();

        if (subCodeCB.getSelectedItem() != null) {
            String subCode = subCodeCB.getSelectedItem().toString();
            String SyllabusOrderQuery = "select SyllabusOrder from subject where SubCode=\'" + subCode + "\'";
            String USN1 = null;
            String I1 = null;
            String I2 = null;
            String I3 = null;
            String CH = null;
            String CA = null;
            String Avg = null;
            String E = null;



            System.out.println(SyllabusOrderQuery);

            try {

                //Connection con=(Connection) ;
                Statement stmt1 = (Statement) dbConnect.getCon().createStatement();
                ResultSet rs = stmt1.executeQuery(SyllabusOrderQuery);

                //ResultSet rs = dbConnect.getStmt().executeQuery(SyllabusOrderQuery);

                if (rs.next()) {
                    // now derive subject order of subCode
                    int syllabusOrder = Integer.parseInt(rs.getString("SyllabusOrder"));
                    //int syllabusOrder = 1;
                    // rs.close();
                    String getMarksQuery = "Select S_USN," + "S" + sem + "S" + syllabusOrder + "I1," + "S" + sem + "S" + syllabusOrder + "I2," + "S" + sem + "S" + syllabusOrder + "I3," + "S" + sem + "S" + syllabusOrder + "CH," + "S" + sem + "S" + syllabusOrder + "CA," + "S" + sem + "S" + syllabusOrder + "Avg," + "S" + sem + "S" + syllabusOrder + "E" + " from  marks where S_USN IN (select USN from student where Sem=" + sem + " and D_DeptCode=\'" + deptCode + "\')";
                    System.out.println(getMarksQuery);
                    //Connection con=(Connection) dbConnect.getCon();
                    Statement stmt = (Statement) dbConnect.getCon().createStatement();
                    ResultSet rs2 = stmt.executeQuery(getMarksQuery);

                    //delete the old table entries
                    //model.addRow(new Object[]{"s", "s", "s", "s", Avg, "s", "s", "s"});
                    while (rs2.next()) {

                        USN1 = rs2.getString(1);
                        I1 = rs2.getString(2);
                        I2 = rs2.getString(3);
                        I3 = rs2.getString(4);
                        CH = rs2.getString(5);
                        CA = rs2.getString(6);
                        Avg = rs2.getString(7);
                        E = rs2.getString(8);
                        //System.out.println("TEST:"+USN1 +  I1 + I2+ I3+ Avg+ CA + CH + E);

                        //Recieving from Db in order ==>   USN,I1,I2,I3,CH,CA,Avg,E
                        //Putting it in table in order==>  USN,I1,I2,I3,Avg,CA,CH,E

                        // model.addRow(new Object[]{USN1, I1, I2, I3, Avg, CA, CH, E});
                        System.out.println("hello" + USN1 + I1 + I2 + I3 + Avg + CA + CH + E);
                        model.addRow(new Object[]{USN1, I1, I2, I3, Avg, CA, CH, E});
                        // marksTable.getSelectionModel().setSelectionInterval(0, 0);

                    }

                    rs2.close();


                    //  System.out.println("TEST:"+USN1 +  I1 + I2+ I3+ Avg+ CA + CH + E);
                    //      model.addRow(new Object[]{USN1, I1, I2, I3, Avg, CA, CH, E});

                }
                rs.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "FillTable Marks: " + ex.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
                Toolkit.getDefaultToolkit().beep();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "FillTable Marks:  " + ex.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
                Toolkit.getDefaultToolkit().beep();
            }
        }

    }

    private void newFilter1() {
        String nameSearch = USN.getText();
        String semSearch = semCB.getSelectedItem().toString();
        String subCodeSearch = subCodeCB.getSelectedItem().toString();
        ArrayList<RowFilter<Object, Object>> andFilters = new ArrayList<RowFilter<Object, Object>>();

        andFilters.add(RowFilter.regexFilter("(?i)" + nameSearch, 0));
        //andFilters.add(RowFilter.regexFilter("(?i)" + semSearch, 3));
        //andFilters.add(RowFilter.regexFilter("(?i)" + subCodeSearch, 3));

        DefaultTableModel model = (DefaultTableModel) marksTable.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        sorter.setRowFilter(RowFilter.andFilter(andFilters));
        marksTable.setRowSorter(sorter);

    }

    private void updatesubCodeCB() {
        DefaultComboBoxModel modelComboBox = new DefaultComboBoxModel();
        subCodeCB.setModel(modelComboBox);
        //collectionOfDeptCode=null;        
        String sql = "Select SubCode from subject where D_DeptCode=\"" + subCodeCB.getSelectedItem().toString() + "\"";
        try {
            ResultSet rs = dbConnect.getCon().createStatement().executeQuery(sql);
            while (rs.next()) {

                modelComboBox.addElement(rs.getString(1));
            }
            rs.close();
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, " update SuvCode:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void deptCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptCBActionPerformed
        fillSubjectCode();
        if (tempDept++ >= 1) {
            refreshTable();
        }

        //update subCode comboBox  with the semCB  subjects 

        //updatesubCodeCB();
        /// newFilter1();


    }//GEN-LAST:event_deptCBActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        this.dispose();
        Run.Runner.RunnerObj.MainUIObj.show();
        Run.Runner.RunnerObj.MainUIObj.AddViewModifyMarksObj = null;
    }//GEN-LAST:event_homeButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // enableEdit();
        //fillTableMarks();
        //  JOptionPane.showMessageDialog(this, "Allow Editing not yet Implemented!!!","Information", JOptionPane.INFORMATION_MESSAGE);
        EditMode = true;
    }//GEN-LAST:event_editButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        if (marksTable.getCellEditor() != null) {
            marksTable.getCellEditor().cancelCellEditing();

        }
        EditMode = false;
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void subCodeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subCodeCBActionPerformed
        //if(tempSub++>1)
        refreshTable();
        //newFilter1();
    }//GEN-LAST:event_subCodeCBActionPerformed

    private void USNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_USNKeyReleased
        newFilter1();
    }//GEN-LAST:event_USNKeyReleased

    private void semCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semCBActionPerformed
        //if(tempSem++!=0)
        {
            //System.out.println("TEST ::::1111 ");
            refreshTable();
            // System.out.println("TEST ::::2222 ");
            refreshSubCode();
        }


    }//GEN-LAST:event_semCBActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        homeButton.doClick();
    }//GEN-LAST:event_formWindowClosing
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DisplayInfoLabel;
    private javax.swing.JTextField USN;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox deptCB;
    private javax.swing.JButton editButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable marksTable;
    private javax.swing.JComboBox semCB;
    private javax.swing.JComboBox subCodeCB;
    // End of variables declaration//GEN-END:variables

    @Override
    public void editingStopped(ChangeEvent e) {
        int updateSuccessful = 0;
        String setField = null;

        int col = marksTable.convertColumnIndexToModel(marksTable.getSelectedColumn());
        int row = marksTable.convertRowIndexToModel(marksTable.getSelectedRow());

        System.out.println("EDITING: column=" + col + " row=" + row);

        String usn = (String) marksTable.getModel().getValueAt(row, 0);
        String sem = semCB.getSelectedItem().toString();

        //change this
        int syllabusOrder = 1;

        if (col == 1) {
            setField = "S" + sem + "S" + syllabusOrder + "I1";
        } else if (col == 2) {
            setField = "S" + sem + "S" + syllabusOrder + "I2";
        } else if (col == 3) {
            setField = "S" + sem + "S" + syllabusOrder + "I3";
        } else if (col == 4) {
            setField = "S" + sem + "S" + syllabusOrder + "CH";
        } else if (col == 5) {
            setField = "S" + sem + "S" + syllabusOrder + "CA";
        } else if (col == 6) {
            setField = "S" + sem + "S" + syllabusOrder + "Avg";
        } else if (col == 7) {
            setField = "S" + sem + "S" + syllabusOrder + "E";
        }

        String newval = (String) marksTable.getModel().getValueAt(row, col);

        if (newval.length() != 0) { //newval="0";

            String updateMarkQuery = "UPDATE marks SET " + setField + "=\"" + newval + "\" where S_USN=\"" + usn + "\";";
            System.out.println(updateMarkQuery);

            try {

                updateSuccessful = dbConnect.getCon().createStatement().executeUpdate(updateMarkQuery);


            } catch (SQLException ex) {
                Logger.getLogger(AddViewModifyMarks.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (updateSuccessful == 1) {
                // JOptionPane.showMessageDialog(this, "marks update successfull", "Information", JOptionPane.INFORMATION_MESSAGE);
                DisplayInfoLabel.setText(usn + " marks  " + newval + " got updated");
            } else {

                JOptionPane.showMessageDialog(this, "marks update not successfull", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }

    }

    @Override
    public void editingCanceled(ChangeEvent e) {
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    private void refreshTable() {
        DefaultTableModel dm = (DefaultTableModel) marksTable.getModel();

        dm.getDataVector().removeAllElements();
        // dm.setRowCount(0);
        setSorterNull();
        fillTableMarks();

        //marksTable.requestFocus();
    }

    private void refreshSubCode() {
        DefaultComboBoxModel dt = new DefaultComboBoxModel();
        subCodeCB.setModel(dt);
        dt.removeAllElements();


        fillSubjectCode();

    }

    private void setSorterNull() {
        DefaultTableModel model = (DefaultTableModel) marksTable.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        marksTable.setRowSorter(sorter);
        sorter.setRowFilter(null);

    }

    private void hierarchy() {
        String privilege = Runner.RunnerObj.MainUIObj.getPrivilege();
        if ("other".equalsIgnoreCase(privilege)) {
            editButton.setEnabled(false);
            cancelButton.setEnabled(false);
        }
    }
}
