<h2>Herzlich Willkommen zu unserer Snake Webseite! </h2>
<p>Hier finden sie einige Infos über unser Projekt: </p>

[Infos übers Team](teamInfo.md)

[Probleme](Probleme.md)

[JoviTest](jovi_test.md)

[Annikatest](annika_test.md)


{% for element in site.data.students %}
- {{element.firstname}}, {{element.lastname}}, {{element.class}}
{% endfor %}

