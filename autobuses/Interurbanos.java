/*
 * Interurbanos.java
 *
 * Created on 5 de junio de 2008, 8:24
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package autobuses;


import java.io.*;
import java.util.*;
public class Interurbanos extends Autobuses
{
	private Paradas paradas[];
	public Interurbanos(int n, Paradas p[])
	{
		super(n);
		paradas=p;
	}
	@Override public double  sacarBillete()throws IOException 
	{
		
		String par;
		char opc;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
		System.out.println("\n\tIntroduzca la parada a la que va: ");
		par=br.readLine();
		for(int i=0;i<paradas.length;i++)
		{
			if (paradas[i].getNomparada().equals(par))
			{
						
			System.out.println("\n\tEl precio del billete es "+paradas[i].getPrecio());
			preciobillete=paradas[i].getPrecio();
			return super.sacarBillete();
			}
			
		}				
		
		System.out.println("\nNo existe esa parada");
		return 0;
		
	}
	public int getParadas()
	{
		return paradas.length;
	}
        
        public boolean buscarParada(String nombre){
            for(int i=0; i<paradas.length; i++)
                if (paradas[i].getNomparada().equals(nombre))
                    return true;
            return false;
        }
	
	public String toString()
	{
		String s=super.toString();
		for(int i=0; i<paradas.length; i++)
			s=s + paradas[i].toString();
		return s;	
	}
}
