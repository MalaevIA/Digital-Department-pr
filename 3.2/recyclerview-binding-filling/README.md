[![Android Studio version](https://img.shields.io/endpoint?url=https%3A%2F%2Fsicampus.ru%2Fgitea%2Fcore%2Fdocs%2Fraw%2Fbranch%2Fmain%2Fandroid-studio-label.json)](https://sicampus.ru/gitea/core/docs/src/branch/main/how-upload-project.md)

# Практическая работа. Курс Kotlin. Практическая 3.2
Данное задание является продолжением практического задания 3.1.

Заполните недостающие части кода в классе *BookAdapter* и *MainActivity* для корректного отображения списка книг в RecyclerView. В качестве примера используется список русских книг с их названиями и авторами. Также, нечетные элементы *RecyclerView*  выравниваются по правой стороне.

В элементе *RecyclerView* обязаны присутствовать книги, представленные ниже.

| Книга                     | Автор                |
| ------------------------- | -------------------- |
| Война и мир               | Лев Толстой          |
| Преступление и наказание  | Фёдор Достоевский    |
| Мастер и Маргарита        | Михаил Булгаков      |
| Анна Каренина             | Лев Толстой          |
| Евгений Онегин            | Александр Пушкин     |

Ниже представлены фрагменты кода, которые надо дополнить

### *MainActivity.kt*:
```kotlin
...
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_main)

    //TODO: Создать и заполнить RecyclerView
}
```

### *BookAdapter.kt*:
```kotlin
//TODO: Реализовать класс BookViewHolder, используя binding
...
override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
    //TODO: Заполнить элемент списка данными дата класса. Нечетные блоки информации должны быть прижаты вправо (использование параметра gravity)
}

```