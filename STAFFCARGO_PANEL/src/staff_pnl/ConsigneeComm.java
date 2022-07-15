/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staff_pnl;

/**
 *
 * @author Finn
 */
class ConsigneeComm {
    private int cid;
    private String ccn,ccq;
    
    public ConsigneeComm(int cid,String ccn, String ccq ){
        this.cid = cid;
        this.ccn = ccn;
        this.ccq = ccq;
        
        
    }
    public int getcid(){
        return cid;
    } 
    public String getccn(){
        return ccn;
    }
    public String getccq(){
        return ccq;
    } 
}
