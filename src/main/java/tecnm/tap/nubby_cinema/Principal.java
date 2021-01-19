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
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
import org.json.simple.JSONObject;
//import tecnm.tap.nubby_cinema.Networking.*;
import com.google.gson.*;
import com.github.kevinsawicki.http.HttpRequest;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JScrollPane;
import org.edisoncor.gui.panel.PanelImage;

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
    JsonObject usuario;
    
    
    
    public Principal() {
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        initComponents();
        initComponents(true);
        cards = (CardLayout)(panelCards).getLayout();
    }
    
    private void initCartelera(){
        String response = HttpRequest.post("http://localhost:80/Phpfiles/ver_catalogo.php").send("table=peliculas").body();
        JsonObject jsonRecived = new JsonParser().parse(response).getAsJsonObject();
        JsonArray cartelera = jsonRecived.get("output").getAsJsonArray();
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        
        for (int i = 0; i < cartelera.size(); i++) {
            JsonObject pelicula = cartelera.get(i).getAsJsonObject();
            JLabel portada = new JLabel();
            portada.setSize(215, 319);
            String a = pelicula.get("nombre_pelicula").toString();
            String b = a.substring(1,a.length()-1);
            portada.setIcon(new ImageIcon("C:\\Cine\\Nubby_Cinema\\src\\main\\java\\tecnm\\tap\\nubby_cinema\\Resources\\Images\\Portadas Peliculas\\"+b+".png"));
            portada.setCursor(new Cursor(HAND_CURSOR));
            portada.addMouseListener(new PortadaListener(i, portada, pelicula));
            
            panelPeliculas.add(portada);
        }

        cardCartelera.repaint();
    }
    
    private void initComponents(boolean opc){
        setLocationRelativeTo(null);
        labelLogo.setIcon(new ImageIcon(new ImageIcon("C:\\Cine\\Nubby_Cinema\\src\\main\\java\\tecnm\\tap\\nubby_cinema\\Resources\\Images\\LogoInicio.png").getImage().getScaledInstance(200,100, Image.SCALE_AREA_AVERAGING)));
        labelNavBar.setIcon(new ImageIcon(new ImageIcon("C:\\Cine\\Nubby_Cinema\\src\\main\\java\\tecnm\\tap\\nubby_cinema\\Resources\\Images\\navBar1920.png").getImage().getScaledInstance(1920,100, Image.SCALE_AREA_AVERAGING)));
        cards = (CardLayout)(panelCards.getLayout());
        initCartelera();
        CheckSession();
    }
    
    private void CheckSession(){
        try {
            File loged = new File("loged.json");
            if(loged.exists()){
                String datosUsuario = new String(Files.readAllBytes(Paths.get("loged.json")));
                JsonObject jsonReaded = new JsonParser().parse(datosUsuario).getAsJsonObject();
                this.usuario = jsonReaded;
                cargarUsuario(usuario,true);
                
            }
        } catch (Exception e) {
        }
        
    }
    
    
    /*private void initCartelera(){
        
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
        labelFacebook = new javax.swing.JLabel();
        labelTwitter = new javax.swing.JLabel();
        labelInstagram = new javax.swing.JLabel();
        labelPlayStore = new javax.swing.JLabel();
        labelPeli1 = new javax.swing.JLabel();
        labelPeli2 = new javax.swing.JLabel();
        labelPeli3 = new javax.swing.JLabel();
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
        boxSesion = new javax.swing.JCheckBox();
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
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldUsuarioAcceso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fieldNombreAcceso = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fieldApellidosAcceso = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        fieldCorreoAcceso = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        fieldCelularAcceso = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        labelDisconnect = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        panelHistorialCompras = new javax.swing.JPanel();
        cardCartelera = new javax.swing.JPanel();
        jsp = new javax.swing.JScrollPane();
        panelPeliculas = new org.edisoncor.gui.panel.PanelImage();
        cardPelicula = new javax.swing.JPanel();
        bannerPelicula = new org.edisoncor.gui.panel.PanelImage();
        panelsPelicula = new javax.swing.JTabbedPane();
        panelSinopsis = new javax.swing.JPanel();
        labelNombrePelicula = new javax.swing.JLabel();
        labelDirectorPelicula = new javax.swing.JLabel();
        labelDuracionPelicula = new javax.swing.JLabel();
        labelCategoriaPelicula = new javax.swing.JLabel();
        labelGenero = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaSinopsis = new javax.swing.JTextArea();
        panelHorarios = new javax.swing.JPanel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 219, Short.MAX_VALUE)
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

        labelFacebook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/icons/icons8_facebook_circled_48px.png"))); // NOI18N

        labelTwitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/icons/icons8_twitter_squared_48px.png"))); // NOI18N

        labelInstagram.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/icons/icons8_instagram_48px.png"))); // NOI18N

        labelPlayStore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/icons/icons8_google_play_48px.png"))); // NOI18N

        labelPeli1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/Portadas Peliculas/Mujer Maravilla 1984.png"))); // NOI18N

        labelPeli2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/Portadas Peliculas/Estación Zombie 2 Península.png"))); // NOI18N

        labelPeli3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/Portadas Peliculas/El Tiempo Contigo.png"))); // NOI18N

        javax.swing.GroupLayout cardPrincipalLayout = new javax.swing.GroupLayout(cardPrincipal);
        cardPrincipal.setLayout(cardPrincipalLayout);
        cardPrincipalLayout.setHorizontalGroup(
            cardPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPrincipalLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(cardPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cardPrincipalLayout.createSequentialGroup()
                        .addComponent(labelFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelPlayStore, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cardPrincipalLayout.createSequentialGroup()
                            .addComponent(labelLeft)
                            .addGap(18, 18, 18)
                            .addComponent(slider)
                            .addGap(18, 18, 18)
                            .addComponent(labelRight))
                        .addGroup(cardPrincipalLayout.createSequentialGroup()
                            .addComponent(labelPeli1)
                            .addGap(45, 45, 45)
                            .addComponent(labelPeli2)
                            .addGap(45, 45, 45)
                            .addComponent(labelPeli3))))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        cardPrincipalLayout.setVerticalGroup(
            cardPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRight, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cardPrincipalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(134, 134, 134)
                .addGroup(cardPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPeli1)
                    .addComponent(labelPeli2)
                    .addComponent(labelPeli3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(cardPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPlayStore, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

        boxSesion.setBackground(new java.awt.Color(51, 51, 51));
        boxSesion.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        boxSesion.setForeground(new java.awt.Color(204, 204, 204));
        boxSesion.setText("Recordarme");
        boxSesion.setBorder(null);

        javax.swing.GroupLayout cardCuentaLayout = new javax.swing.GroupLayout(cardCuenta);
        cardCuenta.setLayout(cardCuentaLayout);
        cardCuentaLayout.setHorizontalGroup(
            cardCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardCuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cardCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(cardCuentaLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelRegistro))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardCuentaLayout.createSequentialGroup()
                                .addGroup(cardCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(cardCuentaLayout.createSequentialGroup()
                                        .addComponent(boxSesion)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnLogin))
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldContraseniaLogIn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
                                .addGap(182, 182, 182)))
                        .addGap(18, 18, Short.MAX_VALUE)
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
                .addComponent(fieldContraseniaLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cardCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogin)
                    .addComponent(boxSesion)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(160, 160, 160)
                .addGroup(cardCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(labelRegistro))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        panelCards.add(cardCuenta, "cardCuenta");

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
                .addContainerGap(89, Short.MAX_VALUE))
        );

        panelCards.add(cardRegistro, "cardRegistro");

        panelInfoGeneral.setBackground(new java.awt.Color(255, 255, 255));

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/usuarioAcceso.png"))); // NOI18N

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel5.setText("Usuario:");

        fieldUsuarioAcceso.setEditable(false);
        fieldUsuarioAcceso.setBackground(new java.awt.Color(255, 255, 255));
        fieldUsuarioAcceso.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        fieldUsuarioAcceso.setBorder(null);
        fieldUsuarioAcceso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel7.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel7.setText("Nombre");

        fieldNombreAcceso.setEditable(false);
        fieldNombreAcceso.setBackground(new java.awt.Color(255, 255, 255));
        fieldNombreAcceso.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        fieldNombreAcceso.setBorder(null);
        fieldNombreAcceso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel9.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel9.setText("Apellidos");

        fieldApellidosAcceso.setEditable(false);
        fieldApellidosAcceso.setBackground(new java.awt.Color(255, 255, 255));
        fieldApellidosAcceso.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        fieldApellidosAcceso.setBorder(null);
        fieldApellidosAcceso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel35.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel35.setText("Correo");

        fieldCorreoAcceso.setEditable(false);
        fieldCorreoAcceso.setBackground(new java.awt.Color(255, 255, 255));
        fieldCorreoAcceso.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        fieldCorreoAcceso.setBorder(null);
        fieldCorreoAcceso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel36.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel36.setText("Telefono");

        fieldCelularAcceso.setEditable(false);
        fieldCelularAcceso.setBackground(new java.awt.Color(255, 255, 255));
        fieldCelularAcceso.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        fieldCelularAcceso.setBorder(null);
        fieldCelularAcceso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        labelDisconnect.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        labelDisconnect.setForeground(new java.awt.Color(51, 153, 255));
        labelDisconnect.setText("Desconectarse");
        labelDisconnect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelDisconnect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelDisconnectMouseClicked(evt);
            }
        });

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/INFORMACIÓN DE LA CUENTA.png"))); // NOI18N

        javax.swing.GroupLayout panelInfoGeneralLayout = new javax.swing.GroupLayout(panelInfoGeneral);
        panelInfoGeneral.setLayout(panelInfoGeneralLayout);
        panelInfoGeneralLayout.setHorizontalGroup(
            panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoGeneralLayout.createSequentialGroup()
                .addGroup(panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoGeneralLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addGroup(panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInfoGeneralLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jSeparator10, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelInfoGeneralLayout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addComponent(fieldUsuarioAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(panelInfoGeneralLayout.createSequentialGroup()
                                .addGroup(panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelInfoGeneralLayout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addGroup(panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jSeparator12, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(fieldNombreAcceso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(panelInfoGeneralLayout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel35)
                                            .addGroup(panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jSeparator14, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(fieldCorreoAcceso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(200, 200, 200)
                                .addGroup(panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelInfoGeneralLayout.createSequentialGroup()
                                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel36)
                                            .addGroup(panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jSeparator15, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(fieldCelularAcceso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(panelInfoGeneralLayout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addGroup(panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jSeparator13, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(fieldApellidosAcceso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGroup(panelInfoGeneralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelDisconnect))
                    .addGroup(panelInfoGeneralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel38)))
                .addGap(18, 254, Short.MAX_VALUE))
        );
        panelInfoGeneralLayout.setVerticalGroup(
            panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInfoGeneralLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldUsuarioAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoGeneralLayout.createSequentialGroup()
                        .addGroup(panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelInfoGeneralLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNombreAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInfoGeneralLayout.createSequentialGroup()
                        .addGroup(panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelInfoGeneralLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldApellidosAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68)
                .addGroup(panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoGeneralLayout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldCorreoAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInfoGeneralLayout.createSequentialGroup()
                        .addGroup(panelInfoGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInfoGeneralLayout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldCelularAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(labelDisconnect)
                .addContainerGap())
        );

        cardAcceso.addTab("Informacion de la cuenta", panelInfoGeneral);

        panelHistorialCompras.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelHistorialComprasLayout = new javax.swing.GroupLayout(panelHistorialCompras);
        panelHistorialCompras.setLayout(panelHistorialComprasLayout);
        panelHistorialComprasLayout.setHorizontalGroup(
            panelHistorialComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 907, Short.MAX_VALUE)
        );
        panelHistorialComprasLayout.setVerticalGroup(
            panelHistorialComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 679, Short.MAX_VALUE)
        );

        cardAcceso.addTab("Historial de compas", panelHistorialCompras);

        panelCards.add(cardAcceso, "cardAcceso");

        panelPeliculas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/fondoCartelera1080.png"))); // NOI18N
        panelPeliculas.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
        jsp.setViewportView(panelPeliculas);

        javax.swing.GroupLayout cardCarteleraLayout = new javax.swing.GroupLayout(cardCartelera);
        cardCartelera.setLayout(cardCarteleraLayout);
        cardCarteleraLayout.setHorizontalGroup(
            cardCarteleraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jsp, javax.swing.GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
        );
        cardCarteleraLayout.setVerticalGroup(
            cardCarteleraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jsp, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );

        panelCards.add(cardCartelera, "cardCartelera");

        bannerPelicula.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout bannerPeliculaLayout = new javax.swing.GroupLayout(bannerPelicula);
        bannerPelicula.setLayout(bannerPeliculaLayout);
        bannerPeliculaLayout.setHorizontalGroup(
            bannerPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        bannerPeliculaLayout.setVerticalGroup(
            bannerPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        panelsPelicula.setBackground(new java.awt.Color(255, 255, 255));

        panelSinopsis.setBackground(new java.awt.Color(255, 255, 255));

        labelNombrePelicula.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        labelNombrePelicula.setText("nombre_pelicula");

        labelDirectorPelicula.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelDirectorPelicula.setText("director");

        labelDuracionPelicula.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        labelDuracionPelicula.setText("Duración (min): ");

        labelCategoriaPelicula.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        labelCategoriaPelicula.setText("Categoría:");

        labelGenero.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        labelGenero.setText("genero");

        jLabel43.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel43.setText("Sinopsis:");

        areaSinopsis.setEditable(false);
        areaSinopsis.setBackground(new java.awt.Color(255, 255, 255));
        areaSinopsis.setColumns(20);
        areaSinopsis.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        areaSinopsis.setLineWrap(true);
        areaSinopsis.setRows(5);
        areaSinopsis.setWrapStyleWord(true);
        areaSinopsis.setBorder(null);
        jScrollPane1.setViewportView(areaSinopsis);

        javax.swing.GroupLayout panelSinopsisLayout = new javax.swing.GroupLayout(panelSinopsis);
        panelSinopsis.setLayout(panelSinopsisLayout);
        panelSinopsisLayout.setHorizontalGroup(
            panelSinopsisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSinopsisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSinopsisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSinopsisLayout.createSequentialGroup()
                        .addGroup(panelSinopsisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNombrePelicula)
                            .addComponent(labelDuracionPelicula)
                            .addComponent(labelCategoriaPelicula)
                            .addComponent(labelGenero)
                            .addComponent(jLabel43)
                            .addComponent(labelDirectorPelicula))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelSinopsisLayout.setVerticalGroup(
            panelSinopsisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSinopsisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNombrePelicula)
                .addGap(18, 18, 18)
                .addComponent(labelDirectorPelicula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDuracionPelicula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCategoriaPelicula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelGenero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelsPelicula.addTab("Sinopsis", panelSinopsis);

        panelHorarios.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelHorariosLayout = new javax.swing.GroupLayout(panelHorarios);
        panelHorarios.setLayout(panelHorariosLayout);
        panelHorariosLayout.setHorizontalGroup(
            panelHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 907, Short.MAX_VALUE)
        );
        panelHorariosLayout.setVerticalGroup(
            panelHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        panelsPelicula.addTab("Horarios Disponibles", panelHorarios);

        javax.swing.GroupLayout cardPeliculaLayout = new javax.swing.GroupLayout(cardPelicula);
        cardPelicula.setLayout(cardPeliculaLayout);
        cardPeliculaLayout.setHorizontalGroup(
            cardPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bannerPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelsPelicula)
        );
        cardPeliculaLayout.setVerticalGroup(
            cardPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPeliculaLayout.createSequentialGroup()
                .addComponent(bannerPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelsPelicula))
        );

        panelCards.add(cardPelicula, "cardPelicula");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navBar, javax.swing.GroupLayout.DEFAULT_SIZE, 1289, Short.MAX_VALUE)
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
        
        if(!logedIn){
            cards.show(panelCards, "cardCuenta");
        }
        else{
            cargarUsuario(usuario,false);
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

        String response = HttpRequest.post("http://localhost:80/Phpfiles/encuentra_usuario.php").send("usuario="+fieldUsuarioLogIn.getText().toLowerCase()+"&clave="+fieldContraseniaLogIn.getText()).body();
        JsonObject jsonRecived = new JsonParser().parse(response).getAsJsonObject();
        try{
            JsonObject output = jsonRecived.get("output").getAsJsonObject();
            JsonObject datosUsuario = output.get("0").getAsJsonObject();
            JOptionPane.showMessageDialog(null,"Inicio correcto");
            
            if(boxSesion.isSelected()){
                SaveSession(datosUsuario);
            }
            cargarUsuario(datosUsuario,false);
            
            
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(jsonRecived.toString());
            JOptionPane.showMessageDialog(null,"Usuario y/o contraseña incorrecta");
        }
        
        
        
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void cargarUsuario(JsonObject datosUsuario, boolean loaded) {
        System.out.println(datosUsuario.toString());
        
        this.usuario = datosUsuario;
        
        fieldUsuarioAcceso.setText(datosUsuario.get("usuario").toString().substring(1,datosUsuario.get("usuario").toString().length()-1));
        fieldNombreAcceso.setText(datosUsuario.get("nombre").toString().substring(1,datosUsuario.get("nombre").toString().length()-1));
        fieldApellidosAcceso.setText(datosUsuario.get("apellidos").toString().substring(1,datosUsuario.get("apellidos").toString().length()-1));
        fieldCorreoAcceso.setText(datosUsuario.get("correo").toString().substring(1,datosUsuario.get("correo").toString().length()-1));
        fieldCelularAcceso.setText(datosUsuario.get("celular").toString().substring(1,datosUsuario.get("celular").toString().length()-1));
        logedIn = true;
        
        if(!loaded)
            cards.show(panelCards, "cardAcceso");
        
        
    }
    
    private void SaveSession(JsonObject datosUsuario){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("loged.json"));
            bw.write(datosUsuario.toString());
            bw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void labelRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRegistroMouseClicked
        cards.show(panelCards, "cardRegistro");
    }//GEN-LAST:event_labelRegistroMouseClicked

    private void labelToLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelToLoginMouseClicked
        cards.show(panelCards, "cardCuenta");
    }//GEN-LAST:event_labelToLoginMouseClicked

    private void labelDisconnectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelDisconnectMouseClicked
        if(JOptionPane.showConfirmDialog(null,"¿Está seguro que desea cerrar sesión?") == 0){
            this.usuario = null;
            this.logedIn = false;
            cards.show(panelCards, "cardCuenta");

            File file = new File("loged.json");
            file.delete();
        }
    }//GEN-LAST:event_labelDisconnectMouseClicked
    
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
    
    private void SeleccionarPelicula(int id, JsonObject pelicula){
        cards.show(panelCards, "cardPelicula");
        
        String query = "qry=SELECT A.nombre_pelicula, B.genero FROM peliculas A INNER JOIN generos B ON A.id_genero = B.id_genero WHERE A.id_pelicula = "+id;
        String response = HttpRequest.post("http://localhost:80/Phpfiles/inner_join.php").send(query).body();
        JsonObject jsonRecived = new JsonParser().parse(response).getAsJsonObject();
        JsonObject output = jsonRecived.getAsJsonObject("output");
        JsonObject data = output.getAsJsonObject("0");
        
        String nombrePelicula = pelicula.get("nombre_pelicula").toString().substring(1,pelicula.get("nombre_pelicula").toString().length()-1);
        String duracion = String.valueOf(pelicula.get("duracion_minutos").toString().substring(1,pelicula.get("duracion_minutos").toString().length()-1));
        String categoria = String.valueOf(pelicula.get("categoria").toString().substring(1,pelicula.get("categoria").toString().length()-1));
        String director = String.valueOf(pelicula.get("director").toString().substring(1,pelicula.get("director").toString().length()-1));
        String sinopsis = String.valueOf(pelicula.get("Sinopsis").toString().substring(1,pelicula.get("Sinopsis").toString().length()-1));
        String genero = data.get("genero").toString().substring(1,data.get("genero").toString().length()-1);
        
        System.out.println("Se seleccionó: "+nombrePelicula);
        ImageIcon img = new ImageIcon(getClass().getResource("/tecnm/tap/nubby_cinema/Resources/Images/BannerPeliculas/"+nombrePelicula+"1.png"));
        labelNombrePelicula.setText(nombrePelicula);
        labelDirectorPelicula.setText("Director: "+director);
        labelDuracionPelicula.setText("Duración (min):"+duracion);
        labelGenero.setText(genero);
        labelCategoriaPelicula.setText("Categoría: "+categoria);
        areaSinopsis.setText(sinopsis);
        
        
        
        
        
        
        
        bannerPelicula.setIcon(img);
        
    }
    
    private class PortadaListener implements MouseListener{
        int id;
        JLabel label;
        JsonObject pelicula;
                
        public PortadaListener(int id, JLabel label, JsonObject pelicula) {
            this.id = id+1;
            this.label = label;
            this.pelicula = pelicula;
        }
        
       
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() == label){
                //JOptionPane.showMessageDialog(null, "Datos de la pelicula: \n"+pelicula.get("nombre_pelicula"));
                System.out.println("Id: "+id+"\n"+pelicula.toString());
                SeleccionarPelicula(id, pelicula);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
 
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
    
    
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaSinopsis;
    private org.edisoncor.gui.panel.PanelImage bannerPelicula;
    private javax.swing.JCheckBox boxSesion;
    private javax.swing.JButton btnCartelera;
    private javax.swing.JButton btnCuenta;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JTabbedPane cardAcceso;
    private javax.swing.JPanel cardCartelera;
    private javax.swing.JPanel cardCuenta;
    private javax.swing.JPanel cardPelicula;
    private javax.swing.JPanel cardPrincipal;
    private javax.swing.JPanel cardRegistro;
    private javax.swing.JTextField fieldApellidosAcceso;
    private javax.swing.JTextField fieldApellidosSignUp;
    private javax.swing.JTextField fieldBusqueda;
    private javax.swing.JTextField fieldCelular;
    private javax.swing.JTextField fieldCelularAcceso;
    private javax.swing.JPasswordField fieldContraseniaLogIn;
    private javax.swing.JPasswordField fieldContraseniaSignUp;
    private javax.swing.JTextField fieldCorreoAcceso;
    private javax.swing.JTextField fieldCorreoSignUp;
    private javax.swing.JTextField fieldNombreAcceso;
    private javax.swing.JTextField fieldNombreSignUp;
    private javax.swing.JTextField fieldUsuarioAcceso;
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
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JScrollPane jsp;
    private javax.swing.JLabel labelCarteleraIcon;
    private javax.swing.JLabel labelCategoriaPelicula;
    private javax.swing.JLabel labelClose;
    private javax.swing.JLabel labelDirectorPelicula;
    private javax.swing.JLabel labelDisconnect;
    private javax.swing.JLabel labelDuracionPelicula;
    private javax.swing.JLabel labelFacebook;
    private javax.swing.JLabel labelGenero;
    private javax.swing.JLabel labelHideSideBar;
    private javax.swing.JLabel labelInstagram;
    private javax.swing.JLabel labelLeft;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelMaximize;
    private javax.swing.JLabel labelMinimize;
    private javax.swing.JLabel labelNavBar;
    private javax.swing.JLabel labelNombrePelicula;
    private javax.swing.JLabel labelPeli1;
    private javax.swing.JLabel labelPeli2;
    private javax.swing.JLabel labelPeli3;
    private javax.swing.JLabel labelPeliculasIcon;
    private javax.swing.JLabel labelPlayStore;
    private javax.swing.JLabel labelRegistro;
    private javax.swing.JLabel labelRight;
    private javax.swing.JLabel labelToLogin;
    private javax.swing.JLabel labelTwitter;
    private javax.swing.JLabel labelUserIcon;
    private javax.swing.JPanel navBar;
    private javax.swing.JPanel panelCards;
    private javax.swing.JPanel panelHistorialCompras;
    private javax.swing.JPanel panelHorarios;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.edisoncor.gui.panel.PanelImage panelImage3;
    private javax.swing.JPanel panelInfoGeneral;
    private javax.swing.JPanel panelOpcionesButton;
    private org.edisoncor.gui.panel.PanelImage panelPeliculas;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSinopsis;
    private javax.swing.JTabbedPane panelsPelicula;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JLabel slider;
    // End of variables declaration//GEN-END:variables

    
        
}