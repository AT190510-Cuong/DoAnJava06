/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multichatclientcore;

/**
 *
 * @author MinhLuong
 */
public class Result 
{
    public String mActionType;
    public String mResultCode;
    public String mContent;

    public Result(String mActionType, String mResultCode, String mContent) {
        this.mActionType = mActionType;
        this.mResultCode = mResultCode;
        this.mContent = mContent;
    }
}
