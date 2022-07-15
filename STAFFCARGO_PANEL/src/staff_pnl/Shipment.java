/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staff_pnl;

/**
 *
 * @author Finn
 */
class Shipment {
    private int shipment_id,consigneeID,shipperID;
    private String trade_update_date,run_date,estimated_arrival_date,foreignportLading,placeofReceipt,portofDestination,actualarrivalDate;
    
    public Shipment(int shipment_id,String trade_update_date,String run_date,String estimated_arrival_date,String foreignportLading,String placeofReceipt,String portofDestination,String actualarrivalDate,int consigneeID,int shipperID){
        this.shipment_id = shipperID;
        this.trade_update_date = trade_update_date;
        this.run_date = run_date;
        this.estimated_arrival_date = estimated_arrival_date;
        this.foreignportLading = foreignportLading;
        this.placeofReceipt = placeofReceipt;
        this.portofDestination = portofDestination;
        this.actualarrivalDate = actualarrivalDate;
        this.shipment_id = shipment_id;
        this.consigneeID = consigneeID;
        this.shipperID = shipperID;
       
        
    }
    public int getshipment_id(){
        return shipment_id;
    } 
    public String gettrade_update_date(){
        return trade_update_date;
    }
    public String getrun_date(){
        return run_date;
    } 
    public String getestimated_arrival_date(){
        return estimated_arrival_date;
    } 
    public String getforeignportLading(){
        return foreignportLading;
    }
    public String getplaceofReceipt(){
        return placeofReceipt;
    }
    public String getportofDestination(){
        return portofDestination;
    }
    public String getactualarrivalDate(){
        return actualarrivalDate;
    }
    public int getconsigneeID(){
        return consigneeID;
    }
    public int getshipperID(){
        return shipperID;
    }
}
