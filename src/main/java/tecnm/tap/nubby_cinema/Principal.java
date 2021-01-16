/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnm.tap.nubby_cinema;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.GraphicsEnvironment;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import org.edisoncor.gui.panel.Panel;
import org.json.simple.JSONArray;

/**
 *
 * @author Rayfi
 */
public class Principal extends javax.swing.JFrame {
    int cantCartelera;
    ArrayList<JLabel> labelsCartelera;
    JSONArray cartelera;
    JLabel labelReturnSideBar;
    CardLayout cards;
    int sliderPosition = 0;
    boolean logedIn = false;

    public Principal() {
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        initComponents();
        initComponents(true);
        cards = (CardLayout)(panelCards).getLayout();
    }
    
    private void initDatosUsuario(){
    
    }
    
    private void initComponents(boolean opc){
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setLocationRelativeTo(null);
        labelLogo.setIcon(new ImageIcon(new ImageIcon("C:\\Cine\\Nubby_Cinema\\src\\main\\java\\tecnm\\tap\\nubby_cinema\\Resources\\Images\\LogoInicio.png").getImage().getScaledInstance(200,100, Image.SCALE_AREA_AVERAGING)));
        labelNavBar.setIcon(new ImageIcon(new ImageIcon("C:\\Cine\\Nubby_Cinema\\src\\main\\java\\tecnm\\tap\\nubby_cinema\\Resources\\Images\\navBar1920.png").getImage().getScaledInstance(1920,100, Image.SCALE_AREA_AVERAGING)));
        //initCartelera();
        cards = (CardLayout)(panelCards.getLayout());
        
        
    }
    
    /*private void initCartelera(){
        JPanel[] arr = new JPanel[5];
        Random ran = new Random();
        for (int i = 0; i < 5; i++) {
            arr[i] = new JPanel();
            arr[i].setSize(50,50);
            arr[i].setBackground(new Color(ran.nextInt(256)+1,ran.nextInt(256)+1,ran.nextInt(256)+1));
            cardCartelera.add(arr[i]);
        }
        cardCartelera.repaint();
    }*/
    
    /*private String[] takeImage(){
        File f = new File(getClass().getResource("/Images").getFile());
        String[] images = f.list();
        return images;
    }
    
    private void showinSlide(int index){
    
        String[] images = takeImage();
        String img = images[index];
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/"+img));
        Image image = icon.getImage().getScaledInstance(slider.getWidth(), slider.getHeight(), Image.SCALE_SMOOTH);
        slider.setIcon(new ImageIcon(image));
    }*/
    
    private void showLabelOptions(){
        labelReturnSideBar = new javax.swing.JLabel();
        labelReturnSideBar.setBackground(new java.awt.Color(255, 255, 255));
        labelReturnSideBar.setForeground(new java.awt.Color(255, 255, 255));
        labelReturnSideBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/icons/icons8_menu_32px.png"))); // NOI18N
        labelReturnSideBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelReturnSideBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelReturnSideBarMouseClicked(evt);
            }
        });
        javax.swing.GroupLayout panelCarteleraLayout = new javax.swing.GroupLayout(panelOpcionesButton);
        panelOpcionesButton.setLayout(panelCarteleraLayout);
        panelCarteleraLayout.setHorizontalGroup(
            panelCarteleraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCarteleraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelReturnSideBar)
                .addContainerGap(1051, Short.MAX_VALUE))
        );
        panelCarteleraLayout.setVerticalGroup(
            panelCarteleraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCarteleraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelReturnSideBar)
                .addContainerGap(427, Short.MAX_VALUE))
        );
    }
    /**/
    private void showSideBar(){
        sidePanel = new javax.swing.JPanel();
        panelImage3 = new org.edisoncor.gui.panel.PanelImage();
        
        sidePanel.setBackground(new java.awt.Color(51, 51, 51));
        sidePanel.setRequestFocusEnabled(false);
        
        panelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/icons/search_icnon_48px.png"))); // NOI18N

        javax.swing.GroupLayout panelImage3Layout = new javax.swing.GroupLayout(panelImage3);
        panelImage3.setLayout(panelImage3Layout);
        panelImage3Layout.setHorizontalGroup(
            panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );
        panelImage3Layout.setVerticalGroup(
            panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        
        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sidePanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(panelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                    .addComponent(jSeparator1)))
                            .addGroup(sidePanelLayout.createSequentialGroup()
                                .addComponent(labelUserIcon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(labelHideSideBar))
                    .addComponent(labelPeliculasIcon)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addComponent(labelCarteleraIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCartelera, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelHideSideBar)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelImage3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldBusqueda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelUserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addComponent(labelPeliculasIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCarteleraIcon))
                    .addComponent(btnCartelera, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        navBar = new javax.swing.JPanel();
        labelNavBar = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelMinimize = new javax.swing.JLabel();
        labelMaximize = new javax.swing.JLabel();
        labelClose = new javax.swing.JLabel();
        panelPrincipal = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        panelImage3 = new org.edisoncor.gui.panel.PanelImage();
        labelHideSideBar = new javax.swing.JLabel();
        fieldBusqueda = new javax.swing.JTextField();
        labelUserIcon = new javax.swing.JLabel();
        btnCuenta = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        labelPeliculasIcon = new javax.swing.JLabel();
        labelCarteleraIcon = new javax.swing.JLabel();
        btnCartelera = new javax.swing.JButton();
        panelOpcionesButton = new javax.swing.JPanel();
        panelCards = new javax.swing.JPanel();
        cardPrincipal = new javax.swing.JPanel();
        slider = new javax.swing.JLabel();
        labelRight = new javax.swing.JLabel();
        labelLeft = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cardCuenta = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        fieldContraseniaLogIn = new javax.swing.JPasswordField();
        fieldUsuarioLogIn = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        labelRegistro = new javax.swing.JLabel();
        cardCartelera = new javax.swing.JPanel();
        cardRegistro = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        fieldUsuarioSignUp = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        fieldContraseniaSignUp = new javax.swing.JPasswordField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        fieldCorreoSignUp = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        fieldNombreSignUp = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        fieldApellidosSignUp = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        fieldCelular = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        btnRegistro = new javax.swing.JButton();
        labelToLogin = new javax.swing.JLabel();
        cardAcceso = new javax.swing.JTabbedPane();
        panelInfoGeneral = new javax.swing.JPanel();
        panelHistorialCompras = new javax.swing.JPanel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(960, 540, 0, 0));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1920, 1080));
        setType(java.awt.Window.Type.POPUP);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        navBar.setBackground(new java.awt.Color(205, 76, 76));
        navBar.setPreferredSize(new java.awt.Dimension(960, 80));

        labelLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelLogoMouseClicked(evt);
            }
        });

        labelMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/icons/icons8_minimize_window_48px_1.png"))); // NOI18N
        labelMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMinimizeMouseClicked(evt);
            }
        });

        labelMaximize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/icons/icons8_maximize_window_48px.png"))); // NOI18N
        labelMaximize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMaximizeMouseClicked(evt);
            }
        });

        labelClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/icons/icons8_cancel_48px.png"))); // NOI18N
        labelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout navBarLayout = new javax.swing.GroupLayout(navBar);
        navBar.setLayout(navBarLayout);
        navBarLayout.setHorizontalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelNavBar, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(labelMinimize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelMaximize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelClose)
                .addContainerGap())
        );
        navBarLayout.setVerticalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelNavBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(navBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addGroup(navBarLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(navBarLayout.createSequentialGroup()
                .addGroup(navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelClose)
                    .addComponent(labelMinimize)
                    .addComponent(labelMaximize))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        sidePanel.setBackground(new java.awt.Color(51, 51, 51));
        sidePanel.setRequestFocusEnabled(false);

        panelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/icons/search_icnon_48px.png"))); // NOI18N

        javax.swing.GroupLayout panelImage3Layout = new javax.swing.GroupLayout(panelImage3);
        panelImage3.setLayout(panelImage3Layout);
        panelImage3Layout.setHorizontalGroup(
            panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );
        panelImage3Layout.setVerticalGroup(
            panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        labelHideSideBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/icons/icons8_back_to_24px.png"))); // NOI18N
        labelHideSideBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelHideSideBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelHideSideBarMouseClicked(evt);
            }
        });

        fieldBusqueda.setBackground(new java.awt.Color(51, 51, 51));
        fieldBusqueda.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        fieldBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        fieldBusqueda.setAutoscrolls(false);
        fieldBusqueda.setBorder(null);

        labelUserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/icons/user_male.png"))); // NOI18N

        btnCuenta.setBackground(new java.awt.Color(51, 51, 51));
        btnCuenta.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        btnCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnCuenta.setText("Mi cuenta");
        btnCuenta.setBorder(null);
        btnCuenta.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnCuentaMouseDragged(evt);
            }
        });
        btnCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentaActionPerformed(evt);
            }
        });

        labelCarteleraIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/icons/cartelera.png"))); // NOI18N

        btnCartelera.setBackground(new java.awt.Color(51, 51, 51));
        btnCartelera.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        btnCartelera.setForeground(new java.awt.Color(255, 255, 255));
        btnCartelera.setText("Ver catálogo");
        btnCartelera.setBorder(null);
        btnCartelera.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnCarteleraMouseDragged(evt);
            }
        });
        btnCartelera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarteleraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sidePanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(panelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                    .addComponent(jSeparator1)))
                            .addGroup(sidePanelLayout.createSequentialGroup()
                                .addComponent(labelUserIcon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(labelHideSideBar))
                    .addComponent(labelPeliculasIcon)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addComponent(labelCarteleraIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCartelera, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelHideSideBar)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelImage3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldBusqueda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelUserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addComponent(labelPeliculasIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCarteleraIcon))
                    .addComponent(btnCartelera, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelOpcionesButton.setLayout(new java.awt.CardLayout());

        panelCards.setLayout(new java.awt.CardLayout());

        cardPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        slider.setBackground(new java.awt.Color(102, 102, 255));
        slider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/CONOCE NUESTRA PROMOCIONES.png"))); // NOI18N

        labelRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/icons/icons8_right_angle_parentheses_key_48px.png"))); // NOI18N
        labelRight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRightMouseClicked(evt);
            }
        });

        labelLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/icons/icons8_left_angle_parentheses_key_48px.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/icons/icons8_facebook_circled_48px.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/icons/icons8_twitter_squared_48px.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/icons/icons8_instagram_48px.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/icons/icons8_google_play_48px.png"))); // NOI18N

        javax.swing.GroupLayout cardPrincipalLayout = new javax.swing.GroupLayout(cardPrincipal);
        cardPrincipal.setLayout(cardPrincipalLayout);
        cardPrincipalLayout.setHorizontalGroup(
            cardPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPrincipalLayout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addGroup(cardPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cardPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(cardPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(cardPrincipalLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(labelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelRight, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
        );
        cardPrincipalLayout.setVerticalGroup(
            cardPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRight, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 373, Short.MAX_VALUE)
                .addGroup(cardPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(cardPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(cardPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(cardPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        panelCards.add(cardPrincipal, "cardPrincipal");

        cardCuenta.setBackground(new java.awt.Color(255, 255, 255));
        cardCuenta.setForeground(new java.awt.Color(255, 255, 255));
        cardCuenta.setName("cardCuenta"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 36)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/LOGIN.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel3.setText("Ingrese usuario");

        jLabel12.setText("Ingrese contraseña");

        fieldContraseniaLogIn.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        fieldContraseniaLogIn.setText("jPasswordField2");
        fieldContraseniaLogIn.setBorder(null);

        fieldUsuarioLogIn.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        fieldUsuarioLogIn.setBorder(null);
        fieldUsuarioLogIn.setCaretColor(new java.awt.Color(60, 63, 65));
        fieldUsuarioLogIn.setSelectionColor(new java.awt.Color(60, 63, 65));

        btnLogin.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/icons/iconReturnSideBar.png"))); // NOI18N
        btnLogin.setText("Iniciar Sesión");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel15.setText("¿No tienes una cuenta?");

        labelRegistro.setBackground(new java.awt.Color(255, 255, 255));
        labelRegistro.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        labelRegistro.setForeground(new java.awt.Color(51, 153, 255));
        labelRegistro.setText("Registrate aquí");
        labelRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRegistroMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout cardCuentaLayout = new javax.swing.GroupLayout(cardCuenta);
        cardCuenta.setLayout(cardCuentaLayout);
        cardCuentaLayout.setHorizontalGroup(
            cardCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardCuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cardCuentaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(321, 321, 321))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cardCuentaLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cardCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cardCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fieldUsuarioLogIn, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator2))
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(cardCuentaLayout.createSequentialGroup()
                        .addGroup(cardCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cardCuentaLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnLogin))
                            .addGroup(cardCuentaLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(cardCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addGroup(cardCuentaLayout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelRegistro))
                                    .addComponent(fieldContraseniaLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(196, 196, 196))
        );
        cardCuentaLayout.setVerticalGroup(
            cardCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardCuentaLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cardCuentaLayout.createSequentialGroup()
                        .addGroup(cardCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(fieldUsuarioLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(cardCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldContraseniaLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogin)
                .addGap(166, 166, 166)
                .addGroup(cardCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(labelRegistro))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        panelCards.add(cardCuenta, "cardCuenta");

        cardCartelera.setBackground(new java.awt.Color(255, 51, 51));
        cardCartelera.setName("cardCartelera"); // NOI18N

        javax.swing.GroupLayout cardCarteleraLayout = new javax.swing.GroupLayout(cardCartelera);
        cardCartelera.setLayout(cardCarteleraLayout);
        cardCarteleraLayout.setHorizontalGroup(
            cardCarteleraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 846, Short.MAX_VALUE)
        );
        cardCarteleraLayout.setVerticalGroup(
            cardCarteleraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 671, Short.MAX_VALUE)
        );

        panelCards.add(cardCartelera, "cardCartelera");

        cardRegistro.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/SIGNUP.png"))); // NOI18N

        fieldUsuarioSignUp.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        fieldUsuarioSignUp.setBorder(null);
        fieldUsuarioSignUp.setCaretColor(new java.awt.Color(60, 63, 65));
        fieldUsuarioSignUp.setSelectionColor(new java.awt.Color(60, 63, 65));

        jLabel18.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel18.setText("Usuario");

        jLabel21.setText("Contraseña");

        fieldContraseniaSignUp.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        fieldContraseniaSignUp.setText("jPasswordField2");
        fieldContraseniaSignUp.setBorder(null);

        jLabel24.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel24.setText("Correo");

        fieldCorreoSignUp.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        fieldCorreoSignUp.setBorder(null);
        fieldCorreoSignUp.setCaretColor(new java.awt.Color(60, 63, 65));
        fieldCorreoSignUp.setSelectionColor(new java.awt.Color(60, 63, 65));

        fieldNombreSignUp.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        fieldNombreSignUp.setBorder(null);
        fieldNombreSignUp.setCaretColor(new java.awt.Color(60, 63, 65));
        fieldNombreSignUp.setSelectionColor(new java.awt.Color(60, 63, 65));

        jLabel28.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel28.setText("Nombre");

        fieldApellidosSignUp.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        fieldApellidosSignUp.setBorder(null);
        fieldApellidosSignUp.setCaretColor(new java.awt.Color(60, 63, 65));
        fieldApellidosSignUp.setSelectionColor(new java.awt.Color(60, 63, 65));

        jLabel31.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel31.setText("Apellidos");

        fieldCelular.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        fieldCelular.setBorder(null);
        fieldCelular.setCaretColor(new java.awt.Color(60, 63, 65));
        fieldCelular.setSelectionColor(new java.awt.Color(60, 63, 65));

        jLabel33.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel33.setText("Celular (Opcional)");

        btnRegistro.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        btnRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/icons/iconReturnSideBar.png"))); // NOI18N
        btnRegistro.setText("Registrarse");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        labelToLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/icons/icons8_back_to_24px.png"))); // NOI18N
        labelToLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelToLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelToLoginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout cardRegistroLayout = new javax.swing.GroupLayout(cardRegistro);
        cardRegistro.setLayout(cardRegistroLayout);
        cardRegistroLayout.setHorizontalGroup(
            cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardRegistroLayout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cardRegistroLayout.createSequentialGroup()
                                .addComponent(fieldContraseniaSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(327, 327, 327))
                            .addGroup(cardRegistroLayout.createSequentialGroup()
                                .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(cardRegistroLayout.createSequentialGroup()
                                        .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(fieldUsuarioSignUp)
                                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel18))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(cardRegistroLayout.createSequentialGroup()
                        .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cardRegistroLayout.createSequentialGroup()
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldNombreSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cardRegistroLayout.createSequentialGroup()
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldApellidosSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnRegistro)
                                .addGroup(cardRegistroLayout.createSequentialGroup()
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel33)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(cardRegistroLayout.createSequentialGroup()
                        .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cardRegistroLayout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21))
                            .addGroup(cardRegistroLayout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldCorreoSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cardRegistroLayout.createSequentialGroup()
                                .addComponent(labelToLogin)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel17)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        cardRegistroLayout.setVerticalGroup(
            cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelToLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cardRegistroLayout.createSequentialGroup()
                        .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(fieldUsuarioSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(8, 8, 8)
                .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldContraseniaSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cardRegistroLayout.createSequentialGroup()
                        .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(fieldCorreoSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cardRegistroLayout.createSequentialGroup()
                        .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(fieldNombreSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cardRegistroLayout.createSequentialGroup()
                        .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(fieldApellidosSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(fieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistro)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        panelCards.add(cardRegistro, "cardRegistro");

        javax.swing.GroupLayout panelInfoGeneralLayout = new javax.swing.GroupLayout(panelInfoGeneral);
        panelInfoGeneral.setLayout(panelInfoGeneralLayout);
        panelInfoGeneralLayout.setHorizontalGroup(
            panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 844, Short.MAX_VALUE)
        );
        panelInfoGeneralLayout.setVerticalGroup(
            panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 645, Short.MAX_VALUE)
        );

        cardAcceso.addTab("Informacion de la cuenta", panelInfoGeneral);

        javax.swing.GroupLayout panelHistorialComprasLayout = new javax.swing.GroupLayout(panelHistorialCompras);
        panelHistorialCompras.setLayout(panelHistorialComprasLayout);
        panelHistorialComprasLayout.setHorizontalGroup(
            panelHistorialComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 844, Short.MAX_VALUE)
        );
        panelHistorialComprasLayout.setVerticalGroup(
            panelHistorialComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 645, Short.MAX_VALUE)
        );

        cardAcceso.addTab("Historial de compas", panelHistorialCompras);

        panelCards.add(cardAcceso, "card6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navBar, javax.swing.GroupLayout.DEFAULT_SIZE, 1226, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelOpcionesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(navBar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelOpcionesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged

    }//GEN-LAST:event_formWindowStateChanged

    private void labelHideSideBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHideSideBarMouseClicked
        panelPrincipal.remove(sidePanel);
        panelPrincipal.repaint();
        showLabelOptions();
    }//GEN-LAST:event_labelHideSideBarMouseClicked

    private void btnCuentaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCuentaMouseDragged
       
    }//GEN-LAST:event_btnCuentaMouseDragged

    private void btnCarteleraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCarteleraMouseDragged
       
    }//GEN-LAST:event_btnCarteleraMouseDragged

    private void btnCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentaActionPerformed
        cards.show(panelCards, "cardCuenta");
        if(!logedIn){
            
        }
    }//GEN-LAST:event_btnCuentaActionPerformed

    private void btnCarteleraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarteleraActionPerformed
        cards.show(panelCards, "cardCartelera");
    }//GEN-LAST:event_btnCarteleraActionPerformed

    private void labelLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLogoMouseClicked
        cards.show(panelCards, "cardPrincipal");
    }//GEN-LAST:event_labelLogoMouseClicked

    private void labelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_labelCloseMouseClicked

    private void labelMaximizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMaximizeMouseClicked
        if(this.getExtendedState() != JFrame.MAXIMIZED_BOTH){
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        else{
            this.setState(JFrame.NORMAL);
        }
    }//GEN-LAST:event_labelMaximizeMouseClicked

    private void labelMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMinimizeMouseClicked
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_labelMinimizeMouseClicked

    private void labelRightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRightMouseClicked
        /*new Thread();
        try {
            Thread.sleep(300);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int p = this.slider.getX();
        
        if(p > -1){
            
        }
        sliderPosition++;
        if(sliderPosition>=takeImage().length){
            sliderPosition=takeImage().length-1;
        }
        showinSlide(sliderPosition);*/
    }//GEN-LAST:event_labelRightMouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void labelRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRegistroMouseClicked
        cards.show(panelCards, "cardRegistro");
    }//GEN-LAST:event_labelRegistroMouseClicked

    private void labelToLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelToLoginMouseClicked
        cards.show(panelCards, "cardCuenta");
    }//GEN-LAST:event_labelToLoginMouseClicked
    
    private void labelReturnSideBarMouseClicked(MouseEvent evt) {
        showSideBar();
        panelOpcionesButton.remove(labelReturnSideBar);
        panelPrincipal.repaint();
    }

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCartelera;
    private javax.swing.JButton btnCuenta;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JTabbedPane cardAcceso;
    private javax.swing.JPanel cardCartelera;
    private javax.swing.JPanel cardCuenta;
    private javax.swing.JPanel cardPrincipal;
    private javax.swing.JPanel cardRegistro;
    private javax.swing.JTextField fieldApellidosSignUp;
    private javax.swing.JTextField fieldBusqueda;
    private javax.swing.JTextField fieldCelular;
    private javax.swing.JPasswordField fieldContraseniaLogIn;
    private javax.swing.JPasswordField fieldContraseniaSignUp;
    private javax.swing.JTextField fieldCorreoSignUp;
    private javax.swing.JTextField fieldNombreSignUp;
    private javax.swing.JTextField fieldUsuarioLogIn;
    private javax.swing.JTextField fieldUsuarioSignUp;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel labelCarteleraIcon;
    private javax.swing.JLabel labelClose;
    private javax.swing.JLabel labelHideSideBar;
    private javax.swing.JLabel labelLeft;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelMaximize;
    private javax.swing.JLabel labelMinimize;
    private javax.swing.JLabel labelNavBar;
    private javax.swing.JLabel labelPeliculasIcon;
    private javax.swing.JLabel labelRegistro;
    private javax.swing.JLabel labelRight;
    private javax.swing.JLabel labelToLogin;
    private javax.swing.JLabel labelUserIcon;
    private javax.swing.JPanel navBar;
    private javax.swing.JPanel panelCards;
    private javax.swing.JPanel panelHistorialCompras;
    private org.edisoncor.gui.panel.PanelImage panelImage3;
    private javax.swing.JPanel panelInfoGeneral;
    private javax.swing.JPanel panelOpcionesButton;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JLabel slider;
    // End of variables declaration//GEN-END:variables
        
}