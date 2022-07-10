/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staff_pnl;

/**
 *
 * @author Finn
 */
class Consignee {
    private int cid;
    private String conname,conadd;
    
    public Consignee(int cid,String conname, String conadd ){
        this.cid = cid;
        this.conname = conname;
        this.conadd = conadd;
        
        
    }
    public int getcid(){
        return cid;
    } 
    public String getconname(){
        return conname;
    }
    public String getconadd(){
        return conadd;
    } 
}
