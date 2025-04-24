/*
 * Autobuses.java
 *
 * Created on 5 de junio de 2008, 8:19
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package autobuses;
import java.io.*;
import java.util.*;
/**
 *
 * @author dai1
 */
public class Autobuses
{
 	/**
         * variable que guarda el numero de la linea
         */
        private int numlinea,numpasaj;
       	private static GregorianCalendar horaini=new GregorianCalendar(0,0,0,6,0),horafin=new GregorianCalendar(0,0,0,23,0);
 	protected double preciobillete;
	private double importetotal;
	private static double total;//total recaudado por la empresa
 	/**
         * 
         * @param n numero de la linea que damos de alta
         */
        public Autobuses(int n)
 	{
                numlinea=n;
		numpasaj=0;
		importetotal=0;
	}
        /**
         * método que nos describe al objeto
         * @return variable string que contiene toda la descripcion
         */
	@Override public  String toString()
	{
	 	String d="\n\tNumero de linea: "+numlinea+ "\nTipo:" + getClass().getName()+
				"\n\tPasajeros: "+numpasaj+"\tImporte total obtenido: "+importetotal;
		return d;
	}
	/**
         * 
         * @return total acumulado en toda la empresa
         */
	public static double getTotal()
	{
		return total;
	}
	public double sacarBillete()throws IOException
	{	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 		System.out.println("\nPaga con abono:");
		String resp=br.readLine();
		double precio=0;
		if (resp.toUpperCase().equals("S"))
			precio=preciobillete-preciobillete*0.15;
		else 
			precio=preciobillete;	
		importetotal+=precio;
		numpasaj++;
		total+=precio;
		return precio;
	}
        
        public static boolean horaCorrecta(GregorianCalendar g){
            if (g.compareTo(horaini)<0 || g.compareTo(horafin)>0)
                return false;
            return true;
            
        }
	
	public static void setHoraInicio(int h,int m){
            horaini=new GregorianCalendar(0,0,0,h,m);
        }
        
        public static void setHoraFin(int h,int m){
            horafin=new GregorianCalendar(0,0,0,h,m);
        }
        
	public int getNumlinea()
	{
		return this.numlinea;
	}
	public double getImportetotal()
	{
		return this.importetotal;
	}
}
