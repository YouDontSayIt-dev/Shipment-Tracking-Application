/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staff_pnl;

/**
 *
 * @author Finn
 */
class Cargo {
    private int sno,piece_count;
    private String desc_text,shipment_id,container_number;
    
    public Cargo(int sno,String desc_text, int piece_count, String shipment_id, String container_number ){
        this.sno = sno;
        this.piece_count = piece_count;
        this.shipment_id = shipment_id;
        this.container_number = container_number;
        this.desc_text = desc_text;
        
    }
    public int getsno(){
        return sno;
    } 
    public String getdt(){
        return desc_text;
    }
    public int getpc(){
        return piece_count;
    } 
    public String getsid(){
        return shipment_id;
    } 
    public String getcn(){
        return container_number;
    }
     
}
