package com.ijnkj.websocket;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserConnectPool {

    private static final Map<MyWebSocket,String> userconnections = new HashMap<MyWebSocket,String>();

    /**
     * 获取用户名
     * @param session
     */
    public static String getUserByKey(MyWebSocket conn){
        return userconnections.get(conn);
    }

    /**
     * 获取MyWebSocket
     * @param user
     */
    public static MyWebSocket getMyWebSocketByUser(String user){
        Set<MyWebSocket> keySet = userconnections.keySet();
        synchronized (keySet) {
            for (MyWebSocket conn : keySet) {
                String cuser = userconnections.get(conn);
                if(cuser.equals(user)){
                    return conn;
                }
            }
        }
        return null;
    }

    /**
     * 向连接池中添加连接
     * @param inbound
     */
    public static void addUser(String user, MyWebSocket conn){
        userconnections.put(conn,user);	//添加连接
    }

    /**
     * 获取所有的在线用户
     * @return
     */
    public static Collection<String> getOnlineUser(){
//		List<String> setUsers = new ArrayList<String>();
        Collection<String> setUsers = userconnections.values();
//		for(String u:setUser){
//			setUsers.add("<a onclick=\"toUserMsg('"+u+"');\">"+u+"</a>");
//		}
        return setUsers;
    }

    /**
     * 移除连接池中的连接
     * @param inbound
     */
    public static boolean removeUser(MyWebSocket conn){
        if(userconnections.containsKey(conn)){
            userconnections.remove(conn);	//移除连接
            return true;
        }else{
            return false;
        }
    }

    /**
     * 向特定的用户发送数据
     * @param user
     * @param message
     */
    public static void sendMessageToUser(MyWebSocket conn,String message) throws IOException {
        if(null != conn && null != userconnections.get(conn)){
            conn.sendMessage(message);
        }
    }

    /**
     * 向所有的用户发送消息
     * @param message
     */
    public static void sendMessage(String message) throws IOException {
        Set<MyWebSocket> keySet = userconnections.keySet();
        synchronized (keySet) {
            for (MyWebSocket conn : keySet) {
                String user = userconnections.get(conn);
                if(user != null){
                    conn.sendMessage(message);
                }
            }
        }
    }
}
