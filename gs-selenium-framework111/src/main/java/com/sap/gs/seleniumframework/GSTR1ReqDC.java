package com.sap.gs.seleniumframework;


import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class GSTR1ReqDC implements Serializable 
{
	/**
	 * Request object for GSTR1
	 */
	private static final long serialVersionUID = 1L;
	private String action;
	private String transid;
	private Data data;
	
	public GSTR1ReqDC() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GSTR1ReqDC(String action, String transid, Data data) {
		super();
		this.action = action;
		this.transid = transid;
		this.data = data;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getTransid() {
		return transid;
	}

	public void setTransid(String transid) {
		this.transid = transid;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public static class Data 
	{
		private String content;
		private String type;
		
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		@Override
		public String toString() {
			return "Data [content=" + content + ", type=" + type + "]";
		}		
	}

	@Override
	public String toString() {
		return "GSTR1ReqDC [action=" + action + ", transid=" + transid + ", data=" + data + "]";
	}
}
