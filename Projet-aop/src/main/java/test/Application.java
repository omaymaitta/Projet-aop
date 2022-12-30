package test;

import metier.Compte;
import metier.IMetierBanque;
import metier.IMetierBanqueImpl;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        //System.out.println("Class Application is sending a message");
        new Application().start();
    }
    public void start(){
        System.out.println("Demarrage de l'application");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Donner le code de compte :");
        Long code = scanner.nextLong();
        System.out.println("Donner le solde initiale de compte : ");
        double solde = scanner.nextDouble();

        IMetierBanque iMetierBanque = new IMetierBanqueImpl();
        iMetierBanque.addcompte(new Compte(code,solde));

        while (true){
            try {
                System.out.println("=========================================");
                System.out.println(iMetierBanque.consulter(code).toString());
                System.out.print("Type Opération:");
                String type=scanner.next();
                if(type.equals("q")) break;
                System.out.print("Montant:");
                double montant=scanner.nextDouble();
                if(type.toLowerCase().equals("v"))
                    iMetierBanque.verser(code,montant);
                else if(type.toLowerCase().equals("r"))
                    iMetierBanque.retirer(code,montant);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
