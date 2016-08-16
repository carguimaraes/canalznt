package com.digicastservices.canalznt.model.service;

import java.util.ArrayList;

public class AbstractService 
{
	  private ArrayList<String> _listaMsg;
	  
	  public AbstractService()
	  {
		  _clearMsg();
	  }
	  
	  public ArrayList<String> getListaMsg()
	  {
		return  _listaMsg;
	  }
	  
	  protected void _addMsg(String msg)
	  {
		  _listaMsg.add(msg);
	  }
	  
	  protected void _clearMsg()
	  {
		  _listaMsg=   new ArrayList<String>(); 
				  
	  }
}
