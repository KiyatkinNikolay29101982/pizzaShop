
import com.example.pizzashop.model.*;
import com.example.pizzashop.repository.*;
import com.example.pizzashop.service.AdditionService;
import com.example.pizzashop.service.AdditionServiceImpl;
import com.example.pizzashop.service.CartService;
import com.example.pizzashop.service.CartServiceImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate\\hibernate.cfg.xml");
        configuration.getProperty("connection.url");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        EntityManager entityManager = sessionFactory.createEntityManager();
        AdditionRepository repository = new AdditionRepositoryImpl(entityManager);
        CartRepository cartRepository = new CartRepositoryImpl(entityManager);
        PizzaRepository pizzaRepository = new PizzaRepositoryImpl(entityManager);
        PersonRepository personRepository = new PersonRepositoryImpl(entityManager);
        ItemRepository itemRepository = new ItemRepositoryImpl(entityManager);
        AdditionRepository additionRepository = new AdditionRepositoryImpl(entityManager);
        AdditionService additionService = new AdditionServiceImpl(additionRepository);
        InngradientRepository inngradientRepository = new IngradientRepositoryImpl(entityManager);

//        CustomPizza pizza = (CustomPizza) CustomPizza.builder()
//                .name("new pizza")
//                .coast(0)
//                .build();
//
//        Ingradient pizzaCheese = Ingradient.builder()
//                .name("Cheese")
//                .coast(89)
//                .build();
//        Ingradient pizzaTomato = Ingradient.builder()
//                .name("Tomato")
//                .coast(89)
//                .build();
//        Ingradient pizzaMeat = Ingradient.builder()
//                .name("Meat")
//                .coast(140)
//                .build();
//
//        inngradientRepository.save(pizzaCheese);
//        inngradientRepository.save(pizzaTomato);
//        inngradientRepository.save(pizzaMeat);



//        System.out.println(additionService.getAdditionByName("olive"));
//        System.out.println(additionService.getAdditionByName("capers"));
//        System.out.println(additionService.getAdditionByName("capers"));
//        System.out.println(additionService.getAdditionByName("anchouse"));

//        Pizza margarita = Pizza.builder()
//                .name("Margarita")
//                .coast(700)
//                .build();
//        pizzaRepository.save(margarita);
//
//        Pizza fourCheese = Pizza.builder()
//                .name("fourCheese")
//                .coast(800)
//                .build();
//        pizzaRepository.save(fourCheese);
//
//        Pizza havai = Pizza.builder()
//                .name("Havai")
//                .coast(1000)
//                .build();
//        pizzaRepository.save(havai);
//        Pizza provance2 = Pizza.builder()
//                .name("Provance")
//                .coast(900)
//                .build();
//        pizzaRepository.save(provance2);
//
//        Addition olive = Addition.builder()
//                .name("olive")
//                .coast(70)
//                .build();
//        additionRepository.save(olive);
//        Addition caperse= Addition.builder()
//                .name("caperse")
//                .coast(70)
//                .build();
//        additionRepository.save(caperse);
//        Addition cheese = Addition.builder()
//                .name("cheese")
//                .coast(70)
//                .build();
//        additionRepository.save(cheese );
//        Addition anchouse = Addition.builder()
//                .name("anchouse")
//                .coast(70)
//                .build();
//        additionRepository.save(anchouse);

//    Item item1 = Item.builder()
//            .pizza(pizzaRepository.findById(1L).get())
//            .additionList(additionRepository.findAll())
//            .build();
//    itemRepository.save(item1);
//        Item item2 = Item.builder()
//                .pizza(pizzaRepository.findById(1L).get())
//                .additionList(additionRepository.findAll())
//                .build();
//        itemRepository.save(item2);
//    List<Item> items = new ArrayList<>();
//    items.add(item1);
//    items.add(item2);
//
//    Cart cart = Cart.builder()
//            .person(personRepository.findById(1L).get())
//            .itemList(items)
//            .city("Samara")
//            .street("Penz")
//            .building("66")
//            .build();
//    cartRepository.save(cart);

//System.out.println(additionRepository.findAll());

    }
}
