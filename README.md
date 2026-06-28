# lab-4-itmo-java

Лабораторная работа по ООП (ИТМО) на тему **вложенных, внутренних, локальных и анонимных классов, а также пользовательских исключений**. Продолжение сюжета [lab-3-itmo-java](https://github.com/netoger/lab-3-itmo-java) — история про Незнайку.

## Структура классов

```
src/
├── Main.java
├── classes/
│   ├── Entity.java                  # abstract: name + property
│   ├── Life.java                    # abstract, implements Moving
│   ├── Human.java                   # extends Life, implements DoingSmf, ShowingCondition
│   ├── GlavnuyGeroy.java            # extends Human + внутренний класс Harakter, метод shalost()
│   ├── Place.java                   # extends Entity + статический nested класс TelephoneBook
│   ├── Subject.java                 # extends Entity, implements Moving/DoingSmf/ShowingCondition
│   ├── IncorrectAgeException.java   # unchecked (extends RuntimeException)
│   └── NotAllSleepException.java    # checked (extends Exception)
├── interfaces/
│   ├── Moving.java, DoingSmf.java, ShowingCondition.java
│   ├── GGactions.java                # маркерный интерфейс для GlavnuyGeroy
│   └── Listening.java                # listen(Human obj)
└── enums/
    ├── Condition.java, Height.java, TimeOfDay.java
    └── Gender.java                   # MALE, FEMALE, NOPE, HELIKOPTER, MIDLE
```

## Что добавлено по сравнению с lab-3

### Вложенные и внутренние классы
- **`GlavnuyGeroy.Harakter`** — нестатический внутренний класс главного героя. Хранит характер (`harakter`) и настроение (`nastroy`), и при изменении характера (`setHarakter`) пересчитывает настроение на основе текущего `Condition` владельца, а от настроения зависит, появился ли у героя аппетит (`appetit`). Демонстрирует доступ внутреннего класса к полям внешнего (`name`, `getCondition()`).
- **`Place.TelephoneBook`** — статический nested-класс: ведёт текстовую «телефонную книгу» (`zapis(Human)` добавляет запись `имя + hashCode`, `readBook()` печатает её).

### Локальные и анонимные классы (в `Main.java`)
- Локальный класс `Treiners`, объявленный прямо внутри `main()`.
- Анонимная реализация интерфейса `Listening` (переопределяет `listen`, попутно проставляя `znania` обоим участникам).
- Анонимные подклассы `GlavnuyGeroy` с переопределёнием `sleep()`/`tell()` (как и в lab-3, но теперь для `GlavnuyGeroy`).

### Исключения
- **`IncorrectAgeException`** (unchecked) — бросается прямо в конструкторе `Human(String, int age, ...)`, если `age <= 0`.
- **`NotAllSleepException`** (checked) — объявлена в сигнатуре `GlavnuyGeroy.shalost(boolean sleeping, Place place)`: если не все уснули, бросает исключение вместо перемещения персонажа; в `Main` обрабатывается через `try/catch`.

### Прочее
- У `Human` появилось поле `age` (с валидацией через `IncorrectAgeException`), `gender: Gender`, `znania` («уровень знаний») и методы `setInteres`/`outInteres`.
- В `Main.java` разыгрывается продолжение истории: персонажи слушают лекции (`Listening`), ложатся спать, и если все уснули — отправляются шалить в Космический городок (`shalost`), иначе ловят `NotAllSleepException`.

## Сборка и запуск

IntelliJ IDEA модуль. Запуск:

```
cd src
javac -d ../out classes/*.java enums/*.java interfaces/*.java Main.java
java -cp ../out Main
```

Либо открыть проект в IDE и запустить `Main.main` (объявлен как `throws NotAllSleepException`).
