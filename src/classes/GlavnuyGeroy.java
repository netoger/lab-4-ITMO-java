package classes;

import enums.Condition;
import enums.Gender;
import enums.Height;

public class GlavnuyGeroy extends Human{
    private boolean appetit = true;
    public GlavnuyGeroy(String name,int age, Height height, Gender gender, Place place) {
        super(name, age, height, gender, place);
    }
    public class Harakter{
        private String harakter;
        private boolean nastroy = true;

        public void setHarakter(String harakter) {
            this.harakter = harakter;
            System.out.print("Характер " + name + " поменялся: ");

            boolean n_nastroy;
            if (getCondition() == Condition.SAD ||
                    getCondition() == Condition.FAIR ||
                    getCondition() == Condition.REMORSE ||
                    getCondition() == Condition.SHAME){
                n_nastroy = false;
            }
            else {
                n_nastroy = true;
            }
            if (nastroy != n_nastroy) {
                if (nastroy == false) {
                    System.out.println("он улучшился");
                }
                else {
                    System.out.println("он испортился");
                }
                if (n_nastroy) {
                    appetit = true;
                    System.out.println("Аппетит у " + name + " вернулся");
                } else {
                    appetit = false;
                    System.out.println("Аппетит у " + name + " пропал");
                }

            }

        }

        public String getHarakter() {
            return harakter;
        }

    }
    public void shalost(boolean sleeping, Place place) throws NotAllSleepException {
        if (sleeping){
            move(place);
        }
        else {
            throw new NotAllSleepException("Не все уснули!");
        }
    }
}
