Степи

1. На пейджі де є ці компоненти має бути локатор для контейнера цього елементу. Локатор має бути не
   унікальний (тобто ви не привязуєтеся до цогось конкретного в продукті).

`private final By productContainerLocator = By.xpath("//li[@class='product-item']");`

2. Створюєте клас а пакеті components і називаєте наприклад Products. В цьому класі мають бути усі
   поля, які описуються даний продукт (назва, ціна, картинка, кнопка і т.д)

```private WebElement image;
   private WebElement nameWe;
   private String name;
   private String rating;
   private String price;
   private String reviews;
```

3. Зробити конструктор, який на вхід буде приймати контейнер, і в цьому контейнері будуть сетатися
   усі поля які ми створили вище. Тобто ми сетаємо поля уже безпосередньо в контейнері. Для цього
   юзається синтаксис:

```
  this.image = container.findElement(By.xpath(".//img[@class='product-image-photo']"));
  this.nameWe = container.findElement(By.xpath(".//a[@class='product-item-link']"));
```

4. Може бути кейс, коли деяких атрибутів (полів) в якомусь із продуктів не має. Тоді ми при
   розпаршувані будемо потрапляти на NoSuchElementException. Для того, щоб це захендлити ми юзаємо
   try/catch в якому, в try шукаєм елемент, якщо не знаходимо - сетаємо null

```
   try {
      this.rating = container.findElement(By.xpath(".//div[@class='rating-result']"))
          .getAttribute("title");
    } catch (NoSuchElementException e) {
      this.rating = null;
    }
```

5. На пейджі з локатором з контейнером ви створюєте метод, в якому буде:

5.1 Створюєте пустий ліст, в який будете складати продукти
`List<ProductComponent> products = new ArrayList<>();`

5.2 Шукаєте контейнери як лісту вебелементів по локатору, який є вище на цій пейджі
`  List<WebElement> containers = findAll(productContainerLocator);`

5.3 Йдете в циклі по цих вебелементах

5.4 В середині цикла створюєте обєкт продукта, в конструктор якого передаєте ось це й контейнер 

`ProductComponent productComponent = new ProductComponent(container);`


5.5 Добавляєте готовий продукт в лісту, яку створили вище
` products.add(productComponent);` 

5.6 Повертаєте ліску з методу. 
5.7 Метод викликаєте в тесті і працюєте з обєктами а не вебелементами