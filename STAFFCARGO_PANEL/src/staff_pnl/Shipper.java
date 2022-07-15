/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staff_pnl;

/**
 *
 * @author Finn
 */
class Shipper {
    private int sid;
    private String sname,sadd;
    
    public Shipper(int sid,String sname, String sadd ){
        this.sid = sid;
        this.sname = sname;
        this.sadd = sadd;
        
        
    }
    public int getsid(){
        return sid;
    } 
    public String getsname(){
        return sname;
    }
    public String getsadd(){
        return sadd;
    } 
  
}
