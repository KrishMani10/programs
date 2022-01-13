package mani;

import java.util.Arrays;
import java.util.Set;
class Marvel_Superheroes {

    String name;
    int age;
    String nickName;
    Set<PowerAbility>powerAbilities;

    Marvel_Superheroes(String marvelName,int marvelAge,String marvelNickname, Set<PowerAbility>powerAbilities){
        this.name = marvelName;
        this.age = marvelAge;
        this.nickName = marvelNickname;
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
        System.out.println("Name : " +name+ "\t" +"||" + " age : " +age+ "\t" +"||" + " Marvel name : " +nickName+  "\t" +"||" + " Power ability : " + Arrays.toString(powerAbilities.toArray())
        );
    }
}

enum PowerAbility {
     FLYING,
    TIME_TRAVEL,
    INVISIBLE,
    MAGIC_POWER
}