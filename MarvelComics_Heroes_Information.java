import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;


public class MarvelComics_Heroes_Information {


    public static void main(String[] args) {
        int Marvel_Heroes;

        Scanner s = new Scanner(System.in);
        System.out.println("Marvel heroes data are : ");
        try {
            Marvel_Heroes = s.nextInt();
            s.nextLine();
            Set<Marvel_Superheroes> m = new HashSet<>();
            for (int i = 0; i < Marvel_Heroes; i++) {
                Set<PowerAbility> PowerAbilities = new HashSet<>();
                System.out.println("Name of the Marvel Character : ");
                String Marvel_Name = s.nextLine();
                System.out.println("Age of the Marvel Character : ");
                int age = s.nextInt();
                s.nextLine();
                System.out.println("Nickname of marvel character : ");
                String nickname = s.nextLine();
                System.out.println("Power ability of marvel character : ");
                for (PowerAbility ability : PowerAbility.values()) {
                    System.out.println("Does character have ability : " + ability + " ? (y/n)");
                    char choice = s.next().charAt(0);

                    if (choice == 'y') {
                        PowerAbilities.add(ability);
                    }
                }
                m.add(new Marvel_Superheroes(Marvel_Name, age, nickname, PowerAbilities));
                s.nextLine();
            }

            for (Marvel_Superheroes hero : m) {
                hero.printData();
            }
        }
        catch(Exception e){
            System.out.println("Given input is mismatched");
        }

    }
}
