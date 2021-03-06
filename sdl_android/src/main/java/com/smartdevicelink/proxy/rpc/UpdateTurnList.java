package com.smartdevicelink.proxy.rpc;

import com.smartdevicelink.protocol.enums.FunctionID;
import com.smartdevicelink.proxy.RPCRequest;

import java.util.Hashtable;
import java.util.List;

/**
 * Updates the list of next maneuvers, which can be requested by the user pressing the softbutton "Turns" on the
 * Navigation base screen. Three softbuttons are predefined by the system: Up, Down, Close
 * 
 * <p>Function Group: Navigation</p>
 * 
 * <p><b>HMILevel needs to be FULL, LIMITED or BACKGROUND</b></p>
 * 
 * 
 * @since SmartDeviceLink 2.0
 * @see ShowConstantTbt
 */
public class UpdateTurnList extends RPCRequest{
    public static final String KEY_TURN_LIST = "turnList";
    public static final String KEY_SOFT_BUTTONS = "softButtons";

    /**
     * Constructs a new UpdateTurnList object
     */
    public UpdateTurnList() {
        super(FunctionID.UPDATE_TURN_LIST.toString());
    }
    
    /**
    * <p>
    * Constructs a new UpdateTurnList object indicated by the Hashtable
    * parameter
    * </p>
    * 
    * @param hash
    *            The Hashtable to use
    */
    public UpdateTurnList(Hashtable<String, Object> hash) {
        super(hash);
    }
    
    /**
     * Sets a list of turns to be shown to the user
     * 
     * @param turnList
     *            a List<Turn> value representing a list of turns to be shown to the user
     *            <p>
     *            <b>Notes: </b>Minsize=1; Maxsize=100</p>
     */
    public void setTurnList(List<Turn> turnList){
        setParameters(KEY_TURN_LIST, turnList);
    }
    
    /**
     * Gets a list of turns to be shown to the user
     * 
     * @return List<Turn> -a List value representing a list of turns
     */
    @SuppressWarnings("unchecked")
    public List<Turn> getTurnList(){
        return (List<Turn>) getObject(Turn.class, KEY_TURN_LIST);
    }

    /**
     * Gets the SoftButton List object
     * 
     * @return List<SoftButton> -a List<SoftButton> representing the List object
     * @since SmartDeviceLink 2.0
     */
    @SuppressWarnings("unchecked")
    public List<SoftButton> getSoftButtons(){
        return (List<SoftButton>) getObject(SoftButton.class, KEY_SOFT_BUTTONS);
    }

    /**
     * Sets the SoftButtons
     * 
     * @param softButtons
     *            a List<SoftButton> value
     *            <p>
     *            <b>Notes: </b></p>
     *            <ul>
     *            <li>If omitted on supported displays, the alert will not have any SoftButton</li>
     *            <li>ArrayMin: 0</li>
     *            <li>ArrayMax: 4</li>
     *            </ul>
     * @since SmartDeviceLink 2.0
     */

    public void setSoftButtons(List<SoftButton> softButtons){
        setParameters(KEY_SOFT_BUTTONS, softButtons);
    }

}
