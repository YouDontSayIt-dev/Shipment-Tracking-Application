/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staff_pnl;

/**
 *
 * @author Finn
 */
class Container {
    private String  containid, vesselname;
    
    public Container(String containid,String vesselname){
        this.containid = containid;
        this.vesselname = vesselname;
       
        
        
    }
    public String getcontainid(){
        return containid;
    } 
    public String getvesselname(){
        return vesselname;
    }
    
}
