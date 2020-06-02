package com.yihukurama.sysbase.module.im.websocket;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.alibaba.fastjson.JSON;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.app.utils.LogUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocket extends TextWebSocketHandler {

	private String key;

	private static final ConcurrentHashMap<String, WebSocketSession> socketMap = new ConcurrentHashMap<>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	}



	private String getUid(WebSocketSession session){
		String uid = session.getUri().getQuery();

		if(EmptyUtil.isEmpty(uid)){
			LogUtil.errorLog(this,"存在没有传入用户id的websocket链接");
			return "";
		}

		return uid;
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String messageStr = message.getPayload();
		String uid = getUid(session);
		if(!EmptyUtil.isEmpty(messageStr) && !EmptyUtil.isEmpty(uid)){

		}else{

		}
	}


	// 向指定的socket发送消息
	public static void sendMsgByUserId(String message, String key) {
		if(!socketMap.containsKey(key)){
			//用户未连接转广播
			broadcast(message);
			return;
		}

		try{
			socketMap.get(key).sendMessage(new TextMessage(message));
		}catch (Throwable e){
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			LogUtil.errorLog(WebSocket.class, "发送消息给" + key + "出错：" + sw.toString());
		}
	}

	/**
	 * 功能描述:通知用户跟进
	 * @param id 用户id
	 * @param data 事故单Accorder,案件Cases,鉴定单Apporder
	 * @param cmd 各种socket命令
	 * @Author:dengshuai
	 * @Date:2017年2月9日 上午11:23:03
	 */
	public static void notifyUser(String id,Object data,String cmd){
		if(id == null || "".equals(id) || data == null){
			LogUtil.errorLog(WebSocket.class, "用户id为空或data数据为空,socket消息发送失败");
			return;
		}
		LogUtil.errorLog(WebSocket.class, "Socket通知用户" + id);
		sendMsgByUserId(JSON.toJSONString(data),id);
	}


	// 向所有连接上来的socket广播消息
	public static void broadcast(String message) {

		for(Map.Entry<String, WebSocketSession> entry : socketMap.entrySet()){
			try{
				TextMessage textMessage = new TextMessage(message);
				entry.getValue().sendMessage(textMessage);
			}catch (Throwable e){
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				e.printStackTrace(pw);
				LogUtil.errorLog(WebSocket.class, "广播消息出错：" + sw.toString());
			}
		}
	}
	

}