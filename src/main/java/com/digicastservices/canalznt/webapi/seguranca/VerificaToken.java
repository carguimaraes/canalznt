package com.digicastservices.canalznt.webapi.seguranca;



//https://github.com/auth0/java-jwt
//https://jwt.io/#encoded-jwt
//http://kjur.github.io/jsjws/tool_jwt.html
//http://jwtbuilder.jamiekurtz.com/

//TODO esta classe sera melhorada
//Usando JWT
public class VerificaToken 
{
  	
  private static String _token="BRRJ2016CANALZNTV01ACE001";
  
  public static boolean isValido(String token)
  {
	  if(token==null) return false;
	  return  token.equals(_token);
		  
  }
}
