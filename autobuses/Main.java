
/*
 * Main.java
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
public class Main {
    
  public static void main(String st[])throws IOException
	{
		int opc, resp,linea, h,m,pos,num;
		//double total=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Vector lineas=new Vector();  
		do                                     
		{
			System.out.println("\n\tQue desea hacer:\n\t1.Alta linea\n\t2.Lineas que pasan por una parada");
			System.out.println("\t3.Subir pasajero\n\t4.Modificar horas\n\t5.Borrar linea con más pérdidas");
			System.out.println("\t6.Informacion\n\t7.Salir");
			opc=Integer.parseInt(br.readLine());
			switch (opc)
			{
			case 1:
                           
					System.out.println("\n\tAlta autobus");
					System.out.println("\t************");
                                        System.out.println("\nIntroduce numero:");
                                        num=Integer.parseInt(br.readLine());
                                        //Busco el hueco en el vector
                                        pos=lineas.size();
                                        for(int i=0;i<lineas.size();i++)
                                            if (((Autobuses)(lineas.get(i))).getNumlinea()>num){
                                                pos=i;
                                                break;
                                            }
                                            else
                                              if (((Autobuses)(lineas.get(i))).getNumlinea()==num){
                                                lineas.remove(i);
                                                pos=i;
                                                break;
                                              }
                                                                                    
					System.out.println("\n\n\tQue tipo de autobus desea introducir:\n\t1.Urbano\n\t2.Interurbano");
					resp=Integer.parseInt(br.readLine());
					if(resp==1){
                                                System.out.println("\nIntroduce el precio del billete:");
                                                double precio=Double.parseDouble(br.readLine());
						lineas.add(pos,new Urbanos(num,precio));
                                        }
					else{
                                            System.out.println("\n\tCuantas paradas tiene la linea?? ");
                                            int numero=Integer.parseInt(br.readLine());
                                            Paradas paradas[]=new Paradas[numero];
                                            for(int x=0; x<numero; x++)
                                                paradas[x]=new Paradas();
                                            lineas.add(pos,new Interurbanos(num,paradas));
                                        }
									
					break;
			
			case 2:
					//int numaux=0;
					System.out.println("\n\tInterurbanos que pasan por una determinada parada");
					System.out.println("\t****************************\n");
					System.out.println("\n\tIntroduzca el nombre de la parada: ");
					String nombre=br.readLine();
                                        boolean encontrada=false;
					for(int x=0; x<lineas.size(); x++)
					{
						if (lineas.get(x) instanceof Interurbanos)
						
							if (((Interurbanos)(lineas.get(x))).buscarParada(nombre)){
                                                            System.out.println(lineas.get(x));
                                                            encontrada=true;
                                                        }
							
						
					}	
					if(!encontrada)
						System.out.println("\n\tNo hay ninguna interurbano con esa parada");
					break;
			case 3:
					System.out.println("\n\tPasajerooooooooo");
					System.out.println("\t****************");
                                        do{
                                            System.out.println("\nIntroduzca hora:");
                                            h=Integer.parseInt(br.readLine());
                                            System.out.println("\nIntroduzca minutos:");
                                            m=Integer.parseInt(br.readLine());
                                        }
                                        while (!Autobuses.horaCorrecta(new GregorianCalendar(0,0,0,h,m)));
                                   	System.out.println("\n\tIntroduzca el numero de linea: ");
					linea=Integer.parseInt(br.readLine());
                                        boolean encontrado=false;
					for(int x=0; x<lineas.size(); x++)
					{
                                                Autobuses aux;
                                                aux=(Autobuses)lineas.get(x);
						if(linea==aux.getNumlinea()) {
							System.out.println("Precio billete: " +aux.sacarBillete());
                                                        encontrado=true;
                                                        break;
                                                }
					}
                                        if (!encontrado)
                                                System.out.println("\nNo existe esa línea");
					break;
			case 4:
					System.out.println("\nAnote nueva hora de inicio:");
                                        h=Integer.parseInt(br.readLine());
                                        System.out.println("\nminutos:");
                                        m=Integer.parseInt(br.readLine());
                                        Autobuses.setHoraInicio(h,m);
                                        System.out.println("\nAnote nueva hora de fin:");
                                        h=Integer.parseInt(br.readLine());
                                        System.out.println("\nminutos:");
                                        m=Integer.parseInt(br.readLine());
                                        Autobuses.setHoraFin(h,m);
					break;
			case 5:         System.out.println("\n\tEliminar linea");
                                        System.out.println("\t**************");
					try{
                                            pos=menosBeneficios(lineas);
                                            lineas.remove(pos);
                                            
                                        }catch(MasException e){
                                            System.out.println(e.getMessage());
                                        }
					
					System.out.println("\n\n\t...........linea eliminada");
					break;
                         case 6:
					System.out.println("\n\tInformacion lineas");
					System.out.println("\t******************\n");
					for(int x=0; x<lineas.size(); x++)
						System.out.println("\n\t"+lineas.get(x).toString());
					break;
			}
		}
		while(opc!=7);
		System.out.println("\n\n\n\tFIINNNNNNNNNNNNNNNNN");
	} 
  
  public static int menosBeneficios(Vector l) throws MasException{
      double min=((Autobuses)(l.get(0))).getImportetotal();
      int pos=0,cuantas=0;
      for(int x=0;x<l.size();x++){
					
		if (((Autobuses)(l.get(x))).getImportetotal()<min){
			min=((Autobuses)(l.get(x))).getImportetotal();
                        cuantas=1;
			pos=x;
                }
                else if (((Autobuses)(l.get(x))).getImportetotal()==min)
                        cuantas++;
	}
      if (cuantas>1)
          throw new MasException(cuantas);
      return pos;
  }
    
}
