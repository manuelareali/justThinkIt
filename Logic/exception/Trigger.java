package exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import beanweb.BachecaPersonaleBoundary;

public class Trigger {

	public void myTrigger() throws MyException{
		throw new MyException("");
	}
	
	 public boolean isNumeric(String str) throws MyException, NumberFormatException { 
		  if (str.isEmpty()) {
			  MyException e = new MyException("Alcuni campi sono vuoti");
			  e.setErrorNumber(MyException.CAMPI_VUOTI);
			  throw e;  
		  }else{
			  Float.parseFloat(str);	  
		  }
		    return true;     
		}
	 
	 public boolean isNumerico(String str) throws MyException, NumberFormatException { 
		  if (str.isEmpty()) {
			  MyException e = new MyException("Inserisci correttamente l'id");
			  e.setErrorNumber(MyException.CAMPI_VUOTI);
			  throw e;  
		  }else{
			  Float.parseFloat(str);	  
		  }
		    return true;     
		}
}
