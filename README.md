# Шаблон для практической работы по теме Spring Core

### Задание
1. Добавьте в `pom.xml` зависимость `'org.springframework:spring-context:5.2.1.RELEASE`

1. Реализуйте `ArrayListItemRepository` и `LinkedListItemRepository`:
    * В `ArrayListItemRepository` итемы должны храниться в `ArrayList` и `initialSequence` считываться из пропертей
    * В `ArrayListItemRepository` итемы должны храниться в `LinkedList` и `initialSequence` генерироваться случайно
    
1. Сделайте так, чтобы используемая реализация `ItemRepository` выбиралась 
исходя из проперти `item.repository.implementation` из значений `array` или `linked`. При отсутствии проперти использовать
`ArrayListItemRepository`.

1. В классе `InitializerConfiguration` реализуйте заполнение используемой `ItemRepository` тестовыми данными.

1. В классе `InitializerConfiguration` реализуйте factory-bean `ColorFactory`, который умеет выдавать следующие цвета в 
виде списка строк:
    * Yellow
    * Red
    * Black 
Данные значения цветов должны быть объявлены в проперти файле под значением `colors.value[0]`

1. В классе `MainConfiguration` сделайте импорт всех конфигурационных файлов и объявите бин `ItemService` как `Lazy`.

1. Допишите аннотацию `InjectRandomInt`, добавьте 2 поля `min` и `max` - минимальное и максимальное значение, из которого
будет случайно выбрано число для инжектирования в целевое поле. Сделайте так, чтобы её можно было ставить только над полями. 
Предусмотрите возможность считать её во время выполенния программы.

1. Допишите класс `InjectRandomIntBeanPostProcessor`. Этот класс должен имплементировать интерфейс `BeanPostProcessor`.
Его главная задача - обрабатывать поля с аннотацией `InjectRandomInt`.

1. В классе `SpringCoreTemplate` в методе `main` создайте экземпляр `ApplicationContext` и передайте ему на вход
`MainConfiguration`. Напишите немного бизнес-логики, чтобы убедиться, что все бины создались и корректно работают 