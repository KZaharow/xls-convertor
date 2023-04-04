import org.testng.annotations.Test

import java.util.function.Function

class MyTestComparator {

    @Test
    void compareTest() {
        def list = [
                new Person("ALL", "ALL", "ALL", "ALL"),
                new Person("ALL", "TST", "ALL", "TST"),
                new Person("TST", "ALL", "ALL", "ALL"),
                new Person("ALL", "ALL", "TST", "ALL"),
                new Person("ALL", "ALL", "ALL", "TST"),
                new Person("TST", "ALL", "TST", "ALL")
        ].sort({
            it.id == "ALL" ? -1 : 1 ?:
                    it.name == "ALL" ? -1 : 1 ?:
                            it.sex == "ALL" ? -1 : 1 ?:
                                    it.address == "ALL" ? -1 : 1
        }).reverse().each { println it }


      def  prioritization = ["id", "name", "sex", "Address"]
        prior(list, prioritization)
    }

    def prior(List list, List prioritization) {
        def map = [:]
        def sum = 0
        def k = Math.pow(10, prioritization.size()- 1)
        for(p in prioritization) {
            map[p] = k
            sum = sum + k
            k = k / 10
        }
        println map
        println sum
        def sorted = [:] as TreeMap
        for (person in list){
            int weight = sum
            for (p in prioritization){
                weight = person["$p"] == "ALL" ? weight : weight - map["$p"]
            }
            sorted[weight as String] = person
        }
        sorted.each {println it.value}
    }
}

class Person {
    String id
    String name
    String sex
    String Address

    Person(String id, String name, String sex, String address) {
        this.id = id
        this.name = name
        this.sex = sex
        Address = address
    }


    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
