import java.util.Arrays;
import java.util.Set;
class Marvel_Superheroes {

    String name;
    int age;
    String nickname;
    Set<PowerAbility>PowerAbilities;

    Marvel_Superheroes(String Marvel_Name,int Marvel_Age,String Marvel_Nickname, Set<PowerAbility>PowerAbilities){
        this.name = Marvel_Name;
        this.age = Marvel_Age;
        this.nickname = Marvel_Nickname;
        this.PowerAbilities = PowerAbilities;

    }

    @Override
    public int hashCode(){
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object other){
        if (other instanceof Marvel_Superheroes) {
            return ((Marvel_Superheroes)other).name.equals(this.name);
        }
        return false;
    }


    void printData(){
        System.out.println("Name : " +name+ "\t" +"||" + " age : " +age+ "\t" +"||" + " Marvel name : " +nickname+  "\t" +"||" + " Power ability : " + Arrays.toString(PowerAbilities.toArray())
        );
    }
}

enum PowerAbility {
     FLYING,
    TIME_TRAVEL,
    INVISIBLE,
    MAGIC_POWER
}

