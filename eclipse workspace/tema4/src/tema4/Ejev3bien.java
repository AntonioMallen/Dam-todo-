package tema4;
import java.util.Scanner;
/*El programa que hay que desarrollar, tiene que generar un calendario de un
mes y un a�o. Se le da al programa dicho mes y a�o y debe dar el calendario de
dicho mes de la siguiente forma:
						1S** 2D 
3L** 4M** 5X** 6J** 7V
...
y as� sucesivamente. Tened en cuenta que si el d�a 1 es, por ejemplo, s�bado, debe
aparecer en su columna correspondiente: es decir, los cinco primero d�as est�n en
blanco
Para ello hay que dise�ar varias tareas:
1. una para que, dada una fecha en forma de (d, m, a), nos devuelva el d�a de
la semana
2. otra que, seg�n el mes, nos calcule los d�as de ese mes: 30, 31, 28 � 29.
Para el c�lculo de a�os bisiestos se aplica la siguiente regla: "ser�n bisiestos los
a�os m�ltiplos de 4 salvo los a�os seculares, es decir los acabados en dos ceros
(1800, 1900) de los cuales solo ser�n bisiestos los que sean m�ltiplos de 400"
Para calcular el d�a de la semana de una fecha concreta se puede usar la siguiente
f�rmula:
if ( m <= 2 ) {
m = m+12;
a = a-1;
}
semana = ((d+2*m+3*(m+1)/5+a+a/4-a/100+a/400+2)%7);
donde, siendo d=d�a, m=mes, a=a�o; semana devuelve 0 para s�bado, 1 para
domingo, 2 para lunes... y 6 para viernes.*/
public class Ejev3bien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado=new Scanner(System.in);
		
		
		int semana;
	
		System.out.print("introduce mes");
		int m=teclado.nextInt();
		System.out.print("introduce a�o");
		int a=teclado.nextInt();
		int diaspormes=0;
		char primerdia=' ';

		switch (m) {
			case 1:{diaspormes=31;break;}
			case 2:{if (a%4==0||a%400==0&&a%100!=0) {diaspormes=29;}
					else {diaspormes=28;}
					break;}
			case 3:{diaspormes=31;break;}
			case 4:{diaspormes=30;break;}
			case 5:{diaspormes=31;break;}
			case 6:{diaspormes=30;break;}
			case 7:{diaspormes=31;break;}
			case 8:{diaspormes=31;break;}
			case 9:{diaspormes=30;break;}
			case 10:{diaspormes=31;break;}
			case 11:{diaspormes=30;break;}
			case 12:{diaspormes=31;break;}
			default:{System.out.print("mes no valido");}
		}
		
		int d=0;
					
		for (int contador=1;contador<=diaspormes;contador++) {
			d++;
			semana = ((d+2*m+3*(m+1)/5+a+a/4-a/100+a/400+2)%7);
			switch (semana){
			case 2:{primerdia='L';break;}//lunes
			case 3:{primerdia='M';break;}//martes
			case 4:{primerdia='X';break;}
			case 5:{primerdia='J';break;}
			case 6:{primerdia='V';break;}
			case 0:{primerdia='S';break;}
			case 1:{primerdia='D';break;}
			default:{break;}//domingo
			}
			if ((contador-1)%7==0) {System.out.println();}
			System.out.print(contador+""+primerdia+"**"+"  ");
			}
			
		}
		;
}


	


