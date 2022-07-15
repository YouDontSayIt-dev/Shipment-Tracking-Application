/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staff_pnl;

/**
 *
 * @author Finn
 */
class ShipperComm {
    private int sid;
    private String scn,scq;
    
    public ShipperComm(int sid,String scn, String scq ){
        this.sid = sid;
        this.scn = scn;
        this.scq = scq;
        
        
    }
    public int getsid(){
        return sid;
    } 
    public String getscn(){
        return scn;
    }
    public String getscq(){
        return scq;
    } 
}
