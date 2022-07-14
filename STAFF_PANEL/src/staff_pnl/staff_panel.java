/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff_pnl;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;



/**
 *
 * @author Bacud
 */
public class staff_panel extends javax.swing.JFrame {
    
    
    /**
     * Creates new form staff_panel
     */
public ArrayList<Cargo> cargoList(){
    ArrayList<Cargo> cargoList = new ArrayList<>();
     try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           String query1 = "SELECT * FROM cargo";
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(query1);
           Cargo cargo;
           while(rs.next()){
               cargo=new Cargo(rs.getInt("serial_number"),rs.getString("description_text"),rs.getInt("piece_count"),rs.getString("shipment_id"),rs.getString("container_number"));
               cargoList.add(cargo);
           }
           
     }catch(Exception e){
           System.out.println(e.getMessage());
           
       }
     
    return cargoList;
}

public ArrayList<Container> containerList(){
    ArrayList<Container> containerList = new ArrayList<>();
     try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           String query1 = "SELECT * FROM container_number";
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(query1);
           Container container;
           while(rs.next()){
               container=new Container(rs.getString("Container_ID"),rs.getString("Vessel_Name"));
               containerList.add(container);
           }
           
     }catch(Exception e){
           System.out.println(e.getMessage());
           
       }
     
    return containerList;
}

public ArrayList<Shipment> shipmentList(){
    ArrayList<Shipment> shipmentList = new ArrayList<>();
     try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           String query1 = "SELECT * FROM shipment_details";
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(query1);
           Shipment shipment;
           while(rs.next()){
               shipment=new Shipment(rs.getInt("Shipment_ID"),rs.getString("trade_update_date"),rs.getString("run_date"),rs.getString("estimated_arrival_date"),rs.getString("foreign_port_lading"),
               rs.getString("place_of_receipt"),rs.getString("port_of_destination"),rs.getString("actual_arrival_date"),rs.getInt("consignee_ID"),rs.getInt("shipper_ID"));
               shipmentList.add(shipment);
           }
           
     }catch(Exception e){
           System.out.println(e.getMessage());
           
       }
     
    return shipmentList;
}

public ArrayList<Shipper> shipperList(){
    ArrayList<Shipper> shipperList = new ArrayList<>();
     try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           String query1 = "SELECT * FROM shipper_table";
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(query1);
           Shipper shipper;
           while(rs.next()){
               shipper=new Shipper(rs.getInt("shipper_ID"),rs.getString("shipper_name"),rs.getString("shipper_address"));
               shipperList.add(shipper);
           }
           
     }catch(Exception e){
           System.out.println(e.getMessage());
           
       }
     
    return shipperList;
}

public ArrayList<ShipperComm> shipperCommList(){
    ArrayList<ShipperComm> shipperCommList = new ArrayList<>();
     try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           String query1 = "SELECT * FROM shipper_contact_table WHERE shipper_ID = '"+shippersDisplay.getValueAt(shippersDisplay.getSelectedRow(),0)+"'";
          // String query1 = "SELECT * FROM shipper_contact_table";
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(query1);
           ShipperComm shippercom;
           while(rs.next()){
               shippercom=new ShipperComm(rs.getInt("shipper_ID"),rs.getString("shipper_comm_number"),rs.getString("shipper_comm_qualifier"));
               shipperCommList.add(shippercom);
           }
           
     }catch(Exception e){
           System.out.println(e.getMessage());
           
       }
     
    return shipperCommList;
}

public ArrayList<Consignee> consigneeList(){
    ArrayList<Consignee> consigneeList = new ArrayList<>();
     try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           String query1 = "SELECT * FROM consignee_table";
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(query1);
           Consignee consignee;
           while(rs.next()){
               consignee=new Consignee(rs.getInt("consignee_ID"),rs.getString("consignee_name"),rs.getString("consignee_address"));
               consigneeList.add(consignee);
           }
           
     }catch(Exception e){
           System.out.println(e.getMessage());
           
       }
     
    return consigneeList;
}

public ArrayList<ConsigneeComm> consigneeCommList(){
    ArrayList<ConsigneeComm> consigneeCommList = new ArrayList<>();
     try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
        //   String query1 = "SELECT * FROM consignee_contact_table";
        String query1 = "SELECT * FROM consignee_contact_table WHERE consignee_ID = '"+consigneeDisplay.getValueAt(consigneeDisplay.getSelectedRow(),0)+"'";
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(query1);
           ConsigneeComm consigneecomm;
           while(rs.next()){
               consigneecomm=new ConsigneeComm(rs.getInt("consignee_ID"),rs.getString("consignee_comm_number"),rs.getString("consignee_comm_qualifier"));
               consigneeCommList.add(consigneecomm);
           }
           
     }catch(Exception e){
           System.out.println(e.getMessage());
           
       }
     
    return consigneeCommList;
}


public void show_cargo(){
    ArrayList<Cargo> list = cargoList();
    DefaultTableModel cargo_model = (DefaultTableModel)cargoDisplay.getModel();
    Object[] row = new Object[5];
    for(int i=0;i<list.size();i++){
        row[0]=list.get(i).getsno();
        row[1]=list.get(i).getdt();
        row[2]=list.get(i).getpc();
        row[3]=list.get(i).getsid();
        row[4]=list.get(i).getcn();
        cargo_model.addRow(row);
    }
}

public void show_shipment(){
    ArrayList<Shipment> list = shipmentList();
    DefaultTableModel shipment_model = (DefaultTableModel)shipmentTable.getModel();
    Object[] row = new Object[11];
    for(int i=0;i<list.size();i++){
        row[0]=list.get(i).getshipment_id();
        row[1]=list.get(i).gettrade_update_date();
        row[2]=list.get(i).getrun_date();
        row[3]=list.get(i).getestimated_arrival_date();
        row[4]=list.get(i).getforeignportLading();
        row[5]=list.get(i).getplaceofReceipt();
        row[6]=list.get(i).getportofDestination();
        row[7]=list.get(i).getactualarrivalDate();
        row[8]=list.get(i).getconsigneeID();
        row[9]=list.get(i).getshipperID();
        shipment_model.addRow(row);
    }
}

public void show_container(){
    ArrayList<Container> list = containerList();
    DefaultTableModel containerModel = (DefaultTableModel)containerDisplay.getModel();
    containerModel.setRowCount(0);
    Object[] row = new Object[2];
    for(int i=0;i<list.size();i++){
        row[0]=list.get(i).getcontainid();
        row[1]=list.get(i).getvesselname();
        containerModel.addRow(row);
    }
}


public void show_shipper(){
    ArrayList<Shipper> list = shipperList();
    DefaultTableModel shipperModel = (DefaultTableModel)shippersDisplay.getModel();
    Object[] row = new Object[4];
    for(int i=0;i<list.size();i++){
        row[0]=list.get(i).getsid();
        row[1]=list.get(i).getsname();
        row[2]=list.get(i).getsadd();
        shipperModel.addRow(row);
    }
}

public void show_shipper_comm(){
    ArrayList<ShipperComm> list = shipperCommList();
    DefaultTableModel shipperCommModel = (DefaultTableModel)shipperDetails_Display.getModel();
    shipperCommModel.setRowCount(0);
    Object[] row = new Object[4];
    for(int i=0;i<list.size();i++){
        row[0]=list.get(i).getsid();
        row[1]=list.get(i).getscn();
        row[2]=list.get(i).getscq();
        shipperCommModel.addRow(row);
    }
}  

public void show_consignee(){
    ArrayList<Consignee> list = consigneeList();
    DefaultTableModel consigneeModel = (DefaultTableModel)consigneeDisplay.getModel();
    Object[] row = new Object[3];
    for(int i=0;i<list.size();i++){
        row[0]=list.get(i).getcid();
        row[1]=list.get(i).getconname();
        row[2]=list.get(i).getconadd();
        consigneeModel.addRow(row);
    }
}
public void show_consignee_comm(){
    ArrayList<ConsigneeComm> list = consigneeCommList();
    DefaultTableModel consigneeCommModel = (DefaultTableModel)consigneeDetails_Display.getModel();
    consigneeCommModel.setRowCount(0);
    Object[] row = new Object[3];
    for(int i=0;i<list.size();i++){
        row[0]=list.get(i).getcid();
        row[1]=list.get(i).getccn();
        row[2]=list.get(i).getccq();
        consigneeCommModel.addRow(row);
    }
}  


    CardLayout main_panel;
    public staff_panel() {
        
        initComponents();
        scaleImage();
        show_cargo();
        show_shipment();
        show_shipper();
        show_shipper_comm();
        show_consignee();
        show_consignee_comm();
        show_container();
        
        lbl_dateToday.setText(LocalDate.now().format(DateTimeFormatter.ISO_DATE)+ " " + Calendar.getInstance().getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()));
        main_panel = (CardLayout)(pnl_main.getLayout());
        
        
    }
    
    
   
    
    public void scaleImage(){
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource( "staff_pnl\\images\\ship.png" ));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(image_container.getWidth(),image_container.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        image_container.setIcon(scaledIcon);
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
        image_container = new javax.swing.JLabel();
        pnl_logout = new javax.swing.JPanel();
        lbl_logout = new javax.swing.JLabel();
        pnl_cargos = new javax.swing.JPanel();
        lbl_cargos = new javax.swing.JLabel();
        pnl_cargos_side = new javax.swing.JPanel();
        pnl_shipments = new javax.swing.JPanel();
        lbl_shipments = new javax.swing.JLabel();
        pnl_shipments_side = new javax.swing.JPanel();
        pnl_shippers = new javax.swing.JPanel();
        lbl_shippers = new javax.swing.JLabel();
        pnl_shippers_side = new javax.swing.JPanel();
        pnl_consignees = new javax.swing.JPanel();
        lbl_consignees = new javax.swing.JLabel();
        pnl_consignees_side = new javax.swing.JPanel();
        pnl_containers = new javax.swing.JPanel();
        lbl_containers = new javax.swing.JLabel();
        pnl_containers_side = new javax.swing.JPanel();
        lbl_dateToday = new javax.swing.JLabel();
        lbl_dateToday1 = new javax.swing.JLabel();
        pnl_main = new javax.swing.JPanel();
        pnlCard_cargos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cargoDisplay = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        PieceCount = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DescriptionText = new javax.swing.JTextPane();
        jLabel11 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        SerialNo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        shipmentID = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        ContainerNumber = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        pnlCard_shipments = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        shipmentTable = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        R_Date = new com.toedter.calendar.JDateChooser();
        TU_Date = new com.toedter.calendar.JDateChooser();
        EA_Date = new com.toedter.calendar.JDateChooser();
        AA_Date = new com.toedter.calendar.JDateChooser();
        jPanel15 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        pnlCard_shippers = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        shippersDisplay = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        ShipperName = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ShipperAddress = new javax.swing.JTextPane();
        jPanel32 = new javax.swing.JPanel();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        ShipperID = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        shipperDetails_Display = new javax.swing.JTable();
        jPanel24 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        Shipper_Comm_Number = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        shipper_comm_qualifier = new javax.swing.JComboBox<>();
        jButton34 = new javax.swing.JButton();
        cbx_cargos_in9 = new javax.swing.JComboBox<>();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        pnlCard_consignees = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        consigneeDisplay = new javax.swing.JTable();
        jPanel33 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jPanel34 = new javax.swing.JPanel();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jPanel29 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        consigneeDetails_Display = new javax.swing.JTable();
        jPanel39 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        cbx_cargos_in7 = new javax.swing.JComboBox<>();
        cbx_cargos_in8 = new javax.swing.JComboBox<>();
        jLabel56 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        jPanel40 = new javax.swing.JPanel();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        pnlCard_containers = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jPanel41 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        containerDisplay = new javax.swing.JTable();
        jPanel42 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jPanel45 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1600, 900));

        jPanel1.setBackground(new java.awt.Color(22, 105, 122));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        image_container.setText("jLabel1");

        pnl_logout.setBackground(new java.awt.Color(72, 159, 181));

        lbl_logout.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lbl_logout.setForeground(new java.awt.Color(255, 255, 255));
        lbl_logout.setText("LOG OUT");

        javax.swing.GroupLayout pnl_logoutLayout = new javax.swing.GroupLayout(pnl_logout);
        pnl_logout.setLayout(pnl_logoutLayout);
        pnl_logoutLayout.setHorizontalGroup(
            pnl_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_logoutLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(lbl_logout)
                .addContainerGap(163, Short.MAX_VALUE))
        );
        pnl_logoutLayout.setVerticalGroup(
            pnl_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_logoutLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(lbl_logout)
                .addGap(31, 31, 31))
        );

        pnl_cargos.setBackground(new java.awt.Color(22, 105, 122));
        pnl_cargos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_cargosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_cargosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_cargosMouseExited(evt);
            }
        });

        lbl_cargos.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lbl_cargos.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cargos.setText("CARGOS");

        pnl_cargos_side.setBackground(new java.awt.Color(22, 105, 122));

        javax.swing.GroupLayout pnl_cargos_sideLayout = new javax.swing.GroupLayout(pnl_cargos_side);
        pnl_cargos_side.setLayout(pnl_cargos_sideLayout);
        pnl_cargos_sideLayout.setHorizontalGroup(
            pnl_cargos_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        pnl_cargos_sideLayout.setVerticalGroup(
            pnl_cargos_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_cargosLayout = new javax.swing.GroupLayout(pnl_cargos);
        pnl_cargos.setLayout(pnl_cargosLayout);
        pnl_cargosLayout.setHorizontalGroup(
            pnl_cargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cargosLayout.createSequentialGroup()
                .addComponent(pnl_cargos_side, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(lbl_cargos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_cargosLayout.setVerticalGroup(
            pnl_cargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cargosLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(lbl_cargos)
                .addGap(31, 31, 31))
            .addComponent(pnl_cargos_side, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_shipments.setBackground(new java.awt.Color(22, 105, 122));
        pnl_shipments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_shipmentsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_shipmentsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_shipmentsMouseExited(evt);
            }
        });

        lbl_shipments.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lbl_shipments.setForeground(new java.awt.Color(255, 255, 255));
        lbl_shipments.setText("SHIPMENTS");

        pnl_shipments_side.setBackground(new java.awt.Color(22, 105, 122));

        javax.swing.GroupLayout pnl_shipments_sideLayout = new javax.swing.GroupLayout(pnl_shipments_side);
        pnl_shipments_side.setLayout(pnl_shipments_sideLayout);
        pnl_shipments_sideLayout.setHorizontalGroup(
            pnl_shipments_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        pnl_shipments_sideLayout.setVerticalGroup(
            pnl_shipments_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_shipmentsLayout = new javax.swing.GroupLayout(pnl_shipments);
        pnl_shipments.setLayout(pnl_shipmentsLayout);
        pnl_shipmentsLayout.setHorizontalGroup(
            pnl_shipmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_shipmentsLayout.createSequentialGroup()
                .addComponent(pnl_shipments_side, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(lbl_shipments)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_shipmentsLayout.setVerticalGroup(
            pnl_shipmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_shipments_side, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_shipmentsLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lbl_shipments)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pnl_shippers.setBackground(new java.awt.Color(22, 105, 122));
        pnl_shippers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_shippersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_shippersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_shippersMouseExited(evt);
            }
        });

        lbl_shippers.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lbl_shippers.setForeground(new java.awt.Color(255, 255, 255));
        lbl_shippers.setText("SHIPPERS");

        pnl_shippers_side.setBackground(new java.awt.Color(22, 105, 122));

        javax.swing.GroupLayout pnl_shippers_sideLayout = new javax.swing.GroupLayout(pnl_shippers_side);
        pnl_shippers_side.setLayout(pnl_shippers_sideLayout);
        pnl_shippers_sideLayout.setHorizontalGroup(
            pnl_shippers_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        pnl_shippers_sideLayout.setVerticalGroup(
            pnl_shippers_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_shippersLayout = new javax.swing.GroupLayout(pnl_shippers);
        pnl_shippers.setLayout(pnl_shippersLayout);
        pnl_shippersLayout.setHorizontalGroup(
            pnl_shippersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_shippersLayout.createSequentialGroup()
                .addComponent(pnl_shippers_side, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127)
                .addComponent(lbl_shippers)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_shippersLayout.setVerticalGroup(
            pnl_shippersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_shippersLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(lbl_shippers)
                .addGap(30, 30, 30))
            .addComponent(pnl_shippers_side, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_consignees.setBackground(new java.awt.Color(22, 105, 122));
        pnl_consignees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_consigneesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_consigneesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_consigneesMouseExited(evt);
            }
        });

        lbl_consignees.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lbl_consignees.setForeground(new java.awt.Color(255, 255, 255));
        lbl_consignees.setText("CONSIGNEES");

        pnl_consignees_side.setBackground(new java.awt.Color(22, 105, 122));

        javax.swing.GroupLayout pnl_consignees_sideLayout = new javax.swing.GroupLayout(pnl_consignees_side);
        pnl_consignees_side.setLayout(pnl_consignees_sideLayout);
        pnl_consignees_sideLayout.setHorizontalGroup(
            pnl_consignees_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        pnl_consignees_sideLayout.setVerticalGroup(
            pnl_consignees_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_consigneesLayout = new javax.swing.GroupLayout(pnl_consignees);
        pnl_consignees.setLayout(pnl_consigneesLayout);
        pnl_consigneesLayout.setHorizontalGroup(
            pnl_consigneesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_consigneesLayout.createSequentialGroup()
                .addComponent(pnl_consignees_side, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addComponent(lbl_consignees)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        pnl_consigneesLayout.setVerticalGroup(
            pnl_consigneesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_consigneesLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lbl_consignees)
                .addContainerGap(32, Short.MAX_VALUE))
            .addComponent(pnl_consignees_side, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_containers.setBackground(new java.awt.Color(22, 105, 122));
        pnl_containers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_containersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_containersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_containersMouseExited(evt);
            }
        });

        lbl_containers.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lbl_containers.setForeground(new java.awt.Color(255, 255, 255));
        lbl_containers.setText("CONTAINERS");

        pnl_containers_side.setBackground(new java.awt.Color(22, 105, 122));

        javax.swing.GroupLayout pnl_containers_sideLayout = new javax.swing.GroupLayout(pnl_containers_side);
        pnl_containers_side.setLayout(pnl_containers_sideLayout);
        pnl_containers_sideLayout.setHorizontalGroup(
            pnl_containers_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        pnl_containers_sideLayout.setVerticalGroup(
            pnl_containers_sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_containersLayout = new javax.swing.GroupLayout(pnl_containers);
        pnl_containers.setLayout(pnl_containersLayout);
        pnl_containersLayout.setHorizontalGroup(
            pnl_containersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_containersLayout.createSequentialGroup()
                .addComponent(pnl_containers_side, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(lbl_containers)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_containersLayout.setVerticalGroup(
            pnl_containersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_containersLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(lbl_containers)
                .addGap(31, 31, 31))
            .addComponent(pnl_containers_side, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lbl_dateToday.setBackground(new java.awt.Color(255, 255, 255));
        lbl_dateToday.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lbl_dateToday.setForeground(new java.awt.Color(255, 255, 255));
        lbl_dateToday.setText("jLabel1");

        lbl_dateToday1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_dateToday1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lbl_dateToday1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_dateToday1.setText("SHIELA MAE BACUD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_logout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_cargos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_shipments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_shippers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_consignees, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_containers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(image_container, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lbl_dateToday1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_dateToday)
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(image_container, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(pnl_cargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_shipments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_shippers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_consignees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_containers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(pnl_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_dateToday)
                    .addComponent(lbl_dateToday1))
                .addContainerGap())
        );

        pnl_main.setLayout(new java.awt.CardLayout());

        pnlCard_cargos.setBackground(new java.awt.Color(255, 255, 255));

        cargoDisplay.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        cargoDisplay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SERIAL", "Description Text", "Piece Count", "Shipment ID", "Container Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cargoDisplay.setSelectionBackground(new java.awt.Color(22, 105, 122));
        cargoDisplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cargoDisplayMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cargoDisplay);

        jPanel4.setBackground(new java.awt.Color(116, 181, 194));

        jLabel7.setBackground(new java.awt.Color(0, 51, 51));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 51));
        jLabel7.setText("SEARCH:");

        jTextField1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTextField1.setToolTipText("");
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(199, 224, 229));

        jButton3.setBackground(new java.awt.Color(153, 0, 0));
        jButton3.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 51));
        jButton1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(51, 51, 0));
        jButton10.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("CLEAR");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 102, 102));
        jButton7.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("INSERT");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1069, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel2.setBackground(new java.awt.Color(72, 159, 181));

        PieceCount.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        PieceCount.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("PIECE COUNT:");

        DescriptionText.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        DescriptionText.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        DescriptionText.setAutoscrolls(false);
        jScrollPane2.setViewportView(DescriptionText);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DESCRIPTION:");

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 51, 51));
        jLabel21.setText("SERIAL NO:");

        SerialNo.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        SerialNo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 102)));
        SerialNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SerialNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(SerialNo, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SerialNo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PieceCount, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addContainerGap(465, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PieceCount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(22, 105, 122));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("SHIPMENT DETAILS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(64, 64, 64))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(72, 159, 181));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("SHIPMENT ID:");

        shipmentID.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        shipmentID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("CONTAINER NO:");

        ContainerNumber.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        ContainerNumber.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ContainerNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(shipmentID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shipmentID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ContainerNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(22, 105, 122));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("CARGO DETAILS");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlCard_cargosLayout = new javax.swing.GroupLayout(pnlCard_cargos);
        pnlCard_cargos.setLayout(pnlCard_cargosLayout);
        pnlCard_cargosLayout.setHorizontalGroup(
            pnlCard_cargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard_cargosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCard_cargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlCard_cargosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        pnlCard_cargosLayout.setVerticalGroup(
            pnlCard_cargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard_cargosLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnl_main.add(pnlCard_cargos, "pnlCard_cargos");

        pnlCard_shipments.setBackground(new java.awt.Color(255, 255, 255));
        pnlCard_shipments.setPreferredSize(new java.awt.Dimension(1632, 973));

        jPanel9.setBackground(new java.awt.Color(116, 181, 194));

        jLabel16.setBackground(new java.awt.Color(0, 51, 51));
        jLabel16.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 51));
        jLabel16.setText("SEARCH:");

        jTextField6.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTextField6.setToolTipText("");
        jTextField6.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        shipmentTable.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        shipmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Shipment ID", "Trade Update Date", "Run Date", "Estimated Arrival Date", "Foreign Port Lading", "Place of Receipt", "Port of Destination", "Actual Arrival Date", "Consignee ID", "Shipper ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        shipmentTable.setSelectionBackground(new java.awt.Color(22, 105, 122));
        shipmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shipmentTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(shipmentTable);

        jPanel10.setBackground(new java.awt.Color(22, 105, 122));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("SHIPMENT DETAILS");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(72, 159, 181));

        jLabel31.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("TRADE DATE:");

        jLabel29.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("RUN DATE:");

        jLabel30.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("EA DATE:");

        jLabel28.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("AA DATE:");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TU_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29)
                        .addGap(18, 18, 18)
                        .addComponent(R_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel30)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(EA_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AA_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addContainerGap(485, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31)
                        .addComponent(jLabel29))
                    .addComponent(R_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TU_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel30))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(AA_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(jLabel28)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(EA_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(72, 159, 181));

        jLabel26.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("FOREIGN PORT OF LADING:");

        jTextField11.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTextField11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel27.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("PLACE OF RECEIPT:");

        jTextField12.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTextField12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel32.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("PORT OF DESTINATION:");

        jTextField13.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTextField13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel13.setBackground(new java.awt.Color(72, 159, 181));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("SHIPPER ID:");

        jTextField9.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTextField9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("CONSIGNEE ID:");

        jTextField10.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTextField10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(199, 224, 229));

        jButton5.setBackground(new java.awt.Color(153, 0, 0));
        jButton5.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("DELETE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 51));
        jButton2.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 102, 102));
        jButton6.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("NEW");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(51, 51, 0));
        jButton11.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("CLEAR");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 51, 51));
        jLabel20.setText("SHIPMENT ID:");

        jTextField14.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTextField14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 102)));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlCard_shipmentsLayout = new javax.swing.GroupLayout(pnlCard_shipments);
        pnlCard_shipments.setLayout(pnlCard_shipmentsLayout);
        pnlCard_shipmentsLayout.setHorizontalGroup(
            pnlCard_shipmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlCard_shipmentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCard_shipmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCard_shipmentsLayout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlCard_shipmentsLayout.setVerticalGroup(
            pnlCard_shipmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard_shipmentsLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(pnlCard_shipmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnl_main.add(pnlCard_shipments, "pnlCard_shipments");

        pnlCard_shippers.setBackground(new java.awt.Color(255, 255, 255));

        jPanel18.setBackground(new java.awt.Color(116, 181, 194));

        jLabel22.setBackground(new java.awt.Color(0, 51, 51));
        jLabel22.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 51, 51));
        jLabel22.setText("SEARCH:");

        jTextField7.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTextField7.setToolTipText("");
        jTextField7.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel21.setBackground(new java.awt.Color(22, 105, 122));

        jLabel36.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("SHIPPER'S INFORMATION");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel36)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel36)
                .addContainerGap())
        );

        jPanel22.setBackground(new java.awt.Color(22, 105, 122));

        jLabel37.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("CONTACT DETAILS");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel37)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addContainerGap())
        );

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        shippersDisplay.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        shippersDisplay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "ADDRESS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        shippersDisplay.setSelectionBackground(new java.awt.Color(22, 105, 122));
        shippersDisplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shippersDisplayMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(shippersDisplay);

        jPanel31.setBackground(new java.awt.Color(116, 181, 194));

        jLabel50.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("NAME:");

        ShipperName.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        ShipperName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel51.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("ADDRESS:");

        ShipperAddress.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane5.setViewportView(ShipperAddress);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel51))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ShipperName, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50)))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ShipperName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));

        jButton17.setBackground(new java.awt.Color(0, 0, 51));
        jButton17.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("SAVE");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(153, 0, 0));
        jButton18.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("DELETE");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(0, 102, 102));
        jButton19.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setText("NEW");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setBackground(new java.awt.Color(51, 51, 0));
        jButton20.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("CLEAR");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel35.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 51, 51));
        jLabel35.setText("SHIPPER ID:");

        ShipperID.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        ShipperID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 102)));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1326, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ShipperID, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(ShipperID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 156, Short.MAX_VALUE))
        );

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));

        shipperDetails_Display.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        shipperDetails_Display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "COMM NUMBER", "COMM QUALIFIER"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        shipperDetails_Display.setSelectionBackground(new java.awt.Color(22, 105, 122));
        jScrollPane7.setViewportView(shipperDetails_Display);

        jPanel24.setBackground(new java.awt.Color(116, 181, 194));

        jLabel40.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("COMM NUMBER:");

        Shipper_Comm_Number.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        Shipper_Comm_Number.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel41.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("COMM QUALIFIER:");

        shipper_comm_qualifier.setBackground(new java.awt.Color(72, 159, 181));
        shipper_comm_qualifier.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        shipper_comm_qualifier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TEL", "FAX", "EMAIL" }));
        shipper_comm_qualifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shipper_comm_qualifierActionPerformed(evt);
            }
        });

        jButton34.setBackground(new java.awt.Color(0, 0, 51));
        jButton34.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton34.setForeground(new java.awt.Color(255, 255, 255));
        jButton34.setText("REFRESH");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        cbx_cargos_in9.setBackground(new java.awt.Color(72, 159, 181));
        cbx_cargos_in9.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        cbx_cargos_in9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_cargos_in9ActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("CONSIGNEE ID:");

        jLabel58.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("SHIPPER ID:");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel24Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(shipper_comm_qualifier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel24Layout.createSequentialGroup()
                            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel24Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel40)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel24Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel24Layout.createSequentialGroup()
                                            .addComponent(jLabel58)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbx_cargos_in9, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel24Layout.createSequentialGroup()
                                            .addComponent(jLabel41)
                                            .addGap(116, 116, 116)))))
                            .addGap(14, 14, 14)))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Shipper_Comm_Number, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addGap(82, 82, 82)
                    .addComponent(jLabel57)
                    .addContainerGap(83, Short.MAX_VALUE)))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx_cargos_in9)
                    .addComponent(jLabel58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Shipper_Comm_Number, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shipper_comm_qualifier, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addGap(95, 95, 95)
                    .addComponent(jLabel57)
                    .addContainerGap(95, Short.MAX_VALUE)))
        );

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));

        jButton13.setBackground(new java.awt.Color(0, 0, 51));
        jButton13.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("SAVE");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(153, 0, 0));
        jButton14.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("DELETE");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(0, 102, 102));
        jButton15.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("NEW");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(51, 51, 0));
        jButton16.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("CLEAR");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1321, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlCard_shippersLayout = new javax.swing.GroupLayout(pnlCard_shippers);
        pnlCard_shippers.setLayout(pnlCard_shippersLayout);
        pnlCard_shippersLayout.setHorizontalGroup(
            pnlCard_shippersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard_shippersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCard_shippersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        pnlCard_shippersLayout.setVerticalGroup(
            pnlCard_shippersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard_shippersLayout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pnl_main.add(pnlCard_shippers, "pnlCard_shippers");

        pnlCard_consignees.setBackground(new java.awt.Color(255, 255, 255));

        jPanel19.setBackground(new java.awt.Color(116, 181, 194));

        jLabel34.setBackground(new java.awt.Color(0, 51, 51));
        jLabel34.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 51, 51));
        jLabel34.setText("SEARCH:");

        jTextField8.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTextField8.setToolTipText("");
        jTextField8.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel27.setBackground(new java.awt.Color(22, 105, 122));

        jLabel42.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("CONSIGNEE'S INFORMATION");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel42)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel42)
                .addContainerGap())
        );

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));

        consigneeDisplay.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        consigneeDisplay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "ADDRESS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        consigneeDisplay.setSelectionBackground(new java.awt.Color(22, 105, 122));
        consigneeDisplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                consigneeDisplayMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(consigneeDisplay);

        jPanel33.setBackground(new java.awt.Color(116, 181, 194));

        jLabel52.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("NAME:");

        jTextField29.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTextField29.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel53.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("ADDRESS:");

        jTextPane3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane8.setViewportView(jTextPane3);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel53))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52)))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));

        jButton22.setBackground(new java.awt.Color(153, 0, 0));
        jButton22.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setText("DELETE");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setBackground(new java.awt.Color(0, 102, 102));
        jButton23.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton23.setForeground(new java.awt.Color(255, 255, 255));
        jButton23.setText("INSERT");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setBackground(new java.awt.Color(51, 51, 0));
        jButton24.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton24.setForeground(new java.awt.Color(255, 255, 255));
        jButton24.setText("CLEAR");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton33.setBackground(new java.awt.Color(0, 0, 51));
        jButton33.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton33.setForeground(new java.awt.Color(255, 255, 255));
        jButton33.setText("SAVE");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jLabel43.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 51, 51));
        jLabel43.setText("CONSIGNEE ID:");

        jTextField17.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTextField17.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 102)));

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1326, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel29.setBackground(new java.awt.Color(22, 105, 122));

        jLabel44.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("CONTACT DETAILS");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel44)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel44)
                .addContainerGap())
        );

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));

        consigneeDetails_Display.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        consigneeDetails_Display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "COMM NUMBER", "COMM QUALIFIER"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        consigneeDetails_Display.setSelectionBackground(new java.awt.Color(22, 105, 122));
        jScrollPane11.setViewportView(consigneeDetails_Display);

        jPanel39.setBackground(new java.awt.Color(116, 181, 194));

        jLabel49.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("COMM NUMBER:");

        jTextField21.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTextField21.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel54.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("COMM QUALIFIER:");

        cbx_cargos_in7.setBackground(new java.awt.Color(72, 159, 181));
        cbx_cargos_in7.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        cbx_cargos_in7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TEL", "FAX", "EMAIL" }));

        cbx_cargos_in8.setBackground(new java.awt.Color(72, 159, 181));
        cbx_cargos_in8.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        cbx_cargos_in8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_cargos_in8ActionPerformed(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("CONSIGNEE ID:");

        jButton21.setBackground(new java.awt.Color(0, 0, 51));
        jButton21.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton21.setForeground(new java.awt.Color(255, 255, 255));
        jButton21.setText("REFRESH");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel39Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel54))
                            .addGroup(jPanel39Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel39Layout.createSequentialGroup()
                                        .addComponent(jLabel49)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel39Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cbx_cargos_in7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbx_cargos_in8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx_cargos_in8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel49)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbx_cargos_in7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));

        jButton25.setBackground(new java.awt.Color(0, 0, 51));
        jButton25.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton25.setForeground(new java.awt.Color(255, 255, 255));
        jButton25.setText("SAVE");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setBackground(new java.awt.Color(153, 0, 0));
        jButton26.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton26.setForeground(new java.awt.Color(255, 255, 255));
        jButton26.setText("DELETE");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setBackground(new java.awt.Color(0, 102, 102));
        jButton27.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton27.setForeground(new java.awt.Color(255, 255, 255));
        jButton27.setText("NEW");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setBackground(new java.awt.Color(51, 51, 0));
        jButton28.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton28.setForeground(new java.awt.Color(255, 255, 255));
        jButton28.setText("CLEAR");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addComponent(jScrollPane11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlCard_consigneesLayout = new javax.swing.GroupLayout(pnlCard_consignees);
        pnlCard_consignees.setLayout(pnlCard_consigneesLayout);
        pnlCard_consigneesLayout.setHorizontalGroup(
            pnlCard_consigneesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlCard_consigneesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCard_consigneesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        pnlCard_consigneesLayout.setVerticalGroup(
            pnlCard_consigneesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard_consigneesLayout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        pnl_main.add(pnlCard_consignees, "pnlCard_consignees");

        pnlCard_containers.setBackground(new java.awt.Color(255, 255, 255));

        jPanel20.setBackground(new java.awt.Color(116, 181, 194));

        jLabel55.setBackground(new java.awt.Color(0, 51, 51));
        jLabel55.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 51, 51));
        jLabel55.setText("SEARCH:");

        jTextField22.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jTextField22.setToolTipText("");
        jTextField22.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField22ActionPerformed(evt);
            }
        });
        jTextField22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField22KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));

        containerDisplay.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        containerDisplay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "container_ID", "Vessel_Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        containerDisplay.setSelectionBackground(new java.awt.Color(22, 105, 122));
        containerDisplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                containerDisplayMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(containerDisplay);

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel42.setBackground(new java.awt.Color(72, 159, 181));

        jLabel61.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("CONTAINER NO:");

        jTextField23.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTextField23.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel62.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("VESSEL NAME:");

        jTextField24.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTextField24.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel61)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62))
                .addGap(31, 31, 31))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel45.setBackground(new java.awt.Color(22, 105, 122));

        jLabel60.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("CONTAINER DETAILS");

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel60)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel60)
                .addContainerGap())
        );

        jPanel47.setBackground(new java.awt.Color(199, 224, 229));

        jButton29.setBackground(new java.awt.Color(153, 0, 0));
        jButton29.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton29.setForeground(new java.awt.Color(255, 255, 255));
        jButton29.setText("DELETE");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton30.setBackground(new java.awt.Color(0, 0, 51));
        jButton30.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton30.setForeground(new java.awt.Color(255, 255, 255));
        jButton30.setText("SAVE");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton31.setBackground(new java.awt.Color(0, 102, 102));
        jButton31.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jButton31.setForeground(new java.awt.Color(255, 255, 255));
        jButton31.setText("NEW");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton32.setBackground(new java.awt.Color(51, 51, 0));
        jButton32.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jButton32.setForeground(new java.awt.Color(255, 255, 255));
        jButton32.setText("CLEAR");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jButton30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlCard_containersLayout = new javax.swing.GroupLayout(pnlCard_containers);
        pnlCard_containers.setLayout(pnlCard_containersLayout);
        pnlCard_containersLayout.setHorizontalGroup(
            pnlCard_containersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlCard_containersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCard_containersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCard_containersLayout.createSequentialGroup()
                        .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnlCard_containersLayout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addGroup(pnlCard_containersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(695, Short.MAX_VALUE))))
        );
        pnlCard_containersLayout.setVerticalGroup(
            pnlCard_containersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard_containersLayout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        pnl_main.add(pnlCard_containers, "pnlCard_containers");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, 1295, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public void setBackgroundColor(JPanel panel,JLabel label, JPanel active){  //change background color when hover
        panel.setBackground(new Color(130,192,204));
        label.setForeground(new Color(22, 105, 122));
        active.setBackground(new Color(240,240,240));
    }
    
    public void resetBackgroundColor(JPanel panel, JLabel label, JPanel active){  //reset background color
        panel.setBackground(new Color(22,105,122));
        label.setForeground(new Color(240,240,240));
        active.setBackground(new Color(22,105,122));
    }
    
    
    private void pnl_cargosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_cargosMouseEntered
       setBackgroundColor(pnl_cargos,lbl_cargos,pnl_cargos_side);
    }//GEN-LAST:event_pnl_cargosMouseEntered

    private void pnl_cargosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_cargosMouseExited
        if(!pnlCard_cargos.isShowing()){
            resetBackgroundColor(pnl_cargos,lbl_cargos,pnl_cargos_side);}
    }//GEN-LAST:event_pnl_cargosMouseExited

    private void pnl_shipmentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_shipmentsMouseEntered
        setBackgroundColor(pnl_shipments,lbl_shipments,pnl_shipments_side);
    }//GEN-LAST:event_pnl_shipmentsMouseEntered

    private void pnl_shipmentsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_shipmentsMouseExited
        if (!pnlCard_shipments.isShowing()){
        resetBackgroundColor(pnl_shipments,lbl_shipments,pnl_shipments_side);}
    }//GEN-LAST:event_pnl_shipmentsMouseExited

    private void pnl_shippersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_shippersMouseEntered
        setBackgroundColor(pnl_shippers,lbl_shippers,pnl_shippers_side);
    }//GEN-LAST:event_pnl_shippersMouseEntered

    private void pnl_shippersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_shippersMouseExited
        if (!pnlCard_shippers.isShowing()){
        resetBackgroundColor(pnl_shippers,lbl_shippers,pnl_shippers_side);}
    }//GEN-LAST:event_pnl_shippersMouseExited

    private void pnl_consigneesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_consigneesMouseEntered
         setBackgroundColor(pnl_consignees,lbl_consignees,pnl_consignees_side);
    }//GEN-LAST:event_pnl_consigneesMouseEntered

    private void pnl_consigneesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_consigneesMouseExited
        if (!pnlCard_consignees.isShowing()){ 
        resetBackgroundColor(pnl_consignees,lbl_consignees,pnl_consignees_side);}
    }//GEN-LAST:event_pnl_consigneesMouseExited

    private void pnl_containersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_containersMouseEntered
       setBackgroundColor(pnl_containers,lbl_containers,pnl_containers_side);
    }//GEN-LAST:event_pnl_containersMouseEntered

    private void pnl_containersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_containersMouseExited
         if (!pnlCard_containers.isShowing()){
        resetBackgroundColor(pnl_containers,lbl_containers,pnl_containers_side);}
    }//GEN-LAST:event_pnl_containersMouseExited

    private void pnl_cargosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_cargosMouseClicked
        main_panel.show(pnl_main, "pnlCard_cargos");
        resetBackgroundColor(pnl_shipments,lbl_shipments,pnl_shipments_side);  
        resetBackgroundColor(pnl_shippers,lbl_shippers,pnl_shippers_side);
        resetBackgroundColor(pnl_consignees,lbl_consignees,pnl_consignees_side);
        resetBackgroundColor(pnl_containers,lbl_containers,pnl_containers_side);
    }//GEN-LAST:event_pnl_cargosMouseClicked

    private void pnl_shipmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_shipmentsMouseClicked
        main_panel.show(pnl_main, "pnlCard_shipments");
        resetBackgroundColor(pnl_cargos,lbl_cargos,pnl_cargos_side);
        resetBackgroundColor(pnl_shippers,lbl_shippers,pnl_shippers_side);
        resetBackgroundColor(pnl_consignees,lbl_consignees,pnl_consignees_side);
        resetBackgroundColor(pnl_containers,lbl_containers,pnl_containers_side);
       
  
    }//GEN-LAST:event_pnl_shipmentsMouseClicked

    private void pnl_shippersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_shippersMouseClicked
        main_panel.show(pnl_main, "pnlCard_shippers");
        
        resetBackgroundColor(pnl_cargos,lbl_cargos,pnl_cargos_side);
        resetBackgroundColor(pnl_shipments,lbl_shipments,pnl_shipments_side);
        resetBackgroundColor(pnl_consignees,lbl_consignees,pnl_consignees_side);
        resetBackgroundColor(pnl_containers,lbl_containers,pnl_containers_side);
    }//GEN-LAST:event_pnl_shippersMouseClicked

    private void pnl_consigneesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_consigneesMouseClicked
        main_panel.show(pnl_main, "pnlCard_consignees");
        resetBackgroundColor(pnl_cargos,lbl_cargos,pnl_cargos_side);
        resetBackgroundColor(pnl_shipments,lbl_shipments,pnl_shipments_side);
        resetBackgroundColor(pnl_shippers,lbl_shippers,pnl_shippers_side); 
        resetBackgroundColor(pnl_containers,lbl_containers,pnl_containers_side);
    }//GEN-LAST:event_pnl_consigneesMouseClicked

    private void pnl_containersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_containersMouseClicked
        main_panel.show(pnl_main, "pnlCard_containers");
        resetBackgroundColor(pnl_cargos,lbl_cargos,pnl_cargos_side);
        resetBackgroundColor(pnl_shipments,lbl_shipments,pnl_shipments_side);
        resetBackgroundColor(pnl_shippers,lbl_shippers,pnl_shippers_side); 
        resetBackgroundColor(pnl_consignees,lbl_consignees,pnl_consignees_side);
    }//GEN-LAST:event_pnl_containersMouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           
           Statement st = con.createStatement();
           String sql = "select * from cargo where serial_number=?";
           ResultSet rs = st.executeQuery(sql);
           
           while(rs.next()){
              String id = String.valueOf(rs.getInt("serial_number"));
              String d_text = rs.getString("description_text");
              String p_count = String.valueOf(rs.getInt("piece_count"));
              String s_id = String.valueOf(rs.getInt("shipment_ID"));
              String c_number = rs.getString("container_number");
              
              String tbData[] = {id,d_text,p_count,s_id,c_number};
              DefaultTableModel model = (DefaultTableModel)cargoDisplay.getModel();
              model.setRowCount(0);
              
              model.addRow(tbData);
           }
       }catch(Exception e){
           System.out.println(e.getMessage());
           
       }
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
            try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           String query = "insert into shipment_details(shipment_ID,trade_update_date,run_date,estimated_arrival_date,foreign_port_lading,place_of_receipt,port_of_destination,actual_arrival_date,consignee_ID,shipper_ID)values(?,?,?,?,?,?,?,?,?,?)";
           PreparedStatement pst = con.prepareStatement(query);
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
           String trade_update_date = sdf.format(TU_Date.getDate());
           String run_date = sdf.format(R_Date.getDate());
           String estimated_arrival_date = sdf.format(EA_Date.getDate());
           String actual_arrival_date = sdf.format(AA_Date.getDate());
           pst.setString(1,jTextField14.getText());
           pst.setString(2,trade_update_date);
           pst.setString(3,run_date);
           pst.setString(4,estimated_arrival_date);
           pst.setString(5,jTextField11.getText());
           pst.setString(6,jTextField12.getText());
           pst.setString(7,jTextField13.getText());
           pst.setString(8,actual_arrival_date);
           pst.setString(9,jTextField10.getText());
           pst.setString(10,jTextField9.getText());
          
           
           
           pst.executeUpdate();
           
           DefaultTableModel  model = (DefaultTableModel)shipmentTable.getModel();
           model.setRowCount(0);
           show_shipment();
           JOptionPane.showMessageDialog(null,"Inserted Succesfully!");
           
        }catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Inserted Failed!");
           
       }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try{
            SerialNo.setText("");
        DescriptionText.setText("");
        PieceCount.setText("");
        shipmentID.setText("");
        ContainerNumber.setText("");
        JOptionPane.showMessageDialog(null,"Cleared Succesfully!");
        }
        catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Clear Failed!");
           
       }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try{
            
        jTextField14.setText("");
        jTextField11.setText("");
        jTextField12.setText("");
        jTextField13.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        JOptionPane.showMessageDialog(null,"Cleared Succesfully!");
        }
        catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Clear Failed!");
           
       }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
         try{
        Shipper_Comm_Number.setText("");
        JOptionPane.showMessageDialog(null,"Cleared Succesfully!");
        }
        catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Clear Failed!");
           
       }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           String query = "insert into shipper_contact_table(shipper_ID,shipper_comm_number,shipper_comm_qualifier)values(?,?,?)";
           PreparedStatement pst = con.prepareStatement(query);
           String s_id;
           String qualifier;
           s_id = cbx_cargos_in9.getSelectedItem().toString();
           pst.setString(1,s_id);
           pst.setString(2,Shipper_Comm_Number.getText());
           qualifier = shipper_comm_qualifier.getSelectedItem().toString();
           pst.setString(3,qualifier);
           pst.executeUpdate();
           DefaultTableModel model = (DefaultTableModel)shipperDetails_Display.getModel();
           model.setRowCount(0);
           show_shipper();
           show_shipper_comm();
           JOptionPane.showMessageDialog(null,"Inserted Succesfully!");
           
           
        }catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Inserted Failed!");
           
       }

    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           String query = "insert into shipper_table(shipper_ID,shipper_name,shipper_address)values(?,?,?)";
           PreparedStatement pst = con.prepareStatement(query);
           pst.setString(1,ShipperID.getText());
           pst.setString(2,ShipperName.getText());
           pst.setString(3,ShipperAddress.getText());
          
           pst.executeUpdate();
           DefaultTableModel model = (DefaultTableModel)shippersDisplay.getModel();
           model.setRowCount(0);
           show_shipper();
           JOptionPane.showMessageDialog(null,"Inserted Succesfully!");
           
           
        }catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Inserted Failed!");
           
       }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
         try{
        ShipperID.setText("");
        ShipperName.setText("");
        ShipperAddress.setText("");
        JOptionPane.showMessageDialog(null,"Cleared Succesfully!");
        }
        catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Clear Failed!");
           
       }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
         try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           String query = "insert into consignee_table(consignee_id,consignee_name,consignee_address)values(?,?,?)";
           PreparedStatement pst = con.prepareStatement(query);
           pst.setString(1,jTextField17.getText());
           pst.setString(2,jTextField29.getText());
           pst.setString(3,jTextPane3.getText());
          
           pst.executeUpdate();
           DefaultTableModel model = (DefaultTableModel)consigneeDisplay.getModel();
           model.setRowCount(0);
           show_consignee();
           JOptionPane.showMessageDialog(null,"Inserted Succesfully!");
           
           
        }catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Inserted Failed!");
           
       }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
         try{
        jTextField17.setText("");
        jTextField29.setText("");
        jTextPane3.setText("");
        JOptionPane.showMessageDialog(null,"Cleared Succesfully!");
        }
        catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Clear Failed!");
           
       }
        
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           String query = "insert into consignee_contact_table(consignee_ID,consignee_comm_number,consignee_comm_qualifier)values(?,?,?)";
           PreparedStatement pst = con.prepareStatement(query);
           String c_id;
           String qualifier;
           c_id = cbx_cargos_in8.getSelectedItem().toString();
           pst.setString(1,c_id);
           pst.setString(2,jTextField21.getText());
           qualifier = cbx_cargos_in7.getSelectedItem().toString();
           pst.setString(3,qualifier);
           pst.executeUpdate();
           DefaultTableModel model = (DefaultTableModel)consigneeDisplay.getModel();
           model.setRowCount(0);
           show_consignee();
           show_consignee_comm();
           JOptionPane.showMessageDialog(null,"Inserted Succesfully!");
           
           
        }catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Inserted Failed!");
           
       }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        try{
        jTextField21.setText("");
        JOptionPane.showMessageDialog(null,"Cleared Succesfully!");
        }
        catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Clear Failed!");
           
       }
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jTextField22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           String query = "insert into container_number(container_ID,Vessel_Name)values(?,?)";
           PreparedStatement pst = con.prepareStatement(query);
           pst.setString(1,jTextField23.getText());
           pst.setString(2,jTextField24.getText());
           
          
           pst.executeUpdate();
           show_container();
           JOptionPane.showMessageDialog(null,"Inserted Succesfully!");
           
           
        }catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Inserted Failed!");
           
       }
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
       try{
        jTextField23.setText("");
        jTextField24.setText("");
        JOptionPane.showMessageDialog(null,"Cleared Succesfully!");
        }
        catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Clear Failed!");
           
       }
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           String query = "insert into cargo(serial_number,description_text,piece_count,shipment_ID,container_number)values(?,?,?,?,?)";
           PreparedStatement pst = con.prepareStatement(query);
           pst.setString(1,SerialNo.getText());
           pst.setString(2,DescriptionText.getText());
           pst.setString(3,PieceCount.getText());
           pst.setString(4,shipmentID.getText());
           pst.setString(5,ContainerNumber.getText());
          
           pst.executeUpdate();
           DefaultTableModel model = (DefaultTableModel)cargoDisplay.getModel();
           model.setRowCount(0);
           show_cargo();
           JOptionPane.showMessageDialog(null,"Inserted Succesfully!");
           
           
        }catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Inserted Failed!");
           
       }
    }//GEN-LAST:event_jButton7ActionPerformed

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           int row = cargoDisplay.getSelectedRow();
           String value = (cargoDisplay.getModel().getValueAt(row,0).toString());
           String query = "UPDATE shipmenttracking.cargo SET description_text=?,piece_count=?,shipment_ID=?,container_number=? WHERE serial_number="+value;
           PreparedStatement pst = con.prepareStatement(query);
           pst.setString(1,DescriptionText.getText());
           pst.setString(2,PieceCount.getText());
           pst.setString(3,shipmentID.getText());
           pst.setString(4,ContainerNumber.getText());
          
           pst.executeUpdate();
           
           DefaultTableModel  model = (DefaultTableModel)cargoDisplay.getModel();
           model.setRowCount(0);
           show_cargo();
           JOptionPane.showMessageDialog(null,"Updated Succesfully!");
           
           
        }catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Update Failed!");
           
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SerialNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SerialNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SerialNoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           int row = shipmentTable.getSelectedRow();
           String value = (shipmentTable.getModel().getValueAt(row,0).toString());
           String query = "UPDATE shipment_details SET trade_update_date=?,run_date=?,estimated_arrival_date=?,foreign_port_lading=?,place_of_receipt=?,port_of_destination=?,actual_arrival_date=?,consignee_ID=?,shipper_ID=? WHERE shipment_ID="+value;
           PreparedStatement pst = con.prepareStatement(query);
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
           String trade_update_date = sdf.format(TU_Date.getDate());
           String run_date = sdf.format(R_Date.getDate());
           String estimated_arrival_date = sdf.format(EA_Date.getDate());
           String actual_arrival_date = sdf.format(AA_Date.getDate());
           pst.setString(1,trade_update_date);
           pst.setString(2,run_date);
           pst.setString(3,estimated_arrival_date);
           pst.setString(4,jTextField11.getText());
           pst.setString(5,jTextField12.getText());
           pst.setString(6,jTextField13.getText());
           pst.setString(7,actual_arrival_date);
           pst.setString(8,jTextField10.getText());
           pst.setString(9,jTextField9.getText());
          
           pst.executeUpdate();
           
           DefaultTableModel  model = (DefaultTableModel)shipmentTable.getModel();
           model.setRowCount(0);
           show_shipment();
           JOptionPane.showMessageDialog(null,"Updated Succesfully!");
           
           
        }catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Update Failed!");
           
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           int row = shippersDisplay.getSelectedRow();
           String value = (shippersDisplay.getModel().getValueAt(row,0).toString());
           String query = "UPDATE shipper_table SET shipper_name=?,shipper_address=? WHERE shipper_ID="+value;
           PreparedStatement pst = con.prepareStatement(query);
           pst.setString(1,ShipperName.getText());
           pst.setString(2,ShipperAddress.getText());
           pst.executeUpdate();
           
           DefaultTableModel  model = (DefaultTableModel)shippersDisplay.getModel();
           model.setRowCount(0);
           show_shipper();
           show_shipper_comm();
           JOptionPane.showMessageDialog(null,"Updated Succesfully!");
           
           
        }catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Update Failed!");
           
       }
 
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
       
try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           int row = shipperDetails_Display.getSelectedRow();
           String value = (shipperDetails_Display.getModel().getValueAt(row,0).toString());
           String query = "UPDATE shipper_contact_table SET shipper_comm_number=?,shipper_comm_qualifier=? WHERE shipper_ID="+value;
           PreparedStatement pst = con.prepareStatement(query);
           pst.setString(1,Shipper_Comm_Number.getText());
           String qualifier;
           qualifier = shipper_comm_qualifier.getSelectedItem().toString();
           pst.setString(2,qualifier);
           pst.executeUpdate();
           
           DefaultTableModel  model = (DefaultTableModel)shipperDetails_Display.getModel();
           model.setRowCount(0);
           show_shipper_comm();
           JOptionPane.showMessageDialog(null,"Updated Succesfully!");
           
           
        }catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Update Failed!");
           
       }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
            int row = cargoDisplay.getSelectedRow();
           String value = (cargoDisplay.getModel().getValueAt(row,0).toString());
            String query = "DELETE FROM cargo where serial_number="+value;
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            
            DefaultTableModel  model = (DefaultTableModel)cargoDisplay.getModel();
            model.setRowCount(0);
            show_cargo();
            JOptionPane.showMessageDialog(null,"Deleted Succesfully!");
        }catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Deletion Failed!");
           
       }   
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
            int row = shipmentTable.getSelectedRow();
           String value = (shipmentTable.getModel().getValueAt(row,0).toString());
            String query = "DELETE FROM shipment_details where shipment_ID="+value;
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            
            DefaultTableModel  model = (DefaultTableModel)shipmentTable.getModel();
            model.setRowCount(0);
            show_shipment();
            JOptionPane.showMessageDialog(null,"Deleted Succesfully!");
        }catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Deletion Failed!");
           
       }   
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
            int row = containerDisplay.getSelectedRow();
           String value = (containerDisplay.getModel().getValueAt(row,0).toString());
            String query = "DELETE FROM container_number where Container_ID='"+value+"' ";
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            DefaultTableModel  model = (DefaultTableModel)containerDisplay.getModel();
            model.setRowCount(0);
            show_container();
            
            JOptionPane.showMessageDialog(null,"Deleted Succesfully!");
        }catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Deletion Failed!");
           
       }   
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           int row = containerDisplay.getSelectedRow();
           String value = (containerDisplay.getModel().getValueAt(row,0).toString());
           String query = "UPDATE container_number SET container_ID=?, Vessel_Name=? WHERE container_ID='"+value+"' ";
           PreparedStatement pst = con.prepareStatement(query);
           pst.setString(1,jTextField23.getText());
           pst.setString(2,jTextField24.getText());
           
          
           pst.executeUpdate();
           DefaultTableModel  model = (DefaultTableModel)containerDisplay.getModel();
           model.setRowCount(0);
           show_container();
           
           JOptionPane.showMessageDialog(null,"Updated Succesfully!");
           
           
        }catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Update Failed!");
           
       }
    }//GEN-LAST:event_jButton30ActionPerformed

    private void containerDisplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_containerDisplayMouseClicked
        int i = containerDisplay.getSelectedRow();
        TableModel model = containerDisplay.getModel();
        jTextField23.setText(model.getValueAt(i,0).toString());
        jTextField24.setText(model.getValueAt(i,1).toString());
        
    }//GEN-LAST:event_containerDisplayMouseClicked

    private void shipmentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shipmentTableMouseClicked
       int i = shipmentTable.getSelectedRow();
   
        TableModel model = shipmentTable.getModel();
        jTextField14.setText(model.getValueAt(i,0).toString());
        jTextField11.setText(model.getValueAt(i,4).toString());
        jTextField12.setText(model.getValueAt(i,5).toString());
        jTextField13.setText(model.getValueAt(i,6).toString());
        jTextField10.setText(model.getValueAt(i,8).toString());
        jTextField9.setText(model.getValueAt(i,9).toString());
        
        

    }//GEN-LAST:event_shipmentTableMouseClicked

    private void cargoDisplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargoDisplayMouseClicked

        int i = cargoDisplay.getSelectedRow();
   
        TableModel model = cargoDisplay.getModel();
        SerialNo.setText(model.getValueAt(i,0).toString());
        DescriptionText.setText(model.getValueAt(i,1).toString());
        PieceCount.setText(model.getValueAt(i,2).toString());
        shipmentID.setText(model.getValueAt(i,3).toString());
        ContainerNumber.setText(model.getValueAt(i,4).toString());
    }//GEN-LAST:event_cargoDisplayMouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        try{
           String search = jTextField1.getText();
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           String sql = "SELECT * FROM cargo where serial_number like '%"+search+"%'";
           PreparedStatement pst = con.prepareStatement(sql);
           DefaultTableModel model = (DefaultTableModel)cargoDisplay.getModel();
           ResultSet rs = pst.executeQuery();
           cargoDisplay.setModel(DbUtils.resultSetToTableModel(rs));
           
           
           
           
     }catch(Exception e){
           System.out.println(e.getMessage());
           
       }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        try{
           String search = jTextField6.getText();
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           String sql = "SELECT * FROM shipment_details where shipment_ID like '%"+search+"%'";
           PreparedStatement pst = con.prepareStatement(sql);
           DefaultTableModel model = (DefaultTableModel)shipmentTable.getModel();
           ResultSet rs = pst.executeQuery();
           shipmentTable.setModel(DbUtils.resultSetToTableModel(rs));
           
           
           
           
     }catch(Exception e){
           System.out.println(e.getMessage());
           
       }
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        try{
           String search = jTextField7.getText();
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           String sql = "SELECT * FROM shipper_table where shipper_ID like '%"+search+"%'";
           PreparedStatement pst = con.prepareStatement(sql);
           DefaultTableModel model = (DefaultTableModel)shippersDisplay.getModel();
           ResultSet rs = pst.executeQuery();
           shippersDisplay.setModel(DbUtils.resultSetToTableModel(rs));
           
           
           
           
     }catch(Exception e){
           System.out.println(e.getMessage());
           
       }
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        try{
           String search = jTextField8.getText();
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           String sql = "SELECT * FROM consignee_table where consignee_ID like '%"+search+"%'";
           PreparedStatement pst = con.prepareStatement(sql);
           DefaultTableModel model = (DefaultTableModel)consigneeDisplay.getModel();
           ResultSet rs = pst.executeQuery();
           consigneeDisplay.setModel(DbUtils.resultSetToTableModel(rs));
           
           
           
           
     }catch(Exception e){
           System.out.println(e.getMessage());
           
       }
    }//GEN-LAST:event_jTextField8KeyReleased

    private void jTextField22KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField22KeyReleased
        try{
           String search = jTextField22.getText();
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           String sql = "SELECT * FROM container_number where Container_ID like '%"+search+"%'";
           PreparedStatement pst = con.prepareStatement(sql);
           DefaultTableModel model = (DefaultTableModel)containerDisplay.getModel();
           ResultSet rs = pst.executeQuery();
           containerDisplay.setModel(DbUtils.resultSetToTableModel(rs));
           
           
           
           
     }catch(Exception e){
           System.out.println(e.getMessage());
           
       }
    }//GEN-LAST:event_jTextField22KeyReleased

    private void consigneeDisplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consigneeDisplayMouseClicked
        int row = consigneeDisplay.getSelectedRow();
        TableModel model = consigneeDisplay.getModel();
        jTextField17.setText((model.getValueAt(row,0)).toString());
        jTextField29.setText((model.getValueAt(row,1)).toString());
      /*  DefaultTableModel consigneeModel = (DefaultTableModel)consigneeDetails_Display.getModel();
        consigneeModel.setRowCount(0);*/
        
        show_consignee_comm();
    }//GEN-LAST:event_consigneeDisplayMouseClicked

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
            int row = consigneeDisplay.getSelectedRow();
           String value = (consigneeDisplay.getModel().getValueAt(row,0).toString());
            String query = "DELETE FROM consignee_table where consignee_ID="+value;
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            
            DefaultTableModel  model = (DefaultTableModel)consigneeDisplay.getModel();
            model.setRowCount(0);
            show_consignee();
            JOptionPane.showMessageDialog(null,"Deleted Succesfully!");
        }catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Deletion Failed!");
           
       }   
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           Statement stm = con.createStatement();
           ResultSet rs = stm.executeQuery("SELECT consignee_ID from consignee_table");
           cbx_cargos_in8.removeAllItems();
           
           
           while(rs.next()){
               String c_id = rs.getString("consignee_ID");
               cbx_cargos_in8.addItem(c_id);
           }
           
           
           
        }catch(Exception e){
           System.out.println(e.getMessage());
          
           
       }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void cbx_cargos_in8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_cargos_in8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_cargos_in8ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           int row = consigneeDisplay.getSelectedRow();
           String value = (consigneeDisplay.getModel().getValueAt(row,0).toString());
           String query = "UPDATE consignee_table SET consignee_name=?,consignee_address=? WHERE consignee_ID="+value;
           PreparedStatement pst = con.prepareStatement(query);
           pst.setString(1,jTextField29.getText());
           pst.setString(2,jTextPane3.getText());
           pst.executeUpdate();
           
           DefaultTableModel  model = (DefaultTableModel)consigneeDisplay.getModel();
           model.setRowCount(0);
           show_consignee();
           show_consignee_comm();
           JOptionPane.showMessageDialog(null,"Updated Succesfully!");
           
           
        }catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Update Failed!");
           
       }
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
            int row = consigneeDetails_Display.getSelectedRow();
            String value = (consigneeDetails_Display.getModel().getValueAt(row,1).toString());
            String query = "DELETE FROM consignee_contact_table WHERE consignee_comm_number='"+value+"' ";
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            
            DefaultTableModel  model = (DefaultTableModel)consigneeDetails_Display.getModel();
            model.setRowCount(0);
            show_consignee_comm();
            JOptionPane.showMessageDialog(null,"Deleted Succesfully!");
        }catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Deletion Failed!");
           
       }  
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           int row = consigneeDetails_Display.getSelectedRow();
           String value = (consigneeDetails_Display.getModel().getValueAt(row,0).toString());
           String query = "UPDATE consignee_contact_table SET consignee_comm_number=?,consignee_comm_qualifier=? WHERE consignee_ID="+value;
           PreparedStatement pst = con.prepareStatement(query);
           pst.setString(1,jTextField21.getText());
           String qualifier;
           qualifier = cbx_cargos_in7.getSelectedItem().toString();
           pst.setString(2,qualifier);
           pst.executeUpdate();
           
           DefaultTableModel  model = (DefaultTableModel)consigneeDetails_Display.getModel();
           model.setRowCount(0);
           show_consignee_comm();
           JOptionPane.showMessageDialog(null,"Updated Succesfully!");
           
           
        }catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Update Failed!");
           
       }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void shipper_comm_qualifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shipper_comm_qualifierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shipper_comm_qualifierActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
           Statement stm = con.createStatement();
           ResultSet rs = stm.executeQuery("SELECT shipper_ID from shipper_table");
           cbx_cargos_in9.removeAllItems();
           
           
           while(rs.next()){
               String s_id = rs.getString("shipper_ID");
               cbx_cargos_in9.addItem(s_id);
           }
           
           
           
        }catch(Exception e){
           System.out.println(e.getMessage());
          
           
       }
    }//GEN-LAST:event_jButton34ActionPerformed

    private void cbx_cargos_in9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_cargos_in9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_cargos_in9ActionPerformed

    private void shippersDisplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shippersDisplayMouseClicked
         int row = shippersDisplay.getSelectedRow();
        TableModel model = shippersDisplay.getModel();
        ShipperID.setText((model.getValueAt(row,0)).toString());
        ShipperName.setText((model.getValueAt(row,1)).toString());
        ShipperAddress.setText((model.getValueAt(row,2)).toString());
      /*  DefaultTableModel consigneeModel = (DefaultTableModel)consigneeDetails_Display.getModel();
        consigneeModel.setRowCount(0);*/
        
        show_shipper_comm();
    }//GEN-LAST:event_shippersDisplayMouseClicked

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
            int row = shippersDisplay.getSelectedRow();
           String value = (shippersDisplay.getModel().getValueAt(row,0).toString());
            String query = "DELETE FROM shipper_table where shipper_ID="+value;
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            
            DefaultTableModel  model = (DefaultTableModel)shippersDisplay.getModel();
            model.setRowCount(0);
            show_shipper();
            JOptionPane.showMessageDialog(null,"Deleted Succesfully!");
        }catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Deletion Failed!");
           
       }   

    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3310/shipmenttracking?useSSL=false","root","KguiDrake");
            int row = shipperDetails_Display.getSelectedRow();
            String value = (shipperDetails_Display.getModel().getValueAt(row,1).toString());
            String query = "DELETE FROM shipper_contact_table WHERE shipper_comm_number='"+value+"' ";
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            
            DefaultTableModel  model = (DefaultTableModel)shipperDetails_Display.getModel();
            model.setRowCount(0);
            show_shipper_comm();
            JOptionPane.showMessageDialog(null,"Deleted Succesfully!");
        }catch(Exception e){
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null,"Deletion Failed!");
           
       } 
    }//GEN-LAST:event_jButton14ActionPerformed

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
            java.util.logging.Logger.getLogger(staff_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(staff_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(staff_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(staff_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        
         
         
         
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new staff_panel().setVisible(true);
        
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser AA_Date;
    private javax.swing.JTextField ContainerNumber;
    private javax.swing.JTextPane DescriptionText;
    private com.toedter.calendar.JDateChooser EA_Date;
    private javax.swing.JTextField PieceCount;
    private com.toedter.calendar.JDateChooser R_Date;
    private javax.swing.JTextField SerialNo;
    private javax.swing.JTextPane ShipperAddress;
    private javax.swing.JTextField ShipperID;
    private javax.swing.JTextField ShipperName;
    private javax.swing.JTextField Shipper_Comm_Number;
    private com.toedter.calendar.JDateChooser TU_Date;
    private javax.swing.JTable cargoDisplay;
    private javax.swing.JComboBox<String> cbx_cargos_in7;
    private javax.swing.JComboBox<String> cbx_cargos_in8;
    private javax.swing.JComboBox<String> cbx_cargos_in9;
    private javax.swing.JTable consigneeDetails_Display;
    private javax.swing.JTable consigneeDisplay;
    private javax.swing.JTable containerDisplay;
    private javax.swing.JLabel image_container;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JLabel lbl_cargos;
    private javax.swing.JLabel lbl_consignees;
    private javax.swing.JLabel lbl_containers;
    private javax.swing.JLabel lbl_dateToday;
    private javax.swing.JLabel lbl_dateToday1;
    private javax.swing.JLabel lbl_logout;
    private javax.swing.JLabel lbl_shipments;
    private javax.swing.JLabel lbl_shippers;
    private javax.swing.JPanel pnlCard_cargos;
    private javax.swing.JPanel pnlCard_consignees;
    private javax.swing.JPanel pnlCard_containers;
    private javax.swing.JPanel pnlCard_shipments;
    private javax.swing.JPanel pnlCard_shippers;
    private javax.swing.JPanel pnl_cargos;
    private javax.swing.JPanel pnl_cargos_side;
    private javax.swing.JPanel pnl_consignees;
    private javax.swing.JPanel pnl_consignees_side;
    private javax.swing.JPanel pnl_containers;
    private javax.swing.JPanel pnl_containers_side;
    private javax.swing.JPanel pnl_logout;
    private javax.swing.JPanel pnl_main;
    private javax.swing.JPanel pnl_shipments;
    private javax.swing.JPanel pnl_shipments_side;
    private javax.swing.JPanel pnl_shippers;
    private javax.swing.JPanel pnl_shippers_side;
    private javax.swing.JTextField shipmentID;
    private javax.swing.JTable shipmentTable;
    private javax.swing.JTable shipperDetails_Display;
    private javax.swing.JComboBox<String> shipper_comm_qualifier;
    private javax.swing.JTable shippersDisplay;
    // End of variables declaration//GEN-END:variables

  
}
