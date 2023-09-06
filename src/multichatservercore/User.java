/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multichatservercore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MinhLuong
 */
public class User {
    Socket mSocket;
    BufferedReader mBufferReader;
    DataOutputStream mDataOutputStream;
    public String mNickName;
    public Room mRoom;
    public Date mTimeConnect; //thời gian kết nối đến server
    public boolean mLogined = false;   //trạng thái đã đăng nhập hay chưa
    public User(Socket socket) throws IOException
    {
        mSocket = socket;
        mBufferReader = new BufferedReader(new InputStreamReader(mSocket.getInputStream(), "UTF8"));
        mDataOutputStream = new DataOutputStream(mSocket.getOutputStream());  //user nhận bằng DataInputStream nên gửi về bằng DataOutputStream
    }
    
    public String Read() throws IOException
    {
        if(mBufferReader.ready())
        {
            return mBufferReader.readLine();
        }
        return null;
    }
    
    public boolean Ready() throws IOException
    {
        return mBufferReader.ready();
    }

    public Boolean Send(String actionType, String resultCode, String content)
    {
        try 
        {
            mDataOutputStream.writeUTF(actionType + ";" + resultCode + ";" + content);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Boolean IsOnline()
    {
        return Send(ActionType.CHECK_ONLINE, ResultCode.OK, "");
    }
}
