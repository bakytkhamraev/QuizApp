# QuizApp
hw 1-5 QApp
Учебный проект: https://github.com/mamediv172/QuizApp21.git (прочитать README файл)
Дизайн: https://www.figma.com/file/DKTdH7KGqrEhxjX8zXRTlHTL/QuizApp

- Дедлайн на каждое ДЗ до следующего занятия, по истечению срока ДЗ автоматически считается невыполненным. 
- Проверка ДЗ и комменты до вечера следующего дня с момента сдачи.
- ДЗ выполнено только после того как выполнены все комменты по заданию.

Урок 1. MVVM. Livedata. ViewModel:

- Добавить BottomNav (иконки взять из фигмы), связать с основным ViewPager-ом
- Добавить разметку в fragment_main (дизайн в фигме)
- Изменить иконку приложения
- Заблокировать скрол view pagera по свайпу
- прописать клики на нажатия элементов Bottom navigation

Дополнительное задание : 
- Почитать про принципы SOLID 
- Почитать про LiveData
- В MainFragment при скроле seekBar отображать позицию seekBara (смотрите дизайн в фигме)
- Добавьте в MainFragment кнопку плюс(+) , textView (0) и кнопку минус (-).  При нажатия на кнопку плюс  значения TextView должно увеличиться на 1, при нажатия на минус значения TextView должно уменьшиться на 1, метод вывести во ViewModel и отображать с помощью LiveData


Урок 1. https://www.youtube.com/watch?v=DSzj3gZ1gFU


Урок 2. MVVM, SOLID, DataBinding

- Сверстать страницу Question
- Добавить Recycler Adapter
- Создать ViewHolder
- Создать 10 статичных вопросов с разными типами
- разделить во ViewHoldere отображения вариантов ответа по типу
- сделать скрол Recycler view как во ViewPager(т.е. при нажатия на ответ должно скролиться на следующий вопрос должно листаться как ViewPager а не как RecyclerView)
- Добавить Data Binding в ViewHolder и в Recycler Adapter

стрим : https://www.youtube.com/watch?v=38SKZeh-dq4


Урок 3. Retrofit, Api, DataBinding

- Получить список категорий
- Отобразить категории в Spiner
- Отобразить уровень сложности в спинер
- при переходе в QuestionsActivity передавать id выбранной категории и уровень сложности
- сверстать страницу истории

стрим : https://www.youtube.com/watch?v=M2_aCPjLJmo

документация api : https://opentdb.com/api_config.php

Урок 4. CallBack, Retrofit, Repository
- сверстать страницу настройки и истории
- добавить ResultActivity
- после того как ответят на все вопросы передавать результат в ResultActivity и отобразить результат(см. Figma)
- при нажатия назад в QuestionActivity переходить на предыдущий вопрос
- при нажатии на какой либо вариант ответа блокировать нажатия на все кнопки(что при переходе назад не было возможности изменить ответ)

дедлайн как всегда до следующего урока


стрим : https://www.youtube.com/watch?v=0GcO9BNk_AQ&feature=youtu.be


Урок 5. Project, Repository

- Сделать запрос на бек через Repository
- При нажатия на Skip засчитать ответ как не правильный и  сделать кнопки не кликабельными
- вывести все методы QuestionActivity во ViewModel
- Сверстать страницу настройки и история
- Прочитать про DataBinding Adapter


стрим : https://www.youtube.com/watch?v=st6mfqE95UE


Урок 6 Room

-Сохранять результат в базу данных
- Отобразить Список истории в HistoryFragment
- Очищать список историй с настроек
