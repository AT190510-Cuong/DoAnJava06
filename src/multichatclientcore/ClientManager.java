/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multichatclientcore;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MinhLuong
 */
public class ClientManager extends Observable{
    
    String serverName = "localhost";
    int port = 1106;
    Socket mSocket;
    BufferedWriter mBufferWriter;
    DataInputStream mDataInputStream;
    Thread mThread;
    public String mNickname;
    public ClientManager(Observer obs)  //hàm khởi tạo khi chưa có socket
    {
        this.addObserver(obs);
    }
    public ClientManager(Socket socket, Observer obs)   //hàm khởi tạo khi đã có socket
    {
        this.addObserver(obs);
        mSocket = socket;
    }
    public void Dispose()
    {
        if(mSocket!=null)
        {
            try 
            {
                mSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if(mThread!=null)
            mThread.stop();
    }
    public boolean StartConnect()
    {
        try 
        {
            mSocket = new Socket(serverName, port); 
            //Sử dụng dataInputStream để đợi nhận kết quả thì vòng while sẽ ko cần chạy liên tục -> tránh tốn hiệu suất
            mDataInputStream = new DataInputStream(mSocket.getInputStream());
            mBufferWriter = new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream(), "UTF8"));
            StartThreadWaitResult();
            return true;
        } catch (IOException ex) 
        {
            Result result = new Result("", ResultCode.ERROR, "Không thể kết nối đến server");
            notifyObservers(result);
            return false;
        }
    }
    
    void StartThreadWaitResult()
    {
        mThread = new Thread(new Runnable() 
        {
            @Override
            public void run() 
            {
                try 
                {
                    while(true)
                    {
                        String[] lines = mDataInputStream.readUTF().split(";", -1);  //limit = -1 sẽ ko loại bỏ phần tử cuối nếu bị rỗng và đảm bảo đủ 3 phần tử để ko bị lỗi
                        Result result;
                        if(lines.length==3) //nếu chỉ gồm 3 phần tức là chỉ gồm actionType;ResultCode;Content
                        {
                            result = new Result(lines[0], lines[1], lines[2]);
                        }else  //nếu nhiều hơn tức là phần content đằng sau có ;
                        {
                            String content = "";
                            for (int i = 2; i < lines.length; i++)   //nên nối lại phần content
                            {
                                content += lines[i] + ";";
                            }
                            result = new Result(lines[0], lines[1], content);
                        }
                        notifyObservers(result);   //thông báo đến các obs
                    }
                }catch (IOException ex) {
                    Result result = new Result("", ResultCode.ERROR, "Kết nối tới server có lỗi");
                    notifyObservers(result);
                }
            }
        });
        mThread.start();
    }
    
    @Override
    public void notifyObservers(Object arg) {
        super.setChanged();
        super.notifyObservers(arg);
    }
 
    public void SendMess(String mess)
    {
        mess = mess.replaceAll("\\n", "<br>");
        String line = ActionType.SEND_MESSAGE + ";" + mess;
        try 
        {
            mBufferWriter.write(line + "\n");
            mBufferWriter.flush();
        } catch (IOException ex) {
            Result result = new Result("", ResultCode.ERROR, "Không thể kết nối tới server");
            notifyObservers(result);
        }
    }
    public void Login(String nickName) throws UnsupportedEncodingException  //vì làm đơn giản nên chỉ cần đăng nhập với họ tên
    {
        String line = ActionType.LOGIN + ";" + nickName;
        try
        {
            mBufferWriter.write(line + "\n");
            mBufferWriter.flush();
        } catch (IOException ex) {
            Result result = new Result("", ResultCode.ERROR, "Không thể kết nối tới server");
            notifyObservers(result);
        }
    }
    
    public void GetListRoom()
    {
        String line = ActionType.GET_LIST_ROOM + ";";
        try
        {
            mBufferWriter.write(line + "\n");
            mBufferWriter.flush();
        } catch (IOException ex) {
            Result result = new Result("", ResultCode.ERROR, "Kết nối tới server có lỗi");
            notifyObservers(result);
        }
    }
    
    public void CreateRoom(String roomName)
    {
        String line = ActionType.CREATE_ROOM + ";" + roomName;
        try
        {
            mBufferWriter.write(line + "\n");
            mBufferWriter.flush();
        } catch (IOException ex) {
            Result result = new Result("", ResultCode.ERROR, "Kết nối tới server có lỗi");
            notifyObservers(result);
        }
    }
    
    public void JoinRoom(String maPhong)
    {
        String line = ActionType.JOIN_ROOM + ";" + maPhong;
        try
        {
            mBufferWriter.write(line + "\n");
            mBufferWriter.flush();
        } catch (IOException ex) {
            Result result = new Result("", ResultCode.ERROR, "Kết nối tới server có lỗi");
            notifyObservers(result);
        }
    }
    public void LeaveRoom()
    {
        String line = ActionType.LEAVE_ROOM + ";null";
        try
        {
            mBufferWriter.write(line + "\n");
            mBufferWriter.flush();
        } catch (IOException ex) {
            Result result = new Result("", ResultCode.ERROR, "Kết nối tới server có lỗi");
            notifyObservers(result);
        }
    }
    public void Logout()
    {
        String line = ActionType.LOGOUT + ";null";
        try
        {
            mBufferWriter.write(line + "\n");
            mBufferWriter.flush();
        } catch (IOException ex) {
            Result result = new Result("", ResultCode.ERROR, "Kết nối tới server có lỗi");
            notifyObservers(result);
        }
    }
    
    
}
