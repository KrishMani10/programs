import java.util.Arrays;
import java.util.Set;
class Marvel_Superheroes {

    String name;
    int age;
    String nickname;
    Set<PowerAbility>powerAbilities;

    Marvel_Superheroes(String marvel_name,int marvel_age,String marvel_nickname, Set<PowerAbility>powerAbilities){
        this.name = marvel_name;
        this.age = marvel_age;
        this.nickname = marvel_nickname;
        this.powerAbilities = powerAbilities;

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
        System.out.println("Name : " +name+ "\t" +"||" + " age : " +age+ "\t" +"||" + " Marvel name : " +nickname+  "\t" +"||" + " Power ability : " + Arrays.toString(powerAbilities.toArray())
        );
    }
}

