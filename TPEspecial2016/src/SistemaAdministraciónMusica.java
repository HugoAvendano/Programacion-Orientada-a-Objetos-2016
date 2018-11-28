
import java.util.List;

public class SistemaAdministraciónMusica {
	
	public static void imprimir(List<Pista> l){
		for (Pista pista : l) {
			System.out.print(pista);
		}
	}
	
	public static void main(String[] args) {
		
		//1)DEFINO LAS SIGUIENTES PISTAS DE MUSICA 
		Pista cancion1= new Pista(1,"El Tiempo No Para",311,"Bersuit Vergarabat","De la cabeza",2002,"Rock nacional");
		Pista cancion2= new Pista(2,"Mi caramelo",290,"Bersuit Vergarabat","De la cabeza",2002,"Rock nacional");
		Pista cancion3= new Pista(3,"Party Rock Anthem",408,"LMFAO","Sorry for Party Rocking",2011,"Electro pop");
		Pista cancion4= new Pista(4,"Sorry for Party Rocking",421,"LMFAO","Sorry for Party Rocking",2011,"Electro pop");
		Pista cancion5= new Pista(5,"Fix you",255,"Coldplay","X&Y",2005,"Rock alternativo");
		Pista cancion6= new Pista(6,"Speed of Sound",455,"Coldplay","X&Y",2005,"Rock alternativo");
		Pista cancion7= new Pista(7,"Viva la vida",320,"Coldplay","Viva la vida",2008,"Rock alternativo");
		Pista cancion8= new Pista(8,"With or whitout you",360,"U2","The Joshua Tree",1987,"Rock");
		Pista cancion9= new Pista(9,"Vertigo",355,"U2","How to Dismantle an Atomic Bomb",2004,"rock");
		Pista cancion10= new Pista(10,"City of Blinding Lights",284,"U2","How to Dismantle an Atomic Bomb",2004,"Rock");				
		Pista cancion11= new Pista(11,"A la luz de la luna",438,"El Indio Solari", "Pajaritos, bravos muchachitos",2013,"rock nacional");
		Pista cancion12= new Pista(12,"Yo Canibal",258,"Patricio rey y sus redonditos de ricota","Lobo Suelto, Cordero atado",1993,"Rock Nacional");
		
		//2)DEFINO LAS SIGUIENTES LISTAS DE MUSICA CON EL ORDEN ESPECIFICADO
		//Creo la lista Clasicos del Rock: pistas Nº 1, 2, 8, 9, 10,12
		
		PlayListManual clasicosRock=new PlayListManual("Clasicos del Rock");
		clasicosRock.addElemento(cancion1);
		clasicosRock.addElemento(cancion2);
		clasicosRock.addElemento(cancion8);
		clasicosRock.addElemento(cancion9);
		clasicosRock.addElemento(cancion10);
		clasicosRock.addElemento(cancion12);
				
		
		//Creo la lista "Lo mejor": pistas Nº 3, 4, 7,12
		
		PlayListManual loMejor = new PlayListManual("Lo mejor");
		loMejor.addElemento(cancion3);
		loMejor.addElemento(cancion4);
		loMejor.addElemento(cancion7);
		loMejor.addElemento(cancion12);
		

		//Creo la lista "Coldplay"
		
		PlayListManual coldPlay= new PlayListManual("ColdPlay");
		coldPlay.addElemento(cancion5);
		coldPlay.addElemento(cancion6);
		coldPlay.addElemento(cancion7);
		
		
		
		//Creo la lista "El Indio"
		
		PlayListManual elIndio= new PlayListManual("El Indio");
		elIndio.addElemento(cancion12);
		elIndio.addElemento(cancion11);
		
		//Añado las canciones a la coleccion
		
		PlayListManual coleccion= new PlayListManual("ReproductorMusical");
		
		coleccion.addElemento(cancion1);
		coleccion.addElemento(cancion2);
		coleccion.addElemento(cancion3);
		coleccion.addElemento(cancion4);
		coleccion.addElemento(cancion5);
		coleccion.addElemento(cancion6);
		coleccion.addElemento(cancion7);
		coleccion.addElemento(cancion8);
		coleccion.addElemento(cancion9);
		coleccion.addElemento(cancion10);
		coleccion.addElemento(cancion11);
		coleccion.addElemento(cancion12);
		
		//Añado las playlist a la coleccion
		
		coleccion.addElemento(clasicosRock);
		coleccion.addElemento(loMejor);
		coleccion.addElemento(coldPlay);
		coleccion.addElemento(elIndio);
		
		
		//3)IMPRIMO POR PANTALLA LAS LISTAS “Clásicos del Rock”, “Lo mejor” y “Coldplay”
		
		System.out.print(clasicosRock+"\n");
		System.out.print(loMejor+"\n\n");
		System.out.print(coldPlay+"\n\n");
		
		
		//4)EJECUTO LAS SIGUIENTES BUSQUEDA E IMPRIMO POR PANTALLA LOS RESULTADOS:
		
		//a) Las pistas cuya duración sea superior a 400 segundos.
		
		List <Pista> resultadoA= coleccion.pistasQueCumplen(new FiltroMinDuracion(400));
		System.out.print("\nLAS PISTAS CUYA DURACION ES MAYOR A 400 SEGUNDOS SON: ");
		imprimir(resultadoA);
		
		//b) Las pistas cuyo género contenga la palabra “rock”.
		
		List <Pista> resultadoB= coleccion.pistasQueCumplen(new FiltroIgualGenero("rock"));
		System.out.print("\n\nLAS PISTAS CUYO GENERO CONTENGA LA PALBRA rock SON: ");
		imprimir(resultadoB);
		
		//c) Las pistas cuyo nombre contenga “rock” pero cuyo interprete NO sea “LMFAO”.
		List <Pista> resultadoC= coleccion.pistasQueCumplen(new FiltroAnd(new FiltroIgualTituloPista("rock"), new FiltroNot(new FiltroIgualArtista("LMFAO"))));
		System.out.print("\n\nLAS PISTAS CUYO TITULO CONTENGA rock PERO CUYO INTERPRETE NO SEA LMFAO SON: ");
		imprimir(resultadoC);
		
		//d) Las pistas cuyo género contenga “rock” y cuya fecha sea mayor a “2006”, o cuyo género contenga “rock” y cuyo intérprete sea “coldplay”.
		List <Pista> resultadoD = coleccion.pistasQueCumplen(new FiltroOr(new FiltroAnd(new FiltroIgualGenero("rock"),new FiltroMinAño(2006)), new FiltroAnd(new FiltroIgualGenero("rock"),new FiltroIgualArtista("coldplay"))));
		System.out.print("\n\nLAS PISTAS CUYO GENERO CONTENGA rock Y CUYA FECHA SEA MAYOR A 2006,\no CUYO GENERO SEA rock Y CUYO INTERPRETE NO SEA coldplay   son: ");
		imprimir(resultadoD);
		
		//5) Imprimir por pantalla la duración total de cada playlist definida y 
		//volver a realizar la búsqueda 4)a) e imprimir la duración total del resultado.
		
		System.out.println("\n\nLA DURACIÓN DE LA PLAYLIST CLASICOS DEL ROCK ES:  "+ clasicosRock.getDuracion());
		System.out.println("LA DURACIÓN DE LA PLAYLIST LO MEJOR  ES:  "+ loMejor.getDuracion());
		System.out.println("LA DURACIÓN DE LA PLAYLIST COLDPLAY ES:  "+ coldPlay.getDuracion());
		System.out.println("LA DURACIÓN DE LA PLAYLIST EL INDIO:  "+ elIndio.getDuracion());
		
		List <Pista> resultado5=coleccion.pistasQueCumplen(new FiltroMinDuracion(400));
		int duracionTotal= 0;
		for (Pista pista : resultado5) {
			duracionTotal+=pista.getDuracion();
		}
		System.out.println("\nDURACION TOTAL DE LAS PISTAS QUE CUMPLEN CON EL CRITERIO DE QUE SEAN MAYORES A 400 SEGUNDOS ES: "+ duracionTotal+" segundos\n");
		
		//6)REALIZO UNA COPIA DE LA PLAYLIST "Lo mejor", la renombro como "Lo mejor++", 
		//INTERCAMBIO EL ORDEN DE LAS PISTAS 3 Y 7 EN LA COPIA, E IMPRIMO LA PLAYLIST ORIGINAL Y LA COPIA .
	
		PlayListManual copiaLoMejor= loMejor.copy();
		copiaLoMejor.setNombre("Lo mejor++");
		copiaLoMejor.intercambiarElemento(0,2);
		System.out.println(loMejor+"\n");
		System.out.println(copiaLoMejor);
	
		//7)DEFINO LA PLAYLIST AUTOMATICA CON NOMBRE “Todo lo de Coldplay”  que 
		//CONTENGA  LAS PISTAS CUYO INTERPRETE SEA "coldplay" E IMPRIMO POR PANTALLA
		
		PlayListAutomatica automaticaColdPlay= new PlayListAutomatica("Todo lo de Coldplay", coleccion, new FiltroIgualArtista("coldplay"));
		System.out.println("\n"+automaticaColdPlay);
	
	
	
		//8)AGREGO UNA NUEVA PLAYLIST AL SISTEMA CON LA DESCRIPCION DADA E IMPRIMO NUEVAMENTE LA PLAYLIST AUTOMATICA
		coleccion.addElemento(new Pista(13,"Paradise",365,"Coldplay","Mylo Xyloto",2011,"Rock alternativo"));
		//System.out.print("\nPlayList: Todo lo de Coldplay");
		System.out.println("\n"+automaticaColdPlay);
	}
		
	

}
