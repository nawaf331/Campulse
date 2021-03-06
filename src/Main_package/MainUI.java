/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package;

import Advance.HODSelectorUI;
import Advance.SubjectMarksLimitManagerUI;
import Department.DepartmentDetails;
import Faculty.ViewFaculty;
import Main_package.AboutUsUI;
import Misc.getScaledImage;
import Run.Runner;
import Run.dbConnect;
import adminTools.AddUserUI;
import adminTools.UserViewModifyDelete;
import faculty.AddFaculty;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import marks.AddViewModifyMarks;
import marks.findStudent;
import studentDetails.AddStudentUI1;
import studentDetails.StudentViewAndModification;
import subject.AddSubjectUI;
import subject.ViewSubjectUI;
import subject.handling.AddSubjectHandlingUI;
import subject.handling.ViewSubjectHandlingUI;
//

/**
 *
 * @author Nawaf
 */
public class MainUI extends javax.swing.JFrame {

    private final String versionNum = "1.8";
    private final String versionCode = "Kappa";
    String UserName;
    String privilege;
    String Dept = null;
    String UFN = null;
    public static getScaledImage getScaledImageObj;
    public DepartmentDetails DepartmentDetailsObj;
    public AddViewModifyMarks AddViewModifyMarksObj;
    public AddFaculty AddFacultyObj;
    public findStudent findStudentObj;
    public ChangeUserDetails ChangeUserDetailsObj;
    public SubjectMarksLimitManagerUI SubjectMarksLimitManagerUIObj;
    public HODSelectorUI HODSelectorUIObj;
    public ViewSubjectHandlingUI ViewSubjectHandlingUIObj;
    public ViewSubjectUI ViewSubjectUIObj;
    public StudentViewAndModification StudentViewAndModificationObj;
    public AddSubjectHandlingUI AddSubjectHandlingUIObj;
    public AddSubjectUI AddSubjectUIObj;
    public AddStudentUI1 AddStudentUI1Obj;
    public ViewFaculty ViewFacultyObj;
    public GeneralSettings GeneralSettingsObj;
    public UserViewModifyDelete UserViewModifyDeleteObj;
    public AddUserUI AddUserUIObj;
    public AboutUsUI AboutUsUIObj;

    /**
     * Creates new form MainUI
     */
    public MainUI(String userNameParameter, String privilegeParameter) {
        this.setIconImage(new ImageIcon(getClass().getResource("/main_package/resources/icon.png")).getImage());

        UserName = userNameParameter;
        privilege = privilegeParameter;
        getProfile();


        initComponents();
        this.setTitle("Campulse " + versionNum + " (" + versionCode + ") -- Running in " + privilege + " mode");
        // this.getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        getScaledImageObj = new getScaledImage();

        hierarchy();
        System.out.println(UserName + " " + privilege + " " + Dept + " " + UFN);


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        MenuCurrentUserName = new javax.swing.JMenu();
        ReLogin = new javax.swing.JMenuItem();
        changePassMenu = new javax.swing.JMenuItem();
        ExitMenu = new javax.swing.JMenuItem();
        AddMenu = new javax.swing.JMenu();
        AddStudentMenu = new javax.swing.JMenuItem();
        AddFacultyMenu = new javax.swing.JMenuItem();
        AddSubjectMenu = new javax.swing.JMenuItem();
        AddSubjectHandlingMenu = new javax.swing.JMenuItem();
        AddDepartmentMenu = new javax.swing.JMenuItem();
        ViewMenu = new javax.swing.JMenu();
        ViewStudentMenu = new javax.swing.JMenuItem();
        ViewFacultyMenu = new javax.swing.JMenuItem();
        ViewSubjectMenu = new javax.swing.JMenuItem();
        ViewSubjectHandlingMenu = new javax.swing.JMenuItem();
        ViewModifyDeptMenu = new javax.swing.JMenuItem();
        MarksEntryMenu = new javax.swing.JMenu();
        MarksAddViewModifyMenu = new javax.swing.JMenuItem();
        viewStudentMarkMenu = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        selectHODMenu = new javax.swing.JMenuItem();
        SMLModifyMenu = new javax.swing.JMenuItem();
        AdminMenuUserAccounts = new javax.swing.JMenu();
        MenuUserAccounts = new javax.swing.JMenu();
        MenuAddUser = new javax.swing.JMenuItem();
        MenuViewUser = new javax.swing.JMenuItem();
        MenuGeneralSettings = new javax.swing.JMenuItem();
        help = new javax.swing.JMenu();
        about = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        MenuCurrentUserName.setText(UserName);

        ReLogin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        ReLogin.setText("Logout");
        ReLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReLoginActionPerformed(evt);
            }
        });
        MenuCurrentUserName.add(ReLogin);

        changePassMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        changePassMenu.setText("Change user details");
        changePassMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePassMenuActionPerformed(evt);
            }
        });
        MenuCurrentUserName.add(changePassMenu);

        ExitMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        ExitMenu.setText("Exit");
        ExitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuActionPerformed(evt);
            }
        });
        MenuCurrentUserName.add(ExitMenu);

        jMenuBar1.add(MenuCurrentUserName);

        AddMenu.setText("Add");

        AddStudentMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        AddStudentMenu.setText("Student");
        AddStudentMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddStudentMenuActionPerformed(evt);
            }
        });
        AddMenu.add(AddStudentMenu);

        AddFacultyMenu.setText("Faculty");
        AddFacultyMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddFacultyMenuActionPerformed(evt);
            }
        });
        AddMenu.add(AddFacultyMenu);

        AddSubjectMenu.setText("Subject");
        AddSubjectMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSubjectMenuActionPerformed(evt);
            }
        });
        AddMenu.add(AddSubjectMenu);

        AddSubjectHandlingMenu.setText("Subject Handling");
        AddSubjectHandlingMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSubjectHandlingMenuActionPerformed(evt);
            }
        });
        AddMenu.add(AddSubjectHandlingMenu);

        AddDepartmentMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        AddDepartmentMenu.setText("Department");
        AddDepartmentMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddDepartmentMenuActionPerformed(evt);
            }
        });
        AddMenu.add(AddDepartmentMenu);

        jMenuBar1.add(AddMenu);

        ViewMenu.setText("View/modify");

        ViewStudentMenu.setText("Student");
        ViewStudentMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewStudentMenuActionPerformed(evt);
            }
        });
        ViewMenu.add(ViewStudentMenu);

        ViewFacultyMenu.setText("Faculty");
        ViewFacultyMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewFacultyMenuActionPerformed(evt);
            }
        });
        ViewMenu.add(ViewFacultyMenu);

        ViewSubjectMenu.setText("Subject");
        ViewSubjectMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewSubjectMenuActionPerformed(evt);
            }
        });
        ViewMenu.add(ViewSubjectMenu);

        ViewSubjectHandlingMenu.setText("Subject Handling");
        ViewSubjectHandlingMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewSubjectHandlingMenuActionPerformed(evt);
            }
        });
        ViewMenu.add(ViewSubjectHandlingMenu);

        ViewModifyDeptMenu.setText("Department");
        ViewModifyDeptMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewModifyDeptMenuActionPerformed(evt);
            }
        });
        ViewMenu.add(ViewModifyDeptMenu);

        jMenuBar1.add(ViewMenu);

        MarksEntryMenu.setText("Marks Entry");

        MarksAddViewModifyMenu.setText("Add/View/Modify");
        MarksAddViewModifyMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarksAddViewModifyMenuActionPerformed(evt);
            }
        });
        MarksEntryMenu.add(MarksAddViewModifyMenu);

        viewStudentMarkMenu.setText("View Student Mark");
        viewStudentMarkMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStudentMarkMenuActionPerformed(evt);
            }
        });
        MarksEntryMenu.add(viewStudentMarkMenu);

        jMenuBar1.add(MarksEntryMenu);

        jMenu1.setText("Advance");

        selectHODMenu.setText("Select HOD");
        selectHODMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectHODMenuActionPerformed(evt);
            }
        });
        jMenu1.add(selectHODMenu);

        SMLModifyMenu.setText("Subject Marks Limit");
        SMLModifyMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMLModifyMenuActionPerformed(evt);
            }
        });
        jMenu1.add(SMLModifyMenu);

        jMenuBar1.add(jMenu1);

        AdminMenuUserAccounts.setText("Admin");

        MenuUserAccounts.setText("User Accounts");

        MenuAddUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        MenuAddUser.setText("Add User");
        MenuAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAddUserActionPerformed(evt);
            }
        });
        MenuUserAccounts.add(MenuAddUser);

        MenuViewUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        MenuViewUser.setText("View / Modify / Delete User");
        MenuViewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuViewUserActionPerformed(evt);
            }
        });
        MenuUserAccounts.add(MenuViewUser);

        AdminMenuUserAccounts.add(MenuUserAccounts);

        MenuGeneralSettings.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        MenuGeneralSettings.setText("General Settings");
        MenuGeneralSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuGeneralSettingsActionPerformed(evt);
            }
        });
        AdminMenuUserAccounts.add(MenuGeneralSettings);

        jMenuBar1.add(AdminMenuUserAccounts);

        help.setText("Help");

        about.setText("About");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        help.add(about);

        helpMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        helpMenu.setText("Help");
        helpMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuActionPerformed(evt);
            }
        });
        help.add(helpMenu);

        jMenuBar1.add(help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuActionPerformed
        NewOkCancelDialog NewOkCancelDialogObj;
        NewOkCancelDialogObj = new NewOkCancelDialog(new javax.swing.JFrame(), true);
        NewOkCancelDialogObj.setTitle("Exit ?");    //  dialog.addWindowListener(new java.awt.event.WindowAdapter() {});
        NewOkCancelDialogObj.setVisible(true);

        if (NewOkCancelDialogObj.returnStatus == 1) {
            this.dispose();
            try {
                Runner.RunnerObj.dbConObj.getCon().close();
            } catch (SQLException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            Run.Runner.RunnerObj.LoginUIObj = null;
            Run.Runner.RunnerObj.MainUIObj = null;
            Run.Runner.RunnerObj = null;
            System.exit(0);
        }
    }//GEN-LAST:event_ExitMenuActionPerformed

    private void ReLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReLoginActionPerformed
        NewOkCancelDialog NewOkCancelDialogObj;
        NewOkCancelDialogObj = new NewOkCancelDialog(new javax.swing.JFrame(), true);
        NewOkCancelDialogObj.setTitle("   Re-Login !!");
        NewOkCancelDialogObj.setVisible(true);

        if (NewOkCancelDialogObj.returnStatus == 1) {
            //new LoginUI().setVisible(true);
            Run.Runner.RunnerObj.LoginUIObj = new LoginUI();
            Run.Runner.RunnerObj.LoginUIObj.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_ReLoginActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ExitMenu.doClick();
    }//GEN-LAST:event_formWindowClosing

    private void MenuAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAddUserActionPerformed
        AddUserUIObj = new AddUserUI();
        AddUserUIObj.setVisible(true);
        this.hide();
    }//GEN-LAST:event_MenuAddUserActionPerformed

    private void MenuViewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuViewUserActionPerformed
        UserViewModifyDeleteObj = new UserViewModifyDelete(UserName);
        UserViewModifyDeleteObj.setVisible(true);
        this.hide();
    }//GEN-LAST:event_MenuViewUserActionPerformed

    private void MenuGeneralSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuGeneralSettingsActionPerformed
        GeneralSettingsObj = new GeneralSettings();
        GeneralSettingsObj.setVisible(true);
        this.hide();

    }//GEN-LAST:event_MenuGeneralSettingsActionPerformed

    private void ViewFacultyMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewFacultyMenuActionPerformed
        ViewFacultyObj = new ViewFaculty();
        ViewFacultyObj.setVisible(true);
        this.hide();
    }//GEN-LAST:event_ViewFacultyMenuActionPerformed

    private void AddStudentMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddStudentMenuActionPerformed
        AddStudentUI1Obj = new AddStudentUI1();
        AddStudentUI1Obj.setVisible(true);
        this.hide();

    }//GEN-LAST:event_AddStudentMenuActionPerformed

    private void AddSubjectMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSubjectMenuActionPerformed
        AddSubjectUIObj = new AddSubjectUI();
        AddSubjectUIObj.setVisible(true);
        this.hide();
    }//GEN-LAST:event_AddSubjectMenuActionPerformed

    private void AddSubjectHandlingMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSubjectHandlingMenuActionPerformed
        AddSubjectHandlingUIObj = new AddSubjectHandlingUI();
        AddSubjectHandlingUIObj.setVisible(true);
        this.hide();
    }//GEN-LAST:event_AddSubjectHandlingMenuActionPerformed

    private void ViewStudentMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewStudentMenuActionPerformed
        StudentViewAndModificationObj = new StudentViewAndModification();
        StudentViewAndModificationObj.setVisible(true);
        this.hide();
    }//GEN-LAST:event_ViewStudentMenuActionPerformed

    private void ViewSubjectMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewSubjectMenuActionPerformed
        ViewSubjectUIObj = new ViewSubjectUI();
        ViewSubjectUIObj.setVisible(true);
        this.hide();
    }//GEN-LAST:event_ViewSubjectMenuActionPerformed

    private void ViewSubjectHandlingMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewSubjectHandlingMenuActionPerformed
        ViewSubjectHandlingUIObj = new ViewSubjectHandlingUI();
        ViewSubjectHandlingUIObj.setVisible(true);
        this.hide();
    }//GEN-LAST:event_ViewSubjectHandlingMenuActionPerformed

    private void AddDepartmentMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddDepartmentMenuActionPerformed
        DepartmentDetailsObj = new DepartmentDetails("Add");
        DepartmentDetailsObj.setVisible(true);
        this.hide();
    }//GEN-LAST:event_AddDepartmentMenuActionPerformed

    private void selectHODMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectHODMenuActionPerformed
        HODSelectorUIObj = new HODSelectorUI("MainUIPointer", 0);
        HODSelectorUIObj.setVisible(true);
        this.hide();
    }//GEN-LAST:event_selectHODMenuActionPerformed

    private void SMLModifyMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMLModifyMenuActionPerformed
        SubjectMarksLimitManagerUIObj = new SubjectMarksLimitManagerUI();
        SubjectMarksLimitManagerUIObj.setVisible(true);
        this.hide();
    }//GEN-LAST:event_SMLModifyMenuActionPerformed

    private void ViewModifyDeptMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewModifyDeptMenuActionPerformed
        DepartmentDetailsObj = new DepartmentDetails("View");
        DepartmentDetailsObj.setVisible(true);
        this.hide();
    }//GEN-LAST:event_ViewModifyDeptMenuActionPerformed

    private void MarksAddViewModifyMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarksAddViewModifyMenuActionPerformed
        AddViewModifyMarksObj = new AddViewModifyMarks();
        AddViewModifyMarksObj.setVisible(true);
        this.hide();
    }//GEN-LAST:event_MarksAddViewModifyMenuActionPerformed

    private void AddFacultyMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddFacultyMenuActionPerformed
        AddFacultyObj = new AddFaculty();
        AddFacultyObj.setVisible(true);
        this.hide();
    }//GEN-LAST:event_AddFacultyMenuActionPerformed

    private void viewStudentMarkMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStudentMarkMenuActionPerformed
        findStudentObj = new findStudent();
        findStudentObj.setVisible(true);
        this.hide();
    }//GEN-LAST:event_viewStudentMarkMenuActionPerformed

    private void changePassMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePassMenuActionPerformed
        ChangeUserDetailsObj = new ChangeUserDetails();
        ChangeUserDetailsObj.setVisible(true);
        this.hide();
    }//GEN-LAST:event_changePassMenuActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
//        AboutUsUIObj = new AboutUsUI();
//        AboutUsUIObj.setVisible(true);
//        this.hide();
    }//GEN-LAST:event_aboutActionPerformed

    private void helpMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuActionPerformed
        try {
            Runtime.getRuntime().exec("hh.exe Main_package\\resources\\help.chm");
        } catch (IOException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_helpMenuActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AddDepartmentMenu;
    private javax.swing.JMenuItem AddFacultyMenu;
    private javax.swing.JMenu AddMenu;
    private javax.swing.JMenuItem AddStudentMenu;
    private javax.swing.JMenuItem AddSubjectHandlingMenu;
    private javax.swing.JMenuItem AddSubjectMenu;
    private javax.swing.JMenu AdminMenuUserAccounts;
    private javax.swing.JMenuItem ExitMenu;
    private javax.swing.JMenuItem MarksAddViewModifyMenu;
    private javax.swing.JMenu MarksEntryMenu;
    private javax.swing.JMenuItem MenuAddUser;
    private javax.swing.JMenu MenuCurrentUserName;
    private javax.swing.JMenuItem MenuGeneralSettings;
    private javax.swing.JMenu MenuUserAccounts;
    private javax.swing.JMenuItem MenuViewUser;
    private javax.swing.JMenuItem ReLogin;
    private javax.swing.JMenuItem SMLModifyMenu;
    private javax.swing.JMenuItem ViewFacultyMenu;
    private javax.swing.JMenu ViewMenu;
    private javax.swing.JMenuItem ViewModifyDeptMenu;
    private javax.swing.JMenuItem ViewStudentMenu;
    private javax.swing.JMenuItem ViewSubjectHandlingMenu;
    private javax.swing.JMenuItem ViewSubjectMenu;
    private javax.swing.JMenuItem about;
    private javax.swing.JMenuItem changePassMenu;
    private javax.swing.JMenu help;
    private javax.swing.JMenuItem helpMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem selectHODMenu;
    public static javax.swing.JMenuItem viewStudentMarkMenu;
    // End of variables declaration//GEN-END:variables

    public void setUsername(String newUsername) {
        UserName = newUsername;
        MenuCurrentUserName.setText(UserName);
    }

    private void hierarchy() {
        if ("tempAdmin".equalsIgnoreCase(privilege)) {
            hierachyTempAdmin();
        } else if ("hod".equalsIgnoreCase(privilege)) {
            hierachyHOD();
        } else if ("faculty".equalsIgnoreCase(privilege)) {
            hierachyFaculty();
        } else if ("other".equalsIgnoreCase(privilege)) {
            hierachyOther();
        }

    }

    private void hierachyTempAdmin() {

        AddDepartmentMenu.setEnabled(false);
        selectHODMenu.setEnabled(false);
        SMLModifyMenu.setEnabled(false);
        MenuUserAccounts.setEnabled(false);
        MenuGeneralSettings.setEnabled(false);
    }

    private void hierachyHOD() {
        // throw new UnsupportedOperationException("Not yet implemented");
        AddStudentMenu.setEnabled(false);
        AddFacultyMenu.setEnabled(false);
        AddDepartmentMenu.setEnabled(false);
        selectHODMenu.setEnabled(false);
        MenuUserAccounts.setEnabled(false);
        MenuGeneralSettings.setEnabled(false);
    }

    private void hierachyFaculty() {
        AddStudentMenu.setEnabled(false);
        AddFacultyMenu.setEnabled(false);
        AddSubjectMenu.setEnabled(false);
        AddSubjectHandlingMenu.setEnabled(false);
        AddDepartmentMenu.setEnabled(false);
        selectHODMenu.setEnabled(false);
        MenuUserAccounts.setEnabled(false);
        MenuGeneralSettings.setEnabled(false);
    }

    private void hierachyOther() {
        AddStudentMenu.setEnabled(false);
        AddFacultyMenu.setEnabled(false);
        AddSubjectMenu.setEnabled(false);
        AddSubjectHandlingMenu.setEnabled(false);
        AddDepartmentMenu.setEnabled(false);
        selectHODMenu.setEnabled(false);
        MenuUserAccounts.setEnabled(false);
        MenuGeneralSettings.setEnabled(false);
    }

    public String getPrivilege() {
        return privilege;
    }

    public String getDept() {
        return Dept;
    }

    public String getUFN() {
        return UFN;
    }

    private void getProfile() {
        try {
            String getUFN = "select * from login where User=\"" + UserName + "\"";
            ResultSet rs2 = dbConnect.getCon().createStatement().executeQuery(getUFN);
            if (!rs2.next()) {
                //Control is never supposed to come here
                JOptionPane.showMessageDialog(this, "You are not supposed to see this.. please contact developers.. errcode -343243498");
                this.dispose();
            }

            UFN = rs2.getString("F_UFN");

            //if(UFN==null) System.out.println("Hurray");
            if (UFN != null) {
                String getDept = "select D_DeptCode from faculty where UFN=\"" + UFN + "\"";
                ResultSet rs1 = dbConnect.getCon().createStatement().executeQuery(getDept);
                if (!rs1.next()) {
                    //Control is never supposed to come here
                    JOptionPane.showMessageDialog(this, "You are not supposed to see this.. please contact developers.. errcode -343233498");
                    this.dispose();
                }
                Dept = rs1.getString("D_DeptCode");
            }


        } catch (SQLException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
