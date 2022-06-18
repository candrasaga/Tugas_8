package fromzero;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Magician magician = new Magician(10, 60, 100);
        Healer healer = new Healer(10, 10, 70);
        Warrior warrior = new Warrior(30, 40, 100);
        Titan titan = new Titan(0, 45, 200);

        System.out.println("Selamat datang di game Defense FILKOM !");
        System.out.print("Silahkan masukkan nama player : ");
        String nama = input.nextLine();
        int choose = 0;

        do{
            try{
                System.out.println("Silahkan pilih karakter yang anda inginkan :");
                String[] Role = {"1. Magician", "2. Healer", "3. Warrior"};
                for(String Hero : Role) {
                    System.out.println(Hero);
                }
                choose = input.nextInt();

                if (choose < 1 || choose > 3) throw new NumberFormatException();
            }catch (Exception e){
                if(e instanceof NumberFormatException) {
                    System.out.println("Silahkan masukan angka 1 - 3");
                }
                else{
                        System.err.println("Tolong masukkan angka !");
                    input.next();
                }
            }
        }while (choose == 0);
        System.out.println("Selamat datang, " + nama);

        switch(choose){
            case 1 :
                int i = 1;
                magician.info();
                while(magician.getHp() != 0 && titan.getHp() != 0){
                    System.out.println("==============" + " TURN " + i + " ==============");

                    if(magician.attack()){
                        titan.receiveDamage(magician.getAttack());
                    }
                    if(titan.attack()){
                        magician.receiveDamage(titan.getAttack());
                    }
                    System.out.println("Enemy's HP\t: " + titan.getHp());
                    System.out.println(nama +"'s HP\t: " + magician.getHp());
                    i++;
                }
                System.out.println("====================================");
                if(titan.getHp() == 0) {
                    System.out.println(nama + " menang\n");
                }
                if(magician.getHp() == 0) {
                    System.out.println("Titan menang\n");
                }
                System.out.println("============== PLAYER ==============");
                magician.info();
                System.out.println();
                System.out.println("============== MUSUH ==============");
                titan.info();
                break;

            case 2 :
                int j = 1;
                healer.info();
                while(healer.getHp() != 0 && titan.getHp() != 0){
                    System.out.println("==============" + " TURN " + j + " ==============");
                    if(j % 2 == 0) {
                        healer.Heal();
                    }
                    if(healer.attack()){
                        titan.receiveDamage(healer.getAttack());
                    }
                    if(titan.attack()){
                        healer.receiveDamage(titan.getAttack());
                    }
                    System.out.println("Enemy's HP\t: " + titan.getHp());
                    System.out.println(nama +"'s HP\t: " + healer.getHp());
                    j++;
                }

                System.out.println("====================================");
                if(titan.getHp() == 0) System.out.println(nama + " menang\n");
                if(healer.getHp() == 0) System.out.println("Titan menang\n");
                System.out.println("============== PLAYER ==============");
                healer.info();
                System.out.println();
                System.out.println("============== MUSUH ==============");
                titan.info();
                break;

            case 3 :
                int k = 1;
                warrior.info();
                while(warrior.getHp() != 0 && titan.getHp() != 0){
                    System.out.println("==============" + " TURN " + k + " ==============");
                    if(warrior.attack()){
                        titan.receiveDamage(warrior.getAttack());
                    }
                    if(titan.attack()){
                        warrior.receiveDamage(titan.getAttack());

                    }
                    System.out.println("Enemy's HP\t: " + titan.getHp());
                    System.out.println(nama +"'s HP\t: " + warrior.getHp());
                    k++;
                }
                System.out.println("====================================");
                if(titan.getHp() == 0) System.out.println(nama + " menang\n");
                if(warrior.getHp() == 0) System.out.println("Titan menang\n");
                System.out.println("============== PLAYER ==============");
                warrior.info();
                System.out.println();
                System.out.println("============== MUSUH ==============");
                titan.info();
                break;
        }
    }

}