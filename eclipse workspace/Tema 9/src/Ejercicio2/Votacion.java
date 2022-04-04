package Ejercicio2;

import java.util.Arrays;

/**
 * almacena los datos de unas elecciones y determina el numero de esca�os o diputados
 * de los partidos.
 * 
 * @author alu
 *
 */
public class Votacion {
	private final int MAXSIZE=100;
	/**
	  *Lista de partidos con sus votos
	  */
	Partido [] l= new Partido[MAXSIZE];
	Partido [] e = null;
	//cantidad de partidos en la lista
	int partidos=0;
	int diputados;
	Votacion(int diputados){
		this.diputados=diputados;
	}
	public void insertarVotos(String partido, int votos) {
		e=null;
		for(int i=0;i<partidos;i++) {
			if(l[i].getNombre().equals(partido)) {
			l[i].addVotos(votos);
			return;
			}
		}
			l[partidos++]=new Partido(partido,votos);
			
		}
	
	/**
	 * Determina el numero de diputados de cada partido con los datos actuales
	 */
	public void calcular() {
		int votosTotal=0;
		Partido []aux = new Partido[diputados*partidos]; 
		int porcentaje=(int) (votosTotal/100 *5);
		
		for( int i=0 ; i < partidos; i++ ) {
			votosTotal += l[i].getVotos();
		}

		for( int i=0 ; i < partidos; i++ ) {
			if( l[i].getVotos()>=porcentaje ) {
				aux[i]=l[i];
			}else {
				aux[i]=new Partido(l[i].getNombre(), 0);
			}
		}
		for (int i = partidos; i<diputados*partidos; i++) {
				int auxPartido = i%partidos;
				int divisor = i/partidos+1;
				aux[i]= new Partido(aux[auxPartido].getNombre(),
									aux[auxPartido].getVotos()/divisor); 
		}
		Arrays.sort(aux);
		e=new Partido[diputados];
		for( int i =0; i<diputados; i++) {
			e[i]= aux[i];
		}
			
	}
	

	public String toString(){
	if( e == null) {
		return "No ha sido calculado";
	}
	
	String salida="Partido/Votos";
		for (int i=0;i<diputados;i++) {
			salida+= "\n"+ e[i].getNombre()+"\t"+e[i].getVotos();
		}
		return salida;
	}
}
