package listacircular.app;


import java.util.InputMismatchException;
import java.util.Scanner;

import listacircular.entities.Noticia;
import listacircular.entities.Slide;

public class ListaCircularApp {
    public static void execute() throws Exception {
      Scanner scan = new Scanner(System.in);
      Slide slide = new Slide();
      int op=0,countId=0,index=0;
      String titulo,info;
     

		do{
      
      System.out.println("---------------------------");
			System.out.println("     Slide de Noticias");
			System.out.println("---------------------------");
			System.out.println("1 - Adicionar Noticia");

      if(!slide.isEmpty()){
          System.out.println("2 - Adicionar Noticia no Principio");
          System.out.println("3 - Remover Primeira Noticia");
          System.out.println("4 - Remover Ultima Noticia");
          System.out.println("5 - Remover Todas Noticias");
          if(slide.size()>1){
            System.out.println("6 - Executar Slide");
          }
          System.out.println("7 - Total de Noticias");
          
      }
			System.out.println("8 - Sair");

      
			try {
        System.out.print("\nEscolha uma opcão: ");
				op = scan.nextInt();
				scan.nextLine();
        if(op == 1){
          System.out.print("\nDigite o Titulo da Noticia: ");
           titulo = scan.nextLine();
          System.out.print("Digite a Noticia: ");
           info = scan.nextLine();
          Noticia noticia = new Noticia(++countId,titulo, info);
          slide.addSlide(noticia);
          System.out.println("Slide Adicionado com Sucesso");
        }else if(op == 8){
          return;
        }else if(!slide.isEmpty()){
          
            switch(op){
              case 2: 
                System.out.print("\nDigite o Titulo da Noticia: ");
                titulo = scan.nextLine();
                System.out.print("Digite a Noticia: ");
                info = scan.nextLine();
                Noticia noticia = new Noticia(++countId,titulo, info);
                slide.addSlideFirst(noticia);
                System.out.println("Slide Adicionado com Sucesso");
                break;
              case 3: 
                  slide.removeFirstSlide();
                  System.out.println("Primeiro Slide Removido com Sucesso");
                  break;
              case 4: 
                slide.removeLastSlide();
                System.out.println("Ultimo Slide Removido com Sucesso");
                break;
              case 5:
                slide.clearSlide();
                System.out.println("Slide Limpo com Sucesso");
                break;
              case 6:
                  String continua;
                  while(true){
                    slide.nextSlide();
                    System.out.print("Deseja continuar?(s/n): ");
                    continua= scan.nextLine();
                    if(!continua.toLowerCase().equals("s")){
                      slide.stopSlide();
                      break;
                    }else{
                      continua="";
                    }
                  
                  }
                  break;
              case 7:System.out.println("\nTotal de Noticias: "+slide.size()); break;
              default: System.out.println("\nOpcao Invalida");
            }	
        }
      
			}catch(InputMismatchException e){
				System.out.println("\n Valor inválido digitado ");
			}catch(Exception e){
				System.out.println("\nAlgum erro :"+ e);
			}	
     
    }while(true);
}}
