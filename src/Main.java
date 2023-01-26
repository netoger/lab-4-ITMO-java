/*
Услышав такой категорический ответ.
Селедочка больше не возобновляла этого разговора.
Со временем Незнайка понемножечку успокоился и уже не убивался, как прежде.
Аппетит вернулся к нему. Сон тоже улучшился.
Вместе с другими коротышками Незнайка приходил в Космический городок,
наблюдал, как производятся испытания ракеты, как тренируются путешественники перед отправлением в космос,
слушал лекции Фуксии и Селедочки о Луне, о межпланетных полетах.
Казалось, что он совершенно примирился со своей участью и уже не мечтает о путешествии на Луну.
Даже характер у Незнайки как будто переменился.
Самые наблюдательные коротышки замечали, что Незнайка стал часто о чем-то задумываться.
Когда у него бывали припадки задумчивости, на лице появлялась какая-то мечтательная улыбка, словно Незнайка чему-то радовался.
Никто, однако ж, не мог догадаться, что его настраивало на такой радостный лад.
 */
/*
Однажды Незнайка встретил Пончика и сказал: Вечером,
накануне назначенного для отлета дня, Незнайка и Пончик не легли спать.
Дождавшись, когда все коротышки уснут, они выбрались потихоньку из дома и отправились в Космический городок.
Ночь была темная, и у Пончика мороз подирал по коже от страха.
При мысли, что он скоро унесется в космическое пространство, душа у него уходила, как говорится, в пятки.
Он уже раскаивался, что ввязался в такое опасное предприятие, однако стыдился признаться Незнайке, что струсил.
 */
/*
Было уже совсем поздно, когда Незнайка и Пончик добрались до Космического городка.
Взошла Луна, и вокруг стало светлей.
Прокравшись мимо домов, наши друзья очутились на краю круглой площади, в центре которой возвышалась космическая ракета.
Она поблескивала своими стальными боками в голубоватом свете Луны,
а Незнайке и Пончику казалось, что ракета светится сама собой, словно была сделана из какого-то светящегося металла.
В ее очертаниях было что-то смелое и стремительное, неудержимо рвущееся кверху:
казалось, что ракета вот-вот сорвется со своего места и полетит ввысь.
 */

import classes.*;
import enums.*;
import interfaces.*;

public class Main {
    public static void main(String[] args) throws NotAllSleepException {
        // начало истории
        boolean isAllSon = false;
        System.out.println("************** Создание объектов **************");
        Place gorod = new Place("город Коротышек");
        Place KosmGrad = new Place("Космический городок");
        GlavnuyGeroy DontKnower = new GlavnuyGeroy("Незнайка", 10, Height.SHORT, Gender.MALE,Place.NOWHERE){
            @Override
            public void sleep() {
                System.out.println("Незнайка не будет засыпать");
            }
        };
        GlavnuyGeroy.Harakter harakterDontKnower = DontKnower.new Harakter();
        GlavnuyGeroy Donut = new GlavnuyGeroy("Пончик", 11, Height.SHORT, Gender.MALE,Place.NOWHERE){
            @Override
            public void sleep() {
                System.out.println("Пончик не будет засыпать");
            }

            @Override
            public void tell(String phrase) {
                System.out.print("В мыслях у Пончика:\n");
            }
        };
        Listening slushat = new Listening() {
            @Override
            public void listen(Human obj) {
                DontKnower.setZnania("a lot");
                obj.setZnania("a lot");
                System.out.println(DontKnower.getName() + " вместе с " + obj.getName() + " наблюдал и слушал");

            }
        };
        Human Shorts = new Human("Коротышки", Height.SHORT, gorod);
        Human Seledka = new Human("Селедочка",9, Height.SHORT, Gender.FEMALE, gorod);
        Human Fuxa = new Human("Фуксия",44, Height.SHORT, Gender.FEMALE, gorod);
        DontKnower.setCondition(Condition.SAD);
        harakterDontKnower.setHarakter(" непонятный");
        Place.setTime();
        DontKnower.setCondition(Condition.FUN);
        harakterDontKnower.setHarakter(" игртвый");
        slushat.listen(Shorts);
        class Treiners{
            String name = "Путешественники";
            public void trena(){
                System.out.println("как " + name + " тренируются");
            }
        };

        DontKnower.move(Place.Home);
        Donut.move(Place.Home);
        DontKnower.doingSmf("встретил", Donut.getName());
        DontKnower.tell(TimeOfDay.EVENING.getName() + "ом");
        while (Place.time != TimeOfDay.NIGHT){
            Place.setTime();
        }
        DontKnower.sleep();
        Donut.sleep();
        Shorts.sleep();
        Seledka.sleep();
        if (Shorts.isSon() && Seledka.isSon() && Fuxa.isSon()){
            isAllSon = true;
        }
        try {
            DontKnower.shalost(isAllSon, KosmGrad);
            Donut.shalost(isAllSon, KosmGrad);
        } catch (NotAllSleepException e) {
            System.err.println(e.getMessage());
            System.err.println("Для совершения шалости все должны уснуть!!");
        }
        if (DontKnower.getPlace() == KosmGrad) {
            Donut.setCondition(Condition.FAIR);
            Subject moroz = new Subject("Мороз");
            Subject soul = new Subject("душа");
            Subject night = new Subject("ночь");
            night.setProperty("темная");
            Donut.showCondition(night.getName() + " " + night.getProperty());
            moroz.doingSmf("подирал", "по коже");
            Place pyatka = new Place("пятки");
            soul.move(pyatka);
            Donut.tell("");
            Donut.setCondition(Condition.SHAME);
            Donut.showCondition("струсил");
            System.out.println("************** The end... **************");
        }
        //конец истории начало тестов
        System.out.println("------------------ tests ------------------");
        Human clonDonut = new Human("Пончик", Height.SHORT);
        clonDonut.setCondition(Condition.SHAME);
        System.out.println(DontKnower.toString());
        System.out.println("Donut == CloneDonut? :" + Donut.equals(clonDonut) );
        System.out.println(Donut.hashCode());
        System.out.println(clonDonut.hashCode());
        Place.NOWHERE.setName("v");
        GlavnuyGeroy GG = new GlavnuyGeroy("GG", 1, Height.SRED, Gender.HELIKOPTER, Place.Home);

    }
}