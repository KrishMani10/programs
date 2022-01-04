import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;


public class MarvelComics_Heroes_Information {


    public static void main(String[] args) {
        int marvel_heroes;

        Scanner s = new Scanner(System.in);
        System.out.println("Marvel heroes data are : ");
        try {
            marvel_heroes = s.nextInt();
            s.nextLine();
            Set<Marvel_Superheroes> m = new HashSet<>();
            for (int i = 0; i < marvel_heroes; i++) {
                Set<PowerAbility> powerAbilities = new HashSet<>();
                System.out.println("Name of the Marvel Character : ");
                String marvel_name = s.nextLine();
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
                        powerAbilities.add(ability);
                    }
                }
                m.add(new Marvel_Superheroes(marvel_name, age, nickname, powerAbilities));
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
enum PowerAbility {
     FLYING,
    TIME_TRAVEL,
    INVISIBLE,
    MAGIC_POWER
}