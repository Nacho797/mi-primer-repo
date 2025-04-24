package autobuses;

import java.io.*;
public class Paradas
{
	private String nomparada;
	private double precio;
	public Paradas()throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\n\tIntroduzca el nombre de la parada: ");
		nomparada=br.readLine();
		System.out.println("\tIntroduzca precio: ");
		precio=Double.parseDouble(br.readLine());
	}
	public String toString()
	{
	String s;
	s="\n" +nomparada+":"+precio;
	return s;
	}
	public String getNomparada()
	{
		return this.nomparada;
	}
	public double getPrecio()
	{
		return this.precio;
	}
}
