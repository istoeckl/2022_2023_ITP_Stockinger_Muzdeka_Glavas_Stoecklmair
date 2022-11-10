<h2>Herzlich Willkommen zu unserer Snake Webseite! </h2>
<p>Hier finden sie einige Infos über unser Projekt: </p>

[Infos übers Team](teamInfo.md)

[Probleme](Probleme.md)

[Projektaufbau und Umsetzung](Projektaufbau und Umsetzung.md)

[Aufgaben](Aufgaben.md)


{% for element in site.data.students %}
- {{element.firstname}} {{element.lastname}}, {{element.class}}
{% endfor %}

