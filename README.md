# Шаблон для практической работы по теме Spring Core

### Задание
Вы создаете Спринг-приложение для управления кинотеатром, которое предостовляет следующий функционал:
+ Для пользователей:
    + регистрироваться
    + просматривать киносеансы
    + смотреть наличие билетов
    + покупать билеты

+ Для администраторов:
    + то же самое, что и для пользователей
    + создавать киносеансы
    + просматривать купленные билеты
    
Вам необходимо:
1. Реализовать Java/Annotation-based config
    + Пример Java Config:
    ```java
    @Configuration
    public class MyConfiguration {
       
       @Bean
       public MyService myService(MyRepository myRepository) {
           MyService myService = new MyServiceImpl();
           myService.setMyRepostiory(myRepository);
           //...
           return myService;
       }
    }
    ```
    + Пример Annotation-based config
    ```java
    @Service
    public class MyServiceImpl implements MyService {
       
       @Autowired
       MyRepository myRepository;
    }
    ```
1. Использовать имеющиеся классы и создавать новые для реализации функционала
1. Разбить сущности на слои: храните ваши данные в объектах типа Map<Id, Entity>, которые будут находиться в DAO-классах
1. Создать консольное приложение. В мейне получить бины по типу и вызвать несколько бизнес-методов. Пример:
```java
@SpringBootApplication
public class SpringCoreTemplate {
    public static void main(String[] args){
        ApplicationContext context = SpringApplication.run(SpringCoreTemplate.class);
        
        MyService myService = context.getBean(MyService.class);
        myService.getAllEntitys();
    }
}
```
Что происходит в данном куске кода: 
1. Получаем контейнер с бинами, которые существуют в нашем приложении.
1. Получаем бин типа `MyService` из контейнера. Полученный бин **обязан** быть синглтоном.
1. Вызываем у `MyService` метод `getAllEntitys`. Внутри себя данный сервис не должен хранить данные `Entity`, для этого
в нем есть приватное поле типа `MyRepository`. `Dependency Injection` обеспечивает предоставление бина данного типа в наш 
+ `MyService`. В результате схема получается следующая:  
+ `MyService - валидация параметров`
+ `MyService - вызов репозитория`
+ `MyRepository - вызов действия с объектом хранения (Коллекция) экземпяров ентити`
+ `MyRepository - возврат результата в сервис`
+ `MyService - обработка ентити, выполнение бизнес-логики`
+ `MyService - возврат результата`

Репозитории должны реализовывать:
1. EventRepository - управляет киносеансами. Методы
    + save
    + remove 
    + getById 
    + getByName 
    + getAll
    + getForDateRange
    + getNextEvents
1. UserRepository - управляет юзерами. Методы
    + save
    + remove 
    + getById 
    + getUserByEmail 
    + getAll
1. BookingRepository - управляет билетами, ценами и заказами
    + getTicketsPrice
    + bookTicket
    + getPurchasedTicketsForEvent
        
> **Это важно!** Для каждого репозитория необходимо создать слой сервисов, который будет инкапсулировать валидацию входных
>параметров и совершать нужную нам бизнес-логику.

1. AuditoriumService - управляет залами и местами в них. Так как информация о кинозалах статическая, храните её в 
проперти-файлах и загружайте в приложение. Поля:
    + getAll
    + getByName
1. DiscountService - ответственнен за скидки, которые распространяются на билеты
    1. DiscountStrategy - отдельный класс, который задает скидку. Реализуйте DiscountService и его стратегии в отдельной 
    конфигурации. Существуют:
        + Скидка в честь для рождения юзера (5%)
        + Скидка "Каждый 10-й билет за полцены"
        
Существуют следующие сущности:
1. Event - киносеанс. Поля:
    + Название фильма
    + Цена билета
    + Рейтинг
    + Дата начала сеанса
    + Продолжительность
1. Auditorium - зал. Поля:
    + Кодовое название
    + Число мест
    + Число вип мест (увеличенная цена в 2 раза)
1. User - пользователь
    + Имя
    + Фамилия
    + Почта
    + Дата рождения
    + Роль
    
>
> Если вы считаете, что в описании задачи не хватет какой-либо информации, вы вольны импровизировать. Допускается добавление
> новых методов, полей, сервисов и сущностей, если вы чувствуете, что это поможет вам в выполнении задачи
>