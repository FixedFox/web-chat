Для возможности удаленной отладки при запуске с помощью Maven
нужно в папке проекта создать каталог .mvn и добавить в него файл
конфигурации jvm.config (<проект>/.mvn/jvm.config) со следующим значением:

-Xdebug -Xrunjdwp:transport=dt_socket,address=8080,server=y,suspend=y

Перечень пользователей в базе:
<table>
<tr>
<th>Логин</th>
<th>Пароль</th>
<th>Ник</th>
<th>Роль</th>
</tr>
<tr>
<td>"admin"</td> 
<td>"123"</td>
<td>"ADMINU$"</td>
<td>ADMIN</td>
</tr>
<tr>
<td>"dog"</td>
<td>"2"</td>
<td>"D()GGY"</td>
<td>CLIENT</td>
</tr>
<tr>
<td>"fox"</td>
<td>"1"</td>
<td>"F0XXX"</td>
<td>CLIENT</td>
</tr>
<tr>
<td>"cat"</td>
<td>"3"</td>
<td>"cAtTy"</td>
<td>CLIENT</td>
</tr>
<tr>
<td>"fish"</td>
<td>"4"</td>
<td>"OCEANFISH"</td>
<td>CLIENT</td>
</tr>
</table>
