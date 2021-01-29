# JWD_Task04
Необходимо создать клиент-серверное приложение с использованием сокетов, разбирающее текст из учебника по программированию из файла и позволяющее выполнять с текстом две различные операции (варианты приведены в списке индивидуальных заданий ниже). Все операции с текстом должны проводиться на стороне сервера, взаимодействие с пользователем и отображение информации выполняет клиент.
Требования
➢ Разобранный текст должен быть представлен в виде объекта (текста), содержащего, например, предложения и блоки кода, предложение может содержать слова предложения. Слова предложения (части предложения), могут быть, например, простыми словами и знаками препинания. Данные классы являются классами сущностей и не должны быть перегружены методами логики.
➢ Разобранный текст необходимо восстановить в первоначальном виде, за исключением пробелов между элементами. Пробелы и знаки табуляции при разборе могут заменяться одним пробелом.
➢ Для деления текста на предложения и другие составляющие следует использовать регулярные выражения.
➢ Код, выполняющий разбитие текста на составляющие части, следует оформить в виде классов-парсеров. При разработке парсеров, разбирающих текст, необходимо следить за количеством создаваемых объектов-парсеров.
➢ При реализации задания можно использовать шаблоны Composite и Chain of Responsibility.
➢ Передача информации между клиентом и сервером должна осуществляться через механизм сериализации.
➢ При обработке исключительных ситуаций приложение необходимо использовать логгер Log4j.
➢ Созданное приложение должно позволять реализовывать группу задач по работе над текстом (задачи приведены ниже) без “переписывания” существующего кода.
1
Найти наибольшее количество предложений текста, в которых есть одинаковые слова.
2
Вывести все предложения заданного текста в порядке возрастания количества слов в каждом из них.
3
Найти такое слово в первом предложении, которого нет ни в одном из остальных предложений.
4
Во всех вопросительных предложениях текста найти и напечатать без повторений слова заданной длины.
5
В каждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения.
6
Напечатать слова текста в алфавитном порядке по первой букве. Слова, начинающиеся с новой буквы, печатать с красной строки.
7
Рассортировать слова текста по возрастанию доли гласных букв (отношение количества гласных к общему количеству букв в слове).
8
Слова текста, начинающиеся с гласных букв, рассортировать в алфавитном порядке по первой согласной букве слова.
9
Все слова текста рассортировать по возрастанию количества заданной буквы в слове. Слова с одинаковым количеством букв расположить в алфавитном порядке.
10
Существует текст и список слов. Для каждого слова из заданного списка найти, сколько раз оно встречается в каждом предложении, и рассортировать слова по убыванию общего количества вхождений.
11
В каждом предложении текста исключить подстроку максимальной длины, начинающуюся и заканчивающуюся заданными символами.
12
Из текста удалить все слова заданной длины, начинающиеся на согласную букву.
13
Отсортировать слова в тексте по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.
14
В заданном тексте найти подстроку максимальной длины, являющуюся палиндромом, т.е. читающуюся слева направо и справа налево одинаково.
15
Преобразовать каждое слово в тексте, удалив из него все последующие (предыдущие) вхождения первой (последней) буквы этого слова.
16
В некотором предложении текста слова заданной длины заменить указанной подстрокой, длина которой может не совпадать с длиной слова.
